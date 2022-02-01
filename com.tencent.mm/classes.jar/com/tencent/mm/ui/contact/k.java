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
import com.tencent.mm.al.n;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.c;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.n.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;

public final class k
  extends LinearLayout
{
  private Context context;
  private String hxt;
  
  public k(Context paramContext, String paramString)
  {
    super(paramContext);
    AppMethodBeat.i(37829);
    this.context = paramContext;
    this.hxt = paramString;
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
        d.b(paramAnonymousView.getContext(), "brandservice", ".ui.EnterpriseBizContactListUI", localIntent);
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
    az.ayM();
    paramContext = c.awB().aNr(this.hxt);
    if ((paramContext == null) || ((int)paramContext.fLJ <= 0))
    {
      ac.e("MicroMsg.EnterpriseBizViewItem", "contact is null, %s", new Object[] { this.hxt });
      AppMethodBeat.o(37829);
      return;
    }
    paramString = (MaskLayout)paramString.findViewById(2131297283);
    a.b.c((ImageView)paramString.getContentView(), this.hxt);
    if (paramContext.field_verifyFlag != 0) {
      if (ar.a.hny != null)
      {
        String str = ar.a.hny.nS(paramContext.field_verifyFlag);
        if (str != null) {
          paramString.a(n.Bh(str), MaskLayout.a.HBk);
        }
      }
    }
    for (;;)
    {
      ((TextView)findViewById(2131299502)).setText(paramContext.aaR());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.k
 * JD-Core Version:    0.7.0.1
 */