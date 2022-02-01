package com.tencent.mm.ui.chatting;

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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/BizChattingUIAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends MMBaseAccessibilityConfig
{
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(253871);
    AppMethodBeat.o(253871);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(253873);
    root(R.i.gfn).view(R.h.gaA).desc((b)new a(this)).disableChildren();
    root(R.i.gfm).view(R.h.content_ll).desc((b)new b(this)).disableChildren().type(ViewType.Button);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(R.i.gfo);
    localConfigHelper.view(R.h.fZd).descFormat(R.l.talkback_placehodler).valueByView(R.h.title).disableChildren().type(ViewType.Button);
    localConfigHelper.view(R.h.fZa).disable();
    root(R.i.gfp).view(R.h.chatting_video_cover_ll).descFormat(R.l.gXg).valueByView(R.h.time_tv).valueByView(R.h.title_tv).disableChildren().type(ViewType.Button);
    localConfigHelper = root(R.i.gfq);
    localConfigHelper.view(R.h.fyy).descFormat(R.l.gXe).valueByView(R.h.title).valueByView(R.h.time_tv).type(ViewType.Button);
    localConfigHelper.disable(R.h.title);
    localConfigHelper.disable(R.h.time_tv);
    localConfigHelper.view(R.h.play_layout).desc(R.l.gXf);
    AppMethodBeat.o(253873);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<View, String>
  {
    a(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<View, String>
  {
    b(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.e
 * JD-Core Version:    0.7.0.1
 */