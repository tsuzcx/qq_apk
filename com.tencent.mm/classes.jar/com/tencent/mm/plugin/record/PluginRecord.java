package com.tencent.mm.plugin.record;

import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.record.a.a;
import com.tencent.mm.plugin.record.a.d;

public class PluginRecord
  extends f
  implements b, c, a
{
  private com.tencent.mm.plugin.record.a.e nsI;
  private d nsJ;
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public d getRecordMsgCDNStorage()
  {
    return this.nsJ;
  }
  
  public com.tencent.mm.plugin.record.a.e getRecordMsgInfoStorage()
  {
    return this.nsI;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    this.nsI = new com.tencent.mm.plugin.record.b.g(com.tencent.mm.kernel.g.DP().dKu);
    this.nsJ = new com.tencent.mm.plugin.record.b.e(com.tencent.mm.kernel.g.DP().dKu);
  }
  
  public void onAccountRelease() {}
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.record.PluginRecord
 * JD-Core Version:    0.7.0.1
 */