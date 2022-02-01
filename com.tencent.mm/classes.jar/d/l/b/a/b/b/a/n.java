package d.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.a.j;
import d.o;
import d.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public enum n
{
  private static final Set<n> Nud;
  private static final Set<n> Nue;
  private static final Map<e, n> Nuf;
  public static final a Nug;
  private static final HashMap<String, n> cEm;
  private final String description;
  private final boolean isDefault;
  
  static
  {
    AppMethodBeat.i(56979);
    Object localObject1 = new n("CLASS", 0, "class");
    Ntn = (n)localObject1;
    Object localObject2 = new n("ANNOTATION_CLASS", 1, "annotation class");
    Nto = (n)localObject2;
    n localn1 = new n("TYPE_PARAMETER", 2, "type parameter", false);
    Ntp = localn1;
    n localn2 = new n("PROPERTY", 3, "property");
    Ntq = localn2;
    n localn3 = new n("FIELD", 4, "field");
    Ntr = localn3;
    n localn4 = new n("LOCAL_VARIABLE", 5, "local variable");
    Nts = localn4;
    n localn5 = new n("VALUE_PARAMETER", 6, "value parameter");
    Ntt = localn5;
    n localn6 = new n("CONSTRUCTOR", 7, "constructor");
    Ntu = localn6;
    n localn7 = new n("FUNCTION", 8, "function");
    Ntv = localn7;
    n localn8 = new n("PROPERTY_GETTER", 9, "getter");
    Ntw = localn8;
    n localn9 = new n("PROPERTY_SETTER", 10, "setter");
    Ntx = localn9;
    n localn10 = new n("TYPE", 11, "type usage", false);
    Nty = localn10;
    n localn11 = new n("EXPRESSION", 12, "expression", false);
    Ntz = localn11;
    n localn12 = new n("FILE", 13, "file", false);
    NtA = localn12;
    n localn13 = new n("TYPEALIAS", 14, "typealias", false);
    NtB = localn13;
    n localn14 = new n("TYPE_PROJECTION", 15, "type projection", false);
    NtC = localn14;
    n localn15 = new n("STAR_PROJECTION", 16, "star projection", false);
    NtD = localn15;
    n localn16 = new n("PROPERTY_PARAMETER", 17, "property constructor parameter", false);
    NtE = localn16;
    n localn17 = new n("CLASS_ONLY", 18, "class", false);
    NtF = localn17;
    n localn18 = new n("OBJECT", 19, "object", false);
    NtG = localn18;
    n localn19 = new n("COMPANION_OBJECT", 20, "companion object", false);
    NtH = localn19;
    n localn20 = new n("INTERFACE", 21, "interface", false);
    NtI = localn20;
    n localn21 = new n("ENUM_CLASS", 22, "enum class", false);
    NtJ = localn21;
    n localn22 = new n("ENUM_ENTRY", 23, "enum entry", false);
    NtK = localn22;
    n localn23 = new n("LOCAL_CLASS", 24, "local class", false);
    NtL = localn23;
    n localn24 = new n("LOCAL_FUNCTION", 25, "local function", false);
    NtM = localn24;
    n localn25 = new n("MEMBER_FUNCTION", 26, "member function", false);
    NtN = localn25;
    n localn26 = new n("TOP_LEVEL_FUNCTION", 27, "top level function", false);
    NtO = localn26;
    n localn27 = new n("MEMBER_PROPERTY", 28, "member property", false);
    NtP = localn27;
    n localn28 = new n("MEMBER_PROPERTY_WITH_BACKING_FIELD", 29, "member property with backing field", false);
    NtQ = localn28;
    n localn29 = new n("MEMBER_PROPERTY_WITH_DELEGATE", 30, "member property with delegate", false);
    NtR = localn29;
    n localn30 = new n("MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 31, "member property without backing field or delegate", false);
    NtS = localn30;
    n localn31 = new n("TOP_LEVEL_PROPERTY", 32, "top level property", false);
    NtT = localn31;
    n localn32 = new n("TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD", 33, "top level property with backing field", false);
    NtU = localn32;
    n localn33 = new n("TOP_LEVEL_PROPERTY_WITH_DELEGATE", 34, "top level property with delegate", false);
    NtV = localn33;
    n localn34 = new n("TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 35, "top level property without backing field or delegate", false);
    NtW = localn34;
    n localn35 = new n("INITIALIZER", 36, "initializer", false);
    NtX = localn35;
    n localn36 = new n("DESTRUCTURING_DECLARATION", 37, "destructuring declaration", false);
    NtY = localn36;
    n localn37 = new n("LAMBDA_EXPRESSION", 38, "lambda expression", false);
    NtZ = localn37;
    n localn38 = new n("ANONYMOUS_FUNCTION", 39, "anonymous function", false);
    Nua = localn38;
    n localn39 = new n("OBJECT_LITERAL", 40, "object literal", false);
    Nub = localn39;
    Nuc = new n[] { localObject1, localObject2, localn1, localn2, localn3, localn4, localn5, localn6, localn7, localn8, localn9, localn10, localn11, localn12, localn13, localn14, localn15, localn16, localn17, localn18, localn19, localn20, localn21, localn22, localn23, localn24, localn25, localn26, localn27, localn28, localn29, localn30, localn31, localn32, localn33, localn34, localn35, localn36, localn37, localn38, localn39 };
    Nug = new a((byte)0);
    cEm = new HashMap();
    localObject1 = values();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject2 = localObject1[i];
      ((Map)cEm).put(((n)localObject2).name(), localObject2);
      i += 1;
    }
    localObject1 = values();
    localObject2 = (Collection)new ArrayList();
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      localn1 = localObject1[i];
      if (localn1.isDefault) {
        ((Collection)localObject2).add(localn1);
      }
      i += 1;
    }
    Nud = j.n((Iterable)localObject2);
    Nue = d.a.e.X(values());
    Nuf = ae.a(new o[] { u.R(e.NsJ, Ntt), u.R(e.NsD, Ntr), u.R(e.NsF, Ntq), u.R(e.NsE, NtA), u.R(e.NsG, Ntw), u.R(e.NsH, Ntx), u.R(e.NsI, Ntt), u.R(e.NsK, Ntt), u.R(e.NsL, Ntr) });
    AppMethodBeat.o(56979);
  }
  
  private n(String paramString, boolean paramBoolean)
  {
    this.description = paramString;
    this.isDefault = paramBoolean;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.a.n
 * JD-Core Version:    0.7.0.1
 */