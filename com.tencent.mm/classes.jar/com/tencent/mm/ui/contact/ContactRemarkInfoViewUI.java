package com.tencent.mm.ui.contact;

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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.ba.c.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;

public class ContactRemarkInfoViewUI
  extends MMActivity
{
  private TextView afcT;
  private TextView afcU;
  private View afdD;
  private View afdE;
  private ImageView afda;
  private boolean afdf = false;
  private au contact;
  private String dYO;
  private String kal;
  private String oRL;
  private int pUt;
  private String username;
  
  private void aNi()
  {
    AppMethodBeat.i(37812);
    bh.bCz();
    this.contact = com.tencent.mm.model.c.bzA().JE(this.username);
    this.dYO = this.contact.aSV();
    this.kal = this.contact.kal;
    this.oRL = this.contact.kam;
    AppMethodBeat.o(37812);
  }
  
  private void jyl()
  {
    AppMethodBeat.i(37814);
    com.tencent.mm.ba.c.bLL();
    Bitmap localBitmap = com.tencent.mm.ba.c.OR(this.username);
    if (localBitmap != null)
    {
      this.afda.setImageBitmap(localBitmap);
      this.afdf = true;
    }
    AppMethodBeat.o(37814);
  }
  
  public int getLayoutId()
  {
    return R.i.giB;
  }
  
  public void initView()
  {
    AppMethodBeat.i(37813);
    this.afcT = ((TextView)findViewById(R.h.fCH));
    this.afcU = ((TextView)findViewById(R.h.fCD));
    this.afda = ((ImageView)findViewById(R.h.fUJ));
    this.afdD = findViewById(R.h.fDf);
    this.afdE = findViewById(R.h.fDg);
    setMMTitle(R.l.gBB);
    this.afda.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37804);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        if (!ContactRemarkInfoViewUI.a(ContactRemarkInfoViewUI.this))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37804);
          return;
        }
        localObject = new Intent(ContactRemarkInfoViewUI.this, ContactRemarkImagePreviewUI.class);
        ((Intent)localObject).putExtra("Contact_User", ContactRemarkInfoViewUI.b(ContactRemarkInfoViewUI.this));
        com.tencent.mm.ba.c.bLL();
        ((Intent)localObject).putExtra("remark_image_path", com.tencent.mm.ba.c.OO(ContactRemarkInfoViewUI.b(ContactRemarkInfoViewUI.this)));
        ((Intent)localObject).putExtra("view_only", true);
        paramAnonymousView = ContactRemarkInfoViewUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37804);
      }
    });
    addTextOptionMenu(0, getString(R.l.app_edit), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(37805);
        Object localObject = new Intent();
        ((Intent)localObject).setClass(ContactRemarkInfoViewUI.this.getContext(), ContactRemarkInfoModUI.class);
        ((Intent)localObject).putExtra("Contact_Scene", ContactRemarkInfoViewUI.c(ContactRemarkInfoViewUI.this));
        ((Intent)localObject).putExtra("Contact_User", ContactRemarkInfoViewUI.d(ContactRemarkInfoViewUI.this).field_username);
        paramAnonymousMenuItem = ContactRemarkInfoViewUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    this.pUt = getIntent().getIntExtra("Contact_Scene", 9);
    this.username = getIntent().getStringExtra("Contact_User");
    if (Util.isNullOrNil(this.username))
    {
      finish();
      AppMethodBeat.o(37809);
      return;
    }
    aNi();
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
    aNi();
    this.afcT.setText(p.b(this, Util.nullAsNil(this.dYO), this.afcT.getTextSize()));
    if (!Util.isNullOrNil(this.kal))
    {
      this.afdD.setVisibility(0);
      this.afcU.setText(Util.nullAsNil(this.kal));
    }
    while (!Util.isNullOrNil(this.oRL))
    {
      this.afdE.setVisibility(0);
      com.tencent.mm.ba.c.bLL();
      if (!com.tencent.mm.ba.c.OP(this.username))
      {
        com.tencent.mm.ba.c.bLL().a(this.username, this.oRL, new c.a()
        {
          public final void hk(final boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(37808);
            ContactRemarkInfoViewUI.f(ContactRemarkInfoViewUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(37807);
                if (!paramAnonymousBoolean)
                {
                  k.cZ(ContactRemarkInfoViewUI.this, ContactRemarkInfoViewUI.this.getString(R.l.app_err_system_busy_tip));
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
        this.afdD.setVisibility(8);
      }
      else
      {
        jyl();
        AppMethodBeat.o(37810);
        return;
      }
    }
    this.afdE.setVisibility(8);
    AppMethodBeat.o(37810);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoViewUI
 * JD-Core Version:    0.7.0.1
 */