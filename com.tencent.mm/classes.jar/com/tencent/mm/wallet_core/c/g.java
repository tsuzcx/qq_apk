package com.tencent.mm.wallet_core.c;

import android.content.Intent;
import com.tencent.mm.am.p;
import com.tencent.mm.ui.MMActivity;

public abstract class g
{
  public MMActivity activity;
  public i agTR;
  
  public g(MMActivity paramMMActivity, i parami)
  {
    this.activity = paramMMActivity;
    this.agTR = parami;
  }
  
  public boolean D(Object... paramVarArgs)
  {
    return false;
  }
  
  public boolean E(Object... paramVarArgs)
  {
    return false;
  }
  
  public CharSequence getTips(int paramInt)
  {
    return null;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public abstract boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp);
  
  public abstract boolean t(Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.g
 * JD-Core Version:    0.7.0.1
 */