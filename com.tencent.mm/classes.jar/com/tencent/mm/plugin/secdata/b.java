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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/secdata/ActivityNamesSecData;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lcom/tencent/mm/plugin/secdata/ISecData;", "activityNameList", "", "", "clazz", "Ljava/lang/Class;", "type", "", "reuse", "", "(Ljava/util/List;Ljava/lang/Class;IZ)V", "getActivityNameList", "()Ljava/util/List;", "getClazz", "()Ljava/lang/Class;", "data", "getData", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;", "data$delegate", "Lkotlin/Lazy;", "check", "intent", "Landroid/content/Intent;", "getTransformData", "getType", "plugin-sec-data_release"})
public class b<T extends com.tencent.mm.cd.a>
  implements h<T>
{
  private final f JbC;
  private final List<String> JbD;
  private final boolean JbE;
  final Class<T> aFS;
  private final int type;
  
  public b(List<String> paramList, Class<T> paramClass, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(197936);
    this.JbD = paramList;
    this.aFS = paramClass;
    this.type = paramInt;
    this.JbE = paramBoolean;
    this.JbC = g.ar((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(197936);
  }
  
  public final boolean aR(Intent paramIntent)
  {
    AppMethodBeat.i(197929);
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
            String str = (String)j.lr(paramIntent);
            paramIntent = str;
            if (str != null) {
              break label65;
            }
          }
        }
      }
      paramIntent = "";
      label65:
      boolean bool = this.JbD.contains(paramIntent);
      AppMethodBeat.o(197929);
      return bool;
    }
    AppMethodBeat.o(197929);
    return false;
  }
  
  public final T fFn()
  {
    AppMethodBeat.i(197932);
    com.tencent.mm.cd.a locala = (com.tencent.mm.cd.a)this.JbC.getValue();
    p.j(locala, "data");
    AppMethodBeat.o(197932);
    return locala;
  }
  
  public final boolean fFo()
  {
    return this.JbE;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.b
 * JD-Core Version:    0.7.0.1
 */