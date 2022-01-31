package com.tencent.mm.ui;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.conversation.ConversationListView;
import com.tencent.mm.ui.conversation.MainUI;

final class HomeUI$1
  implements MainTabUI.a
{
  HomeUI$1(HomeUI paramHomeUI) {}
  
  public final void Ob(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(29339);
    HomeUI.a(this.yYw);
    HomeUI.a(this.yYw, HomeUI.b(this.yYw).getResources().getColor(2131690316), HomeUI.b(this.yYw).getResources().getColor(2131689652), HomeUI.b(this.yYw).getResources().getColor(2131689763));
    Object localObject = HomeUI.c(this.yYw).On(0);
    if ((localObject instanceof MainUI))
    {
      localObject = (MainUI)localObject;
      if (paramInt == 0) {
        bool = true;
      }
      if (((MainUI)localObject).All != null) {
        ((MainUI)localObject).All.setIsCurrentMainUI(bool);
      }
    }
    AppMethodBeat.o(29339);
  }
  
  public final void Oc(int paramInt)
  {
    AppMethodBeat.i(29341);
    if ((HomeUI.d(this.yYw) == 0) && (paramInt == 1)) {
      HomeUI.a(this.yYw, HomeUI.c(this.yYw).Sl);
    }
    for (;;)
    {
      HomeUI.c(this.yYw, paramInt);
      ab.d("MicroMsg.LauncherUI.HomeUI", "tabSelectedStateChanged:%s begin:%s end:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(HomeUI.e(this.yYw)), Integer.valueOf(HomeUI.f(this.yYw)) });
      AppMethodBeat.o(29341);
      return;
      if (paramInt == 2)
      {
        HomeUI.b(this.yYw, HomeUI.c(this.yYw).Sl);
      }
      else if (paramInt == 0)
      {
        HomeUI.a(this.yYw, 0);
        HomeUI.b(this.yYw, 0);
      }
    }
  }
  
  public final void o(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(29340);
    HomeUI.a(this.yYw, paramInt, paramFloat);
    AppMethodBeat.o(29340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.1
 * JD-Core Version:    0.7.0.1
 */