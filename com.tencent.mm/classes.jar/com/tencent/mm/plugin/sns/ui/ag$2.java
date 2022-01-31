package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.previewimageview.c.a;
import com.tencent.mm.plugin.sns.ui.previewimageview.e;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

final class ag$2
  implements c.a
{
  ag$2(ag paramag) {}
  
  public final void fH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38477);
    ag.b localb = this.rKd.rJW;
    String str;
    if ((paramInt1 != paramInt2) && (localb.rKh.size() > paramInt1))
    {
      str = (String)localb.rKh.remove(paramInt1);
      if (paramInt2 >= localb.rKh.size()) {
        break label95;
      }
      localb.rKh.add(paramInt2, str);
    }
    for (;;)
    {
      this.rKd.cmc.getIntent().putExtra("sns_kemdia_path_list", this.rKd.rJW.rKh);
      AppMethodBeat.o(38477);
      return;
      label95:
      localb.rKh.add(str);
    }
  }
  
  public final void removeItem(int paramInt)
  {
    AppMethodBeat.i(38478);
    ag.b localb = this.rKd.rJW;
    if (localb.rKh.size() > paramInt) {
      localb.rKh.remove(paramInt);
    }
    if ((this.rKd.cmc instanceof SnsUploadUI)) {
      ((SnsUploadUI)this.rKd.cmc).cwD();
    }
    this.rKd.cmc.getIntent().putExtra("sns_kemdia_path_list", this.rKd.rJW.rKh);
    ((e)this.rKd.rJX).Fm(this.rKd.rJW.rKh.size());
    AppMethodBeat.o(38478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ag.2
 * JD-Core Version:    0.7.0.1
 */