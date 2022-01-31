package com.tencent.mm.plugin.sns.b;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.ui.MMFragment;

public abstract interface b
  extends a
{
  public abstract String getAccSnsPath();
  
  public abstract String getAccSnsTmpPath();
  
  public abstract String getSnsAdPath();
  
  public abstract MMFragment instantiateAlbumFragment(Context paramContext, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.b.b
 * JD-Core Version:    0.7.0.1
 */