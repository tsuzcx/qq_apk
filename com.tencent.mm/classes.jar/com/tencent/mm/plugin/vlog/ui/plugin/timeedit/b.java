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
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditMenuView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "captionMenu", "Landroid/view/ViewGroup;", "deleteListener", "Lkotlin/Function0;", "", "getDeleteListener", "()Lkotlin/jvm/functions/Function0;", "setDeleteListener", "(Lkotlin/jvm/functions/Function0;)V", "deleteMenu", "downDrawable", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "getDownDrawable", "()Landroid/graphics/drawable/Drawable;", "downDrawable$delegate", "Lkotlin/Lazy;", "editCaptionListener", "getEditCaptionListener", "setEditCaptionListener", "editContentListener", "getEditContentListener", "setEditContentListener", "editMenu", "editTimeListener", "getEditTimeListener", "setEditTimeListener", "enableReadMenu", "", "readMenu", "readTextListener", "getReadTextListener", "setReadTextListener", "timeMenu", "upDrawable", "getUpDrawable", "upDrawable$delegate", "doSetMenuChecked", "menu", "visibility", "", "downBackground", "loadMenuLayout", "layout", "iconRes", "titleRes", "onClick", "v", "Landroid/view/View;", "setMenuChecked", "checked", "showCaptionMenu", "showNormalMenu", "enableTimeEdit", "showTextMenu", "upwardsBackground", "Companion", "plugin-vlog_release"})
public final class b
  extends LinearLayout
  implements View.OnClickListener
{
  public static final a GNa;
  private kotlin.g.a.a<x> GMM;
  private kotlin.g.a.a<x> GMN;
  private kotlin.g.a.a<x> GMO;
  private kotlin.g.a.a<x> GMP;
  private kotlin.g.a.a<x> GMQ;
  ViewGroup GMR;
  private ViewGroup GMS;
  ViewGroup GMU;
  ViewGroup GMV;
  ViewGroup GMW;
  final boolean GMX;
  private final f GMY;
  private final f GMZ;
  
  static
  {
    AppMethodBeat.i(191901);
    GNa = new a((byte)0);
    AppMethodBeat.o(191901);
  }
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(191900);
    this.GMX = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.scO, false);
    this.GMY = kotlin.g.ah((kotlin.g.a.a)new c(this));
    this.GMZ = kotlin.g.ah((kotlin.g.a.a)new b(this));
    LayoutInflater.from(paramContext).inflate(2131496708, (ViewGroup)this, true);
    paramContext = findViewById(2131302840);
    p.g(paramContext, "findViewById(R.id.item_menu_time)");
    this.GMR = ((ViewGroup)paramContext);
    paramContext = findViewById(2131302837);
    p.g(paramContext, "findViewById(R.id.item_menu_delete)");
    this.GMS = ((ViewGroup)paramContext);
    paramContext = findViewById(2131302838);
    p.g(paramContext, "findViewById(R.id.item_menu_edit)");
    this.GMU = ((ViewGroup)paramContext);
    paramContext = findViewById(2131302836);
    p.g(paramContext, "findViewById(R.id.item_menu_caption)");
    this.GMV = ((ViewGroup)paramContext);
    paramContext = findViewById(2131302839);
    p.g(paramContext, "findViewById(R.id.item_menu_read)");
    this.GMW = ((ViewGroup)paramContext);
    if (!this.GMX) {
      this.GMW.setVisibility(8);
    }
    e(this.GMR, 2131690692, 2131767130);
    e(this.GMS, 2131690529, 2131767127);
    e(this.GMU, 2131690644, 2131767128);
    e(this.GMV, 2131690503, 2131767126);
    e(this.GMW, 2131690689, 2131767129);
    AppMethodBeat.o(191900);
  }
  
  private final void e(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191896);
    Object localObject = paramViewGroup.findViewById(2131309195);
    p.g(localObject, "layout.findViewById<TextView>(R.id.title)");
    ((TextView)localObject).setText((CharSequence)com.tencent.mm.cb.a.aI(getContext(), paramInt2));
    ((WeImageView)paramViewGroup.findViewById(2131302468)).setImageResource(paramInt1);
    localObject = (ImageView)paramViewGroup.findViewById(2131298596);
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(com.tencent.mm.cb.a.l(getContext(), 2131691337));
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(191896);
  }
  
  private final Drawable getDownDrawable()
  {
    AppMethodBeat.i(191894);
    Drawable localDrawable = (Drawable)this.GMZ.getValue();
    AppMethodBeat.o(191894);
    return localDrawable;
  }
  
  private final Drawable getUpDrawable()
  {
    AppMethodBeat.i(191893);
    Drawable localDrawable = (Drawable)this.GMY.getValue();
    AppMethodBeat.o(191893);
    return localDrawable;
  }
  
  public final void fEo()
  {
    AppMethodBeat.i(191898);
    setBackground(getUpDrawable());
    AppMethodBeat.o(191898);
  }
  
  public final void fEp()
  {
    AppMethodBeat.i(191899);
    setBackground(getDownDrawable());
    AppMethodBeat.o(191899);
  }
  
  public final kotlin.g.a.a<x> getDeleteListener()
  {
    return this.GMN;
  }
  
  public final kotlin.g.a.a<x> getEditCaptionListener()
  {
    return this.GMP;
  }
  
  public final kotlin.g.a.a<x> getEditContentListener()
  {
    return this.GMO;
  }
  
  public final kotlin.g.a.a<x> getEditTimeListener()
  {
    return this.GMM;
  }
  
  public final kotlin.g.a.a<x> getReadTextListener()
  {
    return this.GMQ;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(191895);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditMenuView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
      AppMethodBeat.o(191895);
      return;
      paramView = null;
      break;
      label99:
      if (paramView.intValue() != 2131302837) {
        break label55;
      }
      paramView = this.GMN;
      if (paramView != null)
      {
        paramView.invoke();
        continue;
        label127:
        if (paramView.intValue() != 2131302840) {
          break label59;
        }
        paramView = this.GMM;
        if (paramView != null)
        {
          paramView.invoke();
          continue;
          label155:
          if (paramView.intValue() != 2131302838) {
            break label63;
          }
          paramView = this.GMO;
          if (paramView != null)
          {
            paramView.invoke();
            continue;
            label183:
            if (paramView.intValue() != 2131302836) {
              break label67;
            }
            paramView = this.GMP;
            if (paramView != null)
            {
              paramView.invoke();
              continue;
              label211:
              if (paramView.intValue() == 2131302839)
              {
                paramView = this.GMQ;
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
    this.GMN = parama;
  }
  
  public final void setEditCaptionListener(kotlin.g.a.a<x> parama)
  {
    this.GMP = parama;
  }
  
  public final void setEditContentListener(kotlin.g.a.a<x> parama)
  {
    this.GMO = parama;
  }
  
  public final void setEditTimeListener(kotlin.g.a.a<x> parama)
  {
    this.GMM = parama;
  }
  
  public final void setMenuChecked$2563266(boolean paramBoolean)
  {
    AppMethodBeat.i(191897);
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      View localView = this.GMW.findViewById(2131298596);
      if (localView == null) {
        break;
      }
      localView.setVisibility(i);
      AppMethodBeat.o(191897);
      return;
    }
    AppMethodBeat.o(191897);
  }
  
  public final void setReadTextListener(kotlin.g.a.a<x> parama)
  {
    this.GMQ = parama;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditMenuView$Companion;", "", "()V", "MENU_CAPTION", "", "MENU_DELETE", "MENU_EDIT", "MENU_READ", "MENU_TIME", "plugin-vlog_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Drawable>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.timeedit.b
 * JD-Core Version:    0.7.0.1
 */