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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.patmsg.a.c.a;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.plugin.textstatus.a.p;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.preference.FMessageListView;
import com.tencent.mm.pluginsdk.ui.preference.PhoneNumPreference;
import com.tencent.mm.pluginsdk.ui.preference.a.a;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class NormalProfileHeaderPreference
  extends Preference
  implements View.OnClickListener, View.OnLongClickListener
{
  private com.tencent.mm.plugin.profile.a.b Bcm;
  private String Bgu;
  private boolean Bgv;
  private boolean Bgw;
  private int Bgx;
  private boolean Bgy;
  String Urs;
  int kuv = 0;
  int kuw = 0;
  private Context mContext;
  private int mScene;
  public com.tencent.mm.ui.base.preference.f nRm;
  private boolean readOnly = false;
  private as rjX;
  private boolean zRI = false;
  View zlc;
  
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
      paramContext = paramContext.getResources().getString(2131760782);
      AppMethodBeat.o(27283);
      return paramContext;
    case 1: 
      if ((paramBoolean) || (paramas.arL() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131758102);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.c.oR(paramas.field_type))
      {
        paramContext = paramContext.getResources().getString(2131758101);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131758103);
      AppMethodBeat.o(27283);
      return paramContext;
    case 3: 
      if ((paramBoolean) || (paramas.arL() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131758105);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.c.oR(paramas.field_type))
      {
        paramContext = paramContext.getResources().getString(2131758104);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131758106);
      AppMethodBeat.o(27283);
      return paramContext;
    case 17: 
      str = jw(((Activity)paramContext).getIntent().getStringExtra("share_card_username"), ((Activity)paramContext).getIntent().getStringExtra("share_card_nickname"));
      paramString = str;
      if (Util.isNullOrNil(str)) {
        paramString = jw(((Activity)paramContext).getIntent().getStringExtra("source_from_user_name"), ((Activity)paramContext).getIntent().getStringExtra("source_from_nick_name"));
      }
      if ((paramBoolean) || (paramas.arL() > 1000000))
      {
        if (Util.isNullOrNil(paramString)) {}
        for (paramContext = paramContext.getString(2131758082);; paramContext = com.tencent.mm.pluginsdk.ui.span.l.c(paramContext, paramContext.getString(2131758081, new Object[] { paramString })))
        {
          AppMethodBeat.o(27283);
          return paramContext;
        }
      }
      if (com.tencent.mm.contact.c.oR(paramas.field_type))
      {
        if (Util.isNullOrNil(paramString)) {}
        for (paramContext = paramContext.getString(2131758079);; paramContext = com.tencent.mm.pluginsdk.ui.span.l.c(paramContext, paramContext.getString(2131758080, new Object[] { paramString })))
        {
          AppMethodBeat.o(27283);
          return paramContext;
        }
      }
      if (!Util.isNullOrNil(paramString))
      {
        paramContext = paramContext.getString(2131758083, new Object[] { paramString });
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = com.tencent.mm.pluginsdk.ui.span.l.c(paramContext, paramContext.getString(2131758084));
      AppMethodBeat.o(27283);
      return paramContext;
    case 18: 
      if ((paramBoolean) || (paramas.arL() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131758090);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.c.oR(paramas.field_type))
      {
        paramContext = paramContext.getResources().getString(2131758089);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131758091);
      AppMethodBeat.o(27283);
      return paramContext;
    case 30: 
      if ((paramBoolean) || (paramas.arL() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131758095);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.c.oR(paramas.field_type))
      {
        paramContext = paramContext.getResources().getString(2131758094);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131758096);
      AppMethodBeat.o(27283);
      return paramContext;
    case 48: 
      paramContext = paramContext.getResources().getString(2131758097);
      AppMethodBeat.o(27283);
      return paramContext;
    case 8: 
    case 14: 
    case 96: 
      paramString = com.tencent.mm.bj.d.bgM().aEm(paramString).field_chatroomName;
      if (Util.isNullOrNil(paramString)) {
        paramString = paramas.field_sourceExtInfo;
      }
      break;
    }
    for (;;)
    {
      as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString);
      paramString = str;
      if (localas != null)
      {
        if (Util.isNullOrNil(localas.field_username)) {
          paramString = str;
        }
      }
      else
      {
        if ((!paramBoolean) && (paramas.arL() <= 1000000)) {
          break label997;
        }
        if (Util.isNullOrNil(paramString)) {
          break label987;
        }
      }
      label987:
      for (paramContext = paramContext.getString(2131758088, new Object[] { paramString });; paramContext = paramContext.getString(2131758086))
      {
        AppMethodBeat.o(27283);
        return paramContext;
        if (Util.isNullOrNil(localas.field_nickname))
        {
          paramString = v.HV(localas.field_username);
          break;
        }
        paramString = localas.field_nickname;
        break;
      }
      label997:
      if (com.tencent.mm.contact.c.oR(paramas.field_type))
      {
        paramContext = paramContext.getResources().getString(2131758087, new Object[] { paramString });
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131758085);
      AppMethodBeat.o(27283);
      return paramContext;
      if ((paramBoolean) || (paramas.arL() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131758108);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.c.oR(paramas.field_type))
      {
        paramContext = paramContext.getResources().getString(2131758107);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131758109);
      AppMethodBeat.o(27283);
      return paramContext;
      paramContext = paramContext.getResources().getString(2131758074);
      AppMethodBeat.o(27283);
      return paramContext;
      paramContext = paramContext.getResources().getString(2131761400);
      AppMethodBeat.o(27283);
      return paramContext;
      paramContext = paramContext.getResources().getString(2131758092);
      AppMethodBeat.o(27283);
      return paramContext;
      if ((paramBoolean) || (paramas.arL() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131758111);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.c.oR(paramas.field_type))
      {
        paramContext = paramContext.getResources().getString(2131758110);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131758112);
      AppMethodBeat.o(27283);
      return paramContext;
      if ((paramBoolean) || (paramas.arL() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131758077);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.c.oR(paramas.field_type))
      {
        paramContext = paramContext.getResources().getString(2131758076);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131758078);
      AppMethodBeat.o(27283);
      return paramContext;
      if ((paramBoolean) || (paramas.arL() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131758099);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.contact.c.oR(paramas.field_type))
      {
        paramContext = paramContext.getResources().getString(2131758098);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131758100);
      AppMethodBeat.o(27283);
      return paramContext;
      paramContext = paramContext.getResources().getString(2131760783);
      AppMethodBeat.o(27283);
      return paramContext;
    }
  }
  
  private static void a(a parama, Context paramContext, as paramas, int paramInt, com.tencent.mm.pluginsdk.ui.preference.b[] paramArrayOfb)
  {
    int i = 0;
    AppMethodBeat.i(27281);
    if ((paramArrayOfb == null) || (com.tencent.mm.contact.c.oR(paramas.field_type)))
    {
      parama.BgR.setVisibility(8);
      AppMethodBeat.o(27281);
      return;
    }
    parama.BgR.setVisibility(0);
    paramContext = Util.nullAsNil(((Activity)paramContext).getIntent().getStringExtra("Verify_ticket"));
    a.a locala = new a.a();
    locala.talker = paramas.field_username;
    locala.scene = paramInt;
    locala.wZz = paramContext;
    locala.Kpf = paramas.fuY;
    locala.type = 0;
    if (paramInt == 18) {
      locala.type = 1;
    }
    for (;;)
    {
      parama.BgR.setFMessageArgs(locala);
      int j = paramArrayOfb.length;
      paramInt = i;
      while (paramInt < j)
      {
        paramContext = paramArrayOfb[paramInt];
        parama.BgR.a(paramContext);
        paramInt += 1;
      }
      if (bp.sb(paramInt)) {
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
    com.tencent.mm.plugin.profile.b.jRt.m(paramString, this.mContext);
    AppMethodBeat.o(27287);
  }
  
  private String aa(as paramas)
  {
    AppMethodBeat.i(27280);
    Resources localResources;
    if (eDI())
    {
      localResources = this.mContext.getResources();
      if (Util.isNullOrNil(paramas.getCity())) {
        paramas = aa.It(paramas.getProvince());
      }
    }
    for (paramas = localResources.getString(2131756856, new Object[] { paramas }).trim();; paramas = paramas.arJ())
    {
      paramas = Util.nullAs(paramas, "");
      AppMethodBeat.o(27280);
      return paramas;
      paramas = paramas.getCity();
      break;
    }
  }
  
  private boolean eDI()
  {
    AppMethodBeat.i(27279);
    boolean bool = as.IG(this.rjX.field_username);
    AppMethodBeat.o(27279);
    return bool;
  }
  
  private static String jw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(27284);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(27284);
      return null;
    }
    String str = aa.Is(paramString1);
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
  
  public final void a(as paramas, int paramInt, boolean paramBoolean, com.tencent.mm.plugin.profile.a.b paramb)
  {
    AppMethodBeat.i(27275);
    this.Bgu = ((Activity)this.mContext).getIntent().getStringExtra("Contact_RoomNickname");
    this.rjX = paramas;
    this.mScene = paramInt;
    this.readOnly = paramBoolean;
    this.zRI = true;
    this.Bcm = paramb;
    AppMethodBeat.o(27275);
  }
  
  public final void b(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(231890);
    int i = au.eu(this.mContext);
    this.Bgv = paramBoolean1;
    this.Bgw = paramBoolean2;
    this.Bgx = paramInt;
    this.Bgy = p.fvC();
    if (paramInt <= 0) {
      this.Bgx = i;
    }
    if (this.nRm != null) {
      this.nRm.notifyDataSetChanged();
    }
    Log.i("MicroMsg.NormalProfileHeaderPreference", "setHasStory action=%s weuiActionBarHeight=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(231890);
  }
  
  public final com.tencent.mm.plugin.textstatus.a.d eEI()
  {
    AppMethodBeat.i(231891);
    if (this.zlc != null)
    {
      com.tencent.mm.plugin.textstatus.a.d locald = ((a)this.zlc.getTag()).BgU;
      AppMethodBeat.o(231891);
      return locald;
    }
    AppMethodBeat.o(231891);
    return null;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27278);
    super.onBindView(paramView);
    if (!this.zRI)
    {
      Log.w("MicroMsg.NormalProfileHeaderPreference", "[onBindView] never attach!");
      AppMethodBeat.o(27278);
      return;
    }
    if (paramView.getTag() == null) {
      paramView.setTag(new a(paramView));
    }
    final a locala = (a)paramView.getTag();
    a.b.c(locala.BgQ, this.rjX.field_username);
    float f1;
    int n;
    int i1;
    int k;
    label263:
    boolean bool2;
    boolean bool3;
    int m;
    if (((com.tencent.mm.plugin.patmsg.a.b)g.af(com.tencent.mm.plugin.patmsg.a.b.class)).J(5, this.rjX.field_username, this.rjX.field_username))
    {
      if (com.tencent.mm.contact.c.oR(this.rjX.field_type))
      {
        locala.BgQ.setTagUsername(this.rjX.field_username);
        locala.BgQ.setTagTalker(this.rjX.field_username);
        locala.BgQ.setTagScene(5);
      }
    }
    else if (!Util.isNullOrNil(aa(this.rjX)))
    {
      locala.BgK.setVisibility(0);
      f1 = locala.BgK.getTextSize();
      paramView = aa(this.rjX);
      n = (int)this.mContext.getResources().getDimension(2131165312);
      i1 = (int)this.mContext.getResources().getDimension(2131165296);
      if (this.rjX.fuA == 0) {
        break label1632;
      }
      k = this.mContext.getResources().getDrawable(2131690428).getIntrinsicWidth();
      boolean bool1 = this.rjX.arB();
      bool2 = o.DCP.aKt(this.rjX.field_username);
      bool3 = this.rjX.arA();
      m = (int)this.mContext.getResources().getDimension(2131165277);
      if (!bool1) {
        break label2152;
      }
    }
    label739:
    label2023:
    label2152:
    for (int j = this.mContext.getResources().getDrawable(2131689967).getIntrinsicWidth() + m + m;; j = m)
    {
      int i = j;
      if (bool3) {
        i = j + this.mContext.getResources().getDrawable(2131691352).getIntrinsicWidth() + m;
      }
      j = i;
      if (bool2) {
        j = i + this.mContext.getResources().getDrawable(2131689968).getIntrinsicWidth() + m;
      }
      i = this.mContext.getResources().getDisplayMetrics().widthPixels - n - i1 * 3 - k - j;
      Log.i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] calculateRemarkNameTvSize:%s", new Object[] { Integer.valueOf(i) });
      locala.BgK.setMaxWidth(i);
      locala.BgK.aw(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, paramView, f1));
      locala.BgK.setContentDescription(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, paramView, f1));
      if (locala.BgK.mq(i, 2147483647).hiG() > 1)
      {
        f1 = com.tencent.mm.cb.a.ez(this.mContext);
        float f2 = com.tencent.mm.cb.a.E(this.mContext, (int)locala.BgK.getResources().getDimension(2131165597));
        locala.BgK.setTextSize(f1 * f2);
        locala.BgK.aw(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, paramView, locala.BgK.getTextSize()));
      }
      label636:
      Object localObject1;
      Object localObject2;
      if ((this.Bgv) || (this.Bgw))
      {
        locala.BgK.setTextColor(this.mContext.getResources().getColor(2131101427));
        locala.BgK.setMaxLines(1);
        locala.BgK.getPaint().setFakeBoldText(true);
        String str1 = ((Activity)this.mContext).getIntent().getStringExtra("Contact_Distance");
        if ((!((Activity)this.mContext).getIntent().getBooleanExtra("Contact_IsLBSFriend", false)) || (Util.isNullOrNil(str1))) {
          break label1673;
        }
        locala.BgO.setText(this.mContext.getString(2131757873) + str1);
        locala.BgO.setVisibility(0);
        if (as.bjp(this.rjX.field_username))
        {
          locala.BgJ.setVisibility(0);
          locala.BgJ.setText(com.tencent.mm.openim.room.a.a.O(this.rjX));
        }
        if ((!Util.isNullOrNil(this.rjX.field_nickname)) && (!Util.isNullOrNil(this.rjX.field_conRemark)) && (!eDI())) {
          break label1686;
        }
        locala.rMV.setVisibility(8);
        if (Util.isNullOrNil(this.Bgu)) {
          break label1762;
        }
        if (((Activity)this.mContext).getIntent().getIntExtra("Contact_Scene", -1) != 14) {
          break label1756;
        }
        i = 1;
        if (i == 0) {
          break label1762;
        }
        locala.BgL.setVisibility(0);
        paramView = this.mContext.getString(2131757857) + this.Bgu;
        locala.BgL.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, paramView, locala.rMV.getTextSize()));
        if (((Util.isNullOrNil(this.rjX.ajx())) && (Util.isNullOrNil(this.rjX.field_username))) || (!com.tencent.mm.contact.c.oR(this.rjX.field_type)) || (as.bjp(this.rjX.field_username)) || (eDI())) {
          break label1786;
        }
        locala.ykC.setVisibility(0);
        localObject1 = locala.ykC;
        localObject2 = new StringBuilder().append(com.tencent.mm.plugin.profile.c.br(this.mContext, this.rjX.field_username));
        String str2 = this.rjX.field_username;
        if (!Util.isNullOrNil(this.rjX.ajx())) {
          break label1775;
        }
        paramView = this.rjX.field_username;
        ((TextView)localObject1).setText(com.tencent.mm.plugin.profile.c.ju(str2, paramView));
        if (this.rjX.field_deleteFlag != 1) {
          break label1799;
        }
        locala.BgP.setVisibility(0);
        locala.BgP.setText(this.mContext.getText(2131757803));
        locala.rMV.setVisibility(8);
        locala.BgM.setVisibility(8);
        i = 1;
        label1134:
        if (i != 0) {
          Log.i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] has delete account! username:%s", new Object[] { this.rjX.field_username });
        }
        if ((com.tencent.mm.contact.c.oR(this.rjX.field_type)) || (eDI()) || (ab.Jv(this.rjX.field_username))) {
          break label1825;
        }
        Log.i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] accept contact! username:%s", new Object[] { this.rjX.field_username });
        locala.BgY.setVisibility(8);
        if ((com.tencent.mm.contact.c.oR(this.rjX.field_type)) || (!((Activity)this.mContext).getIntent().getBooleanExtra("User_Verify", false))) {
          break label1846;
        }
        i = 1;
        label1264:
        if (i == 0) {
          break label1852;
        }
        locala.BgY.setVisibility(0);
        label1278:
        a(locala, this.mContext, this.rjX, this.mScene, q.a(this.mContext, this.rjX, this.mScene));
        if (!Util.isNullOrNil(this.rjX.signature)) {
          break label1865;
        }
        locala.BgM.setVisibility(8);
        if (!Util.isNullOrNil(this.rjX.getProvince())) {
          break label1900;
        }
        locala.BgN.setVisibility(8);
        paramView = locala.BgI;
        localObject1 = this.rjX;
        paramView.setVisibility(0);
        if (((ax)localObject1).fuA != 1) {
          break label2023;
        }
        paramView.setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131690428));
        paramView.setContentDescription(this.mContext.getString(2131764070));
        localObject2 = this.rjX;
        paramView = locala.BgU;
        localObject1 = locala.BgZ;
        if ((localObject2 != null) && (paramView != null)) {
          break label2080;
        }
        i = ((Activity)this.mContext).getIntent().getIntExtra("Contact_Scene", 0);
        if ((26 > i) || (i > 29)) {
          break label2139;
        }
        i = 1;
        if (i != 0)
        {
          locala.BgO.setVisibility(0);
          locala.rMV.setVisibility(8);
          locala.BgO.setText(this.mContext.getString(2131757873) + str1);
        }
        if (!ab.Jv(this.rjX.field_username))
        {
          paramView = locala.BgV;
          if ((!this.rjX.arA()) || (!com.tencent.mm.contact.c.oR(this.rjX.field_type))) {
            break label2145;
          }
        }
      }
      for (i = 0;; i = 8)
      {
        paramView.setVisibility(i);
        locala.Bha.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            AppMethodBeat.i(231886);
            locala.Bha.getViewTreeObserver().removeOnPreDrawListener(this);
            int[] arrayOfInt = new int[2];
            locala.Bha.getLocationOnScreen(arrayOfInt);
            int k = arrayOfInt[1];
            int m = au.getStatusBarHeight(NormalProfileHeaderPreference.this.mContext);
            int j = com.tencent.mm.cb.a.aH(NormalProfileHeaderPreference.this.mContext, 2131166843);
            int i;
            if (NormalProfileHeaderPreference.a(NormalProfileHeaderPreference.this))
            {
              i = com.tencent.mm.cb.a.aH(NormalProfileHeaderPreference.this.mContext, 2131166841);
              if ((k != 0) || (NormalProfileHeaderPreference.a(NormalProfileHeaderPreference.this))) {
                break label275;
              }
              j = i + m;
            }
            for (;;)
            {
              Log.i("MicroMsg.NormalProfileHeaderPreference", "actionBarHeight=%s ,statusBarHeight=%s , rootTop:%s, paddingTopToSet:%s,curPaddingTop:%s", new Object[] { Integer.valueOf(NormalProfileHeaderPreference.b(NormalProfileHeaderPreference.this)), Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(locala.Bha.getPaddingTop()) });
              if (j == locala.Bha.getPaddingTop()) {
                break label295;
              }
              locala.Bha.setPadding(locala.Bha.getPaddingLeft(), j, locala.Bha.getPaddingRight(), locala.Bha.getPaddingBottom());
              AppMethodBeat.o(231886);
              return false;
              i = j;
              if (m <= 0) {
                break;
              }
              i = j;
              if (NormalProfileHeaderPreference.b(NormalProfileHeaderPreference.this) <= 0) {
                break;
              }
              i = NormalProfileHeaderPreference.b(NormalProfileHeaderPreference.this) + com.tencent.mm.cb.a.aH(NormalProfileHeaderPreference.this.mContext, 2131165296);
              break;
              label275:
              j = i;
              if (NormalProfileHeaderPreference.c(NormalProfileHeaderPreference.this)) {
                j = i + m;
              }
            }
            label295:
            AppMethodBeat.o(231886);
            return true;
          }
        });
        AppMethodBeat.o(27278);
        return;
        locala.BgQ.setOnDoubleClickListener(new c.a()
        {
          public final boolean eF(View paramAnonymousView)
          {
            AppMethodBeat.i(231885);
            ((PluginPatMsg)g.ah(PluginPatMsg.class)).playPatAnimation(paramAnonymousView);
            AppMethodBeat.o(231885);
            return true;
          }
        });
        break;
        k = 0;
        break label263;
        locala.BgK.setTextColor(this.mContext.getResources().getColor(2131099746));
        locala.BgK.setMaxLines(2147483647);
        break label636;
        locala.BgO.setVisibility(8);
        break label739;
        locala.rMV.setVisibility(0);
        paramView = this.mContext.getString(2131757979) + this.rjX.field_nickname;
        locala.rMV.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, paramView, locala.rMV.getTextSize()));
        break label819;
        i = 0;
        break label854;
        locala.BgL.setVisibility(8);
        break label923;
        label1775:
        paramView = this.rjX.ajx();
        break label1054;
        label1786:
        locala.ykC.setVisibility(8);
        break label1073;
        locala.BgP.setVisibility(8);
        locala.BgM.setVisibility(8);
        i = 0;
        break label1134;
        if (locala.BgY == null) {
          break label1228;
        }
        locala.BgY.setVisibility(8);
        break label1228;
        i = 0;
        break label1264;
        locala.BgY.setVisibility(8);
        break label1278;
        locala.BgM.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.mContext, this.rjX.signature));
        locala.BgM.setVisibility(8);
        break label1333;
        label1900:
        locala.BgN.setVisibility(0);
        localObject1 = new StringBuilder().append(aa.It(this.rjX.getProvince()));
        if (Util.isNullOrNil(this.rjX.getCity())) {}
        for (paramView = "";; paramView = "  " + this.rjX.getCity())
        {
          paramView = paramView;
          locala.BgN.setText(this.mContext.getString(2131757952) + paramView);
          break;
        }
        if (((ax)localObject1).fuA == 2)
        {
          paramView.setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131690427));
          paramView.setContentDescription(this.mContext.getString(2131764069));
          break label1410;
        }
        if (((ax)localObject1).fuA != 0) {
          break label1410;
        }
        paramView.setVisibility(8);
        break label1410;
        localObject2 = ((ax)localObject2).field_username;
        if (!TextUtils.equals(this.Urs, (CharSequence)localObject2))
        {
          paramView.DV((String)localObject2);
          this.Urs = ((String)localObject2);
        }
        if (this.Bgw)
        {
          ((View)localObject1).setVisibility(8);
          break label1438;
        }
        ((View)localObject1).setVisibility(0);
        break label1438;
        i = 0;
        break label1474;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(27285);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    int i = paramView.getId();
    if (i == 2131306836)
    {
      paramView = this.rjX;
      if (paramView == null) {
        Log.e("MicroMsg.NormalProfileHeaderPreference", "contact is null");
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(27285);
      return;
      if (!com.tencent.mm.contact.c.oR(paramView.field_type))
      {
        if (!Util.isNullOrNil(paramView.field_encryptUsername)) {
          a(paramView.field_encryptUsername, paramView);
        } else {
          a(paramView.field_username, paramView);
        }
      }
      else
      {
        localObject = (PhoneNumPreference)this.nRm.bmg("contact_profile_phone");
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_Scene", this.mScene);
        localIntent.putExtra("Contact_User", paramView.field_username);
        localIntent.putExtra("view_mode", true);
        localIntent.putExtra("contact_phone_number_by_md5", ((PhoneNumPreference)localObject).KcI);
        localIntent.putExtra("contact_phone_number_list", paramView.fuX);
        com.tencent.mm.plugin.profile.b.jRt.l(localIntent, this.mContext);
        continue;
        if (i == 2131304821)
        {
          if (this.Bcm != null) {
            this.Bcm.eDQ();
          }
        }
        else if (i == 2131299126)
        {
          localObject = this.rjX.field_username;
          paramView = new Intent(this.mContext, ProfileHdHeadImg.class);
          paramView.putExtra("username", (String)localObject);
          localObject = this.mContext;
          paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.axQ(), "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "clickAvatar", "(Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject).startActivity((Intent)paramView.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "clickAvatar", "(Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.h.CyF.a(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(((Activity)this.mContext).getIntent())), Integer.valueOf(16), Integer.valueOf(1), this.rjX.field_username });
        }
      }
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27277);
    if (this.zlc == null) {
      this.zlc = super.onCreateView(paramViewGroup);
    }
    paramViewGroup = this.zlc;
    AppMethodBeat.o(27277);
    return paramViewGroup;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(27276);
    if (this.zlc != null)
    {
      a locala = (a)this.zlc.getTag();
      if (locala.BgR != null) {
        locala.BgR.detach();
      }
    }
    AppMethodBeat.o(27276);
  }
  
  public boolean onLongClick(final View paramView)
  {
    AppMethodBeat.i(27286);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    if (paramView.getId() == 2131299144)
    {
      final TextView localTextView = (TextView)paramView;
      final as localas = this.rjX;
      if (localTextView.getText() != null)
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
        ((SpannableString)localObject).setSpan(new BackgroundColorSpan(this.mContext.getResources().getColor(2131100677)), i + 2, localTextView.getText().length(), 33);
        localTextView.setText((CharSequence)localObject);
        localObject = new com.tencent.mm.ui.widget.b.a(this.mContext, localTextView);
        ((com.tencent.mm.ui.widget.b.a)localObject).QSs = new View.OnCreateContextMenuListener()
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(231887);
            paramAnonymousContextMenu.add(NormalProfileHeaderPreference.d(NormalProfileHeaderPreference.this).getString(2131755772));
            AppMethodBeat.o(231887);
          }
        };
        ((com.tencent.mm.ui.widget.b.a)localObject).HLY = new o.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(231888);
            if (paramAnonymousInt == 0)
            {
              ClipboardHelper.setText(paramView);
              com.tencent.mm.ui.base.h.cC(NormalProfileHeaderPreference.d(NormalProfileHeaderPreference.this), NormalProfileHeaderPreference.d(NormalProfileHeaderPreference.this).getString(2131755773));
            }
            AppMethodBeat.o(231888);
          }
        };
        ((com.tencent.mm.ui.widget.b.a)localObject).QwU = new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(231889);
            NormalProfileHeaderPreference.a(NormalProfileHeaderPreference.this, localTextView, localas);
            AppMethodBeat.o(231889);
          }
        };
        if (!(localTextView.getTag(2131309367) instanceof int[])) {
          break label292;
        }
        paramView = (int[])localTextView.getTag(2131309367);
        ((com.tencent.mm.ui.widget.b.a)localObject).ez(paramView[0], paramView[1]);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(27286);
        return true;
        label292:
        ((com.tencent.mm.ui.widget.b.a)localObject).ez(this.kuv, this.kuw);
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(27286);
    return false;
  }
  
  final class a
  {
    private View BgC;
    private View BgD;
    private View BgE;
    private View BgF;
    private View BgG;
    private View BgH;
    ImageView BgI;
    TextView BgJ;
    MMNeat7extView BgK;
    TextView BgL;
    TextView BgM;
    TextView BgN;
    TextView BgO;
    TextView BgP;
    AvatarPatTipImageView BgQ;
    FMessageListView BgR;
    private View BgS;
    LinearLayout BgT;
    com.tencent.mm.plugin.textstatus.a.d BgU;
    ImageView BgV;
    private ImageView BgW;
    private ImageView BgX;
    View BgY;
    ImageView BgZ;
    View Bha;
    private View Bhb;
    TextView rMV;
    TextView ykC;
    
    a(View paramView)
    {
      AppMethodBeat.i(27274);
      this.BgC = null;
      this.BgD = null;
      this.BgE = null;
      this.BgF = null;
      this.BgG = null;
      this.BgH = null;
      this.BgI = null;
      this.rMV = null;
      this.BgJ = null;
      this.BgK = null;
      this.BgL = null;
      this.ykC = null;
      this.BgM = null;
      this.BgN = null;
      this.BgO = null;
      this.BgP = null;
      this.BgQ = null;
      this.BgT = null;
      this.BgU = null;
      this.BgY = paramView.findViewById(2131296335);
      this.BgR = ((FMessageListView)paramView.findViewById(2131299131));
      this.BgS = paramView.findViewById(2131299132);
      this.BgC = paramView.findViewById(2131299129);
      this.BgD = paramView.findViewById(2131299124);
      this.BgE = paramView.findViewById(2131299138);
      this.BgG = paramView.findViewById(2131299125);
      this.BgH = paramView.findViewById(2131299140);
      this.BgF = paramView.findViewById(2131299146);
      this.BgQ = ((AvatarPatTipImageView)paramView.findViewById(2131299126));
      this.BgL = ((TextView)paramView.findViewById(2131299128));
      this.BgK = ((MMNeat7extView)paramView.findViewById(2131299136));
      this.rMV = ((TextView)paramView.findViewById(2131299135));
      this.BgJ = ((TextView)paramView.findViewById(2131299119));
      this.BgI = ((ImageView)paramView.findViewById(2131299141));
      this.ykC = ((TextView)paramView.findViewById(2131299144));
      this.BgM = ((TextView)paramView.findViewById(2131299142));
      this.BgN = ((TextView)paramView.findViewById(2131299134));
      this.BgO = ((TextView)paramView.findViewById(2131299130));
      this.BgP = ((TextView)paramView.findViewById(2131299143));
      this.BgV = ((ImageView)paramView.findViewById(2131299123));
      this.BgW = ((ImageView)paramView.findViewById(2131299121));
      this.BgX = ((ImageView)paramView.findViewById(2131299122));
      this.BgZ = ((ImageView)paramView.findViewById(2131299027));
      this.Bha = paramView.findViewById(2131299137);
      this.Bhb = paramView.findViewById(2131299127);
      this.BgT = ((LinearLayout)paramView.findViewById(2131299133));
      paramView = (RelativeLayout)this.Bha;
      Object localObject = this.BgT;
      if (p.fvC())
      {
        localObject = ((com.tencent.mm.plugin.textstatus.a.c)g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).getProfileCardView(NormalProfileHeaderPreference.this.mContext, paramView, (LinearLayout)localObject, NormalProfileHeaderPreference.this.mContext.getResources().getDimensionPixelSize(2131165296));
        paramView.addView(((com.tencent.mm.plugin.textstatus.a.d)localObject).getView());
        paramView = (RelativeLayout.LayoutParams)((com.tencent.mm.plugin.textstatus.a.d)localObject).getView().getLayoutParams();
        paramView.width = -1;
        paramView.height = -2;
        paramView.addRule(3, 2131299133);
        this.BgU = ((com.tencent.mm.plugin.textstatus.a.d)localObject);
      }
      this.BgY.findViewById(2131306836).setOnClickListener(NormalProfileHeaderPreference.this);
      this.BgY.findViewById(2131304821).setOnClickListener(NormalProfileHeaderPreference.this);
      this.BgH.setOnClickListener(NormalProfileHeaderPreference.this);
      this.BgF.setOnClickListener(NormalProfileHeaderPreference.this);
      this.BgQ.setOnClickListener(NormalProfileHeaderPreference.this);
      this.BgC.setOnClickListener(NormalProfileHeaderPreference.this);
      this.BgD.setOnClickListener(NormalProfileHeaderPreference.this);
      this.BgE.setOnClickListener(NormalProfileHeaderPreference.this);
      this.BgG.setOnClickListener(NormalProfileHeaderPreference.this);
      this.ykC.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(27273);
          NormalProfileHeaderPreference.this.kuv = ((int)paramAnonymousMotionEvent.getRawX());
          NormalProfileHeaderPreference.this.kuw = ((int)paramAnonymousMotionEvent.getRawY());
          paramAnonymousView.setTag(2131309367, new int[] { NormalProfileHeaderPreference.this.kuv, NormalProfileHeaderPreference.this.kuw });
          AppMethodBeat.o(27273);
          return false;
        }
      });
      this.ykC.setOnLongClickListener(NormalProfileHeaderPreference.this);
      if (this.BgZ != null) {
        this.BgZ.setOnClickListener(NormalProfileHeaderPreference.this);
      }
      AppMethodBeat.o(27274);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference
 * JD-Core Version:    0.7.0.1
 */