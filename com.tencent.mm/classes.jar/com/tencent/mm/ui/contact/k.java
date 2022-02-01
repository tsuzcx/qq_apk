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
import com.tencent.mm.am.o;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.c;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;

public final class k
  extends LinearLayout
{
  private Context context;
  private String hPO;
  
  public k(Context paramContext, String paramString)
  {
    super(paramContext);
    AppMethodBeat.i(37829);
    this.context = paramContext;
    this.hPO = paramString;
    paramContext = View.inflate(getContext(), 2131493838, this);
    paramString = findViewById(2131299501);
    paramContext.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37827);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/ui/contact/EnterpriseBizViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
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
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/ui/contact/EnterpriseBizViewItem$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if ((k.b(k.this) instanceof MMActivity)) {
          ((MMActivity)k.b(k.this)).hideVKB();
        }
        a.a(false, this, "com/tencent/mm/ui/contact/EnterpriseBizViewItem$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(37828);
        return false;
      }
    });
    ba.aBQ();
    paramContext = c.azp().aTj(this.hPO);
    if ((paramContext == null) || ((int)paramContext.gfj <= 0))
    {
      ad.e("MicroMsg.EnterpriseBizViewItem", "contact is null, %s", new Object[] { this.hPO });
      AppMethodBeat.o(37829);
      return;
    }
    paramString = (MaskLayout)paramString.findViewById(2131297283);
    a.b.c((ImageView)paramString.getContentView(), this.hPO);
    if (paramContext.field_verifyFlag != 0) {
      if (as.a.hFQ != null)
      {
        String str = as.a.hFQ.os(paramContext.field_verifyFlag);
        if (str != null) {
          paramString.a(o.Eg(str), MaskLayout.a.Jpb);
        }
      }
    }
    for (;;)
    {
      ((TextView)findViewById(2131299502)).setText(paramContext.adu());
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