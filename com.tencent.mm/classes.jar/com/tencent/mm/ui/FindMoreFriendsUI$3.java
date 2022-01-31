package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.c;
import com.tencent.mm.at.o;
import com.tencent.mm.at.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.b;
import com.tencent.mm.plugin.topstory.a.e;
import com.tencent.mm.protocal.protobuf.cku;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.mm.ui.tools.t;

final class FindMoreFriendsUI$3
  implements Runnable
{
  FindMoreFriendsUI$3(FindMoreFriendsUI paramFindMoreFriendsUI, IconPreference paramIconPreference) {}
  
  public final void run()
  {
    AppMethodBeat.i(29209);
    if (this.yWJ == null)
    {
      AppMethodBeat.o(29209);
      return;
    }
    boolean bool1 = ((b)g.G(b.class)).getRedDotMgr().cHX();
    boolean bool2 = ((b)g.G(b.class)).getRedDotMgr().cIl();
    int i = ((b)g.G(b.class)).getRedDotMgr().cIe();
    this.yWJ.ON(8);
    this.yWJ.OM(8);
    this.yWJ.OQ(8);
    this.yWJ.OL(8);
    Object localObject;
    if ((i > 0) && (((b)g.G(b.class)).getRedDotMgr().cHY()))
    {
      this.yWJ.OL(0);
      localObject = String.valueOf(i);
      if (i > 99) {
        localObject = "99+";
      }
      this.yWJ.eN((String)localObject, t.iF(this.yWI.getContext()));
      ((b)g.G(b.class)).getRedDotMgr().Gv(i);
    }
    for (;;)
    {
      FindMoreFriendsUI.a(this.yWI).notifyDataSetChanged();
      AppMethodBeat.o(29209);
      return;
      if (bool1)
      {
        if (LauncherUI.dCf() == 2) {
          ((b)g.G(b.class)).getRedDotMgr().cIa();
        }
        localObject = ((b)g.G(b.class)).getRedDotMgr().cHZ();
        Bitmap localBitmap;
        switch (((cku)localObject).type)
        {
        default: 
          ab.e("MicroMsg.FindMoreFriendsUI", "search unknown red type %d", new Object[] { Integer.valueOf(((cku)localObject).type) });
          break;
        case 1: 
          this.yWJ.ON(0);
          break;
        case 2: 
          this.yWJ.ON(8);
          this.yWJ.OM(0);
          this.yWJ.aG(((cku)localObject).text, -1, Color.parseColor("#8c8c8c"));
          this.yWJ.qI(true);
          this.yWJ.OQ(8);
          break;
        case 3: 
          this.yWJ.ON(8);
          this.yWJ.OQ(0);
          this.yWJ.OP(0);
          this.yWJ.OR(0);
          this.yWJ.qI(false);
          o.ahB();
          localBitmap = c.lK(((cku)localObject).cDz);
          if (localBitmap != null)
          {
            FindMoreFriendsUI.a(this.yWI, null);
            this.yWJ.ap(localBitmap);
            continue;
          }
          o.ahF().a(((cku)localObject).cDz, this.yWI.yWH);
          FindMoreFriendsUI.a(this.yWI, ((cku)localObject).cDz);
          break;
        case 4: 
          this.yWJ.ON(8);
          this.yWJ.OQ(0);
          this.yWJ.OP(0);
          this.yWJ.OR(0);
          this.yWJ.OM(0);
          this.yWJ.qI(false);
          this.yWJ.aG(((cku)localObject).text, -1, Color.parseColor("#8c8c8c"));
          o.ahB();
          localBitmap = c.lK(((cku)localObject).cDz);
          if (localBitmap != null)
          {
            FindMoreFriendsUI.a(this.yWI, null);
            this.yWJ.ap(localBitmap);
            continue;
          }
          o.ahF().a(((cku)localObject).cDz, this.yWI.yWH);
          FindMoreFriendsUI.a(this.yWI, ((cku)localObject).cDz);
          break;
        }
      }
      else if (bool2)
      {
        this.yWJ.ON(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.3
 * JD-Core Version:    0.7.0.1
 */