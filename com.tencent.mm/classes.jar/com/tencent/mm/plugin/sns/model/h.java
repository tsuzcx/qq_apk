package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.sdk.g.b.a;
import com.tencent.mm.sdk.platformtools.ak;
import junit.framework.Assert;

public abstract class h<Params, Progress, Result>
{
  ak handler = ag.bEf();
  private boolean isStart = false;
  
  public abstract Result cL();
  
  public abstract a cjN();
  
  public void onPostExecute(Result paramResult) {}
  
  public final boolean v(Params... paramVarArgs)
  {
    if (this.isStart) {
      Assert.assertTrue("MicroMsg.MMAsyncTask Should construct a new Task", false);
    }
    this.isStart = true;
    a locala = cjN();
    if (locala == null) {
      return false;
    }
    locala.execute(new h.1(this, paramVarArgs));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.h
 * JD-Core Version:    0.7.0.1
 */