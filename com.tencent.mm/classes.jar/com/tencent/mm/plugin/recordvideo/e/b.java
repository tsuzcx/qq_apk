package com.tencent.mm.plugin.recordvideo.e;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.protocal.protobuf.aer;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.g.b.k;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/util/MediaFileUtil;", "", "()V", "MEDIA_FILE_DELETE_SET", "", "MEDIA_FILE_KEY", "MEDIA_TIMING_DELETE_SET", "MIX_AUDIO_FILE", "MIX_BLUR_BG_FILE", "MIX_THUMB_FILE", "MIX_VIDEO_FILE", "PHOTO_EDIT_PREFIX", "PIC_FILE", "TAG", "VIDEO_FILE", "VIDEP_EDOT_PREFIX", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "videoMixPath", "videoRecordRootPath", "videoRecordTempPath", "audioEnsurePath", "parentPath", "mediaId", "checkAndMarkDeletePhotoFile", "", "key", "filePath", "checkConfigProviderCapturePath", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "checkConfigProviderPhotoEditPath", "checkConfigProviderVideoEditPath", "checkThumbSize", "Landroid/graphics/Bitmap;", "bitmap", "shortSide", "", "checkToCreateDir", "newVideoPath", "noMedia", "", "clearTimingFile", "deleteBizFile", "deleteDaemonMediaFile", "mediaCaptureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "deleteFile", "deleteMarkFileByKey", "deleteMarkFilePath", "deleteVideoFileWithCheckPath", "exportVideo", "videoPath", "getAudioTmpPath", "getBlurBgPath", "localId", "getCaptureEditVideoPath", "getCaptureImagePath", "getCaptureThumbPath", "getCaptureVideoPath", "getEditImagePath", "getMixAudioPath", "getMixThumbPath", "getMixVideoPath", "getRecordThumbTempPath", "timeStamp", "", "getSubCaptureVideoParent", "getSubCaptureVideoPath", "handleDaemonNoNeedRemuxCaptureVideo", "isCaptureMedia", "handleMultiPhotoResult", "photoPath", "handleMultiVideoResult", "handleNoNeedRemuxCaptureVideo", "handleRemuxImage", "change", "handleRemuxVideo", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "handleSubRecordMux", "captureInfo", "markDeleteMediaFile", "file", "markDeletePhotoEditFile", "imagePathList", "Ljava/util/ArrayList;", "markTimingDeleteFile", "saveThumb", "thumbPath", "thumbSize", "thumbEnsurePath", "videoEnsurePath", "plugin-recordvideo_release"})
public final class b
{
  private static final ax ctt;
  private static final String vtB;
  private static final String vtC;
  public static final String vtD;
  public static final b vtE;
  
  static
  {
    AppMethodBeat.i(76218);
    vtE = new b();
    StringBuilder localStringBuilder = new StringBuilder();
    e locale = com.tencent.mm.kernel.g.afB();
    k.g(locale, "MMKernel.storage()");
    vtB = locale.getAccPath() + "recordPlugin/";
    vtC = vtB + "temp/";
    vtD = vtB + "mix/";
    ctt = ax.aFC("media_file_key");
    AppMethodBeat.o(76218);
  }
  
  public static void a(final RecordConfigProvider paramRecordConfigProvider, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(76203);
    ad.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:" + paramBoolean1 + "   change:" + paramBoolean2);
    if (paramRecordConfigProvider != null)
    {
      h.Iye.f((Runnable)new h(paramRecordConfigProvider, paramRecordConfigProvider, paramBoolean1, paramBoolean2), "mux_save_work");
      AppMethodBeat.o(76203);
      return;
    }
    AppMethodBeat.o(76203);
  }
  
  public static void a(aer paramaer)
  {
    AppMethodBeat.i(76205);
    if (paramaer != null) {
      h.Iye.f((Runnable)new i(paramaer), "mux_save_work");
    }
    AppMethodBeat.o(76205);
  }
  
  public static void aVM(String paramString)
  {
    AppMethodBeat.i(204332);
    ad.i("MicroMsg.MediaFileUtil", "markTimingDeleteFile file ".concat(String.valueOf(paramString)));
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(204332);
      return;
    }
    Set localSet = ctt.decodeStringSet("media_timing_delete_set", (Set)new HashSet());
    localSet.add(paramString);
    ctt.encode("media_timing_delete_set", localSet);
    AppMethodBeat.o(204332);
  }
  
  public static void aVN(String paramString)
  {
    AppMethodBeat.i(204335);
    if ((!TextUtils.isEmpty((CharSequence)paramString)) && (com.tencent.mm.vfs.i.eK(paramString))) {
      h.Iye.aP((Runnable)new b.m(paramString));
    }
    AppMethodBeat.o(204335);
  }
  
  public static void aVO(String paramString)
  {
    AppMethodBeat.i(204336);
    if ((!TextUtils.isEmpty((CharSequence)paramString)) && (com.tencent.mm.vfs.i.eK(paramString))) {
      h.Iye.aP((Runnable)new b.l(paramString));
    }
    AppMethodBeat.o(204336);
  }
  
  public static void aiz(String paramString)
  {
    AppMethodBeat.i(76192);
    if (!TextUtils.isEmpty((CharSequence)paramString)) {
      h.Iye.f((Runnable)new b.b(paramString), "MediaFileUtil_deleteMediaFile");
    }
    AppMethodBeat.o(76192);
  }
  
  public static void aj(ArrayList<String> paramArrayList)
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
        String str2 = com.tencent.mm.aw.o.ayF().getFullPath("photoEdited_");
        k.g(str2, "SubCoreImage.getImgStg()…llPath(PHOTO_EDIT_PREFIX)");
        if (n.a(localCharSequence, (CharSequence)str2, false) == true)
        {
          ad.i("MicroMsg.MediaFileUtil", "markDeletePhotoEditFile: ".concat(String.valueOf(str1)));
          alQ(str1);
        }
      }
    }
    AppMethodBeat.o(76194);
  }
  
  public static void alP(String paramString)
  {
    AppMethodBeat.i(76189);
    if (paramString != null)
    {
      paramString = ctt.decodeString(paramString, "");
      if (!TextUtils.isEmpty((CharSequence)paramString)) {
        h.Iye.f((Runnable)new b.c(paramString), "MediaFileUtil_deleteMediaFile");
      }
    }
    AppMethodBeat.o(76189);
  }
  
  public static void alQ(String paramString)
  {
    AppMethodBeat.i(76190);
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      ad.i("MicroMsg.MediaFileUtil", "cache delete file ".concat(String.valueOf(paramString)));
      Set localSet = ctt.decodeStringSet("media_file_delete_set", (Set)new HashSet());
      localSet.add(paramString);
      ctt.encode("media_file_delete_set", localSet);
    }
    AppMethodBeat.o(76190);
  }
  
  public static void alR(String paramString)
  {
    AppMethodBeat.i(76191);
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      Set localSet = ctt.decodeStringSet("media_file_delete_set", (Set)new HashSet());
      if (localSet.contains(paramString))
      {
        localSet.remove(paramString);
        if (!TextUtils.isEmpty((CharSequence)paramString)) {
          h.Iye.f((Runnable)new b.d(paramString), "MediaFileUtil_deleteMediaFile");
        }
      }
    }
    AppMethodBeat.o(76191);
  }
  
  public static void alS(String paramString)
  {
    AppMethodBeat.i(76193);
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      if (paramString == null) {
        break label69;
      }
      CharSequence localCharSequence = (CharSequence)paramString;
      k.g(com.tencent.mm.modelvideo.o.aCH(), "SubCoreVideo.getCore()");
      String str = com.tencent.mm.modelvideo.o.getAccVideoPath();
      k.g(str, "SubCoreVideo.getCore().accVideoPath");
      if (n.a(localCharSequence, (CharSequence)str, false) == true) {
        aiz(paramString);
      }
    }
    AppMethodBeat.o(76193);
    return;
    label69:
    AppMethodBeat.o(76193);
  }
  
  public static void alT(String paramString)
  {
    AppMethodBeat.i(76195);
    if (paramString != null)
    {
      CharSequence localCharSequence = (CharSequence)paramString;
      String str = com.tencent.mm.aw.o.ayF().getFullPath("photoEdited_");
      k.g(str, "SubCoreImage.getImgStg()…llPath(PHOTO_EDIT_PREFIX)");
      if (n.a(localCharSequence, (CharSequence)str, false) == true)
      {
        ad.i("MicroMsg.MediaFileUtil", "markDeletePhotoEditFile: ".concat(String.valueOf(paramString)));
        alQ(paramString);
      }
      AppMethodBeat.o(76195);
      return;
    }
    AppMethodBeat.o(76195);
  }
  
  public static String alU(String paramString)
  {
    AppMethodBeat.i(76200);
    k.h(paramString, "videoPath");
    paramString = d.ahb(paramString);
    k.g(paramString, "MMSightUtil.getThumbName(videoPath)");
    AppMethodBeat.o(76200);
    return paramString;
  }
  
  public static String alV(String paramString)
  {
    AppMethodBeat.i(76213);
    if (paramString == null)
    {
      AppMethodBeat.o(76213);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String str = vtD;
    if (paramString == null) {}
    for (paramString = "";; paramString = str + paramString + ".v")
    {
      paramString = paramString + ".mixv";
      AppMethodBeat.o(76213);
      return paramString;
    }
  }
  
  public static String alW(String paramString)
  {
    AppMethodBeat.i(76214);
    if (paramString == null)
    {
      AppMethodBeat.o(76214);
      return "";
    }
    paramString = ih(vtD, paramString) + ".mixt";
    AppMethodBeat.o(76214);
    return paramString;
  }
  
  public static String alX(String paramString)
  {
    AppMethodBeat.i(163472);
    if (paramString == null)
    {
      AppMethodBeat.o(163472);
      return "";
    }
    paramString = ih(vtD, paramString) + ".blurt";
    AppMethodBeat.o(163472);
    return paramString;
  }
  
  public static void alY(String paramString)
  {
    AppMethodBeat.i(76215);
    k.h(paramString, "newVideoPath");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(76215);
      return;
    }
    paramString = com.tencent.mm.vfs.i.aMQ(paramString);
    com.tencent.mm.vfs.i.aMF(paramString);
    com.tencent.mm.vfs.i.aMT(paramString);
    AppMethodBeat.o(76215);
  }
  
  public static void b(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(76217);
    if (paramb != null)
    {
      h.Iye.f((Runnable)new a(paramb), "deleteDaemonMediaFile");
      AppMethodBeat.o(76217);
      return;
    }
    AppMethodBeat.o(76217);
  }
  
  public static void b(final RecordConfigProvider paramRecordConfigProvider, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(76206);
    ad.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:" + paramBoolean1 + "   change:" + paramBoolean2);
    if (paramRecordConfigProvider != null)
    {
      h.Iye.f((Runnable)new g(paramRecordConfigProvider, paramBoolean1, paramRecordConfigProvider, paramBoolean2), "mux_save_work");
      AppMethodBeat.o(76206);
      return;
    }
    AppMethodBeat.o(76206);
  }
  
  public static void c(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(204337);
    if (paramb != null)
    {
      if (paramb.gBl == true) {
        h.Iye.aP((Runnable)new b.n(paramb));
      }
      AppMethodBeat.o(204337);
      return;
    }
    AppMethodBeat.o(204337);
  }
  
  public static void c(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76197);
    k.h(paramRecordConfigProvider, "configProvider");
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.vhW))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      k.g(com.tencent.mm.modelvideo.o.aCH(), "SubCoreVideo.getCore()");
      paramRecordConfigProvider.vhW = (com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_output_" + System.currentTimeMillis());
    }
    AppMethodBeat.o(76197);
  }
  
  public static void d(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(76204);
    if ((paramCaptureVideoNormalModel == null) || (!paramCaptureVideoNormalModel.dhA().booleanValue()))
    {
      AppMethodBeat.o(76204);
      return;
    }
    e locale = com.tencent.mm.kernel.g.afB();
    k.g(locale, "MMKernel.storage()");
    if (!locale.afk().getBoolean(ae.a.Fnp, true))
    {
      AppMethodBeat.o(76204);
      return;
    }
    h.Iye.f((Runnable)new j(paramCaptureVideoNormalModel), "mux_save_work");
    AppMethodBeat.o(76204);
  }
  
  public static void d(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76198);
    k.h(paramRecordConfigProvider, "configProvider");
    StringBuilder localStringBuilder;
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.thumbPath))
    {
      localStringBuilder = new StringBuilder();
      k.g(com.tencent.mm.modelvideo.o.aCH(), "SubCoreVideo.getCore()");
      paramRecordConfigProvider.thumbPath = (com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_thumb_" + System.currentTimeMillis());
    }
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.vhU))
    {
      localStringBuilder = new StringBuilder();
      k.g(com.tencent.mm.modelvideo.o.aCH(), "SubCoreVideo.getCore()");
      paramRecordConfigProvider.vhU = (com.tencent.mm.modelvideo.o.getAccVideoPath() + "vsg_output_" + System.currentTimeMillis());
    }
    AppMethodBeat.o(76198);
  }
  
  public static String djd()
  {
    AppMethodBeat.i(76199);
    k.g(com.tencent.mm.modelvideo.o.aCH(), "SubCoreVideo.getCore()");
    String str = d.agZ(com.tencent.mm.modelvideo.o.getAccVideoPath());
    k.g(str, "MMSightUtil.getTempFileN…o.getCore().accVideoPath)");
    AppMethodBeat.o(76199);
    return str;
  }
  
  public static String dje()
  {
    AppMethodBeat.i(76201);
    String str = com.tencent.mm.aw.o.ayF().getFullPath("photoEdited_" + System.currentTimeMillis());
    k.g(str, "SubCoreImage.getImgStg()…stem.currentTimeMillis())");
    AppMethodBeat.o(76201);
    return str;
  }
  
  public static String djf()
  {
    AppMethodBeat.i(76202);
    String str = com.tencent.mm.aw.o.ayF().getFullPath("photoCapture_" + System.currentTimeMillis());
    k.g(str, "SubCoreImage.getImgStg()…currentTimeMillis() + \"\")");
    AppMethodBeat.o(76202);
    return str;
  }
  
  public static boolean e(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76207);
    ad.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:true  ");
    if (paramRecordConfigProvider != null) {
      h.Iye.f((Runnable)new e(paramRecordConfigProvider), "mux_save_work_daemon");
    }
    AppMethodBeat.o(76207);
    return true;
  }
  
  public static boolean f(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76208);
    ad.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:true  ");
    if (paramRecordConfigProvider != null)
    {
      if (com.tencent.mm.vfs.i.eK(paramRecordConfigProvider.vhT)) {
        com.tencent.mm.vfs.i.lC(paramRecordConfigProvider.vhT, paramRecordConfigProvider.vhU);
      }
      h.Iye.f((Runnable)new f(paramRecordConfigProvider), "handleNoNeedRemuxCaptureVideo");
    }
    AppMethodBeat.o(76208);
    return true;
  }
  
  public static void fYv()
  {
    AppMethodBeat.i(204333);
    h.Iye.aP((Runnable)b.k.LpT);
    AppMethodBeat.o(204333);
  }
  
  public static String fYw()
  {
    AppMethodBeat.i(204334);
    k.g(com.tencent.mm.modelvideo.o.aCH(), "SubCoreVideo.getCore()");
    String str = com.tencent.mm.modelvideo.o.fQN();
    k.g(str, "SubCoreVideo.getCore().subVideoPath");
    AppMethodBeat.o(204334);
    return str;
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
  
  public static void jdMethod_if(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76188);
    ad.i("MicroMsg.MediaFileUtil", "cache delete key: " + paramString1 + " , file " + paramString2);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(76188);
      return;
    }
    ctt.encode(paramString1, paramString2);
    AppMethodBeat.o(76188);
  }
  
  public static void ig(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76196);
    if ((TextUtils.isEmpty((CharSequence)paramString1)) || (TextUtils.isEmpty((CharSequence)paramString2)))
    {
      AppMethodBeat.o(76196);
      return;
    }
    if (paramString2 == null) {
      k.fvU();
    }
    CharSequence localCharSequence = (CharSequence)paramString2;
    String str = com.tencent.mm.aw.o.ayF().getFullPath("photoEdited_");
    k.g(str, "SubCoreImage.getImgStg()…llPath(PHOTO_EDIT_PREFIX)");
    if (n.a(localCharSequence, (CharSequence)str, false)) {
      jdMethod_if(paramString1, paramString2);
    }
    AppMethodBeat.o(76196);
  }
  
  private static String ih(String paramString1, String paramString2)
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
  
  public static String ii(String paramString1, String paramString2)
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
  
  public static String rU(long paramLong)
  {
    AppMethodBeat.i(76210);
    com.tencent.mm.vfs.i.aMF(vtC);
    String str = vtC + "thumb" + paramLong + ".jpg";
    AppMethodBeat.o(76210);
    return str;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(com.tencent.mm.media.widget.camerarecordview.b.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(76178);
      ad.i("MicroMsg.MediaFileUtil", "deleteDaemonMediaFile");
      com.tencent.mm.vfs.i.deleteFile(this.vtF.gBn);
      com.tencent.mm.vfs.i.deleteFile(this.vtF.gBo);
      AppMethodBeat.o(76178);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(RecordConfigProvider paramRecordConfigProvider) {}
    
    public final void run()
    {
      AppMethodBeat.i(76182);
      Object localObject = com.tencent.mm.kernel.g.afB();
      k.g(localObject, "MMKernel.storage()");
      boolean bool = ((e)localObject).afk().getBoolean(ae.a.Fnp, true);
      ad.i("MicroMsg.MediaFileUtil", "handleDaemonNoNeedRemuxCaptureVideo videoState : " + bool + ' ');
      if (bool)
      {
        localObject = d.ahd("mp4");
        com.tencent.mm.vfs.i.lC(this.vlz.vhU, (String)localObject);
        com.tencent.mm.sdk.f.b.k((String)localObject, aj.getContext());
      }
      com.tencent.mm.vfs.i.deleteFile(this.vlz.vhT);
      AppMethodBeat.o(76182);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(RecordConfigProvider paramRecordConfigProvider) {}
    
    public final void run()
    {
      AppMethodBeat.i(76183);
      ad.i("MicroMsg.MediaFileUtil", "handleNoNeedRemuxCaptureVideo");
      Object localObject = com.tencent.mm.kernel.g.afB();
      k.g(localObject, "MMKernel.storage()");
      boolean bool = ((e)localObject).afk().getBoolean(ae.a.Fnp, true);
      ad.i("MicroMsg.MediaFileUtil", "handleNoNeedRemuxCaptureVideo videoState : " + bool + ' ');
      if (bool)
      {
        localObject = d.ahd("mp4");
        com.tencent.mm.vfs.i.lC(this.vlz.vhU, (String)localObject);
        com.tencent.mm.sdk.f.b.k((String)localObject, aj.getContext());
      }
      com.tencent.mm.vfs.i.deleteFile(this.vlz.vhT);
      AppMethodBeat.o(76183);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/util/MediaFileUtil$handleRemuxImage$1$1"})
  static final class g
    implements Runnable
  {
    g(RecordConfigProvider paramRecordConfigProvider1, boolean paramBoolean1, RecordConfigProvider paramRecordConfigProvider2, boolean paramBoolean2) {}
    
    public final void run()
    {
      AppMethodBeat.i(76184);
      if (!this.vlz.vhR) {
        com.tencent.mm.vfs.i.deleteFile(this.vlz.vhV);
      }
      Object localObject = com.tencent.mm.kernel.g.afB();
      k.g(localObject, "MMKernel.storage()");
      boolean bool = ((e)localObject).afk().getBoolean(ae.a.Fno, true);
      ad.i("MicroMsg.MediaFileUtil", "imageState : " + bool + ' ');
      if (!bool)
      {
        AppMethodBeat.o(76184);
        return;
      }
      if (((paramBoolean1) && (bool)) || ((!paramBoolean1) && (paramRecordConfigProvider.vhS) && (paramBoolean2)))
      {
        localObject = d.ahd("jpg");
        if (!paramBoolean1) {
          localObject = com.tencent.mm.sdk.f.b.ahd("jpg");
        }
        ad.i("MicroMsg.MediaFileUtil", "auto save pic src " + paramRecordConfigProvider.vhW + " dest " + (String)localObject + ' ');
        com.tencent.mm.vfs.i.lC(paramRecordConfigProvider.vhW, (String)localObject);
        com.tencent.mm.sdk.f.b.k((String)localObject, aj.getContext());
      }
      AppMethodBeat.o(76184);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/util/MediaFileUtil$handleRemuxVideo$1$1"})
  static final class h
    implements Runnable
  {
    h(RecordConfigProvider paramRecordConfigProvider1, RecordConfigProvider paramRecordConfigProvider2, boolean paramBoolean1, boolean paramBoolean2) {}
    
    public final void run()
    {
      AppMethodBeat.i(76185);
      if (!paramRecordConfigProvider.vhR) {
        com.tencent.mm.vfs.i.deleteFile(this.vlz.vhT);
      }
      Object localObject = com.tencent.mm.kernel.g.afB();
      k.g(localObject, "MMKernel.storage()");
      boolean bool = ((e)localObject).afk().getBoolean(ae.a.Fnp, true);
      ad.i("MicroMsg.MediaFileUtil", "videoState : " + bool + ' ');
      if (!bool)
      {
        AppMethodBeat.o(76185);
        return;
      }
      if ((paramBoolean1) || ((!paramBoolean1) && (paramRecordConfigProvider.vhS) && (paramBoolean2)))
      {
        localObject = d.ahd("mp4");
        if (!paramBoolean1) {
          localObject = com.tencent.mm.sdk.f.b.ahd("mp4");
        }
        ad.i("MicroMsg.MediaFileUtil", "auto save video :".concat(String.valueOf(localObject)));
        com.tencent.mm.vfs.i.lC(this.vlz.vhU, (String)localObject);
        com.tencent.mm.sdk.f.b.k((String)localObject, aj.getContext());
      }
      AppMethodBeat.o(76185);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/util/MediaFileUtil$handleRemuxVideo$3$1"})
  static final class i
    implements Runnable
  {
    i(aer paramaer) {}
    
    public final void run()
    {
      AppMethodBeat.i(76186);
      if (!this.vtK.vhR) {
        com.tencent.mm.vfs.i.deleteFile(this.vtK.vhT);
      }
      Object localObject = com.tencent.mm.kernel.g.afB();
      k.g(localObject, "MMKernel.storage()");
      if (!((e)localObject).afk().getBoolean(ae.a.Fnp, true))
      {
        AppMethodBeat.o(76186);
        return;
      }
      if ((this.vtK.DeU) || ((!this.vtK.DeU) && (this.vtK.vhS) && (this.vtK.yXQ)))
      {
        localObject = d.ahd("mp4");
        if (!this.vtK.DeU) {
          localObject = com.tencent.mm.sdk.f.b.ahd("mp4");
        }
        com.tencent.mm.vfs.i.lC(this.vtK.vhU, (String)localObject);
        com.tencent.mm.sdk.f.b.k((String)localObject, aj.getContext());
      }
      AppMethodBeat.o(76186);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel) {}
    
    public final void run()
    {
      AppMethodBeat.i(76187);
      String str = com.tencent.mm.sdk.f.b.ahd("mp4");
      com.tencent.mm.vfs.i.lC(this.vdq.getVideoPath(), str);
      com.tencent.mm.sdk.f.b.k(str, aj.getContext());
      AppMethodBeat.o(76187);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.b
 * JD-Core Version:    0.7.0.1
 */