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
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.f;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditMenuView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "captionMenu", "Landroid/view/ViewGroup;", "deleteListener", "Lkotlin/Function0;", "", "getDeleteListener", "()Lkotlin/jvm/functions/Function0;", "setDeleteListener", "(Lkotlin/jvm/functions/Function0;)V", "deleteMenu", "downDrawable", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "getDownDrawable", "()Landroid/graphics/drawable/Drawable;", "downDrawable$delegate", "Lkotlin/Lazy;", "editCaptionListener", "getEditCaptionListener", "setEditCaptionListener", "editContentListener", "getEditContentListener", "setEditContentListener", "editMenu", "editTimeListener", "getEditTimeListener", "setEditTimeListener", "enableReadMenu", "", "readMenu", "readTextListener", "getReadTextListener", "setReadTextListener", "timeMenu", "upDrawable", "getUpDrawable", "upDrawable$delegate", "doSetMenuChecked", "menu", "visibility", "", "downBackground", "loadMenuLayout", "layout", "iconRes", "titleRes", "onClick", "v", "Landroid/view/View;", "setMenuChecked", "checked", "showCaptionMenu", "showNormalMenu", "enableTimeEdit", "showTextMenu", "upwardsBackground", "Companion", "plugin-vlog_release"})
public final class b
  extends LinearLayout
  implements View.OnClickListener
{
  public static final b.a BSy;
  private d.g.a.a<z> BSl;
  private d.g.a.a<z> BSm;
  private d.g.a.a<z> BSn;
  private d.g.a.a<z> BSo;
  private d.g.a.a<z> BSp;
  ViewGroup BSq;
  private ViewGroup BSr;
  ViewGroup BSs;
  ViewGroup BSt;
  ViewGroup BSu;
  final boolean BSv;
  private final f BSw;
  private final f BSx;
  
  static
  {
    AppMethodBeat.i(196704);
    BSy = new b.a((byte)0);
    AppMethodBeat.o(196704);
  }
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(196703);
    this.BSv = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qBc, false);
    this.BSw = d.g.O((d.g.a.a)new c(this));
    this.BSx = d.g.O((d.g.a.a)new b(this));
    LayoutInflater.from(paramContext).inflate(2131496494, (ViewGroup)this, true);
    paramContext = findViewById(2131308340);
    p.g(paramContext, "findViewById(R.id.item_menu_time)");
    this.BSq = ((ViewGroup)paramContext);
    paramContext = findViewById(2131308337);
    p.g(paramContext, "findViewById(R.id.item_menu_delete)");
    this.BSr = ((ViewGroup)paramContext);
    paramContext = findViewById(2131308338);
    p.g(paramContext, "findViewById(R.id.item_menu_edit)");
    this.BSs = ((ViewGroup)paramContext);
    paramContext = findViewById(2131308336);
    p.g(paramContext, "findViewById(R.id.item_menu_caption)");
    this.BSt = ((ViewGroup)paramContext);
    paramContext = findViewById(2131308339);
    p.g(paramContext, "findViewById(R.id.item_menu_read)");
    this.BSu = ((ViewGroup)paramContext);
    if (!this.BSv) {
      this.BSu.setVisibility(8);
    }
    e(this.BSq, 2131690487, 2131767231);
    e(this.BSr, 2131690384, 2131767228);
    e(this.BSs, 2131690457, 2131767229);
    e(this.BSt, 2131691600, 2131767227);
    e(this.BSu, 2131690485, 2131767230);
    AppMethodBeat.o(196703);
  }
  
  private final void e(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196699);
    Object localObject = paramViewGroup.findViewById(2131305902);
    p.g(localObject, "layout.findViewById<TextView>(R.id.title)");
    ((TextView)localObject).setText((CharSequence)com.tencent.mm.cc.a.az(getContext(), paramInt2));
    ((WeImageView)paramViewGroup.findViewById(2131300874)).setImageResource(paramInt1);
    localObject = (ImageView)paramViewGroup.findViewById(2131298214);
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(com.tencent.mm.cc.a.l(getContext(), 2131691551));
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(196699);
  }
  
  private final Drawable getDownDrawable()
  {
    AppMethodBeat.i(196697);
    Drawable localDrawable = (Drawable)this.BSx.getValue();
    AppMethodBeat.o(196697);
    return localDrawable;
  }
  
  private final Drawable getUpDrawable()
  {
    AppMethodBeat.i(196696);
    Drawable localDrawable = (Drawable)this.BSw.getValue();
    AppMethodBeat.o(196696);
    return localDrawable;
  }
  
  public final void etV()
  {
    AppMethodBeat.i(196701);
    setBackground(getUpDrawable());
    AppMethodBeat.o(196701);
  }
  
  public final void etW()
  {
    AppMethodBeat.i(196702);
    setBackground(getDownDrawable());
    AppMethodBeat.o(196702);
  }
  
  public final d.g.a.a<z> getDeleteListener()
  {
    return this.BSm;
  }
  
  public final d.g.a.a<z> getEditCaptionListener()
  {
    return this.BSo;
  }
  
  public final d.g.a.a<z> getEditContentListener()
  {
    return this.BSn;
  }
  
  public final d.g.a.a<z> getEditTimeListener()
  {
    return this.BSl;
  }
  
  public final d.g.a.a<z> getReadTextListener()
  {
    return this.BSp;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(196698);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditMenuView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      if (paramView != null) {
        break label99;
      }
      label55:
      if (paramView != null) {
        break label127;
      }
      label59:
      if (paramView != null) {
        break label155;
      }
      label63:
      if (paramView != null) {
        break label183;
      }
      label67:
      if (paramView != null) {
        break label211;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditMenuView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(196698);
      return;
      paramView = null;
      break;
      label99:
      if (paramView.intValue() != 2131308337) {
        break label55;
      }
      paramView = this.BSm;
      if (paramView != null)
      {
        paramView.invoke();
        continue;
        label127:
        if (paramView.intValue() != 2131308340) {
          break label59;
        }
        paramView = this.BSl;
        if (paramView != null)
        {
          paramView.invoke();
          continue;
          label155:
          if (paramView.intValue() != 2131308338) {
            break label63;
          }
          paramView = this.BSn;
          if (paramView != null)
          {
            paramView.invoke();
            continue;
            label183:
            if (paramView.intValue() != 2131308336) {
              break label67;
            }
            paramView = this.BSo;
            if (paramView != null)
            {
              paramView.invoke();
              continue;
              label211:
              if (paramView.intValue() == 2131308339)
              {
                paramView = this.BSp;
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
  
  public final void setDeleteListener(d.g.a.a<z> parama)
  {
    this.BSm = parama;
  }
  
  public final void setEditCaptionListener(d.g.a.a<z> parama)
  {
    this.BSo = parama;
  }
  
  public final void setEditContentListener(d.g.a.a<z> parama)
  {
    this.BSn = parama;
  }
  
  public final void setEditTimeListener(d.g.a.a<z> parama)
  {
    this.BSl = parama;
  }
  
  public final void setMenuChecked$2563266(boolean paramBoolean)
  {
    AppMethodBeat.i(196700);
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      View localView = this.BSu.findViewById(2131298214);
      if (localView == null) {
        break;
      }
      localView.setVisibility(i);
      AppMethodBeat.o(196700);
      return;
    }
    AppMethodBeat.o(196700);
  }
  
  public final void setReadTextListener(d.g.a.a<z> parama)
  {
    this.BSp = parama;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<Drawable>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<Drawable>
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