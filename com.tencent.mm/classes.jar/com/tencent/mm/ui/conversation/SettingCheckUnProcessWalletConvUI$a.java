package com.tencent.mm.ui.conversation;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.util.HashMap;
import java.util.List;

final class SettingCheckUnProcessWalletConvUI$a
  extends BaseAdapter
{
  private final int AhL;
  private final int AhM;
  private float zta;
  protected float ztb;
  private float ztc;
  private ColorStateList[] ztd;
  private HashMap<String, SettingCheckUnProcessWalletConvUI.a.a> zte;
  
  public SettingCheckUnProcessWalletConvUI$a(SettingCheckUnProcessWalletConvUI paramSettingCheckUnProcessWalletConvUI)
  {
    AppMethodBeat.i(34617);
    this.ztd = new ColorStateList[5];
    this.zta = -1.0F;
    this.ztb = -1.0F;
    this.ztc = -1.0F;
    this.ztd[0] = a.l(paramSettingCheckUnProcessWalletConvUI, 2131690168);
    this.ztd[1] = a.l(paramSettingCheckUnProcessWalletConvUI, 2131690773);
    this.ztd[3] = a.l(paramSettingCheckUnProcessWalletConvUI, 2131690322);
    this.ztd[2] = a.l(paramSettingCheckUnProcessWalletConvUI, 2131690770);
    this.ztd[2] = a.l(paramSettingCheckUnProcessWalletConvUI, 2131690770);
    this.ztd[4] = a.l(paramSettingCheckUnProcessWalletConvUI, 2131690210);
    if (a.gt(paramSettingCheckUnProcessWalletConvUI)) {
      this.AhM = paramSettingCheckUnProcessWalletConvUI.getResources().getDimensionPixelSize(2131427552);
    }
    for (this.AhL = paramSettingCheckUnProcessWalletConvUI.getResources().getDimensionPixelSize(2131427554);; this.AhL = paramSettingCheckUnProcessWalletConvUI.getResources().getDimensionPixelSize(2131427555))
    {
      this.zta = a.ao(paramSettingCheckUnProcessWalletConvUI, 2131427809);
      this.ztb = a.ao(paramSettingCheckUnProcessWalletConvUI, 2131427758);
      this.ztc = a.ao(paramSettingCheckUnProcessWalletConvUI, 2131427862);
      this.zte = new HashMap();
      AppMethodBeat.o(34617);
      return;
      this.AhM = paramSettingCheckUnProcessWalletConvUI.getResources().getDimensionPixelSize(2131427551);
    }
  }
  
  private static int GH(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(34621);
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramString).intValue();
      AppMethodBeat.o(34621);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  private static String atE(String paramString)
  {
    AppMethodBeat.i(34624);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kx(paramString);
      AppMethodBeat.o(34624);
      return paramString;
    }
    AppMethodBeat.o(34624);
    return null;
  }
  
  private CharSequence c(ak paramak, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(34623);
    if ((!ah.isNullOrNil(paramak.field_editingMsg)) && ((paramak.field_atCount <= 0) || (paramak.field_unReadCount <= 0)))
    {
      localObject1 = new SpannableStringBuilder(this.AlZ.getString(2131301401));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject1).append(" ").append(j.b(this.AlZ, paramak.field_editingMsg, paramInt));
      AppMethodBeat.o(34623);
      return localObject1;
    }
    Object localObject1 = paramak.field_digest;
    if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  ")))
    {
      paramak = new SpannableString(j.e(this.AlZ, (CharSequence)localObject1, paramInt));
      AppMethodBeat.o(34623);
      return paramak;
    }
    localObject1 = paramak.field_username;
    int i;
    if (((String)localObject1).equals("qqmail"))
    {
      aw.aaz();
      if (ah.g((Integer)c.Ru().get(17, null)) == 1) {}
      for (i = 1; i == 0; i = 0)
      {
        paramak = this.AlZ.getString(2131303374);
        AppMethodBeat.o(34623);
        return paramak;
      }
    }
    if (((String)localObject1).equals("tmessage"))
    {
      aw.aaz();
      localObject1 = c.YI().TL("@t.qq.com");
      if ((localObject1 != null) && (((bq)localObject1).isEnable())) {}
      for (i = 1; i == 0; i = 0)
      {
        paramak = this.AlZ.getString(2131303374);
        AppMethodBeat.o(34623);
        return paramak;
      }
    }
    String str1;
    if ((paramak.field_msgType != null) && ((paramak.field_msgType.equals("47")) || (paramak.field_msgType.equals("1048625"))))
    {
      localObject1 = atE(paramak.field_digest);
      str1 = "";
      if (localObject1 != null)
      {
        paramak = "[" + (String)localObject1 + "]";
        AppMethodBeat.o(34623);
        return paramak;
      }
      localObject1 = str1;
      if (paramak.field_digest != null)
      {
        localObject1 = str1;
        if (paramak.field_digest.contains(":"))
        {
          str1 = paramak.field_digest.substring(0, paramak.field_digest.indexOf(":"));
          String str2 = atE(paramak.field_digest.substring(paramak.field_digest.indexOf(":") + 1).replace(" ", ""));
          localObject1 = str1;
          if (str2 != null)
          {
            paramak = "[" + str2 + "]";
            if (ah.isNullOrNil(str1))
            {
              AppMethodBeat.o(34623);
              return paramak;
            }
            paramak = str1 + ": " + paramak;
            AppMethodBeat.o(34623);
            return paramak;
          }
        }
      }
      str1 = this.AlZ.getString(2131296915);
      if (ah.isNullOrNil((String)localObject1))
      {
        localObject1 = str1;
        paramak.jW((String)localObject1);
      }
    }
    else
    {
      if (ah.isNullOrNil(paramak.field_digest)) {
        break label775;
      }
      if (ah.isNullOrNil(paramak.field_digestUser)) {
        break label764;
      }
      if ((paramak.field_isSend != 0) || (!com.tencent.mm.model.t.lA(paramak.field_username))) {
        break label752;
      }
      localObject1 = s.getDisplayName(paramak.field_digestUser, paramak.field_username);
    }
    label752:
    label764:
    Object localObject2;
    for (;;)
    {
      try
      {
        localObject1 = String.format(paramak.field_digest, new Object[] { localObject1 });
        str1 = ((String)localObject1).replace('\n', ' ');
        if ((paramak.field_atCount <= 0) || (paramak.field_unReadCount <= 0)) {
          break label806;
        }
        paramak = new SpannableStringBuilder(this.AlZ.getString(2131301397));
        paramak.setSpan(new ForegroundColorSpan(-5569532), 0, paramak.length(), 33);
        paramak.append(" ").append(j.b(this.AlZ, str1, paramInt));
        AppMethodBeat.o(34623);
        return paramak;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + str1;
      break;
      localObject1 = s.nE(paramak.field_digestUser);
      continue;
      localObject1 = paramak.field_digest;
      continue;
      label775:
      localObject2 = com.tencent.mm.booter.notification.a.h.a(paramak.field_isSend, paramak.field_username, paramak.field_content, GH(paramak.field_msgType), this.AlZ);
    }
    label806:
    if ((paramBoolean) && (paramak.field_unReadCount > 1)) {
      localObject2 = this.AlZ.getString(2131301400, new Object[] { Integer.valueOf(paramak.field_unReadCount), str1 });
    }
    for (;;)
    {
      paramak = j.b(this.AlZ, (CharSequence)localObject2, paramInt);
      AppMethodBeat.o(34623);
      return paramak;
      localObject2 = str1;
      if (paramak.field_unReadCount > 1)
      {
        localObject2 = str1;
        if (com.tencent.mm.model.t.ot(paramak.field_parentRef)) {
          localObject2 = this.AlZ.getString(2131301400, new Object[] { Integer.valueOf(paramak.field_unReadCount), str1 });
        }
      }
    }
  }
  
  private CharSequence h(ak paramak)
  {
    AppMethodBeat.i(34622);
    if (paramak.field_status == 1)
    {
      paramak = this.AlZ.getString(2131301428);
      AppMethodBeat.o(34622);
      return paramak;
    }
    if (paramak.field_conversationTime == 9223372036854775807L)
    {
      AppMethodBeat.o(34622);
      return "";
    }
    paramak = com.tencent.mm.pluginsdk.f.h.c(this.AlZ, paramak.field_conversationTime, true);
    AppMethodBeat.o(34622);
    return paramak;
  }
  
  public final ak QE(int paramInt)
  {
    AppMethodBeat.i(34619);
    Object localObject = (String)SettingCheckUnProcessWalletConvUI.d(this.AlZ).get(paramInt);
    aw.aaz();
    localObject = c.YF().arH((String)localObject);
    AppMethodBeat.o(34619);
    return localObject;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(34618);
    int i = SettingCheckUnProcessWalletConvUI.d(this.AlZ).size();
    AppMethodBeat.o(34618);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34620);
    if (paramView == null)
    {
      paramViewGroup = new SettingCheckUnProcessWalletConvUI.a.b(this, (byte)0);
      if (a.gt(this.AlZ))
      {
        paramView = View.inflate(this.AlZ, 2130969275, null);
        paramViewGroup.egq = ((ImageView)paramView.findViewById(2131821210));
        paramViewGroup.zti = ((NoMeasuredTextView)paramView.findViewById(2131823254));
        paramViewGroup.Aii = ((NoMeasuredTextView)paramView.findViewById(2131821550));
        paramViewGroup.ztj = ((NoMeasuredTextView)paramView.findViewById(2131823255));
        paramViewGroup.ztk = ((NoMeasuredTextView)paramView.findViewById(2131823256));
        paramViewGroup.jSi = ((TextView)paramView.findViewById(2131821087));
        paramViewGroup.jSi.setBackgroundResource(com.tencent.mm.ui.tools.t.iF(this.AlZ));
        paramViewGroup.ztl = ((ImageView)paramView.findViewById(2131823258));
        paramViewGroup.ztn = paramView.findViewById(2131823253);
        paramViewGroup.ztm = ((ImageView)paramView.findViewById(2131823259));
        paramViewGroup.Aij = ((ImageView)paramView.findViewById(2131823260));
        paramView.setTag(paramViewGroup);
        paramViewGroup.ztk.setTextSize(0, this.ztb);
        paramViewGroup.ztj.setTextSize(0, this.ztc);
        paramViewGroup.zti.setTextSize(0, this.zta);
        paramViewGroup.Aii.setTextSize(0, this.ztb);
        paramViewGroup.ztk.setTextColor(this.ztd[0]);
        paramViewGroup.ztj.setTextColor(this.ztd[4]);
        paramViewGroup.zti.setTextColor(this.ztd[3]);
        paramViewGroup.Aii.setTextColor(this.ztd[0]);
        paramViewGroup.ztk.setShouldEllipsize(true);
        paramViewGroup.ztj.setShouldEllipsize(false);
        paramViewGroup.zti.setShouldEllipsize(true);
        paramViewGroup.Aii.setShouldEllipsize(true);
        paramViewGroup.ztj.setGravity(5);
      }
    }
    ak localak;
    for (;;)
    {
      localak = QE(paramInt);
      if (localak != null) {
        break label384;
      }
      AppMethodBeat.o(34620);
      return paramView;
      paramView = View.inflate(this.AlZ, 2130969274, null);
      break;
      paramViewGroup = (SettingCheckUnProcessWalletConvUI.a.b)paramView.getTag();
    }
    label384:
    a.b.c(paramViewGroup.egq, localak.field_username);
    paramViewGroup.egq.getDrawable();
    String str2 = localak.field_username;
    Object localObject2 = (SettingCheckUnProcessWalletConvUI.a.a)this.zte.get(str2);
    Object localObject1 = localObject2;
    boolean bool;
    if (localObject2 == null)
    {
      localObject2 = new SettingCheckUnProcessWalletConvUI.a.a(this, (byte)0);
      ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).AhY = -1;
      ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).AhX = -1;
      ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).Aid = false;
      ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).Aif = false;
      ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).Aie = false;
      ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).muU = com.tencent.mm.model.t.lA(localak.field_username);
      if ((((SettingCheckUnProcessWalletConvUI.a.a)localObject2).muU) && (((SettingCheckUnProcessWalletConvUI.a.a)localObject2).Aie) && (localak.field_unReadCount > 0))
      {
        bool = true;
        ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).Aic = bool;
        ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).kwo = 0;
        if ((GH(localak.field_msgType) == 34) && (localak.field_isSend == 0) && (!ah.isNullOrNil(localak.field_content)))
        {
          String str1 = localak.field_content;
          if (!str2.equals("qmessage"))
          {
            localObject1 = str1;
            if (!str2.equals("floatbottle")) {}
          }
          else
          {
            String[] arrayOfString = str1.split(":");
            localObject1 = str1;
            if (arrayOfString != null)
            {
              localObject1 = str1;
              if (arrayOfString.length > 3) {
                localObject1 = arrayOfString[1] + ":" + arrayOfString[2] + ":" + arrayOfString[3];
              }
            }
          }
          if (!new p((String)localObject1).fXr) {
            ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).kwo = 1;
          }
        }
        localObject1 = s.nE(str2);
        if ((!((SettingCheckUnProcessWalletConvUI.a.a)localObject2).muU) || (localObject1 != null)) {
          break label1237;
        }
        ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).nickName = this.AlZ.getString(2131298302);
        label724:
        ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).AhU = h(localak);
        ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).AhV = c(localak, (int)paramViewGroup.ztk.getTextSize(), ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).Aic);
        ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).Aig = localak.field_attrflag;
      }
    }
    else
    {
      switch (localak.field_status)
      {
      case 3: 
      case 4: 
      default: 
        paramInt = -1;
        label814:
        ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).AhW = paramInt;
        ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).AhZ = com.tencent.mm.model.t.a(localak);
        aw.aaz();
        ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).ztf = c.YF().g(localak);
        ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).Aia = false;
        ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).Aib = aa.dsC();
        this.zte.put(str2, localObject2);
        localObject1 = localObject2;
        if (((SettingCheckUnProcessWalletConvUI.a.a)localObject1).AhU == null) {
          ((SettingCheckUnProcessWalletConvUI.a.a)localObject1).AhU = h(localak);
        }
        if ((((SettingCheckUnProcessWalletConvUI.a.a)localObject1).Aic) || (com.tencent.mm.model.t.ot(localak.field_parentRef)))
        {
          paramViewGroup.ztk.setTextColor(this.ztd[0]);
          label930:
          if (!str2.toLowerCase().endsWith("@t.qq.com")) {
            break label1308;
          }
          paramViewGroup.zti.setCompoundRightDrawablesWithIntrinsicBounds(2130839141);
          paramViewGroup.zti.setDrawRightDrawable(true);
          label961:
          paramInt = ((SettingCheckUnProcessWalletConvUI.a.a)localObject1).AhW;
          if (paramInt == -1) {
            break label1319;
          }
          paramViewGroup.ztk.setCompoundLeftDrawablesWithIntrinsicBounds(paramInt);
          paramViewGroup.ztk.setDrawLeftDrawable(true);
          label988:
          paramViewGroup.zti.setText(((SettingCheckUnProcessWalletConvUI.a.a)localObject1).nickName);
          paramViewGroup.Aii.setVisibility(8);
          localObject2 = paramViewGroup.ztj.getLayoutParams();
          if (((SettingCheckUnProcessWalletConvUI.a.a)localObject1).AhU.length() <= 9) {
            break label1330;
          }
          if (((ViewGroup.LayoutParams)localObject2).width != this.AhM)
          {
            ((ViewGroup.LayoutParams)localObject2).width = this.AhM;
            paramViewGroup.ztj.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          label1063:
          ab.v("MicroMsg.SettingCheckUnProcessWalletConvUI", "layout update time width %d", new Object[] { Integer.valueOf(((ViewGroup.LayoutParams)localObject2).width) });
          paramViewGroup.ztj.setText(((SettingCheckUnProcessWalletConvUI.a.a)localObject1).AhU);
          paramViewGroup.ztk.setText(((SettingCheckUnProcessWalletConvUI.a.a)localObject1).AhV);
          if ((!((SettingCheckUnProcessWalletConvUI.a.a)localObject1).muU) || (!((SettingCheckUnProcessWalletConvUI.a.a)localObject1).Aie)) {
            break label1363;
          }
          paramViewGroup.ztl.setVisibility(0);
          label1135:
          a.b.c(paramViewGroup.egq, str2);
          if ((!((SettingCheckUnProcessWalletConvUI.a.a)localObject1).AhZ) && (((SettingCheckUnProcessWalletConvUI.a.a)localObject1).ztf) && (aw.RG()))
          {
            aw.aaz();
            c.YF().f(localak);
          }
          if ((!((SettingCheckUnProcessWalletConvUI.a.a)localObject1).ztf) || (localak.field_conversationTime == -1L)) {
            break label1394;
          }
          paramView.findViewById(2131823252).setBackgroundResource(2130838444);
        }
        break;
      }
    }
    for (;;)
    {
      paramViewGroup.ztm.setVisibility(8);
      AppMethodBeat.o(34620);
      return paramView;
      bool = false;
      break;
      label1237:
      ((SettingCheckUnProcessWalletConvUI.a.a)localObject2).nickName = j.b(this.AlZ, s.nE(str2), paramViewGroup.zti.getTextSize());
      break label724;
      paramInt = -1;
      break label814;
      paramInt = 2131231716;
      break label814;
      paramInt = -1;
      break label814;
      paramInt = 2131231715;
      break label814;
      paramViewGroup.ztk.setTextColor(this.ztd[localObject1.kwo]);
      break label930;
      label1308:
      paramViewGroup.zti.setDrawRightDrawable(false);
      break label961;
      label1319:
      paramViewGroup.ztk.setDrawLeftDrawable(false);
      break label988;
      label1330:
      if (((ViewGroup.LayoutParams)localObject2).width == this.AhL) {
        break label1063;
      }
      ((ViewGroup.LayoutParams)localObject2).width = this.AhL;
      paramViewGroup.ztj.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break label1063;
      label1363:
      if (((SettingCheckUnProcessWalletConvUI.a.a)localObject1).Aia)
      {
        paramViewGroup.ztl.setVisibility(0);
        break label1135;
      }
      paramViewGroup.ztl.setVisibility(8);
      break label1135;
      label1394:
      paramView.findViewById(2131823252).setBackgroundResource(2130838445);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI.a
 * JD-Core Version:    0.7.0.1
 */