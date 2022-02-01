package com.tencent.mm.plugin.profile.ui;

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
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/BizContactInfoUIAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "setConfigForBizProfile", "setConfigForContactProfile", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends MMBaseAccessibilityConfig
{
  public static final a.a MUY;
  
  static
  {
    AppMethodBeat.i(305637);
    MUY = new a.a((byte)0);
    AppMethodBeat.o(305637);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(305632);
    AppMethodBeat.o(305632);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(305645);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(R.h.ftJ);
    localConfigHelper.view(R.h.ftF).desc(R.l.gBV).clickAs(R.h.ftE).disableChildren().type(ViewType.Button);
    localConfigHelper.view(R.h.ftH).desc(R.l.gSz).clickAs(R.h.ftG).disableChildren().type(ViewType.Button);
    localConfigHelper.view(R.h.ftD).desc(R.l.gSg).type(ViewType.Button).clickAs(R.h.ftC).disableChildren();
    localConfigHelper.view(R.h.fLN).clickAs(R.h.fLM).disable();
    localConfigHelper = root(R.i.ghW);
    localConfigHelper.view(R.h.fuG).descFormat(R.l.biz_timeline_profile_avatar).valueByKey("biz_timeline_profile_author_title").type(ViewType.Button);
    localConfigHelper.view(R.h.fuH).type(ViewType.Button);
    localConfigHelper.view(R.h.ftO).desc(R.h.ftN).type(ViewType.Button);
    localConfigHelper.view(R.h.fuK).desc(R.l.biz_timeline_placeholder).valueByKey("biz_timeline_profile_author_title_with_state");
    root(R.h.ftR).view(R.h.fuI).descFormat(R.l.biz_timeline_living).valueByKey("biz_timeline_profile_author_title");
    root(R.h.fuc).view(R.h.fuc).type(ViewType.Button);
    localConfigHelper = root(R.i.gia);
    localConfigHelper.view(R.h.fuc).type(ViewType.Button).descFormat(R.l.biz_timeline_placeholder).valueByKey("biz_timeline_profile_menu_selected_msg");
    localConfigHelper.view(R.h.fuj).type(ViewType.Button).descFormat(R.l.biz_timeline_placeholder).valueByKey("biz_timeline_profile_menu_selected_video");
    root(R.i.ghZ).view(R.h.fBW).descFormat(R.l.biz_timeline_video).valueByView(R.h.ftU).valueByView(R.h.ftT).valueByView(R.h.ftX).disableChildren();
    root(R.i.ghV).view(R.h.fux).descFormat(R.l.talkback_placehodler_8).valueByView(R.h.fuA).valueByView(R.h.content_tv).valueByView(R.h.fus).valueByView(R.h.fuw).valueByView(R.h.fuD).valueByView(R.h.fur).valueByView(R.h.fuu).valueByView(R.h.fut).type(ViewType.Button);
    localConfigHelper = root(R.i.fBP);
    Iterator localIterator = ((Iterable)p.listOf(new Integer[] { Integer.valueOf(R.h.fuD), Integer.valueOf(R.h.fuA), Integer.valueOf(R.h.content_tv), Integer.valueOf(R.h.fuv), Integer.valueOf(R.h.fus), Integer.valueOf(R.h.fuw), Integer.valueOf(R.h.fuD), Integer.valueOf(R.h.fur), Integer.valueOf(R.h.fuu), Integer.valueOf(R.h.fut) })).iterator();
    while (localIterator.hasNext()) {
      localConfigHelper.disable(((Number)localIterator.next()).intValue());
    }
    localConfigHelper = root(R.i.fBR);
    localIterator = ((Iterable)p.listOf(new Integer[] { Integer.valueOf(R.h.fuD), Integer.valueOf(R.h.fuA), Integer.valueOf(R.h.fuv), Integer.valueOf(R.h.fus), Integer.valueOf(R.h.fuw), Integer.valueOf(R.h.fuD), Integer.valueOf(R.h.fur), Integer.valueOf(R.h.fuu), Integer.valueOf(R.h.fut) })).iterator();
    while (localIterator.hasNext()) {
      localConfigHelper.disable(((Number)localIterator.next()).intValue());
    }
    localConfigHelper.view(R.h.fuv).disableChildren();
    localConfigHelper = root(R.i.fBQ);
    localIterator = ((Iterable)p.listOf(new Integer[] { Integer.valueOf(R.h.fuD), Integer.valueOf(R.h.fuA), Integer.valueOf(R.h.fuv), Integer.valueOf(R.h.fus), Integer.valueOf(R.h.fuw), Integer.valueOf(R.h.fuD), Integer.valueOf(R.h.fur), Integer.valueOf(R.h.fuu), Integer.valueOf(R.h.fut) })).iterator();
    while (localIterator.hasNext()) {
      localConfigHelper.disable(((Number)localIterator.next()).intValue());
    }
    localConfigHelper = root(R.i.ghT);
    localIterator = ((Iterable)p.listOf(new Integer[] { Integer.valueOf(R.h.fuD), Integer.valueOf(R.h.fuA), Integer.valueOf(R.h.fuv), Integer.valueOf(R.h.fus), Integer.valueOf(R.h.fuw), Integer.valueOf(R.h.fuD), Integer.valueOf(R.h.fur), Integer.valueOf(R.h.fuu), Integer.valueOf(R.h.fut) })).iterator();
    while (localIterator.hasNext()) {
      localConfigHelper.disable(((Number)localIterator.next()).intValue());
    }
    localConfigHelper = root(R.i.fBS);
    localIterator = ((Iterable)p.listOf(new Integer[] { Integer.valueOf(R.h.fuD), Integer.valueOf(R.h.fuA), Integer.valueOf(R.h.fuv), Integer.valueOf(R.h.fus), Integer.valueOf(R.h.fuw), Integer.valueOf(R.h.fuD), Integer.valueOf(R.h.fur), Integer.valueOf(R.h.fuu), Integer.valueOf(R.h.fut) })).iterator();
    while (localIterator.hasNext()) {
      localConfigHelper.disable(((Number)localIterator.next()).intValue());
    }
    localConfigHelper = root(R.i.fBO);
    localConfigHelper.view(R.h.fuC).desc(R.l.biz_timeline_radio_play_icon);
    localIterator = ((Iterable)p.listOf(new Integer[] { Integer.valueOf(R.h.fuD), Integer.valueOf(R.h.fuA), Integer.valueOf(R.h.fuv), Integer.valueOf(R.h.fus), Integer.valueOf(R.h.fuw), Integer.valueOf(R.h.fuD), Integer.valueOf(R.h.fur), Integer.valueOf(R.h.fuu), Integer.valueOf(R.h.fut) })).iterator();
    while (localIterator.hasNext()) {
      localConfigHelper.disable(((Number)localIterator.next()).intValue());
    }
    localConfigHelper = root(R.i.gig);
    localConfigHelper.view(R.h.fCp).disable();
    localConfigHelper.view(R.h.fug).desc(R.h.fug);
    int i = R.h.action_option_icon;
    view(i, i).type(ViewType.Button).desc((b)new b(this));
    localConfigHelper = root(R.i.gnb);
    localConfigHelper.view(R.h.fCk).type(ViewType.TextView).descFormat(R.l.talkback_placehodler).valueByView(R.h.fCk);
    localConfigHelper.view(R.h.fCj).type(ViewType.TextView).descFormat(R.l.talkback_placehodler).valueByView(R.h.fCj);
    localConfigHelper = root(R.h.accept_setting_layout);
    localConfigHelper.view(R.h.remark_name).type(ViewType.Button);
    localConfigHelper.view(R.h.mod_sns_permission).type(ViewType.Button);
    localConfigHelper = root(R.i.contact_profile_header_normal);
    localConfigHelper.view(R.h.contact_profile_sex_iv).type(ViewType.TextView).descFormat(R.l.talkback_placehodler).valueByKey("contact_profile_sex_icon");
    localConfigHelper.view(R.h.contact_profile_nickname_tv).type(ViewType.TextView).descFormat(R.l.talkback_placehodler).valueByView(R.h.contact_profile_nickname_tv);
    localConfigHelper.view(R.h.contact_profile_chatroom_nickname_tv).type(ViewType.TextView).descFormat(R.l.talkback_placehodler).valueByView(R.h.contact_profile_chatroom_nickname_tv);
    localConfigHelper.view(R.h.contact_profile_signature).type(ViewType.TextView).descFormat(R.l.talkback_placehodler).valueByView(R.h.contact_profile_signature);
    localConfigHelper.view(R.h.contact_profile_distance).type(ViewType.TextView).descFormat(R.l.talkback_placehodler).valueByView(R.h.contact_profile_distance);
    localConfigHelper.view(R.h.contact_profile_location).type(ViewType.TextView).descFormat(R.l.talkback_placehodler).valueByView(R.h.contact_profile_location);
    localConfigHelper.view(R.h.contact_profile_tip).type(ViewType.TextView).descFormat(R.l.talkback_placehodler).valueByView(R.h.contact_profile_tip);
    root(R.i.glN).view(16908310).type(ViewType.TextView).descFormat(R.l.talkback_placehodler).valueByView(16908310);
    root(R.i.glN).view(R.h.album_title).type(ViewType.TextView).descFormat(R.l.talkback_placehodler).valueByView(R.h.album_title);
    root(R.i.glP).view(R.h.fHZ).type(ViewType.Button).descFormat(R.l.talkback_placehodler_2).valueByView(R.h.title).valueByView(R.h.album_title).disableChildren();
    root(R.i.mm_preference).view(R.h.root_content).type(ViewType.Button).descFormat(R.l.talkback_placehodler_2).valueByView(16908310).valueByView(16908304).checkOn((b)a.c.MVa, (b)a.d.MVb).disableChildren();
    AppMethodBeat.o(305645);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<View, String>
  {
    b(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.a
 * JD-Core Version:    0.7.0.1
 */