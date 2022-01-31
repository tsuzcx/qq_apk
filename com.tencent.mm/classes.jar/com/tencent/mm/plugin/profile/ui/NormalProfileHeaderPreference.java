package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.BackgroundColorSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.profile.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.preference.FMessageListView;
import com.tencent.mm.pluginsdk.ui.preference.PhoneNumPreference;
import com.tencent.mm.pluginsdk.ui.preference.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class NormalProfileHeaderPreference
  extends Preference
  implements View.OnClickListener, View.OnLongClickListener
{
  public f iLA;
  private ad lpe;
  private Context mContext;
  private int mScene;
  private View ozm;
  private boolean pAY = false;
  private String pAZ;
  private boolean pBa;
  private int pBb;
  int pBc = 0;
  int pBd = 0;
  private com.tencent.mm.plugin.profile.a.b pxo;
  private boolean readOnly = false;
  
  public NormalProfileHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public NormalProfileHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
  }
  
  private String M(ad paramad)
  {
    AppMethodBeat.i(23661);
    Resources localResources;
    if (cbz())
    {
      localResources = this.mContext.getResources();
      if (bo.isNullOrNil(paramad.getCity())) {
        paramad = s.nG(paramad.getProvince());
      }
    }
    for (paramad = localResources.getString(2131297774, new Object[] { paramad }).trim();; paramad = paramad.Of())
    {
      paramad = bo.bf(paramad, "");
      AppMethodBeat.o(23661);
      return paramad;
      paramad = paramad.getCity();
      break;
    }
  }
  
  public static CharSequence a(Context paramContext, ad paramad, int paramInt, String paramString, boolean paramBoolean)
  {
    String str = null;
    AppMethodBeat.i(23664);
    int i = paramInt;
    if (paramInt == 9) {
      i = paramad.getSource();
    }
    switch (i)
    {
    default: 
      AppMethodBeat.o(23664);
      return null;
    case 4: 
    case 12: 
      paramContext = paramContext.getResources().getString(2131300001);
      AppMethodBeat.o(23664);
      return paramContext;
    case 1: 
      if ((paramBoolean) || (paramad.Oh() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131298799);
        AppMethodBeat.o(23664);
        return paramContext;
      }
      if (com.tencent.mm.n.a.je(paramad.field_type))
      {
        paramContext = paramContext.getResources().getString(2131298798);
        AppMethodBeat.o(23664);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131298800);
      AppMethodBeat.o(23664);
      return paramContext;
    case 3: 
      if ((paramBoolean) || (paramad.Oh() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131298802);
        AppMethodBeat.o(23664);
        return paramContext;
      }
      if (com.tencent.mm.n.a.je(paramad.field_type))
      {
        paramContext = paramContext.getResources().getString(2131298801);
        AppMethodBeat.o(23664);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131298803);
      AppMethodBeat.o(23664);
      return paramContext;
    case 17: 
      str = s.nE(((Activity)paramContext).getIntent().getStringExtra("source_from_user_name"));
      paramString = str;
      if (bo.isNullOrNil(str)) {
        paramString = ((Activity)paramContext).getIntent().getStringExtra("source_from_nick_name");
      }
      if ((paramBoolean) || (paramad.Oh() > 1000000))
      {
        if (bo.isNullOrNil(paramString)) {}
        for (paramContext = paramContext.getString(2131298779);; paramContext = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, paramContext.getString(2131298778, new Object[] { paramString })))
        {
          AppMethodBeat.o(23664);
          return paramContext;
        }
      }
      if (com.tencent.mm.n.a.je(paramad.field_type))
      {
        if (bo.isNullOrNil(paramString)) {}
        for (paramContext = paramContext.getString(2131298776);; paramContext = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, paramContext.getString(2131298777, new Object[] { paramString })))
        {
          AppMethodBeat.o(23664);
          return paramContext;
        }
      }
      if (!bo.isNullOrNil(paramString))
      {
        paramContext = paramContext.getString(2131298780, new Object[] { paramString });
        AppMethodBeat.o(23664);
        return paramContext;
      }
      paramContext = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, paramContext.getString(2131298781));
      AppMethodBeat.o(23664);
      return paramContext;
    case 18: 
      if ((paramBoolean) || (paramad.Oh() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131298787);
        AppMethodBeat.o(23664);
        return paramContext;
      }
      if (com.tencent.mm.n.a.je(paramad.field_type))
      {
        paramContext = paramContext.getResources().getString(2131298786);
        AppMethodBeat.o(23664);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131298788);
      AppMethodBeat.o(23664);
      return paramContext;
    case 30: 
      if ((paramBoolean) || (paramad.Oh() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131298792);
        AppMethodBeat.o(23664);
        return paramContext;
      }
      if (com.tencent.mm.n.a.je(paramad.field_type))
      {
        paramContext = paramContext.getResources().getString(2131298791);
        AppMethodBeat.o(23664);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131298793);
      AppMethodBeat.o(23664);
      return paramContext;
    case 48: 
      paramContext = paramContext.getResources().getString(2131298794);
      AppMethodBeat.o(23664);
      return paramContext;
    case 8: 
    case 14: 
    case 96: 
      paramString = d.alh().asd(paramString).field_chatroomName;
      if (bo.isNullOrNil(paramString)) {
        paramString = paramad.field_sourceExtInfo;
      }
      break;
    }
    for (;;)
    {
      ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramString);
      paramString = str;
      if (localad != null)
      {
        if (bo.isNullOrNil(localad.field_username)) {
          paramString = str;
        }
      }
      else
      {
        if ((!paramBoolean) && (paramad.Oh() <= 1000000)) {
          break label970;
        }
        if (bo.isNullOrNil(paramString)) {
          break label960;
        }
      }
      label960:
      for (paramContext = paramContext.getString(2131298785, new Object[] { paramString });; paramContext = paramContext.getString(2131298783))
      {
        AppMethodBeat.o(23664);
        return paramContext;
        if (bo.isNullOrNil(localad.field_nickname))
        {
          paramString = com.tencent.mm.model.n.nm(localad.field_username);
          break;
        }
        paramString = localad.field_nickname;
        break;
      }
      label970:
      if (com.tencent.mm.n.a.je(paramad.field_type))
      {
        paramContext = paramContext.getResources().getString(2131298784, new Object[] { paramString });
        AppMethodBeat.o(23664);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131298782);
      AppMethodBeat.o(23664);
      return paramContext;
      if ((paramBoolean) || (paramad.Oh() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131298805);
        AppMethodBeat.o(23664);
        return paramContext;
      }
      if (com.tencent.mm.n.a.je(paramad.field_type))
      {
        paramContext = paramContext.getResources().getString(2131298804);
        AppMethodBeat.o(23664);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131298806);
      AppMethodBeat.o(23664);
      return paramContext;
      paramContext = paramContext.getResources().getString(2131298771);
      AppMethodBeat.o(23664);
      return paramContext;
      paramContext = paramContext.getResources().getString(2131300486);
      AppMethodBeat.o(23664);
      return paramContext;
      paramContext = paramContext.getResources().getString(2131298789);
      AppMethodBeat.o(23664);
      return paramContext;
      if ((paramBoolean) || (paramad.Oh() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131298808);
        AppMethodBeat.o(23664);
        return paramContext;
      }
      if (com.tencent.mm.n.a.je(paramad.field_type))
      {
        paramContext = paramContext.getResources().getString(2131298807);
        AppMethodBeat.o(23664);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131298809);
      AppMethodBeat.o(23664);
      return paramContext;
      if ((paramBoolean) || (paramad.Oh() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131298774);
        AppMethodBeat.o(23664);
        return paramContext;
      }
      if (com.tencent.mm.n.a.je(paramad.field_type))
      {
        paramContext = paramContext.getResources().getString(2131298773);
        AppMethodBeat.o(23664);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131298775);
      AppMethodBeat.o(23664);
      return paramContext;
      if ((paramBoolean) || (paramad.Oh() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131298796);
        AppMethodBeat.o(23664);
        return paramContext;
      }
      if (com.tencent.mm.n.a.je(paramad.field_type))
      {
        paramContext = paramContext.getResources().getString(2131298795);
        AppMethodBeat.o(23664);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131298797);
      AppMethodBeat.o(23664);
      return paramContext;
      paramContext = paramContext.getResources().getString(2131300002);
      AppMethodBeat.o(23664);
      return paramContext;
    }
  }
  
  private static void a(NormalProfileHeaderPreference.a parama, Context paramContext, ad paramad, int paramInt, com.tencent.mm.pluginsdk.ui.preference.b[] paramArrayOfb)
  {
    int i = 0;
    AppMethodBeat.i(23662);
    if ((paramArrayOfb == null) || (com.tencent.mm.n.a.je(paramad.field_type)))
    {
      parama.pBw.setVisibility(8);
      AppMethodBeat.o(23662);
      return;
    }
    parama.pBw.setVisibility(0);
    paramContext = bo.nullAsNil(((Activity)paramContext).getIntent().getStringExtra("Verify_ticket"));
    a.a locala = new a.a();
    locala.talker = paramad.field_username;
    locala.scene = paramInt;
    locala.mVw = paramContext;
    locala.waH = paramad.dra;
    locala.type = 0;
    if (paramInt == 18) {
      locala.type = 1;
    }
    for (;;)
    {
      parama.pBw.setFMessageArgs(locala);
      int j = paramArrayOfb.length;
      paramInt = i;
      while (paramInt < j)
      {
        paramContext = paramArrayOfb[paramInt];
        parama.pBw.a(paramContext);
        paramInt += 1;
      }
      if (bf.kD(paramInt)) {
        locala.type = 2;
      }
    }
    AppMethodBeat.o(23662);
  }
  
  private void a(String paramString, ad paramad)
  {
    AppMethodBeat.i(23667);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.NormalProfileHeaderPreference", "view stranger remark, username is null");
      AppMethodBeat.o(23667);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("Contact_Scene", this.mScene);
    paramString.putExtra("Contact_mode_name_type", 0);
    paramString.putExtra("Contact_ModStrangerRemark", true);
    paramString.putExtra("Contact_User", paramad.field_username);
    paramString.putExtra("Contact_Nick", paramad.field_nickname);
    paramString.putExtra("Contact_RemarkName", paramad.field_conRemark);
    com.tencent.mm.plugin.profile.b.gmO.n(paramString, this.mContext);
    AppMethodBeat.o(23667);
  }
  
  private boolean cbz()
  {
    AppMethodBeat.i(23660);
    boolean bool = ad.nM(this.lpe.field_username);
    AppMethodBeat.o(23660);
    return bool;
  }
  
  public final void B(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(23663);
    int i = am.di(this.mContext);
    this.pBa = paramBoolean;
    this.pBb = paramInt;
    if (paramInt <= 0) {
      this.pBb = i;
    }
    if (this.iLA != null) {
      this.iLA.notifyDataSetChanged();
    }
    ab.i("MicroMsg.NormalProfileHeaderPreference", "setHasStory action=%s weuiActionBarHeight=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(23663);
  }
  
  public final void a(ad paramad, int paramInt, boolean paramBoolean, com.tencent.mm.plugin.profile.a.b paramb)
  {
    AppMethodBeat.i(23656);
    this.pAZ = ((Activity)this.mContext).getIntent().getStringExtra("Contact_RoomNickname");
    this.lpe = paramad;
    this.mScene = paramInt;
    this.readOnly = paramBoolean;
    this.pAY = true;
    this.pxo = paramb;
    AppMethodBeat.o(23656);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23659);
    super.onBindView(paramView);
    if (!this.pAY)
    {
      ab.w("MicroMsg.NormalProfileHeaderPreference", "[onBindView] never attach!");
      AppMethodBeat.o(23659);
      return;
    }
    if (paramView.getTag() == null) {
      paramView.setTag(new NormalProfileHeaderPreference.a(this, paramView));
    }
    NormalProfileHeaderPreference.a locala = (NormalProfileHeaderPreference.a)paramView.getTag();
    a.b.c(locala.pBv, this.lpe.field_username);
    float f1;
    int n;
    int i1;
    int k;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    int m;
    if (!bo.isNullOrNil(M(this.lpe)))
    {
      locala.pBp.setVisibility(0);
      f1 = locala.pBp.getTextSize();
      paramView = M(this.lpe);
      n = (int)this.mContext.getResources().getDimension(2131427596);
      i1 = (int)this.mContext.getResources().getDimension(2131427587);
      if (this.lpe.dqC == 0) {
        break label1057;
      }
      k = this.mContext.getResources().getDrawable(2131231426).getIntrinsicWidth();
      bool1 = this.lpe.NZ();
      bool2 = com.tencent.mm.plugin.sns.b.n.raT.Xh(this.lpe.field_username);
      bool3 = this.lpe.NY();
      m = (int)this.mContext.getResources().getDimension(2131427579);
      if (!bool1) {
        break label2033;
      }
    }
    label542:
    label725:
    label1111:
    label1250:
    label1647:
    label2033:
    for (int j = this.mContext.getResources().getDrawable(2131231145).getIntrinsicWidth() + m + m;; j = m)
    {
      int i = j;
      if (bool3) {
        i = j + this.mContext.getResources().getDrawable(2131231881).getIntrinsicWidth() + m;
      }
      j = i;
      if (bool2) {
        j = i + this.mContext.getResources().getDrawable(2131231146).getIntrinsicWidth() + m;
      }
      i = this.mContext.getResources().getDisplayMetrics().widthPixels - n - i1 * 3 - k - j;
      ab.i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] calculateRemarkNameTvSize:%s", new Object[] { Integer.valueOf(i) });
      locala.pBp.setMaxWidth(i);
      locala.pBp.af(com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, paramView, f1));
      locala.pBp.setContentDescription(com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, paramView, f1));
      if (locala.pBp.Sa(i).dTo() > 1)
      {
        f1 = com.tencent.mm.cb.a.dr(this.mContext);
        float f2 = com.tencent.mm.cb.a.ar(this.mContext, (int)locala.pBp.getResources().getDimension(2131427865));
        locala.pBp.setTextSize(f1 * f2);
        locala.pBp.af(com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, paramView, locala.pBp.getTextSize()));
      }
      String str;
      label760:
      Object localObject;
      if (this.pBa)
      {
        locala.pBp.setTextColor(this.mContext.getResources().getColor(2131690711));
        locala.pBp.setMaxLines(1);
        locala.pBp.getPaint().setFakeBoldText(true);
        str = ((Activity)this.mContext).getIntent().getStringExtra("Contact_Distance");
        if ((!((Activity)this.mContext).getIntent().getBooleanExtra("Contact_IsLBSFriend", false)) || (bo.isNullOrNil(str))) {
          break label1098;
        }
        locala.pBt.setText(this.mContext.getString(2131298586) + str);
        locala.pBt.setVisibility(0);
        if (ad.arf(this.lpe.field_username))
        {
          locala.pBo.setVisibility(0);
          locala.pBo.setText(com.tencent.mm.openim.room.a.a.A(this.lpe));
        }
        if ((!bo.isNullOrNil(this.lpe.field_nickname)) && (!bo.isNullOrNil(this.lpe.field_conRemark)) && (!cbz())) {
          break label1111;
        }
        locala.nzx.setVisibility(8);
        if (bo.isNullOrNil(this.pAZ)) {
          break label1187;
        }
        if (((Activity)this.mContext).getIntent().getIntExtra("Contact_Scene", -1) != 14) {
          break label1181;
        }
        i = 1;
        if (i == 0) {
          break label1187;
        }
        locala.pBq.setVisibility(0);
        paramView = this.mContext.getString(2131298570) + this.pAZ;
        locala.pBq.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, paramView, locala.nzx.getTextSize()));
        if (((bo.isNullOrNil(this.lpe.Hq())) && (bo.isNullOrNil(this.lpe.field_username))) || (!com.tencent.mm.n.a.je(this.lpe.field_type)) || (ad.arf(this.lpe.field_username)) || (cbz())) {
          break label1211;
        }
        locala.nIh.setVisibility(0);
        localObject = locala.nIh;
        StringBuilder localStringBuilder = new StringBuilder().append(this.mContext.getString(2131296950));
        if (!bo.isNullOrNil(this.lpe.Hq())) {
          break label1200;
        }
        paramView = this.lpe.field_username;
        ((TextView)localObject).setText(paramView);
        if (this.lpe.field_deleteFlag != 1) {
          break label1224;
        }
        locala.pBu.setVisibility(0);
        locala.pBu.setText(this.mContext.getText(2131298517));
        locala.nzx.setVisibility(8);
        locala.pBr.setVisibility(8);
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1250;
        }
        ab.i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] has delete account! username:%s", new Object[] { this.lpe.field_username });
        AppMethodBeat.o(23659);
        return;
        k = 0;
        break;
        locala.pBp.setTextColor(this.mContext.getResources().getColor(2131689766));
        locala.pBp.setMaxLines(2147483647);
        break label542;
        locala.pBt.setVisibility(8);
        break label645;
        locala.nzx.setVisibility(0);
        paramView = this.mContext.getString(2131298681) + this.lpe.field_nickname;
        locala.nzx.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, paramView, locala.nzx.getTextSize()));
        break label725;
        i = 0;
        break label760;
        locala.pBq.setVisibility(8);
        break label829;
        paramView = this.lpe.Hq();
        break label947;
        locala.nIh.setVisibility(8);
        break label961;
        locala.pBu.setVisibility(8);
        locala.pBr.setVisibility(8);
      }
      if ((!com.tencent.mm.n.a.je(this.lpe.field_type)) && (!cbz()) && (!t.ow(this.lpe.field_username)))
      {
        ab.i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] accept contact! username:%s", new Object[] { this.lpe.field_username });
        locala.pBC.setVisibility(8);
        if ((com.tencent.mm.n.a.je(this.lpe.field_type)) || (!((Activity)this.mContext).getIntent().getBooleanExtra("User_Verify", false))) {
          break label1773;
        }
        i = 1;
        if (i == 0) {
          break label1779;
        }
        locala.pBC.setVisibility(0);
        a(locala, this.mContext, this.lpe, this.mScene, p.a(this.mContext, this.lpe, this.mScene));
        if (!bo.isNullOrNil(this.lpe.signature)) {
          break label1792;
        }
        locala.pBr.setVisibility(8);
        if (!bo.isNullOrNil(this.lpe.getProvince())) {
          break label1827;
        }
        locala.pBs.setVisibility(8);
        paramView = locala.pBn;
        localObject = this.lpe;
        paramView.setVisibility(0);
        if (((aq)localObject).dqC != 1) {
          break label1949;
        }
        paramView.setImageDrawable(com.tencent.mm.cb.a.k(this.mContext, 2131231426));
        paramView.setContentDescription(this.mContext.getString(2131302184));
        i = ((Activity)this.mContext).getIntent().getIntExtra("Contact_Scene", 0);
        if ((26 > i) || (i > 29)) {
          break label2006;
        }
        i = 1;
        label1534:
        if (i != 0)
        {
          locala.pBt.setVisibility(0);
          locala.nzx.setVisibility(8);
          locala.pBt.setText(this.mContext.getString(2131298586) + str);
        }
        if (!t.ow(this.lpe.field_username))
        {
          bool1 = this.lpe.NZ();
          bool2 = com.tencent.mm.plugin.sns.b.n.raT.Xh(this.lpe.field_username);
          paramView = locala.pBA;
          if (!bool1) {
            break label2012;
          }
          i = 0;
          paramView.setVisibility(i);
          paramView = locala.pBB;
          if ((!bool2) || (!com.tencent.mm.n.a.je(this.lpe.field_type))) {
            break label2019;
          }
          i = 0;
          paramView.setVisibility(i);
          paramView = locala.pBz;
          if ((!this.lpe.NY()) || (!com.tencent.mm.n.a.je(this.lpe.field_type))) {
            break label2026;
          }
        }
      }
      for (i = 0;; i = 8)
      {
        paramView.setVisibility(i);
        locala.pBE.getViewTreeObserver().addOnPreDrawListener(new NormalProfileHeaderPreference.1(this, locala));
        AppMethodBeat.o(23659);
        return;
        if (locala.pBC == null) {
          break;
        }
        locala.pBC.setVisibility(8);
        break;
        i = 0;
        break label1352;
        label1779:
        locala.pBC.setVisibility(8);
        break label1366;
        locala.pBr.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.mContext, this.lpe.signature));
        locala.pBr.setVisibility(8);
        break label1421;
        locala.pBs.setVisibility(0);
        localObject = new StringBuilder().append(s.nG(this.lpe.getProvince()));
        if (bo.isNullOrNil(this.lpe.getCity())) {}
        for (paramView = "";; paramView = "  " + this.lpe.getCity())
        {
          paramView = paramView;
          locala.pBs.setText(this.mContext.getString(2131298660) + paramView);
          break;
        }
        if (((aq)localObject).dqC == 2)
        {
          paramView.setImageDrawable(com.tencent.mm.cb.a.k(this.mContext, 2131231425));
          paramView.setContentDescription(this.mContext.getString(2131302183));
          break label1498;
        }
        if (((aq)localObject).dqC != 0) {
          break label1498;
        }
        paramView.setVisibility(8);
        break label1498;
        i = 0;
        break label1534;
        i = 8;
        break label1647;
        i = 8;
        break label1680;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(23665);
    int i = paramView.getId();
    Object localObject;
    if (i == 2131823203)
    {
      paramView = this.lpe;
      if (paramView == null)
      {
        ab.e("MicroMsg.NormalProfileHeaderPreference", "contact is null");
        AppMethodBeat.o(23665);
        return;
      }
      if (!com.tencent.mm.n.a.je(paramView.field_type))
      {
        if (!bo.isNullOrNil(paramView.field_encryptUsername))
        {
          a(paramView.field_encryptUsername, paramView);
          AppMethodBeat.o(23665);
          return;
        }
        a(paramView.field_username, paramView);
        AppMethodBeat.o(23665);
        return;
      }
      localObject = (PhoneNumPreference)this.iLA.atx("contact_profile_phone");
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_Scene", this.mScene);
      localIntent.putExtra("Contact_User", paramView.field_username);
      localIntent.putExtra("view_mode", true);
      localIntent.putExtra("contact_phone_number_by_md5", ((PhoneNumPreference)localObject).vRr);
      localIntent.putExtra("contact_phone_number_list", paramView.dqZ);
      com.tencent.mm.plugin.profile.b.gmO.m(localIntent, this.mContext);
      AppMethodBeat.o(23665);
      return;
    }
    if (i == 2131823204)
    {
      if (this.pxo != null)
      {
        this.pxo.cbI();
        AppMethodBeat.o(23665);
      }
    }
    else if (i == 2131823188)
    {
      paramView = this.lpe.field_username;
      localObject = new Intent(this.mContext, ProfileHdHeadImg.class);
      ((Intent)localObject).putExtra("username", paramView);
      this.mContext.startActivity((Intent)localObject);
      h.qsU.e(16055, new Object[] { Integer.valueOf(c.al(((Activity)this.mContext).getIntent())), Integer.valueOf(16), Integer.valueOf(1), this.lpe.field_username });
    }
    AppMethodBeat.o(23665);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(23658);
    if (this.ozm == null) {
      this.ozm = super.onCreateView(paramViewGroup);
    }
    paramViewGroup = this.ozm;
    AppMethodBeat.o(23658);
    return paramViewGroup;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(23657);
    if (this.ozm != null)
    {
      NormalProfileHeaderPreference.a locala = (NormalProfileHeaderPreference.a)this.ozm.getTag();
      if (locala.pBw != null) {
        locala.pBw.detach();
      }
    }
    AppMethodBeat.o(23657);
  }
  
  public boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(23666);
    if (paramView.getId() == 2131823197)
    {
      TextView localTextView = (TextView)paramView;
      ad localad = this.lpe;
      ClipboardManager localClipboardManager = (ClipboardManager)ah.getContext().getSystemService("clipboard");
      Object localObject;
      if ((localTextView.getText() != null) && (localClipboardManager != null))
      {
        localObject = localTextView.getText().toString();
        int i = ((String)localObject).indexOf(':');
        paramView = (View)localObject;
        if (i >= 0)
        {
          paramView = (View)localObject;
          if (i < ((String)localObject).length()) {
            paramView = ((String)localObject).substring(i + 1).trim();
          }
        }
        localObject = new SpannableString(localTextView.getText());
        ((SpannableString)localObject).setSpan(new BackgroundColorSpan(this.mContext.getResources().getColor(2131690206)), i + 2, localTextView.getText().length(), 33);
        localTextView.setText((CharSequence)localObject);
        localObject = new com.tencent.mm.ui.widget.c.a(this.mContext, localTextView);
        ((com.tencent.mm.ui.widget.c.a)localObject).AIG = new NormalProfileHeaderPreference.2(this);
        ((com.tencent.mm.ui.widget.c.a)localObject).sap = new NormalProfileHeaderPreference.3(this, localClipboardManager, paramView);
        ((com.tencent.mm.ui.widget.c.a)localObject).AxS = new NormalProfileHeaderPreference.4(this, localTextView, localad);
        if (!(localTextView.getTag(2131820681) instanceof int[])) {
          break label263;
        }
        paramView = (int[])localTextView.getTag(2131820681);
        ((com.tencent.mm.ui.widget.c.a)localObject).dq(paramView[0], paramView[1]);
      }
      for (;;)
      {
        AppMethodBeat.o(23666);
        return true;
        label263:
        ((com.tencent.mm.ui.widget.c.a)localObject).dq(this.pBc, this.pBd);
      }
    }
    AppMethodBeat.o(23666);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference
 * JD-Core Version:    0.7.0.1
 */