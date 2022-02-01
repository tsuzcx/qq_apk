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
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.a.g;
import com.tencent.mm.plugin.vlog.a.h;
import com.tencent.mm.plugin.vlog.a.i;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditMenuView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "captionMenu", "Landroid/view/ViewGroup;", "deleteListener", "Lkotlin/Function0;", "", "getDeleteListener", "()Lkotlin/jvm/functions/Function0;", "setDeleteListener", "(Lkotlin/jvm/functions/Function0;)V", "deleteMenu", "downDrawable", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "getDownDrawable", "()Landroid/graphics/drawable/Drawable;", "downDrawable$delegate", "Lkotlin/Lazy;", "editCaptionListener", "getEditCaptionListener", "setEditCaptionListener", "editContentListener", "getEditContentListener", "setEditContentListener", "editMenu", "editTimeListener", "getEditTimeListener", "setEditTimeListener", "enableReadMenu", "", "readMenu", "readTextListener", "getReadTextListener", "setReadTextListener", "timeMenu", "upDrawable", "getUpDrawable", "upDrawable$delegate", "doSetMenuChecked", "menu", "visibility", "", "downBackground", "loadMenuLayout", "layout", "iconRes", "titleRes", "onClick", "v", "Landroid/view/View;", "setMenuChecked", "checked", "showCaptionMenu", "showNormalMenu", "enableTimeEdit", "showTextMenu", "upwardsBackground", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends LinearLayout
  implements View.OnClickListener
{
  public static final b.a Uni;
  private kotlin.g.a.a<ah> Unj;
  private kotlin.g.a.a<ah> Unk;
  private kotlin.g.a.a<ah> Unl;
  private kotlin.g.a.a<ah> Unm;
  private kotlin.g.a.a<ah> Unn;
  ViewGroup Uno;
  private ViewGroup Unp;
  ViewGroup Unq;
  ViewGroup Unr;
  ViewGroup Uns;
  final boolean Unt;
  private final j Unu;
  private final j Unv;
  
  static
  {
    AppMethodBeat.i(283135);
    Uni = new b.a((byte)0);
    AppMethodBeat.o(283135);
  }
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(283084);
    this.Unt = ((c)h.ax(c.class)).a(c.a.zci, false);
    this.Unu = k.cm((kotlin.g.a.a)new c(this));
    this.Unv = k.cm((kotlin.g.a.a)new b(this));
    LayoutInflater.from(paramContext).inflate(a.g.time_edit_menu_view, (ViewGroup)this, true);
    paramContext = findViewById(a.f.item_menu_time);
    s.s(paramContext, "findViewById(R.id.item_menu_time)");
    this.Uno = ((ViewGroup)paramContext);
    paramContext = findViewById(a.f.item_menu_delete);
    s.s(paramContext, "findViewById(R.id.item_menu_delete)");
    this.Unp = ((ViewGroup)paramContext);
    paramContext = findViewById(a.f.item_menu_edit);
    s.s(paramContext, "findViewById(R.id.item_menu_edit)");
    this.Unq = ((ViewGroup)paramContext);
    paramContext = findViewById(a.f.item_menu_caption);
    s.s(paramContext, "findViewById(R.id.item_menu_caption)");
    this.Unr = ((ViewGroup)paramContext);
    paramContext = findViewById(a.f.item_menu_read);
    s.s(paramContext, "findViewById(R.id.item_menu_read)");
    this.Uns = ((ViewGroup)paramContext);
    if (!this.Unt) {
      this.Uns.setVisibility(8);
    }
    f(this.Uno, a.h.icons_filled_time, a.i.video_track_edit_item_time);
    f(this.Unp, a.h.icons_filled_delete, a.i.video_track_edit_item_delete);
    f(this.Unq, a.h.icons_filled_pencil, a.i.video_track_edit_item_edit);
    f(this.Unr, a.h.icons_filled_caption, a.i.video_track_edit_item_caption);
    f(this.Uns, a.h.icons_filled_talk, a.i.video_track_edit_item_read);
    AppMethodBeat.o(283084);
  }
  
  private final void f(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(283122);
    ((TextView)paramViewGroup.findViewById(a.f.title)).setText((CharSequence)com.tencent.mm.cd.a.bt(getContext(), paramInt2));
    ((WeImageView)paramViewGroup.findViewById(a.f.icon)).setImageResource(paramInt1);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(a.f.check);
    if (localImageView != null) {
      localImageView.setImageDrawable(com.tencent.mm.cd.a.m(getContext(), a.h.popvideo_post_selected_origin));
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(283122);
  }
  
  private final Drawable getDownDrawable()
  {
    AppMethodBeat.i(283110);
    Drawable localDrawable = (Drawable)this.Unv.getValue();
    AppMethodBeat.o(283110);
    return localDrawable;
  }
  
  private final Drawable getUpDrawable()
  {
    AppMethodBeat.i(283097);
    Drawable localDrawable = (Drawable)this.Unu.getValue();
    AppMethodBeat.o(283097);
    return localDrawable;
  }
  
  public final void FZ(boolean paramBoolean)
  {
    AppMethodBeat.i(283243);
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      View localView = this.Uns.findViewById(a.f.check);
      if (localView != null) {
        localView.setVisibility(i);
      }
      AppMethodBeat.o(283243);
      return;
    }
  }
  
  public final kotlin.g.a.a<ah> getDeleteListener()
  {
    return this.Unk;
  }
  
  public final kotlin.g.a.a<ah> getEditCaptionListener()
  {
    return this.Unm;
  }
  
  public final kotlin.g.a.a<ah> getEditContentListener()
  {
    return this.Unl;
  }
  
  public final kotlin.g.a.a<ah> getEditTimeListener()
  {
    return this.Unj;
  }
  
  public final kotlin.g.a.a<ah> getReadTextListener()
  {
    return this.Unn;
  }
  
  public final void hUf()
  {
    AppMethodBeat.i(283251);
    setBackground(getUpDrawable());
    AppMethodBeat.o(283251);
  }
  
  public final void hUg()
  {
    AppMethodBeat.i(283260);
    setBackground(getDownDrawable());
    AppMethodBeat.o(283260);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(283236);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditMenuView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = a.f.item_menu_delete;
      if (paramView != null) {
        break label119;
      }
      label53:
      i = a.f.item_menu_time;
      if (paramView != null) {
        break label146;
      }
      label61:
      i = a.f.item_menu_edit;
      if (paramView != null) {
        break label173;
      }
      label69:
      i = a.f.item_menu_caption;
      if (paramView != null) {
        break label200;
      }
      label77:
      i = a.f.item_menu_read;
      if (paramView != null) {
        break label227;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditMenuView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(283236);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label119:
      if (paramView.intValue() != i) {
        break label53;
      }
      paramView = this.Unk;
      if (paramView != null)
      {
        paramView.invoke();
        continue;
        label146:
        if (paramView.intValue() != i) {
          break label61;
        }
        paramView = this.Unj;
        if (paramView != null)
        {
          paramView.invoke();
          continue;
          label173:
          if (paramView.intValue() != i) {
            break label69;
          }
          paramView = this.Unl;
          if (paramView != null)
          {
            paramView.invoke();
            continue;
            label200:
            if (paramView.intValue() != i) {
              break label77;
            }
            paramView = this.Unm;
            if (paramView != null)
            {
              paramView.invoke();
              continue;
              label227:
              if (paramView.intValue() == i)
              {
                paramView = this.Unn;
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
  
  public final void setDeleteListener(kotlin.g.a.a<ah> parama)
  {
    this.Unk = parama;
  }
  
  public final void setEditCaptionListener(kotlin.g.a.a<ah> parama)
  {
    this.Unm = parama;
  }
  
  public final void setEditContentListener(kotlin.g.a.a<ah> parama)
  {
    this.Unl = parama;
  }
  
  public final void setEditTimeListener(kotlin.g.a.a<ah> parama)
  {
    this.Unj = parama;
  }
  
  public final void setReadTextListener(kotlin.g.a.a<ah> parama)
  {
    this.Unn = parama;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Drawable>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Drawable>
  {
    c(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.timeedit.b
 * JD-Core Version:    0.7.0.1
 */