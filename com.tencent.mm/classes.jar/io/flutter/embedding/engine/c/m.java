package io.flutter.embedding.engine.c;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.g;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class m
{
  public e SRo;
  private final k.c SRp;
  public final k bbv;
  
  public m(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10224);
    this.SRp = new k.c()
    {
      public final void a(j paramAnonymousj, k.d paramAnonymousd)
      {
        AppMethodBeat.i(10261);
        if (m.this.SRo == null)
        {
          AppMethodBeat.o(10261);
          return;
        }
        Object localObject = paramAnonymousj.method;
        paramAnonymousj = paramAnonymousj.SxX;
        new StringBuilder("Received '").append((String)localObject).append("' message.");
        a.hwd();
        int i = -1;
        switch (((String)localObject).hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            paramAnonymousd.dLv();
            AppMethodBeat.o(10261);
            return;
            if (((String)localObject).equals("TextInput.show"))
            {
              i = 0;
              continue;
              if (((String)localObject).equals("TextInput.hide"))
              {
                i = 1;
                continue;
                if (((String)localObject).equals("TextInput.setClient"))
                {
                  i = 2;
                  continue;
                  if (((String)localObject).equals("TextInput.requestAutofill"))
                  {
                    i = 3;
                    continue;
                    if (((String)localObject).equals("TextInput.setPlatformViewClient"))
                    {
                      i = 4;
                      continue;
                      if (((String)localObject).equals("TextInput.setEditingState"))
                      {
                        i = 5;
                        continue;
                        if (((String)localObject).equals("TextInput.setEditableSizeAndTransform"))
                        {
                          i = 6;
                          continue;
                          if (((String)localObject).equals("TextInput.clearClient")) {
                            i = 7;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            break;
          }
        }
        m.this.SRo.show();
        paramAnonymousd.ba(null);
        AppMethodBeat.o(10261);
        return;
        m.this.SRo.hide();
        paramAnonymousd.ba(null);
        AppMethodBeat.o(10261);
        return;
        try
        {
          paramAnonymousj = (JSONArray)paramAnonymousj;
          i = paramAnonymousj.getInt(0);
          paramAnonymousj = paramAnonymousj.getJSONObject(1);
          m.this.SRo.a(i, m.a.cl(paramAnonymousj));
          paramAnonymousd.ba(null);
          AppMethodBeat.o(10261);
          return;
        }
        catch (NoSuchFieldException paramAnonymousj)
        {
          paramAnonymousd.b("error", paramAnonymousj.getMessage(), null);
          AppMethodBeat.o(10261);
          return;
          m.this.SRo.hxk();
          paramAnonymousd.ba(null);
          AppMethodBeat.o(10261);
          return;
          i = ((Integer)paramAnonymousj).intValue();
          m.this.SRo.atw(i);
          AppMethodBeat.o(10261);
          return;
          try
          {
            paramAnonymousj = (JSONObject)paramAnonymousj;
            m.this.SRo.a(m.d.cn(paramAnonymousj));
            paramAnonymousd.ba(null);
            AppMethodBeat.o(10261);
            return;
          }
          catch (JSONException paramAnonymousj)
          {
            paramAnonymousd.b("error", paramAnonymousj.getMessage(), null);
            AppMethodBeat.o(10261);
            return;
          }
          try
          {
            paramAnonymousj = (JSONObject)paramAnonymousj;
            double d1 = paramAnonymousj.getDouble("width");
            double d2 = paramAnonymousj.getDouble("height");
            paramAnonymousj = paramAnonymousj.getJSONArray("transform");
            localObject = new double[16];
            i = 0;
            while (i < 16)
            {
              localObject[i] = paramAnonymousj.getDouble(i);
              i += 1;
            }
            m.this.SRo.a(d1, d2, (double[])localObject);
            AppMethodBeat.o(10261);
            return;
          }
          catch (JSONException paramAnonymousj)
          {
            paramAnonymousd.b("error", paramAnonymousj.getMessage(), null);
            AppMethodBeat.o(10261);
            return;
          }
          m.this.SRo.hxl();
          paramAnonymousd.ba(null);
          AppMethodBeat.o(10261);
          return;
        }
        catch (JSONException paramAnonymousj)
        {
          label434:
          break label434;
        }
      }
    };
    this.bbv = new k(paramDartExecutor, "flutter/textinput", g.SSl);
    this.bbv.a(this.SRp);
    AppMethodBeat.o(10224);
  }
  
  public static HashMap<Object, Object> g(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(214991);
    HashMap localHashMap = new HashMap();
    localHashMap.put("text", paramString);
    localHashMap.put("selectionBase", Integer.valueOf(paramInt1));
    localHashMap.put("selectionExtent", Integer.valueOf(paramInt2));
    localHashMap.put("composingBase", Integer.valueOf(paramInt3));
    localHashMap.put("composingExtent", Integer.valueOf(paramInt4));
    AppMethodBeat.o(214991);
    return localHashMap;
  }
  
  public final void a(int paramInt, HashMap<String, d> paramHashMap)
  {
    AppMethodBeat.i(214992);
    new StringBuilder("Sending message to update editing state for ").append(String.valueOf(paramHashMap.size())).append(" field(s).");
    a.hwd();
    HashMap localHashMap = new HashMap();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      d locald = (d)localEntry.getValue();
      localHashMap.put(localEntry.getKey(), g(locald.text, locald.selectionStart, locald.selectionEnd, -1, -1));
    }
    this.bbv.a("TextInputClient.updateEditingStateWithTag", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), localHashMap }), null);
    AppMethodBeat.o(214992);
  }
  
  public static final class a
  {
    public final boolean SRr;
    public final boolean SRs;
    public final boolean SRt;
    public final m.c SRu;
    public final m.b SRv;
    public final Integer SRw;
    public final String SRx;
    public final a SRy;
    public final a[] SRz;
    
    private a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, m.c paramc, m.b paramb, Integer paramInteger, String paramString, a parama, a[] paramArrayOfa)
    {
      this.SRr = paramBoolean1;
      this.SRs = paramBoolean2;
      this.SRt = paramBoolean3;
      this.SRu = paramc;
      this.SRv = paramb;
      this.SRw = paramInteger;
      this.SRx = paramString;
      this.SRy = parama;
      this.SRz = paramArrayOfa;
    }
    
    public static a cl(JSONObject paramJSONObject)
    {
      Object localObject4 = null;
      AppMethodBeat.i(214984);
      Object localObject3 = paramJSONObject.getString("inputAction");
      if (localObject3 == null)
      {
        paramJSONObject = new JSONException("Configuration JSON missing 'inputAction' property.");
        AppMethodBeat.o(214984);
        throw paramJSONObject;
      }
      Object localObject5;
      Object localObject1;
      if (!paramJSONObject.isNull("fields"))
      {
        localObject5 = paramJSONObject.getJSONArray("fields");
        localObject1 = new a[((JSONArray)localObject5).length()];
        i = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (i >= localObject1.length) {
            break;
          }
          localObject1[i] = cl(((JSONArray)localObject5).getJSONObject(i));
          i += 1;
        }
      }
      Object localObject2 = null;
      int i = -1;
      label250:
      boolean bool1;
      boolean bool2;
      boolean bool3;
      m.b localb;
      switch (((String)localObject3).hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          localObject1 = Integer.valueOf(0);
          bool1 = paramJSONObject.optBoolean("obscureText");
          bool2 = paramJSONObject.optBoolean("autocorrect", true);
          bool3 = paramJSONObject.optBoolean("enableSuggestions");
          localObject5 = m.c.bto(paramJSONObject.getString("textCapitalization"));
          localObject3 = paramJSONObject.getJSONObject("inputType");
          localb = new m.b(m.f.btp(((JSONObject)localObject3).getString("name")), ((JSONObject)localObject3).optBoolean("signed", false), ((JSONObject)localObject3).optBoolean("decimal", false));
          if (paramJSONObject.isNull("actionLabel"))
          {
            localObject3 = null;
            label339:
            if (!paramJSONObject.isNull("autofill")) {
              break label613;
            }
          }
          break;
        }
        break;
      }
      label613:
      for (paramJSONObject = localObject4;; paramJSONObject = a.cm(paramJSONObject.getJSONObject("autofill")))
      {
        paramJSONObject = new a(bool1, bool2, bool3, (m.c)localObject5, localb, (Integer)localObject1, (String)localObject3, paramJSONObject, localObject2);
        AppMethodBeat.o(214984);
        return paramJSONObject;
        if (!((String)localObject3).equals("TextInputAction.newline")) {
          break;
        }
        i = 0;
        break;
        if (!((String)localObject3).equals("TextInputAction.none")) {
          break;
        }
        i = 1;
        break;
        if (!((String)localObject3).equals("TextInputAction.unspecified")) {
          break;
        }
        i = 2;
        break;
        if (!((String)localObject3).equals("TextInputAction.done")) {
          break;
        }
        i = 3;
        break;
        if (!((String)localObject3).equals("TextInputAction.go")) {
          break;
        }
        i = 4;
        break;
        if (!((String)localObject3).equals("TextInputAction.search")) {
          break;
        }
        i = 5;
        break;
        if (!((String)localObject3).equals("TextInputAction.send")) {
          break;
        }
        i = 6;
        break;
        if (!((String)localObject3).equals("TextInputAction.next")) {
          break;
        }
        i = 7;
        break;
        if (!((String)localObject3).equals("TextInputAction.previous")) {
          break;
        }
        i = 8;
        break;
        localObject1 = Integer.valueOf(1);
        break label250;
        localObject1 = Integer.valueOf(1);
        break label250;
        localObject1 = Integer.valueOf(0);
        break label250;
        localObject1 = Integer.valueOf(6);
        break label250;
        localObject1 = Integer.valueOf(2);
        break label250;
        localObject1 = Integer.valueOf(3);
        break label250;
        localObject1 = Integer.valueOf(4);
        break label250;
        localObject1 = Integer.valueOf(5);
        break label250;
        localObject1 = Integer.valueOf(7);
        break label250;
        localObject3 = paramJSONObject.getString("actionLabel");
        break label339;
      }
    }
    
    public static final class a
    {
      public final String SRA;
      public final String[] SRB;
      public final m.d SRC;
      
      private a(String paramString, String[] paramArrayOfString, m.d paramd)
      {
        this.SRA = paramString;
        this.SRB = paramArrayOfString;
        this.SRC = paramd;
      }
      
      public static a cm(JSONObject paramJSONObject)
      {
        AppMethodBeat.i(214990);
        String str2 = paramJSONObject.getString("uniqueIdentifier");
        JSONArray localJSONArray = paramJSONObject.getJSONArray("hints");
        JSONObject localJSONObject = paramJSONObject.getJSONObject("editingValue");
        String[] arrayOfString = new String[localJSONArray.length()];
        int j = 0;
        if (j < arrayOfString.length)
        {
          String str1 = localJSONArray.getString(j);
          paramJSONObject = str1;
          int i;
          if (Build.VERSION.SDK_INT >= 26)
          {
            i = -1;
            switch (str1.hashCode())
            {
            default: 
              switch (i)
              {
              default: 
                label368:
                paramJSONObject = str1;
              }
              break;
            }
          }
          for (;;)
          {
            arrayOfString[j] = paramJSONObject;
            j += 1;
            break;
            if (!str1.equals("addressCity")) {
              break label368;
            }
            i = 0;
            break label368;
            if (!str1.equals("addressState")) {
              break label368;
            }
            i = 1;
            break label368;
            if (!str1.equals("birthday")) {
              break label368;
            }
            i = 2;
            break label368;
            if (!str1.equals("birthdayDay")) {
              break label368;
            }
            i = 3;
            break label368;
            if (!str1.equals("birthdayMonth")) {
              break label368;
            }
            i = 4;
            break label368;
            if (!str1.equals("birthdayYear")) {
              break label368;
            }
            i = 5;
            break label368;
            if (!str1.equals("countryName")) {
              break label368;
            }
            i = 6;
            break label368;
            if (!str1.equals("creditCardExpirationDate")) {
              break label368;
            }
            i = 7;
            break label368;
            if (!str1.equals("creditCardExpirationDay")) {
              break label368;
            }
            i = 8;
            break label368;
            if (!str1.equals("creditCardExpirationMonth")) {
              break label368;
            }
            i = 9;
            break label368;
            if (!str1.equals("creditCardExpirationYear")) {
              break label368;
            }
            i = 10;
            break label368;
            if (!str1.equals("creditCardNumber")) {
              break label368;
            }
            i = 11;
            break label368;
            if (!str1.equals("creditCardSecurityCode")) {
              break label368;
            }
            i = 12;
            break label368;
            if (!str1.equals("email")) {
              break label368;
            }
            i = 13;
            break label368;
            if (!str1.equals("familyName")) {
              break label368;
            }
            i = 14;
            break label368;
            if (!str1.equals("fullStreetAddress")) {
              break label368;
            }
            i = 15;
            break label368;
            if (!str1.equals("gender")) {
              break label368;
            }
            i = 16;
            break label368;
            if (!str1.equals("givenName")) {
              break label368;
            }
            i = 17;
            break label368;
            if (!str1.equals("middleInitial")) {
              break label368;
            }
            i = 18;
            break label368;
            if (!str1.equals("middleName")) {
              break label368;
            }
            i = 19;
            break label368;
            if (!str1.equals("name")) {
              break label368;
            }
            i = 20;
            break label368;
            if (!str1.equals("namePrefix")) {
              break label368;
            }
            i = 21;
            break label368;
            if (!str1.equals("nameSuffix")) {
              break label368;
            }
            i = 22;
            break label368;
            if (!str1.equals("newPassword")) {
              break label368;
            }
            i = 23;
            break label368;
            if (!str1.equals("newUsername")) {
              break label368;
            }
            i = 24;
            break label368;
            if (!str1.equals("oneTimeCode")) {
              break label368;
            }
            i = 25;
            break label368;
            if (!str1.equals("password")) {
              break label368;
            }
            i = 26;
            break label368;
            if (!str1.equals("postalAddress")) {
              break label368;
            }
            i = 27;
            break label368;
            if (!str1.equals("postalAddressExtended")) {
              break label368;
            }
            i = 28;
            break label368;
            if (!str1.equals("postalAddressExtendedPostalCode")) {
              break label368;
            }
            i = 29;
            break label368;
            if (!str1.equals("postalCode")) {
              break label368;
            }
            i = 30;
            break label368;
            if (!str1.equals("telephoneNumber")) {
              break label368;
            }
            i = 31;
            break label368;
            if (!str1.equals("telephoneNumberCountryCode")) {
              break label368;
            }
            i = 32;
            break label368;
            if (!str1.equals("telephoneNumberDevice")) {
              break label368;
            }
            i = 33;
            break label368;
            if (!str1.equals("telephoneNumberNational")) {
              break label368;
            }
            i = 34;
            break label368;
            if (!str1.equals("username")) {
              break label368;
            }
            i = 35;
            break label368;
            paramJSONObject = "addressLocality";
            continue;
            paramJSONObject = "addressRegion";
            continue;
            paramJSONObject = "birthDateFull";
            continue;
            paramJSONObject = "birthDateDay";
            continue;
            paramJSONObject = "birthDateMonth";
            continue;
            paramJSONObject = "birthDateYear";
            continue;
            paramJSONObject = "addressCountry";
            continue;
            paramJSONObject = "creditCardExpirationDate";
            continue;
            paramJSONObject = "creditCardExpirationDay";
            continue;
            paramJSONObject = "creditCardExpirationMonth";
            continue;
            paramJSONObject = "creditCardExpirationYear";
            continue;
            paramJSONObject = "creditCardNumber";
            continue;
            paramJSONObject = "creditCardSecurityCode";
            continue;
            paramJSONObject = "emailAddress";
            continue;
            paramJSONObject = "personFamilyName";
            continue;
            paramJSONObject = "streetAddress";
            continue;
            paramJSONObject = "gender";
            continue;
            paramJSONObject = "personGivenName";
            continue;
            paramJSONObject = "personMiddleInitial";
            continue;
            paramJSONObject = "personMiddleName";
            continue;
            paramJSONObject = "personName";
            continue;
            paramJSONObject = "personNamePrefix";
            continue;
            paramJSONObject = "personNameSuffix";
            continue;
            paramJSONObject = "newPassword";
            continue;
            paramJSONObject = "newUsername";
            continue;
            paramJSONObject = "smsOTPCode";
            continue;
            paramJSONObject = "password";
            continue;
            paramJSONObject = "postalAddress";
            continue;
            paramJSONObject = "extendedAddress";
            continue;
            paramJSONObject = "extendedPostalCode";
            continue;
            paramJSONObject = "postalCode";
            continue;
            paramJSONObject = "phoneNumber";
            continue;
            paramJSONObject = "phoneCountryCode";
            continue;
            paramJSONObject = "phoneNumberDevice";
            continue;
            paramJSONObject = "phoneNational";
            continue;
            paramJSONObject = "username";
          }
        }
        paramJSONObject = new a(str2, arrayOfString, m.d.cn(localJSONObject));
        AppMethodBeat.o(214990);
        return paramJSONObject;
      }
    }
  }
  
  public static final class b
  {
    public final m.f SRD;
    public final boolean SRE;
    public final boolean SRF;
    
    public b(m.f paramf, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.SRD = paramf;
      this.SRE = paramBoolean1;
      this.SRF = paramBoolean2;
    }
  }
  
  public static enum c
  {
    private final String SQl;
    
    static
    {
      AppMethodBeat.i(10260);
      SRG = new c("CHARACTERS", 0, "TextCapitalization.characters");
      SRH = new c("WORDS", 1, "TextCapitalization.words");
      SRI = new c("SENTENCES", 2, "TextCapitalization.sentences");
      SRJ = new c("NONE", 3, "TextCapitalization.none");
      SRK = new c[] { SRG, SRH, SRI, SRJ };
      AppMethodBeat.o(10260);
    }
    
    private c(String paramString)
    {
      this.SQl = paramString;
    }
    
    static c bto(String paramString)
    {
      AppMethodBeat.i(10259);
      c[] arrayOfc = values();
      int j = arrayOfc.length;
      int i = 0;
      while (i < j)
      {
        c localc = arrayOfc[i];
        if (localc.SQl.equals(paramString))
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
    
    public static d cn(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(214986);
      paramJSONObject = new d(paramJSONObject.getString("text"), paramJSONObject.getInt("selectionBase"), paramJSONObject.getInt("selectionExtent"));
      AppMethodBeat.o(214986);
      return paramJSONObject;
    }
  }
  
  public static abstract interface e
  {
    public abstract void a(double paramDouble1, double paramDouble2, double[] paramArrayOfDouble);
    
    public abstract void a(int paramInt, m.a parama);
    
    public abstract void a(m.d paramd);
    
    public abstract void atw(int paramInt);
    
    public abstract void hide();
    
    public abstract void hxk();
    
    public abstract void hxl();
    
    public abstract void show();
  }
  
  public static enum f
  {
    private final String SQl;
    
    static
    {
      AppMethodBeat.i(10248);
      SRL = new f("TEXT", 0, "TextInputType.text");
      SRM = new f("DATETIME", 1, "TextInputType.datetime");
      SRN = new f("NAME", 2, "TextInputType.name");
      SRO = new f("POSTAL_ADDRESS", 3, "TextInputType.address");
      SRP = new f("NUMBER", 4, "TextInputType.number");
      SRQ = new f("PHONE", 5, "TextInputType.phone");
      SRR = new f("MULTILINE", 6, "TextInputType.multiline");
      SRS = new f("EMAIL_ADDRESS", 7, "TextInputType.emailAddress");
      SRT = new f("URL", 8, "TextInputType.url");
      SRU = new f("VISIBLE_PASSWORD", 9, "TextInputType.visiblePassword");
      SRV = new f[] { SRL, SRM, SRN, SRO, SRP, SRQ, SRR, SRS, SRT, SRU };
      AppMethodBeat.o(10248);
    }
    
    private f(String paramString)
    {
      this.SQl = paramString;
    }
    
    static f btp(String paramString)
    {
      AppMethodBeat.i(10247);
      f[] arrayOff = values();
      int j = arrayOff.length;
      int i = 0;
      while (i < j)
      {
        f localf = arrayOff[i];
        if (localf.SQl.equals(paramString))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     io.flutter.embedding.engine.c.m
 * JD-Core Version:    0.7.0.1
 */