package kotlin.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.o;
import kotlin.s;

public enum n
{
  private static final Set<n> aaMF;
  private static final Set<n> aaMG;
  private static final Map<e, n> aaMH;
  public static final a aaMI;
  private static final HashMap<String, n> map;
  private final String description;
  private final boolean lJx;
  
  static
  {
    AppMethodBeat.i(56979);
    Object localObject1 = new n("CLASS", 0, "class");
    aaLP = (n)localObject1;
    Object localObject2 = new n("ANNOTATION_CLASS", 1, "annotation class");
    aaLQ = (n)localObject2;
    n localn1 = new n("TYPE_PARAMETER", 2, "type parameter", false);
    aaLR = localn1;
    n localn2 = new n("PROPERTY", 3, "property");
    aaLS = localn2;
    n localn3 = new n("FIELD", 4, "field");
    aaLT = localn3;
    n localn4 = new n("LOCAL_VARIABLE", 5, "local variable");
    aaLU = localn4;
    n localn5 = new n("VALUE_PARAMETER", 6, "value parameter");
    aaLV = localn5;
    n localn6 = new n("CONSTRUCTOR", 7, "constructor");
    aaLW = localn6;
    n localn7 = new n("FUNCTION", 8, "function");
    aaLX = localn7;
    n localn8 = new n("PROPERTY_GETTER", 9, "getter");
    aaLY = localn8;
    n localn9 = new n("PROPERTY_SETTER", 10, "setter");
    aaLZ = localn9;
    n localn10 = new n("TYPE", 11, "type usage", false);
    aaMa = localn10;
    n localn11 = new n("EXPRESSION", 12, "expression", false);
    aaMb = localn11;
    n localn12 = new n("FILE", 13, "file", false);
    aaMc = localn12;
    n localn13 = new n("TYPEALIAS", 14, "typealias", false);
    aaMd = localn13;
    n localn14 = new n("TYPE_PROJECTION", 15, "type projection", false);
    aaMe = localn14;
    n localn15 = new n("STAR_PROJECTION", 16, "star projection", false);
    aaMf = localn15;
    n localn16 = new n("PROPERTY_PARAMETER", 17, "property constructor parameter", false);
    aaMg = localn16;
    n localn17 = new n("CLASS_ONLY", 18, "class", false);
    aaMh = localn17;
    n localn18 = new n("OBJECT", 19, "object", false);
    aaMi = localn18;
    n localn19 = new n("COMPANION_OBJECT", 20, "companion object", false);
    aaMj = localn19;
    n localn20 = new n("INTERFACE", 21, "interface", false);
    aaMk = localn20;
    n localn21 = new n("ENUM_CLASS", 22, "enum class", false);
    aaMl = localn21;
    n localn22 = new n("ENUM_ENTRY", 23, "enum entry", false);
    aaMm = localn22;
    n localn23 = new n("LOCAL_CLASS", 24, "local class", false);
    aaMn = localn23;
    n localn24 = new n("LOCAL_FUNCTION", 25, "local function", false);
    aaMo = localn24;
    n localn25 = new n("MEMBER_FUNCTION", 26, "member function", false);
    aaMp = localn25;
    n localn26 = new n("TOP_LEVEL_FUNCTION", 27, "top level function", false);
    aaMq = localn26;
    n localn27 = new n("MEMBER_PROPERTY", 28, "member property", false);
    aaMr = localn27;
    n localn28 = new n("MEMBER_PROPERTY_WITH_BACKING_FIELD", 29, "member property with backing field", false);
    aaMs = localn28;
    n localn29 = new n("MEMBER_PROPERTY_WITH_DELEGATE", 30, "member property with delegate", false);
    aaMt = localn29;
    n localn30 = new n("MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 31, "member property without backing field or delegate", false);
    aaMu = localn30;
    n localn31 = new n("TOP_LEVEL_PROPERTY", 32, "top level property", false);
    aaMv = localn31;
    n localn32 = new n("TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD", 33, "top level property with backing field", false);
    aaMw = localn32;
    n localn33 = new n("TOP_LEVEL_PROPERTY_WITH_DELEGATE", 34, "top level property with delegate", false);
    aaMx = localn33;
    n localn34 = new n("TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 35, "top level property without backing field or delegate", false);
    aaMy = localn34;
    n localn35 = new n("INITIALIZER", 36, "initializer", false);
    aaMz = localn35;
    n localn36 = new n("DESTRUCTURING_DECLARATION", 37, "destructuring declaration", false);
    aaMA = localn36;
    n localn37 = new n("LAMBDA_EXPRESSION", 38, "lambda expression", false);
    aaMB = localn37;
    n localn38 = new n("ANONYMOUS_FUNCTION", 39, "anonymous function", false);
    aaMC = localn38;
    n localn39 = new n("OBJECT_LITERAL", 40, "object literal", false);
    aaMD = localn39;
    aaME = new n[] { localObject1, localObject2, localn1, localn2, localn3, localn4, localn5, localn6, localn7, localn8, localn9, localn10, localn11, localn12, localn13, localn14, localn15, localn16, localn17, localn18, localn19, localn20, localn21, localn22, localn23, localn24, localn25, localn26, localn27, localn28, localn29, localn30, localn31, localn32, localn33, localn34, localn35, localn36, localn37, localn38, localn39 };
    aaMI = new a((byte)0);
    map = new HashMap();
    localObject1 = values();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject2 = localObject1[i];
      ((Map)map).put(((n)localObject2).name(), localObject2);
      i += 1;
    }
    localObject1 = values();
    localObject2 = (Collection)new ArrayList();
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      localn1 = localObject1[i];
      if (localn1.lJx) {
        ((Collection)localObject2).add(localn1);
      }
      i += 1;
    }
    aaMF = j.r((Iterable)localObject2);
    aaMG = kotlin.a.e.ac(values());
    aaMH = ae.e(new o[] { s.M(e.aaLl, aaLV), s.M(e.aaLf, aaLT), s.M(e.aaLh, aaLS), s.M(e.aaLg, aaMc), s.M(e.aaLi, aaLY), s.M(e.aaLj, aaLZ), s.M(e.aaLk, aaLV), s.M(e.aaLm, aaLV), s.M(e.aaLn, aaLT) });
    AppMethodBeat.o(56979);
  }
  
  private n(String paramString, boolean paramBoolean)
  {
    this.description = paramString;
    this.lJx = paramBoolean;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.a.n
 * JD-Core Version:    0.7.0.1
 */