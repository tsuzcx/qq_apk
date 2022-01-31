package com.tencent.mm.ui.tools;

import android.content.Intent;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h.d;

final class ShowImageUI$2$1
  implements h.d
{
  ShowImageUI$2$1(ShowImageUI.2 param2) {}
  
  public final void bF(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
      ShowImageUI.b(this.weY.weX);
      return;
    case 1: 
      ShowImageUI localShowImageUI = this.weY.weX;
      cj localcj = new cj();
      long l = localShowImageUI.getIntent().getLongExtra("key_message_id", -1L);
      if (-1L == l)
      {
        y.w("MicroMsg.ShowImageUI", "msg id error, try fav simple data");
        e.a(localcj, localShowImageUI.getIntent().getIntExtra("key_favorite_source_type", 1), localShowImageUI.getIntent().getStringExtra("key_image_path"));
      }
      for (;;)
      {
        localcj.bIw.activity = localShowImageUI;
        a.udP.m(localcj);
        return;
        e.a(localcj, l);
      }
    case 2: 
      ShowImageUI.c(this.weY.weX);
      return;
    }
    ShowImageUI.d(this.weY.weX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShowImageUI.2.1
 * JD-Core Version:    0.7.0.1
 */