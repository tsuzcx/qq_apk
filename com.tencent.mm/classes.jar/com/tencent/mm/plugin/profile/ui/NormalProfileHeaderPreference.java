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
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.q;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.profile.c;
import com.tencent.mm.plugin.sns.c.o;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.preference.FMessageListView;
import com.tencent.mm.pluginsdk.ui.preference.PhoneNumPreference;
import com.tencent.mm.pluginsdk.ui.preference.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class NormalProfileHeaderPreference
  extends Preference
  implements View.OnClickListener, View.OnLongClickListener
{
  public f lxI;
  private Context mContext;
  private int mScene;
  private af oFt;
  private boolean readOnly = false;
  private boolean tRt = false;
  private View ttN;
  private String uCH;
  private boolean uCI;
  private int uCJ;
  int uCK = 0;
  int uCL = 0;
  private com.tencent.mm.plugin.profile.a.b uyW;
  
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
  
  private String S(af paramaf)
  {
    AppMethodBeat.i(27280);
    Resources localResources;
    if (dbO())
    {
      localResources = this.mContext.getResources();
      if (bt.isNullOrNil(paramaf.getCity())) {
        paramaf = v.sj(paramaf.getProvince());
      }
    }
    for (paramaf = localResources.getString(2131756698, new Object[] { paramaf }).trim();; paramaf = paramaf.ZX())
    {
      paramaf = bt.by(paramaf, "");
      AppMethodBeat.o(27280);
      return paramaf;
      paramaf = paramaf.getCity();
      break;
    }
  }
  
  public static CharSequence a(Context paramContext, af paramaf, int paramInt, String paramString, boolean paramBoolean)
  {
    String str = null;
    AppMethodBeat.i(27283);
    int i = paramInt;
    if (paramInt == 9) {
      i = paramaf.getSource();
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
      if ((paramBoolean) || (paramaf.ZZ() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757862);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.n.b.ls(paramaf.field_type))
      {
        paramContext = paramContext.getResources().getString(2131757861);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131757863);
      AppMethodBeat.o(27283);
      return paramContext;
    case 3: 
      if ((paramBoolean) || (paramaf.ZZ() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757865);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.n.b.ls(paramaf.field_type))
      {
        paramContext = paramContext.getResources().getString(2131757864);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131757866);
      AppMethodBeat.o(27283);
      return paramContext;
    case 17: 
      str = hW(((Activity)paramContext).getIntent().getStringExtra("share_card_username"), ((Activity)paramContext).getIntent().getStringExtra("share_card_nickname"));
      paramString = str;
      if (bt.isNullOrNil(str)) {
        paramString = hW(((Activity)paramContext).getIntent().getStringExtra("source_from_user_name"), ((Activity)paramContext).getIntent().getStringExtra("source_from_nick_name"));
      }
      if ((paramBoolean) || (paramaf.ZZ() > 1000000))
      {
        if (bt.isNullOrNil(paramString)) {}
        for (paramContext = paramContext.getString(2131757842);; paramContext = com.tencent.mm.pluginsdk.ui.span.k.c(paramContext, paramContext.getString(2131757841, new Object[] { paramString })))
        {
          AppMethodBeat.o(27283);
          return paramContext;
        }
      }
      if (com.tencent.mm.n.b.ls(paramaf.field_type))
      {
        if (bt.isNullOrNil(paramString)) {}
        for (paramContext = paramContext.getString(2131757839);; paramContext = com.tencent.mm.pluginsdk.ui.span.k.c(paramContext, paramContext.getString(2131757840, new Object[] { paramString })))
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
      paramContext = com.tencent.mm.pluginsdk.ui.span.k.c(paramContext, paramContext.getString(2131757844));
      AppMethodBeat.o(27283);
      return paramContext;
    case 18: 
      if ((paramBoolean) || (paramaf.ZZ() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757850);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.n.b.ls(paramaf.field_type))
      {
        paramContext = paramContext.getResources().getString(2131757849);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131757851);
      AppMethodBeat.o(27283);
      return paramContext;
    case 30: 
      if ((paramBoolean) || (paramaf.ZZ() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757855);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.n.b.ls(paramaf.field_type))
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
      paramString = d.aCn().agg(paramString).field_chatroomName;
      if (bt.isNullOrNil(paramString)) {
        paramString = paramaf.field_sourceExtInfo;
      }
      break;
    }
    for (;;)
    {
      af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramString);
      paramString = str;
      if (localaf != null)
      {
        if (bt.isNullOrNil(localaf.field_username)) {
          paramString = str;
        }
      }
      else
      {
        if ((!paramBoolean) && (paramaf.ZZ() <= 1000000)) {
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
        if (bt.isNullOrNil(localaf.field_nickname))
        {
          paramString = q.rP(localaf.field_username);
          break;
        }
        paramString = localaf.field_nickname;
        break;
      }
      label997:
      if (com.tencent.mm.n.b.ls(paramaf.field_type))
      {
        paramContext = paramContext.getResources().getString(2131757847, new Object[] { paramString });
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131757845);
      AppMethodBeat.o(27283);
      return paramContext;
      if ((paramBoolean) || (paramaf.ZZ() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757868);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.n.b.ls(paramaf.field_type))
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
      if ((paramBoolean) || (paramaf.ZZ() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757871);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.n.b.ls(paramaf.field_type))
      {
        paramContext = paramContext.getResources().getString(2131757870);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131757872);
      AppMethodBeat.o(27283);
      return paramContext;
      if ((paramBoolean) || (paramaf.ZZ() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757837);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.n.b.ls(paramaf.field_type))
      {
        paramContext = paramContext.getResources().getString(2131757836);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131757838);
      AppMethodBeat.o(27283);
      return paramContext;
      if ((paramBoolean) || (paramaf.ZZ() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757859);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.n.b.ls(paramaf.field_type))
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
  
  private static void a(a parama, Context paramContext, af paramaf, int paramInt, com.tencent.mm.pluginsdk.ui.preference.b[] paramArrayOfb)
  {
    int i = 0;
    AppMethodBeat.i(27281);
    if ((paramArrayOfb == null) || (com.tencent.mm.n.b.ls(paramaf.field_type)))
    {
      parama.uDe.setVisibility(8);
      AppMethodBeat.o(27281);
      return;
    }
    parama.uDe.setVisibility(0);
    paramContext = bt.nullAsNil(((Activity)paramContext).getIntent().getStringExtra("Verify_ticket"));
    a.a locala = new a.a();
    locala.talker = paramaf.field_username;
    locala.scene = paramInt;
    locala.rso = paramContext;
    locala.Cin = paramaf.evP;
    locala.type = 0;
    if (paramInt == 18) {
      locala.type = 1;
    }
    for (;;)
    {
      parama.uDe.setFMessageArgs(locala);
      int j = paramArrayOfb.length;
      paramInt = i;
      while (paramInt < j)
      {
        paramContext = paramArrayOfb[paramInt];
        parama.uDe.a(paramContext);
        paramInt += 1;
      }
      if (bi.nj(paramInt)) {
        locala.type = 2;
      }
    }
    AppMethodBeat.o(27281);
  }
  
  private void a(String paramString, af paramaf)
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
    paramString.putExtra("Contact_User", paramaf.field_username);
    paramString.putExtra("Contact_Nick", paramaf.field_nickname);
    paramString.putExtra("Contact_RemarkName", paramaf.field_conRemark);
    com.tencent.mm.plugin.profile.b.hYt.n(paramString, this.mContext);
    AppMethodBeat.o(27287);
  }
  
  private boolean dbO()
  {
    AppMethodBeat.i(27279);
    boolean bool = af.st(this.oFt.field_username);
    AppMethodBeat.o(27279);
    return bool;
  }
  
  private static String hW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(27284);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(27284);
      return null;
    }
    String str = v.si(paramString1);
    if (!bt.isNullOrNil(str)) {}
    for (;;)
    {
      AppMethodBeat.o(27284);
      return str;
      str = paramString2;
      if (bt.isNullOrNil(paramString2)) {
        str = v.sh(paramString1);
      }
    }
  }
  
  public final void K(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27282);
    int i = ap.dL(this.mContext);
    this.uCI = paramBoolean;
    this.uCJ = paramInt;
    if (paramInt <= 0) {
      this.uCJ = i;
    }
    if (this.lxI != null) {
      this.lxI.notifyDataSetChanged();
    }
    ad.i("MicroMsg.NormalProfileHeaderPreference", "setHasStory action=%s weuiActionBarHeight=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(27282);
  }
  
  public final void a(af paramaf, int paramInt, boolean paramBoolean, com.tencent.mm.plugin.profile.a.b paramb)
  {
    AppMethodBeat.i(27275);
    this.uCH = ((Activity)this.mContext).getIntent().getStringExtra("Contact_RoomNickname");
    this.oFt = paramaf;
    this.mScene = paramInt;
    this.readOnly = paramBoolean;
    this.tRt = true;
    this.uyW = paramb;
    AppMethodBeat.o(27275);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27278);
    super.onBindView(paramView);
    if (!this.tRt)
    {
      ad.w("MicroMsg.NormalProfileHeaderPreference", "[onBindView] never attach!");
      AppMethodBeat.o(27278);
      return;
    }
    if (paramView.getTag() == null) {
      paramView.setTag(new a(paramView));
    }
    final a locala = (a)paramView.getTag();
    a.b.c(locala.uDd, this.oFt.field_username);
    float f1;
    int n;
    int i1;
    int k;
    boolean bool2;
    boolean bool3;
    int m;
    if (!bt.isNullOrNil(S(this.oFt)))
    {
      locala.uCX.setVisibility(0);
      f1 = locala.uCX.getTextSize();
      paramView = S(this.oFt);
      n = (int)this.mContext.getResources().getDimension(2131165301);
      i1 = (int)this.mContext.getResources().getDimension(2131165289);
      if (this.oFt.evp == 0) {
        break label1060;
      }
      k = this.mContext.getResources().getDrawable(2131690323).getIntrinsicWidth();
      boolean bool1 = this.oFt.ZP();
      bool2 = o.wzJ.akH(this.oFt.field_username);
      bool3 = this.oFt.ZO();
      m = (int)this.mContext.getResources().getDimension(2131165274);
      if (!bool1) {
        break label1940;
      }
    }
    label545:
    label832:
    label964:
    label1098:
    label1748:
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
      locala.uCX.setMaxWidth(i);
      locala.uCX.aq(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, paramView, f1));
      locala.uCX.setContentDescription(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, paramView, f1));
      if (locala.uCX.ki(i, 2147483647).fkV() > 1)
      {
        f1 = com.tencent.mm.cd.a.dT(this.mContext);
        float f2 = com.tencent.mm.cd.a.ar(this.mContext, (int)locala.uCX.getResources().getDimension(2131165579));
        locala.uCX.setTextSize(f1 * f2);
        locala.uCX.aq(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, paramView, locala.uCX.getTextSize()));
      }
      String str;
      label728:
      label763:
      Object localObject;
      if (this.uCI)
      {
        locala.uCX.setTextColor(this.mContext.getResources().getColor(2131101182));
        locala.uCX.setMaxLines(1);
        locala.uCX.getPaint().setFakeBoldText(true);
        str = ((Activity)this.mContext).getIntent().getStringExtra("Contact_Distance");
        if ((!((Activity)this.mContext).getIntent().getBooleanExtra("Contact_IsLBSFriend", false)) || (bt.isNullOrNil(str))) {
          break label1098;
        }
        locala.uDb.setText(this.mContext.getString(2131757645) + str);
        locala.uDb.setVisibility(0);
        if (af.aHH(this.oFt.field_username))
        {
          locala.uCW.setVisibility(0);
          locala.uCW.setText(com.tencent.mm.openim.room.a.a.G(this.oFt));
        }
        if ((!bt.isNullOrNil(this.oFt.field_nickname)) && (!bt.isNullOrNil(this.oFt.field_conRemark)) && (!dbO())) {
          break label1111;
        }
        locala.siX.setVisibility(8);
        if (bt.isNullOrNil(this.uCH)) {
          break label1187;
        }
        if (((Activity)this.mContext).getIntent().getIntExtra("Contact_Scene", -1) != 14) {
          break label1181;
        }
        i = 1;
        if (i == 0) {
          break label1187;
        }
        locala.uCY.setVisibility(0);
        paramView = this.mContext.getString(2131757629) + this.uCH;
        locala.uCY.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, paramView, locala.siX.getTextSize()));
        if (((bt.isNullOrNil(this.oFt.Ss())) && (bt.isNullOrNil(this.oFt.field_username))) || (!com.tencent.mm.n.b.ls(this.oFt.field_type)) || (af.aHH(this.oFt.field_username)) || (dbO())) {
          break label1211;
        }
        locala.svO.setVisibility(0);
        localObject = locala.svO;
        StringBuilder localStringBuilder = new StringBuilder().append(this.mContext.getString(2131755760));
        if (!bt.isNullOrNil(this.oFt.Ss())) {
          break label1200;
        }
        paramView = this.oFt.field_username;
        ((TextView)localObject).setText(paramView);
        if (this.oFt.field_deleteFlag != 1) {
          break label1224;
        }
        locala.uDc.setVisibility(0);
        locala.uDc.setText(this.mContext.getText(2131757576));
        locala.siX.setVisibility(8);
        locala.uCZ.setVisibility(8);
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1250;
        }
        ad.i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] has delete account! username:%s", new Object[] { this.oFt.field_username });
        AppMethodBeat.o(27278);
        return;
        k = 0;
        break;
        locala.uCX.setTextColor(ao.aD(this.mContext, 2130968584));
        locala.uCX.setMaxLines(2147483647);
        break label545;
        locala.uDb.setVisibility(8);
        break label648;
        label1111:
        locala.siX.setVisibility(0);
        paramView = this.mContext.getString(2131757742) + this.oFt.field_nickname;
        locala.siX.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, paramView, locala.siX.getTextSize()));
        break label728;
        i = 0;
        break label763;
        locala.uCY.setVisibility(8);
        break label832;
        paramView = this.oFt.Ss();
        break label950;
        locala.svO.setVisibility(8);
        break label964;
        locala.uDc.setVisibility(8);
        locala.uCZ.setVisibility(8);
      }
      label1250:
      if ((!com.tencent.mm.n.b.ls(this.oFt.field_type)) && (!dbO()) && (!w.tg(this.oFt.field_username)))
      {
        ad.i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] accept contact! username:%s", new Object[] { this.oFt.field_username });
        locala.uDk.setVisibility(8);
        if ((com.tencent.mm.n.b.ls(this.oFt.field_type)) || (!((Activity)this.mContext).getIntent().getBooleanExtra("User_Verify", false))) {
          break label1694;
        }
        i = 1;
        if (i == 0) {
          break label1700;
        }
        locala.uDk.setVisibility(0);
        a(locala, this.mContext, this.oFt, this.mScene, p.a(this.mContext, this.oFt, this.mScene));
        if (!bt.isNullOrNil(this.oFt.signature)) {
          break label1713;
        }
        locala.uCZ.setVisibility(8);
        if (!bt.isNullOrNil(this.oFt.getProvince())) {
          break label1748;
        }
        locala.uDa.setVisibility(8);
        paramView = locala.uCV;
        localObject = this.oFt;
        paramView.setVisibility(0);
        if (((au)localObject).evp != 1) {
          break label1870;
        }
        paramView.setImageDrawable(com.tencent.mm.cd.a.l(this.mContext, 2131690323));
        paramView.setContentDescription(this.mContext.getString(2131762052));
        i = ((Activity)this.mContext).getIntent().getIntExtra("Contact_Scene", 0);
        if ((26 > i) || (i > 29)) {
          break label1927;
        }
        i = 1;
        label1534:
        if (i != 0)
        {
          locala.uDb.setVisibility(0);
          locala.siX.setVisibility(8);
          locala.uDb.setText(this.mContext.getString(2131757645) + str);
        }
        if (!w.tg(this.oFt.field_username))
        {
          paramView = locala.uDh;
          if ((!this.oFt.ZO()) || (!com.tencent.mm.n.b.ls(this.oFt.field_type))) {
            break label1933;
          }
        }
      }
      label1366:
      label1498:
      for (i = 0;; i = 8)
      {
        paramView.setVisibility(i);
        locala.uDm.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            AppMethodBeat.i(27269);
            locala.uDm.getViewTreeObserver().removeOnPreDrawListener(this);
            int[] arrayOfInt = new int[2];
            locala.uDm.getLocationOnScreen(arrayOfInt);
            int k = arrayOfInt[1];
            int m = ap.iX(NormalProfileHeaderPreference.this.mContext);
            int j = com.tencent.mm.cd.a.ap(NormalProfileHeaderPreference.this.mContext, 2131166723);
            ad.i("MicroMsg.NormalProfileHeaderPreference", "actionBarHeight=%s ,statusBarHeight=%s , rootTop:%s", new Object[] { Integer.valueOf(NormalProfileHeaderPreference.a(NormalProfileHeaderPreference.this)), Integer.valueOf(m), Integer.valueOf(k) });
            int i;
            if (NormalProfileHeaderPreference.b(NormalProfileHeaderPreference.this)) {
              i = com.tencent.mm.cd.a.ap(NormalProfileHeaderPreference.this.mContext, 2131166721);
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
              if (j == locala.uDm.getPaddingTop()) {
                break;
              }
              locala.uDm.setPadding(locala.uDm.getPaddingLeft(), j, locala.uDm.getPaddingRight(), locala.uDm.getPaddingBottom());
              AppMethodBeat.o(27269);
              return false;
              i = j;
              if (m > 0)
              {
                i = j;
                if (NormalProfileHeaderPreference.a(NormalProfileHeaderPreference.this) > 0) {
                  i = NormalProfileHeaderPreference.a(NormalProfileHeaderPreference.this) + com.tencent.mm.cd.a.ap(NormalProfileHeaderPreference.this.mContext, 2131165289);
                }
              }
            }
            AppMethodBeat.o(27269);
            return true;
          }
        });
        AppMethodBeat.o(27278);
        return;
        if (locala.uDk == null) {
          break;
        }
        locala.uDk.setVisibility(8);
        break;
        i = 0;
        break label1352;
        locala.uDk.setVisibility(8);
        break label1366;
        locala.uCZ.setText(com.tencent.mm.pluginsdk.ui.span.k.c(this.mContext, this.oFt.signature));
        locala.uCZ.setVisibility(8);
        break label1421;
        locala.uDa.setVisibility(0);
        localObject = new StringBuilder().append(v.sj(this.oFt.getProvince()));
        if (bt.isNullOrNil(this.oFt.getCity())) {}
        for (paramView = "";; paramView = "  " + this.oFt.getCity())
        {
          paramView = paramView;
          locala.uDa.setText(this.mContext.getString(2131757721) + paramView);
          break;
        }
        if (((au)localObject).evp == 2)
        {
          paramView.setImageDrawable(com.tencent.mm.cd.a.l(this.mContext, 2131690322));
          paramView.setContentDescription(this.mContext.getString(2131762051));
          break label1498;
        }
        if (((au)localObject).evp != 0) {
          break label1498;
        }
        paramView.setVisibility(8);
        break label1498;
        i = 0;
        break label1534;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(27285);
    int i = paramView.getId();
    Object localObject;
    if (i == 2131303982)
    {
      paramView = this.oFt;
      if (paramView == null)
      {
        ad.e("MicroMsg.NormalProfileHeaderPreference", "contact is null");
        AppMethodBeat.o(27285);
        return;
      }
      if (!com.tencent.mm.n.b.ls(paramView.field_type))
      {
        if (!bt.isNullOrNil(paramView.field_encryptUsername))
        {
          a(paramView.field_encryptUsername, paramView);
          AppMethodBeat.o(27285);
          return;
        }
        a(paramView.field_username, paramView);
        AppMethodBeat.o(27285);
        return;
      }
      localObject = (PhoneNumPreference)this.lxI.aKk("contact_profile_phone");
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_Scene", this.mScene);
      localIntent.putExtra("Contact_User", paramView.field_username);
      localIntent.putExtra("view_mode", true);
      localIntent.putExtra("contact_phone_number_by_md5", ((PhoneNumPreference)localObject).BVY);
      localIntent.putExtra("contact_phone_number_list", paramView.evO);
      com.tencent.mm.plugin.profile.b.hYt.m(localIntent, this.mContext);
      AppMethodBeat.o(27285);
      return;
    }
    if (i == 2131302424)
    {
      if (this.uyW != null)
      {
        this.uyW.dbX();
        AppMethodBeat.o(27285);
      }
    }
    else if (i == 2131298688)
    {
      localObject = this.oFt.field_username;
      paramView = new Intent(this.mContext, ProfileHdHeadImg.class);
      paramView.putExtra("username", (String)localObject);
      localObject = this.mContext;
      paramView = new com.tencent.mm.hellhoundlib.b.a().bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.adn(), "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "clickAvatar", "(Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject).startActivity((Intent)paramView.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "clickAvatar", "(Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.report.service.h.vKh.f(16055, new Object[] { Integer.valueOf(c.aA(((Activity)this.mContext).getIntent())), Integer.valueOf(16), Integer.valueOf(1), this.oFt.field_username });
    }
    AppMethodBeat.o(27285);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27277);
    if (this.ttN == null) {
      this.ttN = super.onCreateView(paramViewGroup);
    }
    paramViewGroup = this.ttN;
    AppMethodBeat.o(27277);
    return paramViewGroup;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(27276);
    if (this.ttN != null)
    {
      a locala = (a)this.ttN.getTag();
      if (locala.uDe != null) {
        locala.uDe.detach();
      }
    }
    AppMethodBeat.o(27276);
  }
  
  public boolean onLongClick(final View paramView)
  {
    AppMethodBeat.i(27286);
    if (paramView.getId() == 2131298706)
    {
      final TextView localTextView = (TextView)paramView;
      final af localaf = this.oFt;
      final ClipboardManager localClipboardManager = (ClipboardManager)aj.getContext().getSystemService("clipboard");
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
        ((SpannableString)localObject).setSpan(new BackgroundColorSpan(this.mContext.getResources().getColor(2131100539)), i + 2, localTextView.getText().length(), 33);
        localTextView.setText((CharSequence)localObject);
        localObject = new com.tencent.mm.ui.widget.b.a(this.mContext, localTextView);
        ((com.tencent.mm.ui.widget.b.a)localObject).HIu = new View.OnCreateContextMenuListener()
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(27270);
            paramAnonymousContextMenu.add(NormalProfileHeaderPreference.c(NormalProfileHeaderPreference.this).getString(2131755701));
            AppMethodBeat.o(27270);
          }
        };
        ((com.tencent.mm.ui.widget.b.a)localObject).HrY = new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(27271);
            if (paramAnonymousInt == 0)
            {
              localClipboardManager.setText(paramView);
              com.tencent.mm.ui.base.h.ce(NormalProfileHeaderPreference.c(NormalProfileHeaderPreference.this), NormalProfileHeaderPreference.c(NormalProfileHeaderPreference.this).getString(2131755702));
            }
            AppMethodBeat.o(27271);
          }
        };
        ((com.tencent.mm.ui.widget.b.a)localObject).Hua = new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(27272);
            NormalProfileHeaderPreference.a(NormalProfileHeaderPreference.this, localTextView, localaf);
            AppMethodBeat.o(27272);
          }
        };
        if (!(localTextView.getTag(2131306044) instanceof int[])) {
          break label263;
        }
        paramView = (int[])localTextView.getTag(2131306044);
        ((com.tencent.mm.ui.widget.b.a)localObject).eh(paramView[0], paramView[1]);
      }
      for (;;)
      {
        AppMethodBeat.o(27286);
        return true;
        label263:
        ((com.tencent.mm.ui.widget.b.a)localObject).eh(this.uCK, this.uCL);
      }
    }
    AppMethodBeat.o(27286);
    return false;
  }
  
  final class a
  {
    TextView siX;
    TextView svO;
    private View uCP;
    private View uCQ;
    private View uCR;
    private View uCS;
    private View uCT;
    private View uCU;
    ImageView uCV;
    TextView uCW;
    MMNeat7extView uCX;
    TextView uCY;
    TextView uCZ;
    TextView uDa;
    TextView uDb;
    TextView uDc;
    ImageView uDd;
    FMessageListView uDe;
    private View uDf;
    private LinearLayout uDg;
    ImageView uDh;
    private ImageView uDi;
    private ImageView uDj;
    View uDk;
    private ImageView uDl;
    View uDm;
    private View uDn;
    
    a(View paramView)
    {
      AppMethodBeat.i(27274);
      this.uCP = null;
      this.uCQ = null;
      this.uCR = null;
      this.uCS = null;
      this.uCT = null;
      this.uCU = null;
      this.uCV = null;
      this.siX = null;
      this.uCW = null;
      this.uCX = null;
      this.uCY = null;
      this.svO = null;
      this.uCZ = null;
      this.uDa = null;
      this.uDb = null;
      this.uDc = null;
      this.uDd = null;
      this.uDg = null;
      this.uDk = paramView.findViewById(2131296322);
      this.uDe = ((FMessageListView)paramView.findViewById(2131298693));
      this.uDf = paramView.findViewById(2131298694);
      this.uCP = paramView.findViewById(2131298691);
      this.uCQ = paramView.findViewById(2131298686);
      this.uCR = paramView.findViewById(2131298700);
      this.uCT = paramView.findViewById(2131298687);
      this.uCU = paramView.findViewById(2131298702);
      this.uCS = paramView.findViewById(2131298708);
      this.uDd = ((ImageView)paramView.findViewById(2131298688));
      this.uCY = ((TextView)paramView.findViewById(2131298690));
      this.uCX = ((MMNeat7extView)paramView.findViewById(2131298698));
      this.siX = ((TextView)paramView.findViewById(2131298697));
      this.uCW = ((TextView)paramView.findViewById(2131298681));
      this.uCV = ((ImageView)paramView.findViewById(2131298703));
      this.svO = ((TextView)paramView.findViewById(2131298706));
      this.uCZ = ((TextView)paramView.findViewById(2131298704));
      this.uDa = ((TextView)paramView.findViewById(2131298696));
      this.uDb = ((TextView)paramView.findViewById(2131298692));
      this.uDc = ((TextView)paramView.findViewById(2131298705));
      this.uDh = ((ImageView)paramView.findViewById(2131298685));
      this.uDi = ((ImageView)paramView.findViewById(2131298683));
      this.uDj = ((ImageView)paramView.findViewById(2131298684));
      this.uDl = ((ImageView)paramView.findViewById(2131298590));
      this.uDm = paramView.findViewById(2131298699);
      this.uDn = paramView.findViewById(2131298689);
      this.uDg = ((LinearLayout)paramView.findViewById(2131298695));
      this.uDk.findViewById(2131303982).setOnClickListener(NormalProfileHeaderPreference.this);
      this.uDk.findViewById(2131302424).setOnClickListener(NormalProfileHeaderPreference.this);
      this.uCU.setOnClickListener(NormalProfileHeaderPreference.this);
      this.uCS.setOnClickListener(NormalProfileHeaderPreference.this);
      this.uDd.setOnClickListener(NormalProfileHeaderPreference.this);
      this.uCP.setOnClickListener(NormalProfileHeaderPreference.this);
      this.uCQ.setOnClickListener(NormalProfileHeaderPreference.this);
      this.uCR.setOnClickListener(NormalProfileHeaderPreference.this);
      this.uCT.setOnClickListener(NormalProfileHeaderPreference.this);
      this.svO.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(27273);
          NormalProfileHeaderPreference.this.uCK = ((int)paramAnonymousMotionEvent.getRawX());
          NormalProfileHeaderPreference.this.uCL = ((int)paramAnonymousMotionEvent.getRawY());
          paramAnonymousView.setTag(2131306044, new int[] { NormalProfileHeaderPreference.this.uCK, NormalProfileHeaderPreference.this.uCL });
          AppMethodBeat.o(27273);
          return false;
        }
      });
      this.svO.setOnLongClickListener(NormalProfileHeaderPreference.this);
      this.uDl.setOnClickListener(NormalProfileHeaderPreference.this);
      AppMethodBeat.o(27274);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference
 * JD-Core Version:    0.7.0.1
 */