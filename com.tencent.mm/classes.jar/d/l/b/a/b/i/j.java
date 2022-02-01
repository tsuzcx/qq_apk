package d.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.x;
import d.aa;
import d.g.b.w;
import d.i.c;
import d.l.b.a.b.b.av;
import java.util.Set;

public final class j
  implements i
{
  private final c JPB;
  final c JPC;
  final c JPD;
  private final c JPE;
  private final c JPF;
  private final c JPH;
  private final c JPI;
  final c JPJ;
  private final c JPK;
  final c JPL;
  final c JPM;
  private final c JPN;
  final c JPO;
  private final c JPP;
  final c JPQ;
  final c JPR;
  private final c JPS;
  private final c JPT;
  private final c JPU;
  private final c JPV;
  private final c JPW;
  final c JPX;
  final c JPY;
  private final c JPZ;
  private final c JQa;
  private final c JQb;
  private final c JQc;
  private final c JQd;
  final c JQe;
  final c JQf;
  final c JQg;
  private final c JQh;
  final c JQi;
  final c JQj;
  final c JQk;
  private final c JQl;
  final c JQm;
  private final c JQn;
  private final c JQo;
  final c JQp;
  private final c JQq;
  private final c JQr;
  private final c JQs;
  private final c JQt;
  private final c JQu;
  private final c JQv;
  private final c JQw;
  boolean aFx;
  
  static
  {
    AppMethodBeat.i(59810);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "withDefinedIn", "getWithDefinedIn()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "modifiers", "getModifiers()Ljava/util/Set;")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "startFromName", "getStartFromName()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "debugMode", "getDebugMode()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "verbose", "getVerbose()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "unitReturnType", "getUnitReturnType()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "withoutReturnType", "getWithoutReturnType()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "enhancedTypes", "getEnhancedTypes()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "normalizedVisibilities", "getNormalizedVisibilities()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "renderDefaultVisibility", "getRenderDefaultVisibility()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "renderDefaultModality", "getRenderDefaultModality()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "renderConstructorDelegation", "getRenderConstructorDelegation()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "includePropertyConstant", "getIncludePropertyConstant()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "withoutTypeParameters", "getWithoutTypeParameters()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "withoutSuperTypes", "getWithoutSuperTypes()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "receiverAfterName", "getReceiverAfterName()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "renderCompanionObjectName", "getRenderCompanionObjectName()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "renderConstructorKeyword", "getRenderConstructorKeyword()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "renderTypeExpansions", "getRenderTypeExpansions()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "renderFunctionContracts", "getRenderFunctionContracts()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z")), (d.l.k)w.a(new d.g.b.o(w.bk(j.class), "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z")) };
    AppMethodBeat.o(59810);
  }
  
  public j()
  {
    AppMethodBeat.i(59855);
    this.JPB = fm(b.c.JOG);
    this.JPC = fm(Boolean.TRUE);
    this.JPD = fm(Boolean.TRUE);
    this.JPE = fm(h.JPy);
    this.JPF = fm(Boolean.FALSE);
    this.JPH = fm(Boolean.FALSE);
    this.JPI = fm(Boolean.FALSE);
    this.JPJ = fm(Boolean.FALSE);
    this.JPK = fm(Boolean.FALSE);
    this.JPL = fm(Boolean.TRUE);
    this.JPM = fm(Boolean.FALSE);
    this.JPN = fm(Boolean.FALSE);
    this.JPO = fm(Boolean.FALSE);
    this.JPP = fm(Boolean.TRUE);
    this.JPQ = fm(Boolean.TRUE);
    this.JPR = fm(Boolean.FALSE);
    this.JPS = fm(Boolean.FALSE);
    this.JPT = fm(Boolean.FALSE);
    this.JPU = fm(Boolean.FALSE);
    this.JPV = fm(Boolean.FALSE);
    this.JPW = fm(Boolean.FALSE);
    this.JPX = fm(Boolean.FALSE);
    this.JPY = fm(j.c.JQz);
    this.JPZ = fm(j.a.JQx);
    this.JQa = fm(Boolean.TRUE);
    this.JQb = fm(m.JQE);
    this.JQc = fm(c.k.a.JPa);
    this.JQd = fm(p.JQP);
    this.JQe = fm(n.JQH);
    this.JQf = fm(Boolean.FALSE);
    this.JQg = fm(Boolean.FALSE);
    this.JQh = fm(o.JQM);
    this.JQi = fm(Boolean.FALSE);
    this.JQj = fm(Boolean.FALSE);
    this.JQk = fm((Set)x.Jgn);
    k localk = k.JQB;
    this.JQl = fm(k.fIQ());
    this.JQm = fm(null);
    this.JQn = fm(a.JOy);
    this.JQo = fm(Boolean.FALSE);
    this.JQp = fm(Boolean.TRUE);
    this.JQq = fm(Boolean.TRUE);
    this.JQr = fm(Boolean.FALSE);
    this.JQs = fm(Boolean.TRUE);
    this.JQt = fm(Boolean.TRUE);
    this.JQu = fm(Boolean.FALSE);
    this.JQv = fm(Boolean.FALSE);
    this.JQw = fm(Boolean.FALSE);
    AppMethodBeat.o(59855);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(59847);
    d.g.b.k.h(parama, "<set-?>");
    this.JQn.a($$delegatedProperties[37], parama);
    AppMethodBeat.o(59847);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(59814);
    d.g.b.k.h(paramb, "<set-?>");
    this.JPB.a($$delegatedProperties[0], paramb);
    AppMethodBeat.o(59814);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(59840);
    d.g.b.k.h(paramn, "<set-?>");
    this.JQe.a($$delegatedProperties[28], paramn);
    AppMethodBeat.o(59840);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(59839);
    d.g.b.k.h(paramp, "<set-?>");
    this.JQd.a($$delegatedProperties[27], paramp);
    AppMethodBeat.o(59839);
  }
  
  public final boolean fIA()
  {
    AppMethodBeat.i(59829);
    boolean bool = ((Boolean)this.JPU.a($$delegatedProperties[18])).booleanValue();
    AppMethodBeat.o(59829);
    return bool;
  }
  
  public final boolean fIB()
  {
    AppMethodBeat.i(59830);
    boolean bool = ((Boolean)this.JPV.a($$delegatedProperties[19])).booleanValue();
    AppMethodBeat.o(59830);
    return bool;
  }
  
  public final boolean fIC()
  {
    AppMethodBeat.i(59831);
    boolean bool = ((Boolean)this.JPW.a($$delegatedProperties[20])).booleanValue();
    AppMethodBeat.o(59831);
    return bool;
  }
  
  public final d.g.a.b<av, String> fID()
  {
    AppMethodBeat.i(59834);
    d.g.a.b localb = (d.g.a.b)this.JPZ.a($$delegatedProperties[23]);
    AppMethodBeat.o(59834);
    return localb;
  }
  
  public final boolean fIE()
  {
    AppMethodBeat.i(59835);
    boolean bool = ((Boolean)this.JQa.a($$delegatedProperties[24])).booleanValue();
    AppMethodBeat.o(59835);
    return bool;
  }
  
  public final m fIF()
  {
    AppMethodBeat.i(59836);
    m localm = (m)this.JQb.a($$delegatedProperties[25]);
    AppMethodBeat.o(59836);
    return localm;
  }
  
  public final c.k fIG()
  {
    AppMethodBeat.i(59837);
    c.k localk = (c.k)this.JQc.a($$delegatedProperties[26]);
    AppMethodBeat.o(59837);
    return localk;
  }
  
  public final p fIH()
  {
    AppMethodBeat.i(59838);
    p localp = (p)this.JQd.a($$delegatedProperties[27]);
    AppMethodBeat.o(59838);
    return localp;
  }
  
  public final o fII()
  {
    AppMethodBeat.i(59843);
    o localo = (o)this.JQh.a($$delegatedProperties[31]);
    AppMethodBeat.o(59843);
    return localo;
  }
  
  public final boolean fIJ()
  {
    AppMethodBeat.i(59848);
    boolean bool = ((Boolean)this.JQo.a($$delegatedProperties[38])).booleanValue();
    AppMethodBeat.o(59848);
    return bool;
  }
  
  public final boolean fIK()
  {
    AppMethodBeat.i(59849);
    boolean bool = ((Boolean)this.JQq.a($$delegatedProperties[40])).booleanValue();
    AppMethodBeat.o(59849);
    return bool;
  }
  
  public final boolean fIL()
  {
    AppMethodBeat.i(59850);
    boolean bool = ((Boolean)this.JQr.a($$delegatedProperties[41])).booleanValue();
    AppMethodBeat.o(59850);
    return bool;
  }
  
  public final boolean fIM()
  {
    AppMethodBeat.i(59851);
    boolean bool = ((Boolean)this.JQs.a($$delegatedProperties[42])).booleanValue();
    AppMethodBeat.o(59851);
    return bool;
  }
  
  public final boolean fIN()
  {
    AppMethodBeat.i(59852);
    boolean bool = ((Boolean)this.JQt.a($$delegatedProperties[43])).booleanValue();
    AppMethodBeat.o(59852);
    return bool;
  }
  
  public final boolean fIO()
  {
    AppMethodBeat.i(59853);
    boolean bool = ((Boolean)this.JQv.a($$delegatedProperties[45])).booleanValue();
    AppMethodBeat.o(59853);
    return bool;
  }
  
  public final boolean fIP()
  {
    AppMethodBeat.i(59854);
    boolean bool = ((Boolean)this.JQw.a($$delegatedProperties[46])).booleanValue();
    AppMethodBeat.o(59854);
    return bool;
  }
  
  public final a fIo()
  {
    AppMethodBeat.i(59846);
    a locala = (a)this.JQn.a($$delegatedProperties[37]);
    AppMethodBeat.o(59846);
    return locala;
  }
  
  public final boolean fIp()
  {
    AppMethodBeat.i(59821);
    boolean bool = ((Boolean)this.JPI.a($$delegatedProperties[6])).booleanValue();
    AppMethodBeat.o(59821);
    return bool;
  }
  
  public final boolean fIq()
  {
    AppMethodBeat.i(59825);
    boolean bool = ((Boolean)this.JPN.a($$delegatedProperties[11])).booleanValue();
    AppMethodBeat.o(59825);
    return bool;
  }
  
  public final Set<d.l.b.a.b.f.b> fIr()
  {
    AppMethodBeat.i(59844);
    Set localSet = (Set)this.JQl.a($$delegatedProperties[35]);
    AppMethodBeat.o(59844);
    return localSet;
  }
  
  public final b fIs()
  {
    AppMethodBeat.i(59813);
    b localb = (b)this.JPB.a($$delegatedProperties[0]);
    AppMethodBeat.o(59813);
    return localb;
  }
  
  public final Set<h> fIt()
  {
    AppMethodBeat.i(59816);
    Set localSet = (Set)this.JPE.a($$delegatedProperties[3]);
    AppMethodBeat.o(59816);
    return localSet;
  }
  
  public final boolean fIu()
  {
    AppMethodBeat.i(59818);
    boolean bool = ((Boolean)this.JPF.a($$delegatedProperties[4])).booleanValue();
    AppMethodBeat.o(59818);
    return bool;
  }
  
  public final boolean fIv()
  {
    AppMethodBeat.i(59820);
    boolean bool = ((Boolean)this.JPH.a($$delegatedProperties[5])).booleanValue();
    AppMethodBeat.o(59820);
    return bool;
  }
  
  public final boolean fIw()
  {
    AppMethodBeat.i(59823);
    boolean bool = ((Boolean)this.JPK.a($$delegatedProperties[8])).booleanValue();
    AppMethodBeat.o(59823);
    return bool;
  }
  
  public final boolean fIx()
  {
    AppMethodBeat.i(59826);
    boolean bool = ((Boolean)this.JPP.a($$delegatedProperties[13])).booleanValue();
    AppMethodBeat.o(59826);
    return bool;
  }
  
  public final boolean fIy()
  {
    AppMethodBeat.i(59827);
    boolean bool = ((Boolean)this.JPS.a($$delegatedProperties[16])).booleanValue();
    AppMethodBeat.o(59827);
    return bool;
  }
  
  public final boolean fIz()
  {
    AppMethodBeat.i(59828);
    boolean bool = ((Boolean)this.JPT.a($$delegatedProperties[17])).booleanValue();
    AppMethodBeat.o(59828);
    return bool;
  }
  
  final <T> c<j, T> fm(T paramT)
  {
    AppMethodBeat.i(59812);
    d.i.a locala = d.i.a.JhA;
    paramT = (c)new j.b(paramT, paramT, this);
    AppMethodBeat.o(59812);
    return paramT;
  }
  
  public final void lock()
  {
    AppMethodBeat.i(59811);
    if (!this.aFx) {}
    for (int i = 1; (aa.JfW) && (i == 0); i = 0)
    {
      Throwable localThrowable = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(59811);
      throw localThrowable;
    }
    this.aFx = true;
    AppMethodBeat.o(59811);
  }
  
  public final void m(Set<d.l.b.a.b.f.b> paramSet)
  {
    AppMethodBeat.i(59845);
    d.g.b.k.h(paramSet, "<set-?>");
    this.JQl.a($$delegatedProperties[35], paramSet);
    AppMethodBeat.o(59845);
  }
  
  public final void n(Set<? extends h> paramSet)
  {
    AppMethodBeat.i(59817);
    d.g.b.k.h(paramSet, "<set-?>");
    this.JPE.a($$delegatedProperties[3], paramSet);
    AppMethodBeat.o(59817);
  }
  
  public final void setDebugMode(boolean paramBoolean)
  {
    AppMethodBeat.i(59822);
    this.JPI.a($$delegatedProperties[6], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59822);
  }
  
  public final void yb(boolean paramBoolean)
  {
    AppMethodBeat.i(59841);
    this.JQf.a($$delegatedProperties[29], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59841);
  }
  
  public final void yc(boolean paramBoolean)
  {
    AppMethodBeat.i(59842);
    this.JQg.a($$delegatedProperties[30], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59842);
  }
  
  public final void yd(boolean paramBoolean)
  {
    AppMethodBeat.i(59819);
    this.JPF.a($$delegatedProperties[4], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59819);
  }
  
  public final void ye(boolean paramBoolean)
  {
    AppMethodBeat.i(59824);
    this.JPK.a($$delegatedProperties[8], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59824);
  }
  
  public final void yf(boolean paramBoolean)
  {
    AppMethodBeat.i(59815);
    this.JPC.a($$delegatedProperties[1], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59815);
  }
  
  public final void yg(boolean paramBoolean)
  {
    AppMethodBeat.i(59833);
    this.JPX.a($$delegatedProperties[21], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59833);
  }
  
  public final void yh(boolean paramBoolean)
  {
    AppMethodBeat.i(59832);
    this.JPW.a($$delegatedProperties[20], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.i.j
 * JD-Core Version:    0.7.0.1
 */