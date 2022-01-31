package com.tencent.mm.ui.chatting.l;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.e;
import java.lang.ref.WeakReference;
import java.util.Map;
import junit.framework.Assert;

public abstract class a
{
  WeakReference<a.b> vAl = null;
  
  public a(a.b paramb)
  {
    Assert.assertNotNull(paramb);
    this.vAl = new WeakReference(paramb);
    ((e)g.r(e.class)).a(cGZ(), new a.1(this));
  }
  
  abstract CharSequence b(Map<String, String> paramMap, String paramString, Bundle paramBundle, WeakReference<Context> paramWeakReference);
  
  abstract String cGZ();
  
  public final void release()
  {
    ((e)g.r(e.class)).Hb(cGZ());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.a
 * JD-Core Version:    0.7.0.1
 */