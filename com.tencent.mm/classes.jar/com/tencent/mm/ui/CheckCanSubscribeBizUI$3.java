package com.tencent.mm.ui;

import com.tencent.mm.sdk.platformtools.y;

final class CheckCanSubscribeBizUI$3
  implements Runnable
{
  CheckCanSubscribeBizUI$3(CheckCanSubscribeBizUI paramCheckCanSubscribeBizUI, String paramString) {}
  
  public final void run()
  {
    y.d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange toUserName = " + CheckCanSubscribeBizUI.d(this.uHE) + ", userName = " + this.egy);
    if (CheckCanSubscribeBizUI.d(this.uHE).equals(this.egy))
    {
      CheckCanSubscribeBizUI.e(this.uHE);
      if (!CheckCanSubscribeBizUI.f(this.uHE)) {
        CheckCanSubscribeBizUI.b(this.uHE);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.CheckCanSubscribeBizUI.3
 * JD-Core Version:    0.7.0.1
 */