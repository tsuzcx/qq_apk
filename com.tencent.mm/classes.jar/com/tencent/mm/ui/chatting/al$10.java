package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.at.g;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.vfs.e;

final class al$10
  implements n.d
{
  al$10(bi parambi, String paramString, int paramInt, Context paramContext) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(31019);
    String str2 = paramMenuItem.getTitle();
    Object localObject2 = this.fkH;
    j.b localb = j.b.mY(bo.apU(this.gWF));
    if (localb == null)
    {
      ab.w("MicroMsg.LongClickBrandServiceHelper", "send: parse app msg content return null");
      switch (this.bHS)
      {
      }
    }
    for (;;)
    {
      for (;;)
      {
        com.tencent.mm.ui.base.h.bO(this.val$context, this.val$context.getString(2131297064));
        AppMethodBeat.o(31019);
        return;
        paramMenuItem = null;
        Object localObject1 = paramMenuItem;
        if (((dd)localObject2).field_imgPath != null)
        {
          localObject1 = paramMenuItem;
          if (!((dd)localObject2).field_imgPath.equals("")) {
            localObject1 = o.ahC().J(((dd)localObject2).field_imgPath, true);
          }
        }
        try
        {
          localObject1 = e.i((String)localObject1, 0, -1);
          localObject2 = new b();
          paramMenuItem = (MenuItem)localObject2;
          if (!bo.isNullOrNil(localb.cmN))
          {
            long l = bo.getLong(localb.cmN, -1L);
            if (l == -1L) {
              break label416;
            }
            al.aUJ().get(l, (com.tencent.mm.sdk.e.c)localObject2);
            paramMenuItem = (MenuItem)localObject2;
            if (((b)localObject2).systemRowid != l)
            {
              localObject2 = al.aUJ().alo(localb.cmN);
              if (localObject2 != null)
              {
                paramMenuItem = (MenuItem)localObject2;
                if (((b)localObject2).field_mediaSvrId.equals(localb.cmN)) {}
              }
              else
              {
                paramMenuItem = null;
              }
            }
          }
          String str1 = "";
          localObject2 = str1;
          if (paramMenuItem != null)
          {
            localObject2 = str1;
            if (paramMenuItem.field_fileFullPath != null)
            {
              localObject2 = str1;
              if (!paramMenuItem.field_fileFullPath.equals(""))
              {
                aw.aaz();
                localObject2 = l.Z(com.tencent.mm.model.c.YS(), localb.title, localb.fgx);
                e.C(paramMenuItem.field_fileFullPath, (String)localObject2);
              }
            }
          }
          paramMenuItem = j.b.a(localb);
          paramMenuItem.fgz = 3;
          l.a(paramMenuItem, localb.appId, localb.appName, str2, (String)localObject2, (byte[])localObject1, null);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.e("MicroMsg.LongClickBrandServiceHelper", "send appmsg to %s, error:%s", new Object[] { str2, localException.getLocalizedMessage() });
            MenuItem localMenuItem = paramMenuItem;
            continue;
            label416:
            localObject2 = al.aUJ().alo(localb.cmN);
            if (localObject2 != null)
            {
              paramMenuItem = (MenuItem)localObject2;
              if (((b)localObject2).field_mediaSvrId.equals(localb.cmN)) {}
            }
            else
            {
              paramMenuItem = null;
            }
          }
        }
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(10424, new Object[] { Integer.valueOf(49), Integer.valueOf(256), str2 });
      continue;
      com.tencent.mm.plugin.report.service.h.qsU.e(10424, new Object[] { Integer.valueOf(49), Integer.valueOf(128), str2 });
      continue;
      com.tencent.mm.plugin.report.service.h.qsU.e(10424, new Object[] { Integer.valueOf(49), Integer.valueOf(512), str2 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.al.10
 * JD-Core Version:    0.7.0.1
 */