package io.flutter.embedding.engine.plugins;

import android.content.Context;
import io.flutter.plugin.platform.e;

public abstract interface a
{
  public abstract void a(b paramb);
  
  public abstract void b(b paramb);
  
  public static abstract interface a
  {
    public abstract String bGe(String paramString);
    
    public abstract String pl(String paramString1, String paramString2);
  }
  
  public static final class b
  {
    public final io.flutter.embedding.engine.a BCx;
    public final io.flutter.plugin.a.c aaqF;
    public final io.flutter.view.c aarP;
    private final e aarQ;
    public final a.a aarR;
    public final Context applicationContext;
    
    public b(Context paramContext, io.flutter.embedding.engine.a parama, io.flutter.plugin.a.c paramc, io.flutter.view.c paramc1, e parame, a.a parama1)
    {
      this.applicationContext = paramContext;
      this.BCx = parama;
      this.aaqF = paramc;
      this.aarP = paramc1;
      this.aarQ = parame;
      this.aarR = parama1;
    }
    
    @Deprecated
    public final io.flutter.embedding.engine.a iAZ()
    {
      return this.BCx;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.a
 * JD-Core Version:    0.7.0.1
 */