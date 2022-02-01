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
import com.tencent.mm.al.g;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.au;
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
import com.tencent.mm.protocal.protobuf.brb;
import com.tencent.mm.protocal.protobuf.cak;
import com.tencent.mm.protocal.protobuf.cal;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.r.b;
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
  private String CiZ;
  private ImageView GUA;
  private ImageView GUB;
  private TextView GUC;
  private View GUD;
  private View GUE;
  private String GUF;
  private boolean GUG;
  private boolean GUH;
  private boolean GUI;
  private boolean GUJ;
  private boolean GUK;
  private a GUL;
  private MMTagPanel GUM;
  private TextView GUN;
  private List<String> GUO;
  private ProfileEditPhoneNumberView GUP;
  private String GUQ;
  private String GUR;
  private TextWatcher GUS;
  private b GUT;
  private String GUU;
  private n.b GUV;
  boolean GUW;
  boolean GUX;
  private boolean GUY;
  private MMClearEditText GUt;
  private TextView GUu;
  private MMEditText GUv;
  private TextView GUw;
  private TextView GUx;
  private TextView GUy;
  private TextView GUz;
  private String bNL;
  private af contact;
  private String evI;
  private ProgressDialog gUr;
  private String hqm;
  private int ima;
  private String sNm;
  private String username;
  
  public ContactRemarkInfoModUI()
  {
    AppMethodBeat.i(37771);
    this.GUG = false;
    this.GUH = false;
    this.GUI = false;
    this.GUJ = false;
    this.GUK = false;
    this.GUL = new a((byte)0);
    this.GUS = new TextWatcher()
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
    this.GUT = new b((byte)0);
    this.GUV = new n.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(37758);
        ad.d("MiroMsg.ContactRemarkInfoModUI", "cpan onNotifyChange");
        ContactRemarkInfoModUI.d(ContactRemarkInfoModUI.this);
        AppMethodBeat.o(37758);
      }
    };
    this.GUW = true;
    this.GUX = false;
    this.GUY = false;
    AppMethodBeat.o(37771);
  }
  
  private void U(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(37777);
    if (this.GUI)
    {
      this.GUw.setVisibility(8);
      if ((paramBoolean) && (ae.isNullOrNil(this.evI)))
      {
        this.GUx.setVisibility(0);
        this.GUE.setVisibility(8);
      }
      for (;;)
      {
        this.GUt.setVisibility(0);
        AppMethodBeat.o(37777);
        return;
        if (paramInt == 2131298634)
        {
          this.GUx.setVisibility(8);
          this.GUE.setVisibility(0);
        }
      }
    }
    this.GUw.setVisibility(0);
    this.GUx.setVisibility(0);
    this.GUt.setVisibility(8);
    this.GUE.setVisibility(8);
    AppMethodBeat.o(37777);
  }
  
  private void VE()
  {
    AppMethodBeat.i(37772);
    ProfileEditPhoneNumberView localProfileEditPhoneNumberView = this.GUP;
    Object localObject = localProfileEditPhoneNumberView.getPhoneNumberList();
    boolean bool;
    if ((localObject == null) || (((ArrayList)localObject).isEmpty()))
    {
      if (localProfileEditPhoneNumberView.BWa == null) {
        break label166;
      }
      bool = true;
    }
    for (;;)
    {
      this.GUY = bool;
      if ((!fbn()) && (!fbo()) && (!wt(false)) && (!this.GUY)) {
        break;
      }
      enableOptionMenu(true);
      AppMethodBeat.o(37772);
      return;
      if (localProfileEditPhoneNumberView.BWa == null)
      {
        bool = true;
      }
      else if (((ArrayList)localObject).size() != localProfileEditPhoneNumberView.BWa.length)
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
          if (!((String)((Iterator)localObject).next()).equals(localProfileEditPhoneNumberView.BWa[i]))
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
  
  private void aLq(String paramString)
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
    float f = com.tencent.mm.cd.a.getDensity(this);
    paramString = BackwardSupportUtil.b.n(this.GUF, f);
    if (paramString != null)
    {
      this.GUy.setVisibility(8);
      this.GUB.setVisibility(8);
      this.GUA.setVisibility(0);
      this.GUA.setImageBitmap(paramString);
      this.GUG = true;
    }
    AppMethodBeat.o(37781);
  }
  
  private String aLr(String paramString)
  {
    AppMethodBeat.i(37791);
    if (!com.tencent.mm.vfs.i.eK(paramString))
    {
      AppMethodBeat.o(37791);
      return null;
    }
    int i = BackwardSupportUtil.ExifHelper.co(paramString);
    Object localObject = new StringBuilder();
    com.tencent.mm.be.c.aAc();
    localObject = com.tencent.mm.be.c.yT(this.username) + ".tmp";
    if (!com.tencent.mm.sdk.platformtools.f.a(paramString, 960, 960, Bitmap.CompressFormat.JPEG, 70, (String)localObject))
    {
      ad.e("MiroMsg.ContactRemarkInfoModUI", "createThumbNail big pic fail");
      AppMethodBeat.o(37791);
      return null;
    }
    if ((i != 0) && (!com.tencent.mm.sdk.platformtools.f.a((String)localObject, i, Bitmap.CompressFormat.JPEG, 70, (String)localObject)))
    {
      ad.e("MiroMsg.ContactRemarkInfoModUI", "rotate big pic fail");
      AppMethodBeat.o(37791);
      return null;
    }
    AppMethodBeat.o(37791);
    return localObject;
  }
  
  private void fbk()
  {
    AppMethodBeat.i(37779);
    this.GUu.setFocusableInTouchMode(true);
    this.GUu.requestFocus();
    this.GUt.clearFocus();
    this.GUv.clearFocus();
    this.GUP.clearFocus();
    hideVKB();
    AppMethodBeat.o(37779);
  }
  
  private void fbl()
  {
    AppMethodBeat.i(37780);
    com.tencent.mm.be.c.aAc();
    Bitmap localBitmap = com.tencent.mm.be.c.yW(this.username);
    if (localBitmap != null)
    {
      this.GUy.setVisibility(8);
      this.GUB.setVisibility(8);
      this.GUA.setVisibility(0);
      this.GUA.setImageBitmap(localBitmap);
    }
    this.GUG = true;
    AppMethodBeat.o(37780);
  }
  
  private void fbm()
  {
    AppMethodBeat.i(37782);
    if (!this.GUY)
    {
      AppMethodBeat.o(37782);
      return;
    }
    Object localObject2 = new brb();
    ((brb)localObject2).DOL = this.username;
    cal localcal = new cal();
    localcal.DWX = new LinkedList();
    Object localObject3 = this.GUP.getPhoneNumberList();
    Object localObject1 = new ArrayList();
    if (localObject3 != null)
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        if (com.tencent.mm.plugin.bbom.c.OQ(str))
        {
          cak localcak = new cak();
          localcak.DWW = str;
          localcal.DWX.add(localcak);
          ((ArrayList)localObject1).add(str);
        }
      }
    }
    localcal.mAK = ((ArrayList)localObject1).size();
    ((brb)localObject2).DOD = localcal;
    az.arV();
    com.tencent.mm.model.c.apL().c(new j.a(60, (com.tencent.mm.bx.a)localObject2));
    az.arV();
    localObject2 = com.tencent.mm.model.c.apM().aHY(this.username);
    if ((localObject2 != null) && ((int)((com.tencent.mm.n.b)localObject2).fId > 0) && (com.tencent.mm.n.b.ls(((au)localObject2).field_type)))
    {
      localObject1 = com.tencent.mm.n.a.g((ArrayList)localObject1);
      ad.i("MiroMsg.ContactRemarkInfoModUI", "[dealModPhoneNumberList] username:%s %s", new Object[] { this.username, localObject1 });
      this.contact.nH((String)localObject1);
      com.tencent.mm.n.a.g(this.contact);
      az.arV();
      com.tencent.mm.model.c.apM().ae(this.contact);
    }
    AppMethodBeat.o(37782);
  }
  
  private boolean fbn()
  {
    AppMethodBeat.i(37784);
    String str = this.GUv.getText().toString();
    if (((this.evI == null) || (!this.evI.equals(str))) && ((!ae.isNullOrNil(this.evI)) || (!ae.isNullOrNil(str))))
    {
      AppMethodBeat.o(37784);
      return true;
    }
    AppMethodBeat.o(37784);
    return false;
  }
  
  private boolean fbo()
  {
    AppMethodBeat.i(37785);
    if ((!ae.isNullOrNil(this.GUF)) || (this.GUK))
    {
      AppMethodBeat.o(37785);
      return true;
    }
    AppMethodBeat.o(37785);
    return false;
  }
  
  private void fbp()
  {
    AppMethodBeat.i(37789);
    this.GUK = true;
    this.GUB.setVisibility(8);
    this.GUy.setVisibility(0);
    this.GUA.setVisibility(8);
    this.GUA.setImageBitmap(null);
    VE();
    AppMethodBeat.o(37789);
  }
  
  private void fbq()
  {
    AppMethodBeat.i(37792);
    if (!ae.isNullOrNil(this.sNm))
    {
      this.GUM.setVisibility(0);
      this.GUN.setVisibility(8);
      this.GUM.a(this.GUO, this.GUO);
      AppMethodBeat.o(37792);
      return;
    }
    this.GUM.setVisibility(8);
    this.GUN.setVisibility(0);
    AppMethodBeat.o(37792);
  }
  
  private void fbr()
  {
    AppMethodBeat.i(37793);
    az.arV();
    this.contact = com.tencent.mm.model.c.apM().aHY(this.username);
    this.sNm = this.contact.field_contactLabelIds;
    this.GUO = com.tencent.mm.plugin.label.a.a.cIS().aeK(this.sNm);
    fbq();
    AppMethodBeat.o(37793);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(37786);
    boolean bool1 = fbo();
    boolean bool2 = wt(true);
    boolean bool3 = fbn();
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
  
  private boolean wt(boolean paramBoolean)
  {
    AppMethodBeat.i(37783);
    String str = this.GUt.getText().toString();
    if (!paramBoolean)
    {
      if (((this.bNL == null) || (!this.bNL.equals(str))) && ((!ae.isNullOrNil(this.bNL)) || (!ae.isNullOrNil(str))))
      {
        AppMethodBeat.o(37783);
        return true;
      }
      AppMethodBeat.o(37783);
      return false;
    }
    if (((this.bNL == null) || (!this.bNL.equals(str))) && ((!ae.isNullOrNil(this.bNL)) || (!ae.isNullOrNil(str)))) {}
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
    this.GUu = ((TextView)findViewById(2131298628));
    this.GUw = ((TextView)findViewById(2131298636));
    this.GUx = ((TextView)findViewById(2131298634));
    this.GUy = ((TextView)findViewById(2131298635));
    this.GUt = ((MMClearEditText)findViewById(2131298627));
    this.GUv = ((MMEditText)findViewById(2131298626));
    this.GUA = ((ImageView)findViewById(2131303983));
    this.GUB = ((ImageView)findViewById(2131303984));
    this.GUz = ((TextView)findViewById(2131307005));
    this.GUE = findViewById(2131298625);
    this.GUP = ((ProfileEditPhoneNumberView)findViewById(2131302418));
    this.GUP.oFt = this.contact;
    Object localObject1 = this.GUP;
    Object localObject2 = this.GUQ;
    String str = this.GUR;
    ((ProfileEditPhoneNumberView)localObject1).BVY = ((String)localObject2);
    ((ProfileEditPhoneNumberView)localObject1).BVZ = str;
    ((ProfileEditPhoneNumberView)localObject1).dcY();
    this.GUP.BWd = new ProfileEditPhoneNumberView.a()
    {
      public final void exF()
      {
        AppMethodBeat.i(37760);
        w.w(ContactRemarkInfoModUI.e(ContactRemarkInfoModUI.this));
        o.azv().ov(7);
        AppMethodBeat.o(37760);
      }
      
      public final void onChange()
      {
        AppMethodBeat.i(37759);
        ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this);
        AppMethodBeat.o(37759);
      }
    };
    this.GUM = ((MMTagPanel)findViewById(2131298623));
    this.GUM.setPanelClickable(false);
    this.GUN = ((TextView)findViewById(2131298621));
    this.GUN.setText(2131761304);
    this.GUM.setOnClickListener(this.GUL);
    this.GUN.setOnClickListener(this.GUL);
    setMMTitle(2131757731);
    label617:
    int i;
    if (!ae.isNullOrNil(this.bNL))
    {
      this.GUt.setText(k.b(this, ae.nullAsNil(this.bNL), this.GUt.getTextSize()));
      this.GUw.setText(k.b(this, ae.nullAsNil(this.bNL), this.GUw.getTextSize()));
      this.GUt.setSelection(this.GUt.getText().length());
      localObject1 = k.b(this, ae.nullAsNil(this.evI), this.GUx.getTextSize());
      this.GUv.setText((CharSequence)localObject1);
      this.GUv.setSelection(this.GUv.getText().length());
      if (!ae.isNullOrNil(this.evI))
      {
        this.GUx.setText(k.b(this, ae.nullAsNil(this.evI), this.GUx.getTextSize()));
        this.GUx.setTextColor(ao.aD(getContext(), 2130968584));
      }
      this.GUw.setOnClickListener(new View.OnClickListener()
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
      this.GUx.setOnClickListener(new View.OnClickListener()
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
      this.GUt.addTextChangedListener(this.GUS);
      this.GUz.setText(com.tencent.mm.ui.tools.f.cJ(800, this.GUv.getEditableText().toString()));
      this.GUv.addTextChangedListener(this.GUT);
      if (ae.isNullOrNil(this.hqm)) {
        break label901;
      }
      this.GUy.setVisibility(8);
      this.GUA.setVisibility(0);
      com.tencent.mm.be.c.aAc();
      if (com.tencent.mm.be.c.yU(this.username)) {
        break label894;
      }
      com.tencent.mm.be.c.aAc().a(this.username, this.hqm, new com.tencent.mm.be.c.a()
      {
        public final void et(final boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(37754);
          ContactRemarkInfoModUI.t(ContactRemarkInfoModUI.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(37753);
              if (!paramAnonymousBoolean)
              {
                h.cf(ContactRemarkInfoModUI.this, ContactRemarkInfoModUI.this.getString(2131755733));
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
      this.GUA.setOnClickListener(new View.OnClickListener()
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
            com.tencent.mm.be.c.aAc();
          }
          for (paramAnonymousView = com.tencent.mm.be.c.yT(ContactRemarkInfoModUI.k(ContactRemarkInfoModUI.this));; paramAnonymousView = ContactRemarkInfoModUI.n(ContactRemarkInfoModUI.this))
          {
            localIntent.putExtra("remark_image_path", paramAnonymousView);
            localIntent.putExtra("view_temp_remark_image", ContactRemarkInfoModUI.m(ContactRemarkInfoModUI.this));
            ContactRemarkInfoModUI.this.startActivityForResult(localIntent, 400);
            AppMethodBeat.o(37763);
            return;
          }
        }
      });
      this.GUy.setOnClickListener(new View.OnClickListener()
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
      localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cc(this.contact.field_username);
      if ((localObject1 != null) && (!ae.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aIv())) && (!((com.tencent.mm.plugin.account.friend.a.a)localObject1).aIv().equals(this.GUt.getText().toString()))) {
        break label921;
      }
      i = 0;
      label697:
      if ((i == 0) && (this.ima == 14) && (!ae.isNullOrNil(this.CiZ)) && (!this.CiZ.equals(this.GUt.getText().toString()))) {
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
      }, null, r.b.FOB);
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
      if (!ae.isNullOrNil(this.bNL)) {
        break label1194;
      }
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.GUB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37750);
          ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, true);
          ContactRemarkInfoModUI.j(ContactRemarkInfoModUI.this);
          AppMethodBeat.o(37750);
        }
      });
      if (!this.GUJ)
      {
        this.GUI = true;
        U(true, -1);
      }
      fbk();
      AppMethodBeat.o(37778);
      return;
      this.GUt.setText(k.b(this, ae.nullAsNil(this.contact.ZW()), this.GUt.getTextSize()));
      this.GUw.setText(k.b(this, ae.nullAsNil(this.contact.ZW()), this.GUt.getTextSize()));
      break;
      label894:
      fbl();
      break label617;
      label901:
      this.GUy.setVisibility(0);
      this.GUA.setVisibility(8);
      break label617;
      label921:
      this.GUC = ((TextView)findViewById(2131302425));
      this.GUD = findViewById(2131302419);
      this.GUD.setVisibility(0);
      this.GUC.setText(ae.nullAsNil(getString(2131757816, new Object[] { ((com.tencent.mm.plugin.account.friend.a.a)localObject1).aIv() })));
      localObject2 = new l(getString(2131766242));
      ((l)localObject2).setSpan(new c(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aIv()), 0, ((l)localObject2).length(), 17);
      this.GUC.append(" ");
      this.GUC.append((CharSequence)localObject2);
      this.GUC.setMovementMethod(LinkMovementMethod.getInstance());
      i = 1;
      break label697;
      label1053:
      this.GUC = ((TextView)findViewById(2131302425));
      this.GUD = findViewById(2131302419);
      this.GUD.setVisibility(0);
      this.GUC.setText(k.b(this, ae.nullAsNil(getString(2131757815, new Object[] { this.CiZ })), this.GUC.getTextSize()));
      localObject1 = new l(getString(2131766242));
      ((l)localObject1).setSpan(new c(this.CiZ), 0, ((l)localObject1).length(), 17);
      this.GUC.append(" ");
      this.GUC.append((CharSequence)localObject1);
      this.GUC.setMovementMethod(LinkMovementMethod.getInstance());
      break label740;
      label1194:
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
      az.arV();
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.q.h(localContext, paramIntent, com.tencent.mm.model.c.apW());
      if (paramIntent == null)
      {
        AppMethodBeat.o(37788);
        return;
      }
      this.GUF = aLr(paramIntent);
      aLq(this.GUF);
      this.GUH = true;
      this.GUK = false;
      VE();
      AppMethodBeat.o(37788);
      return;
    case 200: 
      localContext = getApplicationContext();
      az.arV();
      paramIntent = com.tencent.mm.ui.tools.a.i(localContext, paramIntent, com.tencent.mm.model.c.apW());
      if (paramIntent == null)
      {
        AppMethodBeat.o(37788);
        return;
      }
      this.GUF = aLr(paramIntent);
      aLq(this.GUF);
      this.GUH = true;
      this.GUK = false;
      VE();
      AppMethodBeat.o(37788);
      return;
    case 400: 
      if (paramIntent.getBooleanExtra("response_delete", false)) {
        fbp();
      }
      AppMethodBeat.o(37788);
      return;
    }
    if ((wt(true)) || (fbn()) || (fbo()) || (paramIntent.getBooleanExtra("hasLableChange", false)))
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
    az.aeS().a(575, this);
    az.aeS().a(576, this);
    this.ima = getIntent().getIntExtra("Contact_Scene", 9);
    this.CiZ = getIntent().getStringExtra("Contact_RoomNickname");
    this.GUJ = getIntent().getBooleanExtra("view_mode", false);
    this.GUU = getIntent().getStringExtra("contact_auto_app_phone_from_chatting");
    this.GUQ = getIntent().getStringExtra("contact_phone_number_by_md5");
    this.GUR = getIntent().getStringExtra("contact_phone_number_list");
    this.username = getIntent().getStringExtra("Contact_User");
    if (ae.isNullOrNil(this.username))
    {
      finish();
      AppMethodBeat.o(37773);
      return;
    }
    az.arV();
    this.contact = com.tencent.mm.model.c.apM().aHY(this.username);
    this.bNL = this.contact.field_conRemark;
    this.evI = this.contact.evI;
    this.hqm = this.contact.evJ;
    this.sNm = this.contact.field_contactLabelIds;
    this.GUO = com.tencent.mm.plugin.label.a.a.cIS().aeK(this.sNm);
    initView();
    VE();
    int i;
    if ((this.contact != null) && (af.aHH(this.contact.field_username))) {
      i = 1;
    }
    while (i != 0) {
      if (this.GUt == null)
      {
        AppMethodBeat.o(37773);
        return;
        i = 0;
      }
      else
      {
        paramBundle = (ViewGroup)this.GUt.getParent();
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
    az.aeS().b(575, this);
    az.aeS().b(576, this);
    this.GUt.removeTextChangedListener(this.GUS);
    this.GUv.removeTextChangedListener(this.GUT);
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
    az.arV();
    com.tencent.mm.model.c.apM().b(this.GUV);
    super.onPause();
    AppMethodBeat.o(37775);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(37774);
    super.onResume();
    az.arV();
    com.tencent.mm.model.c.apM().a(this.GUV);
    fbr();
    AppMethodBeat.o(37774);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(37790);
    ad.i("MiroMsg.ContactRemarkInfoModUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.gUr != null)
    {
      this.gUr.dismiss();
      this.gUr = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      h.c(this, getString(2131755732), null, true);
      AppMethodBeat.o(37790);
      return;
    }
    if (paramn.getType() == 575)
    {
      if (this.GUF != null)
      {
        paramString = new e(this.GUF);
        if (paramString.exists())
        {
          com.tencent.mm.be.c.aAc();
          paramString.af(new e(com.tencent.mm.be.c.yT(this.username)));
        }
      }
      paramString = ((com.tencent.mm.be.b)paramn).hqm;
      if (!ae.isNullOrNil(paramString)) {
        this.hqm = paramString;
      }
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(37790);
      return;
      if (paramn.getType() == 576)
      {
        this.GUF = null;
        this.hqm = null;
        this.GUG = false;
        az.arV();
        this.contact = com.tencent.mm.model.c.apM().aHY(this.username);
        this.contact.nC("");
        az.arV();
        com.tencent.mm.model.c.apM().c(this.username, this.contact);
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
    private String GVb = "";
    private int weg = 800;
    
    private b() {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(37768);
      this.weg = com.tencent.mm.ui.tools.f.cJ(800, paramEditable.toString());
      if (this.weg < 0) {
        this.weg = 0;
      }
      if (ContactRemarkInfoModUI.b(ContactRemarkInfoModUI.this) != null) {
        ContactRemarkInfoModUI.b(ContactRemarkInfoModUI.this).setText(this.weg);
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
    public String iaz;
    
    public c(String paramString)
    {
      this.iaz = paramString;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(37769);
      ContactRemarkInfoModUI.f(ContactRemarkInfoModUI.this);
      ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, true, -1);
      ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).setText(k.b(ContactRemarkInfoModUI.this, ae.nullAsNil(this.iaz), ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).getTextSize()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI
 * JD-Core Version:    0.7.0.1
 */