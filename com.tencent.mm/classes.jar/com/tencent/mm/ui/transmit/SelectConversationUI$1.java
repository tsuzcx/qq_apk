package com.tencent.mm.ui.transmit;

import com.tencent.mm.plugin.base.stub.d.a;
import com.tencent.mm.sdk.platformtools.y;

final class SelectConversationUI$1
  implements d.a
{
  SelectConversationUI$1(SelectConversationUI paramSelectConversationUI) {}
  
  public final void em(boolean paramBoolean)
  {
    boolean bool = this.whw.isFinishing();
    y.i("MicroMsg.SelectConversationUI", "onCheckEnd, isPass = " + paramBoolean + ", isFinishing = " + bool);
    if ((!paramBoolean) && (!bool)) {
      this.whw.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.1
 * JD-Core Version:    0.7.0.1
 */