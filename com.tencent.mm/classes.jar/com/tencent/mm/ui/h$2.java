package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.tencent.mm.as.c;
import com.tencent.mm.as.o;
import com.tencent.mm.as.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.b;
import com.tencent.mm.plugin.topstory.a.e;
import com.tencent.mm.protocal.c.byd;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.IconPreference;

final class h$2
  implements Runnable
{
  h$2(h paramh, IconPreference paramIconPreference) {}
  
  public final void run()
  {
    if (this.uJj == null) {
      return;
    }
    if (((b)g.t(b.class)).getRedDotMgr().bMU())
    {
      if (LauncherUI.cyY() == 2) {
        ((b)g.t(b.class)).getRedDotMgr().bMY();
      }
      byd localbyd = ((b)g.t(b.class)).getRedDotMgr().bMX();
      switch (localbyd.type)
      {
      default: 
        y.e("MicroMsg.FindMoreFriendsUI", "search unknown red type %d", new Object[] { Integer.valueOf(localbyd.type) });
        return;
      case 1: 
        this.uJj.Gv(0);
        this.uJj.Gu(8);
        return;
      case 2: 
        this.uJj.Gv(8);
        this.uJj.Gu(0);
        this.uJj.ap(localbyd.text, -1, Color.parseColor("#8c8c8c"));
        this.uJj.ne(true);
        this.uJj.Gy(8);
        return;
      case 3: 
        this.uJj.Gv(8);
        this.uJj.Gy(0);
        this.uJj.Gx(0);
        this.uJj.Gz(0);
        this.uJj.ne(false);
        o.OI();
        localBitmap = c.jK(localbyd.bVO);
        if (localBitmap != null)
        {
          h.a(this.uJi, null);
          this.uJj.Z(localBitmap);
          return;
        }
        o.OM().a(localbyd.bVO, this.uJi.uJh);
        h.a(this.uJi, localbyd.bVO);
        return;
      }
      this.uJj.Gv(8);
      this.uJj.Gy(0);
      this.uJj.Gx(0);
      this.uJj.Gz(0);
      this.uJj.Gu(0);
      this.uJj.ne(false);
      this.uJj.ap(localbyd.text, -1, Color.parseColor("#8c8c8c"));
      o.OI();
      Bitmap localBitmap = c.jK(localbyd.bVO);
      if (localBitmap != null)
      {
        h.a(this.uJi, null);
        this.uJj.Z(localBitmap);
        return;
      }
      o.OM().a(localbyd.bVO, this.uJi.uJh);
      h.a(this.uJi, localbyd.bVO);
      return;
    }
    this.uJj.Gv(8);
    this.uJj.Gu(8);
    this.uJj.Gy(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.h.2
 * JD-Core Version:    0.7.0.1
 */