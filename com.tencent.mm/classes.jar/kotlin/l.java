package kotlin;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/Metadata;", "", "kind", "", "metadataVersion", "", "bytecodeVersion", "data1", "", "", "data2", "extraString", "packageName", "extraInt", "bv", "()[I", "d1", "()[Ljava/lang/String;", "d2", "xi", "()I", "xs", "()Ljava/lang/String;", "k", "mv", "pn", "kotlin-stdlib"})
public @interface l
{
  int[] hxD() default {};
  
  String[] hxE() default {};
  
  String[] hxF() default {};
  
  int hxG() default 0;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.l
 * JD-Core Version:    0.7.0.1
 */