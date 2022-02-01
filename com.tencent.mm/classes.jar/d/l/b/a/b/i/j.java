package d.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.x;
import d.ac;
import d.g.b.u;
import d.g.b.z;
import d.i.c;
import d.l.b.a.b.b.av;
import java.util.Set;

public final class j
  implements i
{
  private final c NtT;
  final c NtU;
  final c NtV;
  private final c NtW;
  private final c NtX;
  private final c NtY;
  private final c NtZ;
  final c NuA;
  final c NuB;
  private final c NuC;
  final c NuD;
  private final c NuE;
  private final c NuF;
  final c NuG;
  private final c NuH;
  private final c NuI;
  private final c NuJ;
  private final c NuK;
  private final c NuL;
  private final c NuM;
  private final c NuN;
  private final c NuO;
  final c Nua;
  private final c Nub;
  final c Nuc;
  final c Nud;
  private final c Nue;
  final c Nuf;
  private final c Nug;
  final c Nuh;
  final c Nui;
  private final c Nuj;
  private final c Nuk;
  private final c Nul;
  private final c Num;
  private final c Nun;
  final c Nuo;
  final c Nup;
  private final c Nuq;
  private final c Nur;
  private final c Nus;
  private final c Nut;
  private final c Nuu;
  final c Nuv;
  final c Nuw;
  final c Nux;
  private final c Nuy;
  final c Nuz;
  boolean aIe;
  
  static
  {
    AppMethodBeat.i(59810);
    cwV = new d.l.k[] { (d.l.k)z.a(new u(z.bp(j.class), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;")), (d.l.k)z.a(new u(z.bp(j.class), "withDefinedIn", "getWithDefinedIn()Z")), (d.l.k)z.a(new u(z.bp(j.class), "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z")), (d.l.k)z.a(new u(z.bp(j.class), "modifiers", "getModifiers()Ljava/util/Set;")), (d.l.k)z.a(new u(z.bp(j.class), "startFromName", "getStartFromName()Z")), (d.l.k)z.a(new u(z.bp(j.class), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z")), (d.l.k)z.a(new u(z.bp(j.class), "debugMode", "getDebugMode()Z")), (d.l.k)z.a(new u(z.bp(j.class), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z")), (d.l.k)z.a(new u(z.bp(j.class), "verbose", "getVerbose()Z")), (d.l.k)z.a(new u(z.bp(j.class), "unitReturnType", "getUnitReturnType()Z")), (d.l.k)z.a(new u(z.bp(j.class), "withoutReturnType", "getWithoutReturnType()Z")), (d.l.k)z.a(new u(z.bp(j.class), "enhancedTypes", "getEnhancedTypes()Z")), (d.l.k)z.a(new u(z.bp(j.class), "normalizedVisibilities", "getNormalizedVisibilities()Z")), (d.l.k)z.a(new u(z.bp(j.class), "renderDefaultVisibility", "getRenderDefaultVisibility()Z")), (d.l.k)z.a(new u(z.bp(j.class), "renderDefaultModality", "getRenderDefaultModality()Z")), (d.l.k)z.a(new u(z.bp(j.class), "renderConstructorDelegation", "getRenderConstructorDelegation()Z")), (d.l.k)z.a(new u(z.bp(j.class), "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z")), (d.l.k)z.a(new u(z.bp(j.class), "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z")), (d.l.k)z.a(new u(z.bp(j.class), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z")), (d.l.k)z.a(new u(z.bp(j.class), "includePropertyConstant", "getIncludePropertyConstant()Z")), (d.l.k)z.a(new u(z.bp(j.class), "withoutTypeParameters", "getWithoutTypeParameters()Z")), (d.l.k)z.a(new u(z.bp(j.class), "withoutSuperTypes", "getWithoutSuperTypes()Z")), (d.l.k)z.a(new u(z.bp(j.class), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;")), (d.l.k)z.a(new u(z.bp(j.class), "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;")), (d.l.k)z.a(new u(z.bp(j.class), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z")), (d.l.k)z.a(new u(z.bp(j.class), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;")), (d.l.k)z.a(new u(z.bp(j.class), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;")), (d.l.k)z.a(new u(z.bp(j.class), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;")), (d.l.k)z.a(new u(z.bp(j.class), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;")), (d.l.k)z.a(new u(z.bp(j.class), "receiverAfterName", "getReceiverAfterName()Z")), (d.l.k)z.a(new u(z.bp(j.class), "renderCompanionObjectName", "getRenderCompanionObjectName()Z")), (d.l.k)z.a(new u(z.bp(j.class), "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;")), (d.l.k)z.a(new u(z.bp(j.class), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z")), (d.l.k)z.a(new u(z.bp(j.class), "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z")), (d.l.k)z.a(new u(z.bp(j.class), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;")), (d.l.k)z.a(new u(z.bp(j.class), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;")), (d.l.k)z.a(new u(z.bp(j.class), "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;")), (d.l.k)z.a(new u(z.bp(j.class), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;")), (d.l.k)z.a(new u(z.bp(j.class), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z")), (d.l.k)z.a(new u(z.bp(j.class), "renderConstructorKeyword", "getRenderConstructorKeyword()Z")), (d.l.k)z.a(new u(z.bp(j.class), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z")), (d.l.k)z.a(new u(z.bp(j.class), "renderTypeExpansions", "getRenderTypeExpansions()Z")), (d.l.k)z.a(new u(z.bp(j.class), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z")), (d.l.k)z.a(new u(z.bp(j.class), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z")), (d.l.k)z.a(new u(z.bp(j.class), "renderFunctionContracts", "getRenderFunctionContracts()Z")), (d.l.k)z.a(new u(z.bp(j.class), "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z")), (d.l.k)z.a(new u(z.bp(j.class), "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z")), (d.l.k)z.a(new u(z.bp(j.class), "informativeErrorType", "getInformativeErrorType()Z")) };
    AppMethodBeat.o(59810);
  }
  
  public j()
  {
    AppMethodBeat.i(59855);
    this.NtT = fr(b.c.NsW);
    this.NtU = fr(Boolean.TRUE);
    this.NtV = fr(Boolean.TRUE);
    this.NtW = fr(h.NtQ);
    this.NtX = fr(Boolean.FALSE);
    this.NtY = fr(Boolean.FALSE);
    this.NtZ = fr(Boolean.FALSE);
    this.Nua = fr(Boolean.FALSE);
    this.Nub = fr(Boolean.FALSE);
    this.Nuc = fr(Boolean.TRUE);
    this.Nud = fr(Boolean.FALSE);
    this.Nue = fr(Boolean.FALSE);
    this.Nuf = fr(Boolean.FALSE);
    this.Nug = fr(Boolean.TRUE);
    this.Nuh = fr(Boolean.TRUE);
    this.Nui = fr(Boolean.FALSE);
    this.Nuj = fr(Boolean.FALSE);
    this.Nuk = fr(Boolean.FALSE);
    this.Nul = fr(Boolean.FALSE);
    this.Num = fr(Boolean.FALSE);
    this.Nun = fr(Boolean.FALSE);
    this.Nuo = fr(Boolean.FALSE);
    this.Nup = fr(j.c.NuR);
    this.Nuq = fr(j.a.NuP);
    this.Nur = fr(Boolean.TRUE);
    this.Nus = fr(m.NuW);
    this.Nut = fr(c.l.a.Nts);
    this.Nuu = fr(p.Nvh);
    this.Nuv = fr(n.NuZ);
    this.Nuw = fr(Boolean.FALSE);
    this.Nux = fr(Boolean.FALSE);
    this.Nuy = fr(o.Nve);
    this.Nuz = fr(Boolean.FALSE);
    this.NuA = fr(Boolean.FALSE);
    this.NuB = fr((Set)x.MKG);
    k localk = k.NuT;
    this.NuC = fr(k.gsT());
    this.NuD = fr(null);
    this.NuE = fr(a.NsO);
    this.NuF = fr(Boolean.FALSE);
    this.NuG = fr(Boolean.TRUE);
    this.NuH = fr(Boolean.TRUE);
    this.NuI = fr(Boolean.FALSE);
    this.NuJ = fr(Boolean.TRUE);
    this.NuK = fr(Boolean.TRUE);
    this.NuL = fr(Boolean.FALSE);
    this.NuM = fr(Boolean.FALSE);
    this.NuN = fr(Boolean.FALSE);
    this.NuO = fr(Boolean.TRUE);
    AppMethodBeat.o(59855);
  }
  
  public final void Ah(boolean paramBoolean)
  {
    AppMethodBeat.i(59841);
    this.Nuw.a(cwV[29], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59841);
  }
  
  public final void Ai(boolean paramBoolean)
  {
    AppMethodBeat.i(59842);
    this.Nux.a(cwV[30], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59842);
  }
  
  public final void Aj(boolean paramBoolean)
  {
    AppMethodBeat.i(59819);
    this.NtX.a(cwV[4], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59819);
  }
  
  public final void Ak(boolean paramBoolean)
  {
    AppMethodBeat.i(59824);
    this.Nub.a(cwV[8], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59824);
  }
  
  public final void Al(boolean paramBoolean)
  {
    AppMethodBeat.i(59815);
    this.NtU.a(cwV[1], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59815);
  }
  
  public final void Am(boolean paramBoolean)
  {
    AppMethodBeat.i(59833);
    this.Nuo.a(cwV[21], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59833);
  }
  
  public final void An(boolean paramBoolean)
  {
    AppMethodBeat.i(59832);
    this.Nun.a(cwV[20], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59832);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(59847);
    d.g.b.p.h(parama, "<set-?>");
    this.NuE.a(cwV[37], parama);
    AppMethodBeat.o(59847);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(59814);
    d.g.b.p.h(paramb, "<set-?>");
    this.NtT.a(cwV[0], paramb);
    AppMethodBeat.o(59814);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(59840);
    d.g.b.p.h(paramn, "<set-?>");
    this.Nuv.a(cwV[28], paramn);
    AppMethodBeat.o(59840);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(59839);
    d.g.b.p.h(paramp, "<set-?>");
    this.Nuu.a(cwV[27], paramp);
    AppMethodBeat.o(59839);
  }
  
  final <T> c<j, T> fr(T paramT)
  {
    AppMethodBeat.i(59812);
    d.i.a locala = d.i.a.MMa;
    paramT = (c)new b(paramT, paramT, this);
    AppMethodBeat.o(59812);
    return paramT;
  }
  
  public final boolean gsA()
  {
    AppMethodBeat.i(59827);
    boolean bool = ((Boolean)this.Nuj.a(cwV[16])).booleanValue();
    AppMethodBeat.o(59827);
    return bool;
  }
  
  public final boolean gsB()
  {
    AppMethodBeat.i(59828);
    boolean bool = ((Boolean)this.Nuk.a(cwV[17])).booleanValue();
    AppMethodBeat.o(59828);
    return bool;
  }
  
  public final boolean gsC()
  {
    AppMethodBeat.i(59829);
    boolean bool = ((Boolean)this.Nul.a(cwV[18])).booleanValue();
    AppMethodBeat.o(59829);
    return bool;
  }
  
  public final boolean gsD()
  {
    AppMethodBeat.i(59830);
    boolean bool = ((Boolean)this.Num.a(cwV[19])).booleanValue();
    AppMethodBeat.o(59830);
    return bool;
  }
  
  public final boolean gsE()
  {
    AppMethodBeat.i(59831);
    boolean bool = ((Boolean)this.Nun.a(cwV[20])).booleanValue();
    AppMethodBeat.o(59831);
    return bool;
  }
  
  public final d.g.a.b<av, String> gsF()
  {
    AppMethodBeat.i(59834);
    d.g.a.b localb = (d.g.a.b)this.Nuq.a(cwV[23]);
    AppMethodBeat.o(59834);
    return localb;
  }
  
  public final boolean gsG()
  {
    AppMethodBeat.i(59835);
    boolean bool = ((Boolean)this.Nur.a(cwV[24])).booleanValue();
    AppMethodBeat.o(59835);
    return bool;
  }
  
  public final m gsH()
  {
    AppMethodBeat.i(59836);
    m localm = (m)this.Nus.a(cwV[25]);
    AppMethodBeat.o(59836);
    return localm;
  }
  
  public final c.l gsI()
  {
    AppMethodBeat.i(59837);
    c.l locall = (c.l)this.Nut.a(cwV[26]);
    AppMethodBeat.o(59837);
    return locall;
  }
  
  public final p gsJ()
  {
    AppMethodBeat.i(59838);
    p localp = (p)this.Nuu.a(cwV[27]);
    AppMethodBeat.o(59838);
    return localp;
  }
  
  public final o gsK()
  {
    AppMethodBeat.i(59843);
    o localo = (o)this.Nuy.a(cwV[31]);
    AppMethodBeat.o(59843);
    return localo;
  }
  
  public final boolean gsL()
  {
    AppMethodBeat.i(59848);
    boolean bool = ((Boolean)this.NuF.a(cwV[38])).booleanValue();
    AppMethodBeat.o(59848);
    return bool;
  }
  
  public final boolean gsM()
  {
    AppMethodBeat.i(59849);
    boolean bool = ((Boolean)this.NuH.a(cwV[40])).booleanValue();
    AppMethodBeat.o(59849);
    return bool;
  }
  
  public final boolean gsN()
  {
    AppMethodBeat.i(59850);
    boolean bool = ((Boolean)this.NuI.a(cwV[41])).booleanValue();
    AppMethodBeat.o(59850);
    return bool;
  }
  
  public final boolean gsO()
  {
    AppMethodBeat.i(59851);
    boolean bool = ((Boolean)this.NuJ.a(cwV[42])).booleanValue();
    AppMethodBeat.o(59851);
    return bool;
  }
  
  public final boolean gsP()
  {
    AppMethodBeat.i(59852);
    boolean bool = ((Boolean)this.NuK.a(cwV[43])).booleanValue();
    AppMethodBeat.o(59852);
    return bool;
  }
  
  public final boolean gsQ()
  {
    AppMethodBeat.i(59853);
    boolean bool = ((Boolean)this.NuM.a(cwV[45])).booleanValue();
    AppMethodBeat.o(59853);
    return bool;
  }
  
  public final boolean gsR()
  {
    AppMethodBeat.i(59854);
    boolean bool = ((Boolean)this.NuN.a(cwV[46])).booleanValue();
    AppMethodBeat.o(59854);
    return bool;
  }
  
  public final boolean gsS()
  {
    AppMethodBeat.i(187783);
    boolean bool = ((Boolean)this.NuO.a(cwV[47])).booleanValue();
    AppMethodBeat.o(187783);
    return bool;
  }
  
  public final a gsq()
  {
    AppMethodBeat.i(59846);
    a locala = (a)this.NuE.a(cwV[37]);
    AppMethodBeat.o(59846);
    return locala;
  }
  
  public final boolean gsr()
  {
    AppMethodBeat.i(59821);
    boolean bool = ((Boolean)this.NtZ.a(cwV[6])).booleanValue();
    AppMethodBeat.o(59821);
    return bool;
  }
  
  public final boolean gss()
  {
    AppMethodBeat.i(59825);
    boolean bool = ((Boolean)this.Nue.a(cwV[11])).booleanValue();
    AppMethodBeat.o(59825);
    return bool;
  }
  
  public final Set<d.l.b.a.b.f.b> gst()
  {
    AppMethodBeat.i(59844);
    Set localSet = (Set)this.NuC.a(cwV[35]);
    AppMethodBeat.o(59844);
    return localSet;
  }
  
  public final b gsu()
  {
    AppMethodBeat.i(59813);
    b localb = (b)this.NtT.a(cwV[0]);
    AppMethodBeat.o(59813);
    return localb;
  }
  
  public final Set<h> gsv()
  {
    AppMethodBeat.i(59816);
    Set localSet = (Set)this.NtW.a(cwV[3]);
    AppMethodBeat.o(59816);
    return localSet;
  }
  
  public final boolean gsw()
  {
    AppMethodBeat.i(59818);
    boolean bool = ((Boolean)this.NtX.a(cwV[4])).booleanValue();
    AppMethodBeat.o(59818);
    return bool;
  }
  
  public final boolean gsx()
  {
    AppMethodBeat.i(59820);
    boolean bool = ((Boolean)this.NtY.a(cwV[5])).booleanValue();
    AppMethodBeat.o(59820);
    return bool;
  }
  
  public final boolean gsy()
  {
    AppMethodBeat.i(59823);
    boolean bool = ((Boolean)this.Nub.a(cwV[8])).booleanValue();
    AppMethodBeat.o(59823);
    return bool;
  }
  
  public final boolean gsz()
  {
    AppMethodBeat.i(59826);
    boolean bool = ((Boolean)this.Nug.a(cwV[13])).booleanValue();
    AppMethodBeat.o(59826);
    return bool;
  }
  
  public final void lock()
  {
    AppMethodBeat.i(59811);
    if (!this.aIe) {}
    for (int i = 1; (ac.MKp) && (i == 0); i = 0)
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
    this.NtZ.a(cwV[6], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59822);
  }
  
  public final void u(Set<d.l.b.a.b.f.b> paramSet)
  {
    AppMethodBeat.i(59845);
    d.g.b.p.h(paramSet, "<set-?>");
    this.NuC.a(cwV[35], paramSet);
    AppMethodBeat.o(59845);
  }
  
  public final void v(Set<? extends h> paramSet)
  {
    AppMethodBeat.i(59817);
    d.g.b.p.h(paramSet, "<set-?>");
    this.NtW.a(cwV[3], paramSet);
    AppMethodBeat.o(59817);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.i.j
 * JD-Core Version:    0.7.0.1
 */