package com.tencent.mm.plugin.updater.model;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.hp.b.d;
import com.tencent.mm.plugin.updater.a.c;
import com.tencent.mm.protocal.protobuf.czn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/updater/model/DownloadCallbackListener;", "Lcom/tencent/mm/plugin/downloader/model/IFileDownloadCallback;", "response", "Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "downloadId", "", "(Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;J)V", "TAG", "", "getDownloadId", "()J", "getResponse", "()Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "onTaskFailed", "", "id", "errCode", "", "hasChangeUrl", "", "onTaskFinished", "savedFilePath", "onTaskMd5Checking", "onTaskPaused", "onTaskProgressChanged", "url", "revcLeng", "totalLen", "onTaskRemoved", "onTaskResumed", "onTaskStarted", "plugin-updater_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements m
{
  private final String TAG;
  private final com.tencent.mm.plugin.hp.b.b TWJ;
  private final long hyV;
  
  public a(com.tencent.mm.plugin.hp.b.b paramb, long paramLong)
  {
    AppMethodBeat.i(265955);
    this.TWJ = paramb;
    this.hyV = paramLong;
    this.TAG = "MicroMsg.Updater.DownloadCallbackListener";
    AppMethodBeat.o(265955);
  }
  
  private static final void bw(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(265983);
    Object localObject = b.TWK;
    localObject = b.TWK;
    localObject = b.getString(a.c.wechat);
    StringBuilder localStringBuilder = new StringBuilder();
    b localb = b.TWK;
    b.a((String)localObject, b.getString(a.c.updater_download_progress) + 100L * paramLong1 / paramLong2 + '%', null);
    AppMethodBeat.o(265983);
  }
  
  private static final void hPT()
  {
    AppMethodBeat.i(265966);
    Toast.makeText(MMApplicationContext.getContext(), (CharSequence)MMApplicationContext.getContext().getString(a.c.updater_download_start), 0).show();
    Object localObject = b.TWK;
    localObject = b.TWK;
    localObject = b.getString(a.c.wechat);
    b localb = b.TWK;
    b.a((String)localObject, b.getString(a.c.updater_download_progress, new Object[] { "0%" }), null);
    AppMethodBeat.o(265966);
  }
  
  private static final void hPU()
  {
    AppMethodBeat.i(265970);
    Toast.makeText(MMApplicationContext.getContext(), (CharSequence)MMApplicationContext.getContext().getString(a.c.updater_merge_wording), 0).show();
    Object localObject = b.TWK;
    localObject = b.TWK;
    localObject = b.getString(a.c.wechat);
    b localb = b.TWK;
    b.a((String)localObject, b.getString(a.c.updater_merge_wording), null);
    AppMethodBeat.o(265970);
  }
  
  private static final void hPV()
  {
    AppMethodBeat.i(265976);
    Toast.makeText(MMApplicationContext.getContext(), (CharSequence)MMApplicationContext.getContext().getString(a.c.updater_download_fail), 0).show();
    b localb = b.TWK;
    b.hPY();
    AppMethodBeat.o(265976);
  }
  
  public final void a(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(266036);
    s.u(paramString, "url");
    Log.i(this.TAG, "onTaskProgressChanged cdnUrl:" + this.TWJ.mOI + " downloadId:" + this.hyV + " id:" + paramLong1 + " revcLeng:" + paramLong2 + " totalLen:" + paramLong3);
    if (this.hyV == paramLong1) {
      h.ahAA.bk(new a..ExternalSyntheticLambda0(paramLong2, paramLong3));
    }
    AppMethodBeat.o(266036);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(266014);
    Log.i(this.TAG, "onTaskFinished cdnUrl:" + this.TWJ.mOI + " downloadId:" + this.hyV + " id:" + paramLong + " hasChangeUrl:" + paramBoolean + " savedFilePath:" + paramString);
    Object localObject;
    if (this.hyV == paramLong) {
      if (this.TWJ != null)
      {
        localObject = this.TWJ.vyQ;
        if (localObject != null) {
          break label150;
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.downloader.model.f.duv();
      c.b((m)this);
      h.ahAA.bk(a..ExternalSyntheticLambda3.INSTANCE);
      if (paramString != null)
      {
        localObject = b.TWK;
        b.a(this.TWJ, paramString);
      }
      AppMethodBeat.o(266014);
      return;
      label150:
      if ((((Integer)localObject).intValue() == 4) && (paramString != null))
      {
        localObject = d.fQw();
        if ((!Util.isNullOrNil(this.TWJ.mOI)) && (!Util.isNullOrNil(((czn)localObject).mOI)) && (this.TWJ.mOI.equals(((czn)localObject).mOI))) {
          Log.i(this.TAG, "HdiffApk onDownloadFinish, funck is equals, response.cdnUrl: " + this.TWJ.mOI + ", status.cdnUrl = " + ((czn)localObject).mOI);
        }
        ((czn)localObject).vXL = "3";
        d.a((czn)localObject);
      }
    }
  }
  
  public final void c(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(266019);
    Log.i(this.TAG, "onTaskFailed cdnUrl:" + this.TWJ.mOI + " downloadId:" + this.hyV + " id:" + paramLong + " errCode:" + paramInt + " hasChangeUrl:" + paramBoolean);
    if (this.hyV == paramLong)
    {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 13L, 1L, false);
      com.tencent.mm.plugin.downloader.model.f.duv();
      c.b((m)this);
      h.ahAA.bk(a..ExternalSyntheticLambda1.INSTANCE);
    }
    AppMethodBeat.o(266019);
  }
  
  public final void jF(long paramLong)
  {
    AppMethodBeat.i(266025);
    Log.i(this.TAG, "onTaskRemoved cdnUrl:" + this.TWJ.mOI + " downloadId:" + this.hyV + " id:" + paramLong);
    if (this.hyV == paramLong)
    {
      com.tencent.mm.plugin.downloader.model.f.duv();
      c.b((m)this);
    }
    AppMethodBeat.o(266025);
  }
  
  public final void jG(long paramLong)
  {
    AppMethodBeat.i(266027);
    Log.i(this.TAG, "onTaskPaused cdnUrl:" + this.TWJ.mOI + " downloadId:" + this.hyV + " id:" + paramLong);
    AppMethodBeat.o(266027);
  }
  
  public final void jH(long paramLong)
  {
    AppMethodBeat.i(266047);
    Log.i(this.TAG, "onTaskMd5Checking cdnUrl:" + this.TWJ.mOI + " downloadId:" + this.hyV + " id:" + paramLong);
    AppMethodBeat.o(266047);
  }
  
  public final void v(long paramLong, String paramString)
  {
    AppMethodBeat.i(266004);
    String str2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onTaskStarted cdnUrl:").append(this.TWJ.mOI).append(" downloadId:").append(this.hyV).append(" id:").append(paramLong).append(" savedFilePath:");
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    Log.i(str2, str1);
    if (this.hyV == paramLong)
    {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1429L, 12L, 1L, false);
      h.ahAA.bk(a..ExternalSyntheticLambda2.INSTANCE);
    }
    AppMethodBeat.o(266004);
  }
  
  public final void w(long paramLong, String paramString)
  {
    AppMethodBeat.i(266041);
    Log.i(this.TAG, "onTaskResumed cdnUrl:" + this.TWJ.mOI + " downloadId:" + this.hyV + " id:" + paramLong);
    AppMethodBeat.o(266041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.model.a
 * JD-Core Version:    0.7.0.1
 */