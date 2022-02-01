package com.tencent.mm.recoveryv2;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public abstract class e$b
  implements e
{
  protected final List<a> Bar = new ArrayList();
  protected final StringBuilder NBD = new StringBuilder();
  final String mName;
  
  public e$b(String paramString)
  {
    this.mName = paramString;
  }
  
  protected final b bhA(String paramString)
  {
    this.Bar.add(new b(paramString));
    return this;
  }
  
  protected final b bhz(String paramString)
  {
    this.Bar.add(new c(paramString));
    return this;
  }
  
  public final String getDescription()
  {
    return this.NBD.toString();
  }
  
  public static abstract class a
    implements e.a
  {
    public SharedPreferences.Editor NBE;
    String key;
    Object value;
    
    public a(String paramString, Object paramObject)
    {
      this.key = paramString;
      this.value = paramObject;
    }
    
    protected abstract void a(SharedPreferences.Editor paramEditor);
    
    public final void perform()
    {
      if (this.NBE == null) {
        throw new IllegalStateException("Call #attach first!");
      }
      a(this.NBE);
    }
  }
  
  static final class b
    extends e.b.a
  {
    public b(String paramString)
    {
      super(Boolean.FALSE);
    }
    
    public final void a(SharedPreferences.Editor paramEditor)
    {
      AppMethodBeat.i(193779);
      paramEditor.putBoolean(this.key, ((Boolean)this.value).booleanValue());
      AppMethodBeat.o(193779);
    }
    
    public final String getDescription()
    {
      AppMethodBeat.i(193780);
      String str = "putBoolean(" + this.key + ", " + this.value + ")";
      AppMethodBeat.o(193780);
      return str;
    }
  }
  
  static final class c
    extends e.b.a
  {
    public c(String paramString)
    {
      super(Integer.valueOf(2147483647));
      AppMethodBeat.i(193781);
      AppMethodBeat.o(193781);
    }
    
    public final void a(SharedPreferences.Editor paramEditor)
    {
      AppMethodBeat.i(193782);
      paramEditor.putInt(this.key, ((Integer)this.value).intValue());
      AppMethodBeat.o(193782);
    }
    
    public final String getDescription()
    {
      AppMethodBeat.i(193783);
      String str = "putInt(" + this.key + ", " + this.value + ")";
      AppMethodBeat.o(193783);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.e.b
 * JD-Core Version:    0.7.0.1
 */