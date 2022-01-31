package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.model.au;
import com.tencent.mm.model.b.d;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.bk;

public final class g
  extends b
{
  String vUC = null;
  String vUD = null;
  boolean vgB = false;
  
  public g(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramContext);
    this.vUC = paramString1;
    this.vUD = paramString2;
    this.vgB = paramBoolean;
    if (this.view != null)
    {
      paramContext = (TextView)this.view.findViewById(R.h.chatting_security_banner_text);
      paramString1 = au.Hx().FY().ac(this.vUC, "wording");
      paramString2 = au.Hx().FY().ac(this.vUD, "wording");
      if (bk.bl(paramString1)) {
        break label197;
      }
      paramContext.setText(paramString1);
    }
    for (;;)
    {
      paramContext = au.Hx().FY().ac(this.vUC, "linkname");
      paramString1 = au.Hx().FY().ac(this.vUC, "linksrc");
      paramString2 = (TextView)this.view.findViewById(R.h.chatting_security_banner_expose_text);
      if (!bk.bl(paramContext)) {
        paramString2.setText(paramContext);
      }
      paramString2.setOnClickListener(new g.1(this, paramString1));
      ((ImageView)this.view.findViewById(R.h.chatting_security_banner_delete)).setOnClickListener(new g.2(this));
      return;
      label197:
      if (!bk.bl(paramString2)) {
        paramContext.setText(paramString2);
      }
    }
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return R.i.chatting_security_banner;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.g
 * JD-Core Version:    0.7.0.1
 */