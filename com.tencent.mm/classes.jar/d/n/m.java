package d.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/text/ScreenFloatValueRegEx;", "", "()V", "value", "Lkotlin/text/Regex;", "kotlin-stdlib"})
final class m
{
  public static final k Oep;
  public static final m Oeq;
  
  static
  {
    AppMethodBeat.i(129375);
    Oeq = new m();
    String str1 = "[eE][+-]?".concat(String.valueOf("(\\p{Digit}+)"));
    String str2 = "(0[xX]" + "(\\p{XDigit}+)" + "(\\.)?)|(0[xX]" + "(\\p{XDigit}+)" + "?(\\.)" + "(\\p{XDigit}+)" + ')';
    str1 = "(" + "(\\p{Digit}+)" + "(\\.)?(" + "(\\p{Digit}+)" + "?)(" + str1 + ")?)|(\\.(" + "(\\p{Digit}+)" + ")(" + str1 + ")?)|((" + str2 + ")[pP][+-]?" + "(\\p{Digit}+)" + ')';
    Oep = new k("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + str1 + ")[fFdD]?))[\\x00-\\x20]*");
    AppMethodBeat.o(129375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.n.m
 * JD-Core Version:    0.7.0.1
 */