package com.tencent.soter.a;

import android.content.Context;
import com.tencent.soter.a.b.b;
import com.tencent.soter.a.g.e;
import com.tencent.soter.a.g.f;
import com.tencent.soter.a.g.j;

public final class a$1
  implements Runnable
{
  public a$1(Context paramContext, e parame, b paramb) {}
  
  public final void run()
  {
    j localj = new j(this.val$context, this.wPt);
    localj.wPW = this.wPu;
    if (!f.cPH().a(localj, new com.tencent.soter.a.b.d())) {
      com.tencent.soter.core.c.d.e("Soter.SoterWrapperApi", "soter: add init task failed.", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.a.a.1
 * JD-Core Version:    0.7.0.1
 */