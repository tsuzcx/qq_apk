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
import com.tencent.mm.bj.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.r;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.patmsg.a.c.a;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.preference.FMessageListView;
import com.tencent.mm.pluginsdk.ui.preference.PhoneNumPreference;
import com.tencent.mm.pluginsdk.ui.preference.a.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bq;
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
  int jwh = 0;
  int jwi = 0;
  private Context mContext;
  public f mEx;
  private int mScene;
  private an pSY;
  private boolean readOnly = false;
  private View vQX;
  private boolean wuL = false;
  private com.tencent.mm.plugin.profile.a.b xeK;
  private String xiA;
  private boolean xiB;
  private int xiC;
  
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
  
  public static CharSequence a(Context paramContext, an paraman, int paramInt, String paramString, boolean paramBoolean)
  {
    String str = null;
    AppMethodBeat.i(27283);
    int i = paramInt;
    if (paramInt == 9) {
      i = paraman.getSource();
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
      if ((paramBoolean) || (paraman.adI() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757862);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.c.lO(paraman.field_type))
      {
        paramContext = paramContext.getResources().getString(2131757861);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131757863);
      AppMethodBeat.o(27283);
      return paramContext;
    case 3: 
      if ((paramBoolean) || (paraman.adI() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757865);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.c.lO(paraman.field_type))
      {
        paramContext = paramContext.getResources().getString(2131757864);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131757866);
      AppMethodBeat.o(27283);
      return paramContext;
    case 17: 
      str = iJ(((Activity)paramContext).getIntent().getStringExtra("share_card_username"), ((Activity)paramContext).getIntent().getStringExtra("share_card_nickname"));
      paramString = str;
      if (bu.isNullOrNil(str)) {
        paramString = iJ(((Activity)paramContext).getIntent().getStringExtra("source_from_user_name"), ((Activity)paramContext).getIntent().getStringExtra("source_from_nick_name"));
      }
      if ((paramBoolean) || (paraman.adI() > 1000000))
      {
        if (bu.isNullOrNil(paramString)) {}
        for (paramContext = paramContext.getString(2131757842);; paramContext = k.c(paramContext, paramContext.getString(2131757841, new Object[] { paramString })))
        {
          AppMethodBeat.o(27283);
          return paramContext;
        }
      }
      if (com.tencent.mm.contact.c.lO(paraman.field_type))
      {
        if (bu.isNullOrNil(paramString)) {}
        for (paramContext = paramContext.getString(2131757839);; paramContext = k.c(paramContext, paramContext.getString(2131757840, new Object[] { paramString })))
        {
          AppMethodBeat.o(27283);
          return paramContext;
        }
      }
      if (!bu.isNullOrNil(paramString))
      {
        paramContext = paramContext.getString(2131757843, new Object[] { paramString });
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = k.c(paramContext, paramContext.getString(2131757844));
      AppMethodBeat.o(27283);
      return paramContext;
    case 18: 
      if ((paramBoolean) || (paraman.adI() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757850);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.c.lO(paraman.field_type))
      {
        paramContext = paramContext.getResources().getString(2131757849);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131757851);
      AppMethodBeat.o(27283);
      return paramContext;
    case 30: 
      if ((paramBoolean) || (paraman.adI() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757855);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.c.lO(paraman.field_type))
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
      paramString = d.aML().aqR(paramString).field_chatroomName;
      if (bu.isNullOrNil(paramString)) {
        paramString = paraman.field_sourceExtInfo;
      }
      break;
    }
    for (;;)
    {
      an localan = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramString);
      paramString = str;
      if (localan != null)
      {
        if (bu.isNullOrNil(localan.field_username)) {
          paramString = str;
        }
      }
      else
      {
        if ((!paramBoolean) && (paraman.adI() <= 1000000)) {
          break label997;
        }
        if (bu.isNullOrNil(paramString)) {
          break label987;
        }
      }
      label987:
      for (paramContext = paramContext.getString(2131757848, new Object[] { paramString });; paramContext = paramContext.getString(2131757846))
      {
        AppMethodBeat.o(27283);
        return paramContext;
        if (bu.isNullOrNil(localan.field_nickname))
        {
          paramString = r.zt(localan.field_username);
          break;
        }
        paramString = localan.field_nickname;
        break;
      }
      label997:
      if (com.tencent.mm.contact.c.lO(paraman.field_type))
      {
        paramContext = paramContext.getResources().getString(2131757847, new Object[] { paramString });
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131757845);
      AppMethodBeat.o(27283);
      return paramContext;
      if ((paramBoolean) || (paraman.adI() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757868);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.c.lO(paraman.field_type))
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
      if ((paramBoolean) || (paraman.adI() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757871);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.c.lO(paraman.field_type))
      {
        paramContext = paramContext.getResources().getString(2131757870);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131757872);
      AppMethodBeat.o(27283);
      return paramContext;
      if ((paramBoolean) || (paraman.adI() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757837);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.c.lO(paraman.field_type))
      {
        paramContext = paramContext.getResources().getString(2131757836);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131757838);
      AppMethodBeat.o(27283);
      return paramContext;
      if ((paramBoolean) || (paraman.adI() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757859);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.c.lO(paraman.field_type))
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
  
  private static void a(a parama, Context paramContext, an paraman, int paramInt, com.tencent.mm.pluginsdk.ui.preference.b[] paramArrayOfb)
  {
    int i = 0;
    AppMethodBeat.i(27281);
    if ((paramArrayOfb == null) || (com.tencent.mm.contact.c.lO(paraman.field_type)))
    {
      parama.xiV.setVisibility(8);
      AppMethodBeat.o(27281);
      return;
    }
    parama.xiV.setVisibility(0);
    paramContext = bu.nullAsNil(((Activity)paramContext).getIntent().getStringExtra("Verify_ticket"));
    a.a locala = new a.a();
    locala.talker = paraman.field_username;
    locala.scene = paramInt;
    locala.tIA = paramContext;
    locala.Fyj = paraman.eRv;
    locala.type = 0;
    if (paramInt == 18) {
      locala.type = 1;
    }
    for (;;)
    {
      parama.xiV.setFMessageArgs(locala);
      int j = paramArrayOfb.length;
      paramInt = i;
      while (paramInt < j)
      {
        paramContext = paramArrayOfb[paramInt];
        parama.xiV.a(paramContext);
        paramInt += 1;
      }
      if (bl.oA(paramInt)) {
        locala.type = 2;
      }
    }
    AppMethodBeat.o(27281);
  }
  
  private void a(String paramString, an paraman)
  {
    AppMethodBeat.i(27287);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.NormalProfileHeaderPreference", "view stranger remark, username is null");
      AppMethodBeat.o(27287);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("Contact_Scene", this.mScene);
    paramString.putExtra("Contact_mode_name_type", 0);
    paramString.putExtra("Contact_ModStrangerRemark", true);
    paramString.putExtra("Contact_User", paraman.field_username);
    paramString.putExtra("Contact_Nick", paraman.field_nickname);
    paramString.putExtra("Contact_RemarkName", paraman.field_conRemark);
    com.tencent.mm.plugin.profile.b.iUz.n(paramString, this.mContext);
    AppMethodBeat.o(27287);
  }
  
  private String aa(an paraman)
  {
    AppMethodBeat.i(27280);
    Resources localResources;
    if (dDq())
    {
      localResources = this.mContext.getResources();
      if (bu.isNullOrNil(paraman.getCity())) {
        paraman = w.zR(paraman.getProvince());
      }
    }
    for (paraman = localResources.getString(2131756698, new Object[] { paraman }).trim();; paraman = paraman.adG())
    {
      paraman = bu.bI(paraman, "");
      AppMethodBeat.o(27280);
      return paraman;
      paraman = paraman.getCity();
      break;
    }
  }
  
  private boolean dDq()
  {
    AppMethodBeat.i(27279);
    boolean bool = an.Ac(this.pSY.field_username);
    AppMethodBeat.o(27279);
    return bool;
  }
  
  private static String iJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(27284);
    if (bu.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(27284);
      return null;
    }
    String str = w.zQ(paramString1);
    if (!bu.isNullOrNil(str)) {}
    for (;;)
    {
      AppMethodBeat.o(27284);
      return str;
      str = paramString2;
      if (bu.isNullOrNil(paramString2)) {
        str = w.zP(paramString1);
      }
    }
  }
  
  public final void Q(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27282);
    int i = ar.dX(this.mContext);
    this.xiB = paramBoolean;
    this.xiC = paramInt;
    if (paramInt <= 0) {
      this.xiC = i;
    }
    if (this.mEx != null) {
      this.mEx.notifyDataSetChanged();
    }
    ae.i("MicroMsg.NormalProfileHeaderPreference", "setHasStory action=%s weuiActionBarHeight=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(27282);
  }
  
  public final void a(an paraman, int paramInt, boolean paramBoolean, com.tencent.mm.plugin.profile.a.b paramb)
  {
    AppMethodBeat.i(27275);
    this.xiA = ((Activity)this.mContext).getIntent().getStringExtra("Contact_RoomNickname");
    this.pSY = paraman;
    this.mScene = paramInt;
    this.readOnly = paramBoolean;
    this.wuL = true;
    this.xeK = paramb;
    AppMethodBeat.o(27275);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27278);
    super.onBindView(paramView);
    if (!this.wuL)
    {
      ae.w("MicroMsg.NormalProfileHeaderPreference", "[onBindView] never attach!");
      AppMethodBeat.o(27278);
      return;
    }
    if (paramView.getTag() == null) {
      paramView.setTag(new a(paramView));
    }
    final a locala = (a)paramView.getTag();
    a.b.c(locala.xiU, this.pSY.field_username);
    float f1;
    int n;
    int i1;
    int k;
    label263:
    boolean bool2;
    boolean bool3;
    int m;
    if (((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.patmsg.a.b.class)).G(5, this.pSY.field_username, this.pSY.field_username))
    {
      if (com.tencent.mm.contact.c.lO(this.pSY.field_type))
      {
        locala.xiU.setTagUsername(this.pSY.field_username);
        locala.xiU.setTagTalker(this.pSY.field_username);
        locala.xiU.setTagScene(5);
      }
    }
    else if (!bu.isNullOrNil(aa(this.pSY)))
    {
      locala.xiO.setVisibility(0);
      f1 = locala.xiO.getTextSize();
      paramView = aa(this.pSY);
      n = (int)this.mContext.getResources().getDimension(2131165301);
      i1 = (int)this.mContext.getResources().getDimension(2131165289);
      if (this.pSY.eQV == 0) {
        break label1579;
      }
      k = this.mContext.getResources().getDrawable(2131690323).getIntrinsicWidth();
      boolean bool1 = this.pSY.ady();
      bool2 = o.zsy.awb(this.pSY.field_username);
      bool3 = this.pSY.adx();
      m = (int)this.mContext.getResources().getDimension(2131165274);
      if (!bool1) {
        break label2040;
      }
    }
    label629:
    label2040:
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
      ae.i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] calculateRemarkNameTvSize:%s", new Object[] { Integer.valueOf(i) });
      locala.xiO.setMaxWidth(i);
      locala.xiO.aq(k.b(this.mContext, paramView, f1));
      locala.xiO.setContentDescription(k.b(this.mContext, paramView, f1));
      if (locala.xiO.kR(i, 2147483647).fXb() > 1)
      {
        f1 = com.tencent.mm.cb.a.ef(this.mContext);
        float f2 = com.tencent.mm.cb.a.aA(this.mContext, (int)locala.xiO.getResources().getDimension(2131165579));
        locala.xiO.setTextSize(f1 * f2);
        locala.xiO.aq(k.b(this.mContext, paramView, locala.xiO.getTextSize()));
      }
      Object localObject;
      if (this.xiB)
      {
        locala.xiO.setTextColor(this.mContext.getResources().getColor(2131101182));
        locala.xiO.setMaxLines(1);
        locala.xiO.getPaint().setFakeBoldText(true);
        String str = ((Activity)this.mContext).getIntent().getStringExtra("Contact_Distance");
        if ((!((Activity)this.mContext).getIntent().getBooleanExtra("Contact_IsLBSFriend", false)) || (bu.isNullOrNil(str))) {
          break label1620;
        }
        locala.xiS.setText(this.mContext.getString(2131757645) + str);
        locala.xiS.setVisibility(0);
        if (an.aUq(this.pSY.field_username))
        {
          locala.xiN.setVisibility(0);
          locala.xiN.setText(com.tencent.mm.openim.room.a.a.O(this.pSY));
        }
        if ((!bu.isNullOrNil(this.pSY.field_nickname)) && (!bu.isNullOrNil(this.pSY.field_conRemark)) && (!dDq())) {
          break label1633;
        }
        locala.uAJ.setVisibility(8);
        if (bu.isNullOrNil(this.xiA)) {
          break label1709;
        }
        if (((Activity)this.mContext).getIntent().getIntExtra("Contact_Scene", -1) != 14) {
          break label1703;
        }
        i = 1;
        if (i == 0) {
          break label1709;
        }
        locala.xiP.setVisibility(0);
        paramView = this.mContext.getString(2131757629) + this.xiA;
        locala.xiP.setText(k.b(this.mContext, paramView, locala.uAJ.getTextSize()));
        if (((bu.isNullOrNil(this.pSY.VI())) && (bu.isNullOrNil(this.pSY.field_username))) || (!com.tencent.mm.contact.c.lO(this.pSY.field_type)) || (an.aUq(this.pSY.field_username)) || (dDq())) {
          break label1733;
        }
        locala.uRZ.setVisibility(0);
        localObject = locala.uRZ;
        StringBuilder localStringBuilder = new StringBuilder().append(this.mContext.getString(2131755760));
        if (!bu.isNullOrNil(this.pSY.VI())) {
          break label1722;
        }
        paramView = this.pSY.field_username;
        ((TextView)localObject).setText(paramView);
        if (this.pSY.field_deleteFlag != 1) {
          break label1746;
        }
        locala.xiT.setVisibility(0);
        locala.xiT.setText(this.mContext.getText(2131757576));
        locala.uAJ.setVisibility(8);
        locala.xiQ.setVisibility(8);
        i = 1;
        if (i != 0) {
          ae.i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] has delete account! username:%s", new Object[] { this.pSY.field_username });
        }
        if ((com.tencent.mm.contact.c.lO(this.pSY.field_type)) || (dDq()) || (x.AQ(this.pSY.field_username))) {
          break label1772;
        }
        ae.i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] accept contact! username:%s", new Object[] { this.pSY.field_username });
        locala.xjb.setVisibility(8);
        if ((com.tencent.mm.contact.c.lO(this.pSY.field_type)) || (!((Activity)this.mContext).getIntent().getBooleanExtra("User_Verify", false))) {
          break label1793;
        }
        i = 1;
        if (i == 0) {
          break label1799;
        }
        locala.xjb.setVisibility(0);
        a(locala, this.mContext, this.pSY, this.mScene, p.a(this.mContext, this.pSY, this.mScene));
        if (!bu.isNullOrNil(this.pSY.signature)) {
          break label1812;
        }
        locala.xiQ.setVisibility(8);
        if (!bu.isNullOrNil(this.pSY.getProvince())) {
          break label1847;
        }
        locala.xiR.setVisibility(8);
        paramView = locala.xiM;
        localObject = this.pSY;
        paramView.setVisibility(0);
        if (((aw)localObject).eQV != 1) {
          break label1970;
        }
        paramView.setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131690323));
        paramView.setContentDescription(this.mContext.getString(2131762052));
        i = ((Activity)this.mContext).getIntent().getIntExtra("Contact_Scene", 0);
        if ((26 > i) || (i > 29)) {
          break label2027;
        }
        i = 1;
        if (i != 0)
        {
          locala.xiS.setVisibility(0);
          locala.uAJ.setVisibility(8);
          locala.xiS.setText(this.mContext.getString(2131757645) + str);
        }
        if (!x.AQ(this.pSY.field_username))
        {
          paramView = locala.xiY;
          if ((!this.pSY.adx()) || (!com.tencent.mm.contact.c.lO(this.pSY.field_type))) {
            break label2033;
          }
        }
      }
      for (i = 0;; i = 8)
      {
        paramView.setVisibility(i);
        locala.xjd.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            AppMethodBeat.i(186530);
            locala.xjd.getViewTreeObserver().removeOnPreDrawListener(this);
            int[] arrayOfInt = new int[2];
            locala.xjd.getLocationOnScreen(arrayOfInt);
            int k = arrayOfInt[1];
            int m = ar.jN(NormalProfileHeaderPreference.this.mContext);
            int j = com.tencent.mm.cb.a.ay(NormalProfileHeaderPreference.this.mContext, 2131166723);
            ae.i("MicroMsg.NormalProfileHeaderPreference", "actionBarHeight=%s ,statusBarHeight=%s , rootTop:%s", new Object[] { Integer.valueOf(NormalProfileHeaderPreference.a(NormalProfileHeaderPreference.this)), Integer.valueOf(m), Integer.valueOf(k) });
            int i;
            if (NormalProfileHeaderPreference.b(NormalProfileHeaderPreference.this)) {
              i = com.tencent.mm.cb.a.ay(NormalProfileHeaderPreference.this.mContext, 2131166721);
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
              if (j == locala.xjd.getPaddingTop()) {
                break;
              }
              locala.xjd.setPadding(locala.xjd.getPaddingLeft(), j, locala.xjd.getPaddingRight(), locala.xjd.getPaddingBottom());
              AppMethodBeat.o(186530);
              return false;
              i = j;
              if (m > 0)
              {
                i = j;
                if (NormalProfileHeaderPreference.a(NormalProfileHeaderPreference.this) > 0) {
                  i = NormalProfileHeaderPreference.a(NormalProfileHeaderPreference.this) + com.tencent.mm.cb.a.ay(NormalProfileHeaderPreference.this.mContext, 2131165289);
                }
              }
            }
            AppMethodBeat.o(186530);
            return true;
          }
        });
        AppMethodBeat.o(27278);
        return;
        locala.xiU.setOnDoubleClickListener(new c.a()
        {
          public final boolean ex(View paramAnonymousView)
          {
            AppMethodBeat.i(186529);
            ((PluginPatMsg)com.tencent.mm.kernel.g.ad(PluginPatMsg.class)).playPatAnimation(paramAnonymousView);
            AppMethodBeat.o(186529);
            return true;
          }
        });
        break;
        k = 0;
        break label263;
        locala.xiO.setTextColor(this.mContext.getResources().getColor(2131099732));
        locala.xiO.setMaxLines(2147483647);
        break label629;
        locala.xiS.setVisibility(8);
        break label732;
        locala.uAJ.setVisibility(0);
        paramView = this.mContext.getString(2131757742) + this.pSY.field_nickname;
        locala.uAJ.setText(k.b(this.mContext, paramView, locala.uAJ.getTextSize()));
        break label812;
        i = 0;
        break label847;
        locala.xiP.setVisibility(8);
        break label916;
        paramView = this.pSY.VI();
        break label1034;
        locala.uRZ.setVisibility(8);
        break label1048;
        locala.xiT.setVisibility(8);
        locala.xiQ.setVisibility(8);
        i = 0;
        break label1109;
        if (locala.xjb == null) {
          break label1203;
        }
        locala.xjb.setVisibility(8);
        break label1203;
        i = 0;
        break label1239;
        locala.xjb.setVisibility(8);
        break label1253;
        locala.xiQ.setText(k.c(this.mContext, this.pSY.signature));
        locala.xiQ.setVisibility(8);
        break label1308;
        locala.xiR.setVisibility(0);
        localObject = new StringBuilder().append(w.zR(this.pSY.getProvince()));
        if (bu.isNullOrNil(this.pSY.getCity())) {}
        for (paramView = "";; paramView = "  " + this.pSY.getCity())
        {
          paramView = paramView;
          locala.xiR.setText(this.mContext.getString(2131757721) + paramView);
          break;
        }
        if (((aw)localObject).eQV == 2)
        {
          paramView.setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131690322));
          paramView.setContentDescription(this.mContext.getString(2131762051));
          break label1385;
        }
        if (((aw)localObject).eQV != 0) {
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
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    int i = paramView.getId();
    if (i == 2131303982)
    {
      paramView = this.pSY;
      if (paramView == null) {
        ae.e("MicroMsg.NormalProfileHeaderPreference", "contact is null");
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(27285);
      return;
      if (!com.tencent.mm.contact.c.lO(paramView.field_type))
      {
        if (!bu.isNullOrNil(paramView.field_encryptUsername)) {
          a(paramView.field_encryptUsername, paramView);
        } else {
          a(paramView.field_username, paramView);
        }
      }
      else
      {
        localObject = (PhoneNumPreference)this.mEx.aXe("contact_profile_phone");
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_Scene", this.mScene);
        localIntent.putExtra("Contact_User", paramView.field_username);
        localIntent.putExtra("view_mode", true);
        localIntent.putExtra("contact_phone_number_by_md5", ((PhoneNumPreference)localObject).FlQ);
        localIntent.putExtra("contact_phone_number_list", paramView.eRu);
        com.tencent.mm.plugin.profile.b.iUz.m(localIntent, this.mContext);
        continue;
        if (i == 2131302424)
        {
          if (this.xeK != null) {
            this.xeK.dDz();
          }
        }
        else if (i == 2131298688)
        {
          localObject = this.pSY.field_username;
          paramView = new Intent(this.mContext, ProfileHdHeadImg.class);
          paramView.putExtra("username", (String)localObject);
          localObject = this.mContext;
          paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.ahE(), "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "clickAvatar", "(Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject).startActivity((Intent)paramView.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "clickAvatar", "(Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aH(((Activity)this.mContext).getIntent())), Integer.valueOf(16), Integer.valueOf(1), this.pSY.field_username });
        }
      }
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27277);
    if (this.vQX == null) {
      this.vQX = super.onCreateView(paramViewGroup);
    }
    paramViewGroup = this.vQX;
    AppMethodBeat.o(27277);
    return paramViewGroup;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(27276);
    if (this.vQX != null)
    {
      a locala = (a)this.vQX.getTag();
      if (locala.xiV != null) {
        locala.xiV.detach();
      }
    }
    AppMethodBeat.o(27276);
  }
  
  public boolean onLongClick(final View paramView)
  {
    AppMethodBeat.i(27286);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    if (paramView.getId() == 2131298706)
    {
      final TextView localTextView = (TextView)paramView;
      final an localan = this.pSY;
      final ClipboardManager localClipboardManager = (ClipboardManager)ak.getContext().getSystemService("clipboard");
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
        ((com.tencent.mm.ui.widget.b.a)localObject).LwG = new View.OnCreateContextMenuListener()
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(186531);
            paramAnonymousContextMenu.add(NormalProfileHeaderPreference.c(NormalProfileHeaderPreference.this).getString(2131755701));
            AppMethodBeat.o(186531);
          }
        };
        ((com.tencent.mm.ui.widget.b.a)localObject).LfT = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(186532);
            if (paramAnonymousInt == 0)
            {
              localClipboardManager.setText(paramView);
              h.cl(NormalProfileHeaderPreference.c(NormalProfileHeaderPreference.this), NormalProfileHeaderPreference.c(NormalProfileHeaderPreference.this).getString(2131755702));
            }
            AppMethodBeat.o(186532);
          }
        };
        ((com.tencent.mm.ui.widget.b.a)localObject).LhV = new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(186533);
            NormalProfileHeaderPreference.a(NormalProfileHeaderPreference.this, localTextView, localan);
            AppMethodBeat.o(186533);
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
        ((com.tencent.mm.ui.widget.b.a)localObject).el(this.jwh, this.jwi);
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(27286);
    return false;
  }
  
  final class a
  {
    TextView uAJ;
    TextView uRZ;
    private View xiG;
    private View xiH;
    private View xiI;
    private View xiJ;
    private View xiK;
    private View xiL;
    ImageView xiM;
    TextView xiN;
    MMNeat7extView xiO;
    TextView xiP;
    TextView xiQ;
    TextView xiR;
    TextView xiS;
    TextView xiT;
    AvatarPatTipImageView xiU;
    FMessageListView xiV;
    private View xiW;
    private LinearLayout xiX;
    ImageView xiY;
    private ImageView xiZ;
    private ImageView xja;
    View xjb;
    private ImageView xjc;
    View xjd;
    private View xje;
    
    a(View paramView)
    {
      AppMethodBeat.i(27274);
      this.xiG = null;
      this.xiH = null;
      this.xiI = null;
      this.xiJ = null;
      this.xiK = null;
      this.xiL = null;
      this.xiM = null;
      this.uAJ = null;
      this.xiN = null;
      this.xiO = null;
      this.xiP = null;
      this.uRZ = null;
      this.xiQ = null;
      this.xiR = null;
      this.xiS = null;
      this.xiT = null;
      this.xiU = null;
      this.xiX = null;
      this.xjb = paramView.findViewById(2131296322);
      this.xiV = ((FMessageListView)paramView.findViewById(2131298693));
      this.xiW = paramView.findViewById(2131298694);
      this.xiG = paramView.findViewById(2131298691);
      this.xiH = paramView.findViewById(2131298686);
      this.xiI = paramView.findViewById(2131298700);
      this.xiK = paramView.findViewById(2131298687);
      this.xiL = paramView.findViewById(2131298702);
      this.xiJ = paramView.findViewById(2131298708);
      this.xiU = ((AvatarPatTipImageView)paramView.findViewById(2131298688));
      this.xiP = ((TextView)paramView.findViewById(2131298690));
      this.xiO = ((MMNeat7extView)paramView.findViewById(2131298698));
      this.uAJ = ((TextView)paramView.findViewById(2131298697));
      this.xiN = ((TextView)paramView.findViewById(2131298681));
      this.xiM = ((ImageView)paramView.findViewById(2131298703));
      this.uRZ = ((TextView)paramView.findViewById(2131298706));
      this.xiQ = ((TextView)paramView.findViewById(2131298704));
      this.xiR = ((TextView)paramView.findViewById(2131298696));
      this.xiS = ((TextView)paramView.findViewById(2131298692));
      this.xiT = ((TextView)paramView.findViewById(2131298705));
      this.xiY = ((ImageView)paramView.findViewById(2131298685));
      this.xiZ = ((ImageView)paramView.findViewById(2131298683));
      this.xja = ((ImageView)paramView.findViewById(2131298684));
      this.xjc = ((ImageView)paramView.findViewById(2131298590));
      this.xjd = paramView.findViewById(2131298699);
      this.xje = paramView.findViewById(2131298689);
      this.xiX = ((LinearLayout)paramView.findViewById(2131298695));
      this.xjb.findViewById(2131303982).setOnClickListener(NormalProfileHeaderPreference.this);
      this.xjb.findViewById(2131302424).setOnClickListener(NormalProfileHeaderPreference.this);
      this.xiL.setOnClickListener(NormalProfileHeaderPreference.this);
      this.xiJ.setOnClickListener(NormalProfileHeaderPreference.this);
      this.xiU.setOnClickListener(NormalProfileHeaderPreference.this);
      this.xiG.setOnClickListener(NormalProfileHeaderPreference.this);
      this.xiH.setOnClickListener(NormalProfileHeaderPreference.this);
      this.xiI.setOnClickListener(NormalProfileHeaderPreference.this);
      this.xiK.setOnClickListener(NormalProfileHeaderPreference.this);
      this.uRZ.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(27273);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference$ViewHolder$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          NormalProfileHeaderPreference.this.jwh = ((int)paramAnonymousMotionEvent.getRawX());
          NormalProfileHeaderPreference.this.jwi = ((int)paramAnonymousMotionEvent.getRawY());
          paramAnonymousView.setTag(2131306044, new int[] { NormalProfileHeaderPreference.this.jwh, NormalProfileHeaderPreference.this.jwi });
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference$ViewHolder$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(27273);
          return false;
        }
      });
      this.uRZ.setOnLongClickListener(NormalProfileHeaderPreference.this);
      this.xjc.setOnClickListener(NormalProfileHeaderPreference.this);
      AppMethodBeat.o(27274);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference
 * JD-Core Version:    0.7.0.1
 */