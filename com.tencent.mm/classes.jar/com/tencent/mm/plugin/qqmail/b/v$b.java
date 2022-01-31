package com.tencent.mm.plugin.qqmail.b;

import android.os.AsyncTask;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ai;

final class v$b
  extends AsyncTask<v.d, Integer, v.d>
  implements n.a
{
  private n nev;
  v.d jdField_new;
  
  private v$b(v paramv) {}
  
  public final boolean b(v.d paramd)
  {
    if (!paramd.neF.onReady()) {
      return false;
    }
    this.jdField_new = paramd;
    super.execute(new v.d[] { paramd });
    return true;
  }
  
  public final void btt()
  {
    publishProgress(new Integer[] { Integer.valueOf(0) });
  }
  
  protected final void onCancelled()
  {
    g.DQ();
    g.DS().O(new v.b.1(this));
    super.onCancelled();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.v.b
 * JD-Core Version:    0.7.0.1
 */