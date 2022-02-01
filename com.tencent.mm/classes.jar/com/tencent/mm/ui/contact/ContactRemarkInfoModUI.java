package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.w;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView;
import com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.cai;
import com.tencent.mm.protocal.protobuf.cki;
import com.tencent.mm.protocal.protobuf.ckj;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactRemarkInfoModUI
  extends MMActivity
  implements com.tencent.mm.al.f
{
  private String Fgx;
  private boolean KlA;
  private boolean KlB;
  private boolean KlC;
  private boolean KlD;
  private a KlE;
  private MMTagPanel KlF;
  private TextView KlG;
  private List<String> KlH;
  private ProfileEditPhoneNumberView KlI;
  private String KlJ;
  private String KlK;
  private TextWatcher KlL;
  private b KlM;
  private String KlN;
  private n.b KlO;
  boolean KlP;
  boolean KlQ;
  private boolean KlR;
  private MMClearEditText Klm;
  private TextView Kln;
  private MMEditText Klo;
  private TextView Klp;
  private TextView Klq;
  private TextView Klr;
  private TextView Kls;
  private ImageView Klt;
  private ImageView Klu;
  private TextView Klv;
  private View Klw;
  private View Klx;
  private String Kly;
  private boolean Klz;
  private String bVG;
  private am contact;
  private String ePD;
  private ProgressDialog hNi;
  private String ikc;
  private int jfq;
  private String uXt;
  private String username;
  
  public ContactRemarkInfoModUI()
  {
    AppMethodBeat.i(37771);
    this.Klz = false;
    this.KlA = false;
    this.KlB = false;
    this.KlC = false;
    this.KlD = false;
    this.KlE = new a((byte)0);
    this.KlL = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(37749);
        ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this);
        AppMethodBeat.o(37749);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.KlM = new b((byte)0);
    this.KlO = new n.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(37758);
        ad.d("MiroMsg.ContactRemarkInfoModUI", "cpan onNotifyChange");
        ContactRemarkInfoModUI.d(ContactRemarkInfoModUI.this);
        AppMethodBeat.o(37758);
      }
    };
    this.KlP = true;
    this.KlQ = false;
    this.KlR = false;
    AppMethodBeat.o(37771);
  }
  
  private void Y(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(37777);
    if (this.KlB)
    {
      this.Klp.setVisibility(8);
      if ((paramBoolean) && (af.isNullOrNil(this.ePD)))
      {
        this.Klq.setVisibility(0);
        this.Klx.setVisibility(8);
      }
      for (;;)
      {
        this.Klm.setVisibility(0);
        AppMethodBeat.o(37777);
        return;
        if (paramInt == 2131298634)
        {
          this.Klq.setVisibility(8);
          this.Klx.setVisibility(0);
        }
      }
    }
    this.Klp.setVisibility(0);
    this.Klq.setVisibility(0);
    this.Klm.setVisibility(8);
    this.Klx.setVisibility(8);
    AppMethodBeat.o(37777);
  }
  
  private void YW()
  {
    AppMethodBeat.i(37772);
    ProfileEditPhoneNumberView localProfileEditPhoneNumberView = this.KlI;
    Object localObject = localProfileEditPhoneNumberView.getPhoneNumberList();
    boolean bool;
    if ((localObject == null) || (((ArrayList)localObject).isEmpty()))
    {
      if (localProfileEditPhoneNumberView.ETx == null) {
        break label166;
      }
      bool = true;
    }
    for (;;)
    {
      this.KlR = bool;
      if ((!fHR()) && (!fHS()) && (!ym(false)) && (!this.KlR)) {
        break;
      }
      enableOptionMenu(true);
      AppMethodBeat.o(37772);
      return;
      if (localProfileEditPhoneNumberView.ETx == null)
      {
        bool = true;
      }
      else if (((ArrayList)localObject).size() != localProfileEditPhoneNumberView.ETx.length)
      {
        bool = true;
      }
      else
      {
        localObject = ((ArrayList)localObject).iterator();
        int i = 0;
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label166;
          }
          if (!((String)((Iterator)localObject).next()).equals(localProfileEditPhoneNumberView.ETx[i]))
          {
            bool = true;
            break;
          }
          i += 1;
        }
        label166:
        bool = false;
      }
    }
    enableOptionMenu(false);
    AppMethodBeat.o(37772);
  }
  
  private void aWP(String paramString)
  {
    AppMethodBeat.i(37781);
    if (af.isNullOrNil(paramString))
    {
      AppMethodBeat.o(37781);
      return;
    }
    paramString = new e(paramString);
    if (!paramString.exists())
    {
      AppMethodBeat.o(37781);
      return;
    }
    if (paramString.length() > 204800L)
    {
      h.c(this, getString(2131757625), null, true);
      AppMethodBeat.o(37781);
      return;
    }
    float f = com.tencent.mm.cc.a.getDensity(this);
    paramString = BackwardSupportUtil.b.o(this.Kly, f);
    if (paramString != null)
    {
      this.Klr.setVisibility(8);
      this.Klu.setVisibility(8);
      this.Klt.setVisibility(0);
      this.Klt.setImageBitmap(paramString);
      this.Klz = true;
    }
    AppMethodBeat.o(37781);
  }
  
  private String aWQ(String paramString)
  {
    AppMethodBeat.i(37791);
    if (!i.fv(paramString))
    {
      AppMethodBeat.o(37791);
      return null;
    }
    int i = BackwardSupportUtil.ExifHelper.cY(paramString);
    Object localObject = new StringBuilder();
    com.tencent.mm.be.c.aKd();
    localObject = com.tencent.mm.be.c.Gd(this.username) + ".tmp";
    if (!g.a(paramString, 960, 960, Bitmap.CompressFormat.JPEG, 70, (String)localObject))
    {
      ad.e("MiroMsg.ContactRemarkInfoModUI", "createThumbNail big pic fail");
      AppMethodBeat.o(37791);
      return null;
    }
    if ((i != 0) && (!g.a((String)localObject, i, Bitmap.CompressFormat.JPEG, 70, (String)localObject)))
    {
      ad.e("MiroMsg.ContactRemarkInfoModUI", "rotate big pic fail");
      AppMethodBeat.o(37791);
      return null;
    }
    AppMethodBeat.o(37791);
    return localObject;
  }
  
  private void fHO()
  {
    AppMethodBeat.i(37779);
    this.Kln.setFocusableInTouchMode(true);
    this.Kln.requestFocus();
    this.Klm.clearFocus();
    this.Klo.clearFocus();
    this.KlI.clearFocus();
    hideVKB();
    AppMethodBeat.o(37779);
  }
  
  private void fHP()
  {
    AppMethodBeat.i(37780);
    com.tencent.mm.be.c.aKd();
    Bitmap localBitmap = com.tencent.mm.be.c.Gg(this.username);
    if (localBitmap != null)
    {
      this.Klr.setVisibility(8);
      this.Klu.setVisibility(8);
      this.Klt.setVisibility(0);
      this.Klt.setImageBitmap(localBitmap);
    }
    this.Klz = true;
    AppMethodBeat.o(37780);
  }
  
  private void fHQ()
  {
    AppMethodBeat.i(37782);
    if (!this.KlR)
    {
      AppMethodBeat.o(37782);
      return;
    }
    Object localObject2 = new cai();
    ((cai)localObject2).GUK = this.username;
    ckj localckj = new ckj();
    localckj.HdV = new LinkedList();
    Object localObject3 = this.KlI.getPhoneNumberList();
    Object localObject1 = new ArrayList();
    if (localObject3 != null)
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        if (com.tencent.mm.plugin.bbom.c.Wx(str))
        {
          cki localcki = new cki();
          localcki.HdU = str;
          localckj.HdV.add(localcki);
          ((ArrayList)localObject1).add(str);
        }
      }
    }
    localckj.nDi = ((ArrayList)localObject1).size();
    ((cai)localObject2).GUC = localckj;
    ba.aBQ();
    com.tencent.mm.model.c.azo().c(new k.a(60, (com.tencent.mm.bx.a)localObject2));
    ba.aBQ();
    localObject2 = com.tencent.mm.model.c.azp().Bf(this.username);
    if ((localObject2 != null) && ((int)((com.tencent.mm.o.b)localObject2).gfj > 0) && (com.tencent.mm.o.b.lM(((aw)localObject2).field_type)))
    {
      localObject1 = com.tencent.mm.o.a.h((ArrayList)localObject1);
      ad.i("MiroMsg.ContactRemarkInfoModUI", "[dealModPhoneNumberList] username:%s %s", new Object[] { this.username, localObject1 });
      this.contact.tx((String)localObject1);
      com.tencent.mm.o.a.g(this.contact);
      ba.aBQ();
      com.tencent.mm.model.c.azp().af(this.contact);
    }
    AppMethodBeat.o(37782);
  }
  
  private boolean fHR()
  {
    AppMethodBeat.i(37784);
    String str = this.Klo.getText().toString();
    if (((this.ePD == null) || (!this.ePD.equals(str))) && ((!af.isNullOrNil(this.ePD)) || (!af.isNullOrNil(str))))
    {
      AppMethodBeat.o(37784);
      return true;
    }
    AppMethodBeat.o(37784);
    return false;
  }
  
  private boolean fHS()
  {
    AppMethodBeat.i(37785);
    if ((!af.isNullOrNil(this.Kly)) || (this.KlD))
    {
      AppMethodBeat.o(37785);
      return true;
    }
    AppMethodBeat.o(37785);
    return false;
  }
  
  private void fHT()
  {
    AppMethodBeat.i(37789);
    this.KlD = true;
    this.Klu.setVisibility(8);
    this.Klr.setVisibility(0);
    this.Klt.setVisibility(8);
    this.Klt.setImageBitmap(null);
    YW();
    AppMethodBeat.o(37789);
  }
  
  private void fHU()
  {
    AppMethodBeat.i(37792);
    if (!af.isNullOrNil(this.uXt))
    {
      this.KlF.setVisibility(0);
      this.KlG.setVisibility(8);
      this.KlF.a(this.KlH, this.KlH);
      AppMethodBeat.o(37792);
      return;
    }
    this.KlF.setVisibility(8);
    this.KlG.setVisibility(0);
    AppMethodBeat.o(37792);
  }
  
  private void fHV()
  {
    AppMethodBeat.i(37793);
    ba.aBQ();
    this.contact = com.tencent.mm.model.c.azp().Bf(this.username);
    this.uXt = this.contact.field_contactLabelIds;
    this.KlH = com.tencent.mm.plugin.label.a.a.dfo().aoo(this.uXt);
    fHU();
    AppMethodBeat.o(37793);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(37786);
    boolean bool1 = fHS();
    boolean bool2 = ym(true);
    boolean bool3 = fHR();
    if ((bool1) || (bool2) || (bool3))
    {
      h.e(this, getString(2131757789), null, getString(2131757791), getString(2131757790), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(37756);
          ContactRemarkInfoModUI.p(ContactRemarkInfoModUI.this);
          AppMethodBeat.o(37756);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(37757);
          ContactRemarkInfoModUI.this.finish();
          AppMethodBeat.o(37757);
        }
      });
      AppMethodBeat.o(37786);
      return;
    }
    hideVKB();
    finish();
    AppMethodBeat.o(37786);
  }
  
  private boolean ym(boolean paramBoolean)
  {
    AppMethodBeat.i(37783);
    String str = this.Klm.getText().toString();
    if (!paramBoolean)
    {
      if (((this.bVG == null) || (!this.bVG.equals(str))) && ((!af.isNullOrNil(this.bVG)) || (!af.isNullOrNil(str))))
      {
        AppMethodBeat.o(37783);
        return true;
      }
      AppMethodBeat.o(37783);
      return false;
    }
    if (((this.bVG == null) || (!this.bVG.equals(str))) && ((!af.isNullOrNil(this.bVG)) || (!af.isNullOrNil(str)))) {}
    for (int i = 1; (i != 0) && ((str == null) || (!str.equals(this.contact.field_nickname))); i = 0)
    {
      AppMethodBeat.o(37783);
      return true;
    }
    AppMethodBeat.o(37783);
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131493656;
  }
  
  public void initView()
  {
    AppMethodBeat.i(37778);
    this.Kln = ((TextView)findViewById(2131298628));
    this.Klp = ((TextView)findViewById(2131298636));
    this.Klq = ((TextView)findViewById(2131298634));
    this.Klr = ((TextView)findViewById(2131298635));
    this.Klm = ((MMClearEditText)findViewById(2131298627));
    this.Klo = ((MMEditText)findViewById(2131298626));
    this.Klt = ((ImageView)findViewById(2131303983));
    this.Klu = ((ImageView)findViewById(2131303984));
    this.Kls = ((TextView)findViewById(2131307005));
    this.Klx = findViewById(2131298625);
    this.KlI = ((ProfileEditPhoneNumberView)findViewById(2131302418));
    this.KlI.pMt = this.contact;
    Object localObject1 = this.KlI;
    Object localObject2 = this.KlJ;
    String str = this.KlK;
    ((ProfileEditPhoneNumberView)localObject1).ETv = ((String)localObject2);
    ((ProfileEditPhoneNumberView)localObject1).ETw = str;
    ((ProfileEditPhoneNumberView)localObject1).dBj();
    this.KlI.ETA = new ProfileEditPhoneNumberView.a()
    {
      public final void fbY()
      {
        AppMethodBeat.i(37760);
        w.w(ContactRemarkInfoModUI.e(ContactRemarkInfoModUI.this));
        p.aJx().pM(7);
        AppMethodBeat.o(37760);
      }
      
      public final void onChange()
      {
        AppMethodBeat.i(37759);
        ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this);
        AppMethodBeat.o(37759);
      }
    };
    this.KlF = ((MMTagPanel)findViewById(2131298623));
    this.KlF.setPanelClickable(false);
    this.KlG = ((TextView)findViewById(2131298621));
    this.KlG.setText(2131761304);
    this.KlF.setOnClickListener(this.KlE);
    this.KlG.setOnClickListener(this.KlE);
    setMMTitle(2131757731);
    label620:
    int i;
    if (!af.isNullOrNil(this.bVG))
    {
      this.Klm.setText(k.b(this, af.nullAsNil(this.bVG), this.Klm.getTextSize()));
      this.Klp.setText(k.b(this, af.nullAsNil(this.bVG), this.Klp.getTextSize()));
      this.Klm.setSelection(this.Klm.getText().length());
      localObject1 = k.b(this, af.nullAsNil(this.ePD), this.Klq.getTextSize());
      this.Klo.setText((CharSequence)localObject1);
      this.Klo.setSelection(this.Klo.getText().length());
      if (!af.isNullOrNil(this.ePD))
      {
        this.Klq.setText(k.b(this, af.nullAsNil(this.ePD), this.Klq.getTextSize()));
        this.Klq.setTextColor(getContext().getResources().getColor(2131099732));
      }
      this.Klp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37761);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ContactRemarkInfoModUI.f(ContactRemarkInfoModUI.this);
          ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, false, paramAnonymousView.getId());
          ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).performClick();
          ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).requestFocus();
          ContactRemarkInfoModUI.this.showVKB();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37761);
        }
      });
      this.Klq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37762);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ContactRemarkInfoModUI.f(ContactRemarkInfoModUI.this);
          ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, false, paramAnonymousView.getId());
          ContactRemarkInfoModUI.h(ContactRemarkInfoModUI.this).performClick();
          ContactRemarkInfoModUI.h(ContactRemarkInfoModUI.this).requestFocus();
          ContactRemarkInfoModUI.this.showVKB();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37762);
        }
      });
      this.Klm.addTextChangedListener(this.KlL);
      this.Kls.setText(com.tencent.mm.ui.tools.f.cU(800, this.Klo.getEditableText().toString()));
      this.Klo.addTextChangedListener(this.KlM);
      if (af.isNullOrNil(this.ikc)) {
        break label904;
      }
      this.Klr.setVisibility(8);
      this.Klt.setVisibility(0);
      com.tencent.mm.be.c.aKd();
      if (com.tencent.mm.be.c.Ge(this.username)) {
        break label897;
      }
      com.tencent.mm.be.c.aKd().a(this.username, this.ikc, new com.tencent.mm.be.c.a()
      {
        public final void eP(final boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(37754);
          ContactRemarkInfoModUI.t(ContactRemarkInfoModUI.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(37753);
              if (!paramAnonymousBoolean)
              {
                h.cl(ContactRemarkInfoModUI.this, ContactRemarkInfoModUI.this.getString(2131755733));
                ContactRemarkInfoModUI.r(ContactRemarkInfoModUI.this).setVisibility(0);
                ContactRemarkInfoModUI.s(ContactRemarkInfoModUI.this).setVisibility(8);
                ContactRemarkInfoModUI.t(ContactRemarkInfoModUI.this).setVisibility(8);
                AppMethodBeat.o(37753);
                return;
              }
              ContactRemarkInfoModUI.u(ContactRemarkInfoModUI.this);
              AppMethodBeat.o(37753);
            }
          });
          AppMethodBeat.o(37754);
        }
      });
      this.Klt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37763);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          if (!ContactRemarkInfoModUI.i(ContactRemarkInfoModUI.this))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37763);
            return;
          }
          ContactRemarkInfoModUI.j(ContactRemarkInfoModUI.this);
          localObject = new Intent(ContactRemarkInfoModUI.this, ContactRemarkImagePreviewUI.class);
          ((Intent)localObject).putExtra("Contact_User", ContactRemarkInfoModUI.k(ContactRemarkInfoModUI.this));
          if ((!af.isNullOrNil(ContactRemarkInfoModUI.l(ContactRemarkInfoModUI.this))) && (!ContactRemarkInfoModUI.m(ContactRemarkInfoModUI.this))) {
            com.tencent.mm.be.c.aKd();
          }
          for (paramAnonymousView = com.tencent.mm.be.c.Gd(ContactRemarkInfoModUI.k(ContactRemarkInfoModUI.this));; paramAnonymousView = ContactRemarkInfoModUI.n(ContactRemarkInfoModUI.this))
          {
            ((Intent)localObject).putExtra("remark_image_path", paramAnonymousView);
            ((Intent)localObject).putExtra("view_temp_remark_image", ContactRemarkInfoModUI.m(ContactRemarkInfoModUI.this));
            ContactRemarkInfoModUI.this.startActivityForResult((Intent)localObject, 400);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37763);
            return;
          }
        }
      });
      this.Klr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37764);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if ((af.isNullOrNil(ContactRemarkInfoModUI.l(ContactRemarkInfoModUI.this))) || (ContactRemarkInfoModUI.o(ContactRemarkInfoModUI.this)))
          {
            ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, false);
            ContactRemarkInfoModUI.j(ContactRemarkInfoModUI.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37764);
        }
      });
      localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Ju(this.contact.field_username);
      if ((localObject1 != null) && (!af.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aSy())) && (!((com.tencent.mm.plugin.account.friend.a.a)localObject1).aSy().equals(this.Klm.getText().toString()))) {
        break label924;
      }
      i = 0;
      label700:
      if ((i == 0) && (this.jfq == 14) && (!af.isNullOrNil(this.Fgx)) && (!this.Fgx.equals(this.Klm.getText().toString()))) {
        break label1056;
      }
      label743:
      addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(37765);
          ContactRemarkInfoModUI.p(ContactRemarkInfoModUI.this);
          ContactRemarkInfoModUI.this.hideVKB();
          AppMethodBeat.o(37765);
          return false;
        }
      }, null, s.b.JbS);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(37766);
          ContactRemarkInfoModUI.q(ContactRemarkInfoModUI.this);
          AppMethodBeat.o(37766);
          return true;
        }
      });
      if (!af.isNullOrNil(this.bVG)) {
        break label1197;
      }
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.Klu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37750);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, true);
          ContactRemarkInfoModUI.j(ContactRemarkInfoModUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37750);
        }
      });
      if (!this.KlC)
      {
        this.KlB = true;
        Y(true, -1);
      }
      fHO();
      AppMethodBeat.o(37778);
      return;
      this.Klm.setText(k.b(this, af.nullAsNil(this.contact.adu()), this.Klm.getTextSize()));
      this.Klp.setText(k.b(this, af.nullAsNil(this.contact.adu()), this.Klm.getTextSize()));
      break;
      label897:
      fHP();
      break label620;
      label904:
      this.Klr.setVisibility(0);
      this.Klt.setVisibility(8);
      break label620;
      label924:
      this.Klv = ((TextView)findViewById(2131302425));
      this.Klw = findViewById(2131302419);
      this.Klw.setVisibility(0);
      this.Klv.setText(af.nullAsNil(getString(2131757816, new Object[] { ((com.tencent.mm.plugin.account.friend.a.a)localObject1).aSy() })));
      localObject2 = new l(getString(2131766242));
      ((l)localObject2).setSpan(new c(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aSy()), 0, ((l)localObject2).length(), 17);
      this.Klv.append(" ");
      this.Klv.append((CharSequence)localObject2);
      this.Klv.setMovementMethod(LinkMovementMethod.getInstance());
      i = 1;
      break label700;
      label1056:
      this.Klv = ((TextView)findViewById(2131302425));
      this.Klw = findViewById(2131302419);
      this.Klw.setVisibility(0);
      this.Klv.setText(k.b(this, af.nullAsNil(getString(2131757815, new Object[] { this.Fgx })), this.Klv.getTextSize()));
      localObject1 = new l(getString(2131766242));
      ((l)localObject1).setSpan(new c(this.Fgx), 0, ((l)localObject1).length(), 17);
      this.Klv.append(" ");
      this.Klv.append((CharSequence)localObject1);
      this.Klv.setMovementMethod(LinkMovementMethod.getInstance());
      break label743;
      label1197:
      enableOptionMenu(false);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(37788);
    ad.i("MiroMsg.ContactRemarkInfoModUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent == null)
    {
      ad.e("MiroMsg.ContactRemarkInfoModUI", "data shouldnot be null");
      AppMethodBeat.o(37788);
      return;
    }
    Context localContext;
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(37788);
      return;
    case 100: 
      localContext = getApplicationContext();
      ba.aBQ();
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.q.i(localContext, paramIntent, com.tencent.mm.model.c.azA());
      if (paramIntent == null)
      {
        AppMethodBeat.o(37788);
        return;
      }
      this.Kly = aWQ(paramIntent);
      aWP(this.Kly);
      this.KlA = true;
      this.KlD = false;
      YW();
      AppMethodBeat.o(37788);
      return;
    case 200: 
      localContext = getApplicationContext();
      ba.aBQ();
      paramIntent = com.tencent.mm.ui.tools.a.j(localContext, paramIntent, com.tencent.mm.model.c.azA());
      if (paramIntent == null)
      {
        AppMethodBeat.o(37788);
        return;
      }
      this.Kly = aWQ(paramIntent);
      aWP(this.Kly);
      this.KlA = true;
      this.KlD = false;
      YW();
      AppMethodBeat.o(37788);
      return;
    case 400: 
      if (paramIntent.getBooleanExtra("response_delete", false)) {
        fHT();
      }
      AppMethodBeat.o(37788);
      return;
    }
    if ((ym(true)) || (fHR()) || (fHS()) || (paramIntent.getBooleanExtra("hasLableChange", false)))
    {
      enableOptionMenu(true);
      AppMethodBeat.o(37788);
      return;
    }
    enableOptionMenu(false);
    AppMethodBeat.o(37788);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(37773);
    super.onCreate(paramBundle);
    ba.aiU().a(575, this);
    ba.aiU().a(576, this);
    this.jfq = getIntent().getIntExtra("Contact_Scene", 9);
    this.Fgx = getIntent().getStringExtra("Contact_RoomNickname");
    this.KlC = getIntent().getBooleanExtra("view_mode", false);
    this.KlN = getIntent().getStringExtra("contact_auto_app_phone_from_chatting");
    this.KlJ = getIntent().getStringExtra("contact_phone_number_by_md5");
    this.KlK = getIntent().getStringExtra("contact_phone_number_list");
    this.username = getIntent().getStringExtra("Contact_User");
    if (af.isNullOrNil(this.username))
    {
      finish();
      AppMethodBeat.o(37773);
      return;
    }
    ba.aBQ();
    this.contact = com.tencent.mm.model.c.azp().Bf(this.username);
    this.bVG = this.contact.field_conRemark;
    this.ePD = this.contact.ePD;
    this.ikc = this.contact.ePE;
    this.uXt = this.contact.field_contactLabelIds;
    this.KlH = com.tencent.mm.plugin.label.a.a.dfo().aoo(this.uXt);
    initView();
    YW();
    int i;
    if ((this.contact != null) && (am.aSQ(this.contact.field_username))) {
      i = 1;
    }
    while (i != 0) {
      if (this.Klm == null)
      {
        AppMethodBeat.o(37773);
        return;
        i = 0;
      }
      else
      {
        paramBundle = (ViewGroup)this.Klm.getParent();
        ViewGroup localViewGroup = (ViewGroup)paramBundle.getParent();
        int k = localViewGroup.getChildCount();
        i = j;
        while (i < k)
        {
          View localView = localViewGroup.getChildAt(i);
          if (localView != paramBundle) {
            localView.setVisibility(8);
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(37773);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(37776);
    ba.aiU().b(575, this);
    ba.aiU().b(576, this);
    this.Klm.removeTextChangedListener(this.KlL);
    this.Klo.removeTextChangedListener(this.KlM);
    super.onDestroy();
    AppMethodBeat.o(37776);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(37787);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      goBack();
      AppMethodBeat.o(37787);
      return true;
    }
    AppMethodBeat.o(37787);
    return false;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(37775);
    ba.aBQ();
    com.tencent.mm.model.c.azp().b(this.KlO);
    super.onPause();
    AppMethodBeat.o(37775);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(37774);
    super.onResume();
    ba.aBQ();
    com.tencent.mm.model.c.azp().a(this.KlO);
    fHV();
    AppMethodBeat.o(37774);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(37790);
    ad.i("MiroMsg.ContactRemarkInfoModUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.hNi != null)
    {
      this.hNi.dismiss();
      this.hNi = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      h.c(this, getString(2131755732), null, true);
      AppMethodBeat.o(37790);
      return;
    }
    if (paramn.getType() == 575)
    {
      if (this.Kly != null)
      {
        paramString = new e(this.Kly);
        if (paramString.exists())
        {
          com.tencent.mm.be.c.aKd();
          paramString.ag(new e(com.tencent.mm.be.c.Gd(this.username)));
        }
      }
      paramString = ((com.tencent.mm.be.b)paramn).ikc;
      if (!af.isNullOrNil(paramString)) {
        this.ikc = paramString;
      }
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(37790);
      return;
      if (paramn.getType() == 576)
      {
        this.Kly = null;
        this.ikc = null;
        this.Klz = false;
        ba.aBQ();
        this.contact = com.tencent.mm.model.c.azp().Bf(this.username);
        this.contact.ts("");
        ba.aBQ();
        com.tencent.mm.model.c.azp().c(this.username, this.contact);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements View.OnClickListener
  {
    private a() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(37767);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$LabelEditOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      ContactRemarkInfoModUI.c(ContactRemarkInfoModUI.this);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$LabelEditOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(37767);
    }
  }
  
  final class b
    implements TextWatcher
  {
    private String KlU = "";
    private int yDX = 800;
    
    private b() {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(37768);
      this.yDX = com.tencent.mm.ui.tools.f.cU(800, paramEditable.toString());
      if (this.yDX < 0) {
        this.yDX = 0;
      }
      if (ContactRemarkInfoModUI.b(ContactRemarkInfoModUI.this) != null) {
        ContactRemarkInfoModUI.b(ContactRemarkInfoModUI.this).setText(this.yDX);
      }
      ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this);
      AppMethodBeat.o(37768);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  final class c
    extends ClickableSpan
  {
    public String iTM;
    
    public c(String paramString)
    {
      this.iTM = paramString;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(37769);
      ContactRemarkInfoModUI.f(ContactRemarkInfoModUI.this);
      ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, true, -1);
      ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).setText(k.b(ContactRemarkInfoModUI.this, af.nullAsNil(this.iTM), ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).getTextSize()));
      ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).setSelection(ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).getText().length());
      ContactRemarkInfoModUI.w(ContactRemarkInfoModUI.this).setVisibility(8);
      AppMethodBeat.o(37769);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(37770);
      paramTextPaint.setColor(ContactRemarkInfoModUI.this.getResources().getColor(2131100027));
      paramTextPaint.setUnderlineText(false);
      AppMethodBeat.o(37770);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI
 * JD-Core Version:    0.7.0.1
 */