package com.tencent.mm.ui.a;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/accessibility/LauncherUIAccessibilityConfig;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends MMBaseAccessibilityConfig
{
  public static final g.a adLu;
  
  static
  {
    AppMethodBeat.i(250106);
    adLu = new g.a((byte)0);
    AppMethodBeat.o(250106);
  }
  
  public g(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(250101);
    AppMethodBeat.o(250101);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(250113);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(R.i.more_tab_personal_info);
    localConfigHelper.view(R.h.head_root).desc(R.l.more_tab_person);
    localConfigHelper.view(R.h.avatar_iv).disable();
    root(R.i.giG).view(R.h.fDC).desc((b)new c(this));
    root(R.h.fMt).view(R.h.fYC).checkOn((b)d.adLw, (b)e.adLx);
    root(R.h.main_ui_container).view(R.h.fzl).disable();
    root(R.h.action_bar_container).view(R.h.actionbar_up_indicator_btn).desc(R.l.multi_task_title);
    root(R.i.ghq).view(R.h.fxs).descFormat(R.l.chatroom_notify).valueByView(R.h.fqt);
    root(R.i.ghp).view(R.h.fvJ).descFormat(R.l.add_contact_notify).valueByView(R.h.fqt);
    root(R.i.live_talkroom_tipsbar).view(R.h.live_tipsbar_list_unfold_btn).type(ViewType.Button).desc(R.l.fold_btn);
    localConfigHelper = root(R.i.live_talkroom_tipsbar_item);
    localConfigHelper.view(R.h.live_tipsbar_click_area).descFormat(R.l.live_tipsbar).valueByView(R.h.live_tipsbar_livename).valueByView(R.h.live_tipsbar_anchor);
    localConfigHelper.view(R.h.live_tipsbar_close_btn).type(ViewType.Button).desc(R.l.close_btn);
    root(R.i.fYM).view(R.h.btn_cancel).type(ViewType.Button).desc(R.l.fold_btn);
    localConfigHelper = root(R.i.ghw);
    localConfigHelper.view(R.h.fVC).descFormat(R.l.security_notify).valueByView(R.h.fzY);
    localConfigHelper.view(R.h.fzX).type(ViewType.Button).desc(R.l.gzx);
    localConfigHelper.view(R.h.fzW).type(ViewType.Button).desc(R.l.close_btn);
    root(R.i.ggR).view(R.h.fTY).descFormat(R.l.msg_quote_ll).valueByView(R.h.fwZ).valueByKey("quote_img");
    root(R.i.gfR).view(R.h.fTY).descFormat(R.l.msg_quote_ll).valueByView(R.h.fwZ).valueByKey("quote_img");
    localConfigHelper = root(R.i.ggn);
    localConfigHelper.view(R.h.chatting_click_area).desc(R.h.fZY);
    localConfigHelper.view(R.h.fMO).desc(R.l.avatar_desc);
    root(R.i.actionbar_custom_area_center).view(R.h.title_area_ll).disableChildren().desc((b)new b(this));
    AppMethodBeat.o(250113);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<View, String>
  {
    b(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<View, String>
  {
    c(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<View, Boolean>
  {
    public static final d adLw;
    
    static
    {
      AppMethodBeat.i(250118);
      adLw = new d();
      AppMethodBeat.o(250118);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements b<View, Boolean>
  {
    public static final e adLx;
    
    static
    {
      AppMethodBeat.i(250120);
      adLx = new e();
      AppMethodBeat.o(250120);
    }
    
    e()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.a.g
 * JD-Core Version:    0.7.0.1
 */