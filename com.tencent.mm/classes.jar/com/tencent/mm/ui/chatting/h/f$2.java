package com.tencent.mm.ui.chatting.h;

import android.content.pm.PackageInfo;
import android.view.View;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.tools.j;

final class f$2
  implements c.e
{
  f$2(f paramf) {}
  
  public final void a(int paramInt, c.b paramb)
  {
    au.Hx();
    bi localbi = c.Fy().fd(paramb.bIt);
    g.a locala = g.a.gp(localbi.field_content);
    String str1 = p.u(locala.url, "message");
    String str2 = p.u(locala.dQu, "message");
    PackageInfo localPackageInfo = f.getPackageInfo(this.vza.mContext, locala.appId);
    f localf = this.vza;
    if (localPackageInfo == null)
    {
      paramb = null;
      if (localPackageInfo != null) {
        break label122;
      }
    }
    label122:
    for (paramInt = 0;; paramInt = localPackageInfo.versionCode)
    {
      localf.a(str1, str2, paramb, paramInt, locala.appId, localbi.field_msgId, localbi.field_msgSvrId, localbi);
      return;
      paramb = localPackageInfo.versionName;
      break;
    }
  }
  
  public final void a(View paramView, int paramInt, c.b paramb)
  {
    y.i("MicroMsg.MusicHistoryListPresenter", "[onItemLongClick] position:%s", new Object[] { Integer.valueOf(paramInt) });
    new j(paramView.getContext()).b(paramView, new f.2.1(this), new f.2.2(this, paramb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.f.2
 * JD-Core Version:    0.7.0.1
 */