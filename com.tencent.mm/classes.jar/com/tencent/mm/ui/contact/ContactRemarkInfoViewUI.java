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
import com.tencent.mm.bd.c.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ContactRemarkInfoViewUI
  extends MMActivity
{
  private TextView KHJ;
  private TextView KHK;
  private ImageView KHN;
  private boolean KHT = false;
  private View KIp;
  private View KIq;
  private String bVG;
  private an contact;
  private String eRo;
  private String imV;
  private int jij;
  private String username;
  
  private void Zm()
  {
    AppMethodBeat.i(37812);
    bc.aCg();
    this.contact = com.tencent.mm.model.c.azF().BH(this.username);
    this.bVG = this.contact.adG();
    this.eRo = this.contact.eRo;
    this.imV = this.contact.eRp;
    AppMethodBeat.o(37812);
  }
  
  private void fMh()
  {
    AppMethodBeat.i(37814);
    com.tencent.mm.bd.c.aKw();
    Bitmap localBitmap = com.tencent.mm.bd.c.GI(this.username);
    if (localBitmap != null)
    {
      this.KHN.setImageBitmap(localBitmap);
      this.KHT = true;
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
    this.KHJ = ((TextView)findViewById(2131298636));
    this.KHK = ((TextView)findViewById(2131298634));
    this.KHN = ((ImageView)findViewById(2131303983));
    this.KIp = findViewById(2131298709);
    this.KIq = findViewById(2131298710);
    setMMTitle(2131757732);
    this.KHN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37804);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        if (!ContactRemarkInfoViewUI.a(ContactRemarkInfoViewUI.this))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37804);
          return;
        }
        localObject = new Intent(ContactRemarkInfoViewUI.this, ContactRemarkImagePreviewUI.class);
        ((Intent)localObject).putExtra("Contact_User", ContactRemarkInfoViewUI.b(ContactRemarkInfoViewUI.this));
        com.tencent.mm.bd.c.aKw();
        ((Intent)localObject).putExtra("remark_image_path", com.tencent.mm.bd.c.GF(ContactRemarkInfoViewUI.b(ContactRemarkInfoViewUI.this)));
        ((Intent)localObject).putExtra("view_only", true);
        paramAnonymousView = ContactRemarkInfoViewUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
    this.jij = getIntent().getIntExtra("Contact_Scene", 9);
    this.username = getIntent().getStringExtra("Contact_User");
    if (bu.isNullOrNil(this.username))
    {
      finish();
      AppMethodBeat.o(37809);
      return;
    }
    Zm();
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
    Zm();
    this.KHJ.setText(k.b(this, bu.nullAsNil(this.bVG), this.KHJ.getTextSize()));
    if (!bu.isNullOrNil(this.eRo))
    {
      this.KIp.setVisibility(0);
      this.KHK.setText(bu.nullAsNil(this.eRo));
    }
    while (!bu.isNullOrNil(this.imV))
    {
      this.KIq.setVisibility(0);
      com.tencent.mm.bd.c.aKw();
      if (!com.tencent.mm.bd.c.GG(this.username))
      {
        com.tencent.mm.bd.c.aKw().a(this.username, this.imV, new c.a()
        {
          public final void eS(final boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(37808);
            ContactRemarkInfoViewUI.f(ContactRemarkInfoViewUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(37807);
                if (!paramAnonymousBoolean)
                {
                  h.cm(ContactRemarkInfoViewUI.this, ContactRemarkInfoViewUI.this.getString(2131755733));
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
        this.KIp.setVisibility(8);
      }
      else
      {
        fMh();
        AppMethodBeat.o(37810);
        return;
      }
    }
    this.KIq.setVisibility(8);
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