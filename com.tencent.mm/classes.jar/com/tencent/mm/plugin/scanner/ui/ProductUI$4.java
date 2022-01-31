package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.av.a;
import com.tencent.mm.av.a.7;
import com.tencent.mm.av.f;
import com.tencent.mm.plugin.scanner.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
    if (paramMusicPreference == null) {
      y.e("MicroMsg.scanner.ProductUI", "onMusicPrefClick, musicPref == null");
    }
    do
    {
      return;
      if ((!bk.bl(paramMusicPreference.nGD)) || (!bk.bl(paramMusicPreference.nGE))) {
        break;
      }
      y.w("MicroMsg.scanner.ProductUI", "wifiurl = null,  wapurl = null");
    } while (bk.bl(paramMusicPreference.nGF));
    ProductUI.a(this.nKF, paramMusicPreference.nGF);
    return;
    String str1 = String.format("%s_cd_%s", new Object[] { paramMusicPreference.nGD, paramMusicPreference.mKey });
    int j;
    label124:
    ArrayList localArrayList;
    int i;
    label173:
    MusicPreference localMusicPreference;
    String str2;
    if (!ProductUI.Me(str1))
    {
      if (paramMusicPreference.getTitle() == null)
      {
        y.e("MicroMsg.scanner.ProductUI", "onPlayBtnClick, getTitle() == null");
        return;
      }
      j = -1;
      if (ProductUI.m(this.nKF) == null)
      {
        str1 = null;
        paramMusicPreference = String.format("%s_cd_%s", new Object[] { paramMusicPreference.nGD, paramMusicPreference.mKey });
        localArrayList = new ArrayList();
        Iterator localIterator = ProductUI.n(this.nKF).iterator();
        i = 0;
        if (!localIterator.hasNext()) {
          break label307;
        }
        localMusicPreference = (MusicPreference)localIterator.next();
        str2 = String.format("%s_cd_%s", new Object[] { localMusicPreference.nGD, localMusicPreference.mKey });
        if (!paramMusicPreference.equals(str2)) {
          break label354;
        }
        j = i;
      }
    }
    label307:
    label354:
    for (;;)
    {
      localArrayList.add(f.a(5, str1, localMusicPreference.getTitle().toString(), "", localMusicPreference.nGF, localMusicPreference.nGE, localMusicPreference.nGD, str2, c.FU(), str1, "", "wx482a4001c37e2b74"));
      i += 1;
      break label173;
      str1 = ProductUI.m(this.nKF).UO();
      break label124;
      if (j < 0) {
        break;
      }
      ai.d(new a.7(localArrayList, j));
      for (;;)
      {
        ProductUI.o(this.nKF);
        return;
        a.Ps();
        y.d("MicroMsg.scanner.ProductUI", "isTheSameId, playMusicId : [%s]", new Object[] { str1 });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.4
 * JD-Core Version:    0.7.0.1
 */