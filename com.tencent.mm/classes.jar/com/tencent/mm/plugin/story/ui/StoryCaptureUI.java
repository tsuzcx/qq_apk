package com.tencent.mm.plugin.story.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.jn;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.ui.view.UserGuideView;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(3)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "guideView", "Lcom/tencent/mm/plugin/story/ui/view/UserGuideView;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-story_release"})
public final class StoryCaptureUI
  extends MMActivity
{
  public static final a FwU;
  private UserGuideView FwT;
  
  static
  {
    AppMethodBeat.i(119629);
    FwU = new a((byte)0);
    AppMethodBeat.o(119629);
  }
  
  public final int getLayoutId()
  {
    return 2131496571;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119628);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    d.rb(true);
    this.FwT = ((UserGuideView)findViewById(2131308488));
    paramBundle = this.FwT;
    if (paramBundle != null) {
      paramBundle.setClickListener((kotlin.g.a.a)new b(this));
    }
    paramBundle = h.FuH;
    h.fqm().sj(1L);
    paramBundle = h.FuH;
    h.fqn();
    AppMethodBeat.o(119628);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(StoryCaptureUI paramStoryCaptureUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryCaptureUI
 * JD-Core Version:    0.7.0.1
 */