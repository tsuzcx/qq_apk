package com.tencent.mm.recoveryv2;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public abstract class e$b
  implements e
{
  protected final StringBuilder HTX = new StringBuilder();
  final String mName;
  protected final List<a> wNb = new ArrayList();
  
  public e$b(String paramString)
  {
    this.mName = paramString;
  }
  
  protected final b aPA(String paramString)
  {
    this.wNb.add(new b(paramString));
    return this;
  }
  
  protected final b aPz(String paramString)
  {
    this.wNb.add(new c(paramString));
    return this;
  }
  
  public final String getDescription()
  {
    return this.HTX.toString();
  }
  
  public static abstract class a
    implements e.a
  {
    public SharedPreferences.Editor HTY;
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
      if (this.HTY == null) {
        throw new IllegalStateException("Call #attach first!");
      }
      a(this.HTY);
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
      AppMethodBeat.i(206983);
      paramEditor.putBoolean(this.key, ((Boolean)this.value).booleanValue());
      AppMethodBeat.o(206983);
    }
    
    public final String getDescription()
    {
      AppMethodBeat.i(206984);
      String str = "putBoolean(" + this.key + ", " + this.value + ")";
      AppMethodBeat.o(206984);
      return str;
    }
  }
  
  static final class c
    extends e.b.a
  {
    public c(String paramString)
    {
      super(Integer.valueOf(2147483647));
      AppMethodBeat.i(206985);
      AppMethodBeat.o(206985);
    }
    
    public final void a(SharedPreferences.Editor paramEditor)
    {
      AppMethodBeat.i(206986);
      paramEditor.putInt(this.key, ((Integer)this.value).intValue());
      AppMethodBeat.o(206986);
    }
    
    public final String getDescription()
    {
      AppMethodBeat.i(206987);
      String str = "putInt(" + this.key + ", " + this.value + ")";
      AppMethodBeat.o(206987);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.e.b
 * JD-Core Version:    0.7.0.1
 */