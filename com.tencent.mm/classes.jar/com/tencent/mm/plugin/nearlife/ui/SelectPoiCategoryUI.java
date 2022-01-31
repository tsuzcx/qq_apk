package com.tencent.mm.plugin.nearlife.ui;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.az.k;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  static final String mFJ = ac.dOP + "poi_categories";
  private ListView Nn;
  private MenuItem.OnMenuItemClickListener mFE = new SelectPoiCategoryUI.2(this);
  private SelectPoiCategoryUI.a mFK;
  private ArrayAdapter<String> mFL;
  private List<String> mFM;
  private AdapterView.OnItemClickListener mFN = new SelectPoiCategoryUI.1(this);
  
  private boolean JS(String paramString)
  {
    if (bk.bl(paramString)) {}
    File localFile;
    do
    {
      return false;
      localFile = new File(paramString);
    } while (!localFile.exists());
    try
    {
      boolean bool = z(new FileInputStream(localFile));
      return bool;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      y.d("MicroMsg.SelectPoiCategoryUI", "update poi categories failed, path:%s, msg:%s", new Object[] { paramString, localFileNotFoundException.getMessage() });
    }
    return false;
  }
  
  /* Error */
  private boolean z(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_0
    //   7: getfield 106	com/tencent/mm/plugin/nearlife/ui/SelectPoiCategoryUI:mFM	Ljava/util/List;
    //   10: invokeinterface 115 1 0
    //   15: new 117	java/io/BufferedReader
    //   18: dup
    //   19: new 119	java/io/InputStreamReader
    //   22: dup
    //   23: aload_1
    //   24: ldc 121
    //   26: invokespecial 124	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   29: invokespecial 127	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   32: astore_3
    //   33: aload_3
    //   34: astore_2
    //   35: aload_3
    //   36: invokevirtual 130	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   39: astore 4
    //   41: aload 4
    //   43: ifnull +63 -> 106
    //   46: aload_3
    //   47: astore_2
    //   48: aload_0
    //   49: getfield 106	com/tencent/mm/plugin/nearlife/ui/SelectPoiCategoryUI:mFM	Ljava/util/List;
    //   52: aload 4
    //   54: invokeinterface 134 2 0
    //   59: pop
    //   60: goto -27 -> 33
    //   63: astore 4
    //   65: aload_3
    //   66: astore_2
    //   67: ldc 89
    //   69: new 26	java/lang/StringBuilder
    //   72: dup
    //   73: ldc 136
    //   75: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: aload 4
    //   80: invokevirtual 138	java/io/IOException:getMessage	()Ljava/lang/String;
    //   83: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 141	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload_3
    //   93: ifnull +7 -> 100
    //   96: aload_3
    //   97: invokevirtual 144	java/io/BufferedReader:close	()V
    //   100: aload_1
    //   101: invokevirtual 147	java/io/InputStream:close	()V
    //   104: iconst_1
    //   105: ireturn
    //   106: aload_3
    //   107: invokevirtual 144	java/io/BufferedReader:close	()V
    //   110: aload_1
    //   111: invokevirtual 147	java/io/InputStream:close	()V
    //   114: goto -10 -> 104
    //   117: astore_1
    //   118: ldc 89
    //   120: new 26	java/lang/StringBuilder
    //   123: dup
    //   124: ldc 149
    //   126: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   129: aload_1
    //   130: invokevirtual 150	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   133: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 141	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: goto -38 -> 104
    //   145: astore_1
    //   146: ldc 89
    //   148: new 26	java/lang/StringBuilder
    //   151: dup
    //   152: ldc 149
    //   154: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   157: aload_1
    //   158: invokevirtual 150	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   161: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 141	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: goto -66 -> 104
    //   173: astore_3
    //   174: aconst_null
    //   175: astore_2
    //   176: aload_2
    //   177: ifnull +7 -> 184
    //   180: aload_2
    //   181: invokevirtual 144	java/io/BufferedReader:close	()V
    //   184: aload_1
    //   185: invokevirtual 147	java/io/InputStream:close	()V
    //   188: aload_3
    //   189: athrow
    //   190: astore_1
    //   191: ldc 89
    //   193: new 26	java/lang/StringBuilder
    //   196: dup
    //   197: ldc 149
    //   199: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   202: aload_1
    //   203: invokevirtual 150	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   206: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 141	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: goto -27 -> 188
    //   218: astore_3
    //   219: goto -43 -> 176
    //   222: astore 4
    //   224: aconst_null
    //   225: astore_3
    //   226: goto -161 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	SelectPoiCategoryUI
    //   0	229	1	paramInputStream	java.io.InputStream
    //   34	147	2	localBufferedReader1	java.io.BufferedReader
    //   32	75	3	localBufferedReader2	java.io.BufferedReader
    //   173	16	3	localObject1	Object
    //   218	1	3	localObject2	Object
    //   225	1	3	localObject3	Object
    //   39	14	4	str	String
    //   63	16	4	localIOException1	IOException
    //   222	1	4	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   35	41	63	java/io/IOException
    //   48	60	63	java/io/IOException
    //   106	114	117	java/lang/Exception
    //   96	100	145	java/lang/Exception
    //   100	104	145	java/lang/Exception
    //   15	33	173	finally
    //   180	184	190	java/lang/Exception
    //   184	188	190	java/lang/Exception
    //   35	41	218	finally
    //   48	60	218	finally
    //   67	92	218	finally
    //   15	33	222	java/io/IOException
  }
  
  final void aF(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new String(paramArrayOfByte).split("\n");
    this.mFM.clear();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      this.mFM.add(paramArrayOfByte[i].trim());
      i += 1;
    }
  }
  
  final void bor()
  {
    this.mFL.clear();
    int i = 0;
    while (i < this.mFM.size())
    {
      this.mFL.add(this.mFM.get(i));
      i += 1;
    }
    this.mFL.notifyDataSetChanged();
  }
  
  protected final int getLayoutId()
  {
    return R.i.select_poi_category_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.nl_select_category);
    setBackBtn(this.mFE);
    this.mFL = new ArrayAdapter(this, R.i.poi_category_item);
    this.Nn = ((ListView)findViewById(R.h.categories_container));
    this.Nn.setAdapter(this.mFL);
    this.Nn.setOnItemClickListener(this.mFN);
    AssetManager localAssetManager;
    if (!JS(mFJ + "/lastest_poi_categories.dat")) {
      localAssetManager = getAssets();
    }
    try
    {
      z(localAssetManager.open("default_poi_categories.dat"));
      bor();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.d("MicroMsg.SelectPoiCategoryUI", "open file from assets failed: " + localIOException.getMessage());
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mFM = new ArrayList();
    initView();
    this.mFK = new SelectPoiCategoryUI.a(this);
    paramBundle = this.mFK;
    a.udP.c(paramBundle);
    this.mFK.mFP = this;
    paramBundle = new k(17);
    au.Dk().a(paramBundle, 0);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    SelectPoiCategoryUI.a locala = this.mFK;
    a.udP.d(locala);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.SelectPoiCategoryUI
 * JD-Core Version:    0.7.0.1
 */