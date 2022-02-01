package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "", "serialName", "", "(Ljava/lang/String;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "setAnnotations", "(Ljava/util/List;)V", "elementAnnotations", "", "getElementAnnotations$kotlinx_serialization_runtime", "elementDescriptors", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getElementDescriptors$kotlinx_serialization_runtime", "elementNames", "getElementNames$kotlinx_serialization_runtime", "elementOptionality", "", "getElementOptionality$kotlinx_serialization_runtime", "isNullable", "isNullable$annotations", "()V", "()Z", "setNullable", "(Z)V", "getSerialName", "()Ljava/lang/String;", "uniqueNames", "", "descriptor", "T", "element", "", "elementName", "isOptional", "listDescriptor", "typeDescriptor", "mapDescriptor", "K", "V", "keyDescriptor", "valueDescriptor", "setDescriptor", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public final class a
{
  List<? extends Annotation> aYF;
  final List<String> ajCB;
  private final Set<String> ajCC;
  final List<e> ajCD;
  final List<List<Annotation>> ajCE;
  final List<Boolean> ajCF;
  private final String ajCG;
  
  public a(String paramString)
  {
    AppMethodBeat.i(188437);
    this.ajCG = paramString;
    this.aYF = ((List)ab.aivy);
    this.ajCB = ((List)new ArrayList());
    this.ajCC = ((Set)new HashSet());
    this.ajCD = ((List)new ArrayList());
    this.ajCE = ((List)new ArrayList());
    this.ajCF = ((List)new ArrayList());
    AppMethodBeat.o(188437);
  }
  
  private void a(String paramString, e parame, List<? extends Annotation> paramList)
  {
    AppMethodBeat.i(188425);
    s.u(paramString, "elementName");
    s.u(parame, "descriptor");
    s.u(paramList, "annotations");
    if (!this.ajCC.add(paramString))
    {
      paramString = (Throwable)new IllegalArgumentException(("Element with name '" + paramString + "' is already registered").toString());
      AppMethodBeat.o(188425);
      throw paramString;
    }
    ((Collection)this.ajCB).add(paramString);
    ((Collection)this.ajCD).add(parame);
    ((Collection)this.ajCE).add(paramList);
    ((Collection)this.ajCF).add(Boolean.FALSE);
    AppMethodBeat.o(188425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.b.a
 * JD-Core Version:    0.7.0.1
 */