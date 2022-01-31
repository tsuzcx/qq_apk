package com.tencent.mm.ui.contact;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.m;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.c;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.n.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;

public final class j
  extends LinearLayout
{
  private Context context;
  private String fuO;
  
  public j(Context paramContext, String paramString)
  {
    super(paramContext);
    AppMethodBeat.i(33711);
    this.context = paramContext;
    this.fuO = paramString;
    paramContext = View.inflate(getContext(), 2130969426, this);
    paramString = findViewById(2131823728);
    paramContext.setOnClickListener(new j.1(this));
    paramString.setOnTouchListener(new j.2(this));
    aw.aaz();
    paramContext = c.YA().aru(this.fuO);
    if ((paramContext == null) || ((int)paramContext.euF <= 0))
    {
      ab.e("MicroMsg.EnterpriseBizViewItem", "contact is null, %s", new Object[] { this.fuO });
      AppMethodBeat.o(33711);
      return;
    }
    paramString = (MaskLayout)paramString.findViewById(2131821837);
    a.b.c((ImageView)paramString.getContentView(), this.fuO);
    if (paramContext.field_verifyFlag != 0) {
      if (ao.a.flK != null)
      {
        String str = ao.a.flK.ky(paramContext.field_verifyFlag);
        if (str != null) {
          paramString.a(m.sf(str), MaskLayout.a.znW);
        }
      }
    }
    for (;;)
    {
      ((TextView)findViewById(2131823729)).setText(paramContext.Oe());
      AppMethodBeat.o(33711);
      return;
      paramString.setMaskBitmap(null);
      continue;
      paramString.setMaskBitmap(null);
      continue;
      paramString.setMaskBitmap(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.j
 * JD-Core Version:    0.7.0.1
 */