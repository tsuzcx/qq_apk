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
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.patmsg.a.c.a;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.plugin.profile.c;
import com.tencent.mm.plugin.repairer.PluginRepairer;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.t;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.preference.FMessageListView;
import com.tencent.mm.pluginsdk.ui.preference.PhoneNumPreference;
import com.tencent.mm.pluginsdk.ui.preference.a.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;

public class NormalProfileHeaderPreference
  extends Preference
  implements View.OnClickListener, View.OnLongClickListener
{
  View EQs;
  private boolean Fxn = false;
  private com.tencent.mm.plugin.profile.a.b GWl;
  private String Hac;
  private boolean Had;
  private boolean Hae;
  private int Haf;
  private boolean Hag;
  public FinderContact Hah;
  String Hai;
  private Context mContext;
  private int mScene;
  public com.tencent.mm.ui.base.preference.f mrf;
  int nmj = 0;
  int nmk = 0;
  private boolean readOnly = false;
  private as uNk;
  
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
  
  public static CharSequence a(Context paramContext, as paramas, int paramInt, String paramString, boolean paramBoolean)
  {
    String str = null;
    AppMethodBeat.i(27283);
    int i = paramInt;
    if (paramInt == 9) {
      i = paramas.getSource();
    }
    switch (i)
    {
    default: 
      AppMethodBeat.o(27283);
      return null;
    case 4: 
    case 12: 
      paramContext = paramContext.getResources().getString(R.l.eFi);
      AppMethodBeat.o(27283);
      return paramContext;
    case 1: 
      if ((paramBoolean) || (paramas.ayu() > 1000000))
      {
        paramContext = paramContext.getResources().getString(R.l.ezU);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.d.rk(paramas.field_type))
      {
        paramContext = paramContext.getResources().getString(R.l.ezT);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(R.l.ezV);
      AppMethodBeat.o(27283);
      return paramContext;
    case 3: 
      if ((paramBoolean) || (paramas.ayu() > 1000000))
      {
        paramContext = paramContext.getResources().getString(R.l.ezX);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.d.rk(paramas.field_type))
      {
        paramContext = paramContext.getResources().getString(R.l.ezW);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(R.l.ezY);
      AppMethodBeat.o(27283);
      return paramContext;
    case 17: 
      str = jH(((Activity)paramContext).getIntent().getStringExtra("share_card_username"), ((Activity)paramContext).getIntent().getStringExtra("share_card_nickname"));
      paramString = str;
      if (Util.isNullOrNil(str)) {
        paramString = jH(((Activity)paramContext).getIntent().getStringExtra("source_from_user_name"), ((Activity)paramContext).getIntent().getStringExtra("source_from_nick_name"));
      }
      if ((paramBoolean) || (paramas.ayu() > 1000000))
      {
        if (Util.isNullOrNil(paramString)) {}
        for (paramContext = paramContext.getString(R.l.ezB);; paramContext = l.c(paramContext, paramContext.getString(R.l.ezA, new Object[] { paramString })))
        {
          AppMethodBeat.o(27283);
          return paramContext;
        }
      }
      if (com.tencent.mm.contact.d.rk(paramas.field_type))
      {
        if (Util.isNullOrNil(paramString)) {}
        for (paramContext = paramContext.getString(R.l.ezy);; paramContext = l.c(paramContext, paramContext.getString(R.l.ezz, new Object[] { paramString })))
        {
          AppMethodBeat.o(27283);
          return paramContext;
        }
      }
      if (!Util.isNullOrNil(paramString))
      {
        paramContext = paramContext.getString(R.l.ezC, new Object[] { paramString });
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = l.c(paramContext, paramContext.getString(R.l.ezD));
      AppMethodBeat.o(27283);
      return paramContext;
    case 18: 
      if ((paramBoolean) || (paramas.ayu() > 1000000))
      {
        paramContext = paramContext.getResources().getString(R.l.ezJ);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.d.rk(paramas.field_type))
      {
        paramContext = paramContext.getResources().getString(R.l.ezI);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(R.l.ezK);
      AppMethodBeat.o(27283);
      return paramContext;
    case 30: 
      if ((paramBoolean) || (paramas.ayu() > 1000000))
      {
        paramContext = paramContext.getResources().getString(R.l.ezN);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.d.rk(paramas.field_type))
      {
        paramContext = paramContext.getResources().getString(R.l.ezM);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(R.l.ezO);
      AppMethodBeat.o(27283);
      return paramContext;
    case 48: 
      paramContext = paramContext.getResources().getString(R.l.ezP);
      AppMethodBeat.o(27283);
      return paramContext;
    case 8: 
    case 14: 
    case 96: 
      paramString = com.tencent.mm.bl.d.bqb().aOw(paramString).field_chatroomName;
      if (Util.isNullOrNil(paramString)) {
        paramString = paramas.field_sourceExtInfo;
      }
      break;
    }
    for (;;)
    {
      as localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramString);
      paramString = str;
      if (localas != null)
      {
        if (Util.isNullOrNil(localas.field_username)) {
          paramString = str;
        }
      }
      else
      {
        if ((!paramBoolean) && (paramas.ayu() <= 1000000)) {
          break label1019;
        }
        if (Util.isNullOrNil(paramString)) {
          break label1008;
        }
      }
      label1008:
      for (paramContext = paramContext.getString(R.l.ezH, new Object[] { paramString });; paramContext = paramContext.getString(R.l.ezF))
      {
        AppMethodBeat.o(27283);
        return paramContext;
        if (Util.isNullOrNil(localas.field_nickname))
        {
          paramString = v.Pl(localas.field_username);
          break;
        }
        paramString = localas.field_nickname;
        break;
      }
      label1019:
      if (com.tencent.mm.contact.d.rk(paramas.field_type))
      {
        paramContext = paramContext.getResources().getString(R.l.ezG, new Object[] { paramString });
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(R.l.ezE);
      AppMethodBeat.o(27283);
      return paramContext;
      if ((paramBoolean) || (paramas.ayu() > 1000000))
      {
        paramContext = paramContext.getResources().getString(R.l.eAa);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.d.rk(paramas.field_type))
      {
        paramContext = paramContext.getResources().getString(R.l.ezZ);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(R.l.eAb);
      AppMethodBeat.o(27283);
      return paramContext;
      paramContext = paramContext.getResources().getString(R.l.ezu);
      AppMethodBeat.o(27283);
      return paramContext;
      paramContext = paramContext.getResources().getString(R.l.gcontact_from_source);
      AppMethodBeat.o(27283);
      return paramContext;
      paramContext = paramContext.getResources().getString(R.l.ezL);
      AppMethodBeat.o(27283);
      return paramContext;
      if ((paramBoolean) || (paramas.ayu() > 1000000))
      {
        paramContext = paramContext.getResources().getString(R.l.eAd);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.d.rk(paramas.field_type))
      {
        paramContext = paramContext.getResources().getString(R.l.eAc);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(R.l.eAe);
      AppMethodBeat.o(27283);
      return paramContext;
      if ((paramBoolean) || (paramas.ayu() > 1000000))
      {
        paramContext = paramContext.getResources().getString(R.l.ezw);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.d.rk(paramas.field_type))
      {
        paramContext = paramContext.getResources().getString(R.l.ezv);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(R.l.ezx);
      AppMethodBeat.o(27283);
      return paramContext;
      if ((paramBoolean) || (paramas.ayu() > 1000000))
      {
        paramContext = paramContext.getResources().getString(R.l.ezR);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.d.rk(paramas.field_type))
      {
        paramContext = paramContext.getResources().getString(R.l.ezQ);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(R.l.ezS);
      AppMethodBeat.o(27283);
      return paramContext;
      paramContext = paramContext.getResources().getString(R.l.eFj);
      AppMethodBeat.o(27283);
      return paramContext;
    }
  }
  
  private static void a(a parama, Context paramContext, as paramas, int paramInt, com.tencent.mm.pluginsdk.ui.preference.b[] paramArrayOfb)
  {
    int i = 0;
    AppMethodBeat.i(27281);
    if ((paramArrayOfb == null) || (com.tencent.mm.contact.d.rk(paramas.field_type)))
    {
      parama.HaB.setVisibility(8);
      AppMethodBeat.o(27281);
      return;
    }
    parama.HaB.setVisibility(0);
    paramContext = Util.nullAsNil(((Activity)paramContext).getIntent().getStringExtra("Verify_ticket"));
    a.a locala = new a.a();
    locala.talker = paramas.field_username;
    locala.scene = paramInt;
    locala.BLy = paramContext;
    locala.RpW = paramas.hDx;
    locala.type = 0;
    if (paramInt == 18) {
      locala.type = 1;
    }
    for (;;)
    {
      parama.HaB.setFMessageArgs(locala);
      int j = paramArrayOfb.length;
      paramInt = i;
      while (paramInt < j)
      {
        paramContext = paramArrayOfb[paramInt];
        parama.HaB.a(paramContext);
        paramInt += 1;
      }
      if (bq.uY(paramInt)) {
        locala.type = 2;
      }
    }
    AppMethodBeat.o(27281);
  }
  
  private void a(String paramString, as paramas)
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
    paramString.putExtra("Contact_User", paramas.field_username);
    paramString.putExtra("Contact_Nick", paramas.field_nickname);
    paramString.putExtra("Contact_RemarkName", paramas.field_conRemark);
    com.tencent.mm.plugin.profile.b.mIG.l(paramString, this.mContext);
    AppMethodBeat.o(27287);
  }
  
  private String ah(as paramas)
  {
    AppMethodBeat.i(27280);
    Resources localResources;
    int i;
    if (fpA())
    {
      localResources = this.mContext.getResources();
      i = R.l.etp;
      if (Util.isNullOrNil(paramas.getCity())) {
        paramas = aa.PL(paramas.getProvince());
      }
    }
    for (paramas = localResources.getString(i, new Object[] { paramas }).trim();; paramas = paramas.ays())
    {
      paramas = Util.nullAs(paramas, "");
      AppMethodBeat.o(27280);
      return paramas;
      paramas = paramas.getCity();
      break;
    }
  }
  
  private boolean fpA()
  {
    AppMethodBeat.i(27279);
    boolean bool = as.PY(this.uNk.field_username);
    AppMethodBeat.o(27279);
    return bool;
  }
  
  private static String jH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(27284);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(27284);
      return null;
    }
    String str = aa.PK(paramString1);
    if (!Util.isNullOrNil(str)) {}
    for (;;)
    {
      AppMethodBeat.o(27284);
      return str;
      str = paramString2;
      if (Util.isNullOrNil(paramString2)) {
        str = aa.PJ(paramString1);
      }
    }
  }
  
  public final void a(as paramas, int paramInt, boolean paramBoolean, com.tencent.mm.plugin.profile.a.b paramb)
  {
    AppMethodBeat.i(27275);
    this.Hac = ((Activity)this.mContext).getIntent().getStringExtra("Contact_RoomNickname");
    this.uNk = paramas;
    this.mScene = paramInt;
    this.readOnly = paramBoolean;
    this.Fxn = true;
    this.GWl = paramb;
    AppMethodBeat.o(27275);
  }
  
  public final void b(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(226472);
    int i = com.tencent.mm.ui.ax.ew(this.mContext);
    this.Had = paramBoolean1;
    this.Hae = paramBoolean2;
    this.Haf = paramInt;
    this.Hag = t.gkZ();
    if (paramInt <= 0) {
      this.Haf = i;
    }
    if (this.mrf != null) {
      this.mrf.notifyDataSetChanged();
    }
    Log.i("MicroMsg.NormalProfileHeaderPreference", "setHasStory action=%s weuiActionBarHeight=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(226472);
  }
  
  public final e fpU()
  {
    AppMethodBeat.i(226511);
    if (this.EQs != null)
    {
      e locale = ((a)this.EQs.getTag()).HaE;
      AppMethodBeat.o(226511);
      return locale;
    }
    AppMethodBeat.o(226511);
    return null;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27278);
    super.onBindView(paramView);
    if (!this.Fxn)
    {
      Log.w("MicroMsg.NormalProfileHeaderPreference", "[onBindView] never attach!");
      AppMethodBeat.o(27278);
      return;
    }
    if (paramView.getTag() == null) {
      paramView.setTag(new a(paramView));
    }
    final a locala = (a)paramView.getTag();
    a.b.c(locala.HaA, this.uNk.field_username);
    float f1;
    int n;
    int i1;
    int k;
    label263:
    boolean bool2;
    boolean bool3;
    int m;
    if (((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.patmsg.a.b.class)).M(5, this.uNk.field_username, this.uNk.field_username))
    {
      if (com.tencent.mm.contact.d.rk(this.uNk.field_type))
      {
        locala.HaA.setTagUsername(this.uNk.field_username);
        locala.HaA.setTagTalker(this.uNk.field_username);
        locala.HaA.setTagScene(5);
      }
    }
    else if (!Util.isNullOrNil(ah(this.uNk)))
    {
      locala.Hau.setVisibility(0);
      f1 = locala.Hau.getTextSize();
      paramView = ah(this.uNk);
      n = (int)this.mContext.getResources().getDimension(R.f.Edge_8A);
      i1 = (int)this.mContext.getResources().getDimension(R.f.Edge_2A);
      if (this.uNk.sex == 0) {
        break label1649;
      }
      k = this.mContext.getResources().getDrawable(R.k.ic_sex_male).getIntrinsicWidth();
      boolean bool1 = this.uNk.ayi();
      bool2 = p.JPf.aUR(this.uNk.field_username);
      bool3 = this.uNk.ayh();
      m = (int)this.mContext.getResources().getDimension(R.f.Edge_0_5_A);
      if (!bool1) {
        break label2350;
      }
    }
    label923:
    label1054:
    label1438:
    label1703:
    label2350:
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
      locala.Hau.setMaxWidth(i);
      locala.Hau.aL(l.b(this.mContext, paramView, f1));
      locala.Hau.setContentDescription(l.b(this.mContext, paramView, f1));
      if (locala.Hau.nH(i, 2147483647).ikp() > 1)
      {
        f1 = com.tencent.mm.ci.a.ez(this.mContext);
        float f2 = com.tencent.mm.ci.a.H(this.mContext, (int)locala.Hau.getResources().getDimension(R.f.SuperTextSize));
        locala.Hau.setTextSize(f1 * f2);
        locala.Hau.aL(l.b(this.mContext, paramView, locala.Hau.getTextSize()));
      }
      label636:
      Object localObject2;
      label739:
      Object localObject3;
      if ((this.Had) || (this.Hae))
      {
        locala.Hau.setTextColor(this.mContext.getResources().getColor(R.e.white_text_color));
        locala.Hau.setMaxLines(1);
        locala.Hau.getPaint().setFakeBoldText(true);
        localObject1 = ((Activity)this.mContext).getIntent().getStringExtra("Contact_Distance");
        if ((!((Activity)this.mContext).getIntent().getBooleanExtra("Contact_IsLBSFriend", false)) || (Util.isNullOrNil((String)localObject1))) {
          break label1690;
        }
        locala.Hay.setText(this.mContext.getString(R.l.eyu) + (String)localObject1);
        locala.Hay.setVisibility(0);
        if (as.bvK(this.uNk.field_username))
        {
          locala.Hat.setVisibility(0);
          locala.Hat.setText(com.tencent.mm.openim.room.a.a.V(this.uNk));
        }
        if ((!Util.isNullOrNil(this.uNk.field_nickname)) && (!Util.isNullOrNil(this.uNk.field_conRemark)) && (!fpA())) {
          break label1703;
        }
        locala.vsF.setVisibility(8);
        label819:
        if (Util.isNullOrNil(this.Hac)) {
          break label1779;
        }
        if (((Activity)this.mContext).getIntent().getIntExtra("Contact_Scene", -1) != 14) {
          break label1773;
        }
        i = 1;
        label854:
        if (i == 0) {
          break label1779;
        }
        locala.Hav.setVisibility(0);
        paramView = this.mContext.getString(R.l.eyn) + this.Hac;
        locala.Hav.setText(l.b(this.mContext, paramView, locala.vsF.getTextSize()));
        if (((Util.isNullOrNil(this.uNk.apf())) && (Util.isNullOrNil(this.uNk.field_username))) || (!com.tencent.mm.contact.d.rk(this.uNk.field_type)) || (as.bvK(this.uNk.field_username)) || (fpA())) {
          break label1803;
        }
        locala.DKE.setVisibility(0);
        localObject2 = locala.DKE;
        localObject3 = new StringBuilder().append(c.bE(this.mContext, this.uNk.field_username));
        String str = this.uNk.field_username;
        if (!Util.isNullOrNil(this.uNk.apf())) {
          break label1792;
        }
        paramView = this.uNk.field_username;
        ((TextView)localObject2).setText(c.jG(str, paramView));
        label1073:
        if (this.uNk.field_deleteFlag != 1) {
          break label1816;
        }
        locala.Haz.setVisibility(0);
        locala.Haz.setText(this.mContext.getText(R.l.exP));
        locala.vsF.setVisibility(8);
        locala.Haw.setVisibility(8);
        i = 1;
        label1134:
        if (i != 0) {
          Log.i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] has delete account! username:%s", new Object[] { this.uNk.field_username });
        }
        if ((com.tencent.mm.contact.d.rk(this.uNk.field_type)) || (fpA()) || (ab.QO(this.uNk.field_username))) {
          break label1842;
        }
        Log.i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] accept contact! username:%s", new Object[] { this.uNk.field_username });
        locala.HaJ.setVisibility(8);
        label1228:
        if ((com.tencent.mm.contact.d.rk(this.uNk.field_type)) || (!((Activity)this.mContext).getIntent().getBooleanExtra("User_Verify", false))) {
          break label1863;
        }
        i = 1;
        label1264:
        if (i == 0) {
          break label1869;
        }
        locala.HaJ.setVisibility(0);
        label1278:
        a(locala, this.mContext, this.uNk, this.mScene, q.a(this.mContext, this.uNk, this.mScene));
        if (!Util.isNullOrNil(this.uNk.signature)) {
          break label1882;
        }
        locala.Haw.setVisibility(8);
        label1333:
        if (!Util.isNullOrNil(this.uNk.getProvince())) {
          break label1917;
        }
        locala.Hax.setVisibility(8);
        paramView = locala.Has;
        localObject2 = this.uNk;
        paramView.setVisibility(0);
        if (((com.tencent.mm.f.c.ax)localObject2).sex != 1) {
          break label2040;
        }
        paramView.setImageDrawable(com.tencent.mm.ci.a.m(this.mContext, R.k.ic_sex_male));
        paramView.setContentDescription(this.mContext.getString(R.l.profile_sex_male_desc));
        localObject3 = this.uNk;
        paramView = locala.HaE;
        localObject2 = locala.HaK;
        if ((localObject3 != null) && (paramView != null)) {
          break label2097;
        }
        i = ((Activity)this.mContext).getIntent().getIntExtra("Contact_Scene", 0);
        if ((26 > i) || (i > 29)) {
          break label2156;
        }
        i = 1;
        label1474:
        if (i != 0)
        {
          locala.Hay.setVisibility(0);
          locala.vsF.setVisibility(8);
          locala.Hay.setText(this.mContext.getString(R.l.eyu) + (String)localObject1);
        }
        if (!ab.QO(this.uNk.field_username))
        {
          paramView = locala.HaG;
          if ((!this.uNk.ayh()) || (!com.tencent.mm.contact.d.rk(this.uNk.field_type))) {
            break label2162;
          }
        }
      }
      label1649:
      label2162:
      for (i = 0;; i = 8)
      {
        paramView.setVisibility(i);
        locala.HaL.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            AppMethodBeat.i(202580);
            locala.HaL.getViewTreeObserver().removeOnPreDrawListener(this);
            int[] arrayOfInt = new int[2];
            locala.HaL.getLocationOnScreen(arrayOfInt);
            int k = arrayOfInt[1];
            int m = com.tencent.mm.ui.ax.getStatusBarHeight(NormalProfileHeaderPreference.this.mContext);
            int j = com.tencent.mm.ci.a.aZ(NormalProfileHeaderPreference.this.mContext, R.f.dlD);
            int i;
            if (NormalProfileHeaderPreference.a(NormalProfileHeaderPreference.this))
            {
              i = com.tencent.mm.ci.a.aZ(NormalProfileHeaderPreference.this.mContext, R.f.dlB);
              if ((k != 0) || (NormalProfileHeaderPreference.a(NormalProfileHeaderPreference.this))) {
                break label278;
              }
              j = i + m;
            }
            for (;;)
            {
              Log.i("MicroMsg.NormalProfileHeaderPreference", "actionBarHeight=%s ,statusBarHeight=%s , rootTop:%s, paddingTopToSet:%s,curPaddingTop:%s", new Object[] { Integer.valueOf(NormalProfileHeaderPreference.b(NormalProfileHeaderPreference.this)), Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(locala.HaL.getPaddingTop()) });
              if (j == locala.HaL.getPaddingTop()) {
                break label310;
              }
              locala.HaL.setPadding(locala.HaL.getPaddingLeft(), j, locala.HaL.getPaddingRight(), locala.HaL.getPaddingBottom());
              AppMethodBeat.o(202580);
              return false;
              i = j;
              if (m <= 0) {
                break;
              }
              i = j;
              if (NormalProfileHeaderPreference.b(NormalProfileHeaderPreference.this) <= 0) {
                break;
              }
              i = NormalProfileHeaderPreference.b(NormalProfileHeaderPreference.this) + com.tencent.mm.ci.a.aZ(NormalProfileHeaderPreference.this.mContext, R.f.Edge_2A);
              break;
              label278:
              j = i;
              if (NormalProfileHeaderPreference.c(NormalProfileHeaderPreference.this))
              {
                j = i;
                if (NormalProfileHeaderPreference.d(NormalProfileHeaderPreference.this)) {
                  j = i + m;
                }
              }
            }
            label310:
            AppMethodBeat.o(202580);
            return true;
          }
        });
        if (this.Hah != null) {
          break label2169;
        }
        locala.HaN.setVisibility(8);
        AppMethodBeat.o(27278);
        return;
        locala.HaA.setOnDoubleClickListener(new c.a()
        {
          public final boolean fH(View paramAnonymousView)
          {
            AppMethodBeat.i(276301);
            ((PluginPatMsg)com.tencent.mm.kernel.h.ag(PluginPatMsg.class)).playPatAnimation(paramAnonymousView);
            AppMethodBeat.o(276301);
            return true;
          }
        });
        break;
        k = 0;
        break label263;
        locala.Hau.setTextColor(this.mContext.getResources().getColor(R.e.FG_0));
        locala.Hau.setMaxLines(2147483647);
        break label636;
        locala.Hay.setVisibility(8);
        break label739;
        locala.vsF.setVisibility(0);
        paramView = this.mContext.getString(R.l.eyP) + this.uNk.field_nickname;
        locala.vsF.setText(l.b(this.mContext, paramView, locala.vsF.getTextSize()));
        break label819;
        i = 0;
        break label854;
        label1779:
        locala.Hav.setVisibility(8);
        break label923;
        paramView = this.uNk.apf();
        break label1054;
        locala.DKE.setVisibility(8);
        break label1073;
        locala.Haz.setVisibility(8);
        locala.Haw.setVisibility(8);
        i = 0;
        break label1134;
        if (locala.HaJ == null) {
          break label1228;
        }
        locala.HaJ.setVisibility(8);
        break label1228;
        i = 0;
        break label1264;
        locala.HaJ.setVisibility(8);
        break label1278;
        locala.Haw.setText(l.c(this.mContext, this.uNk.signature));
        locala.Haw.setVisibility(8);
        break label1333;
        label1917:
        locala.Hax.setVisibility(0);
        localObject2 = new StringBuilder().append(aa.PL(this.uNk.getProvince()));
        if (Util.isNullOrNil(this.uNk.getCity())) {}
        for (paramView = "";; paramView = "  " + this.uNk.getCity())
        {
          paramView = paramView;
          locala.Hax.setText(this.mContext.getString(R.l.eyD) + paramView);
          break;
        }
        label2040:
        if (((com.tencent.mm.f.c.ax)localObject2).sex == 2)
        {
          paramView.setImageDrawable(com.tencent.mm.ci.a.m(this.mContext, R.k.ic_sex_female));
          paramView.setContentDescription(this.mContext.getString(R.l.profile_sex_female_desc));
          break label1410;
        }
        if (((com.tencent.mm.f.c.ax)localObject2).sex != 0) {
          break label1410;
        }
        paramView.setVisibility(8);
        break label1410;
        localObject3 = ((com.tencent.mm.f.c.ax)localObject3).field_username;
        if (!TextUtils.equals(this.Hai, (CharSequence)localObject3))
        {
          paramView.KN((String)localObject3);
          this.Hai = ((String)localObject3);
        }
        if (this.Hae)
        {
          ((View)localObject2).setVisibility(8);
          break label1438;
        }
        ((View)localObject2).setVisibility(0);
        break label1438;
        i = 0;
        break label1474;
      }
      label1773:
      label2169:
      Object localObject1 = this.Hah.authInfo;
      label1842:
      label1863:
      label1869:
      label1882:
      label2156:
      if (localObject1 != null)
      {
        paramView = (View)localObject1;
        if (((FinderAuthInfo)localObject1).authIconType > 0) {}
      }
      else
      {
        paramView = com.tencent.mm.plugin.finder.storage.d.AjH;
        paramView = (View)localObject1;
        if (((Boolean)com.tencent.mm.plugin.finder.storage.d.dXU().aSr()).booleanValue())
        {
          paramView = new FinderAuthInfo();
          paramView.authIconType = 1;
          paramView.authIconUrl = "https://dldir1.qq.com/weixin/checkresupdate/auth_icon_level3_2e2f94615c1e4651a25a7e0446f63135.png";
          paramView.authProfession = "摄影博主";
        }
      }
      label2097:
      localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
      if ((((Integer)com.tencent.mm.plugin.finder.storage.d.dXZ().aSr()).intValue() == 0) || (paramView == null) || (paramView.authIconType <= 0))
      {
        locala.HaN.setVisibility(8);
        AppMethodBeat.o(27278);
        return;
      }
      locala.HaN.setVisibility(0);
      localObject1 = aj.AGc;
      aj.a(locala.HaO, paramView, 1);
      locala.HaP.setText(paramView.authProfession);
      locala.HaN.setOnClickListener(new NormalProfileHeaderPreference.6(this));
      AppMethodBeat.o(27278);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(27285);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    int i = paramView.getId();
    if (i == R.h.dSG)
    {
      paramView = this.uNk;
      if (paramView == null) {
        Log.e("MicroMsg.NormalProfileHeaderPreference", "contact is null");
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(27285);
      return;
      if (!com.tencent.mm.contact.d.rk(paramView.field_type))
      {
        if (!Util.isNullOrNil(paramView.field_encryptUsername)) {
          a(paramView.field_encryptUsername, paramView);
        } else {
          a(paramView.field_username, paramView);
        }
      }
      else
      {
        localObject = (PhoneNumPreference)this.mrf.byG("contact_profile_phone");
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_Scene", this.mScene);
        localIntent.putExtra("Contact_User", paramView.field_username);
        localIntent.putExtra("view_mode", true);
        localIntent.putExtra("contact_phone_number_by_md5", ((PhoneNumPreference)localObject).Rdn);
        localIntent.putExtra("contact_phone_number_list", paramView.hDw);
        com.tencent.mm.plugin.profile.b.mIG.k(localIntent, this.mContext);
        continue;
        if (i == R.h.dMI)
        {
          if (this.GWl != null) {
            this.GWl.fpJ();
          }
        }
        else if (i == R.h.dBW)
        {
          localObject = this.uNk.field_username;
          paramView = new Intent(this.mContext, ProfileHdHeadImg.class);
          paramView.putExtra("username", (String)localObject);
          localObject = this.mContext;
          paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
          com.tencent.mm.hellhoundlib.a.a.b(localObject, paramView.aFh(), "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "clickAvatar", "(Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject).startActivity((Intent)paramView.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "clickAvatar", "(Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.profile.d.a(((Activity)this.mContext).getIntent(), 16, 1, this.uNk.field_username);
        }
      }
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27277);
    if (this.EQs == null) {
      this.EQs = super.onCreateView(paramViewGroup);
    }
    paramViewGroup = this.EQs;
    AppMethodBeat.o(27277);
    return paramViewGroup;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(27276);
    if (this.EQs != null)
    {
      a locala = (a)this.EQs.getTag();
      if (locala.HaB != null) {
        locala.HaB.detach();
      }
    }
    AppMethodBeat.o(27276);
  }
  
  public boolean onLongClick(final View paramView)
  {
    AppMethodBeat.i(27286);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    int i = paramView.getId();
    if (i == R.h.dCn)
    {
      final TextView localTextView = (TextView)paramView;
      final as localas = this.uNk;
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
        ((com.tencent.mm.ui.widget.b.a)localObject).Yrf = new View.OnCreateContextMenuListener()
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(291185);
            paramAnonymousContextMenu.add(NormalProfileHeaderPreference.e(NormalProfileHeaderPreference.this).getString(R.l.app_copy));
            AppMethodBeat.o(291185);
          }
        };
        ((com.tencent.mm.ui.widget.b.a)localObject).ODU = new q.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(288146);
            if (paramAnonymousInt == 0)
            {
              ClipboardHelper.setText(paramView);
              com.tencent.mm.ui.base.h.cN(NormalProfileHeaderPreference.e(NormalProfileHeaderPreference.this), NormalProfileHeaderPreference.e(NormalProfileHeaderPreference.this).getString(R.l.app_copy_ok));
            }
            AppMethodBeat.o(288146);
          }
        };
        ((com.tencent.mm.ui.widget.b.a)localObject).XVa = new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(276119);
            NormalProfileHeaderPreference.a(NormalProfileHeaderPreference.this, localTextView, localas);
            AppMethodBeat.o(276119);
          }
        };
        if (!(localTextView.getTag(R.h.touch_loc) instanceof int[])) {
          break label294;
        }
        paramView = (int[])localTextView.getTag(R.h.touch_loc);
        ((com.tencent.mm.ui.widget.b.a)localObject).eY(paramView[0], paramView[1]);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(27286);
        return true;
        label294:
        ((com.tencent.mm.ui.widget.b.a)localObject).eY(this.nmj, this.nmk);
      }
    }
    if (i == R.h.dCg)
    {
      paramView = Util.secPrint(this.uNk.field_username) + "-" + com.tencent.mm.pluginsdk.j.f.formatTime("yyyy-MM-dd_HH:mm:ss", cm.bfF()) + ".txt";
      ((PluginRepairer)com.tencent.mm.kernel.h.ag(PluginRepairer.class)).sendContactInfo(paramView, this.uNk);
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(27286);
      return true;
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(27286);
    return false;
  }
  
  final class a
  {
    TextView DKE;
    AvatarPatTipImageView HaA;
    FMessageListView HaB;
    private View HaC;
    LinearLayout HaD;
    e HaE;
    View HaF;
    ImageView HaG;
    private ImageView HaH;
    private ImageView HaI;
    View HaJ;
    ImageView HaK;
    View HaL;
    private View HaM;
    View HaN;
    ImageView HaO;
    TextView HaP;
    private View Ham;
    private View Han;
    private View Hao;
    private View Hap;
    private View Haq;
    private View Har;
    ImageView Has;
    TextView Hat;
    MMNeat7extView Hau;
    TextView Hav;
    TextView Haw;
    TextView Hax;
    TextView Hay;
    TextView Haz;
    TextView vsF;
    
    a(View paramView)
    {
      AppMethodBeat.i(27274);
      this.Ham = null;
      this.Han = null;
      this.Hao = null;
      this.Hap = null;
      this.Haq = null;
      this.Har = null;
      this.Has = null;
      this.vsF = null;
      this.Hat = null;
      this.Hau = null;
      this.Hav = null;
      this.DKE = null;
      this.Haw = null;
      this.Hax = null;
      this.Hay = null;
      this.Haz = null;
      this.HaA = null;
      this.HaD = null;
      this.HaE = null;
      this.HaF = null;
      this.HaJ = paramView.findViewById(R.h.dpC);
      this.HaB = ((FMessageListView)paramView.findViewById(R.h.dCb));
      this.HaC = paramView.findViewById(R.h.dCc);
      this.Ham = paramView.findViewById(R.h.dBZ);
      this.Han = paramView.findViewById(R.h.dBU);
      this.Hao = paramView.findViewById(R.h.dCi);
      this.Haq = paramView.findViewById(R.h.dBV);
      this.Har = paramView.findViewById(R.h.dCj);
      this.Hap = paramView.findViewById(R.h.dCo);
      this.HaA = ((AvatarPatTipImageView)paramView.findViewById(R.h.dBW));
      this.Hav = ((TextView)paramView.findViewById(R.h.dBY));
      this.Hau = ((MMNeat7extView)paramView.findViewById(R.h.dCg));
      this.vsF = ((TextView)paramView.findViewById(R.h.dCf));
      this.HaN = paramView.findViewById(R.h.dAI);
      this.HaO = ((ImageView)paramView.findViewById(R.h.dAG));
      this.HaP = ((TextView)paramView.findViewById(R.h.dAH));
      this.Hat = ((TextView)paramView.findViewById(R.h.dBQ));
      this.Has = ((ImageView)paramView.findViewById(R.h.dCk));
      this.DKE = ((TextView)paramView.findViewById(R.h.dCn));
      this.Haw = ((TextView)paramView.findViewById(R.h.dCl));
      this.Hax = ((TextView)paramView.findViewById(R.h.dCe));
      this.Hay = ((TextView)paramView.findViewById(R.h.dCa));
      this.Haz = ((TextView)paramView.findViewById(R.h.dCm));
      this.HaG = ((ImageView)paramView.findViewById(R.h.dBT));
      this.HaH = ((ImageView)paramView.findViewById(R.h.dBR));
      this.HaI = ((ImageView)paramView.findViewById(R.h.dBS));
      this.HaK = ((ImageView)paramView.findViewById(R.h.dAD));
      this.HaL = paramView.findViewById(R.h.dCh);
      this.HaM = paramView.findViewById(R.h.dBX);
      this.HaD = ((LinearLayout)paramView.findViewById(R.h.dCd));
      this.HaF = paramView.findViewById(R.h.v_intercept_head_root_click);
      paramView = (RelativeLayout)this.HaL;
      Object localObject = this.HaD;
      if (t.gkZ())
      {
        localObject = ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).getProfileCardView(NormalProfileHeaderPreference.this.mContext, paramView, (LinearLayout)localObject, NormalProfileHeaderPreference.this.mContext.getResources().getDimensionPixelSize(R.f.Edge_2A));
        paramView.addView(((e)localObject).getView());
        paramView = (RelativeLayout.LayoutParams)((e)localObject).getView().getLayoutParams();
        paramView.width = -1;
        paramView.height = -2;
        paramView.addRule(3, R.h.dCd);
        this.HaE = ((e)localObject);
      }
      this.HaJ.findViewById(R.h.dSG).setOnClickListener(NormalProfileHeaderPreference.this);
      this.HaJ.findViewById(R.h.dMI).setOnClickListener(NormalProfileHeaderPreference.this);
      this.Har.setOnClickListener(NormalProfileHeaderPreference.this);
      this.Hap.setOnClickListener(NormalProfileHeaderPreference.this);
      this.HaA.setOnClickListener(NormalProfileHeaderPreference.this);
      this.Ham.setOnClickListener(NormalProfileHeaderPreference.this);
      this.Han.setOnClickListener(NormalProfileHeaderPreference.this);
      this.Hao.setOnClickListener(NormalProfileHeaderPreference.this);
      this.Haq.setOnClickListener(NormalProfileHeaderPreference.this);
      this.DKE.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(27273);
          NormalProfileHeaderPreference.this.nmj = ((int)paramAnonymousMotionEvent.getRawX());
          NormalProfileHeaderPreference.this.nmk = ((int)paramAnonymousMotionEvent.getRawY());
          int i = NormalProfileHeaderPreference.this.nmj;
          int j = NormalProfileHeaderPreference.this.nmk;
          paramAnonymousView.setTag(R.h.touch_loc, new int[] { i, j });
          AppMethodBeat.o(27273);
          return false;
        }
      });
      this.DKE.setOnLongClickListener(NormalProfileHeaderPreference.this);
      paramView = i.YyX;
      if (i.a(b.a.YxQ, 0) == 1) {
        this.Hau.setOnLongClickListener(NormalProfileHeaderPreference.this);
      }
      if (this.HaK != null) {
        this.HaK.setOnClickListener(NormalProfileHeaderPreference.this);
      }
      if (this.HaL != null) {
        this.HaL.setOnClickListener(NormalProfileHeaderPreference.this);
      }
      AppMethodBeat.o(27274);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference
 * JD-Core Version:    0.7.0.1
 */