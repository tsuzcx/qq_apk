package com.tencent.mm.plugin.repairer.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.repairer.ui.b.c;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/repairer/ui/RepairerSendMsgUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ui-repairer_release"})
public final class RepairerSendMsgUI
  extends MMActivity
{
  private final String TAG = "MicroMsg.RepairerSendMsgUI";
  
  public final int getLayoutId()
  {
    return b.b.IwS;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(226713);
    super.onCreate(paramBundle);
    setMMTitle("发送微信消息");
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    findViewById(b.a.ok_btn).setOnClickListener((View.OnClickListener)new b(this));
    AppMethodBeat.o(226713);
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
    a(RepairerSendMsgUI paramRepairerSendMsgUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(226588);
      this.Ixe.finish();
      AppMethodBeat.o(226588);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(RepairerSendMsgUI paramRepairerSendMsgUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(227561);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      a.c("com/tencent/mm/plugin/repairer/ui/RepairerSendMsgUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = this.Ixe.findViewById(b.a.Iwg);
      p.j(paramView, "findViewById<EditText>(R.id.filepath_et)");
      paramView = ((EditText)paramView).getText().toString();
      localObject = c.Iyf;
      c.bG((Context)this.Ixe, paramView);
      a.a(this, "com/tencent/mm/plugin/repairer/ui/RepairerSendMsgUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(227561);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.RepairerSendMsgUI
 * JD-Core Version:    0.7.0.1
 */