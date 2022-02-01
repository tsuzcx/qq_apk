package com.tencent.mm.plugin.recordvideo.e;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/util/MediaFileUtil;", "", "()V", "MEDIA_FILE_DELETE_SET", "", "MEDIA_FILE_KEY", "MEDIA_TIMING_DELETE_SET", "MIX_AUDIO_FILE", "MIX_BLUR_BG_FILE", "MIX_THUMB_FILE", "MIX_VIDEO_FILE", "PHOTO_EDIT_PREFIX", "PIC_FILE", "TAG", "VIDEO_FILE", "VIDEP_EDOT_PREFIX", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "videoMixPath", "videoRecordRootPath", "videoRecordTempPath", "audioEnsurePath", "parentPath", "mediaId", "checkAndMarkDeletePhotoFile", "", "key", "filePath", "checkConfigProviderCapturePath", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "checkConfigProviderPhotoEditPath", "checkConfigProviderVideoEditPath", "checkThumbSize", "Landroid/graphics/Bitmap;", "bitmap", "shortSide", "", "checkToCreateDir", "newVideoPath", "noMedia", "", "clearTimingFile", "deleteBizFile", "deleteDaemonMediaFile", "mediaCaptureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "deleteFile", "deleteMarkFileByKey", "deleteMarkFilePath", "deleteVideoFileWithCheckPath", "exportVideo", "videoPath", "getAudioTmpPath", "getBlurBgPath", "localId", "getCaptureEditVideoPath", "getCaptureImagePath", "getCaptureThumbPath", "getCaptureVideoPath", "getEditImagePath", "getMixAudioPath", "getMixThumbPath", "getMixVideoPath", "getRecordThumbTempPath", "timeStamp", "", "getSubCaptureVideoParent", "getSubCaptureVideoPath", "handleDaemonNoNeedRemuxCaptureVideo", "isCaptureMedia", "handleMultiPhotoResult", "photoPath", "handleMultiVideoResult", "handleNoNeedRemuxCaptureVideo", "handleRemuxImage", "change", "handleRemuxVideo", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "handleSubRecordMux", "captureInfo", "markDeleteMediaFile", "file", "markDeletePhotoEditFile", "imagePathList", "Ljava/util/ArrayList;", "markTimingDeleteFile", "saveThumb", "thumbPath", "thumbSize", "thumbEnsurePath", "videoEnsurePath", "plugin-recordvideo_release"})
public final class b
{
  private static final ax cBy;
  private static final String xRi;
  private static final String xRj;
  public static final String xRk;
  public static final b xRl;
  
  static
  {
    AppMethodBeat.i(76218);
    xRl = new b();
    StringBuilder localStringBuilder = new StringBuilder();
    e locale = g.ajC();
    p.g(locale, "MMKernel.storage()");
    xRi = locale.getAccPath() + "recordPlugin/";
    xRj = xRi + "temp/";
    xRk = xRi + "mix/";
    cBy = ax.aQz("media_file_key");
    AppMethodBeat.o(76218);
  }
  
  public static void a(final RecordConfigProvider paramRecordConfigProvider, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(76203);
    ad.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:" + paramBoolean1 + "   change:" + paramBoolean2);
    if (paramRecordConfigProvider != null)
    {
      h.LTJ.f((Runnable)new k(paramRecordConfigProvider, paramRecordConfigProvider, paramBoolean1, paramBoolean2), "mux_save_work");
      AppMethodBeat.o(76203);
      return;
    }
    AppMethodBeat.o(76203);
  }
  
  public static void a(aif paramaif)
  {
    AppMethodBeat.i(76205);
    if (paramaif != null) {
      h.LTJ.f((Runnable)new l(paramaif), "mux_save_work");
    }
    AppMethodBeat.o(76205);
  }
  
  public static void ast(String paramString)
  {
    AppMethodBeat.i(76192);
    if (!TextUtils.isEmpty((CharSequence)paramString)) {
      h.LTJ.f((Runnable)new b.c(paramString), "MediaFileUtil_deleteMediaFile");
    }
    AppMethodBeat.o(76192);
  }
  
  public static void at(ArrayList<String> paramArrayList)
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
        String str2 = q.aIF().getFullPath("photoEdited_");
        p.g(str2, "SubCoreImage.getImgStg()…llPath(PHOTO_EDIT_PREFIX)");
        if (n.a(localCharSequence, (CharSequence)str2, false) == true)
        {
          ad.i("MicroMsg.MediaFileUtil", "markDeletePhotoEditFile: ".concat(String.valueOf(str1)));
          avR(str1);
        }
      }
    }
    AppMethodBeat.o(76194);
  }
  
  public static void avP(String paramString)
  {
    AppMethodBeat.i(200878);
    ad.i("MicroMsg.MediaFileUtil", "markTimingDeleteFile file ".concat(String.valueOf(paramString)));
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(200878);
      return;
    }
    Set localSet = cBy.decodeStringSet("media_timing_delete_set", (Set)new HashSet());
    localSet.add(paramString);
    cBy.encode("media_timing_delete_set", localSet);
    AppMethodBeat.o(200878);
  }
  
  public static void avQ(String paramString)
  {
    AppMethodBeat.i(76189);
    if (paramString != null)
    {
      paramString = cBy.decodeString(paramString, "");
      if (!TextUtils.isEmpty((CharSequence)paramString)) {
        h.LTJ.f((Runnable)new b.d(paramString), "MediaFileUtil_deleteMediaFile");
      }
    }
    AppMethodBeat.o(76189);
  }
  
  public static void avR(String paramString)
  {
    AppMethodBeat.i(76190);
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      ad.i("MicroMsg.MediaFileUtil", "cache delete file ".concat(String.valueOf(paramString)));
      Set localSet = cBy.decodeStringSet("media_file_delete_set", (Set)new HashSet());
      localSet.add(paramString);
      cBy.encode("media_file_delete_set", localSet);
    }
    AppMethodBeat.o(76190);
  }
  
  public static void avS(String paramString)
  {
    AppMethodBeat.i(76191);
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      Set localSet = cBy.decodeStringSet("media_file_delete_set", (Set)new HashSet());
      if (localSet.contains(paramString))
      {
        localSet.remove(paramString);
        if (!TextUtils.isEmpty((CharSequence)paramString)) {
          h.LTJ.f((Runnable)new b.e(paramString), "MediaFileUtil_deleteMediaFile");
        }
      }
    }
    AppMethodBeat.o(76191);
  }
  
  public static void avT(String paramString)
  {
    AppMethodBeat.i(76193);
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      if (paramString == null) {
        break label69;
      }
      CharSequence localCharSequence = (CharSequence)paramString;
      p.g(o.aMI(), "SubCoreVideo.getCore()");
      String str = o.getAccVideoPath();
      p.g(str, "SubCoreVideo.getCore().accVideoPath");
      if (n.a(localCharSequence, (CharSequence)str, false) == true) {
        ast(paramString);
      }
    }
    AppMethodBeat.o(76193);
    return;
    label69:
    AppMethodBeat.o(76193);
  }
  
  public static void avU(String paramString)
  {
    AppMethodBeat.i(76195);
    if (paramString != null)
    {
      CharSequence localCharSequence = (CharSequence)paramString;
      String str = q.aIF().getFullPath("photoEdited_");
      p.g(str, "SubCoreImage.getImgStg()…llPath(PHOTO_EDIT_PREFIX)");
      if (n.a(localCharSequence, (CharSequence)str, false) == true)
      {
        ad.i("MicroMsg.MediaFileUtil", "markDeletePhotoEditFile: ".concat(String.valueOf(paramString)));
        avR(paramString);
      }
      AppMethodBeat.o(76195);
      return;
    }
    AppMethodBeat.o(76195);
  }
  
  public static String avV(String paramString)
  {
    AppMethodBeat.i(76200);
    p.h(paramString, "videoPath");
    paramString = d.aqL(paramString);
    p.g(paramString, "MMSightUtil.getThumbName(videoPath)");
    AppMethodBeat.o(76200);
    return paramString;
  }
  
  public static void avW(String paramString)
  {
    AppMethodBeat.i(200881);
    if ((!TextUtils.isEmpty((CharSequence)paramString)) && (com.tencent.mm.vfs.i.fv(paramString))) {
      h.LTJ.aR((Runnable)new b.h(paramString));
    }
    AppMethodBeat.o(200881);
  }
  
  public static void avX(String paramString)
  {
    AppMethodBeat.i(200882);
    if ((!TextUtils.isEmpty((CharSequence)paramString)) && (com.tencent.mm.vfs.i.fv(paramString))) {
      h.LTJ.aR((Runnable)new b.g(paramString));
    }
    AppMethodBeat.o(200882);
  }
  
  public static String avY(String paramString)
  {
    AppMethodBeat.i(76213);
    if (paramString == null)
    {
      AppMethodBeat.o(76213);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String str = xRk;
    if (paramString == null) {}
    for (paramString = "";; paramString = str + paramString + ".v")
    {
      paramString = paramString + ".mixv";
      AppMethodBeat.o(76213);
      return paramString;
    }
  }
  
  public static String avZ(String paramString)
  {
    AppMethodBeat.i(76214);
    if (paramString == null)
    {
      AppMethodBeat.o(76214);
      return "";
    }
    paramString = iN(xRk, paramString) + ".mixt";
    AppMethodBeat.o(76214);
    return paramString;
  }
  
  public static String awa(String paramString)
  {
    AppMethodBeat.i(163472);
    if (paramString == null)
    {
      AppMethodBeat.o(163472);
      return "";
    }
    paramString = iN(xRk, paramString) + ".blurt";
    AppMethodBeat.o(163472);
    return paramString;
  }
  
  public static void awb(String paramString)
  {
    AppMethodBeat.i(76215);
    p.h(paramString, "newVideoPath");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(76215);
      return;
    }
    paramString = com.tencent.mm.vfs.i.aYr(paramString);
    com.tencent.mm.vfs.i.aYg(paramString);
    com.tencent.mm.vfs.i.aYu(paramString);
    AppMethodBeat.o(76215);
  }
  
  public static void b(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(200883);
    if (paramb != null)
    {
      if (paramb.htP == true) {
        h.LTJ.aR((Runnable)new n(paramb));
      }
      AppMethodBeat.o(200883);
      return;
    }
    AppMethodBeat.o(200883);
  }
  
  public static void b(final RecordConfigProvider paramRecordConfigProvider, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(76206);
    ad.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:" + paramBoolean1 + "   change:" + paramBoolean2);
    if (paramRecordConfigProvider != null)
    {
      h.LTJ.f((Runnable)new j(paramRecordConfigProvider, paramBoolean1, paramRecordConfigProvider, paramBoolean2), "mux_save_work");
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
      h.LTJ.f((Runnable)new b(paramb), "deleteDaemonMediaFile");
      AppMethodBeat.o(76217);
      return;
    }
    AppMethodBeat.o(76217);
  }
  
  public static void c(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(76204);
    if ((paramCaptureVideoNormalModel == null) || (!paramCaptureVideoNormalModel.dFC().booleanValue()))
    {
      AppMethodBeat.o(76204);
      return;
    }
    e locale = g.ajC();
    p.g(locale, "MMKernel.storage()");
    if (!locale.ajl().getBoolean(al.a.Ixw, true))
    {
      AppMethodBeat.o(76204);
      return;
    }
    h.LTJ.f((Runnable)new m(paramCaptureVideoNormalModel), "mux_save_work");
    AppMethodBeat.o(76204);
  }
  
  public static void d(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76197);
    p.h(paramRecordConfigProvider, "configProvider");
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.xyz))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      p.g(o.aMI(), "SubCoreVideo.getCore()");
      paramRecordConfigProvider.xyz = (o.getAccVideoPath() + "vsg_output_" + System.currentTimeMillis());
    }
    AppMethodBeat.o(76197);
  }
  
  public static void dIs()
  {
    AppMethodBeat.i(200879);
    h.LTJ.aR((Runnable)a.xRm);
    AppMethodBeat.o(200879);
  }
  
  public static String dIt()
  {
    AppMethodBeat.i(76199);
    p.g(o.aMI(), "SubCoreVideo.getCore()");
    String str = d.aqJ(o.getAccVideoPath());
    p.g(str, "MMSightUtil.getTempFileN…o.getCore().accVideoPath)");
    AppMethodBeat.o(76199);
    return str;
  }
  
  public static String dIu()
  {
    AppMethodBeat.i(200880);
    p.g(o.aMI(), "SubCoreVideo.getCore()");
    String str = o.aMR();
    p.g(str, "SubCoreVideo.getCore().subVideoPath");
    AppMethodBeat.o(200880);
    return str;
  }
  
  public static String dIv()
  {
    AppMethodBeat.i(76201);
    String str = q.aIF().getFullPath("photoEdited_" + System.currentTimeMillis());
    p.g(str, "SubCoreImage.getImgStg()…stem.currentTimeMillis())");
    AppMethodBeat.o(76201);
    return str;
  }
  
  public static String dIw()
  {
    AppMethodBeat.i(76202);
    String str = q.aIF().getFullPath("photoCapture_" + System.currentTimeMillis());
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
      p.g(o.aMI(), "SubCoreVideo.getCore()");
      paramRecordConfigProvider.thumbPath = (o.getAccVideoPath() + "vsg_thumb_" + System.currentTimeMillis());
    }
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.xyx))
    {
      localStringBuilder = new StringBuilder();
      p.g(o.aMI(), "SubCoreVideo.getCore()");
      paramRecordConfigProvider.xyx = (o.getAccVideoPath() + "vsg_output_" + System.currentTimeMillis());
    }
    AppMethodBeat.o(76198);
  }
  
  public static boolean f(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76207);
    ad.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:true  ");
    if (paramRecordConfigProvider != null) {
      h.LTJ.f((Runnable)new f(paramRecordConfigProvider), "mux_save_work_daemon");
    }
    AppMethodBeat.o(76207);
    return true;
  }
  
  public static boolean g(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76208);
    ad.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:true  ");
    if (paramRecordConfigProvider != null)
    {
      if (com.tencent.mm.vfs.i.fv(paramRecordConfigProvider.xyw)) {
        com.tencent.mm.vfs.i.mz(paramRecordConfigProvider.xyw, paramRecordConfigProvider.xyx);
      }
      h.LTJ.f((Runnable)new i(paramRecordConfigProvider), "handleNoNeedRemuxCaptureVideo");
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
  
  public static void iL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76188);
    ad.i("MicroMsg.MediaFileUtil", "cache delete key: " + paramString1 + " , file " + paramString2);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(76188);
      return;
    }
    cBy.encode(paramString1, paramString2);
    AppMethodBeat.o(76188);
  }
  
  public static void iM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76196);
    if ((TextUtils.isEmpty((CharSequence)paramString1)) || (TextUtils.isEmpty((CharSequence)paramString2)))
    {
      AppMethodBeat.o(76196);
      return;
    }
    if (paramString2 == null) {
      p.gfZ();
    }
    CharSequence localCharSequence = (CharSequence)paramString2;
    String str = q.aIF().getFullPath("photoEdited_");
    p.g(str, "SubCoreImage.getImgStg()…llPath(PHOTO_EDIT_PREFIX)");
    if (n.a(localCharSequence, (CharSequence)str, false)) {
      iL(paramString1, paramString2);
    }
    AppMethodBeat.o(76196);
  }
  
  private static String iN(String paramString1, String paramString2)
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
  
  public static String iO(String paramString1, String paramString2)
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
  
  public static String yR(long paramLong)
  {
    AppMethodBeat.i(76210);
    com.tencent.mm.vfs.i.aYg(xRj);
    String str = xRj + "thumb" + paramLong + ".jpg";
    AppMethodBeat.o(76210);
    return str;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a xRm;
    
    static
    {
      AppMethodBeat.i(200874);
      xRm = new a();
      AppMethodBeat.o(200874);
    }
    
    public final void run()
    {
      AppMethodBeat.i(200873);
      Object localObject1 = b.xRl;
      localObject1 = b.dIx().decodeStringSet("media_file_delete_set", (Set)new HashSet());
      p.g(localObject1, "set");
      Object localObject2 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject2).hasNext()) {
        com.tencent.mm.vfs.i.deleteFile((String)((Iterator)localObject2).next());
      }
      ((Set)localObject1).clear();
      localObject2 = b.xRl;
      b.dIx().encode("media_timing_delete_set", (Set)localObject1);
      AppMethodBeat.o(200873);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(com.tencent.mm.media.widget.camerarecordview.b.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(76178);
      ad.i("MicroMsg.MediaFileUtil", "deleteDaemonMediaFile");
      com.tencent.mm.vfs.i.deleteFile(this.xRn.htR);
      com.tencent.mm.vfs.i.deleteFile(this.xRn.htS);
      AppMethodBeat.o(76178);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(RecordConfigProvider paramRecordConfigProvider) {}
    
    public final void run()
    {
      AppMethodBeat.i(76182);
      Object localObject = g.ajC();
      p.g(localObject, "MMKernel.storage()");
      boolean bool = ((e)localObject).ajl().getBoolean(al.a.Ixw, true);
      ad.i("MicroMsg.MediaFileUtil", "handleDaemonNoNeedRemuxCaptureVideo videoState : " + bool + ' ');
      if (bool)
      {
        localObject = d.aqN("mp4");
        com.tencent.mm.vfs.i.mz(this.xCb.xyx, (String)localObject);
        com.tencent.mm.sdk.f.b.k((String)localObject, aj.getContext());
      }
      com.tencent.mm.vfs.i.deleteFile(this.xCb.xyw);
      AppMethodBeat.o(76182);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(RecordConfigProvider paramRecordConfigProvider) {}
    
    public final void run()
    {
      AppMethodBeat.i(76183);
      ad.i("MicroMsg.MediaFileUtil", "handleNoNeedRemuxCaptureVideo");
      Object localObject = g.ajC();
      p.g(localObject, "MMKernel.storage()");
      boolean bool = ((e)localObject).ajl().getBoolean(al.a.Ixw, true);
      ad.i("MicroMsg.MediaFileUtil", "handleNoNeedRemuxCaptureVideo videoState : " + bool + ' ');
      if (bool)
      {
        localObject = d.aqN("mp4");
        com.tencent.mm.vfs.i.mz(this.xCb.xyx, (String)localObject);
        com.tencent.mm.sdk.f.b.k((String)localObject, aj.getContext());
      }
      com.tencent.mm.vfs.i.deleteFile(this.xCb.xyw);
      AppMethodBeat.o(76183);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/util/MediaFileUtil$handleRemuxImage$1$1"})
  static final class j
    implements Runnable
  {
    j(RecordConfigProvider paramRecordConfigProvider1, boolean paramBoolean1, RecordConfigProvider paramRecordConfigProvider2, boolean paramBoolean2) {}
    
    public final void run()
    {
      AppMethodBeat.i(76184);
      if (!this.xCb.xyu) {
        com.tencent.mm.vfs.i.deleteFile(this.xCb.xyy);
      }
      Object localObject = g.ajC();
      p.g(localObject, "MMKernel.storage()");
      boolean bool = ((e)localObject).ajl().getBoolean(al.a.Ixv, true);
      ad.i("MicroMsg.MediaFileUtil", "imageState : " + bool + ' ');
      if (!bool)
      {
        AppMethodBeat.o(76184);
        return;
      }
      if (((paramBoolean1) && (bool)) || ((!paramBoolean1) && (paramRecordConfigProvider.xyv) && (paramBoolean2)))
      {
        localObject = d.aqN("jpg");
        if (!paramBoolean1) {
          localObject = com.tencent.mm.sdk.f.b.aqN("jpg");
        }
        ad.i("MicroMsg.MediaFileUtil", "auto save pic src " + paramRecordConfigProvider.xyz + " dest " + (String)localObject + ' ');
        com.tencent.mm.vfs.i.mz(paramRecordConfigProvider.xyz, (String)localObject);
        com.tencent.mm.sdk.f.b.k((String)localObject, aj.getContext());
      }
      AppMethodBeat.o(76184);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/util/MediaFileUtil$handleRemuxVideo$1$1"})
  static final class k
    implements Runnable
  {
    k(RecordConfigProvider paramRecordConfigProvider1, RecordConfigProvider paramRecordConfigProvider2, boolean paramBoolean1, boolean paramBoolean2) {}
    
    public final void run()
    {
      AppMethodBeat.i(76185);
      if (!paramRecordConfigProvider.xyu) {
        com.tencent.mm.vfs.i.deleteFile(this.xCb.xyw);
      }
      Object localObject = g.ajC();
      p.g(localObject, "MMKernel.storage()");
      boolean bool = ((e)localObject).ajl().getBoolean(al.a.Ixw, true);
      ad.i("MicroMsg.MediaFileUtil", "videoState : " + bool + ' ');
      if (!bool)
      {
        AppMethodBeat.o(76185);
        return;
      }
      if ((paramBoolean1) || ((!paramBoolean1) && (paramRecordConfigProvider.xyv) && (paramBoolean2)))
      {
        localObject = d.aqN("mp4");
        if (!paramBoolean1) {
          localObject = com.tencent.mm.sdk.f.b.aqN("mp4");
        }
        ad.i("MicroMsg.MediaFileUtil", "auto save video :".concat(String.valueOf(localObject)));
        com.tencent.mm.vfs.i.mz(this.xCb.xyx, (String)localObject);
        com.tencent.mm.sdk.f.b.k((String)localObject, aj.getContext());
      }
      AppMethodBeat.o(76185);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/util/MediaFileUtil$handleRemuxVideo$3$1"})
  static final class l
    implements Runnable
  {
    l(aif paramaif) {}
    
    public final void run()
    {
      AppMethodBeat.i(76186);
      if (!this.xRt.xyu) {
        com.tencent.mm.vfs.i.deleteFile(this.xRt.xyw);
      }
      Object localObject = g.ajC();
      p.g(localObject, "MMKernel.storage()");
      if (!((e)localObject).ajl().getBoolean(al.a.Ixw, true))
      {
        AppMethodBeat.o(76186);
        return;
      }
      if ((this.xRt.GfH) || ((!this.xRt.GfH) && (this.xRt.xyv) && (this.xRt.BDq)))
      {
        localObject = d.aqN("mp4");
        if (!this.xRt.GfH) {
          localObject = com.tencent.mm.sdk.f.b.aqN("mp4");
        }
        com.tencent.mm.vfs.i.mz(this.xRt.xyx, (String)localObject);
        com.tencent.mm.sdk.f.b.k((String)localObject, aj.getContext());
      }
      AppMethodBeat.o(76186);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    m(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel) {}
    
    public final void run()
    {
      AppMethodBeat.i(76187);
      String str = com.tencent.mm.sdk.f.b.aqN("mp4");
      com.tencent.mm.vfs.i.mz(this.xuc.getVideoPath(), str);
      com.tencent.mm.sdk.f.b.k(str, aj.getContext());
      AppMethodBeat.o(76187);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(com.tencent.mm.media.widget.camerarecordview.b.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(200877);
      Iterator localIterator = ((Iterable)this.xRu.htX).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ad.i("MicroMsg.MediaFileUtil", "delete file:".concat(String.valueOf(str)));
        com.tencent.mm.vfs.i.deleteFile(str);
      }
      AppMethodBeat.o(200877);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.b
 * JD-Core Version:    0.7.0.1
 */