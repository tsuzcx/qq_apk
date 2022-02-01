package com.tencent.mm.plugin.repairer.ui.demo;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.EmojiPanelInputComponent;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.repairer.ui.BaseRepairerUI;
import com.tencent.mm.plugin.repairer.ui.b.c;
import com.tencent.mm.plugin.repairer.ui.b.d;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.cedit.api.c;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerKeyboardEmojiInputDemoUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "inputEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "sayFooter", "Lcom/tencent/mm/emoji/view/EmojiPanelInputComponent;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerKeyboardEmojiInputDemoUI
  extends BaseRepairerUI
{
  private EmojiPanelInputComponent OwY;
  private MMEditText nir;
  
  private static final void a(RepairerKeyboardEmojiInputDemoUI paramRepairerKeyboardEmojiInputDemoUI, View paramView)
  {
    AppMethodBeat.i(278402);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerKeyboardEmojiInputDemoUI);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerKeyboardEmojiInputDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerKeyboardEmojiInputDemoUI, "this$0");
    paramView = paramRepairerKeyboardEmojiInputDemoUI.nir;
    if (paramView != null) {
      paramView.jEJ();
    }
    paramView = paramRepairerKeyboardEmojiInputDemoUI.OwY;
    if ((paramView != null) && (paramView.aWH() == true)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramView = paramRepairerKeyboardEmojiInputDemoUI.OwY;
        if (paramView != null) {
          paramView.aWI();
        }
      }
      if (!KeyBoardUtil.isPortOrientation((Context)paramRepairerKeyboardEmojiInputDemoUI))
      {
        paramView = paramRepairerKeyboardEmojiInputDemoUI.OwY;
        if (paramView != null) {
          paramView.aWF();
        }
      }
      paramRepairerKeyboardEmojiInputDemoUI.getContentView().postInvalidate();
      a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerKeyboardEmojiInputDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(278402);
      return;
    }
  }
  
  private static final boolean a(RepairerKeyboardEmojiInputDemoUI paramRepairerKeyboardEmojiInputDemoUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(278393);
    s.u(paramRepairerKeyboardEmojiInputDemoUI, "this$0");
    paramRepairerKeyboardEmojiInputDemoUI.finish();
    AppMethodBeat.o(278393);
    return true;
  }
  
  public final int getLayoutId()
  {
    return b.d.Ovv;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278426);
    super.onCreate(paramBundle);
    setMMTitle("表情输入Demo");
    setBackBtn(new RepairerKeyboardEmojiInputDemoUI..ExternalSyntheticLambda0(this));
    this.nir = ((MMEditText)findViewById(b.c.input_et));
    this.OwY = ((EmojiPanelInputComponent)findViewById(b.c.say_footer));
    paramBundle = this.OwY;
    if (paramBundle != null) {
      paramBundle.setMMEditText((c)this.nir);
    }
    paramBundle = this.OwY;
    if (paramBundle != null) {
      paramBundle.setVisibility(4);
    }
    paramBundle = this.nir;
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new RepairerKeyboardEmojiInputDemoUI..ExternalSyntheticLambda1(this));
    }
    AppMethodBeat.o(278426);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(278436);
    EmojiPanelInputComponent localEmojiPanelInputComponent = this.OwY;
    if (localEmojiPanelInputComponent != null) {
      localEmojiPanelInputComponent.release();
    }
    super.onDestroy();
    AppMethodBeat.o(278436);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(278443);
    s.u(paramKeyEvent, "event");
    if (paramKeyEvent.getKeyCode() == 4)
    {
      paramKeyEvent = this.OwY;
      if ((paramKeyEvent != null) && (paramKeyEvent.aWG() == true)) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        paramKeyEvent = this.OwY;
        if (paramKeyEvent != null) {
          paramKeyEvent.aWI();
        }
        AppMethodBeat.o(278443);
        return true;
      }
      finish();
      AppMethodBeat.o(278443);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(278443);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerKeyboardEmojiInputDemoUI
 * JD-Core Version:    0.7.0.1
 */