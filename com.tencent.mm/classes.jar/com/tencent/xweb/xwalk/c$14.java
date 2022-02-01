package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$14
  implements View.OnClickListener
{
  c$14(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154165);
    c.la(this.IST.IMY);
    Toast.makeText(this.IST.IMY, "开始检测插件更新", 0).show();
    AppMethodBeat.o(154165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.14
 * JD-Core Version:    0.7.0.1
 */