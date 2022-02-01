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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/SerialDescriptorBuilder;", "", "serialName", "", "(Ljava/lang/String;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "setAnnotations", "(Ljava/util/List;)V", "elementAnnotations", "", "getElementAnnotations$kotlinx_serialization_runtime", "elementDescriptors", "Lkotlinx/serialization/SerialDescriptor;", "getElementDescriptors$kotlinx_serialization_runtime", "elementNames", "getElementNames$kotlinx_serialization_runtime", "elementOptionality", "", "getElementOptionality$kotlinx_serialization_runtime", "isNullable", "()Z", "setNullable", "(Z)V", "getSerialName", "()Ljava/lang/String;", "uniqueNames", "", "element", "", "T", "elementName", "isOptional", "descriptor", "kotlinx-serialization-runtime"})
public final class o
{
  List<? extends Annotation> MVS;
  boolean NLA;
  final List<String> NLB;
  private final Set<String> NLC;
  final List<n> NLD;
  final List<List<Annotation>> NLE;
  final List<Boolean> NLF;
  private final String NLG;
  
  public o(String paramString)
  {
    AppMethodBeat.i(191024);
    this.NLG = paramString;
    this.MVS = ((List)v.MKE);
    this.NLB = ((List)new ArrayList());
    this.NLC = ((Set)new HashSet());
    this.NLD = ((List)new ArrayList());
    this.NLE = ((List)new ArrayList());
    this.NLF = ((List)new ArrayList());
    AppMethodBeat.o(191024);
  }
  
  private void a(String paramString, n paramn, List<? extends Annotation> paramList)
  {
    AppMethodBeat.i(191022);
    p.h(paramString, "elementName");
    p.h(paramn, "descriptor");
    p.h(paramList, "annotations");
    if (!this.NLC.add(paramString))
    {
      paramString = (Throwable)new IllegalArgumentException(("Element with name '" + paramString + "' is already registered").toString());
      AppMethodBeat.o(191022);
      throw paramString;
    }
    ((Collection)this.NLB).add(paramString);
    ((Collection)this.NLD).add(paramn);
    ((Collection)this.NLE).add(paramList);
    ((Collection)this.NLF).add(Boolean.FALSE);
    AppMethodBeat.o(191022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.o
 * JD-Core Version:    0.7.0.1
 */