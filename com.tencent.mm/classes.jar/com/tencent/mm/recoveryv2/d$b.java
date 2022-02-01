package com.tencent.mm.recoveryv2;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public abstract class d$b
  implements d
{
  protected final List<a> MRS = new ArrayList();
  protected final StringBuilder acjX = new StringBuilder();
  final String mName;
  
  public d$b(String paramString)
  {
    this.mName = paramString;
  }
  
  protected final b btI(String paramString)
  {
    this.MRS.add(new c(paramString));
    return this;
  }
  
  protected final b btJ(String paramString)
  {
    this.MRS.add(new b(paramString));
    return this;
  }
  
  public final String getDescription()
  {
    return this.acjX.toString();
  }
  
  public static abstract class a
    implements d.a
  {
    public SharedPreferences.Editor eYx;
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
      if (this.eYx == null) {
        throw new IllegalStateException("Call #attach first!");
      }
      a(this.eYx);
    }
  }
  
  static final class b
    extends d.b.a
  {
    public b(String paramString)
    {
      super(Boolean.FALSE);
    }
    
    public final void a(SharedPreferences.Editor paramEditor)
    {
      AppMethodBeat.i(238043);
      paramEditor.putBoolean(this.key, ((Boolean)this.value).booleanValue());
      AppMethodBeat.o(238043);
    }
    
    public final String getDescription()
    {
      AppMethodBeat.i(238049);
      String str = "putBoolean(" + this.key + ", " + this.value + ")";
      AppMethodBeat.o(238049);
      return str;
    }
  }
  
  static final class c
    extends d.b.a
  {
    public c(String paramString)
    {
      super(Integer.valueOf(2147483647));
      AppMethodBeat.i(238041);
      AppMethodBeat.o(238041);
    }
    
    public final void a(SharedPreferences.Editor paramEditor)
    {
      AppMethodBeat.i(238048);
      paramEditor.putInt(this.key, ((Integer)this.value).intValue());
      AppMethodBeat.o(238048);
    }
    
    public final String getDescription()
    {
      AppMethodBeat.i(238054);
      String str = "putInt(" + this.key + ", " + this.value + ")";
      AppMethodBeat.o(238054);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.d.b
 * JD-Core Version:    0.7.0.1
 */