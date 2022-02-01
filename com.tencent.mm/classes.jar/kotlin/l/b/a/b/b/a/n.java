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
  private static final Set<n> TjL;
  private static final Set<n> TjM;
  private static final Map<e, n> TjN;
  public static final a TjO;
  private static final HashMap<String, n> map;
  private final String description;
  private final boolean isDefault;
  
  static
  {
    AppMethodBeat.i(56979);
    Object localObject1 = new n("CLASS", 0, "class");
    TiV = (n)localObject1;
    Object localObject2 = new n("ANNOTATION_CLASS", 1, "annotation class");
    TiW = (n)localObject2;
    n localn1 = new n("TYPE_PARAMETER", 2, "type parameter", false);
    TiX = localn1;
    n localn2 = new n("PROPERTY", 3, "property");
    TiY = localn2;
    n localn3 = new n("FIELD", 4, "field");
    TiZ = localn3;
    n localn4 = new n("LOCAL_VARIABLE", 5, "local variable");
    Tja = localn4;
    n localn5 = new n("VALUE_PARAMETER", 6, "value parameter");
    Tjb = localn5;
    n localn6 = new n("CONSTRUCTOR", 7, "constructor");
    Tjc = localn6;
    n localn7 = new n("FUNCTION", 8, "function");
    Tjd = localn7;
    n localn8 = new n("PROPERTY_GETTER", 9, "getter");
    Tje = localn8;
    n localn9 = new n("PROPERTY_SETTER", 10, "setter");
    Tjf = localn9;
    n localn10 = new n("TYPE", 11, "type usage", false);
    Tjg = localn10;
    n localn11 = new n("EXPRESSION", 12, "expression", false);
    Tjh = localn11;
    n localn12 = new n("FILE", 13, "file", false);
    Tji = localn12;
    n localn13 = new n("TYPEALIAS", 14, "typealias", false);
    Tjj = localn13;
    n localn14 = new n("TYPE_PROJECTION", 15, "type projection", false);
    Tjk = localn14;
    n localn15 = new n("STAR_PROJECTION", 16, "star projection", false);
    Tjl = localn15;
    n localn16 = new n("PROPERTY_PARAMETER", 17, "property constructor parameter", false);
    Tjm = localn16;
    n localn17 = new n("CLASS_ONLY", 18, "class", false);
    Tjn = localn17;
    n localn18 = new n("OBJECT", 19, "object", false);
    Tjo = localn18;
    n localn19 = new n("COMPANION_OBJECT", 20, "companion object", false);
    Tjp = localn19;
    n localn20 = new n("INTERFACE", 21, "interface", false);
    Tjq = localn20;
    n localn21 = new n("ENUM_CLASS", 22, "enum class", false);
    Tjr = localn21;
    n localn22 = new n("ENUM_ENTRY", 23, "enum entry", false);
    Tjs = localn22;
    n localn23 = new n("LOCAL_CLASS", 24, "local class", false);
    Tjt = localn23;
    n localn24 = new n("LOCAL_FUNCTION", 25, "local function", false);
    Tju = localn24;
    n localn25 = new n("MEMBER_FUNCTION", 26, "member function", false);
    Tjv = localn25;
    n localn26 = new n("TOP_LEVEL_FUNCTION", 27, "top level function", false);
    Tjw = localn26;
    n localn27 = new n("MEMBER_PROPERTY", 28, "member property", false);
    Tjx = localn27;
    n localn28 = new n("MEMBER_PROPERTY_WITH_BACKING_FIELD", 29, "member property with backing field", false);
    Tjy = localn28;
    n localn29 = new n("MEMBER_PROPERTY_WITH_DELEGATE", 30, "member property with delegate", false);
    Tjz = localn29;
    n localn30 = new n("MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 31, "member property without backing field or delegate", false);
    TjA = localn30;
    n localn31 = new n("TOP_LEVEL_PROPERTY", 32, "top level property", false);
    TjB = localn31;
    n localn32 = new n("TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD", 33, "top level property with backing field", false);
    TjC = localn32;
    n localn33 = new n("TOP_LEVEL_PROPERTY_WITH_DELEGATE", 34, "top level property with delegate", false);
    TjD = localn33;
    n localn34 = new n("TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 35, "top level property without backing field or delegate", false);
    TjE = localn34;
    n localn35 = new n("INITIALIZER", 36, "initializer", false);
    TjF = localn35;
    n localn36 = new n("DESTRUCTURING_DECLARATION", 37, "destructuring declaration", false);
    TjG = localn36;
    n localn37 = new n("LAMBDA_EXPRESSION", 38, "lambda expression", false);
    TjH = localn37;
    n localn38 = new n("ANONYMOUS_FUNCTION", 39, "anonymous function", false);
    TjI = localn38;
    n localn39 = new n("OBJECT_LITERAL", 40, "object literal", false);
    TjJ = localn39;
    TjK = new n[] { localObject1, localObject2, localn1, localn2, localn3, localn4, localn5, localn6, localn7, localn8, localn9, localn10, localn11, localn12, localn13, localn14, localn15, localn16, localn17, localn18, localn19, localn20, localn21, localn22, localn23, localn24, localn25, localn26, localn27, localn28, localn29, localn30, localn31, localn32, localn33, localn34, localn35, localn36, localn37, localn38, localn39 };
    TjO = new a((byte)0);
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
      if (localn1.isDefault) {
        ((Collection)localObject2).add(localn1);
      }
      i += 1;
    }
    TjL = j.r((Iterable)localObject2);
    TjM = kotlin.a.e.Y(values());
    TjN = ae.e(new o[] { s.U(e.Tir, Tjb), s.U(e.Til, TiZ), s.U(e.Tin, TiY), s.U(e.Tim, Tji), s.U(e.Tio, Tje), s.U(e.Tip, Tjf), s.U(e.Tiq, Tjb), s.U(e.Tis, Tjb), s.U(e.Tit, TiZ) });
    AppMethodBeat.o(56979);
  }
  
  private n(String paramString, boolean paramBoolean)
  {
    this.description = paramString;
    this.isDefault = paramBoolean;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.a.n
 * JD-Core Version:    0.7.0.1
 */