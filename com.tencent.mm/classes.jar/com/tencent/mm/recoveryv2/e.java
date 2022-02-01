package com.tencent.mm.recoveryv2;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public abstract interface e
{
  public abstract void fkI();
  
  public abstract void fkJ();
  
  public abstract String getDescription();
  
  public static abstract class b
    implements e
  {
    protected final StringBuilder Iof = new StringBuilder();
    final String mName;
    protected final List<a> xcP = new ArrayList();
    
    public b(String paramString)
    {
      this.mName = paramString;
    }
    
    protected final b aQW(String paramString)
    {
      this.xcP.add(new c(paramString));
      return this;
    }
    
    protected final b aQX(String paramString)
    {
      this.xcP.add(new b(paramString));
      return this;
    }
    
    public final String getDescription()
    {
      return this.Iof.toString();
    }
    
    public static abstract class a
      implements e.a
    {
      public SharedPreferences.Editor Iog;
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
        if (this.Iog == null) {
          throw new IllegalStateException("Call #attach first!");
        }
        a(this.Iog);
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
        AppMethodBeat.i(195291);
        paramEditor.putBoolean(this.key, ((Boolean)this.value).booleanValue());
        AppMethodBeat.o(195291);
      }
      
      public final String getDescription()
      {
        AppMethodBeat.i(195292);
        String str = "putBoolean(" + this.key + ", " + this.value + ")";
        AppMethodBeat.o(195292);
        return str;
      }
    }
    
    static final class c
      extends e.b.a
    {
      public c(String paramString)
      {
        super(Integer.valueOf(2147483647));
        AppMethodBeat.i(195293);
        AppMethodBeat.o(195293);
      }
      
      public final void a(SharedPreferences.Editor paramEditor)
      {
        AppMethodBeat.i(195294);
        paramEditor.putInt(this.key, ((Integer)this.value).intValue());
        AppMethodBeat.o(195294);
      }
      
      public final String getDescription()
      {
        AppMethodBeat.i(195295);
        String str = "putInt(" + this.key + ", " + this.value + ")";
        AppMethodBeat.o(195295);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.e
 * JD-Core Version:    0.7.0.1
 */