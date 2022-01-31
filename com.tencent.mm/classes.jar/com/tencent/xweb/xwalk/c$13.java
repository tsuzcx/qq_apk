package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$13
  implements View.OnClickListener
{
  c$13(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(85134);
    this.BIO.ead();
    Toast.makeText(this.BIO.BDH, "开始检测插件更新", 0).show();
    AppMethodBeat.o(85134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.13
 * JD-Core Version:    0.7.0.1
 */