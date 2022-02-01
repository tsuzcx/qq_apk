package com.tencent.mm.plugin.repairer.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.storage.cc;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/RepairerMsgDebugUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerMsgDebugUI
  extends BaseRepairerUI
{
  private static final void a(cc paramcc, View paramView)
  {
    AppMethodBeat.i(278001);
    Object localObject1 = new Object();
    Object localObject2 = new b();
    ((b)localObject2).cH(paramcc);
    ((b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/RepairerMsgDebugUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((b)localObject2).aYj());
    paramView = kotlin.n.n.bJB("\n                MsgId: " + paramcc.field_msgId + "\n                MsgSvrId: " + paramcc.field_msgSvrId + "\n                MsgIsSender: " + paramcc.field_isSend + "\n                MsgTalker: " + paramcc.field_talker + "\n                MsgFlag: " + Integer.toBinaryString(paramcc.field_flag) + "\n                MsgType: " + Integer.toHexString(paramcc.getType()) + "\n                MsgSource: " + paramcc.jUr + "\n                MsgContent: " + paramcc.field_content + "\n            ");
    localObject1 = am.aixg;
    paramcc = String.format("msg_info_%s.txt", Arrays.copyOf(new Object[] { Long.valueOf(paramcc.field_msgId) }, 1));
    s.s(paramcc, "java.lang.String.format(format, *args)");
    localObject1 = (com.tencent.mm.plugin.repairer.a)h.az(com.tencent.mm.plugin.repairer.a.class);
    localObject2 = d.UTF_8;
    if (paramView == null)
    {
      paramcc = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(278001);
      throw paramcc;
    }
    paramView = paramView.getBytes((Charset)localObject2);
    s.s(paramView, "(this as java.lang.String).getBytes(charset)");
    ((com.tencent.mm.plugin.repairer.a)localObject1).saveRepairerFile(paramcc, paramView, true);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/RepairerMsgDebugUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278001);
  }
  
  private static final boolean a(RepairerMsgDebugUI paramRepairerMsgDebugUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(277990);
    s.u(paramRepairerMsgDebugUI, "this$0");
    paramRepairerMsgDebugUI.finish();
    AppMethodBeat.o(277990);
    return true;
  }
  
  private static final void eV(View paramView)
  {
    AppMethodBeat.i(278011);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/RepairerMsgDebugUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/RepairerMsgDebugUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278011);
  }
  
  public final int getLayoutId()
  {
    return b.d.OvW;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278034);
    super.onCreate(paramBundle);
    setMMTitle("消息调试页面");
    setBackBtn(new RepairerMsgDebugUI..ExternalSyntheticLambda0(this));
    long l = getIntent().getLongExtra("Chat_Msg_Id", 0L);
    paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(l);
    View localView = findViewById(b.c.OtF);
    if (localView != null) {
      localView.setOnClickListener(new RepairerMsgDebugUI..ExternalSyntheticLambda1(paramBundle));
    }
    paramBundle = findViewById(b.c.OuY);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(RepairerMsgDebugUI..ExternalSyntheticLambda2.INSTANCE);
    }
    AppMethodBeat.o(278034);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.RepairerMsgDebugUI
 * JD-Core Version:    0.7.0.1
 */