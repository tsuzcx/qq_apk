package kotlin.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import kotlin.a.x;
import kotlin.g.b.v;
import kotlin.i.c;
import kotlin.l.b.a.b.b.av;

public final class j
  implements i
{
  private final c TFV;
  final c TFW;
  final c TFX;
  private final c TFY;
  private final c TFZ;
  private final c TGA;
  final c TGB;
  final c TGC;
  final c TGD;
  private final c TGE;
  final c TGF;
  private final c TGG;
  private final c TGH;
  final c TGI;
  private final c TGJ;
  private final c TGK;
  private final c TGL;
  private final c TGM;
  private final c TGN;
  private final c TGO;
  private final c TGP;
  private final c TGQ;
  private final c TGa;
  private final c TGb;
  final c TGc;
  private final c TGd;
  final c TGe;
  final c TGf;
  private final c TGg;
  final c TGh;
  private final c TGi;
  final c TGj;
  final c TGk;
  private final c TGl;
  private final c TGm;
  private final c TGn;
  private final c TGo;
  private final c TGp;
  final c TGq;
  final c TGr;
  private final c TGs;
  private final c TGt;
  private final c TGu;
  private final c TGv;
  private final c TGw;
  final c TGx;
  final c TGy;
  final c TGz;
  boolean aHY;
  
  static
  {
    AppMethodBeat.i(59810);
    cLI = new kotlin.l.k[] { (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "withDefinedIn", "getWithDefinedIn()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "modifiers", "getModifiers()Ljava/util/Set;")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "startFromName", "getStartFromName()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "debugMode", "getDebugMode()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "verbose", "getVerbose()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "unitReturnType", "getUnitReturnType()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "withoutReturnType", "getWithoutReturnType()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "enhancedTypes", "getEnhancedTypes()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "normalizedVisibilities", "getNormalizedVisibilities()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "renderDefaultVisibility", "getRenderDefaultVisibility()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "renderDefaultModality", "getRenderDefaultModality()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "renderConstructorDelegation", "getRenderConstructorDelegation()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "includePropertyConstant", "getIncludePropertyConstant()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "withoutTypeParameters", "getWithoutTypeParameters()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "withoutSuperTypes", "getWithoutSuperTypes()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "receiverAfterName", "getReceiverAfterName()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "renderCompanionObjectName", "getRenderCompanionObjectName()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "renderConstructorKeyword", "getRenderConstructorKeyword()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "renderTypeExpansions", "getRenderTypeExpansions()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "renderFunctionContracts", "getRenderFunctionContracts()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z")), (kotlin.l.k)kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(j.class), "informativeErrorType", "getInformativeErrorType()Z")) };
    AppMethodBeat.o(59810);
  }
  
  public j()
  {
    AppMethodBeat.i(59855);
    this.TFV = fy(b.c.TFa);
    this.TFW = fy(Boolean.TRUE);
    this.TFX = fy(Boolean.TRUE);
    this.TFY = fy(h.TFS);
    this.TFZ = fy(Boolean.FALSE);
    this.TGa = fy(Boolean.FALSE);
    this.TGb = fy(Boolean.FALSE);
    this.TGc = fy(Boolean.FALSE);
    this.TGd = fy(Boolean.FALSE);
    this.TGe = fy(Boolean.TRUE);
    this.TGf = fy(Boolean.FALSE);
    this.TGg = fy(Boolean.FALSE);
    this.TGh = fy(Boolean.FALSE);
    this.TGi = fy(Boolean.TRUE);
    this.TGj = fy(Boolean.TRUE);
    this.TGk = fy(Boolean.FALSE);
    this.TGl = fy(Boolean.FALSE);
    this.TGm = fy(Boolean.FALSE);
    this.TGn = fy(Boolean.FALSE);
    this.TGo = fy(Boolean.FALSE);
    this.TGp = fy(Boolean.FALSE);
    this.TGq = fy(Boolean.FALSE);
    this.TGr = fy(j.c.TGT);
    this.TGs = fy(j.a.TGR);
    this.TGt = fy(Boolean.TRUE);
    this.TGu = fy(m.TGY);
    this.TGv = fy(c.l.a.TFw);
    this.TGw = fy(p.THj);
    this.TGx = fy(n.THb);
    this.TGy = fy(Boolean.FALSE);
    this.TGz = fy(Boolean.FALSE);
    this.TGA = fy(o.THg);
    this.TGB = fy(Boolean.FALSE);
    this.TGC = fy(Boolean.FALSE);
    this.TGD = fy((Set)x.SXt);
    k localk = k.TGV;
    this.TGE = fy(k.hKy());
    this.TGF = fy(null);
    this.TGG = fy(a.TES);
    this.TGH = fy(Boolean.FALSE);
    this.TGI = fy(Boolean.TRUE);
    this.TGJ = fy(Boolean.TRUE);
    this.TGK = fy(Boolean.FALSE);
    this.TGL = fy(Boolean.TRUE);
    this.TGM = fy(Boolean.TRUE);
    this.TGN = fy(Boolean.FALSE);
    this.TGO = fy(Boolean.FALSE);
    this.TGP = fy(Boolean.FALSE);
    this.TGQ = fy(Boolean.TRUE);
    AppMethodBeat.o(59855);
  }
  
  public final void D(Set<kotlin.l.b.a.b.f.b> paramSet)
  {
    AppMethodBeat.i(59845);
    kotlin.g.b.p.h(paramSet, "<set-?>");
    this.TGE.a(cLI[35], paramSet);
    AppMethodBeat.o(59845);
  }
  
  public final void E(Set<? extends h> paramSet)
  {
    AppMethodBeat.i(59817);
    kotlin.g.b.p.h(paramSet, "<set-?>");
    this.TFY.a(cLI[3], paramSet);
    AppMethodBeat.o(59817);
  }
  
  public final void EK(boolean paramBoolean)
  {
    AppMethodBeat.i(59841);
    this.TGy.a(cLI[29], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59841);
  }
  
  public final void EL(boolean paramBoolean)
  {
    AppMethodBeat.i(59842);
    this.TGz.a(cLI[30], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59842);
  }
  
  public final void EM(boolean paramBoolean)
  {
    AppMethodBeat.i(59819);
    this.TFZ.a(cLI[4], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59819);
  }
  
  public final void EN(boolean paramBoolean)
  {
    AppMethodBeat.i(59824);
    this.TGd.a(cLI[8], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59824);
  }
  
  public final void EO(boolean paramBoolean)
  {
    AppMethodBeat.i(59815);
    this.TFW.a(cLI[1], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59815);
  }
  
  public final void EP(boolean paramBoolean)
  {
    AppMethodBeat.i(59833);
    this.TGq.a(cLI[21], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59833);
  }
  
  public final void EQ(boolean paramBoolean)
  {
    AppMethodBeat.i(59832);
    this.TGp.a(cLI[20], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59832);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(59847);
    kotlin.g.b.p.h(parama, "<set-?>");
    this.TGG.a(cLI[37], parama);
    AppMethodBeat.o(59847);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(59814);
    kotlin.g.b.p.h(paramb, "<set-?>");
    this.TFV.a(cLI[0], paramb);
    AppMethodBeat.o(59814);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(59840);
    kotlin.g.b.p.h(paramn, "<set-?>");
    this.TGx.a(cLI[28], paramn);
    AppMethodBeat.o(59840);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(59839);
    kotlin.g.b.p.h(paramp, "<set-?>");
    this.TGw.a(cLI[27], paramp);
    AppMethodBeat.o(59839);
  }
  
  final <T> c<j, T> fy(T paramT)
  {
    AppMethodBeat.i(59812);
    kotlin.i.a locala = kotlin.i.a.SYL;
    paramT = (c)new b(paramT, paramT, this);
    AppMethodBeat.o(59812);
    return paramT;
  }
  
  public final a hJV()
  {
    AppMethodBeat.i(59846);
    a locala = (a)this.TGG.a(cLI[37]);
    AppMethodBeat.o(59846);
    return locala;
  }
  
  public final boolean hJW()
  {
    AppMethodBeat.i(59821);
    boolean bool = ((Boolean)this.TGb.a(cLI[6])).booleanValue();
    AppMethodBeat.o(59821);
    return bool;
  }
  
  public final boolean hJX()
  {
    AppMethodBeat.i(59825);
    boolean bool = ((Boolean)this.TGg.a(cLI[11])).booleanValue();
    AppMethodBeat.o(59825);
    return bool;
  }
  
  public final Set<kotlin.l.b.a.b.f.b> hJY()
  {
    AppMethodBeat.i(59844);
    Set localSet = (Set)this.TGE.a(cLI[35]);
    AppMethodBeat.o(59844);
    return localSet;
  }
  
  public final b hJZ()
  {
    AppMethodBeat.i(59813);
    b localb = (b)this.TFV.a(cLI[0]);
    AppMethodBeat.o(59813);
    return localb;
  }
  
  public final Set<h> hKa()
  {
    AppMethodBeat.i(59816);
    Set localSet = (Set)this.TFY.a(cLI[3]);
    AppMethodBeat.o(59816);
    return localSet;
  }
  
  public final boolean hKb()
  {
    AppMethodBeat.i(59818);
    boolean bool = ((Boolean)this.TFZ.a(cLI[4])).booleanValue();
    AppMethodBeat.o(59818);
    return bool;
  }
  
  public final boolean hKc()
  {
    AppMethodBeat.i(59820);
    boolean bool = ((Boolean)this.TGa.a(cLI[5])).booleanValue();
    AppMethodBeat.o(59820);
    return bool;
  }
  
  public final boolean hKd()
  {
    AppMethodBeat.i(59823);
    boolean bool = ((Boolean)this.TGd.a(cLI[8])).booleanValue();
    AppMethodBeat.o(59823);
    return bool;
  }
  
  public final boolean hKe()
  {
    AppMethodBeat.i(59826);
    boolean bool = ((Boolean)this.TGi.a(cLI[13])).booleanValue();
    AppMethodBeat.o(59826);
    return bool;
  }
  
  public final boolean hKf()
  {
    AppMethodBeat.i(59827);
    boolean bool = ((Boolean)this.TGl.a(cLI[16])).booleanValue();
    AppMethodBeat.o(59827);
    return bool;
  }
  
  public final boolean hKg()
  {
    AppMethodBeat.i(59828);
    boolean bool = ((Boolean)this.TGm.a(cLI[17])).booleanValue();
    AppMethodBeat.o(59828);
    return bool;
  }
  
  public final boolean hKh()
  {
    AppMethodBeat.i(59829);
    boolean bool = ((Boolean)this.TGn.a(cLI[18])).booleanValue();
    AppMethodBeat.o(59829);
    return bool;
  }
  
  public final boolean hKi()
  {
    AppMethodBeat.i(59830);
    boolean bool = ((Boolean)this.TGo.a(cLI[19])).booleanValue();
    AppMethodBeat.o(59830);
    return bool;
  }
  
  public final boolean hKj()
  {
    AppMethodBeat.i(59831);
    boolean bool = ((Boolean)this.TGp.a(cLI[20])).booleanValue();
    AppMethodBeat.o(59831);
    return bool;
  }
  
  public final kotlin.g.a.b<av, String> hKk()
  {
    AppMethodBeat.i(59834);
    kotlin.g.a.b localb = (kotlin.g.a.b)this.TGs.a(cLI[23]);
    AppMethodBeat.o(59834);
    return localb;
  }
  
  public final boolean hKl()
  {
    AppMethodBeat.i(59835);
    boolean bool = ((Boolean)this.TGt.a(cLI[24])).booleanValue();
    AppMethodBeat.o(59835);
    return bool;
  }
  
  public final m hKm()
  {
    AppMethodBeat.i(59836);
    m localm = (m)this.TGu.a(cLI[25]);
    AppMethodBeat.o(59836);
    return localm;
  }
  
  public final c.l hKn()
  {
    AppMethodBeat.i(59837);
    c.l locall = (c.l)this.TGv.a(cLI[26]);
    AppMethodBeat.o(59837);
    return locall;
  }
  
  public final p hKo()
  {
    AppMethodBeat.i(59838);
    p localp = (p)this.TGw.a(cLI[27]);
    AppMethodBeat.o(59838);
    return localp;
  }
  
  public final o hKp()
  {
    AppMethodBeat.i(59843);
    o localo = (o)this.TGA.a(cLI[31]);
    AppMethodBeat.o(59843);
    return localo;
  }
  
  public final boolean hKq()
  {
    AppMethodBeat.i(59848);
    boolean bool = ((Boolean)this.TGH.a(cLI[38])).booleanValue();
    AppMethodBeat.o(59848);
    return bool;
  }
  
  public final boolean hKr()
  {
    AppMethodBeat.i(59849);
    boolean bool = ((Boolean)this.TGJ.a(cLI[40])).booleanValue();
    AppMethodBeat.o(59849);
    return bool;
  }
  
  public final boolean hKs()
  {
    AppMethodBeat.i(59850);
    boolean bool = ((Boolean)this.TGK.a(cLI[41])).booleanValue();
    AppMethodBeat.o(59850);
    return bool;
  }
  
  public final boolean hKt()
  {
    AppMethodBeat.i(59851);
    boolean bool = ((Boolean)this.TGL.a(cLI[42])).booleanValue();
    AppMethodBeat.o(59851);
    return bool;
  }
  
  public final boolean hKu()
  {
    AppMethodBeat.i(59852);
    boolean bool = ((Boolean)this.TGM.a(cLI[43])).booleanValue();
    AppMethodBeat.o(59852);
    return bool;
  }
  
  public final boolean hKv()
  {
    AppMethodBeat.i(59853);
    boolean bool = ((Boolean)this.TGO.a(cLI[45])).booleanValue();
    AppMethodBeat.o(59853);
    return bool;
  }
  
  public final boolean hKw()
  {
    AppMethodBeat.i(59854);
    boolean bool = ((Boolean)this.TGP.a(cLI[46])).booleanValue();
    AppMethodBeat.o(59854);
    return bool;
  }
  
  public final boolean hKx()
  {
    AppMethodBeat.i(186258);
    boolean bool = ((Boolean)this.TGQ.a(cLI[47])).booleanValue();
    AppMethodBeat.o(186258);
    return bool;
  }
  
  public final void lock()
  {
    AppMethodBeat.i(59811);
    if (!this.aHY) {}
    for (int i = 1; (kotlin.aa.SXc) && (i == 0); i = 0)
    {
      Throwable localThrowable = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(59811);
      throw localThrowable;
    }
    this.aHY = true;
    AppMethodBeat.o(59811);
  }
  
  public final void setDebugMode(boolean paramBoolean)
  {
    AppMethodBeat.i(59822);
    this.TGb.a(cLI[6], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59822);
  }
  
  public static final class b
    extends kotlin.i.b<T>
  {
    public b(Object paramObject1, Object paramObject2, j paramj)
    {
      super();
    }
    
    public final boolean b(kotlin.l.k<?> paramk)
    {
      AppMethodBeat.i(59807);
      kotlin.g.b.p.h(paramk, "property");
      if (jdField_this.aHY)
      {
        paramk = (Throwable)new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
        AppMethodBeat.o(59807);
        throw paramk;
      }
      AppMethodBeat.o(59807);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.i.j
 * JD-Core Version:    0.7.0.1
 */