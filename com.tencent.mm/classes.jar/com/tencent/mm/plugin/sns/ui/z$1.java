package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class z$1
  implements View.OnClickListener
{
  z$1(z paramz) {}
  
  public final void onClick(View paramView)
  {
    if (!bk.bl(this.oQh.oQg)) {
      return;
    }
    y.i("MicroMsg.LinkWidget", "adlink url " + this.oQh.eAl);
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.oQh.eAl);
    a.eUR.j(paramView, this.oQh.bER);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.z.1
 * JD-Core Version:    0.7.0.1
 */