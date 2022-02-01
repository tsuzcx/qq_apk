package com.tencent.mm.plugin.recordvideo.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.s;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TimeZone;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/util/MediaFileUtil;", "", "()V", "MEDIA_FILE_DELETE_SET", "", "MEDIA_FILE_KEY", "MEDIA_TIMING_DELETE_SET", "MIX_AUDIO_FILE", "MIX_BLUR_BG_FILE", "MIX_THUMB_FILE", "MIX_VIDEO_FILE", "PHOTO_EDIT_PREFIX", "PIC_FILE", "TAG", "VIDEO_FILE", "VIDEP_EDOT_PREFIX", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "videoMixPath", "videoRecordRootPath", "videoRecordTempPath", "audioEnsurePath", "parentPath", "mediaId", "checkAndMarkDeletePhotoFile", "", "key", "filePath", "checkConfigProviderCapturePath", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "checkConfigProviderPhotoEditPath", "checkConfigProviderVideoEditPath", "checkThumbSize", "Landroid/graphics/Bitmap;", "bitmap", "shortSide", "", "checkToCreateDir", "newVideoPath", "noMedia", "", "clearTimingFile", "deleteBizFile", "deleteDaemonMediaFile", "mediaCaptureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "deleteDirExpiredFile", "expired", "", "deleteExpiredFile", "deleteFile", "deleteMarkFileByKey", "deleteMarkFilePath", "deleteVideoFileWithCheckPath", "exportVideo", "videoPath", "getAudioTmpPath", "getBlurBgPath", "localId", "getCaptureEditVideoPath", "getCaptureImagePath", "getCaptureThumbPath", "getCaptureVideoPath", "getEditImagePath", "getMixAudioPath", "getMixThumbPath", "getMixVideoPath", "getRecordThumbTempPath", "timeStamp", "getSubCaptureVideoParent", "getSubCaptureVideoPath", "handleDaemonNoNeedRemuxCaptureVideo", "isCaptureMedia", "handleMultiPhotoResult", "photoPath", "handleMultiVideoResult", "handleNoNeedRemuxCaptureVideo", "handleRemuxImage", "change", "handleRemuxVideo", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "handleSubRecordMux", "captureInfo", "markDeleteMediaFile", "file", "markDeletePhotoEditFile", "imagePathList", "Ljava/util/ArrayList;", "markTimingDeleteFile", "saveThumb", "thumbPath", "thumbSize", "thumbEnsurePath", "videoEnsurePath", "plugin-recordvideo_release"})
public final class c
{
  private static final String ChZ;
  private static final String Cia;
  private static final String Cib;
  public static final c Cic;
  private static final MultiProcessMMKV cQe;
  
  static
  {
    AppMethodBeat.i(76218);
    Cic = new c();
    StringBuilder localStringBuilder = new StringBuilder();
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    ChZ = locale.getAccPath() + "recordPlugin/";
    Cia = ChZ + "temp/";
    Cib = ChZ + "mix/";
    cQe = MultiProcessMMKV.getMMKV("media_file_key");
    AppMethodBeat.o(76218);
  }
  
  public static String In(long paramLong)
  {
    AppMethodBeat.i(76210);
    s.boN(Cia);
    String str = Cia + "thumb" + paramLong + ".jpg";
    AppMethodBeat.o(76210);
    return str;
  }
  
  public static void a(final RecordConfigProvider paramRecordConfigProvider, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(76203);
    Log.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:" + paramBoolean1 + "   change:" + paramBoolean2);
    if (paramRecordConfigProvider != null)
    {
      h.RTc.b((Runnable)new l(paramRecordConfigProvider, paramRecordConfigProvider, paramBoolean1, paramBoolean2), "mux_save_work");
      AppMethodBeat.o(76203);
      return;
    }
    AppMethodBeat.o(76203);
  }
  
  public static void a(ald paramald)
  {
    AppMethodBeat.i(76205);
    if (paramald != null) {
      h.RTc.b((Runnable)new m(paramald), "mux_save_work");
    }
    AppMethodBeat.o(76205);
  }
  
  public static void aHD(String paramString)
  {
    AppMethodBeat.i(76192);
    if (!TextUtils.isEmpty((CharSequence)paramString)) {
      h.RTc.b((Runnable)new d(paramString), "MediaFileUtil_deleteMediaFile");
    }
    AppMethodBeat.o(76192);
  }
  
  public static void aL(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(76194);
    p.h(paramArrayList, "imagePathList");
    paramArrayList = ((Iterable)paramArrayList).iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if ((str != null) && (n.a((CharSequence)str, (CharSequence)"photoEdited_", false) == true))
      {
        Log.i("MicroMsg.MediaFileUtil", "markDeletePhotoEditFile: ".concat(String.valueOf(str)));
        aLE(str);
      }
    }
    AppMethodBeat.o(76194);
  }
  
  public static void aLC(String paramString)
  {
    AppMethodBeat.i(237981);
    Log.i("MicroMsg.MediaFileUtil", "markTimingDeleteFile file ".concat(String.valueOf(paramString)));
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      AppMethodBeat.o(237981);
      return;
    }
    Set localSet = cQe.decodeStringSet("media_timing_delete_set", (Set)new HashSet());
    localSet.add(paramString);
    cQe.encode("media_timing_delete_set", localSet);
    AppMethodBeat.o(237981);
  }
  
  public static void aLD(String paramString)
  {
    AppMethodBeat.i(76189);
    if (paramString != null)
    {
      paramString = cQe.decodeString(paramString, "");
      if (!TextUtils.isEmpty((CharSequence)paramString)) {
        h.RTc.b((Runnable)new e(paramString), "MediaFileUtil_deleteMediaFile");
      }
    }
    AppMethodBeat.o(76189);
  }
  
  public static void aLE(String paramString)
  {
    AppMethodBeat.i(76190);
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      Log.i("MicroMsg.MediaFileUtil", "cache delete file ".concat(String.valueOf(paramString)));
      Set localSet = cQe.decodeStringSet("media_file_delete_set", (Set)new HashSet());
      localSet.add(paramString);
      cQe.encode("media_file_delete_set", localSet);
    }
    AppMethodBeat.o(76190);
  }
  
  public static void aLF(String paramString)
  {
    AppMethodBeat.i(76191);
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      Set localSet = cQe.decodeStringSet("media_file_delete_set", (Set)new HashSet());
      if (localSet.contains(paramString))
      {
        localSet.remove(paramString);
        if (!TextUtils.isEmpty((CharSequence)paramString)) {
          h.RTc.b((Runnable)new f(paramString), "MediaFileUtil_deleteMediaFile");
        }
      }
    }
    AppMethodBeat.o(76191);
  }
  
  public static void aLG(String paramString)
  {
    AppMethodBeat.i(76193);
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      if (paramString == null) {
        break label69;
      }
      CharSequence localCharSequence = (CharSequence)paramString;
      p.g(com.tencent.mm.modelvideo.o.bhi(), "SubCoreVideo.getCore()");
      String str = com.tencent.mm.modelvideo.o.getAccVideoPath();
      p.g(str, "SubCoreVideo.getCore().accVideoPath");
      if (n.a(localCharSequence, (CharSequence)str, false) == true) {
        aHD(paramString);
      }
    }
    AppMethodBeat.o(76193);
    return;
    label69:
    AppMethodBeat.o(76193);
  }
  
  public static void aLH(String paramString)
  {
    AppMethodBeat.i(76195);
    if (paramString != null)
    {
      if (n.a((CharSequence)paramString, (CharSequence)"photoEdited_", false) == true)
      {
        Log.i("MicroMsg.MediaFileUtil", "markDeletePhotoEditFile: ".concat(String.valueOf(paramString)));
        aLE(paramString);
      }
      AppMethodBeat.o(76195);
      return;
    }
    AppMethodBeat.o(76195);
  }
  
  public static String aLI(String paramString)
  {
    AppMethodBeat.i(76200);
    p.h(paramString, "videoPath");
    paramString = d.aFl(paramString);
    p.g(paramString, "MMSightUtil.getThumbName(videoPath)");
    AppMethodBeat.o(76200);
    return paramString;
  }
  
  public static void aLJ(String paramString)
  {
    AppMethodBeat.i(237984);
    if ((!TextUtils.isEmpty((CharSequence)paramString)) && (s.YS(paramString))) {
      h.RTc.aX((Runnable)new i(paramString));
    }
    AppMethodBeat.o(237984);
  }
  
  public static void aLK(String paramString)
  {
    AppMethodBeat.i(237985);
    if ((!TextUtils.isEmpty((CharSequence)paramString)) && (s.YS(paramString))) {
      h.RTc.aX((Runnable)new h(paramString));
    }
    AppMethodBeat.o(237985);
  }
  
  public static String aLL(String paramString)
  {
    AppMethodBeat.i(76213);
    if (paramString == null)
    {
      AppMethodBeat.o(76213);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String str = Cib;
    if (paramString == null) {}
    for (paramString = "";; paramString = str + paramString + ".v")
    {
      paramString = paramString + ".mixv";
      AppMethodBeat.o(76213);
      return paramString;
    }
  }
  
  public static String aLM(String paramString)
  {
    AppMethodBeat.i(76214);
    if (paramString == null)
    {
      AppMethodBeat.o(76214);
      return "";
    }
    paramString = jF(Cib, paramString) + ".mixt";
    AppMethodBeat.o(76214);
    return paramString;
  }
  
  public static String aLN(String paramString)
  {
    AppMethodBeat.i(163472);
    if (paramString == null)
    {
      AppMethodBeat.o(163472);
      return "";
    }
    paramString = jF(Cib, paramString) + ".blurt";
    AppMethodBeat.o(163472);
    return paramString;
  }
  
  public static String aLO(String paramString)
  {
    AppMethodBeat.i(237987);
    if (paramString == null)
    {
      AppMethodBeat.o(237987);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String str = Cib;
    if (paramString == null) {}
    for (paramString = "";; paramString = str + paramString + ".p")
    {
      paramString = paramString + ".mixa";
      AppMethodBeat.o(237987);
      return paramString;
    }
  }
  
  public static void aLP(String paramString)
  {
    AppMethodBeat.i(76215);
    p.h(paramString, "newVideoPath");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(76215);
      return;
    }
    paramString = s.boZ(paramString);
    s.boN(paramString);
    s.bpc(paramString);
    AppMethodBeat.o(76215);
  }
  
  public static void b(final RecordConfigProvider paramRecordConfigProvider, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(76206);
    Log.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:" + paramBoolean1 + "   change:" + paramBoolean2);
    if (paramRecordConfigProvider != null)
    {
      h.RTc.b((Runnable)new k(paramRecordConfigProvider, paramBoolean1, paramRecordConfigProvider, paramBoolean2), "mux_save_work");
      AppMethodBeat.o(76206);
      return;
    }
    AppMethodBeat.o(76206);
  }
  
  public static void c(b paramb)
  {
    AppMethodBeat.i(237986);
    if (paramb != null)
    {
      if (paramb.iqf == true) {
        h.RTc.aX((Runnable)new o(paramb));
      }
      AppMethodBeat.o(237986);
      return;
    }
    AppMethodBeat.o(237986);
  }
  
  public static void c(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(76204);
    if ((paramCaptureVideoNormalModel == null) || (!paramCaptureVideoNormalModel.eJG().booleanValue()))
    {
      AppMethodBeat.o(76204);
      return;
    }
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    if (!locale.azQ().getBoolean(ar.a.NZW, true))
    {
      AppMethodBeat.o(76204);
      return;
    }
    h.RTc.b((Runnable)new n(paramCaptureVideoNormalModel), "mux_save_work");
    AppMethodBeat.o(76204);
  }
  
  public static void d(b paramb)
  {
    AppMethodBeat.i(76217);
    if (paramb != null)
    {
      h.RTc.b((Runnable)new b(paramb), "deleteDaemonMediaFile");
      AppMethodBeat.o(76217);
      return;
    }
    AppMethodBeat.o(76217);
  }
  
  public static void d(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76197);
    p.h(paramRecordConfigProvider, "configProvider");
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.BOC))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      p.g(com.tencent.mm.modelvideo.o.bhi(), "SubCoreVideo.getCore()");
      paramRecordConfigProvider.BOC = (com.tencent.mm.modelvideo.o.getAccVideoPath() + "/vsg_output_" + System.currentTimeMillis());
    }
    AppMethodBeat.o(76197);
  }
  
  public static void e(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76198);
    p.h(paramRecordConfigProvider, "configProvider");
    StringBuilder localStringBuilder;
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.thumbPath))
    {
      localStringBuilder = new StringBuilder();
      p.g(com.tencent.mm.modelvideo.o.bhi(), "SubCoreVideo.getCore()");
      paramRecordConfigProvider.thumbPath = (com.tencent.mm.modelvideo.o.getAccVideoPath() + "/vsg_thumb_" + System.currentTimeMillis());
    }
    if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.BOA))
    {
      localStringBuilder = new StringBuilder();
      p.g(com.tencent.mm.modelvideo.o.bhi(), "SubCoreVideo.getCore()");
      paramRecordConfigProvider.BOA = (com.tencent.mm.modelvideo.o.getAccVideoPath() + "/vsg_output_" + System.currentTimeMillis());
    }
    AppMethodBeat.o(76198);
  }
  
  public static void eMH()
  {
    AppMethodBeat.i(237982);
    h.RTc.aX((Runnable)a.Cid);
    AppMethodBeat.o(237982);
  }
  
  public static String eMI()
  {
    AppMethodBeat.i(76199);
    p.g(com.tencent.mm.modelvideo.o.bhi(), "SubCoreVideo.getCore()");
    String str = d.aFj(com.tencent.mm.modelvideo.o.getAccVideoPath());
    p.g(str, "MMSightUtil.getTempFileN…o.getCore().accVideoPath)");
    AppMethodBeat.o(76199);
    return str;
  }
  
  public static String eMJ()
  {
    AppMethodBeat.i(237983);
    p.g(com.tencent.mm.modelvideo.o.bhi(), "SubCoreVideo.getCore()");
    String str = com.tencent.mm.modelvideo.o.bhr();
    p.g(str, "SubCoreVideo.getCore().subVideoPath");
    AppMethodBeat.o(237983);
    return str;
  }
  
  public static String eMK()
  {
    AppMethodBeat.i(76201);
    String str = "photoEdited_" + System.currentTimeMillis();
    Object localObject2 = s.k("wcf://temp/".concat(String.valueOf(str)), true);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new StringBuilder();
      localObject2 = MMApplicationContext.getContext();
      p.g(localObject2, "MMApplicationContext.getContext()");
      localObject2 = ((Context)localObject2).getCacheDir();
      p.g(localObject2, "MMApplicationContext.getContext().cacheDir");
      localObject1 = ((File)localObject2).getAbsolutePath() + '/' + str;
    }
    AppMethodBeat.o(76201);
    return localObject1;
  }
  
  public static String eML()
  {
    AppMethodBeat.i(76202);
    String str = "photoCapture_" + System.currentTimeMillis();
    Object localObject2 = s.k("wcf://temp/".concat(String.valueOf(str)), true);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new StringBuilder();
      localObject2 = MMApplicationContext.getContext();
      p.g(localObject2, "MMApplicationContext.getContext()");
      localObject2 = ((Context)localObject2).getCacheDir();
      p.g(localObject2, "MMApplicationContext.getContext().cacheDir");
      localObject1 = ((File)localObject2).getAbsolutePath() + '/' + str;
    }
    AppMethodBeat.o(76202);
    return localObject1;
  }
  
  public static boolean f(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76207);
    Log.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:true  ");
    if (paramRecordConfigProvider != null) {
      h.RTc.b((Runnable)new g(paramRecordConfigProvider), "mux_save_work_daemon");
    }
    AppMethodBeat.o(76207);
    return true;
  }
  
  public static boolean g(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76208);
    Log.i("MicroMsg.MediaFileUtil", "configProvider : " + paramRecordConfigProvider + "  isCaptureMedia:true  ");
    if (paramRecordConfigProvider != null)
    {
      if (s.YS(paramRecordConfigProvider.BOz)) {
        s.nw(paramRecordConfigProvider.BOz, paramRecordConfigProvider.BOA);
      }
      h.RTc.b((Runnable)new j(paramRecordConfigProvider), "handleNoNeedRemuxCaptureVideo");
    }
    AppMethodBeat.o(76208);
    return true;
  }
  
  public static Bitmap j(Bitmap paramBitmap, int paramInt)
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
  
  public static void jD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76188);
    Log.i("MicroMsg.MediaFileUtil", "cache delete key: " + paramString1 + " , file " + paramString2);
    if ((paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(76188);
      return;
    }
    cQe.encode(paramString1, paramString2);
    AppMethodBeat.o(76188);
  }
  
  public static void jE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76196);
    if ((TextUtils.isEmpty((CharSequence)paramString1)) || (TextUtils.isEmpty((CharSequence)paramString2)))
    {
      AppMethodBeat.o(76196);
      return;
    }
    if (paramString2 == null) {
      p.hyc();
    }
    if (n.a((CharSequence)paramString2, (CharSequence)"photoEdited_", false)) {
      jD(paramString1, paramString2);
    }
    AppMethodBeat.o(76196);
  }
  
  private static String jF(String paramString1, String paramString2)
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
  
  public static void n(String paramString1, final String paramString2, final long paramLong)
  {
    AppMethodBeat.i(237989);
    h.RTc.aZ((Runnable)new c(paramString1, paramString2, paramLong));
    AppMethodBeat.o(237989);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a Cid;
    
    static
    {
      AppMethodBeat.i(237976);
      Cid = new a();
      AppMethodBeat.o(237976);
    }
    
    public final void run()
    {
      AppMethodBeat.i(237975);
      Object localObject1 = c.Cic;
      localObject1 = c.eMM().decodeStringSet("media_file_delete_set", (Set)new HashSet());
      p.g(localObject1, "set");
      Object localObject2 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject2).hasNext()) {
        s.deleteFile((String)((Iterator)localObject2).next());
      }
      ((Set)localObject1).clear();
      localObject2 = c.Cic;
      c.eMM().encode("media_timing_delete_set", (Set)localObject1);
      AppMethodBeat.o(237975);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(76178);
      Log.i("MicroMsg.MediaFileUtil", "deleteDaemonMediaFile");
      s.deleteFile(this.Cie.iqh);
      s.deleteFile(this.Cie.iqi);
      AppMethodBeat.o(76178);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(String paramString1, String paramString2, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(237977);
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm:ss");
      localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
      if ((!TextUtils.isEmpty((CharSequence)this.Cif)) && (s.YS(this.Cif)))
      {
        com.tencent.mm.vfs.o[] arrayOfo = new com.tencent.mm.vfs.o(this.Cif).het();
        if (arrayOfo != null)
        {
          int j = arrayOfo.length;
          int i = 0;
          while (i < j)
          {
            com.tencent.mm.vfs.o localo = arrayOfo[i];
            p.g(localo, "it");
            Object localObject = localo.getAbsolutePath();
            p.g(localObject, "it.absolutePath");
            if (n.e((CharSequence)localObject, (CharSequence)paramString2))
            {
              localObject = new Date(localo.lastModified());
              String str = localSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis() - localo.lastModified()));
              Log.i("MicroMsg.MediaFileUtil", "print file path:" + localo.getAbsolutePath() + " data:" + localObject + " time:" + localo.lastModified() + " exist:" + str);
              if (System.currentTimeMillis() - localo.lastModified() >= paramLong)
              {
                Log.i("MicroMsg.MediaFileUtil", "delete file path:" + localo.getAbsolutePath());
                s.deleteFile(localo.getAbsolutePath());
              }
            }
            i += 1;
          }
          AppMethodBeat.o(237977);
          return;
        }
      }
      AppMethodBeat.o(237977);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(76179);
      Log.i("MicroMsg.MediaFileUtil", "deleteMediaFile file:" + this.msC);
      s.deleteFile(this.msC);
      AppMethodBeat.o(76179);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(76180);
      Log.i("MicroMsg.MediaFileUtil", "deleteMediaFile file:" + this.msC);
      s.deleteFile(this.msC);
      AppMethodBeat.o(76180);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(76181);
      Log.i("MicroMsg.MediaFileUtil", "deleteMediaFile file:" + this.msC);
      s.deleteFile(this.msC);
      AppMethodBeat.o(76181);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(RecordConfigProvider paramRecordConfigProvider) {}
    
    public final void run()
    {
      AppMethodBeat.i(76182);
      Object localObject = g.aAh();
      p.g(localObject, "MMKernel.storage()");
      boolean bool = ((e)localObject).azQ().getBoolean(ar.a.NZW, true);
      Log.i("MicroMsg.MediaFileUtil", "handleDaemonNoNeedRemuxCaptureVideo videoState : " + bool + ' ');
      if (bool)
      {
        localObject = d.getExportImagePath("mp4");
        s.nw(this.BSb.BOA, (String)localObject);
        AndroidMediaUtil.refreshMediaScanner((String)localObject, MMApplicationContext.getContext());
      }
      s.deleteFile(this.BSb.BOz);
      AppMethodBeat.o(76182);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(237978);
      Object localObject = g.aAh();
      p.g(localObject, "MMKernel.storage()");
      boolean bool = ((e)localObject).azQ().getBoolean(ar.a.NZV, true);
      Log.i("MicroMsg.MediaFileUtil", "handleMultiVideoResult videoState : " + bool + ' ');
      if (bool)
      {
        localObject = AndroidMediaUtil.getExportImagePath("jpg");
        s.nw(this.Cih, (String)localObject);
        AndroidMediaUtil.refreshMediaScanner((String)localObject, MMApplicationContext.getContext());
      }
      AppMethodBeat.o(237978);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(237979);
      Object localObject = g.aAh();
      p.g(localObject, "MMKernel.storage()");
      boolean bool = ((e)localObject).azQ().getBoolean(ar.a.NZW, true);
      Log.i("MicroMsg.MediaFileUtil", "remuxComposition videoState : " + bool + " videoPath:" + this.mtb);
      if (bool)
      {
        localObject = AndroidMediaUtil.getExportImagePath("mp4");
        s.nw(this.mtb, (String)localObject);
        AndroidMediaUtil.refreshMediaScanner((String)localObject, MMApplicationContext.getContext());
      }
      AppMethodBeat.o(237979);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(RecordConfigProvider paramRecordConfigProvider) {}
    
    public final void run()
    {
      AppMethodBeat.i(76183);
      Log.i("MicroMsg.MediaFileUtil", "handleNoNeedRemuxCaptureVideo");
      Object localObject = g.aAh();
      p.g(localObject, "MMKernel.storage()");
      boolean bool = ((e)localObject).azQ().getBoolean(ar.a.NZW, true);
      Log.i("MicroMsg.MediaFileUtil", "handleNoNeedRemuxCaptureVideo videoState : " + bool + ' ');
      if (bool)
      {
        localObject = d.getExportImagePath("mp4");
        s.nw(this.BSb.BOA, (String)localObject);
        AndroidMediaUtil.refreshMediaScanner((String)localObject, MMApplicationContext.getContext());
      }
      s.deleteFile(this.BSb.BOz);
      AppMethodBeat.o(76183);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/util/MediaFileUtil$handleRemuxImage$1$1"})
  static final class k
    implements Runnable
  {
    k(RecordConfigProvider paramRecordConfigProvider1, boolean paramBoolean1, RecordConfigProvider paramRecordConfigProvider2, boolean paramBoolean2) {}
    
    public final void run()
    {
      AppMethodBeat.i(76184);
      if (!this.BSb.BOx) {
        s.deleteFile(this.BSb.BOB);
      }
      Object localObject = g.aAh();
      p.g(localObject, "MMKernel.storage()");
      boolean bool = ((e)localObject).azQ().getBoolean(ar.a.NZV, true);
      Log.i("MicroMsg.MediaFileUtil", "imageState : " + bool + ' ');
      if (!bool)
      {
        AppMethodBeat.o(76184);
        return;
      }
      if (((paramBoolean1) && (bool)) || ((!paramBoolean1) && (paramRecordConfigProvider.BOy) && (paramBoolean2)))
      {
        localObject = d.getExportImagePath("jpg");
        if (!paramBoolean1) {
          localObject = AndroidMediaUtil.getExportImagePath("jpg");
        }
        Log.i("MicroMsg.MediaFileUtil", "auto save pic src " + paramRecordConfigProvider.BOC + " dest " + (String)localObject + ' ');
        s.nw(paramRecordConfigProvider.BOC, (String)localObject);
        AndroidMediaUtil.refreshMediaScanner((String)localObject, MMApplicationContext.getContext());
      }
      AppMethodBeat.o(76184);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/util/MediaFileUtil$handleRemuxVideo$1$1"})
  static final class l
    implements Runnable
  {
    l(RecordConfigProvider paramRecordConfigProvider1, RecordConfigProvider paramRecordConfigProvider2, boolean paramBoolean1, boolean paramBoolean2) {}
    
    public final void run()
    {
      AppMethodBeat.i(76185);
      if (!paramRecordConfigProvider.BOx) {
        s.deleteFile(this.BSb.BOz);
      }
      Object localObject = g.aAh();
      p.g(localObject, "MMKernel.storage()");
      boolean bool = ((e)localObject).azQ().getBoolean(ar.a.NZW, true);
      Log.i("MicroMsg.MediaFileUtil", "videoState : " + bool + ' ');
      if (!bool)
      {
        AppMethodBeat.o(76185);
        return;
      }
      if ((paramBoolean1) || ((!paramBoolean1) && (paramRecordConfigProvider.BOy) && (paramBoolean2)))
      {
        localObject = d.getExportImagePath("mp4");
        if (!paramBoolean1) {
          localObject = AndroidMediaUtil.getExportImagePath("mp4");
        }
        Log.i("MicroMsg.MediaFileUtil", "auto save video :".concat(String.valueOf(localObject)));
        s.nw(this.BSb.BOA, (String)localObject);
        AndroidMediaUtil.refreshMediaScanner((String)localObject, MMApplicationContext.getContext());
      }
      AppMethodBeat.o(76185);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/util/MediaFileUtil$handleRemuxVideo$3$1"})
  static final class m
    implements Runnable
  {
    m(ald paramald) {}
    
    public final void run()
    {
      AppMethodBeat.i(76186);
      if (!this.Cil.BOx) {
        s.deleteFile(this.Cil.BOz);
      }
      Object localObject = g.aAh();
      p.g(localObject, "MMKernel.storage()");
      if (!((e)localObject).azQ().getBoolean(ar.a.NZW, true))
      {
        AppMethodBeat.o(76186);
        return;
      }
      if ((this.Cil.Lud) || ((!this.Cil.Lud) && (this.Cil.BOy) && (this.Cil.Gvu)))
      {
        localObject = d.getExportImagePath("mp4");
        if (!this.Cil.Lud) {
          localObject = AndroidMediaUtil.getExportImagePath("mp4");
        }
        s.nw(this.Cil.BOA, (String)localObject);
        AndroidMediaUtil.refreshMediaScanner((String)localObject, MMApplicationContext.getContext());
      }
      AppMethodBeat.o(76186);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel) {}
    
    public final void run()
    {
      AppMethodBeat.i(76187);
      String str = AndroidMediaUtil.getExportImagePath("mp4");
      s.nw(this.BKd.getVideoPath(), str);
      AndroidMediaUtil.refreshMediaScanner(str, MMApplicationContext.getContext());
      AppMethodBeat.o(76187);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(237980);
      Iterator localIterator = ((Iterable)this.Cim.iqn).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Log.i("MicroMsg.MediaFileUtil", "delete file:".concat(String.valueOf(str)));
        s.deleteFile(str);
      }
      AppMethodBeat.o(237980);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.c
 * JD-Core Version:    0.7.0.1
 */