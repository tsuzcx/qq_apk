package com.tencent.mm.plugin.p;

import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.l;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livestorage/MMLiveDBAnno;", "", "entities", "", "Lkotlin/reflect/KClass;", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "()[Ljava/lang/Class;", "plugin-livestorage_release"})
public @interface f
{
  Class<? extends IAutoDBItem>[] eLU();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.p.f
 * JD-Core Version:    0.7.0.1
 */