package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import com.tencent.mm.R.h;
import com.tencent.mm.pluginsdk.ui.b.b;

public final class h
  extends b
{
  public h(Context paramContext)
  {
    super(paramContext);
    if (this.view != null) {
      this.view.findViewById(R.h.facebook_tips_content).setOnClickListener(new h.1(this));
    }
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.h
 * JD-Core Version:    0.7.0.1
 */