package com.tencent.threadpool.coroutines.hook;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.g.b.ae;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.l.o;
import kotlinx.coroutines.bg;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"TAG", "", "field_java_lang_reflect_Field_modifiers", "Ljava/lang/reflect/Field;", "getField_java_lang_reflect_Field_modifiers", "()Ljava/lang/reflect/Field;", "field_java_lang_reflect_Field_modifiers$delegate", "Lkotlin/Lazy;", "field_kotlinx_coroutines_Dispatchers_Default", "getField_kotlinx_coroutines_Dispatchers_Default", "field_kotlinx_coroutines_Dispatchers_Default$delegate", "field_kotlinx_coroutines_Dispatchers_IO", "getField_kotlinx_coroutines_Dispatchers_IO", "field_kotlinx_coroutines_Dispatchers_IO$delegate", "stackTraceString", "", "getStackTraceString", "(Ljava/lang/Throwable;)Ljava/lang/String;", "unprotectFinal", "", "threadpool-coroutines_release"}, k=2, mv={1, 1, 16})
public final class a
{
  private static final j ahAP;
  private static final j ahAQ;
  private static final j ahAR;
  
  static
  {
    AppMethodBeat.i(226883);
    aYe = new o[] { (o)ai.a(new ae(ai.p(a.class, "threadpool-coroutines_release"), "field_java_lang_reflect_Field_modifiers", "getField_java_lang_reflect_Field_modifiers()Ljava/lang/reflect/Field;")), (o)ai.a(new ae(ai.p(a.class, "threadpool-coroutines_release"), "field_kotlinx_coroutines_Dispatchers_Default", "getField_kotlinx_coroutines_Dispatchers_Default()Ljava/lang/reflect/Field;")), (o)ai.a(new ae(ai.p(a.class, "threadpool-coroutines_release"), "field_kotlinx_coroutines_Dispatchers_IO", "getField_kotlinx_coroutines_Dispatchers_IO()Ljava/lang/reflect/Field;")) };
    ahAP = k.cm((kotlin.g.a.a)a.ahAS);
    ahAQ = k.cm((kotlin.g.a.a)b.ahAT);
    ahAR = k.cm((kotlin.g.a.a)c.ahAU);
    AppMethodBeat.o(226883);
  }
  
  private static final String getStackTraceString(Throwable paramThrowable)
  {
    AppMethodBeat.i(226890);
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter((Writer)localStringWriter);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    paramThrowable = localStringWriter.toString();
    s.r(paramThrowable, "sw.toString()");
    AppMethodBeat.o(226890);
    return paramThrowable;
  }
  
  private static final boolean h(Field paramField)
  {
    AppMethodBeat.i(226887);
    try
    {
      Field localField = (Field)ahAP.getValue();
      if (localField != null) {
        localField.set(paramField, Integer.valueOf(paramField.getModifiers() & 0xFFFFFFEF));
      }
      bool = true;
    }
    finally
    {
      for (;;)
      {
        new StringBuilder("Failed to unprotect final field:\n").append(getStackTraceString(paramField));
        boolean bool = false;
      }
    }
    AppMethodBeat.o(226887);
    return bool;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Ljava/lang/reflect/Field;", "invoke"}, k=3, mv={1, 1, 16})
  static final class a
    extends u
    implements kotlin.g.a.a<Field>
  {
    public static final a ahAS;
    
    static
    {
      AppMethodBeat.i(226886);
      ahAS = new a();
      AppMethodBeat.o(226886);
    }
    
    a()
    {
      super();
    }
    
    private static Field jZb()
    {
      AppMethodBeat.i(226881);
      try
      {
        Field localField = Field.class.getDeclaredField("modifiers");
        localField.setAccessible(true);
        AppMethodBeat.o(226881);
        return localField;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        for (;;)
        {
          new StringBuilder("Unable to get field Field.modifiers:\n").append(a.E((Throwable)localNoSuchFieldException));
          Object localObject = null;
        }
      }
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Ljava/lang/reflect/Field;", "invoke"}, k=3, mv={1, 1, 16})
  static final class b
    extends u
    implements kotlin.g.a.a<Field>
  {
    public static final b ahAT;
    
    static
    {
      AppMethodBeat.i(226882);
      ahAT = new b();
      AppMethodBeat.o(226882);
    }
    
    b()
    {
      super();
    }
    
    private static Field jZb()
    {
      AppMethodBeat.i(226877);
      try
      {
        Field localField = bg.class.getDeclaredField("ajvW");
        localField.setAccessible(true);
        a.i(localField);
        AppMethodBeat.o(226877);
        return localField;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        for (;;)
        {
          new StringBuilder("Unable to get field Dispatchers.Default:\n").append(a.E((Throwable)localNoSuchFieldException));
          Object localObject = null;
        }
      }
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Ljava/lang/reflect/Field;", "invoke"}, k=3, mv={1, 1, 16})
  static final class c
    extends u
    implements kotlin.g.a.a<Field>
  {
    public static final c ahAU;
    
    static
    {
      AppMethodBeat.i(226885);
      ahAU = new c();
      AppMethodBeat.o(226885);
    }
    
    c()
    {
      super();
    }
    
    private static Field jZb()
    {
      AppMethodBeat.i(226880);
      try
      {
        Field localField = bg.class.getDeclaredField("ajvY");
        localField.setAccessible(true);
        a.i(localField);
        AppMethodBeat.o(226880);
        return localField;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        for (;;)
        {
          new StringBuilder("Unable to get field Dispatchers.IO:\n").append(a.E((Throwable)localNoSuchFieldException));
          Object localObject = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.threadpool.coroutines.hook.a
 * JD-Core Version:    0.7.0.1
 */