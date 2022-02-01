package com.tencent.mm.plugin.mv.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.mv.b.a;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.plugin.mv.ui.view.MusicMvEditPhotoPluginLayout;
import com.tencent.mm.plugin.mv.ui.view.MusicMvEditVideoPluginLayout;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import kotlin.Metadata;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.cx;

@com.tencent.mm.ui.base.a(7)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/MusicMvRouterUI;", "Lcom/tencent/mm/plugin/mv/ui/BaseMusicMvUI;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "router", "", "captureMvCover", "", "createMainUI", "intent", "Landroid/content/Intent;", "createMv", "createPostMv", "createPreviewMv", "getLayoutId", "isFlexEditMv", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onActivityResult", "requestCode", "resultCode", "data", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditFinish", "p0", "p1", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "p2", "onFinishBtnClick", "Landroid/content/Context;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaGenerated", "context", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onNewIntent", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "takePhoto", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvRouterUI
  extends BaseMusicMvUI
  implements CaptureDataManager.b
{
  public static final MusicMvRouterUI.a Maw;
  private int Bqi;
  private final aq mainScope;
  
  static
  {
    AppMethodBeat.i(286405);
    Maw = new MusicMvRouterUI.a((byte)0);
    AppMethodBeat.o(286405);
  }
  
  public MusicMvRouterUI()
  {
    AppMethodBeat.i(286320);
    this.Bqi = -1;
    this.mainScope = ar.b(ar.kBZ(), (f)cx.g(null));
    AppMethodBeat.o(286320);
  }
  
  private static final void a(MusicMvRouterUI paramMusicMvRouterUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(286385);
    s.u(paramMusicMvRouterUI, "this$0");
    paramDialogInterface.dismiss();
    paramMusicMvRouterUI.finish();
    b.lx((Context)paramMusicMvRouterUI.getContext());
    AppMethodBeat.o(286385);
  }
  
  private static final void b(MusicMvRouterUI paramMusicMvRouterUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(286394);
    s.u(paramMusicMvRouterUI, "this$0");
    paramDialogInterface.dismiss();
    paramMusicMvRouterUI.finish();
    AppMethodBeat.o(286394);
  }
  
  private final void bi(Intent paramIntent)
  {
    AppMethodBeat.i(286333);
    Intent localIntent = new Intent((Context)this, MusicMvMainUI.class);
    localIntent.addFlags(67108864);
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_track_data");
    if (arrayOfByte != null) {
      localIntent.putExtra("key_track_data", arrayOfByte);
    }
    localIntent.putExtra("key_seek_to_start", paramIntent.getBooleanExtra("key_seek_to_start", false));
    overridePendingTransition(b.a.slide_right_in, -1);
    paramIntent = com.tencent.mm.plugin.music.model.c.LLZ;
    com.tencent.mm.plugin.music.model.c.zK(true);
    paramIntent = com.tencent.mm.plugin.music.model.c.LLZ;
    com.tencent.mm.plugin.music.model.c.gnR();
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramIntent.aYi(), "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI", "createMainUI", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI", "createMainUI", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(286333);
  }
  
  private void bpM()
  {
    AppMethodBeat.i(286372);
    Object localObject1 = e.bIg().bIm();
    Log.i("MicroMsg.Mv.MusicMvRouterUI", s.X("videoParams ", localObject1));
    Object localObject2 = com.tencent.mm.plugin.music.model.j.LMC;
    localObject2 = com.tencent.mm.plugin.music.model.j.fip();
    com.tencent.mm.plugin.music.model.j localj = com.tencent.mm.plugin.music.model.j.LMC;
    localObject1 = RecordConfigProvider.a((String)localObject2, com.tencent.mm.plugin.music.model.j.gob(), (VideoTransPara)localObject1, ((VideoTransPara)localObject1).duration * 1000, 14);
    ((RecordConfigProvider)localObject1).NHY = Boolean.FALSE;
    ((RecordConfigProvider)localObject1).NHV = Boolean.FALSE;
    ((RecordConfigProvider)localObject1).NHX = Boolean.TRUE;
    int i = getIntent().getIntExtra("KEY_MIN_RECORD_DURATION", 1000);
    int j = getIntent().getIntExtra("KEY_MAX_RECORD_DURATION", 1000);
    boolean bool = getIntent().getBooleanExtra("KEY_IS_FIX_CLIP_MODE", true);
    Log.i("MicroMsg.Mv.MusicMvRouterUI", "record require duration:" + i + ", maxVideoDuration:" + j);
    ((RecordConfigProvider)localObject1).NIa = i;
    ((RecordConfigProvider)localObject1).NHZ = j;
    if ((i > 0) && (bool))
    {
      i = (int)(i / 1000.0F);
      ((RecordConfigProvider)localObject1).NIo = getContext().getString(b.h.LWi, new Object[] { String.valueOf(i) });
    }
    ((RecordConfigProvider)localObject1).NIn.XKq = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zoE, true);
    ((RecordConfigProvider)localObject1).NIn.XKs = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zoF, -1);
    ((RecordConfigProvider)localObject1).NIn.XKt = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zoG, -1);
    ((RecordConfigProvider)localObject1).NIn.XKu = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zoH, -1);
    ((RecordConfigProvider)localObject1).NIn.XKv = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zoI, -1);
    ((RecordConfigProvider)localObject1).NIn.XKw = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zoJ, -1);
    localObject2 = new UICustomParam.a();
    ((UICustomParam.a)localObject2).aQw();
    ((UICustomParam.a)localObject2).aQv();
    ((UICustomParam.a)localObject2).aQu();
    ((UICustomParam.a)localObject2).eL(false);
    ((UICustomParam.a)localObject2).aQx();
    ((UICustomParam.a)localObject2).eJ(true);
    ((UICustomParam.a)localObject2).eK(true);
    ((UICustomParam.a)localObject2).eH(true);
    ((UICustomParam.a)localObject2).eI(true);
    ((RecordConfigProvider)localObject1).NHR = ((UICustomParam.a)localObject2).lZB;
    ((RecordConfigProvider)localObject1).NHS = i.e.XYM;
    ((RecordConfigProvider)localObject1).cD(2, MusicMvEditVideoPluginLayout.class.getName());
    CaptureDataManager.NHH.NHG = ((CaptureDataManager.b)this);
    localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
    com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)this, 233, b.a.sight_slide_bottom_in, b.a.sight_slide_bottom_out, (RecordConfigProvider)localObject1);
    AppMethodBeat.o(286372);
  }
  
  private final void gqc()
  {
    AppMethodBeat.i(286327);
    switch (this.Bqi)
    {
    case 4: 
    default: 
      Log.e("MicroMsg.Mv.MusicMvRouterUI", s.X("unknown router: ", Integer.valueOf(this.Bqi)));
      finish();
      AppMethodBeat.o(286327);
      return;
    case 1: 
      bpM();
      AppMethodBeat.o(286327);
      return;
    case 2: 
      gqg();
      AppMethodBeat.o(286327);
      return;
    case 3: 
      gqd();
      AppMethodBeat.o(286327);
      return;
    case 6: 
      gqf();
      AppMethodBeat.o(286327);
      return;
    case 7: 
      gqe();
      AppMethodBeat.o(286327);
      return;
    }
    bi(getIntent());
    finish();
    AppMethodBeat.o(286327);
  }
  
  private final void gqd()
  {
    AppMethodBeat.i(286339);
    Object localObject = new Intent((Context)this, MusicMvMakerUI.class);
    byte[] arrayOfByte = getIntent().getByteArrayExtra("key_track_data");
    if (arrayOfByte != null) {
      ((Intent)localObject).putExtra("key_track_data", arrayOfByte);
    }
    d.a((Intent)localObject, getIntent(), "key_mv_music_duration");
    d.a((Intent)localObject, getIntent(), "key_mv_from_scene");
    d.a((Intent)localObject, getIntent(), "key_mv_enter_maker_ui_from_scene");
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI", "createMv", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI", "createMv", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(286339);
  }
  
  private final void gqe()
  {
    AppMethodBeat.i(286349);
    Object localObject = new Intent((Context)this, MusicMvPostUI.class);
    byte[] arrayOfByte = getIntent().getByteArrayExtra("key_track_data");
    if (arrayOfByte != null) {
      ((Intent)localObject).putExtra("key_track_data", arrayOfByte);
    }
    d.a((Intent)localObject, getIntent(), "key_mv_music_duration");
    d.a((Intent)localObject, getIntent(), "key_mv_from_scene");
    d.a((Intent)localObject, getIntent(), "key_mv_enter_maker_ui_from_scene");
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI", "createPostMv", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI", "createPostMv", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(286349);
  }
  
  private final void gqf()
  {
    AppMethodBeat.i(286355);
    kotlinx.coroutines.j.a(this.mainScope, null, null, (m)new MusicMvRouterUI.b(this, this, null), 3);
    AppMethodBeat.o(286355);
  }
  
  private void gqg()
  {
    AppMethodBeat.i(286378);
    Object localObject1 = e.bIg().bIm();
    Log.i("MicroMsg.Mv.MusicMvRouterUI", s.X("videoParams ", localObject1));
    Object localObject2 = com.tencent.mm.plugin.music.model.j.LMC;
    localObject2 = com.tencent.mm.plugin.music.model.j.fip();
    com.tencent.mm.plugin.music.model.j localj = com.tencent.mm.plugin.music.model.j.LMC;
    localObject1 = RecordConfigProvider.a((String)localObject2, com.tencent.mm.plugin.music.model.j.gob(), (VideoTransPara)localObject1, 0, 14);
    ((RecordConfigProvider)localObject1).NHY = Boolean.FALSE;
    ((RecordConfigProvider)localObject1).NHV = Boolean.TRUE;
    ((RecordConfigProvider)localObject1).NHW = Boolean.FALSE;
    ((RecordConfigProvider)localObject1).NIb = true;
    localObject2 = new UICustomParam.a();
    ((UICustomParam.a)localObject2).eK(true);
    ((UICustomParam.a)localObject2).aQu();
    ((RecordConfigProvider)localObject1).NHR = ((UICustomParam.a)localObject2).lZB;
    ((RecordConfigProvider)localObject1).cD(1, MusicMvEditPhotoPluginLayout.class.getName());
    CaptureDataManager.NHH.NHG = ((CaptureDataManager.b)this);
    localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
    com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)this, 233, b.a.sight_slide_bottom_in, b.a.sight_slide_bottom_out, (RecordConfigProvider)localObject1);
    AppMethodBeat.o(286378);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(286431);
    Log.i("MicroMsg.Mv.MusicMvRouterUI", "onMediaGenerated");
    if (paramCaptureVideoNormalModel == null)
    {
      AppMethodBeat.o(286431);
      return;
    }
    Log.i("MicroMsg.Mv.MusicMvRouterUI", "record video path:" + paramCaptureVideoNormalModel.videoPath + ' ' + paramCaptureVideoNormalModel.thumbPath);
    int i;
    if (this.Bqi == 1)
    {
      paramBundle = (CharSequence)paramCaptureVideoNormalModel.videoPath;
      if ((paramBundle == null) || (paramBundle.length() == 0))
      {
        i = 1;
        if (i != 0) {
          break label168;
        }
        paramBundle = new Intent();
        paramBundle.putExtra("KEY_RECORD_VIDEO_PATH", paramCaptureVideoNormalModel.videoPath);
        paramBundle.putExtra("KEY_RECORD_VIDEO_THUMB_PATH", paramCaptureVideoNormalModel.thumbPath);
        setResult(-1, paramBundle);
      }
    }
    for (;;)
    {
      if (paramContext != null) {
        break label232;
      }
      paramContext = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(286431);
      throw paramContext;
      i = 0;
      break;
      label168:
      if (this.Bqi == 2)
      {
        paramBundle = paramCaptureVideoNormalModel.NHK;
        s.s(paramBundle, "model.photo");
        if (paramBundle.booleanValue())
        {
          paramBundle = new Intent();
          paramBundle.putExtra("KEY_RECORD_PHOTO_PATH", paramCaptureVideoNormalModel.thumbPath);
          setResult(-1, paramBundle);
          continue;
        }
      }
      setResult(0);
    }
    label232:
    ((Activity)paramContext).finish();
    finish();
    AppMethodBeat.o(286431);
  }
  
  public final void a(RecordMediaReportInfo paramRecordMediaReportInfo, Bundle paramBundle) {}
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    return false;
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(286436);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 233) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.Mv.MusicMvRouterUI", "cancel take photo");
      setResult(0);
      finish();
    }
    AppMethodBeat.o(286436);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(286424);
    super.onCreate(paramBundle);
    this.Bqi = getIntent().getIntExtra("KEY_MUSIC_ROUTER", -1);
    gqc();
    AppMethodBeat.o(286424);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(286486);
    Log.i("MicroMsg.Mv.MusicMvRouterUI", "onDestroy");
    super.onDestroy();
    ar.a(this.mainScope, null);
    AppMethodBeat.o(286486);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(286457);
    super.onNewIntent(paramIntent);
    if (paramIntent != null) {
      switch (paramIntent.getIntExtra("KEY_MUSIC_ROUTER", -1))
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(286457);
      return;
      overridePendingTransition(b.a.slide_right_in, -1);
      finish();
      AppMethodBeat.o(286457);
      return;
      bi(paramIntent);
      finish();
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(286496);
    super.onPause();
    Log.i("MicroMsg.Mv.MusicMvRouterUI", "onPause");
    AppMethodBeat.o(286496);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int k = 1;
    int j = 1;
    AppMethodBeat.i(286449);
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("MicroMsg.Mv.MusicMvRouterUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(286449);
      return;
    }
    Log.i("MicroMsg.Mv.MusicMvRouterUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    label199:
    label330:
    for (;;)
    {
      AppMethodBeat.o(286449);
      return;
      if (paramArrayOfInt.length == 0)
      {
        paramInt = 1;
        if (paramInt != 0) {
          break label199;
        }
      }
      for (paramInt = j;; paramInt = 0)
      {
        if ((paramInt == 0) || (paramArrayOfInt[0] != 0)) {
          break label204;
        }
        gqc();
        AppMethodBeat.o(286449);
        return;
        paramInt = 0;
        break;
      }
      label204:
      k.a((Context)getContext(), com.tencent.mm.cd.a.bt((Context)getContext(), b.h.permission_camera_request_again_msg), com.tencent.mm.cd.a.bt((Context)getContext(), b.h.permission_tips_title), com.tencent.mm.cd.a.bt((Context)getContext(), b.h.jump_to_settings), com.tencent.mm.cd.a.bt((Context)getContext(), b.h.permission_cancel), false, new MusicMvRouterUI..ExternalSyntheticLambda1(this), new MusicMvRouterUI..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(286449);
      return;
      if (paramArrayOfInt.length == 0)
      {
        paramInt = 1;
        if (paramInt != 0) {
          break label327;
        }
      }
      for (paramInt = k;; paramInt = 0)
      {
        if ((paramInt == 0) || (paramArrayOfInt[0] != 0)) {
          break label330;
        }
        gqc();
        break;
        paramInt = 0;
        break label298;
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(286494);
    Log.i("MicroMsg.Mv.MusicMvRouterUI", "onResume");
    super.onResume();
    com.tencent.mm.plugin.music.model.c localc = com.tencent.mm.plugin.music.model.c.LLZ;
    com.tencent.mm.plugin.music.model.c.zK(true);
    localc = com.tencent.mm.plugin.music.model.c.LLZ;
    com.tencent.mm.plugin.music.model.c.gnR();
    AppMethodBeat.o(286494);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.MusicMvRouterUI
 * JD-Core Version:    0.7.0.1
 */