package com.tencent.mm.pluginsdk.model;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;
import junit.framework.Assert;

public abstract class k<Params, Progress, Result>
{
  private boolean bSr = false;
  ah handler = new ah(Looper.getMainLooper());
  
  public abstract ah byB();
  
  public abstract Result cj();
  
  public void onPostExecute(Result paramResult) {}
  
  public final boolean p(Params... paramVarArgs)
  {
    if (this.bSr) {
      Assert.assertTrue("MicroMsg.MMAsyncTask Should construct a new Task", false);
    }
    this.bSr = true;
    q(paramVarArgs);
    ah localah = byB();
    if (localah == null) {
      return false;
    }
    localah.post(new k.1(this, paramVarArgs));
    return true;
  }
  
  public void q(Params... paramVarArgs) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.k
 * JD-Core Version:    0.7.0.1
 */