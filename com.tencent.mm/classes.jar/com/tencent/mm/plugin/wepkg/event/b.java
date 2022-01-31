package com.tencent.mm.plugin.wepkg.event;

import android.os.Parcelable;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b
{
  private static ConcurrentLinkedQueue<a> rOP = new ConcurrentLinkedQueue();
  
  public static <T extends Parcelable> void a(T paramT, b.a parama)
  {
    ToolsProcessIPCService.a(paramT, b.b.class, new b.1(parama));
  }
  
  public static void a(a parama)
  {
    rOP.add(parama);
  }
  
  public static void b(a parama)
  {
    rOP.remove(parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.event.b
 * JD-Core Version:    0.7.0.1
 */