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
import com.tencent.mm.plugin.profile.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashSet;

public class PhoneNumPreference
  extends Preference
  implements View.OnClickListener
{
  public String ETv;
  public String ETw;
  ProfileMobilePhoneView FgH;
  public Intent intent;
  public f mzx;
  public am pMt;
  private View vET;
  
  public PhoneNumPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PhoneNumPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static String b(String paramString, am paramam)
  {
    AppMethodBeat.i(31899);
    if (paramam.ePJ == null)
    {
      AppMethodBeat.o(31899);
      return null;
    }
    HashSet localHashSet = new HashSet();
    if (paramString != null) {
      localHashSet.add(paramString);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = com.tencent.mm.o.a.e(paramam);
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i].trim();
        if ((!localHashSet.contains(str)) && (!bt.isNullOrNil(str))) {
          localStringBuilder.append(str).append(com.tencent.mm.o.a.d(paramam));
        }
        localHashSet.add(str);
        i += 1;
      }
    }
    if (localStringBuilder.length() > 1) {
      localStringBuilder.subSequence(0, localStringBuilder.length() - 1);
    }
    ad.i("MicroMsg.PhoneNumPreference", "[filterPhoneList] phoneNumberByMD5:%s phoneList:%s", new Object[] { paramString, paramam.ePJ });
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(31899);
    return paramString;
  }
  
  public final void feO()
  {
    AppMethodBeat.i(31900);
    if ((this.pMt == null) || (!com.tencent.mm.o.b.lM(this.pMt.field_type)) || (am.aSQ(this.pMt.field_username)) || ((bt.isNullOrNil(this.ETv)) && (bt.isNullOrNil(this.ETw))))
    {
      this.mzx.cP("contact_profile_phone", true);
      AppMethodBeat.o(31900);
      return;
    }
    this.mzx.cP("contact_profile_phone", false);
    AppMethodBeat.o(31900);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(31898);
    super.onBindView(paramView);
    this.FgH.dBj();
    AppMethodBeat.o(31898);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(31901);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/PhoneNumPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    g.yhR.f(16055, new Object[] { Integer.valueOf(c.aG(this.intent)), Integer.valueOf(17), Integer.valueOf(1), this.pMt.field_username });
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/preference/PhoneNumPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(31901);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31897);
    if (this.vET == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
      localViewGroup.removeAllViews();
      ProfileMobilePhoneView localProfileMobilePhoneView = new ProfileMobilePhoneView(paramViewGroup.getContext(), this);
      this.FgH = localProfileMobilePhoneView;
      localViewGroup.addView(localProfileMobilePhoneView, new AbsListView.LayoutParams(-1, -2));
      this.FgH.pMt = this.pMt;
      this.FgH.lt(this.ETv, this.ETw);
      this.vET = paramViewGroup;
    }
    paramViewGroup = this.vET;
    AppMethodBeat.o(31897);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.PhoneNumPreference
 * JD-Core Version:    0.7.0.1
 */