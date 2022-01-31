package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ek
  implements ec, Cloneable
{
  public static final ek a;
  private double b;
  private int c;
  private boolean d;
  private boolean e;
  private List<dg> f;
  private List<dg> g;
  
  static
  {
    AppMethodBeat.i(147597);
    a = new ek();
    AppMethodBeat.o(147597);
  }
  
  public ek()
  {
    AppMethodBeat.i(147585);
    this.b = -1.0D;
    this.c = 136;
    this.d = true;
    this.f = Collections.emptyList();
    this.g = Collections.emptyList();
    AppMethodBeat.o(147585);
  }
  
  private boolean a(ef paramef)
  {
    AppMethodBeat.i(147594);
    if ((paramef != null) && (paramef.a() > this.b))
    {
      AppMethodBeat.o(147594);
      return false;
    }
    AppMethodBeat.o(147594);
    return true;
  }
  
  private boolean a(ef paramef, eg parameg)
  {
    AppMethodBeat.i(147593);
    if ((a(paramef)) && (a(parameg)))
    {
      AppMethodBeat.o(147593);
      return true;
    }
    AppMethodBeat.o(147593);
    return false;
  }
  
  private boolean a(eg parameg)
  {
    AppMethodBeat.i(147595);
    if ((parameg != null) && (parameg.a() <= this.b))
    {
      AppMethodBeat.o(147595);
      return false;
    }
    AppMethodBeat.o(147595);
    return true;
  }
  
  private boolean a(Class<?> paramClass)
  {
    AppMethodBeat.i(147590);
    if ((!Enum.class.isAssignableFrom(paramClass)) && ((paramClass.isAnonymousClass()) || (paramClass.isLocalClass())))
    {
      AppMethodBeat.o(147590);
      return true;
    }
    AppMethodBeat.o(147590);
    return false;
  }
  
  private boolean b(Class<?> paramClass)
  {
    AppMethodBeat.i(147591);
    if ((paramClass.isMemberClass()) && (!c(paramClass)))
    {
      AppMethodBeat.o(147591);
      return true;
    }
    AppMethodBeat.o(147591);
    return false;
  }
  
  private boolean c(Class<?> paramClass)
  {
    AppMethodBeat.i(147592);
    if ((paramClass.getModifiers() & 0x8) != 0)
    {
      AppMethodBeat.o(147592);
      return true;
    }
    AppMethodBeat.o(147592);
    return false;
  }
  
  public final <T> eb<T> a(dk paramdk, fe<T> paramfe)
  {
    AppMethodBeat.i(147587);
    Class localClass = paramfe.a();
    boolean bool1 = a(localClass, true);
    boolean bool2 = a(localClass, false);
    if ((!bool1) && (!bool2))
    {
      AppMethodBeat.o(147587);
      return null;
    }
    paramdk = new ek.1(this, bool2, bool1, paramdk, paramfe);
    AppMethodBeat.o(147587);
    return paramdk;
  }
  
  protected final ek a()
  {
    AppMethodBeat.i(147586);
    try
    {
      ek localek = (ek)super.clone();
      AppMethodBeat.o(147586);
      return localek;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      AssertionError localAssertionError = new AssertionError();
      AppMethodBeat.o(147586);
      throw localAssertionError;
    }
  }
  
  public final boolean a(Class<?> paramClass, boolean paramBoolean)
  {
    AppMethodBeat.i(147589);
    if ((this.b != -1.0D) && (!a((ef)paramClass.getAnnotation(ef.class), (eg)paramClass.getAnnotation(eg.class))))
    {
      AppMethodBeat.o(147589);
      return true;
    }
    if ((!this.d) && (b(paramClass)))
    {
      AppMethodBeat.o(147589);
      return true;
    }
    if (a(paramClass))
    {
      AppMethodBeat.o(147589);
      return true;
    }
    if (paramBoolean) {}
    for (Object localObject = this.f;; localObject = this.g)
    {
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((dg)((Iterator)localObject).next()).a(paramClass));
      AppMethodBeat.o(147589);
      return true;
    }
    AppMethodBeat.o(147589);
    return false;
  }
  
  public final boolean a(Field paramField, boolean paramBoolean)
  {
    AppMethodBeat.i(147588);
    if ((this.c & paramField.getModifiers()) != 0)
    {
      AppMethodBeat.o(147588);
      return true;
    }
    if ((this.b != -1.0D) && (!a((ef)paramField.getAnnotation(ef.class), (eg)paramField.getAnnotation(eg.class))))
    {
      AppMethodBeat.o(147588);
      return true;
    }
    if (paramField.isSynthetic())
    {
      AppMethodBeat.o(147588);
      return true;
    }
    if (this.e)
    {
      localObject = (ed)paramField.getAnnotation(ed.class);
      if (localObject != null)
      {
        if (!paramBoolean) {
          break label122;
        }
        if (((ed)localObject).a()) {
          break label131;
        }
      }
      label122:
      while (!((ed)localObject).b())
      {
        AppMethodBeat.o(147588);
        return true;
      }
    }
    label131:
    if ((!this.d) && (b(paramField.getType())))
    {
      AppMethodBeat.o(147588);
      return true;
    }
    if (a(paramField.getType()))
    {
      AppMethodBeat.o(147588);
      return true;
    }
    if (paramBoolean) {}
    for (Object localObject = this.f; !((List)localObject).isEmpty(); localObject = this.g)
    {
      paramField = new dh(paramField);
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((dg)((Iterator)localObject).next()).a(paramField));
      AppMethodBeat.o(147588);
      return true;
    }
    AppMethodBeat.o(147588);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ek
 * JD-Core Version:    0.7.0.1
 */