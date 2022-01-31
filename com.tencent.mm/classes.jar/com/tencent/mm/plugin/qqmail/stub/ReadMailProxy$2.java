package com.tencent.mm.plugin.qqmail.stub;

import com.tencent.mm.pluginsdk.ui.tools.i.a;

final class ReadMailProxy$2
  implements i.a
{
  ReadMailProxy$2(ReadMailProxy paramReadMailProxy) {}
  
  public final void btK()
  {
    this.nfz.CLIENT_CALL("onGetQQMailUnreadFailed", new Object[0]);
  }
  
  public final void onSuccess(int paramInt)
  {
    this.nfz.CLIENT_CALL("onGetQQMailUnreadSuccess", new Object[] { Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.stub.ReadMailProxy.2
 * JD-Core Version:    0.7.0.1
 */