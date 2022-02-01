package com.tencent.mm.ui.contact;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.mmdata.rpt.ma;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelmulti.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView;
import com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView.a;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.dqb;
import com.tencent.mm.protocal.protobuf.edj;
import com.tencent.mm.protocal.protobuf.edk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.a.e;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactRemarkInfoModUI
  extends MMActivity
  implements com.tencent.mm.am.h, com.tencent.mm.ui.tools.h
{
  private View CzL;
  private HashSet<String> JWF;
  private HashSet<String> JWG;
  private HashSet<String> JWH;
  private ObjectAnimator JWJ;
  private String JWt;
  private HashSet<String> JWw;
  private String NaB;
  private String NaC;
  private int NaD;
  private boolean NaE;
  private int NaF;
  private int NaG;
  private List<String> NaH;
  private HashSet<String> NaI;
  private List<String> Nau;
  private ImageView Nax;
  private LinearLayout Nay;
  private TextView Naz;
  private String Ynb;
  private MMClearEditText afcP;
  private View afcQ;
  private TextView afcR;
  private MMEditText afcS;
  private TextView afcT;
  private TextView afcU;
  private ScrollView afcV;
  private LinearLayout afcW;
  private ImageView afcX;
  private TextView afcY;
  private TextView afcZ;
  private ImageView afda;
  private ImageView afdb;
  private TextView afdc;
  private View afdd;
  private String afde;
  private boolean afdf;
  private boolean afdg;
  private boolean afdh;
  private boolean afdi;
  private boolean afdj;
  private boolean afdk;
  private ContactRemarkInfoModUI.a afdl;
  private List<String> afdm;
  private HashSet<String> afdn;
  private HashSet<String> afdo;
  private ProfileEditPhoneNumberView afdp;
  private View afdq;
  private String afdr;
  private String afds;
  private TextWatcher afdt;
  private b afdu;
  private String afdv;
  private MStorageEx.IOnStorageChange afdw;
  boolean afdx;
  boolean afdy;
  private boolean afdz;
  private au contact;
  private String dYO;
  private long hTS;
  private String kal;
  private com.tencent.mm.ui.tools.i lKz;
  private String oRL;
  private ProgressDialog osY;
  private ProgressDialog pNH;
  private int pUt;
  private String username;
  
  public ContactRemarkInfoModUI()
  {
    AppMethodBeat.i(37771);
    this.afdf = false;
    this.afdg = false;
    this.afdh = false;
    this.afdi = false;
    this.afdj = false;
    this.afdk = false;
    this.afdl = new ContactRemarkInfoModUI.a(this, (byte)0);
    this.Nau = new ArrayList();
    this.NaH = new ArrayList();
    this.afdm = new ArrayList();
    this.afdn = new HashSet();
    this.JWw = new HashSet();
    this.NaD = 0;
    this.afdo = new HashSet();
    this.NaI = new HashSet();
    this.JWF = new HashSet();
    this.JWG = new HashSet();
    this.JWH = new HashSet();
    this.afdt = new TextWatcher()
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
    this.afdu = new b((byte)0);
    this.JWJ = null;
    this.afdw = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(252965);
        Log.d("MiroMsg.ContactRemarkInfoModUI", "cpan onNotifyChange");
        ContactRemarkInfoModUI.e(ContactRemarkInfoModUI.this);
        AppMethodBeat.o(252965);
      }
    };
    this.afdx = true;
    this.afdy = false;
    this.afdz = false;
    AppMethodBeat.o(37771);
  }
  
  private static boolean H(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(253042);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramList1 != null) {
      localArrayList1.addAll(paramList1);
    }
    if (paramList2 != null) {
      localArrayList2.addAll(paramList2);
    }
    Collections.sort(localArrayList1);
    Collections.sort(localArrayList2);
    if (localArrayList1.equals(localArrayList2))
    {
      AppMethodBeat.o(253042);
      return false;
    }
    AppMethodBeat.o(253042);
    return true;
  }
  
  private boolean My(boolean paramBoolean)
  {
    AppMethodBeat.i(37783);
    if (com.tencent.mm.platformtools.ab.isNullOrNil(this.dYO))
    {
      if (!this.afdh)
      {
        AppMethodBeat.o(37783);
        return false;
      }
      AppMethodBeat.o(37783);
      return true;
    }
    String str = this.afcP.getText().toString();
    if (!paramBoolean)
    {
      if (((this.dYO == null) || (!this.dYO.equals(str))) && ((!com.tencent.mm.platformtools.ab.isNullOrNil(this.dYO)) || (!com.tencent.mm.platformtools.ab.isNullOrNil(str))))
      {
        AppMethodBeat.o(37783);
        return true;
      }
      AppMethodBeat.o(37783);
      return false;
    }
    if (((this.dYO == null) || (!this.dYO.equals(str))) && ((!com.tencent.mm.platformtools.ab.isNullOrNil(this.dYO)) || (!com.tencent.mm.platformtools.ab.isNullOrNil(str)))) {}
    for (int i = 1; (i != 0) && ((str == null) || (!str.equals(this.contact.field_nickname))); i = 0)
    {
      AppMethodBeat.o(37783);
      return true;
    }
    AppMethodBeat.o(37783);
    return false;
  }
  
  private void aMU()
  {
    AppMethodBeat.i(37772);
    ProfileEditPhoneNumberView localProfileEditPhoneNumberView = this.afdp;
    Object localObject = localProfileEditPhoneNumberView.getPhoneNumberList();
    boolean bool;
    if ((localObject == null) || (((ArrayList)localObject).isEmpty()))
    {
      if (localProfileEditPhoneNumberView.XZv == null) {
        break label168;
      }
      bool = true;
    }
    for (;;)
    {
      this.afdz = bool;
      if ((!jyn()) && (!jyo()) && (!My(false)) && (!this.afdz)) {
        break;
      }
      enableOptionMenu(true);
      AppMethodBeat.o(37772);
      return;
      if (localProfileEditPhoneNumberView.XZv == null)
      {
        bool = true;
      }
      else if (((ArrayList)localObject).size() != localProfileEditPhoneNumberView.XZv.length)
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
          if (!((String)((Iterator)localObject).next()).equals(localProfileEditPhoneNumberView.XZv[i]))
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
  
  private void au(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(253027);
    if ((this.afdi) && ((!paramBoolean) || (!com.tencent.mm.platformtools.ab.isNullOrNil(this.kal))))
    {
      if (paramInt == R.h.fCD)
      {
        this.afcU.setVisibility(8);
        this.CzL.setVisibility(0);
        AppMethodBeat.o(253027);
      }
    }
    else
    {
      this.afcU.setVisibility(0);
      this.CzL.setVisibility(8);
    }
    AppMethodBeat.o(253027);
  }
  
  private void bBK(String paramString)
  {
    AppMethodBeat.i(37781);
    if (com.tencent.mm.platformtools.ab.isNullOrNil(paramString))
    {
      AppMethodBeat.o(37781);
      return;
    }
    paramString = new com.tencent.mm.vfs.u(paramString);
    if (!paramString.jKS())
    {
      AppMethodBeat.o(37781);
      return;
    }
    if (paramString.length() > 204800L)
    {
      k.c(this, getString(R.l.gBd), null, true);
      AppMethodBeat.o(37781);
      return;
    }
    float f = com.tencent.mm.cd.a.getDensity(this);
    paramString = BackwardSupportUtil.BitmapFactory.decodeFile(this.afde, f);
    if (paramString != null)
    {
      this.afdb.setVisibility(8);
      this.afda.setVisibility(0);
      this.afda.setImageBitmap(paramString);
      this.afcW.setVisibility(8);
      this.afdf = true;
    }
    AppMethodBeat.o(37781);
  }
  
  private void bBL(String paramString)
  {
    AppMethodBeat.i(253045);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MiroMsg.ContactRemarkInfoModUI", "tag is empty");
      AppMethodBeat.o(253045);
      return;
    }
    paramString = paramString.trim();
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MiroMsg.ContactRemarkInfoModUI", "new tag is empty");
      AppMethodBeat.o(253045);
      return;
    }
    aw localaw = com.tencent.mm.plugin.label.d.fTa().bxl(paramString);
    if ((this.Nau == null) || (!this.Nau.contains(paramString)) || ((localaw != null) && (localaw.field_isTemporary))) {
      this.JWw.add(paramString);
    }
    if ((this.afdn != null) && (this.afdn.contains(paramString))) {
      this.afdn.remove(paramString);
    }
    AppMethodBeat.o(253045);
  }
  
  private String bBM(String paramString)
  {
    AppMethodBeat.i(37791);
    if (!com.tencent.mm.vfs.y.ZC(paramString))
    {
      AppMethodBeat.o(37791);
      return null;
    }
    int i = BackwardSupportUtil.ExifHelper.getExifOrientation(paramString);
    Object localObject = new StringBuilder();
    com.tencent.mm.ba.c.bLL();
    localObject = com.tencent.mm.ba.c.OO(this.username) + ".tmp";
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
  
  private void goBack()
  {
    AppMethodBeat.i(37786);
    boolean bool1 = jyo();
    boolean bool2 = My(true);
    boolean bool3 = jyn();
    if ((bool1) || (bool2) || (bool3))
    {
      k.b(this, getString(R.l.gBO), null, getString(R.l.gBQ), getString(R.l.gBP), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(252947);
          ContactRemarkInfoModUI.this.hm(1L);
          ContactRemarkInfoModUI.t(ContactRemarkInfoModUI.this);
          AppMethodBeat.o(252947);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(252956);
          ContactRemarkInfoModUI.this.hm(2L);
          ContactRemarkInfoModUI.this.finish();
          AppMethodBeat.o(252956);
        }
      });
      AppMethodBeat.o(37786);
      return;
    }
    hm(2L);
    hideVKB();
    finish();
    AppMethodBeat.o(37786);
  }
  
  private void jw(List<String> paramList)
  {
    AppMethodBeat.i(253056);
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.Naz.setText("");
      AppMethodBeat.o(253056);
      return;
    }
    String str = "";
    int i = 0;
    if (i < paramList.size())
    {
      StringBuilder localStringBuilder = new StringBuilder().append(str).append((String)paramList.get(i));
      if (i < paramList.size() - 1) {}
      for (str = "，";; str = "")
      {
        str = str;
        i += 1;
        break;
      }
    }
    this.Naz.setText(str);
    AppMethodBeat.o(253056);
  }
  
  private void jyj()
  {
    AppMethodBeat.i(253025);
    if (this.afcP == null)
    {
      AppMethodBeat.o(253025);
      return;
    }
    ViewGroup localViewGroup1 = (ViewGroup)this.afcP.getParent().getParent();
    ViewGroup localViewGroup2 = (ViewGroup)localViewGroup1.getParent();
    int j = localViewGroup2.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = localViewGroup2.getChildAt(i);
      if (localView != localViewGroup1) {
        localView.setVisibility(8);
      }
      i += 1;
    }
    AppMethodBeat.o(253025);
  }
  
  private void jyk()
  {
    AppMethodBeat.i(37779);
    this.afcR.setFocusableInTouchMode(true);
    this.afcR.requestFocus();
    this.afcP.clearFocus();
    this.afcS.clearFocus();
    this.afdp.clearFocus();
    hideVKB();
    AppMethodBeat.o(37779);
  }
  
  private void jyl()
  {
    AppMethodBeat.i(37780);
    com.tencent.mm.ba.c.bLL();
    Bitmap localBitmap = com.tencent.mm.ba.c.OR(this.username);
    if (localBitmap != null)
    {
      this.afcW.setVisibility(8);
      this.afdb.setVisibility(8);
      this.afda.setVisibility(0);
      this.afda.setImageBitmap(localBitmap);
    }
    this.afdf = true;
    AppMethodBeat.o(37780);
  }
  
  private void jym()
  {
    AppMethodBeat.i(37782);
    if (!this.afdz)
    {
      AppMethodBeat.o(37782);
      return;
    }
    Object localObject2 = new dqb();
    ((dqb)localObject2).aaWl = this.username;
    edk localedk = new edk();
    localedk.abiF = new LinkedList();
    Object localObject3 = this.afdp.getPhoneNumberList();
    Object localObject1 = new ArrayList();
    if (localObject3 != null)
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        if (com.tencent.mm.plugin.bbom.c.aie(str))
        {
          edj localedj = new edj();
          localedj.abiE = str;
          localedk.abiF.add(localedj);
          ((ArrayList)localObject1).add(str);
        }
      }
    }
    localedk.vgN = ((ArrayList)localObject1).size();
    ((dqb)localObject2).aaWb = localedk;
    bh.bCz();
    com.tencent.mm.model.c.bzz().d(new k.a(60, (com.tencent.mm.bx.a)localObject2));
    bh.bCz();
    localObject2 = com.tencent.mm.model.c.bzA().JE(this.username);
    if ((localObject2 != null) && ((int)((com.tencent.mm.contact.d)localObject2).maN > 0) && (com.tencent.mm.contact.d.rs(((com.tencent.mm.autogen.b.az)localObject2).field_type)))
    {
      localObject1 = com.tencent.mm.contact.a.m((ArrayList)localObject1);
      Log.i("MiroMsg.ContactRemarkInfoModUI", "[dealModPhoneNumberList] username:%s %s", new Object[] { this.username, localObject1 });
      this.contact.BB((String)localObject1);
      com.tencent.mm.contact.a.h(this.contact);
      bh.bCz();
      com.tencent.mm.model.c.bzA().aA(this.contact);
    }
    AppMethodBeat.o(37782);
  }
  
  private boolean jyn()
  {
    AppMethodBeat.i(37784);
    String str = this.afcS.getText().toString();
    if (((this.kal == null) || (!this.kal.equals(str))) && ((!com.tencent.mm.platformtools.ab.isNullOrNil(this.kal)) || (!com.tencent.mm.platformtools.ab.isNullOrNil(str))))
    {
      AppMethodBeat.o(37784);
      return true;
    }
    AppMethodBeat.o(37784);
    return false;
  }
  
  private boolean jyo()
  {
    AppMethodBeat.i(37785);
    if ((!com.tencent.mm.platformtools.ab.isNullOrNil(this.afde)) || (this.afdk))
    {
      AppMethodBeat.o(37785);
      return true;
    }
    AppMethodBeat.o(37785);
    return false;
  }
  
  private void jyp()
  {
    AppMethodBeat.i(37789);
    this.afdk = true;
    this.afdb.setVisibility(8);
    this.afcW.setVisibility(0);
    this.afda.setVisibility(8);
    this.afda.setImageBitmap(null);
    aMU();
    AppMethodBeat.o(37789);
  }
  
  private void jyq()
  {
    AppMethodBeat.i(37793);
    bh.bCz();
    this.contact = com.tencent.mm.model.c.bzA().JE(this.username);
    this.JWt = this.contact.field_contactLabelIds;
    this.NaH = com.tencent.mm.plugin.label.a.a.fTb().aJJ(this.JWt);
    this.Nau.clear();
    if (this.NaH != null) {
      this.Nau.addAll(this.NaH);
    }
    List localList;
    for (;;)
    {
      localList = com.tencent.mm.plugin.label.a.a.fTb().fSY();
      if (localList == null) {
        break;
      }
      int i = 0;
      while (i < localList.size())
      {
        if (!this.Nau.contains(localList.get(i))) {
          this.Nau.add((String)localList.get(i));
        }
        i += 1;
      }
      this.Nau = new ArrayList();
      this.NaH = new ArrayList();
    }
    this.afdm.clear();
    this.afdm.addAll(this.NaH);
    Iterator localIterator = this.NaH.iterator();
    while (localIterator.hasNext()) {
      bBL((String)localIterator.next());
    }
    this.NaF = localList.size();
    this.NaG = this.NaH.size();
    this.afdo.addAll(this.NaH);
    jw(this.NaH);
    AppMethodBeat.o(37793);
  }
  
  private List<EditText> lU(View paramView)
  {
    AppMethodBeat.i(253021);
    ArrayList localArrayList = new ArrayList();
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        View localView = paramView.getChildAt(i);
        if (((localView instanceof EditText)) && (((EditText)localView).isFocused())) {
          localArrayList.add((EditText)localView);
        }
        localArrayList.addAll(lU(localView));
        i += 1;
      }
    }
    AppMethodBeat.o(253021);
    return localArrayList;
  }
  
  public int getLayoutId()
  {
    return R.i.giA;
  }
  
  public final void hm(final long paramLong)
  {
    AppMethodBeat.i(253286);
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(252973);
        ma localma = new ma();
        Object localObject1 = ContactRemarkInfoModUI.B(ContactRemarkInfoModUI.this);
        localma.uI(ContactRemarkInfoModUI.o(ContactRemarkInfoModUI.this));
        long l;
        Object localObject2;
        int i;
        label67:
        String str;
        if (ContactRemarkInfoModUI.C(ContactRemarkInfoModUI.this))
        {
          l = 1L;
          localma.jaJ = l;
          localObject2 = ((List)localObject1).iterator();
          i = 0;
          if (!((Iterator)localObject2).hasNext()) {
            break label117;
          }
          str = (String)((Iterator)localObject2).next();
          if (!ContactRemarkInfoModUI.D(ContactRemarkInfoModUI.this).contains(str)) {
            break label914;
          }
          i += 1;
        }
        label902:
        label905:
        label908:
        label911:
        label914:
        for (;;)
        {
          break label67;
          l = 0L;
          break;
          label117:
          localma.jaL = i;
          l = 0L;
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            str = (String)((Iterator)localObject2).next();
            if (ContactRemarkInfoModUI.E(ContactRemarkInfoModUI.this).contains(str)) {
              l += 1L;
            }
          }
          localma.jaN = l;
          localObject2 = ((List)localObject1).iterator();
          int j = 0;
          if (((Iterator)localObject2).hasNext())
          {
            str = (String)((Iterator)localObject2).next();
            if (!ContactRemarkInfoModUI.F(ContactRemarkInfoModUI.this).contains(str)) {
              break label911;
            }
            j += 1;
          }
          for (;;)
          {
            break;
            localma.jaM = j;
            localObject2 = ((List)localObject1).iterator();
            int k = 0;
            if (((Iterator)localObject2).hasNext())
            {
              str = (String)((Iterator)localObject2).next();
              if (!ContactRemarkInfoModUI.G(ContactRemarkInfoModUI.this).contains(str)) {
                break label908;
              }
              k += 1;
            }
            for (;;)
            {
              break;
              localma.jaK = k;
              localma.iGM = (System.currentTimeMillis() - ContactRemarkInfoModUI.H(ContactRemarkInfoModUI.this));
              localma.jaR = ContactRemarkInfoModUI.I(ContactRemarkInfoModUI.this);
              localma.jaS = paramLong;
              localma.jaO = ContactRemarkInfoModUI.J(ContactRemarkInfoModUI.this);
              int i1 = ContactRemarkInfoModUI.this.getIntent().getIntExtra("key_label_click_source", 0);
              if (i1 > 0) {
                localma.aIQ();
              }
              int n = 0;
              localObject2 = ((List)localObject1).iterator();
              int m = 0;
              if (((Iterator)localObject2).hasNext())
              {
                str = (String)((Iterator)localObject2).next();
                if (ContactRemarkInfoModUI.K(ContactRemarkInfoModUI.this).contains(str)) {
                  break label905;
                }
                m += 1;
              }
              for (;;)
              {
                break;
                localObject2 = ContactRemarkInfoModUI.K(ContactRemarkInfoModUI.this).iterator();
                if (((Iterator)localObject2).hasNext())
                {
                  if (((List)localObject1).contains((String)((Iterator)localObject2).next())) {
                    break label902;
                  }
                  n += 1;
                }
                for (;;)
                {
                  break;
                  localma.iuA = 1L;
                  localObject2 = ContactRemarkInfoModUI.k(ContactRemarkInfoModUI.this).getText().toString().trim();
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = "";
                  }
                  if (!com.tencent.mm.platformtools.ab.isNullOrNil(ContactRemarkInfoModUI.L(ContactRemarkInfoModUI.this))) {
                    if (ContactRemarkInfoModUI.L(ContactRemarkInfoModUI.this).equals(localObject1)) {
                      ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, 3);
                    }
                  }
                  for (;;)
                  {
                    localma.jaT = ContactRemarkInfoModUI.O(ContactRemarkInfoModUI.this);
                    localma.jaQ = m;
                    localma.jaP = n;
                    localma.bMH();
                    Log.i("MiroMsg.ContactRemarkInfoModUI", "22865 setAddedLabelCnt = " + m + ",setRemovedLabelCnt = " + n + ",source = " + i1 + ",oriLabelCnt = " + ContactRemarkInfoModUI.J(ContactRemarkInfoModUI.this) + ",opResult = " + paramLong + ",totalLabelCnt = " + ContactRemarkInfoModUI.I(ContactRemarkInfoModUI.this) + ",selectNewLabelCnt = " + k + ",selectAddLabelCnt = " + j + ",addRemarkType = " + ContactRemarkInfoModUI.O(ContactRemarkInfoModUI.this) + ",scene= 1,newLebalCountBySearch = " + i + ",searchAddLabelCnt = " + l);
                    AppMethodBeat.o(252973);
                    return;
                    ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, 2);
                    continue;
                    if (!ContactRemarkInfoModUI.M(ContactRemarkInfoModUI.this)) {
                      ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, 3);
                    } else if (!com.tencent.mm.platformtools.ab.isNullOrNil(ContactRemarkInfoModUI.N(ContactRemarkInfoModUI.this)))
                    {
                      if (ContactRemarkInfoModUI.N(ContactRemarkInfoModUI.this).equals(localObject1)) {
                        ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, 1);
                      } else if (Util.isNullOrNil((String)localObject1)) {
                        ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, 3);
                      } else {
                        ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, 2);
                      }
                    }
                    else if (((String)localObject1).equals(ContactRemarkInfoModUI.N(ContactRemarkInfoModUI.this))) {
                      ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, 3);
                    } else {
                      ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, 2);
                    }
                  }
                }
              }
            }
          }
        }
      }
    });
    AppMethodBeat.o(253286);
  }
  
  public void initView()
  {
    AppMethodBeat.i(37778);
    this.afcR = ((TextView)findViewById(R.h.fCy));
    this.afcT = ((TextView)findViewById(R.h.fCH));
    this.afcU = ((TextView)findViewById(R.h.fCD));
    this.afcY = ((TextView)findViewById(R.h.fCG));
    this.afcV = ((ScrollView)findViewById(R.h.scrollview));
    this.afcW = ((LinearLayout)findViewById(R.h.fCE));
    this.afcX = ((ImageView)findViewById(R.h.fCF));
    this.afcX.setImageDrawable(bb.m(this, R.k.icons_outlined_camera, getResources().getColor(R.e.BW_70)));
    this.afcP = ((MMClearEditText)findViewById(R.h.fCx));
    this.afcQ = findViewById(R.h.fBp);
    this.afcS = ((MMEditText)findViewById(R.h.fCw));
    this.afda = ((ImageView)findViewById(R.h.fUJ));
    this.afdb = ((ImageView)findViewById(R.h.fUK));
    this.afcZ = ((TextView)findViewById(R.h.wordcount));
    this.CzL = findViewById(R.h.fCv);
    this.afdq = findViewById(R.h.fNY);
    this.afdp = ((ProfileEditPhoneNumberView)findViewById(R.h.fOo));
    this.afdp.xVS = this.contact;
    if ((this.afds == null) && (this.contact != null))
    {
      this.afds = this.contact.kar;
      Log.i("MiroMsg.ContactRemarkInfoModUI", "is null phone, mContactPhoneNumberList: %s, mContactPhoneNumberByMD5: %s, ", new Object[] { this.afds, this.afdr });
    }
    Object localObject1 = this.afdp;
    Object localObject2 = this.afdr;
    String str = this.afds;
    ((ProfileEditPhoneNumberView)localObject1).XZt = ((String)localObject2);
    ((ProfileEditPhoneNumberView)localObject1).XZu = str;
    ((ProfileEditPhoneNumberView)localObject1).gCe();
    this.afdp.XZy = new ProfileEditPhoneNumberView.a()
    {
      public final void iKF()
      {
        AppMethodBeat.i(252972);
        com.tencent.mm.model.ab.K(ContactRemarkInfoModUI.f(ContactRemarkInfoModUI.this));
        com.tencent.mm.modelmulti.u.bKY().wG(7);
        AppMethodBeat.o(252972);
      }
      
      public final void iKG()
      {
        AppMethodBeat.i(252975);
        if (!ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).iKB()) {
          ContactRemarkInfoModUI.h(ContactRemarkInfoModUI.this).setVisibility(0);
        }
        for (;;)
        {
          ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this);
          AppMethodBeat.o(252975);
          return;
          ContactRemarkInfoModUI.h(ContactRemarkInfoModUI.this).setVisibility(4);
        }
      }
      
      public final void kH(View paramAnonymousView)
      {
        AppMethodBeat.i(252978);
        ContactRemarkInfoModUI.this.hideVKB(paramAnonymousView);
        AppMethodBeat.o(252978);
      }
      
      public final void onChange()
      {
        AppMethodBeat.i(252970);
        ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this);
        AppMethodBeat.o(252970);
      }
    };
    label532:
    label858:
    int i;
    if (!this.afdp.iKB())
    {
      this.afdq.setVisibility(0);
      this.Nay = ((LinearLayout)findViewById(R.h.fCt));
      this.Naz = ((TextView)findViewById(R.h.fCs));
      this.Naz.setVisibility(0);
      this.Nax = ((ImageView)findViewById(R.h.fso));
      if (this.Nax != null) {
        this.Nax.setImageDrawable(bb.m(this, R.k.icons_outlined_arrow, com.tencent.mm.cd.a.w(getContext(), R.e.BW_70)));
      }
      this.Nay.setOnClickListener(this.afdl);
      setMMTitle("");
      if (com.tencent.mm.platformtools.ab.isNullOrNil(this.dYO)) {
        break label1118;
      }
      this.afcP.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, com.tencent.mm.platformtools.ab.nullAsNil(this.dYO), this.afcP.getTextSize()));
      this.afcT.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, com.tencent.mm.platformtools.ab.nullAsNil(this.dYO), this.afcT.getTextSize()));
      if (this.afcP.getText() != null) {
        this.NaB = this.afcP.getText().toString();
      }
      this.NaC = this.dYO;
      this.afcP.setSelection(this.afcP.getText().length());
      localObject1 = com.tencent.mm.pluginsdk.ui.span.p.b(this, com.tencent.mm.platformtools.ab.nullAsNil(this.kal), this.afcU.getTextSize());
      this.afcS.setText((CharSequence)localObject1);
      this.afcS.setSelection(this.afcS.getText().length());
      if (!com.tencent.mm.platformtools.ab.isNullOrNil(this.kal))
      {
        this.afcU.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, com.tencent.mm.platformtools.ab.nullAsNil(this.kal), this.afcU.getTextSize()));
        this.afcU.setTextColor(getContext().getResources().getColor(R.e.FG_0));
      }
      com.tencent.mm.ui.tools.b.c.i(this.afcP).aEg(32).a(new com.tencent.mm.ui.tools.b.c.a()
      {
        public final void Tw(String paramAnonymousString) {}
        
        public final void Tx(String paramAnonymousString) {}
        
        public final void eY(String paramAnonymousString) {}
      });
      this.afcT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37763);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          ContactRemarkInfoModUI.i(ContactRemarkInfoModUI.this);
          localObject = ContactRemarkInfoModUI.this;
          paramAnonymousView.getId();
          ContactRemarkInfoModUI.j((ContactRemarkInfoModUI)localObject);
          ContactRemarkInfoModUI.k(ContactRemarkInfoModUI.this).performClick();
          ContactRemarkInfoModUI.k(ContactRemarkInfoModUI.this).requestFocus();
          ContactRemarkInfoModUI.this.showVKB();
          ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37763);
        }
      });
      this.afcU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37764);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          ContactRemarkInfoModUI.l(ContactRemarkInfoModUI.this);
          ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, false, paramAnonymousView.getId());
          ContactRemarkInfoModUI.c(ContactRemarkInfoModUI.this).performClick();
          ContactRemarkInfoModUI.c(ContactRemarkInfoModUI.this).requestFocus();
          ContactRemarkInfoModUI.this.showVKB();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37764);
        }
      });
      this.afcP.addTextChangedListener(this.afdt);
      this.afcZ.setText(g.ej(400, this.afcS.getEditableText().toString()));
      this.afcS.addTextChangedListener(this.afdu);
      if (com.tencent.mm.platformtools.ab.isNullOrNil(this.oRL)) {
        break label1184;
      }
      this.afcW.setVisibility(8);
      this.afda.setVisibility(0);
      com.tencent.mm.ba.c.bLL();
      if (com.tencent.mm.ba.c.OP(this.username)) {
        break label1177;
      }
      com.tencent.mm.ba.c.bLL().a(this.username, this.oRL, new com.tencent.mm.ba.c.a()
      {
        public final void hk(final boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(252996);
          ContactRemarkInfoModUI.x(ContactRemarkInfoModUI.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(253033);
              if (!paramAnonymousBoolean)
              {
                k.cZ(ContactRemarkInfoModUI.this, ContactRemarkInfoModUI.this.getString(R.l.app_err_system_busy_tip));
                ContactRemarkInfoModUI.v(ContactRemarkInfoModUI.this).setVisibility(0);
                ContactRemarkInfoModUI.w(ContactRemarkInfoModUI.this).setVisibility(8);
                ContactRemarkInfoModUI.x(ContactRemarkInfoModUI.this).setVisibility(8);
                AppMethodBeat.o(253033);
                return;
              }
              ContactRemarkInfoModUI.y(ContactRemarkInfoModUI.this);
              AppMethodBeat.o(253033);
            }
          });
          AppMethodBeat.o(252996);
        }
      });
      this.afda.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(252928);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          if (!ContactRemarkInfoModUI.m(ContactRemarkInfoModUI.this))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252928);
            return;
          }
          ContactRemarkInfoModUI.n(ContactRemarkInfoModUI.this);
          localObject = new Intent(ContactRemarkInfoModUI.this, ContactRemarkImagePreviewUI.class);
          ((Intent)localObject).putExtra("Contact_User", ContactRemarkInfoModUI.o(ContactRemarkInfoModUI.this));
          if ((!com.tencent.mm.platformtools.ab.isNullOrNil(ContactRemarkInfoModUI.p(ContactRemarkInfoModUI.this))) && (!ContactRemarkInfoModUI.q(ContactRemarkInfoModUI.this))) {
            com.tencent.mm.ba.c.bLL();
          }
          for (paramAnonymousView = com.tencent.mm.ba.c.OO(ContactRemarkInfoModUI.o(ContactRemarkInfoModUI.this));; paramAnonymousView = ContactRemarkInfoModUI.r(ContactRemarkInfoModUI.this))
          {
            ((Intent)localObject).putExtra("remark_image_path", paramAnonymousView);
            ((Intent)localObject).putExtra("view_temp_remark_image", ContactRemarkInfoModUI.q(ContactRemarkInfoModUI.this));
            ContactRemarkInfoModUI.this.startActivityForResult((Intent)localObject, 400);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252928);
            return;
          }
        }
      });
      this.afcW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(252930);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if ((com.tencent.mm.platformtools.ab.isNullOrNil(ContactRemarkInfoModUI.p(ContactRemarkInfoModUI.this))) || (ContactRemarkInfoModUI.s(ContactRemarkInfoModUI.this)))
          {
            ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, false);
            ContactRemarkInfoModUI.n(ContactRemarkInfoModUI.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(252930);
        }
      });
      localObject1 = com.tencent.mm.plugin.account.b.getAddrUploadStg().SR(this.contact.field_username);
      if ((localObject1 != null) && (!com.tencent.mm.platformtools.ab.isNullOrNil(((com.tencent.mm.plugin.account.friend.model.a)localObject1).bWI())) && (!((com.tencent.mm.plugin.account.friend.model.a)localObject1).bWI().equals(this.afcP.getText().toString()))) {
        break label1204;
      }
      i = 0;
      label938:
      if ((i == 0) && (this.pUt == 14) && (!com.tencent.mm.platformtools.ab.isNullOrNil(this.Ynb)) && (!this.Ynb.equals(this.afcP.getText().toString()))) {
        break label1336;
      }
      label981:
      addTextOptionMenu(0, getString(R.l.app_finish), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(252980);
          ContactRemarkInfoModUI.t(ContactRemarkInfoModUI.this);
          ContactRemarkInfoModUI.this.hideVKB();
          ContactRemarkInfoModUI.this.hm(1L);
          AppMethodBeat.o(252980);
          return false;
        }
      }, null, y.b.adEJ);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(252983);
          ContactRemarkInfoModUI.u(ContactRemarkInfoModUI.this);
          AppMethodBeat.o(252983);
          return true;
        }
      });
      if (!com.tencent.mm.platformtools.ab.isNullOrNil(this.dYO)) {
        break label1477;
      }
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.afdb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(252989);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, true);
          ContactRemarkInfoModUI.n(ContactRemarkInfoModUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(252989);
        }
      });
      if (!this.afdj)
      {
        Log.i("MiroMsg.ContactRemarkInfoModUI", "oncreate initWithViewMode");
        this.afdi = true;
        au(true, -1);
      }
      jyk();
      if (this.afcQ != null) {
        this.afcQ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(252988);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            ContactRemarkInfoModUI.k(ContactRemarkInfoModUI.this).jmg();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252988);
          }
        });
      }
      AppMethodBeat.o(37778);
      return;
      this.afdq.setVisibility(4);
      break;
      label1118:
      this.afcP.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, com.tencent.mm.platformtools.ab.nullAsNil(this.contact.aSU()), this.afcP.getTextSize()));
      this.afcT.setHint(com.tencent.mm.pluginsdk.ui.span.p.b(this, com.tencent.mm.platformtools.ab.nullAsNil(this.contact.aSU()), this.afcP.getTextSize()));
      break label532;
      label1177:
      jyl();
      break label858;
      label1184:
      this.afcW.setVisibility(0);
      this.afda.setVisibility(8);
      break label858;
      label1204:
      this.afdc = ((TextView)findViewById(R.h.fOt));
      this.afdd = findViewById(R.h.fOp);
      this.afdd.setVisibility(0);
      this.afdc.setText(com.tencent.mm.platformtools.ab.nullAsNil(getString(R.l.gCd, new Object[] { ((com.tencent.mm.plugin.account.friend.model.a)localObject1).bWI() })));
      localObject2 = new q(getString(R.l.write_contact_remark));
      ((q)localObject2).setSpan(new c(((com.tencent.mm.plugin.account.friend.model.a)localObject1).bWI()), 0, ((q)localObject2).length(), 17);
      this.afdc.append(" ");
      this.afdc.append((CharSequence)localObject2);
      this.afdc.setMovementMethod(LinkMovementMethod.getInstance());
      i = 1;
      break label938;
      label1336:
      this.afdc = ((TextView)findViewById(R.h.fOt));
      this.afdd = findViewById(R.h.fOp);
      this.afdd.setVisibility(0);
      this.afdc.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, com.tencent.mm.platformtools.ab.nullAsNil(getString(R.l.gCc, new Object[] { this.Ynb })), this.afdc.getTextSize()));
      localObject1 = new q(getString(R.l.write_contact_remark));
      ((q)localObject1).setSpan(new c(this.Ynb), 0, ((q)localObject1).length(), 17);
      this.afdc.append(" ");
      this.afdc.append((CharSequence)localObject1);
      this.afdc.setMovementMethod(LinkMovementMethod.getInstance());
      break label981;
      label1477:
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
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(37788);
      return;
    case 100: 
      localObject1 = getApplicationContext();
      bh.bCz();
      paramIntent = t.g((Context)localObject1, paramIntent, com.tencent.mm.model.c.bzL());
      if (paramIntent == null)
      {
        AppMethodBeat.o(37788);
        return;
      }
      this.afde = bBM(paramIntent);
      bBK(this.afde);
      this.afdg = true;
      this.afdk = false;
      aMU();
      AppMethodBeat.o(37788);
      return;
    case 200: 
      localObject1 = getApplicationContext();
      bh.bCz();
      paramIntent = com.tencent.mm.ui.tools.b.i((Context)localObject1, paramIntent, com.tencent.mm.model.c.bzL());
      if (paramIntent == null)
      {
        AppMethodBeat.o(37788);
        return;
      }
      this.afde = bBM(paramIntent);
      bBK(this.afde);
      this.afdg = true;
      this.afdk = false;
      aMU();
      AppMethodBeat.o(37788);
      return;
    case 400: 
      if (paramIntent.getBooleanExtra("response_delete", false)) {
        jyp();
      }
      AppMethodBeat.o(37788);
      return;
    }
    Object localObject1 = paramIntent.getStringArrayListExtra("result_label_id_list");
    Object localObject2 = com.tencent.mm.plugin.label.a.a.fTb().fSY();
    if ((!H((List)localObject1, this.afdm)) && (!H((List)localObject2, this.Nau)))
    {
      AppMethodBeat.o(37788);
      return;
    }
    Object localObject3 = paramIntent.getStringArrayListExtra("contact_search_label_new_list");
    if (localObject3 != null) {
      this.NaI.addAll((Collection)localObject3);
    }
    localObject3 = paramIntent.getStringArrayListExtra("contact_search_label_add_list");
    if (localObject3 != null) {
      this.JWF.addAll((Collection)localObject3);
    }
    localObject3 = paramIntent.getStringArrayListExtra("contact_select_label_add_list");
    if (localObject3 != null) {
      this.JWH.addAll((Collection)localObject3);
    }
    localObject3 = paramIntent.getStringArrayListExtra("contact_select_label_new_list");
    if (localObject3 != null) {
      this.JWG.addAll((Collection)localObject3);
    }
    localObject3 = ((ArrayList)localObject1).iterator();
    String str;
    while (((Iterator)localObject3).hasNext())
    {
      str = (String)((Iterator)localObject3).next();
      if (!this.afdm.contains(str)) {
        bBL(str);
      }
    }
    localObject3 = this.afdm.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      str = (String)((Iterator)localObject3).next();
      if (!((ArrayList)localObject1).contains(str))
      {
        if ((this.NaH != null) && (this.NaH.contains(str))) {
          this.afdn.add(str);
        }
        if ((this.JWw != null) && (this.JWw.contains(str))) {
          this.JWw.remove(str);
        }
      }
    }
    if (this.Nau == null) {
      this.Nau = new ArrayList();
    }
    this.Nau = ((List)localObject2);
    localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (this.Nau.contains(localObject3)) {
        this.Nau.remove(localObject3);
      }
    }
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).addAll(this.Nau);
    this.Nau.clear();
    this.Nau.addAll((Collection)localObject1);
    this.Nau.addAll((Collection)localObject2);
    if (localObject1 != null)
    {
      this.afdm.clear();
      this.afdm.addAll((Collection)localObject1);
    }
    jw(this.afdm);
    if ((My(true)) || (jyn()) || (jyo()) || (paramIntent.getBooleanExtra("hasLableChange", false)))
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
    bh.aZW().a(575, this);
    bh.aZW().a(576, this);
    bh.aZW().a(638, this);
    this.pUt = getIntent().getIntExtra("Contact_Scene", 9);
    this.Ynb = getIntent().getStringExtra("Contact_RoomNickname");
    this.afdj = getIntent().getBooleanExtra("view_mode", false);
    this.afdv = getIntent().getStringExtra("contact_auto_app_phone_from_chatting");
    this.afdr = getIntent().getStringExtra("contact_phone_number_by_md5");
    this.afds = getIntent().getStringExtra("contact_phone_number_list");
    this.username = getIntent().getStringExtra("Contact_User");
    if (com.tencent.mm.platformtools.ab.isNullOrNil(this.username))
    {
      finish();
      AppMethodBeat.o(37773);
      return;
    }
    this.hTS = System.currentTimeMillis();
    bh.bCz();
    this.contact = com.tencent.mm.model.c.bzA().JE(this.username);
    this.dYO = this.contact.field_conRemark;
    this.kal = this.contact.kal;
    this.oRL = this.contact.kam;
    this.JWt = this.contact.field_contactLabelIds;
    this.NaH = com.tencent.mm.plugin.label.a.a.fTb().aJJ(this.JWt);
    this.afdm.clear();
    if (this.NaH != null) {
      this.afdm.addAll(this.NaH);
    }
    for (;;)
    {
      initView();
      aMU();
      int i = j;
      if (this.contact != null)
      {
        i = j;
        if (au.bwO(this.contact.field_username)) {
          i = 1;
        }
      }
      if (i != 0) {
        jyj();
      }
      jyq();
      setActionbarColor(getContext().getResources().getColor(R.e.white));
      hideActionbarLine();
      setMMTitle("");
      this.mController.setStatusBarColor(getResources().getColor(a.c.white));
      this.lKz = new com.tencent.mm.ui.tools.i(this);
      this.lKz.afIL = this;
      AppMethodBeat.o(37773);
      return;
      this.NaH = new ArrayList();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(37776);
    bh.aZW().b(638, this);
    bh.aZW().b(575, this);
    bh.aZW().b(576, this);
    this.afcP.removeTextChangedListener(this.afdt);
    this.afcS.removeTextChangedListener(this.afdu);
    if (this.lKz != null) {
      this.lKz.close();
    }
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
  
  public void onKeyboardHeightChanged(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(253218);
    Log.i("MiroMsg.ContactRemarkInfoModUI", "onKeyboardHeightChanged, height:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((this.JWJ != null) && (this.JWJ.isRunning())) {
      this.JWJ.cancel();
    }
    ScrollView localScrollView = this.afcV;
    Log.i("MiroMsg.ContactRemarkInfoModUI", "container:%s", new Object[] { localScrollView });
    if (localScrollView == null)
    {
      AppMethodBeat.o(253218);
      return;
    }
    int i = paramInt;
    if (localScrollView == this.afcV)
    {
      Object localObject = lU(this.afcV);
      Log.i("MiroMsg.ContactRemarkInfoModUI", "onKeyboardHeightChanged, editTexts:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      if (((List)localObject).isEmpty())
      {
        AppMethodBeat.o(253218);
        return;
      }
      localObject = (EditText)((List)localObject).get(((List)localObject).size() - 1);
      int[] arrayOfInt = new int[2];
      ((EditText)localObject).getLocationOnScreen(arrayOfInt);
      i = com.tencent.mm.ui.widget.happybubble.c.getScreenWH(getContext())[1];
      i = arrayOfInt[1] - (i - paramInt);
    }
    Log.i("MiroMsg.ContactRemarkInfoModUI", "onKeyboardHeightChanged, translateHeigth:%s", new Object[] { Integer.valueOf(i) });
    if (i > 0) {
      if (localScrollView.getTranslationY() != 0.0F) {
        localScrollView.setTranslationY(0.0F);
      }
    }
    for (this.JWJ = ObjectAnimator.ofFloat(localScrollView, "translationY", new float[] { 0.0F, -i });; this.JWJ = ObjectAnimator.ofFloat(localScrollView, "translationY", new float[] { localScrollView.getTranslationY(), 0.0F }))
    {
      this.JWJ.setDuration(200L);
      this.JWJ.setInterpolator(new androidx.g.a.a.b());
      this.JWJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(252961);
          Log.i("MiroMsg.ContactRemarkInfoModUI", "onAnimationUpdate %s", new Object[] { Float.valueOf(((Float)paramAnonymousValueAnimator.getAnimatedValue("translationY")).floatValue()) });
          AppMethodBeat.o(252961);
        }
      });
      this.JWJ.start();
      AppMethodBeat.o(253218);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(37775);
    bh.aZW().b(635, this);
    bh.bCz();
    com.tencent.mm.model.c.bzA().remove(this.afdw);
    if (this.lKz != null) {
      this.lKz.close();
    }
    super.onPause();
    AppMethodBeat.o(37775);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(37774);
    super.onResume();
    bh.aZW().a(635, this);
    bh.bCz();
    com.tencent.mm.model.c.bzA().add(this.afdw);
    if (this.lKz != null) {
      this.lKz.start();
    }
    AppMethodBeat.o(37774);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(37790);
    Log.i("MiroMsg.ContactRemarkInfoModUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.osY != null)
    {
      this.osY.dismiss();
      this.osY = null;
    }
    if ((this.pNH != null) && (this.pNH.isShowing())) {
      this.pNH.dismiss();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      k.c(this, getString(R.l.app_err_server_busy_tip), null, true);
      AppMethodBeat.o(37790);
      return;
    }
    paramInt1 = paramp.getType();
    if (paramInt1 == 575)
    {
      if (this.afde != null)
      {
        paramString = new com.tencent.mm.vfs.u(this.afde);
        if (paramString.jKS())
        {
          com.tencent.mm.ba.c.bLL();
          paramString.am(new com.tencent.mm.vfs.u(com.tencent.mm.ba.c.OO(this.username)));
        }
      }
      paramString = ((com.tencent.mm.ba.b)paramp).oRL;
      if (!com.tencent.mm.platformtools.ab.isNullOrNil(paramString)) {
        this.oRL = paramString;
      }
      finish();
      AppMethodBeat.o(37790);
      return;
    }
    if (paramInt1 == 576)
    {
      this.afde = null;
      this.oRL = null;
      this.afdf = false;
      bh.bCz();
      this.contact = com.tencent.mm.model.c.bzA().JE(this.username);
      this.contact.Bw("");
      bh.bCz();
      com.tencent.mm.model.c.bzA().d(this.username, this.contact);
      finish();
    }
    AppMethodBeat.o(37790);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(253244);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (this.lKz != null) {
      this.lKz.start();
    }
    AppMethodBeat.o(253244);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(253287);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(e.class);
    AppMethodBeat.o(253287);
  }
  
  final class b
    implements TextWatcher
  {
    private int Ppb = 400;
    private String afdC = "";
    
    private b() {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(37768);
      this.Ppb = g.ej(400, paramEditable.toString());
      if (this.Ppb < 0) {
        this.Ppb = 0;
      }
      if (ContactRemarkInfoModUI.b(ContactRemarkInfoModUI.this) != null) {
        ContactRemarkInfoModUI.b(ContactRemarkInfoModUI.this).setText(this.Ppb);
      }
      ContactRemarkInfoModUI.c(ContactRemarkInfoModUI.this).removeTextChangedListener(this);
      if (paramEditable != null)
      {
        paramEditable = paramEditable.toString();
        if (!Util.isNullOrNil(paramEditable))
        {
          int i = g.bCx(paramEditable);
          g.ek(400, paramEditable);
          if (i > 400)
          {
            i = g.ei(400, paramEditable);
            if ((i > 0) && (i < 400) && (i < paramEditable.length()))
            {
              ContactRemarkInfoModUI.c(ContactRemarkInfoModUI.this).setText(paramEditable.substring(0, i + 1));
              ContactRemarkInfoModUI.c(ContactRemarkInfoModUI.this).setSelection(ContactRemarkInfoModUI.c(ContactRemarkInfoModUI.this).getText().length());
              ax.jlo();
            }
          }
        }
      }
      ContactRemarkInfoModUI.c(ContactRemarkInfoModUI.this).addTextChangedListener(this);
      ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this);
      AppMethodBeat.o(37768);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
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
      Log.i("MiroMsg.ContactRemarkInfoModUI", "oncreate WriteRemarkSpan");
      ContactRemarkInfoModUI.i(ContactRemarkInfoModUI.this);
      ContactRemarkInfoModUI.l(ContactRemarkInfoModUI.this);
      ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, true, -1);
      ContactRemarkInfoModUI.j(ContactRemarkInfoModUI.this);
      ContactRemarkInfoModUI.k(ContactRemarkInfoModUI.this).setText(com.tencent.mm.pluginsdk.ui.span.p.b(ContactRemarkInfoModUI.this, com.tencent.mm.platformtools.ab.nullAsNil(this.remark), ContactRemarkInfoModUI.k(ContactRemarkInfoModUI.this).getTextSize()));
      ContactRemarkInfoModUI.k(ContactRemarkInfoModUI.this).setSelection(ContactRemarkInfoModUI.k(ContactRemarkInfoModUI.this).getText().length());
      ContactRemarkInfoModUI.A(ContactRemarkInfoModUI.this).setVisibility(8);
      AppMethodBeat.o(37769);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(37770);
      paramTextPaint.setColor(ContactRemarkInfoModUI.this.getResources().getColor(R.e.blue_text_color));
      paramTextPaint.setUnderlineText(false);
      AppMethodBeat.o(37770);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI
 * JD-Core Version:    0.7.0.1
 */