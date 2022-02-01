package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.v;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.patmsg.a.c.a;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.plugin.profile.c;
import com.tencent.mm.plugin.repairer.PluginRepairer;
import com.tencent.mm.plugin.sns.c.q;
import com.tencent.mm.plugin.textstatus.a.ac;
import com.tencent.mm.plugin.textstatus.a.g;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.preference.FMessageListView;
import com.tencent.mm.pluginsdk.ui.preference.PhoneNumPreference;
import com.tencent.mm.pluginsdk.ui.preference.a.a;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class NormalProfileHeaderPreference
  extends Preference
  implements View.OnClickListener, View.OnLongClickListener
{
  View KKQ;
  private boolean Ltx = false;
  private com.tencent.mm.plugin.profile.logic.b MTQ;
  private String MYh;
  private boolean MYi;
  private boolean MYj;
  private int MYk;
  private boolean MYl;
  public FinderContact MYm;
  public com.tencent.mm.pluginsdk.ui.preference.a.b MYn;
  View.OnLayoutChangeListener MYo = null;
  String MYp;
  private Context mContext;
  private int mScene;
  public com.tencent.mm.ui.base.preference.f pkD;
  int qjs = 0;
  int qjt = 0;
  private boolean readOnly = false;
  private au xVS;
  
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
  
  public static CharSequence a(Context paramContext, au paramau, int paramInt, String paramString, boolean paramBoolean)
  {
    String str = null;
    AppMethodBeat.i(27283);
    int i = paramInt;
    if (paramInt == 9) {
      i = paramau.getSource();
    }
    switch (i)
    {
    default: 
      AppMethodBeat.o(27283);
      return null;
    case 4: 
    case 12: 
      paramContext = paramContext.getResources().getString(R.l.gIc);
      AppMethodBeat.o(27283);
      return paramContext;
    case 1: 
      if ((paramBoolean) || (paramau.aSX() > 1000000))
      {
        paramContext = paramContext.getResources().getString(R.l.gCL);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.d.rs(paramau.field_type))
      {
        paramContext = paramContext.getResources().getString(R.l.gCK);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(R.l.gCM);
      AppMethodBeat.o(27283);
      return paramContext;
    case 3: 
      if ((paramBoolean) || (paramau.aSX() > 1000000))
      {
        paramContext = paramContext.getResources().getString(R.l.gCO);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.d.rs(paramau.field_type))
      {
        paramContext = paramContext.getResources().getString(R.l.gCN);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(R.l.gCP);
      AppMethodBeat.o(27283);
      return paramContext;
    case 17: 
      str = lc(((Activity)paramContext).getIntent().getStringExtra("share_card_username"), ((Activity)paramContext).getIntent().getStringExtra("share_card_nickname"));
      paramString = str;
      if (Util.isNullOrNil(str)) {
        paramString = lc(((Activity)paramContext).getIntent().getStringExtra("source_from_user_name"), ((Activity)paramContext).getIntent().getStringExtra("source_from_nick_name"));
      }
      if ((paramBoolean) || (paramau.aSX() > 1000000))
      {
        if (Util.isNullOrNil(paramString)) {}
        for (paramContext = paramContext.getString(R.l.gCq);; paramContext = p.b(paramContext, paramContext.getString(R.l.gCp, new Object[] { paramString })))
        {
          AppMethodBeat.o(27283);
          return paramContext;
        }
      }
      if (com.tencent.mm.contact.d.rs(paramau.field_type))
      {
        if (Util.isNullOrNil(paramString)) {}
        for (paramContext = paramContext.getString(R.l.gCn);; paramContext = p.b(paramContext, paramContext.getString(R.l.gCo, new Object[] { paramString })))
        {
          AppMethodBeat.o(27283);
          return paramContext;
        }
      }
      if (!Util.isNullOrNil(paramString))
      {
        paramContext = paramContext.getString(R.l.gCr, new Object[] { paramString });
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = p.b(paramContext, paramContext.getString(R.l.gCs));
      AppMethodBeat.o(27283);
      return paramContext;
    case 18: 
      if ((paramBoolean) || (paramau.aSX() > 1000000))
      {
        paramContext = paramContext.getResources().getString(R.l.gCA);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.d.rs(paramau.field_type))
      {
        paramContext = paramContext.getResources().getString(R.l.gCz);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(R.l.gCB);
      AppMethodBeat.o(27283);
      return paramContext;
    case 30: 
      if ((paramBoolean) || (paramau.aSX() > 1000000))
      {
        paramContext = paramContext.getResources().getString(R.l.gCE);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.d.rs(paramau.field_type))
      {
        paramContext = paramContext.getResources().getString(R.l.gCD);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(R.l.gCF);
      AppMethodBeat.o(27283);
      return paramContext;
    case 48: 
      paramContext = paramContext.getResources().getString(R.l.gCG);
      AppMethodBeat.o(27283);
      return paramContext;
    case 8: 
    case 14: 
    case 96: 
      paramString = com.tencent.mm.modelverify.d.bNH().aLv(paramString).field_chatroomName;
      if (Util.isNullOrNil(paramString)) {
        paramString = paramau.field_sourceExtInfo;
      }
      break;
    }
    for (;;)
    {
      au localau = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramString);
      paramString = str;
      if (localau != null)
      {
        if (Util.isNullOrNil(localau.field_username)) {
          paramString = str;
        }
      }
      else
      {
        if ((!paramBoolean) && (paramau.aSX() <= 1000000)) {
          break label1035;
        }
        if (Util.isNullOrNil(paramString)) {
          break label1024;
        }
      }
      label1024:
      for (paramContext = paramContext.getString(R.l.gCw, new Object[] { paramString });; paramContext = paramContext.getString(R.l.gCu))
      {
        AppMethodBeat.o(27283);
        return paramContext;
        if (Util.isNullOrNil(localau.field_nickname))
        {
          paramString = v.Ie(localau.field_username);
          break;
        }
        paramString = localau.field_nickname;
        break;
      }
      label1035:
      if (com.tencent.mm.contact.d.rs(paramau.field_type))
      {
        paramContext = paramContext.getResources().getString(R.l.gCv, new Object[] { paramString });
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(R.l.gCt);
      AppMethodBeat.o(27283);
      return paramContext;
      if ((paramBoolean) || (paramau.aSX() > 1000000))
      {
        paramContext = paramContext.getResources().getString(R.l.gCR);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.d.rs(paramau.field_type))
      {
        paramContext = paramContext.getResources().getString(R.l.gCQ);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(R.l.gCS);
      AppMethodBeat.o(27283);
      return paramContext;
      paramContext = paramContext.getResources().getString(R.l.gCj);
      AppMethodBeat.o(27283);
      return paramContext;
      paramContext = paramContext.getResources().getString(R.l.gcontact_from_source);
      AppMethodBeat.o(27283);
      return paramContext;
      paramContext = paramContext.getResources().getString(R.l.gCC);
      AppMethodBeat.o(27283);
      return paramContext;
      if ((paramBoolean) || (paramau.aSX() > 1000000))
      {
        paramContext = paramContext.getResources().getString(R.l.gCU);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.d.rs(paramau.field_type))
      {
        paramContext = paramContext.getResources().getString(R.l.gCT);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(R.l.gCV);
      AppMethodBeat.o(27283);
      return paramContext;
      paramContext = paramContext.getResources().getString(R.l.gCy);
      AppMethodBeat.o(27283);
      return paramContext;
      if ((paramBoolean) || (paramau.aSX() > 1000000))
      {
        paramContext = paramContext.getResources().getString(R.l.gCl);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.d.rs(paramau.field_type))
      {
        paramContext = paramContext.getResources().getString(R.l.gCk);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(R.l.gCm);
      AppMethodBeat.o(27283);
      return paramContext;
      if ((paramBoolean) || (paramau.aSX() > 1000000))
      {
        paramContext = paramContext.getResources().getString(R.l.gCI);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.d.rs(paramau.field_type))
      {
        paramContext = paramContext.getResources().getString(R.l.gCH);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(R.l.gCJ);
      AppMethodBeat.o(27283);
      return paramContext;
      paramContext = paramContext.getResources().getString(R.l.gId);
      AppMethodBeat.o(27283);
      return paramContext;
      paramContext = paramContext.getResources().getString(R.l.gCx);
      AppMethodBeat.o(27283);
      return paramContext;
    }
  }
  
  private void a(NormalProfileHeaderPreference.a parama, Context paramContext, au paramau, int paramInt, com.tencent.mm.pluginsdk.ui.preference.b[] paramArrayOfb)
  {
    int i = 0;
    AppMethodBeat.i(27281);
    if ((paramArrayOfb == null) || (com.tencent.mm.contact.d.rs(paramau.field_type)))
    {
      parama.MYI.setVisibility(8);
      AppMethodBeat.o(27281);
      return;
    }
    parama.MYI.setGotoSayHiCallBack(this.MYn);
    parama.MYI.setVisibility(0);
    paramContext = Util.nullAsNil(((Activity)paramContext).getIntent().getStringExtra("Verify_ticket"));
    a.a locala = new a.a();
    locala.talker = paramau.field_username;
    locala.scene = paramInt;
    locala.pPi = paramContext;
    locala.Ymm = paramau.kas;
    locala.type = 0;
    if (paramInt == 18) {
      locala.type = 1;
    }
    for (;;)
    {
      parama.MYI.setFMessageArgs(locala);
      int j = paramArrayOfb.length;
      paramInt = i;
      while (paramInt < j)
      {
        paramContext = paramArrayOfb[paramInt];
        parama.MYI.a(paramContext);
        paramInt += 1;
      }
      if (br.vj(paramInt)) {
        locala.type = 2;
      }
    }
    AppMethodBeat.o(27281);
  }
  
  private String an(au paramau)
  {
    AppMethodBeat.i(27280);
    Resources localResources;
    int i;
    if (gAG())
    {
      localResources = this.mContext.getResources();
      i = R.l.gvM;
      if (Util.isNullOrNil(paramau.getCity())) {
        paramau = aa.IF(paramau.getProvince());
      }
    }
    for (paramau = localResources.getString(i, new Object[] { paramau }).trim();; paramau = paramau.aSV())
    {
      paramau = Util.nullAs(paramau, "");
      AppMethodBeat.o(27280);
      return paramau;
      paramau = paramau.getCity();
      break;
    }
  }
  
  private void b(String paramString, au paramau)
  {
    AppMethodBeat.i(27287);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.NormalProfileHeaderPreference", "view stranger remark, username is null");
      AppMethodBeat.o(27287);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("Contact_Scene", this.mScene);
    paramString.putExtra("Contact_mode_name_type", 0);
    paramString.putExtra("Contact_ModStrangerRemark", true);
    paramString.putExtra("Contact_User", paramau.field_username);
    paramString.putExtra("Contact_Nick", paramau.field_nickname);
    paramString.putExtra("Contact_RemarkName", paramau.field_conRemark);
    com.tencent.mm.plugin.profile.b.pFn.l(paramString, this.mContext);
    AppMethodBeat.o(27287);
  }
  
  private boolean gAG()
  {
    AppMethodBeat.i(27279);
    boolean bool = au.bwS(this.xVS.field_username);
    AppMethodBeat.o(27279);
    return bool;
  }
  
  private static String lc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(27284);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(27284);
      return null;
    }
    String str = aa.IE(paramString1);
    if (!Util.isNullOrNil(str)) {}
    for (;;)
    {
      AppMethodBeat.o(27284);
      return str;
      str = paramString2;
      if (Util.isNullOrNil(paramString2)) {
        str = aa.getDisplayName(paramString1);
      }
    }
  }
  
  public final void a(au paramau, int paramInt, boolean paramBoolean, com.tencent.mm.plugin.profile.logic.b paramb)
  {
    AppMethodBeat.i(27275);
    this.MYh = ((Activity)this.mContext).getIntent().getStringExtra("Contact_RoomNickname");
    this.xVS = paramau;
    this.mScene = paramInt;
    this.readOnly = paramBoolean;
    this.Ltx = true;
    this.MTQ = paramb;
    AppMethodBeat.o(27275);
  }
  
  public final void b(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(305534);
    int i = bf.fs(this.mContext);
    this.MYi = paramBoolean1;
    this.MYj = paramBoolean2;
    this.MYk = paramInt;
    this.MYl = ac.hFS();
    if (paramInt <= 0) {
      this.MYk = i;
    }
    if (this.pkD != null) {
      this.pkD.notifyDataSetChanged();
    }
    Log.i("MicroMsg.NormalProfileHeaderPreference", "setHasStory action=%s weuiActionBarHeight=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(305534);
  }
  
  public final g gBi()
  {
    AppMethodBeat.i(305549);
    if (this.KKQ != null)
    {
      g localg = ((NormalProfileHeaderPreference.a)this.KKQ.getTag()).MYL;
      AppMethodBeat.o(305549);
      return localg;
    }
    AppMethodBeat.o(305549);
    return null;
  }
  
  public final View getRootView()
  {
    AppMethodBeat.i(305545);
    if (this.KKQ != null)
    {
      View localView = ((NormalProfileHeaderPreference.a)this.KKQ.getTag()).plc;
      AppMethodBeat.o(305545);
      return localView;
    }
    AppMethodBeat.o(305545);
    return null;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27278);
    super.onBindView(paramView);
    if (!this.Ltx)
    {
      Log.w("MicroMsg.NormalProfileHeaderPreference", "[onBindView] never attach!");
      AppMethodBeat.o(27278);
      return;
    }
    if (paramView.getTag() == null) {
      paramView.setTag(new NormalProfileHeaderPreference.a(this, paramView));
    }
    NormalProfileHeaderPreference.a locala = (NormalProfileHeaderPreference.a)paramView.getTag();
    com.tencent.mm.pluginsdk.ui.a.b.g(locala.MYH, this.xVS.field_username);
    float f1;
    int n;
    int i1;
    int k;
    label262:
    boolean bool2;
    boolean bool3;
    int m;
    if (((com.tencent.mm.plugin.patmsg.a.b)h.ax(com.tencent.mm.plugin.patmsg.a.b.class)).kM(this.xVS.field_username, this.xVS.field_username))
    {
      if (com.tencent.mm.contact.d.rs(this.xVS.field_type))
      {
        locala.MYH.setTagUsername(this.xVS.field_username);
        locala.MYH.setTagTalker(this.xVS.field_username);
        locala.MYH.setTagScene(5);
      }
    }
    else if (!Util.isNullOrNil(an(this.xVS)))
    {
      locala.MYB.setVisibility(0);
      f1 = locala.MYB.getTextSize();
      paramView = an(this.xVS);
      n = (int)this.mContext.getResources().getDimension(R.f.Edge_8A);
      i1 = (int)this.mContext.getResources().getDimension(R.f.Edge_2A);
      if (this.xVS.sex == 0) {
        break label1733;
      }
      k = this.mContext.getResources().getDrawable(R.k.ic_sex_male).getIntrinsicWidth();
      boolean bool1 = this.xVS.aSL();
      bool2 = q.Qkl.aRZ(this.xVS.field_username);
      bool3 = this.xVS.aSK();
      m = (int)this.mContext.getResources().getDimension(R.f.Edge_0_5_A);
      if (!bool1) {
        break label2576;
      }
    }
    label775:
    label1290:
    label2576:
    for (int j = this.mContext.getResources().getDrawable(R.k.circle_notreceive).getIntrinsicWidth() + m + m;; j = m)
    {
      int i = j;
      if (bool3) {
        i = j + this.mContext.getResources().getDrawable(R.k.profile_star_icon).getIntrinsicWidth() + m;
      }
      j = i;
      if (bool2) {
        j = i + this.mContext.getResources().getDrawable(R.k.circle_notvisible).getIntrinsicWidth() + m;
      }
      i = this.mContext.getResources().getDisplayMetrics().widthPixels - n - i1 * 3 - k - j;
      Log.i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] calculateRemarkNameTvSize:%s", new Object[] { Integer.valueOf(i) });
      locala.MYB.setMaxWidth(i);
      locala.MYB.aZ(p.b(this.mContext, paramView, f1));
      locala.MYB.setContentDescription(p.b(this.mContext, paramView, f1));
      if (locala.MYB.pE(i, 2147483647).jQH() > 1)
      {
        f1 = com.tencent.mm.cd.a.getScaleSize(this.mContext);
        float f2 = com.tencent.mm.cd.a.K(this.mContext, (int)locala.MYB.getResources().getDimension(R.f.SuperTextSize));
        locala.MYB.setTextSize(f1 * f2);
        locala.MYB.aZ(p.b(this.mContext, paramView, locala.MYB.getTextSize()));
      }
      label635:
      Object localObject2;
      label738:
      Object localObject3;
      if ((this.MYi) || (this.MYj))
      {
        locala.MYB.setTextColor(this.mContext.getResources().getColor(R.e.white_text_color));
        locala.MYB.setMaxLines(1);
        locala.MYB.getPaint().setFakeBoldText(true);
        localObject1 = ((Activity)this.mContext).getIntent().getStringExtra("Contact_Distance");
        if ((!((Activity)this.mContext).getIntent().getBooleanExtra("Contact_IsLBSFriend", false)) || (Util.isNullOrNil((String)localObject1))) {
          break label1774;
        }
        locala.MYF.setText(this.mContext.getString(R.l.gBm) + (String)localObject1);
        locala.MYF.setVisibility(0);
        if (!au.bwO(this.xVS.field_username)) {
          break label1787;
        }
        locala.MYA.setVisibility(0);
        locala.MYA.setText(com.tencent.mm.openim.room.a.a.X(this.xVS));
        if ((!Util.isNullOrNil(this.xVS.field_nickname)) && (!Util.isNullOrNil(this.xVS.field_conRemark)) && (!gAG())) {
          break label1905;
        }
        locala.yEQ.setVisibility(8);
        label818:
        if (Util.isNullOrNil(this.MYh)) {
          break label1981;
        }
        if (((Activity)this.mContext).getIntent().getIntExtra("Contact_Scene", -1) != 14) {
          break label1975;
        }
        i = 1;
        label853:
        if (i == 0) {
          break label1981;
        }
        locala.MYC.setVisibility(0);
        paramView = this.mContext.getString(R.l.gBf) + this.MYh;
        locala.MYC.setText(p.b(this.mContext, paramView, locala.yEQ.getTextSize()));
        label922:
        if (((Util.isNullOrNil(this.xVS.aJs())) && (Util.isNullOrNil(this.xVS.field_username))) || (!com.tencent.mm.contact.d.rs(this.xVS.field_type)) || (au.bwO(this.xVS.field_username)) || (gAG()) || (au.bwQ(this.xVS.field_username))) {
          break label2005;
        }
        locala.JBA.setVisibility(0);
        localObject2 = locala.JBA;
        localObject3 = new StringBuilder().append(c.bG(this.mContext, this.xVS.field_username));
        String str = this.xVS.field_username;
        if (!Util.isNullOrNil(this.xVS.aJs())) {
          break label1994;
        }
        paramView = this.xVS.field_username;
        label1066:
        ((TextView)localObject2).setText(c.la(str, paramView));
        label1085:
        if (this.xVS.field_deleteFlag != 1) {
          break label2018;
        }
        locala.MYG.setVisibility(0);
        locala.MYG.setText(this.mContext.getText(R.l.gAE));
        locala.yEQ.setVisibility(8);
        locala.MYD.setVisibility(8);
        i = 1;
        label1146:
        if (i != 0) {
          Log.i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] has delete account! username:%s", new Object[] { this.xVS.field_username });
        }
        if ((com.tencent.mm.contact.d.rs(this.xVS.field_type)) || (gAG()) || (au.bws(this.xVS.field_username))) {
          break label2044;
        }
        Log.i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] accept contact! username:%s", new Object[] { this.xVS.field_username });
        locala.MYQ.setVisibility(8);
        label1240:
        if ((com.tencent.mm.contact.d.rs(this.xVS.field_type)) || (!((Activity)this.mContext).getIntent().getBooleanExtra("User_Verify", false))) {
          break label2065;
        }
        i = 1;
        label1276:
        if (i == 0) {
          break label2071;
        }
        locala.MYQ.setVisibility(0);
        a(locala, this.mContext, this.xVS, this.mScene, r.a(this.mContext, this.xVS, this.mScene));
        if (!Util.isNullOrNil(this.xVS.signature))
        {
          if (!au.bwO(this.xVS.field_username)) {
            break label2084;
          }
          h.baF();
          if ((((PluginOpenIM)h.az(PluginOpenIM.class)).getSnsFlagStg().RV(this.xVS.field_username) & 0x2) != 0L) {
            break label2084;
          }
        }
        locala.MYD.setVisibility(8);
        label1394:
        if (!Util.isNullOrNil(this.xVS.getProvince())) {
          break label2119;
        }
        locala.MYE.setVisibility(8);
        paramView = locala.MYz;
        localObject2 = this.xVS;
        paramView.setVisibility(0);
        if (((az)localObject2).sex != 1) {
          break label2242;
        }
        paramView.setImageDrawable(com.tencent.mm.cd.a.m(this.mContext, R.k.ic_sex_male));
        localObject2 = com.tencent.mm.ui.component.k.aeZF;
        ((a)com.tencent.mm.ui.component.k.nq(paramView.getContext()).q(a.class)).setValue("contact_profile_sex_icon", this.mContext.getString(R.l.profile_sex_male_desc));
        label1494:
        localObject3 = this.xVS;
        paramView = locala.MYL;
        localObject2 = locala.MYR;
        if ((localObject3 != null) && (paramView != null)) {
          break label2322;
        }
        label1522:
        i = ((Activity)this.mContext).getIntent().getIntExtra("Contact_Scene", 0);
        if ((26 > i) || (i > 29)) {
          break label2381;
        }
        i = 1;
        label1558:
        if (i != 0)
        {
          locala.MYF.setVisibility(0);
          locala.yEQ.setVisibility(8);
          locala.MYF.setText(this.mContext.getString(R.l.gBm) + (String)localObject1);
        }
        if (!au.bws(this.xVS.field_username))
        {
          paramView = locala.MYN;
          if ((!this.xVS.aSK()) || (!com.tencent.mm.contact.d.rs(this.xVS.field_type))) {
            break label2387;
          }
        }
      }
      label1733:
      label1994:
      label2381:
      label2387:
      for (i = 0;; i = 8)
      {
        paramView.setVisibility(i);
        locala.MYS.getViewTreeObserver().addOnPreDrawListener(new NormalProfileHeaderPreference.2(this, locala));
        if (this.MYm != null) {
          break label2394;
        }
        locala.MYU.setVisibility(8);
        AppMethodBeat.o(27278);
        return;
        locala.MYH.setOnDoubleClickListener(new c.a()
        {
          public final boolean iA(View paramAnonymousView)
          {
            AppMethodBeat.i(305467);
            ((PluginPatMsg)h.az(PluginPatMsg.class)).playPatAnimation(paramAnonymousView);
            AppMethodBeat.o(305467);
            return true;
          }
        });
        break;
        k = 0;
        break label262;
        locala.MYB.setTextColor(this.mContext.getResources().getColor(R.e.FG_0));
        locala.MYB.setMaxLines(2147483647);
        break label635;
        label1774:
        locala.MYF.setVisibility(8);
        break label738;
        label1787:
        if (!au.bwQ(this.xVS.field_username)) {
          break label775;
        }
        paramView = com.tencent.mm.openim.room.a.a.Y(this.xVS);
        if (!Util.isNullOrNil(paramView))
        {
          locala.MYA.setVisibility(0);
          locala.MYA.setText(paramView);
        }
        for (;;)
        {
          locala.MYS.setBackgroundResource(R.e.BG_2);
          locala.MYK.setPadding(locala.MYK.getPaddingLeft(), locala.MYK.getPaddingTop(), locala.MYK.getPaddingRight(), this.mContext.getResources().getDimensionPixelSize(R.f.Edge_6A));
          break;
          locala.MYA.setVisibility(8);
        }
        label1905:
        locala.yEQ.setVisibility(0);
        paramView = this.mContext.getString(R.l.gBH) + this.xVS.field_nickname;
        locala.yEQ.setText(p.b(this.mContext, paramView, locala.yEQ.getTextSize()));
        break label818;
        i = 0;
        break label853;
        locala.MYC.setVisibility(8);
        break label922;
        paramView = this.xVS.aJs();
        break label1066;
        label2005:
        locala.JBA.setVisibility(8);
        break label1085;
        label2018:
        locala.MYG.setVisibility(8);
        locala.MYD.setVisibility(8);
        i = 0;
        break label1146;
        label2044:
        if (locala.MYQ == null) {
          break label1240;
        }
        locala.MYQ.setVisibility(8);
        break label1240;
        i = 0;
        break label1276;
        locala.MYQ.setVisibility(8);
        break label1290;
        locala.MYD.setText(p.b(this.mContext, this.xVS.signature));
        locala.MYD.setVisibility(8);
        break label1394;
        locala.MYE.setVisibility(0);
        localObject2 = new StringBuilder().append(aa.IF(this.xVS.getProvince()));
        if (Util.isNullOrNil(this.xVS.getCity())) {}
        for (paramView = "";; paramView = "  " + this.xVS.getCity())
        {
          paramView = paramView;
          locala.MYE.setText(this.mContext.getString(R.l.gBv) + paramView);
          break;
        }
        if (((az)localObject2).sex == 2)
        {
          paramView.setImageDrawable(com.tencent.mm.cd.a.m(this.mContext, R.k.ic_sex_female));
          localObject2 = com.tencent.mm.ui.component.k.aeZF;
          ((a)com.tencent.mm.ui.component.k.nq(paramView.getContext()).q(a.class)).setValue("contact_profile_sex_icon", this.mContext.getString(R.l.profile_sex_female_desc));
          break label1494;
        }
        if (((az)localObject2).sex != 0) {
          break label1494;
        }
        paramView.setVisibility(8);
        break label1494;
        localObject3 = ((az)localObject3).field_username;
        if (!TextUtils.equals(this.MYp, (CharSequence)localObject3))
        {
          paramView.Ds((String)localObject3);
          this.MYp = ((String)localObject3);
        }
        if (this.MYj)
        {
          ((View)localObject2).setVisibility(8);
          break label1522;
        }
        ((View)localObject2).setVisibility(0);
        break label1522;
        i = 0;
        break label1558;
      }
      label1975:
      label1981:
      label2119:
      label2394:
      Object localObject1 = this.MYm.authInfo;
      label2065:
      label2071:
      label2084:
      label2242:
      if (localObject1 != null)
      {
        paramView = (View)localObject1;
        if (((FinderAuthInfo)localObject1).authIconType > 0) {}
      }
      else
      {
        paramView = com.tencent.mm.plugin.finder.storage.d.FAy;
        paramView = (View)localObject1;
        if (((Boolean)com.tencent.mm.plugin.finder.storage.d.eWP().bmg()).booleanValue())
        {
          paramView = new FinderAuthInfo();
          paramView.authIconType = 1;
          paramView.authIconUrl = "https://dldir1.qq.com/weixin/checkresupdate/auth_icon_level3_2e2f94615c1e4651a25a7e0446f63135.png";
          paramView.authProfession = "摄影博主";
        }
      }
      label2322:
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if ((((Integer)com.tencent.mm.plugin.finder.storage.d.eWT().bmg()).intValue() == 0) || (paramView == null) || (paramView.authIconType <= 0))
      {
        locala.MYU.setVisibility(8);
        AppMethodBeat.o(27278);
        return;
      }
      locala.MYU.setVisibility(0);
      localObject1 = av.GiL;
      av.a(locala.MYV, paramView, 1, null);
      locala.MYW.setText(paramView.authProfession);
      locala.MYU.setOnClickListener(new NormalProfileHeaderPreference.6(this));
      AppMethodBeat.o(27278);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(27285);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    int i = paramView.getId();
    if (i == R.h.remark_name)
    {
      paramView = this.xVS;
      if (paramView == null) {
        Log.e("MicroMsg.NormalProfileHeaderPreference", "contact is null");
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(27285);
      return;
      if (!com.tencent.mm.contact.d.rs(paramView.field_type))
      {
        if (!Util.isNullOrNil(paramView.field_encryptUsername)) {
          b(paramView.field_encryptUsername, paramView);
        } else {
          b(paramView.field_username, paramView);
        }
      }
      else
      {
        localObject = (PhoneNumPreference)this.pkD.bAi("contact_profile_phone");
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_Scene", this.mScene);
        localIntent.putExtra("Contact_User", paramView.field_username);
        localIntent.putExtra("view_mode", true);
        localIntent.putExtra("contact_phone_number_by_md5", ((PhoneNumPreference)localObject).XZt);
        localIntent.putExtra("contact_phone_number_list", paramView.kar);
        com.tencent.mm.plugin.profile.b.pFn.k(localIntent, this.mContext);
        continue;
        if (i == R.h.mod_sns_permission)
        {
          if (this.MTQ != null) {
            this.MTQ.gAX();
          }
        }
        else if (i == R.h.contact_profile_avatar_iv)
        {
          localObject = this.xVS.field_username;
          paramView = new Intent(this.mContext, ProfileHdHeadImg.class);
          paramView.putExtra("username", (String)localObject);
          localObject = this.mContext;
          paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
          com.tencent.mm.hellhoundlib.a.a.b(localObject, paramView.aYi(), "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "clickAvatar", "(Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject).startActivity((Intent)paramView.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "clickAvatar", "(Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.profile.d.b(((Activity)this.mContext).getIntent(), 16, 1, this.xVS.field_username);
        }
      }
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27277);
    if (this.KKQ == null) {
      this.KKQ = super.onCreateView(paramViewGroup);
    }
    paramViewGroup = this.KKQ;
    AppMethodBeat.o(27277);
    return paramViewGroup;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(27276);
    if (this.KKQ != null)
    {
      NormalProfileHeaderPreference.a locala = (NormalProfileHeaderPreference.a)this.KKQ.getTag();
      if (locala.MYI != null) {
        locala.MYI.detach();
      }
    }
    if (gBi() != null) {
      gBi().wk(0L);
    }
    AppMethodBeat.o(27276);
  }
  
  public boolean onLongClick(final View paramView)
  {
    AppMethodBeat.i(27286);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    int i = paramView.getId();
    if (i == R.h.contact_profile_username_tv)
    {
      final TextView localTextView = (TextView)paramView;
      final au localau = this.xVS;
      if (localTextView.getText() != null)
      {
        localObject = localTextView.getText().toString();
        i = ((String)localObject).indexOf(':');
        paramView = (View)localObject;
        if (i >= 0)
        {
          paramView = (View)localObject;
          if (i < ((String)localObject).length()) {
            paramView = ((String)localObject).substring(i + 1).trim();
          }
        }
        localObject = new SpannableString(localTextView.getText());
        ((SpannableString)localObject).setSpan(new BackgroundColorSpan(this.mContext.getResources().getColor(R.e.FG_3)), i + 2, localTextView.getText().length(), 33);
        localTextView.setText((CharSequence)localObject);
        localObject = new com.tencent.mm.ui.widget.b.a(this.mContext, localTextView);
        ((com.tencent.mm.ui.widget.b.a)localObject).agjt = new View.OnCreateContextMenuListener()
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(305461);
            paramAnonymousContextMenu.add(NormalProfileHeaderPreference.e(NormalProfileHeaderPreference.this).getString(R.l.app_copy));
            AppMethodBeat.o(305461);
          }
        };
        ((com.tencent.mm.ui.widget.b.a)localObject).GAC = new u.i()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(305466);
            if (paramAnonymousInt == 0)
            {
              ClipboardHelper.setText(paramView);
              com.tencent.mm.ui.base.k.cY(NormalProfileHeaderPreference.e(NormalProfileHeaderPreference.this), NormalProfileHeaderPreference.e(NormalProfileHeaderPreference.this).getString(R.l.app_copy_ok));
            }
            AppMethodBeat.o(305466);
          }
        };
        ((com.tencent.mm.ui.widget.b.a)localObject).afLp = new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(305463);
            NormalProfileHeaderPreference.a(NormalProfileHeaderPreference.this, localTextView, localau);
            AppMethodBeat.o(305463);
          }
        };
        if (!(localTextView.getTag(R.h.touch_loc) instanceof int[])) {
          break label291;
        }
        paramView = (int[])localTextView.getTag(R.h.touch_loc);
        ((com.tencent.mm.ui.widget.b.a)localObject).fQ(paramView[0], paramView[1]);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(27286);
        return true;
        label291:
        ((com.tencent.mm.ui.widget.b.a)localObject).fQ(this.qjs, this.qjt);
      }
    }
    if (i == R.h.contact_profile_remark_tv)
    {
      paramView = Util.secPrint(this.xVS.field_username) + "-" + com.tencent.mm.pluginsdk.platformtools.f.formatTime("yyyy-MM-dd_HH:mm:ss", cn.getSyncServerTimeSecond()) + ".txt";
      ((PluginRepairer)h.az(PluginRepairer.class)).sendContactInfo(paramView, this.xVS);
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(27286);
      return true;
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(27286);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference
 * JD-Core Version:    0.7.0.1
 */