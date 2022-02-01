package com.tencent.mm.plugin.recordvideo.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.protocal.protobuf.ame;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TimeZone;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/util/MediaFileUtil;", "", "()V", "MEDIA_FILE_DELETE_SET", "", "MEDIA_FILE_KEY", "MEDIA_TIMING_DELETE_SET", "MIX_AUDIO_FILE", "MIX_BLUR_BG_FILE", "MIX_THUMB_FILE", "MIX_VIDEO_FILE", "PHOTO_EDIT_PREFIX", "PIC_FILE", "TAG", "VIDEO_FILE", "VIDEP_EDOT_PREFIX", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "videoMixPath", "videoRecordRootPath", "videoRecordTempPath", "audioEnsurePath", "parentPath", "mediaId", "checkAndMarkDeletePhotoFile", "", "key", "filePath", "checkConfigProviderCapturePath", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "checkConfigProviderPhotoEditPath", "checkConfigProviderVideoEditPath", "checkThumbSize", "Landroid/graphics/Bitmap;", "bitmap", "shortSide", "", "checkToCreateDir", "newVideoPath", "noMedia", "", "clearTimingFile", "deleteDaemonMediaFile", "mediaCaptureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "deleteDirExpiredFile", "expired", "", "deleteExpiredFile", "deleteFile", "deleteMarkFileByKey", "deleteMarkFilePath", "deleteVideoFileWithCheckPath", "exportVideo", "videoPath", "getAudioTmpPath", "getBlurBgPath", "localId", "getCaptureEditVideoPath", "getCaptureImagePath", "getCaptureThumbPath", "getCaptureVideoPath", "getEditImagePath", "getMixAudioPath", "getMixThumbPath", "getMixVideoPath", "getRecordThumbTempPath", "timeStamp", "getSubCaptureVideoParent", "getSubCaptureVideoPath", "handleDaemonNoNeedRemuxCaptureVideo", "isCaptureMedia", "handleMultiPhotoResult", "photoPath", "handleMultiVideoResult", "handleNoNeedRemuxCaptureVideo", "handleRemuxImage", "change", "handleRemuxVideo", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "handleSubRecordMux", "captureInfo", "markDeleteMediaFile", "file", "markDeletePhotoEditFile", "imagePathList", "Ljava/util/ArrayList;", "markTimingDeleteFile", "saveThumb", "thumbPath", "thumbSize", "thumbEnsurePath", "videoEnsurePath", "plugin-recordvideo_release"})
public final class d
{
  private static final String IeR;
  private static final String IeS;
  public static final String IeT;
  public static final d IeU;
  private static final MultiProcessMMKV cQO;
  
  static
  {
    AppMethodBeat.i(76218);
    IeU = new d();
    StringBuilder localStringBuilder = new StringBuilder();
    f localf = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localf, "MMKernel.storage()");
    IeR = localf.getAccPath() + "recordPlugin/";
    IeS = IeR + "temp/";
    IeT = IeR + "mix/";
    cQO = MultiProcessMMKV.getMMKV("media_file_key");
    AppMethodBeat.o(76218);
  }
  
  public static String PH(long paramLong)
  {
    AppMethodBeat.i(76210);
    u.bBD(IeS);
    String str = IeS + "thumb" + paramLong + ".jpg";
    AppMethodBeat.o(76210);
    return str;
  }
  
  public static void a(final RecordConfigProvider paramRecordConfigProvider, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(76203);
    Log.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:" + paramBoolean1 + "   change:" + paramBoolean2);
    if (paramRecordConfigProvider != null)
    {
      com.tencent.e.h.ZvG.d((Runnable)new i(paramRecordConfigProvider, paramRecordConfigProvider, paramBoolean1, paramBoolean2), "mux_save_work");
      AppMethodBeat.o(76203);
      return;
    }
    AppMethodBeat.o(76203);
  }
  
  public static void a(ame paramame)
  {
    AppMethodBeat.i(76205);
    if (paramame != null) {
      com.tencent.e.h.ZvG.d((Runnable)new j(paramame), "mux_save_work");
    }
    AppMethodBeat.o(76205);
  }
  
  public static void aRR(String paramString)
  {
    AppMethodBeat.i(76192);
    boolean bool = u.agG(paramString);
    Log.i("MicroMsg.MediaFileUtil", "path:" + paramString + "  fileExist:" + bool);
    if (bool) {
      com.tencent.e.h.ZvG.d((Runnable)new d.c(paramString), "MediaFileUtil_deleteMediaFile");
    }
    AppMethodBeat.o(76192);
  }
  
  public static void aS(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(76194);
    kotlin.g.b.p.k(paramArrayList, "imagePathList");
    paramArrayList = ((Iterable)paramArrayList).iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if ((str != null) && (n.a((CharSequence)str, (CharSequence)"photoEdited_", false) == true))
      {
        Log.i("MicroMsg.MediaFileUtil", "markDeletePhotoEditFile: ".concat(String.valueOf(str)));
        aWi(str);
      }
    }
    AppMethodBeat.o(76194);
  }
  
  public static void aWg(String paramString)
  {
    AppMethodBeat.i(217182);
    Log.i("MicroMsg.MediaFileUtil", "markTimingDeleteFile file ".concat(String.valueOf(paramString)));
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(217182);
      return;
    }
    Set localSet = cQO.decodeStringSet("media_timing_delete_set", (Set)new HashSet());
    localSet.add(paramString);
    cQO.encode("media_timing_delete_set", localSet);
    AppMethodBeat.o(217182);
  }
  
  public static void aWh(String paramString)
  {
    AppMethodBeat.i(76189);
    if (paramString != null) {
      aRR(cQO.decodeString(paramString, ""));
    }
    AppMethodBeat.o(76189);
  }
  
  public static void aWi(String paramString)
  {
    AppMethodBeat.i(76190);
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      Log.i("MicroMsg.MediaFileUtil", "cache delete file ".concat(String.valueOf(paramString)));
      Set localSet = cQO.decodeStringSet("media_file_delete_set", (Set)new HashSet());
      localSet.add(paramString);
      cQO.encode("media_file_delete_set", localSet);
    }
    AppMethodBeat.o(76190);
  }
  
  public static void aWj(String paramString)
  {
    AppMethodBeat.i(76191);
    Log.i("MicroMsg.MediaFileUtil", "deleteMarkFilePath ".concat(String.valueOf(paramString)));
    Set localSet = cQO.decodeStringSet("media_file_delete_set", (Set)new HashSet());
    if (localSet.contains(paramString))
    {
      localSet.remove(paramString);
      aRR(paramString);
    }
    cQO.encode("media_file_delete_set", localSet);
    AppMethodBeat.o(76191);
  }
  
  public static void aWk(String paramString)
  {
    AppMethodBeat.i(76193);
    Log.i("MicroMsg.MediaFileUtil", "deleteVideoFileWithCheckPath ".concat(String.valueOf(paramString)));
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      if (paramString == null) {
        break label84;
      }
      CharSequence localCharSequence = (CharSequence)paramString;
      kotlin.g.b.p.j(s.bqA(), "SubCoreVideo.getCore()");
      String str = s.getAccVideoPath();
      kotlin.g.b.p.j(str, "SubCoreVideo.getCore().accVideoPath");
      if (n.a(localCharSequence, (CharSequence)str, false) == true) {
        aRR(paramString);
      }
    }
    AppMethodBeat.o(76193);
    return;
    label84:
    AppMethodBeat.o(76193);
  }
  
  public static void aWl(String paramString)
  {
    AppMethodBeat.i(76195);
    if (paramString != null)
    {
      if (n.a((CharSequence)paramString, (CharSequence)"photoEdited_", false) == true)
      {
        Log.i("MicroMsg.MediaFileUtil", "markDeletePhotoEditFile: ".concat(String.valueOf(paramString)));
        aWi(paramString);
      }
      AppMethodBeat.o(76195);
      return;
    }
    AppMethodBeat.o(76195);
  }
  
  public static String aWm(String paramString)
  {
    AppMethodBeat.i(76200);
    kotlin.g.b.p.k(paramString, "videoPath");
    paramString = com.tencent.mm.plugin.mmsight.d.aPv(paramString);
    kotlin.g.b.p.j(paramString, "MMSightUtil.getThumbName(videoPath)");
    AppMethodBeat.o(76200);
    return paramString;
  }
  
  public static void aWn(String paramString)
  {
    AppMethodBeat.i(217188);
    if ((!TextUtils.isEmpty((CharSequence)paramString)) && (u.agG(paramString))) {
      com.tencent.e.h.ZvG.be((Runnable)new f(paramString));
    }
    AppMethodBeat.o(217188);
  }
  
  public static void aWo(String paramString)
  {
    AppMethodBeat.i(217189);
    if ((!TextUtils.isEmpty((CharSequence)paramString)) && (u.agG(paramString))) {
      com.tencent.e.h.ZvG.be((Runnable)new d.e(paramString));
    }
    AppMethodBeat.o(217189);
  }
  
  public static String aWp(String paramString)
  {
    AppMethodBeat.i(76213);
    if (paramString == null)
    {
      AppMethodBeat.o(76213);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String str = IeT;
    if (paramString == null) {}
    for (paramString = "";; paramString = str + paramString + ".v")
    {
      paramString = paramString + ".mixv";
      AppMethodBeat.o(76213);
      return paramString;
    }
  }
  
  public static String aWq(String paramString)
  {
    AppMethodBeat.i(76214);
    if (paramString == null)
    {
      AppMethodBeat.o(76214);
      return "";
    }
    paramString = jT(IeT, paramString) + ".mixt";
    AppMethodBeat.o(76214);
    return paramString;
  }
  
  public static String aWr(String paramString)
  {
    AppMethodBeat.i(163472);
    if (paramString == null)
    {
      AppMethodBeat.o(163472);
      return "";
    }
    paramString = jT(IeT, paramString) + ".blurt";
    AppMethodBeat.o(163472);
    return paramString;
  }
  
  public static void aWs(String paramString)
  {
    AppMethodBeat.i(76215);
    kotlin.g.b.p.k(paramString, "newVideoPath");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(76215);
      return;
    }
    paramString = u.bBT(paramString);
    u.bBD(paramString);
    u.bBX(paramString);
    AppMethodBeat.o(76215);
  }
  
  public static void b(final RecordConfigProvider paramRecordConfigProvider, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(76206);
    Log.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:" + paramBoolean1 + "   change:" + paramBoolean2);
    if (paramRecordConfigProvider != null)
    {
      com.tencent.e.h.ZvG.d((Runnable)new h(paramRecordConfigProvider, paramBoolean1, paramRecordConfigProvider, paramBoolean2), "mux_save_work");
      AppMethodBeat.o(76206);
      return;
    }
    AppMethodBeat.o(76206);
  }
  
  public static void c(b paramb)
  {
    AppMethodBeat.i(217190);
    if (paramb != null)
    {
      if (paramb.lfl == true) {
        com.tencent.e.h.ZvG.be((Runnable)new l(paramb));
      }
      AppMethodBeat.o(217190);
      return;
    }
    AppMethodBeat.o(217190);
  }
  
  public static void c(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(76204);
    if ((paramCaptureVideoNormalModel == null) || (!paramCaptureVideoNormalModel.fvR().booleanValue()))
    {
      AppMethodBeat.o(76204);
      return;
    }
    f localf = com.tencent.mm.kernel.h.aHG();
    kotlin.g.b.p.j(localf, "MMKernel.storage()");
    if (!localf.aHp().getBoolean(ar.a.VnX, true))
    {
      AppMethodBeat.o(76204);
      return;
    }
    com.tencent.e.h.ZvG.d((Runnable)new k(paramCaptureVideoNormalModel), "mux_save_work");
    AppMethodBeat.o(76204);
  }
  
  public static void d(b paramb)
  {
    AppMethodBeat.i(76217);
    if (paramb != null)
    {
      com.tencent.e.h.ZvG.d((Runnable)new a(paramb), "deleteDaemonMediaFile");
      AppMethodBeat.o(76217);
      return;
    }
    AppMethodBeat.o(76217);
  }
  
  public static void f(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76197);
    kotlin.g.b.p.k(paramRecordConfigProvider, "configProvider");
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.HLi))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      kotlin.g.b.p.j(s.bqA(), "SubCoreVideo.getCore()");
      paramRecordConfigProvider.HLi = (s.getAccVideoPath() + "/vsg_output_" + System.currentTimeMillis());
    }
    AppMethodBeat.o(76197);
  }
  
  public static void fzt()
  {
    AppMethodBeat.i(217183);
    Set localSet = cQO.decodeStringSet("media_timing_delete_set", (Set)new HashSet());
    kotlin.g.b.p.j(localSet, "set");
    Iterator localIterator = ((Iterable)localSet).iterator();
    while (localIterator.hasNext()) {
      aRR((String)localIterator.next());
    }
    localSet.clear();
    cQO.encode("media_timing_delete_set", localSet);
    AppMethodBeat.o(217183);
  }
  
  public static String fzu()
  {
    AppMethodBeat.i(76199);
    kotlin.g.b.p.j(s.bqA(), "SubCoreVideo.getCore()");
    String str = com.tencent.mm.plugin.mmsight.d.aPt(s.getAccVideoPath());
    kotlin.g.b.p.j(str, "MMSightUtil.getTempFileN…o.getCore().accVideoPath)");
    AppMethodBeat.o(76199);
    return str;
  }
  
  public static String fzv()
  {
    AppMethodBeat.i(217185);
    kotlin.g.b.p.j(s.bqA(), "SubCoreVideo.getCore()");
    String str = s.bqJ();
    kotlin.g.b.p.j(str, "SubCoreVideo.getCore().subVideoPath");
    AppMethodBeat.o(217185);
    return str;
  }
  
  public static String fzw()
  {
    AppMethodBeat.i(76201);
    String str = "photoEdited_" + System.currentTimeMillis();
    Object localObject2 = u.n("wcf://temp/".concat(String.valueOf(str)), true);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new StringBuilder();
      localObject2 = MMApplicationContext.getContext();
      kotlin.g.b.p.j(localObject2, "MMApplicationContext.getContext()");
      localObject2 = ((Context)localObject2).getCacheDir();
      kotlin.g.b.p.j(localObject2, "MMApplicationContext.getContext().cacheDir");
      localObject1 = ((File)localObject2).getAbsolutePath() + '/' + str;
    }
    AppMethodBeat.o(76201);
    return localObject1;
  }
  
  public static String fzx()
  {
    AppMethodBeat.i(76202);
    String str = "photoCapture_" + System.currentTimeMillis();
    Object localObject2 = u.n("wcf://temp/".concat(String.valueOf(str)), true);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new StringBuilder();
      localObject2 = MMApplicationContext.getContext();
      kotlin.g.b.p.j(localObject2, "MMApplicationContext.getContext()");
      localObject2 = ((Context)localObject2).getCacheDir();
      kotlin.g.b.p.j(localObject2, "MMApplicationContext.getContext().cacheDir");
      localObject1 = ((File)localObject2).getAbsolutePath() + '/' + str;
    }
    AppMethodBeat.o(76202);
    return localObject1;
  }
  
  public static void g(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76198);
    kotlin.g.b.p.k(paramRecordConfigProvider, "configProvider");
    StringBuilder localStringBuilder;
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.thumbPath))
    {
      localStringBuilder = new StringBuilder();
      kotlin.g.b.p.j(s.bqA(), "SubCoreVideo.getCore()");
      paramRecordConfigProvider.thumbPath = (s.getAccVideoPath() + "/vsg_thumb_" + System.currentTimeMillis());
    }
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.HLg))
    {
      localStringBuilder = new StringBuilder();
      kotlin.g.b.p.j(s.bqA(), "SubCoreVideo.getCore()");
      paramRecordConfigProvider.HLg = (s.getAccVideoPath() + "/vsg_output_" + System.currentTimeMillis());
    }
    AppMethodBeat.o(76198);
  }
  
  public static boolean h(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76207);
    Log.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:true  ");
    if (paramRecordConfigProvider != null) {
      com.tencent.e.h.ZvG.d((Runnable)new d(paramRecordConfigProvider), "mux_save_work_daemon");
    }
    AppMethodBeat.o(76207);
    return true;
  }
  
  public static boolean i(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76208);
    Log.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:true  ");
    if (paramRecordConfigProvider != null)
    {
      if (u.agG(paramRecordConfigProvider.HLf)) {
        com.tencent.mm.platformtools.p.n(MMApplicationContext.getContext(), paramRecordConfigProvider.HLf, paramRecordConfigProvider.HLg);
      }
      com.tencent.e.h.ZvG.d((Runnable)new g(paramRecordConfigProvider), "handleNoNeedRemuxCaptureVideo");
    }
    AppMethodBeat.o(76208);
    return true;
  }
  
  public static void jR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76188);
    Log.i("MicroMsg.MediaFileUtil", "cache delete key: " + paramString1 + " , file " + paramString2);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(76188);
      return;
    }
    cQO.encode(paramString1, paramString2);
    AppMethodBeat.o(76188);
  }
  
  public static void jS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76196);
    Log.i("MicroMsg.MediaFileUtil", "checkAndMarkDeletePhotoFile key:" + paramString1 + " filePath:" + paramString2);
    if ((TextUtils.isEmpty((CharSequence)paramString1)) || (TextUtils.isEmpty((CharSequence)paramString2)))
    {
      AppMethodBeat.o(76196);
      return;
    }
    if (paramString2 == null) {
      kotlin.g.b.p.iCn();
    }
    if (n.g((CharSequence)paramString2, (CharSequence)"photoEdited_")) {
      jR(paramString1, paramString2);
    }
    AppMethodBeat.o(76196);
  }
  
  private static String jT(String paramString1, String paramString2)
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
  
  public static String jU(String paramString1, String paramString2)
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
  
  public static Bitmap k(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(76209);
    kotlin.g.b.p.k(paramBitmap, "bitmap");
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
        kotlin.g.b.p.j(paramBitmap, "Bitmap.createScaledBitma…idth, outputHeight, true)");
        AppMethodBeat.o(76209);
        return paramBitmap;
        i = (int)(paramBitmap.getWidth() * paramInt * 1.0F / paramBitmap.getHeight());
      }
    }
    AppMethodBeat.o(76209);
    return paramBitmap;
  }
  
  public static void p(String paramString1, final String paramString2, final long paramLong)
  {
    AppMethodBeat.i(217195);
    com.tencent.e.h.ZvG.bg((Runnable)new b(paramString1, paramString2, paramLong));
    AppMethodBeat.o(217195);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(76178);
      Log.i("MicroMsg.MediaFileUtil", "deleteDaemonMediaFile");
      d locald = d.IeU;
      d.aRR(this.IeV.lfm);
      locald = d.IeU;
      d.aRR(this.IeV.lfn);
      AppMethodBeat.o(76178);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(String paramString1, String paramString2, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(225428);
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm:ss");
      localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
      if ((!TextUtils.isEmpty((CharSequence)this.IeW)) && (u.agG(this.IeW)))
      {
        q[] arrayOfq = new q(this.IeW).ifJ();
        if (arrayOfq != null)
        {
          int j = arrayOfq.length;
          int i = 0;
          while (i < j)
          {
            q localq = arrayOfq[i];
            kotlin.g.b.p.j(localq, "it");
            Object localObject = localq.bOF();
            kotlin.g.b.p.j(localObject, "it.absolutePath");
            if (n.g((CharSequence)localObject, (CharSequence)paramString2))
            {
              localObject = new Date(localq.lastModified());
              String str = localSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis() - localq.lastModified()));
              Log.i("MicroMsg.MediaFileUtil", "print file path:" + localq.bOF() + " data:" + localObject + " time:" + localq.lastModified() + " exist:" + str);
              if (System.currentTimeMillis() - localq.lastModified() >= paramLong)
              {
                Log.i("MicroMsg.MediaFileUtil", "delete file path:" + localq.bOF());
                localObject = d.IeU;
                d.aRR(localq.bOF());
              }
            }
            i += 1;
          }
          AppMethodBeat.o(225428);
          return;
        }
      }
      AppMethodBeat.o(225428);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(RecordConfigProvider paramRecordConfigProvider) {}
    
    public final void run()
    {
      AppMethodBeat.i(76182);
      Object localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      boolean bool = ((f)localObject).aHp().getBoolean(ar.a.VnX, true);
      Log.i("MicroMsg.MediaFileUtil", "handleDaemonNoNeedRemuxCaptureVideo videoState : " + bool + ' ');
      if (bool)
      {
        localObject = com.tencent.mm.plugin.mmsight.d.getExportImagePath("mp4");
        com.tencent.mm.platformtools.p.n(MMApplicationContext.getContext(), this.HOQ.HLg, (String)localObject);
        AndroidMediaUtil.refreshMediaScanner((String)localObject, MMApplicationContext.getContext());
      }
      localObject = d.IeU;
      d.aRR(this.HOQ.HLf);
      AppMethodBeat.o(76182);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(222572);
      Object localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      boolean bool = ((f)localObject).aHp().getBoolean(ar.a.VnX, true);
      Log.i("MicroMsg.MediaFileUtil", "remuxComposition videoState : " + bool + " videoPath:" + this.prl);
      if (bool)
      {
        localObject = AndroidMediaUtil.getExportImagePath("mp4");
        Context localContext = MMApplicationContext.getContext();
        String str = this.prl;
        if (str == null) {
          kotlin.g.b.p.iCn();
        }
        com.tencent.mm.platformtools.p.n(localContext, str, (String)localObject);
        AndroidMediaUtil.refreshMediaScanner((String)localObject, MMApplicationContext.getContext());
      }
      AppMethodBeat.o(222572);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(RecordConfigProvider paramRecordConfigProvider) {}
    
    public final void run()
    {
      AppMethodBeat.i(76183);
      Log.i("MicroMsg.MediaFileUtil", "handleNoNeedRemuxCaptureVideo");
      Object localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      boolean bool = ((f)localObject).aHp().getBoolean(ar.a.VnX, true);
      Log.i("MicroMsg.MediaFileUtil", "handleNoNeedRemuxCaptureVideo videoState : " + bool + ' ');
      if (bool)
      {
        localObject = com.tencent.mm.plugin.mmsight.d.getExportImagePath("mp4");
        com.tencent.mm.platformtools.p.n(MMApplicationContext.getContext(), this.HOQ.HLg, (String)localObject);
        AndroidMediaUtil.refreshMediaScanner((String)localObject, MMApplicationContext.getContext());
      }
      localObject = d.IeU;
      d.aRR(this.HOQ.HLf);
      AppMethodBeat.o(76183);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/util/MediaFileUtil$handleRemuxImage$1$1"})
  static final class h
    implements Runnable
  {
    h(RecordConfigProvider paramRecordConfigProvider1, boolean paramBoolean1, RecordConfigProvider paramRecordConfigProvider2, boolean paramBoolean2) {}
    
    public final void run()
    {
      AppMethodBeat.i(76184);
      if (!this.HOQ.HLd)
      {
        localObject = d.IeU;
        d.aRR(this.HOQ.HLh);
      }
      Object localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      boolean bool = ((f)localObject).aHp().getBoolean(ar.a.VnW, true);
      Log.i("MicroMsg.MediaFileUtil", "imageState : " + bool + ' ');
      if (!bool)
      {
        AppMethodBeat.o(76184);
        return;
      }
      if (((paramBoolean1) && (bool)) || ((!paramBoolean1) && (paramRecordConfigProvider.HLe) && (paramBoolean2)))
      {
        localObject = com.tencent.mm.plugin.mmsight.d.getExportImagePath("jpg");
        if (!paramBoolean1) {
          localObject = AndroidMediaUtil.getExportImagePath("jpg");
        }
        Log.i("MicroMsg.MediaFileUtil", "auto save pic src " + paramRecordConfigProvider.HLi + " dest " + (String)localObject + ' ');
        com.tencent.mm.platformtools.p.l(MMApplicationContext.getContext(), paramRecordConfigProvider.HLi, (String)localObject);
        AndroidMediaUtil.refreshMediaScanner((String)localObject, MMApplicationContext.getContext());
      }
      AppMethodBeat.o(76184);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/util/MediaFileUtil$handleRemuxVideo$1$1"})
  static final class i
    implements Runnable
  {
    i(RecordConfigProvider paramRecordConfigProvider1, RecordConfigProvider paramRecordConfigProvider2, boolean paramBoolean1, boolean paramBoolean2) {}
    
    public final void run()
    {
      AppMethodBeat.i(76185);
      if (!paramRecordConfigProvider.HLd)
      {
        localObject = d.IeU;
        d.aRR(this.HOQ.HLf);
      }
      Object localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      boolean bool = ((f)localObject).aHp().getBoolean(ar.a.VnX, true);
      Log.i("MicroMsg.MediaFileUtil", "videoState : " + bool + ' ');
      if (!bool)
      {
        AppMethodBeat.o(76185);
        return;
      }
      if ((paramBoolean1) || ((!paramBoolean1) && (paramRecordConfigProvider.HLe) && (paramBoolean2)))
      {
        localObject = com.tencent.mm.plugin.mmsight.d.getExportImagePath("mp4");
        if (!paramBoolean1) {
          localObject = AndroidMediaUtil.getExportImagePath("mp4");
        }
        Log.i("MicroMsg.MediaFileUtil", "auto save video :".concat(String.valueOf(localObject)));
        com.tencent.mm.platformtools.p.n(MMApplicationContext.getContext(), this.HOQ.HLg, (String)localObject);
        AndroidMediaUtil.refreshMediaScanner((String)localObject, MMApplicationContext.getContext());
      }
      AppMethodBeat.o(76185);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/util/MediaFileUtil$handleRemuxVideo$3$1"})
  static final class j
    implements Runnable
  {
    j(ame paramame) {}
    
    public final void run()
    {
      AppMethodBeat.i(76186);
      if (!this.Ifc.HLd)
      {
        localObject = d.IeU;
        d.aRR(this.Ifc.HLf);
      }
      Object localObject = com.tencent.mm.kernel.h.aHG();
      kotlin.g.b.p.j(localObject, "MMKernel.storage()");
      if (!((f)localObject).aHp().getBoolean(ar.a.VnX, true))
      {
        AppMethodBeat.o(76186);
        return;
      }
      if ((this.Ifc.SwB) || ((!this.Ifc.SwB) && (this.Ifc.HLe) && (this.Ifc.NiN)))
      {
        localObject = com.tencent.mm.plugin.mmsight.d.getExportImagePath("mp4");
        if (!this.Ifc.SwB) {
          localObject = AndroidMediaUtil.getExportImagePath("mp4");
        }
        com.tencent.mm.platformtools.p.n(MMApplicationContext.getContext(), this.Ifc.HLg, (String)localObject);
        AndroidMediaUtil.refreshMediaScanner((String)localObject, MMApplicationContext.getContext());
      }
      AppMethodBeat.o(76186);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel) {}
    
    public final void run()
    {
      AppMethodBeat.i(76187);
      String str = AndroidMediaUtil.getExportImagePath("mp4");
      com.tencent.mm.platformtools.p.n(MMApplicationContext.getContext(), this.HGn.getVideoPath(), str);
      Log.i("MicroMsg.MediaFileUtil", "handleRemuxVideo save video" + this.HGn.getVideoPath() + " exist:" + u.agG(this.HGn.getVideoPath()) + " to:" + str);
      AndroidMediaUtil.refreshMediaScanner(str, MMApplicationContext.getContext());
      AppMethodBeat.o(76187);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(218127);
      Iterator localIterator = ((Iterable)this.Ifd.lfs).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Log.i("MicroMsg.MediaFileUtil", "delete file:".concat(String.valueOf(str)));
        d locald = d.IeU;
        d.aRR(str);
      }
      AppMethodBeat.o(218127);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.d
 * JD-Core Version:    0.7.0.1
 */