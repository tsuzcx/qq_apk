package com.tencent.mm.plugin.recordvideo;

import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import java.util.Set;

public abstract interface a
  extends com.tencent.mm.kernel.b.a, com.tencent.mm.kernel.c.a
{
  public abstract Set<Class<? extends MMBaseAccessibilityConfig>> getAccessibilityConfigSet();
  
  public abstract void registerAccessibilityConfig(Class<? extends MMBaseAccessibilityConfig> paramClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.a
 * JD-Core Version:    0.7.0.1
 */