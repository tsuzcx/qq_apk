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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/SerialDescriptorBuilder;", "", "serialName", "", "(Ljava/lang/String;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "setAnnotations", "(Ljava/util/List;)V", "elementAnnotations", "", "getElementAnnotations$kotlinx_serialization_runtime", "elementDescriptors", "Lkotlinx/serialization/SerialDescriptor;", "getElementDescriptors$kotlinx_serialization_runtime", "elementNames", "getElementNames$kotlinx_serialization_runtime", "elementOptionality", "", "getElementOptionality$kotlinx_serialization_runtime", "isNullable", "()Z", "setNullable", "(Z)V", "getSerialName", "()Ljava/lang/String;", "uniqueNames", "", "element", "", "T", "elementName", "isOptional", "descriptor", "kotlinx-serialization-runtime"})
public final class o
{
  List<? extends Annotation> aaLz;
  boolean abAR;
  final List<String> abAS;
  private final Set<String> abAT;
  final List<n> abAU;
  final List<List<Annotation>> abAV;
  final List<Boolean> abAW;
  private final String abAX;
  
  public o(String paramString)
  {
    AppMethodBeat.i(254218);
    this.abAX = paramString;
    this.aaLz = ((List)v.aaAd);
    this.abAS = ((List)new ArrayList());
    this.abAT = ((Set)new HashSet());
    this.abAU = ((List)new ArrayList());
    this.abAV = ((List)new ArrayList());
    this.abAW = ((List)new ArrayList());
    AppMethodBeat.o(254218);
  }
  
  private void a(String paramString, n paramn, List<? extends Annotation> paramList)
  {
    AppMethodBeat.i(254212);
    p.k(paramString, "elementName");
    p.k(paramn, "descriptor");
    p.k(paramList, "annotations");
    if (!this.abAT.add(paramString))
    {
      paramString = (Throwable)new IllegalArgumentException(("Element with name '" + paramString + "' is already registered").toString());
      AppMethodBeat.o(254212);
      throw paramString;
    }
    ((Collection)this.abAS).add(paramString);
    ((Collection)this.abAU).add(paramn);
    ((Collection)this.abAV).add(paramList);
    ((Collection)this.abAW).add(Boolean.FALSE);
    AppMethodBeat.o(254212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.o
 * JD-Core Version:    0.7.0.1
 */