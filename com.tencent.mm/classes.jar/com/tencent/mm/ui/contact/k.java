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
import com.tencent.mm.al.o;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.c;
import com.tencent.mm.model.bc;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;

public final class k
  extends LinearLayout
{
  private Context context;
  private String hSG;
  
  public k(Context paramContext, String paramString)
  {
    super(paramContext);
    AppMethodBeat.i(37829);
    this.context = paramContext;
    this.hSG = paramString;
    paramContext = View.inflate(getContext(), 2131493838, this);
    paramString = findViewById(2131299501);
    paramContext.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37827);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/ui/contact/EnterpriseBizViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        localObject = new Intent();
        ((Intent)localObject).putExtra("enterprise_from_scene", 2);
        ((Intent)localObject).putExtra("enterprise_biz_name", k.a(k.this));
        d.b(paramAnonymousView.getContext(), "brandservice", ".ui.EnterpriseBizContactListUI", (Intent)localObject);
        a.a(this, "com/tencent/mm/ui/contact/EnterpriseBizViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37827);
      }
    });
    paramString.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(37828);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/ui/contact/EnterpriseBizViewItem$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        if ((k.b(k.this) instanceof MMActivity)) {
          ((MMActivity)k.b(k.this)).hideVKB();
        }
        a.a(false, this, "com/tencent/mm/ui/contact/EnterpriseBizViewItem$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(37828);
        return false;
      }
    });
    bc.aCg();
    paramContext = com.tencent.mm.model.c.azF().aUK(this.hSG);
    if ((paramContext == null) || ((int)paramContext.ght <= 0))
    {
      ae.e("MicroMsg.EnterpriseBizViewItem", "contact is null, %s", new Object[] { this.hSG });
      AppMethodBeat.o(37829);
      return;
    }
    paramString = (MaskLayout)paramString.findViewById(2131297283);
    a.b.c((ImageView)paramString.getContentView(), this.hSG);
    if (paramContext.field_verifyFlag != 0) {
      if (au.a.hII != null)
      {
        String str = au.a.hII.ov(paramContext.field_verifyFlag);
        if (str != null) {
          paramString.a(o.EI(str), MaskLayout.a.JJQ);
        }
      }
    }
    for (;;)
    {
      ((TextView)findViewById(2131299502)).setText(paramContext.adF());
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