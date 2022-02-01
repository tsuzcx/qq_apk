package com.tencent.mm.plugin.ringtone.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/utils/RingtoneUtils;", "", "()V", "parserXML", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "strXML", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c OFT;
  
  static
  {
    AppMethodBeat.i(272992);
    OFT = new c();
    AppMethodBeat.o(272992);
  }
  
  public static ArrayList<String> aUA(String paramString)
  {
    AppMethodBeat.i(272984);
    s.u(paramString, "strXML");
    ArrayList localArrayList = new ArrayList();
    paramString = ((Iterable)n.b((CharSequence)paramString, new String[] { "</em>" })).iterator();
    while (paramString.hasNext())
    {
      Object localObject = (String)paramString.next();
      if (n.i((CharSequence)localObject, (CharSequence)"<em>"))
      {
        localObject = (String)localObject + "</em>";
        if (localObject != null)
        {
          localObject = XmlParser.parseXml((String)localObject, "em", null);
          if (localObject != null)
          {
            localObject = (String)((Map)localObject).get(".em");
            if (localObject != null) {
              localArrayList.add(localObject);
            }
          }
        }
      }
    }
    AppMethodBeat.o(272984);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.l.c
 * JD-Core Version:    0.7.0.1
 */