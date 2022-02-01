package com.tencent.mm.plugin.sns.cover.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.tencent.mm.protocal.protobuf.FinderObject;

public abstract class a
  extends RelativeLayout
{
  public a(Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(getLayoutId(), this, true);
  }
  
  public void L(FinderObject paramFinderObject) {}
  
  public abstract void a(b paramb);
  
  public abstract void etL();
  
  public abstract void etM();
  
  public abstract void etO();
  
  public abstract int getLayoutId();
  
  public abstract int getType();
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onPostClose();
  
  public abstract void onResume();
  
  public void setCoverFoldStatusProvider(e parame) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.cover.a.a
 * JD-Core Version:    0.7.0.1
 */