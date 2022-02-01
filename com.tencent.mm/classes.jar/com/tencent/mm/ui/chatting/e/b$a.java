package com.tencent.mm.ui.chatting.e;

import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.presenter.c;

public abstract interface b$a
  extends c<b.b>
{
  public abstract RecyclerView.a bBf(String paramString);
  
  public abstract String bVz();
  
  public abstract int getType();
  
  public abstract <T extends RecyclerView.LayoutManager> T juP();
  
  public abstract RecyclerView.h juQ();
  
  public abstract void juR();
  
  public abstract c.e juS();
  
  public abstract com.tencent.mm.modelvoiceaddr.ui.b.a juT();
  
  public abstract String juU();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.e.b.a
 * JD-Core Version:    0.7.0.1
 */