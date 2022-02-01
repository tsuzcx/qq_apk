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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.an.o;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;

public final class k
  extends LinearLayout
{
  private Context context;
  private String ovT;
  
  public k(Context paramContext, String paramString)
  {
    super(paramContext);
    AppMethodBeat.i(37829);
    this.context = paramContext;
    this.ovT = paramString;
    paramContext = View.inflate(getContext(), R.i.giW, this);
    paramString = findViewById(R.h.fGJ);
    paramContext.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37827);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        a.c("com/tencent/mm/ui/contact/EnterpriseBizViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        localObject = new Intent();
        ((Intent)localObject).putExtra("enterprise_from_scene", 2);
        ((Intent)localObject).putExtra("enterprise_biz_name", k.a(k.this));
        com.tencent.mm.br.c.b(paramAnonymousView.getContext(), "brandservice", ".ui.EnterpriseBizContactListUI", (Intent)localObject);
        a.a(this, "com/tencent/mm/ui/contact/EnterpriseBizViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
    bh.bCz();
    paramContext = com.tencent.mm.model.c.bzA().bxu(this.ovT);
    if ((paramContext == null) || ((int)paramContext.maN <= 0))
    {
      Log.e("MicroMsg.EnterpriseBizViewItem", "contact is null, %s", new Object[] { this.ovT });
      AppMethodBeat.o(37829);
      return;
    }
    paramString = (MaskLayout)paramString.findViewById(R.h.ftx);
    a.b.g((ImageView)paramString.getContentView(), this.ovT);
    if (paramContext.field_verifyFlag != 0) {
      if (az.a.okR != null)
      {
        String str = az.a.okR.ve(paramContext.field_verifyFlag);
        if (str != null) {
          paramString.a(o.MR(str), MaskLayout.a.adVl);
        }
      }
    }
    for (;;)
    {
      ((TextView)findViewById(R.h.fGK)).setText(paramContext.aSU());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.k
 * JD-Core Version:    0.7.0.1
 */