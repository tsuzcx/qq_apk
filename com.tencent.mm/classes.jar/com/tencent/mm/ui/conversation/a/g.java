package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.b.d;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.bo;

public final class g
  extends b
{
  String AmA;
  boolean zvB;
  String zwh;
  
  public g(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(34654);
    this.zwh = null;
    this.AmA = null;
    this.zvB = false;
    this.zwh = paramString1;
    this.AmA = paramString2;
    this.zvB = paramBoolean;
    if (this.view != null)
    {
      paramContext = (TextView)this.view.findViewById(2131822764);
      paramString1 = aw.aaz().YZ().as(this.zwh, "wording");
      paramString2 = aw.aaz().YZ().as(this.AmA, "wording");
      if (bo.isNullOrNil(paramString1)) {
        break label204;
      }
      paramContext.setText(paramString1);
    }
    for (;;)
    {
      paramContext = aw.aaz().YZ().as(this.zwh, "linkname");
      paramString1 = aw.aaz().YZ().as(this.zwh, "linksrc");
      paramString2 = (TextView)this.view.findViewById(2131822765);
      if (!bo.isNullOrNil(paramContext)) {
        paramString2.setText(paramContext);
      }
      paramString2.setOnClickListener(new g.1(this, paramString1));
      ((ImageView)this.view.findViewById(2131822766)).setOnClickListener(new g.2(this));
      AppMethodBeat.o(34654);
      return;
      label204:
      if (!bo.isNullOrNil(paramString2)) {
        paramContext.setText(paramString2);
      }
    }
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return 2130969138;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.g
 * JD-Core Version:    0.7.0.1
 */