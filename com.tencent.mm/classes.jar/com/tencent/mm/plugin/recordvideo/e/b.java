package com.tencent.mm.plugin.recordvideo.e;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.g.b.k;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/util/MediaFileUtil;", "", "()V", "MEDIA_FILE_DELETE_SET", "", "MEDIA_FILE_KEY", "MEDIA_TIMING_DELETE_SET", "MIX_AUDIO_FILE", "MIX_BLUR_BG_FILE", "MIX_THUMB_FILE", "MIX_VIDEO_FILE", "PHOTO_EDIT_PREFIX", "PIC_FILE", "TAG", "VIDEO_FILE", "VIDEP_EDOT_PREFIX", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "videoMixPath", "videoRecordRootPath", "videoRecordTempPath", "audioEnsurePath", "parentPath", "mediaId", "checkAndMarkDeletePhotoFile", "", "key", "filePath", "checkConfigProviderCapturePath", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "checkConfigProviderPhotoEditPath", "checkConfigProviderVideoEditPath", "checkThumbSize", "Landroid/graphics/Bitmap;", "bitmap", "shortSide", "", "checkToCreateDir", "newVideoPath", "noMedia", "", "clearTimingFile", "deleteBizFile", "deleteDaemonMediaFile", "mediaCaptureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "deleteFile", "deleteMarkFileByKey", "deleteMarkFilePath", "deleteVideoFileWithCheckPath", "exportVideo", "videoPath", "getAudioTmpPath", "getBlurBgPath", "localId", "getCaptureEditVideoPath", "getCaptureImagePath", "getCaptureThumbPath", "getCaptureVideoPath", "getEditImagePath", "getMixAudioPath", "getMixThumbPath", "getMixVideoPath", "getRecordThumbTempPath", "timeStamp", "", "getSubCaptureVideoParent", "getSubCaptureVideoPath", "handleDaemonNoNeedRemuxCaptureVideo", "isCaptureMedia", "handleMultiPhotoResult", "photoPath", "handleMultiVideoResult", "handleNoNeedRemuxCaptureVideo", "handleRemuxImage", "change", "handleRemuxVideo", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "handleSubRecordMux", "captureInfo", "markDeleteMediaFile", "file", "markDeletePhotoEditFile", "imagePathList", "Ljava/util/ArrayList;", "markTimingDeleteFile", "saveThumb", "thumbPath", "thumbSize", "thumbEnsurePath", "videoEnsurePath", "plugin-recordvideo_release"})
public final class b
{
  private static final aw cqB;
  private static final String wDB;
  private static final String wDC;
  public static final String wDD;
  public static final b wDE;
  
  static
  {
    AppMethodBeat.i(76218);
    wDE = new b();
    StringBuilder localStringBuilder = new StringBuilder();
    e locale = com.tencent.mm.kernel.g.agR();
    k.g(locale, "MMKernel.storage()");
    wDB = locale.getAccPath() + "recordPlugin/";
    wDC = wDB + "temp/";
    wDD = wDB + "mix/";
    cqB = aw.aKT("media_file_key");
    AppMethodBeat.o(76218);
  }
  
  public static void a(final RecordConfigProvider paramRecordConfigProvider, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(76203);
    ac.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:" + paramBoolean1 + "   change:" + paramBoolean2);
    if (paramRecordConfigProvider != null)
    {
      h.JZN.f((Runnable)new k(paramRecordConfigProvider, paramRecordConfigProvider, paramBoolean1, paramBoolean2), "mux_save_work");
      AppMethodBeat.o(76203);
      return;
    }
    AppMethodBeat.o(76203);
  }
  
  public static void a(afq paramafq)
  {
    AppMethodBeat.i(76205);
    if (paramafq != null) {
      h.JZN.f((Runnable)new l(paramafq), "mux_save_work");
    }
    AppMethodBeat.o(76205);
  }
  
  public static void anu(String paramString)
  {
    AppMethodBeat.i(76192);
    if (!TextUtils.isEmpty((CharSequence)paramString)) {
      h.JZN.f((Runnable)new b.c(paramString), "MediaFileUtil_deleteMediaFile");
    }
    AppMethodBeat.o(76192);
  }
  
  public static void aqP(String paramString)
  {
    AppMethodBeat.i(199452);
    ac.i("MicroMsg.MediaFileUtil", "markTimingDeleteFile file ".concat(String.valueOf(paramString)));
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(199452);
      return;
    }
    Set localSet = cqB.decodeStringSet("media_timing_delete_set", (Set)new HashSet());
    localSet.add(paramString);
    cqB.encode("media_timing_delete_set", localSet);
    AppMethodBeat.o(199452);
  }
  
  public static void aqQ(String paramString)
  {
    AppMethodBeat.i(76189);
    if (paramString != null)
    {
      paramString = cqB.decodeString(paramString, "");
      if (!TextUtils.isEmpty((CharSequence)paramString)) {
        h.JZN.f((Runnable)new b.d(paramString), "MediaFileUtil_deleteMediaFile");
      }
    }
    AppMethodBeat.o(76189);
  }
  
  public static void aqR(String paramString)
  {
    AppMethodBeat.i(76190);
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      ac.i("MicroMsg.MediaFileUtil", "cache delete file ".concat(String.valueOf(paramString)));
      Set localSet = cqB.decodeStringSet("media_file_delete_set", (Set)new HashSet());
      localSet.add(paramString);
      cqB.encode("media_file_delete_set", localSet);
    }
    AppMethodBeat.o(76190);
  }
  
  public static void aqS(String paramString)
  {
    AppMethodBeat.i(76191);
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      Set localSet = cqB.decodeStringSet("media_file_delete_set", (Set)new HashSet());
      if (localSet.contains(paramString))
      {
        localSet.remove(paramString);
        if (!TextUtils.isEmpty((CharSequence)paramString)) {
          h.JZN.f((Runnable)new b.e(paramString), "MediaFileUtil_deleteMediaFile");
        }
      }
    }
    AppMethodBeat.o(76191);
  }
  
  public static void aqT(String paramString)
  {
    AppMethodBeat.i(76193);
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      if (paramString == null) {
        break label69;
      }
      CharSequence localCharSequence = (CharSequence)paramString;
      k.g(com.tencent.mm.modelvideo.o.aJx(), "SubCoreVideo.getCore()");
      String str = com.tencent.mm.modelvideo.o.getAccVideoPath();
      k.g(str, "SubCoreVideo.getCore().accVideoPath");
      if (n.a(localCharSequence, (CharSequence)str, false) == true) {
        anu(paramString);
      }
    }
    AppMethodBeat.o(76193);
    return;
    label69:
    AppMethodBeat.o(76193);
  }
  
  public static void aqU(String paramString)
  {
    AppMethodBeat.i(76195);
    if (paramString != null)
    {
      CharSequence localCharSequence = (CharSequence)paramString;
      String str = com.tencent.mm.av.o.aFx().getFullPath("photoEdited_");
      k.g(str, "SubCoreImage.getImgStg()…llPath(PHOTO_EDIT_PREFIX)");
      if (n.a(localCharSequence, (CharSequence)str, false) == true)
      {
        ac.i("MicroMsg.MediaFileUtil", "markDeletePhotoEditFile: ".concat(String.valueOf(paramString)));
        aqR(paramString);
      }
      AppMethodBeat.o(76195);
      return;
    }
    AppMethodBeat.o(76195);
  }
  
  public static String aqV(String paramString)
  {
    AppMethodBeat.i(76200);
    k.h(paramString, "videoPath");
    paramString = d.alW(paramString);
    k.g(paramString, "MMSightUtil.getThumbName(videoPath)");
    AppMethodBeat.o(76200);
    return paramString;
  }
  
  public static void aqW(String paramString)
  {
    AppMethodBeat.i(199455);
    if ((!TextUtils.isEmpty((CharSequence)paramString)) && (com.tencent.mm.vfs.i.eA(paramString))) {
      h.JZN.aS((Runnable)new b.h(paramString));
    }
    AppMethodBeat.o(199455);
  }
  
  public static void aqX(String paramString)
  {
    AppMethodBeat.i(199456);
    if ((!TextUtils.isEmpty((CharSequence)paramString)) && (com.tencent.mm.vfs.i.eA(paramString))) {
      h.JZN.aS((Runnable)new b.g(paramString));
    }
    AppMethodBeat.o(199456);
  }
  
  public static String aqY(String paramString)
  {
    AppMethodBeat.i(76213);
    if (paramString == null)
    {
      AppMethodBeat.o(76213);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String str = wDD;
    if (paramString == null) {}
    for (paramString = "";; paramString = str + paramString + ".v")
    {
      paramString = paramString + ".mixv";
      AppMethodBeat.o(76213);
      return paramString;
    }
  }
  
  public static String aqZ(String paramString)
  {
    AppMethodBeat.i(76214);
    if (paramString == null)
    {
      AppMethodBeat.o(76214);
      return "";
    }
    paramString = iA(wDD, paramString) + ".mixt";
    AppMethodBeat.o(76214);
    return paramString;
  }
  
  public static String ara(String paramString)
  {
    AppMethodBeat.i(163472);
    if (paramString == null)
    {
      AppMethodBeat.o(163472);
      return "";
    }
    paramString = iA(wDD, paramString) + ".blurt";
    AppMethodBeat.o(163472);
    return paramString;
  }
  
  public static void arb(String paramString)
  {
    AppMethodBeat.i(76215);
    k.h(paramString, "newVideoPath");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(76215);
      return;
    }
    paramString = com.tencent.mm.vfs.i.aSs(paramString);
    com.tencent.mm.vfs.i.aSh(paramString);
    com.tencent.mm.vfs.i.aSv(paramString);
    AppMethodBeat.o(76215);
  }
  
  public static void av(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(76194);
    k.h(paramArrayList, "imagePathList");
    paramArrayList = ((Iterable)paramArrayList).iterator();
    while (paramArrayList.hasNext())
    {
      String str1 = (String)paramArrayList.next();
      if (str1 != null)
      {
        CharSequence localCharSequence = (CharSequence)str1;
        String str2 = com.tencent.mm.av.o.aFx().getFullPath("photoEdited_");
        k.g(str2, "SubCoreImage.getImgStg()…llPath(PHOTO_EDIT_PREFIX)");
        if (n.a(localCharSequence, (CharSequence)str2, false) == true)
        {
          ac.i("MicroMsg.MediaFileUtil", "markDeletePhotoEditFile: ".concat(String.valueOf(str1)));
          aqR(str1);
        }
      }
    }
    AppMethodBeat.o(76194);
  }
  
  public static void b(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(199457);
    if (paramb != null)
    {
      if (paramb.hbH == true) {
        h.JZN.aS((Runnable)new b.n(paramb));
      }
      AppMethodBeat.o(199457);
      return;
    }
    AppMethodBeat.o(199457);
  }
  
  public static void b(final RecordConfigProvider paramRecordConfigProvider, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(76206);
    ac.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:" + paramBoolean1 + "   change:" + paramBoolean2);
    if (paramRecordConfigProvider != null)
    {
      h.JZN.f((Runnable)new j(paramRecordConfigProvider, paramBoolean1, paramRecordConfigProvider, paramBoolean2), "mux_save_work");
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
      h.JZN.f((Runnable)new b(paramb), "deleteDaemonMediaFile");
      AppMethodBeat.o(76217);
      return;
    }
    AppMethodBeat.o(76217);
  }
  
  public static void c(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(76204);
    if ((paramCaptureVideoNormalModel == null) || (!paramCaptureVideoNormalModel.dvh().booleanValue()))
    {
      AppMethodBeat.o(76204);
      return;
    }
    e locale = com.tencent.mm.kernel.g.agR();
    k.g(locale, "MMKernel.storage()");
    if (!locale.agA().getBoolean(ah.a.GLe, true))
    {
      AppMethodBeat.o(76204);
      return;
    }
    h.JZN.f((Runnable)new m(paramCaptureVideoNormalModel), "mux_save_work");
    AppMethodBeat.o(76204);
  }
  
  public static void d(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76197);
    k.h(paramRecordConfigProvider, "configProvider");
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.wqI))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      k.g(com.tencent.mm.modelvideo.o.aJx(), "SubCoreVideo.getCore()");
      paramRecordConfigProvider.wqI = (com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_output_" + System.currentTimeMillis());
    }
    AppMethodBeat.o(76197);
  }
  
  public static void dxa()
  {
    AppMethodBeat.i(199453);
    h.JZN.aS((Runnable)a.wDF);
    AppMethodBeat.o(199453);
  }
  
  public static String dxb()
  {
    AppMethodBeat.i(76199);
    k.g(com.tencent.mm.modelvideo.o.aJx(), "SubCoreVideo.getCore()");
    String str = d.alU(com.tencent.mm.modelvideo.o.getAccVideoPath());
    k.g(str, "MMSightUtil.getTempFileN…o.getCore().accVideoPath)");
    AppMethodBeat.o(76199);
    return str;
  }
  
  public static String dxc()
  {
    AppMethodBeat.i(199454);
    k.g(com.tencent.mm.modelvideo.o.aJx(), "SubCoreVideo.getCore()");
    String str = com.tencent.mm.modelvideo.o.aJG();
    k.g(str, "SubCoreVideo.getCore().subVideoPath");
    AppMethodBeat.o(199454);
    return str;
  }
  
  public static String dxd()
  {
    AppMethodBeat.i(76201);
    String str = com.tencent.mm.av.o.aFx().getFullPath("photoEdited_" + System.currentTimeMillis());
    k.g(str, "SubCoreImage.getImgStg()…stem.currentTimeMillis())");
    AppMethodBeat.o(76201);
    return str;
  }
  
  public static String dxe()
  {
    AppMethodBeat.i(76202);
    String str = com.tencent.mm.av.o.aFx().getFullPath("photoCapture_" + System.currentTimeMillis());
    k.g(str, "SubCoreImage.getImgStg()…currentTimeMillis() + \"\")");
    AppMethodBeat.o(76202);
    return str;
  }
  
  public static void e(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76198);
    k.h(paramRecordConfigProvider, "configProvider");
    StringBuilder localStringBuilder;
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.thumbPath))
    {
      localStringBuilder = new StringBuilder();
      k.g(com.tencent.mm.modelvideo.o.aJx(), "SubCoreVideo.getCore()");
      paramRecordConfigProvider.thumbPath = (com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_thumb_" + System.currentTimeMillis());
    }
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.wqG))
    {
      localStringBuilder = new StringBuilder();
      k.g(com.tencent.mm.modelvideo.o.aJx(), "SubCoreVideo.getCore()");
      paramRecordConfigProvider.wqG = (com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_output_" + System.currentTimeMillis());
    }
    AppMethodBeat.o(76198);
  }
  
  public static boolean f(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76207);
    ac.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:true  ");
    if (paramRecordConfigProvider != null) {
      h.JZN.f((Runnable)new f(paramRecordConfigProvider), "mux_save_work_daemon");
    }
    AppMethodBeat.o(76207);
    return true;
  }
  
  public static boolean g(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76208);
    ac.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:true  ");
    if (paramRecordConfigProvider != null)
    {
      if (com.tencent.mm.vfs.i.eA(paramRecordConfigProvider.wqF)) {
        com.tencent.mm.vfs.i.lZ(paramRecordConfigProvider.wqF, paramRecordConfigProvider.wqG);
      }
      h.JZN.f((Runnable)new i(paramRecordConfigProvider), "handleNoNeedRemuxCaptureVideo");
    }
    AppMethodBeat.o(76208);
    return true;
  }
  
  public static Bitmap h(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(76209);
    k.h(paramBitmap, "bitmap");
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
        k.g(paramBitmap, "Bitmap.createScaledBitma…idth, outputHeight, true)");
        AppMethodBeat.o(76209);
        return paramBitmap;
        i = (int)(paramBitmap.getWidth() * paramInt * 1.0F / paramBitmap.getHeight());
      }
    }
    AppMethodBeat.o(76209);
    return paramBitmap;
  }
  
  private static String iA(String paramString1, String paramString2)
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
  
  public static String iB(String paramString1, String paramString2)
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
  
  public static void iy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76188);
    ac.i("MicroMsg.MediaFileUtil", "cache delete key: " + paramString1 + " , file " + paramString2);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(76188);
      return;
    }
    cqB.encode(paramString1, paramString2);
    AppMethodBeat.o(76188);
  }
  
  public static void iz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76196);
    if ((TextUtils.isEmpty((CharSequence)paramString1)) || (TextUtils.isEmpty((CharSequence)paramString2)))
    {
      AppMethodBeat.o(76196);
      return;
    }
    if (paramString2 == null) {
      k.fOy();
    }
    CharSequence localCharSequence = (CharSequence)paramString2;
    String str = com.tencent.mm.av.o.aFx().getFullPath("photoEdited_");
    k.g(str, "SubCoreImage.getImgStg()…llPath(PHOTO_EDIT_PREFIX)");
    if (n.a(localCharSequence, (CharSequence)str, false)) {
      iy(paramString1, paramString2);
    }
    AppMethodBeat.o(76196);
  }
  
  public static String wx(long paramLong)
  {
    AppMethodBeat.i(76210);
    com.tencent.mm.vfs.i.aSh(wDC);
    String str = wDC + "thumb" + paramLong + ".jpg";
    AppMethodBeat.o(76210);
    return str;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a wDF;
    
    static
    {
      AppMethodBeat.i(199448);
      wDF = new a();
      AppMethodBeat.o(199448);
    }
    
    public final void run()
    {
      AppMethodBeat.i(199447);
      Object localObject1 = b.wDE;
      localObject1 = b.dxf().decodeStringSet("media_file_delete_set", (Set)new HashSet());
      k.g(localObject1, "set");
      Object localObject2 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject2).hasNext()) {
        com.tencent.mm.vfs.i.deleteFile((String)((Iterator)localObject2).next());
      }
      ((Set)localObject1).clear();
      localObject2 = b.wDE;
      b.dxf().encode("media_timing_delete_set", (Set)localObject1);
      AppMethodBeat.o(199447);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(com.tencent.mm.media.widget.camerarecordview.b.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(76178);
      ac.i("MicroMsg.MediaFileUtil", "deleteDaemonMediaFile");
      com.tencent.mm.vfs.i.deleteFile(this.wDG.hbJ);
      com.tencent.mm.vfs.i.deleteFile(this.wDG.hbK);
      AppMethodBeat.o(76178);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(RecordConfigProvider paramRecordConfigProvider) {}
    
    public final void run()
    {
      AppMethodBeat.i(76182);
      Object localObject = com.tencent.mm.kernel.g.agR();
      k.g(localObject, "MMKernel.storage()");
      boolean bool = ((e)localObject).agA().getBoolean(ah.a.GLe, true);
      ac.i("MicroMsg.MediaFileUtil", "handleDaemonNoNeedRemuxCaptureVideo videoState : " + bool + ' ');
      if (bool)
      {
        localObject = d.alY("mp4");
        com.tencent.mm.vfs.i.lZ(this.wuf.wqG, (String)localObject);
        com.tencent.mm.sdk.f.b.k((String)localObject, ai.getContext());
      }
      com.tencent.mm.vfs.i.deleteFile(this.wuf.wqF);
      AppMethodBeat.o(76182);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(RecordConfigProvider paramRecordConfigProvider) {}
    
    public final void run()
    {
      AppMethodBeat.i(76183);
      ac.i("MicroMsg.MediaFileUtil", "handleNoNeedRemuxCaptureVideo");
      Object localObject = com.tencent.mm.kernel.g.agR();
      k.g(localObject, "MMKernel.storage()");
      boolean bool = ((e)localObject).agA().getBoolean(ah.a.GLe, true);
      ac.i("MicroMsg.MediaFileUtil", "handleNoNeedRemuxCaptureVideo videoState : " + bool + ' ');
      if (bool)
      {
        localObject = d.alY("mp4");
        com.tencent.mm.vfs.i.lZ(this.wuf.wqG, (String)localObject);
        com.tencent.mm.sdk.f.b.k((String)localObject, ai.getContext());
      }
      com.tencent.mm.vfs.i.deleteFile(this.wuf.wqF);
      AppMethodBeat.o(76183);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/util/MediaFileUtil$handleRemuxImage$1$1"})
  static final class j
    implements Runnable
  {
    j(RecordConfigProvider paramRecordConfigProvider1, boolean paramBoolean1, RecordConfigProvider paramRecordConfigProvider2, boolean paramBoolean2) {}
    
    public final void run()
    {
      AppMethodBeat.i(76184);
      if (!this.wuf.wqD) {
        com.tencent.mm.vfs.i.deleteFile(this.wuf.wqH);
      }
      Object localObject = com.tencent.mm.kernel.g.agR();
      k.g(localObject, "MMKernel.storage()");
      boolean bool = ((e)localObject).agA().getBoolean(ah.a.GLd, true);
      ac.i("MicroMsg.MediaFileUtil", "imageState : " + bool + ' ');
      if (!bool)
      {
        AppMethodBeat.o(76184);
        return;
      }
      if (((paramBoolean1) && (bool)) || ((!paramBoolean1) && (paramRecordConfigProvider.wqE) && (paramBoolean2)))
      {
        localObject = d.alY("jpg");
        if (!paramBoolean1) {
          localObject = com.tencent.mm.sdk.f.b.alY("jpg");
        }
        ac.i("MicroMsg.MediaFileUtil", "auto save pic src " + paramRecordConfigProvider.wqI + " dest " + (String)localObject + ' ');
        com.tencent.mm.vfs.i.lZ(paramRecordConfigProvider.wqI, (String)localObject);
        com.tencent.mm.sdk.f.b.k((String)localObject, ai.getContext());
      }
      AppMethodBeat.o(76184);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/util/MediaFileUtil$handleRemuxVideo$1$1"})
  static final class k
    implements Runnable
  {
    k(RecordConfigProvider paramRecordConfigProvider1, RecordConfigProvider paramRecordConfigProvider2, boolean paramBoolean1, boolean paramBoolean2) {}
    
    public final void run()
    {
      AppMethodBeat.i(76185);
      if (!paramRecordConfigProvider.wqD) {
        com.tencent.mm.vfs.i.deleteFile(this.wuf.wqF);
      }
      Object localObject = com.tencent.mm.kernel.g.agR();
      k.g(localObject, "MMKernel.storage()");
      boolean bool = ((e)localObject).agA().getBoolean(ah.a.GLe, true);
      ac.i("MicroMsg.MediaFileUtil", "videoState : " + bool + ' ');
      if (!bool)
      {
        AppMethodBeat.o(76185);
        return;
      }
      if ((paramBoolean1) || ((!paramBoolean1) && (paramRecordConfigProvider.wqE) && (paramBoolean2)))
      {
        localObject = d.alY("mp4");
        if (!paramBoolean1) {
          localObject = com.tencent.mm.sdk.f.b.alY("mp4");
        }
        ac.i("MicroMsg.MediaFileUtil", "auto save video :".concat(String.valueOf(localObject)));
        com.tencent.mm.vfs.i.lZ(this.wuf.wqG, (String)localObject);
        com.tencent.mm.sdk.f.b.k((String)localObject, ai.getContext());
      }
      AppMethodBeat.o(76185);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/util/MediaFileUtil$handleRemuxVideo$3$1"})
  static final class l
    implements Runnable
  {
    l(afq paramafq) {}
    
    public final void run()
    {
      AppMethodBeat.i(76186);
      if (!this.wDM.wqD) {
        com.tencent.mm.vfs.i.deleteFile(this.wDM.wqF);
      }
      Object localObject = com.tencent.mm.kernel.g.agR();
      k.g(localObject, "MMKernel.storage()");
      if (!((e)localObject).agA().getBoolean(ah.a.GLe, true))
      {
        AppMethodBeat.o(76186);
        return;
      }
      if ((this.wDM.Eya) || ((!this.wDM.Eya) && (this.wDM.wqE) && (this.wDM.AlF)))
      {
        localObject = d.alY("mp4");
        if (!this.wDM.Eya) {
          localObject = com.tencent.mm.sdk.f.b.alY("mp4");
        }
        com.tencent.mm.vfs.i.lZ(this.wDM.wqG, (String)localObject);
        com.tencent.mm.sdk.f.b.k((String)localObject, ai.getContext());
      }
      AppMethodBeat.o(76186);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    m(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel) {}
    
    public final void run()
    {
      AppMethodBeat.i(76187);
      String str = com.tencent.mm.sdk.f.b.alY("mp4");
      com.tencent.mm.vfs.i.lZ(this.wmg.getVideoPath(), str);
      com.tencent.mm.sdk.f.b.k(str, ai.getContext());
      AppMethodBeat.o(76187);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.b
 * JD-Core Version:    0.7.0.1
 */