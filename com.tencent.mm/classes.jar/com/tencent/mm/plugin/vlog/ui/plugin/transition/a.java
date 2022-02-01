package com.tencent.mm.plugin.vlog.ui.plugin.transition;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.vlog.a.f;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditTransitionPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$EditTransitionListener;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "autoInitTransitionInfo", "", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Z)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "editSelectTrack", "", "getEditSelectTrack", "()I", "setEditSelectTrack", "(I)V", "editStartLoopTimeMs", "", "getEditStartLoopTimeMs", "()J", "setEditStartLoopTimeMs", "(J)V", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "transitionEditView", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView;", "getTransitionEditView", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView;", "transitionEditView$delegate", "Lkotlin/Lazy;", "initTransitionInfo", "", "initTransitionViewOnce", "onApplyTransitionToAll", "editTransitionIndex", "effect", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "onClose", "onSetTransition", "setVisibility", "visibility", "showEditTransitionDialog", "transitionIndex", "order", "path", "", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements b.b
{
  public static final a UnO;
  private final EditorPanelHolder Gvm;
  private final j UnP;
  public int UnQ;
  public long UnR;
  private final Context context;
  private ViewGroup parent;
  
  static
  {
    AppMethodBeat.i(282925);
    UnO = new a((byte)0);
    AppMethodBeat.o(282925);
  }
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama, final boolean paramBoolean)
  {
    super(parama);
    AppMethodBeat.i(282887);
    this.parent = paramViewGroup;
    this.context = this.parent.getContext();
    this.Gvm = ((EditorPanelHolder)this.parent.findViewById(a.f.editor_transition_edit_panel));
    this.UnP = k.cm((kotlin.g.a.a)new c(this, paramBoolean));
    this.UnQ = -1;
    AppMethodBeat.o(282887);
  }
  
  private final b hUj()
  {
    AppMethodBeat.i(282903);
    b localb = (b)this.UnP.getValue();
    AppMethodBeat.o(282903);
    return localb;
  }
  
  private final void hUk()
  {
    AppMethodBeat.i(282914);
    if (!this.Gvm.gBh())
    {
      EditorPanelHolder localEditorPanelHolder = this.Gvm;
      s.s(localEditorPanelHolder, "holder");
      EditorPanelHolder.a(localEditorPanelHolder, (View)hUj());
      this.Gvm.setOnVisibleChangeCallback((kotlin.g.a.b)new b(this));
      hUj().setEditTransitionListener((b.b)this);
      hUj().hUl();
    }
    AppMethodBeat.o(282914);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.vlog.model.local.a.a parama)
  {
    AppMethodBeat.i(282972);
    com.tencent.mm.plugin.recordvideo.plugin.parent.a locala = this.GrC;
    com.tencent.mm.plugin.recordvideo.plugin.parent.a.c localc = com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NPX;
    Bundle localBundle = new Bundle();
    localBundle.putInt("EDIT_SELECT_TRANSITION_INDEX", paramInt);
    String str;
    if (parama == null)
    {
      paramInt = 0;
      localBundle.putInt("EDIT_TRANSITION_EFFECT_ID", paramInt);
      if (parama != null) {
        break label106;
      }
      str = null;
      label54:
      localBundle.putString("PARAM_1_STRING", str);
      if (parama != null) {
        break label115;
      }
    }
    label106:
    label115:
    for (long l = 0L;; l = parama.duration)
    {
      localBundle.putLong("PARAM_1_INT", l);
      parama = ah.aiuX;
      locala.a(localc, localBundle);
      AppMethodBeat.o(282972);
      return;
      paramInt = parama.order;
      break;
      str = parama.assetPath;
      break label54;
    }
  }
  
  public final void b(int paramInt, com.tencent.mm.plugin.vlog.model.local.a.a parama)
  {
    AppMethodBeat.i(282989);
    com.tencent.mm.plugin.recordvideo.plugin.parent.a locala = this.GrC;
    com.tencent.mm.plugin.recordvideo.plugin.parent.a.c localc = com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NPW;
    Bundle localBundle = new Bundle();
    localBundle.putInt("EDIT_SELECT_TRANSITION_INDEX", paramInt);
    Object localObject;
    long l;
    if (parama == null)
    {
      localObject = null;
      localBundle.putString("PARAM_1_STRING", (String)localObject);
      if (parama != null) {
        break label122;
      }
      l = 0L;
      label56:
      localBundle.putLong("PARAM_1_INT", l);
      if (parama != null)
      {
        localObject = com.tencent.mm.plugin.vlog.model.local.a.UbD;
        com.tencent.mm.plugin.vlog.model.local.a.b(parama);
      }
      if (parama != null) {
        break label130;
      }
    }
    label130:
    for (paramInt = 0;; paramInt = parama.order)
    {
      localBundle.putInt("EDIT_TRANSITION_EFFECT_ID", paramInt);
      parama = ah.aiuX;
      locala.a(localc, localBundle);
      AppMethodBeat.o(282989);
      return;
      localObject = parama.assetPath;
      break;
      label122:
      l = parama.duration;
      break label56;
    }
  }
  
  public final void bfj()
  {
    AppMethodBeat.i(283000);
    this.Gvm.setShow(false);
    AppMethodBeat.o(283000);
  }
  
  public final void dw(int paramInt, String paramString)
  {
    AppMethodBeat.i(282952);
    hUk();
    b localb = hUj();
    Object localObject1 = com.tencent.mm.plugin.vlog.model.local.a.UbD;
    localObject1 = (Iterable)com.tencent.mm.plugin.vlog.model.local.a.hRr();
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        p.kkW();
      }
      if (s.p(((com.tencent.mm.plugin.vlog.model.local.a.a)localObject2).assetPath, paramString)) {
        localb.mB(paramInt, i + 1);
      }
    }
    for (;;)
    {
      this.Gvm.setShow(true);
      AppMethodBeat.o(282952);
      return;
      i += 1;
      break;
      localb.mB(paramInt, -1);
    }
  }
  
  public final void mA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(282960);
    hUk();
    hUj().mB(paramInt1, paramInt2);
    this.Gvm.setShow(true);
    AppMethodBeat.o(282960);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(282935);
    if (paramInt == 0)
    {
      com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(this.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NPR);
      AppMethodBeat.o(282935);
      return;
    }
    com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(this.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NPS);
    AppMethodBeat.o(282935);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditTransitionPlugin$Companion;", "", "()V", "TAG", "", "TRANS_LOOP_TIME", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<b>
  {
    c(a parama, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.transition.a
 * JD-Core Version:    0.7.0.1
 */