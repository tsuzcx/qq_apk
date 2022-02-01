package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/SerialDescriptorBuilder;", "", "serialName", "", "(Ljava/lang/String;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "setAnnotations", "(Ljava/util/List;)V", "elementAnnotations", "", "getElementAnnotations$kotlinx_serialization_runtime", "elementDescriptors", "Lkotlinx/serialization/SerialDescriptor;", "getElementDescriptors$kotlinx_serialization_runtime", "elementNames", "getElementNames$kotlinx_serialization_runtime", "elementOptionality", "", "getElementOptionality$kotlinx_serialization_runtime", "isNullable", "()Z", "setNullable", "(Z)V", "getSerialName", "()Ljava/lang/String;", "uniqueNames", "", "element", "", "T", "elementName", "isOptional", "descriptor", "kotlinx-serialization-runtime"})
public final class o
{
  boolean TXC;
  final List<String> TXD;
  private final Set<String> TXE;
  final List<n> TXF;
  final List<List<Annotation>> TXG;
  final List<Boolean> TXH;
  private final String TXI;
  List<? extends Annotation> TiF;
  
  public o(String paramString)
  {
    AppMethodBeat.i(225384);
    this.TXI = paramString;
    this.TiF = ((List)v.SXr);
    this.TXD = ((List)new ArrayList());
    this.TXE = ((Set)new HashSet());
    this.TXF = ((List)new ArrayList());
    this.TXG = ((List)new ArrayList());
    this.TXH = ((List)new ArrayList());
    AppMethodBeat.o(225384);
  }
  
  private void a(String paramString, n paramn, List<? extends Annotation> paramList)
  {
    AppMethodBeat.i(225382);
    p.h(paramString, "elementName");
    p.h(paramn, "descriptor");
    p.h(paramList, "annotations");
    if (!this.TXE.add(paramString))
    {
      paramString = (Throwable)new IllegalArgumentException(("Element with name '" + paramString + "' is already registered").toString());
      AppMethodBeat.o(225382);
      throw paramString;
    }
    ((Collection)this.TXD).add(paramString);
    ((Collection)this.TXF).add(paramn);
    ((Collection)this.TXG).add(paramList);
    ((Collection)this.TXH).add(Boolean.FALSE);
    AppMethodBeat.o(225382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.o
 * JD-Core Version:    0.7.0.1
 */