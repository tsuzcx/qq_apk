package com.tencent.mm.plugin.updater.a;

import com.tencent.mm.kernel.b.d;

public abstract interface a
  extends d
{
  public abstract void addManualCheckUpdateListener(b paramb);
  
  public abstract void clickAboutWechatRedDot();
  
  public abstract void clickBottomTabRedDot();
  
  public abstract void clickCheckUpdateRedDot();
  
  public abstract void clickSettingTabRedDot();
  
  public abstract int getUpdateVersion();
  
  public abstract boolean hasAboutWechatRedDot();
  
  public abstract boolean hasBottomTabRedDot();
  
  public abstract boolean hasCheckUpdateTabRedDot();
  
  public abstract boolean hasSettingTabRedDot();
  
  public abstract void manualCheckUpdate(int paramInt);
  
  public abstract boolean openUpdater();
  
  public abstract void removeManualCheckUpdateListener(b paramb);
  
  public abstract void setFullCheckUpdateRedDot(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.a.a
 * JD-Core Version:    0.7.0.1
 */