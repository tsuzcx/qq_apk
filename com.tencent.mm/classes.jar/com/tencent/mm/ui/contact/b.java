package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e;
import com.tencent.mm.bs.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;

public final class b
  extends RelativeLayout
{
  private TextView contentView;
  private Context context;
  private View hFi;
  private View imc;
  
  public b(Context paramContext, final a parama)
  {
    super(paramContext);
    AppMethodBeat.i(37654);
    this.hFi = null;
    this.imc = null;
    this.contentView = null;
    this.context = paramContext;
    View.inflate(getContext(), 2131492949, this);
    this.hFi = findViewById(2131298736);
    this.imc = this.hFi.findViewById(2131296499);
    paramContext = this.imc.getLayoutParams();
    paramContext.height = ((int)(com.tencent.mm.cd.a.ap(this.context, 2131165242) * com.tencent.mm.cd.a.hR(this.context)));
    this.imc.setLayoutParams(paramContext);
    this.contentView = ((TextView)this.imc.findViewById(2131296501));
    this.hFi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37648);
        switch (b.3.GTg[parama.ordinal()])
        {
        default: 
          ad.e("MicroMsg.ChatroomContactEntranceView", "[cpan] unknow type for click. type:%s", new Object[] { parama });
          AppMethodBeat.o(37648);
          return;
        case 1: 
          localObject = new Intent();
          ((Intent)localObject).setClassName(b.a(b.this), "com.tencent.mm.ui.contact.ChatroomContactUI");
          paramAnonymousView = b.a(b.this);
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(37648);
          return;
        case 2: 
          paramAnonymousView = new Intent();
          d.b(b.a(b.this), "label", ".ui.ContactLabelManagerUI", paramAnonymousView);
          AppMethodBeat.o(37648);
          return;
        case 3: 
          paramAnonymousView = new Intent();
          d.b(b.a(b.this), "ipcall", ".ui.IPCallAddressUI", paramAnonymousView);
          AppMethodBeat.o(37648);
          return;
        }
        Object localObject = new Intent(b.a(b.this), OnlyChatContactMgrUI.class);
        paramAnonymousView = b.a(b.this);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37648);
      }
    });
    this.imc.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(37649);
        if ((b.a(b.this) instanceof MMActivity)) {
          ((MMActivity)b.a(b.this)).hideVKB();
        }
        AppMethodBeat.o(37649);
        return false;
      }
    });
    paramContext = (ImageView)((MaskLayout)this.imc.findViewById(2131296500)).getContentView();
    switch (3.GTg[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37654);
      return;
      this.contentView.setText(2131755178);
      e.a(getContext(), paramContext, 2131690016);
      AppMethodBeat.o(37654);
      return;
      this.contentView.setText(2131755182);
      e.a(getContext(), paramContext, 2131690017);
      AppMethodBeat.o(37654);
      return;
      this.imc.setBackgroundResource(2131231818);
      this.contentView.setText(2131755181);
      e.a(getContext(), paramContext, 2131690023);
      AppMethodBeat.o(37654);
      return;
      this.contentView.setText(2131755183);
      e.a(getContext(), paramContext, 2131234826);
    }
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(37655);
    View localView = this.hFi;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(37655);
      return;
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(37653);
      GTh = new a("Chatromm", 0);
      GTi = new a("ContactLabel", 1);
      GTj = new a("ContactIpCall", 2);
      GTk = new a("OnlyChat", 3);
      GTl = new a[] { GTh, GTi, GTj, GTk };
      AppMethodBeat.o(37653);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.b
 * JD-Core Version:    0.7.0.1
 */