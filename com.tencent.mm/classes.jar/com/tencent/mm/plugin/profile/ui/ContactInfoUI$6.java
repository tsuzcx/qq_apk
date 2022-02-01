package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.plugin.textstatus.a.b;
import com.tencent.mm.plugin.textstatus.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback;

final class ContactInfoUI$6
  implements PullDownListView.IPullDownCallback
{
  ContactInfoUI$6(ContactInfoUI paramContactInfoUI) {}
  
  public final void UC(int paramInt) {}
  
  public final void UD(int paramInt) {}
  
  public final void UE(int paramInt) {}
  
  public final void eEk()
  {
    AppMethodBeat.i(231836);
    if (ContactInfoUI.e(this.BdV) != null)
    {
      ContactInfoUI.e(this.BdV).eEk();
      if (ContactInfoUI.f(this.BdV) != null)
      {
        Object localObject = (NormalProfileHeaderPreference)ContactInfoUI.f(this.BdV).bmg("contact_profile_header_normal");
        if (localObject != null)
        {
          localObject = ((NormalProfileHeaderPreference)localObject).eEI();
          if (localObject != null) {
            ((d)localObject).eEk();
          }
        }
      }
    }
    AppMethodBeat.o(231836);
  }
  
  public final void eEl()
  {
    AppMethodBeat.i(231837);
    if (ContactInfoUI.e(this.BdV) != null)
    {
      ContactInfoUI.e(this.BdV).eEl();
      if (ContactInfoUI.f(this.BdV) != null)
      {
        Object localObject = (NormalProfileHeaderPreference)ContactInfoUI.f(this.BdV).bmg("contact_profile_header_normal");
        if (localObject != null)
        {
          localObject = ((NormalProfileHeaderPreference)localObject).eEI();
          if (localObject != null) {
            ((d)localObject).eEl();
          }
        }
      }
    }
    AppMethodBeat.o(231837);
  }
  
  public final void eEm()
  {
    AppMethodBeat.i(231838);
    Log.i("MicroMsg.ContactInfoUI", "story_cat onMuteIn");
    if (ContactInfoUI.d(this.BdV) != null) {
      ContactInfoUI.d(this.BdV).fmV();
    }
    AppMethodBeat.o(231838);
  }
  
  public final void eEn()
  {
    AppMethodBeat.i(231839);
    if (ContactInfoUI.d(this.BdV) != null) {
      ContactInfoUI.d(this.BdV).fmW();
    }
    AppMethodBeat.o(231839);
  }
  
  public final void onPostClose()
  {
    AppMethodBeat.i(231835);
    if (ContactInfoUI.e(this.BdV) != null) {
      ContactInfoUI.e(this.BdV).onPostClose();
    }
    AppMethodBeat.o(231835);
  }
  
  public final void onPostOpen(boolean paramBoolean)
  {
    AppMethodBeat.i(231834);
    if (ContactInfoUI.e(this.BdV) != null) {
      ContactInfoUI.e(this.BdV).onPostOpen(paramBoolean);
    }
    AppMethodBeat.o(231834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.6
 * JD-Core Version:    0.7.0.1
 */