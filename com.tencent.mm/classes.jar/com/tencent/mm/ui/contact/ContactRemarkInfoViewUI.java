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
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ContactRemarkInfoViewUI
  extends MMActivity
{
  private TextView IuJ;
  private TextView IuK;
  private ImageView IuN;
  private boolean IuT = false;
  private View Ivp;
  private View Ivq;
  private String bLt;
  private ai contact;
  private String eyf;
  private String hQO;
  private int iMg;
  private String username;
  
  private void WJ()
  {
    AppMethodBeat.i(37812);
    az.ayM();
    this.contact = com.tencent.mm.model.c.awB().aNt(this.username);
    this.bLt = this.contact.aaS();
    this.eyf = this.contact.eyf;
    this.hQO = this.contact.eyg;
    AppMethodBeat.o(37812);
  }
  
  private void frc()
  {
    AppMethodBeat.i(37814);
    com.tencent.mm.bd.c.aGS();
    Bitmap localBitmap = com.tencent.mm.bd.c.Db(this.username);
    if (localBitmap != null)
    {
      this.IuN.setImageBitmap(localBitmap);
      this.IuT = true;
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
    this.IuJ = ((TextView)findViewById(2131298636));
    this.IuK = ((TextView)findViewById(2131298634));
    this.IuN = ((ImageView)findViewById(2131303983));
    this.Ivp = findViewById(2131298709);
    this.Ivq = findViewById(2131298710);
    setMMTitle(2131757732);
    this.IuN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37804);
        if (!ContactRemarkInfoViewUI.a(ContactRemarkInfoViewUI.this))
        {
          AppMethodBeat.o(37804);
          return;
        }
        Object localObject = new Intent(ContactRemarkInfoViewUI.this, ContactRemarkImagePreviewUI.class);
        ((Intent)localObject).putExtra("Contact_User", ContactRemarkInfoViewUI.b(ContactRemarkInfoViewUI.this));
        com.tencent.mm.bd.c.aGS();
        ((Intent)localObject).putExtra("remark_image_path", com.tencent.mm.bd.c.CY(ContactRemarkInfoViewUI.b(ContactRemarkInfoViewUI.this)));
        ((Intent)localObject).putExtra("view_only", true);
        paramAnonymousView = ContactRemarkInfoViewUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
    this.iMg = getIntent().getIntExtra("Contact_Scene", 9);
    this.username = getIntent().getStringExtra("Contact_User");
    if (bs.isNullOrNil(this.username))
    {
      finish();
      AppMethodBeat.o(37809);
      return;
    }
    WJ();
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
    WJ();
    this.IuJ.setText(k.b(this, bs.nullAsNil(this.bLt), this.IuJ.getTextSize()));
    if (!bs.isNullOrNil(this.eyf))
    {
      this.Ivp.setVisibility(0);
      this.IuK.setText(bs.nullAsNil(this.eyf));
    }
    while (!bs.isNullOrNil(this.hQO))
    {
      this.Ivq.setVisibility(0);
      com.tencent.mm.bd.c.aGS();
      if (!com.tencent.mm.bd.c.CZ(this.username))
      {
        com.tencent.mm.bd.c.aGS().a(this.username, this.hQO, new c.a()
        {
          public final void eN(final boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(37808);
            ContactRemarkInfoViewUI.f(ContactRemarkInfoViewUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(37807);
                if (!paramAnonymousBoolean)
                {
                  h.cg(ContactRemarkInfoViewUI.this, ContactRemarkInfoViewUI.this.getString(2131755733));
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
        this.Ivp.setVisibility(8);
      }
      else
      {
        frc();
        AppMethodBeat.o(37810);
        return;
      }
    }
    this.Ivq.setVisibility(8);
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