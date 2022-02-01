package io.flutter.embedding.engine.systemchannels;

import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TextInputChannel
{
  private static final String TAG = "TextInputChannel";
  public final MethodChannel channel;
  private final MethodChannel.MethodCallHandler parsingMethodHandler;
  private TextInputMethodHandler textInputMethodHandler;
  
  public TextInputChannel(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10224);
    this.parsingMethodHandler = new MethodChannel.MethodCallHandler()
    {
      public void onMethodCall(MethodCall paramAnonymousMethodCall, MethodChannel.Result paramAnonymousResult)
      {
        AppMethodBeat.i(10261);
        if (TextInputChannel.this.textInputMethodHandler == null)
        {
          AppMethodBeat.o(10261);
          return;
        }
        Object localObject = paramAnonymousMethodCall.method;
        paramAnonymousMethodCall = paramAnonymousMethodCall.arguments;
        Log.v("TextInputChannel", "Received '" + (String)localObject + "' message.");
        int i = -1;
        switch (((String)localObject).hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            paramAnonymousResult.notImplemented();
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
        TextInputChannel.this.textInputMethodHandler.show();
        paramAnonymousResult.success(null);
        AppMethodBeat.o(10261);
        return;
        TextInputChannel.this.textInputMethodHandler.hide();
        paramAnonymousResult.success(null);
        AppMethodBeat.o(10261);
        return;
        try
        {
          paramAnonymousMethodCall = (JSONArray)paramAnonymousMethodCall;
          i = paramAnonymousMethodCall.getInt(0);
          paramAnonymousMethodCall = paramAnonymousMethodCall.getJSONObject(1);
          TextInputChannel.this.textInputMethodHandler.setClient(i, TextInputChannel.Configuration.fromJson(paramAnonymousMethodCall));
          paramAnonymousResult.success(null);
          AppMethodBeat.o(10261);
          return;
        }
        catch (NoSuchFieldException paramAnonymousMethodCall)
        {
          paramAnonymousResult.error("error", paramAnonymousMethodCall.getMessage(), null);
          AppMethodBeat.o(10261);
          return;
          TextInputChannel.this.textInputMethodHandler.requestAutofill();
          paramAnonymousResult.success(null);
          AppMethodBeat.o(10261);
          return;
          i = ((Integer)paramAnonymousMethodCall).intValue();
          TextInputChannel.this.textInputMethodHandler.setPlatformViewClient(i);
          AppMethodBeat.o(10261);
          return;
          try
          {
            paramAnonymousMethodCall = (JSONObject)paramAnonymousMethodCall;
            TextInputChannel.this.textInputMethodHandler.setEditingState(TextInputChannel.TextEditState.fromJson(paramAnonymousMethodCall));
            paramAnonymousResult.success(null);
            AppMethodBeat.o(10261);
            return;
          }
          catch (JSONException paramAnonymousMethodCall)
          {
            paramAnonymousResult.error("error", paramAnonymousMethodCall.getMessage(), null);
            AppMethodBeat.o(10261);
            return;
          }
          try
          {
            paramAnonymousMethodCall = (JSONObject)paramAnonymousMethodCall;
            double d1 = paramAnonymousMethodCall.getDouble("width");
            double d2 = paramAnonymousMethodCall.getDouble("height");
            paramAnonymousMethodCall = paramAnonymousMethodCall.getJSONArray("transform");
            localObject = new double[16];
            i = 0;
            while (i < 16)
            {
              localObject[i] = paramAnonymousMethodCall.getDouble(i);
              i += 1;
            }
            TextInputChannel.this.textInputMethodHandler.setEditableSizeAndTransform(d1, d2, (double[])localObject);
            AppMethodBeat.o(10261);
            return;
          }
          catch (JSONException paramAnonymousMethodCall)
          {
            paramAnonymousResult.error("error", paramAnonymousMethodCall.getMessage(), null);
            AppMethodBeat.o(10261);
            return;
          }
          TextInputChannel.this.textInputMethodHandler.clearClient();
          paramAnonymousResult.success(null);
          AppMethodBeat.o(10261);
          return;
          try
          {
            paramAnonymousMethodCall = (JSONObject)paramAnonymousMethodCall;
            localObject = paramAnonymousMethodCall.getString("action");
            String str = paramAnonymousMethodCall.getString("data");
            if ((str == null) || (str.isEmpty())) {
              break label899;
            }
            paramAnonymousMethodCall = new Bundle();
            paramAnonymousMethodCall.putString("data", str);
            TextInputChannel.this.textInputMethodHandler.sendAppPrivateCommand((String)localObject, paramAnonymousMethodCall);
            paramAnonymousResult.success(null);
            AppMethodBeat.o(10261);
            return;
          }
          catch (JSONException paramAnonymousMethodCall)
          {
            paramAnonymousResult.error("error", paramAnonymousMethodCall.getMessage(), null);
            AppMethodBeat.o(10261);
            return;
          }
          TextInputChannel.this.textInputMethodHandler.finishAutofillContext(((Boolean)paramAnonymousMethodCall).booleanValue());
          paramAnonymousResult.success(null);
          AppMethodBeat.o(10261);
          return;
        }
        catch (JSONException paramAnonymousMethodCall)
        {
          for (;;)
          {
            continue;
            label899:
            paramAnonymousMethodCall = null;
          }
        }
      }
    };
    this.channel = new MethodChannel(paramDartExecutor, "flutter/textinput", JSONMethodCodec.INSTANCE);
    this.channel.setMethodCallHandler(this.parsingMethodHandler);
    AppMethodBeat.o(10224);
  }
  
  private static HashMap<Object, Object> createEditingStateJSON(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(190211);
    HashMap localHashMap = new HashMap();
    localHashMap.put("text", paramString);
    localHashMap.put("selectionBase", Integer.valueOf(paramInt1));
    localHashMap.put("selectionExtent", Integer.valueOf(paramInt2));
    localHashMap.put("composingBase", Integer.valueOf(paramInt3));
    localHashMap.put("composingExtent", Integer.valueOf(paramInt4));
    AppMethodBeat.o(190211);
    return localHashMap;
  }
  
  public void done(int paramInt)
  {
    AppMethodBeat.i(190268);
    Log.v("TextInputChannel", "Sending 'done' message.");
    this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.done" }));
    AppMethodBeat.o(190268);
  }
  
  public void go(int paramInt)
  {
    AppMethodBeat.i(190249);
    Log.v("TextInputChannel", "Sending 'go' message.");
    this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.go" }));
    AppMethodBeat.o(190249);
  }
  
  public void newline(int paramInt)
  {
    AppMethodBeat.i(190242);
    Log.v("TextInputChannel", "Sending 'newline' message.");
    this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.newline" }));
    AppMethodBeat.o(190242);
  }
  
  public void next(int paramInt)
  {
    AppMethodBeat.i(190276);
    Log.v("TextInputChannel", "Sending 'next' message.");
    this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.next" }));
    AppMethodBeat.o(190276);
  }
  
  public void performPrivateCommand(int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(190294);
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", paramString);
    if (paramBundle != null)
    {
      paramString = new HashMap();
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = paramBundle.get(str);
        if ((localObject instanceof byte[])) {
          paramString.put(str, paramBundle.getByteArray(str));
        } else if ((localObject instanceof Byte)) {
          paramString.put(str, Byte.valueOf(paramBundle.getByte(str)));
        } else if ((localObject instanceof char[])) {
          paramString.put(str, paramBundle.getCharArray(str));
        } else if ((localObject instanceof Character)) {
          paramString.put(str, Character.valueOf(paramBundle.getChar(str)));
        } else if ((localObject instanceof CharSequence[])) {
          paramString.put(str, paramBundle.getCharSequenceArray(str));
        } else if ((localObject instanceof CharSequence)) {
          paramString.put(str, paramBundle.getCharSequence(str));
        } else if ((localObject instanceof float[])) {
          paramString.put(str, paramBundle.getFloatArray(str));
        } else if ((localObject instanceof Float)) {
          paramString.put(str, Float.valueOf(paramBundle.getFloat(str)));
        }
      }
      localHashMap.put("data", paramString);
    }
    this.channel.invokeMethod("TextInputClient.performPrivateCommand", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), localHashMap }));
    AppMethodBeat.o(190294);
  }
  
  public void previous(int paramInt)
  {
    AppMethodBeat.i(190282);
    Log.v("TextInputChannel", "Sending 'previous' message.");
    this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.previous" }));
    AppMethodBeat.o(190282);
  }
  
  public void requestExistingInputState()
  {
    AppMethodBeat.i(190226);
    this.channel.invokeMethod("TextInputClient.requestExistingInputState", null);
    AppMethodBeat.o(190226);
  }
  
  public void search(int paramInt)
  {
    AppMethodBeat.i(190254);
    Log.v("TextInputChannel", "Sending 'search' message.");
    this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.search" }));
    AppMethodBeat.o(190254);
  }
  
  public void send(int paramInt)
  {
    AppMethodBeat.i(190261);
    Log.v("TextInputChannel", "Sending 'send' message.");
    this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.send" }));
    AppMethodBeat.o(190261);
  }
  
  public void setTextInputMethodHandler(TextInputMethodHandler paramTextInputMethodHandler)
  {
    this.textInputMethodHandler = paramTextInputMethodHandler;
  }
  
  public void unspecifiedAction(int paramInt)
  {
    AppMethodBeat.i(190287);
    Log.v("TextInputChannel", "Sending 'unspecified' message.");
    this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.unspecified" }));
    AppMethodBeat.o(190287);
  }
  
  public void updateEditingState(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(190232);
    Log.v("TextInputChannel", "Sending message to update editing state: \nText: " + paramString + "\nSelection start: " + paramInt2 + "\nSelection end: " + paramInt3 + "\nComposing start: " + paramInt4 + "\nComposing end: " + paramInt5);
    paramString = createEditingStateJSON(paramString, paramInt2, paramInt3, paramInt4, paramInt5);
    this.channel.invokeMethod("TextInputClient.updateEditingState", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt1), paramString }));
    AppMethodBeat.o(190232);
  }
  
  public void updateEditingStateWithTag(int paramInt, HashMap<String, TextEditState> paramHashMap)
  {
    AppMethodBeat.i(190237);
    Log.v("TextInputChannel", "Sending message to update editing state for " + String.valueOf(paramHashMap.size()) + " field(s).");
    HashMap localHashMap = new HashMap();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      TextEditState localTextEditState = (TextEditState)localEntry.getValue();
      localHashMap.put(localEntry.getKey(), createEditingStateJSON(localTextEditState.text, localTextEditState.selectionStart, localTextEditState.selectionEnd, -1, -1));
    }
    this.channel.invokeMethod("TextInputClient.updateEditingStateWithTag", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), localHashMap }));
    AppMethodBeat.o(190237);
  }
  
  public static class Configuration
  {
    public final String actionLabel;
    public final boolean autocorrect;
    public final Autofill autofill;
    public final boolean enableSuggestions;
    public final Configuration[] fields;
    public final Integer inputAction;
    public final TextInputChannel.InputType inputType;
    public final boolean obscureText;
    public final TextInputChannel.TextCapitalization textCapitalization;
    
    public Configuration(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, TextInputChannel.TextCapitalization paramTextCapitalization, TextInputChannel.InputType paramInputType, Integer paramInteger, String paramString, Autofill paramAutofill, Configuration[] paramArrayOfConfiguration)
    {
      this.obscureText = paramBoolean1;
      this.autocorrect = paramBoolean2;
      this.enableSuggestions = paramBoolean3;
      this.textCapitalization = paramTextCapitalization;
      this.inputType = paramInputType;
      this.inputAction = paramInteger;
      this.actionLabel = paramString;
      this.autofill = paramAutofill;
      this.fields = paramArrayOfConfiguration;
    }
    
    public static Configuration fromJson(JSONObject paramJSONObject)
    {
      Object localObject3 = null;
      AppMethodBeat.i(190285);
      Object localObject4 = paramJSONObject.getString("inputAction");
      if (localObject4 == null)
      {
        paramJSONObject = new JSONException("Configuration JSON missing 'inputAction' property.");
        AppMethodBeat.o(190285);
        throw paramJSONObject;
      }
      Object localObject2;
      if (!paramJSONObject.isNull("fields"))
      {
        localObject5 = paramJSONObject.getJSONArray("fields");
        localObject2 = new Configuration[((JSONArray)localObject5).length()];
        int i = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= localObject2.length) {
            break;
          }
          localObject2[i] = fromJson(((JSONArray)localObject5).getJSONObject(i));
          i += 1;
        }
      }
      Object localObject1 = null;
      localObject4 = inputActionFromTextInputAction((String)localObject4);
      boolean bool1 = paramJSONObject.optBoolean("obscureText");
      boolean bool2 = paramJSONObject.optBoolean("autocorrect", true);
      boolean bool3 = paramJSONObject.optBoolean("enableSuggestions");
      Object localObject5 = TextInputChannel.TextCapitalization.fromValue(paramJSONObject.getString("textCapitalization"));
      TextInputChannel.InputType localInputType = TextInputChannel.InputType.fromJson(paramJSONObject.getJSONObject("inputType"));
      if (paramJSONObject.isNull("actionLabel"))
      {
        localObject2 = null;
        if (!paramJSONObject.isNull("autofill")) {
          break label218;
        }
      }
      label218:
      for (paramJSONObject = localObject3;; paramJSONObject = Autofill.fromJson(paramJSONObject.getJSONObject("autofill")))
      {
        paramJSONObject = new Configuration(bool1, bool2, bool3, (TextInputChannel.TextCapitalization)localObject5, localInputType, (Integer)localObject4, (String)localObject2, paramJSONObject, localObject1);
        AppMethodBeat.o(190285);
        return paramJSONObject;
        localObject2 = paramJSONObject.getString("actionLabel");
        break;
      }
    }
    
    private static Integer inputActionFromTextInputAction(String paramString)
    {
      AppMethodBeat.i(190292);
      int i = -1;
      switch (paramString.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          AppMethodBeat.o(190292);
          return Integer.valueOf(0);
          if (paramString.equals("TextInputAction.newline"))
          {
            i = 0;
            continue;
            if (paramString.equals("TextInputAction.none"))
            {
              i = 1;
              continue;
              if (paramString.equals("TextInputAction.unspecified"))
              {
                i = 2;
                continue;
                if (paramString.equals("TextInputAction.done"))
                {
                  i = 3;
                  continue;
                  if (paramString.equals("TextInputAction.go"))
                  {
                    i = 4;
                    continue;
                    if (paramString.equals("TextInputAction.search"))
                    {
                      i = 5;
                      continue;
                      if (paramString.equals("TextInputAction.send"))
                      {
                        i = 6;
                        continue;
                        if (paramString.equals("TextInputAction.next"))
                        {
                          i = 7;
                          continue;
                          if (paramString.equals("TextInputAction.previous")) {
                            i = 8;
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
      AppMethodBeat.o(190292);
      return Integer.valueOf(1);
      AppMethodBeat.o(190292);
      return Integer.valueOf(1);
      AppMethodBeat.o(190292);
      return Integer.valueOf(0);
      AppMethodBeat.o(190292);
      return Integer.valueOf(6);
      AppMethodBeat.o(190292);
      return Integer.valueOf(2);
      AppMethodBeat.o(190292);
      return Integer.valueOf(3);
      AppMethodBeat.o(190292);
      return Integer.valueOf(4);
      AppMethodBeat.o(190292);
      return Integer.valueOf(5);
      AppMethodBeat.o(190292);
      return Integer.valueOf(7);
    }
    
    public static class Autofill
    {
      public final TextInputChannel.TextEditState editState;
      public final String[] hints;
      public final String uniqueIdentifier;
      
      public Autofill(String paramString, String[] paramArrayOfString, TextInputChannel.TextEditState paramTextEditState)
      {
        this.uniqueIdentifier = paramString;
        this.hints = paramArrayOfString;
        this.editState = paramTextEditState;
      }
      
      public static Autofill fromJson(JSONObject paramJSONObject)
      {
        AppMethodBeat.i(190271);
        String str = paramJSONObject.getString("uniqueIdentifier");
        JSONArray localJSONArray = paramJSONObject.getJSONArray("hints");
        paramJSONObject = paramJSONObject.getJSONObject("editingValue");
        String[] arrayOfString = new String[localJSONArray.length()];
        int i = 0;
        while (i < arrayOfString.length)
        {
          arrayOfString[i] = translateAutofillHint(localJSONArray.getString(i));
          i += 1;
        }
        paramJSONObject = new Autofill(str, arrayOfString, TextInputChannel.TextEditState.fromJson(paramJSONObject));
        AppMethodBeat.o(190271);
        return paramJSONObject;
      }
      
      private static String translateAutofillHint(String paramString)
      {
        AppMethodBeat.i(190284);
        if (Build.VERSION.SDK_INT < 26)
        {
          AppMethodBeat.o(190284);
          return paramString;
        }
        int i = -1;
        switch (paramString.hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            AppMethodBeat.o(190284);
            return paramString;
            if (paramString.equals("addressCity"))
            {
              i = 0;
              continue;
              if (paramString.equals("addressState"))
              {
                i = 1;
                continue;
                if (paramString.equals("birthday"))
                {
                  i = 2;
                  continue;
                  if (paramString.equals("birthdayDay"))
                  {
                    i = 3;
                    continue;
                    if (paramString.equals("birthdayMonth"))
                    {
                      i = 4;
                      continue;
                      if (paramString.equals("birthdayYear"))
                      {
                        i = 5;
                        continue;
                        if (paramString.equals("countryName"))
                        {
                          i = 6;
                          continue;
                          if (paramString.equals("creditCardExpirationDate"))
                          {
                            i = 7;
                            continue;
                            if (paramString.equals("creditCardExpirationDay"))
                            {
                              i = 8;
                              continue;
                              if (paramString.equals("creditCardExpirationMonth"))
                              {
                                i = 9;
                                continue;
                                if (paramString.equals("creditCardExpirationYear"))
                                {
                                  i = 10;
                                  continue;
                                  if (paramString.equals("creditCardNumber"))
                                  {
                                    i = 11;
                                    continue;
                                    if (paramString.equals("creditCardSecurityCode"))
                                    {
                                      i = 12;
                                      continue;
                                      if (paramString.equals("email"))
                                      {
                                        i = 13;
                                        continue;
                                        if (paramString.equals("familyName"))
                                        {
                                          i = 14;
                                          continue;
                                          if (paramString.equals("fullStreetAddress"))
                                          {
                                            i = 15;
                                            continue;
                                            if (paramString.equals("gender"))
                                            {
                                              i = 16;
                                              continue;
                                              if (paramString.equals("givenName"))
                                              {
                                                i = 17;
                                                continue;
                                                if (paramString.equals("middleInitial"))
                                                {
                                                  i = 18;
                                                  continue;
                                                  if (paramString.equals("middleName"))
                                                  {
                                                    i = 19;
                                                    continue;
                                                    if (paramString.equals("name"))
                                                    {
                                                      i = 20;
                                                      continue;
                                                      if (paramString.equals("namePrefix"))
                                                      {
                                                        i = 21;
                                                        continue;
                                                        if (paramString.equals("nameSuffix"))
                                                        {
                                                          i = 22;
                                                          continue;
                                                          if (paramString.equals("newPassword"))
                                                          {
                                                            i = 23;
                                                            continue;
                                                            if (paramString.equals("newUsername"))
                                                            {
                                                              i = 24;
                                                              continue;
                                                              if (paramString.equals("oneTimeCode"))
                                                              {
                                                                i = 25;
                                                                continue;
                                                                if (paramString.equals("password"))
                                                                {
                                                                  i = 26;
                                                                  continue;
                                                                  if (paramString.equals("postalAddress"))
                                                                  {
                                                                    i = 27;
                                                                    continue;
                                                                    if (paramString.equals("postalAddressExtended"))
                                                                    {
                                                                      i = 28;
                                                                      continue;
                                                                      if (paramString.equals("postalAddressExtendedPostalCode"))
                                                                      {
                                                                        i = 29;
                                                                        continue;
                                                                        if (paramString.equals("postalCode"))
                                                                        {
                                                                          i = 30;
                                                                          continue;
                                                                          if (paramString.equals("telephoneNumber"))
                                                                          {
                                                                            i = 31;
                                                                            continue;
                                                                            if (paramString.equals("telephoneNumberCountryCode"))
                                                                            {
                                                                              i = 32;
                                                                              continue;
                                                                              if (paramString.equals("telephoneNumberDevice"))
                                                                              {
                                                                                i = 33;
                                                                                continue;
                                                                                if (paramString.equals("telephoneNumberNational"))
                                                                                {
                                                                                  i = 34;
                                                                                  continue;
                                                                                  if (paramString.equals("username")) {
                                                                                    i = 35;
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
                      }
                    }
                  }
                }
              }
            }
            break;
          }
        }
        AppMethodBeat.o(190284);
        return "addressLocality";
        AppMethodBeat.o(190284);
        return "addressRegion";
        AppMethodBeat.o(190284);
        return "birthDateFull";
        AppMethodBeat.o(190284);
        return "birthDateDay";
        AppMethodBeat.o(190284);
        return "birthDateMonth";
        AppMethodBeat.o(190284);
        return "birthDateYear";
        AppMethodBeat.o(190284);
        return "addressCountry";
        AppMethodBeat.o(190284);
        return "creditCardExpirationDate";
        AppMethodBeat.o(190284);
        return "creditCardExpirationDay";
        AppMethodBeat.o(190284);
        return "creditCardExpirationMonth";
        AppMethodBeat.o(190284);
        return "creditCardExpirationYear";
        AppMethodBeat.o(190284);
        return "creditCardNumber";
        AppMethodBeat.o(190284);
        return "creditCardSecurityCode";
        AppMethodBeat.o(190284);
        return "emailAddress";
        AppMethodBeat.o(190284);
        return "personFamilyName";
        AppMethodBeat.o(190284);
        return "streetAddress";
        AppMethodBeat.o(190284);
        return "gender";
        AppMethodBeat.o(190284);
        return "personGivenName";
        AppMethodBeat.o(190284);
        return "personMiddleInitial";
        AppMethodBeat.o(190284);
        return "personMiddleName";
        AppMethodBeat.o(190284);
        return "personName";
        AppMethodBeat.o(190284);
        return "personNamePrefix";
        AppMethodBeat.o(190284);
        return "personNameSuffix";
        AppMethodBeat.o(190284);
        return "newPassword";
        AppMethodBeat.o(190284);
        return "newUsername";
        AppMethodBeat.o(190284);
        return "smsOTPCode";
        AppMethodBeat.o(190284);
        return "password";
        AppMethodBeat.o(190284);
        return "postalAddress";
        AppMethodBeat.o(190284);
        return "extendedAddress";
        AppMethodBeat.o(190284);
        return "extendedPostalCode";
        AppMethodBeat.o(190284);
        return "postalCode";
        AppMethodBeat.o(190284);
        return "phoneNumber";
        AppMethodBeat.o(190284);
        return "phoneCountryCode";
        AppMethodBeat.o(190284);
        return "phoneNumberDevice";
        AppMethodBeat.o(190284);
        return "phoneNational";
        AppMethodBeat.o(190284);
        return "username";
      }
    }
  }
  
  public static class InputType
  {
    public final boolean isDecimal;
    public final boolean isSigned;
    public final TextInputChannel.TextInputType type;
    
    public InputType(TextInputChannel.TextInputType paramTextInputType, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.type = paramTextInputType;
      this.isSigned = paramBoolean1;
      this.isDecimal = paramBoolean2;
    }
    
    public static InputType fromJson(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(190218);
      paramJSONObject = new InputType(TextInputChannel.TextInputType.fromValue(paramJSONObject.getString("name")), paramJSONObject.optBoolean("signed", false), paramJSONObject.optBoolean("decimal", false));
      AppMethodBeat.o(190218);
      return paramJSONObject;
    }
  }
  
  public static class TextEditState
  {
    public final int composingEnd;
    public final int composingStart;
    public final int selectionEnd;
    public final int selectionStart;
    public final String text;
    
    public TextEditState(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(190309);
      if (((paramInt1 != -1) || (paramInt2 != -1)) && ((paramInt1 < 0) || (paramInt2 < 0)))
      {
        paramString = new IndexOutOfBoundsException("invalid selection: (" + String.valueOf(paramInt1) + ", " + String.valueOf(paramInt2) + ")");
        AppMethodBeat.o(190309);
        throw paramString;
      }
      if (((paramInt3 != -1) || (paramInt4 != -1)) && ((paramInt3 < 0) || (paramInt3 >= paramInt4)))
      {
        paramString = new IndexOutOfBoundsException("invalid composing range: (" + String.valueOf(paramInt3) + ", " + String.valueOf(paramInt4) + ")");
        AppMethodBeat.o(190309);
        throw paramString;
      }
      if (paramInt4 > paramString.length())
      {
        paramString = new IndexOutOfBoundsException("invalid composing start: " + String.valueOf(paramInt3));
        AppMethodBeat.o(190309);
        throw paramString;
      }
      if (paramInt1 > paramString.length())
      {
        paramString = new IndexOutOfBoundsException("invalid selection start: " + String.valueOf(paramInt1));
        AppMethodBeat.o(190309);
        throw paramString;
      }
      if (paramInt2 > paramString.length())
      {
        paramString = new IndexOutOfBoundsException("invalid selection end: " + String.valueOf(paramInt2));
        AppMethodBeat.o(190309);
        throw paramString;
      }
      this.text = paramString;
      this.selectionStart = paramInt1;
      this.selectionEnd = paramInt2;
      this.composingStart = paramInt3;
      this.composingEnd = paramInt4;
      AppMethodBeat.o(190309);
    }
    
    public static TextEditState fromJson(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(190302);
      paramJSONObject = new TextEditState(paramJSONObject.getString("text"), paramJSONObject.getInt("selectionBase"), paramJSONObject.getInt("selectionExtent"), paramJSONObject.getInt("composingBase"), paramJSONObject.getInt("composingExtent"));
      AppMethodBeat.o(190302);
      return paramJSONObject;
    }
  }
  
  public static abstract interface TextInputMethodHandler
  {
    public abstract void clearClient();
    
    public abstract void finishAutofillContext(boolean paramBoolean);
    
    public abstract void hide();
    
    public abstract void requestAutofill();
    
    public abstract void sendAppPrivateCommand(String paramString, Bundle paramBundle);
    
    public abstract void setClient(int paramInt, TextInputChannel.Configuration paramConfiguration);
    
    public abstract void setEditableSizeAndTransform(double paramDouble1, double paramDouble2, double[] paramArrayOfDouble);
    
    public abstract void setEditingState(TextInputChannel.TextEditState paramTextEditState);
    
    public abstract void setPlatformViewClient(int paramInt);
    
    public abstract void show();
  }
  
  public static enum TextInputType
  {
    private final String encodedName;
    
    static
    {
      AppMethodBeat.i(10248);
      TEXT = new TextInputType("TEXT", 0, "TextInputType.text");
      DATETIME = new TextInputType("DATETIME", 1, "TextInputType.datetime");
      NAME = new TextInputType("NAME", 2, "TextInputType.name");
      POSTAL_ADDRESS = new TextInputType("POSTAL_ADDRESS", 3, "TextInputType.address");
      NUMBER = new TextInputType("NUMBER", 4, "TextInputType.number");
      PHONE = new TextInputType("PHONE", 5, "TextInputType.phone");
      MULTILINE = new TextInputType("MULTILINE", 6, "TextInputType.multiline");
      EMAIL_ADDRESS = new TextInputType("EMAIL_ADDRESS", 7, "TextInputType.emailAddress");
      URL = new TextInputType("URL", 8, "TextInputType.url");
      VISIBLE_PASSWORD = new TextInputType("VISIBLE_PASSWORD", 9, "TextInputType.visiblePassword");
      $VALUES = new TextInputType[] { TEXT, DATETIME, NAME, POSTAL_ADDRESS, NUMBER, PHONE, MULTILINE, EMAIL_ADDRESS, URL, VISIBLE_PASSWORD };
      AppMethodBeat.o(10248);
    }
    
    private TextInputType(String paramString)
    {
      this.encodedName = paramString;
    }
    
    static TextInputType fromValue(String paramString)
    {
      AppMethodBeat.i(10247);
      TextInputType[] arrayOfTextInputType = values();
      int j = arrayOfTextInputType.length;
      int i = 0;
      while (i < j)
      {
        TextInputType localTextInputType = arrayOfTextInputType[i];
        if (localTextInputType.encodedName.equals(paramString))
        {
          AppMethodBeat.o(10247);
          return localTextInputType;
        }
        i += 1;
      }
      paramString = new NoSuchFieldException("No such TextInputType: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(10247);
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.TextInputChannel
 * JD-Core Version:    0.7.0.1
 */