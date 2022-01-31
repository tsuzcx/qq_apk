package com.tencent.mm.plugin.subapp.b;

import com.tencent.mm.pluginsdk.h.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

final class b$a
{
  public String eZK;
  public Queue<String> pvv;
  
  b$a(String paramString)
  {
    this.eZK = paramString;
    this.pvv = new LinkedList();
    y.d("MicroMsg.PushMessageExtension", "DoSceneStruct:" + paramString);
    paramString = a.bm(ae.getContext(), paramString);
    if ((paramString == null) || (paramString.size() <= 0)) {
      y.e("MicroMsg.PushMessageExtension", "Parse Message Failed !");
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramString.size())
      {
        Object localObject = ((a)paramString.get(i)).rYd;
        if (localObject != null)
        {
          localObject = ((Map)localObject).entrySet().iterator();
          while (((Iterator)localObject).hasNext()) {
            this.pvv.offer(((Map.Entry)((Iterator)localObject).next()).getValue());
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.b.b.a
 * JD-Core Version:    0.7.0.1
 */