package com.tencent.sqlitelint.behaviour.alert;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

class IssueAlertBehaviour$1
  implements Runnable
{
  private byte _hellAccFlag_;
  
  IssueAlertBehaviour$1(IssueAlertBehaviour paramIssueAlertBehaviour) {}
  
  public void run()
  {
    AppMethodBeat.i(52901);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(IssueAlertBehaviour.access$000(this.this$0), CheckResultActivity.class);
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).putExtra("db_label", IssueAlertBehaviour.access$100(this.this$0));
    Context localContext = IssueAlertBehaviour.access$000(this.this$0);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/sqlitelint/behaviour/alert/IssueAlertBehaviour$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/sqlitelint/behaviour/alert/IssueAlertBehaviour$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(52901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.sqlitelint.behaviour.alert.IssueAlertBehaviour.1
 * JD-Core Version:    0.7.0.1
 */