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
  public e MFe;
  private final io.flutter.plugin.a.k.c MFf;
  public final io.flutter.plugin.a.k vCn;
  
  public k(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10224);
    this.MFf = new io.flutter.plugin.a.k.c()
    {
      public final void a(j paramAnonymousj, io.flutter.plugin.a.k.d paramAnonymousd)
      {
        AppMethodBeat.i(10261);
        if (k.this.MFe == null)
        {
          AppMethodBeat.o(10261);
          return;
        }
        Object localObject1 = paramAnonymousj.method;
        paramAnonymousj = paramAnonymousj.grf;
        new StringBuilder("Received '").append((String)localObject1).append("' message.");
        a.gea();
        int i = -1;
        switch (((String)localObject1).hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            paramAnonymousd.djR();
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
        k.this.MFe.show();
        paramAnonymousd.de(null);
        AppMethodBeat.o(10261);
        return;
        k.this.MFe.hide();
        paramAnonymousd.de(null);
        AppMethodBeat.o(10261);
        return;
        try
        {
          paramAnonymousj = (JSONArray)paramAnonymousj;
          j = paramAnonymousj.getInt(0);
          localObject1 = paramAnonymousj.getJSONObject(1);
          locale = k.this.MFe;
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
          paramAnonymousd.f("error", paramAnonymousj.getMessage(), null);
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
            localc = k.c.bbW(((JSONObject)localObject1).getString("textCapitalization"));
            localObject2 = ((JSONObject)localObject1).getJSONObject("inputType");
            localObject2 = new k.b(k.f.bbX(((JSONObject)localObject2).getString("name")), ((JSONObject)localObject2).optBoolean("signed", false), ((JSONObject)localObject2).optBoolean("decimal", false));
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
              paramAnonymousd.de(null);
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
            k.this.MFe.ajc(i);
            AppMethodBeat.o(10261);
            return;
            try
            {
              paramAnonymousj = (JSONObject)paramAnonymousj;
              k.this.MFe.a(new k.d(paramAnonymousj.getString("text"), paramAnonymousj.getInt("selectionBase"), paramAnonymousj.getInt("selectionExtent")));
              paramAnonymousd.de(null);
              AppMethodBeat.o(10261);
              return;
            }
            catch (JSONException paramAnonymousj)
            {
              paramAnonymousd.f("error", paramAnonymousj.getMessage(), null);
              AppMethodBeat.o(10261);
              return;
            }
            k.this.MFe.gfh();
            paramAnonymousd.de(null);
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
    this.vCn = new io.flutter.plugin.a.k(paramDartExecutor, "flutter/textinput", g.MFU);
    this.vCn.a(this.MFf);
    AppMethodBeat.o(10224);
  }
  
  public static final class a
  {
    public final boolean MFh;
    public final boolean MFi;
    public final boolean MFj;
    public final k.c MFk;
    public final k.b MFl;
    public final Integer MFm;
    public final String MFn;
    
    public a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, k.c paramc, k.b paramb, Integer paramInteger, String paramString)
    {
      this.MFh = paramBoolean1;
      this.MFi = paramBoolean2;
      this.MFj = paramBoolean3;
      this.MFk = paramc;
      this.MFl = paramb;
      this.MFm = paramInteger;
      this.MFn = paramString;
    }
  }
  
  public static final class b
  {
    public final k.f MFo;
    public final boolean MFp;
    public final boolean MFq;
    
    public b(k.f paramf, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.MFo = paramf;
      this.MFp = paramBoolean1;
      this.MFq = paramBoolean2;
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
    
    public abstract void ajc(int paramInt);
    
    public abstract void gfh();
    
    public abstract void hide();
    
    public abstract void show();
  }
  
  public static enum f
  {
    private final String MEk;
    
    static
    {
      AppMethodBeat.i(10248);
      MFw = new f("TEXT", 0, "TextInputType.text");
      MFx = new f("DATETIME", 1, "TextInputType.datetime");
      MFy = new f("NUMBER", 2, "TextInputType.number");
      MFz = new f("PHONE", 3, "TextInputType.phone");
      MFA = new f("MULTILINE", 4, "TextInputType.multiline");
      MFB = new f("EMAIL_ADDRESS", 5, "TextInputType.emailAddress");
      MFC = new f("URL", 6, "TextInputType.url");
      MFD = new f("VISIBLE_PASSWORD", 7, "TextInputType.visiblePassword");
      MFE = new f[] { MFw, MFx, MFy, MFz, MFA, MFB, MFC, MFD };
      AppMethodBeat.o(10248);
    }
    
    private f(String paramString)
    {
      this.MEk = paramString;
    }
    
    static f bbX(String paramString)
    {
      AppMethodBeat.i(10247);
      f[] arrayOff = values();
      int j = arrayOff.length;
      int i = 0;
      while (i < j)
      {
        f localf = arrayOff[i];
        if (localf.MEk.equals(paramString))
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