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
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.br.c;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;

public final class b
  extends RelativeLayout
{
  private TextView contentView;
  private Context context;
  private View hDw;
  private View pUv;
  
  public b(Context paramContext, final a parama)
  {
    super(paramContext);
    AppMethodBeat.i(37654);
    this.hDw = null;
    this.pUv = null;
    this.contentView = null;
    this.context = paramContext;
    View.inflate(getContext(), R.i.gdX, this);
    this.hDw = findViewById(R.h.container);
    this.pUv = this.hDw.findViewById(R.h.fqT);
    paramContext = this.pUv.getLayoutParams();
    paramContext.height = ((int)(com.tencent.mm.cd.a.bs(this.context, R.f.ContactListHeight) * com.tencent.mm.cd.a.mo(this.context)));
    this.pUv.setLayoutParams(paramContext);
    this.contentView = ((TextView)this.pUv.findViewById(R.h.fqV));
    this.hDw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37648);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        switch (b.3.afbC[parama.ordinal()])
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
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          continue;
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("key_label_click_source", 2);
          c.b(b.a(b.this), "label", ".ui.ContactLabelManagerUI", paramAnonymousView);
          continue;
          paramAnonymousView = new Intent();
          c.b(b.a(b.this), "ipcall", ".ui.IPCallAddressUI", paramAnonymousView);
          continue;
          localObject = new Intent(b.a(b.this), OnlyChatContactMgrUI.class);
          paramAnonymousView = b.a(b.this);
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/ui/contact/AddressUIEntranceHeaderView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    });
    this.pUv.setOnTouchListener(new View.OnTouchListener()
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
    paramContext = (ImageView)((MaskLayout)this.pUv.findViewById(R.h.fqU)).getContentView();
    switch (3.afbC[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37654);
      return;
      this.contentView.setText(R.l.address_chatroom_contact_nick);
      AvatarStorage.a(getContext(), paramContext, R.k.default_chatroom);
      AppMethodBeat.o(37654);
      return;
      this.contentView.setText(R.l.gqb);
      AvatarStorage.a(getContext(), paramContext, R.k.default_contactlabel);
      AppMethodBeat.o(37654);
      return;
      this.pUv.setBackgroundResource(R.g.comm_list_item_selector);
      this.contentView.setText(R.l.gqa);
      AvatarStorage.a(getContext(), paramContext, R.k.default_ipcall);
      AppMethodBeat.o(37654);
      return;
      this.contentView.setText(R.l.gqc);
      AvatarStorage.a(getContext(), paramContext, R.g.chatonlyfriends);
    }
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(37655);
    View localView = this.hDw;
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
      afbD = new a("Chatromm", 0);
      afbE = new a("ContactLabel", 1);
      afbF = new a("ContactIpCall", 2);
      afbG = new a("OnlyChat", 3);
      afbH = new a[] { afbD, afbE, afbF, afbG };
      AppMethodBeat.o(37653);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.b
 * JD-Core Version:    0.7.0.1
 */