package com.tencent.mm.plugin.notification;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.al;
import com.tencent.mm.plugin.notification.b.a;

public class PluginNotification
  extends f
  implements a
{
  private al mIt;
  
  public void execute(g paramg) {}
  
  public al getNotification()
  {
    return this.mIt;
  }
  
  public void setNotification(al paramal)
  {
    this.mIt = paramal;
    b.mIj = paramal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.PluginNotification
 * JD-Core Version:    0.7.0.1
 */