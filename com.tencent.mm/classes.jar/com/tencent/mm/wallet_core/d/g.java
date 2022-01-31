package com.tencent.mm.wallet_core.d;

import android.content.Intent;
import com.tencent.mm.ai.m;
import com.tencent.mm.ui.MMActivity;

public abstract class g
{
  public i AXB;
  public MMActivity hwZ;
  
  public g(MMActivity paramMMActivity, i parami)
  {
    this.hwZ = paramMMActivity;
    this.AXB = parami;
  }
  
  public CharSequence getTips(int paramInt)
  {
    return null;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public abstract boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm);
  
  public abstract boolean p(Object... paramVarArgs);
  
  public boolean x(Object... paramVarArgs)
  {
    return false;
  }
  
  public boolean y(Object... paramVarArgs)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.g
 * JD-Core Version:    0.7.0.1
 */