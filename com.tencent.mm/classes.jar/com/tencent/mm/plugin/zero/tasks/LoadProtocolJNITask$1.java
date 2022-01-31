package com.tencent.mm.plugin.zero.tasks;

import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.d;

class LoadProtocolJNITask$1
  implements Runnable
{
  LoadProtocolJNITask$1(LoadProtocolJNITask paramLoadProtocolJNITask) {}
  
  public void run()
  {
    MMProtocalJni.setClientPackVersion(d.spa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask.1
 * JD-Core Version:    0.7.0.1
 */