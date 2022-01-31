package com.tencent.mm.pluginsdk.model;

import android.os.Looper;
import com.tencent.mm.sdk.g.b.a;
import com.tencent.mm.sdk.platformtools.ak;
import junit.framework.Assert;

public abstract class k<Params, Progress, Result>
{
  ak handler = new ak(Looper.getMainLooper());
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
    w(paramVarArgs);
    a locala = cjN();
    if (locala == null) {
      return false;
    }
    locala.execute(new k.1(this, paramVarArgs));
    return true;
  }
  
  public void w(Params... paramVarArgs) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.k
 * JD-Core Version:    0.7.0.1
 */