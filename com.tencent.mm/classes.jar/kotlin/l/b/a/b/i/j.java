package kotlin.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import kotlin.a.x;
import kotlin.g.b.ab;
import kotlin.g.b.v;
import kotlin.i.c;
import kotlin.l.b.a.b.b.av;
import kotlin.z;

public final class j
  implements i
{
  boolean APF;
  final c abiA;
  final c abiB;
  private final c abiC;
  private final c abiD;
  private final c abiE;
  private final c abiF;
  final c abiG;
  private final c abiH;
  final c abiI;
  final c abiJ;
  private final c abiK;
  final c abiL;
  private final c abiM;
  final c abiN;
  final c abiO;
  private final c abiP;
  private final c abiQ;
  private final c abiR;
  private final c abiS;
  private final c abiT;
  final c abiU;
  final c abiV;
  private final c abiW;
  private final c abiX;
  private final c abiY;
  private final c abiZ;
  private final c abiz;
  private final c abja;
  final c abjb;
  final c abjc;
  final c abjd;
  private final c abje;
  final c abjf;
  final c abjg;
  final c abjh;
  private final c abji;
  final c abjj;
  private final c abjk;
  private final c abjl;
  final c abjm;
  private final c abjn;
  private final c abjo;
  private final c abjp;
  private final c abjq;
  private final c abjr;
  private final c abjs;
  private final c abjt;
  private final c abju;
  
  static
  {
    AppMethodBeat.i(59810);
    cMt = new kotlin.l.n[] { (kotlin.l.n)ab.a(new v(ab.bO(j.class), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "withDefinedIn", "getWithDefinedIn()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "modifiers", "getModifiers()Ljava/util/Set;")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "startFromName", "getStartFromName()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "debugMode", "getDebugMode()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "verbose", "getVerbose()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "unitReturnType", "getUnitReturnType()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "withoutReturnType", "getWithoutReturnType()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "enhancedTypes", "getEnhancedTypes()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "normalizedVisibilities", "getNormalizedVisibilities()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "renderDefaultVisibility", "getRenderDefaultVisibility()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "renderDefaultModality", "getRenderDefaultModality()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "renderConstructorDelegation", "getRenderConstructorDelegation()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "includePropertyConstant", "getIncludePropertyConstant()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "withoutTypeParameters", "getWithoutTypeParameters()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "withoutSuperTypes", "getWithoutSuperTypes()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "receiverAfterName", "getReceiverAfterName()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "renderCompanionObjectName", "getRenderCompanionObjectName()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "renderConstructorKeyword", "getRenderConstructorKeyword()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "renderTypeExpansions", "getRenderTypeExpansions()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "renderFunctionContracts", "getRenderFunctionContracts()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z")), (kotlin.l.n)ab.a(new v(ab.bO(j.class), "informativeErrorType", "getInformativeErrorType()Z")) };
    AppMethodBeat.o(59810);
  }
  
  public j()
  {
    AppMethodBeat.i(59855);
    this.abiz = fE(b.c.abhE);
    this.abiA = fE(Boolean.TRUE);
    this.abiB = fE(Boolean.TRUE);
    this.abiC = fE(h.abiw);
    this.abiD = fE(Boolean.FALSE);
    this.abiE = fE(Boolean.FALSE);
    this.abiF = fE(Boolean.FALSE);
    this.abiG = fE(Boolean.FALSE);
    this.abiH = fE(Boolean.FALSE);
    this.abiI = fE(Boolean.TRUE);
    this.abiJ = fE(Boolean.FALSE);
    this.abiK = fE(Boolean.FALSE);
    this.abiL = fE(Boolean.FALSE);
    this.abiM = fE(Boolean.TRUE);
    this.abiN = fE(Boolean.TRUE);
    this.abiO = fE(Boolean.FALSE);
    this.abiP = fE(Boolean.FALSE);
    this.abiQ = fE(Boolean.FALSE);
    this.abiR = fE(Boolean.FALSE);
    this.abiS = fE(Boolean.FALSE);
    this.abiT = fE(Boolean.FALSE);
    this.abiU = fE(Boolean.FALSE);
    this.abiV = fE(j.c.abjx);
    this.abiW = fE(j.a.abjv);
    this.abiX = fE(Boolean.TRUE);
    this.abiY = fE(m.abjC);
    this.abiZ = fE(c.l.a.abia);
    this.abja = fE(p.abjN);
    this.abjb = fE(n.abjF);
    this.abjc = fE(Boolean.FALSE);
    this.abjd = fE(Boolean.FALSE);
    this.abje = fE(o.abjK);
    this.abjf = fE(Boolean.FALSE);
    this.abjg = fE(Boolean.FALSE);
    this.abjh = fE((Set)x.aaAf);
    k localk = k.abjz;
    this.abji = fE(k.iOO());
    this.abjj = fE(null);
    this.abjk = fE(a.abhw);
    this.abjl = fE(Boolean.FALSE);
    this.abjm = fE(Boolean.TRUE);
    this.abjn = fE(Boolean.TRUE);
    this.abjo = fE(Boolean.FALSE);
    this.abjp = fE(Boolean.TRUE);
    this.abjq = fE(Boolean.TRUE);
    this.abjr = fE(Boolean.FALSE);
    this.abjs = fE(Boolean.FALSE);
    this.abjt = fE(Boolean.FALSE);
    this.abju = fE(Boolean.TRUE);
    AppMethodBeat.o(59855);
  }
  
  public final void C(Set<kotlin.l.b.a.b.f.b> paramSet)
  {
    AppMethodBeat.i(59845);
    kotlin.g.b.p.k(paramSet, "<set-?>");
    this.abji.a(cMt[35], paramSet);
    AppMethodBeat.o(59845);
  }
  
  public final void D(Set<? extends h> paramSet)
  {
    AppMethodBeat.i(59817);
    kotlin.g.b.p.k(paramSet, "<set-?>");
    this.abiC.a(cMt[3], paramSet);
    AppMethodBeat.o(59817);
  }
  
  public final void Jr(boolean paramBoolean)
  {
    AppMethodBeat.i(59841);
    this.abjc.a(cMt[29], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59841);
  }
  
  public final void Js(boolean paramBoolean)
  {
    AppMethodBeat.i(59842);
    this.abjd.a(cMt[30], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59842);
  }
  
  public final void Jt(boolean paramBoolean)
  {
    AppMethodBeat.i(59819);
    this.abiD.a(cMt[4], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59819);
  }
  
  public final void Ju(boolean paramBoolean)
  {
    AppMethodBeat.i(59824);
    this.abiH.a(cMt[8], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59824);
  }
  
  public final void Jv(boolean paramBoolean)
  {
    AppMethodBeat.i(59815);
    this.abiA.a(cMt[1], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59815);
  }
  
  public final void Jw(boolean paramBoolean)
  {
    AppMethodBeat.i(59833);
    this.abiU.a(cMt[21], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59833);
  }
  
  public final void Jx(boolean paramBoolean)
  {
    AppMethodBeat.i(59832);
    this.abiT.a(cMt[20], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59832);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(59847);
    kotlin.g.b.p.k(parama, "<set-?>");
    this.abjk.a(cMt[37], parama);
    AppMethodBeat.o(59847);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(59814);
    kotlin.g.b.p.k(paramb, "<set-?>");
    this.abiz.a(cMt[0], paramb);
    AppMethodBeat.o(59814);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(59840);
    kotlin.g.b.p.k(paramn, "<set-?>");
    this.abjb.a(cMt[28], paramn);
    AppMethodBeat.o(59840);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(59839);
    kotlin.g.b.p.k(paramp, "<set-?>");
    this.abja.a(cMt[27], paramp);
    AppMethodBeat.o(59839);
  }
  
  final <T> c<j, T> fE(T paramT)
  {
    AppMethodBeat.i(59812);
    kotlin.i.a locala = kotlin.i.a.aaBH;
    paramT = (c)new b(paramT, paramT, this);
    AppMethodBeat.o(59812);
    return paramT;
  }
  
  public final kotlin.g.a.b<av, String> iOA()
  {
    AppMethodBeat.i(59834);
    kotlin.g.a.b localb = (kotlin.g.a.b)this.abiW.a(cMt[23]);
    AppMethodBeat.o(59834);
    return localb;
  }
  
  public final boolean iOB()
  {
    AppMethodBeat.i(59835);
    boolean bool = ((Boolean)this.abiX.a(cMt[24])).booleanValue();
    AppMethodBeat.o(59835);
    return bool;
  }
  
  public final m iOC()
  {
    AppMethodBeat.i(59836);
    m localm = (m)this.abiY.a(cMt[25]);
    AppMethodBeat.o(59836);
    return localm;
  }
  
  public final c.l iOD()
  {
    AppMethodBeat.i(59837);
    c.l locall = (c.l)this.abiZ.a(cMt[26]);
    AppMethodBeat.o(59837);
    return locall;
  }
  
  public final p iOE()
  {
    AppMethodBeat.i(59838);
    p localp = (p)this.abja.a(cMt[27]);
    AppMethodBeat.o(59838);
    return localp;
  }
  
  public final o iOF()
  {
    AppMethodBeat.i(59843);
    o localo = (o)this.abje.a(cMt[31]);
    AppMethodBeat.o(59843);
    return localo;
  }
  
  public final boolean iOG()
  {
    AppMethodBeat.i(59848);
    boolean bool = ((Boolean)this.abjl.a(cMt[38])).booleanValue();
    AppMethodBeat.o(59848);
    return bool;
  }
  
  public final boolean iOH()
  {
    AppMethodBeat.i(59849);
    boolean bool = ((Boolean)this.abjn.a(cMt[40])).booleanValue();
    AppMethodBeat.o(59849);
    return bool;
  }
  
  public final boolean iOI()
  {
    AppMethodBeat.i(59850);
    boolean bool = ((Boolean)this.abjo.a(cMt[41])).booleanValue();
    AppMethodBeat.o(59850);
    return bool;
  }
  
  public final boolean iOJ()
  {
    AppMethodBeat.i(59851);
    boolean bool = ((Boolean)this.abjp.a(cMt[42])).booleanValue();
    AppMethodBeat.o(59851);
    return bool;
  }
  
  public final boolean iOK()
  {
    AppMethodBeat.i(59852);
    boolean bool = ((Boolean)this.abjq.a(cMt[43])).booleanValue();
    AppMethodBeat.o(59852);
    return bool;
  }
  
  public final boolean iOL()
  {
    AppMethodBeat.i(59853);
    boolean bool = ((Boolean)this.abjs.a(cMt[45])).booleanValue();
    AppMethodBeat.o(59853);
    return bool;
  }
  
  public final boolean iOM()
  {
    AppMethodBeat.i(59854);
    boolean bool = ((Boolean)this.abjt.a(cMt[46])).booleanValue();
    AppMethodBeat.o(59854);
    return bool;
  }
  
  public final boolean iON()
  {
    AppMethodBeat.i(268525);
    boolean bool = ((Boolean)this.abju.a(cMt[47])).booleanValue();
    AppMethodBeat.o(268525);
    return bool;
  }
  
  public final a iOl()
  {
    AppMethodBeat.i(59846);
    a locala = (a)this.abjk.a(cMt[37]);
    AppMethodBeat.o(59846);
    return locala;
  }
  
  public final boolean iOm()
  {
    AppMethodBeat.i(59821);
    boolean bool = ((Boolean)this.abiF.a(cMt[6])).booleanValue();
    AppMethodBeat.o(59821);
    return bool;
  }
  
  public final boolean iOn()
  {
    AppMethodBeat.i(59825);
    boolean bool = ((Boolean)this.abiK.a(cMt[11])).booleanValue();
    AppMethodBeat.o(59825);
    return bool;
  }
  
  public final Set<kotlin.l.b.a.b.f.b> iOo()
  {
    AppMethodBeat.i(59844);
    Set localSet = (Set)this.abji.a(cMt[35]);
    AppMethodBeat.o(59844);
    return localSet;
  }
  
  public final b iOp()
  {
    AppMethodBeat.i(59813);
    b localb = (b)this.abiz.a(cMt[0]);
    AppMethodBeat.o(59813);
    return localb;
  }
  
  public final Set<h> iOq()
  {
    AppMethodBeat.i(59816);
    Set localSet = (Set)this.abiC.a(cMt[3]);
    AppMethodBeat.o(59816);
    return localSet;
  }
  
  public final boolean iOr()
  {
    AppMethodBeat.i(59818);
    boolean bool = ((Boolean)this.abiD.a(cMt[4])).booleanValue();
    AppMethodBeat.o(59818);
    return bool;
  }
  
  public final boolean iOs()
  {
    AppMethodBeat.i(59820);
    boolean bool = ((Boolean)this.abiE.a(cMt[5])).booleanValue();
    AppMethodBeat.o(59820);
    return bool;
  }
  
  public final boolean iOt()
  {
    AppMethodBeat.i(59823);
    boolean bool = ((Boolean)this.abiH.a(cMt[8])).booleanValue();
    AppMethodBeat.o(59823);
    return bool;
  }
  
  public final boolean iOu()
  {
    AppMethodBeat.i(59826);
    boolean bool = ((Boolean)this.abiM.a(cMt[13])).booleanValue();
    AppMethodBeat.o(59826);
    return bool;
  }
  
  public final boolean iOv()
  {
    AppMethodBeat.i(59827);
    boolean bool = ((Boolean)this.abiP.a(cMt[16])).booleanValue();
    AppMethodBeat.o(59827);
    return bool;
  }
  
  public final boolean iOw()
  {
    AppMethodBeat.i(59828);
    boolean bool = ((Boolean)this.abiQ.a(cMt[17])).booleanValue();
    AppMethodBeat.o(59828);
    return bool;
  }
  
  public final boolean iOx()
  {
    AppMethodBeat.i(59829);
    boolean bool = ((Boolean)this.abiR.a(cMt[18])).booleanValue();
    AppMethodBeat.o(59829);
    return bool;
  }
  
  public final boolean iOy()
  {
    AppMethodBeat.i(59830);
    boolean bool = ((Boolean)this.abiS.a(cMt[19])).booleanValue();
    AppMethodBeat.o(59830);
    return bool;
  }
  
  public final boolean iOz()
  {
    AppMethodBeat.i(59831);
    boolean bool = ((Boolean)this.abiT.a(cMt[20])).booleanValue();
    AppMethodBeat.o(59831);
    return bool;
  }
  
  public final void lock()
  {
    AppMethodBeat.i(59811);
    if (!this.APF) {}
    for (int i = 1; (z.aazO) && (i == 0); i = 0)
    {
      Throwable localThrowable = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(59811);
      throw localThrowable;
    }
    this.APF = true;
    AppMethodBeat.o(59811);
  }
  
  public final void setDebugMode(boolean paramBoolean)
  {
    AppMethodBeat.i(59822);
    this.abiF.a(cMt[6], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59822);
  }
  
  public static final class b
    extends kotlin.i.b<T>
  {
    public b(Object paramObject1, Object paramObject2, j paramj)
    {
      super();
    }
    
    public final boolean b(kotlin.l.n<?> paramn)
    {
      AppMethodBeat.i(59807);
      kotlin.g.b.p.k(paramn, "property");
      if (jdField_this.APF)
      {
        paramn = (Throwable)new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
        AppMethodBeat.o(59807);
        throw paramn;
      }
      AppMethodBeat.o(59807);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.i.j
 * JD-Core Version:    0.7.0.1
 */