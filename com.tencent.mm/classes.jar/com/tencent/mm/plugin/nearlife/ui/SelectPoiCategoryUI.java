package com.tencent.mm.plugin.nearlife.ui;

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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.sb;
import com.tencent.mm.autogen.a.sb.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelpackage.p;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SelectPoiCategoryUI
  extends MMActivity
{
  static final String MrA;
  private EventListener MrB;
  private ArrayAdapter<String> MrC;
  private List<String> MrD;
  private AdapterView.OnItemClickListener MrE;
  private MenuItem.OnMenuItemClickListener Mrv;
  private ListView mListView;
  
  static
  {
    AppMethodBeat.i(26638);
    MrA = at.acHq + "poi_categories";
    AppMethodBeat.o(26638);
  }
  
  public SelectPoiCategoryUI()
  {
    AppMethodBeat.i(26630);
    this.MrE = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(26626);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        a.c("com/tencent/mm/plugin/nearlife/ui/SelectPoiCategoryUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        Log.d("MicroMsg.SelectPoiCategoryUI", "item click on pos:%d, len:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(SelectPoiCategoryUI.a(SelectPoiCategoryUI.this).size()) });
        paramAnonymousAdapterView = new Intent();
        paramAnonymousAdapterView.putExtra("poi_category", (String)SelectPoiCategoryUI.a(SelectPoiCategoryUI.this).get(paramAnonymousInt));
        SelectPoiCategoryUI.this.setResult(-1, paramAnonymousAdapterView);
        SelectPoiCategoryUI.this.finish();
        a.a(this, "com/tencent/mm/plugin/nearlife/ui/SelectPoiCategoryUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(26626);
      }
    };
    this.Mrv = new MenuItem.OnMenuItemClickListener()
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
  private boolean U(java.io.InputStream paramInputStream)
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
    //   19: getfield 78	com/tencent/mm/plugin/nearlife/ui/SelectPoiCategoryUI:MrD	Ljava/util/List;
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
    //   61: getfield 78	com/tencent/mm/plugin/nearlife/ui/SelectPoiCategoryUI:MrD	Ljava/util/List;
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
    //   101: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   157: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   185: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   236: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  private boolean aPR(String paramString)
  {
    AppMethodBeat.i(26634);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(26634);
      return false;
    }
    u localu = new u(paramString);
    if (!localu.jKS())
    {
      AppMethodBeat.o(26634);
      return false;
    }
    try
    {
      boolean bool = U(y.ao(localu));
      AppMethodBeat.o(26634);
      return bool;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Log.d("MicroMsg.SelectPoiCategoryUI", "update poi categories failed, path:%s, msg:%s", new Object[] { paramString, localFileNotFoundException.getMessage() });
      AppMethodBeat.o(26634);
    }
    return false;
  }
  
  final void cm(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26636);
    paramArrayOfByte = new String(paramArrayOfByte).split("\n");
    this.MrD.clear();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      this.MrD.add(paramArrayOfByte[i].trim());
      i += 1;
    }
    AppMethodBeat.o(26636);
  }
  
  public int getLayoutId()
  {
    return R.i.gnP;
  }
  
  final void gtc()
  {
    AppMethodBeat.i(26637);
    this.MrC.clear();
    int i = 0;
    while (i < this.MrD.size())
    {
      this.MrC.add((String)this.MrD.get(i));
      i += 1;
    }
    this.MrC.notifyDataSetChanged();
    AppMethodBeat.o(26637);
  }
  
  public void initView()
  {
    AppMethodBeat.i(26632);
    setMMTitle(R.l.gOR);
    setBackBtn(this.Mrv);
    this.MrC = new ArrayAdapter(this, R.i.gmU);
    this.mListView = ((ListView)findViewById(R.h.fvB));
    this.mListView.setAdapter(this.MrC);
    this.mListView.setOnItemClickListener(this.MrE);
    AssetManager localAssetManager;
    if (!aPR(MrA + "/lastest_poi_categories.dat")) {
      localAssetManager = getAssets();
    }
    try
    {
      U(localAssetManager.open("default_poi_categories.dat"));
      gtc();
      AppMethodBeat.o(26632);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.d("MicroMsg.SelectPoiCategoryUI", "open file from assets failed: " + localIOException.getMessage());
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26631);
    super.onCreate(paramBundle);
    this.MrD = new ArrayList();
    initView();
    this.MrB = new EventListener();
    this.MrB.alive();
    this.MrB.MrG = this;
    paramBundle = new p(17);
    bh.aZW().a(paramBundle, 0);
    AppMethodBeat.o(26631);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26635);
    super.onDestroy();
    this.MrB.dead();
    AppMethodBeat.o(26635);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  class EventListener
    extends IListener<sb>
  {
    SelectPoiCategoryUI MrG;
    
    public EventListener()
    {
      super(0);
      AppMethodBeat.i(161394);
      this.__eventId = sb.class.getName().hashCode();
      AppMethodBeat.o(161394);
    }
    
    private boolean a(sb paramsb)
    {
      AppMethodBeat.i(26628);
      SelectPoiCategoryUI localSelectPoiCategoryUI;
      Object localObject;
      if ((paramsb instanceof sb))
      {
        localSelectPoiCategoryUI = this.MrG;
        paramsb = paramsb.hVc.hVd;
        localObject = new u(SelectPoiCategoryUI.MrA);
        if (!((u)localObject).jKS()) {
          ((u)localObject).jKY();
        }
      }
      try
      {
        localObject = SelectPoiCategoryUI.MrA + "/lastest_poi_categories.dat";
        u localu = new u((String)localObject);
        if (!localu.jKS()) {
          localu.jKZ();
        }
        y.f((String)localObject, paramsb, paramsb.length);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.SelectPoiCategoryUI", "write file failed: " + localException.getMessage());
        }
      }
      localSelectPoiCategoryUI.cm(paramsb);
      localSelectPoiCategoryUI.gtc();
      AppMethodBeat.o(26628);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.SelectPoiCategoryUI
 * JD-Core Version:    0.7.0.1
 */