package kotlin.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.a.ak;
import kotlin.a.k;
import kotlin.a.p;
import kotlin.r;
import kotlin.v;

public enum n
{
  private static final Set<n> aiIA;
  private static final Set<n> aiIB;
  private static final Map<e, n> aiIC;
  public static final n.a aiIz;
  private static final HashMap<String, n> map;
  private final String description;
  private final boolean oBZ;
  
  static
  {
    AppMethodBeat.i(56979);
    aiID = new n("CLASS", 0, "class");
    aiIE = new n("ANNOTATION_CLASS", 1, "annotation class");
    aiIF = new n("TYPE_PARAMETER", 2, "type parameter", false);
    aiIG = new n("PROPERTY", 3, "property");
    aiIH = new n("FIELD", 4, "field");
    aiII = new n("LOCAL_VARIABLE", 5, "local variable");
    aiIJ = new n("VALUE_PARAMETER", 6, "value parameter");
    aiIK = new n("CONSTRUCTOR", 7, "constructor");
    aiIL = new n("FUNCTION", 8, "function");
    aiIM = new n("PROPERTY_GETTER", 9, "getter");
    aiIN = new n("PROPERTY_SETTER", 10, "setter");
    aiIO = new n("TYPE", 11, "type usage", false);
    aiIP = new n("EXPRESSION", 12, "expression", false);
    aiIQ = new n("FILE", 13, "file", false);
    aiIR = new n("TYPEALIAS", 14, "typealias", false);
    aiIS = new n("TYPE_PROJECTION", 15, "type projection", false);
    aiIT = new n("STAR_PROJECTION", 16, "star projection", false);
    aiIU = new n("PROPERTY_PARAMETER", 17, "property constructor parameter", false);
    aiIV = new n("CLASS_ONLY", 18, "class", false);
    aiIW = new n("OBJECT", 19, "object", false);
    aiIX = new n("COMPANION_OBJECT", 20, "companion object", false);
    aiIY = new n("INTERFACE", 21, "interface", false);
    aiIZ = new n("ENUM_CLASS", 22, "enum class", false);
    aiJa = new n("ENUM_ENTRY", 23, "enum entry", false);
    aiJb = new n("LOCAL_CLASS", 24, "local class", false);
    aiJc = new n("LOCAL_FUNCTION", 25, "local function", false);
    aiJd = new n("MEMBER_FUNCTION", 26, "member function", false);
    aiJe = new n("TOP_LEVEL_FUNCTION", 27, "top level function", false);
    aiJf = new n("MEMBER_PROPERTY", 28, "member property", false);
    aiJg = new n("MEMBER_PROPERTY_WITH_BACKING_FIELD", 29, "member property with backing field", false);
    aiJh = new n("MEMBER_PROPERTY_WITH_DELEGATE", 30, "member property with delegate", false);
    aiJi = new n("MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 31, "member property without backing field or delegate", false);
    aiJj = new n("TOP_LEVEL_PROPERTY", 32, "top level property", false);
    aiJk = new n("TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD", 33, "top level property with backing field", false);
    aiJl = new n("TOP_LEVEL_PROPERTY_WITH_DELEGATE", 34, "top level property with delegate", false);
    aiJm = new n("TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 35, "top level property without backing field or delegate", false);
    aiJn = new n("INITIALIZER", 36, "initializer", false);
    aiJo = new n("DESTRUCTURING_DECLARATION", 37, "destructuring declaration", false);
    aiJp = new n("LAMBDA_EXPRESSION", 38, "lambda expression", false);
    aiJq = new n("ANONYMOUS_FUNCTION", 39, "anonymous function", false);
    aiJr = new n("OBJECT_LITERAL", 40, "object literal", false);
    aiJs = new n[] { aiID, aiIE, aiIF, aiIG, aiIH, aiII, aiIJ, aiIK, aiIL, aiIM, aiIN, aiIO, aiIP, aiIQ, aiIR, aiIS, aiIT, aiIU, aiIV, aiIW, aiIX, aiIY, aiIZ, aiJa, aiJb, aiJc, aiJd, aiJe, aiJf, aiJg, aiJh, aiJi, aiJj, aiJk, aiJl, aiJm, aiJn, aiJo, aiJp, aiJq, aiJr };
    aiIz = new n.a((byte)0);
    map = new HashMap();
    n[] arrayOfn = values();
    int j = arrayOfn.length;
    int i = 0;
    while (i < j)
    {
      localObject = arrayOfn[i];
      ((Map)map).put(((n)localObject).name(), localObject);
      i += 1;
    }
    arrayOfn = values();
    Object localObject = (Collection)new ArrayList();
    j = arrayOfn.length;
    i = 0;
    while (i < j)
    {
      n localn = arrayOfn[i];
      if (localn.oBZ) {
        ((Collection)localObject).add(localn);
      }
      i += 1;
    }
    aiIA = p.r((Iterable)localObject);
    aiIB = k.ag(values());
    aiIC = ak.e(new r[] { v.Y(e.aiHX, aiIJ), v.Y(e.aiHR, aiIH), v.Y(e.aiHT, aiIG), v.Y(e.aiHS, aiIQ), v.Y(e.aiHU, aiIM), v.Y(e.aiHV, aiIN), v.Y(e.aiHW, aiIJ), v.Y(e.aiHY, aiIJ), v.Y(e.aiHZ, aiIH) });
    AppMethodBeat.o(56979);
  }
  
  private n(String paramString, boolean paramBoolean)
  {
    this.description = paramString;
    this.oBZ = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.a.n
 * JD-Core Version:    0.7.0.1
 */