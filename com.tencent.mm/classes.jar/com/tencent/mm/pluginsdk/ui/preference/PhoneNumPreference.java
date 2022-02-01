package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.n.a;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.profile.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashSet;

public class PhoneNumPreference
  extends Preference
  implements View.OnClickListener
{
  public String BVY;
  public String BVZ;
  ProfileMobilePhoneView Cjj;
  public Intent intent;
  public f lxI;
  public af oFt;
  private View ttN;
  
  public PhoneNumPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PhoneNumPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static String b(String paramString, af paramaf)
  {
    AppMethodBeat.i(31899);
    if (paramaf.evO == null)
    {
      AppMethodBeat.o(31899);
      return null;
    }
    HashSet localHashSet = new HashSet();
    if (paramString != null) {
      localHashSet.add(paramString);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = a.e(paramaf);
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i].trim();
        if ((!localHashSet.contains(str)) && (!bt.isNullOrNil(str))) {
          localStringBuilder.append(str).append(a.d(paramaf));
        }
        localHashSet.add(str);
        i += 1;
      }
    }
    if (localStringBuilder.length() > 1) {
      localStringBuilder.subSequence(0, localStringBuilder.length() - 1);
    }
    ad.i("MicroMsg.PhoneNumPreference", "[filterPhoneList] phoneNumberByMD5:%s phoneList:%s", new Object[] { paramString, paramaf.evO });
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(31899);
    return paramString;
  }
  
  public final void eAs()
  {
    AppMethodBeat.i(31900);
    if ((this.oFt == null) || (!b.ls(this.oFt.field_type)) || (af.aHH(this.oFt.field_username)) || ((bt.isNullOrNil(this.BVY)) && (bt.isNullOrNil(this.BVZ))))
    {
      this.lxI.cE("contact_profile_phone", true);
      AppMethodBeat.o(31900);
      return;
    }
    this.lxI.cE("contact_profile_phone", false);
    AppMethodBeat.o(31900);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(31898);
    super.onBindView(paramView);
    this.Cjj.dcY();
    AppMethodBeat.o(31898);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(31901);
    h.vKh.f(16055, new Object[] { Integer.valueOf(c.aA(this.intent)), Integer.valueOf(17), Integer.valueOf(1), this.oFt.field_username });
    AppMethodBeat.o(31901);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31897);
    if (this.ttN == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
      localViewGroup.removeAllViews();
      ProfileMobilePhoneView localProfileMobilePhoneView = new ProfileMobilePhoneView(paramViewGroup.getContext(), this);
      this.Cjj = localProfileMobilePhoneView;
      localViewGroup.addView(localProfileMobilePhoneView, new AbsListView.LayoutParams(-1, -2));
      this.Cjj.oFt = this.oFt;
      this.Cjj.kz(this.BVY, this.BVZ);
      this.ttN = paramViewGroup;
    }
    paramViewGroup = this.ttN;
    AppMethodBeat.o(31897);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.PhoneNumPreference
 * JD-Core Version:    0.7.0.1
 */