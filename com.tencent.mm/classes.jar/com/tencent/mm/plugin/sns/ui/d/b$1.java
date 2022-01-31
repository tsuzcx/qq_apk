package com.tencent.mm.plugin.sns.ui.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.vi;
import java.util.LinkedList;

final class b$1
  implements View.OnClickListener
{
  b$1(b paramb) {}
  
  public final void onClick(View paramView)
  {
    boolean bool = false;
    AppMethodBeat.i(40239);
    if (paramView.getTag() == null)
    {
      AppMethodBeat.o(40239);
      return;
    }
    n localn = b.dT(paramView);
    if ((localn == null) || (!localn.Ex(32)))
    {
      AppMethodBeat.o(40239);
      return;
    }
    int j;
    int i;
    Object localObject;
    label121:
    int k;
    if (localn.csQ().csb().cqs())
    {
      j = v.gG(localn.csQ().csb().cqn(), localn.csP());
      if (j > 0)
      {
        i = 1;
        localObject = localn.csQ().csb().cqn();
        String str1 = localn.csP();
        g.RJ();
        String str2 = a.QC();
        if (i == 0) {
          break label213;
        }
        if (i == 0) {
          break label218;
        }
        k = 0;
        label128:
        v.h((String)localObject, str1, str2, j, k);
        if (i != 0) {}
      }
    }
    for (bool = true;; bool = false)
    {
      localObject = localn.csh();
      if ((((TimeLineObject)localObject).xTS.wNZ == 15) && (((TimeLineObject)localObject).xTZ != 1))
      {
        b.a(this.skd, paramView, localn, 1001, localn.csQ().csb().cqt(), bool);
        AppMethodBeat.o(40239);
        return;
        i = 0;
        break;
        label213:
        j = 1;
        break label121;
        label218:
        k = 1;
        break label128;
      }
      if (((((TimeLineObject)localObject).xTS.wNZ == 1) && (((TimeLineObject)localObject).xTS.wOa.size() == 1)) || (((TimeLineObject)localObject).xTS.wNZ == 7)) {
        b.b(this.skd, paramView, localn, 1001, localn.csQ().csb().cqt(), bool);
      }
      AppMethodBeat.o(40239);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.1
 * JD-Core Version:    0.7.0.1
 */