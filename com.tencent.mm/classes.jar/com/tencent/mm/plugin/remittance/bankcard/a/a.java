package com.tencent.mm.plugin.remittance.bankcard.a;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/remittance/bankcard/accessibility/BankRemitDetailUIAccessibilityConfig;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends MMBaseAccessibilityConfig
{
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(288714);
    AppMethodBeat.o(288714);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(288725);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.g.bank_remit_detail_ui);
    localConfigHelper.view(a.f.brdu_state_title_1_layout).disableChildren().desc((b)a.ObV);
    localConfigHelper.view(a.f.brdu_state_title_2_layout).disableChildren().desc((b)b.ObW);
    localConfigHelper.view(a.f.brdu_state_title_3_layout).disableChildren().desc((b)c.ObX);
    root(a.g.bank_remit_detail_item_comm_layout).view(a.f.bank_remit_detail_item_layout).disableChildren().desc((b)d.ObY);
    root(a.g.bank_remit_detail_item_money_layout).view(a.f.bank_remit_detail_item_layout).disableChildren().desc((b)e.ObZ);
    AppMethodBeat.o(288725);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<View, String>
  {
    public static final a ObV;
    
    static
    {
      AppMethodBeat.i(288708);
      ObV = new a();
      AppMethodBeat.o(288708);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<View, String>
  {
    public static final b ObW;
    
    static
    {
      AppMethodBeat.i(288709);
      ObW = new b();
      AppMethodBeat.o(288709);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<View, String>
  {
    public static final c ObX;
    
    static
    {
      AppMethodBeat.i(288713);
      ObX = new c();
      AppMethodBeat.o(288713);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<View, String>
  {
    public static final d ObY;
    
    static
    {
      AppMethodBeat.i(288718);
      ObY = new d();
      AppMethodBeat.o(288718);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements b<View, String>
  {
    public static final e ObZ;
    
    static
    {
      AppMethodBeat.i(288723);
      ObZ = new e();
      AppMethodBeat.o(288723);
    }
    
    e()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.a.a
 * JD-Core Version:    0.7.0.1
 */