package d.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.x;
import d.ac;
import d.g.b.q;
import d.g.b.u;
import d.g.b.z;
import d.i.c;
import d.l.b.a.b.b.av;
import d.l.b.a.b.m.ab;
import java.util.Set;

public final class j
  implements i
{
  private final c NQZ;
  private final c NRA;
  final c NRB;
  final c NRC;
  final c NRD;
  private final c NRE;
  final c NRF;
  final c NRG;
  final c NRH;
  private final c NRI;
  final c NRJ;
  private final c NRK;
  private final c NRL;
  final c NRM;
  private final c NRN;
  private final c NRO;
  private final c NRP;
  private final c NRQ;
  private final c NRR;
  private final c NRS;
  private final c NRT;
  private final c NRU;
  final c NRa;
  final c NRb;
  private final c NRc;
  private final c NRd;
  private final c NRe;
  private final c NRf;
  final c NRg;
  private final c NRh;
  final c NRi;
  final c NRj;
  private final c NRk;
  final c NRl;
  private final c NRm;
  final c NRn;
  final c NRo;
  private final c NRp;
  private final c NRq;
  private final c NRr;
  private final c NRs;
  private final c NRt;
  final c NRu;
  final c NRv;
  private final c NRw;
  private final c NRx;
  private final c NRy;
  private final c NRz;
  boolean aIe;
  
  static
  {
    AppMethodBeat.i(59810);
    cxA = new d.l.k[] { (d.l.k)z.a(new u(z.bp(j.class), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;")), (d.l.k)z.a(new u(z.bp(j.class), "withDefinedIn", "getWithDefinedIn()Z")), (d.l.k)z.a(new u(z.bp(j.class), "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z")), (d.l.k)z.a(new u(z.bp(j.class), "modifiers", "getModifiers()Ljava/util/Set;")), (d.l.k)z.a(new u(z.bp(j.class), "startFromName", "getStartFromName()Z")), (d.l.k)z.a(new u(z.bp(j.class), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z")), (d.l.k)z.a(new u(z.bp(j.class), "debugMode", "getDebugMode()Z")), (d.l.k)z.a(new u(z.bp(j.class), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z")), (d.l.k)z.a(new u(z.bp(j.class), "verbose", "getVerbose()Z")), (d.l.k)z.a(new u(z.bp(j.class), "unitReturnType", "getUnitReturnType()Z")), (d.l.k)z.a(new u(z.bp(j.class), "withoutReturnType", "getWithoutReturnType()Z")), (d.l.k)z.a(new u(z.bp(j.class), "enhancedTypes", "getEnhancedTypes()Z")), (d.l.k)z.a(new u(z.bp(j.class), "normalizedVisibilities", "getNormalizedVisibilities()Z")), (d.l.k)z.a(new u(z.bp(j.class), "renderDefaultVisibility", "getRenderDefaultVisibility()Z")), (d.l.k)z.a(new u(z.bp(j.class), "renderDefaultModality", "getRenderDefaultModality()Z")), (d.l.k)z.a(new u(z.bp(j.class), "renderConstructorDelegation", "getRenderConstructorDelegation()Z")), (d.l.k)z.a(new u(z.bp(j.class), "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z")), (d.l.k)z.a(new u(z.bp(j.class), "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z")), (d.l.k)z.a(new u(z.bp(j.class), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z")), (d.l.k)z.a(new u(z.bp(j.class), "includePropertyConstant", "getIncludePropertyConstant()Z")), (d.l.k)z.a(new u(z.bp(j.class), "withoutTypeParameters", "getWithoutTypeParameters()Z")), (d.l.k)z.a(new u(z.bp(j.class), "withoutSuperTypes", "getWithoutSuperTypes()Z")), (d.l.k)z.a(new u(z.bp(j.class), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;")), (d.l.k)z.a(new u(z.bp(j.class), "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;")), (d.l.k)z.a(new u(z.bp(j.class), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z")), (d.l.k)z.a(new u(z.bp(j.class), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;")), (d.l.k)z.a(new u(z.bp(j.class), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;")), (d.l.k)z.a(new u(z.bp(j.class), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;")), (d.l.k)z.a(new u(z.bp(j.class), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;")), (d.l.k)z.a(new u(z.bp(j.class), "receiverAfterName", "getReceiverAfterName()Z")), (d.l.k)z.a(new u(z.bp(j.class), "renderCompanionObjectName", "getRenderCompanionObjectName()Z")), (d.l.k)z.a(new u(z.bp(j.class), "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;")), (d.l.k)z.a(new u(z.bp(j.class), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z")), (d.l.k)z.a(new u(z.bp(j.class), "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z")), (d.l.k)z.a(new u(z.bp(j.class), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;")), (d.l.k)z.a(new u(z.bp(j.class), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;")), (d.l.k)z.a(new u(z.bp(j.class), "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;")), (d.l.k)z.a(new u(z.bp(j.class), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;")), (d.l.k)z.a(new u(z.bp(j.class), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z")), (d.l.k)z.a(new u(z.bp(j.class), "renderConstructorKeyword", "getRenderConstructorKeyword()Z")), (d.l.k)z.a(new u(z.bp(j.class), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z")), (d.l.k)z.a(new u(z.bp(j.class), "renderTypeExpansions", "getRenderTypeExpansions()Z")), (d.l.k)z.a(new u(z.bp(j.class), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z")), (d.l.k)z.a(new u(z.bp(j.class), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z")), (d.l.k)z.a(new u(z.bp(j.class), "renderFunctionContracts", "getRenderFunctionContracts()Z")), (d.l.k)z.a(new u(z.bp(j.class), "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z")), (d.l.k)z.a(new u(z.bp(j.class), "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z")), (d.l.k)z.a(new u(z.bp(j.class), "informativeErrorType", "getInformativeErrorType()Z")) };
    AppMethodBeat.o(59810);
  }
  
  public j()
  {
    AppMethodBeat.i(59855);
    this.NQZ = fu(b.c.NQc);
    this.NRa = fu(Boolean.TRUE);
    this.NRb = fu(Boolean.TRUE);
    this.NRc = fu(h.NQW);
    this.NRd = fu(Boolean.FALSE);
    this.NRe = fu(Boolean.FALSE);
    this.NRf = fu(Boolean.FALSE);
    this.NRg = fu(Boolean.FALSE);
    this.NRh = fu(Boolean.FALSE);
    this.NRi = fu(Boolean.TRUE);
    this.NRj = fu(Boolean.FALSE);
    this.NRk = fu(Boolean.FALSE);
    this.NRl = fu(Boolean.FALSE);
    this.NRm = fu(Boolean.TRUE);
    this.NRn = fu(Boolean.TRUE);
    this.NRo = fu(Boolean.FALSE);
    this.NRp = fu(Boolean.FALSE);
    this.NRq = fu(Boolean.FALSE);
    this.NRr = fu(Boolean.FALSE);
    this.NRs = fu(Boolean.FALSE);
    this.NRt = fu(Boolean.FALSE);
    this.NRu = fu(Boolean.FALSE);
    this.NRv = fu(c.NRX);
    this.NRw = fu(a.NRV);
    this.NRx = fu(Boolean.TRUE);
    this.NRy = fu(m.NSc);
    this.NRz = fu(c.l.a.NQy);
    this.NRA = fu(p.NSn);
    this.NRB = fu(n.NSf);
    this.NRC = fu(Boolean.FALSE);
    this.NRD = fu(Boolean.FALSE);
    this.NRE = fu(o.NSk);
    this.NRF = fu(Boolean.FALSE);
    this.NRG = fu(Boolean.FALSE);
    this.NRH = fu((Set)x.NhJ);
    k localk = k.NRZ;
    this.NRI = fu(k.gxv());
    this.NRJ = fu(null);
    this.NRK = fu(a.NPU);
    this.NRL = fu(Boolean.FALSE);
    this.NRM = fu(Boolean.TRUE);
    this.NRN = fu(Boolean.TRUE);
    this.NRO = fu(Boolean.FALSE);
    this.NRP = fu(Boolean.TRUE);
    this.NRQ = fu(Boolean.TRUE);
    this.NRR = fu(Boolean.FALSE);
    this.NRS = fu(Boolean.FALSE);
    this.NRT = fu(Boolean.FALSE);
    this.NRU = fu(Boolean.TRUE);
    AppMethodBeat.o(59855);
  }
  
  public final void AA(boolean paramBoolean)
  {
    AppMethodBeat.i(59832);
    this.NRt.a(cxA[20], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59832);
  }
  
  public final void Au(boolean paramBoolean)
  {
    AppMethodBeat.i(59841);
    this.NRC.a(cxA[29], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59841);
  }
  
  public final void Av(boolean paramBoolean)
  {
    AppMethodBeat.i(59842);
    this.NRD.a(cxA[30], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59842);
  }
  
  public final void Aw(boolean paramBoolean)
  {
    AppMethodBeat.i(59819);
    this.NRd.a(cxA[4], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59819);
  }
  
  public final void Ax(boolean paramBoolean)
  {
    AppMethodBeat.i(59824);
    this.NRh.a(cxA[8], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59824);
  }
  
  public final void Ay(boolean paramBoolean)
  {
    AppMethodBeat.i(59815);
    this.NRa.a(cxA[1], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59815);
  }
  
  public final void Az(boolean paramBoolean)
  {
    AppMethodBeat.i(59833);
    this.NRu.a(cxA[21], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59833);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(59847);
    d.g.b.p.h(parama, "<set-?>");
    this.NRK.a(cxA[37], parama);
    AppMethodBeat.o(59847);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(59814);
    d.g.b.p.h(paramb, "<set-?>");
    this.NQZ.a(cxA[0], paramb);
    AppMethodBeat.o(59814);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(59840);
    d.g.b.p.h(paramn, "<set-?>");
    this.NRB.a(cxA[28], paramn);
    AppMethodBeat.o(59840);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(59839);
    d.g.b.p.h(paramp, "<set-?>");
    this.NRA.a(cxA[27], paramp);
    AppMethodBeat.o(59839);
  }
  
  final <T> c<j, T> fu(T paramT)
  {
    AppMethodBeat.i(59812);
    d.i.a locala = d.i.a.Njd;
    paramT = (c)new b(paramT, paramT, this);
    AppMethodBeat.o(59812);
    return paramT;
  }
  
  public final a gwS()
  {
    AppMethodBeat.i(59846);
    a locala = (a)this.NRK.a(cxA[37]);
    AppMethodBeat.o(59846);
    return locala;
  }
  
  public final boolean gwT()
  {
    AppMethodBeat.i(59821);
    boolean bool = ((Boolean)this.NRf.a(cxA[6])).booleanValue();
    AppMethodBeat.o(59821);
    return bool;
  }
  
  public final boolean gwU()
  {
    AppMethodBeat.i(59825);
    boolean bool = ((Boolean)this.NRk.a(cxA[11])).booleanValue();
    AppMethodBeat.o(59825);
    return bool;
  }
  
  public final Set<d.l.b.a.b.f.b> gwV()
  {
    AppMethodBeat.i(59844);
    Set localSet = (Set)this.NRI.a(cxA[35]);
    AppMethodBeat.o(59844);
    return localSet;
  }
  
  public final b gwW()
  {
    AppMethodBeat.i(59813);
    b localb = (b)this.NQZ.a(cxA[0]);
    AppMethodBeat.o(59813);
    return localb;
  }
  
  public final Set<h> gwX()
  {
    AppMethodBeat.i(59816);
    Set localSet = (Set)this.NRc.a(cxA[3]);
    AppMethodBeat.o(59816);
    return localSet;
  }
  
  public final boolean gwY()
  {
    AppMethodBeat.i(59818);
    boolean bool = ((Boolean)this.NRd.a(cxA[4])).booleanValue();
    AppMethodBeat.o(59818);
    return bool;
  }
  
  public final boolean gwZ()
  {
    AppMethodBeat.i(59820);
    boolean bool = ((Boolean)this.NRe.a(cxA[5])).booleanValue();
    AppMethodBeat.o(59820);
    return bool;
  }
  
  public final boolean gxa()
  {
    AppMethodBeat.i(59823);
    boolean bool = ((Boolean)this.NRh.a(cxA[8])).booleanValue();
    AppMethodBeat.o(59823);
    return bool;
  }
  
  public final boolean gxb()
  {
    AppMethodBeat.i(59826);
    boolean bool = ((Boolean)this.NRm.a(cxA[13])).booleanValue();
    AppMethodBeat.o(59826);
    return bool;
  }
  
  public final boolean gxc()
  {
    AppMethodBeat.i(59827);
    boolean bool = ((Boolean)this.NRp.a(cxA[16])).booleanValue();
    AppMethodBeat.o(59827);
    return bool;
  }
  
  public final boolean gxd()
  {
    AppMethodBeat.i(59828);
    boolean bool = ((Boolean)this.NRq.a(cxA[17])).booleanValue();
    AppMethodBeat.o(59828);
    return bool;
  }
  
  public final boolean gxe()
  {
    AppMethodBeat.i(59829);
    boolean bool = ((Boolean)this.NRr.a(cxA[18])).booleanValue();
    AppMethodBeat.o(59829);
    return bool;
  }
  
  public final boolean gxf()
  {
    AppMethodBeat.i(59830);
    boolean bool = ((Boolean)this.NRs.a(cxA[19])).booleanValue();
    AppMethodBeat.o(59830);
    return bool;
  }
  
  public final boolean gxg()
  {
    AppMethodBeat.i(59831);
    boolean bool = ((Boolean)this.NRt.a(cxA[20])).booleanValue();
    AppMethodBeat.o(59831);
    return bool;
  }
  
  public final d.g.a.b<av, String> gxh()
  {
    AppMethodBeat.i(59834);
    d.g.a.b localb = (d.g.a.b)this.NRw.a(cxA[23]);
    AppMethodBeat.o(59834);
    return localb;
  }
  
  public final boolean gxi()
  {
    AppMethodBeat.i(59835);
    boolean bool = ((Boolean)this.NRx.a(cxA[24])).booleanValue();
    AppMethodBeat.o(59835);
    return bool;
  }
  
  public final m gxj()
  {
    AppMethodBeat.i(59836);
    m localm = (m)this.NRy.a(cxA[25]);
    AppMethodBeat.o(59836);
    return localm;
  }
  
  public final c.l gxk()
  {
    AppMethodBeat.i(59837);
    c.l locall = (c.l)this.NRz.a(cxA[26]);
    AppMethodBeat.o(59837);
    return locall;
  }
  
  public final p gxl()
  {
    AppMethodBeat.i(59838);
    p localp = (p)this.NRA.a(cxA[27]);
    AppMethodBeat.o(59838);
    return localp;
  }
  
  public final o gxm()
  {
    AppMethodBeat.i(59843);
    o localo = (o)this.NRE.a(cxA[31]);
    AppMethodBeat.o(59843);
    return localo;
  }
  
  public final boolean gxn()
  {
    AppMethodBeat.i(59848);
    boolean bool = ((Boolean)this.NRL.a(cxA[38])).booleanValue();
    AppMethodBeat.o(59848);
    return bool;
  }
  
  public final boolean gxo()
  {
    AppMethodBeat.i(59849);
    boolean bool = ((Boolean)this.NRN.a(cxA[40])).booleanValue();
    AppMethodBeat.o(59849);
    return bool;
  }
  
  public final boolean gxp()
  {
    AppMethodBeat.i(59850);
    boolean bool = ((Boolean)this.NRO.a(cxA[41])).booleanValue();
    AppMethodBeat.o(59850);
    return bool;
  }
  
  public final boolean gxq()
  {
    AppMethodBeat.i(59851);
    boolean bool = ((Boolean)this.NRP.a(cxA[42])).booleanValue();
    AppMethodBeat.o(59851);
    return bool;
  }
  
  public final boolean gxr()
  {
    AppMethodBeat.i(59852);
    boolean bool = ((Boolean)this.NRQ.a(cxA[43])).booleanValue();
    AppMethodBeat.o(59852);
    return bool;
  }
  
  public final boolean gxs()
  {
    AppMethodBeat.i(59853);
    boolean bool = ((Boolean)this.NRS.a(cxA[45])).booleanValue();
    AppMethodBeat.o(59853);
    return bool;
  }
  
  public final boolean gxt()
  {
    AppMethodBeat.i(59854);
    boolean bool = ((Boolean)this.NRT.a(cxA[46])).booleanValue();
    AppMethodBeat.o(59854);
    return bool;
  }
  
  public final boolean gxu()
  {
    AppMethodBeat.i(193307);
    boolean bool = ((Boolean)this.NRU.a(cxA[47])).booleanValue();
    AppMethodBeat.o(193307);
    return bool;
  }
  
  public final void lock()
  {
    AppMethodBeat.i(59811);
    if (!this.aIe) {}
    for (int i = 1; (ac.Nhs) && (i == 0); i = 0)
    {
      Throwable localThrowable = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(59811);
      throw localThrowable;
    }
    this.aIe = true;
    AppMethodBeat.o(59811);
  }
  
  public final void setDebugMode(boolean paramBoolean)
  {
    AppMethodBeat.i(59822);
    this.NRf.a(cxA[6], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59822);
  }
  
  public final void u(Set<d.l.b.a.b.f.b> paramSet)
  {
    AppMethodBeat.i(59845);
    d.g.b.p.h(paramSet, "<set-?>");
    this.NRI.a(cxA[35], paramSet);
    AppMethodBeat.o(59845);
  }
  
  public final void v(Set<? extends h> paramSet)
  {
    AppMethodBeat.i(59817);
    d.g.b.p.h(paramSet, "<set-?>");
    this.NRc.a(cxA[3], paramSet);
    AppMethodBeat.o(59817);
  }
  
  static final class a
    extends q
    implements d.g.a.b<av, String>
  {
    public static final a NRV;
    
    static
    {
      AppMethodBeat.i(59806);
      NRV = new a();
      AppMethodBeat.o(59806);
    }
    
    a()
    {
      super();
    }
  }
  
  public static final class b
    extends d.i.b<T>
  {
    public b(Object paramObject1, Object paramObject2, j paramj)
    {
      super();
    }
    
    public final boolean b(d.l.k<?> paramk)
    {
      AppMethodBeat.i(59807);
      d.g.b.p.h(paramk, "property");
      if (jdField_this.aIe)
      {
        paramk = (Throwable)new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
        AppMethodBeat.o(59807);
        throw paramk;
      }
      AppMethodBeat.o(59807);
      return true;
    }
  }
  
  static final class c
    extends q
    implements d.g.a.b<ab, ab>
  {
    public static final c NRX;
    
    static
    {
      AppMethodBeat.i(59809);
      NRX = new c();
      AppMethodBeat.o(59809);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.i.j
 * JD-Core Version:    0.7.0.1
 */