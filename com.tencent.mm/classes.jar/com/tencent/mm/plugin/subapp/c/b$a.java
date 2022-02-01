package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.k.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

final class b$a
{
  public Queue<String> SEY;
  public String pJo;
  
  b$a(String paramString)
  {
    AppMethodBeat.i(28919);
    this.pJo = paramString;
    this.SEY = new LinkedList();
    Log.d("MicroMsg.PushMessageExtension", "DoSceneStruct:".concat(String.valueOf(paramString)));
    paramString = a.cJ(MMApplicationContext.getContext(), paramString);
    if ((paramString == null) || (paramString.size() <= 0))
    {
      Log.e("MicroMsg.PushMessageExtension", "Parse Message Failed !");
      AppMethodBeat.o(28919);
      return;
    }
    int i = 0;
    while (i < paramString.size())
    {
      Object localObject = ((a)paramString.get(i)).XXi;
      if (localObject != null)
      {
        localObject = ((Map)localObject).entrySet().iterator();
        while (((Iterator)localObject).hasNext()) {
          this.SEY.offer((String)((Map.Entry)((Iterator)localObject).next()).getValue());
        }
      }
      i += 1;
    }
    AppMethodBeat.o(28919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.b.a
 * JD-Core Version:    0.7.0.1
 */