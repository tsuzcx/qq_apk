package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import org.xwalk.core.R.id;
import org.xwalk.core.XWalkInitializer;

final class a$6
  implements View.OnClickListener
{
  a$6(a parama) {}
  
  public final void onClick(View paramView)
  {
    ((TextView)this.xlg.xld.findViewById(R.id.txtVersion)).setText(this.xlg.ov(true) + "\n" + XWalkInitializer.getXWalkInitializeLog());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.6
 * JD-Core Version:    0.7.0.1
 */