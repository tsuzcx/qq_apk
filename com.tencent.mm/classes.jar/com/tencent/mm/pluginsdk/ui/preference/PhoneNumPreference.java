package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.profile.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashSet;

public class PhoneNumPreference
  extends Preference
  implements View.OnClickListener
{
  public String KcI;
  public String KcJ;
  ProfileMobilePhoneView Kqe;
  public Intent intent;
  public f nRm;
  public as rjX;
  private View zlc;
  
  public PhoneNumPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PhoneNumPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static String b(String paramString, as paramas)
  {
    AppMethodBeat.i(31899);
    if (paramas.fuX == null)
    {
      AppMethodBeat.o(31899);
      return null;
    }
    HashSet localHashSet = new HashSet();
    if (paramString != null) {
      localHashSet.add(paramString);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = com.tencent.mm.contact.a.e(paramas);
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i].trim();
        if ((!localHashSet.contains(str)) && (!Util.isNullOrNil(str))) {
          localStringBuilder.append(str).append(com.tencent.mm.contact.a.d(paramas));
        }
        localHashSet.add(str);
        i += 1;
      }
    }
    if (localStringBuilder.length() > 1) {
      localStringBuilder.subSequence(0, localStringBuilder.length() - 1);
    }
    Log.i("MicroMsg.PhoneNumPreference", "[filterPhoneList] phoneNumberByMD5:%s phoneList:%s", new Object[] { paramString, paramas.fuX });
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(31899);
    return paramString;
  }
  
  public final void grR()
  {
    AppMethodBeat.i(31900);
    if ((this.rjX == null) || (!c.oR(this.rjX.field_type)) || (as.bjp(this.rjX.field_username)) || ((Util.isNullOrNil(this.KcI)) && (Util.isNullOrNil(this.KcJ))))
    {
      this.nRm.jdMethod_do("contact_profile_phone", true);
      AppMethodBeat.o(31900);
      return;
    }
    this.nRm.jdMethod_do("contact_profile_phone", false);
    AppMethodBeat.o(31900);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(31898);
    super.onBindView(paramView);
    this.Kqe.eEV();
    AppMethodBeat.o(31898);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(31901);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/PhoneNumPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    h.CyF.a(16055, new Object[] { Integer.valueOf(d.aP(this.intent)), Integer.valueOf(17), Integer.valueOf(1), this.rjX.field_username });
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/preference/PhoneNumPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(31901);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31897);
    if (this.zlc == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
      localViewGroup.removeAllViews();
      ProfileMobilePhoneView localProfileMobilePhoneView = new ProfileMobilePhoneView(paramViewGroup.getContext(), this);
      this.Kqe = localProfileMobilePhoneView;
      localViewGroup.addView(localProfileMobilePhoneView, new AbsListView.LayoutParams(-1, -2));
      this.Kqe.rjX = this.rjX;
      this.Kqe.my(this.KcI, this.KcJ);
      this.zlc = paramViewGroup;
    }
    paramViewGroup = this.zlc;
    AppMethodBeat.o(31897);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.PhoneNumPreference
 * JD-Core Version:    0.7.0.1
 */