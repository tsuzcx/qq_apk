package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.n;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.c;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.n.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;

public final class k
  extends LinearLayout
{
  private Context context;
  private String gWU;
  
  public k(Context paramContext, String paramString)
  {
    super(paramContext);
    AppMethodBeat.i(37829);
    this.context = paramContext;
    this.gWU = paramString;
    paramContext = View.inflate(getContext(), 2131493838, this);
    paramString = findViewById(2131299501);
    paramContext.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37827);
        Intent localIntent = new Intent();
        localIntent.putExtra("enterprise_from_scene", 2);
        localIntent.putExtra("enterprise_biz_name", k.a(k.this));
        d.b(paramAnonymousView.getContext(), "brandservice", ".ui.EnterpriseBizEntranceListUI", localIntent);
        AppMethodBeat.o(37827);
      }
    });
    paramString.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(37828);
        if ((k.b(k.this) instanceof MMActivity)) {
          ((MMActivity)k.b(k.this)).hideVKB();
        }
        AppMethodBeat.o(37828);
        return false;
      }
    });
    az.arV();
    paramContext = c.apM().aHW(this.gWU);
    if ((paramContext == null) || ((int)paramContext.fId <= 0))
    {
      ad.e("MicroMsg.EnterpriseBizViewItem", "contact is null, %s", new Object[] { this.gWU });
      AppMethodBeat.o(37829);
      return;
    }
    paramString = (MaskLayout)paramString.findViewById(2131297283);
    a.b.c((ImageView)paramString.getContentView(), this.gWU);
    if (paramContext.field_verifyFlag != 0) {
      if (ar.a.gMY != null)
      {
        String str = ar.a.gMY.ne(paramContext.field_verifyFlag);
        if (str != null) {
          paramString.a(n.xb(str), MaskLayout.a.Gbv);
        }
      }
    }
    for (;;)
    {
      ((TextView)findViewById(2131299502)).setText(paramContext.ZW());
      AppMethodBeat.o(37829);
      return;
      paramString.setMaskBitmap(null);
      continue;
      paramString.setMaskBitmap(null);
      continue;
      paramString.setMaskBitmap(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.k
 * JD-Core Version:    0.7.0.1
 */