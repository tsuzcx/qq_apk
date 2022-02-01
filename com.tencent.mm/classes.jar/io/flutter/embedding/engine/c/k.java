package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.g;
import io.flutter.plugin.a.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class k
{
  public e KOh;
  private final io.flutter.plugin.a.k.c KOi;
  public final io.flutter.plugin.a.k uzK;
  
  public k(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10224);
    this.KOi = new io.flutter.plugin.a.k.c()
    {
      public final void a(j paramAnonymousj, io.flutter.plugin.a.k.d paramAnonymousd)
      {
        AppMethodBeat.i(10261);
        if (k.this.KOh == null)
        {
          AppMethodBeat.o(10261);
          return;
        }
        Object localObject1 = paramAnonymousj.method;
        paramAnonymousj = paramAnonymousj.fXJ;
        new StringBuilder("Received '").append((String)localObject1).append("' message.");
        a.fMD();
        int i = -1;
        switch (((String)localObject1).hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            paramAnonymousd.daE();
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
        k.this.KOh.show();
        paramAnonymousd.db(null);
        AppMethodBeat.o(10261);
        return;
        k.this.KOh.hide();
        paramAnonymousd.db(null);
        AppMethodBeat.o(10261);
        return;
        try
        {
          paramAnonymousj = (JSONArray)paramAnonymousj;
          j = paramAnonymousj.getInt(0);
          localObject1 = paramAnonymousj.getJSONObject(1);
          locale = k.this.KOh;
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
          paramAnonymousd.e("error", paramAnonymousj.getMessage(), null);
          AppMethodBeat.o(10261);
          return;
          i = -1;
          boolean bool1;
          boolean bool2;
          boolean bool3;
          k.c localc;
          Object localObject2;
          switch (paramAnonymousj.hashCode())
          {
          case 1539450297: 
            paramAnonymousj = Integer.valueOf(0);
            bool1 = ((JSONObject)localObject1).optBoolean("obscureText");
            bool2 = ((JSONObject)localObject1).optBoolean("autocorrect", true);
            bool3 = ((JSONObject)localObject1).optBoolean("enableSuggestions");
            localc = k.c.aVT(((JSONObject)localObject1).getString("textCapitalization"));
            localObject2 = ((JSONObject)localObject1).getJSONObject("inputType");
            localObject2 = new k.b(k.f.aVU(((JSONObject)localObject2).getString("name")), ((JSONObject)localObject2).optBoolean("signed", false), ((JSONObject)localObject2).optBoolean("decimal", false));
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
              locale.a(j, new k.a(bool1, bool2, bool3, localc, (k.b)localObject2, paramAnonymousj, (String)localObject1));
              paramAnonymousd.db(null);
              AppMethodBeat.o(10261);
              return;
              if (!paramAnonymousj.equals("TextInputAction.newline")) {
                break label983;
              }
              i = 0;
              break label983;
              if (!paramAnonymousj.equals("TextInputAction.none")) {
                break label983;
              }
              i = 1;
              break label983;
              if (!paramAnonymousj.equals("TextInputAction.unspecified")) {
                break label983;
              }
              i = 2;
              break label983;
              if (!paramAnonymousj.equals("TextInputAction.done")) {
                break label983;
              }
              i = 3;
              break label983;
              if (!paramAnonymousj.equals("TextInputAction.go")) {
                break label983;
              }
              i = 4;
              break label983;
              if (!paramAnonymousj.equals("TextInputAction.search")) {
                break label983;
              }
              i = 5;
              break label983;
              if (!paramAnonymousj.equals("TextInputAction.send")) {
                break label983;
              }
              i = 6;
              break label983;
              if (!paramAnonymousj.equals("TextInputAction.next")) {
                break label983;
              }
              i = 7;
              break label983;
              if (!paramAnonymousj.equals("TextInputAction.previous")) {
                break label983;
              }
              i = 8;
              break label983;
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
            k.this.KOh.agB(i);
            AppMethodBeat.o(10261);
            return;
            try
            {
              paramAnonymousj = (JSONObject)paramAnonymousj;
              k.this.KOh.a(new k.d(paramAnonymousj.getString("text"), paramAnonymousj.getInt("selectionBase"), paramAnonymousj.getInt("selectionExtent")));
              paramAnonymousd.db(null);
              AppMethodBeat.o(10261);
              return;
            }
            catch (JSONException paramAnonymousj)
            {
              paramAnonymousd.e("error", paramAnonymousj.getMessage(), null);
              AppMethodBeat.o(10261);
              return;
            }
            k.this.KOh.fNI();
            paramAnonymousd.db(null);
            AppMethodBeat.o(10261);
            return;
          }
        }
        catch (NoSuchFieldException paramAnonymousj)
        {
          for (;;)
          {
            continue;
            label983:
            switch (i)
            {
            }
          }
        }
      }
    };
    this.uzK = new io.flutter.plugin.a.k(paramDartExecutor, "flutter/textinput", g.KOX);
    this.uzK.a(this.KOi);
    AppMethodBeat.o(10224);
  }
  
  public static final class a
  {
    public final boolean KOk;
    public final boolean KOl;
    public final boolean KOm;
    public final k.c KOn;
    public final k.b KOo;
    public final Integer KOp;
    public final String KOq;
    
    public a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, k.c paramc, k.b paramb, Integer paramInteger, String paramString)
    {
      this.KOk = paramBoolean1;
      this.KOl = paramBoolean2;
      this.KOm = paramBoolean3;
      this.KOn = paramc;
      this.KOo = paramb;
      this.KOp = paramInteger;
      this.KOq = paramString;
    }
  }
  
  public static final class b
  {
    public final k.f KOr;
    public final boolean KOs;
    public final boolean KOt;
    
    public b(k.f paramf, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.KOr = paramf;
      this.KOs = paramBoolean1;
      this.KOt = paramBoolean2;
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
    
    public abstract void agB(int paramInt);
    
    public abstract void fNI();
    
    public abstract void hide();
    
    public abstract void show();
  }
  
  public static enum f
  {
    private final String KNn;
    
    static
    {
      AppMethodBeat.i(10248);
      KOz = new f("TEXT", 0, "TextInputType.text");
      KOA = new f("DATETIME", 1, "TextInputType.datetime");
      KOB = new f("NUMBER", 2, "TextInputType.number");
      KOC = new f("PHONE", 3, "TextInputType.phone");
      KOD = new f("MULTILINE", 4, "TextInputType.multiline");
      KOE = new f("EMAIL_ADDRESS", 5, "TextInputType.emailAddress");
      KOF = new f("URL", 6, "TextInputType.url");
      KOG = new f("VISIBLE_PASSWORD", 7, "TextInputType.visiblePassword");
      KOH = new f[] { KOz, KOA, KOB, KOC, KOD, KOE, KOF, KOG };
      AppMethodBeat.o(10248);
    }
    
    private f(String paramString)
    {
      this.KNn = paramString;
    }
    
    static f aVU(String paramString)
    {
      AppMethodBeat.i(10247);
      f[] arrayOff = values();
      int j = arrayOff.length;
      int i = 0;
      while (i < j)
      {
        f localf = arrayOff[i];
        if (localf.KNn.equals(paramString))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.c.k
 * JD-Core Version:    0.7.0.1
 */