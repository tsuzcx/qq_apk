package com.tencent.mm.ui.contact;

import android.animation.ObjectAnimator;
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
import com.tencent.mm.an.t;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.b.a.jo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView;
import com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.protocal.protobuf.cyv;
import com.tencent.mm.protocal.protobuf.dkz;
import com.tencent.mm.protocal.protobuf.dla;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.w.b;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactRemarkInfoModUI
  extends MMActivity
  implements com.tencent.mm.an.i, com.tencent.mm.ui.tools.h
{
  private String EeH;
  private HashSet<String> EeJ;
  private HashSet<String> EeK;
  private HashSet<String> EeR;
  private HashSet<String> EeS;
  private HashSet<String> EeT;
  private ObjectAnimator EeU;
  private List<String> Hci;
  private ImageView Hcl;
  private LinearLayout Hcm;
  private TextView Hcn;
  private String Hcq;
  private String Hcr;
  private int Hcs;
  private boolean Hct;
  private int Hcu;
  private int Hcv;
  private List<String> Hcw;
  private HashSet<String> Hcx;
  private String RqK;
  private ImageView XrA;
  private TextView XrB;
  private View XrC;
  private String XrD;
  private boolean XrE;
  private boolean XrF;
  private boolean XrG;
  private boolean XrH;
  private boolean XrI;
  private boolean XrJ;
  private ContactRemarkInfoModUI.a XrK;
  private List<String> XrL;
  private HashSet<String> XrM;
  private ProfileEditPhoneNumberView XrN;
  private View XrO;
  private String XrP;
  private String XrQ;
  private TextWatcher XrR;
  private ContactRemarkInfoModUI.b XrS;
  private String XrT;
  private MStorageEx.IOnStorageChange XrU;
  boolean XrV;
  boolean XrW;
  private boolean XrX;
  private MMClearEditText Xrp;
  private TextView Xrq;
  private MMEditText Xrr;
  private TextView Xrs;
  private TextView Xrt;
  private ScrollView Xru;
  private LinearLayout Xrv;
  private ImageView Xrw;
  private TextView Xrx;
  private TextView Xry;
  private ImageView Xrz;
  private String cip;
  private as contact;
  private long fOa;
  private String hDq;
  private com.tencent.mm.ui.tools.i jij;
  private ProgressDialog lBo;
  private String lYG;
  private ProgressDialog mRa;
  private int mXL;
  private String username;
  private View ybl;
  
  public ContactRemarkInfoModUI()
  {
    AppMethodBeat.i(37771);
    this.XrE = false;
    this.XrF = false;
    this.XrG = false;
    this.XrH = false;
    this.XrI = false;
    this.XrJ = false;
    this.XrK = new ContactRemarkInfoModUI.a(this, (byte)0);
    this.Hci = new ArrayList();
    this.Hcw = new ArrayList();
    this.XrL = new ArrayList();
    this.EeJ = new HashSet();
    this.EeK = new HashSet();
    this.Hcs = 0;
    this.XrM = new HashSet();
    this.Hcx = new HashSet();
    this.EeR = new HashSet();
    this.EeS = new HashSet();
    this.EeT = new HashSet();
    this.XrR = new ContactRemarkInfoModUI.1(this);
    this.XrS = new ContactRemarkInfoModUI.b(this, (byte)0);
    this.EeU = null;
    this.XrU = new ContactRemarkInfoModUI.14(this);
    this.XrV = true;
    this.XrW = false;
    this.XrX = false;
    AppMethodBeat.o(37771);
  }
  
  private boolean GK(boolean paramBoolean)
  {
    AppMethodBeat.i(37783);
    if (ae.isNullOrNil(this.cip))
    {
      if (!this.XrG)
      {
        AppMethodBeat.o(37783);
        return false;
      }
      AppMethodBeat.o(37783);
      return true;
    }
    String str = this.Xrp.getText().toString();
    if (!paramBoolean)
    {
      if (((this.cip == null) || (!this.cip.equals(str))) && ((!ae.isNullOrNil(this.cip)) || (!ae.isNullOrNil(str))))
      {
        AppMethodBeat.o(37783);
        return true;
      }
      AppMethodBeat.o(37783);
      return false;
    }
    if (((this.cip == null) || (!this.cip.equals(str))) && ((!ae.isNullOrNil(this.cip)) || (!ae.isNullOrNil(str)))) {}
    for (int i = 1; (i != 0) && ((str == null) || (!str.equals(this.contact.field_nickname))); i = 0)
    {
      AppMethodBeat.o(37783);
      return true;
    }
    AppMethodBeat.o(37783);
    return false;
  }
  
  private void as(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(265521);
    if ((this.XrH) && ((!paramBoolean) || (!ae.isNullOrNil(this.hDq))))
    {
      if (paramInt == R.h.dBp)
      {
        this.Xrt.setVisibility(8);
        this.ybl.setVisibility(0);
        AppMethodBeat.o(265521);
      }
    }
    else
    {
      this.Xrt.setVisibility(0);
      this.ybl.setVisibility(8);
    }
    AppMethodBeat.o(265521);
  }
  
  private void asT()
  {
    AppMethodBeat.i(37772);
    ProfileEditPhoneNumberView localProfileEditPhoneNumberView = this.XrN;
    Object localObject = localProfileEditPhoneNumberView.getPhoneNumberList();
    boolean bool;
    if ((localObject == null) || (((ArrayList)localObject).isEmpty()))
    {
      if (localProfileEditPhoneNumberView.Rdp == null) {
        break label175;
      }
      bool = true;
    }
    for (;;)
    {
      this.XrX = bool;
      if ((!hUx()) && (!hUy()) && (!GK(false)) && (!this.XrX) && (!hUA())) {
        break;
      }
      enableOptionMenu(true);
      AppMethodBeat.o(37772);
      return;
      if (localProfileEditPhoneNumberView.Rdp == null)
      {
        bool = true;
      }
      else if (((ArrayList)localObject).size() != localProfileEditPhoneNumberView.Rdp.length)
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
            break label175;
          }
          if (!((String)((Iterator)localObject).next()).equals(localProfileEditPhoneNumberView.Rdp[i]))
          {
            bool = true;
            break;
          }
          i += 1;
        }
        label175:
        bool = false;
      }
    }
    enableOptionMenu(false);
    AppMethodBeat.o(37772);
  }
  
  private void bzU(String paramString)
  {
    AppMethodBeat.i(37781);
    if (ae.isNullOrNil(paramString))
    {
      AppMethodBeat.o(37781);
      return;
    }
    paramString = new com.tencent.mm.vfs.q(paramString);
    if (!paramString.ifE())
    {
      AppMethodBeat.o(37781);
      return;
    }
    if (paramString.length() > 204800L)
    {
      com.tencent.mm.ui.base.h.c(this, getString(R.l.eyl), null, true);
      AppMethodBeat.o(37781);
      return;
    }
    float f = com.tencent.mm.ci.a.getDensity(this);
    paramString = BackwardSupportUtil.BitmapFactory.decodeFile(this.XrD, f);
    if (paramString != null)
    {
      this.XrA.setVisibility(8);
      this.Xrz.setVisibility(0);
      this.Xrz.setImageBitmap(paramString);
      this.Xrv.setVisibility(8);
      this.XrE = true;
    }
    AppMethodBeat.o(37781);
  }
  
  private void bzV(String paramString)
  {
    AppMethodBeat.i(265524);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MiroMsg.ContactRemarkInfoModUI", "tag is empty");
      AppMethodBeat.o(265524);
      return;
    }
    paramString = paramString.trim();
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MiroMsg.ContactRemarkInfoModUI", "new tag is empty");
      AppMethodBeat.o(265524);
      return;
    }
    com.tencent.mm.storage.au localau = e.eLd().bvY(paramString);
    if ((this.Hci == null) || (!this.Hci.contains(paramString)) || ((localau != null) && (localau.field_isTemporary))) {
      this.EeK.add(paramString);
    }
    if ((this.EeJ != null) && (this.EeJ.contains(paramString))) {
      this.EeJ.remove(paramString);
    }
    AppMethodBeat.o(265524);
  }
  
  private String bzW(String paramString)
  {
    AppMethodBeat.i(37791);
    if (!com.tencent.mm.vfs.u.agG(paramString))
    {
      AppMethodBeat.o(37791);
      return null;
    }
    int i = BackwardSupportUtil.ExifHelper.getExifOrientation(paramString);
    Object localObject = new StringBuilder();
    com.tencent.mm.bg.c.bnY();
    localObject = com.tencent.mm.bg.c.WO(this.username) + ".tmp";
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
    boolean bool1 = hUy();
    boolean bool2 = GK(true);
    boolean bool3 = hUx();
    boolean bool4 = hUA();
    if ((bool1) || (bool2) || (bool3) || (bool4))
    {
      com.tencent.mm.ui.base.h.c(this, getString(R.l.eyW), null, getString(R.l.eyY), getString(R.l.eyX), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(37757);
          ContactRemarkInfoModUI.this.Ph(1L);
          ContactRemarkInfoModUI.t(ContactRemarkInfoModUI.this);
          AppMethodBeat.o(37757);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(257077);
          ContactRemarkInfoModUI.this.Ph(2L);
          ContactRemarkInfoModUI.this.finish();
          AppMethodBeat.o(257077);
        }
      });
      AppMethodBeat.o(37786);
      return;
    }
    Ph(2L);
    hideVKB();
    finish();
    AppMethodBeat.o(37786);
  }
  
  private void gw(List<String> paramList)
  {
    AppMethodBeat.i(265525);
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.Hcn.setText("");
      AppMethodBeat.o(265525);
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
    this.Hcn.setText(str);
    AppMethodBeat.o(265525);
  }
  
  private boolean hUA()
  {
    AppMethodBeat.i(265523);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.addAll(this.XrL);
    localArrayList2.addAll(this.Hcw);
    Collections.sort(localArrayList1);
    Collections.sort(localArrayList2);
    if (localArrayList1.equals(localArrayList2))
    {
      AppMethodBeat.o(265523);
      return false;
    }
    AppMethodBeat.o(265523);
    return true;
  }
  
  private void hUB()
  {
    AppMethodBeat.i(37793);
    bh.beI();
    this.contact = com.tencent.mm.model.c.bbL().RG(this.username);
    this.EeH = this.contact.field_contactLabelIds;
    this.Hcw = com.tencent.mm.plugin.label.a.a.eLe().aMQ(this.EeH);
    this.Hci.clear();
    if (this.Hcw != null) {
      this.Hci.addAll(this.Hcw);
    }
    List localList;
    for (;;)
    {
      localList = com.tencent.mm.plugin.label.a.a.eLe().eLb();
      if (localList == null) {
        break;
      }
      int i = 0;
      while (i < localList.size())
      {
        if (!this.Hci.contains(localList.get(i))) {
          this.Hci.add(localList.get(i));
        }
        i += 1;
      }
      this.Hci = new ArrayList();
      this.Hcw = new ArrayList();
    }
    this.XrL.clear();
    this.XrL.addAll(this.Hcw);
    Iterator localIterator = this.Hcw.iterator();
    while (localIterator.hasNext()) {
      bzV((String)localIterator.next());
    }
    this.Hcu = localList.size();
    this.Hcv = this.Hcw.size();
    this.XrM.addAll(this.Hcw);
    gw(this.Hcw);
    AppMethodBeat.o(37793);
  }
  
  private void hUt()
  {
    AppMethodBeat.i(265519);
    if (this.Xrp == null)
    {
      AppMethodBeat.o(265519);
      return;
    }
    ViewGroup localViewGroup1 = (ViewGroup)this.Xrp.getParent();
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
    AppMethodBeat.o(265519);
  }
  
  private void hUu()
  {
    AppMethodBeat.i(37779);
    this.Xrq.setFocusableInTouchMode(true);
    this.Xrq.requestFocus();
    this.Xrp.clearFocus();
    this.Xrr.clearFocus();
    this.XrN.clearFocus();
    hideVKB();
    AppMethodBeat.o(37779);
  }
  
  private void hUv()
  {
    AppMethodBeat.i(37780);
    com.tencent.mm.bg.c.bnY();
    Bitmap localBitmap = com.tencent.mm.bg.c.WR(this.username);
    if (localBitmap != null)
    {
      this.Xrv.setVisibility(8);
      this.XrA.setVisibility(8);
      this.Xrz.setVisibility(0);
      this.Xrz.setImageBitmap(localBitmap);
    }
    this.XrE = true;
    AppMethodBeat.o(37780);
  }
  
  private void hUw()
  {
    AppMethodBeat.i(37782);
    if (!this.XrX)
    {
      AppMethodBeat.o(37782);
      return;
    }
    Object localObject2 = new cyv();
    ((cyv)localObject2).TGE = this.username;
    dla localdla = new dla();
    localdla.TSh = new LinkedList();
    Object localObject3 = this.XrN.getPhoneNumberList();
    Object localObject1 = new ArrayList();
    if (localObject3 != null)
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        if (com.tencent.mm.plugin.bbom.c.aoI(str))
        {
          dkz localdkz = new dkz();
          localdkz.TSg = str;
          localdla.TSh.add(localdkz);
          ((ArrayList)localObject1).add(str);
        }
      }
    }
    localdla.rVx = ((ArrayList)localObject1).size();
    ((cyv)localObject2).TGv = localdla;
    bh.beI();
    com.tencent.mm.model.c.bbK().d(new k.a(60, (com.tencent.mm.cd.a)localObject2));
    bh.beI();
    localObject2 = com.tencent.mm.model.c.bbL().RG(this.username);
    if ((localObject2 != null) && ((int)((d)localObject2).jxt > 0) && (d.rk(((com.tencent.mm.f.c.ax)localObject2).field_type)))
    {
      localObject1 = com.tencent.mm.contact.a.j((ArrayList)localObject1);
      Log.i("MiroMsg.ContactRemarkInfoModUI", "[dealModPhoneNumberList] username:%s %s", new Object[] { this.username, localObject1 });
      this.contact.IW((String)localObject1);
      com.tencent.mm.contact.a.g(this.contact);
      bh.beI();
      com.tencent.mm.model.c.bbL().au(this.contact);
    }
    AppMethodBeat.o(37782);
  }
  
  private boolean hUx()
  {
    AppMethodBeat.i(37784);
    String str = this.Xrr.getText().toString();
    if (((this.hDq == null) || (!this.hDq.equals(str))) && ((!ae.isNullOrNil(this.hDq)) || (!ae.isNullOrNil(str))))
    {
      AppMethodBeat.o(37784);
      return true;
    }
    AppMethodBeat.o(37784);
    return false;
  }
  
  private boolean hUy()
  {
    AppMethodBeat.i(37785);
    if ((!ae.isNullOrNil(this.XrD)) || (this.XrJ))
    {
      AppMethodBeat.o(37785);
      return true;
    }
    AppMethodBeat.o(37785);
    return false;
  }
  
  private void hUz()
  {
    AppMethodBeat.i(37789);
    this.XrJ = true;
    this.XrA.setVisibility(8);
    this.Xrv.setVisibility(0);
    this.Xrz.setVisibility(8);
    this.Xrz.setImageBitmap(null);
    asT();
    AppMethodBeat.o(37789);
  }
  
  private List<EditText> iy(View paramView)
  {
    AppMethodBeat.i(265517);
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
        localArrayList.addAll(iy(localView));
        i += 1;
      }
    }
    AppMethodBeat.o(265517);
    return localArrayList;
  }
  
  private static boolean t(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(265522);
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
      AppMethodBeat.o(265522);
      return false;
    }
    AppMethodBeat.o(265522);
    return true;
  }
  
  public final void A(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(265518);
    Log.i("MiroMsg.ContactRemarkInfoModUI", "onKeyboardHeightChanged, height:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((this.EeU != null) && (this.EeU.isRunning())) {
      this.EeU.cancel();
    }
    ScrollView localScrollView = this.Xru;
    Log.i("MiroMsg.ContactRemarkInfoModUI", "container:%s", new Object[] { localScrollView });
    if (localScrollView == null)
    {
      AppMethodBeat.o(265518);
      return;
    }
    int i = paramInt;
    if (localScrollView == this.Xru)
    {
      Object localObject = iy(this.Xru);
      Log.i("MiroMsg.ContactRemarkInfoModUI", "onKeyboardHeightChanged, editTexts:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      if (((List)localObject).isEmpty())
      {
        AppMethodBeat.o(265518);
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
    for (this.EeU = ObjectAnimator.ofFloat(localScrollView, "translationY", new float[] { 0.0F, -i });; this.EeU = ObjectAnimator.ofFloat(localScrollView, "translationY", new float[] { localScrollView.getTranslationY(), 0.0F }))
    {
      this.EeU.setDuration(200L);
      this.EeU.setInterpolator(new androidx.f.a.a.b());
      this.EeU.addUpdateListener(new ContactRemarkInfoModUI.10(this));
      this.EeU.start();
      AppMethodBeat.o(265518);
      return;
    }
  }
  
  public final void Ph(final long paramLong)
  {
    AppMethodBeat.i(265526);
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(287650);
        jo localjo = new jo();
        Object localObject1 = ContactRemarkInfoModUI.B(ContactRemarkInfoModUI.this);
        localjo.AC(ContactRemarkInfoModUI.o(ContactRemarkInfoModUI.this));
        long l;
        Object localObject2;
        int i;
        label67:
        String str;
        if (ContactRemarkInfoModUI.C(ContactRemarkInfoModUI.this))
        {
          l = 1L;
          localjo.gLo = l;
          localObject2 = ((List)localObject1).iterator();
          i = 0;
          if (!((Iterator)localObject2).hasNext()) {
            break label117;
          }
          str = (String)((Iterator)localObject2).next();
          if (!ContactRemarkInfoModUI.D(ContactRemarkInfoModUI.this).contains(str)) {
            break label878;
          }
          i += 1;
        }
        label866:
        label869:
        label872:
        label875:
        label878:
        for (;;)
        {
          break label67;
          l = 0L;
          break;
          label117:
          localjo.gLq = i;
          l = 0L;
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            str = (String)((Iterator)localObject2).next();
            if (ContactRemarkInfoModUI.E(ContactRemarkInfoModUI.this).contains(str)) {
              l += 1L;
            }
          }
          localjo.gLs = l;
          localObject2 = ((List)localObject1).iterator();
          int j = 0;
          if (((Iterator)localObject2).hasNext())
          {
            str = (String)((Iterator)localObject2).next();
            if (!ContactRemarkInfoModUI.F(ContactRemarkInfoModUI.this).contains(str)) {
              break label875;
            }
            j += 1;
          }
          for (;;)
          {
            break;
            localjo.gLr = j;
            localObject2 = ((List)localObject1).iterator();
            int k = 0;
            if (((Iterator)localObject2).hasNext())
            {
              str = (String)((Iterator)localObject2).next();
              if (!ContactRemarkInfoModUI.G(ContactRemarkInfoModUI.this).contains(str)) {
                break label872;
              }
              k += 1;
            }
            for (;;)
            {
              break;
              localjo.gLp = k;
              localjo.guX = (System.currentTimeMillis() - ContactRemarkInfoModUI.H(ContactRemarkInfoModUI.this));
              localjo.gLw = ContactRemarkInfoModUI.I(ContactRemarkInfoModUI.this);
              localjo.gLx = paramLong;
              localjo.gLt = ContactRemarkInfoModUI.J(ContactRemarkInfoModUI.this);
              int n = 0;
              localObject2 = ((List)localObject1).iterator();
              int m = 0;
              if (((Iterator)localObject2).hasNext())
              {
                str = (String)((Iterator)localObject2).next();
                if (ContactRemarkInfoModUI.K(ContactRemarkInfoModUI.this).contains(str)) {
                  break label869;
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
                    break label866;
                  }
                  n += 1;
                }
                for (;;)
                {
                  break;
                  localjo.gmT = 1L;
                  localObject2 = ContactRemarkInfoModUI.j(ContactRemarkInfoModUI.this).getText().toString().trim();
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = "";
                  }
                  if (!ae.isNullOrNil(ContactRemarkInfoModUI.L(ContactRemarkInfoModUI.this))) {
                    if (ContactRemarkInfoModUI.L(ContactRemarkInfoModUI.this).equals(localObject1)) {
                      ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, 3);
                    }
                  }
                  for (;;)
                  {
                    localjo.gLy = ContactRemarkInfoModUI.O(ContactRemarkInfoModUI.this);
                    localjo.gLv = m;
                    localjo.gLu = n;
                    localjo.bpa();
                    Log.i("MiroMsg.ContactRemarkInfoModUI", "22865 setAddedLabelCnt = " + m + ",setRemovedLabelCnt = " + n + ",oriLabelCnt = " + ContactRemarkInfoModUI.J(ContactRemarkInfoModUI.this) + ",opResult = " + paramLong + ",totalLabelCnt = " + ContactRemarkInfoModUI.I(ContactRemarkInfoModUI.this) + ",selectNewLabelCnt = " + k + ",selectAddLabelCnt = " + j + ",addRemarkType = " + ContactRemarkInfoModUI.O(ContactRemarkInfoModUI.this) + ",scene= 1,newLebalCountBySearch = " + i + ",searchAddLabelCnt = " + l);
                    AppMethodBeat.o(287650);
                    return;
                    ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, 2);
                    continue;
                    if (!ContactRemarkInfoModUI.M(ContactRemarkInfoModUI.this)) {
                      ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, 3);
                    } else if (!ae.isNullOrNil(ContactRemarkInfoModUI.N(ContactRemarkInfoModUI.this)))
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
    AppMethodBeat.o(265526);
  }
  
  public int getLayoutId()
  {
    return R.i.efB;
  }
  
  public void initView()
  {
    AppMethodBeat.i(37778);
    this.Xrq = ((TextView)findViewById(R.h.dBk));
    this.Xrs = ((TextView)findViewById(R.h.dBt));
    this.Xrt = ((TextView)findViewById(R.h.dBp));
    this.Xrx = ((TextView)findViewById(R.h.dBs));
    this.Xru = ((ScrollView)findViewById(R.h.scrollview));
    this.Xrv = ((LinearLayout)findViewById(R.h.dBq));
    this.Xrw = ((ImageView)findViewById(R.h.dBr));
    this.Xrw.setImageDrawable(com.tencent.mm.ui.au.o(this, R.k.icons_outlined_camera, getResources().getColor(R.e.BW_70)));
    this.Xrp = ((MMClearEditText)findViewById(R.h.dBj));
    this.Xrr = ((MMEditText)findViewById(R.h.dBi));
    this.Xrz = ((ImageView)findViewById(R.h.dSH));
    this.XrA = ((ImageView)findViewById(R.h.dSI));
    this.Xry = ((TextView)findViewById(R.h.wordcount));
    this.ybl = findViewById(R.h.dBh);
    this.XrO = findViewById(R.h.dMp);
    this.XrN = ((ProfileEditPhoneNumberView)findViewById(R.h.dMD));
    this.XrN.uNk = this.contact;
    if ((this.XrQ == null) && (this.contact != null))
    {
      this.XrQ = this.contact.hDw;
      Log.i("MiroMsg.ContactRemarkInfoModUI", "is null phone, mContactPhoneNumberList: %s, mContactPhoneNumberByMD5: %s, ", new Object[] { this.XrQ, this.XrP });
    }
    Object localObject1 = this.XrN;
    Object localObject2 = this.XrP;
    String str = this.XrQ;
    ((ProfileEditPhoneNumberView)localObject1).Rdn = ((String)localObject2);
    ((ProfileEditPhoneNumberView)localObject1).Rdo = str;
    ((ProfileEditPhoneNumberView)localObject1).fqK();
    this.XrN.Rds = new ProfileEditPhoneNumberView.a()
    {
      public final void hjN()
      {
        AppMethodBeat.i(288945);
        ab.J(ContactRemarkInfoModUI.e(ContactRemarkInfoModUI.this));
        p.bnn().wE(7);
        AppMethodBeat.o(288945);
      }
      
      public final void hjO()
      {
        AppMethodBeat.i(288947);
        if (!ContactRemarkInfoModUI.f(ContactRemarkInfoModUI.this).hjJ()) {
          ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).setVisibility(0);
        }
        for (;;)
        {
          ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this);
          AppMethodBeat.o(288947);
          return;
          ContactRemarkInfoModUI.g(ContactRemarkInfoModUI.this).setVisibility(4);
        }
      }
      
      public final void hr(View paramAnonymousView)
      {
        AppMethodBeat.i(288949);
        ContactRemarkInfoModUI.this.hideVKB(paramAnonymousView);
        AppMethodBeat.o(288949);
      }
      
      public final void onChange()
      {
        AppMethodBeat.i(288943);
        ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this);
        AppMethodBeat.o(288943);
      }
    };
    label521:
    label824:
    int i;
    if (!this.XrN.hjJ())
    {
      this.XrO.setVisibility(0);
      this.Hcm = ((LinearLayout)findViewById(R.h.dBf));
      this.Hcn = ((TextView)findViewById(R.h.dBe));
      this.Hcn.setVisibility(0);
      this.Hcl = ((ImageView)findViewById(R.h.drW));
      if (this.Hcl != null) {
        this.Hcl.setImageDrawable(com.tencent.mm.ui.au.o(this, R.k.icons_outlined_arrow, com.tencent.mm.ci.a.w(getContext(), R.e.BW_70)));
      }
      this.Hcm.setOnClickListener(this.XrK);
      setMMTitle("");
      if (ae.isNullOrNil(this.cip)) {
        break label1062;
      }
      this.Xrp.setText(l.b(this, ae.nullAsNil(this.cip), this.Xrp.getTextSize()));
      this.Xrs.setText(l.b(this, ae.nullAsNil(this.cip), this.Xrs.getTextSize()));
      if (this.Xrp.getText() != null) {
        this.Hcq = this.Xrp.getText().toString();
      }
      this.Hcr = this.cip;
      this.Xrp.setSelection(this.Xrp.getText().length());
      localObject1 = l.b(this, ae.nullAsNil(this.hDq), this.Xrt.getTextSize());
      this.Xrr.setText((CharSequence)localObject1);
      this.Xrr.setSelection(this.Xrr.getText().length());
      if (!ae.isNullOrNil(this.hDq))
      {
        this.Xrt.setText(l.b(this, ae.nullAsNil(this.hDq), this.Xrt.getTextSize()));
        this.Xrt.setTextColor(getContext().getResources().getColor(R.e.FG_0));
      }
      this.Xrs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37762);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          ContactRemarkInfoModUI.h(ContactRemarkInfoModUI.this);
          localObject = ContactRemarkInfoModUI.this;
          paramAnonymousView.getId();
          ContactRemarkInfoModUI.i((ContactRemarkInfoModUI)localObject);
          ContactRemarkInfoModUI.j(ContactRemarkInfoModUI.this).performClick();
          ContactRemarkInfoModUI.j(ContactRemarkInfoModUI.this).requestFocus();
          ContactRemarkInfoModUI.this.showVKB();
          ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37762);
        }
      });
      this.Xrt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37763);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          ContactRemarkInfoModUI.k(ContactRemarkInfoModUI.this);
          ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, false, paramAnonymousView.getId());
          ContactRemarkInfoModUI.l(ContactRemarkInfoModUI.this).performClick();
          ContactRemarkInfoModUI.l(ContactRemarkInfoModUI.this).requestFocus();
          ContactRemarkInfoModUI.this.showVKB();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37763);
        }
      });
      this.Xrp.addTextChangedListener(this.XrR);
      this.Xry.setText(g.dq(800, this.Xrr.getEditableText().toString()));
      this.Xrr.addTextChangedListener(this.XrS);
      if (ae.isNullOrNil(this.lYG)) {
        break label1128;
      }
      this.Xrv.setVisibility(8);
      this.Xrz.setVisibility(0);
      com.tencent.mm.bg.c.bnY();
      if (com.tencent.mm.bg.c.WP(this.username)) {
        break label1121;
      }
      com.tencent.mm.bg.c.bnY().a(this.username, this.lYG, new com.tencent.mm.bg.c.a()
      {
        public final void gu(final boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(291355);
          ContactRemarkInfoModUI.x(ContactRemarkInfoModUI.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(207188);
              if (!paramAnonymousBoolean)
              {
                com.tencent.mm.ui.base.h.cO(ContactRemarkInfoModUI.this, ContactRemarkInfoModUI.this.getString(R.l.app_err_system_busy_tip));
                ContactRemarkInfoModUI.v(ContactRemarkInfoModUI.this).setVisibility(0);
                ContactRemarkInfoModUI.w(ContactRemarkInfoModUI.this).setVisibility(8);
                ContactRemarkInfoModUI.x(ContactRemarkInfoModUI.this).setVisibility(8);
                AppMethodBeat.o(207188);
                return;
              }
              ContactRemarkInfoModUI.y(ContactRemarkInfoModUI.this);
              AppMethodBeat.o(207188);
            }
          });
          AppMethodBeat.o(291355);
        }
      });
      this.Xrz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37764);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          if (!ContactRemarkInfoModUI.m(ContactRemarkInfoModUI.this))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37764);
            return;
          }
          ContactRemarkInfoModUI.n(ContactRemarkInfoModUI.this);
          localObject = new Intent(ContactRemarkInfoModUI.this, ContactRemarkImagePreviewUI.class);
          ((Intent)localObject).putExtra("Contact_User", ContactRemarkInfoModUI.o(ContactRemarkInfoModUI.this));
          if ((!ae.isNullOrNil(ContactRemarkInfoModUI.p(ContactRemarkInfoModUI.this))) && (!ContactRemarkInfoModUI.q(ContactRemarkInfoModUI.this))) {
            com.tencent.mm.bg.c.bnY();
          }
          for (paramAnonymousView = com.tencent.mm.bg.c.WO(ContactRemarkInfoModUI.o(ContactRemarkInfoModUI.this));; paramAnonymousView = ContactRemarkInfoModUI.r(ContactRemarkInfoModUI.this))
          {
            ((Intent)localObject).putExtra("remark_image_path", paramAnonymousView);
            ((Intent)localObject).putExtra("view_temp_remark_image", ContactRemarkInfoModUI.q(ContactRemarkInfoModUI.this));
            ContactRemarkInfoModUI.this.startActivityForResult((Intent)localObject, 400);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37764);
            return;
          }
        }
      });
      this.Xrv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(288523);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if ((ae.isNullOrNil(ContactRemarkInfoModUI.p(ContactRemarkInfoModUI.this))) || (ContactRemarkInfoModUI.s(ContactRemarkInfoModUI.this)))
          {
            ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, false);
            ContactRemarkInfoModUI.n(ContactRemarkInfoModUI.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(288523);
        }
      });
      localObject1 = com.tencent.mm.plugin.account.b.getAddrUploadStg().aax(this.contact.field_username);
      if ((localObject1 != null) && (!ae.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).bxT())) && (!((com.tencent.mm.plugin.account.friend.a.a)localObject1).bxT().equals(this.Xrp.getText().toString()))) {
        break label1148;
      }
      i = 0;
      label904:
      if ((i == 0) && (this.mXL == 14) && (!ae.isNullOrNil(this.RqK)) && (!this.RqK.equals(this.Xrp.getText().toString()))) {
        break label1280;
      }
      label947:
      addTextOptionMenu(0, getString(R.l.app_finish), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(37766);
          ContactRemarkInfoModUI.t(ContactRemarkInfoModUI.this);
          ContactRemarkInfoModUI.this.hideVKB();
          ContactRemarkInfoModUI.this.Ph(1L);
          AppMethodBeat.o(37766);
          return false;
        }
      }, null, w.b.Wao);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(277511);
          ContactRemarkInfoModUI.u(ContactRemarkInfoModUI.this);
          AppMethodBeat.o(277511);
          return true;
        }
      });
      if (!ae.isNullOrNil(this.cip)) {
        break label1421;
      }
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.XrA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(268421);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, true);
          ContactRemarkInfoModUI.n(ContactRemarkInfoModUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(268421);
        }
      });
      if (!this.XrI)
      {
        Log.i("MiroMsg.ContactRemarkInfoModUI", "oncreate initWithViewMode");
        this.XrH = true;
        as(true, -1);
      }
      hUu();
      AppMethodBeat.o(37778);
      return;
      this.XrO.setVisibility(4);
      break;
      label1062:
      this.Xrp.setText(l.b(this, ae.nullAsNil(this.contact.ayr()), this.Xrp.getTextSize()));
      this.Xrs.setHint(l.b(this, ae.nullAsNil(this.contact.ayr()), this.Xrp.getTextSize()));
      break label521;
      label1121:
      hUv();
      break label824;
      label1128:
      this.Xrv.setVisibility(0);
      this.Xrz.setVisibility(8);
      break label824;
      label1148:
      this.XrB = ((TextView)findViewById(R.h.dMJ));
      this.XrC = findViewById(R.h.dME);
      this.XrC.setVisibility(0);
      this.XrB.setText(ae.nullAsNil(getString(R.l.ezo, new Object[] { ((com.tencent.mm.plugin.account.friend.a.a)localObject1).bxT() })));
      localObject2 = new m(getString(R.l.write_contact_remark));
      ((m)localObject2).setSpan(new c(((com.tencent.mm.plugin.account.friend.a.a)localObject1).bxT()), 0, ((m)localObject2).length(), 17);
      this.XrB.append(" ");
      this.XrB.append((CharSequence)localObject2);
      this.XrB.setMovementMethod(LinkMovementMethod.getInstance());
      i = 1;
      break label904;
      label1280:
      this.XrB = ((TextView)findViewById(R.h.dMJ));
      this.XrC = findViewById(R.h.dME);
      this.XrC.setVisibility(0);
      this.XrB.setText(l.b(this, ae.nullAsNil(getString(R.l.ezn, new Object[] { this.RqK })), this.XrB.getTextSize()));
      localObject1 = new m(getString(R.l.write_contact_remark));
      ((m)localObject1).setSpan(new c(this.RqK), 0, ((m)localObject1).length(), 17);
      this.XrB.append(" ");
      this.XrB.append((CharSequence)localObject1);
      this.XrB.setMovementMethod(LinkMovementMethod.getInstance());
      break label947;
      label1421:
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
      bh.beI();
      paramIntent = com.tencent.mm.pluginsdk.ui.tools.u.g((Context)localObject1, paramIntent, com.tencent.mm.model.c.bbW());
      if (paramIntent == null)
      {
        AppMethodBeat.o(37788);
        return;
      }
      this.XrD = bzW(paramIntent);
      bzU(this.XrD);
      this.XrF = true;
      this.XrJ = false;
      asT();
      AppMethodBeat.o(37788);
      return;
    case 200: 
      localObject1 = getApplicationContext();
      bh.beI();
      paramIntent = com.tencent.mm.ui.tools.b.h((Context)localObject1, paramIntent, com.tencent.mm.model.c.bbW());
      if (paramIntent == null)
      {
        AppMethodBeat.o(37788);
        return;
      }
      this.XrD = bzW(paramIntent);
      bzU(this.XrD);
      this.XrF = true;
      this.XrJ = false;
      asT();
      AppMethodBeat.o(37788);
      return;
    case 400: 
      if (paramIntent.getBooleanExtra("response_delete", false)) {
        hUz();
      }
      AppMethodBeat.o(37788);
      return;
    }
    Object localObject1 = paramIntent.getStringArrayListExtra("result_label_id_list");
    Object localObject2 = com.tencent.mm.plugin.label.a.a.eLe().eLb();
    if ((!t((List)localObject1, this.XrL)) && (!t((List)localObject2, this.Hci)))
    {
      AppMethodBeat.o(37788);
      return;
    }
    Object localObject3 = paramIntent.getStringArrayListExtra("contact_search_label_new_list");
    if (localObject3 != null) {
      this.Hcx.addAll((Collection)localObject3);
    }
    localObject3 = paramIntent.getStringArrayListExtra("contact_search_label_add_list");
    if (localObject3 != null) {
      this.EeR.addAll((Collection)localObject3);
    }
    localObject3 = paramIntent.getStringArrayListExtra("contact_select_label_add_list");
    if (localObject3 != null) {
      this.EeT.addAll((Collection)localObject3);
    }
    localObject3 = paramIntent.getStringArrayListExtra("contact_select_label_new_list");
    if (localObject3 != null) {
      this.EeS.addAll((Collection)localObject3);
    }
    localObject3 = ((ArrayList)localObject1).iterator();
    String str;
    while (((Iterator)localObject3).hasNext())
    {
      str = (String)((Iterator)localObject3).next();
      if (!this.XrL.contains(str)) {
        bzV(str);
      }
    }
    localObject3 = this.XrL.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      str = (String)((Iterator)localObject3).next();
      if (!((ArrayList)localObject1).contains(str))
      {
        if ((this.Hcw != null) && (this.Hcw.contains(str))) {
          this.EeJ.add(str);
        }
        if ((this.EeK != null) && (this.EeK.contains(str))) {
          this.EeK.remove(str);
        }
      }
    }
    if (this.Hci == null) {
      this.Hci = new ArrayList();
    }
    this.Hci = ((List)localObject2);
    localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (this.Hci.contains(localObject3)) {
        this.Hci.remove(localObject3);
      }
    }
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).addAll(this.Hci);
    this.Hci.clear();
    this.Hci.addAll((Collection)localObject1);
    this.Hci.addAll((Collection)localObject2);
    if (localObject1 != null)
    {
      this.XrL.clear();
      this.XrL.addAll((Collection)localObject1);
    }
    gw(this.XrL);
    if ((GK(true)) || (hUx()) || (hUy()) || (paramIntent.getBooleanExtra("hasLableChange", false)))
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
    bh.aGY().a(575, this);
    bh.aGY().a(576, this);
    bh.aGY().a(638, this);
    this.mXL = getIntent().getIntExtra("Contact_Scene", 9);
    this.RqK = getIntent().getStringExtra("Contact_RoomNickname");
    this.XrI = getIntent().getBooleanExtra("view_mode", false);
    this.XrT = getIntent().getStringExtra("contact_auto_app_phone_from_chatting");
    this.XrP = getIntent().getStringExtra("contact_phone_number_by_md5");
    this.XrQ = getIntent().getStringExtra("contact_phone_number_list");
    this.username = getIntent().getStringExtra("Contact_User");
    if (ae.isNullOrNil(this.username))
    {
      finish();
      AppMethodBeat.o(37773);
      return;
    }
    this.fOa = System.currentTimeMillis();
    bh.beI();
    this.contact = com.tencent.mm.model.c.bbL().RG(this.username);
    this.cip = this.contact.field_conRemark;
    this.hDq = this.contact.hDq;
    this.lYG = this.contact.hDr;
    this.EeH = this.contact.field_contactLabelIds;
    this.Hcw = com.tencent.mm.plugin.label.a.a.eLe().aMQ(this.EeH);
    this.XrL.clear();
    if (this.Hcw != null) {
      this.XrL.addAll(this.Hcw);
    }
    for (;;)
    {
      initView();
      asT();
      int i = j;
      if (this.contact != null)
      {
        i = j;
        if (as.bvK(this.contact.field_username)) {
          i = 1;
        }
      }
      if (i != 0) {
        hUt();
      }
      hUB();
      setActionbarColor(getContext().getResources().getColor(R.e.white));
      hideActionbarLine();
      setMMTitle("");
      this.mController.setStatusBarColor(getResources().getColor(a.c.white));
      this.jij = new com.tencent.mm.ui.tools.i(this);
      this.jij.XSx = this;
      AppMethodBeat.o(37773);
      return;
      this.Hcw = new ArrayList();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(37776);
    bh.aGY().b(638, this);
    bh.aGY().b(575, this);
    bh.aGY().b(576, this);
    this.Xrp.removeTextChangedListener(this.XrR);
    this.Xrr.removeTextChangedListener(this.XrS);
    if (this.jij != null) {
      this.jij.close();
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
  
  public void onPause()
  {
    AppMethodBeat.i(37775);
    bh.aGY().b(635, this);
    bh.beI();
    com.tencent.mm.model.c.bbL().remove(this.XrU);
    if (this.jij != null) {
      this.jij.close();
    }
    super.onPause();
    AppMethodBeat.o(37775);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(37774);
    super.onResume();
    bh.aGY().a(635, this);
    bh.beI();
    com.tencent.mm.model.c.bbL().add(this.XrU);
    if (this.jij != null) {
      this.jij.start();
    }
    AppMethodBeat.o(37774);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(37790);
    Log.i("MiroMsg.ContactRemarkInfoModUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.lBo != null)
    {
      this.lBo.dismiss();
      this.lBo = null;
    }
    if ((this.mRa != null) && (this.mRa.isShowing())) {
      this.mRa.dismiss();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.ui.base.h.c(this, getString(R.l.app_err_server_busy_tip), null, true);
      AppMethodBeat.o(37790);
      return;
    }
    paramInt1 = paramq.getType();
    if (paramInt1 == 575)
    {
      if (this.XrD != null)
      {
        paramString = new com.tencent.mm.vfs.q(this.XrD);
        if (paramString.ifE())
        {
          com.tencent.mm.bg.c.bnY();
          paramString.aj(new com.tencent.mm.vfs.q(com.tencent.mm.bg.c.WO(this.username)));
        }
      }
      paramString = ((com.tencent.mm.bg.b)paramq).lYG;
      if (!ae.isNullOrNil(paramString)) {
        this.lYG = paramString;
      }
      finish();
      AppMethodBeat.o(37790);
      return;
    }
    if (paramInt1 == 576)
    {
      this.XrD = null;
      this.lYG = null;
      this.XrE = false;
      bh.beI();
      this.contact = com.tencent.mm.model.c.bbL().RG(this.username);
      this.contact.IR("");
      bh.beI();
      com.tencent.mm.model.c.bbL().c(this.username, this.contact);
      finish();
    }
    AppMethodBeat.o(37790);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(265520);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (this.jij != null) {
      this.jij.start();
    }
    AppMethodBeat.o(265520);
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
      ContactRemarkInfoModUI.h(ContactRemarkInfoModUI.this);
      ContactRemarkInfoModUI.k(ContactRemarkInfoModUI.this);
      ContactRemarkInfoModUI.a(ContactRemarkInfoModUI.this, true, -1);
      ContactRemarkInfoModUI.i(ContactRemarkInfoModUI.this);
      ContactRemarkInfoModUI.j(ContactRemarkInfoModUI.this).setText(l.b(ContactRemarkInfoModUI.this, ae.nullAsNil(this.remark), ContactRemarkInfoModUI.j(ContactRemarkInfoModUI.this).getTextSize()));
      ContactRemarkInfoModUI.j(ContactRemarkInfoModUI.this).setSelection(ContactRemarkInfoModUI.j(ContactRemarkInfoModUI.this).getText().length());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI
 * JD-Core Version:    0.7.0.1
 */