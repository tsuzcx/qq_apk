package com.tencent.mm.plugin.story.ui;

import a.f.b.j;
import a.l;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.g.b.a.as;
import com.tencent.mm.g.b.a.bc;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.proxy.MediaEditorProxy;
import com.tencent.mm.media.proxy.MediaEditorProxy.a;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.story.d.b.b;
import com.tencent.mm.plugin.story.f.b;
import com.tencent.mm.plugin.story.model.i.a.a;
import com.tencent.mm.plugin.story.proxy.StoryAudioManagerProxy;
import com.tencent.mm.plugin.story.proxy.StoryAudioManagerProxy.a;
import com.tencent.mm.plugin.story.proxy.StoryCaptureProxy;
import com.tencent.mm.plugin.story.proxy.StoryCaptureProxy.a;
import com.tencent.mm.plugin.story.ui.view.CaptureView;
import com.tencent.mm.plugin.story.ui.view.editor.EditorView;
import com.tencent.mm.plugin.story.ui.view.editor.EditorView.b;
import com.tencent.mm.plugin.story.ui.view.editor.EditorView.d;
import com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer.e;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Collection;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "captureView", "Lcom/tencent/mm/plugin/story/ui/view/CaptureView;", "editorPresenter", "Lcom/tencent/mm/plugin/story/presenter/EditorPresenter;", "editorView", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorView;", "isInit", "", "screenDp", "Landroid/graphics/Point;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "status", "", "uiNavigation", "com/tencent/mm/plugin/story/ui/StoryCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$uiNavigation$1;", "voipCallingListener", "com/tencent/mm/plugin/story/ui/StoryCaptureUI$voipCallingListener$1", "Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$voipCallingListener$1;", "doReport", "", "getForceOrientation", "getLayoutId", "initCreate", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "Companion", "UINavigation", "plugin-story_release"})
@com.tencent.mm.ui.base.a(3)
public final class StoryCaptureUI
  extends MMActivity
{
  public static final StoryCaptureUI.a sHu;
  private boolean bRB;
  private final com.tencent.mm.remoteservice.d evl;
  private Point oPX;
  private CaptureView sHp;
  private EditorView sHq;
  private b sHr;
  private final StoryCaptureUI.f sHs;
  private final StoryCaptureUI.g sHt;
  private int status;
  
  static
  {
    AppMethodBeat.i(110021);
    sHu = new StoryCaptureUI.a((byte)0);
    AppMethodBeat.o(110021);
  }
  
  public StoryCaptureUI()
  {
    AppMethodBeat.i(110020);
    this.evl = new com.tencent.mm.remoteservice.d((Context)this);
    this.status = -1;
    this.sHs = new StoryCaptureUI.f(this);
    this.sHt = new StoryCaptureUI.g(this);
    AppMethodBeat.o(110020);
  }
  
  public final int getForceOrientation()
  {
    if (ac.eru.eoC) {
      return 7;
    }
    return 1;
  }
  
  public final int getLayoutId()
  {
    return 2130970930;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(110015);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ab.i("MicroMsg.StoryCaptureUI", "onActivityResult, requestCode:" + paramInt1 + ", resultCode:" + paramInt2 + ", data:" + paramIntent);
    Object localObject3 = this.sHq;
    Object localObject1;
    int i;
    Object localObject2;
    label395:
    Object localObject4;
    label563:
    label582:
    label601:
    label614:
    boolean bool;
    if ((localObject3 != null) && (paramInt1 == 1003) && (paramInt2 == -1))
    {
      if (paramIntent != null)
      {
        ((EditorView)localObject3).sPS.eSM = bo.bf(paramIntent.getStringExtra("get_poi_name"), "");
        ((EditorView)localObject3).sPS.gwR = bo.bf(paramIntent.getStringExtra("get_city"), "");
        ((EditorView)localObject3).sPS.wDi = paramIntent.getFloatExtra("get_lat", -1000.0F);
        ((EditorView)localObject3).sPS.wDh = paramIntent.getFloatExtra("get_lng", -1000.0F);
        ((EditorView)localObject3).sPS.xpN = paramIntent.getStringExtra("get_poi_classify_id");
        localObject1 = com.tencent.mm.plugin.story.model.audio.c.swQ;
        float f1 = ((EditorView)localObject3).sPS.wDh;
        float f2 = ((EditorView)localObject3).sPS.wDi;
        com.tencent.mm.plugin.story.model.audio.c.mw((f1 * 1000000.0F));
        com.tencent.mm.plugin.story.model.audio.c.mx((1000000.0F * f2));
        ab.i(((EditorView)localObject3).TAG, "onActivityResult check cur lat " + ((EditorView)localObject3).sPS.wDi + ' ' + ((EditorView)localObject3).sPS.wDh + " poiname " + ((EditorView)localObject3).sPS.eSM + " City " + ((EditorView)localObject3).sPS.gwR);
        if ((bo.isNullOrNil(((EditorView)localObject3).sPS.eSM)) && (bo.isNullOrNil(((EditorView)localObject3).sPS.gwR))) {
          break label830;
        }
        i = 1;
        if (i == 0) {
          break label852;
        }
        if (!((EditorView)localObject3).sPM.cFS()) {
          break label836;
        }
        localObject1 = ((EditorView)localObject3).sPM;
        localObject2 = ((EditorView)localObject3).sPS;
        j.q(localObject2, "sl");
        if (((EditorItemContainer)localObject1).sQI != null)
        {
          ((EditorItemContainer)localObject1).i((a.f.a.a)EditorItemContainer.e.sQV);
          ((EditorItemContainer)localObject1).b((chj)localObject2);
        }
      }
      ((EditorView)localObject3).sQf = new EditorView.b((EditorView)localObject3);
      localObject4 = ((EditorView)localObject3).sQf;
      if ((localObject4 != null) && (paramIntent != null))
      {
        ((EditorView.b)localObject4).index = paramIntent.getIntExtra("report_index", -1);
        ((EditorView.b)localObject4).peO = paramIntent.getLongExtra("first_start_time", 0L);
        ((EditorView.b)localObject4).peP = paramIntent.getLongExtra("lastSuccStamp", 0L);
        ((EditorView.b)localObject4).peQ = paramIntent.getLongExtra("firstSuccStamp", 0L);
        ((EditorView.b)localObject4).peR = paramIntent.getIntExtra("reqLoadCnt", 0);
        ((EditorView.b)localObject4).ogt = paramIntent.getIntExtra("entry_time", 0);
        localObject2 = paramIntent.getStringExtra("search_id");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((EditorView.b)localObject4).hng = ((String)localObject1);
      }
      ((EditorView)localObject3).cFM();
    }
    else if ((paramInt1 == 1002) && (paramInt2 == -1))
    {
      if (paramIntent == null) {
        break label890;
      }
      localObject1 = paramIntent.getStringExtra("K_SEGMENTVIDEOPATH");
      if (paramIntent == null) {
        break label896;
      }
      localObject2 = Long.valueOf(paramIntent.getLongExtra("key_seek_look_start_time", -1L));
      if (paramIntent == null) {
        break label902;
      }
      localObject3 = Long.valueOf(paramIntent.getLongExtra("key_seek_end_time", -1L));
      if (paramIntent == null) {
        break label908;
      }
      localObject4 = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
      if (paramIntent == null) {
        break label914;
      }
      bool = paramIntent.getBooleanExtra("key_is_photo_to_video", false);
      label628:
      if (!bo.isNullOrNil((String)localObject1)) {
        break label975;
      }
      if (paramIntent == null) {
        break label920;
      }
      paramIntent = paramIntent.getStringArrayListExtra("key_select_video_list");
      label648:
      if ((paramIntent == null) || (paramIntent.size() <= 0)) {
        break label975;
      }
    }
    label779:
    label830:
    label836:
    label975:
    for (paramIntent = (String)paramIntent.get(0);; paramIntent = (Intent)localObject1)
    {
      ab.i("MicroMsg.StoryCaptureUI", "select from album finish, videoPath:" + paramIntent + ", startTime:" + localObject2 + ", endTime:" + localObject3 + ", isPhotoToVideo:" + bool);
      com.tencent.mm.plugin.story.e.a locala = new com.tencent.mm.plugin.story.e.a();
      if (paramIntent == null) {}
      for (localObject1 = "";; localObject1 = paramIntent)
      {
        locala.acH((String)localObject1);
        long l;
        if (localObject2 != null)
        {
          l = ((Long)localObject2).longValue();
          label760:
          locala.ssn = l;
          if (localObject3 == null) {
            break label933;
          }
          l = ((Long)localObject3).longValue();
          locala.sso = l;
          locala.fbp = false;
          if (bo.isNullOrNil(paramIntent)) {
            break label941;
          }
          locala.eWL = SightVideoJNI.getMp4Rotate(paramIntent);
        }
        for (;;)
        {
          locala.ssp = bool;
          this.sHs.b(locala);
          AppMethodBeat.o(110015);
          return;
          i = 0;
          break;
          ((EditorView)localObject3).sPM.b(((EditorView)localObject3).sPS);
          break label395;
          label852:
          if (!((EditorView)localObject3).sPM.cFS()) {
            break label395;
          }
          ((EditorView)localObject3).sPM.i((a.f.a.a)EditorView.d.sQl);
          ((EditorView)localObject3).sPK.setVisibility(8);
          break label395;
          label890:
          localObject1 = null;
          break label563;
          localObject2 = null;
          break label582;
          localObject3 = null;
          break label601;
          localObject4 = null;
          break label614;
          bool = false;
          break label628;
          paramIntent = null;
          break label648;
          l = -1L;
          break label760;
          l = -1L;
          break label779;
          paramIntent = new ArrayList((Collection)localObject4);
          j.q(paramIntent, "<set-?>");
          locala.sss = paramIntent;
        }
      }
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(110018);
    Object localObject = this.sHp;
    if (localObject != null)
    {
      if (((CaptureView)localObject).sLk != null) {
        ((CaptureView)localObject).cFt();
      }
      for (int i = 1; i == 1; i = 0)
      {
        AppMethodBeat.o(110018);
        return;
      }
    }
    localObject = com.tencent.mm.plugin.story.g.i.sFa;
    com.tencent.mm.plugin.story.g.i.FR(14);
    localObject = this.sHr;
    if (localObject != null)
    {
      if (!((b)localObject).zY())
      {
        this.sHs.exit();
        localObject = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.cDk();
        localObject = com.tencent.mm.plugin.story.g.i.sFa;
        com.tencent.mm.plugin.story.g.i.cDn();
      }
      AppMethodBeat.o(110018);
      return;
    }
    AppMethodBeat.o(110018);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(110017);
    j.q(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    if ((this.bRB) && (com.tencent.mm.compatible.util.d.fv(13)))
    {
      paramConfiguration = new Point(paramConfiguration.screenWidthDp, paramConfiguration.screenHeightDp);
      if ((this.oPX == null) || ((j.e(this.oPX, paramConfiguration) ^ true))) {
        this.oPX = paramConfiguration;
      }
    }
    AppMethodBeat.o(110017);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110012);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    paramBundle = StoryCaptureProxy.sCS;
    StoryCaptureProxy.a.createInstance(this.evl);
    paramBundle = StoryAudioManagerProxy.sCO;
    StoryAudioManagerProxy.a.createInstance(this.evl);
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.evl));
    paramBundle = MediaEditorProxy.eVP;
    MediaEditorProxy.a.createInstance(this.evl);
    this.evl.connect((Runnable)new StoryCaptureUI.c(this));
    this.sHp = ((CaptureView)findViewById(2131828290));
    paramBundle = this.sHp;
    if (paramBundle != null) {
      paramBundle.setUiNavigation((StoryCaptureUI.b)this.sHs);
    }
    this.sHq = ((EditorView)findViewById(2131828291));
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    com.tencent.mm.plugin.mmsight.d.jm(true);
    com.tencent.mm.sdk.b.a.ymk.c((com.tencent.mm.sdk.b.c)this.sHt);
    paramBundle = com.tencent.mm.plugin.story.g.i.sFa;
    com.tencent.mm.plugin.story.g.i.cDk();
    paramBundle = com.tencent.mm.plugin.story.g.i.sFa;
    com.tencent.mm.plugin.story.g.i.cDl();
    int i = getIntent().getIntExtra("jump_page_from", -1);
    long l1 = getIntent().getLongExtra("video_object_id", 0L);
    long l2 = System.currentTimeMillis();
    paramBundle = com.tencent.mm.plugin.story.g.i.sFa;
    com.tencent.mm.plugin.story.g.i.cDi().bG(at.gV((Context)getContext()));
    paramBundle = com.tencent.mm.plugin.story.g.i.sFa;
    com.tencent.mm.plugin.story.g.i.cDi().fY(String.valueOf(l2));
    paramBundle = com.tencent.mm.plugin.story.g.i.sFa;
    com.tencent.mm.plugin.story.g.i.cDi().bH(i);
    paramBundle = com.tencent.mm.plugin.story.g.i.sFa;
    com.tencent.mm.plugin.story.g.i.cDi().bI(l2);
    paramBundle = com.tencent.mm.plugin.story.g.i.sFa;
    com.tencent.mm.plugin.story.g.i.cDi().bR(l1);
    paramBundle = com.tencent.mm.plugin.story.g.i.sFa;
    com.tencent.mm.plugin.story.g.i.cDm().cU(at.gV((Context)getContext()));
    paramBundle = com.tencent.mm.plugin.story.g.i.sFa;
    paramBundle = com.tencent.mm.plugin.story.g.i.cDm();
    StringBuilder localStringBuilder = new StringBuilder();
    e locale = g.RL();
    j.p(locale, "MMKernel.storage()");
    paramBundle.gq(locale.Ru().get(2).toString() + l2);
    paramBundle = com.tencent.mm.plugin.story.g.i.sFa;
    com.tencent.mm.plugin.story.g.i.cDm().cV(i);
    paramBundle = com.tencent.mm.plugin.story.g.i.sFa;
    com.tencent.mm.plugin.story.g.i.cDm().cW(l2);
    paramBundle = com.tencent.mm.plugin.story.g.i.sFa;
    com.tencent.mm.plugin.story.g.i.cDm().db(l1);
    paramBundle = com.tencent.mm.plugin.story.g.d.sEm;
    com.tencent.mm.plugin.story.g.d.cCH();
    this.bRB = true;
    com.tencent.mm.cn.d.aNX();
    com.tencent.mm.plugin.story.image2video.d.czT();
    AppMethodBeat.o(110012);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(110019);
    super.onDestroy();
    this.evl.release();
    Object localObject = this.sHp;
    if (localObject != null) {
      ((CaptureView)localObject).lyn.release();
    }
    localObject = this.sHr;
    if (localObject != null)
    {
      ((b)localObject).reset();
      ((b)localObject).sAF.destroy();
    }
    com.tencent.mm.sdk.b.a.ymk.d((com.tencent.mm.sdk.b.c)this.sHt);
    localObject = com.tencent.mm.plugin.story.model.i.suJ;
    com.tencent.mm.sdk.g.d.post((Runnable)i.a.a.suK, "Story_cleanAudioFile");
    localObject = com.tencent.mm.plugin.story.g.d.sEm;
    com.tencent.mm.plugin.story.g.d.cCI();
    AppMethodBeat.o(110019);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(110014);
    ab.i("MicroMsg.StoryCaptureUI", "onPause, status:" + this.status);
    Object localObject = com.tencent.mm.plugin.story.g.i.sFa;
    com.tencent.mm.plugin.story.g.i.FR(15);
    super.onPause();
    if (this.status == 0)
    {
      localObject = this.sHp;
      if (localObject != null)
      {
        ((CaptureView)localObject).lyn.stopPreview();
        AppMethodBeat.o(110014);
        return;
      }
      AppMethodBeat.o(110014);
      return;
    }
    if (this.status == 1)
    {
      localObject = this.sHr;
      if (localObject != null)
      {
        ((b)localObject).pause();
        AppMethodBeat.o(110014);
        return;
      }
    }
    AppMethodBeat.o(110014);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(110016);
    j.q(paramArrayOfString, "permissions");
    j.q(paramArrayOfInt, "grantResults");
    if (paramArrayOfInt.length <= 0)
    {
      paramArrayOfString = Thread.currentThread();
      j.p(paramArrayOfString, "Thread.currentThread()");
      ab.i("MicroMsg.StoryCaptureUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramArrayOfString.getId()) });
      AppMethodBeat.o(110016);
      return;
    }
    int i = paramArrayOfInt[0];
    paramArrayOfString = Thread.currentThread();
    j.p(paramArrayOfString, "Thread.currentThread()");
    ab.i("MicroMsg.StoryCaptureUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Long.valueOf(paramArrayOfString.getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(110016);
      return;
      if (paramArrayOfInt[0] != 0) {
        h.a((Context)this, getString(2131302073), getString(2131302083), getString(2131300996), getString(2131296888), false, (DialogInterface.OnClickListener)new StoryCaptureUI.d(this), (DialogInterface.OnClickListener)StoryCaptureUI.e.sHw);
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(110013);
    ab.i("MicroMsg.StoryCaptureUI", "onResume, status:" + this.status);
    super.onResume();
    setSelfNavigationBarVisible(8);
    Object localObject;
    if (this.status == 0)
    {
      localObject = this.sHp;
      if (localObject != null)
      {
        ((CaptureView)localObject).resume();
        AppMethodBeat.o(110013);
        return;
      }
      AppMethodBeat.o(110013);
      return;
    }
    if (this.status == 1)
    {
      localObject = this.sHr;
      if (localObject != null)
      {
        ((b)localObject).resume();
        AppMethodBeat.o(110013);
        return;
      }
    }
    AppMethodBeat.o(110013);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryCaptureUI
 * JD-Core Version:    0.7.0.1
 */