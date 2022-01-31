package com.tencent.mm.plugin.nearlife.ui;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.ba.k;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SelectPoiCategoryUI
  extends MMActivity
{
  static final String pfP;
  private ListView mListView;
  private MenuItem.OnMenuItemClickListener pfK;
  private SelectPoiCategoryUI.a pfQ;
  private ArrayAdapter<String> pfR;
  private List<String> pfS;
  private AdapterView.OnItemClickListener pfT;
  
  static
  {
    AppMethodBeat.i(23011);
    pfP = ac.eQv + "poi_categories";
    AppMethodBeat.o(23011);
  }
  
  public SelectPoiCategoryUI()
  {
    AppMethodBeat.i(23003);
    this.pfT = new SelectPoiCategoryUI.1(this);
    this.pfK = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(22999);
        SelectPoiCategoryUI.this.setResult(0, null);
        SelectPoiCategoryUI.this.finish();
        AppMethodBeat.o(22999);
        return true;
      }
    };
    AppMethodBeat.o(23003);
  }
  
  private boolean VS(String paramString)
  {
    AppMethodBeat.i(23007);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(23007);
      return false;
    }
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      AppMethodBeat.o(23007);
      return false;
    }
    try
    {
      boolean bool = z(new FileInputStream(localFile));
      AppMethodBeat.o(23007);
      return bool;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      ab.d("MicroMsg.SelectPoiCategoryUI", "update poi categories failed, path:%s, msg:%s", new Object[] { paramString, localFileNotFoundException.getMessage() });
      AppMethodBeat.o(23007);
    }
    return false;
  }
  
  /* Error */
  private boolean z(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: sipush 23006
    //   3: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +11 -> 18
    //   10: sipush 23006
    //   13: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_0
    //   19: getfield 115	com/tencent/mm/plugin/nearlife/ui/SelectPoiCategoryUI:pfS	Ljava/util/List;
    //   22: invokeinterface 124 1 0
    //   27: new 126	java/io/BufferedReader
    //   30: dup
    //   31: new 128	java/io/InputStreamReader
    //   34: dup
    //   35: aload_1
    //   36: ldc 130
    //   38: invokespecial 133	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   41: invokespecial 136	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   44: astore_3
    //   45: aload_3
    //   46: astore_2
    //   47: aload_3
    //   48: invokevirtual 139	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore 4
    //   53: aload 4
    //   55: ifnull +69 -> 124
    //   58: aload_3
    //   59: astore_2
    //   60: aload_0
    //   61: getfield 115	com/tencent/mm/plugin/nearlife/ui/SelectPoiCategoryUI:pfS	Ljava/util/List;
    //   64: aload 4
    //   66: invokeinterface 143 2 0
    //   71: pop
    //   72: goto -27 -> 45
    //   75: astore 4
    //   77: aload_3
    //   78: astore_2
    //   79: ldc 98
    //   81: new 34	java/lang/StringBuilder
    //   84: dup
    //   85: ldc 145
    //   87: invokespecial 146	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   90: aload 4
    //   92: invokevirtual 147	java/io/IOException:getMessage	()Ljava/lang/String;
    //   95: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 150	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload_3
    //   105: ifnull +7 -> 112
    //   108: aload_3
    //   109: invokevirtual 153	java/io/BufferedReader:close	()V
    //   112: aload_1
    //   113: invokevirtual 156	java/io/InputStream:close	()V
    //   116: sipush 23006
    //   119: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: iconst_1
    //   123: ireturn
    //   124: aload_3
    //   125: invokevirtual 153	java/io/BufferedReader:close	()V
    //   128: aload_1
    //   129: invokevirtual 156	java/io/InputStream:close	()V
    //   132: goto -16 -> 116
    //   135: astore_1
    //   136: ldc 98
    //   138: new 34	java/lang/StringBuilder
    //   141: dup
    //   142: ldc 158
    //   144: invokespecial 146	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   147: aload_1
    //   148: invokevirtual 159	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   151: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 150	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: goto -44 -> 116
    //   163: astore_1
    //   164: ldc 98
    //   166: new 34	java/lang/StringBuilder
    //   169: dup
    //   170: ldc 158
    //   172: invokespecial 146	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   175: aload_1
    //   176: invokevirtual 159	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   179: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 150	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: goto -72 -> 116
    //   191: astore_3
    //   192: aconst_null
    //   193: astore_2
    //   194: aload_2
    //   195: ifnull +7 -> 202
    //   198: aload_2
    //   199: invokevirtual 153	java/io/BufferedReader:close	()V
    //   202: aload_1
    //   203: invokevirtual 156	java/io/InputStream:close	()V
    //   206: sipush 23006
    //   209: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: aload_3
    //   213: athrow
    //   214: astore_1
    //   215: ldc 98
    //   217: new 34	java/lang/StringBuilder
    //   220: dup
    //   221: ldc 158
    //   223: invokespecial 146	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: aload_1
    //   227: invokevirtual 159	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   230: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 150	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  final void bWQ()
  {
    AppMethodBeat.i(23010);
    this.pfR.clear();
    int i = 0;
    while (i < this.pfS.size())
    {
      this.pfR.add(this.pfS.get(i));
      i += 1;
    }
    this.pfR.notifyDataSetChanged();
    AppMethodBeat.o(23010);
  }
  
  final void bd(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23009);
    paramArrayOfByte = new String(paramArrayOfByte).split("\n");
    this.pfS.clear();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      this.pfS.add(paramArrayOfByte[i].trim());
      i += 1;
    }
    AppMethodBeat.o(23009);
  }
  
  public int getLayoutId()
  {
    return 2130970659;
  }
  
  public void initView()
  {
    AppMethodBeat.i(23005);
    setMMTitle(2131301856);
    setBackBtn(this.pfK);
    this.pfR = new ArrayAdapter(this, 2130970423);
    this.mListView = ((ListView)findViewById(2131827550));
    this.mListView.setAdapter(this.pfR);
    this.mListView.setOnItemClickListener(this.pfT);
    AssetManager localAssetManager;
    if (!VS(pfP + "/lastest_poi_categories.dat")) {
      localAssetManager = getAssets();
    }
    try
    {
      z(localAssetManager.open("default_poi_categories.dat"));
      bWQ();
      AppMethodBeat.o(23005);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.d("MicroMsg.SelectPoiCategoryUI", "open file from assets failed: " + localIOException.getMessage());
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23004);
    super.onCreate(paramBundle);
    this.pfS = new ArrayList();
    initView();
    this.pfQ = new SelectPoiCategoryUI.a(this);
    paramBundle = this.pfQ;
    a.ymk.c(paramBundle);
    this.pfQ.pfV = this;
    paramBundle = new k(17);
    aw.Rc().a(paramBundle, 0);
    AppMethodBeat.o(23004);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(23008);
    super.onDestroy();
    SelectPoiCategoryUI.a locala = this.pfQ;
    a.ymk.d(locala);
    AppMethodBeat.o(23008);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.SelectPoiCategoryUI
 * JD-Core Version:    0.7.0.1
 */