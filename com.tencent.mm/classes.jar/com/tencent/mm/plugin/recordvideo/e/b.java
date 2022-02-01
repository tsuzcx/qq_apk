package com.tencent.mm.plugin.recordvideo.e;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.protocal.protobuf.aip;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/util/MediaFileUtil;", "", "()V", "MEDIA_FILE_DELETE_SET", "", "MEDIA_FILE_KEY", "MEDIA_TIMING_DELETE_SET", "MIX_AUDIO_FILE", "MIX_BLUR_BG_FILE", "MIX_THUMB_FILE", "MIX_VIDEO_FILE", "PHOTO_EDIT_PREFIX", "PIC_FILE", "TAG", "VIDEO_FILE", "VIDEP_EDOT_PREFIX", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "videoMixPath", "videoRecordRootPath", "videoRecordTempPath", "audioEnsurePath", "parentPath", "mediaId", "checkAndMarkDeletePhotoFile", "", "key", "filePath", "checkConfigProviderCapturePath", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "checkConfigProviderPhotoEditPath", "checkConfigProviderVideoEditPath", "checkThumbSize", "Landroid/graphics/Bitmap;", "bitmap", "shortSide", "", "checkToCreateDir", "newVideoPath", "noMedia", "", "clearTimingFile", "deleteBizFile", "deleteDaemonMediaFile", "mediaCaptureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "deleteFile", "deleteMarkFileByKey", "deleteMarkFilePath", "deleteVideoFileWithCheckPath", "exportVideo", "videoPath", "getAudioTmpPath", "getBlurBgPath", "localId", "getCaptureEditVideoPath", "getCaptureImagePath", "getCaptureThumbPath", "getCaptureVideoPath", "getEditImagePath", "getMixAudioPath", "getMixThumbPath", "getMixVideoPath", "getRecordThumbTempPath", "timeStamp", "", "getSubCaptureVideoParent", "getSubCaptureVideoPath", "handleDaemonNoNeedRemuxCaptureVideo", "isCaptureMedia", "handleMultiPhotoResult", "photoPath", "handleMultiVideoResult", "handleNoNeedRemuxCaptureVideo", "handleRemuxImage", "change", "handleRemuxVideo", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "handleSubRecordMux", "captureInfo", "markDeleteMediaFile", "file", "markDeletePhotoEditFile", "imagePathList", "Ljava/util/ArrayList;", "markTimingDeleteFile", "saveThumb", "thumbPath", "thumbSize", "thumbEnsurePath", "videoEnsurePath", "plugin-recordvideo_release"})
public final class b
{
  private static final ay cCf;
  private static final String yhb;
  private static final String yhc;
  public static final String yhd;
  public static final b yhe;
  
  static
  {
    AppMethodBeat.i(76218);
    yhe = new b();
    StringBuilder localStringBuilder = new StringBuilder();
    e locale = g.ajR();
    p.g(locale, "MMKernel.storage()");
    yhb = locale.getAccPath() + "recordPlugin/";
    yhc = yhb + "temp/";
    yhd = yhb + "mix/";
    cCf = ay.aRW("media_file_key");
    AppMethodBeat.o(76218);
  }
  
  public static void a(final RecordConfigProvider paramRecordConfigProvider, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(76203);
    ae.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:" + paramBoolean1 + "   change:" + paramBoolean2);
    if (paramRecordConfigProvider != null)
    {
      h.MqF.f((Runnable)new k(paramRecordConfigProvider, paramRecordConfigProvider, paramBoolean1, paramBoolean2), "mux_save_work");
      AppMethodBeat.o(76203);
      return;
    }
    AppMethodBeat.o(76203);
  }
  
  public static void a(aip paramaip)
  {
    AppMethodBeat.i(76205);
    if (paramaip != null) {
      h.MqF.f((Runnable)new l(paramaip), "mux_save_work");
    }
    AppMethodBeat.o(76205);
  }
  
  public static void atH(String paramString)
  {
    AppMethodBeat.i(76192);
    if (!TextUtils.isEmpty((CharSequence)paramString)) {
      h.MqF.f((Runnable)new b.c(paramString), "MediaFileUtil_deleteMediaFile");
    }
    AppMethodBeat.o(76192);
  }
  
  public static void au(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(76194);
    p.h(paramArrayList, "imagePathList");
    paramArrayList = ((Iterable)paramArrayList).iterator();
    while (paramArrayList.hasNext())
    {
      String str1 = (String)paramArrayList.next();
      if (str1 != null)
      {
        CharSequence localCharSequence = (CharSequence)str1;
        String str2 = q.aIX().getFullPath("photoEdited_");
        p.g(str2, "SubCoreImage.getImgStg()…llPath(PHOTO_EDIT_PREFIX)");
        if (n.a(localCharSequence, (CharSequence)str2, false) == true)
        {
          ae.i("MicroMsg.MediaFileUtil", "markDeletePhotoEditFile: ".concat(String.valueOf(str1)));
          axg(str1);
        }
      }
    }
    AppMethodBeat.o(76194);
  }
  
  public static void axe(String paramString)
  {
    AppMethodBeat.i(207136);
    ae.i("MicroMsg.MediaFileUtil", "markTimingDeleteFile file ".concat(String.valueOf(paramString)));
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(207136);
      return;
    }
    Set localSet = cCf.decodeStringSet("media_timing_delete_set", (Set)new HashSet());
    localSet.add(paramString);
    cCf.encode("media_timing_delete_set", localSet);
    AppMethodBeat.o(207136);
  }
  
  public static void axf(String paramString)
  {
    AppMethodBeat.i(76189);
    if (paramString != null)
    {
      paramString = cCf.decodeString(paramString, "");
      if (!TextUtils.isEmpty((CharSequence)paramString)) {
        h.MqF.f((Runnable)new b.d(paramString), "MediaFileUtil_deleteMediaFile");
      }
    }
    AppMethodBeat.o(76189);
  }
  
  public static void axg(String paramString)
  {
    AppMethodBeat.i(76190);
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      ae.i("MicroMsg.MediaFileUtil", "cache delete file ".concat(String.valueOf(paramString)));
      Set localSet = cCf.decodeStringSet("media_file_delete_set", (Set)new HashSet());
      localSet.add(paramString);
      cCf.encode("media_file_delete_set", localSet);
    }
    AppMethodBeat.o(76190);
  }
  
  public static void axh(String paramString)
  {
    AppMethodBeat.i(76191);
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      Set localSet = cCf.decodeStringSet("media_file_delete_set", (Set)new HashSet());
      if (localSet.contains(paramString))
      {
        localSet.remove(paramString);
        if (!TextUtils.isEmpty((CharSequence)paramString)) {
          h.MqF.f((Runnable)new b.e(paramString), "MediaFileUtil_deleteMediaFile");
        }
      }
    }
    AppMethodBeat.o(76191);
  }
  
  public static void axi(String paramString)
  {
    AppMethodBeat.i(76193);
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      if (paramString == null) {
        break label69;
      }
      CharSequence localCharSequence = (CharSequence)paramString;
      p.g(com.tencent.mm.modelvideo.o.aNg(), "SubCoreVideo.getCore()");
      String str = com.tencent.mm.modelvideo.o.getAccVideoPath();
      p.g(str, "SubCoreVideo.getCore().accVideoPath");
      if (n.a(localCharSequence, (CharSequence)str, false) == true) {
        atH(paramString);
      }
    }
    AppMethodBeat.o(76193);
    return;
    label69:
    AppMethodBeat.o(76193);
  }
  
  public static void axj(String paramString)
  {
    AppMethodBeat.i(76195);
    if (paramString != null)
    {
      CharSequence localCharSequence = (CharSequence)paramString;
      String str = q.aIX().getFullPath("photoEdited_");
      p.g(str, "SubCoreImage.getImgStg()…llPath(PHOTO_EDIT_PREFIX)");
      if (n.a(localCharSequence, (CharSequence)str, false) == true)
      {
        ae.i("MicroMsg.MediaFileUtil", "markDeletePhotoEditFile: ".concat(String.valueOf(paramString)));
        axg(paramString);
      }
      AppMethodBeat.o(76195);
      return;
    }
    AppMethodBeat.o(76195);
  }
  
  public static String axk(String paramString)
  {
    AppMethodBeat.i(76200);
    p.h(paramString, "videoPath");
    paramString = d.arQ(paramString);
    p.g(paramString, "MMSightUtil.getThumbName(videoPath)");
    AppMethodBeat.o(76200);
    return paramString;
  }
  
  public static void axl(String paramString)
  {
    AppMethodBeat.i(207139);
    if ((!TextUtils.isEmpty((CharSequence)paramString)) && (com.tencent.mm.vfs.o.fB(paramString))) {
      h.MqF.aO((Runnable)new b.h(paramString));
    }
    AppMethodBeat.o(207139);
  }
  
  public static void axm(String paramString)
  {
    AppMethodBeat.i(207140);
    if ((!TextUtils.isEmpty((CharSequence)paramString)) && (com.tencent.mm.vfs.o.fB(paramString))) {
      h.MqF.aO((Runnable)new b.g(paramString));
    }
    AppMethodBeat.o(207140);
  }
  
  public static String axn(String paramString)
  {
    AppMethodBeat.i(76213);
    if (paramString == null)
    {
      AppMethodBeat.o(76213);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String str = yhd;
    if (paramString == null) {}
    for (paramString = "";; paramString = str + paramString + ".v")
    {
      paramString = paramString + ".mixv";
      AppMethodBeat.o(76213);
      return paramString;
    }
  }
  
  public static String axo(String paramString)
  {
    AppMethodBeat.i(76214);
    if (paramString == null)
    {
      AppMethodBeat.o(76214);
      return "";
    }
    paramString = iT(yhd, paramString) + ".mixt";
    AppMethodBeat.o(76214);
    return paramString;
  }
  
  public static String axp(String paramString)
  {
    AppMethodBeat.i(163472);
    if (paramString == null)
    {
      AppMethodBeat.o(163472);
      return "";
    }
    paramString = iT(yhd, paramString) + ".blurt";
    AppMethodBeat.o(163472);
    return paramString;
  }
  
  public static void axq(String paramString)
  {
    AppMethodBeat.i(76215);
    p.h(paramString, "newVideoPath");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(76215);
      return;
    }
    paramString = com.tencent.mm.vfs.o.aZU(paramString);
    com.tencent.mm.vfs.o.aZI(paramString);
    com.tencent.mm.vfs.o.aZX(paramString);
    AppMethodBeat.o(76215);
  }
  
  public static void b(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(207141);
    if (paramb != null)
    {
      if (paramb.hwD == true) {
        h.MqF.aO((Runnable)new b.n(paramb));
      }
      AppMethodBeat.o(207141);
      return;
    }
    AppMethodBeat.o(207141);
  }
  
  public static void b(final RecordConfigProvider paramRecordConfigProvider, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(76206);
    ae.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:" + paramBoolean1 + "   change:" + paramBoolean2);
    if (paramRecordConfigProvider != null)
    {
      h.MqF.f((Runnable)new j(paramRecordConfigProvider, paramBoolean1, paramRecordConfigProvider, paramBoolean2), "mux_save_work");
      AppMethodBeat.o(76206);
      return;
    }
    AppMethodBeat.o(76206);
  }
  
  public static void c(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(76217);
    if (paramb != null)
    {
      h.MqF.f((Runnable)new b.b(paramb), "deleteDaemonMediaFile");
      AppMethodBeat.o(76217);
      return;
    }
    AppMethodBeat.o(76217);
  }
  
  public static void c(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(76204);
    if ((paramCaptureVideoNormalModel == null) || (!paramCaptureVideoNormalModel.dIT().booleanValue()))
    {
      AppMethodBeat.o(76204);
      return;
    }
    e locale = g.ajR();
    p.g(locale, "MMKernel.storage()");
    if (!locale.ajA().getBoolean(am.a.IRU, true))
    {
      AppMethodBeat.o(76204);
      return;
    }
    h.MqF.f((Runnable)new b.m(paramCaptureVideoNormalModel), "mux_save_work");
    AppMethodBeat.o(76204);
  }
  
  public static void d(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76197);
    p.h(paramRecordConfigProvider, "configProvider");
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.xOv))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      p.g(com.tencent.mm.modelvideo.o.aNg(), "SubCoreVideo.getCore()");
      paramRecordConfigProvider.xOv = (com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_output_" + System.currentTimeMillis());
    }
    AppMethodBeat.o(76197);
  }
  
  public static void dLJ()
  {
    AppMethodBeat.i(207137);
    h.MqF.aO((Runnable)a.yhf);
    AppMethodBeat.o(207137);
  }
  
  public static String dLK()
  {
    AppMethodBeat.i(76199);
    p.g(com.tencent.mm.modelvideo.o.aNg(), "SubCoreVideo.getCore()");
    String str = d.arO(com.tencent.mm.modelvideo.o.getAccVideoPath());
    p.g(str, "MMSightUtil.getTempFileN…o.getCore().accVideoPath)");
    AppMethodBeat.o(76199);
    return str;
  }
  
  public static String dLL()
  {
    AppMethodBeat.i(207138);
    p.g(com.tencent.mm.modelvideo.o.aNg(), "SubCoreVideo.getCore()");
    String str = com.tencent.mm.modelvideo.o.aNp();
    p.g(str, "SubCoreVideo.getCore().subVideoPath");
    AppMethodBeat.o(207138);
    return str;
  }
  
  public static String dLM()
  {
    AppMethodBeat.i(76201);
    String str = q.aIX().getFullPath("photoEdited_" + System.currentTimeMillis());
    p.g(str, "SubCoreImage.getImgStg()…stem.currentTimeMillis())");
    AppMethodBeat.o(76201);
    return str;
  }
  
  public static String dLN()
  {
    AppMethodBeat.i(76202);
    String str = q.aIX().getFullPath("photoCapture_" + System.currentTimeMillis());
    p.g(str, "SubCoreImage.getImgStg()…currentTimeMillis() + \"\")");
    AppMethodBeat.o(76202);
    return str;
  }
  
  public static void e(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76198);
    p.h(paramRecordConfigProvider, "configProvider");
    StringBuilder localStringBuilder;
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.thumbPath))
    {
      localStringBuilder = new StringBuilder();
      p.g(com.tencent.mm.modelvideo.o.aNg(), "SubCoreVideo.getCore()");
      paramRecordConfigProvider.thumbPath = (com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_thumb_" + System.currentTimeMillis());
    }
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.xOt))
    {
      localStringBuilder = new StringBuilder();
      p.g(com.tencent.mm.modelvideo.o.aNg(), "SubCoreVideo.getCore()");
      paramRecordConfigProvider.xOt = (com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_output_" + System.currentTimeMillis());
    }
    AppMethodBeat.o(76198);
  }
  
  public static boolean f(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76207);
    ae.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:true  ");
    if (paramRecordConfigProvider != null) {
      h.MqF.f((Runnable)new f(paramRecordConfigProvider), "mux_save_work_daemon");
    }
    AppMethodBeat.o(76207);
    return true;
  }
  
  public static boolean g(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76208);
    ae.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:true  ");
    if (paramRecordConfigProvider != null)
    {
      if (com.tencent.mm.vfs.o.fB(paramRecordConfigProvider.xOs)) {
        com.tencent.mm.vfs.o.mF(paramRecordConfigProvider.xOs, paramRecordConfigProvider.xOt);
      }
      h.MqF.f((Runnable)new i(paramRecordConfigProvider), "handleNoNeedRemuxCaptureVideo");
    }
    AppMethodBeat.o(76208);
    return true;
  }
  
  public static Bitmap h(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(76209);
    p.h(paramBitmap, "bitmap");
    if (paramInt <= 0)
    {
      AppMethodBeat.o(76209);
      return paramBitmap;
    }
    if (Math.min(paramBitmap.getWidth(), paramBitmap.getHeight()) > paramInt)
    {
      int i;
      if (paramBitmap.getWidth() < paramBitmap.getHeight())
      {
        int j = (int)(paramBitmap.getHeight() * paramInt * 1.0F / paramBitmap.getWidth());
        i = paramInt;
        paramInt = j;
      }
      for (;;)
      {
        paramBitmap = Bitmap.createScaledBitmap(paramBitmap, i, paramInt, true);
        p.g(paramBitmap, "Bitmap.createScaledBitma…idth, outputHeight, true)");
        AppMethodBeat.o(76209);
        return paramBitmap;
        i = (int)(paramBitmap.getWidth() * paramInt * 1.0F / paramBitmap.getHeight());
      }
    }
    AppMethodBeat.o(76209);
    return paramBitmap;
  }
  
  public static void iR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76188);
    ae.i("MicroMsg.MediaFileUtil", "cache delete key: " + paramString1 + " , file " + paramString2);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(76188);
      return;
    }
    cCf.encode(paramString1, paramString2);
    AppMethodBeat.o(76188);
  }
  
  public static void iS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76196);
    if ((TextUtils.isEmpty((CharSequence)paramString1)) || (TextUtils.isEmpty((CharSequence)paramString2)))
    {
      AppMethodBeat.o(76196);
      return;
    }
    if (paramString2 == null) {
      p.gkB();
    }
    CharSequence localCharSequence = (CharSequence)paramString2;
    String str = q.aIX().getFullPath("photoEdited_");
    p.g(str, "SubCoreImage.getImgStg()…llPath(PHOTO_EDIT_PREFIX)");
    if (n.a(localCharSequence, (CharSequence)str, false)) {
      iR(paramString1, paramString2);
    }
    AppMethodBeat.o(76196);
  }
  
  private static String iT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76211);
    if (paramString2 == null)
    {
      AppMethodBeat.o(76211);
      return "";
    }
    paramString1 = paramString1 + paramString2 + ".p";
    AppMethodBeat.o(76211);
    return paramString1;
  }
  
  public static String iU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76212);
    if (paramString2 == null)
    {
      AppMethodBeat.o(76212);
      return "";
    }
    paramString1 = paramString1 + paramString2 + ".p";
    AppMethodBeat.o(76212);
    return paramString1;
  }
  
  public static String zp(long paramLong)
  {
    AppMethodBeat.i(76210);
    com.tencent.mm.vfs.o.aZI(yhc);
    String str = yhc + "thumb" + paramLong + ".jpg";
    AppMethodBeat.o(76210);
    return str;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a yhf;
    
    static
    {
      AppMethodBeat.i(207132);
      yhf = new a();
      AppMethodBeat.o(207132);
    }
    
    public final void run()
    {
      AppMethodBeat.i(207131);
      Object localObject1 = b.yhe;
      localObject1 = b.dLO().decodeStringSet("media_file_delete_set", (Set)new HashSet());
      p.g(localObject1, "set");
      Object localObject2 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject2).hasNext()) {
        com.tencent.mm.vfs.o.deleteFile((String)((Iterator)localObject2).next());
      }
      ((Set)localObject1).clear();
      localObject2 = b.yhe;
      b.dLO().encode("media_timing_delete_set", (Set)localObject1);
      AppMethodBeat.o(207131);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(RecordConfigProvider paramRecordConfigProvider) {}
    
    public final void run()
    {
      AppMethodBeat.i(76182);
      Object localObject = g.ajR();
      p.g(localObject, "MMKernel.storage()");
      boolean bool = ((e)localObject).ajA().getBoolean(am.a.IRU, true);
      ae.i("MicroMsg.MediaFileUtil", "handleDaemonNoNeedRemuxCaptureVideo videoState : " + bool + ' ');
      if (bool)
      {
        localObject = d.arS("mp4");
        com.tencent.mm.vfs.o.mF(this.xRW.xOt, (String)localObject);
        com.tencent.mm.sdk.f.b.k((String)localObject, ak.getContext());
      }
      com.tencent.mm.vfs.o.deleteFile(this.xRW.xOs);
      AppMethodBeat.o(76182);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(RecordConfigProvider paramRecordConfigProvider) {}
    
    public final void run()
    {
      AppMethodBeat.i(76183);
      ae.i("MicroMsg.MediaFileUtil", "handleNoNeedRemuxCaptureVideo");
      Object localObject = g.ajR();
      p.g(localObject, "MMKernel.storage()");
      boolean bool = ((e)localObject).ajA().getBoolean(am.a.IRU, true);
      ae.i("MicroMsg.MediaFileUtil", "handleNoNeedRemuxCaptureVideo videoState : " + bool + ' ');
      if (bool)
      {
        localObject = d.arS("mp4");
        com.tencent.mm.vfs.o.mF(this.xRW.xOt, (String)localObject);
        com.tencent.mm.sdk.f.b.k((String)localObject, ak.getContext());
      }
      com.tencent.mm.vfs.o.deleteFile(this.xRW.xOs);
      AppMethodBeat.o(76183);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/util/MediaFileUtil$handleRemuxImage$1$1"})
  static final class j
    implements Runnable
  {
    j(RecordConfigProvider paramRecordConfigProvider1, boolean paramBoolean1, RecordConfigProvider paramRecordConfigProvider2, boolean paramBoolean2) {}
    
    public final void run()
    {
      AppMethodBeat.i(76184);
      if (!this.xRW.xOq) {
        com.tencent.mm.vfs.o.deleteFile(this.xRW.xOu);
      }
      Object localObject = g.ajR();
      p.g(localObject, "MMKernel.storage()");
      boolean bool = ((e)localObject).ajA().getBoolean(am.a.IRT, true);
      ae.i("MicroMsg.MediaFileUtil", "imageState : " + bool + ' ');
      if (!bool)
      {
        AppMethodBeat.o(76184);
        return;
      }
      if (((paramBoolean1) && (bool)) || ((!paramBoolean1) && (paramRecordConfigProvider.xOr) && (paramBoolean2)))
      {
        localObject = d.arS("jpg");
        if (!paramBoolean1) {
          localObject = com.tencent.mm.sdk.f.b.arS("jpg");
        }
        ae.i("MicroMsg.MediaFileUtil", "auto save pic src " + paramRecordConfigProvider.xOv + " dest " + (String)localObject + ' ');
        com.tencent.mm.vfs.o.mF(paramRecordConfigProvider.xOv, (String)localObject);
        com.tencent.mm.sdk.f.b.k((String)localObject, ak.getContext());
      }
      AppMethodBeat.o(76184);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/util/MediaFileUtil$handleRemuxVideo$1$1"})
  static final class k
    implements Runnable
  {
    k(RecordConfigProvider paramRecordConfigProvider1, RecordConfigProvider paramRecordConfigProvider2, boolean paramBoolean1, boolean paramBoolean2) {}
    
    public final void run()
    {
      AppMethodBeat.i(76185);
      if (!paramRecordConfigProvider.xOq) {
        com.tencent.mm.vfs.o.deleteFile(this.xRW.xOs);
      }
      Object localObject = g.ajR();
      p.g(localObject, "MMKernel.storage()");
      boolean bool = ((e)localObject).ajA().getBoolean(am.a.IRU, true);
      ae.i("MicroMsg.MediaFileUtil", "videoState : " + bool + ' ');
      if (!bool)
      {
        AppMethodBeat.o(76185);
        return;
      }
      if ((paramBoolean1) || ((!paramBoolean1) && (paramRecordConfigProvider.xOr) && (paramBoolean2)))
      {
        localObject = d.arS("mp4");
        if (!paramBoolean1) {
          localObject = com.tencent.mm.sdk.f.b.arS("mp4");
        }
        ae.i("MicroMsg.MediaFileUtil", "auto save video :".concat(String.valueOf(localObject)));
        com.tencent.mm.vfs.o.mF(this.xRW.xOt, (String)localObject);
        com.tencent.mm.sdk.f.b.k((String)localObject, ak.getContext());
      }
      AppMethodBeat.o(76185);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/util/MediaFileUtil$handleRemuxVideo$3$1"})
  static final class l
    implements Runnable
  {
    l(aip paramaip) {}
    
    public final void run()
    {
      AppMethodBeat.i(76186);
      if (!this.yhm.xOq) {
        com.tencent.mm.vfs.o.deleteFile(this.yhm.xOs);
      }
      Object localObject = g.ajR();
      p.g(localObject, "MMKernel.storage()");
      if (!((e)localObject).ajA().getBoolean(am.a.IRU, true))
      {
        AppMethodBeat.o(76186);
        return;
      }
      if ((this.yhm.Gyp) || ((!this.yhm.Gyp) && (this.yhm.xOr) && (this.yhm.BUO)))
      {
        localObject = d.arS("mp4");
        if (!this.yhm.Gyp) {
          localObject = com.tencent.mm.sdk.f.b.arS("mp4");
        }
        com.tencent.mm.vfs.o.mF(this.yhm.xOt, (String)localObject);
        com.tencent.mm.sdk.f.b.k((String)localObject, ak.getContext());
      }
      AppMethodBeat.o(76186);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.b
 * JD-Core Version:    0.7.0.1
 */