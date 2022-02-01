package com.tencent.mm.plugin.nearlife.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.bb.l;
import com.tencent.mm.g.a.oy;
import com.tencent.mm.g.a.oy.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SelectPoiCategoryUI
  extends MMActivity
{
  static final String wHo;
  private ListView mListView;
  private MenuItem.OnMenuItemClickListener wHj;
  private a wHp;
  private ArrayAdapter<String> wHq;
  private List<String> wHr;
  private AdapterView.OnItemClickListener wHs;
  
  static
  {
    AppMethodBeat.i(26638);
    wHo = am.IKh + "poi_categories";
    AppMethodBeat.o(26638);
  }
  
  public SelectPoiCategoryUI()
  {
    AppMethodBeat.i(26630);
    this.wHs = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(26626);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearlife/ui/SelectPoiCategoryUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        ae.d("MicroMsg.SelectPoiCategoryUI", "item click on pos:%d, len:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(SelectPoiCategoryUI.a(SelectPoiCategoryUI.this).size()) });
        paramAnonymousAdapterView = new Intent();
        paramAnonymousAdapterView.putExtra("poi_category", (String)SelectPoiCategoryUI.a(SelectPoiCategoryUI.this).get(paramAnonymousInt));
        SelectPoiCategoryUI.this.setResult(-1, paramAnonymousAdapterView);
        SelectPoiCategoryUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearlife/ui/SelectPoiCategoryUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(26626);
      }
    };
    this.wHj = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26627);
        SelectPoiCategoryUI.this.setResult(0, null);
        SelectPoiCategoryUI.this.finish();
        AppMethodBeat.o(26627);
        return true;
      }
    };
    AppMethodBeat.o(26630);
  }
  
  /* Error */
  private boolean K(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: sipush 26633
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +11 -> 18
    //   10: sipush 26633
    //   13: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_0
    //   19: getfield 78	com/tencent/mm/plugin/nearlife/ui/SelectPoiCategoryUI:wHr	Ljava/util/List;
    //   22: invokeinterface 83 1 0
    //   27: new 85	java/io/BufferedReader
    //   30: dup
    //   31: new 87	java/io/InputStreamReader
    //   34: dup
    //   35: aload_1
    //   36: ldc 89
    //   38: invokespecial 92	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   41: invokespecial 95	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   44: astore_3
    //   45: aload_3
    //   46: astore_2
    //   47: aload_3
    //   48: invokevirtual 98	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore 4
    //   53: aload 4
    //   55: ifnull +69 -> 124
    //   58: aload_3
    //   59: astore_2
    //   60: aload_0
    //   61: getfield 78	com/tencent/mm/plugin/nearlife/ui/SelectPoiCategoryUI:wHr	Ljava/util/List;
    //   64: aload 4
    //   66: invokeinterface 102 2 0
    //   71: pop
    //   72: goto -27 -> 45
    //   75: astore 4
    //   77: aload_3
    //   78: astore_2
    //   79: ldc 104
    //   81: new 37	java/lang/StringBuilder
    //   84: dup
    //   85: ldc 106
    //   87: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   90: aload 4
    //   92: invokevirtual 112	java/io/IOException:getMessage	()Ljava/lang/String;
    //   95: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 118	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload_3
    //   105: ifnull +7 -> 112
    //   108: aload_3
    //   109: invokevirtual 121	java/io/BufferedReader:close	()V
    //   112: aload_1
    //   113: invokevirtual 124	java/io/InputStream:close	()V
    //   116: sipush 26633
    //   119: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: iconst_1
    //   123: ireturn
    //   124: aload_3
    //   125: invokevirtual 121	java/io/BufferedReader:close	()V
    //   128: aload_1
    //   129: invokevirtual 124	java/io/InputStream:close	()V
    //   132: goto -16 -> 116
    //   135: astore_1
    //   136: ldc 104
    //   138: new 37	java/lang/StringBuilder
    //   141: dup
    //   142: ldc 126
    //   144: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   147: aload_1
    //   148: invokevirtual 127	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   151: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 118	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: goto -44 -> 116
    //   163: astore_1
    //   164: ldc 104
    //   166: new 37	java/lang/StringBuilder
    //   169: dup
    //   170: ldc 126
    //   172: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   175: aload_1
    //   176: invokevirtual 127	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   179: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 118	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: goto -72 -> 116
    //   191: astore_3
    //   192: aconst_null
    //   193: astore_2
    //   194: aload_2
    //   195: ifnull +7 -> 202
    //   198: aload_2
    //   199: invokevirtual 121	java/io/BufferedReader:close	()V
    //   202: aload_1
    //   203: invokevirtual 124	java/io/InputStream:close	()V
    //   206: sipush 26633
    //   209: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: aload_3
    //   213: athrow
    //   214: astore_1
    //   215: ldc 104
    //   217: new 37	java/lang/StringBuilder
    //   220: dup
    //   221: ldc 126
    //   223: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: aload_1
    //   227: invokevirtual 127	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   230: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 118	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: goto -33 -> 206
    //   242: astore_3
    //   243: goto -49 -> 194
    //   246: astore 4
    //   248: aconst_null
    //   249: astore_3
    //   250: goto -173 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	SelectPoiCategoryUI
    //   0	253	1	paramInputStream	java.io.InputStream
    //   46	153	2	localBufferedReader1	java.io.BufferedReader
    //   44	81	3	localBufferedReader2	java.io.BufferedReader
    //   191	22	3	localObject1	Object
    //   242	1	3	localObject2	Object
    //   249	1	3	localObject3	Object
    //   51	14	4	str	String
    //   75	16	4	localIOException1	IOException
    //   246	1	4	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   47	53	75	java/io/IOException
    //   60	72	75	java/io/IOException
    //   124	132	135	java/lang/Exception
    //   108	112	163	java/lang/Exception
    //   112	116	163	java/lang/Exception
    //   27	45	191	finally
    //   198	202	214	java/lang/Exception
    //   202	206	214	java/lang/Exception
    //   47	53	242	finally
    //   60	72	242	finally
    //   79	104	242	finally
    //   27	45	246	java/io/IOException
  }
  
  private boolean aup(String paramString)
  {
    AppMethodBeat.i(26634);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26634);
      return false;
    }
    k localk = new k(paramString);
    if (!localk.exists())
    {
      AppMethodBeat.o(26634);
      return false;
    }
    try
    {
      boolean bool = K(o.ai(localk));
      AppMethodBeat.o(26634);
      return bool;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      ae.d("MicroMsg.SelectPoiCategoryUI", "update poi categories failed, path:%s, msg:%s", new Object[] { paramString, localFileNotFoundException.getMessage() });
      AppMethodBeat.o(26634);
    }
    return false;
  }
  
  final void bD(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26636);
    paramArrayOfByte = new String(paramArrayOfByte).split("\n");
    this.wHr.clear();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      this.wHr.add(paramArrayOfByte[i].trim());
      i += 1;
    }
    AppMethodBeat.o(26636);
  }
  
  final void dxz()
  {
    AppMethodBeat.i(26637);
    this.wHq.clear();
    int i = 0;
    while (i < this.wHr.size())
    {
      this.wHq.add(this.wHr.get(i));
      i += 1;
    }
    this.wHq.notifyDataSetChanged();
    AppMethodBeat.o(26637);
  }
  
  public int getLayoutId()
  {
    return 2131495354;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26632);
    setMMTitle(2131761616);
    setBackBtn(this.wHj);
    this.wHq = new ArrayAdapter(this, 2131495096);
    this.mListView = ((ListView)findViewById(2131297926));
    this.mListView.setAdapter(this.wHq);
    this.mListView.setOnItemClickListener(this.wHs);
    AssetManager localAssetManager;
    if (!aup(wHo + "/lastest_poi_categories.dat")) {
      localAssetManager = getAssets();
    }
    try
    {
      K(localAssetManager.open("default_poi_categories.dat"));
      dxz();
      AppMethodBeat.o(26632);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ae.d("MicroMsg.SelectPoiCategoryUI", "open file from assets failed: " + localIOException.getMessage());
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26631);
    super.onCreate(paramBundle);
    this.wHr = new ArrayList();
    initView();
    this.wHp = new a();
    paramBundle = this.wHp;
    com.tencent.mm.sdk.b.a.IvT.c(paramBundle);
    this.wHp.wHu = this;
    paramBundle = new l(17);
    bc.ajj().a(paramBundle, 0);
    AppMethodBeat.o(26631);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26635);
    super.onDestroy();
    a locala = this.wHp;
    com.tencent.mm.sdk.b.a.IvT.d(locala);
    AppMethodBeat.o(26635);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends c<oy>
  {
    SelectPoiCategoryUI wHu;
    
    public a()
    {
      super();
      AppMethodBeat.i(161394);
      this.__eventId = oy.class.getName().hashCode();
      AppMethodBeat.o(161394);
    }
    
    private boolean a(oy paramoy)
    {
      AppMethodBeat.i(26628);
      SelectPoiCategoryUI localSelectPoiCategoryUI;
      Object localObject;
      if ((paramoy instanceof oy))
      {
        localSelectPoiCategoryUI = this.wHu;
        paramoy = paramoy.dDS.content;
        localObject = new k(SelectPoiCategoryUI.wHo);
        if (!((k)localObject).exists()) {
          ((k)localObject).mkdirs();
        }
      }
      try
      {
        localObject = SelectPoiCategoryUI.wHo + "/lastest_poi_categories.dat";
        k localk = new k((String)localObject);
        if (!localk.exists()) {
          localk.createNewFile();
        }
        o.f((String)localObject, paramoy, paramoy.length);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.e("MicroMsg.SelectPoiCategoryUI", "write file failed: " + localException.getMessage());
        }
      }
      localSelectPoiCategoryUI.bD(paramoy);
      localSelectPoiCategoryUI.dxz();
      AppMethodBeat.o(26628);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.SelectPoiCategoryUI
 * JD-Core Version:    0.7.0.1
 */