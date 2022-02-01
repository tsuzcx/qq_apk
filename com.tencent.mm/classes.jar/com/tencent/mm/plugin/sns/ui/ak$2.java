package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.previewimageview.c.a;
import com.tencent.mm.plugin.sns.ui.previewimageview.e;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

final class ak$2
  implements c.a
{
  ak$2(ak paramak) {}
  
  public final void hn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98156);
    ak.b localb = this.xqH.xqA;
    String str;
    if ((paramInt1 != paramInt2) && (localb.xqL.size() > paramInt1))
    {
      str = (String)localb.xqL.remove(paramInt1);
      if (paramInt2 >= localb.xqL.size()) {
        break label95;
      }
      localb.xqL.add(paramInt2, str);
    }
    for (;;)
    {
      this.xqH.imP.getIntent().putExtra("sns_kemdia_path_list", this.xqH.xqA.xqL);
      AppMethodBeat.o(98156);
      return;
      label95:
      localb.xqL.add(str);
    }
  }
  
  public final void removeItem(int paramInt)
  {
    AppMethodBeat.i(98157);
    ak.b localb = this.xqH.xqA;
    if (localb.xqL.size() > paramInt) {
      localb.xqL.remove(paramInt);
    }
    if ((this.xqH.imP instanceof SnsUploadUI)) {
      ((SnsUploadUI)this.xqH.imP).dCO();
    }
    this.xqH.imP.getIntent().putExtra("sns_kemdia_path_list", this.xqH.xqA.xqL);
    this.xqH.imP.getIntent().putExtra("sns_kemdia_path", "");
    ((e)this.xqH.xqB).NR(this.xqH.xqA.xqL.size());
    AppMethodBeat.o(98157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ak.2
 * JD-Core Version:    0.7.0.1
 */