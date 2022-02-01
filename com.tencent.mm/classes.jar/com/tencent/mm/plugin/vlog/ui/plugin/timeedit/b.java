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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditMenuView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "captionMenu", "Landroid/view/ViewGroup;", "deleteListener", "Lkotlin/Function0;", "", "getDeleteListener", "()Lkotlin/jvm/functions/Function0;", "setDeleteListener", "(Lkotlin/jvm/functions/Function0;)V", "deleteMenu", "downDrawable", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "getDownDrawable", "()Landroid/graphics/drawable/Drawable;", "downDrawable$delegate", "Lkotlin/Lazy;", "editCaptionListener", "getEditCaptionListener", "setEditCaptionListener", "editContentListener", "getEditContentListener", "setEditContentListener", "editMenu", "editTimeListener", "getEditTimeListener", "setEditTimeListener", "enableReadMenu", "", "readMenu", "readTextListener", "getReadTextListener", "setReadTextListener", "timeMenu", "upDrawable", "getUpDrawable", "upDrawable$delegate", "doSetMenuChecked", "menu", "visibility", "", "downBackground", "loadMenuLayout", "layout", "iconRes", "titleRes", "onClick", "v", "Landroid/view/View;", "setMenuChecked", "checked", "showCaptionMenu", "showNormalMenu", "enableTimeEdit", "showTextMenu", "upwardsBackground", "Companion", "plugin-vlog_release"})
public final class b
  extends LinearLayout
  implements View.OnClickListener
{
  public static final b.a CjY;
  private d.g.a.a<z> CjL;
  private d.g.a.a<z> CjM;
  private d.g.a.a<z> CjN;
  private d.g.a.a<z> CjO;
  private d.g.a.a<z> CjP;
  ViewGroup CjQ;
  private ViewGroup CjR;
  ViewGroup CjS;
  ViewGroup CjT;
  ViewGroup CjU;
  final boolean CjV;
  private final f CjW;
  private final f CjX;
  
  static
  {
    AppMethodBeat.i(192165);
    CjY = new b.a((byte)0);
    AppMethodBeat.o(192165);
  }
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(192164);
    this.CjV = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qIo, false);
    this.CjW = d.g.O((d.g.a.a)new c(this));
    this.CjX = d.g.O((d.g.a.a)new b(this));
    LayoutInflater.from(paramContext).inflate(2131496494, (ViewGroup)this, true);
    paramContext = findViewById(2131308340);
    p.g(paramContext, "findViewById(R.id.item_menu_time)");
    this.CjQ = ((ViewGroup)paramContext);
    paramContext = findViewById(2131308337);
    p.g(paramContext, "findViewById(R.id.item_menu_delete)");
    this.CjR = ((ViewGroup)paramContext);
    paramContext = findViewById(2131308338);
    p.g(paramContext, "findViewById(R.id.item_menu_edit)");
    this.CjS = ((ViewGroup)paramContext);
    paramContext = findViewById(2131308336);
    p.g(paramContext, "findViewById(R.id.item_menu_caption)");
    this.CjT = ((ViewGroup)paramContext);
    paramContext = findViewById(2131308339);
    p.g(paramContext, "findViewById(R.id.item_menu_read)");
    this.CjU = ((ViewGroup)paramContext);
    if (!this.CjV) {
      this.CjU.setVisibility(8);
    }
    e(this.CjQ, 2131690487, 2131767231);
    e(this.CjR, 2131690384, 2131767228);
    e(this.CjS, 2131690457, 2131767229);
    e(this.CjT, 2131691600, 2131767227);
    e(this.CjU, 2131690485, 2131767230);
    AppMethodBeat.o(192164);
  }
  
  private final void e(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192160);
    Object localObject = paramViewGroup.findViewById(2131305902);
    p.g(localObject, "layout.findViewById<TextView>(R.id.title)");
    ((TextView)localObject).setText((CharSequence)com.tencent.mm.cb.a.az(getContext(), paramInt2));
    ((WeImageView)paramViewGroup.findViewById(2131300874)).setImageResource(paramInt1);
    localObject = (ImageView)paramViewGroup.findViewById(2131298214);
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(com.tencent.mm.cb.a.l(getContext(), 2131691551));
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(192160);
  }
  
  private final Drawable getDownDrawable()
  {
    AppMethodBeat.i(192158);
    Drawable localDrawable = (Drawable)this.CjX.getValue();
    AppMethodBeat.o(192158);
    return localDrawable;
  }
  
  private final Drawable getUpDrawable()
  {
    AppMethodBeat.i(192157);
    Drawable localDrawable = (Drawable)this.CjW.getValue();
    AppMethodBeat.o(192157);
    return localDrawable;
  }
  
  public final void exC()
  {
    AppMethodBeat.i(192162);
    setBackground(getUpDrawable());
    AppMethodBeat.o(192162);
  }
  
  public final void exD()
  {
    AppMethodBeat.i(192163);
    setBackground(getDownDrawable());
    AppMethodBeat.o(192163);
  }
  
  public final d.g.a.a<z> getDeleteListener()
  {
    return this.CjM;
  }
  
  public final d.g.a.a<z> getEditCaptionListener()
  {
    return this.CjO;
  }
  
  public final d.g.a.a<z> getEditContentListener()
  {
    return this.CjN;
  }
  
  public final d.g.a.a<z> getEditTimeListener()
  {
    return this.CjL;
  }
  
  public final d.g.a.a<z> getReadTextListener()
  {
    return this.CjP;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(192159);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditMenuView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
      AppMethodBeat.o(192159);
      return;
      paramView = null;
      break;
      label99:
      if (paramView.intValue() != 2131308337) {
        break label55;
      }
      paramView = this.CjM;
      if (paramView != null)
      {
        paramView.invoke();
        continue;
        label127:
        if (paramView.intValue() != 2131308340) {
          break label59;
        }
        paramView = this.CjL;
        if (paramView != null)
        {
          paramView.invoke();
          continue;
          label155:
          if (paramView.intValue() != 2131308338) {
            break label63;
          }
          paramView = this.CjN;
          if (paramView != null)
          {
            paramView.invoke();
            continue;
            label183:
            if (paramView.intValue() != 2131308336) {
              break label67;
            }
            paramView = this.CjO;
            if (paramView != null)
            {
              paramView.invoke();
              continue;
              label211:
              if (paramView.intValue() == 2131308339)
              {
                paramView = this.CjP;
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
    this.CjM = parama;
  }
  
  public final void setEditCaptionListener(d.g.a.a<z> parama)
  {
    this.CjO = parama;
  }
  
  public final void setEditContentListener(d.g.a.a<z> parama)
  {
    this.CjN = parama;
  }
  
  public final void setEditTimeListener(d.g.a.a<z> parama)
  {
    this.CjL = parama;
  }
  
  public final void setMenuChecked$2563266(boolean paramBoolean)
  {
    AppMethodBeat.i(192161);
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      View localView = this.CjU.findViewById(2131298214);
      if (localView == null) {
        break;
      }
      localView.setVisibility(i);
      AppMethodBeat.o(192161);
      return;
    }
    AppMethodBeat.o(192161);
  }
  
  public final void setReadTextListener(d.g.a.a<z> parama)
  {
    this.CjP = parama;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<Drawable>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.timeedit.b
 * JD-Core Version:    0.7.0.1
 */