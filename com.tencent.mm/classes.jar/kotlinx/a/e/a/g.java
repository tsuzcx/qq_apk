package kotlinx.a.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlinx.a.b.i.b;
import kotlinx.a.d.af;
import kotlinx.a.e.d;
import kotlinx.a.e.j;
import kotlinx.a.e.l;
import kotlinx.a.e.m;
import kotlinx.a.e.n;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/json/internal/JsonTreeDecoder;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonObject;", "polyDiscriminator", "", "polyDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "position", "", "getValue", "()Lkotlinx/serialization/json/JsonObject;", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "descriptor", "coerceInputValue", "", "index", "tag", "currentElement", "Lkotlinx/serialization/json/JsonElement;", "decodeElementIndex", "endStructure", "", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
class g
  extends a
{
  private final m ajEG;
  private final String ajEH;
  private final kotlinx.a.b.e ajEI;
  private int position;
  
  public g(kotlinx.a.e.a parama, m paramm, String paramString, kotlinx.a.b.e parame)
  {
    super(parama, (kotlinx.a.e.e)paramm, (byte)0);
    AppMethodBeat.i(188526);
    this.ajEG = paramm;
    this.ajEH = paramString;
    this.ajEI = parame;
    AppMethodBeat.o(188526);
  }
  
  public void b(kotlinx.a.b.e parame)
  {
    AppMethodBeat.i(188588);
    s.u(parame, "descriptor");
    if ((this.ajEb.ajEr) || ((parame.kFd() instanceof kotlinx.a.b.c)))
    {
      AppMethodBeat.o(188588);
      return;
    }
    Object localObject = af.h(parame);
    Iterator localIterator = kFM().keySet().iterator();
    while (localIterator.hasNext())
    {
      parame = (String)localIterator.next();
      if ((!((Set)localObject).contains(parame)) && ((s.p(parame, this.ajEH) ^ true)))
      {
        localObject = kFM().toString();
        s.u(parame, "key");
        s.u(localObject, "input");
        parame = (Throwable)new d(-1, "JSON encountered unknown key: '" + parame + "'. You can enable 'JsonBuilder.ignoreUnknownKeys' property to ignore unknown keys.\n JSON input: " + j.jQ((String)localObject, -1));
        AppMethodBeat.o(188588);
        throw parame;
      }
    }
    AppMethodBeat.o(188588);
  }
  
  protected kotlinx.a.e.e bJQ(String paramString)
  {
    AppMethodBeat.i(188565);
    s.u(paramString, "tag");
    paramString = (kotlinx.a.e.e)ak.e((Map)kFM(), paramString);
    AppMethodBeat.o(188565);
    return paramString;
  }
  
  public final kotlinx.a.c.c c(kotlinx.a.b.e parame)
  {
    AppMethodBeat.i(188577);
    s.u(parame, "descriptor");
    if (parame == this.ajEI)
    {
      parame = (kotlinx.a.c.c)this;
      AppMethodBeat.o(188577);
      return parame;
    }
    parame = super.c(parame);
    AppMethodBeat.o(188577);
    return parame;
  }
  
  public int g(kotlinx.a.b.e parame)
  {
    AppMethodBeat.i(188551);
    s.u(parame, "descriptor");
    while (this.position < parame.kFb())
    {
      int i = this.position;
      this.position = (i + 1);
      Object localObject = e(parame, i);
      if (((Map)kFM()).containsKey(localObject))
      {
        kotlinx.a.b.e locale1;
        if (this.ajEb.ajEw)
        {
          locale1 = parame.aMJ(this.position - 1);
          if ((!(bJQ((String)localObject) instanceof l)) || (locale1.kFc())) {
            break label124;
          }
          i = 1;
        }
        while (i == 0)
        {
          i = this.position;
          AppMethodBeat.o(188551);
          return i - 1;
          label124:
          if (s.p(locale1.kFd(), i.b.ajDi))
          {
            kotlinx.a.e.e locale = bJQ((String)localObject);
            localObject = locale;
            if (!(locale instanceof n)) {
              localObject = null;
            }
            localObject = (n)localObject;
            if (localObject != null)
            {
              s.u(localObject, "$this$contentOrNull");
              if (!(localObject instanceof l)) {
                break label193;
              }
              localObject = null;
              if (localObject != null) {
                break label201;
              }
            }
          }
          label184:
          label193:
          label201:
          while (locale1.bJN((String)localObject) != -3)
          {
            i = 0;
            break;
            localObject = ((n)localObject).getContent();
            break label184;
          }
          i = 1;
        }
      }
    }
    AppMethodBeat.o(188551);
    return -1;
  }
  
  public m kFM()
  {
    return this.ajEG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.e.a.g
 * JD-Core Version:    0.7.0.1
 */