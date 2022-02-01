package d.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.x;
import d.aa;
import d.g.b.l;
import d.g.b.w;
import d.i.c;
import d.l.b.a.b.b.av;
import d.l.b.a.b.m.ab;
import java.util.Set;

public final class j
  implements i
{
  private final c LCV;
  final c LCW;
  final c LCX;
  private final c LCY;
  private final c LCZ;
  private final c LDA;
  final c LDB;
  final c LDC;
  final c LDD;
  private final c LDE;
  final c LDF;
  private final c LDG;
  private final c LDH;
  final c LDI;
  private final c LDJ;
  private final c LDK;
  private final c LDL;
  private final c LDM;
  private final c LDN;
  private final c LDO;
  private final c LDP;
  private final c LDa;
  private final c LDb;
  final c LDc;
  private final c LDd;
  final c LDe;
  final c LDf;
  private final c LDg;
  final c LDh;
  private final c LDi;
  final c LDj;
  final c LDk;
  private final c LDl;
  private final c LDm;
  private final c LDn;
  private final c LDo;
  private final c LDp;
  final c LDq;
  final c LDr;
  private final c LDs;
  private final c LDt;
  private final c LDu;
  private final c LDv;
  private final c LDw;
  final c LDx;
  final c LDy;
  final c LDz;
  boolean aGn;
  
  static
  {
    AppMethodBeat.i(59810);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "withDefinedIn", "getWithDefinedIn()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "modifiers", "getModifiers()Ljava/util/Set;")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "startFromName", "getStartFromName()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "debugMode", "getDebugMode()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "verbose", "getVerbose()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "unitReturnType", "getUnitReturnType()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "withoutReturnType", "getWithoutReturnType()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "enhancedTypes", "getEnhancedTypes()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "normalizedVisibilities", "getNormalizedVisibilities()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "renderDefaultVisibility", "getRenderDefaultVisibility()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "renderDefaultModality", "getRenderDefaultModality()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "renderConstructorDelegation", "getRenderConstructorDelegation()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "includePropertyConstant", "getIncludePropertyConstant()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "withoutTypeParameters", "getWithoutTypeParameters()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "withoutSuperTypes", "getWithoutSuperTypes()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "receiverAfterName", "getReceiverAfterName()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "renderCompanionObjectName", "getRenderCompanionObjectName()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "renderConstructorKeyword", "getRenderConstructorKeyword()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "renderTypeExpansions", "getRenderTypeExpansions()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "renderFunctionContracts", "getRenderFunctionContracts()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z")), (d.l.k)w.a(new d.g.b.o(w.bn(j.class), "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z")) };
    AppMethodBeat.o(59810);
  }
  
  public j()
  {
    AppMethodBeat.i(59855);
    this.LCV = fp(b.c.LCa);
    this.LCW = fp(Boolean.TRUE);
    this.LCX = fp(Boolean.TRUE);
    this.LCY = fp(h.LCS);
    this.LCZ = fp(Boolean.FALSE);
    this.LDa = fp(Boolean.FALSE);
    this.LDb = fp(Boolean.FALSE);
    this.LDc = fp(Boolean.FALSE);
    this.LDd = fp(Boolean.FALSE);
    this.LDe = fp(Boolean.TRUE);
    this.LDf = fp(Boolean.FALSE);
    this.LDg = fp(Boolean.FALSE);
    this.LDh = fp(Boolean.FALSE);
    this.LDi = fp(Boolean.TRUE);
    this.LDj = fp(Boolean.TRUE);
    this.LDk = fp(Boolean.FALSE);
    this.LDl = fp(Boolean.FALSE);
    this.LDm = fp(Boolean.FALSE);
    this.LDn = fp(Boolean.FALSE);
    this.LDo = fp(Boolean.FALSE);
    this.LDp = fp(Boolean.FALSE);
    this.LDq = fp(Boolean.FALSE);
    this.LDr = fp(c.LDS);
    this.LDs = fp(a.LDQ);
    this.LDt = fp(Boolean.TRUE);
    this.LDu = fp(m.LDX);
    this.LDv = fp(c.k.a.LCu);
    this.LDw = fp(p.LEi);
    this.LDx = fp(n.LEa);
    this.LDy = fp(Boolean.FALSE);
    this.LDz = fp(Boolean.FALSE);
    this.LDA = fp(o.LEf);
    this.LDB = fp(Boolean.FALSE);
    this.LDC = fp(Boolean.FALSE);
    this.LDD = fp((Set)x.KTH);
    k localk = k.LDU;
    this.LDE = fp(k.gbt());
    this.LDF = fp(null);
    this.LDG = fp(a.LBS);
    this.LDH = fp(Boolean.FALSE);
    this.LDI = fp(Boolean.TRUE);
    this.LDJ = fp(Boolean.TRUE);
    this.LDK = fp(Boolean.FALSE);
    this.LDL = fp(Boolean.TRUE);
    this.LDM = fp(Boolean.TRUE);
    this.LDN = fp(Boolean.FALSE);
    this.LDO = fp(Boolean.FALSE);
    this.LDP = fp(Boolean.FALSE);
    AppMethodBeat.o(59855);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(59847);
    d.g.b.k.h(parama, "<set-?>");
    this.LDG.a($$delegatedProperties[37], parama);
    AppMethodBeat.o(59847);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(59814);
    d.g.b.k.h(paramb, "<set-?>");
    this.LCV.a($$delegatedProperties[0], paramb);
    AppMethodBeat.o(59814);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(59840);
    d.g.b.k.h(paramn, "<set-?>");
    this.LDx.a($$delegatedProperties[28], paramn);
    AppMethodBeat.o(59840);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(59839);
    d.g.b.k.h(paramp, "<set-?>");
    this.LDw.a($$delegatedProperties[27], paramp);
    AppMethodBeat.o(59839);
  }
  
  final <T> c<j, T> fp(T paramT)
  {
    AppMethodBeat.i(59812);
    d.i.a locala = d.i.a.KUU;
    paramT = (c)new b(paramT, paramT, this);
    AppMethodBeat.o(59812);
    return paramT;
  }
  
  public final a gaR()
  {
    AppMethodBeat.i(59846);
    a locala = (a)this.LDG.a($$delegatedProperties[37]);
    AppMethodBeat.o(59846);
    return locala;
  }
  
  public final boolean gaS()
  {
    AppMethodBeat.i(59821);
    boolean bool = ((Boolean)this.LDb.a($$delegatedProperties[6])).booleanValue();
    AppMethodBeat.o(59821);
    return bool;
  }
  
  public final boolean gaT()
  {
    AppMethodBeat.i(59825);
    boolean bool = ((Boolean)this.LDg.a($$delegatedProperties[11])).booleanValue();
    AppMethodBeat.o(59825);
    return bool;
  }
  
  public final Set<d.l.b.a.b.f.b> gaU()
  {
    AppMethodBeat.i(59844);
    Set localSet = (Set)this.LDE.a($$delegatedProperties[35]);
    AppMethodBeat.o(59844);
    return localSet;
  }
  
  public final b gaV()
  {
    AppMethodBeat.i(59813);
    b localb = (b)this.LCV.a($$delegatedProperties[0]);
    AppMethodBeat.o(59813);
    return localb;
  }
  
  public final Set<h> gaW()
  {
    AppMethodBeat.i(59816);
    Set localSet = (Set)this.LCY.a($$delegatedProperties[3]);
    AppMethodBeat.o(59816);
    return localSet;
  }
  
  public final boolean gaX()
  {
    AppMethodBeat.i(59818);
    boolean bool = ((Boolean)this.LCZ.a($$delegatedProperties[4])).booleanValue();
    AppMethodBeat.o(59818);
    return bool;
  }
  
  public final boolean gaY()
  {
    AppMethodBeat.i(59820);
    boolean bool = ((Boolean)this.LDa.a($$delegatedProperties[5])).booleanValue();
    AppMethodBeat.o(59820);
    return bool;
  }
  
  public final boolean gaZ()
  {
    AppMethodBeat.i(59823);
    boolean bool = ((Boolean)this.LDd.a($$delegatedProperties[8])).booleanValue();
    AppMethodBeat.o(59823);
    return bool;
  }
  
  public final boolean gba()
  {
    AppMethodBeat.i(59826);
    boolean bool = ((Boolean)this.LDi.a($$delegatedProperties[13])).booleanValue();
    AppMethodBeat.o(59826);
    return bool;
  }
  
  public final boolean gbb()
  {
    AppMethodBeat.i(59827);
    boolean bool = ((Boolean)this.LDl.a($$delegatedProperties[16])).booleanValue();
    AppMethodBeat.o(59827);
    return bool;
  }
  
  public final boolean gbc()
  {
    AppMethodBeat.i(59828);
    boolean bool = ((Boolean)this.LDm.a($$delegatedProperties[17])).booleanValue();
    AppMethodBeat.o(59828);
    return bool;
  }
  
  public final boolean gbd()
  {
    AppMethodBeat.i(59829);
    boolean bool = ((Boolean)this.LDn.a($$delegatedProperties[18])).booleanValue();
    AppMethodBeat.o(59829);
    return bool;
  }
  
  public final boolean gbe()
  {
    AppMethodBeat.i(59830);
    boolean bool = ((Boolean)this.LDo.a($$delegatedProperties[19])).booleanValue();
    AppMethodBeat.o(59830);
    return bool;
  }
  
  public final boolean gbf()
  {
    AppMethodBeat.i(59831);
    boolean bool = ((Boolean)this.LDp.a($$delegatedProperties[20])).booleanValue();
    AppMethodBeat.o(59831);
    return bool;
  }
  
  public final d.g.a.b<av, String> gbg()
  {
    AppMethodBeat.i(59834);
    d.g.a.b localb = (d.g.a.b)this.LDs.a($$delegatedProperties[23]);
    AppMethodBeat.o(59834);
    return localb;
  }
  
  public final boolean gbh()
  {
    AppMethodBeat.i(59835);
    boolean bool = ((Boolean)this.LDt.a($$delegatedProperties[24])).booleanValue();
    AppMethodBeat.o(59835);
    return bool;
  }
  
  public final m gbi()
  {
    AppMethodBeat.i(59836);
    m localm = (m)this.LDu.a($$delegatedProperties[25]);
    AppMethodBeat.o(59836);
    return localm;
  }
  
  public final c.k gbj()
  {
    AppMethodBeat.i(59837);
    c.k localk = (c.k)this.LDv.a($$delegatedProperties[26]);
    AppMethodBeat.o(59837);
    return localk;
  }
  
  public final p gbk()
  {
    AppMethodBeat.i(59838);
    p localp = (p)this.LDw.a($$delegatedProperties[27]);
    AppMethodBeat.o(59838);
    return localp;
  }
  
  public final o gbl()
  {
    AppMethodBeat.i(59843);
    o localo = (o)this.LDA.a($$delegatedProperties[31]);
    AppMethodBeat.o(59843);
    return localo;
  }
  
  public final boolean gbm()
  {
    AppMethodBeat.i(59848);
    boolean bool = ((Boolean)this.LDH.a($$delegatedProperties[38])).booleanValue();
    AppMethodBeat.o(59848);
    return bool;
  }
  
  public final boolean gbn()
  {
    AppMethodBeat.i(59849);
    boolean bool = ((Boolean)this.LDJ.a($$delegatedProperties[40])).booleanValue();
    AppMethodBeat.o(59849);
    return bool;
  }
  
  public final boolean gbo()
  {
    AppMethodBeat.i(59850);
    boolean bool = ((Boolean)this.LDK.a($$delegatedProperties[41])).booleanValue();
    AppMethodBeat.o(59850);
    return bool;
  }
  
  public final boolean gbp()
  {
    AppMethodBeat.i(59851);
    boolean bool = ((Boolean)this.LDL.a($$delegatedProperties[42])).booleanValue();
    AppMethodBeat.o(59851);
    return bool;
  }
  
  public final boolean gbq()
  {
    AppMethodBeat.i(59852);
    boolean bool = ((Boolean)this.LDM.a($$delegatedProperties[43])).booleanValue();
    AppMethodBeat.o(59852);
    return bool;
  }
  
  public final boolean gbr()
  {
    AppMethodBeat.i(59853);
    boolean bool = ((Boolean)this.LDO.a($$delegatedProperties[45])).booleanValue();
    AppMethodBeat.o(59853);
    return bool;
  }
  
  public final boolean gbs()
  {
    AppMethodBeat.i(59854);
    boolean bool = ((Boolean)this.LDP.a($$delegatedProperties[46])).booleanValue();
    AppMethodBeat.o(59854);
    return bool;
  }
  
  public final void lock()
  {
    AppMethodBeat.i(59811);
    if (!this.aGn) {}
    for (int i = 1; (aa.KTq) && (i == 0); i = 0)
    {
      Throwable localThrowable = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(59811);
      throw localThrowable;
    }
    this.aGn = true;
    AppMethodBeat.o(59811);
  }
  
  public final void n(Set<d.l.b.a.b.f.b> paramSet)
  {
    AppMethodBeat.i(59845);
    d.g.b.k.h(paramSet, "<set-?>");
    this.LDE.a($$delegatedProperties[35], paramSet);
    AppMethodBeat.o(59845);
  }
  
  public final void o(Set<? extends h> paramSet)
  {
    AppMethodBeat.i(59817);
    d.g.b.k.h(paramSet, "<set-?>");
    this.LCY.a($$delegatedProperties[3], paramSet);
    AppMethodBeat.o(59817);
  }
  
  public final void setDebugMode(boolean paramBoolean)
  {
    AppMethodBeat.i(59822);
    this.LDb.a($$delegatedProperties[6], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59822);
  }
  
  public final void zt(boolean paramBoolean)
  {
    AppMethodBeat.i(59841);
    this.LDy.a($$delegatedProperties[29], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59841);
  }
  
  public final void zu(boolean paramBoolean)
  {
    AppMethodBeat.i(59842);
    this.LDz.a($$delegatedProperties[30], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59842);
  }
  
  public final void zv(boolean paramBoolean)
  {
    AppMethodBeat.i(59819);
    this.LCZ.a($$delegatedProperties[4], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59819);
  }
  
  public final void zw(boolean paramBoolean)
  {
    AppMethodBeat.i(59824);
    this.LDd.a($$delegatedProperties[8], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59824);
  }
  
  public final void zx(boolean paramBoolean)
  {
    AppMethodBeat.i(59815);
    this.LCW.a($$delegatedProperties[1], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59815);
  }
  
  public final void zy(boolean paramBoolean)
  {
    AppMethodBeat.i(59833);
    this.LDq.a($$delegatedProperties[21], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59833);
  }
  
  public final void zz(boolean paramBoolean)
  {
    AppMethodBeat.i(59832);
    this.LDp.a($$delegatedProperties[20], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(59832);
  }
  
  static final class a
    extends l
    implements d.g.a.b<av, String>
  {
    public static final a LDQ;
    
    static
    {
      AppMethodBeat.i(59806);
      LDQ = new a();
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
      d.g.b.k.h(paramk, "property");
      if (jdField_this.aGn)
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
    extends l
    implements d.g.a.b<ab, ab>
  {
    public static final c LDS;
    
    static
    {
      AppMethodBeat.i(59809);
      LDS = new c();
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