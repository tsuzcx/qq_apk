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
import com.tencent.mm.ak.g;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView;
import com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.bvs;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.protocal.protobuf.cfk;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactRemarkInfoModUI
  extends MMActivity
  implements g
{
  private String DBq;
  private MMClearEditText IuG;
  private TextView IuH;
  private MMEditText IuI;
  private TextView IuJ;
  private TextView IuK;
  private TextView IuL;
  private TextView IuM;
  private ImageView IuN;
  private ImageView IuO;
  private TextView IuP;
  private View IuQ;
  private View IuR;
  private String IuS;
  private boolean IuT;
  private boolean IuU;
  private boolean IuV;
  private boolean IuW;
  private boolean IuX;
  private a IuY;
  private MMTagPanel IuZ;
  private TextView Iva;
  private List<String> Ivb;
  private ProfileEditPhoneNumberView Ivc;
  private String Ivd;
  private String Ive;
  private TextWatcher Ivf;
  private b Ivg;
  private String Ivh;
  private n.b Ivi;
  boolean Ivj;
  boolean Ivk;
  private boolean Ivl;
  private String bLt;
  private ai contact;
  private String eyf;
  private String hQO;
  private ProgressDialog huQ;
  private int iMg;
  private String tUR;
  private String username;
  
  public ContactRemarkInfoModUI()
  {
    AppMethodBeat.i(37771);
    this.IuT = false;
    this.IuU = false;
    this.IuV = false;
    this.IuW = false;
    this.IuX = false;
    this.IuY = new a((byte)0);
    this.Ivf = new TextWatcher()
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
    this.Ivg = new b((byte)0);
    this.Ivi = new n.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(37758);
        ac.d("MiroMsg.ContactRemarkInfoModUI", "cpan onNotifyChange");
        ContactRemarkInfoModUI.d(ContactRemarkInfoModUI.this);
        AppMethodBeat.o(37758);
      }
    };
    this.Ivj = true;
    this.Ivk = false;
    this.Ivl = false;
    AppMethodBeat.o(37771);
  }
  
  private void WC()
  {
    AppMethodBeat.i(37772);
    ProfileEditPhoneNumberView localProfileEditPhoneNumberView = this.Ivc;
    Object localObject = localProfileEditPhoneNumberView.getPhoneNumberList();
    boolean bool;
    if ((localObject == null) || (((ArrayList)localObject).isEmpty()))
    {
      if (localProfileEditPhoneNumberView.Dor == null) {
        break label166;
      }
      bool = true;
    }
    for (;;)
    {
      this.Ivl = bool;
      if ((!fre()) && (!frf()) && (!xz(false)) && (!this.Ivl)) {
        break;
      }
      enableOptionMenu(true);
      AppMethodBeat.o(37772);
      return;
      if (localProfileEditPhoneNumberView.Dor == null)
      {
        bool = true;
      }
      else if (((ArrayList)localObject).size() != localProfileEditPhoneNumberView.Dor.length)
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
          if (!((String)((Iterator)localObject).next()).equals(localProfileEditPhoneNumberView.Dor[i]))
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
  
  private void X(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(37777);
    if (this.IuV)
    {
      this.IuJ.setVisibility(8);
      if ((paramBoolean) && (ae.isNullOrNil(this.eyf)))
      {
        this.IuK.setVisibility(0);
        this.IuR.setVisibility(8);
      }
      for (;;)
      {
        this.IuG.setVisibility(0);
        AppMethodBeat.o(37777);
        return;
        if (paramInt == 2131298634)
        {
          this.IuK.setVisibility(8);
          this.IuR.setVisibility(0);
        }
      }
    }
    this.IuJ.setVisibility(0);
    this.IuK.setVisibility(0);
    this.IuG.setVisibility(8);
    this.IuR.setVisibility(8);
    AppMethodBeat.o(37777);
  }
  
  private void aQU(String paramString)
  {
    AppMethodBeat.i(37781);
    if (ae.isNullOrNil(paramString))
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
    paramString = BackwardSupportUtil.b.n(this.IuS, f);
    if (paramString != null)
    {
      this.IuL.setVisibility(8);
      this.IuO.setVisibility(8);
      this.IuN.setVisibility(0);
      this.IuN.setImageBitmap(paramString);
      this.IuT = true;
    }
    AppMethodBeat.o(37781);
  }
  
  private String aQV(String paramString)
  {
    AppMethodBeat.i(37791);
    if (!com.tencent.mm.vfs.i.eA(paramString))
    {
      AppMethodBeat.o(37791);
      return null;
    }
    int i = BackwardSupportUtil.ExifHelper.ce(paramString);
    Object localObject = new StringBuilder();
    com.tencent.mm.bd.c.aGS();
    localObject = com.tencent.mm.bd.c.CY(this.username) + ".tmp";
    if (!com.tencent.mm.sdk.platformtools.f.a(paramString, 960, 960, Bitmap.CompressFormat.JPEG, 70, (String)localObject))
    {
      ac.e("MiroMsg.ContactRemarkInfoModUI", "createThumbNail big pic fail");
      AppMethodBeat.o(37791);
      return null;
    }
    if ((i != 0) && (!com.tencent.mm.sdk.platformtools.f.a((String)localObject, i, Bitmap.CompressFormat.JPEG, 70, (String)localObject)))
    {
      ac.e("MiroMsg.ContactRemarkInfoModUI", "rotate big pic fail");
      AppMethodBeat.o(37791);
      return null;
    }
    AppMethodBeat.o(37791);
    return localObject;
  }
  
  private void frb()
  {
    AppMethodBeat.i(37779);
    this.IuH.setFocusableInTouchMode(true);
    this.IuH.requestFocus();
    this.IuG.clearFocus();
    this.IuI.clearFocus();
    this.Ivc.clearFocus();
    hideVKB();
    AppMethodBeat.o(37779);
  }
  
  private void frc()
  {
    AppMethodBeat.i(37780);
    com.tencent.mm.bd.c.aGS();
    Bitmap localBitmap = com.tencent.mm.bd.c.Db(this.username);
    if (localBitmap != null)
    {
      this.IuL.setVisibility(8);
      this.IuO.setVisibility(8);
      this.IuN.setVisibility(0);
      this.IuN.setImageBitmap(localBitmap);
    }
    this.IuT = true;
    AppMethodBeat.o(37780);
  }
  
  private void frd()
  {
    AppMethodBeat.i(37782);
    if (!this.Ivl)
    {
      AppMethodBeat.o(37782);
      return;
    }
    Object localObject2 = new bvs();
    ((bvs)localObject2).Flc = this.username;
    cfk localcfk = new cfk();
    localcfk.FtQ = new LinkedList();
    Object localObject3 = this.Ivc.getPhoneNumberList();
    Object localObject1 = new ArrayList();
    if (localObject3 != null)
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        if (com.tencent.mm.plugin.bbom.c.Ta(str))
        {
          cfj localcfj = new cfj();
          localcfj.FtP = str;
          localcfk.FtQ.add(localcfj);
          ((ArrayList)localObject1).add(str);
        }
      }
    }
    localcfk.ncL = ((ArrayList)localObject1).size();
    ((bvs)localObject2).FkU = localcfk;
    az.ayM();
    com.tencent.mm.model.c.awA().c(new j.a(60, (com.tencent.mm.bw.a)localObject2));
    az.ayM();
    localObject2 = com.tencent.mm.model.c.awB().aNt(this.username);
    if ((localObject2 != null) && ((int)((com.tencent.mm.n.b)localObject2).fLJ > 0) && (com.tencent.mm.n.b.ln(((av)localObject2).field_type)))
    {
      localObject1 = com.tencent.mm.n.a.h((ArrayList)localObject1);
      ac.i("MiroMsg.ContactRemarkInfoModUI", "[dealModPhoneNumberList] username:%s %s", new Object[] { this.username, localObject1 });
      this.contact.qN((String)localObject1);
      com.tencent.mm.n.a.g(this.contact);
      az.ayM();
      com.tencent.mm.model.c.awB().af(this.contact);
    }
    AppMethodBeat.o(37782);
  }
  
  private boolean fre()
  {
    AppMethodBeat.i(37784);
    String str = this.IuI.getText().toString();
    if (((this.eyf == null) || (!this.eyf.equals(str))) && ((!ae.isNullOrNil(this.eyf)) || (!ae.isNullOrNil(str))))
    {
      AppMethodBeat.o(37784);
      return true;
    }
    AppMethodBeat.o(37784);
    return false;
  }
  
  private boolean frf()
  {
    AppMethodBeat.i(37785);
    if ((!ae.isNullOrNil(this.IuS)) || (this.IuX))
    {
      AppMethodBeat.o(37785);
      return true;
    }
    AppMethodBeat.o(37785);
    return false;
  }
  
  private void frg()
  {
    AppMethodBeat.i(37789);
    this.IuX = true;
    this.IuO.setVisibility(8);
    this.IuL.setVisibility(0);
    this.IuN.setVisibility(8);
    this.IuN.setImageBitmap(null);
    WC();
    AppMethodBeat.o(37789);
  }
  
  private void frh()
  {
    AppMethodBeat.i(37792);
    if (!ae.isNullOrNil(this.tUR))
    {
      this.IuZ.setVisibility(0);
      this.Iva.setVisibility(8);
      this.IuZ.a(this.Ivb, this.Ivb);
      AppMethodBeat.o(37792);
      return;
    }
    this.IuZ.setVisibility(8);
    this.Iva.setVisibility(0);
    AppMethodBeat.o(37792);
  }
  
  private void fri()
  {
    AppMethodBeat.i(37793);
    az.ayM();
    this.contact = com.tencent.mm.model.c.awB().aNt(this.username);
    this.tUR = this.contact.field_contactLabelIds;
    this.Ivb = com.tencent.mm.plugin.label.a.a.cWd().ajC(this.tUR);
    frh();
    AppMethodBeat.o(37793);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(37786);
    boolean bool1 = frf();
    boolean bool2 = xz(true);
    boolean bool3 = fre();
    if ((bool1) || (bool2) || (bool3))
    {
      h.d(this, getString(2131757789), null, getString(2131757791), getString(2131757790), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
  
  private boolean xz(boolean paramBoolean)
  {
    AppMethodBeat.i(37783);
    String str = this.IuG.getText().toString();
    if (!paramBoolean)
    {
      if (((this.bLt == null) || (!this.bLt.equals(str))) && ((!ae.isNullOrNil(this.bLt)) || (!ae.isNullOrNil(str))))
      {
        AppMethodBeat.o(37783);
        return true;
      }
      AppMethodBeat.o(37783);
      return false;
    }
    if (((this.bLt == null) || (!this.bLt.equals(str))) && ((!ae.isNullOrNil(this.bLt)) || (!ae.isNullOrNil(str)))) {}
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
    this.IuH = ((TextView)findViewById(2131298628));
    this.IuJ = ((TextView)findViewById(2131298636));
    this.IuK = ((TextView)findViewById(2131298634));
    this.IuL = ((TextView)findViewById(2131298635));
    this.IuG = ((MMClearEditText)findViewById(2131298627));
    this.IuI = ((MMEditText)findViewById(2131298626));
    this.IuN = ((ImageView)findViewById(2131303983));
    this.IuO = ((ImageView)findViewById(2131303984));
    this.IuM = ((TextView)findViewById(2131307005));
    this.IuR = findViewById(2131298625);
    this.Ivc = ((ProfileEditPhoneNumberView)findViewById(2131302418));
    this.Ivc.piT = this.contact;
    Object localObject1 = this.Ivc;
    Object localObject2 = this.Ivd;
    String str = this.Ive;
    ((ProfileEditPhoneNumberView)localObject1).Dop = ((String)localObject2);
    ((ProfileEditPhoneNumberView)localObject1).Doq = str;
    ((ProfileEditPhoneNumberView)localObject1).dqG();
    this.Ivc.Dou = new ProfileEditPhoneNumberView.a()
    {
      public final void eMZ()
      {
        AppMethodBeat.i(37760);
        w.w(ContactRemarkInfoModUI.e(ContactRemarkInfoModUI.this));
        o.aGm().pj(7);
        AppMethodBeat.o(37760);
      }
      
      public final void onChange()
      {
        AppMethodBeat.i(37759);
        ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this);
        AppMethodBeat.o(37759);
      }
    };
    this.IuZ = ((MMTagPanel)findViewById(2131298623));
    this.IuZ.setPanelClickable(false);
    this.Iva = ((TextView)findViewById(2131298621));
    this.Iva.setText(2131761304);
    this.IuZ.setOnClickListener(this.IuY);
    this.Iva.setOnClickListener(this.IuY);
    setMMTitle(2131757731);
    label617:
    int i;
    if (!ae.isNullOrNil(this.bLt))
    {
      this.IuG.setText(k.b(this, ae.nullAsNil(this.bLt), this.IuG.getTextSize()));
      this.IuJ.setText(k.b(this, ae.nullAsNil(this.bLt), this.IuJ.getTextSize()));
      this.IuG.setSelection(this.IuG.getText().length());
      localObject1 = k.b(this, ae.nullAsNil(this.eyf), this.IuK.getTextSize());
      this.IuI.setText((CharSequence)localObject1);
      this.IuI.setSelection(this.IuI.getText().length());
      if (!ae.isNullOrNil(this.eyf))
      {
        this.IuK.setText(k.b(this, ae.nullAsNil(this.eyf), this.IuK.getTextSize()));
        this.IuK.setTextColor(ao.aJ(getContext(), 2130968584));
      }
      this.IuJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37761);
          ContactRemarkInfoModUI.f(ContactRemarkInfoModUI.this);
          ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, false, paramAnonymousView.getId());
          ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).performClick();
          ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).requestFocus();
          ContactRemarkInfoModUI.this.showVKB();
          AppMethodBeat.o(37761);
        }
      });
      this.IuK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37762);
          ContactRemarkInfoModUI.f(ContactRemarkInfoModUI.this);
          ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, false, paramAnonymousView.getId());
          ContactRemarkInfoModUI.h(ContactRemarkInfoModUI.this).performClick();
          ContactRemarkInfoModUI.h(ContactRemarkInfoModUI.this).requestFocus();
          ContactRemarkInfoModUI.this.showVKB();
          AppMethodBeat.o(37762);
        }
      });
      this.IuG.addTextChangedListener(this.Ivf);
      this.IuM.setText(com.tencent.mm.ui.tools.f.cM(800, this.IuI.getEditableText().toString()));
      this.IuI.addTextChangedListener(this.Ivg);
      if (ae.isNullOrNil(this.hQO)) {
        break label901;
      }
      this.IuL.setVisibility(8);
      this.IuN.setVisibility(0);
      com.tencent.mm.bd.c.aGS();
      if (com.tencent.mm.bd.c.CZ(this.username)) {
        break label894;
      }
      com.tencent.mm.bd.c.aGS().a(this.username, this.hQO, new com.tencent.mm.bd.c.a()
      {
        public final void eN(final boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(37754);
          ContactRemarkInfoModUI.t(ContactRemarkInfoModUI.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(37753);
              if (!paramAnonymousBoolean)
              {
                h.cg(ContactRemarkInfoModUI.this, ContactRemarkInfoModUI.this.getString(2131755733));
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
      this.IuN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37763);
          if (!ContactRemarkInfoModUI.i(ContactRemarkInfoModUI.this))
          {
            AppMethodBeat.o(37763);
            return;
          }
          ContactRemarkInfoModUI.j(ContactRemarkInfoModUI.this);
          Intent localIntent = new Intent(ContactRemarkInfoModUI.this, ContactRemarkImagePreviewUI.class);
          localIntent.putExtra("Contact_User", ContactRemarkInfoModUI.k(ContactRemarkInfoModUI.this));
          if ((!ae.isNullOrNil(ContactRemarkInfoModUI.l(ContactRemarkInfoModUI.this))) && (!ContactRemarkInfoModUI.m(ContactRemarkInfoModUI.this))) {
            com.tencent.mm.bd.c.aGS();
          }
          for (paramAnonymousView = com.tencent.mm.bd.c.CY(ContactRemarkInfoModUI.k(ContactRemarkInfoModUI.this));; paramAnonymousView = ContactRemarkInfoModUI.n(ContactRemarkInfoModUI.this))
          {
            localIntent.putExtra("remark_image_path", paramAnonymousView);
            localIntent.putExtra("view_temp_remark_image", ContactRemarkInfoModUI.m(ContactRemarkInfoModUI.this));
            ContactRemarkInfoModUI.this.startActivityForResult(localIntent, 400);
            AppMethodBeat.o(37763);
            return;
          }
        }
      });
      this.IuL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37764);
          if ((ae.isNullOrNil(ContactRemarkInfoModUI.l(ContactRemarkInfoModUI.this))) || (ContactRemarkInfoModUI.o(ContactRemarkInfoModUI.this)))
          {
            ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, false);
            ContactRemarkInfoModUI.j(ContactRemarkInfoModUI.this);
          }
          AppMethodBeat.o(37764);
        }
      });
      localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gf(this.contact.field_username);
      if ((localObject1 != null) && (!ae.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aPm())) && (!((com.tencent.mm.plugin.account.friend.a.a)localObject1).aPm().equals(this.IuG.getText().toString()))) {
        break label921;
      }
      i = 0;
      label697:
      if ((i == 0) && (this.iMg == 14) && (!ae.isNullOrNil(this.DBq)) && (!this.DBq.equals(this.IuG.getText().toString()))) {
        break label1053;
      }
      label740:
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
      }, null, s.b.Hom);
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
      if (!ae.isNullOrNil(this.bLt)) {
        break label1194;
      }
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.IuO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37750);
          ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, true);
          ContactRemarkInfoModUI.j(ContactRemarkInfoModUI.this);
          AppMethodBeat.o(37750);
        }
      });
      if (!this.IuW)
      {
        this.IuV = true;
        X(true, -1);
      }
      frb();
      AppMethodBeat.o(37778);
      return;
      this.IuG.setText(k.b(this, ae.nullAsNil(this.contact.aaR()), this.IuG.getTextSize()));
      this.IuJ.setText(k.b(this, ae.nullAsNil(this.contact.aaR()), this.IuG.getTextSize()));
      break;
      label894:
      frc();
      break label617;
      label901:
      this.IuL.setVisibility(0);
      this.IuN.setVisibility(8);
      break label617;
      label921:
      this.IuP = ((TextView)findViewById(2131302425));
      this.IuQ = findViewById(2131302419);
      this.IuQ.setVisibility(0);
      this.IuP.setText(ae.nullAsNil(getString(2131757816, new Object[] { ((com.tencent.mm.plugin.account.friend.a.a)localObject1).aPm() })));
      localObject2 = new l(getString(2131766242));
      ((l)localObject2).setSpan(new c(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aPm()), 0, ((l)localObject2).length(), 17);
      this.IuP.append(" ");
      this.IuP.append((CharSequence)localObject2);
      this.IuP.setMovementMethod(LinkMovementMethod.getInstance());
      i = 1;
      break label697;
      label1053:
      this.IuP = ((TextView)findViewById(2131302425));
      this.IuQ = findViewById(2131302419);
      this.IuQ.setVisibility(0);
      this.IuP.setText(k.b(this, ae.nullAsNil(getString(2131757815, new Object[] { this.DBq })), this.IuP.getTextSize()));
      localObject1 = new l(getString(2131766242));
      ((l)localObject1).setSpan(new c(this.DBq), 0, ((l)localObject1).length(), 17);
      this.IuP.append(" ");
      this.IuP.append((CharSequence)localObject1);
      this.IuP.setMovementMethod(LinkMovementMethod.getInstance());
      break label740;
      label1194:
      enableOptionMenu(false);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(37788);
    ac.i("MiroMsg.ContactRemarkInfoModUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent == null)
    {
      ac.e("MiroMsg.ContactRemarkInfoModUI", "data shouldnot be null");
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
      az.ayM();
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.q.h(localContext, paramIntent, com.tencent.mm.model.c.awL());
      if (paramIntent == null)
      {
        AppMethodBeat.o(37788);
        return;
      }
      this.IuS = aQV(paramIntent);
      aQU(this.IuS);
      this.IuU = true;
      this.IuX = false;
      WC();
      AppMethodBeat.o(37788);
      return;
    case 200: 
      localContext = getApplicationContext();
      az.ayM();
      paramIntent = com.tencent.mm.ui.tools.a.i(localContext, paramIntent, com.tencent.mm.model.c.awL());
      if (paramIntent == null)
      {
        AppMethodBeat.o(37788);
        return;
      }
      this.IuS = aQV(paramIntent);
      aQU(this.IuS);
      this.IuU = true;
      this.IuX = false;
      WC();
      AppMethodBeat.o(37788);
      return;
    case 400: 
      if (paramIntent.getBooleanExtra("response_delete", false)) {
        frg();
      }
      AppMethodBeat.o(37788);
      return;
    }
    if ((xz(true)) || (fre()) || (frf()) || (paramIntent.getBooleanExtra("hasLableChange", false)))
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
    az.agi().a(575, this);
    az.agi().a(576, this);
    this.iMg = getIntent().getIntExtra("Contact_Scene", 9);
    this.DBq = getIntent().getStringExtra("Contact_RoomNickname");
    this.IuW = getIntent().getBooleanExtra("view_mode", false);
    this.Ivh = getIntent().getStringExtra("contact_auto_app_phone_from_chatting");
    this.Ivd = getIntent().getStringExtra("contact_phone_number_by_md5");
    this.Ive = getIntent().getStringExtra("contact_phone_number_list");
    this.username = getIntent().getStringExtra("Contact_User");
    if (ae.isNullOrNil(this.username))
    {
      finish();
      AppMethodBeat.o(37773);
      return;
    }
    az.ayM();
    this.contact = com.tencent.mm.model.c.awB().aNt(this.username);
    this.bLt = this.contact.field_conRemark;
    this.eyf = this.contact.eyf;
    this.hQO = this.contact.eyg;
    this.tUR = this.contact.field_contactLabelIds;
    this.Ivb = com.tencent.mm.plugin.label.a.a.cWd().ajC(this.tUR);
    initView();
    WC();
    int i;
    if ((this.contact != null) && (ai.aNc(this.contact.field_username))) {
      i = 1;
    }
    while (i != 0) {
      if (this.IuG == null)
      {
        AppMethodBeat.o(37773);
        return;
        i = 0;
      }
      else
      {
        paramBundle = (ViewGroup)this.IuG.getParent();
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
    az.agi().b(575, this);
    az.agi().b(576, this);
    this.IuG.removeTextChangedListener(this.Ivf);
    this.IuI.removeTextChangedListener(this.Ivg);
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
    az.ayM();
    com.tencent.mm.model.c.awB().b(this.Ivi);
    super.onPause();
    AppMethodBeat.o(37775);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(37774);
    super.onResume();
    az.ayM();
    com.tencent.mm.model.c.awB().a(this.Ivi);
    fri();
    AppMethodBeat.o(37774);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(37790);
    ac.i("MiroMsg.ContactRemarkInfoModUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.huQ != null)
    {
      this.huQ.dismiss();
      this.huQ = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      h.c(this, getString(2131755732), null, true);
      AppMethodBeat.o(37790);
      return;
    }
    if (paramn.getType() == 575)
    {
      if (this.IuS != null)
      {
        paramString = new e(this.IuS);
        if (paramString.exists())
        {
          com.tencent.mm.bd.c.aGS();
          paramString.ae(new e(com.tencent.mm.bd.c.CY(this.username)));
        }
      }
      paramString = ((com.tencent.mm.bd.b)paramn).hQO;
      if (!ae.isNullOrNil(paramString)) {
        this.hQO = paramString;
      }
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(37790);
      return;
      if (paramn.getType() == 576)
      {
        this.IuS = null;
        this.hQO = null;
        this.IuT = false;
        az.ayM();
        this.contact = com.tencent.mm.model.c.awB().aNt(this.username);
        this.contact.qI("");
        az.ayM();
        com.tencent.mm.model.c.awB().c(this.username, this.contact);
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
      ContactRemarkInfoModUI.c(ContactRemarkInfoModUI.this);
      AppMethodBeat.o(37767);
    }
  }
  
  final class b
    implements TextWatcher
  {
    private String Ivo = "";
    private int xpu = 800;
    
    private b() {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(37768);
      this.xpu = com.tencent.mm.ui.tools.f.cM(800, paramEditable.toString());
      if (this.xpu < 0) {
        this.xpu = 0;
      }
      if (ContactRemarkInfoModUI.b(ContactRemarkInfoModUI.this) != null) {
        ContactRemarkInfoModUI.b(ContactRemarkInfoModUI.this).setText(this.xpu);
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
    public String iAC;
    
    public c(String paramString)
    {
      this.iAC = paramString;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(37769);
      ContactRemarkInfoModUI.f(ContactRemarkInfoModUI.this);
      ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, true, -1);
      ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).setText(k.b(ContactRemarkInfoModUI.this, ae.nullAsNil(this.iAC), ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).getTextSize()));
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