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
  private View ize;
  private View jfs;
  
  public b(Context paramContext, final a parama)
  {
    super(paramContext);
    AppMethodBeat.i(37654);
    this.ize = null;
    this.jfs = null;
    this.contentView = null;
    this.context = paramContext;
    View.inflate(getContext(), 2131492949, this);
    this.ize = findViewById(2131298736);
    this.jfs = this.ize.findViewById(2131296499);
    paramContext = this.jfs.getLayoutParams();
    paramContext.height = ((int)(com.tencent.mm.cc.a.ay(this.context, 2131165242) * com.tencent.mm.cc.a.il(this.context)));
    this.jfs.setLayoutParams(paramContext);
    this.contentView = ((TextView)this.jfs.findViewById(2131296501));
    this.ize.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37648);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        switch (b.3.KjX[parama.ordinal()])
        {
        default: 
          ad.e("MicroMsg.ChatroomContactEntranceView", "[cpan] unknow type for click. type:%s", new Object[] { parama });
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37648);
          return;
          localObject = new Intent();
          ((Intent)localObject).setClassName(b.a(b.this), "com.tencent.mm.ui.contact.ChatroomContactUI");
          paramAnonymousView = b.a(b.this);
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          continue;
          paramAnonymousView = new Intent();
          d.b(b.a(b.this), "label", ".ui.ContactLabelManagerUI", paramAnonymousView);
          continue;
          paramAnonymousView = new Intent();
          d.b(b.a(b.this), "ipcall", ".ui.IPCallAddressUI", paramAnonymousView);
          continue;
          localObject = new Intent(b.a(b.this), OnlyChatContactMgrUI.class);
          paramAnonymousView = b.a(b.this);
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    });
    this.jfs.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(37649);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if ((b.a(b.this) instanceof MMActivity)) {
          ((MMActivity)b.a(b.this)).hideVKB();
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(37649);
        return false;
      }
    });
    paramContext = (ImageView)((MaskLayout)this.jfs.findViewById(2131296500)).getContentView();
    switch (3.KjX[parama.ordinal()])
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
      this.jfs.setBackgroundResource(2131231818);
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
    View localView = this.ize;
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
      KjY = new a("Chatromm", 0);
      KjZ = new a("ContactLabel", 1);
      Kka = new a("ContactIpCall", 2);
      Kkb = new a("OnlyChat", 3);
      Kkc = new a[] { KjY, KjZ, Kka, Kkb };
      AppMethodBeat.o(37653);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.b
 * JD-Core Version:    0.7.0.1
 */