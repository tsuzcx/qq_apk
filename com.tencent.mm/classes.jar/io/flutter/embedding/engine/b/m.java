package io.flutter.embedding.engine.b;

import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.b;
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
  public final k aKT;
  private final k.c aasq;
  public e aatN;
  
  public m(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10224);
    this.aasq = new k.c()
    {
      public final void a(j paramAnonymousj, k.d paramAnonymousd)
      {
        AppMethodBeat.i(10261);
        if (m.this.aatN == null)
        {
          AppMethodBeat.o(10261);
          return;
        }
        Object localObject = paramAnonymousj.method;
        paramAnonymousj = paramAnonymousj.ZZe;
        new StringBuilder("Received '").append((String)localObject).append("' message.");
        b.iAd();
        int i = -1;
        switch (((String)localObject).hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            paramAnonymousd.epZ();
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
                          if (((String)localObject).equals("TextInput.clearClient"))
                          {
                            i = 7;
                            continue;
                            if (((String)localObject).equals("TextInput.sendAppPrivateCommand"))
                            {
                              i = 8;
                              continue;
                              if (((String)localObject).equals("TextInput.finishAutofillContext")) {
                                i = 9;
                              }
                            }
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
        m.this.aatN.show();
        paramAnonymousd.bb(null);
        AppMethodBeat.o(10261);
        return;
        m.this.aatN.hide();
        paramAnonymousd.bb(null);
        AppMethodBeat.o(10261);
        return;
        try
        {
          paramAnonymousj = (JSONArray)paramAnonymousj;
          i = paramAnonymousj.getInt(0);
          paramAnonymousj = paramAnonymousj.getJSONObject(1);
          m.this.aatN.a(i, m.a.cw(paramAnonymousj));
          paramAnonymousd.bb(null);
          AppMethodBeat.o(10261);
          return;
        }
        catch (NoSuchFieldException paramAnonymousj)
        {
          paramAnonymousd.b("error", paramAnonymousj.getMessage(), null);
          AppMethodBeat.o(10261);
          return;
          m.this.aatN.iBm();
          paramAnonymousd.bb(null);
          AppMethodBeat.o(10261);
          return;
          i = ((Integer)paramAnonymousj).intValue();
          m.this.aatN.aDr(i);
          AppMethodBeat.o(10261);
          return;
          try
          {
            paramAnonymousj = (JSONObject)paramAnonymousj;
            m.this.aatN.a(m.d.cy(paramAnonymousj));
            paramAnonymousd.bb(null);
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
            m.this.aatN.a(d1, d2, (double[])localObject);
            AppMethodBeat.o(10261);
            return;
          }
          catch (JSONException paramAnonymousj)
          {
            paramAnonymousd.b("error", paramAnonymousj.getMessage(), null);
            AppMethodBeat.o(10261);
            return;
          }
          m.this.aatN.iBn();
          paramAnonymousd.bb(null);
          AppMethodBeat.o(10261);
          return;
          try
          {
            paramAnonymousj = (JSONObject)paramAnonymousj;
            localObject = paramAnonymousj.getString("action");
            String str = paramAnonymousj.getString("data");
            if ((str == null) || (str.isEmpty())) {
              break label895;
            }
            paramAnonymousj = new Bundle();
            paramAnonymousj.putString("data", str);
            m.this.aatN.x((String)localObject, paramAnonymousj);
            paramAnonymousd.bb(null);
            AppMethodBeat.o(10261);
            return;
          }
          catch (JSONException paramAnonymousj)
          {
            paramAnonymousd.b("error", paramAnonymousj.getMessage(), null);
            AppMethodBeat.o(10261);
            return;
          }
          m.this.aatN.Jd(((Boolean)paramAnonymousj).booleanValue());
          paramAnonymousd.bb(null);
          AppMethodBeat.o(10261);
          return;
        }
        catch (JSONException paramAnonymousj)
        {
          for (;;)
          {
            continue;
            label895:
            paramAnonymousj = null;
          }
        }
      }
    };
    this.aKT = new k(paramDartExecutor, "flutter/textinput", g.aauM);
    this.aKT.a(this.aasq);
    AppMethodBeat.o(10224);
  }
  
  public static HashMap<Object, Object> h(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(254346);
    HashMap localHashMap = new HashMap();
    localHashMap.put("text", paramString);
    localHashMap.put("selectionBase", Integer.valueOf(paramInt1));
    localHashMap.put("selectionExtent", Integer.valueOf(paramInt2));
    localHashMap.put("composingBase", Integer.valueOf(paramInt3));
    localHashMap.put("composingExtent", Integer.valueOf(paramInt4));
    AppMethodBeat.o(254346);
    return localHashMap;
  }
  
  public final void a(int paramInt, HashMap<String, d> paramHashMap)
  {
    AppMethodBeat.i(254348);
    new StringBuilder("Sending message to update editing state for ").append(String.valueOf(paramHashMap.size())).append(" field(s).");
    b.iAd();
    HashMap localHashMap = new HashMap();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      d locald = (d)localEntry.getValue();
      localHashMap.put(localEntry.getKey(), h(locald.text, locald.aauj, locald.aauk, -1, -1));
    }
    this.aKT.a("TextInputClient.updateEditingStateWithTag", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), localHashMap }), null);
    AppMethodBeat.o(254348);
  }
  
  public static final class a
  {
    public final boolean aatP;
    public final boolean aatQ;
    public final boolean aatR;
    public final m.c aatS;
    public final m.b aatT;
    public final Integer aatU;
    public final String aatV;
    public final a aatW;
    public final a[] aatX;
    
    private a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, m.c paramc, m.b paramb, Integer paramInteger, String paramString, a parama, a[] paramArrayOfa)
    {
      this.aatP = paramBoolean1;
      this.aatQ = paramBoolean2;
      this.aatR = paramBoolean3;
      this.aatS = paramc;
      this.aatT = paramb;
      this.aatU = paramInteger;
      this.aatV = paramString;
      this.aatW = parama;
      this.aatX = paramArrayOfa;
    }
    
    public static a cw(JSONObject paramJSONObject)
    {
      Object localObject4 = null;
      AppMethodBeat.i(253828);
      Object localObject3 = paramJSONObject.getString("inputAction");
      if (localObject3 == null)
      {
        paramJSONObject = new JSONException("Configuration JSON missing 'inputAction' property.");
        AppMethodBeat.o(253828);
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
          localObject1[i] = cw(((JSONArray)localObject5).getJSONObject(i));
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
          localObject5 = m.c.bGr(paramJSONObject.getString("textCapitalization"));
          localObject3 = paramJSONObject.getJSONObject("inputType");
          localb = new m.b(m.f.bGs(((JSONObject)localObject3).getString("name")), ((JSONObject)localObject3).optBoolean("signed", false), ((JSONObject)localObject3).optBoolean("decimal", false));
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
      for (paramJSONObject = localObject4;; paramJSONObject = a.cx(paramJSONObject.getJSONObject("autofill")))
      {
        paramJSONObject = new a(bool1, bool2, bool3, (m.c)localObject5, localb, (Integer)localObject1, (String)localObject3, paramJSONObject, localObject2);
        AppMethodBeat.o(253828);
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
      public final String aatY;
      public final String[] aatZ;
      public final m.d aaua;
      
      private a(String paramString, String[] paramArrayOfString, m.d paramd)
      {
        this.aatY = paramString;
        this.aatZ = paramArrayOfString;
        this.aaua = paramd;
      }
      
      public static a cx(JSONObject paramJSONObject)
      {
        AppMethodBeat.i(255098);
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
        paramJSONObject = new a(str2, arrayOfString, m.d.cy(localJSONObject));
        AppMethodBeat.o(255098);
        return paramJSONObject;
      }
    }
  }
  
  public static final class b
  {
    public final m.f aaub;
    public final boolean aauc;
    public final boolean aaud;
    
    public b(m.f paramf, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.aaub = paramf;
      this.aauc = paramBoolean1;
      this.aaud = paramBoolean2;
    }
  }
  
  public static enum c
  {
    private final String aasG;
    
    static
    {
      AppMethodBeat.i(10260);
      aaue = new c("CHARACTERS", 0, "TextCapitalization.characters");
      aauf = new c("WORDS", 1, "TextCapitalization.words");
      aaug = new c("SENTENCES", 2, "TextCapitalization.sentences");
      aauh = new c("NONE", 3, "TextCapitalization.none");
      aaui = new c[] { aaue, aauf, aaug, aauh };
      AppMethodBeat.o(10260);
    }
    
    private c(String paramString)
    {
      this.aasG = paramString;
    }
    
    static c bGr(String paramString)
    {
      AppMethodBeat.i(10259);
      c[] arrayOfc = values();
      int j = arrayOfc.length;
      int i = 0;
      while (i < j)
      {
        c localc = arrayOfc[i];
        if (localc.aasG.equals(paramString))
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
    public final int aauj;
    public final int aauk;
    public final int aaul;
    public final int aaum;
    public final String text;
    
    public d(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(255809);
      if (((paramInt1 != -1) || (paramInt2 != -1)) && ((paramInt1 < 0) || (paramInt2 < 0)))
      {
        paramString = new IndexOutOfBoundsException("invalid selection: (" + String.valueOf(paramInt1) + ", " + String.valueOf(paramInt2) + ")");
        AppMethodBeat.o(255809);
        throw paramString;
      }
      if (((paramInt3 != -1) || (paramInt4 != -1)) && ((paramInt3 < 0) || (paramInt3 >= paramInt4)))
      {
        paramString = new IndexOutOfBoundsException("invalid composing range: (" + String.valueOf(paramInt3) + ", " + String.valueOf(paramInt4) + ")");
        AppMethodBeat.o(255809);
        throw paramString;
      }
      if (paramInt4 > paramString.length())
      {
        paramString = new IndexOutOfBoundsException("invalid composing start: " + String.valueOf(paramInt3));
        AppMethodBeat.o(255809);
        throw paramString;
      }
      if (paramInt1 > paramString.length())
      {
        paramString = new IndexOutOfBoundsException("invalid selection start: " + String.valueOf(paramInt1));
        AppMethodBeat.o(255809);
        throw paramString;
      }
      if (paramInt2 > paramString.length())
      {
        paramString = new IndexOutOfBoundsException("invalid selection end: " + String.valueOf(paramInt2));
        AppMethodBeat.o(255809);
        throw paramString;
      }
      this.text = paramString;
      this.aauj = paramInt1;
      this.aauk = paramInt2;
      this.aaul = paramInt3;
      this.aaum = paramInt4;
      AppMethodBeat.o(255809);
    }
    
    public static d cy(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(255807);
      paramJSONObject = new d(paramJSONObject.getString("text"), paramJSONObject.getInt("selectionBase"), paramJSONObject.getInt("selectionExtent"), paramJSONObject.getInt("composingBase"), paramJSONObject.getInt("composingExtent"));
      AppMethodBeat.o(255807);
      return paramJSONObject;
    }
  }
  
  public static abstract interface e
  {
    public abstract void Jd(boolean paramBoolean);
    
    public abstract void a(double paramDouble1, double paramDouble2, double[] paramArrayOfDouble);
    
    public abstract void a(int paramInt, m.a parama);
    
    public abstract void a(m.d paramd);
    
    public abstract void aDr(int paramInt);
    
    public abstract void hide();
    
    public abstract void iBm();
    
    public abstract void iBn();
    
    public abstract void show();
    
    public abstract void x(String paramString, Bundle paramBundle);
  }
  
  public static enum f
  {
    private final String aasG;
    
    static
    {
      AppMethodBeat.i(10248);
      aaun = new f("TEXT", 0, "TextInputType.text");
      aauo = new f("DATETIME", 1, "TextInputType.datetime");
      aaup = new f("NAME", 2, "TextInputType.name");
      aauq = new f("POSTAL_ADDRESS", 3, "TextInputType.address");
      aaur = new f("NUMBER", 4, "TextInputType.number");
      aaus = new f("PHONE", 5, "TextInputType.phone");
      aaut = new f("MULTILINE", 6, "TextInputType.multiline");
      aauu = new f("EMAIL_ADDRESS", 7, "TextInputType.emailAddress");
      aauv = new f("URL", 8, "TextInputType.url");
      aauw = new f("VISIBLE_PASSWORD", 9, "TextInputType.visiblePassword");
      aaux = new f[] { aaun, aauo, aaup, aauq, aaur, aaus, aaut, aauu, aauv, aauw };
      AppMethodBeat.o(10248);
    }
    
    private f(String paramString)
    {
      this.aasG = paramString;
    }
    
    static f bGs(String paramString)
    {
      AppMethodBeat.i(10247);
      f[] arrayOff = values();
      int j = arrayOff.length;
      int i = 0;
      while (i < j)
      {
        f localf = arrayOff[i];
        if (localf.aasG.equals(paramString))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.b.m
 * JD-Core Version:    0.7.0.1
 */