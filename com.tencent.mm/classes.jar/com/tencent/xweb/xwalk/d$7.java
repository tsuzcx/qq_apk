package com.tencent.xweb.xwalk;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.xweb.ae;
import org.xwalk.core.Log;
import org.xwalk.core.R.id;

final class d$7
  implements View.OnClickListener
{
  d$7(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154158);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/xweb/xwalk/WebDebugPage$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = (TextView)this.ainW.ainP.findViewById(R.id.text_origin);
    if (paramView != null)
    {
      paramView = paramView.getText().toString();
      if (!TextUtils.isEmpty(paramView))
      {
        Log.i("WebDebugPage", "delete origin:".concat(String.valueOf(paramView)));
        ae.kfW().deleteOrigin(paramView);
      }
    }
    a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(154158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.7
 * JD-Core Version:    0.7.0.1
 */