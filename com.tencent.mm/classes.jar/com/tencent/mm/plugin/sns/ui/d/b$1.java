package com.tencent.mm.plugin.sns.ui.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import java.util.LinkedList;

final class b$1
  implements View.OnClickListener
{
  b$1(b paramb) {}
  
  public final void onClick(View paramView)
  {
    boolean bool = false;
    if (paramView.getTag() == null) {}
    n localn;
    do
    {
      return;
      localn = b.dc(paramView);
    } while ((localn == null) || (!localn.yr(32)));
    int j;
    int i;
    label72:
    Object localObject;
    label105:
    int k;
    if (localn.bGN().bFZ().bEM())
    {
      j = v.eY(localn.bGN().bFZ().bEH(), localn.bGM());
      if (j > 0)
      {
        i = 1;
        localObject = localn.bGN().bFZ().bEH();
        String str1 = localn.bGM();
        g.DN();
        String str2 = a.CL();
        if (i == 0) {
          break label192;
        }
        if (i == 0) {
          break label197;
        }
        k = 0;
        label112:
        v.g((String)localObject, str1, str2, j, k);
        if (i != 0) {}
      }
    }
    for (bool = true;; bool = false)
    {
      localObject = localn.bGe();
      if ((((bxk)localObject).tNr.sPI == 15) && (((bxk)localObject).tNy != 1))
      {
        b.a(this.ppl, paramView, localn, 1001, localn.bGN().bFZ().bEN(), bool);
        return;
        i = 0;
        break label72;
        label192:
        j = 1;
        break label105;
        label197:
        k = 1;
        break label112;
      }
      if (((((bxk)localObject).tNr.sPI != 1) || (((bxk)localObject).tNr.sPJ.size() != 1)) && (((bxk)localObject).tNr.sPI != 7)) {
        break;
      }
      b.b(this.ppl, paramView, localn, 1001, localn.bGN().bFZ().bEN(), bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.1
 * JD-Core Version:    0.7.0.1
 */