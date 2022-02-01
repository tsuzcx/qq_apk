package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.g;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.g.a.bn.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import d.z;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "", "()V", "checkResUpdateCacheFileEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "downloadFileSuccessCallback", "Lkotlin/Function0;", "", "getDownloadFileSuccessCallback", "()Lkotlin/jvm/functions/Function0;", "setDownloadFileSuccessCallback", "(Lkotlin/jvm/functions/Function0;)V", "<set-?>", "", "fileExist", "getFileExist", "()Z", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/IVideoResReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/IVideoResReport;", "checkFile", "checkRes", "getConfigJson", "Lorg/json/JSONArray;", "getFileDirName", "", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResTmpPath", "getResType", "", "getSubType", "getTag", "init", "moveFileToTargetPath", "fileName", "reportEdit", "unInit", "unzipRes", "filePath", "type", "subType", "version", "Companion", "plugin-recordvideo_release"})
public abstract class a
{
  public static final a.a xXk = new a.a((byte)0);
  final com.tencent.mm.sdk.b.c<bn> hZz = (com.tencent.mm.sdk.b.c)new b(this);
  public boolean xXi;
  public d.g.a.a<z> xXj;
  
  private final boolean aHI()
  {
    Object localObject = dKm() + "config.json";
    ae.i(getTag(), "absConfigPath is:".concat(String.valueOf(localObject)));
    if (o.fB((String)localObject))
    {
      localObject = o.aZT((String)localObject);
      try
      {
        localObject = new JSONArray((String)localObject);
        int k = ((JSONArray)localObject).length();
        int i = 0;
        while (i < k)
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          String[] arrayOfString = dKl();
          int m = arrayOfString.length;
          int j = 0;
          while (j < m)
          {
            String str = arrayOfString[j];
            str = dKm() + localJSONObject.optString(str);
            ae.i(getTag(), "file index:" + i + " path:" + str);
            if (!o.fB(str))
            {
              ae.e(getTag(), "file not exist.path:".concat(String.valueOf(str)));
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
        ae.printErrStackTrace(getTag(), (Throwable)localException, "video res parse config error!", new Object[0]);
        return false;
      }
    }
    ae.i(getTag(), "config not exist.");
    return false;
  }
  
  private final String dKo()
  {
    return dKm() + "temp/";
  }
  
  private final void n(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int j;
    Object localObject;
    try
    {
      ae.i(getTag(), "unzipRes: %s", new Object[] { paramString });
      if (!o.fB(paramString)) {
        break label626;
      }
      o.aZI(dKo());
      j = o.fD(paramString, dKo());
      ae.i(getTag(), "unzip file ret:" + j + "  " + dKo());
      paramString = o.dh(dKo() + dKn(), false);
      if (paramString != null)
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          localObject = (com.tencent.mm.vfs.c)paramString.next();
          ae.i(getTag(), "unzip file path:" + ((com.tencent.mm.vfs.c)localObject).Itr + " name:" + ((com.tencent.mm.vfs.c)localObject).name + " size:" + ((com.tencent.mm.vfs.c)localObject).size);
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
        if (!o.fB(dKo() + dKn() + "config.json")) {
          break label797;
        }
        paramString = o.aZT(dKo() + dKn() + "config.json");
        ae.i(getTag(), "meta json: %s", new Object[] { paramString });
        paramString = new JSONArray(paramString);
        i = 0;
        int k = paramString.length();
        if (i >= k) {
          break label713;
        }
        localObject = paramString.getJSONObject(i);
        String[] arrayOfString = dKl();
        int m = arrayOfString.length;
        j = 0;
        if (j >= m) {
          break label895;
        }
        str1 = ((JSONObject)localObject).optString(arrayOfString[j]);
        p.g(str1, "item.optString(it)");
        String str2 = dKo() + dKn() + str1;
        String str3 = dKm() + str1;
        ae.i(getTag(), "file tmp:" + str2 + "  real:" + str3);
        if (o.fB(str2)) {
          if (!o.fB(str3))
          {
            ae.i(getTag(), "move file ".concat(String.valueOf(str1)));
            o.mG(str2, str3);
          }
          else if ((p.i(g.getMD5(str2), g.getMD5(str3)) ^ true))
          {
            o.deleteFile(str3);
            o.mG(str2, str3);
            ae.i(getTag(), "replace file ".concat(String.valueOf(str1)));
          }
        }
      }
      catch (Exception paramString)
      {
        String str1;
        ae.printErrStackTrace(getTag(), (Throwable)paramString, "unzipRes error: %s", new Object[] { paramString.getMessage() });
        dKj().dKx();
        ae.i(getTag(), "unzip failed");
        paramString = this.xXj;
        if (paramString != null) {
          paramString.invoke();
        }
        o.dd(dKo(), true);
        label626:
        return;
        ae.i(getTag(), "already has file ".concat(String.valueOf(str1)));
      }
      finally
      {
        dKj().dKx();
        ae.i(getTag(), "unzip failed");
        localObject = this.xXj;
        if (localObject != null) {
          ((d.g.a.a)localObject).invoke();
        }
        o.dd(dKo(), true);
      }
      ae.e(getTag(), "fuck! config does not matching file list!!!!!!!!");
      break label886;
      label713:
      o.deleteFile(dKm() + "config.json");
      o.mG(dKo() + dKn() + "config.json", dKm() + "config.json");
      i = 1;
      label797:
      if (i == 0)
      {
        dKj().dKx();
        ae.i(getTag(), "unzip failed");
      }
      for (;;)
      {
        paramString = this.xXj;
        if (paramString != null) {
          paramString.invoke();
        }
        o.dd(dKo(), true);
        break;
        dKj().dKw();
        ae.i(getTag(), "unzip success");
        com.tencent.mm.pluginsdk.j.a.a.b.fes().aH(paramInt1, paramInt2, paramInt3);
        this.xXi = true;
      }
      label886:
      j += 1;
      continue;
      label895:
      i += 1;
    }
  }
  
  public final void aHH()
  {
    ae.i(getTag(), "checkRes " + dKk());
    com.tencent.mm.pluginsdk.j.a.a.b.fes();
    com.tencent.mm.pluginsdk.j.a.a.b.Zd(dKk());
    dKj().aHH();
  }
  
  public abstract b dKj();
  
  public abstract int dKk();
  
  public abstract String[] dKl();
  
  public abstract String dKm();
  
  public abstract String dKn();
  
  public final JSONArray dKp()
  {
    if (this.xXi) {
      return new JSONArray(o.aZT(dKm() + "config.json"));
    }
    return null;
  }
  
  public final void dKq()
  {
    if (this.xXi)
    {
      dKj().dKt();
      return;
    }
    dKj().dKu();
  }
  
  public abstract String getTag();
  
  public final void init()
  {
    ae.i(getTag(), "init");
    this.hZz.alive();
    if (aHI()) {
      this.xXi = true;
    }
    while (this.xXi)
    {
      dKj().dKr();
      return;
      com.tencent.mm.pluginsdk.j.a.a.b.fes();
      String str = com.tencent.mm.pluginsdk.j.a.a.b.jq(dKk(), 1);
      if (o.fB(str))
      {
        ae.i(getTag(), "cache file exist %s", new Object[] { str });
        p.g(str, "cacheFile");
        n(str, dKk(), 1, 1);
      }
    }
    dKj().dKs();
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic$checkResUpdateCacheFileEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "callback", "", "event", "plugin-recordvideo_release"})
  public static final class b
    extends com.tencent.mm.sdk.b.c<bn>
  {
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(a.b paramb, bn parambn) {}
      
      public final void run()
      {
        AppMethodBeat.i(206664);
        a locala = this.xXm.xXl;
        String str = this.xXn.dny.filePath;
        p.g(str, "event.data.filePath");
        a.a(locala, str, this.xXn.dny.dnz, this.xXn.dny.subType, this.xXn.dny.dnA);
        AppMethodBeat.o(206664);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.a
 * JD-Core Version:    0.7.0.1
 */