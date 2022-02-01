package com.tencent.mm.plugin.repairer.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ck;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/repairer/ui/RepairerNewXmlUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ui-repairer_release"})
public final class RepairerNewXmlUI
  extends MMActivity
{
  public final int getLayoutId()
  {
    return b.b.IwQ;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(227564);
    super.onCreate(paramBundle);
    setMMTitle("微信推送NewXML");
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    findViewById(b.a.ok_btn).setOnClickListener((View.OnClickListener)new b(this));
    AppMethodBeat.o(227564);
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
    a(RepairerNewXmlUI paramRepairerNewXmlUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(226980);
      this.Ixa.finish();
      AppMethodBeat.o(226980);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(RepairerNewXmlUI paramRepairerNewXmlUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(226625);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      a.c("com/tencent/mm/plugin/repairer/ui/RepairerNewXmlUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = new db();
      paramView.COi = 10002;
      localObject = this.Ixa.findViewById(b.a.IwD);
      p.j(localObject, "findViewById<MMEditText>(R.id.xml_et)");
      localObject = ((MMEditText)localObject).getText().toString();
      paramView.RIF = new eaf().btQ((String)localObject);
      paramView = new h.a(paramView, false, false, false);
      localObject = h.ag(v.class);
      p.j(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
      ((v)localObject).getSysCmdMsgExtension().b(paramView);
      a.a(this, "com/tencent/mm/plugin/repairer/ui/RepairerNewXmlUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(226625);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.RepairerNewXmlUI
 * JD-Core Version:    0.7.0.1
 */