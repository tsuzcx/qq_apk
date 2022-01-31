package com.tencent.mm.plugin.profile.ui.newbizinfo;

import a.l;
import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMessageHeaderPreference;", "Lcom/tencent/mm/ui/base/preference/Preference;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/tencent/mm/ui/MMActivity;", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "setContext", "(Lcom/tencent/mm/ui/MMActivity;)V", "init", "", "app_release"})
public final class NewBizInfoMessageHeaderPreference
  extends Preference
{
  public MMActivity cmc;
  
  public NewBizInfoMessageHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(154028);
    this.cmc = ((MMActivity)paramContext);
    AppMethodBeat.o(154028);
  }
  
  public NewBizInfoMessageHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(154029);
    this.cmc = ((MMActivity)paramContext);
    AppMethodBeat.o(154029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMessageHeaderPreference
 * JD-Core Version:    0.7.0.1
 */