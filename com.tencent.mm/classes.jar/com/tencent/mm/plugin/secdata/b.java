package com.tencent.mm.plugin.secdata;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/secdata/ActivityNamesSecData;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lcom/tencent/mm/plugin/secdata/ISecData;", "activityNameList", "", "", "clazz", "Ljava/lang/Class;", "type", "", "reuse", "", "(Ljava/util/List;Ljava/lang/Class;IZ)V", "getActivityNameList", "()Ljava/util/List;", "getClazz", "()Ljava/lang/Class;", "data", "getData", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;", "data$delegate", "Lkotlin/Lazy;", "check", "intent", "Landroid/content/Intent;", "getTransformData", "getType", "plugin-sec-data_release"})
public class b<T extends com.tencent.mm.bw.a>
  implements h<T>
{
  private final f CVQ;
  private final List<String> CVR;
  private final boolean CVS;
  final Class<T> aWC;
  private final int type;
  
  public b(List<String> paramList, Class<T> paramClass, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(219134);
    this.CVR = paramList;
    this.aWC = paramClass;
    this.type = paramInt;
    this.CVS = paramBoolean;
    this.CVQ = g.ah((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(219134);
  }
  
  public final boolean aS(Intent paramIntent)
  {
    AppMethodBeat.i(219132);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getComponent();
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getClassName();
        if (paramIntent != null)
        {
          paramIntent = n.a((CharSequence)paramIntent, new String[] { "." });
          if (paramIntent != null)
          {
            String str = (String)j.kv(paramIntent);
            paramIntent = str;
            if (str != null) {
              break label65;
            }
          }
        }
      }
      paramIntent = "";
      label65:
      boolean bool = this.CVR.contains(paramIntent);
      AppMethodBeat.o(219132);
      return bool;
    }
    AppMethodBeat.o(219132);
    return false;
  }
  
  public final T eSl()
  {
    AppMethodBeat.i(219133);
    com.tencent.mm.bw.a locala = (com.tencent.mm.bw.a)this.CVQ.getValue();
    p.g(locala, "data");
    AppMethodBeat.o(219133);
    return locala;
  }
  
  public final boolean eSm()
  {
    return this.CVS;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;"})
  static final class a
    extends q
    implements kotlin.g.a.a<T>
  {
    a(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.b
 * JD-Core Version:    0.7.0.1
 */