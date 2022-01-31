package com.tencent.mm.plugin.recordvideo.plugin.parent;

import a.f.b.j;
import a.l;
import a.v;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.e;
import com.tencent.mm.api.k;
import com.tencent.mm.api.n;
import com.tencent.mm.api.r;
import com.tencent.mm.api.s;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.doodle.PhotoDoodlePlugin;
import com.tencent.mm.plugin.recordvideo.plugin.f;
import com.tencent.mm.plugin.recordvideo.plugin.f.b;
import com.tencent.mm.plugin.recordvideo.plugin.g;
import com.tencent.mm.plugin.recordvideo.plugin.g.a;
import com.tencent.mm.plugin.recordvideo.plugin.h;
import com.tencent.mm.plugin.recordvideo.plugin.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditPhotoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "addEmojiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "backToRecordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "editAddTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "editCropPhotoPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoCropPlugin;", "editFinishPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "editPencilPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin;", "editPhotoWrapper", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "photoControlUI", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin;", "initLogic", "", "onBackPress", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "toEditPhoto", "info", "Companion", "plugin-recordvideo_release"})
public final class EditPhotoPluginLayout
  extends BasePluginLayout
  implements d
{
  public static final EditPhotoPluginLayout.a qdT;
  public RecordConfigProvider qaF;
  public com.tencent.mm.media.widget.camerarecordview.a.b qbS;
  private com.tencent.mm.plugin.recordvideo.activity.a qdK;
  private final i qdL;
  private final h qdM;
  public final f qdN;
  private final com.tencent.mm.plugin.recordvideo.plugin.c qdO;
  private final g qdP;
  private final com.tencent.mm.plugin.recordvideo.plugin.a qdQ;
  private final com.tencent.mm.plugin.recordvideo.plugin.d qdR;
  private final com.tencent.mm.plugin.recordvideo.plugin.b qdS;
  
  static
  {
    AppMethodBeat.i(150799);
    qdT = new EditPhotoPluginLayout.a((byte)0);
    AppMethodBeat.o(150799);
  }
  
  public EditPhotoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(150798);
    View.inflate(paramContext, 2130970419, (ViewGroup)this);
    paramContext = findViewById(2131828697);
    j.p(paramContext, "findViewById(R.id.editor_close)");
    this.qdO = new com.tencent.mm.plugin.recordvideo.plugin.c((ImageView)paramContext, (d)this);
    this.qdL = new i((ViewGroup)this, (d)this);
    paramContext = (ViewGroup)this;
    paramAttributeSet = findViewById(2131823579);
    j.p(paramAttributeSet, "findViewById(R.id.editor_add_emoji)");
    this.qdQ = new com.tencent.mm.plugin.recordvideo.plugin.a(paramContext, (ImageView)paramAttributeSet, (d)this);
    this.qdS = new com.tencent.mm.plugin.recordvideo.plugin.b((ViewGroup)this, (d)this);
    paramContext = findViewById(2131828702);
    j.p(paramContext, "findViewById(R.id.editor_photo_crop)");
    this.qdM = new h((ImageView)paramContext, (d)this);
    paramContext = findViewById(2131828380);
    j.p(paramContext, "findViewById(R.id.editor_mix)");
    this.qdR = new com.tencent.mm.plugin.recordvideo.plugin.d(paramContext, (d)this);
    paramContext = findViewById(2131826736);
    j.p(paramContext, "findViewById(R.id.photo_preview_plugin)");
    this.qdN = new f((FrameLayout)paramContext, (d)this);
    paramContext = findViewById(2131826737);
    j.p(paramContext, "findViewById(R.id.control_container)");
    this.qdP = new g((ViewGroup)paramContext, (d)this);
    this.qdQ.setVisibility(0);
    this.qdS.setVisibility(0);
    getPluginList().add(this.qdP);
    getPluginList().add(this.qdL);
    getPluginList().add(this.qdM);
    getPluginList().add(this.qdN);
    getPluginList().add(this.qdO);
    getPluginList().add(this.qdQ);
    getPluginList().add(this.qdR);
    getPluginList().add(this.qdS);
    AppMethodBeat.o(150798);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.activity.a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(150795);
    j.q(parama, "navigator");
    j.q(paramRecordConfigProvider, "configProvider");
    ab.i("MicroMsg.EditPhotoPluginLayout", "configProvider ".concat(String.valueOf(paramRecordConfigProvider)));
    this.qdK = parama;
    this.qaF = paramRecordConfigProvider;
    parama = com.tencent.mm.plugin.recordvideo.d.a.qfv;
    com.tencent.mm.plugin.recordvideo.d.a.b(paramRecordConfigProvider);
    AppMethodBeat.o(150795);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(150796);
    j.q(paramc, "status");
    ab.i("MicroMsg.EditPhotoPluginLayout", "status :" + paramc + " , param :" + paramBundle);
    Object localObject;
    switch (a.bLo[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(150796);
      return;
    case 1: 
      cgq();
      AppMethodBeat.o(150796);
      return;
    case 2: 
    case 3: 
    case 4: 
      this.qdP.setVisibility(4);
      AppMethodBeat.o(150796);
      return;
    case 5: 
      this.qdP.setVisibility(0);
      AppMethodBeat.o(150796);
      return;
    case 6: 
      if (paramBundle != null)
      {
        paramBundle = (EmojiInfo)paramBundle.getParcelable("PARAM_EDIT_EMOJI_INFO");
        if (paramBundle != null)
        {
          paramc = this.qdN;
          paramBundle = (k)paramBundle;
          j.q(paramBundle, "emojiInfo");
          localObject = paramc.qbU;
          if (localObject != null) {
            ((com.tencent.mm.bs.b)localObject).getSelectedFeatureListener().a(e.bVX);
          }
          paramc = paramc.qbU;
          if (paramc != null)
          {
            paramc.d(paramBundle);
            AppMethodBeat.o(150796);
            return;
          }
          AppMethodBeat.o(150796);
          return;
        }
      }
      AppMethodBeat.o(150796);
      return;
    case 7: 
      this.qdL.cgy();
      AppMethodBeat.o(150796);
      return;
    case 8: 
      this.qdP.cgx();
      this.qdN.reset();
      AppMethodBeat.o(150796);
      return;
    case 9: 
      paramc = this.qdN;
      paramc.qbW = e.bVZ;
      paramc.eSO = 0;
      paramBundle = paramc.qbU;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(e.bVZ);
      }
      paramc = paramc.qbU;
      if (paramc != null) {
        paramc.getSelectedFeatureListener().a(e.bVZ, 0);
      }
      paramc = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      com.tencent.mm.plugin.recordvideo.c.b.Ya("KEY_CLICK_MOSAIC_COUNT_INT");
      paramc = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      com.tencent.mm.plugin.recordvideo.c.b.Cs(8);
      AppMethodBeat.o(150796);
      return;
    case 10: 
      paramc = this.qdN;
      paramc.qbW = e.bVZ;
      paramc.eSO = 1;
      paramBundle = paramc.qbU;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(e.bVZ);
      }
      paramc = paramc.qbU;
      if (paramc != null) {
        paramc.getSelectedFeatureListener().a(e.bVZ, 1);
      }
      paramc = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      com.tencent.mm.plugin.recordvideo.c.b.Ya("KEY_CLICK_BRUSH_COUNT_INT");
      paramc = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      com.tencent.mm.plugin.recordvideo.c.b.Cs(9);
      AppMethodBeat.o(150796);
      return;
    case 11: 
      if (paramBundle != null)
      {
        paramc = this.qdN;
        i = paramBundle.getInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT");
        paramc.qbW = e.bVW;
        paramc.eSO = i;
        paramBundle = paramc.qbU;
        if (paramBundle != null) {
          paramBundle.getSelectedFeatureListener().a(e.bVW);
        }
        paramc = paramc.qbU;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(e.bVW, i);
          AppMethodBeat.o(150796);
          return;
        }
      }
      AppMethodBeat.o(150796);
      return;
    case 12: 
      paramc = this.qdN;
      paramBundle = paramc.qbU;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(com.tencent.mm.cache.c.Jg().Jh(), -1);
      }
      paramBundle = paramc.qbU;
      if (paramBundle != null) {
        paramBundle.getSelectedFeatureListener().a(paramc.qbW);
      }
      paramBundle = paramc.qbU;
      if (paramBundle != null)
      {
        paramBundle.getSelectedFeatureListener().a(paramc.qbW, paramc.eSO);
        AppMethodBeat.o(150796);
        return;
      }
      AppMethodBeat.o(150796);
      return;
    case 13: 
      this.qdO.setVisibility(0);
    case 26: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
      do
      {
        this.qdP.setVisibility(0);
        break;
        this.qdO.setVisibility(4);
        this.qdP.setVisibility(4);
        paramc = this.qdN.qbU;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(e.bVY);
          AppMethodBeat.o(150796);
          return;
        }
        AppMethodBeat.o(150796);
        return;
        this.qdO.setVisibility(4);
        this.qdP.setVisibility(4);
        paramc = this.qdN.qbU;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(e.bVX);
          AppMethodBeat.o(150796);
          return;
        }
        AppMethodBeat.o(150796);
        return;
        int j;
        if (paramBundle != null)
        {
          localObject = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
          i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
          j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
          paramc = this.qdN;
          paramBundle = (Editable)localObject;
          if (paramBundle == null) {
            j.ebi();
          }
          j.q(paramBundle, "text");
          paramBundle.clearSpans();
          localObject = paramc.qbU;
          if (localObject != null) {
            ((com.tencent.mm.bs.b)localObject).getSelectedFeatureListener().a(e.bVX);
          }
          paramc = paramc.qbU;
          if (paramc != null)
          {
            paramc.a(paramBundle, i, j);
            AppMethodBeat.o(150796);
            return;
          }
        }
        AppMethodBeat.o(150796);
        return;
        if (paramBundle != null)
        {
          paramc = paramBundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
          i = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR");
          j = paramBundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
          this.qdS.e(paramc, i, j);
        }
        AppMethodBeat.o(150796);
        return;
        this.qdO.setVisibility(0);
        this.qdP.cgx();
        this.qdL.cgy();
        this.qdN.cgw();
        AppMethodBeat.o(150796);
        return;
        paramc = this.qdN;
        paramBundle = com.tencent.mm.plugin.recordvideo.c.b.qfu;
        paramBundle = paramc.oOG.zZ();
        j.p(paramBundle, "photoEditor.photoEditReport");
        com.tencent.mm.plugin.recordvideo.c.b.p("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(paramBundle.An()));
        paramBundle = com.tencent.mm.plugin.recordvideo.c.b.qfu;
        paramBundle = paramc.oOG.zZ();
        j.p(paramBundle, "photoEditor.photoEditReport");
        com.tencent.mm.plugin.recordvideo.c.b.p("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(paramBundle.Am()));
        paramBundle = com.tencent.mm.plugin.recordvideo.c.b.qfu;
        paramBundle = paramc.oOG.zZ();
        j.p(paramBundle, "photoEditor.photoEditReport");
        com.tencent.mm.plugin.recordvideo.c.b.p("KEY_ADD_DOODLE_COUNT_INT", Integer.valueOf(paramBundle.Ap()));
        paramBundle = com.tencent.mm.plugin.recordvideo.c.b.qfu;
        paramBundle = paramc.oOG.zZ();
        j.p(paramBundle, "photoEditor.photoEditReport");
        com.tencent.mm.plugin.recordvideo.c.b.p("KEY_ADD_DOODLE_COLOR_COUNT_INT", Integer.valueOf(paramBundle.As()));
        paramBundle = com.tencent.mm.plugin.recordvideo.c.b.qfu;
        paramBundle = paramc.oOG.zZ();
        j.p(paramBundle, "photoEditor.photoEditReport");
        com.tencent.mm.plugin.recordvideo.c.b.p("KEY_ADD_MOSAIC_COUNT_INT", Integer.valueOf(paramBundle.Ao()));
        paramBundle = com.tencent.mm.plugin.recordvideo.c.b.qfu;
        paramBundle = paramc.oOG.zZ();
        j.p(paramBundle, "photoEditor.photoEditReport");
        if (paramBundle.Ar()) {
          i = 1;
        }
        com.tencent.mm.plugin.recordvideo.c.b.p("KEY_ROTATE_INT", Integer.valueOf(i));
        paramBundle = com.tencent.mm.plugin.recordvideo.c.b.qfu;
        com.tencent.mm.plugin.recordvideo.c.b.p("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
        paramBundle = paramc.oOG.zZ();
        j.p(paramBundle, "photoEditor.photoEditReport");
        boolean bool = paramBundle.At();
        if (bool)
        {
          paramBundle = com.tencent.mm.media.i.c.eZC;
          com.tencent.mm.media.i.c.VP();
        }
        paramBundle = com.tencent.mm.media.i.c.eZC;
        com.tencent.mm.media.i.c.VW();
        if (!paramc.mwZ)
        {
          paramBundle = paramc.context;
          if (paramBundle == null)
          {
            paramc = new v("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(150796);
            throw paramc;
          }
          if (!((Activity)paramBundle).isFinishing()) {}
        }
        else
        {
          AppMethodBeat.o(150796);
          return;
        }
        paramc.mwZ = true;
        long l = bo.yB();
        ab.d("MicroMsg.EditPhotoPluginLayout", "dofinish time: ".concat(String.valueOf(l)));
        paramBundle = com.tencent.mm.ui.base.p.b(paramc.context, (CharSequence)((Activity)paramc.context).getResources().getString(2131306206), true, null);
        paramc.oOG.a((n)new f.b(paramc, l, paramBundle, bool));
        AppMethodBeat.o(150796);
        return;
        this.qdL.qcn.setVisibility(4);
        this.qdO.setVisibility(4);
        paramc = this.qdP;
        paramc.qcf = g.a.qch;
        paramBundle = paramc.qcb;
        j.p(paramBundle, "normalFuncLayout");
        paramBundle.setVisibility(4);
        paramc = paramc.qcc;
        j.p(paramc, "cropFuncLayout");
        paramc.setVisibility(0);
        paramc = this.qdN;
        if (paramc.qbW != e.bWa)
        {
          paramc.qbW = e.bWa;
          paramc = paramc.qbU;
          if (paramc != null)
          {
            paramc.getSelectedFeatureListener().a(e.bWa);
            AppMethodBeat.o(150796);
            return;
          }
        }
        AppMethodBeat.o(150796);
        return;
        this.qdO.setVisibility(0);
        paramc = this.qdN;
        paramc.qbW = e.bVV;
        paramc = paramc.qbU;
        if (paramc != null) {
          paramc.getSelectedFeatureListener().a(e.bWa, 2);
        }
        this.qdL.cgy();
        AppMethodBeat.o(150796);
        return;
        paramc = this.qdN;
        paramc.qbW = e.bWa;
        paramc = paramc.qbU;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(e.bWa, 0);
          AppMethodBeat.o(150796);
          return;
        }
        AppMethodBeat.o(150796);
        return;
        paramc = this.qdN;
        paramc.qbW = e.bWa;
        paramc = paramc.qbU;
        if (paramc != null)
        {
          paramc.getSelectedFeatureListener().a(e.bWa, 3);
          AppMethodBeat.o(150796);
          return;
        }
        AppMethodBeat.o(150796);
        return;
      } while (this.qdP.qcg.getVisibility() == 4);
      if (this.qdP.qcg.getVisibility() == 0) {
        this.qdP.setVisibility(4);
      }
      AppMethodBeat.o(150796);
      return;
    }
    this.qdP.setVisibility(4);
    AppMethodBeat.o(150796);
  }
  
  public final boolean cgq()
  {
    AppMethodBeat.i(150797);
    if (!super.cgq())
    {
      Object localObject = com.tencent.mm.media.i.c.eZC;
      com.tencent.mm.media.i.c.VT();
      localObject = com.tencent.mm.plugin.recordvideo.c.b.qfu;
      com.tencent.mm.plugin.recordvideo.c.b.p("KEY_AFTER_EDIT_INT", Integer.valueOf(0));
      localObject = this.qdK;
      if (localObject != null) {
        ((com.tencent.mm.plugin.recordvideo.activity.a)localObject).cgh();
      }
    }
    AppMethodBeat.o(150797);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout
 * JD-Core Version:    0.7.0.1
 */