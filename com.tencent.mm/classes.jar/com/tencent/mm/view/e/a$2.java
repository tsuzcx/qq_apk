package com.tencent.mm.view.e;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.view.SmileyPanelViewPager;
import com.tencent.mm.view.a.j;
import com.tencent.mm.view.a.j.a;

final class a$2
  implements j.a
{
  a$2(a parama) {}
  
  public final void f(int paramInt, View paramView)
  {
    boolean bool2 = false;
    AppMethodBeat.i(63024);
    Object localObject1 = a.j(this.AUz).RK(paramInt);
    if (localObject1 == null)
    {
      ab.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "info is null. ignore click action.");
      AppMethodBeat.o(63024);
      return;
    }
    Object localObject2 = ((EmojiGroupInfo)localObject1).field_productID;
    a.d(this.AUz);
    if (((String)localObject2).equalsIgnoreCase("TAG_STORE_MANEGER_TAB"))
    {
      a.k(this.AUz);
      AppMethodBeat.o(63024);
      return;
    }
    a.b(this.AUz, paramInt);
    localObject2 = a.d(this.AUz).avU(((EmojiGroupInfo)localObject1).field_productID);
    a.a(this.AUz, ((com.tencent.mm.view.c.a)localObject2).jpL);
    if (((com.tencent.mm.view.c.a)localObject2).ATX > ((com.tencent.mm.view.c.a)localObject2).dRf() - 1) {}
    for (paramInt = ((com.tencent.mm.view.c.a)localObject2).dRf() - 1;; paramInt = ((com.tencent.mm.view.c.a)localObject2).ATX)
    {
      if (a.c(this.AUz) != null) {
        a.c(this.AUz).setCurrentItem(a.e(this.AUz) + paramInt, false);
      }
      boolean bool1 = bool2;
      if (a.d(this.AUz).dRF())
      {
        String str = ((com.tencent.mm.view.c.a)localObject2).liu;
        a.d(this.AUz);
        bool1 = bool2;
        if (str.equals("TAG_DEFAULT_TAB")) {
          bool1 = true;
        }
      }
      a.a(this.AUz, ((com.tencent.mm.view.c.a)localObject2).dRf(), paramInt, bool1);
      a.d(this.AUz).AVa = paramInt;
      a.d(this.AUz).setShowProductId(((EmojiGroupInfo)localObject1).field_productID);
      localObject1 = ((EmojiGroupInfo)localObject1).field_productID;
      a.d(this.AUz);
      if ((((String)localObject1).equals("capture")) && (com.tencent.mm.view.f.a.RR(a.d(this.AUz).mScene)))
      {
        a.dRp();
        paramView = paramView.findViewById(2131827809);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
      }
      AppMethodBeat.o(63024);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.e.a.2
 * JD-Core Version:    0.7.0.1
 */