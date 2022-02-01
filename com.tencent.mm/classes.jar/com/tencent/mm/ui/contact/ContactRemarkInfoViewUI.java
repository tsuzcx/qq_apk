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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ContactRemarkInfoViewUI
  extends MMActivity
{
  private TextView PUI;
  private TextView PUJ;
  private ImageView PUM;
  private boolean PUR = false;
  private View PVn;
  private View PVo;
  private String cgo;
  private as contact;
  private String fuR;
  private String jid;
  private int kgm;
  private String username;
  
  private void amZ()
  {
    AppMethodBeat.i(37812);
    bg.aVF();
    this.contact = com.tencent.mm.model.c.aSN().Kn(this.username);
    this.cgo = this.contact.arJ();
    this.fuR = this.contact.fuR;
    this.jid = this.contact.fuS;
    AppMethodBeat.o(37812);
  }
  
  private void gUB()
  {
    AppMethodBeat.i(37814);
    com.tencent.mm.bd.c.bez();
    Bitmap localBitmap = com.tencent.mm.bd.c.Pu(this.username);
    if (localBitmap != null)
    {
      this.PUM.setImageBitmap(localBitmap);
      this.PUR = true;
    }
    AppMethodBeat.o(37814);
  }
  
  public int getLayoutId()
  {
    return 2131493787;
  }
  
  public void initView()
  {
    AppMethodBeat.i(37813);
    this.PUI = ((TextView)findViewById(2131299073));
    this.PUJ = ((TextView)findViewById(2131299071));
    this.PUM = ((ImageView)findViewById(2131306837));
    this.PVn = findViewById(2131299147);
    this.PVo = findViewById(2131299148);
    setMMTitle(2131757969);
    this.PUM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37804);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        if (!ContactRemarkInfoViewUI.a(ContactRemarkInfoViewUI.this))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37804);
          return;
        }
        localObject = new Intent(ContactRemarkInfoViewUI.this, ContactRemarkImagePreviewUI.class);
        ((Intent)localObject).putExtra("Contact_User", ContactRemarkInfoViewUI.b(ContactRemarkInfoViewUI.this));
        com.tencent.mm.bd.c.bez();
        ((Intent)localObject).putExtra("remark_image_path", com.tencent.mm.bd.c.Pr(ContactRemarkInfoViewUI.b(ContactRemarkInfoViewUI.this)));
        ((Intent)localObject).putExtra("view_only", true);
        paramAnonymousView = ContactRemarkInfoViewUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37804);
      }
    });
    addTextOptionMenu(0, getString(2131755792), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(37805);
        Object localObject = new Intent();
        ((Intent)localObject).setClass(ContactRemarkInfoViewUI.this.getContext(), ContactRemarkInfoModUI.class);
        ((Intent)localObject).putExtra("Contact_Scene", ContactRemarkInfoViewUI.c(ContactRemarkInfoViewUI.this));
        ((Intent)localObject).putExtra("Contact_User", ContactRemarkInfoViewUI.d(ContactRemarkInfoViewUI.this).field_username);
        paramAnonymousMenuItem = ContactRemarkInfoViewUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/contact/ContactRemarkInfoViewUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
    this.kgm = getIntent().getIntExtra("Contact_Scene", 9);
    this.username = getIntent().getStringExtra("Contact_User");
    if (Util.isNullOrNil(this.username))
    {
      finish();
      AppMethodBeat.o(37809);
      return;
    }
    amZ();
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
    amZ();
    this.PUI.setText(l.b(this, Util.nullAsNil(this.cgo), this.PUI.getTextSize()));
    if (!Util.isNullOrNil(this.fuR))
    {
      this.PVn.setVisibility(0);
      this.PUJ.setText(Util.nullAsNil(this.fuR));
    }
    while (!Util.isNullOrNil(this.jid))
    {
      this.PVo.setVisibility(0);
      com.tencent.mm.bd.c.bez();
      if (!com.tencent.mm.bd.c.Ps(this.username))
      {
        com.tencent.mm.bd.c.bez().a(this.username, this.jid, new c.a()
        {
          public final void fI(final boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(37808);
            ContactRemarkInfoViewUI.f(ContactRemarkInfoViewUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(37807);
                if (!paramAnonymousBoolean)
                {
                  h.cD(ContactRemarkInfoViewUI.this, ContactRemarkInfoViewUI.this.getString(2131755804));
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
        this.PVn.setVisibility(8);
      }
      else
      {
        gUB();
        AppMethodBeat.o(37810);
        return;
      }
    }
    this.PVo.setVisibility(8);
    AppMethodBeat.o(37810);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoViewUI
 * JD-Core Version:    0.7.0.1
 */