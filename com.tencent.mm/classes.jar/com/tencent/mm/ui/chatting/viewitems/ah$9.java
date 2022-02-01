package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.b.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;

final class ah$9
  implements View.OnClickListener
{
  ah$9(ah paramah, Map paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, com.tencent.mm.storage.bo parambo, bo parambo1) {}
  
  public final void onClick(View paramView)
  {
    int j = 1;
    AppMethodBeat.i(169886);
    paramView = bs.nullAsNil((String)this.frY.get(".msg.fromusername"));
    if (this.InI)
    {
      int i;
      if ((!this.InJ) && (this.InK))
      {
        ah.a(this.Inu, this.InJ, this.InI, this.hmq, this.frY, paramView, this.InF, this.InK);
        i = 1;
      }
      for (;;)
      {
        Object localObject = a.ihM;
        localObject = ah.d(this.Inu);
        if (this.InJ) {
          j = 0;
        }
        a.a(paramView, i, (String)localObject, j, ah.f(this.Inu));
        AppMethodBeat.o(169886);
        return;
        if (this.InK)
        {
          ah.a(this.Inu, this.InJ, this.InI, this.hmq, this.frY, paramView, this.InF, this.InK);
          i = 1;
        }
        else
        {
          i = 2;
          ah.b(this.Inu, paramView);
        }
      }
    }
    if (!this.InJ)
    {
      ah.a(this.Inu, this.InJ, this.InI, this.hmq, this.frY, paramView, this.InF, this.InK);
      AppMethodBeat.o(169886);
      return;
    }
    ah.b(this.Inu, paramView);
    AppMethodBeat.o(169886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ah.9
 * JD-Core Version:    0.7.0.1
 */