package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.sdk.platformtools.ah;
import junit.framework.Assert;

public abstract class h<Params, Progress, Result>
{
  private boolean bSr = false;
  ah handler = af.aXq();
  
  public abstract ah byB();
  
  public abstract Result cj();
  
  public void onPostExecute(Result paramResult) {}
  
  public final boolean p(Params... paramVarArgs)
  {
    if (this.bSr) {
      Assert.assertTrue("MicroMsg.MMAsyncTask Should construct a new Task", false);
    }
    this.bSr = true;
    ah localah = byB();
    if (localah == null) {
      return false;
    }
    localah.post(new h.1(this, paramVarArgs));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.h
 * JD-Core Version:    0.7.0.1
 */