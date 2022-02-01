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
import com.tencent.mm.aj.e;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;

public final class b
  extends RelativeLayout
{
  private TextView contentView;
  private Context context;
  private View jxm;
  private View kgo;
  
  public b(Context paramContext, final a parama)
  {
    super(paramContext);
    AppMethodBeat.i(37654);
    this.jxm = null;
    this.kgo = null;
    this.contentView = null;
    this.context = paramContext;
    View.inflate(getContext(), 2131492982, this);
    this.jxm = findViewById(2131299174);
    this.kgo = this.jxm.findViewById(2131296573);
    paramContext = this.kgo.getLayoutParams();
    paramContext.height = ((int)(com.tencent.mm.cb.a.aH(this.context, 2131165246) * com.tencent.mm.cb.a.jj(this.context)));
    this.kgo.setLayoutParams(paramContext);
    this.contentView = ((TextView)this.kgo.findViewById(2131296575));
    this.jxm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37648);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        switch (b.3.PTo[parama.ordinal()])
        {
        default: 
          Log.e("MicroMsg.ChatroomContactEntranceView", "[cpan] unknow type for click. type:%s", new Object[] { parama });
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37648);
          return;
          localObject = new Intent();
          ((Intent)localObject).setClassName(b.a(b.this), "com.tencent.mm.ui.contact.ChatroomContactUI");
          paramAnonymousView = b.a(b.this);
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          continue;
          paramAnonymousView = new Intent();
          c.b(b.a(b.this), "label", ".ui.ContactLabelManagerUI", paramAnonymousView);
          continue;
          paramAnonymousView = new Intent();
          c.b(b.a(b.this), "ipcall", ".ui.IPCallAddressUI", paramAnonymousView);
          continue;
          localObject = new Intent(b.a(b.this), OnlyChatContactMgrUI.class);
          paramAnonymousView = b.a(b.this);
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    });
    this.kgo.setOnTouchListener(new View.OnTouchListener()
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
    paramContext = (ImageView)((MaskLayout)this.kgo.findViewById(2131296574)).getContentView();
    switch (3.PTo[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37654);
      return;
      this.contentView.setText(2131755196);
      e.a(getContext(), paramContext, 2131690046);
      AppMethodBeat.o(37654);
      return;
      this.contentView.setText(2131755200);
      e.a(getContext(), paramContext, 2131690047);
      AppMethodBeat.o(37654);
      return;
      this.kgo.setBackgroundResource(2131231898);
      this.contentView.setText(2131755199);
      e.a(getContext(), paramContext, 2131690053);
      AppMethodBeat.o(37654);
      return;
      this.contentView.setText(2131755201);
      e.a(getContext(), paramContext, 2131231694);
    }
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(37655);
    View localView = this.jxm;
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
      PTp = new a("Chatromm", 0);
      PTq = new a("ContactLabel", 1);
      PTr = new a("ContactIpCall", 2);
      PTs = new a("OnlyChat", 3);
      PTt = new a[] { PTp, PTq, PTr, PTs };
      AppMethodBeat.o(37653);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.b
 * JD-Core Version:    0.7.0.1
 */