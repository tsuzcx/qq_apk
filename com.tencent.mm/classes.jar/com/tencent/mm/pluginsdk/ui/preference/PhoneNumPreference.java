package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashSet;

public class PhoneNumPreference
  extends Preference
  implements View.OnClickListener
{
  public String FlQ;
  public String FlR;
  ProfileMobilePhoneView Fzf;
  public Intent intent;
  public f mEx;
  public an pSY;
  private View vQX;
  
  public PhoneNumPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PhoneNumPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static String b(String paramString, an paraman)
  {
    AppMethodBeat.i(31899);
    if (paraman.eRu == null)
    {
      AppMethodBeat.o(31899);
      return null;
    }
    HashSet localHashSet = new HashSet();
    if (paramString != null) {
      localHashSet.add(paramString);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = com.tencent.mm.contact.a.e(paraman);
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i].trim();
        if ((!localHashSet.contains(str)) && (!bu.isNullOrNil(str))) {
          localStringBuilder.append(str).append(com.tencent.mm.contact.a.d(paraman));
        }
        localHashSet.add(str);
        i += 1;
      }
    }
    if (localStringBuilder.length() > 1) {
      localStringBuilder.subSequence(0, localStringBuilder.length() - 1);
    }
    ae.i("MicroMsg.PhoneNumPreference", "[filterPhoneList] phoneNumberByMD5:%s phoneList:%s", new Object[] { paramString, paraman.eRu });
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(31899);
    return paramString;
  }
  
  public final void fiE()
  {
    AppMethodBeat.i(31900);
    if ((this.pSY == null) || (!com.tencent.mm.contact.c.lO(this.pSY.field_type)) || (an.aUq(this.pSY.field_username)) || ((bu.isNullOrNil(this.FlQ)) && (bu.isNullOrNil(this.FlR))))
    {
      this.mEx.cT("contact_profile_phone", true);
      AppMethodBeat.o(31900);
      return;
    }
    this.mEx.cT("contact_profile_phone", false);
    AppMethodBeat.o(31900);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(31898);
    super.onBindView(paramView);
    this.Fzf.dEA();
    AppMethodBeat.o(31898);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(31901);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/PhoneNumPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    g.yxI.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aH(this.intent)), Integer.valueOf(17), Integer.valueOf(1), this.pSY.field_username });
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/preference/PhoneNumPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(31901);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31897);
    if (this.vQX == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
      localViewGroup.removeAllViews();
      ProfileMobilePhoneView localProfileMobilePhoneView = new ProfileMobilePhoneView(paramViewGroup.getContext(), this);
      this.Fzf = localProfileMobilePhoneView;
      localViewGroup.addView(localProfileMobilePhoneView, new AbsListView.LayoutParams(-1, -2));
      this.Fzf.pSY = this.pSY;
      this.Fzf.lA(this.FlQ, this.FlR);
      this.vQX = paramViewGroup;
    }
    paramViewGroup = this.vQX;
    AppMethodBeat.o(31897);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.PhoneNumPreference
 * JD-Core Version:    0.7.0.1
 */