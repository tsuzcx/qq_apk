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
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.x;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView;
import com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.cbc;
import com.tencent.mm.protocal.protobuf.clc;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactRemarkInfoModUI
  extends MMActivity
  implements com.tencent.mm.ak.f
{
  private String FyV;
  private MMClearEditText KHG;
  private TextView KHH;
  private MMEditText KHI;
  private TextView KHJ;
  private TextView KHK;
  private TextView KHL;
  private TextView KHM;
  private ImageView KHN;
  private ImageView KHO;
  private TextView KHP;
  private View KHQ;
  private View KHR;
  private String KHS;
  private boolean KHT;
  private boolean KHU;
  private boolean KHV;
  private boolean KHW;
  private boolean KHX;
  private a KHY;
  private MMTagPanel KHZ;
  private TextView KIa;
  private List<String> KIb;
  private ProfileEditPhoneNumberView KIc;
  private String KId;
  private String KIe;
  private TextWatcher KIf;
  private b KIg;
  private String KIh;
  private n.b KIi;
  boolean KIj;
  boolean KIk;
  private boolean KIl;
  private String bVG;
  private an contact;
  private String eRo;
  private ProgressDialog hQb;
  private String imV;
  private int jij;
  private String username;
  private String vjh;
  
  public ContactRemarkInfoModUI()
  {
    AppMethodBeat.i(37771);
    this.KHT = false;
    this.KHU = false;
    this.KHV = false;
    this.KHW = false;
    this.KHX = false;
    this.KHY = new a((byte)0);
    this.KIf = new TextWatcher()
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
    this.KIg = new b((byte)0);
    this.KIi = new n.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(37758);
        ae.d("MiroMsg.ContactRemarkInfoModUI", "cpan onNotifyChange");
        ContactRemarkInfoModUI.d(ContactRemarkInfoModUI.this);
        AppMethodBeat.o(37758);
      }
    };
    this.KIj = true;
    this.KIk = false;
    this.KIl = false;
    AppMethodBeat.o(37771);
  }
  
  private void Zf()
  {
    AppMethodBeat.i(37772);
    ProfileEditPhoneNumberView localProfileEditPhoneNumberView = this.KIc;
    Object localObject = localProfileEditPhoneNumberView.getPhoneNumberList();
    boolean bool;
    if ((localObject == null) || (((ArrayList)localObject).isEmpty()))
    {
      if (localProfileEditPhoneNumberView.FlS == null) {
        break label166;
      }
      bool = true;
    }
    for (;;)
    {
      this.KIl = bool;
      if ((!fMj()) && (!fMk()) && (!yz(false)) && (!this.KIl)) {
        break;
      }
      enableOptionMenu(true);
      AppMethodBeat.o(37772);
      return;
      if (localProfileEditPhoneNumberView.FlS == null)
      {
        bool = true;
      }
      else if (((ArrayList)localObject).size() != localProfileEditPhoneNumberView.FlS.length)
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
          if (!((String)((Iterator)localObject).next()).equals(localProfileEditPhoneNumberView.FlS[i]))
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
  
  private void aYq(String paramString)
  {
    AppMethodBeat.i(37781);
    if (af.isNullOrNil(paramString))
    {
      AppMethodBeat.o(37781);
      return;
    }
    paramString = new com.tencent.mm.vfs.k(paramString);
    if (!paramString.exists())
    {
      AppMethodBeat.o(37781);
      return;
    }
    if (paramString.length() > 204800L)
    {
      com.tencent.mm.ui.base.h.c(this, getString(2131757625), null, true);
      AppMethodBeat.o(37781);
      return;
    }
    float f = com.tencent.mm.cb.a.getDensity(this);
    paramString = BackwardSupportUtil.b.p(this.KHS, f);
    if (paramString != null)
    {
      this.KHL.setVisibility(8);
      this.KHO.setVisibility(8);
      this.KHN.setVisibility(0);
      this.KHN.setImageBitmap(paramString);
      this.KHT = true;
    }
    AppMethodBeat.o(37781);
  }
  
  private String aYr(String paramString)
  {
    AppMethodBeat.i(37791);
    if (!o.fB(paramString))
    {
      AppMethodBeat.o(37791);
      return null;
    }
    int i = BackwardSupportUtil.ExifHelper.df(paramString);
    Object localObject = new StringBuilder();
    com.tencent.mm.bd.c.aKw();
    localObject = com.tencent.mm.bd.c.GF(this.username) + ".tmp";
    if (!com.tencent.mm.sdk.platformtools.h.a(paramString, 960, 960, Bitmap.CompressFormat.JPEG, 70, (String)localObject))
    {
      ae.e("MiroMsg.ContactRemarkInfoModUI", "createThumbNail big pic fail");
      AppMethodBeat.o(37791);
      return null;
    }
    if ((i != 0) && (!com.tencent.mm.sdk.platformtools.h.a((String)localObject, i, Bitmap.CompressFormat.JPEG, 70, (String)localObject)))
    {
      ae.e("MiroMsg.ContactRemarkInfoModUI", "rotate big pic fail");
      AppMethodBeat.o(37791);
      return null;
    }
    AppMethodBeat.o(37791);
    return localObject;
  }
  
  private void ac(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(37777);
    if (this.KHV)
    {
      this.KHJ.setVisibility(8);
      if ((paramBoolean) && (af.isNullOrNil(this.eRo)))
      {
        this.KHK.setVisibility(0);
        this.KHR.setVisibility(8);
      }
      for (;;)
      {
        this.KHG.setVisibility(0);
        AppMethodBeat.o(37777);
        return;
        if (paramInt == 2131298634)
        {
          this.KHK.setVisibility(8);
          this.KHR.setVisibility(0);
        }
      }
    }
    this.KHJ.setVisibility(0);
    this.KHK.setVisibility(0);
    this.KHG.setVisibility(8);
    this.KHR.setVisibility(8);
    AppMethodBeat.o(37777);
  }
  
  private void fMg()
  {
    AppMethodBeat.i(37779);
    this.KHH.setFocusableInTouchMode(true);
    this.KHH.requestFocus();
    this.KHG.clearFocus();
    this.KHI.clearFocus();
    this.KIc.clearFocus();
    hideVKB();
    AppMethodBeat.o(37779);
  }
  
  private void fMh()
  {
    AppMethodBeat.i(37780);
    com.tencent.mm.bd.c.aKw();
    Bitmap localBitmap = com.tencent.mm.bd.c.GI(this.username);
    if (localBitmap != null)
    {
      this.KHL.setVisibility(8);
      this.KHO.setVisibility(8);
      this.KHN.setVisibility(0);
      this.KHN.setImageBitmap(localBitmap);
    }
    this.KHT = true;
    AppMethodBeat.o(37780);
  }
  
  private void fMi()
  {
    AppMethodBeat.i(37782);
    if (!this.KIl)
    {
      AppMethodBeat.o(37782);
      return;
    }
    Object localObject2 = new cbc();
    ((cbc)localObject2).Hol = this.username;
    cld localcld = new cld();
    localcld.Hxv = new LinkedList();
    Object localObject3 = this.KIc.getPhoneNumberList();
    Object localObject1 = new ArrayList();
    if (localObject3 != null)
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        if (com.tencent.mm.plugin.bbom.c.Xj(str))
        {
          clc localclc = new clc();
          localclc.Hxu = str;
          localcld.Hxv.add(localclc);
          ((ArrayList)localObject1).add(str);
        }
      }
    }
    localcld.nID = ((ArrayList)localObject1).size();
    ((cbc)localObject2).Hod = localcld;
    bc.aCg();
    com.tencent.mm.model.c.azE().d(new k.a(60, (com.tencent.mm.bw.a)localObject2));
    bc.aCg();
    localObject2 = com.tencent.mm.model.c.azF().BH(this.username);
    if ((localObject2 != null) && ((int)((com.tencent.mm.contact.c)localObject2).ght > 0) && (com.tencent.mm.contact.c.lO(((aw)localObject2).field_type)))
    {
      localObject1 = com.tencent.mm.contact.a.h((ArrayList)localObject1);
      ae.i("MiroMsg.ContactRemarkInfoModUI", "[dealModPhoneNumberList] username:%s %s", new Object[] { this.username, localObject1 });
      this.contact.tS((String)localObject1);
      com.tencent.mm.contact.a.g(this.contact);
      bc.aCg();
      com.tencent.mm.model.c.azF().am(this.contact);
    }
    AppMethodBeat.o(37782);
  }
  
  private boolean fMj()
  {
    AppMethodBeat.i(37784);
    String str = this.KHI.getText().toString();
    if (((this.eRo == null) || (!this.eRo.equals(str))) && ((!af.isNullOrNil(this.eRo)) || (!af.isNullOrNil(str))))
    {
      AppMethodBeat.o(37784);
      return true;
    }
    AppMethodBeat.o(37784);
    return false;
  }
  
  private boolean fMk()
  {
    AppMethodBeat.i(37785);
    if ((!af.isNullOrNil(this.KHS)) || (this.KHX))
    {
      AppMethodBeat.o(37785);
      return true;
    }
    AppMethodBeat.o(37785);
    return false;
  }
  
  private void fMl()
  {
    AppMethodBeat.i(37789);
    this.KHX = true;
    this.KHO.setVisibility(8);
    this.KHL.setVisibility(0);
    this.KHN.setVisibility(8);
    this.KHN.setImageBitmap(null);
    Zf();
    AppMethodBeat.o(37789);
  }
  
  private void fMm()
  {
    AppMethodBeat.i(37792);
    if (!af.isNullOrNil(this.vjh))
    {
      this.KHZ.setVisibility(0);
      this.KIa.setVisibility(8);
      this.KHZ.a(this.KIb, this.KIb);
      AppMethodBeat.o(37792);
      return;
    }
    this.KHZ.setVisibility(8);
    this.KIa.setVisibility(0);
    AppMethodBeat.o(37792);
  }
  
  private void fMn()
  {
    AppMethodBeat.i(37793);
    bc.aCg();
    this.contact = com.tencent.mm.model.c.azF().BH(this.username);
    this.vjh = this.contact.field_contactLabelIds;
    this.KIb = com.tencent.mm.plugin.label.a.a.dig().apq(this.vjh);
    fMm();
    AppMethodBeat.o(37793);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(37786);
    boolean bool1 = fMk();
    boolean bool2 = yz(true);
    boolean bool3 = fMj();
    if ((bool1) || (bool2) || (bool3))
    {
      com.tencent.mm.ui.base.h.e(this, getString(2131757789), null, getString(2131757791), getString(2131757790), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
  
  private boolean yz(boolean paramBoolean)
  {
    AppMethodBeat.i(37783);
    String str = this.KHG.getText().toString();
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
    this.KHH = ((TextView)findViewById(2131298628));
    this.KHJ = ((TextView)findViewById(2131298636));
    this.KHK = ((TextView)findViewById(2131298634));
    this.KHL = ((TextView)findViewById(2131298635));
    this.KHG = ((MMClearEditText)findViewById(2131298627));
    this.KHI = ((MMEditText)findViewById(2131298626));
    this.KHN = ((ImageView)findViewById(2131303983));
    this.KHO = ((ImageView)findViewById(2131303984));
    this.KHM = ((TextView)findViewById(2131307005));
    this.KHR = findViewById(2131298625);
    this.KIc = ((ProfileEditPhoneNumberView)findViewById(2131302418));
    this.KIc.pSY = this.contact;
    Object localObject1 = this.KIc;
    Object localObject2 = this.KId;
    String str = this.KIe;
    ((ProfileEditPhoneNumberView)localObject1).FlQ = ((String)localObject2);
    ((ProfileEditPhoneNumberView)localObject1).FlR = str;
    ((ProfileEditPhoneNumberView)localObject1).dEA();
    this.KIc.FlV = new ProfileEditPhoneNumberView.a()
    {
      public final void ffM()
      {
        AppMethodBeat.i(37760);
        x.D(ContactRemarkInfoModUI.e(ContactRemarkInfoModUI.this));
        p.aJQ().pP(7);
        AppMethodBeat.o(37760);
      }
      
      public final void onChange()
      {
        AppMethodBeat.i(37759);
        ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this);
        AppMethodBeat.o(37759);
      }
    };
    this.KHZ = ((MMTagPanel)findViewById(2131298623));
    this.KHZ.setPanelClickable(false);
    this.KIa = ((TextView)findViewById(2131298621));
    this.KIa.setText(2131761304);
    this.KHZ.setOnClickListener(this.KHY);
    this.KIa.setOnClickListener(this.KHY);
    setMMTitle(2131757731);
    label621:
    int i;
    if (!af.isNullOrNil(this.bVG))
    {
      this.KHG.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, af.nullAsNil(this.bVG), this.KHG.getTextSize()));
      this.KHJ.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, af.nullAsNil(this.bVG), this.KHJ.getTextSize()));
      this.KHG.setSelection(this.KHG.getText().length());
      localObject1 = com.tencent.mm.pluginsdk.ui.span.k.b(this, af.nullAsNil(this.eRo), this.KHK.getTextSize());
      this.KHI.setText((CharSequence)localObject1);
      this.KHI.setSelection(this.KHI.getText().length());
      if (!af.isNullOrNil(this.eRo))
      {
        this.KHK.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, af.nullAsNil(this.eRo), this.KHK.getTextSize()));
        this.KHK.setTextColor(getContext().getResources().getColor(2131099732));
      }
      this.KHJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37761);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ContactRemarkInfoModUI.f(ContactRemarkInfoModUI.this);
          ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, false, paramAnonymousView.getId());
          ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).performClick();
          ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).requestFocus();
          ContactRemarkInfoModUI.this.showVKB();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37761);
        }
      });
      this.KHK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37762);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ContactRemarkInfoModUI.f(ContactRemarkInfoModUI.this);
          ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, false, paramAnonymousView.getId());
          ContactRemarkInfoModUI.h(ContactRemarkInfoModUI.this).performClick();
          ContactRemarkInfoModUI.h(ContactRemarkInfoModUI.this).requestFocus();
          ContactRemarkInfoModUI.this.showVKB();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37762);
        }
      });
      this.KHG.addTextChangedListener(this.KIf);
      this.KHM.setText(com.tencent.mm.ui.tools.f.cU(800, this.KHI.getEditableText().toString()));
      this.KHI.addTextChangedListener(this.KIg);
      if (af.isNullOrNil(this.imV)) {
        break label905;
      }
      this.KHL.setVisibility(8);
      this.KHN.setVisibility(0);
      com.tencent.mm.bd.c.aKw();
      if (com.tencent.mm.bd.c.GG(this.username)) {
        break label898;
      }
      com.tencent.mm.bd.c.aKw().a(this.username, this.imV, new com.tencent.mm.bd.c.a()
      {
        public final void eS(final boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(37754);
          ContactRemarkInfoModUI.t(ContactRemarkInfoModUI.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(37753);
              if (!paramAnonymousBoolean)
              {
                com.tencent.mm.ui.base.h.cm(ContactRemarkInfoModUI.this, ContactRemarkInfoModUI.this.getString(2131755733));
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
      this.KHN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37763);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
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
            com.tencent.mm.bd.c.aKw();
          }
          for (paramAnonymousView = com.tencent.mm.bd.c.GF(ContactRemarkInfoModUI.k(ContactRemarkInfoModUI.this));; paramAnonymousView = ContactRemarkInfoModUI.n(ContactRemarkInfoModUI.this))
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
      this.KHL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37764);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if ((af.isNullOrNil(ContactRemarkInfoModUI.l(ContactRemarkInfoModUI.this))) || (ContactRemarkInfoModUI.o(ContactRemarkInfoModUI.this)))
          {
            ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, false);
            ContactRemarkInfoModUI.j(ContactRemarkInfoModUI.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37764);
        }
      });
      localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().JT(this.contact.field_username);
      if ((localObject1 != null) && (!af.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aSX())) && (!((com.tencent.mm.plugin.account.friend.a.a)localObject1).aSX().equals(this.KHG.getText().toString()))) {
        break label925;
      }
      i = 0;
      label701:
      if ((i == 0) && (this.jij == 14) && (!af.isNullOrNil(this.FyV)) && (!this.FyV.equals(this.KHG.getText().toString()))) {
        break label1056;
      }
      label744:
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
      }, null, s.b.JwA);
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
        break label1196;
      }
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.KHO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37750);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, true);
          ContactRemarkInfoModUI.j(ContactRemarkInfoModUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37750);
        }
      });
      if (!this.KHW)
      {
        this.KHV = true;
        ac(true, -1);
      }
      fMg();
      AppMethodBeat.o(37778);
      return;
      this.KHG.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, af.nullAsNil(this.contact.adF()), this.KHG.getTextSize()));
      this.KHJ.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, af.nullAsNil(this.contact.adF()), this.KHG.getTextSize()));
      break;
      label898:
      fMh();
      break label621;
      label905:
      this.KHL.setVisibility(0);
      this.KHN.setVisibility(8);
      break label621;
      label925:
      this.KHP = ((TextView)findViewById(2131302425));
      this.KHQ = findViewById(2131302419);
      this.KHQ.setVisibility(0);
      this.KHP.setText(af.nullAsNil(getString(2131757816, new Object[] { ((com.tencent.mm.plugin.account.friend.a.a)localObject1).aSX() })));
      localObject2 = new l(getString(2131766242));
      ((l)localObject2).setSpan(new c(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aSX()), 0, ((l)localObject2).length(), 17);
      this.KHP.append(" ");
      this.KHP.append((CharSequence)localObject2);
      this.KHP.setMovementMethod(LinkMovementMethod.getInstance());
      i = 1;
      break label701;
      label1056:
      this.KHP = ((TextView)findViewById(2131302425));
      this.KHQ = findViewById(2131302419);
      this.KHQ.setVisibility(0);
      this.KHP.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, af.nullAsNil(getString(2131757815, new Object[] { this.FyV })), this.KHP.getTextSize()));
      localObject1 = new l(getString(2131766242));
      ((l)localObject1).setSpan(new c(this.FyV), 0, ((l)localObject1).length(), 17);
      this.KHP.append(" ");
      this.KHP.append((CharSequence)localObject1);
      this.KHP.setMovementMethod(LinkMovementMethod.getInstance());
      break label744;
      label1196:
      enableOptionMenu(false);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(37788);
    ae.i("MiroMsg.ContactRemarkInfoModUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent == null)
    {
      ae.e("MiroMsg.ContactRemarkInfoModUI", "data shouldnot be null");
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
      bc.aCg();
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.q.i(localContext, paramIntent, com.tencent.mm.model.c.azQ());
      if (paramIntent == null)
      {
        AppMethodBeat.o(37788);
        return;
      }
      this.KHS = aYr(paramIntent);
      aYq(this.KHS);
      this.KHU = true;
      this.KHX = false;
      Zf();
      AppMethodBeat.o(37788);
      return;
    case 200: 
      localContext = getApplicationContext();
      bc.aCg();
      paramIntent = com.tencent.mm.ui.tools.a.j(localContext, paramIntent, com.tencent.mm.model.c.azQ());
      if (paramIntent == null)
      {
        AppMethodBeat.o(37788);
        return;
      }
      this.KHS = aYr(paramIntent);
      aYq(this.KHS);
      this.KHU = true;
      this.KHX = false;
      Zf();
      AppMethodBeat.o(37788);
      return;
    case 400: 
      if (paramIntent.getBooleanExtra("response_delete", false)) {
        fMl();
      }
      AppMethodBeat.o(37788);
      return;
    }
    if ((yz(true)) || (fMj()) || (fMk()) || (paramIntent.getBooleanExtra("hasLableChange", false)))
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
    bc.ajj().a(575, this);
    bc.ajj().a(576, this);
    this.jij = getIntent().getIntExtra("Contact_Scene", 9);
    this.FyV = getIntent().getStringExtra("Contact_RoomNickname");
    this.KHW = getIntent().getBooleanExtra("view_mode", false);
    this.KIh = getIntent().getStringExtra("contact_auto_app_phone_from_chatting");
    this.KId = getIntent().getStringExtra("contact_phone_number_by_md5");
    this.KIe = getIntent().getStringExtra("contact_phone_number_list");
    this.username = getIntent().getStringExtra("Contact_User");
    if (af.isNullOrNil(this.username))
    {
      finish();
      AppMethodBeat.o(37773);
      return;
    }
    bc.aCg();
    this.contact = com.tencent.mm.model.c.azF().BH(this.username);
    this.bVG = this.contact.field_conRemark;
    this.eRo = this.contact.eRo;
    this.imV = this.contact.eRp;
    this.vjh = this.contact.field_contactLabelIds;
    this.KIb = com.tencent.mm.plugin.label.a.a.dig().apq(this.vjh);
    initView();
    Zf();
    int i;
    if ((this.contact != null) && (an.aUq(this.contact.field_username))) {
      i = 1;
    }
    while (i != 0) {
      if (this.KHG == null)
      {
        AppMethodBeat.o(37773);
        return;
        i = 0;
      }
      else
      {
        paramBundle = (ViewGroup)this.KHG.getParent();
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
    bc.ajj().b(575, this);
    bc.ajj().b(576, this);
    this.KHG.removeTextChangedListener(this.KIf);
    this.KHI.removeTextChangedListener(this.KIg);
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
    bc.aCg();
    com.tencent.mm.model.c.azF().b(this.KIi);
    super.onPause();
    AppMethodBeat.o(37775);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(37774);
    super.onResume();
    bc.aCg();
    com.tencent.mm.model.c.azF().a(this.KIi);
    fMn();
    AppMethodBeat.o(37774);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(37790);
    ae.i("MiroMsg.ContactRemarkInfoModUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.hQb != null)
    {
      this.hQb.dismiss();
      this.hQb = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.ui.base.h.c(this, getString(2131755732), null, true);
      AppMethodBeat.o(37790);
      return;
    }
    if (paramn.getType() == 575)
    {
      if (this.KHS != null)
      {
        paramString = new com.tencent.mm.vfs.k(this.KHS);
        if (paramString.exists())
        {
          com.tencent.mm.bd.c.aKw();
          paramString.ag(new com.tencent.mm.vfs.k(com.tencent.mm.bd.c.GF(this.username)));
        }
      }
      paramString = ((com.tencent.mm.bd.b)paramn).imV;
      if (!af.isNullOrNil(paramString)) {
        this.imV = paramString;
      }
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(37790);
      return;
      if (paramn.getType() == 576)
      {
        this.KHS = null;
        this.imV = null;
        this.KHT = false;
        bc.aCg();
        this.contact = com.tencent.mm.model.c.azF().BH(this.username);
        this.contact.tN("");
        bc.aCg();
        com.tencent.mm.model.c.azF().c(this.username, this.contact);
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
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$LabelEditOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      ContactRemarkInfoModUI.c(ContactRemarkInfoModUI.this);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$LabelEditOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(37767);
    }
  }
  
  final class b
    implements TextWatcher
  {
    private String KIo = "";
    private int yUc = 800;
    
    private b() {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(37768);
      this.yUc = com.tencent.mm.ui.tools.f.cU(800, paramEditable.toString());
      if (this.yUc < 0) {
        this.yUc = 0;
      }
      if (ContactRemarkInfoModUI.b(ContactRemarkInfoModUI.this) != null) {
        ContactRemarkInfoModUI.b(ContactRemarkInfoModUI.this).setText(this.yUc);
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
    public String iWF;
    
    public c(String paramString)
    {
      this.iWF = paramString;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(37769);
      ContactRemarkInfoModUI.f(ContactRemarkInfoModUI.this);
      ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, true, -1);
      ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).setText(com.tencent.mm.pluginsdk.ui.span.k.b(ContactRemarkInfoModUI.this, af.nullAsNil(this.iWF), ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).getTextSize()));
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