package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/text/ScreenFloatValueRegEx;", "", "()V", "value", "Lkotlin/text/Regex;", "kotlin-stdlib"})
final class m
{
  public static final k TTj;
  public static final m TTk;
  
  static
  {
    AppMethodBeat.i(129375);
    TTk = new m();
    String str1 = "[eE][+-]?".concat(String.valueOf("(\\p{Digit}+)"));
    String str2 = "(0[xX]" + "(\\p{XDigit}+)" + "(\\.)?)|(0[xX]" + "(\\p{XDigit}+)" + "?(\\.)" + "(\\p{XDigit}+)" + ')';
    str1 = "(" + "(\\p{Digit}+)" + "(\\.)?(" + "(\\p{Digit}+)" + "?)(" + str1 + ")?)|(\\.(" + "(\\p{Digit}+)" + ")(" + str1 + ")?)|((" + str2 + ")[pP][+-]?" + "(\\p{Digit}+)" + ')';
    TTj = new k("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + str1 + ")[fFdD]?))[\\x00-\\x20]*");
    AppMethodBeat.o(129375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.n.m
 * JD-Core Version:    0.7.0.1
 */