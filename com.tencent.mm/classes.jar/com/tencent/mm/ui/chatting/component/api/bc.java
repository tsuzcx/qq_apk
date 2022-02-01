package com.tencent.mm.ui.chatting.component.api;

import android.view.MenuItem;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.component.aj;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.c;

public abstract interface bc
  extends aj
{
  public abstract boolean b(MenuItem paramMenuItem, cc paramcc);
  
  public abstract ChattingItemTranslate.c cZ(cc paramcc);
  
  public abstract String h(cc paramcc, boolean paramBoolean);
  
  public abstract void jtW();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.api.bc
 * JD-Core Version:    0.7.0.1
 */