package com.tencent.mm.plugin.secdata;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/secdata/ActivityNamesSecData;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lcom/tencent/mm/plugin/secdata/ISecData;", "activityNameList", "", "", "clazz", "Ljava/lang/Class;", "type", "", "reuse", "", "(Ljava/util/List;Ljava/lang/Class;IZ)V", "getActivityNameList", "()Ljava/util/List;", "getClazz", "()Ljava/lang/Class;", "data", "kotlin.jvm.PlatformType", "getData", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;", "data$delegate", "Lkotlin/Lazy;", "check", "intent", "Landroid/content/Intent;", "getTransformData", "getType", "plugin-sec-data_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b<T extends com.tencent.mm.bx.a>
  implements h<T>
{
  private final List<String> Plt;
  private final boolean Plu;
  private final j Plv;
  final Class<T> clazz;
  private final int type;
  
  public b(List<String> paramList, Class<T> paramClass, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(261422);
    this.Plt = paramList;
    this.clazz = paramClass;
    this.type = paramInt;
    this.Plu = paramBoolean;
    this.Plv = k.cm((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(261422);
  }
  
  public final boolean bp(Intent paramIntent)
  {
    AppMethodBeat.i(261432);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getComponent();
      if (paramIntent == null) {
        paramIntent = "";
      }
      for (;;)
      {
        boolean bool = this.Plt.contains(paramIntent);
        AppMethodBeat.o(261432);
        return bool;
        paramIntent = paramIntent.getClassName();
        if (paramIntent == null)
        {
          paramIntent = "";
        }
        else
        {
          paramIntent = n.a((CharSequence)paramIntent, new String[] { "." });
          if (paramIntent == null)
          {
            paramIntent = "";
          }
          else
          {
            String str = (String)p.oN(paramIntent);
            paramIntent = str;
            if (str == null) {
              paramIntent = "";
            }
          }
        }
      }
    }
    AppMethodBeat.o(261432);
    return false;
  }
  
  public final T gUv()
  {
    AppMethodBeat.i(261442);
    com.tencent.mm.bx.a locala = (com.tencent.mm.bx.a)this.Plv.getValue();
    s.s(locala, "data");
    AppMethodBeat.o(261442);
    return locala;
  }
  
  public final boolean gUw()
  {
    return this.Plu;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "T", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/protobuf/BaseProtoBuf;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<T>
  {
    a(b<T> paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.b
 * JD-Core Version:    0.7.0.1
 */