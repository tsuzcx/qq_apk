package com.tencent.mm.plugin.recordvideo.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vfs.j;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/util/MediaFileUtil;", "", "()V", "CLEAN_FILE_INTERVAL", "", "CLEAN_FILE_TIMESTAMP_LONG", "", "MEDIA_FILE_DELETE_SET", "MEDIA_FILE_KEY", "MEDIA_TIMING_DELETE_SET", "MIX_AUDIO_FILE", "MIX_BLUR_BG_FILE", "MIX_THUMB_FILE", "MIX_VIDEO_FILE", "PHOTO_EDIT_PREFIX", "PIC_FILE", "TAG", "VIDEO_FILE", "VIDEP_EDOT_PREFIX", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "videoMixPath", "videoRecordRootPath", "videoRecordTempPath", "audioEnsurePath", "parentPath", "mediaId", "checkAndMarkDeletePhotoFile", "", "key", "filePath", "checkConfigProviderCapturePath", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "checkConfigProviderPhotoEditPath", "checkConfigProviderVideoEditPath", "checkThumbSize", "Landroid/graphics/Bitmap;", "bitmap", "shortSide", "checkToCreateDir", "newVideoPath", "noMedia", "", "clearTimingFile", "deleteDaemonMediaFile", "mediaCaptureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "deleteDirExpiredFile", "expired", "", "deleteExpiredFile", "deleteFile", "deleteMarkFileByKey", "deleteMarkFilePath", "deleteVideoFileWithCheckPath", "exportVideo", "videoPath", "getAudioTmpPath", "getBlurBgPath", "localId", "getCaptureEditVideoPath", "getCaptureImagePath", "getCaptureThumbPath", "getCaptureVideoPath", "getEditImagePath", "getMixAudioPath", "getMixThumbPath", "getMixVideoPath", "getRecordThumbTempPath", "timeStamp", "getSubCaptureVideoParent", "getSubCaptureVideoPath", "handleDaemonNoNeedRemuxCaptureVideo", "isCaptureMedia", "handleMultiPhotoResult", "photoPath", "handleMultiVideoResult", "handleNoNeedRemuxCaptureVideo", "handleRemuxImage", "change", "handleRemuxVideo", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "handleSubRecordMux", "captureInfo", "markDeleteMediaFile", "file", "markDeletePhotoEditFile", "imagePathList", "Ljava/util/ArrayList;", "markTimingDeleteFile", "saveThumb", "thumbPath", "thumbSize", "thumbEnsurePath", "videoEnsurePath", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f Obq;
  private static final String Obr;
  private static final String Obs;
  public static final String Obt;
  public static final MultiProcessMMKV eMf;
  
  static
  {
    AppMethodBeat.i(76218);
    Obq = new f();
    String str = s.X(com.tencent.mm.kernel.h.baE().mCJ, "recordPlugin/");
    Obr = str;
    Obs = s.X(str, "temp/");
    Obt = s.X(Obr, "mix/");
    eMf = MultiProcessMMKV.getMMKV("media_file_key");
    AppMethodBeat.o(76218);
  }
  
  private static final void a(RecordConfigProvider paramRecordConfigProvider1, RecordConfigProvider paramRecordConfigProvider2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(279689);
    s.u(paramRecordConfigProvider2, "$this_apply");
    if (!paramRecordConfigProvider1.NIb) {
      aOJ(paramRecordConfigProvider2.NId);
    }
    boolean bool = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acPs, true);
    Log.i("MicroMsg.MediaFileUtil", "videoState : " + bool + ' ');
    if (!bool)
    {
      AppMethodBeat.o(279689);
      return;
    }
    if ((paramBoolean1) || ((!paramBoolean1) && (paramRecordConfigProvider1.NIc) && (paramBoolean2)))
    {
      paramRecordConfigProvider1 = d.getExportImagePath("mp4");
      if (!paramBoolean1) {
        paramRecordConfigProvider1 = AndroidMediaUtil.getExportImagePath("mp4");
      }
      Log.i("MicroMsg.MediaFileUtil", s.X("auto save video :", paramRecordConfigProvider1));
      ExportFileUtil.q(MMApplicationContext.getContext(), paramRecordConfigProvider2.NIe, paramRecordConfigProvider1);
      AndroidMediaUtil.refreshMediaScanner(paramRecordConfigProvider1, MMApplicationContext.getContext());
    }
    AppMethodBeat.o(279689);
  }
  
  private static final void a(RecordConfigProvider paramRecordConfigProvider1, boolean paramBoolean1, RecordConfigProvider paramRecordConfigProvider2, boolean paramBoolean2)
  {
    AppMethodBeat.i(279696);
    s.u(paramRecordConfigProvider1, "$this_apply");
    if (!paramRecordConfigProvider1.NIb) {
      aOJ(paramRecordConfigProvider1.NIf);
    }
    boolean bool = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acPr, true);
    Log.i("MicroMsg.MediaFileUtil", "imageState : " + bool + ' ');
    if (!bool)
    {
      AppMethodBeat.o(279696);
      return;
    }
    if (((paramBoolean1) && (bool)) || ((!paramBoolean1) && (paramRecordConfigProvider2.NIc) && (paramBoolean2)))
    {
      paramRecordConfigProvider1 = d.getExportImagePath("jpg");
      if (!paramBoolean1) {
        paramRecordConfigProvider1 = AndroidMediaUtil.getExportImagePath("jpg");
      }
      Log.i("MicroMsg.MediaFileUtil", "auto save pic src " + paramRecordConfigProvider2.NIg + " dest " + paramRecordConfigProvider1 + ' ');
      ExportFileUtil.p(MMApplicationContext.getContext(), paramRecordConfigProvider2.NIg, paramRecordConfigProvider1);
      AndroidMediaUtil.refreshMediaScanner(paramRecordConfigProvider1, MMApplicationContext.getContext());
    }
    AppMethodBeat.o(279696);
  }
  
  public static void a(RecordConfigProvider paramRecordConfigProvider, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(76203);
    Log.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:" + paramBoolean1 + "   change:" + paramBoolean2);
    if (paramRecordConfigProvider != null) {
      com.tencent.threadpool.h.ahAA.g(new f..ExternalSyntheticLambda5(paramRecordConfigProvider, paramRecordConfigProvider, paramBoolean1, paramBoolean2), "mux_save_work");
    }
    AppMethodBeat.o(76203);
  }
  
  public static void a(apw paramapw)
  {
    AppMethodBeat.i(76205);
    if (paramapw != null) {
      com.tencent.threadpool.h.ahAA.g(new f..ExternalSyntheticLambda7(paramapw), "mux_save_work");
    }
    AppMethodBeat.o(76205);
  }
  
  public static void aOJ(String paramString)
  {
    AppMethodBeat.i(76192);
    boolean bool = y.ZC(paramString);
    Log.i("MicroMsg.MediaFileUtil", "path:" + paramString + "  fileExist:" + bool);
    if (bool) {
      com.tencent.threadpool.h.ahAA.g(new f..ExternalSyntheticLambda10(paramString), "MediaFileUtil_deleteMediaFile");
    }
    AppMethodBeat.o(76192);
  }
  
  public static String aTA(String paramString)
  {
    AppMethodBeat.i(163472);
    if (paramString == null)
    {
      AppMethodBeat.o(163472);
      return "";
    }
    paramString = s.X(lp(Obt, paramString), ".blurt");
    AppMethodBeat.o(163472);
    return paramString;
  }
  
  public static void aTB(String paramString)
  {
    AppMethodBeat.i(76215);
    s.u(paramString, "newVideoPath");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(76215);
      return;
    }
    paramString = y.bEo(paramString);
    y.bDX(paramString);
    y.bEr(paramString);
    AppMethodBeat.o(76215);
  }
  
  private static final void aTC(String paramString)
  {
    AppMethodBeat.i(279687);
    Log.i("MicroMsg.MediaFileUtil", s.X("exec delete filePath:", paramString));
    y.deleteFile(paramString);
    AppMethodBeat.o(279687);
  }
  
  private static final void aTD(String paramString)
  {
    AppMethodBeat.i(279703);
    boolean bool = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acPs, true);
    Log.i("MicroMsg.MediaFileUtil", "remuxComposition videoState : " + bool + " videoPath:" + paramString);
    if (bool)
    {
      String str = AndroidMediaUtil.getExportImagePath("mp4");
      Context localContext = MMApplicationContext.getContext();
      s.checkNotNull(paramString);
      ExportFileUtil.q(localContext, paramString, str);
      AndroidMediaUtil.refreshMediaScanner(str, MMApplicationContext.getContext());
    }
    AppMethodBeat.o(279703);
  }
  
  private static final void aTE(String paramString)
  {
    AppMethodBeat.i(279707);
    boolean bool = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acPr, true);
    Log.i("MicroMsg.MediaFileUtil", "handleMultiVideoResult videoState : " + bool + ' ');
    if (bool)
    {
      String str = AndroidMediaUtil.getExportImagePath("jpg");
      Context localContext = MMApplicationContext.getContext();
      s.checkNotNull(paramString);
      ExportFileUtil.p(localContext, paramString, str);
      AndroidMediaUtil.refreshMediaScanner(str, MMApplicationContext.getContext());
    }
    AppMethodBeat.o(279707);
  }
  
  public static void aTp(String paramString)
  {
    AppMethodBeat.i(279587);
    Log.i("MicroMsg.MediaFileUtil", s.X("markTimingDeleteFile file ", paramString));
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(279587);
      return;
    }
    Set localSet = eMf.decodeStringSet("media_timing_delete_set", (Set)new HashSet());
    localSet.add(paramString);
    eMf.encode("media_timing_delete_set", localSet);
    AppMethodBeat.o(279587);
  }
  
  public static void aTq(String paramString)
  {
    AppMethodBeat.i(76189);
    if (paramString != null) {
      aOJ(eMf.decodeString(paramString, ""));
    }
    AppMethodBeat.o(76189);
  }
  
  public static void aTr(String paramString)
  {
    AppMethodBeat.i(76190);
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      Log.i("MicroMsg.MediaFileUtil", s.X("cache delete file ", paramString));
      Set localSet = eMf.decodeStringSet("media_file_delete_set", (Set)new HashSet());
      localSet.add(paramString);
      eMf.encode("media_file_delete_set", localSet);
    }
    AppMethodBeat.o(76190);
  }
  
  public static void aTs(String paramString)
  {
    AppMethodBeat.i(76191);
    Log.i("MicroMsg.MediaFileUtil", s.X("deleteMarkFilePath ", paramString));
    Set localSet = eMf.decodeStringSet("media_file_delete_set", (Set)new HashSet());
    if (localSet.contains(paramString))
    {
      localSet.remove(paramString);
      aOJ(paramString);
    }
    eMf.encode("media_file_delete_set", localSet);
    AppMethodBeat.o(76191);
  }
  
  public static void aTt(String paramString)
  {
    AppMethodBeat.i(76193);
    Log.i("MicroMsg.MediaFileUtil", s.X("deleteVideoFileWithCheckPath ", paramString));
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      if (paramString == null) {
        break label83;
      }
      CharSequence localCharSequence = (CharSequence)paramString;
      v.bOg();
      String str = v.getAccVideoPath();
      s.s(str, "getCore().accVideoPath");
      if (n.a(localCharSequence, (CharSequence)str, false) != true) {
        break label83;
      }
    }
    label83:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        aOJ(paramString);
      }
      AppMethodBeat.o(76193);
      return;
    }
  }
  
  public static void aTu(String paramString)
  {
    AppMethodBeat.i(76195);
    if ((paramString != null) && (n.a((CharSequence)paramString, (CharSequence)"photoEdited_", false) == true)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.MediaFileUtil", s.X("markDeletePhotoEditFile: ", paramString));
        aTr(paramString);
      }
      AppMethodBeat.o(76195);
      return;
    }
  }
  
  public static String aTv(String paramString)
  {
    AppMethodBeat.i(76200);
    s.u(paramString, "videoPath");
    paramString = d.aMt(paramString);
    s.s(paramString, "getThumbName(videoPath)");
    AppMethodBeat.o(76200);
    return paramString;
  }
  
  public static void aTw(String paramString)
  {
    AppMethodBeat.i(279641);
    if ((!TextUtils.isEmpty((CharSequence)paramString)) && (y.ZC(paramString))) {
      com.tencent.threadpool.h.ahAA.bm(new f..ExternalSyntheticLambda9(paramString));
    }
    AppMethodBeat.o(279641);
  }
  
  public static void aTx(String paramString)
  {
    AppMethodBeat.i(279642);
    if ((!TextUtils.isEmpty((CharSequence)paramString)) && (y.ZC(paramString))) {
      com.tencent.threadpool.h.ahAA.bm(new f..ExternalSyntheticLambda8(paramString));
    }
    AppMethodBeat.o(279642);
  }
  
  public static String aTy(String paramString)
  {
    AppMethodBeat.i(76213);
    if (paramString == null)
    {
      AppMethodBeat.o(76213);
      return "";
    }
    String str = Obt;
    if (paramString == null) {}
    for (paramString = "";; paramString = str + paramString + ".v")
    {
      paramString = s.X(paramString, ".mixv");
      AppMethodBeat.o(76213);
      return paramString;
    }
  }
  
  public static String aTz(String paramString)
  {
    AppMethodBeat.i(76214);
    if (paramString == null)
    {
      AppMethodBeat.o(76214);
      return "";
    }
    paramString = s.X(lp(Obt, paramString), ".mixt");
    AppMethodBeat.o(76214);
    return paramString;
  }
  
  public static void b(RecordConfigProvider paramRecordConfigProvider, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(76206);
    Log.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:" + paramBoolean1 + "   change:" + paramBoolean2);
    if (paramRecordConfigProvider != null) {
      com.tencent.threadpool.h.ahAA.g(new f..ExternalSyntheticLambda6(paramRecordConfigProvider, paramBoolean1, paramRecordConfigProvider, paramBoolean2), "mux_save_work");
    }
    AppMethodBeat.o(76206);
  }
  
  private static final void b(apw paramapw)
  {
    AppMethodBeat.i(279695);
    if (!paramapw.NIb) {
      aOJ(paramapw.NId);
    }
    if (!com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acPs, true))
    {
      AppMethodBeat.o(279695);
      return;
    }
    if ((paramapw.Zxk) || ((!paramapw.Zxk) && (paramapw.NIc) && (paramapw.TVM)))
    {
      String str = d.getExportImagePath("mp4");
      if (!paramapw.Zxk) {
        str = AndroidMediaUtil.getExportImagePath("mp4");
      }
      ExportFileUtil.q(MMApplicationContext.getContext(), paramapw.NIe, str);
      AndroidMediaUtil.refreshMediaScanner(str, MMApplicationContext.getContext());
    }
    AppMethodBeat.o(279695);
  }
  
  public static void bn(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(76194);
    s.u(paramArrayList, "imagePathList");
    paramArrayList = ((Iterable)paramArrayList).iterator();
    label93:
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if ((str != null) && (n.a((CharSequence)str, (CharSequence)"photoEdited_", false) == true)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label93;
        }
        Log.i("MicroMsg.MediaFileUtil", s.X("markDeletePhotoEditFile: ", str));
        aTr(str);
        break;
      }
    }
    AppMethodBeat.o(76194);
  }
  
  public static void c(b paramb)
  {
    int i = 1;
    AppMethodBeat.i(279643);
    if ((paramb != null) && (paramb.nJW == true)) {}
    for (;;)
    {
      if (i != 0) {
        com.tencent.threadpool.h.ahAA.bm(new f..ExternalSyntheticLambda0(paramb));
      }
      AppMethodBeat.o(279643);
      return;
      i = 0;
    }
  }
  
  public static void c(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(76204);
    if ((paramCaptureVideoNormalModel == null) || (!paramCaptureVideoNormalModel.NHI.booleanValue()))
    {
      AppMethodBeat.o(76204);
      return;
    }
    if (!com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acPs, true))
    {
      AppMethodBeat.o(76204);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(new f..ExternalSyntheticLambda2(paramCaptureVideoNormalModel), "mux_save_work");
    AppMethodBeat.o(76204);
  }
  
  public static void d(b paramb)
  {
    AppMethodBeat.i(76217);
    if (paramb != null) {
      com.tencent.threadpool.h.ahAA.g(new f..ExternalSyntheticLambda1(paramb), "deleteDaemonMediaFile");
    }
    AppMethodBeat.o(76217);
  }
  
  private static final void d(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(279692);
    String str = AndroidMediaUtil.getExportImagePath("mp4");
    ExportFileUtil.q(MMApplicationContext.getContext(), paramCaptureVideoNormalModel.videoPath, str);
    Log.i("MicroMsg.MediaFileUtil", "handleRemuxVideo save video" + paramCaptureVideoNormalModel.videoPath + " exist:" + y.ZC(paramCaptureVideoNormalModel.videoPath) + " to:" + str);
    AndroidMediaUtil.refreshMediaScanner(str, MMApplicationContext.getContext());
    AppMethodBeat.o(279692);
  }
  
  private static final void e(b paramb)
  {
    AppMethodBeat.i(279711);
    paramb = ((Iterable)paramb.nKd).iterator();
    while (paramb.hasNext())
    {
      String str = (String)paramb.next();
      Log.i("MicroMsg.MediaFileUtil", s.X("delete file:", str));
      aOJ(str);
    }
    AppMethodBeat.o(279711);
  }
  
  private static final void f(b paramb)
  {
    AppMethodBeat.i(279713);
    s.u(paramb, "$this_apply");
    Log.i("MicroMsg.MediaFileUtil", "deleteDaemonMediaFile");
    aOJ(paramb.nJX);
    aOJ(paramb.nJY);
    AppMethodBeat.o(279713);
  }
  
  public static void gLg()
  {
    AppMethodBeat.i(279594);
    Set localSet = eMf.decodeStringSet("media_timing_delete_set", (Set)new HashSet());
    s.s(localSet, "set");
    Iterator localIterator = ((Iterable)localSet).iterator();
    while (localIterator.hasNext()) {
      aOJ((String)localIterator.next());
    }
    localSet.clear();
    eMf.encode("media_timing_delete_set", localSet);
    AppMethodBeat.o(279594);
  }
  
  public static String gLh()
  {
    AppMethodBeat.i(279629);
    v.bOg();
    String str = v.bOp();
    s.s(str, "getCore().subVideoPath");
    AppMethodBeat.o(279629);
    return str;
  }
  
  public static String gLi()
  {
    AppMethodBeat.i(76201);
    String str1 = s.X("photoEdited_", Long.valueOf(System.currentTimeMillis()));
    String str2 = y.n(s.X("wcf://temp/", str1), true);
    if (str2 == null)
    {
      str1 = MMApplicationContext.getContext().getCacheDir().getAbsolutePath() + '/' + str1;
      AppMethodBeat.o(76201);
      return str1;
    }
    AppMethodBeat.o(76201);
    return str2;
  }
  
  public static Bitmap j(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(76209);
    s.u(paramBitmap, "bitmap");
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
        s.s(paramBitmap, "createScaledBitmap(bitma…idth, outputHeight, true)");
        AppMethodBeat.o(76209);
        return paramBitmap;
        i = (int)(paramBitmap.getWidth() * paramInt * 1.0F / paramBitmap.getHeight());
      }
    }
    AppMethodBeat.o(76209);
    return paramBitmap;
  }
  
  public static void j(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(279623);
    s.u(paramRecordConfigProvider, "configProvider");
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.NIg)) {
      paramRecordConfigProvider.NIg = gLi();
    }
    String str1;
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.NIf))
    {
      String str3 = s.X("photoCapture_", Long.valueOf(System.currentTimeMillis()));
      String str2 = y.n(s.X("wcf://temp/", str3), true);
      str1 = str2;
      if (str2 == null) {
        str1 = MMApplicationContext.getContext().getCacheDir().getAbsolutePath() + '/' + str3;
      }
      paramRecordConfigProvider.NIf = str1;
    }
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.NId))
    {
      v.bOg();
      str1 = d.aMr(v.getAccVideoPath());
      s.s(str1, "getTempFileName(SubCoreV…o.getCore().accVideoPath)");
      paramRecordConfigProvider.NId = str1;
    }
    l(paramRecordConfigProvider);
    AppMethodBeat.o(279623);
  }
  
  public static void k(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76197);
    s.u(paramRecordConfigProvider, "configProvider");
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.NIg))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      v.bOg();
      paramRecordConfigProvider.NIg = (v.getAccVideoPath() + "/vsg_output_" + System.currentTimeMillis());
    }
    AppMethodBeat.o(76197);
  }
  
  public static void l(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76198);
    s.u(paramRecordConfigProvider, "configProvider");
    StringBuilder localStringBuilder;
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.thumbPath))
    {
      localStringBuilder = new StringBuilder();
      v.bOg();
      paramRecordConfigProvider.thumbPath = (v.getAccVideoPath() + "/vsg_thumb_" + System.currentTimeMillis());
    }
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.NIe))
    {
      localStringBuilder = new StringBuilder();
      v.bOg();
      paramRecordConfigProvider.NIe = (v.getAccVideoPath() + "/vsg_output_" + System.currentTimeMillis());
    }
    AppMethodBeat.o(76198);
  }
  
  public static void ln(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76188);
    Log.i("MicroMsg.MediaFileUtil", "cache delete key: " + paramString1 + " , file " + paramString2);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(76188);
      return;
    }
    eMf.encode(paramString1, paramString2);
    AppMethodBeat.o(76188);
  }
  
  public static void lo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76196);
    Log.i("MicroMsg.MediaFileUtil", "checkAndMarkDeletePhotoFile key:" + paramString1 + " filePath:" + paramString2);
    if ((TextUtils.isEmpty((CharSequence)paramString1)) || (TextUtils.isEmpty((CharSequence)paramString2)))
    {
      AppMethodBeat.o(76196);
      return;
    }
    s.checkNotNull(paramString2);
    if (n.i((CharSequence)paramString2, (CharSequence)"photoEdited_")) {
      ln(paramString1, paramString2);
    }
    AppMethodBeat.o(76196);
  }
  
  private static String lp(String paramString1, String paramString2)
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
  
  public static String lq(String paramString1, String paramString2)
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
  
  public static boolean m(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76207);
    Log.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:true  ");
    if (paramRecordConfigProvider != null) {
      com.tencent.threadpool.h.ahAA.g(new f..ExternalSyntheticLambda3(paramRecordConfigProvider), "mux_save_work_daemon");
    }
    AppMethodBeat.o(76207);
    return true;
  }
  
  public static boolean n(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76208);
    Log.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:true  ");
    if (paramRecordConfigProvider != null)
    {
      if (y.ZC(paramRecordConfigProvider.NId)) {
        ExportFileUtil.q(MMApplicationContext.getContext(), paramRecordConfigProvider.NId, paramRecordConfigProvider.NIe);
      }
      com.tencent.threadpool.h.ahAA.g(new f..ExternalSyntheticLambda4(paramRecordConfigProvider), "handleNoNeedRemuxCaptureVideo");
    }
    AppMethodBeat.o(76208);
    return true;
  }
  
  private static final void o(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(279698);
    s.u(paramRecordConfigProvider, "$this_apply");
    boolean bool = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acPs, true);
    Log.i("MicroMsg.MediaFileUtil", "handleDaemonNoNeedRemuxCaptureVideo videoState : " + bool + ' ');
    if (bool)
    {
      String str = d.getExportImagePath("mp4");
      ExportFileUtil.q(MMApplicationContext.getContext(), paramRecordConfigProvider.NIe, str);
      AndroidMediaUtil.refreshMediaScanner(str, MMApplicationContext.getContext());
    }
    aOJ(paramRecordConfigProvider.NId);
    AppMethodBeat.o(279698);
  }
  
  private static final void p(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(279700);
    s.u(paramRecordConfigProvider, "$this_apply");
    Log.i("MicroMsg.MediaFileUtil", "handleNoNeedRemuxCaptureVideo");
    boolean bool = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acPs, true);
    Log.i("MicroMsg.MediaFileUtil", "handleNoNeedRemuxCaptureVideo videoState : " + bool + ' ');
    if (bool)
    {
      String str = d.getExportImagePath("mp4");
      ExportFileUtil.q(MMApplicationContext.getContext(), paramRecordConfigProvider.NIe, str);
      AndroidMediaUtil.refreshMediaScanner(str, MMApplicationContext.getContext());
    }
    aOJ(paramRecordConfigProvider.NId);
    AppMethodBeat.o(279700);
  }
  
  public static void q(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(279685);
    com.tencent.threadpool.h.ahAA.bo(new f..ExternalSyntheticLambda11(paramString1, paramString2, paramLong));
    AppMethodBeat.o(279685);
  }
  
  private static final void r(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(279719);
    s.u(paramString1, "$parentPath");
    s.u(paramString2, "$filePath");
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm:ss");
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
    if ((!TextUtils.isEmpty((CharSequence)paramString1)) && (y.ZC(paramString1)))
    {
      Object localObject = y.eB(paramString1, false);
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        while (localIterator.hasNext())
        {
          j localj = (j)localIterator.next();
          localObject = localj.acpB;
          s.s(localObject, "it.relPath");
          if (n.i((CharSequence)localObject, (CharSequence)paramString2))
          {
            Date localDate = new Date(localj.agxg);
            String str = localSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis() - localj.agxg));
            if (n.bz((CharSequence)paramString1) == '/') {}
            for (localObject = s.X(paramString1, localj.acpB);; localObject = paramString1 + File.separator + localj.acpB)
            {
              Log.i("MicroMsg.MediaFileUtil", "print file path:" + (String)localObject + " data:" + localDate + " time:" + localj.agxg + " exist:" + str);
              if (System.currentTimeMillis() - localj.agxg < paramLong) {
                break;
              }
              Log.i("MicroMsg.MediaFileUtil", s.X("delete file path:", localObject));
              aOJ((String)localObject);
              break;
            }
          }
        }
      }
    }
    AppMethodBeat.o(279719);
  }
  
  public static String tH(long paramLong)
  {
    AppMethodBeat.i(76210);
    y.bDX(Obs);
    String str = Obs + "thumb" + paramLong + ".jpg";
    AppMethodBeat.o(76210);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.util.f
 * JD-Core Version:    0.7.0.1
 */