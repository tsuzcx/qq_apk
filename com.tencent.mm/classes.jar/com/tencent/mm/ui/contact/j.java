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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ai.m;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.c;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.n.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;

public final class j
  extends LinearLayout
{
  private Context context;
  private String eeM;
  
  public j(Context paramContext, String paramString)
  {
    super(paramContext);
    this.context = paramContext;
    this.eeM = paramString;
    paramContext = View.inflate(getContext(), R.i.enterprise_biz_item_in_addressui_header, this);
    paramString = findViewById(R.h.enterprise_biz_item_ll);
    paramContext.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("enterprise_from_scene", 2);
        localIntent.putExtra("enterprise_biz_name", j.a(j.this));
        d.b(paramAnonymousView.getContext(), "brandservice", ".ui.EnterpriseBizContactListUI", localIntent);
      }
    });
    paramString.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if ((j.b(j.this) instanceof MMActivity)) {
          ((MMActivity)j.b(j.this)).XM();
        }
        return false;
      }
    });
    au.Hx();
    paramContext = c.Fw().abj(this.eeM);
    if ((paramContext == null) || ((int)paramContext.dBe <= 0))
    {
      y.e("MicroMsg.EnterpriseBizViewItem", "contact is null, %s", new Object[] { this.eeM });
      return;
    }
    paramString = (MaskLayout)paramString.findViewById(R.h.biz_contact_entrance_avatar_iv);
    a.b.a((ImageView)paramString.getContentView(), this.eeM);
    if (paramContext.field_verifyFlag != 0) {
      if (am.a.dVA != null)
      {
        String str = am.a.dVA.hM(paramContext.field_verifyFlag);
        if (str != null) {
          paramString.a(m.lk(str), MaskLayout.a.uZF);
        }
      }
    }
    for (;;)
    {
      ((TextView)findViewById(R.h.enterprise_biz_title)).setText(paramContext.Bp());
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
 * Qualified Name:     com.tencent.mm.ui.contact.j
 * JD-Core Version:    0.7.0.1
 */