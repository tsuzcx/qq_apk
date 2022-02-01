package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.g.b.p;
import d.l;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/SerialDescriptorBuilder;", "", "serialName", "", "(Ljava/lang/String;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "setAnnotations", "(Ljava/util/List;)V", "elementAnnotations", "", "getElementAnnotations$kotlinx_serialization_runtime", "elementDescriptors", "Lkotlinx/serialization/SerialDescriptor;", "getElementDescriptors$kotlinx_serialization_runtime", "elementNames", "getElementNames$kotlinx_serialization_runtime", "elementOptionality", "", "getElementOptionality$kotlinx_serialization_runtime", "isNullable", "()Z", "setNullable", "(Z)V", "getSerialName", "()Ljava/lang/String;", "uniqueNames", "", "element", "", "T", "elementName", "isOptional", "descriptor", "kotlinx-serialization-runtime"})
public final class o
{
  List<? extends Annotation> NsX;
  boolean OiG;
  final List<String> OiH;
  private final Set<String> OiI;
  final List<n> OiJ;
  final List<List<Annotation>> OiK;
  final List<Boolean> OiL;
  private final String OiM;
  
  public o(String paramString)
  {
    AppMethodBeat.i(199612);
    this.OiM = paramString;
    this.NsX = ((List)v.NhH);
    this.OiH = ((List)new ArrayList());
    this.OiI = ((Set)new HashSet());
    this.OiJ = ((List)new ArrayList());
    this.OiK = ((List)new ArrayList());
    this.OiL = ((List)new ArrayList());
    AppMethodBeat.o(199612);
  }
  
  private void a(String paramString, n paramn, List<? extends Annotation> paramList)
  {
    AppMethodBeat.i(199610);
    p.h(paramString, "elementName");
    p.h(paramn, "descriptor");
    p.h(paramList, "annotations");
    if (!this.OiI.add(paramString))
    {
      paramString = (Throwable)new IllegalArgumentException(("Element with name '" + paramString + "' is already registered").toString());
      AppMethodBeat.o(199610);
      throw paramString;
    }
    ((Collection)this.OiH).add(paramString);
    ((Collection)this.OiJ).add(paramn);
    ((Collection)this.OiK).add(paramList);
    ((Collection)this.OiL).add(Boolean.FALSE);
    AppMethodBeat.o(199610);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.o
 * JD-Core Version:    0.7.0.1
 */