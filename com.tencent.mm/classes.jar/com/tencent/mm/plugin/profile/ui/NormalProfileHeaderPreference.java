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
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.q;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.profile.c;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.preference.FMessageListView;
import com.tencent.mm.pluginsdk.ui.preference.PhoneNumPreference;
import com.tencent.mm.pluginsdk.ui.preference.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bj;
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
  public f lZC;
  private Context mContext;
  private int mScene;
  private com.tencent.mm.storage.ai piT;
  int rTn = 0;
  int rTo = 0;
  private boolean readOnly = false;
  private View uCg;
  private com.tencent.mm.plugin.profile.a.b vHP;
  private String vLA;
  private boolean vLB;
  private int vLC;
  private boolean vab = false;
  
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
  
  private String T(com.tencent.mm.storage.ai paramai)
  {
    AppMethodBeat.i(27280);
    Resources localResources;
    if (dpw())
    {
      localResources = this.mContext.getResources();
      if (bs.isNullOrNil(paramai.getCity())) {
        paramai = v.wm(paramai.getProvince());
      }
    }
    for (paramai = localResources.getString(2131756698, new Object[] { paramai }).trim();; paramai = paramai.aaS())
    {
      paramai = bs.bG(paramai, "");
      AppMethodBeat.o(27280);
      return paramai;
      paramai = paramai.getCity();
      break;
    }
  }
  
  public static CharSequence a(Context paramContext, com.tencent.mm.storage.ai paramai, int paramInt, String paramString, boolean paramBoolean)
  {
    String str = null;
    AppMethodBeat.i(27283);
    int i = paramInt;
    if (paramInt == 9) {
      i = paramai.getSource();
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
      if ((paramBoolean) || (paramai.aaU() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757862);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.n.b.ln(paramai.field_type))
      {
        paramContext = paramContext.getResources().getString(2131757861);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131757863);
      AppMethodBeat.o(27283);
      return paramContext;
    case 3: 
      if ((paramBoolean) || (paramai.aaU() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757865);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.n.b.ln(paramai.field_type))
      {
        paramContext = paramContext.getResources().getString(2131757864);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131757866);
      AppMethodBeat.o(27283);
      return paramContext;
    case 17: 
      str = ip(((Activity)paramContext).getIntent().getStringExtra("share_card_username"), ((Activity)paramContext).getIntent().getStringExtra("share_card_nickname"));
      paramString = str;
      if (bs.isNullOrNil(str)) {
        paramString = ip(((Activity)paramContext).getIntent().getStringExtra("source_from_user_name"), ((Activity)paramContext).getIntent().getStringExtra("source_from_nick_name"));
      }
      if ((paramBoolean) || (paramai.aaU() > 1000000))
      {
        if (bs.isNullOrNil(paramString)) {}
        for (paramContext = paramContext.getString(2131757842);; paramContext = com.tencent.mm.pluginsdk.ui.span.k.c(paramContext, paramContext.getString(2131757841, new Object[] { paramString })))
        {
          AppMethodBeat.o(27283);
          return paramContext;
        }
      }
      if (com.tencent.mm.n.b.ln(paramai.field_type))
      {
        if (bs.isNullOrNil(paramString)) {}
        for (paramContext = paramContext.getString(2131757839);; paramContext = com.tencent.mm.pluginsdk.ui.span.k.c(paramContext, paramContext.getString(2131757840, new Object[] { paramString })))
        {
          AppMethodBeat.o(27283);
          return paramContext;
        }
      }
      if (!bs.isNullOrNil(paramString))
      {
        paramContext = paramContext.getString(2131757843, new Object[] { paramString });
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = com.tencent.mm.pluginsdk.ui.span.k.c(paramContext, paramContext.getString(2131757844));
      AppMethodBeat.o(27283);
      return paramContext;
    case 18: 
      if ((paramBoolean) || (paramai.aaU() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757850);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.n.b.ln(paramai.field_type))
      {
        paramContext = paramContext.getResources().getString(2131757849);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131757851);
      AppMethodBeat.o(27283);
      return paramContext;
    case 30: 
      if ((paramBoolean) || (paramai.aaU() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757855);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.n.b.ln(paramai.field_type))
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
      paramString = d.aJd().ala(paramString).field_chatroomName;
      if (bs.isNullOrNil(paramString)) {
        paramString = paramai.field_sourceExtInfo;
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.storage.ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString);
      paramString = str;
      if (localai != null)
      {
        if (bs.isNullOrNil(localai.field_username)) {
          paramString = str;
        }
      }
      else
      {
        if ((!paramBoolean) && (paramai.aaU() <= 1000000)) {
          break label997;
        }
        if (bs.isNullOrNil(paramString)) {
          break label987;
        }
      }
      label987:
      for (paramContext = paramContext.getString(2131757848, new Object[] { paramString });; paramContext = paramContext.getString(2131757846))
      {
        AppMethodBeat.o(27283);
        return paramContext;
        if (bs.isNullOrNil(localai.field_nickname))
        {
          paramString = q.vS(localai.field_username);
          break;
        }
        paramString = localai.field_nickname;
        break;
      }
      label997:
      if (com.tencent.mm.n.b.ln(paramai.field_type))
      {
        paramContext = paramContext.getResources().getString(2131757847, new Object[] { paramString });
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131757845);
      AppMethodBeat.o(27283);
      return paramContext;
      if ((paramBoolean) || (paramai.aaU() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757868);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.n.b.ln(paramai.field_type))
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
      if ((paramBoolean) || (paramai.aaU() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757871);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.n.b.ln(paramai.field_type))
      {
        paramContext = paramContext.getResources().getString(2131757870);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131757872);
      AppMethodBeat.o(27283);
      return paramContext;
      if ((paramBoolean) || (paramai.aaU() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757837);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.n.b.ln(paramai.field_type))
      {
        paramContext = paramContext.getResources().getString(2131757836);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      paramContext = paramContext.getResources().getString(2131757838);
      AppMethodBeat.o(27283);
      return paramContext;
      if ((paramBoolean) || (paramai.aaU() > 1000000))
      {
        paramContext = paramContext.getResources().getString(2131757859);
        AppMethodBeat.o(27283);
        return paramContext;
      }
      if (com.tencent.mm.n.b.ln(paramai.field_type))
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
  
  private static void a(a parama, Context paramContext, com.tencent.mm.storage.ai paramai, int paramInt, com.tencent.mm.pluginsdk.ui.preference.b[] paramArrayOfb)
  {
    int i = 0;
    AppMethodBeat.i(27281);
    if ((paramArrayOfb == null) || (com.tencent.mm.n.b.ln(paramai.field_type)))
    {
      parama.vLV.setVisibility(8);
      AppMethodBeat.o(27281);
      return;
    }
    parama.vLV.setVisibility(0);
    paramContext = bs.nullAsNil(((Activity)paramContext).getIntent().getStringExtra("Verify_ticket"));
    a.a locala = new a.a();
    locala.talker = paramai.field_username;
    locala.scene = paramInt;
    locala.sBi = paramContext;
    locala.DAE = paramai.eym;
    locala.type = 0;
    if (paramInt == 18) {
      locala.type = 1;
    }
    for (;;)
    {
      parama.vLV.setFMessageArgs(locala);
      int j = paramArrayOfb.length;
      paramInt = i;
      while (paramInt < j)
      {
        paramContext = paramArrayOfb[paramInt];
        parama.vLV.a(paramContext);
        paramInt += 1;
      }
      if (bi.nX(paramInt)) {
        locala.type = 2;
      }
    }
    AppMethodBeat.o(27281);
  }
  
  private void a(String paramString, com.tencent.mm.storage.ai paramai)
  {
    AppMethodBeat.i(27287);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.NormalProfileHeaderPreference", "view stranger remark, username is null");
      AppMethodBeat.o(27287);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("Contact_Scene", this.mScene);
    paramString.putExtra("Contact_mode_name_type", 0);
    paramString.putExtra("Contact_ModStrangerRemark", true);
    paramString.putExtra("Contact_User", paramai.field_username);
    paramString.putExtra("Contact_Nick", paramai.field_nickname);
    paramString.putExtra("Contact_RemarkName", paramai.field_conRemark);
    com.tencent.mm.plugin.profile.b.iyx.n(paramString, this.mContext);
    AppMethodBeat.o(27287);
  }
  
  private boolean dpw()
  {
    AppMethodBeat.i(27279);
    boolean bool = com.tencent.mm.storage.ai.ww(this.piT.field_username);
    AppMethodBeat.o(27279);
    return bool;
  }
  
  private static String ip(String paramString1, String paramString2)
  {
    AppMethodBeat.i(27284);
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(27284);
      return null;
    }
    String str = v.wl(paramString1);
    if (!bs.isNullOrNil(str)) {}
    for (;;)
    {
      AppMethodBeat.o(27284);
      return str;
      str = paramString2;
      if (bs.isNullOrNil(paramString2)) {
        str = v.wk(paramString1);
      }
    }
  }
  
  public final void M(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27282);
    int i = ap.dT(this.mContext);
    this.vLB = paramBoolean;
    this.vLC = paramInt;
    if (paramInt <= 0) {
      this.vLC = i;
    }
    if (this.lZC != null) {
      this.lZC.notifyDataSetChanged();
    }
    ac.i("MicroMsg.NormalProfileHeaderPreference", "setHasStory action=%s weuiActionBarHeight=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(27282);
  }
  
  public final void a(com.tencent.mm.storage.ai paramai, int paramInt, boolean paramBoolean, com.tencent.mm.plugin.profile.a.b paramb)
  {
    AppMethodBeat.i(27275);
    this.vLA = ((Activity)this.mContext).getIntent().getStringExtra("Contact_RoomNickname");
    this.piT = paramai;
    this.mScene = paramInt;
    this.readOnly = paramBoolean;
    this.vab = true;
    this.vHP = paramb;
    AppMethodBeat.o(27275);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27278);
    super.onBindView(paramView);
    if (!this.vab)
    {
      ac.w("MicroMsg.NormalProfileHeaderPreference", "[onBindView] never attach!");
      AppMethodBeat.o(27278);
      return;
    }
    if (paramView.getTag() == null) {
      paramView.setTag(new a(paramView));
    }
    final a locala = (a)paramView.getTag();
    a.b.c(locala.vLU, this.piT.field_username);
    float f1;
    int n;
    int i1;
    int k;
    boolean bool2;
    boolean bool3;
    int m;
    if (!bs.isNullOrNil(T(this.piT)))
    {
      locala.vLO.setVisibility(0);
      f1 = locala.vLO.getTextSize();
      paramView = T(this.piT);
      n = (int)this.mContext.getResources().getDimension(2131165301);
      i1 = (int)this.mContext.getResources().getDimension(2131165289);
      if (this.piT.exL == 0) {
        break label1476;
      }
      k = this.mContext.getResources().getDrawable(2131690323).getIntrinsicWidth();
      boolean bool1 = this.piT.aaK();
      bool2 = o.xMd.apG(this.piT.field_username);
      bool3 = this.piT.aaJ();
      m = (int)this.mContext.getResources().getDimension(2131165274);
      if (!bool1) {
        break label1933;
      }
    }
    label648:
    label1933:
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
      ac.i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] calculateRemarkNameTvSize:%s", new Object[] { Integer.valueOf(i) });
      locala.vLO.setMaxWidth(i);
      locala.vLO.ar(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, paramView, f1));
      locala.vLO.setContentDescription(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, paramView, f1));
      if (locala.vLO.kv(i, 2147483647).fBm() > 1)
      {
        f1 = com.tencent.mm.cc.a.eb(this.mContext);
        float f2 = com.tencent.mm.cc.a.ax(this.mContext, (int)locala.vLO.getResources().getDimension(2131165579));
        locala.vLO.setTextSize(f1 * f2);
        locala.vLO.ar(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, paramView, locala.vLO.getTextSize()));
      }
      label545:
      label728:
      label763:
      Object localObject;
      if (this.vLB)
      {
        locala.vLO.setTextColor(this.mContext.getResources().getColor(2131101182));
        locala.vLO.setMaxLines(1);
        locala.vLO.getPaint().setFakeBoldText(true);
        String str = ((Activity)this.mContext).getIntent().getStringExtra("Contact_Distance");
        if ((!((Activity)this.mContext).getIntent().getBooleanExtra("Contact_IsLBSFriend", false)) || (bs.isNullOrNil(str))) {
          break label1514;
        }
        locala.vLS.setText(this.mContext.getString(2131757645) + str);
        locala.vLS.setVisibility(0);
        if (com.tencent.mm.storage.ai.aNc(this.piT.field_username))
        {
          locala.vLN.setVisibility(0);
          locala.vLN.setText(com.tencent.mm.openim.room.a.a.H(this.piT));
        }
        if ((!bs.isNullOrNil(this.piT.field_nickname)) && (!bs.isNullOrNil(this.piT.field_conRemark)) && (!dpw())) {
          break label1527;
        }
        locala.tqQ.setVisibility(8);
        if (bs.isNullOrNil(this.vLA)) {
          break label1603;
        }
        if (((Activity)this.mContext).getIntent().getIntExtra("Contact_Scene", -1) != 14) {
          break label1597;
        }
        i = 1;
        if (i == 0) {
          break label1603;
        }
        locala.vLP.setVisibility(0);
        paramView = this.mContext.getString(2131757629) + this.vLA;
        locala.vLP.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, paramView, locala.tqQ.getTextSize()));
        label832:
        if (((bs.isNullOrNil(this.piT.Tl())) && (bs.isNullOrNil(this.piT.field_username))) || (!com.tencent.mm.n.b.ln(this.piT.field_type)) || (com.tencent.mm.storage.ai.aNc(this.piT.field_username)) || (dpw())) {
          break label1627;
        }
        locala.tDD.setVisibility(0);
        localObject = locala.tDD;
        StringBuilder localStringBuilder = new StringBuilder().append(this.mContext.getString(2131755760));
        if (!bs.isNullOrNil(this.piT.Tl())) {
          break label1616;
        }
        paramView = this.piT.field_username;
        label950:
        ((TextView)localObject).setText(paramView);
        label964:
        if (this.piT.field_deleteFlag != 1) {
          break label1640;
        }
        locala.vLT.setVisibility(0);
        locala.vLT.setText(this.mContext.getText(2131757576));
        locala.tqQ.setVisibility(8);
        locala.vLQ.setVisibility(8);
        i = 1;
        if (i != 0) {
          ac.i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] has delete account! username:%s", new Object[] { this.piT.field_username });
        }
        if ((com.tencent.mm.n.b.ln(this.piT.field_type)) || (dpw()) || (w.xj(this.piT.field_username))) {
          break label1666;
        }
        ac.i("MicroMsg.NormalProfileHeaderPreference", "[onBindView] accept contact! username:%s", new Object[] { this.piT.field_username });
        locala.vMb.setVisibility(8);
        label1119:
        if ((com.tencent.mm.n.b.ln(this.piT.field_type)) || (!((Activity)this.mContext).getIntent().getBooleanExtra("User_Verify", false))) {
          break label1687;
        }
        i = 1;
        if (i == 0) {
          break label1693;
        }
        locala.vMb.setVisibility(0);
        label1169:
        a(locala, this.mContext, this.piT, this.mScene, p.a(this.mContext, this.piT, this.mScene));
        if (!bs.isNullOrNil(this.piT.signature)) {
          break label1706;
        }
        locala.vLQ.setVisibility(8);
        label1224:
        if (!bs.isNullOrNil(this.piT.getProvince())) {
          break label1741;
        }
        locala.vLR.setVisibility(8);
        paramView = locala.vLM;
        localObject = this.piT;
        paramView.setVisibility(0);
        if (((av)localObject).exL != 1) {
          break label1863;
        }
        paramView.setImageDrawable(com.tencent.mm.cc.a.l(this.mContext, 2131690323));
        paramView.setContentDescription(this.mContext.getString(2131762052));
        label1301:
        i = ((Activity)this.mContext).getIntent().getIntExtra("Contact_Scene", 0);
        if ((26 > i) || (i > 29)) {
          break label1920;
        }
        i = 1;
        label1337:
        if (i != 0)
        {
          locala.vLS.setVisibility(0);
          locala.tqQ.setVisibility(8);
          locala.vLS.setText(this.mContext.getString(2131757645) + str);
        }
        if (!w.xj(this.piT.field_username))
        {
          paramView = locala.vLY;
          if ((!this.piT.aaJ()) || (!com.tencent.mm.n.b.ln(this.piT.field_type))) {
            break label1926;
          }
        }
      }
      for (i = 0;; i = 8)
      {
        paramView.setVisibility(i);
        locala.vMd.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            AppMethodBeat.i(27269);
            locala.vMd.getViewTreeObserver().removeOnPreDrawListener(this);
            int[] arrayOfInt = new int[2];
            locala.vMd.getLocationOnScreen(arrayOfInt);
            int k = arrayOfInt[1];
            int m = ap.ji(NormalProfileHeaderPreference.this.mContext);
            int j = com.tencent.mm.cc.a.av(NormalProfileHeaderPreference.this.mContext, 2131166723);
            ac.i("MicroMsg.NormalProfileHeaderPreference", "actionBarHeight=%s ,statusBarHeight=%s , rootTop:%s", new Object[] { Integer.valueOf(NormalProfileHeaderPreference.a(NormalProfileHeaderPreference.this)), Integer.valueOf(m), Integer.valueOf(k) });
            int i;
            if (NormalProfileHeaderPreference.b(NormalProfileHeaderPreference.this)) {
              i = com.tencent.mm.cc.a.av(NormalProfileHeaderPreference.this.mContext, 2131166721);
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
              if (j == locala.vMd.getPaddingTop()) {
                break;
              }
              locala.vMd.setPadding(locala.vMd.getPaddingLeft(), j, locala.vMd.getPaddingRight(), locala.vMd.getPaddingBottom());
              AppMethodBeat.o(27269);
              return false;
              i = j;
              if (m > 0)
              {
                i = j;
                if (NormalProfileHeaderPreference.a(NormalProfileHeaderPreference.this) > 0) {
                  i = NormalProfileHeaderPreference.a(NormalProfileHeaderPreference.this) + com.tencent.mm.cc.a.av(NormalProfileHeaderPreference.this.mContext, 2131165289);
                }
              }
            }
            AppMethodBeat.o(27269);
            return true;
          }
        });
        AppMethodBeat.o(27278);
        return;
        label1476:
        k = 0;
        break;
        locala.vLO.setTextColor(ao.aJ(this.mContext, 2130968584));
        locala.vLO.setMaxLines(2147483647);
        break label545;
        label1514:
        locala.vLS.setVisibility(8);
        break label648;
        label1527:
        locala.tqQ.setVisibility(0);
        paramView = this.mContext.getString(2131757742) + this.piT.field_nickname;
        locala.tqQ.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, paramView, locala.tqQ.getTextSize()));
        break label728;
        label1597:
        i = 0;
        break label763;
        label1603:
        locala.vLP.setVisibility(8);
        break label832;
        label1616:
        paramView = this.piT.Tl();
        break label950;
        label1627:
        locala.tDD.setVisibility(8);
        break label964;
        label1640:
        locala.vLT.setVisibility(8);
        locala.vLQ.setVisibility(8);
        i = 0;
        break label1025;
        if (locala.vMb == null) {
          break label1119;
        }
        locala.vMb.setVisibility(8);
        break label1119;
        label1687:
        i = 0;
        break label1155;
        label1693:
        locala.vMb.setVisibility(8);
        break label1169;
        label1706:
        locala.vLQ.setText(com.tencent.mm.pluginsdk.ui.span.k.c(this.mContext, this.piT.signature));
        locala.vLQ.setVisibility(8);
        break label1224;
        label1741:
        locala.vLR.setVisibility(0);
        localObject = new StringBuilder().append(v.wm(this.piT.getProvince()));
        if (bs.isNullOrNil(this.piT.getCity())) {}
        for (paramView = "";; paramView = "  " + this.piT.getCity())
        {
          paramView = paramView;
          locala.vLR.setText(this.mContext.getString(2131757721) + paramView);
          break;
        }
        label1863:
        if (((av)localObject).exL == 2)
        {
          paramView.setImageDrawable(com.tencent.mm.cc.a.l(this.mContext, 2131690322));
          paramView.setContentDescription(this.mContext.getString(2131762051));
          break label1301;
        }
        if (((av)localObject).exL != 0) {
          break label1301;
        }
        paramView.setVisibility(8);
        break label1301;
        i = 0;
        break label1337;
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
      paramView = this.piT;
      if (paramView == null)
      {
        ac.e("MicroMsg.NormalProfileHeaderPreference", "contact is null");
        AppMethodBeat.o(27285);
        return;
      }
      if (!com.tencent.mm.n.b.ln(paramView.field_type))
      {
        if (!bs.isNullOrNil(paramView.field_encryptUsername))
        {
          a(paramView.field_encryptUsername, paramView);
          AppMethodBeat.o(27285);
          return;
        }
        a(paramView.field_username, paramView);
        AppMethodBeat.o(27285);
        return;
      }
      localObject = (PhoneNumPreference)this.lZC.aPN("contact_profile_phone");
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_Scene", this.mScene);
      localIntent.putExtra("Contact_User", paramView.field_username);
      localIntent.putExtra("view_mode", true);
      localIntent.putExtra("contact_phone_number_by_md5", ((PhoneNumPreference)localObject).Dop);
      localIntent.putExtra("contact_phone_number_list", paramView.eyl);
      com.tencent.mm.plugin.profile.b.iyx.m(localIntent, this.mContext);
      AppMethodBeat.o(27285);
      return;
    }
    if (i == 2131302424)
    {
      if (this.vHP != null)
      {
        this.vHP.dpF();
        AppMethodBeat.o(27285);
      }
    }
    else if (i == 2131298688)
    {
      localObject = this.piT.field_username;
      paramView = new Intent(this.mContext, ProfileHdHeadImg.class);
      paramView.putExtra("username", (String)localObject);
      localObject = this.mContext;
      paramView = new com.tencent.mm.hellhoundlib.b.a().ba(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.aeD(), "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "clickAvatar", "(Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject).startActivity((Intent)paramView.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/profile/ui/NormalProfileHeaderPreference", "clickAvatar", "(Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.report.service.h.wUl.f(16055, new Object[] { Integer.valueOf(c.aB(((Activity)this.mContext).getIntent())), Integer.valueOf(16), Integer.valueOf(1), this.piT.field_username });
    }
    AppMethodBeat.o(27285);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27277);
    if (this.uCg == null) {
      this.uCg = super.onCreateView(paramViewGroup);
    }
    paramViewGroup = this.uCg;
    AppMethodBeat.o(27277);
    return paramViewGroup;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(27276);
    if (this.uCg != null)
    {
      a locala = (a)this.uCg.getTag();
      if (locala.vLV != null) {
        locala.vLV.detach();
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
      final com.tencent.mm.storage.ai localai = this.piT;
      final ClipboardManager localClipboardManager = (ClipboardManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("clipboard");
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
        ((com.tencent.mm.ui.widget.b.a)localObject).JiR = new View.OnCreateContextMenuListener()
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(27270);
            paramAnonymousContextMenu.add(NormalProfileHeaderPreference.c(NormalProfileHeaderPreference.this).getString(2131755701));
            AppMethodBeat.o(27270);
          }
        };
        ((com.tencent.mm.ui.widget.b.a)localObject).ISv = new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(27271);
            if (paramAnonymousInt == 0)
            {
              localClipboardManager.setText(paramView);
              com.tencent.mm.ui.base.h.cf(NormalProfileHeaderPreference.c(NormalProfileHeaderPreference.this), NormalProfileHeaderPreference.c(NormalProfileHeaderPreference.this).getString(2131755702));
            }
            AppMethodBeat.o(27271);
          }
        };
        ((com.tencent.mm.ui.widget.b.a)localObject).IUx = new PopupWindow.OnDismissListener()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(27272);
            NormalProfileHeaderPreference.a(NormalProfileHeaderPreference.this, localTextView, localai);
            AppMethodBeat.o(27272);
          }
        };
        if (!(localTextView.getTag(2131306044) instanceof int[])) {
          break label263;
        }
        paramView = (int[])localTextView.getTag(2131306044);
        ((com.tencent.mm.ui.widget.b.a)localObject).ej(paramView[0], paramView[1]);
      }
      for (;;)
      {
        AppMethodBeat.o(27286);
        return true;
        label263:
        ((com.tencent.mm.ui.widget.b.a)localObject).ej(this.rTn, this.rTo);
      }
    }
    AppMethodBeat.o(27286);
    return false;
  }
  
  final class a
  {
    TextView tDD;
    TextView tqQ;
    private View vLG;
    private View vLH;
    private View vLI;
    private View vLJ;
    private View vLK;
    private View vLL;
    ImageView vLM;
    TextView vLN;
    MMNeat7extView vLO;
    TextView vLP;
    TextView vLQ;
    TextView vLR;
    TextView vLS;
    TextView vLT;
    ImageView vLU;
    FMessageListView vLV;
    private View vLW;
    private LinearLayout vLX;
    ImageView vLY;
    private ImageView vLZ;
    private ImageView vMa;
    View vMb;
    private ImageView vMc;
    View vMd;
    private View vMe;
    
    a(View paramView)
    {
      AppMethodBeat.i(27274);
      this.vLG = null;
      this.vLH = null;
      this.vLI = null;
      this.vLJ = null;
      this.vLK = null;
      this.vLL = null;
      this.vLM = null;
      this.tqQ = null;
      this.vLN = null;
      this.vLO = null;
      this.vLP = null;
      this.tDD = null;
      this.vLQ = null;
      this.vLR = null;
      this.vLS = null;
      this.vLT = null;
      this.vLU = null;
      this.vLX = null;
      this.vMb = paramView.findViewById(2131296322);
      this.vLV = ((FMessageListView)paramView.findViewById(2131298693));
      this.vLW = paramView.findViewById(2131298694);
      this.vLG = paramView.findViewById(2131298691);
      this.vLH = paramView.findViewById(2131298686);
      this.vLI = paramView.findViewById(2131298700);
      this.vLK = paramView.findViewById(2131298687);
      this.vLL = paramView.findViewById(2131298702);
      this.vLJ = paramView.findViewById(2131298708);
      this.vLU = ((ImageView)paramView.findViewById(2131298688));
      this.vLP = ((TextView)paramView.findViewById(2131298690));
      this.vLO = ((MMNeat7extView)paramView.findViewById(2131298698));
      this.tqQ = ((TextView)paramView.findViewById(2131298697));
      this.vLN = ((TextView)paramView.findViewById(2131298681));
      this.vLM = ((ImageView)paramView.findViewById(2131298703));
      this.tDD = ((TextView)paramView.findViewById(2131298706));
      this.vLQ = ((TextView)paramView.findViewById(2131298704));
      this.vLR = ((TextView)paramView.findViewById(2131298696));
      this.vLS = ((TextView)paramView.findViewById(2131298692));
      this.vLT = ((TextView)paramView.findViewById(2131298705));
      this.vLY = ((ImageView)paramView.findViewById(2131298685));
      this.vLZ = ((ImageView)paramView.findViewById(2131298683));
      this.vMa = ((ImageView)paramView.findViewById(2131298684));
      this.vMc = ((ImageView)paramView.findViewById(2131298590));
      this.vMd = paramView.findViewById(2131298699);
      this.vMe = paramView.findViewById(2131298689);
      this.vLX = ((LinearLayout)paramView.findViewById(2131298695));
      this.vMb.findViewById(2131303982).setOnClickListener(NormalProfileHeaderPreference.this);
      this.vMb.findViewById(2131302424).setOnClickListener(NormalProfileHeaderPreference.this);
      this.vLL.setOnClickListener(NormalProfileHeaderPreference.this);
      this.vLJ.setOnClickListener(NormalProfileHeaderPreference.this);
      this.vLU.setOnClickListener(NormalProfileHeaderPreference.this);
      this.vLG.setOnClickListener(NormalProfileHeaderPreference.this);
      this.vLH.setOnClickListener(NormalProfileHeaderPreference.this);
      this.vLI.setOnClickListener(NormalProfileHeaderPreference.this);
      this.vLK.setOnClickListener(NormalProfileHeaderPreference.this);
      this.tDD.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(27273);
          NormalProfileHeaderPreference.this.rTn = ((int)paramAnonymousMotionEvent.getRawX());
          NormalProfileHeaderPreference.this.rTo = ((int)paramAnonymousMotionEvent.getRawY());
          paramAnonymousView.setTag(2131306044, new int[] { NormalProfileHeaderPreference.this.rTn, NormalProfileHeaderPreference.this.rTo });
          AppMethodBeat.o(27273);
          return false;
        }
      });
      this.tDD.setOnLongClickListener(NormalProfileHeaderPreference.this);
      this.vMc.setOnClickListener(NormalProfileHeaderPreference.this);
      AppMethodBeat.o(27274);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference
 * JD-Core Version:    0.7.0.1
 */