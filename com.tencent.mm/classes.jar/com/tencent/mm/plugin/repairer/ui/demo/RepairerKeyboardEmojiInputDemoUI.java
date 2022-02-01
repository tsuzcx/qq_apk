package com.tencent.mm.plugin.repairer.ui.demo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.EmojiPanelInputComponent;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.repairer.ui.b.a;
import com.tencent.mm.plugin.repairer.ui.b.b;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.cedit.api.c;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerKeyboardEmojiInputDemoUI;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "()V", "inputEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "sayFooter", "Lcom/tencent/mm/emoji/view/EmojiPanelInputComponent;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "ui-repairer_release"})
public final class RepairerKeyboardEmojiInputDemoUI
  extends MMSecDataActivity
{
  private EmojiPanelInputComponent IxH;
  private MMEditText kFl;
  
  public final int getLayoutId()
  {
    return b.b.IwJ;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(226913);
    super.onCreate(paramBundle);
    setMMTitle("表情输入Demo");
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    this.kFl = ((MMEditText)findViewById(b.a.input_et));
    this.IxH = ((EmojiPanelInputComponent)findViewById(b.a.say_footer));
    paramBundle = this.IxH;
    if (paramBundle != null) {
      paramBundle.setMMEditText((c)this.kFl);
    }
    paramBundle = this.IxH;
    if (paramBundle != null) {
      paramBundle.setVisibility(4);
    }
    paramBundle = this.kFl;
    if (paramBundle != null)
    {
      paramBundle.setOnClickListener((View.OnClickListener)new b(this));
      AppMethodBeat.o(226913);
      return;
    }
    AppMethodBeat.o(226913);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(226918);
    EmojiPanelInputComponent localEmojiPanelInputComponent = this.IxH;
    if (localEmojiPanelInputComponent != null) {
      localEmojiPanelInputComponent.release();
    }
    super.onDestroy();
    AppMethodBeat.o(226918);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(226925);
    p.k(paramKeyEvent, "event");
    if (paramKeyEvent.getKeyCode() == 4)
    {
      paramKeyEvent = this.IxH;
      if ((paramKeyEvent != null) && (paramKeyEvent.aDI() == true))
      {
        paramKeyEvent = this.IxH;
        if (paramKeyEvent != null) {
          paramKeyEvent.aDK();
        }
        AppMethodBeat.o(226925);
        return true;
      }
      finish();
      AppMethodBeat.o(226925);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(226925);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(RepairerKeyboardEmojiInputDemoUI paramRepairerKeyboardEmojiInputDemoUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(226585);
      this.IxI.finish();
      AppMethodBeat.o(226585);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(RepairerKeyboardEmojiInputDemoUI paramRepairerKeyboardEmojiInputDemoUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(227256);
      b localb = new b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerKeyboardEmojiInputDemoUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = RepairerKeyboardEmojiInputDemoUI.a(this.IxI);
      if (paramView != null) {
        paramView.hZB();
      }
      paramView = RepairerKeyboardEmojiInputDemoUI.b(this.IxI);
      if ((paramView != null) && (paramView.aDJ() == true))
      {
        paramView = RepairerKeyboardEmojiInputDemoUI.b(this.IxI);
        if (paramView != null) {
          paramView.aDK();
        }
      }
      if (!KeyBoardUtil.isPortOrientation((Context)this.IxI))
      {
        paramView = RepairerKeyboardEmojiInputDemoUI.b(this.IxI);
        if (paramView != null) {
          paramView.aDG();
        }
      }
      RepairerKeyboardEmojiInputDemoUI.c(this.IxI).postInvalidate();
      a.a(this, "com/tencent/mm/plugin/repairer/ui/demo/RepairerKeyboardEmojiInputDemoUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(227256);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerKeyboardEmojiInputDemoUI
 * JD-Core Version:    0.7.0.1
 */