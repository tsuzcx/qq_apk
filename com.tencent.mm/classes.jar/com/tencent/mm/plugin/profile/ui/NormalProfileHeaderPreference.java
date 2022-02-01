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
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bk.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.q;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.patmsg.a.c.a;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.plugin.profile.c;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.preference.FMessageListView;
import com.tencent.mm.pluginsdk.ui.preference.PhoneNumPreference;
import com.tencent.mm.pluginsdk.ui.preference.a.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class NormalProfileHeaderPreference
  extends Preference
  implements View.OnClickListener, View.OnLongClickListener
{
  private Context mContext;
  private int mScene;
  public f mzx;
  private am pMt;
  private boolean readOnly = false;
  int sPX = 0;
  int sPY = 0;
  private View vET;
  private com.tencent.mm.plugin.profile.a.b wOW;
  private String wSJ;
  private boolean wSK;
  private int wSL;
  private boolean wfi = false;
  
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
  
  private String T(am paramam)
  {
    AppMethodBeat.i(27280);
    Resources localResources;
    if (dzZ())
    {
      localResources = this.mContext.getResources();
      if (bt.isNullOrNil(paramam.getCity())) {
        paramam = v.zh(paramam.getProvince());
      }
    }
    for (paramam = localResources.getString(2131756698, new Object[] { paramam }).trim();; paramam = paramam.adv())
    {
      paramam = bt.bI(paramam, "");
      AppMethodBeat.o(27280);
      return paramam;
      paramam = paramam.getCity();
      break;
    }
  }
  
  public static CharSequence a(Context paramContext, am paramam, int paramInt, String paramString, boolean paramBoolean)
  {
    String str = null;
    AppMethodBeat.i(27283);
    int i = paramInt;
    if (paramInt == 9) {
      i = paramam.getSource();
    }
    switch (i)
    {
    default: 
      AppMethodBeat.o(27283);
      return null;
    case 4: 
    case 12: 
      paramContext = paramContext.getResources().getString(2131759467);
      AppMethodBeat.o(27283);
      return paramContext;
    case 1: 
      if ((paramBoolean) || (paramam.adx() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757862);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.o.b.lM(paramam.field_type))
      {
        paramContext = paramContext.getResources().getString(2131757861);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131757863);
      AppMethodBeat.o(27283);
      return paramContext;
    case 3: 
      if ((paramBoolean) || (paramam.adx() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757865);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.o.b.lM(paramam.field_type))
      {
        paramContext = paramContext.getResources().getString(2131757864);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131757866);
      AppMethodBeat.o(27283);
      return paramContext;
    case 17: 
      str = iD(((Activity)paramContext).getIntent().getStringExtra("share_card_username"), ((Activity)paramContext).getIntent().getStringExtra("share_card_nickname"));
      paramString = str;
      if (bt.isNullOrNil(str)) {
        paramString = iD(((Activity)paramContext).getIntent().getStringExtra("source_from_user_name"), ((Activity)paramContext).getIntent().getStringExtra("source_from_nick_name"));
      }
      if ((paramBoolean) || (paramam.adx() > 1000000))
      {
        if (bt.isNullOrNil(paramString)) {}
        for (paramContext = paramContext.getString(2131757842);; paramContext = k.c(paramContext, paramContext.getString(2131757841, new Object[] { paramString })))
        {
          AppMethodBeat.o(27283);
          return paramContext;
        }
      }
      if (com.tencent.mm.o.b.lM(paramam.field_type))
      {
        if (bt.isNullOrNil(paramString)) {}
        for (paramContext = paramContext.getString(2131757839);; paramContext = k.c(paramContext, paramContext.getString(2131757840, new Object[] { paramString })))
        {
          AppMethodBeat.o(27283);
          return paramContext;
        }
      }
      if (!bt.isNullOrNil(paramString))
      {
        paramContext = paramContext.getString(2131757843, new Object[] { paramString });
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = k.c(paramContext, paramContext.getString(2131757844));
      AppMethodBeat.o(27283);
      return paramContext;
    case 18: 
      if ((paramBoolean) || (paramam.adx() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757850);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.o.b.lM(paramam.field_type))
      {
        paramContext = paramContext.getResources().getString(2131757849);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131757851);
      AppMethodBeat.o(27283);
      return paramContext;
    case 30: 
      if ((paramBoolean) || (paramam.adx() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757855);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.o.b.lM(paramam.field_type))
      {
        paramContext = paramContext.getResources().getString(2131757854);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131757856);
      AppMethodBeat.o(27283);
      return paramContext;
    case 48: 
      paramContext = paramContext.getResources().getString(2131757857);
      AppMethodBeat.o(27283);
      return paramContext;
    case 8: 
    case 14: 
    case 96: 
      paramString = d.aMn().apM(paramString).field_chatroomName;
      if (bt.isNullOrNil(paramString)) {
        paramString = paramam.field_sourceExtInfo;
      }
      break;
    }
    for (;;)
    {
      am localam = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramString);
      paramString = str;
      if (localam != null)
      {
        if (bt.isNullOrNil(localam.field_username)) {
          paramString = str;
        }
      }
      else
      {
        if ((!paramBoolean) && (paramam.adx() <= 1000000)) {
          break label997;
        }
        if (bt.isNullOrNil(paramString)) {
          break label987;
        }
      }
      label987:
      for (paramContext = paramContext.getString(2131757848, new Object[] { paramString });; paramContext = paramContext.getString(2131757846))
      {
        AppMethodBeat.o(27283);
        return paramContext;
        if (bt.isNullOrNil(localam.field_nickname))
        {
          paramString = q.yJ(localam.field_username);
          break;
        }
        paramString = localam.field_nickname;
        break;
      }
      label997:
      if (com.tencent.mm.o.b.lM(paramam.field_type))
      {
        paramContext = paramContext.getResources().getString(2131757847, new Object[] { paramString });
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131757845);
      AppMethodBeat.o(27283);
      return paramContext;
      if ((paramBoolean) || (paramam.adx() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757868);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.o.b.lM(paramam.field_type))
      {
        paramContext = paramContext.getResources().getString(2131757867);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131757869);
      AppMethodBeat.o(27283);
      return paramContext;
      paramContext = paramContext.getResources().getString(2131757834);
      AppMethodBeat.o(27283);
      return paramContext;
      paramContext = paramContext.getResources().getString(2131760022);
      AppMethodBeat.o(27283);
      return paramContext;
      paramContext = paramContext.getResources().getString(2131757852);
      AppMethodBeat.o(27283);
      return paramContext;
      if ((paramBoolean) || (paramam.adx() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757871);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.o.b.lM(paramam.field_type))
      {
        paramContext = paramContext.getResources().getString(2131757870);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131757872);
      AppMethodBeat.o(27283);
      return paramContext;
      if ((paramBoolean) || (paramam.adx() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757837);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.o.b.lM(paramam.field_type))
      {
        paramContext = paramContext.getResources().getString(2131757836);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131757838);
      AppMethodBeat.o(27283);
      return paramContext;
      if ((paramBoolean) || (paramam.adx() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757859);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.o.b.lM(paramam.field_type))
      {
        paramContext = paramContext.getResources().getString(2131757858);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131757860);
      AppMethodBeat.o(27283);
      return paramContext;
      paramContext = paramContext.getResources().getString(2131759468);
      AppMethodBeat.o(27283);
      return paramContext;
    }
  }
  
  private static void a(a parama, Context paramContext, am paramam, int paramInt, com.tencent.mm.pluginsdk.ui.preference.b[] paramArrayOfb)
  {
    int i = 0;
    AppMethodBeat.i(27281);
    if ((paramArrayOfb == null) || (com.tencent.mm.o.b.lM(paramam.field_type)))
    {
      parama.wTe.setVisibility(8);
      AppMethodBeat.o(27281);
      return;
    }
    parama.wTe.setVisibility(0);
    paramContext = bt.nullAsNil(((Activity)paramContext).getIntent().getStringExtra("Verify_ticket"));
    a.a locala = new a.a();
    locala.talker = paramam.field_username;
    locala.scene = paramInt;
    locala.txJ = paramContext;
    locala.FfL = paramam.ePK;
    locala.type = 0;
    if (paramInt == 18) {
      locala.type = 1;
    }
    for (;;)
    {
      parama.wTe.setFMessageArgs(locala);
      int j = paramArrayOfb.length;
      paramInt = i;
      while (paramInt < j)
      {
        paramContext = paramArrayOfb[paramInt];
        parama.wTe.a(paramContext);
        paramInt += 1;
      }
      if (bj.ox(paramInt)) {
        locala.type = 2;
      }
    }
    AppMethodBeat.o(27281);
  }
  
  private void a(String paramString, am paramam)
  {
    AppMethodBeat.i(27287);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.NormalProfileHeaderPreference", "view stranger remark, username is null");
      AppMethodBeat.o(27287);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("Contact_Scene", this.mScene);
    paramString.putExtra("Contact_mode_name_type", 0);
    paramString.putExtra("Contact_ModStrangerRemark", true);
    paramString.putExtra("Contact_User", paramam.field_username);
    paramString.putExtra("Contact_Nick", paramam.field_nickname);
    paramString.putExtra("Contact_RemarkName", paramam.field_conRemark);
    com.tencent.mm.plugin.profile.b.iRG.n(paramString, this.mContext);
    AppMethodBeat.o(27287);
  }
  
  private boolean dzZ()
  {
    AppMethodBeat.i(27279);
    boolean bool = am.zs(this.pMt.field_username);
    AppMethodBeat.o(27279);
    return bool;
  }
  
  private static String iD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(27284);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(27284);
      return null;
    }
    String str = v.zg(paramString1);
    if (!bt.isNullOrNil(str)) {}
    for (;;)
    {
      AppMethodBeat.o(27284);
      return str;
      str = paramString2;
      if (bt.isNullOrNil(paramString2)) {
        str = v.zf(paramString1);
      }
    }
  }
  
  public final void N(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27282);
    int i = ar.dT(this.mContext);
    this.wSK = paramBoolean;
    this.wSL = paramInt;
    if (paramInt <= 0) {
      this.wSL = i;
    }
    if (this.mzx != null) {
      this.mzx.notifyDataSetChanged();
    }
    ad.i("MicroMsg.NormalProfileHeaderPreference", "setHasStory action=%s weuiActionBarHeight=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(27282);
  }
  
  public final void a(am paramam, int paramInt, boolean paramBoolean, com.tencent.mm.plugin.profile.a.b paramb)
  {
    AppMethodBeat.i(27275);
    this.wSJ = ((Activity)this.mContext).getIntent().getStringExtra("Contact_RoomNickname");
    this.pMt = paramam;
    this.mScene = paramInt;
    this.readOnly = paramBoolean;
    this.wfi = true;
    this.wOW = paramb;
    AppMethodBeat.o(27275);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27278);
    super.onBindView(paramView);
    if (!this.wfi)
    {
      ad.w("MicroMsg.NormalProfileHeaderPreference", "[onBindView] never attach!");
      AppMethodBeat.o(27278);
      return;
    }
    if (paramView.getTag() == null) {
      paramView.setTag(new a(paramView));
    }
    final a locala = (a)paramView.getTag();
    a.b.c(locala.wTd, this.pMt.field_username);
    float f1;
    int n;
    int i1;
    int k;
    label263:
    boolean bool2;
    boolean bool3;
    int m;
    if (((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.patmsg.a.b.class)).G(5, this.pMt.field_username, this.pMt.field_username))
    {
      if (com.tencent.mm.o.b.lM(this.pMt.field_type))
      {
        locala.wTd.setTagUsername(this.pMt.field_username);
        locala.wTd.setTagTalker(this.pMt.field_username);
        locala.wTd.setTagScene(5);
      }
    }
    else if (!bt.isNullOrNil(T(this.pMt)))
    {
      locala.wSX.setVisibility(0);
      f1 = locala.wSX.getTextSize();
      paramView = T(this.pMt);
      n = (int)this.mContext.getResources().getDimension(2131165301);
      i1 = (int)this.mContext.getResources().getDimension(2131165289);
      if (this.pMt.ePk == 0) {
        break label1579;
      }
      k = this.mContext.getResources().getDrawable(2131690323).getIntrinsicWidth();
      boolean bool1 = this.pMt.adn();
      bool2 = o.zbV.auM(this.pMt.field_username);
      bool3 = this.pMt.adm();
      m = (int)this.mContext.getResources().getDimension(2131165274);
      if (!bool1) {
        break label2039;
      }
    }
    label629:
    label2039:
    for (int j = this.mContext.getResources().getDrawable(2131689946).getIntrinsicWidth() + m + m;; j = m)
    {
      int i = j;
      if (bool3) {
        i = j + this.mContext.getResources().getDrawable(2131691050).getIntrinsicWidth() + m;
      }
      j = i;
      if (bool2) {
        j = i + this.mContext.getResources().getDrawable(2131689947).getIntrinsicWidth() + m;
      }
      i = this.mContext.getResources().getDisplayMetrics().widthPixels - n - i1 * 3 - k - j;
      ad.i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] calculateRemarkNameTvSize:%s", new Object[] { Integer.valueOf(i) });
      locala.wSX.setMaxWidth(i);
      locala.wSX.ar(k.b(this.mContext, paramView, f1));
      locala.wSX.setContentDescription(k.b(this.mContext, paramView, f1));
      if (locala.wSX.kK(i, 2147483647).fSB() > 1)
      {
        f1 = com.tencent.mm.cc.a.eb(this.mContext);
        float f2 = com.tencent.mm.cc.a.aA(this.mContext, (int)locala.wSX.getResources().getDimension(2131165579));
        locala.wSX.setTextSize(f1 * f2);
        locala.wSX.ar(k.b(this.mContext, paramView, locala.wSX.getTextSize()));
      }
      Object localObject;
      if (this.wSK)
      {
        locala.wSX.setTextColor(this.mContext.getResources().getColor(2131101182));
        locala.wSX.setMaxLines(1);
        locala.wSX.getPaint().setFakeBoldText(true);
        String str = ((Activity)this.mContext).getIntent().getStringExtra("Contact_Distance");
        if ((!((Activity)this.mContext).getIntent().getBooleanExtra("Contact_IsLBSFriend", false)) || (bt.isNullOrNil(str))) {
          break label1620;
        }
        locala.wTb.setText(this.mContext.getString(2131757645) + str);
        locala.wTb.setVisibility(0);
        if (am.aSQ(this.pMt.field_username))
        {
          locala.wSW.setVisibility(0);
          locala.wSW.setText(com.tencent.mm.openim.room.a.a.H(this.pMt));
        }
        if ((!bt.isNullOrNil(this.pMt.field_nickname)) && (!bt.isNullOrNil(this.pMt.field_conRemark)) && (!dzZ())) {
          break label1633;
        }
        locala.upn.setVisibility(8);
        if (bt.isNullOrNil(this.wSJ)) {
          break label1709;
        }
        if (((Activity)this.mContext).getIntent().getIntExtra("Contact_Scene", -1) != 14) {
          break label1703;
        }
        i = 1;
        if (i == 0) {
          break label1709;
        }
        locala.wSY.setVisibility(0);
        paramView = this.mContext.getString(2131757629) + this.wSJ;
        locala.wSY.setText(k.b(this.mContext, paramView, locala.upn.getTextSize()));
        if (((bt.isNullOrNil(this.pMt.VA())) && (bt.isNullOrNil(this.pMt.field_username))) || (!com.tencent.mm.o.b.lM(this.pMt.field_type)) || (am.aSQ(this.pMt.field_username)) || (dzZ())) {
          break label1733;
        }
        locala.uGm.setVisibility(0);
        localObject = locala.uGm;
        StringBuilder localStringBuilder = new StringBuilder().append(this.mContext.getString(2131755760));
        if (!bt.isNullOrNil(this.pMt.VA())) {
          break label1722;
        }
        paramView = this.pMt.field_username;
        ((TextView)localObject).setText(paramView);
        if (this.pMt.field_deleteFlag != 1) {
          break label1746;
        }
        locala.wTc.setVisibility(0);
        locala.wTc.setText(this.mContext.getText(2131757576));
        locala.upn.setVisibility(8);
        locala.wSZ.setVisibility(8);
        i = 1;
        if (i != 0) {
          ad.i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] has delete account! username:%s", new Object[] { this.pMt.field_username });
        }
        if ((com.tencent.mm.o.b.lM(this.pMt.field_type)) || (dzZ()) || (w.Ag(this.pMt.field_username))) {
          break label1772;
        }
        ad.i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] accept contact! username:%s", new Object[] { this.pMt.field_username });
        locala.wTk.setVisibility(8);
        if ((com.tencent.mm.o.b.lM(this.pMt.field_type)) || (!((Activity)this.mContext).getIntent().getBooleanExtra("User_Verify", false))) {
          break label1793;
        }
        i = 1;
        if (i == 0) {
          break label1799;
        }
        locala.wTk.setVisibility(0);
        a(locala, this.mContext, this.pMt, this.mScene, p.a(this.mContext, this.pMt, this.mScene));
        if (!bt.isNullOrNil(this.pMt.signature)) {
          break label1812;
        }
        locala.wSZ.setVisibility(8);
        if (!bt.isNullOrNil(this.pMt.getProvince())) {
          break label1847;
        }
        locala.wTa.setVisibility(8);
        paramView = locala.wSV;
        localObject = this.pMt;
        paramView.setVisibility(0);
        if (((aw)localObject).ePk != 1) {
          break label1969;
        }
        paramView.setImageDrawable(com.tencent.mm.cc.a.l(this.mContext, 2131690323));
        paramView.setContentDescription(this.mContext.getString(2131762052));
        i = ((Activity)this.mContext).getIntent().getIntExtra("Contact_Scene", 0);
        if ((26 > i) || (i > 29)) {
          break label2026;
        }
        i = 1;
        if (i != 0)
        {
          locala.wTb.setVisibility(0);
          locala.upn.setVisibility(8);
          locala.wTb.setText(this.mContext.getString(2131757645) + str);
        }
        if (!w.Ag(this.pMt.field_username))
        {
          paramView = locala.wTh;
          if ((!this.pMt.adm()) || (!com.tencent.mm.o.b.lM(this.pMt.field_type))) {
            break label2032;
          }
        }
      }
      for (i = 0;; i = 8)
      {
        paramView.setVisibility(i);
        locala.wTm.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            AppMethodBeat.i(193256);
            locala.wTm.getViewTreeObserver().removeOnPreDrawListener(this);
            int[] arrayOfInt = new int[2];
            locala.wTm.getLocationOnScreen(arrayOfInt);
            int k = arrayOfInt[1];
            int m = ar.jG(NormalProfileHeaderPreference.this.mContext);
            int j = com.tencent.mm.cc.a.ay(NormalProfileHeaderPreference.this.mContext, 2131166723);
            ad.i("MicroMsg.NormalProfileHeaderPreference", "actionBarHeight=%s ,statusBarHeight=%s , rootTop:%s", new Object[] { Integer.valueOf(NormalProfileHeaderPreference.a(NormalProfileHeaderPreference.this)), Integer.valueOf(m), Integer.valueOf(k) });
            int i;
            if (NormalProfileHeaderPreference.b(NormalProfileHeaderPreference.this)) {
              i = com.tencent.mm.cc.a.ay(NormalProfileHeaderPreference.this.mContext, 2131166721);
            }
            for (;;)
            {
              j = i;
              if (k == 0)
              {
                j = i;
                if (!NormalProfileHeaderPreference.b(NormalProfileHeaderPreference.this)) {
                  j = i + m;
                }
              }
              if (j == locala.wTm.getPaddingTop()) {
                break;
              }
              locala.wTm.setPadding(locala.wTm.getPaddingLeft(), j, locala.wTm.getPaddingRight(), locala.wTm.getPaddingBottom());
              AppMethodBeat.o(193256);
              return false;
              i = j;
              if (m > 0)
              {
                i = j;
                if (NormalProfileHeaderPreference.a(NormalProfileHeaderPreference.this) > 0) {
                  i = NormalProfileHeaderPreference.a(NormalProfileHeaderPreference.this) + com.tencent.mm.cc.a.ay(NormalProfileHeaderPreference.this.mContext, 2131165289);
                }
              }
            }
            AppMethodBeat.o(193256);
            return true;
          }
        });
        AppMethodBeat.o(27278);
        return;
        locala.wTd.setOnDoubleClickListener(new c.a()
        {
          public final boolean ex(View paramAnonymousView)
          {
            AppMethodBeat.i(193255);
            ((PluginPatMsg)com.tencent.mm.kernel.g.ad(PluginPatMsg.class)).playPatAnimation(paramAnonymousView);
            AppMethodBeat.o(193255);
            return true;
          }
        });
        break;
        k = 0;
        break label263;
        locala.wSX.setTextColor(this.mContext.getResources().getColor(2131099732));
        locala.wSX.setMaxLines(2147483647);
        break label629;
        locala.wTb.setVisibility(8);
        break label732;
        locala.upn.setVisibility(0);
        paramView = this.mContext.getString(2131757742) + this.pMt.field_nickname;
        locala.upn.setText(k.b(this.mContext, paramView, locala.upn.getTextSize()));
        break label812;
        i = 0;
        break label847;
        locala.wSY.setVisibility(8);
        break label916;
        paramView = this.pMt.VA();
        break label1034;
        locala.uGm.setVisibility(8);
        break label1048;
        locala.wTc.setVisibility(8);
        locala.wSZ.setVisibility(8);
        i = 0;
        break label1109;
        if (locala.wTk == null) {
          break label1203;
        }
        locala.wTk.setVisibility(8);
        break label1203;
        i = 0;
        break label1239;
        locala.wTk.setVisibility(8);
        break label1253;
        locala.wSZ.setText(k.c(this.mContext, this.pMt.signature));
        locala.wSZ.setVisibility(8);
        break label1308;
        locala.wTa.setVisibility(0);
        localObject = new StringBuilder().append(v.zh(this.pMt.getProvince()));
        if (bt.isNullOrNil(this.pMt.getCity())) {}
        for (paramView = "";; paramView = "  " + this.pMt.getCity())
        {
          paramView = paramView;
          locala.wTa.setText(this.mContext.getString(2131757721) + paramView);
          break;
        }
        if (((aw)localObject).ePk == 2)
        {
          paramView.setImageDrawable(com.tencent.mm.cc.a.l(this.mContext, 2131690322));
          paramView.setContentDescription(this.mContext.getString(2131762051));
          break label1385;
        }
        if (((aw)localObject).ePk != 0) {
          break label1385;
        }
        paramView.setVisibility(8);
        break label1385;
        i = 0;
        break label1421;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(27285);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    int i = paramView.getId();
    if (i == 2131303982)
    {
      paramView = this.pMt;
      if (paramView == null) {
        ad.e("MicroMsg.NormalProfileHeaderPreference", "contact is null");
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(27285);
      return;
      if (!com.tencent.mm.o.b.lM(paramView.field_type))
      {
        if (!bt.isNullOrNil(paramView.field_encryptUsername)) {
          a(paramView.field_encryptUsername, paramView);
        } else {
          a(paramView.field_username, paramView);
        }
      }
      else
      {
        localObject = (PhoneNumPreference)this.mzx.aVD("contact_profile_phone");
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_Scene", this.mScene);
        localIntent.putExtra("Contact_User", paramView.field_username);
        localIntent.putExtra("view_mode", true);
        localIntent.putExtra("contact_phone_number_by_md5", ((PhoneNumPreference)localObject).ETv);
        localIntent.putExtra("contact_phone_number_list", paramView.ePJ);
        com.tencent.mm.plugin.profile.b.iRG.m(localIntent, this.mContext);
        continue;
        if (i == 2131302424)
        {
          if (this.wOW != null) {
            this.wOW.dAi();
          }
        }
        else if (i == 2131298688)
        {
          localObject = this.pMt.field_username;
          paramView = new Intent(this.mContext, ProfileHdHeadImg.class);
          paramView.putExtra("username", (String)localObject);
          localObject = this.mContext;
          paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.ahp(), "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "clickAvatar", "(Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject).startActivity((Intent)paramView.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "clickAvatar", "(Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(c.aG(((Activity)this.mContext).getIntent())), Integer.valueOf(16), Integer.valueOf(1), this.pMt.field_username });
        }
      }
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27277);
    if (this.vET == null) {
      this.vET = super.onCreateView(paramViewGroup);
    }
    paramViewGroup = this.vET;
    AppMethodBeat.o(27277);
    return paramViewGroup;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(27276);
    if (this.vET != null)
    {
      a locala = (a)this.vET.getTag();
      if (locala.wTe != null) {
        locala.wTe.detach();
      }
    }
    AppMethodBeat.o(27276);
  }
  
  public boolean onLongClick(final View paramView)
  {
    AppMethodBeat.i(27286);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    if (paramView.getId() == 2131298706)
    {
      final TextView localTextView = (TextView)paramView;
      final am localam = this.pMt;
      final ClipboardManager localClipboardManager = (ClipboardManager)aj.getContext().getSystemService("clipboard");
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
        ((SpannableString)localObject).setSpan(new BackgroundColorSpan(this.mContext.getResources().getColor(2131100539)), i + 2, localTextView.getText().length(), 33);
        localTextView.setText((CharSequence)localObject);
        localObject = new com.tencent.mm.ui.widget.b.a(this.mContext, localTextView);
        ((com.tencent.mm.ui.widget.b.a)localObject).Lai = new View.OnCreateContextMenuListener()
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(193257);
            paramAnonymousContextMenu.add(NormalProfileHeaderPreference.c(NormalProfileHeaderPreference.this).getString(2131755701));
            AppMethodBeat.o(193257);
          }
        };
        ((com.tencent.mm.ui.widget.b.a)localObject).KJz = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(193258);
            if (paramAnonymousInt == 0)
            {
              localClipboardManager.setText(paramView);
              h.ck(NormalProfileHeaderPreference.c(NormalProfileHeaderPreference.this), NormalProfileHeaderPreference.c(NormalProfileHeaderPreference.this).getString(2131755702));
            }
            AppMethodBeat.o(193258);
          }
        };
        ((com.tencent.mm.ui.widget.b.a)localObject).KLB = new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(193259);
            NormalProfileHeaderPreference.a(NormalProfileHeaderPreference.this, localTextView, localam);
            AppMethodBeat.o(193259);
          }
        };
        if (!(localTextView.getTag(2131306044) instanceof int[])) {
          break label313;
        }
        paramView = (int[])localTextView.getTag(2131306044);
        ((com.tencent.mm.ui.widget.b.a)localObject).el(paramView[0], paramView[1]);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(27286);
        return true;
        label313:
        ((com.tencent.mm.ui.widget.b.a)localObject).el(this.sPX, this.sPY);
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(27286);
    return false;
  }
  
  final class a
  {
    TextView uGm;
    TextView upn;
    private View wSP;
    private View wSQ;
    private View wSR;
    private View wSS;
    private View wST;
    private View wSU;
    ImageView wSV;
    TextView wSW;
    MMNeat7extView wSX;
    TextView wSY;
    TextView wSZ;
    TextView wTa;
    TextView wTb;
    TextView wTc;
    AvatarPatTipImageView wTd;
    FMessageListView wTe;
    private View wTf;
    private LinearLayout wTg;
    ImageView wTh;
    private ImageView wTi;
    private ImageView wTj;
    View wTk;
    private ImageView wTl;
    View wTm;
    private View wTn;
    
    a(View paramView)
    {
      AppMethodBeat.i(27274);
      this.wSP = null;
      this.wSQ = null;
      this.wSR = null;
      this.wSS = null;
      this.wST = null;
      this.wSU = null;
      this.wSV = null;
      this.upn = null;
      this.wSW = null;
      this.wSX = null;
      this.wSY = null;
      this.uGm = null;
      this.wSZ = null;
      this.wTa = null;
      this.wTb = null;
      this.wTc = null;
      this.wTd = null;
      this.wTg = null;
      this.wTk = paramView.findViewById(2131296322);
      this.wTe = ((FMessageListView)paramView.findViewById(2131298693));
      this.wTf = paramView.findViewById(2131298694);
      this.wSP = paramView.findViewById(2131298691);
      this.wSQ = paramView.findViewById(2131298686);
      this.wSR = paramView.findViewById(2131298700);
      this.wST = paramView.findViewById(2131298687);
      this.wSU = paramView.findViewById(2131298702);
      this.wSS = paramView.findViewById(2131298708);
      this.wTd = ((AvatarPatTipImageView)paramView.findViewById(2131298688));
      this.wSY = ((TextView)paramView.findViewById(2131298690));
      this.wSX = ((MMNeat7extView)paramView.findViewById(2131298698));
      this.upn = ((TextView)paramView.findViewById(2131298697));
      this.wSW = ((TextView)paramView.findViewById(2131298681));
      this.wSV = ((ImageView)paramView.findViewById(2131298703));
      this.uGm = ((TextView)paramView.findViewById(2131298706));
      this.wSZ = ((TextView)paramView.findViewById(2131298704));
      this.wTa = ((TextView)paramView.findViewById(2131298696));
      this.wTb = ((TextView)paramView.findViewById(2131298692));
      this.wTc = ((TextView)paramView.findViewById(2131298705));
      this.wTh = ((ImageView)paramView.findViewById(2131298685));
      this.wTi = ((ImageView)paramView.findViewById(2131298683));
      this.wTj = ((ImageView)paramView.findViewById(2131298684));
      this.wTl = ((ImageView)paramView.findViewById(2131298590));
      this.wTm = paramView.findViewById(2131298699);
      this.wTn = paramView.findViewById(2131298689);
      this.wTg = ((LinearLayout)paramView.findViewById(2131298695));
      this.wTk.findViewById(2131303982).setOnClickListener(NormalProfileHeaderPreference.this);
      this.wTk.findViewById(2131302424).setOnClickListener(NormalProfileHeaderPreference.this);
      this.wSU.setOnClickListener(NormalProfileHeaderPreference.this);
      this.wSS.setOnClickListener(NormalProfileHeaderPreference.this);
      this.wTd.setOnClickListener(NormalProfileHeaderPreference.this);
      this.wSP.setOnClickListener(NormalProfileHeaderPreference.this);
      this.wSQ.setOnClickListener(NormalProfileHeaderPreference.this);
      this.wSR.setOnClickListener(NormalProfileHeaderPreference.this);
      this.wST.setOnClickListener(NormalProfileHeaderPreference.this);
      this.uGm.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(27273);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference$ViewHolder$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          NormalProfileHeaderPreference.this.sPX = ((int)paramAnonymousMotionEvent.getRawX());
          NormalProfileHeaderPreference.this.sPY = ((int)paramAnonymousMotionEvent.getRawY());
          paramAnonymousView.setTag(2131306044, new int[] { NormalProfileHeaderPreference.this.sPX, NormalProfileHeaderPreference.this.sPY });
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference$ViewHolder$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(27273);
          return false;
        }
      });
      this.uGm.setOnLongClickListener(NormalProfileHeaderPreference.this);
      this.wTl.setOnClickListener(NormalProfileHeaderPreference.this);
      AppMethodBeat.o(27274);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference
 * JD-Core Version:    0.7.0.1
 */