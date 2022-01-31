package com.tencent.mm.ui.chatting.m;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.e;
import java.lang.ref.WeakReference;
import java.util.Map;
import junit.framework.Assert;

public abstract class a
{
  WeakReference<a.b> zQJ = null;
  
  public a(a.b paramb)
  {
    Assert.assertNotNull(paramb);
    this.zQJ = new WeakReference(paramb);
    ((e)g.E(e.class)).a(dLm(), new a.1(this));
  }
  
  abstract CharSequence b(Map<String, String> paramMap, String paramString, Bundle paramBundle, WeakReference<Context> paramWeakReference);
  
  abstract String dLm();
  
  public final void release()
  {
    ((e)g.E(e.class)).SM(dLm());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.a
 * JD-Core Version:    0.7.0.1
 */