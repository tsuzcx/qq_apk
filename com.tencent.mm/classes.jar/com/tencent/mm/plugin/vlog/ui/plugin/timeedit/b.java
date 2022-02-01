package com.tencent.mm.plugin.vlog.ui.plugin.timeedit;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.a.g;
import com.tencent.mm.plugin.vlog.a.h;
import com.tencent.mm.plugin.vlog.a.i;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditMenuView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "captionMenu", "Landroid/view/ViewGroup;", "deleteListener", "Lkotlin/Function0;", "", "getDeleteListener", "()Lkotlin/jvm/functions/Function0;", "setDeleteListener", "(Lkotlin/jvm/functions/Function0;)V", "deleteMenu", "downDrawable", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "getDownDrawable", "()Landroid/graphics/drawable/Drawable;", "downDrawable$delegate", "Lkotlin/Lazy;", "editCaptionListener", "getEditCaptionListener", "setEditCaptionListener", "editContentListener", "getEditContentListener", "setEditContentListener", "editMenu", "editTimeListener", "getEditTimeListener", "setEditTimeListener", "enableReadMenu", "", "readMenu", "readTextListener", "getReadTextListener", "setReadTextListener", "timeMenu", "upDrawable", "getUpDrawable", "upDrawable$delegate", "doSetMenuChecked", "menu", "visibility", "", "downBackground", "loadMenuLayout", "layout", "iconRes", "titleRes", "onClick", "v", "Landroid/view/View;", "setMenuChecked", "checked", "showCaptionMenu", "showNormalMenu", "enableTimeEdit", "showTextMenu", "upwardsBackground", "Companion", "plugin-vlog_release"})
public final class b
  extends LinearLayout
  implements View.OnClickListener
{
  public static final a NAH;
  private ViewGroup NAA;
  ViewGroup NAB;
  ViewGroup NAC;
  ViewGroup NAD;
  final boolean NAE;
  private final f NAF;
  private final f NAG;
  private kotlin.g.a.a<x> NAu;
  private kotlin.g.a.a<x> NAv;
  private kotlin.g.a.a<x> NAw;
  private kotlin.g.a.a<x> NAx;
  private kotlin.g.a.a<x> NAy;
  ViewGroup NAz;
  
  static
  {
    AppMethodBeat.i(251251);
    NAH = new a((byte)0);
    AppMethodBeat.o(251251);
  }
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(251249);
    this.NAE = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vLF, false);
    this.NAF = g.ar((kotlin.g.a.a)new c(this));
    this.NAG = g.ar((kotlin.g.a.a)new b(this));
    LayoutInflater.from(paramContext).inflate(a.g.time_edit_menu_view, (ViewGroup)this, true);
    paramContext = findViewById(a.f.item_menu_time);
    p.j(paramContext, "findViewById(R.id.item_menu_time)");
    this.NAz = ((ViewGroup)paramContext);
    paramContext = findViewById(a.f.item_menu_delete);
    p.j(paramContext, "findViewById(R.id.item_menu_delete)");
    this.NAA = ((ViewGroup)paramContext);
    paramContext = findViewById(a.f.item_menu_edit);
    p.j(paramContext, "findViewById(R.id.item_menu_edit)");
    this.NAB = ((ViewGroup)paramContext);
    paramContext = findViewById(a.f.item_menu_caption);
    p.j(paramContext, "findViewById(R.id.item_menu_caption)");
    this.NAC = ((ViewGroup)paramContext);
    paramContext = findViewById(a.f.item_menu_read);
    p.j(paramContext, "findViewById(R.id.item_menu_read)");
    this.NAD = ((ViewGroup)paramContext);
    if (!this.NAE) {
      this.NAD.setVisibility(8);
    }
    e(this.NAz, a.h.icons_filled_time, a.i.video_track_edit_item_time);
    e(this.NAA, a.h.icons_filled_delete, a.i.video_track_edit_item_delete);
    e(this.NAB, a.h.icons_filled_pencil, a.i.video_track_edit_item_edit);
    e(this.NAC, a.h.icons_filled_caption, a.i.video_track_edit_item_caption);
    e(this.NAD, a.h.icons_filled_talk, a.i.video_track_edit_item_read);
    AppMethodBeat.o(251249);
  }
  
  private final void e(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251242);
    Object localObject = paramViewGroup.findViewById(a.f.title);
    p.j(localObject, "layout.findViewById<TextView>(R.id.title)");
    ((TextView)localObject).setText((CharSequence)com.tencent.mm.ci.a.ba(getContext(), paramInt2));
    ((WeImageView)paramViewGroup.findViewById(a.f.icon)).setImageResource(paramInt1);
    localObject = (ImageView)paramViewGroup.findViewById(a.f.check);
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(com.tencent.mm.ci.a.m(getContext(), a.h.popvideo_post_selected_origin));
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(251242);
  }
  
  private final Drawable getDownDrawable()
  {
    AppMethodBeat.i(251239);
    Drawable localDrawable = (Drawable)this.NAG.getValue();
    AppMethodBeat.o(251239);
    return localDrawable;
  }
  
  private final Drawable getUpDrawable()
  {
    AppMethodBeat.i(251237);
    Drawable localDrawable = (Drawable)this.NAF.getValue();
    AppMethodBeat.o(251237);
    return localDrawable;
  }
  
  public final void AA(boolean paramBoolean)
  {
    AppMethodBeat.i(251245);
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      View localView = this.NAD.findViewById(a.f.check);
      if (localView == null) {
        break;
      }
      localView.setVisibility(i);
      AppMethodBeat.o(251245);
      return;
    }
    AppMethodBeat.o(251245);
  }
  
  public final kotlin.g.a.a<x> getDeleteListener()
  {
    return this.NAv;
  }
  
  public final kotlin.g.a.a<x> getEditCaptionListener()
  {
    return this.NAx;
  }
  
  public final kotlin.g.a.a<x> getEditContentListener()
  {
    return this.NAw;
  }
  
  public final kotlin.g.a.a<x> getEditTimeListener()
  {
    return this.NAu;
  }
  
  public final kotlin.g.a.a<x> getReadTextListener()
  {
    return this.NAy;
  }
  
  public final void gwn()
  {
    AppMethodBeat.i(251247);
    setBackground(getUpDrawable());
    AppMethodBeat.o(251247);
  }
  
  public final void gwo()
  {
    AppMethodBeat.i(251248);
    setBackground(getDownDrawable());
    AppMethodBeat.o(251248);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(251240);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditMenuView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = a.f.item_menu_delete;
      if (paramView != null) {
        break label119;
      }
      label59:
      i = a.f.item_menu_time;
      if (paramView != null) {
        break label146;
      }
      label67:
      i = a.f.item_menu_edit;
      if (paramView != null) {
        break label173;
      }
      label75:
      i = a.f.item_menu_caption;
      if (paramView != null) {
        break label200;
      }
      label83:
      i = a.f.item_menu_read;
      if (paramView != null) {
        break label227;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditMenuView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(251240);
      return;
      paramView = null;
      break;
      label119:
      if (paramView.intValue() != i) {
        break label59;
      }
      paramView = this.NAv;
      if (paramView != null)
      {
        paramView.invoke();
        continue;
        label146:
        if (paramView.intValue() != i) {
          break label67;
        }
        paramView = this.NAu;
        if (paramView != null)
        {
          paramView.invoke();
          continue;
          label173:
          if (paramView.intValue() != i) {
            break label75;
          }
          paramView = this.NAw;
          if (paramView != null)
          {
            paramView.invoke();
            continue;
            label200:
            if (paramView.intValue() != i) {
              break label83;
            }
            paramView = this.NAx;
            if (paramView != null)
            {
              paramView.invoke();
              continue;
              label227:
              if (paramView.intValue() == i)
              {
                paramView = this.NAy;
                if (paramView != null) {
                  paramView.invoke();
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void setDeleteListener(kotlin.g.a.a<x> parama)
  {
    this.NAv = parama;
  }
  
  public final void setEditCaptionListener(kotlin.g.a.a<x> parama)
  {
    this.NAx = parama;
  }
  
  public final void setEditContentListener(kotlin.g.a.a<x> parama)
  {
    this.NAw = parama;
  }
  
  public final void setEditTimeListener(kotlin.g.a.a<x> parama)
  {
    this.NAu = parama;
  }
  
  public final void setReadTextListener(kotlin.g.a.a<x> parama)
  {
    this.NAy = parama;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditMenuView$Companion;", "", "()V", "MENU_CAPTION", "", "MENU_DELETE", "MENU_EDIT", "MENU_READ", "MENU_TIME", "plugin-vlog_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Drawable>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<Drawable>
  {
    c(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.timeedit.b
 * JD-Core Version:    0.7.0.1
 */