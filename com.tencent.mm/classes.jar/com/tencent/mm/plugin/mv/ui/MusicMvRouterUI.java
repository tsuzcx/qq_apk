package com.tencent.mm.plugin.mv.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.music.model.c;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.plugin.mv.ui.free.MusicMvFreeMakerPreviewUI;
import com.tencent.mm.plugin.mv.ui.view.MusicMvEditPhotoPluginLayout;
import com.tencent.mm.plugin.mv.ui.view.MusicMvEditVideoPluginLayout;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.ResultKt;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;
import kotlinx.coroutines.aw;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.ct;
import kotlinx.coroutines.g;
import kotlinx.coroutines.i;

@com.tencent.mm.ui.base.a(7)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/MusicMvRouterUI;", "Lcom/tencent/mm/plugin/mv/ui/BaseMusicMvUI;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "router", "", "captureMvCover", "", "createMainUI", "intent", "Landroid/content/Intent;", "createMv", "createPostMv", "createPreviewMv", "getLayoutId", "isFlexEditMv", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onActivityResult", "requestCode", "resultCode", "data", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditFinish", "p0", "p1", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "p2", "onFinishBtnClick", "Landroid/content/Context;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaGenerated", "context", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onNewIntent", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "takePhoto", "Companion", "plugin-mv_release"})
public final class MusicMvRouterUI
  extends BaseMusicMvUI
  implements CaptureDataManager.b
{
  public static final a Gff;
  private HashMap _$_findViewCache;
  private final ak oDi;
  private int xQJ;
  
  static
  {
    AppMethodBeat.i(228374);
    Gff = new a((byte)0);
    AppMethodBeat.o(228374);
  }
  
  public MusicMvRouterUI()
  {
    AppMethodBeat.i(228373);
    this.xQJ = -1;
    this.oDi = al.b(al.iRe(), (f)ct.iRW());
    AppMethodBeat.o(228373);
  }
  
  private final void aL(Intent paramIntent)
  {
    AppMethodBeat.i(228320);
    Intent localIntent = new Intent((Context)this, MusicMvMainUI.class);
    localIntent.addFlags(67108864);
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_track_data");
    if (arrayOfByte != null) {
      localIntent.putExtra("key_track_data", arrayOfByte);
    }
    localIntent.putExtra("key_seek_to_start", paramIntent.getBooleanExtra("key_seek_to_start", false));
    overridePendingTransition(com.tencent.mm.plugin.mv.b.a.slide_right_in, -1);
    paramIntent = c.FRf;
    c.vs(true);
    paramIntent = c.FRf;
    c.cwB();
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramIntent.aFh(), "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI", "createMainUI", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI", "createMainUI", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(228320);
  }
  
  private void aVe()
  {
    AppMethodBeat.i(228349);
    Object localObject1 = e.bkp();
    p.j(localObject1, "SubCoreVideoControl.getCore()");
    localObject1 = ((e)localObject1).bku();
    Log.i("MicroMsg.Mv.MusicMvRouterUI", "videoParams ".concat(String.valueOf(localObject1)));
    Object localObject2 = com.tencent.mm.plugin.music.model.j.FRI;
    localObject2 = com.tencent.mm.plugin.music.model.j.egp();
    com.tencent.mm.plugin.music.model.j localj = com.tencent.mm.plugin.music.model.j.FRI;
    localObject1 = RecordConfigProvider.a((String)localObject2, com.tencent.mm.plugin.music.model.j.feU(), (VideoTransPara)localObject1, ((VideoTransPara)localObject1).duration * 1000, 14);
    ((RecordConfigProvider)localObject1).HLa = Boolean.FALSE;
    ((RecordConfigProvider)localObject1).HKX = Boolean.FALSE;
    ((RecordConfigProvider)localObject1).HKZ = Boolean.TRUE;
    int i = getIntent().getIntExtra("KEY_MIN_RECORD_DURATION", 1000);
    int j = getIntent().getIntExtra("KEY_MAX_RECORD_DURATION", 1000);
    boolean bool = getIntent().getBooleanExtra("KEY_IS_FIX_CLIP_MODE", true);
    Log.i("MicroMsg.Mv.MusicMvRouterUI", "record require duration:" + i + ", maxVideoDuration:" + j);
    ((RecordConfigProvider)localObject1).HLc = i;
    ((RecordConfigProvider)localObject1).HLb = j;
    if ((i > 0) && (bool))
    {
      i = (int)(i / 1000.0F);
      ((RecordConfigProvider)localObject1).HLq = getContext().getString(b.h.Gab, new Object[] { String.valueOf(i) });
    }
    ((RecordConfigProvider)localObject1).HLp.QPr = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vVZ, true);
    ((RecordConfigProvider)localObject1).HLp.QPt = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vWa, -1);
    ((RecordConfigProvider)localObject1).HLp.QPu = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vWb, -1);
    ((RecordConfigProvider)localObject1).HLp.QPv = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vWc, -1);
    ((RecordConfigProvider)localObject1).HLp.QPw = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vWd, -1);
    ((RecordConfigProvider)localObject1).HLp.QPx = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vWe, -1);
    localObject2 = new UICustomParam.a();
    ((UICustomParam.a)localObject2).avX();
    ((UICustomParam.a)localObject2).avW();
    ((UICustomParam.a)localObject2).avV();
    ((UICustomParam.a)localObject2).dZ(false);
    ((UICustomParam.a)localObject2).avY();
    ((UICustomParam.a)localObject2).dX(true);
    ((UICustomParam.a)localObject2).dY(true);
    ((UICustomParam.a)localObject2).dV(true);
    ((UICustomParam.a)localObject2).dW(true);
    ((RecordConfigProvider)localObject1).HKT = ((UICustomParam.a)localObject2).avZ();
    ((RecordConfigProvider)localObject1).HKU = i.e.RcG;
    ((RecordConfigProvider)localObject1).G(2, MusicMvEditVideoPluginLayout.class.getName());
    CaptureDataManager.HKJ.a((CaptureDataManager.b)this);
    localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
    com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)this, 233, com.tencent.mm.plugin.mv.b.a.sight_slide_bottom_in, com.tencent.mm.plugin.mv.b.a.sight_slide_bottom_out, (RecordConfigProvider)localObject1);
    AppMethodBeat.o(228349);
  }
  
  private final void fgA()
  {
    AppMethodBeat.i(228331);
    Object localObject = new Intent((Context)this, MusicMvPostUI.class);
    byte[] arrayOfByte = getIntent().getByteArrayExtra("key_track_data");
    if (arrayOfByte != null) {
      ((Intent)localObject).putExtra("key_track_data", arrayOfByte);
    }
    com.tencent.mm.ae.d.a((Intent)localObject, getIntent(), "key_mv_music_duration");
    com.tencent.mm.ae.d.a((Intent)localObject, getIntent(), "key_mv_from_scene");
    com.tencent.mm.ae.d.a((Intent)localObject, getIntent(), "key_mv_enter_maker_ui_from_scene");
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI", "createPostMv", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI", "createPostMv", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(228331);
  }
  
  private final void fgB()
  {
    AppMethodBeat.i(228333);
    final MusicMvRouterUI localMusicMvRouterUI = (MusicMvRouterUI)this;
    g.b(this.oDi, null, (m)new b(this, localMusicMvRouterUI, null), 3);
    AppMethodBeat.o(228333);
  }
  
  private void fgC()
  {
    AppMethodBeat.i(228350);
    Object localObject1 = e.bkp();
    p.j(localObject1, "SubCoreVideoControl.getCore()");
    localObject1 = ((e)localObject1).bku();
    Log.i("MicroMsg.Mv.MusicMvRouterUI", "videoParams ".concat(String.valueOf(localObject1)));
    Object localObject2 = com.tencent.mm.plugin.music.model.j.FRI;
    localObject2 = com.tencent.mm.plugin.music.model.j.egp();
    com.tencent.mm.plugin.music.model.j localj = com.tencent.mm.plugin.music.model.j.FRI;
    localObject1 = RecordConfigProvider.a((String)localObject2, com.tencent.mm.plugin.music.model.j.feU(), (VideoTransPara)localObject1, 0, 14);
    ((RecordConfigProvider)localObject1).HLa = Boolean.FALSE;
    ((RecordConfigProvider)localObject1).HKX = Boolean.TRUE;
    ((RecordConfigProvider)localObject1).HKY = Boolean.FALSE;
    ((RecordConfigProvider)localObject1).HLd = true;
    localObject2 = new UICustomParam.a();
    ((UICustomParam.a)localObject2).dY(true);
    ((UICustomParam.a)localObject2).avV();
    ((RecordConfigProvider)localObject1).HKT = ((UICustomParam.a)localObject2).avZ();
    ((RecordConfigProvider)localObject1).G(1, MusicMvEditPhotoPluginLayout.class.getName());
    CaptureDataManager.HKJ.a((CaptureDataManager.b)this);
    localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
    com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)this, 233, com.tencent.mm.plugin.mv.b.a.sight_slide_bottom_in, com.tencent.mm.plugin.mv.b.a.sight_slide_bottom_out, (RecordConfigProvider)localObject1);
    AppMethodBeat.o(228350);
  }
  
  private final void fgy()
  {
    AppMethodBeat.i(228315);
    switch (this.xQJ)
    {
    case 4: 
    default: 
      Log.e("MicroMsg.Mv.MusicMvRouterUI", "unknown router: " + this.xQJ);
      finish();
      AppMethodBeat.o(228315);
      return;
    case 1: 
      aVe();
      AppMethodBeat.o(228315);
      return;
    case 2: 
      fgC();
      AppMethodBeat.o(228315);
      return;
    case 3: 
      fgz();
      AppMethodBeat.o(228315);
      return;
    case 6: 
      fgB();
      AppMethodBeat.o(228315);
      return;
    case 7: 
      fgA();
      AppMethodBeat.o(228315);
      return;
    }
    Intent localIntent = getIntent();
    p.j(localIntent, "intent");
    aL(localIntent);
    finish();
    AppMethodBeat.o(228315);
  }
  
  private final void fgz()
  {
    AppMethodBeat.i(228325);
    Object localObject = new Intent((Context)this, MusicMvMakerUI.class);
    byte[] arrayOfByte = getIntent().getByteArrayExtra("key_track_data");
    if (arrayOfByte != null) {
      ((Intent)localObject).putExtra("key_track_data", arrayOfByte);
    }
    com.tencent.mm.ae.d.a((Intent)localObject, getIntent(), "key_mv_music_duration");
    com.tencent.mm.ae.d.a((Intent)localObject, getIntent(), "key_mv_from_scene");
    com.tencent.mm.ae.d.a((Intent)localObject, getIntent(), "key_mv_enter_maker_ui_from_scene");
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI", "createMv", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI", "createMv", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(228325);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(228376);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(228376);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(228375);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(228375);
    return localView1;
  }
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(228357);
    Log.i("MicroMsg.Mv.MusicMvRouterUI", "onMediaGenerated");
    if (paramCaptureVideoNormalModel == null)
    {
      AppMethodBeat.o(228357);
      return;
    }
    Log.i("MicroMsg.Mv.MusicMvRouterUI", "record video path:" + paramCaptureVideoNormalModel.getVideoPath() + ' ' + paramCaptureVideoNormalModel.aZe());
    int i;
    if (this.xQJ == 1)
    {
      paramBundle = (CharSequence)paramCaptureVideoNormalModel.getVideoPath();
      if ((paramBundle == null) || (paramBundle.length() == 0))
      {
        i = 1;
        if (i != 0) {
          break label166;
        }
        paramBundle = new Intent();
        paramBundle.putExtra("KEY_RECORD_VIDEO_PATH", paramCaptureVideoNormalModel.getVideoPath());
        paramBundle.putExtra("KEY_RECORD_VIDEO_THUMB_PATH", paramCaptureVideoNormalModel.aZe());
        setResult(-1, paramBundle);
      }
    }
    for (;;)
    {
      if (paramContext != null) {
        break label230;
      }
      paramContext = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(228357);
      throw paramContext;
      i = 0;
      break;
      label166:
      if (this.xQJ == 2)
      {
        paramBundle = paramCaptureVideoNormalModel.fvT();
        p.j(paramBundle, "model.photo");
        if (paramBundle.booleanValue())
        {
          paramBundle = new Intent();
          paramBundle.putExtra("KEY_RECORD_PHOTO_PATH", paramCaptureVideoNormalModel.aZe());
          setResult(-1, paramBundle);
          continue;
        }
      }
      setResult(0);
    }
    label230:
    ((Activity)paramContext).finish();
    finish();
    AppMethodBeat.o(228357);
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
    AppMethodBeat.i(228359);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 233) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.Mv.MusicMvRouterUI", "cancel take photo");
      setResult(0);
      finish();
    }
    AppMethodBeat.o(228359);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(228310);
    super.onCreate(paramBundle);
    this.xQJ = getIntent().getIntExtra("KEY_MUSIC_ROUTER", -1);
    fgy();
    AppMethodBeat.o(228310);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(228370);
    Log.i("MicroMsg.Mv.MusicMvRouterUI", "onDestroy");
    super.onDestroy();
    al.a(this.oDi, null);
    AppMethodBeat.o(228370);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(228368);
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("KEY_MUSIC_ROUTER", -1);
      if (i == 4)
      {
        overridePendingTransition(com.tencent.mm.plugin.mv.b.a.slide_right_in, -1);
        finish();
        AppMethodBeat.o(228368);
        return;
      }
      if (i == 5)
      {
        aL(paramIntent);
        finish();
      }
      AppMethodBeat.o(228368);
      return;
    }
    AppMethodBeat.o(228368);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(228372);
    super.onPause();
    Log.i("MicroMsg.Mv.MusicMvRouterUI", "onPause");
    AppMethodBeat.o(228372);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int k = 1;
    int j = 1;
    AppMethodBeat.i(228367);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramArrayOfString = Thread.currentThread();
      p.j(paramArrayOfString, "Thread.currentThread()");
      Log.i("MicroMsg.Mv.MusicMvRouterUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramArrayOfString.getId()) });
      AppMethodBeat.o(228367);
      return;
    }
    i = paramArrayOfInt[0];
    paramArrayOfString = Thread.currentThread();
    p.j(paramArrayOfString, "Thread.currentThread()");
    Log.i("MicroMsg.Mv.MusicMvRouterUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Long.valueOf(paramArrayOfString.getId()) });
    switch (paramInt)
    {
    }
    label219:
    label224:
    label353:
    label356:
    for (;;)
    {
      AppMethodBeat.o(228367);
      return;
      if (paramArrayOfInt.length == 0)
      {
        paramInt = 1;
        if (paramInt != 0) {
          break label219;
        }
      }
      for (paramInt = j;; paramInt = 0)
      {
        if ((paramInt == 0) || (paramArrayOfInt[0] != 0)) {
          break label224;
        }
        fgy();
        AppMethodBeat.o(228367);
        return;
        paramInt = 0;
        break;
      }
      com.tencent.mm.ui.base.h.a((Context)getContext(), com.tencent.mm.ci.a.ba((Context)getContext(), b.h.permission_camera_request_again_msg), com.tencent.mm.ci.a.ba((Context)getContext(), b.h.permission_tips_title), com.tencent.mm.ci.a.ba((Context)getContext(), b.h.jump_to_settings), com.tencent.mm.ci.a.ba((Context)getContext(), b.h.permission_cancel), false, (DialogInterface.OnClickListener)new d(this), (DialogInterface.OnClickListener)new e(this));
      AppMethodBeat.o(228367);
      return;
      if (paramArrayOfInt.length == 0)
      {
        paramInt = 1;
        if (paramInt != 0) {
          break label353;
        }
      }
      for (paramInt = k;; paramInt = 0)
      {
        if ((paramInt == 0) || (paramArrayOfInt[0] != 0)) {
          break label356;
        }
        fgy();
        break;
        paramInt = 0;
        break label324;
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(228371);
    Log.i("MicroMsg.Mv.MusicMvRouterUI", "onResume");
    super.onResume();
    c localc = c.FRf;
    c.vs(true);
    localc = c.FRf;
    c.cwB();
    AppMethodBeat.o(228371);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/MusicMvRouterUI$Companion;", "", "()V", "TAG", "", "TAKE_PHOTO_REQUEST_CODE", "", "plugin-mv_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends kotlin.d.b.a.j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    Object oDA;
    private ak p$;
    
    b(MusicMvRouterUI paramMusicMvRouterUI1, MusicMvRouterUI paramMusicMvRouterUI2, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(228829);
      p.k(paramd, "completion");
      paramd = new b(this.Gfg, localMusicMvRouterUI, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(228829);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(228833);
      paramObject1 = ((b)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(228833);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(228823);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      Object localObject1;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(228823);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        localObject1 = this.Gfg;
        this.L$0 = paramObject;
        this.label = 1;
        localObject1 = i.a((f)bc.iRs(), (m)new MusicMvRouterUI.c((MusicMvRouterUI)localObject1, null), this);
        if (localObject1 == locala)
        {
          AppMethodBeat.o(228823);
          return locala;
        }
        break;
      case 1: 
        localObject2 = (ak)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
      }
      for (;;)
      {
        if (((Boolean)localObject1).booleanValue()) {}
        for (localObject1 = new Intent((Context)localMusicMvRouterUI, MusicMvFreeMakerPreviewUI.class);; localObject1 = new Intent((Context)localMusicMvRouterUI, MusicMvMakerPreviewUI.class))
        {
          localObject2 = this.Gfg.getIntent().getByteArrayExtra("key_track_data");
          if (localObject2 != null) {
            ((Intent)localObject1).putExtra("key_track_data", (byte[])localObject2);
          }
          com.tencent.mm.ae.d.a((Intent)localObject1, this.Gfg.getIntent(), "key_mv_music_duration");
          com.tencent.mm.ae.d.a((Intent)localObject1, this.Gfg.getIntent(), "key_mv_from_scene");
          com.tencent.mm.ae.d.a((Intent)localObject1, this.Gfg.getIntent(), "key_mv_enter_maker_ui_from_scene");
          localObject2 = this.Gfg;
          com.tencent.mm.hellhoundlib.b.a locala1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(localObject2, locala1.aFh(), "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI$createPreviewMv$1", "invokeSuspend", "(Ljava/lang/Object;)Ljava/lang/Object;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((MusicMvRouterUI)localObject2).startActivity((Intent)locala1.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI$createPreviewMv$1", "invokeSuspend", "(Ljava/lang/Object;)Ljava/lang/Object;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.L$0 = paramObject;
          this.oDA = localObject1;
          this.label = 2;
          if (aw.a(500L, this) != locala) {
            break;
          }
          AppMethodBeat.o(228823);
          return locala;
        }
        ResultKt.throwOnFailure(paramObject);
        this.Gfg.finish();
        paramObject = x.aazN;
        AppMethodBeat.o(228823);
        return paramObject;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class c
    extends kotlin.d.b.a.j
    implements m<ak, kotlin.d.d<? super Boolean>, Object>
  {
    int label;
    private ak p$;
    
    c(MusicMvRouterUI paramMusicMvRouterUI, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(228759);
      p.k(paramd, "completion");
      paramd = new c(this.Gfg, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(228759);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(228763);
      paramObject1 = ((c)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(228763);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      bool = true;
      AppMethodBeat.i(228757);
      Object localObject = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(228757);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      for (;;)
      {
        try
        {
          paramObject = this.Gfg.getIntent().getByteArrayExtra("key_track_data");
          if (paramObject == null)
          {
            paramObject = Boolean.FALSE;
            AppMethodBeat.o(228757);
            return paramObject;
          }
          localObject = new dbo();
          ((dbo)localObject).parseFrom(paramObject);
          paramObject = ((dbo)localObject).TIV;
          if (paramObject == null) {
            continue;
          }
          paramObject = paramObject.objectDesc;
          if (paramObject == null) {
            continue;
          }
          paramObject = paramObject.mvInfo;
          if (paramObject == null) {
            continue;
          }
          int i = paramObject.SOF;
          if (i != 1) {
            continue;
          }
        }
        catch (Exception paramObject)
        {
          bool = false;
          continue;
        }
        AppMethodBeat.o(228757);
        return Boolean.valueOf(bool);
        bool = false;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    d(MusicMvRouterUI paramMusicMvRouterUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(232008);
      paramDialogInterface.dismiss();
      this.Gfg.finish();
      paramDialogInterface = this.Gfg.getContext();
      Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI$onRequestPermissionsResult$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramDialogInterface, "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI$onRequestPermissionsResult$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(232008);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(MusicMvRouterUI paramMusicMvRouterUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(225897);
      paramDialogInterface.dismiss();
      this.Gfg.finish();
      AppMethodBeat.o(225897);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.MusicMvRouterUI
 * JD-Core Version:    0.7.0.1
 */