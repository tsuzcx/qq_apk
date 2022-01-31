package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.protocal.c.axf;
import com.tencent.mm.protocal.c.ua;
import com.tencent.mm.protocal.c.ub;

public final class k
  extends i.b
{
  private axf nQL = new axf();
  
  public k()
  {
    this(false, 22, 8);
  }
  
  public k(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(31);
    ua localua = new ua();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localua.sQN = i;
      i = j;
      if (paramBoolean) {
        i = 0;
      }
      localua.sQP = i;
      ub localub = new ub();
      localub.sQR = paramInt1;
      localub.sQS = paramInt2;
      localua.sQO = localub;
      localub.sQR = 0;
      localub.sQS = 0;
      localua.sQQ = localub;
      this.nQL.ttK = localua;
      this.mdD = this.nQL;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.k
 * JD-Core Version:    0.7.0.1
 */