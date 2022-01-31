package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.d;

final class SnsOnlineVideoActivity$13
  implements View.OnLongClickListener
{
  SnsOnlineVideoActivity$13(SnsOnlineVideoActivity paramSnsOnlineVideoActivity) {}
  
  public final boolean onLongClick(View paramView)
  {
    SnsOnlineVideoActivity.a(this.pbr, new d(this.pbr.mController.uMN, 1, false));
    SnsOnlineVideoActivity.o(this.pbr).phH = this.pbr.pbq;
    SnsOnlineVideoActivity.o(this.pbr).phI = this.pbr.ifj;
    SnsOnlineVideoActivity.o(this.pbr).wmU = new SnsOnlineVideoActivity.13.1(this);
    SnsOnlineVideoActivity.o(this.pbr).cfU();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.13
 * JD-Core Version:    0.7.0.1
 */