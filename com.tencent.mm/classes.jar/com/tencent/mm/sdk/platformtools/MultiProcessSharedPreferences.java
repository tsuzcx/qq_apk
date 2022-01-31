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

public class MultiProcessSharedPreferences
  extends ContentProvider
  implements SharedPreferences
{
  private static String AUTHORITY;
  private static volatile Uri AUTHORITY_URI;
  private BroadcastReceiver hWU;
  private Context mContext;
  private List<SoftReference<SharedPreferences.OnSharedPreferenceChangeListener>> mListeners;
  private int mMode;
  private String mName;
  private boolean ugY;
  private UriMatcher ugZ;
  private Map<String, Integer> uha;
  
  public MultiProcessSharedPreferences() {}
  
  private MultiProcessSharedPreferences(Context paramContext, String paramString, int paramInt)
  {
    this.mContext = paramContext;
    this.mName = paramString;
    this.mMode = paramInt;
    this.ugY = paramContext.getPackageManager().isSafeMode();
  }
  
  private static String Zr(String paramString)
  {
    return String.format("%1$s_%2$s", new Object[] { MultiProcessSharedPreferences.class.getName(), paramString });
  }
  
  private Object c(String paramString1, String paramString2, Object paramObject)
  {
    Object localObject2 = null;
    Bundle localBundle = null;
    Object localObject1 = null;
    Object localObject3 = null;
    if (this.ugY)
    {
      paramString2 = (String)localObject3;
      return paramString2;
    }
    fE(this.mContext);
    localObject3 = Uri.withAppendedPath(Uri.withAppendedPath(AUTHORITY_URI, this.mName), paramString1);
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
        label145:
        break label145;
      }
      ((Cursor)localObject3).close();
      paramString2 = paramString1;
      if (paramString1 != null) {
        break;
      }
      return paramObject;
    }
  }
  
  private void cru()
  {
    if (this.uha == null) {
      this.uha = new HashMap();
    }
  }
  
  private void fE(Context paramContext)
  {
    if (AUTHORITY_URI == null)
    {
      String str = null;
      Uri localUri2 = AUTHORITY_URI;
      Uri localUri1 = localUri2;
      if (localUri2 == null) {}
      try
      {
        str = fF(paramContext);
        localUri1 = Uri.parse("content://" + str);
        if (str == null) {
          throw new IllegalArgumentException("'AUTHORITY' initialize failed.");
        }
      }
      finally {}
      AUTHORITY = str;
      AUTHORITY_URI = localUri1;
    }
  }
  
  private static String fF(Context paramContext)
  {
    Object localObject2 = null;
    try
    {
      localObject1 = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 8);
      paramContext = localObject2;
      if (localObject1 != null)
      {
        paramContext = localObject2;
        if (((PackageInfo)localObject1).providers != null)
        {
          localObject1 = ((PackageInfo)localObject1).providers;
          int j = localObject1.length;
          i = 0;
          paramContext = localObject2;
          if (i < j)
          {
            paramContext = localObject1[i];
            if (!paramContext.name.equals(MultiProcessSharedPreferences.class.getName())) {
              break label84;
            }
            paramContext = paramContext.authority;
          }
        }
      }
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        int i;
        Object localObject1 = null;
        continue;
        label84:
        i += 1;
      }
    }
  }
  
  public static SharedPreferences getSharedPreferences(Context paramContext, String paramString, int paramInt)
  {
    return new MultiProcessSharedPreferences(paramContext, paramString, paramInt);
  }
  
  private void j(String paramString, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      Intent localIntent = new Intent();
      localIntent.setAction(Zr(paramString));
      localIntent.setPackage(getContext().getPackageName());
      localIntent.putExtra("name", paramString);
      localIntent.putExtra("value", paramArrayList);
      getContext().sendBroadcast(localIntent);
    }
  }
  
  public boolean contains(String paramString)
  {
    paramString = (Boolean)c("contains", paramString, null);
    if (paramString != null) {
      return paramString.booleanValue();
    }
    return false;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("No external delete");
  }
  
  public SharedPreferences.Editor edit()
  {
    return new b();
  }
  
  public Map<String, ?> getAll()
  {
    return (Map)c("getAll", null, null);
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    paramString = (Boolean)c("getBoolean", paramString, Boolean.valueOf(paramBoolean));
    if (paramString != null) {
      paramBoolean = paramString.booleanValue();
    }
    return paramBoolean;
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    paramString = (Float)c("getFloat", paramString, Float.valueOf(paramFloat));
    if (paramString != null) {
      paramFloat = paramString.floatValue();
    }
    return paramFloat;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    paramString = (Integer)c("getInt", paramString, Integer.valueOf(paramInt));
    if (paramString != null) {
      paramInt = paramString.intValue();
    }
    return paramInt;
  }
  
  public long getLong(String paramString, long paramLong)
  {
    paramString = (Long)c("getLong", paramString, Long.valueOf(paramLong));
    if (paramString != null) {
      paramLong = paramString.longValue();
    }
    return paramLong;
  }
  
  public String getString(String paramString1, String paramString2)
  {
    paramString1 = (String)c("getString", paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1;
    }
    return paramString2;
  }
  
  public Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    for (;;)
    {
      try
      {
        paramString = (Set)c("getString", paramString, paramSet);
        if (paramString != null) {
          return paramString;
        }
      }
      finally {}
      paramString = paramSet;
    }
  }
  
  public String getType(Uri paramUri)
  {
    throw new UnsupportedOperationException("No external call");
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException("No external insert");
  }
  
  public boolean onCreate()
  {
    fE(getContext());
    this.ugZ = new UriMatcher(-1);
    this.ugZ.addURI(AUTHORITY, "*/getAll", 1);
    this.ugZ.addURI(AUTHORITY, "*/getString", 2);
    this.ugZ.addURI(AUTHORITY, "*/getInt", 3);
    this.ugZ.addURI(AUTHORITY, "*/getLong", 4);
    this.ugZ.addURI(AUTHORITY, "*/getFloat", 5);
    this.ugZ.addURI(AUTHORITY, "*/getBoolean", 6);
    this.ugZ.addURI(AUTHORITY, "*/contains", 7);
    this.ugZ.addURI(AUTHORITY, "*/apply", 8);
    this.ugZ.addURI(AUTHORITY, "*/commit", 9);
    this.ugZ.addURI(AUTHORITY, "*/registerOnSharedPreferenceChangeListener", 10);
    this.ugZ.addURI(AUTHORITY, "*/unregisterOnSharedPreferenceChangeListener", 11);
    return true;
  }
  
  public void onLowMemory()
  {
    if (this.uha != null) {
      this.uha.clear();
    }
    super.onLowMemory();
  }
  
  public void onTrimMemory(int paramInt)
  {
    if (this.uha != null) {
      this.uha.clear();
    }
    super.onTrimMemory(paramInt);
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = false;
    paramString1 = (String)paramUri.getPathSegments().get(0);
    int i = Integer.parseInt(paramArrayOfString2[0]);
    paramString2 = paramArrayOfString2[1];
    paramArrayOfString2 = paramArrayOfString2[2];
    paramArrayOfString1 = new Bundle();
    label381:
    int j;
    switch (this.ugZ.match(paramUri))
    {
    case 8: 
    case 9: 
    default: 
      throw new IllegalArgumentException("This is Unknown Uri：" + paramUri);
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
        return new a(paramArrayOfString1);
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
      cru();
      paramUri = (Integer)this.uha.get(paramString1);
      if (paramUri == null)
      {
        i = 0;
        j = i + 1;
        this.uha.put(paramString1, Integer.valueOf(j));
        paramUri = (Integer)this.uha.get(paramString1);
        if (paramUri != null) {
          break label458;
        }
      }
      label458:
      for (i = 0;; i = paramUri.intValue())
      {
        bool1 = bool2;
        if (j == i) {
          bool1 = true;
        }
        paramArrayOfString1.putBoolean("value", bool1);
        break;
        i = paramUri.intValue();
        break label381;
      }
    }
    cru();
    paramUri = (Integer)this.uha.get(paramString1);
    if (paramUri == null)
    {
      i = 0;
      label492:
      j = i - 1;
      if (j > 0) {
        break label553;
      }
      this.uha.remove(paramString1);
      if (this.uha.containsKey(paramString1)) {
        break label547;
      }
    }
    for (;;)
    {
      paramArrayOfString1.putBoolean("value", bool1);
      break;
      i = paramUri.intValue();
      break label492;
      label547:
      bool1 = false;
    }
    label553:
    this.uha.put(paramString1, Integer.valueOf(j));
    paramUri = (Integer)this.uha.get(paramString1);
    if (paramUri == null)
    {
      i = 0;
      label590:
      if (j != i) {
        break label621;
      }
    }
    label621:
    for (bool1 = bool3;; bool1 = false)
    {
      paramArrayOfString1.putBoolean("value", bool1);
      break;
      i = paramUri.intValue();
      break label590;
    }
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    try
    {
      if (this.mListeners == null) {
        this.mListeners = new ArrayList();
      }
      Boolean localBoolean = (Boolean)c("registerOnSharedPreferenceChangeListener", null, Boolean.valueOf(false));
      if ((localBoolean != null) && (localBoolean.booleanValue()))
      {
        this.mListeners.add(new SoftReference(paramOnSharedPreferenceChangeListener));
        if (this.hWU == null)
        {
          this.hWU = new BroadcastReceiver()
          {
            public final void onReceive(Context paramAnonymousContext, Intent arg2)
            {
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
            }
          };
          this.mContext.registerReceiver(this.hWU, new IntentFilter(Zr(this.mName)));
        }
      }
      return;
    }
    finally {}
  }
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    Object localObject;
    try
    {
      c("unregisterOnSharedPreferenceChangeListener", null, Boolean.valueOf(false));
      if (this.mListeners == null) {
        break label181;
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
    finally {}
    while (paramOnSharedPreferenceChangeListener.hasNext())
    {
      localObject = (SoftReference)paramOnSharedPreferenceChangeListener.next();
      this.mListeners.remove(localObject);
    }
    if ((this.mListeners.isEmpty()) && (this.hWU != null))
    {
      this.mContext.unregisterReceiver(this.hWU);
      this.hWU = null;
      this.mListeners = null;
    }
    label181:
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    String str1 = (String)paramUri.getPathSegments().get(0);
    int i = Integer.parseInt(paramArrayOfString[0]);
    Object localObject1 = getContext().getSharedPreferences(str1, i);
    int j = this.ugZ.match(paramUri);
    switch (j)
    {
    default: 
      throw new IllegalArgumentException("This is Unknown Uri：" + paramUri);
    }
    if ((this.uha != null) && (this.uha.get(str1) != null) && (((Integer)this.uha.get(str1)).intValue() > 0))
    {
      i = 1;
      paramUri = new HashMap();
      if (i == 0) {
        break label747;
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
            break label454;
          }
          ((SharedPreferences.Editor)localObject1).putString(str2, (String)localObject2);
          break;
          if ((i != 0) && (paramUri != null) && ((!paramUri.containsKey(str2)) || ((paramUri.containsKey(str2)) && (!localObject2.equals(paramUri.get(str2)))))) {
            paramString.add(str2);
          }
        }
        label454:
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
              j(str1, paramString);
              i = 1;
            }
            catch (IllegalArgumentException paramUri)
            {
              throw new RuntimeException(paramUri);
            }
            catch (IllegalAccessException paramUri)
            {
              throw new RuntimeException(paramUri);
            }
            catch (InvocationTargetException paramUri)
            {
              throw new RuntimeException(paramUri);
            }
            catch (NoSuchMethodException paramUri)
            {
              throw new RuntimeException(paramUri);
            }
          }
        } while (!((SharedPreferences.Editor)localObject1).commit());
        j(str1, paramString);
        i = 1;
      }
      label747:
      paramString = null;
    }
  }
  
  private static final class a
    extends MatrixCursor
  {
    private Bundle BX;
    
    public a(Bundle paramBundle)
    {
      super(0);
      this.BX = paramBundle;
    }
    
    public final Bundle getExtras()
    {
      return this.BX;
    }
    
    public final Bundle respond(Bundle paramBundle)
    {
      this.BX = paramBundle;
      return this.BX;
    }
  }
  
  public final class b
    implements SharedPreferences.Editor
  {
    private final Map<String, Object> ugN = new HashMap();
    private boolean ugO = false;
    
    public b() {}
    
    /* Error */
    private boolean setValue(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 20	com/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences$b:uhb	Lcom/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences;
      //   4: invokestatic 37	com/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences:c	(Lcom/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences;)Z
      //   7: ifeq +5 -> 12
      //   10: iconst_0
      //   11: ireturn
      //   12: aload_0
      //   13: getfield 20	com/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences$b:uhb	Lcom/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences;
      //   16: astore 4
      //   18: aload 4
      //   20: monitorenter
      //   21: aload_0
      //   22: getfield 20	com/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences$b:uhb	Lcom/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences;
      //   25: aload_0
      //   26: getfield 20	com/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences$b:uhb	Lcom/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences;
      //   29: invokestatic 41	com/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences:d	(Lcom/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences;)Landroid/content/Context;
      //   32: invokestatic 45	com/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences:a	(Lcom/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences;Landroid/content/Context;)V
      //   35: aload_0
      //   36: getfield 20	com/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences$b:uhb	Lcom/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences;
      //   39: invokestatic 49	com/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences:e	(Lcom/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences;)I
      //   42: istore_2
      //   43: aload_0
      //   44: getfield 30	com/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences$b:ugO	Z
      //   47: istore_3
      //   48: aload_0
      //   49: monitorenter
      //   50: invokestatic 53	com/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences:crv	()Landroid/net/Uri;
      //   53: aload_0
      //   54: getfield 20	com/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences$b:uhb	Lcom/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences;
      //   57: invokestatic 56	com/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences:a	(Lcom/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences;)Ljava/lang/String;
      //   60: invokestatic 62	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
      //   63: aload_1
      //   64: invokestatic 62	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
      //   67: astore_1
      //   68: aload_0
      //   69: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences$b:ugN	Ljava/util/Map;
      //   72: checkcast 25	java/util/HashMap
      //   75: invokestatic 68	com/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences$c:n	(Ljava/util/HashMap;)Landroid/content/ContentValues;
      //   78: astore 5
      //   80: aload_0
      //   81: getfield 20	com/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences$b:uhb	Lcom/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences;
      //   84: invokestatic 41	com/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences:d	(Lcom/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences;)Landroid/content/Context;
      //   87: invokevirtual 74	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
      //   90: aload_1
      //   91: aload 5
      //   93: aconst_null
      //   94: iconst_2
      //   95: anewarray 76	java/lang/String
      //   98: dup
      //   99: iconst_0
      //   100: iload_2
      //   101: invokestatic 80	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   104: aastore
      //   105: dup
      //   106: iconst_1
      //   107: iload_3
      //   108: invokestatic 83	java/lang/String:valueOf	(Z)Ljava/lang/String;
      //   111: aastore
      //   112: invokevirtual 89	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
      //   115: ifle +18 -> 133
      //   118: iconst_1
      //   119: istore_3
      //   120: aload_0
      //   121: monitorexit
      //   122: aload 4
      //   124: monitorexit
      //   125: iload_3
      //   126: ireturn
      //   127: astore_1
      //   128: aload 4
      //   130: monitorexit
      //   131: aload_1
      //   132: athrow
      //   133: iconst_0
      //   134: istore_3
      //   135: goto -15 -> 120
      //   138: astore_1
      //   139: aload_0
      //   140: monitorexit
      //   141: aload_1
      //   142: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	143	0	this	b
      //   0	143	1	paramString	String
      //   42	59	2	i	int
      //   47	88	3	bool	boolean
      //   16	113	4	localMultiProcessSharedPreferences	MultiProcessSharedPreferences
      //   78	14	5	localContentValues	ContentValues
      // Exception table:
      //   from	to	target	type
      //   21	50	127	finally
      //   122	125	127	finally
      //   128	131	127	finally
      //   141	143	127	finally
      //   50	118	138	finally
      //   120	122	138	finally
      //   139	141	138	finally
    }
    
    public final void apply()
    {
      setValue("apply");
    }
    
    public final SharedPreferences.Editor clear()
    {
      try
      {
        this.ugO = true;
        return this;
      }
      finally {}
    }
    
    public final boolean commit()
    {
      return setValue("commit");
    }
    
    public final SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
    {
      try
      {
        this.ugN.put(paramString, Boolean.valueOf(paramBoolean));
        return this;
      }
      finally {}
    }
    
    public final SharedPreferences.Editor putFloat(String paramString, float paramFloat)
    {
      try
      {
        this.ugN.put(paramString, Float.valueOf(paramFloat));
        return this;
      }
      finally {}
    }
    
    public final SharedPreferences.Editor putInt(String paramString, int paramInt)
    {
      try
      {
        this.ugN.put(paramString, Integer.valueOf(paramInt));
        return this;
      }
      finally {}
    }
    
    public final SharedPreferences.Editor putLong(String paramString, long paramLong)
    {
      try
      {
        this.ugN.put(paramString, Long.valueOf(paramLong));
        return this;
      }
      finally {}
    }
    
    public final SharedPreferences.Editor putString(String paramString1, String paramString2)
    {
      try
      {
        this.ugN.put(paramString1, paramString2);
        return this;
      }
      finally {}
    }
    
    /* Error */
    public final SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcessSharedPreferences$b:ugN	Ljava/util/Map;
      //   6: astore_3
      //   7: aload_2
      //   8: ifnonnull +18 -> 26
      //   11: aconst_null
      //   12: astore_2
      //   13: aload_3
      //   14: aload_1
      //   15: aload_2
      //   16: invokeinterface 111 3 0
      //   21: pop
      //   22: aload_0
      //   23: monitorexit
      //   24: aload_0
      //   25: areturn
      //   26: new 138	java/util/HashSet
      //   29: dup
      //   30: aload_2
      //   31: invokespecial 141	java/util/HashSet:<init>	(Ljava/util/Collection;)V
      //   34: astore_2
      //   35: goto -22 -> 13
      //   38: astore_1
      //   39: aload_0
      //   40: monitorexit
      //   41: aload_1
      //   42: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	43	0	this	b
      //   0	43	1	paramString	String
      //   0	43	2	paramSet	Set<String>
      //   6	8	3	localMap	Map
      // Exception table:
      //   from	to	target	type
      //   2	7	38	finally
      //   13	24	38	finally
      //   26	35	38	finally
      //   39	41	38	finally
    }
    
    public final SharedPreferences.Editor remove(String paramString)
    {
      try
      {
        this.ugN.put(paramString, null);
        return this;
      }
      finally {}
    }
  }
  
  private static final class c
  {
    public static SharedPreferences.Editor a(SharedPreferences.Editor paramEditor, String paramString, Set<String> paramSet)
    {
      try
      {
        paramEditor = (SharedPreferences.Editor)paramEditor.getClass().getDeclaredMethod("putStringSet", new Class[] { String.class, Set.class }).invoke(paramEditor, new Object[] { paramString, paramSet });
        return paramEditor;
      }
      catch (IllegalArgumentException paramEditor)
      {
        throw new RuntimeException(paramEditor);
      }
      catch (IllegalAccessException paramEditor)
      {
        throw new RuntimeException(paramEditor);
      }
      catch (InvocationTargetException paramEditor)
      {
        throw new RuntimeException(paramEditor);
      }
      catch (NoSuchMethodException paramEditor)
      {
        throw new RuntimeException(paramEditor);
      }
    }
    
    public static ContentValues n(HashMap<String, Object> paramHashMap)
    {
      try
      {
        Constructor localConstructor = ContentValues.class.getDeclaredConstructor(new Class[] { HashMap.class });
        localConstructor.setAccessible(true);
        paramHashMap = (ContentValues)localConstructor.newInstance(new Object[] { paramHashMap });
        return paramHashMap;
      }
      catch (IllegalArgumentException paramHashMap)
      {
        throw new RuntimeException(paramHashMap);
      }
      catch (IllegalAccessException paramHashMap)
      {
        throw new RuntimeException(paramHashMap);
      }
      catch (InvocationTargetException paramHashMap)
      {
        throw new RuntimeException(paramHashMap);
      }
      catch (NoSuchMethodException paramHashMap)
      {
        throw new RuntimeException(paramHashMap);
      }
      catch (InstantiationException paramHashMap)
      {
        throw new RuntimeException(paramHashMap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences
 * JD-Core Version:    0.7.0.1
 */