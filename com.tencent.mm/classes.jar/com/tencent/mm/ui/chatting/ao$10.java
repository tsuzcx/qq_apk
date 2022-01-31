package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.as.g;
import com.tencent.mm.as.o;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.vfs.e;

final class ao$10
  implements n.d
{
  ao$10(bi parambi, String paramString, int paramInt, Context paramContext) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    String str2 = paramMenuItem.getTitle();
    Object localObject2 = this.dUy;
    g.a locala = g.a.gp(bk.ZQ(this.fEp));
    if (locala == null)
    {
      y.w("MicroMsg.LongClickBrandServiceHelper", "send: parse app msg content return null");
      switch (this.bns)
      {
      }
    }
    for (;;)
    {
      for (;;)
      {
        com.tencent.mm.ui.base.h.bC(this.val$context, this.val$context.getString(R.l.app_saved));
        return;
        paramMenuItem = null;
        Object localObject1 = paramMenuItem;
        if (((cs)localObject2).field_imgPath != null)
        {
          localObject1 = paramMenuItem;
          if (!((cs)localObject2).field_imgPath.equals("")) {
            localObject1 = o.OJ().F(((cs)localObject2).field_imgPath, true);
          }
        }
        try
        {
          localObject1 = e.c((String)localObject1, 0, -1);
          localObject2 = new b();
          paramMenuItem = (MenuItem)localObject2;
          if (!bk.bl(locala.bFE))
          {
            long l = bk.getLong(locala.bFE, -1L);
            if (l == -1L) {
              break label403;
            }
            ap.avh().b(l, (com.tencent.mm.sdk.e.c)localObject2);
            paramMenuItem = (MenuItem)localObject2;
            if (((b)localObject2).ujK != l)
            {
              localObject2 = ap.avh().VQ(locala.bFE);
              if (localObject2 != null)
              {
                paramMenuItem = (MenuItem)localObject2;
                if (((b)localObject2).field_mediaSvrId.equals(locala.bFE)) {}
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
                au.Hx();
                localObject2 = l.aj(com.tencent.mm.model.c.FO(), locala.title, locala.dQw);
                e.r(paramMenuItem.field_fileFullPath, (String)localObject2);
              }
            }
          }
          paramMenuItem = g.a.a(locala);
          paramMenuItem.dQy = 3;
          l.a(paramMenuItem, locala.appId, locala.appName, str2, (String)localObject2, (byte[])localObject1, null);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            y.e("MicroMsg.LongClickBrandServiceHelper", "send appmsg to %s, error:%s", new Object[] { str2, localException.getLocalizedMessage() });
            MenuItem localMenuItem = paramMenuItem;
            continue;
            label403:
            localObject2 = ap.avh().VQ(locala.bFE);
            if (localObject2 != null)
            {
              paramMenuItem = (MenuItem)localObject2;
              if (((b)localObject2).field_mediaSvrId.equals(locala.bFE)) {}
            }
            else
            {
              paramMenuItem = null;
            }
          }
        }
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(10424, new Object[] { Integer.valueOf(49), Integer.valueOf(256), str2 });
      continue;
      com.tencent.mm.plugin.report.service.h.nFQ.f(10424, new Object[] { Integer.valueOf(49), Integer.valueOf(128), str2 });
      continue;
      com.tencent.mm.plugin.report.service.h.nFQ.f(10424, new Object[] { Integer.valueOf(49), Integer.valueOf(512), str2 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ao.10
 * JD-Core Version:    0.7.0.1
 */