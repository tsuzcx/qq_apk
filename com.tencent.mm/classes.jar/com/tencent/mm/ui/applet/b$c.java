package com.tencent.mm.ui.applet;

import java.util.LinkedList;

final class b$c
{
  private LinkedList<String> dtH = null;
  private int maxSize = 40;
  
  public b$c(b paramb) {}
  
  final boolean contains(String paramString)
  {
    return this.dtH.contains(paramString);
  }
  
  final void qh(String paramString)
  {
    if (this.dtH.contains(paramString)) {}
    do
    {
      return;
      this.dtH.add(paramString);
    } while (this.dtH.size() < this.maxSize);
    this.dtH.removeFirst();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.applet.b.c
 * JD-Core Version:    0.7.0.1
 */