package com.tencent.mm.ui.chatting.i;

import android.content.pm.PackageInfo;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.a.c.b;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.tools.l;

final class f$2
  implements c.e
{
  f$2(f paramf) {}
  
  public final void a(View paramView, int paramInt, c.b paramb)
  {
    AppMethodBeat.i(32614);
    aw.aaz();
    paramb = c.YC().kB(paramb.cpO);
    j.b localb = j.b.mY(paramb.field_content);
    String str1 = p.H(localb.url, "message");
    String str2 = p.H(localb.fgv, "message");
    PackageInfo localPackageInfo = f.getPackageInfo(this.zPx.mContext, localb.appId);
    f localf = this.zPx;
    if (localPackageInfo == null)
    {
      paramView = null;
      if (localPackageInfo != null) {
        break label134;
      }
    }
    label134:
    for (paramInt = 0;; paramInt = localPackageInfo.versionCode)
    {
      localf.a(str1, str2, paramView, paramInt, localb.appId, paramb.field_msgId, paramb.field_msgSvrId, paramb);
      AppMethodBeat.o(32614);
      return;
      paramView = localPackageInfo.versionName;
      break;
    }
  }
  
  public final void b(View paramView, int paramInt, c.b paramb)
  {
    AppMethodBeat.i(32615);
    ab.i("MicroMsg.MusicHistoryListPresenter", "[onItemLongClick] position:%s", new Object[] { Integer.valueOf(paramInt) });
    new l(paramView.getContext()).b(paramView, new f.2.1(this), new f.2.2(this, paramb));
    AppMethodBeat.o(32615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.f.2
 * JD-Core Version:    0.7.0.1
 */