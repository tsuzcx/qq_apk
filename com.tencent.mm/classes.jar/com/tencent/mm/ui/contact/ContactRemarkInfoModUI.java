package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.bd.c.a;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.protocal.protobuf.cqe;
import com.tencent.mm.protocal.protobuf.dbk;
import com.tencent.mm.protocal.protobuf.dbl;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactRemarkInfoModUI
  extends MMActivity
  implements i
{
  private String KpU;
  private MMClearEditText PUF;
  private TextView PUG;
  private MMEditText PUH;
  private TextView PUI;
  private TextView PUJ;
  private TextView PUK;
  private TextView PUL;
  private ImageView PUM;
  private ImageView PUN;
  private TextView PUO;
  private View PUP;
  private String PUQ;
  private boolean PUR;
  private boolean PUS;
  private boolean PUT;
  private boolean PUU;
  private boolean PUV;
  private ContactRemarkInfoModUI.a PUW;
  private MMTagPanel PUX;
  private TextView PUY;
  private List<String> PUZ;
  private ProfileEditPhoneNumberView PVa;
  private String PVb;
  private String PVc;
  private TextWatcher PVd;
  private ContactRemarkInfoModUI.b PVe;
  private String PVf;
  private MStorageEx.IOnStorageChange PVg;
  boolean PVh;
  boolean PVi;
  private boolean PVj;
  private String cgo;
  private as contact;
  private String fuR;
  private ProgressDialog iLh;
  private String jid;
  private int kgm;
  private View uhh;
  private String username;
  private String yDk;
  
  public ContactRemarkInfoModUI()
  {
    AppMethodBeat.i(37771);
    this.PUR = false;
    this.PUS = false;
    this.PUT = false;
    this.PUU = false;
    this.PUV = false;
    this.PUW = new ContactRemarkInfoModUI.a(this, (byte)0);
    this.PVd = new ContactRemarkInfoModUI.1(this);
    this.PVe = new ContactRemarkInfoModUI.b(this, (byte)0);
    this.PVg = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(37758);
        Log.d("MiroMsg.ContactRemarkInfoModUI", "cpan onNotifyChange");
        ContactRemarkInfoModUI.d(ContactRemarkInfoModUI.this);
        AppMethodBeat.o(37758);
      }
    };
    this.PVh = true;
    this.PVi = false;
    this.PVj = false;
    AppMethodBeat.o(37771);
  }
  
  private boolean Co(boolean paramBoolean)
  {
    AppMethodBeat.i(37783);
    String str = this.PUF.getText().toString();
    if (!paramBoolean)
    {
      if (((this.cgo == null) || (!this.cgo.equals(str))) && ((!af.isNullOrNil(this.cgo)) || (!af.isNullOrNil(str))))
      {
        AppMethodBeat.o(37783);
        return true;
      }
      AppMethodBeat.o(37783);
      return false;
    }
    if (((this.cgo == null) || (!this.cgo.equals(str))) && ((!af.isNullOrNil(this.cgo)) || (!af.isNullOrNil(str)))) {}
    for (int i = 1; (i != 0) && ((str == null) || (!str.equals(this.contact.field_nickname))); i = 0)
    {
      AppMethodBeat.o(37783);
      return true;
    }
    AppMethodBeat.o(37783);
    return false;
  }
  
  private void ae(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(37777);
    if (this.PUT)
    {
      this.PUI.setVisibility(8);
      if ((paramBoolean) && (af.isNullOrNil(this.fuR)))
      {
        this.PUJ.setVisibility(0);
        this.uhh.setVisibility(8);
      }
      for (;;)
      {
        this.PUF.setVisibility(0);
        AppMethodBeat.o(37777);
        return;
        if (paramInt == 2131299071)
        {
          this.PUJ.setVisibility(8);
          this.uhh.setVisibility(0);
        }
      }
    }
    this.PUI.setVisibility(0);
    this.PUJ.setVisibility(0);
    this.PUF.setVisibility(8);
    this.uhh.setVisibility(8);
    AppMethodBeat.o(37777);
  }
  
  private void amS()
  {
    AppMethodBeat.i(37772);
    ProfileEditPhoneNumberView localProfileEditPhoneNumberView = this.PVa;
    Object localObject = localProfileEditPhoneNumberView.getPhoneNumberList();
    boolean bool;
    if ((localObject == null) || (((ArrayList)localObject).isEmpty()))
    {
      if (localProfileEditPhoneNumberView.KcK == null) {
        break label168;
      }
      bool = true;
    }
    for (;;)
    {
      this.PVj = bool;
      if ((!gUD()) && (!gUE()) && (!Co(false)) && (!this.PVj)) {
        break;
      }
      enableOptionMenu(true);
      AppMethodBeat.o(37772);
      return;
      if (localProfileEditPhoneNumberView.KcK == null)
      {
        bool = true;
      }
      else if (((ArrayList)localObject).size() != localProfileEditPhoneNumberView.KcK.length)
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
            break label168;
          }
          if (!((String)((Iterator)localObject).next()).equals(localProfileEditPhoneNumberView.KcK[i]))
          {
            bool = true;
            break;
          }
          i += 1;
        }
        label168:
        bool = false;
      }
    }
    enableOptionMenu(false);
    AppMethodBeat.o(37772);
  }
  
  private void bnu(String paramString)
  {
    AppMethodBeat.i(37781);
    if (af.isNullOrNil(paramString))
    {
      AppMethodBeat.o(37781);
      return;
    }
    paramString = new o(paramString);
    if (!paramString.exists())
    {
      AppMethodBeat.o(37781);
      return;
    }
    if (paramString.length() > 204800L)
    {
      h.c(this, getString(2131757853), null, true);
      AppMethodBeat.o(37781);
      return;
    }
    float f = com.tencent.mm.cb.a.getDensity(this);
    paramString = BackwardSupportUtil.BitmapFactory.decodeFile(this.PUQ, f);
    if (paramString != null)
    {
      this.PUK.setVisibility(8);
      this.PUN.setVisibility(8);
      this.PUM.setVisibility(0);
      this.PUM.setImageBitmap(paramString);
      this.PUR = true;
    }
    AppMethodBeat.o(37781);
  }
  
  private String bnv(String paramString)
  {
    AppMethodBeat.i(37791);
    if (!com.tencent.mm.vfs.s.YS(paramString))
    {
      AppMethodBeat.o(37791);
      return null;
    }
    int i = BackwardSupportUtil.ExifHelper.getExifOrientation(paramString);
    Object localObject = new StringBuilder();
    com.tencent.mm.bd.c.bez();
    localObject = com.tencent.mm.bd.c.Pr(this.username) + ".tmp";
    if (!BitmapUtil.createThumbNail(paramString, 960, 960, Bitmap.CompressFormat.JPEG, 70, (String)localObject))
    {
      Log.e("MiroMsg.ContactRemarkInfoModUI", "createThumbNail big pic fail");
      AppMethodBeat.o(37791);
      return null;
    }
    if ((i != 0) && (!BitmapUtil.rotate((String)localObject, i, Bitmap.CompressFormat.JPEG, 70, (String)localObject)))
    {
      Log.e("MiroMsg.ContactRemarkInfoModUI", "rotate big pic fail");
      AppMethodBeat.o(37791);
      return null;
    }
    AppMethodBeat.o(37791);
    return localObject;
  }
  
  private void gUA()
  {
    AppMethodBeat.i(37779);
    this.PUG.setFocusableInTouchMode(true);
    this.PUG.requestFocus();
    this.PUF.clearFocus();
    this.PUH.clearFocus();
    this.PVa.clearFocus();
    hideVKB();
    AppMethodBeat.o(37779);
  }
  
  private void gUB()
  {
    AppMethodBeat.i(37780);
    com.tencent.mm.bd.c.bez();
    Bitmap localBitmap = com.tencent.mm.bd.c.Pu(this.username);
    if (localBitmap != null)
    {
      this.PUK.setVisibility(8);
      this.PUN.setVisibility(8);
      this.PUM.setVisibility(0);
      this.PUM.setImageBitmap(localBitmap);
    }
    this.PUR = true;
    AppMethodBeat.o(37780);
  }
  
  private void gUC()
  {
    AppMethodBeat.i(37782);
    if (!this.PVj)
    {
      AppMethodBeat.o(37782);
      return;
    }
    Object localObject2 = new cqe();
    ((cqe)localObject2).MvG = this.username;
    dbl localdbl = new dbl();
    localdbl.MGv = new LinkedList();
    Object localObject3 = this.PVa.getPhoneNumberList();
    Object localObject1 = new ArrayList();
    if (localObject3 != null)
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        if (com.tencent.mm.plugin.bbom.c.ahc(str))
        {
          dbk localdbk = new dbk();
          localdbk.MGu = str;
          localdbl.MGv.add(localdbk);
          ((ArrayList)localObject1).add(str);
        }
      }
    }
    localdbl.oTz = ((ArrayList)localObject1).size();
    ((cqe)localObject2).Mvx = localdbl;
    bg.aVF();
    com.tencent.mm.model.c.aSM().d(new k.a(60, (com.tencent.mm.bw.a)localObject2));
    bg.aVF();
    localObject2 = com.tencent.mm.model.c.aSN().Kn(this.username);
    if ((localObject2 != null) && ((int)((com.tencent.mm.contact.c)localObject2).gMZ > 0) && (com.tencent.mm.contact.c.oR(((ax)localObject2).field_type)))
    {
      localObject1 = com.tencent.mm.contact.a.j((ArrayList)localObject1);
      Log.i("MiroMsg.ContactRemarkInfoModUI", "[dealModPhoneNumberList] username:%s %s", new Object[] { this.username, localObject1 });
      this.contact.Ci((String)localObject1);
      com.tencent.mm.contact.a.g(this.contact);
      bg.aVF();
      com.tencent.mm.model.c.aSN().ao(this.contact);
    }
    AppMethodBeat.o(37782);
  }
  
  private boolean gUD()
  {
    AppMethodBeat.i(37784);
    String str = this.PUH.getText().toString();
    if (((this.fuR == null) || (!this.fuR.equals(str))) && ((!af.isNullOrNil(this.fuR)) || (!af.isNullOrNil(str))))
    {
      AppMethodBeat.o(37784);
      return true;
    }
    AppMethodBeat.o(37784);
    return false;
  }
  
  private boolean gUE()
  {
    AppMethodBeat.i(37785);
    if ((!af.isNullOrNil(this.PUQ)) || (this.PUV))
    {
      AppMethodBeat.o(37785);
      return true;
    }
    AppMethodBeat.o(37785);
    return false;
  }
  
  private void gUF()
  {
    AppMethodBeat.i(37789);
    this.PUV = true;
    this.PUN.setVisibility(8);
    this.PUK.setVisibility(0);
    this.PUM.setVisibility(8);
    this.PUM.setImageBitmap(null);
    amS();
    AppMethodBeat.o(37789);
  }
  
  private void gUG()
  {
    AppMethodBeat.i(37792);
    if (!af.isNullOrNil(this.yDk))
    {
      this.PUX.setVisibility(0);
      this.PUY.setVisibility(8);
      this.PUX.a(this.PUZ, this.PUZ);
      AppMethodBeat.o(37792);
      return;
    }
    this.PUX.setVisibility(8);
    this.PUY.setVisibility(0);
    AppMethodBeat.o(37792);
  }
  
  private void gUH()
  {
    AppMethodBeat.i(37793);
    bg.aVF();
    this.contact = com.tencent.mm.model.c.aSN().Kn(this.username);
    this.yDk = this.contact.field_contactLabelIds;
    this.PUZ = com.tencent.mm.plugin.label.a.a.ecg().aCJ(this.yDk);
    gUG();
    AppMethodBeat.o(37793);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(37786);
    boolean bool1 = gUE();
    boolean bool2 = Co(true);
    boolean bool3 = gUD();
    if ((bool1) || (bool2) || (bool3))
    {
      h.c(this, getString(2131758029), null, getString(2131758031), getString(2131758030), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
  
  public int getLayoutId()
  {
    return 2131493786;
  }
  
  public void initView()
  {
    AppMethodBeat.i(37778);
    this.PUG = ((TextView)findViewById(2131299065));
    this.PUI = ((TextView)findViewById(2131299073));
    this.PUJ = ((TextView)findViewById(2131299071));
    this.PUK = ((TextView)findViewById(2131299072));
    this.PUF = ((MMClearEditText)findViewById(2131299064));
    this.PUH = ((MMEditText)findViewById(2131299063));
    this.PUM = ((ImageView)findViewById(2131306837));
    this.PUN = ((ImageView)findViewById(2131306838));
    this.PUL = ((TextView)findViewById(2131310528));
    this.uhh = findViewById(2131299062);
    this.PVa = ((ProfileEditPhoneNumberView)findViewById(2131304815));
    this.PVa.rjX = this.contact;
    Object localObject1 = this.PVa;
    Object localObject2 = this.PVb;
    String str = this.PVc;
    ((ProfileEditPhoneNumberView)localObject1).KcI = ((String)localObject2);
    ((ProfileEditPhoneNumberView)localObject1).KcJ = str;
    ((ProfileEditPhoneNumberView)localObject1).eEV();
    this.PVa.KcN = new ContactRemarkInfoModUI.11(this);
    this.PUX = ((MMTagPanel)findViewById(2131299060));
    this.PUX.setPanelClickable(false);
    this.PUY = ((TextView)findViewById(2131299058));
    this.PUY.setText(2131763130);
    this.PUX.setOnClickListener(this.PUW);
    this.PUY.setOnClickListener(this.PUW);
    setMMTitle(2131757968);
    label621:
    int i;
    if (!af.isNullOrNil(this.cgo))
    {
      this.PUF.setText(l.b(this, af.nullAsNil(this.cgo), this.PUF.getTextSize()));
      this.PUI.setText(l.b(this, af.nullAsNil(this.cgo), this.PUI.getTextSize()));
      this.PUF.setSelection(this.PUF.getText().length());
      localObject1 = l.b(this, af.nullAsNil(this.fuR), this.PUJ.getTextSize());
      this.PUH.setText((CharSequence)localObject1);
      this.PUH.setSelection(this.PUH.getText().length());
      if (!af.isNullOrNil(this.fuR))
      {
        this.PUJ.setText(l.b(this, af.nullAsNil(this.fuR), this.PUJ.getTextSize()));
        this.PUJ.setTextColor(getContext().getResources().getColor(2131099746));
      }
      this.PUI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37761);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          ContactRemarkInfoModUI.f(ContactRemarkInfoModUI.this);
          ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, false, paramAnonymousView.getId());
          ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).performClick();
          ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).requestFocus();
          ContactRemarkInfoModUI.this.showVKB();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37761);
        }
      });
      this.PUJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37762);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          ContactRemarkInfoModUI.f(ContactRemarkInfoModUI.this);
          ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, false, paramAnonymousView.getId());
          ContactRemarkInfoModUI.h(ContactRemarkInfoModUI.this).performClick();
          ContactRemarkInfoModUI.h(ContactRemarkInfoModUI.this).requestFocus();
          ContactRemarkInfoModUI.this.showVKB();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37762);
        }
      });
      this.PUF.addTextChangedListener(this.PVd);
      this.PUL.setText(f.dp(800, this.PUH.getEditableText().toString()));
      this.PUH.addTextChangedListener(this.PVe);
      if (af.isNullOrNil(this.jid)) {
        break label905;
      }
      this.PUK.setVisibility(8);
      this.PUM.setVisibility(0);
      com.tencent.mm.bd.c.bez();
      if (com.tencent.mm.bd.c.Ps(this.username)) {
        break label898;
      }
      com.tencent.mm.bd.c.bez().a(this.username, this.jid, new c.a()
      {
        public final void fI(final boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(37754);
          ContactRemarkInfoModUI.t(ContactRemarkInfoModUI.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(37753);
              if (!paramAnonymousBoolean)
              {
                h.cD(ContactRemarkInfoModUI.this, ContactRemarkInfoModUI.this.getString(2131755804));
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
      this.PUM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37763);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
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
            com.tencent.mm.bd.c.bez();
          }
          for (paramAnonymousView = com.tencent.mm.bd.c.Pr(ContactRemarkInfoModUI.k(ContactRemarkInfoModUI.this));; paramAnonymousView = ContactRemarkInfoModUI.n(ContactRemarkInfoModUI.this))
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
      this.PUK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37764);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if ((af.isNullOrNil(ContactRemarkInfoModUI.l(ContactRemarkInfoModUI.this))) || (ContactRemarkInfoModUI.o(ContactRemarkInfoModUI.this)))
          {
            ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, false);
            ContactRemarkInfoModUI.j(ContactRemarkInfoModUI.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37764);
        }
      });
      localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(this.contact.field_username);
      if ((localObject1 != null) && (!af.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).bnK())) && (!((com.tencent.mm.plugin.account.friend.a.a)localObject1).bnK().equals(this.PUF.getText().toString()))) {
        break label925;
      }
      i = 0;
      label701:
      if ((i == 0) && (this.kgm == 14) && (!af.isNullOrNil(this.KpU)) && (!this.KpU.equals(this.PUF.getText().toString()))) {
        break label1056;
      }
      label744:
      addTextOptionMenu(0, getString(2131755858), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(37765);
          ContactRemarkInfoModUI.p(ContactRemarkInfoModUI.this);
          ContactRemarkInfoModUI.this.hideVKB();
          AppMethodBeat.o(37765);
          return false;
        }
      }, null, t.b.OGU);
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
      if (!af.isNullOrNil(this.cgo)) {
        break label1196;
      }
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.PUN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37750);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, true);
          ContactRemarkInfoModUI.j(ContactRemarkInfoModUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37750);
        }
      });
      if (!this.PUU)
      {
        this.PUT = true;
        ae(true, -1);
      }
      gUA();
      AppMethodBeat.o(37778);
      return;
      this.PUF.setText(l.b(this, af.nullAsNil(this.contact.arI()), this.PUF.getTextSize()));
      this.PUI.setText(l.b(this, af.nullAsNil(this.contact.arI()), this.PUF.getTextSize()));
      break;
      label898:
      gUB();
      break label621;
      label905:
      this.PUK.setVisibility(0);
      this.PUM.setVisibility(8);
      break label621;
      label925:
      this.PUO = ((TextView)findViewById(2131304824));
      this.PUP = findViewById(2131304816);
      this.PUP.setVisibility(0);
      this.PUO.setText(af.nullAsNil(getString(2131758056, new Object[] { ((com.tencent.mm.plugin.account.friend.a.a)localObject1).bnK() })));
      localObject2 = new m(getString(2131768753));
      ((m)localObject2).setSpan(new c(((com.tencent.mm.plugin.account.friend.a.a)localObject1).bnK()), 0, ((m)localObject2).length(), 17);
      this.PUO.append(" ");
      this.PUO.append((CharSequence)localObject2);
      this.PUO.setMovementMethod(LinkMovementMethod.getInstance());
      i = 1;
      break label701;
      label1056:
      this.PUO = ((TextView)findViewById(2131304824));
      this.PUP = findViewById(2131304816);
      this.PUP.setVisibility(0);
      this.PUO.setText(l.b(this, af.nullAsNil(getString(2131758055, new Object[] { this.KpU })), this.PUO.getTextSize()));
      localObject1 = new m(getString(2131768753));
      ((m)localObject1).setSpan(new c(this.KpU), 0, ((m)localObject1).length(), 17);
      this.PUO.append(" ");
      this.PUO.append((CharSequence)localObject1);
      this.PUO.setMovementMethod(LinkMovementMethod.getInstance());
      break label744;
      label1196:
      enableOptionMenu(false);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(37788);
    Log.i("MiroMsg.ContactRemarkInfoModUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent == null)
    {
      Log.e("MiroMsg.ContactRemarkInfoModUI", "data shouldnot be null");
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
      bg.aVF();
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.s.h(localContext, paramIntent, com.tencent.mm.model.c.aSY());
      if (paramIntent == null)
      {
        AppMethodBeat.o(37788);
        return;
      }
      this.PUQ = bnv(paramIntent);
      bnu(this.PUQ);
      this.PUS = true;
      this.PUV = false;
      amS();
      AppMethodBeat.o(37788);
      return;
    case 200: 
      localContext = getApplicationContext();
      bg.aVF();
      paramIntent = com.tencent.mm.ui.tools.a.i(localContext, paramIntent, com.tencent.mm.model.c.aSY());
      if (paramIntent == null)
      {
        AppMethodBeat.o(37788);
        return;
      }
      this.PUQ = bnv(paramIntent);
      bnu(this.PUQ);
      this.PUS = true;
      this.PUV = false;
      amS();
      AppMethodBeat.o(37788);
      return;
    case 400: 
      if (paramIntent.getBooleanExtra("response_delete", false)) {
        gUF();
      }
      AppMethodBeat.o(37788);
      return;
    }
    if ((Co(true)) || (gUD()) || (gUE()) || (paramIntent.getBooleanExtra("hasLableChange", false)))
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
    bg.azz().a(575, this);
    bg.azz().a(576, this);
    this.kgm = getIntent().getIntExtra("Contact_Scene", 9);
    this.KpU = getIntent().getStringExtra("Contact_RoomNickname");
    this.PUU = getIntent().getBooleanExtra("view_mode", false);
    this.PVf = getIntent().getStringExtra("contact_auto_app_phone_from_chatting");
    this.PVb = getIntent().getStringExtra("contact_phone_number_by_md5");
    this.PVc = getIntent().getStringExtra("contact_phone_number_list");
    this.username = getIntent().getStringExtra("Contact_User");
    if (af.isNullOrNil(this.username))
    {
      finish();
      AppMethodBeat.o(37773);
      return;
    }
    bg.aVF();
    this.contact = com.tencent.mm.model.c.aSN().Kn(this.username);
    this.cgo = this.contact.field_conRemark;
    this.fuR = this.contact.fuR;
    this.jid = this.contact.fuS;
    this.yDk = this.contact.field_contactLabelIds;
    this.PUZ = com.tencent.mm.plugin.label.a.a.ecg().aCJ(this.yDk);
    initView();
    amS();
    int i;
    if ((this.contact != null) && (as.bjp(this.contact.field_username))) {
      i = 1;
    }
    while (i != 0) {
      if (this.PUF == null)
      {
        AppMethodBeat.o(37773);
        return;
        i = 0;
      }
      else
      {
        paramBundle = (ViewGroup)this.PUF.getParent();
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
    bg.azz().b(575, this);
    bg.azz().b(576, this);
    this.PUF.removeTextChangedListener(this.PVd);
    this.PUH.removeTextChangedListener(this.PVe);
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
    bg.aVF();
    com.tencent.mm.model.c.aSN().remove(this.PVg);
    super.onPause();
    AppMethodBeat.o(37775);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(37774);
    super.onResume();
    bg.aVF();
    com.tencent.mm.model.c.aSN().add(this.PVg);
    gUH();
    AppMethodBeat.o(37774);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(37790);
    Log.i("MiroMsg.ContactRemarkInfoModUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.iLh != null)
    {
      this.iLh.dismiss();
      this.iLh = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      h.c(this, getString(2131755803), null, true);
      AppMethodBeat.o(37790);
      return;
    }
    if (paramq.getType() == 575)
    {
      if (this.PUQ != null)
      {
        paramString = new o(this.PUQ);
        if (paramString.exists())
        {
          com.tencent.mm.bd.c.bez();
          paramString.am(new o(com.tencent.mm.bd.c.Pr(this.username)));
        }
      }
      paramString = ((com.tencent.mm.bd.b)paramq).jid;
      if (!af.isNullOrNil(paramString)) {
        this.jid = paramString;
      }
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(37790);
      return;
      if (paramq.getType() == 576)
      {
        this.PUQ = null;
        this.jid = null;
        this.PUR = false;
        bg.aVF();
        this.contact = com.tencent.mm.model.c.aSN().Kn(this.username);
        this.contact.Cd("");
        bg.aVF();
        com.tencent.mm.model.c.aSN().c(this.username, this.contact);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class c
    extends ClickableSpan
  {
    public String remark;
    
    public c(String paramString)
    {
      this.remark = paramString;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(37769);
      ContactRemarkInfoModUI.f(ContactRemarkInfoModUI.this);
      ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, true, -1);
      ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).setText(l.b(ContactRemarkInfoModUI.this, af.nullAsNil(this.remark), ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).getTextSize()));
      ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).setSelection(ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).getText().length());
      ContactRemarkInfoModUI.w(ContactRemarkInfoModUI.this).setVisibility(8);
      AppMethodBeat.o(37769);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(37770);
      paramTextPaint.setColor(ContactRemarkInfoModUI.this.getResources().getColor(2131100053));
      paramTextPaint.setUnderlineText(false);
      AppMethodBeat.o(37770);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI
 * JD-Core Version:    0.7.0.1
 */