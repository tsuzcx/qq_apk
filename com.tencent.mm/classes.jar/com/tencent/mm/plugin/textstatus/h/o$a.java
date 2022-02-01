package com.tencent.mm.plugin.textstatus.h;

import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$Listener;", "", "subject", "key", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "ref", "Ljava/lang/ref/WeakReference;", "getRef", "()Ljava/lang/ref/WeakReference;", "setRef", "(Ljava/lang/ref/WeakReference;)V", "notDeadToRun", "", "onChange", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class o$a
{
  String key;
  public WeakReference<Object> tzB;
  
  public o$a(Object paramObject, String arg2)
  {
    this.key = ???;
    ??? = new WeakReference(paramObject);
    s.u(???, "<set-?>");
    this.tzB = ???;
    synchronized (o.hHz())
    {
      o.hHz().put(Integer.valueOf(paramObject.hashCode()), this);
      return;
    }
  }
  
  public final WeakReference<Object> hHA()
  {
    WeakReference localWeakReference = this.tzB;
    if (localWeakReference != null) {
      return localWeakReference;
    }
    s.bIx("ref");
    return null;
  }
  
  public abstract void onChange();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.o.a
 * JD-Core Version:    0.7.0.1
 */