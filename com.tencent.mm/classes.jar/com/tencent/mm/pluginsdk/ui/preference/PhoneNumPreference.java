package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.n.a;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.profile.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashSet;

public class PhoneNumPreference
  extends Preference
  implements View.OnClickListener
{
  ProfileMobilePhoneView DBA;
  public String Dop;
  public String Doq;
  public Intent intent;
  public f lZC;
  public ai piT;
  private View uCg;
  
  public PhoneNumPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PhoneNumPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static String b(String paramString, ai paramai)
  {
    AppMethodBeat.i(31899);
    if (paramai.eyl == null)
    {
      AppMethodBeat.o(31899);
      return null;
    }
    HashSet localHashSet = new HashSet();
    if (paramString != null) {
      localHashSet.add(paramString);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = a.e(paramai);
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i].trim();
        if ((!localHashSet.contains(str)) && (!bs.isNullOrNil(str))) {
          localStringBuilder.append(str).append(a.d(paramai));
        }
        localHashSet.add(str);
        i += 1;
      }
    }
    if (localStringBuilder.length() > 1) {
      localStringBuilder.subSequence(0, localStringBuilder.length() - 1);
    }
    ac.i("MicroMsg.PhoneNumPreference", "[filterPhoneList] phoneNumberByMD5:%s phoneList:%s", new Object[] { paramString, paramai.eyl });
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(31899);
    return paramString;
  }
  
  public final void ePM()
  {
    AppMethodBeat.i(31900);
    if ((this.piT == null) || (!b.ln(this.piT.field_type)) || (ai.aNc(this.piT.field_username)) || ((bs.isNullOrNil(this.Dop)) && (bs.isNullOrNil(this.Doq))))
    {
      this.lZC.cK("contact_profile_phone", true);
      AppMethodBeat.o(31900);
      return;
    }
    this.lZC.cK("contact_profile_phone", false);
    AppMethodBeat.o(31900);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(31898);
    super.onBindView(paramView);
    this.DBA.dqG();
    AppMethodBeat.o(31898);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(31901);
    h.wUl.f(16055, new Object[] { Integer.valueOf(c.aB(this.intent)), Integer.valueOf(17), Integer.valueOf(1), this.piT.field_username });
    AppMethodBeat.o(31901);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31897);
    if (this.uCg == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
      localViewGroup.removeAllViews();
      ProfileMobilePhoneView localProfileMobilePhoneView = new ProfileMobilePhoneView(paramViewGroup.getContext(), this);
      this.DBA = localProfileMobilePhoneView;
      localViewGroup.addView(localProfileMobilePhoneView, new AbsListView.LayoutParams(-1, -2));
      this.DBA.piT = this.piT;
      this.DBA.kW(this.Dop, this.Doq);
      this.uCg = paramViewGroup;
    }
    paramViewGroup = this.uCg;
    AppMethodBeat.o(31897);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.PhoneNumPreference
 * JD-Core Version:    0.7.0.1
 */