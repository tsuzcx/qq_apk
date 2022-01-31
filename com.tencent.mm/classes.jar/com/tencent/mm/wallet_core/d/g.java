package com.tencent.mm.wallet_core.d;

import android.content.Intent;
import com.tencent.mm.ah.m;
import com.tencent.mm.ui.MMActivity;

public abstract class g
{
  public MMActivity gfb;
  public i wBd;
  
  public g(MMActivity paramMMActivity, i parami)
  {
    this.gfb = paramMMActivity;
    this.wBd = parami;
  }
  
  public abstract boolean c(int paramInt1, int paramInt2, String paramString, m paramm);
  
  public abstract boolean m(Object... paramVarArgs);
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public boolean s(Object... paramVarArgs)
  {
    return false;
  }
  
  public boolean t(Object... paramVarArgs)
  {
    return false;
  }
  
  public CharSequence vy(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.g
 * JD-Core Version:    0.7.0.1
 */