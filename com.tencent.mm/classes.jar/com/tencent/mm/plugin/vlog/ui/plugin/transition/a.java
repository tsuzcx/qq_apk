package com.tencent.mm.plugin.vlog.ui.plugin.transition;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.vlog.a.f;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditTransitionPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$EditTransitionListener;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "autoInitTransitionInfo", "", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Z)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "editSelectTrack", "", "getEditSelectTrack", "()I", "setEditSelectTrack", "(I)V", "editStartLoopTimeMs", "", "getEditStartLoopTimeMs", "()J", "setEditStartLoopTimeMs", "(J)V", "holder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "transitionEditView", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView;", "getTransitionEditView", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView;", "transitionEditView$delegate", "Lkotlin/Lazy;", "initTransitionInfo", "", "initTransitionViewOnce", "onApplyTransitionToAll", "editTransitionIndex", "effect", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "onClose", "onSetTransition", "setVisibility", "visibility", "showEditTransitionDialog", "transitionIndex", "order", "path", "", "Companion", "plugin-vlog_release"})
public final class a
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements b.b
{
  public static final a NBg;
  d APl;
  public final EditorPanelHolder ATq;
  private final f NBd;
  public int NBe;
  public long NBf;
  private final Context context;
  private ViewGroup parent;
  
  static
  {
    AppMethodBeat.i(227311);
    NBg = new a((byte)0);
    AppMethodBeat.o(227311);
  }
  
  public a(ViewGroup paramViewGroup, d paramd, final boolean paramBoolean)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(227309);
    this.parent = paramViewGroup;
    this.APl = paramd;
    this.context = this.parent.getContext();
    this.ATq = ((EditorPanelHolder)this.parent.findViewById(a.f.editor_transition_edit_panel));
    this.NBd = g.ar((kotlin.g.a.a)new c(this, paramBoolean));
    this.NBe = -1;
    AppMethodBeat.o(227309);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.vlog.model.local.a.a parama)
  {
    AppMethodBeat.i(227300);
    d locald = this.APl;
    d.c localc = d.c.HTr;
    Bundle localBundle = new Bundle();
    localBundle.putInt("EDIT_SELECT_TRANSITION_INDEX", paramInt);
    String str;
    if (parama != null)
    {
      paramInt = parama.order;
      localBundle.putInt("EDIT_TRANSITION_EFFECT_ID", paramInt);
      if (parama == null) {
        break label108;
      }
      str = parama.assetPath;
      label60:
      localBundle.putString("PARAM_1_STRING", str);
      if (parama == null) {
        break label114;
      }
    }
    label108:
    label114:
    for (long l = parama.duration;; l = 0L)
    {
      localBundle.putLong("PARAM_1_INT", l);
      locald.a(localc, localBundle);
      AppMethodBeat.o(227300);
      return;
      paramInt = 0;
      break;
      str = null;
      break label60;
    }
  }
  
  public final void b(int paramInt, com.tencent.mm.plugin.vlog.model.local.a.a parama)
  {
    AppMethodBeat.i(227303);
    d locald = this.APl;
    d.c localc = d.c.HTq;
    Bundle localBundle = new Bundle();
    localBundle.putInt("EDIT_SELECT_TRANSITION_INDEX", paramInt);
    Object localObject;
    long l;
    if (parama != null)
    {
      localObject = parama.assetPath;
      localBundle.putString("PARAM_1_STRING", (String)localObject);
      if (parama == null) {
        break label122;
      }
      l = parama.duration;
      label61:
      localBundle.putLong("PARAM_1_INT", l);
      if (parama != null)
      {
        localObject = com.tencent.mm.plugin.vlog.model.local.a.Nol;
        com.tencent.mm.plugin.vlog.model.local.a.b(parama);
      }
      if (parama == null) {
        break label127;
      }
    }
    label122:
    label127:
    for (paramInt = parama.order;; paramInt = 0)
    {
      localBundle.putInt("EDIT_TRANSITION_EFFECT_ID", paramInt);
      locald.a(localc, localBundle);
      AppMethodBeat.o(227303);
      return;
      localObject = null;
      break;
      l = 0L;
      break label61;
    }
  }
  
  public final b gwr()
  {
    AppMethodBeat.i(227292);
    b localb = (b)this.NBd.getValue();
    AppMethodBeat.o(227292);
    return localb;
  }
  
  public final void gws()
  {
    AppMethodBeat.i(227295);
    if (!this.ATq.fpT())
    {
      EditorPanelHolder.a(this.ATq, (View)gwr());
      this.ATq.setOnVisibleChangeCallback((kotlin.g.a.b)new b(this));
      gwr().setEditTransitionListener((b.b)this);
      gwr().gwt();
    }
    AppMethodBeat.o(227295);
  }
  
  public final void kK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(227299);
    gws();
    gwr().kL(paramInt1, paramInt2);
    this.ATq.setShow(true);
    AppMethodBeat.o(227299);
  }
  
  public final void onClose()
  {
    AppMethodBeat.i(227305);
    this.ATq.setShow(false);
    AppMethodBeat.o(227305);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(227297);
    if (paramInt == 0)
    {
      d.b.a(this.APl, d.c.HTl);
      AppMethodBeat.o(227297);
      return;
    }
    d.b.a(this.APl, d.c.HTm);
    AppMethodBeat.o(227297);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditTransitionPlugin$Companion;", "", "()V", "TAG", "", "TRANS_LOOP_TIME", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<b>
  {
    c(a parama, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.transition.a
 * JD-Core Version:    0.7.0.1
 */