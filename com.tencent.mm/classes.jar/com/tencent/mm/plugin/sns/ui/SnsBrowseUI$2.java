package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.a.gq;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.av;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.b.b;

final class SnsBrowseUI$2
  implements View.OnClickListener
{
  SnsBrowseUI$2(SnsBrowseUI paramSnsBrowseUI, av paramav, bxk parambxk) {}
  
  public final void onClick(View paramView)
  {
    if (this.oVM.sug == null) {}
    int i;
    int j;
    do
    {
      do
      {
        return;
        paramView = com.tencent.mm.plugin.sns.c.a.eUS.cs(this.oVM.sug.euK);
        i = 0;
        if (this.oVN.tNr.sPI == 1) {
          i = 2;
        }
        while (i.a(this.oVN, this.oVL))
        {
          com.tencent.mm.plugin.sns.c.a.eUS.a(this.oVL, this.oVM.sug.euK, paramView, this.oVN.hPY, i, 18, 9, this.oVM.sug.sua, this.oVN.lsK);
          return;
          if (this.oVN.tNr.sPI == 3) {
            i = 5;
          } else if (this.oVN.tNr.sPI == 15) {
            i = 4;
          }
        }
        switch (this.oVM.hQR)
        {
        default: 
          return;
        case 4: 
          localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", this.oVM.kSC);
          com.tencent.mm.plugin.sns.c.a.eUR.j((Intent)localObject, this.oVL);
          com.tencent.mm.plugin.sns.c.a.eUS.a(this.oVL, this.oVM.sug.euK, paramView, this.oVN.hPY, i, 18, 1, this.oVM.sug.sua, this.oVN.lsK);
          return;
        }
      } while (this.oVM.pyo != 1);
      localObject = new gq();
      ((gq)localObject).bOu.actionCode = 2;
      ((gq)localObject).bOu.scene = 3;
      ((gq)localObject).bOu.appId = this.oVM.sug.euK;
      ((gq)localObject).bOu.context = this.oVL;
      com.tencent.mm.sdk.b.a.udP.m((b)localObject);
      com.tencent.mm.plugin.sns.c.a.eUS.a(this.oVL, this.oVM.sug.euK, paramView, this.oVN.hPY, i, 18, 6, this.oVM.sug.sua, this.oVN.lsK);
      return;
      j = af.a(this.oVL, this.oVM);
      if (j == 1)
      {
        localObject = new gq();
        ((gq)localObject).bOu.context = this.oVL;
        ((gq)localObject).bOu.actionCode = 2;
        ((gq)localObject).bOu.appId = this.oVM.sug.euK;
        ((gq)localObject).bOu.messageAction = this.oVM.sug.suc;
        ((gq)localObject).bOu.messageExt = this.oVM.sug.sub;
        ((gq)localObject).bOu.scene = 3;
        com.tencent.mm.sdk.b.a.udP.m((b)localObject);
        com.tencent.mm.plugin.sns.c.a.eUS.a(this.oVL, this.oVM.sug.euK, paramView, this.oVN.hPY, i, 18, 6, this.oVM.sug.sua, this.oVN.lsK);
        return;
      }
    } while (j != 2);
    Object localObject = new gq();
    ((gq)localObject).bOu.context = this.oVL;
    ((gq)localObject).bOu.actionCode = 1;
    ((gq)localObject).bOu.appId = this.oVM.sug.euK;
    ((gq)localObject).bOu.messageAction = this.oVM.sug.suc;
    ((gq)localObject).bOu.messageExt = this.oVM.sug.sub;
    ((gq)localObject).bOu.scene = 3;
    com.tencent.mm.sdk.b.a.udP.m((b)localObject);
    com.tencent.mm.plugin.sns.c.a.eUS.a(this.oVL, this.oVM.sug.euK, paramView, this.oVN.hPY, i, 18, 3, this.oVM.sug.sua, this.oVN.lsK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBrowseUI.2
 * JD-Core Version:    0.7.0.1
 */