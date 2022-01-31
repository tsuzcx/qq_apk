package com.tencent.mm.ui.bizchat;

import android.view.View;

final class BizChatSearchUI$c
{
  View ida;
  View idb;
  View idc;
  
  final void v(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    View localView = this.ida;
    if (paramBoolean1)
    {
      i = 0;
      localView.setVisibility(i);
      this.idb.setVisibility(8);
      localView = this.idc;
      if (!paramBoolean2) {
        break label56;
      }
    }
    label56:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      return;
      i = 8;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSearchUI.c
 * JD-Core Version:    0.7.0.1
 */