package com.tencent.mm.plugin.subapp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.h.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

final class b$a
{
  public String grD;
  public Queue<String> sXa;
  
  b$a(String paramString)
  {
    AppMethodBeat.i(25240);
    this.grD = paramString;
    this.sXa = new LinkedList();
    ab.d("MicroMsg.PushMessageExtension", "DoSceneStruct:".concat(String.valueOf(paramString)));
    paramString = a.by(ah.getContext(), paramString);
    if ((paramString == null) || (paramString.size() <= 0))
    {
      ab.e("MicroMsg.PushMessageExtension", "Parse Message Failed !");
      AppMethodBeat.o(25240);
      return;
    }
    int i = 0;
    while (i < paramString.size())
    {
      Object localObject = ((a)paramString.get(i)).vOU;
      if (localObject != null)
      {
        localObject = ((Map)localObject).entrySet().iterator();
        while (((Iterator)localObject).hasNext()) {
          this.sXa.offer(((Map.Entry)((Iterator)localObject).next()).getValue());
        }
      }
      i += 1;
    }
    AppMethodBeat.o(25240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.b.b.a
 * JD-Core Version:    0.7.0.1
 */