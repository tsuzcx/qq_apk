package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.profile.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashSet;

public class PhoneNumPreference
  extends Preference
  implements View.OnClickListener
{
  public f iLA;
  public Intent intent;
  public ad lpe;
  private View ozm;
  public String vRr;
  public String vRs;
  ProfileMobilePhoneView wbD;
  
  public PhoneNumPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PhoneNumPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static String hX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(154678);
    if (paramString2 == null)
    {
      AppMethodBeat.o(154678);
      return null;
    }
    HashSet localHashSet = new HashSet();
    if (paramString1 != null) {
      localHashSet.add(paramString1);
    }
    String[] arrayOfString = paramString2.split(",");
    StringBuilder localStringBuilder = new StringBuilder();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i].trim();
      if ((!localHashSet.contains(str)) && (!bo.isNullOrNil(str))) {
        localStringBuilder.append(str).append(",");
      }
      localHashSet.add(str);
      i += 1;
    }
    if (localStringBuilder.length() > 1) {
      localStringBuilder.subSequence(0, localStringBuilder.length() - 1);
    }
    ab.i("MicroMsg.PhoneNumPreference", "[filterPhoneList] phoneNumberByMD5:%s phoneList:%s", new Object[] { paramString1, paramString2 });
    paramString1 = localStringBuilder.toString();
    AppMethodBeat.o(154678);
    return paramString1;
  }
  
  public final void dpl()
  {
    AppMethodBeat.i(28112);
    if ((this.lpe == null) || (!a.je(this.lpe.field_type)) || (ad.arf(this.lpe.field_username)) || ((bo.isNullOrNil(this.vRr)) && (bo.isNullOrNil(this.vRs))))
    {
      this.iLA.cl("contact_profile_phone", true);
      AppMethodBeat.o(28112);
      return;
    }
    this.iLA.cl("contact_profile_phone", false);
    AppMethodBeat.o(28112);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(28111);
    super.onBindView(paramView);
    this.wbD.ccG();
    AppMethodBeat.o(28111);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(153754);
    h.qsU.e(16055, new Object[] { Integer.valueOf(c.al(this.intent)), Integer.valueOf(17), Integer.valueOf(1), this.lpe.field_username });
    AppMethodBeat.o(153754);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(28110);
    if (this.ozm == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
      localViewGroup.removeAllViews();
      ProfileMobilePhoneView localProfileMobilePhoneView = new ProfileMobilePhoneView(paramViewGroup.getContext(), this);
      this.wbD = localProfileMobilePhoneView;
      localViewGroup.addView(localProfileMobilePhoneView, new AbsListView.LayoutParams(-1, -2));
      this.wbD.hT(this.vRr, this.vRs);
      this.ozm = paramViewGroup;
    }
    paramViewGroup = this.ozm;
    AppMethodBeat.o(28110);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.PhoneNumPreference
 * JD-Core Version:    0.7.0.1
 */