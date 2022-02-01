package com.tencent.mm.plugin.profile.ui.tab.observer;

import android.arch.lifecycle.LifecycleObserver;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.f;

public abstract interface IBizProfileOperateObserver
  extends LifecycleObserver
{
  public abstract boolean a(f paramf, as paramas);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.observer.IBizProfileOperateObserver
 * JD-Core Version:    0.7.0.1
 */