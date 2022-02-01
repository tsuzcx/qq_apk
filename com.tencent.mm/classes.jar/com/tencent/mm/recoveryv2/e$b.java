package com.tencent.mm.recoveryv2;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public abstract class e$b
  implements e
{
  protected final List<a> GUp = new ArrayList();
  protected final StringBuilder UPg = new StringBuilder();
  final String mName;
  
  public e$b(String paramString)
  {
    this.mName = paramString;
  }
  
  protected final b btR(String paramString)
  {
    this.GUp.add(new c(paramString));
    return this;
  }
  
  protected final b btS(String paramString)
  {
    this.GUp.add(new b(paramString));
    return this;
  }
  
  public final String getDescription()
  {
    return this.UPg.toString();
  }
  
  public static abstract class a
    implements e.a
  {
    SharedPreferences.Editor cZX;
    String key;
    Object value;
    
    public a(String paramString, Object paramObject)
    {
      this.key = paramString;
      this.value = paramObject;
    }
    
    public final a a(SharedPreferences.Editor paramEditor)
    {
      this.cZX = paramEditor;
      return this;
    }
    
    protected abstract void b(SharedPreferences.Editor paramEditor);
    
    public final void perform()
    {
      if (this.cZX == null) {
        throw new IllegalStateException("Call #attach first!");
      }
      b(this.cZX);
    }
  }
  
  static final class b
    extends e.b.a
  {
    public b(String paramString)
    {
      super(Boolean.FALSE);
    }
    
    public final void b(SharedPreferences.Editor paramEditor)
    {
      AppMethodBeat.i(189989);
      paramEditor.putBoolean(this.key, ((Boolean)this.value).booleanValue());
      AppMethodBeat.o(189989);
    }
    
    public final String getDescription()
    {
      AppMethodBeat.i(189993);
      String str = "putBoolean(" + this.key + ", " + this.value + ")";
      AppMethodBeat.o(189993);
      return str;
    }
  }
  
  static final class c
    extends e.b.a
  {
    public c(String paramString)
    {
      super(Integer.valueOf(2147483647));
      AppMethodBeat.i(189999);
      AppMethodBeat.o(189999);
    }
    
    public final void b(SharedPreferences.Editor paramEditor)
    {
      AppMethodBeat.i(190002);
      paramEditor.putInt(this.key, ((Integer)this.value).intValue());
      AppMethodBeat.o(190002);
    }
    
    public final String getDescription()
    {
      AppMethodBeat.i(190006);
      String str = "putInt(" + this.key + ", " + this.value + ")";
      AppMethodBeat.o(190006);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.e.b
 * JD-Core Version:    0.7.0.1
 */