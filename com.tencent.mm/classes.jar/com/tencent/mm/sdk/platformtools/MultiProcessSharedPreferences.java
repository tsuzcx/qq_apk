package com.tencent.mm.sdk.platformtools;

import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.UriMatcher;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Deprecated
public class MultiProcessSharedPreferences
  extends ContentProvider
  implements SharedPreferences
{
  private static String AUTHORITY;
  private static volatile Uri AUTHORITY_URI;
  private boolean GsV;
  private Map<String, Integer> GsW;
  private Context mContext;
  private List<SoftReference<SharedPreferences.OnSharedPreferenceChangeListener>> mListeners;
  private int mMode;
  private String mName;
  private BroadcastReceiver mReceiver;
  private UriMatcher zmD;
  
  public MultiProcessSharedPreferences() {}
  
  private MultiProcessSharedPreferences(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(156323);
    this.mContext = paramContext;
    this.mName = paramString;
    this.mMode = paramInt;
    this.GsV = paramContext.getPackageManager().isSafeMode();
    AppMethodBeat.o(156323);
  }
  
  private static String aKZ(String paramString)
  {
    AppMethodBeat.i(156336);
    paramString = String.format("%1$s_%2$s", new Object[] { MultiProcessSharedPreferences.class.getName(), paramString });
    AppMethodBeat.o(156336);
    return paramString;
  }
  
  private void eVC()
  {
    AppMethodBeat.i(156345);
    if (this.GsW == null) {
      this.GsW = new HashMap();
    }
    AppMethodBeat.o(156345);
  }
  
  public static SharedPreferences getSharedPreferences(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(156322);
    aw localaw = aw.aKT(paramString);
    aw.a(new MultiProcessSharedPreferences(paramContext, paramString, paramInt), localaw);
    AppMethodBeat.o(156322);
    return localaw;
  }
  
  private Object h(String paramString1, String paramString2, Object paramObject)
  {
    Bundle localBundle = null;
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(156335);
    if (this.GsV)
    {
      AppMethodBeat.o(156335);
      return null;
    }
    iE(this.mContext);
    Object localObject3 = Uri.withAppendedPath(Uri.withAppendedPath(AUTHORITY_URI, this.mName), paramString1);
    int i = this.mMode;
    if (paramObject == null) {}
    for (paramString1 = null;; paramString1 = String.valueOf(paramObject))
    {
      localObject3 = this.mContext.getContentResolver().query((Uri)localObject3, null, null, new String[] { String.valueOf(i), paramString2, paramString1 }, null);
      paramString1 = localBundle;
      if (localObject3 != null) {
        paramString1 = localObject1;
      }
      try
      {
        localBundle = ((Cursor)localObject3).getExtras();
        paramString1 = localObject2;
        if (localBundle != null)
        {
          paramString1 = localObject1;
          paramString2 = localBundle.get("value");
          paramString1 = paramString2;
          localBundle.clear();
          paramString1 = paramString2;
        }
      }
      catch (Exception paramString2)
      {
        label149:
        break label149;
      }
      ((Cursor)localObject3).close();
      if (paramString1 == null) {
        break;
      }
      AppMethodBeat.o(156335);
      return paramString1;
    }
    AppMethodBeat.o(156335);
    return paramObject;
  }
  
  private void iE(Context paramContext)
  {
    AppMethodBeat.i(156320);
    if (AUTHORITY_URI == null)
    {
      String str = null;
      Uri localUri2 = AUTHORITY_URI;
      Uri localUri1 = localUri2;
      if (localUri2 == null) {}
      try
      {
        str = iF(paramContext);
        localUri1 = Uri.parse("content://".concat(String.valueOf(str)));
        if (str == null)
        {
          paramContext = new IllegalArgumentException("'AUTHORITY' initialize failed.");
          AppMethodBeat.o(156320);
          throw paramContext;
        }
      }
      finally
      {
        AppMethodBeat.o(156320);
      }
      AUTHORITY = str;
      AUTHORITY_URI = localUri1;
    }
    AppMethodBeat.o(156320);
  }
  
  private static String iF(Context paramContext)
  {
    AppMethodBeat.i(156321);
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 8);
      if ((paramContext != null) && (paramContext.providers != null))
      {
        paramContext = paramContext.providers;
        int j = paramContext.length;
        i = 0;
        if (i < j)
        {
          Object localObject = paramContext[i];
          if (localObject.name.equals(MultiProcessSharedPreferences.class.getName()))
          {
            paramContext = localObject.authority;
            AppMethodBeat.o(156321);
            return paramContext;
          }
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        int i;
        paramContext = null;
        continue;
        i += 1;
      }
      AppMethodBeat.o(156321);
    }
    return null;
  }
  
  private void k(String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(156346);
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      Intent localIntent = new Intent();
      localIntent.setAction(aKZ(paramString));
      localIntent.setPackage(getContext().getPackageName());
      localIntent.putExtra("name", paramString);
      localIntent.putExtra("value", paramArrayList);
      getContext().sendBroadcast(localIntent);
    }
    AppMethodBeat.o(156346);
  }
  
  public boolean contains(String paramString)
  {
    AppMethodBeat.i(156331);
    paramString = (Boolean)h("contains", paramString, null);
    if (paramString != null)
    {
      boolean bool = paramString.booleanValue();
      AppMethodBeat.o(156331);
      return bool;
    }
    AppMethodBeat.o(156331);
    return false;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(156341);
    paramUri = new UnsupportedOperationException("No external delete");
    AppMethodBeat.o(156341);
    throw paramUri;
  }
  
  public SharedPreferences.Editor edit()
  {
    AppMethodBeat.i(156332);
    b localb = new b();
    AppMethodBeat.o(156332);
    return localb;
  }
  
  public Map<String, ?> getAll()
  {
    AppMethodBeat.i(156324);
    Map localMap = (Map)h("getAll", null, null);
    AppMethodBeat.o(156324);
    return localMap;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(156330);
    paramString = (Boolean)h("getBoolean", paramString, Boolean.valueOf(paramBoolean));
    if (paramString != null)
    {
      paramBoolean = paramString.booleanValue();
      AppMethodBeat.o(156330);
      return paramBoolean;
    }
    AppMethodBeat.o(156330);
    return paramBoolean;
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(156329);
    paramString = (Float)h("getFloat", paramString, Float.valueOf(paramFloat));
    if (paramString != null)
    {
      paramFloat = paramString.floatValue();
      AppMethodBeat.o(156329);
      return paramFloat;
    }
    AppMethodBeat.o(156329);
    return paramFloat;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(156327);
    paramString = (Integer)h("getInt", paramString, Integer.valueOf(paramInt));
    if (paramString != null)
    {
      paramInt = paramString.intValue();
      AppMethodBeat.o(156327);
      return paramInt;
    }
    AppMethodBeat.o(156327);
    return paramInt;
  }
  
  public long getLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(156328);
    paramString = (Long)h("getLong", paramString, Long.valueOf(paramLong));
    if (paramString != null)
    {
      paramLong = paramString.longValue();
      AppMethodBeat.o(156328);
      return paramLong;
    }
    AppMethodBeat.o(156328);
    return paramLong;
  }
  
  public String getString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156325);
    paramString1 = (String)h("getString", paramString1, paramString2);
    if (paramString1 != null)
    {
      AppMethodBeat.o(156325);
      return paramString1;
    }
    AppMethodBeat.o(156325);
    return paramString2;
  }
  
  /* Error */
  public Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    // Byte code:
    //   0: ldc_w 356
    //   3: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: ldc_w 353
    //   12: aload_1
    //   13: aload_2
    //   14: invokespecial 277	com/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences:h	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   17: checkcast 358	java/util/Set
    //   20: astore_1
    //   21: aload_1
    //   22: ifnull +13 -> 35
    //   25: aload_0
    //   26: monitorexit
    //   27: ldc_w 356
    //   30: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_1
    //   34: areturn
    //   35: aload_2
    //   36: astore_1
    //   37: goto -12 -> 25
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: ldc_w 356
    //   46: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	MultiProcessSharedPreferences
    //   0	51	1	paramString	String
    //   0	51	2	paramSet	Set<String>
    // Exception table:
    //   from	to	target	type
    //   8	21	40	finally
    //   25	27	40	finally
    //   41	43	40	finally
  }
  
  public String getType(Uri paramUri)
  {
    AppMethodBeat.i(156339);
    paramUri = new UnsupportedOperationException("No external call");
    AppMethodBeat.o(156339);
    throw paramUri;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    AppMethodBeat.i(156340);
    paramUri = new UnsupportedOperationException("No external insert");
    AppMethodBeat.o(156340);
    throw paramUri;
  }
  
  public boolean onCreate()
  {
    AppMethodBeat.i(156337);
    iE(getContext());
    this.zmD = new UriMatcher(-1);
    this.zmD.addURI(AUTHORITY, "*/getAll", 1);
    this.zmD.addURI(AUTHORITY, "*/getString", 2);
    this.zmD.addURI(AUTHORITY, "*/getInt", 3);
    this.zmD.addURI(AUTHORITY, "*/getLong", 4);
    this.zmD.addURI(AUTHORITY, "*/getFloat", 5);
    this.zmD.addURI(AUTHORITY, "*/getBoolean", 6);
    this.zmD.addURI(AUTHORITY, "*/contains", 7);
    this.zmD.addURI(AUTHORITY, "*/apply", 8);
    this.zmD.addURI(AUTHORITY, "*/commit", 9);
    this.zmD.addURI(AUTHORITY, "*/registerOnSharedPreferenceChangeListener", 10);
    this.zmD.addURI(AUTHORITY, "*/unregisterOnSharedPreferenceChangeListener", 11);
    AppMethodBeat.o(156337);
    return true;
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(156343);
    if (this.GsW != null) {
      this.GsW.clear();
    }
    super.onLowMemory();
    AppMethodBeat.o(156343);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(156344);
    if (this.GsW != null) {
      this.GsW.clear();
    }
    super.onTrimMemory(paramInt);
    AppMethodBeat.o(156344);
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(156338);
    paramString1 = (String)paramUri.getPathSegments().get(0);
    int i = Integer.parseInt(paramArrayOfString2[0]);
    paramString2 = paramArrayOfString2[1];
    paramArrayOfString2 = paramArrayOfString2[2];
    paramArrayOfString1 = new Bundle();
    label386:
    int j;
    switch (this.zmD.match(paramUri))
    {
    case 8: 
    case 9: 
    default: 
      paramUri = new IllegalArgumentException("This is Unknown Uri：".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(156338);
      throw paramUri;
    case 1: 
      paramArrayOfString1.putSerializable("value", (HashMap)getContext().getSharedPreferences(paramString1, i).getAll());
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
      for (;;)
      {
        paramUri = new a(paramArrayOfString1);
        AppMethodBeat.o(156338);
        return paramUri;
        paramArrayOfString1.putString("value", getContext().getSharedPreferences(paramString1, i).getString(paramString2, paramArrayOfString2));
        continue;
        paramArrayOfString1.putInt("value", getContext().getSharedPreferences(paramString1, i).getInt(paramString2, Integer.parseInt(paramArrayOfString2)));
        continue;
        paramArrayOfString1.putLong("value", getContext().getSharedPreferences(paramString1, i).getLong(paramString2, Long.parseLong(paramArrayOfString2)));
        continue;
        paramArrayOfString1.putFloat("value", getContext().getSharedPreferences(paramString1, i).getFloat(paramString2, Float.parseFloat(paramArrayOfString2)));
        continue;
        paramArrayOfString1.putBoolean("value", getContext().getSharedPreferences(paramString1, i).getBoolean(paramString2, Boolean.parseBoolean(paramArrayOfString2)));
        continue;
        paramArrayOfString1.putBoolean("value", getContext().getSharedPreferences(paramString1, i).contains(paramString2));
      }
    case 10: 
      eVC();
      paramUri = (Integer)this.GsW.get(paramString1);
      if (paramUri == null)
      {
        i = 0;
        j = i + 1;
        this.GsW.put(paramString1, Integer.valueOf(j));
        paramUri = (Integer)this.GsW.get(paramString1);
        if (paramUri != null) {
          break label459;
        }
        i = 0;
        label429:
        if (j != i) {
          break label468;
        }
      }
      label459:
      label468:
      for (bool = true;; bool = false)
      {
        paramArrayOfString1.putBoolean("value", bool);
        break;
        i = paramUri.intValue();
        break label386;
        i = paramUri.intValue();
        break label429;
      }
    }
    eVC();
    paramUri = (Integer)this.GsW.get(paramString1);
    if (paramUri == null)
    {
      i = 0;
      label499:
      j = i - 1;
      if (j > 0) {
        break label563;
      }
      this.GsW.remove(paramString1);
      if (this.GsW.containsKey(paramString1)) {
        break label557;
      }
    }
    label557:
    for (boolean bool = true;; bool = false)
    {
      paramArrayOfString1.putBoolean("value", bool);
      break;
      i = paramUri.intValue();
      break label499;
    }
    label563:
    this.GsW.put(paramString1, Integer.valueOf(j));
    paramUri = (Integer)this.GsW.get(paramString1);
    if (paramUri == null)
    {
      i = 0;
      label600:
      if (j != i) {
        break label630;
      }
    }
    label630:
    for (bool = true;; bool = false)
    {
      paramArrayOfString1.putBoolean("value", bool);
      break;
      i = paramUri.intValue();
      break label600;
    }
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    AppMethodBeat.i(156333);
    try
    {
      if (this.mListeners == null) {
        this.mListeners = new ArrayList();
      }
      Boolean localBoolean = (Boolean)h("registerOnSharedPreferenceChangeListener", null, Boolean.FALSE);
      if ((localBoolean != null) && (localBoolean.booleanValue()))
      {
        this.mListeners.add(new SoftReference(paramOnSharedPreferenceChangeListener));
        if (this.mReceiver == null)
        {
          this.mReceiver = new BroadcastReceiver()
          {
            public final void onReceive(Context paramAnonymousContext, Intent arg2)
            {
              AppMethodBeat.i(156305);
              Object localObject = ???.getStringExtra("name");
              paramAnonymousContext = (List)???.getSerializableExtra("value");
              if ((MultiProcessSharedPreferences.a(MultiProcessSharedPreferences.this).equals(localObject)) && (paramAnonymousContext != null)) {
                for (;;)
                {
                  int i;
                  synchronized (MultiProcessSharedPreferences.this)
                  {
                    localObject = MultiProcessSharedPreferences.b(MultiProcessSharedPreferences.this);
                    ??? = new ArrayList((Collection)localObject);
                    i = paramAnonymousContext.size() - 1;
                    if (i < 0) {
                      break;
                    }
                    localObject = (String)paramAnonymousContext.get(i);
                    Iterator localIterator = ???.iterator();
                    if (localIterator.hasNext())
                    {
                      SharedPreferences.OnSharedPreferenceChangeListener localOnSharedPreferenceChangeListener = (SharedPreferences.OnSharedPreferenceChangeListener)((SoftReference)localIterator.next()).get();
                      if (localOnSharedPreferenceChangeListener == null) {
                        continue;
                      }
                      localOnSharedPreferenceChangeListener.onSharedPreferenceChanged(MultiProcessSharedPreferences.this, (String)localObject);
                    }
                  }
                  i -= 1;
                }
              }
              AppMethodBeat.o(156305);
            }
          };
          this.mContext.registerReceiver(this.mReceiver, new IntentFilter(aKZ(this.mName)));
        }
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(156333);
    }
  }
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    AppMethodBeat.i(156334);
    Object localObject;
    try
    {
      h("unregisterOnSharedPreferenceChangeListener", null, Boolean.FALSE);
      if (this.mListeners == null) {
        break label192;
      }
      localObject = new ArrayList();
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext())
      {
        SoftReference localSoftReference = (SoftReference)localIterator.next();
        SharedPreferences.OnSharedPreferenceChangeListener localOnSharedPreferenceChangeListener = (SharedPreferences.OnSharedPreferenceChangeListener)localSoftReference.get();
        if ((localOnSharedPreferenceChangeListener != null) && (localOnSharedPreferenceChangeListener.equals(paramOnSharedPreferenceChangeListener))) {
          ((List)localObject).add(localSoftReference);
        }
      }
      paramOnSharedPreferenceChangeListener = ((List)localObject).iterator();
    }
    finally
    {
      AppMethodBeat.o(156334);
    }
    while (paramOnSharedPreferenceChangeListener.hasNext())
    {
      localObject = (SoftReference)paramOnSharedPreferenceChangeListener.next();
      this.mListeners.remove(localObject);
    }
    if ((this.mListeners.isEmpty()) && (this.mReceiver != null))
    {
      this.mContext.unregisterReceiver(this.mReceiver);
      this.mReceiver = null;
      this.mListeners = null;
    }
    label192:
    AppMethodBeat.o(156334);
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(156342);
    String str1 = (String)paramUri.getPathSegments().get(0);
    int i = Integer.parseInt(paramArrayOfString[0]);
    Object localObject1 = getContext().getSharedPreferences(str1, i);
    int j = this.zmD.match(paramUri);
    switch (j)
    {
    default: 
      paramUri = new IllegalArgumentException("This is Unknown Uri：".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(156342);
      throw paramUri;
    }
    if ((this.GsW != null) && (this.GsW.get(str1) != null) && (((Integer)this.GsW.get(str1)).intValue() > 0))
    {
      i = 1;
      paramUri = new HashMap();
      if (i == 0) {
        break label791;
      }
      paramString = new ArrayList();
      paramUri = ((SharedPreferences)localObject1).getAll();
    }
    for (;;)
    {
      localObject1 = ((SharedPreferences)localObject1).edit();
      if (Boolean.parseBoolean(paramArrayOfString[1]))
      {
        if ((i != 0) && (paramUri != null) && (!paramUri.isEmpty()))
        {
          paramArrayOfString = paramUri.entrySet().iterator();
          for (;;)
          {
            if (paramArrayOfString.hasNext())
            {
              paramString.add(((Map.Entry)paramArrayOfString.next()).getKey());
              continue;
              i = 0;
              break;
            }
          }
        }
        ((SharedPreferences.Editor)localObject1).clear();
      }
      paramArrayOfString = paramContentValues.valueSet().iterator();
      while (paramArrayOfString.hasNext())
      {
        Object localObject2 = (Map.Entry)paramArrayOfString.next();
        String str2 = (String)((Map.Entry)localObject2).getKey();
        localObject2 = ((Map.Entry)localObject2).getValue();
        if (((localObject2 instanceof b)) || (localObject2 == null))
        {
          ((SharedPreferences.Editor)localObject1).remove(str2);
          if ((i != 0) && (paramUri != null) && (paramUri.containsKey(str2))) {
            paramString.add(str2);
          }
        }
        for (;;)
        {
          if (!(localObject2 instanceof String)) {
            break label459;
          }
          ((SharedPreferences.Editor)localObject1).putString(str2, (String)localObject2);
          break;
          if ((i != 0) && (paramUri != null) && ((!paramUri.containsKey(str2)) || ((paramUri.containsKey(str2)) && (!localObject2.equals(paramUri.get(str2)))))) {
            paramString.add(str2);
          }
        }
        label459:
        if ((localObject2 instanceof Set)) {
          c.a((SharedPreferences.Editor)localObject1, str2, (Set)localObject2);
        } else if ((localObject2 instanceof Integer)) {
          ((SharedPreferences.Editor)localObject1).putInt(str2, ((Integer)localObject2).intValue());
        } else if ((localObject2 instanceof Long)) {
          ((SharedPreferences.Editor)localObject1).putLong(str2, ((Long)localObject2).longValue());
        } else if ((localObject2 instanceof Float)) {
          ((SharedPreferences.Editor)localObject1).putFloat(str2, ((Float)localObject2).floatValue());
        } else if ((localObject2 instanceof Boolean)) {
          ((SharedPreferences.Editor)localObject1).putBoolean(str2, ((Boolean)localObject2).booleanValue());
        }
      }
      if ((i != 0) && (paramString.isEmpty())) {
        i = 1;
      }
      for (;;)
      {
        paramContentValues.clear();
        AppMethodBeat.o(156342);
        return i;
        switch (j)
        {
        }
        do
        {
          for (;;)
          {
            i = 0;
            break;
            try
            {
              localObject1.getClass().getDeclaredMethod("apply", new Class[0]).invoke(localObject1, new Object[0]);
              k(str1, paramString);
              i = 1;
            }
            catch (IllegalArgumentException paramUri)
            {
              paramUri = new RuntimeException(paramUri);
              AppMethodBeat.o(156342);
              throw paramUri;
            }
            catch (IllegalAccessException paramUri)
            {
              paramUri = new RuntimeException(paramUri);
              AppMethodBeat.o(156342);
              throw paramUri;
            }
            catch (InvocationTargetException paramUri)
            {
              paramUri = new RuntimeException(paramUri);
              AppMethodBeat.o(156342);
              throw paramUri;
            }
            catch (NoSuchMethodException paramUri)
            {
              paramUri = new RuntimeException(paramUri);
              AppMethodBeat.o(156342);
              throw paramUri;
            }
          }
        } while (!((SharedPreferences.Editor)localObject1).commit());
        k(str1, paramString);
        i = 1;
      }
      label791:
      paramString = null;
    }
  }
  
  static final class a
    extends MatrixCursor
  {
    private Bundle mBundle;
    
    public a(Bundle paramBundle)
    {
      super(0);
      AppMethodBeat.i(156306);
      this.mBundle = paramBundle;
      AppMethodBeat.o(156306);
    }
    
    public final Bundle getExtras()
    {
      return this.mBundle;
    }
    
    public final Bundle respond(Bundle paramBundle)
    {
      this.mBundle = paramBundle;
      return this.mBundle;
    }
  }
  
  public final class b
    implements SharedPreferences.Editor
  {
    private final Map<String, Object> GsH;
    private boolean GsI;
    
    public b()
    {
      AppMethodBeat.i(156307);
      this.GsH = new HashMap();
      this.GsI = false;
      AppMethodBeat.o(156307);
    }
    
    private boolean setValue(String paramString)
    {
      AppMethodBeat.i(156317);
      if (MultiProcessSharedPreferences.c(MultiProcessSharedPreferences.this))
      {
        AppMethodBeat.o(156317);
        return false;
      }
      synchronized (MultiProcessSharedPreferences.this)
      {
        MultiProcessSharedPreferences.a(MultiProcessSharedPreferences.this, MultiProcessSharedPreferences.d(MultiProcessSharedPreferences.this));
        int i = MultiProcessSharedPreferences.e(MultiProcessSharedPreferences.this);
        boolean bool = this.GsI;
        try
        {
          paramString = Uri.withAppendedPath(Uri.withAppendedPath(MultiProcessSharedPreferences.eVD(), MultiProcessSharedPreferences.a(MultiProcessSharedPreferences.this)), paramString);
          ContentValues localContentValues = MultiProcessSharedPreferences.c.n((HashMap)this.GsH);
          if (MultiProcessSharedPreferences.d(MultiProcessSharedPreferences.this).getContentResolver().update(paramString, localContentValues, null, new String[] { String.valueOf(i), String.valueOf(bool) }) > 0) {}
          for (bool = true;; bool = false) {
            return bool;
          }
          paramString = finally;
        }
        finally
        {
          AppMethodBeat.o(156317);
        }
      }
    }
    
    public final void apply()
    {
      AppMethodBeat.i(156315);
      setValue("apply");
      AppMethodBeat.o(156315);
    }
    
    public final SharedPreferences.Editor clear()
    {
      try
      {
        this.GsI = true;
        return this;
      }
      finally {}
    }
    
    public final boolean commit()
    {
      AppMethodBeat.i(156316);
      boolean bool = setValue("commit");
      AppMethodBeat.o(156316);
      return bool;
    }
    
    public final SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(156313);
      try
      {
        this.GsH.put(paramString, Boolean.valueOf(paramBoolean));
        return this;
      }
      finally
      {
        AppMethodBeat.o(156313);
      }
    }
    
    public final SharedPreferences.Editor putFloat(String paramString, float paramFloat)
    {
      AppMethodBeat.i(156312);
      try
      {
        this.GsH.put(paramString, Float.valueOf(paramFloat));
        return this;
      }
      finally
      {
        AppMethodBeat.o(156312);
      }
    }
    
    public final SharedPreferences.Editor putInt(String paramString, int paramInt)
    {
      AppMethodBeat.i(156310);
      try
      {
        this.GsH.put(paramString, Integer.valueOf(paramInt));
        return this;
      }
      finally
      {
        AppMethodBeat.o(156310);
      }
    }
    
    public final SharedPreferences.Editor putLong(String paramString, long paramLong)
    {
      AppMethodBeat.i(156311);
      try
      {
        this.GsH.put(paramString, Long.valueOf(paramLong));
        return this;
      }
      finally
      {
        AppMethodBeat.o(156311);
      }
    }
    
    public final SharedPreferences.Editor putString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(156308);
      try
      {
        this.GsH.put(paramString1, paramString2);
        return this;
      }
      finally
      {
        AppMethodBeat.o(156308);
      }
    }
    
    /* Error */
    public final SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
    {
      // Byte code:
      //   0: ldc 155
      //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: monitorenter
      //   7: aload_0
      //   8: getfield 35	com/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences$b:GsH	Ljava/util/Map;
      //   11: astore_3
      //   12: aload_2
      //   13: ifnonnull +23 -> 36
      //   16: aconst_null
      //   17: astore_2
      //   18: aload_3
      //   19: aload_1
      //   20: aload_2
      //   21: invokeinterface 125 3 0
      //   26: pop
      //   27: aload_0
      //   28: monitorexit
      //   29: ldc 155
      //   31: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   34: aload_0
      //   35: areturn
      //   36: new 157	java/util/HashSet
      //   39: dup
      //   40: aload_2
      //   41: invokespecial 160	java/util/HashSet:<init>	(Ljava/util/Collection;)V
      //   44: astore_2
      //   45: goto -27 -> 18
      //   48: astore_1
      //   49: aload_0
      //   50: monitorexit
      //   51: ldc 155
      //   53: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   56: aload_1
      //   57: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	58	0	this	b
      //   0	58	1	paramString	String
      //   0	58	2	paramSet	Set<String>
      //   11	8	3	localMap	Map
      // Exception table:
      //   from	to	target	type
      //   7	12	48	finally
      //   18	29	48	finally
      //   36	45	48	finally
      //   49	51	48	finally
    }
    
    public final SharedPreferences.Editor remove(String paramString)
    {
      AppMethodBeat.i(156314);
      try
      {
        this.GsH.put(paramString, null);
        return this;
      }
      finally
      {
        AppMethodBeat.o(156314);
      }
    }
  }
  
  static final class c
  {
    public static SharedPreferences.Editor a(SharedPreferences.Editor paramEditor, String paramString, Set<String> paramSet)
    {
      AppMethodBeat.i(156319);
      try
      {
        paramEditor = (SharedPreferences.Editor)paramEditor.getClass().getDeclaredMethod("putStringSet", new Class[] { String.class, Set.class }).invoke(paramEditor, new Object[] { paramString, paramSet });
        AppMethodBeat.o(156319);
        return paramEditor;
      }
      catch (IllegalArgumentException paramEditor)
      {
        paramEditor = new RuntimeException(paramEditor);
        AppMethodBeat.o(156319);
        throw paramEditor;
      }
      catch (IllegalAccessException paramEditor)
      {
        paramEditor = new RuntimeException(paramEditor);
        AppMethodBeat.o(156319);
        throw paramEditor;
      }
      catch (InvocationTargetException paramEditor)
      {
        paramEditor = new RuntimeException(paramEditor);
        AppMethodBeat.o(156319);
        throw paramEditor;
      }
      catch (NoSuchMethodException paramEditor)
      {
        paramEditor = new RuntimeException(paramEditor);
        AppMethodBeat.o(156319);
        throw paramEditor;
      }
    }
    
    public static ContentValues n(HashMap<String, Object> paramHashMap)
    {
      AppMethodBeat.i(156318);
      try
      {
        Constructor localConstructor = ContentValues.class.getDeclaredConstructor(new Class[] { HashMap.class });
        localConstructor.setAccessible(true);
        paramHashMap = (ContentValues)localConstructor.newInstance(new Object[] { paramHashMap });
        AppMethodBeat.o(156318);
        return paramHashMap;
      }
      catch (IllegalArgumentException paramHashMap)
      {
        paramHashMap = new RuntimeException(paramHashMap);
        AppMethodBeat.o(156318);
        throw paramHashMap;
      }
      catch (IllegalAccessException paramHashMap)
      {
        paramHashMap = new RuntimeException(paramHashMap);
        AppMethodBeat.o(156318);
        throw paramHashMap;
      }
      catch (InvocationTargetException paramHashMap)
      {
        paramHashMap = new RuntimeException(paramHashMap);
        AppMethodBeat.o(156318);
        throw paramHashMap;
      }
      catch (NoSuchMethodException paramHashMap)
      {
        paramHashMap = new RuntimeException(paramHashMap);
        AppMethodBeat.o(156318);
        throw paramHashMap;
      }
      catch (InstantiationException paramHashMap)
      {
        paramHashMap = new RuntimeException(paramHashMap);
        AppMethodBeat.o(156318);
        throw paramHashMap;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences
 * JD-Core Version:    0.7.0.1
 */