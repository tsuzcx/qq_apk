package com.tencent.mm.plugin.recordvideo.d;

import a.f.b.j;
import a.l;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/util/MediaFileUtil;", "", "()V", "checkConfigProviderCapturePath", "", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "checkConfigProviderPhotoEditPath", "checkConfigProviderVideoEditPath", "getCaptureEditVideoPath", "", "getCaptureImagePath", "getCaptureThumbPath", "videoPath", "getCaptureVideoPath", "getEditImagePath", "handleNoNeedRemuxCaptureVideo", "", "isCaptureMedia", "handleRemuxImage", "change", "handleRemuxVideo", "plugin-recordvideo_release"})
public final class a
{
  public static final a qfv;
  
  static
  {
    AppMethodBeat.i(150839);
    qfv = new a();
    AppMethodBeat.o(150839);
  }
  
  public static String Yb(String paramString)
  {
    AppMethodBeat.i(154655);
    paramString = com.tencent.mm.plugin.mmsight.d.TW(paramString);
    j.p(paramString, "MMSightUtil.getThumbName(videoPath)");
    AppMethodBeat.o(154655);
    return paramString;
  }
  
  public static void a(final RecordConfigProvider paramRecordConfigProvider, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(155839);
    if (paramRecordConfigProvider != null)
    {
      com.tencent.mm.sdk.g.d.h((Runnable)new c(paramRecordConfigProvider, paramRecordConfigProvider, paramBoolean1, paramBoolean2), "mux_save_work").start();
      AppMethodBeat.o(155839);
      return;
    }
    AppMethodBeat.o(155839);
  }
  
  public static void b(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(154652);
    j.q(paramRecordConfigProvider, "configProvider");
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.qbD))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      j.p(com.tencent.mm.modelvideo.o.alD(), "SubCoreVideo.getCore()");
      paramRecordConfigProvider.qbD = (com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_output_" + System.currentTimeMillis());
    }
    AppMethodBeat.o(154652);
  }
  
  public static void b(RecordConfigProvider paramRecordConfigProvider, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(155840);
    if (paramRecordConfigProvider != null)
    {
      com.tencent.mm.sdk.g.d.h((Runnable)new a.b(paramRecordConfigProvider, paramBoolean1, paramRecordConfigProvider, paramBoolean2), "mux_save_work").start();
      AppMethodBeat.o(155840);
      return;
    }
    AppMethodBeat.o(155840);
  }
  
  public static void c(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(154653);
    j.q(paramRecordConfigProvider, "configProvider");
    StringBuilder localStringBuilder;
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.thumbPath))
    {
      localStringBuilder = new StringBuilder();
      j.p(com.tencent.mm.modelvideo.o.alD(), "SubCoreVideo.getCore()");
      paramRecordConfigProvider.thumbPath = (com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_thumb_" + System.currentTimeMillis());
    }
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.qbB))
    {
      localStringBuilder = new StringBuilder();
      j.p(com.tencent.mm.modelvideo.o.alD(), "SubCoreVideo.getCore()");
      paramRecordConfigProvider.qbB = (com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_output_" + System.currentTimeMillis());
    }
    AppMethodBeat.o(154653);
  }
  
  public static String cgC()
  {
    AppMethodBeat.i(154654);
    j.p(com.tencent.mm.modelvideo.o.alD(), "SubCoreVideo.getCore()");
    String str = com.tencent.mm.plugin.mmsight.d.TU(com.tencent.mm.modelvideo.o.getAccVideoPath());
    j.p(str, "MMSightUtil.getTempFileN…o.getCore().accVideoPath)");
    AppMethodBeat.o(154654);
    return str;
  }
  
  public static String cgD()
  {
    AppMethodBeat.i(150836);
    String str = com.tencent.mm.at.o.ahC().getFullPath("photoEdited_" + System.currentTimeMillis());
    j.p(str, "SubCoreImage.getImgStg()…currentTimeMillis() + \"\")");
    AppMethodBeat.o(150836);
    return str;
  }
  
  public static String cgE()
  {
    AppMethodBeat.i(154656);
    String str = com.tencent.mm.at.o.ahC().getFullPath("photoCapture_" + System.currentTimeMillis());
    j.p(str, "SubCoreImage.getImgStg()…currentTimeMillis() + \"\")");
    AppMethodBeat.o(154656);
    return str;
  }
  
  public static boolean d(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(155505);
    if (paramRecordConfigProvider != null)
    {
      if (com.tencent.mm.vfs.e.cN(paramRecordConfigProvider.qbA)) {
        com.tencent.mm.vfs.e.C(paramRecordConfigProvider.qbA, paramRecordConfigProvider.qbB);
      }
      com.tencent.mm.sdk.g.d.h((Runnable)new a.a(paramRecordConfigProvider), "mux_save_work").start();
    }
    AppMethodBeat.o(155505);
    return true;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/util/MediaFileUtil$handleRemuxVideo$1$1"})
  static final class c
    implements Runnable
  {
    c(RecordConfigProvider paramRecordConfigProvider1, RecordConfigProvider paramRecordConfigProvider2, boolean paramBoolean1, boolean paramBoolean2) {}
    
    public final void run()
    {
      AppMethodBeat.i(150833);
      if (!paramRecordConfigProvider.qby) {
        com.tencent.mm.vfs.e.deleteFile(this.qfw.qbA);
      }
      Object localObject = com.tencent.mm.kernel.g.RL();
      j.p(localObject, "MMKernel.storage()");
      if (!((com.tencent.mm.kernel.e)localObject).Ru().getBoolean(ac.a.yEJ, true))
      {
        AppMethodBeat.o(150833);
        return;
      }
      if ((paramBoolean1) || ((!paramBoolean1) && (paramRecordConfigProvider.qbz) && (paramBoolean2)))
      {
        localObject = com.tencent.mm.plugin.mmsight.d.TY("mp4");
        if (!paramBoolean1) {
          localObject = b.TY("mp4");
        }
        com.tencent.mm.vfs.e.C(this.qfw.qbB, (String)localObject);
        b.a((String)localObject, ah.getContext());
      }
      AppMethodBeat.o(150833);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.a
 * JD-Core Version:    0.7.0.1
 */