package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.be.c.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ContactRemarkInfoViewUI
  extends MMActivity
{
  private View KlV;
  private View KlW;
  private TextView Klp;
  private TextView Klq;
  private ImageView Klt;
  private boolean Klz = false;
  private String bVG;
  private am contact;
  private String ePD;
  private String ikc;
  private int jfq;
  private String username;
  
  private void Zd()
  {
    AppMethodBeat.i(37812);
    ba.aBQ();
    this.contact = com.tencent.mm.model.c.azp().Bf(this.username);
    this.bVG = this.contact.adv();
    this.ePD = this.contact.ePD;
    this.ikc = this.contact.ePE;
    AppMethodBeat.o(37812);
  }
  
  private void fHP()
  {
    AppMethodBeat.i(37814);
    com.tencent.mm.be.c.aKd();
    Bitmap localBitmap = com.tencent.mm.be.c.Gg(this.username);
    if (localBitmap != null)
    {
      this.Klt.setImageBitmap(localBitmap);
      this.Klz = true;
    }
    AppMethodBeat.o(37814);
  }
  
  public int getLayoutId()
  {
    return 2131493657;
  }
  
  public void initView()
  {
    AppMethodBeat.i(37813);
    this.Klp = ((TextView)findViewById(2131298636));
    this.Klq = ((TextView)findViewById(2131298634));
    this.Klt = ((ImageView)findViewById(2131303983));
    this.KlV = findViewById(2131298709);
    this.KlW = findViewById(2131298710);
    setMMTitle(2131757732);
    this.Klt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37804);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        if (!ContactRemarkInfoViewUI.a(ContactRemarkInfoViewUI.this))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37804);
          return;
        }
        localObject = new Intent(ContactRemarkInfoViewUI.this, ContactRemarkImagePreviewUI.class);
        ((Intent)localObject).putExtra("Contact_User", ContactRemarkInfoViewUI.b(ContactRemarkInfoViewUI.this));
        com.tencent.mm.be.c.aKd();
        ((Intent)localObject).putExtra("remark_image_path", com.tencent.mm.be.c.Gd(ContactRemarkInfoViewUI.b(ContactRemarkInfoViewUI.this)));
        ((Intent)localObject).putExtra("view_only", true);
        paramAnonymousView = ContactRemarkInfoViewUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37804);
      }
    });
    addTextOptionMenu(0, getString(2131755721), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(37805);
        Object localObject = new Intent();
        ((Intent)localObject).setClass(ContactRemarkInfoViewUI.this.getContext(), ContactRemarkInfoModUI.class);
        ((Intent)localObject).putExtra("Contact_Scene", ContactRemarkInfoViewUI.c(ContactRemarkInfoViewUI.this));
        ((Intent)localObject).putExtra("Contact_User", ContactRemarkInfoViewUI.d(ContactRemarkInfoViewUI.this).field_username);
        paramAnonymousMenuItem = ContactRemarkInfoViewUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37805);
        return false;
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(37806);
        ContactRemarkInfoViewUI.this.finish();
        AppMethodBeat.o(37806);
        return true;
      }
    });
    AppMethodBeat.o(37813);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37809);
    super.onCreate(paramBundle);
    this.jfq = getIntent().getIntExtra("Contact_Scene", 9);
    this.username = getIntent().getStringExtra("Contact_User");
    if (bt.isNullOrNil(this.username))
    {
      finish();
      AppMethodBeat.o(37809);
      return;
    }
    Zd();
    initView();
    AppMethodBeat.o(37809);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(37811);
    super.onDestroy();
    AppMethodBeat.o(37811);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(37810);
    super.onResume();
    Zd();
    this.Klp.setText(k.b(this, bt.nullAsNil(this.bVG), this.Klp.getTextSize()));
    if (!bt.isNullOrNil(this.ePD))
    {
      this.KlV.setVisibility(0);
      this.Klq.setText(bt.nullAsNil(this.ePD));
    }
    while (!bt.isNullOrNil(this.ikc))
    {
      this.KlW.setVisibility(0);
      com.tencent.mm.be.c.aKd();
      if (!com.tencent.mm.be.c.Ge(this.username))
      {
        com.tencent.mm.be.c.aKd().a(this.username, this.ikc, new c.a()
        {
          public final void eP(final boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(37808);
            ContactRemarkInfoViewUI.f(ContactRemarkInfoViewUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(37807);
                if (!paramAnonymousBoolean)
                {
                  h.cl(ContactRemarkInfoViewUI.this, ContactRemarkInfoViewUI.this.getString(2131755733));
                  AppMethodBeat.o(37807);
                  return;
                }
                ContactRemarkInfoViewUI.e(ContactRemarkInfoViewUI.this);
                AppMethodBeat.o(37807);
              }
            });
            AppMethodBeat.o(37808);
          }
        });
        AppMethodBeat.o(37810);
        return;
        this.KlV.setVisibility(8);
      }
      else
      {
        fHP();
        AppMethodBeat.o(37810);
        return;
      }
    }
    this.KlW.setVisibility(8);
    AppMethodBeat.o(37810);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoViewUI
 * JD-Core Version:    0.7.0.1
 */