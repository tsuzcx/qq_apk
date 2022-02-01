package com.tencent.mm.plugin.story.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.dk;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.ui.view.UserGuideView;
import com.tencent.mm.ui.MMActivity;
import d.y;

@com.tencent.mm.ui.base.a(3)
@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "guideView", "Lcom/tencent/mm/plugin/story/ui/view/UserGuideView;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-story_release"})
public final class StoryCaptureUI
  extends MMActivity
{
  public static final a ypI;
  private UserGuideView ypH;
  
  static
  {
    AppMethodBeat.i(119629);
    ypI = new a((byte)0);
    AppMethodBeat.o(119629);
  }
  
  public final int getLayoutId()
  {
    return 2131495666;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119628);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    d.ne(true);
    this.ypH = ((UserGuideView)findViewById(2131305283));
    paramBundle = this.ypH;
    if (paramBundle != null) {
      paramBundle.setClickListener((d.g.a.a)new b(this));
    }
    paramBundle = h.ynv;
    h.dJn().fX(1L);
    paramBundle = h.ynv;
    h.dJo();
    AppMethodBeat.o(119628);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
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