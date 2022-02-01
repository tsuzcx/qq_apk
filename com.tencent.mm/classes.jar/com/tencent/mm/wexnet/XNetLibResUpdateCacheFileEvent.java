package com.tencent.mm.wexnet;

import android.text.TextUtils;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.autogen.a.cd.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.io.File;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/wexnet/XNetLibResUpdateCacheFileEvent;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "()V", "callback", "", "event", "recycleOldVersionSo", "", "path", "", "fileVersion", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class XNetLibResUpdateCacheFileEvent
  extends IListener<cd>
{
  public static final a agWn;
  
  static
  {
    AppMethodBeat.i(231552);
    agWn = new a((byte)0);
    AppMethodBeat.o(231552);
  }
  
  public XNetLibResUpdateCacheFileEvent()
  {
    super((q)f.hfK);
    AppMethodBeat.i(231526);
    AppMethodBeat.o(231526);
  }
  
  private static boolean a(cd paramcd)
  {
    AppMethodBeat.i(231540);
    s.u(paramcd, "event");
    if ((paramcd.hCg.hCh == 108) || (paramcd.hCg.hCh == 109))
    {
      Log.i("MicroMsg.XNET.XNetLibResUpdateCacheFileEvent", "xnet lib update coming. resType: %d subtype: %d, file path: %s, file version: %d, isArm64: %b", new Object[] { Integer.valueOf(paramcd.hCg.hCh), Integer.valueOf(paramcd.hCg.subType), paramcd.hCg.filePath, Integer.valueOf(paramcd.hCg.hCi), Boolean.valueOf(BuildInfo.IS_ARM64) });
      if (!new File(paramcd.hCg.filePath).exists())
      {
        Log.e("MicroMsg.XNET.XNetLibResUpdateCacheFileEvent", "file not exits :%s", new Object[] { paramcd.hCg.filePath });
        AppMethodBeat.o(231540);
        return true;
      }
      Object localObject1 = y.bub(paramcd.hCg.filePath);
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        Log.e("MicroMsg.XNET.XNetLibResUpdateCacheFileEvent", "current_file_md5 is empty");
        AppMethodBeat.o(231540);
        return true;
      }
      if (!s.p(localObject1, paramcd.hCg.hCk))
      {
        h.OAn.idkeyStat(1868L, 6L, 1L, true);
        Log.e("MicroMsg.XNET.XNetLibResUpdateCacheFileEvent", "md5 is diff, current md5:%s, original md5:%s", new Object[] { localObject1, paramcd.hCg.hCk });
        AppMethodBeat.o(231540);
        return true;
      }
      Log.i("MicroMsg.XNET.XNetLibResUpdateCacheFileEvent", "md5 is same, current md5:%s, original md5:%s", new Object[] { localObject1, paramcd.hCg.hCk });
      localObject1 = b.agWj;
      localObject1 = b.a.jPK();
      Object localObject2 = new File((String)localObject1);
      if (!((File)localObject2).exists()) {}
      try
      {
        ((File)localObject2).mkdir();
        localObject2 = (String)localObject1 + '/' + paramcd.hCg.hCi;
        localFile = new File((String)localObject2);
        if (localFile.exists()) {
          localFile.delete();
        }
      }
      catch (Exception localException1)
      {
        try
        {
          File localFile;
          localFile.mkdirs();
          int i = y.aA(paramcd.hCg.filePath, (String)localObject2);
          if (i < 0)
          {
            h.OAn.idkeyStat(1868L, 5L, 1L, true);
            Log.e("MicroMsg.XNET.XNetLibResUpdateCacheFileEvent", "unzip fail, ret = " + i + ", zipFilePath = " + paramcd.hCg.filePath + ", unzipPath = " + (String)localObject2);
            AppMethodBeat.o(231540);
            return true;
            localException1 = localException1;
            Log.printErrStackTrace("MicroMsg.XNET.XNetLibResUpdateCacheFileEvent", (Throwable)localException1, "create file:%s", new Object[] { localObject2 });
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.XNET.XNetLibResUpdateCacheFileEvent", (Throwable)localException2, "create file:%s", new Object[] { localObject2 });
            continue;
            Log.i("MicroMsg.XNET.XNetLibResUpdateCacheFileEvent", "unzip file success, unzipFolder file :%s to path:%s", new Object[] { paramcd.hCg.filePath, localObject2 });
            com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf().bu(paramcd.hCg.hCh, paramcd.hCg.subType, paramcd.hCg.hCi);
            h.OAn.idkeyStat(1868L, 4L, 1L, true);
            cC((String)localObject1, paramcd.hCg.hCi);
          }
        }
      }
    }
    AppMethodBeat.o(231540);
    return false;
  }
  
  private static void cC(String paramString, int paramInt)
  {
    AppMethodBeat.i(231545);
    Log.i("MicroMsg.XNET.XNetLibResUpdateCacheFileEvent", "recycleOldVersionSo current fileVersion", new Object[] { Integer.valueOf(paramInt) });
    paramInt -= 2;
    if (paramInt < 0)
    {
      AppMethodBeat.o(231545);
      return;
    }
    if (paramInt >= 0) {}
    for (;;)
    {
      int i = paramInt - 1;
      String str = paramString + '/' + paramInt;
      File localFile = new File(str);
      if (localFile.exists())
      {
        localFile.delete();
        Log.i("MicroMsg.XNET.XNetLibResUpdateCacheFileEvent", "delete versionFolder:%s", new Object[] { str });
      }
      if (i < 0)
      {
        AppMethodBeat.o(231545);
        return;
      }
      paramInt = i;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/wexnet/XNetLibResUpdateCacheFileEvent$Companion;", "", "()V", "RECYCLED_VERSION_INTERVAl", "", "TAG", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wexnet.XNetLibResUpdateCacheFileEvent
 * JD-Core Version:    0.7.0.1
 */