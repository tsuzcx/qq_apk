package com.tencent.mm.wallet_core.d;

import android.content.Intent;
import com.tencent.mm.an.q;
import com.tencent.mm.ui.MMActivity;

public abstract class g
{
  public i YVX;
  public MMActivity activity;
  
  public g(MMActivity paramMMActivity, i parami)
  {
    this.activity = paramMMActivity;
    this.YVX = parami;
  }
  
  public boolean A(Object... paramVarArgs)
  {
    return false;
  }
  
  public boolean B(Object... paramVarArgs)
  {
    return false;
  }
  
  public CharSequence getTips(int paramInt)
  {
    return null;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public abstract boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq);
  
  public abstract boolean r(Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.g
 * JD-Core Version:    0.7.0.1
 */