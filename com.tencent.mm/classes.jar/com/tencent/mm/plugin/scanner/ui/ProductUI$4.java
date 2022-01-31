package com.tencent.mm.plugin.scanner.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a;
import com.tencent.mm.aw.a.7;
import com.tencent.mm.aw.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class ProductUI$4
  implements MusicPreference.a
{
  ProductUI$4(ProductUI paramProductUI) {}
  
  public final void d(MusicPreference paramMusicPreference)
  {
    AppMethodBeat.i(81082);
    if (paramMusicPreference == null)
    {
      ab.e("MicroMsg.scanner.ProductUI", "onMusicPrefClick, musicPref == null");
      AppMethodBeat.o(81082);
      return;
    }
    if ((bo.isNullOrNil(paramMusicPreference.qtT)) && (bo.isNullOrNil(paramMusicPreference.qtU)))
    {
      ab.w("MicroMsg.scanner.ProductUI", "wifiurl = null,  wapurl = null");
      if (!bo.isNullOrNil(paramMusicPreference.qtV)) {
        ProductUI.a(this.qyh, paramMusicPreference.qtV);
      }
      AppMethodBeat.o(81082);
      return;
    }
    String str1 = String.format("%s_cd_%s", new Object[] { paramMusicPreference.qtT, paramMusicPreference.mKey });
    int j;
    ArrayList localArrayList;
    int i;
    label193:
    MusicPreference localMusicPreference;
    String str2;
    if (!ProductUI.YG(str1))
    {
      if (paramMusicPreference.getTitle() == null)
      {
        ab.e("MicroMsg.scanner.ProductUI", "onPlayBtnClick, getTitle() == null");
        AppMethodBeat.o(81082);
        return;
      }
      j = -1;
      if (ProductUI.o(this.qyh) == null)
      {
        str1 = null;
        paramMusicPreference = String.format("%s_cd_%s", new Object[] { paramMusicPreference.qtT, paramMusicPreference.mKey });
        localArrayList = new ArrayList();
        Iterator localIterator = ProductUI.p(this.qyh).iterator();
        i = 0;
        if (!localIterator.hasNext()) {
          break label330;
        }
        localMusicPreference = (MusicPreference)localIterator.next();
        str2 = String.format("%s_cd_%s", new Object[] { localMusicPreference.qtT, localMusicPreference.mKey });
        if (!paramMusicPreference.equals(str2)) {
          break label388;
        }
        j = i;
      }
    }
    label388:
    for (;;)
    {
      localArrayList.add(f.a(5, str1, localMusicPreference.getTitle().toString(), "", localMusicPreference.qtV, localMusicPreference.qtU, localMusicPreference.qtT, str2, g.RL().eHR, str1, "", "wx482a4001c37e2b74"));
      i += 1;
      break label193;
      str1 = ProductUI.o(this.qyh).aon();
      break;
      label330:
      if (j < 0)
      {
        AppMethodBeat.o(81082);
        return;
      }
      al.d(new a.7(localArrayList, j));
      for (;;)
      {
        ProductUI.q(this.qyh);
        AppMethodBeat.o(81082);
        return;
        a.aiu();
        ab.d("MicroMsg.scanner.ProductUI", "isTheSameId, playMusicId : [%s]", new Object[] { str1 });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.4
 * JD-Core Version:    0.7.0.1
 */