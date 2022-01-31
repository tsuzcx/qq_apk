package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.xv;

public final class d
  implements h.b
{
  Context context;
  int idy;
  int idz;
  
  public d(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void a(View paramView, int paramInt, b paramb)
  {
    TextView localTextView = (TextView)paramView.findViewById(R.h.record_listitem_content);
    localTextView.setText(paramb.bNt.desc);
    j.h(localTextView, 1);
    localTextView.setOnLongClickListener(new d.1(this, paramb));
    paramView.setOnTouchListener(new d.2(this));
  }
  
  public final View dZ(Context paramContext)
  {
    return View.inflate(paramContext, R.i.record_listitem_text, null);
  }
  
  public final void destroy()
  {
    this.context = null;
  }
  
  public final void pause() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.d
 * JD-Core Version:    0.7.0.1
 */