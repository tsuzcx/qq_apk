package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;

public final class f
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  String vUC = null;
  String vUD = null;
  
  public f(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext);
    this.vUC = paramString1;
    this.vUD = paramString2;
    if (this.view != null)
    {
      paramContext = (ImageView)this.view.findViewById(R.h.chatting_banner_recom_icon);
      this.view.setOnClickListener(new f.1(this));
      paramContext.setImageBitmap(com.tencent.mm.ag.b.a(this.vUC, true, -1));
    }
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return R.i.chatting_recom_friends_banner;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.f
 * JD-Core Version:    0.7.0.1
 */