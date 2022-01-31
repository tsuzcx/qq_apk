package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.mm.plugin.sns.ui.previewimageview.c.a;
import com.tencent.mm.plugin.sns.ui.previewimageview.e;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

final class ag$2
  implements c.a
{
  ag$2(ag paramag) {}
  
  public final void dV(int paramInt1, int paramInt2)
  {
    ag.b localb = this.oSk.oSd;
    String str;
    if ((paramInt1 != paramInt2) && (localb.oSo.size() > paramInt1))
    {
      str = (String)localb.oSo.remove(paramInt1);
      if (paramInt2 >= localb.oSo.size()) {
        break label85;
      }
      localb.oSo.add(paramInt2, str);
    }
    for (;;)
    {
      this.oSk.bER.getIntent().putExtra("sns_kemdia_path_list", this.oSk.oSd.oSo);
      return;
      label85:
      localb.oSo.add(str);
    }
  }
  
  public final void removeItem(int paramInt)
  {
    ag.b localb = this.oSk.oSd;
    if (localb.oSo.size() > paramInt) {
      localb.oSo.remove(paramInt);
    }
    if ((this.oSk.bER instanceof SnsUploadUI)) {
      ((SnsUploadUI)this.oSk.bER).bKb();
    }
    this.oSk.bER.getIntent().putExtra("sns_kemdia_path_list", this.oSk.oSd.oSo);
    ((e)this.oSk.oSe).zb(this.oSk.oSd.oSo.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ag.2
 * JD-Core Version:    0.7.0.1
 */