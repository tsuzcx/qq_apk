package com.tencent.mm.plugin.mv.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.music.model.c;
import com.tencent.mm.plugin.music.model.j;
import com.tencent.mm.plugin.mv.ui.view.MusicMvEditPhotoPluginLayout;
import com.tencent.mm.plugin.mv.ui.view.MusicMvEditVideoPluginLayout;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@com.tencent.mm.ui.base.a(7)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/MusicMvRouterUI;", "Lcom/tencent/mm/plugin/mv/ui/BaseMusicMvUI;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoGenerateCallback;", "()V", "router", "", "captureMvCover", "", "createMainUI", "intent", "Landroid/content/Intent;", "createMv", "getLayoutId", "onActivityResult", "requestCode", "resultCode", "data", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onEditFinish", "p0", "", "p1", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "p2", "onFinishBtnClick", "Landroid/content/Context;", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$IVideoFinishController;", "onMediaGenerated", "context", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onNewIntent", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "takePhoto", "Companion", "plugin-mv_release"})
public final class MusicMvRouterUI
  extends BaseMusicMvUI
  implements CaptureDataManager.b
{
  public static final a Ary;
  private HashMap _$_findViewCache;
  private int ubR = -1;
  
  static
  {
    AppMethodBeat.i(256944);
    Ary = new a((byte)0);
    AppMethodBeat.o(256944);
  }
  
  private void aML()
  {
    AppMethodBeat.i(256938);
    Object localObject1 = e.baZ();
    p.g(localObject1, "SubCoreVideoControl.getCore()");
    localObject1 = ((e)localObject1).bbe();
    Log.i("MicroMsg.Mv.MusicMvRouterUI", "videoParams ".concat(String.valueOf(localObject1)));
    Object localObject2 = j.AkE;
    localObject2 = j.dEC();
    j localj = j.AkE;
    localObject1 = RecordConfigProvider.a((String)localObject2, j.euz(), (VideoTransPara)localObject1, ((VideoTransPara)localObject1).duration * 1000, 14);
    ((RecordConfigProvider)localObject1).BOu = Boolean.FALSE;
    ((RecordConfigProvider)localObject1).BOr = Boolean.FALSE;
    ((RecordConfigProvider)localObject1).BOt = Boolean.TRUE;
    int i = getIntent().getIntExtra("KEY_REQUIRE_VIDEO_DURATION", 1000);
    Log.i("MicroMsg.Mv.MusicMvRouterUI", "record require duration:".concat(String.valueOf(i)));
    ((RecordConfigProvider)localObject1).BOw = 1000;
    ((RecordConfigProvider)localObject1).BOv = i;
    i = (int)(i / 1000.0F);
    ((RecordConfigProvider)localObject1).BOK = getContext().getString(2131764285, new Object[] { Integer.valueOf(i) });
    ((RecordConfigProvider)localObject1).BOJ.BOM = ((b)g.af(b.class)).a(b.a.slw, true);
    ((RecordConfigProvider)localObject1).BOJ.hDb = ((b)g.af(b.class)).a(b.a.slx, -1);
    ((RecordConfigProvider)localObject1).BOJ.hDc = ((b)g.af(b.class)).a(b.a.sly, -1);
    ((RecordConfigProvider)localObject1).BOJ.hDd = ((b)g.af(b.class)).a(b.a.slz, -1);
    ((RecordConfigProvider)localObject1).BOJ.hDe = ((b)g.af(b.class)).a(b.a.slA, -1);
    ((RecordConfigProvider)localObject1).BOJ.hDf = ((b)g.af(b.class)).a(b.a.slB, -1);
    localObject2 = new UICustomParam.a();
    ((UICustomParam.a)localObject2).apE();
    ((UICustomParam.a)localObject2).apD();
    ((UICustomParam.a)localObject2).apC();
    ((UICustomParam.a)localObject2).dz(false);
    ((UICustomParam.a)localObject2).apF();
    ((UICustomParam.a)localObject2).dx(true);
    ((UICustomParam.a)localObject2).dy(true);
    ((UICustomParam.a)localObject2).dv(true);
    ((UICustomParam.a)localObject2).dw(true);
    ((RecordConfigProvider)localObject1).BOn = ((UICustomParam.a)localObject2).apG();
    ((RecordConfigProvider)localObject1).BOo = i.e.Kcb;
    ((RecordConfigProvider)localObject1).F(2, MusicMvEditVideoPluginLayout.class.getName());
    CaptureDataManager.BOb.a((CaptureDataManager.b)this);
    localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
    com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)this, 233, 2130772161, 2130772162, (RecordConfigProvider)localObject1);
    AppMethodBeat.o(256938);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(256946);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(256946);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(256945);
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
    AppMethodBeat.o(256945);
    return localView1;
  }
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(256939);
    Log.i("MicroMsg.Mv.MusicMvRouterUI", "onMediaGenerated");
    if (paramCaptureVideoNormalModel == null)
    {
      AppMethodBeat.o(256939);
      return;
    }
    Log.i("MicroMsg.Mv.MusicMvRouterUI", "record video path:" + paramCaptureVideoNormalModel.getVideoPath() + ' ' + paramCaptureVideoNormalModel.aQn());
    int i;
    if (this.ubR == 1)
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
        paramBundle.putExtra("KEY_RECORD_VIDEO_THUMB_PATH", paramCaptureVideoNormalModel.aQn());
        setResult(-1, paramBundle);
      }
    }
    for (;;)
    {
      if (paramContext != null) {
        break label230;
      }
      paramContext = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(256939);
      throw paramContext;
      i = 0;
      break;
      label166:
      if (this.ubR == 2)
      {
        paramBundle = paramCaptureVideoNormalModel.eJI();
        p.g(paramBundle, "model.photo");
        if (paramBundle.booleanValue())
        {
          paramBundle = new Intent();
          paramBundle.putExtra("KEY_RECORD_PHOTO_PATH", paramCaptureVideoNormalModel.aQn());
          setResult(-1, paramBundle);
          continue;
        }
      }
      setResult(0);
    }
    label230:
    ((Activity)paramContext).finish();
    finish();
    AppMethodBeat.o(256939);
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
    AppMethodBeat.i(256940);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 233) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.Mv.MusicMvRouterUI", "cancel take photo");
      setResult(0);
      finish();
    }
    AppMethodBeat.o(256940);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(256937);
    super.onCreate(paramBundle);
    this.ubR = getIntent().getIntExtra("KEY_MUSIC_ROUTER", -1);
    switch (this.ubR)
    {
    default: 
      Log.e("MicroMsg.Mv.MusicMvRouterUI", "unknown router: " + this.ubR);
      AppMethodBeat.o(256937);
      return;
    case 1: 
      aML();
      AppMethodBeat.o(256937);
      return;
    case 2: 
      paramBundle = e.baZ();
      p.g(paramBundle, "SubCoreVideoControl.getCore()");
      paramBundle = paramBundle.bbe();
      Log.i("MicroMsg.Mv.MusicMvRouterUI", "videoParams ".concat(String.valueOf(paramBundle)));
      localObject = j.AkE;
      localObject = j.dEC();
      j localj = j.AkE;
      paramBundle = RecordConfigProvider.a((String)localObject, j.euz(), paramBundle, 0, 14);
      paramBundle.BOu = Boolean.FALSE;
      paramBundle.BOr = Boolean.TRUE;
      paramBundle.BOs = Boolean.FALSE;
      paramBundle.BOx = true;
      localObject = new UICustomParam.a();
      ((UICustomParam.a)localObject).dy(true);
      ((UICustomParam.a)localObject).apC();
      paramBundle.BOn = ((UICustomParam.a)localObject).apG();
      paramBundle.F(1, MusicMvEditPhotoPluginLayout.class.getName());
      CaptureDataManager.BOb.a((CaptureDataManager.b)this);
      localObject = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
      com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)this, 233, 2130772161, 2130772162, paramBundle);
      AppMethodBeat.o(256937);
      return;
    }
    Object localObject = new Intent((Context)this, MusicMvMakerUI.class);
    paramBundle = getIntent().getByteArrayExtra("key_track_data");
    if (paramBundle != null) {
      ((Intent)localObject).putExtra("key_track_data", paramBundle);
    }
    paramBundle = getIntent();
    p.h(localObject, "$this$copyIntExtra");
    p.h("key_mv_from_scene", "key");
    if (paramBundle != null) {}
    for (paramBundle = Integer.valueOf(paramBundle.getIntExtra("key_mv_from_scene", 0));; paramBundle = null)
    {
      ((Intent)localObject).putExtra("key_mv_from_scene", (Serializable)paramBundle);
      paramBundle = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.axQ(), "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI", "createMv", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramBundle.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI", "createMv", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(256937);
      return;
    }
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(256942);
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("KEY_MUSIC_ROUTER", -1);
      if (i == 4)
      {
        overridePendingTransition(2130772169, -1);
        finish();
        AppMethodBeat.o(256942);
        return;
      }
      if (i == 5)
      {
        p.h(paramIntent, "intent");
        Intent localIntent = new Intent((Context)this, MusicMvMainUI.class);
        localIntent.addFlags(67108864);
        byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_track_data");
        if (arrayOfByte != null) {
          localIntent.putExtra("key_track_data", arrayOfByte);
        }
        localIntent.putExtra("key_seek_to_start", paramIntent.getBooleanExtra("key_seek_to_start", false));
        overridePendingTransition(2130772169, -1);
        paramIntent = c.Akc;
        c.sm(true);
        paramIntent = c.Akc;
        c.cjj();
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.axQ(), "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI", "createMainUI", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramIntent.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI", "createMainUI", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
      }
      AppMethodBeat.o(256942);
      return;
    }
    AppMethodBeat.o(256942);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int k = 1;
    int j = 1;
    AppMethodBeat.i(256941);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramArrayOfString = Thread.currentThread();
      p.g(paramArrayOfString, "Thread.currentThread()");
      Log.i("MicroMsg.Mv.MusicMvRouterUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramArrayOfString.getId()) });
      AppMethodBeat.o(256941);
      return;
    }
    i = paramArrayOfInt[0];
    paramArrayOfString = Thread.currentThread();
    p.g(paramArrayOfString, "Thread.currentThread()");
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
      AppMethodBeat.o(256941);
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
        aML();
        AppMethodBeat.o(256941);
        return;
        paramInt = 0;
        break;
      }
      h.a((Context)getContext(), com.tencent.mm.cb.a.aI((Context)getContext(), 2131763864), com.tencent.mm.cb.a.aI((Context)getContext(), 2131763890), com.tencent.mm.cb.a.aI((Context)getContext(), 2131762043), com.tencent.mm.cb.a.aI((Context)getContext(), 2131763865), false, (DialogInterface.OnClickListener)new b(this), (DialogInterface.OnClickListener)new c(this));
      AppMethodBeat.o(256941);
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
        aML();
        break;
        paramInt = 0;
        break label324;
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(256943);
    super.onResume();
    c localc = c.Akc;
    c.sm(true);
    localc = c.Akc;
    c.cjj();
    AppMethodBeat.o(256943);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/MusicMvRouterUI$Companion;", "", "()V", "TAG", "", "TAKE_PHOTO_REQUEST_CODE", "", "plugin-mv_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(MusicMvRouterUI paramMusicMvRouterUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(256935);
      paramDialogInterface.dismiss();
      this.Arz.finish();
      paramDialogInterface = this.Arz.getContext();
      Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI$onRequestPermissionsResult$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, "com/tencent/mm/plugin/mv/ui/MusicMvRouterUI$onRequestPermissionsResult$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(256935);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(MusicMvRouterUI paramMusicMvRouterUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(256936);
      paramDialogInterface.dismiss();
      this.Arz.finish();
      AppMethodBeat.o(256936);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.MusicMvRouterUI
 * JD-Core Version:    0.7.0.1
 */