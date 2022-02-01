package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.g;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.g.a.bn.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.FileSystem.a;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.l;
import d.z;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "", "()V", "checkResUpdateCacheFileEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "downloadFileSuccessCallback", "Lkotlin/Function0;", "", "getDownloadFileSuccessCallback", "()Lkotlin/jvm/functions/Function0;", "setDownloadFileSuccessCallback", "(Lkotlin/jvm/functions/Function0;)V", "<set-?>", "", "fileExist", "getFileExist", "()Z", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/IVideoResReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/IVideoResReport;", "checkFile", "checkRes", "getConfigJson", "Lorg/json/JSONArray;", "getFileDirName", "", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResTmpPath", "getResType", "", "getSubType", "getTag", "init", "moveFileToTargetPath", "fileName", "reportEdit", "unInit", "unzipRes", "filePath", "type", "subType", "version", "Companion", "plugin-recordvideo_release"})
public abstract class a
{
  public static final a.a xHp = new a.a((byte)0);
  final c<bn> hWH = (c)new b(this);
  public boolean xHn;
  public d.g.a.a<z> xHo;
  
  private final boolean aHr()
  {
    Object localObject = dGV() + "config.json";
    ad.i(getTag(), "absConfigPath is:".concat(String.valueOf(localObject)));
    if (i.fv((String)localObject))
    {
      localObject = i.aYq((String)localObject);
      try
      {
        localObject = new JSONArray((String)localObject);
        int k = ((JSONArray)localObject).length();
        int i = 0;
        while (i < k)
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          String[] arrayOfString = dGU();
          int m = arrayOfString.length;
          int j = 0;
          while (j < m)
          {
            String str = arrayOfString[j];
            str = dGV() + localJSONObject.optString(str);
            ad.i(getTag(), "file index:" + i + " path:" + str);
            if (!i.fv(str))
            {
              ad.e(getTag(), "file not exist.path:".concat(String.valueOf(str)));
              return false;
            }
            j += 1;
          }
          i += 1;
        }
        return true;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace(getTag(), (Throwable)localException, "video res parse config error!", new Object[0]);
        return false;
      }
    }
    ad.i(getTag(), "config not exist.");
    return false;
  }
  
  private final String dGX()
  {
    return dGV() + "temp/";
  }
  
  private final void n(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int j;
    Object localObject;
    try
    {
      ad.i(getTag(), "unzipRes: %s", new Object[] { paramString });
      if (!i.fv(paramString)) {
        break label626;
      }
      i.aYg(dGX());
      j = i.fz(paramString, dGX());
      ad.i(getTag(), "unzip file ret:" + j + "  " + dGX());
      paramString = i.de(dGX() + dGW(), false);
      if (paramString != null)
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          localObject = (FileSystem.a)paramString.next();
          ad.i(getTag(), "unzip file path:" + ((FileSystem.a)localObject).HZk + " name:" + ((FileSystem.a)localObject).name + " size:" + ((FileSystem.a)localObject).size);
        }
      }
      i = 0;
    }
    finally {}
    int i;
    if (j == 0) {}
    for (;;)
    {
      try
      {
        if (!i.fv(dGX() + dGW() + "config.json")) {
          break label797;
        }
        paramString = i.aYq(dGX() + dGW() + "config.json");
        ad.i(getTag(), "meta json: %s", new Object[] { paramString });
        paramString = new JSONArray(paramString);
        i = 0;
        int k = paramString.length();
        if (i >= k) {
          break label713;
        }
        localObject = paramString.getJSONObject(i);
        String[] arrayOfString = dGU();
        int m = arrayOfString.length;
        j = 0;
        if (j >= m) {
          break label895;
        }
        str1 = ((JSONObject)localObject).optString(arrayOfString[j]);
        p.g(str1, "item.optString(it)");
        String str2 = dGX() + dGW() + str1;
        String str3 = dGV() + str1;
        ad.i(getTag(), "file tmp:" + str2 + "  real:" + str3);
        if (i.fv(str2)) {
          if (!i.fv(str3))
          {
            ad.i(getTag(), "move file ".concat(String.valueOf(str1)));
            i.mA(str2, str3);
          }
          else if ((p.i(g.getMD5(str2), g.getMD5(str3)) ^ true))
          {
            i.deleteFile(str3);
            i.mA(str2, str3);
            ad.i(getTag(), "replace file ".concat(String.valueOf(str1)));
          }
        }
      }
      catch (Exception paramString)
      {
        String str1;
        ad.printErrStackTrace(getTag(), (Throwable)paramString, "unzipRes error: %s", new Object[] { paramString.getMessage() });
        dGS().dHg();
        ad.i(getTag(), "unzip failed");
        paramString = this.xHo;
        if (paramString != null) {
          paramString.invoke();
        }
        i.cZ(dGX(), true);
        label626:
        return;
        ad.i(getTag(), "already has file ".concat(String.valueOf(str1)));
      }
      finally
      {
        dGS().dHg();
        ad.i(getTag(), "unzip failed");
        localObject = this.xHo;
        if (localObject != null) {
          ((d.g.a.a)localObject).invoke();
        }
        i.cZ(dGX(), true);
      }
      ad.e(getTag(), "fuck! config does not matching file list!!!!!!!!");
      break label886;
      label713:
      i.deleteFile(dGV() + "config.json");
      i.mA(dGX() + dGW() + "config.json", dGV() + "config.json");
      i = 1;
      label797:
      if (i == 0)
      {
        dGS().dHg();
        ad.i(getTag(), "unzip failed");
      }
      for (;;)
      {
        paramString = this.xHo;
        if (paramString != null) {
          paramString.invoke();
        }
        i.cZ(dGX(), true);
        break;
        dGS().dHf();
        ad.i(getTag(), "unzip success");
        com.tencent.mm.pluginsdk.j.a.a.b.faE().aG(paramInt1, paramInt2, paramInt3);
        this.xHn = true;
      }
      label886:
      j += 1;
      continue;
      label895:
      i += 1;
    }
  }
  
  public final void aHq()
  {
    ad.i(getTag(), "checkRes " + dGT());
    com.tencent.mm.pluginsdk.j.a.a.b.faE();
    com.tencent.mm.pluginsdk.j.a.a.b.Yx(dGT());
    dGS().aHq();
  }
  
  public abstract b dGS();
  
  public abstract int dGT();
  
  public abstract String[] dGU();
  
  public abstract String dGV();
  
  public abstract String dGW();
  
  public final JSONArray dGY()
  {
    if (this.xHn) {
      return new JSONArray(i.aYq(dGV() + "config.json"));
    }
    return null;
  }
  
  public final void dGZ()
  {
    if (this.xHn)
    {
      dGS().dHc();
      return;
    }
    dGS().dHd();
  }
  
  public abstract String getTag();
  
  public final void init()
  {
    ad.i(getTag(), "init");
    this.hWH.alive();
    if (aHr()) {
      this.xHn = true;
    }
    while (this.xHn)
    {
      dGS().dHa();
      return;
      com.tencent.mm.pluginsdk.j.a.a.b.faE();
      String str = com.tencent.mm.pluginsdk.j.a.a.b.jm(dGT(), 1);
      if (i.fv(str))
      {
        ad.i(getTag(), "cache file exist %s", new Object[] { str });
        p.g(str, "cacheFile");
        n(str, dGT(), 1, 1);
      }
    }
    dGS().dHb();
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic$checkResUpdateCacheFileEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "callback", "", "event", "plugin-recordvideo_release"})
  public static final class b
    extends c<bn>
  {
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(a.b paramb, bn parambn) {}
      
      public final void run()
      {
        AppMethodBeat.i(200403);
        a locala = this.xHr.xHq;
        String str = this.xHs.dmw.filePath;
        p.g(str, "event.data.filePath");
        a.a(locala, str, this.xHs.dmw.dmx, this.xHs.dmw.subType, this.xHs.dmw.dmy);
        AppMethodBeat.o(200403);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.a
 * JD-Core Version:    0.7.0.1
 */