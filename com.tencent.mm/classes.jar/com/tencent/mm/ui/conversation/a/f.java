package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  String AmA;
  String zwh;
  
  public f(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext);
    AppMethodBeat.i(34651);
    this.zwh = null;
    this.AmA = null;
    this.zwh = paramString1;
    this.AmA = paramString2;
    if (this.view != null)
    {
      paramContext = (ImageView)this.view.findViewById(2131822763);
      this.view.setOnClickListener(new f.1(this));
      paramContext.setImageBitmap(com.tencent.mm.ah.b.b(this.zwh, true, -1));
    }
    AppMethodBeat.o(34651);
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return 2130969137;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.f
 * JD-Core Version:    0.7.0.1
 */