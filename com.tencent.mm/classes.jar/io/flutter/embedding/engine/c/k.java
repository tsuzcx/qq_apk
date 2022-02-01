package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.a.a.g;
import io.flutter.a.a.j;
import io.flutter.embedding.engine.dart.DartExecutor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class k
{
  public e JaE;
  private final io.flutter.a.a.k.c JaF;
  public final io.flutter.a.a.k sNT;
  
  public k(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10224);
    this.JaF = new io.flutter.a.a.k.c()
    {
      public final void a(j paramAnonymousj, io.flutter.a.a.k.d paramAnonymousd)
      {
        AppMethodBeat.i(10261);
        if (k.this.JaE == null)
        {
          AppMethodBeat.o(10261);
          return;
        }
        Object localObject1 = paramAnonymousj.method;
        paramAnonymousj = paramAnonymousj.fTP;
        new StringBuilder("Received '").append((String)localObject1).append("' message.");
        a.ftS();
        int i = -1;
        switch (((String)localObject1).hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            paramAnonymousd.Av();
            AppMethodBeat.o(10261);
            return;
            if (((String)localObject1).equals("TextInput.show"))
            {
              i = 0;
              continue;
              if (((String)localObject1).equals("TextInput.hide"))
              {
                i = 1;
                continue;
                if (((String)localObject1).equals("TextInput.setClient"))
                {
                  i = 2;
                  continue;
                  if (((String)localObject1).equals("TextInput.setPlatformViewClient"))
                  {
                    i = 3;
                    continue;
                    if (((String)localObject1).equals("TextInput.setEditingState"))
                    {
                      i = 4;
                      continue;
                      if (((String)localObject1).equals("TextInput.clearClient")) {
                        i = 5;
                      }
                    }
                  }
                }
              }
            }
            break;
          }
        }
        k.this.JaE.show();
        paramAnonymousd.ay(null);
        AppMethodBeat.o(10261);
        return;
        k.this.JaE.hide();
        paramAnonymousd.ay(null);
        AppMethodBeat.o(10261);
        return;
        try
        {
          paramAnonymousj = (JSONArray)paramAnonymousj;
          j = paramAnonymousj.getInt(0);
          localObject1 = paramAnonymousj.getJSONObject(1);
          locale = k.this.JaE;
          paramAnonymousj = ((JSONObject)localObject1).getString("inputAction");
          if (paramAnonymousj == null)
          {
            paramAnonymousj = new JSONException("Configuration JSON missing 'inputAction' property.");
            AppMethodBeat.o(10261);
            throw paramAnonymousj;
          }
        }
        catch (JSONException paramAnonymousj)
        {
          int j;
          k.e locale;
          paramAnonymousd.a("error", paramAnonymousj.getMessage(), null);
          AppMethodBeat.o(10261);
          return;
          i = -1;
          boolean bool1;
          boolean bool2;
          k.c localc;
          Object localObject2;
          switch (paramAnonymousj.hashCode())
          {
          case 1539450297: 
            paramAnonymousj = Integer.valueOf(0);
            bool1 = ((JSONObject)localObject1).optBoolean("obscureText");
            bool2 = ((JSONObject)localObject1).optBoolean("autocorrect", true);
            localc = k.c.aPV(((JSONObject)localObject1).getString("textCapitalization"));
            localObject2 = ((JSONObject)localObject1).getJSONObject("inputType");
            localObject2 = new k.b(k.f.aPW(((JSONObject)localObject2).getString("name")), ((JSONObject)localObject2).optBoolean("signed", false), ((JSONObject)localObject2).optBoolean("decimal", false));
            if (!((JSONObject)localObject1).isNull("actionLabel")) {
              break;
            }
          case -737080013: 
          case -810971940: 
          case -737377923: 
          case 1241689507: 
          case 469250275: 
          case -736940669: 
          case -737089298: 
          case 2110497650: 
            for (localObject1 = null;; localObject1 = ((JSONObject)localObject1).getString("actionLabel"))
            {
              locale.a(j, new k.a(bool1, bool2, localc, (k.b)localObject2, paramAnonymousj, (String)localObject1));
              paramAnonymousd.ay(null);
              AppMethodBeat.o(10261);
              return;
              if (!paramAnonymousj.equals("TextInputAction.newline")) {
                break label972;
              }
              i = 0;
              break label972;
              if (!paramAnonymousj.equals("TextInputAction.none")) {
                break label972;
              }
              i = 1;
              break label972;
              if (!paramAnonymousj.equals("TextInputAction.unspecified")) {
                break label972;
              }
              i = 2;
              break label972;
              if (!paramAnonymousj.equals("TextInputAction.done")) {
                break label972;
              }
              i = 3;
              break label972;
              if (!paramAnonymousj.equals("TextInputAction.go")) {
                break label972;
              }
              i = 4;
              break label972;
              if (!paramAnonymousj.equals("TextInputAction.search")) {
                break label972;
              }
              i = 5;
              break label972;
              if (!paramAnonymousj.equals("TextInputAction.send")) {
                break label972;
              }
              i = 6;
              break label972;
              if (!paramAnonymousj.equals("TextInputAction.next")) {
                break label972;
              }
              i = 7;
              break label972;
              if (!paramAnonymousj.equals("TextInputAction.previous")) {
                break label972;
              }
              i = 8;
              break label972;
              paramAnonymousj = Integer.valueOf(1);
              break;
              paramAnonymousj = Integer.valueOf(1);
              break;
              paramAnonymousj = Integer.valueOf(0);
              break;
              paramAnonymousj = Integer.valueOf(6);
              break;
              paramAnonymousj = Integer.valueOf(2);
              break;
              paramAnonymousj = Integer.valueOf(3);
              break;
              paramAnonymousj = Integer.valueOf(4);
              break;
              paramAnonymousj = Integer.valueOf(5);
              break;
              paramAnonymousj = Integer.valueOf(7);
              break;
            }
            i = ((Integer)paramAnonymousj).intValue();
            k.this.JaE.adG(i);
            AppMethodBeat.o(10261);
            return;
            try
            {
              paramAnonymousj = (JSONObject)paramAnonymousj;
              k.this.JaE.a(new k.d(paramAnonymousj.getString("text"), paramAnonymousj.getInt("selectionBase"), paramAnonymousj.getInt("selectionExtent")));
              paramAnonymousd.ay(null);
              AppMethodBeat.o(10261);
              return;
            }
            catch (JSONException paramAnonymousj)
            {
              paramAnonymousd.a("error", paramAnonymousj.getMessage(), null);
              AppMethodBeat.o(10261);
              return;
            }
            k.this.JaE.fvc();
            paramAnonymousd.ay(null);
            AppMethodBeat.o(10261);
            return;
          }
        }
        catch (NoSuchFieldException paramAnonymousj)
        {
          for (;;)
          {
            continue;
            label972:
            switch (i)
            {
            }
          }
        }
      }
    };
    this.sNT = new io.flutter.a.a.k(paramDartExecutor, "flutter/textinput", g.Jbt);
    this.sNT.a(this.JaF);
    AppMethodBeat.o(10224);
  }
  
  public static final class a
  {
    public final boolean JaH;
    public final boolean JaI;
    public final k.c JaJ;
    public final k.b JaK;
    public final Integer JaL;
    public final String JaM;
    
    public a(boolean paramBoolean1, boolean paramBoolean2, k.c paramc, k.b paramb, Integer paramInteger, String paramString)
    {
      this.JaH = paramBoolean1;
      this.JaI = paramBoolean2;
      this.JaJ = paramc;
      this.JaK = paramb;
      this.JaL = paramInteger;
      this.JaM = paramString;
    }
  }
  
  public static final class b
  {
    public final k.f JaN;
    public final boolean JaO;
    public final boolean JaP;
    
    public b(k.f paramf, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.JaN = paramf;
      this.JaO = paramBoolean1;
      this.JaP = paramBoolean2;
    }
  }
  
  public static enum c
  {
    private final String IZK;
    
    static
    {
      AppMethodBeat.i(10260);
      JaQ = new c("CHARACTERS", 0, "TextCapitalization.characters");
      JaR = new c("WORDS", 1, "TextCapitalization.words");
      JaS = new c("SENTENCES", 2, "TextCapitalization.sentences");
      JaT = new c("NONE", 3, "TextCapitalization.none");
      JaU = new c[] { JaQ, JaR, JaS, JaT };
      AppMethodBeat.o(10260);
    }
    
    private c(String paramString)
    {
      this.IZK = paramString;
    }
    
    static c aPV(String paramString)
    {
      AppMethodBeat.i(10259);
      c[] arrayOfc = values();
      int j = arrayOfc.length;
      int i = 0;
      while (i < j)
      {
        c localc = arrayOfc[i];
        if (localc.IZK.equals(paramString))
        {
          AppMethodBeat.o(10259);
          return localc;
        }
        i += 1;
      }
      paramString = new NoSuchFieldException("No such TextCapitalization: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(10259);
      throw paramString;
    }
  }
  
  public static final class d
  {
    public final int selectionEnd;
    public final int selectionStart;
    public final String text;
    
    public d(String paramString, int paramInt1, int paramInt2)
    {
      this.text = paramString;
      this.selectionStart = paramInt1;
      this.selectionEnd = paramInt2;
    }
  }
  
  public static abstract interface e
  {
    public abstract void a(int paramInt, k.a parama);
    
    public abstract void a(k.d paramd);
    
    public abstract void adG(int paramInt);
    
    public abstract void fvc();
    
    public abstract void hide();
    
    public abstract void show();
  }
  
  public static enum f
  {
    private final String IZK;
    
    static
    {
      AppMethodBeat.i(10248);
      JaV = new f("TEXT", 0, "TextInputType.text");
      JaW = new f("DATETIME", 1, "TextInputType.datetime");
      JaX = new f("NUMBER", 2, "TextInputType.number");
      JaY = new f("PHONE", 3, "TextInputType.phone");
      JaZ = new f("MULTILINE", 4, "TextInputType.multiline");
      Jba = new f("EMAIL_ADDRESS", 5, "TextInputType.emailAddress");
      Jbb = new f("URL", 6, "TextInputType.url");
      Jbc = new f("VISIBLE_PASSWORD", 7, "TextInputType.visiblePassword");
      Jbd = new f[] { JaV, JaW, JaX, JaY, JaZ, Jba, Jbb, Jbc };
      AppMethodBeat.o(10248);
    }
    
    private f(String paramString)
    {
      this.IZK = paramString;
    }
    
    static f aPW(String paramString)
    {
      AppMethodBeat.i(10247);
      f[] arrayOff = values();
      int j = arrayOff.length;
      int i = 0;
      while (i < j)
      {
        f localf = arrayOff[i];
        if (localf.IZK.equals(paramString))
        {
          AppMethodBeat.o(10247);
          return localf;
        }
        i += 1;
      }
      paramString = new NoSuchFieldException("No such TextInputType: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(10247);
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.c.k
 * JD-Core Version:    0.7.0.1
 */