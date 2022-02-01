import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBFixed64Field;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBPrimitiveField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSFixed32Field;
import com.tencent.mobileqq.pb.PBSFixed64Field;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBSInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class acqx
{
  /* Error */
  private static MessageMicro a(MessageMicro paramMessageMicro, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +27 -> 28
    //   4: aload_0
    //   5: invokevirtual 18	java/lang/Object:getClass	()Ljava/lang/Class;
    //   8: invokestatic 22	acqx:c	(Ljava/lang/Class;)Z
    //   11: ifeq +17 -> 28
    //   14: aload_1
    //   15: ifnull +13 -> 28
    //   18: getstatic 28	org/json/JSONObject:NULL	Ljava/lang/Object;
    //   21: aload_1
    //   22: invokevirtual 32	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   25: ifeq +12 -> 37
    //   28: ldc 34
    //   30: ldc 36
    //   32: invokestatic 42	acqy:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aconst_null
    //   36: areturn
    //   37: aload_0
    //   38: invokevirtual 18	java/lang/Object:getClass	()Ljava/lang/Class;
    //   41: invokevirtual 48	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   44: astore_0
    //   45: aload_1
    //   46: invokevirtual 52	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   49: astore_3
    //   50: aload_3
    //   51: invokeinterface 58 1 0
    //   56: ifeq +233 -> 289
    //   59: ldc 60
    //   61: aload_3
    //   62: invokeinterface 63 1 0
    //   67: invokevirtual 67	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   70: checkcast 60	java/lang/String
    //   73: astore 5
    //   75: aload 5
    //   77: invokestatic 73	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   80: ifeq +35 -> 115
    //   83: ldc 34
    //   85: ldc 75
    //   87: invokestatic 42	acqy:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: goto -40 -> 50
    //   93: astore_0
    //   94: ldc 34
    //   96: ldc 77
    //   98: aload_0
    //   99: invokestatic 80	acqy:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   102: aconst_null
    //   103: areturn
    //   104: astore_0
    //   105: ldc 34
    //   107: ldc 77
    //   109: aload_0
    //   110: invokestatic 80	acqy:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   113: aconst_null
    //   114: areturn
    //   115: aload_1
    //   116: aload 5
    //   118: invokevirtual 84	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   121: astore 4
    //   123: aload 4
    //   125: ifnull -75 -> 50
    //   128: getstatic 28	org/json/JSONObject:NULL	Ljava/lang/Object;
    //   131: aload 4
    //   133: invokevirtual 32	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   136: ifne -86 -> 50
    //   139: aload_0
    //   140: invokevirtual 18	java/lang/Object:getClass	()Ljava/lang/Class;
    //   143: aload 5
    //   145: invokevirtual 88	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   148: astore 6
    //   150: aload 6
    //   152: invokevirtual 93	java/lang/reflect/Field:isAccessible	()Z
    //   155: istore_2
    //   156: aload 6
    //   158: iconst_1
    //   159: invokevirtual 97	java/lang/reflect/Field:setAccessible	(Z)V
    //   162: aload 6
    //   164: aload_0
    //   165: invokevirtual 99	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   168: astore 5
    //   170: aload 6
    //   172: iload_2
    //   173: invokevirtual 97	java/lang/reflect/Field:setAccessible	(Z)V
    //   176: aload 5
    //   178: instanceof 101
    //   181: ifne +55 -> 236
    //   184: ldc 34
    //   186: ldc 75
    //   188: invokestatic 42	acqy:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: goto -141 -> 50
    //   194: astore 4
    //   196: ldc 34
    //   198: ldc 77
    //   200: aload 4
    //   202: invokestatic 80	acqy:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   205: goto -155 -> 50
    //   208: astore 4
    //   210: ldc 34
    //   212: ldc 77
    //   214: aload 4
    //   216: invokestatic 80	acqy:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   219: goto -169 -> 50
    //   222: astore 4
    //   224: ldc 34
    //   226: ldc 77
    //   228: aload 4
    //   230: invokestatic 80	acqy:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   233: goto -183 -> 50
    //   236: ldc 101
    //   238: aload 5
    //   240: invokevirtual 67	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   243: checkcast 101	com/tencent/mobileqq/pb/PBField
    //   246: aload 4
    //   248: invokestatic 104	acqx:a	(Lcom/tencent/mobileqq/pb/PBField;Ljava/lang/Object;)Lcom/tencent/mobileqq/pb/PBField;
    //   251: astore 4
    //   253: aload 4
    //   255: ifnonnull +13 -> 268
    //   258: ldc 34
    //   260: ldc 75
    //   262: invokestatic 42	acqy:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   265: goto -215 -> 50
    //   268: aload 5
    //   270: aload 4
    //   272: invokestatic 106	acqx:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   275: aload 5
    //   277: invokevirtual 18	java/lang/Object:getClass	()Ljava/lang/Class;
    //   280: invokestatic 109	acqx:a	(Ljava/lang/Class;)Ljava/lang/Class;
    //   283: invokestatic 112	acqx:a	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Class;)V
    //   286: goto -236 -> 50
    //   289: aload_0
    //   290: instanceof 114
    //   293: ifeq +13 -> 306
    //   296: ldc 114
    //   298: aload_0
    //   299: invokevirtual 67	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   302: checkcast 114	com/tencent/mobileqq/pb/MessageMicro
    //   305: areturn
    //   306: ldc 34
    //   308: ldc 75
    //   310: invokestatic 42	acqy:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   313: aconst_null
    //   314: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	paramMessageMicro	MessageMicro
    //   0	315	1	paramJSONObject	JSONObject
    //   155	18	2	bool	boolean
    //   49	13	3	localIterator	Iterator
    //   121	11	4	localObject1	Object
    //   194	7	4	localJSONException	JSONException
    //   208	7	4	localNoSuchFieldException	NoSuchFieldException
    //   222	25	4	localIllegalAccessException	IllegalAccessException
    //   251	20	4	localPBField	PBField
    //   73	203	5	localObject2	Object
    //   148	23	6	localField	Field
    // Exception table:
    //   from	to	target	type
    //   37	45	93	java/lang/InstantiationException
    //   37	45	104	java/lang/IllegalAccessException
    //   115	123	194	org/json/JSONException
    //   139	176	208	java/lang/NoSuchFieldException
    //   139	176	222	java/lang/IllegalAccessException
  }
  
  public static PBField a(PBField paramPBField, Object paramObject)
  {
    if ((paramPBField == null) || (paramPBField.getClass() == PBBytesField.class) || (paramObject == null) || (JSONObject.NULL.equals(paramObject)))
    {
      acqy.d("GdtJsonPbUtil", "pbFromJson error");
      return null;
    }
    if (a(paramPBField.getClass())) {
      return a((PBPrimitiveField)PBPrimitiveField.class.cast(paramPBField), paramObject);
    }
    if ((b(paramPBField.getClass())) && ((paramObject instanceof JSONArray))) {
      return a(paramPBField, (JSONArray)JSONArray.class.cast(paramObject));
    }
    if ((c(paramPBField.getClass())) && ((paramObject instanceof JSONObject))) {
      return a((MessageMicro)MessageMicro.class.cast(paramPBField), (JSONObject)JSONObject.class.cast(paramObject));
    }
    acqy.d("GdtJsonPbUtil", "pbFromJson error");
    return null;
  }
  
  private static PBField a(PBField paramPBField, JSONArray paramJSONArray)
  {
    if ((paramPBField == null) || (paramJSONArray == null) || (JSONObject.NULL.equals(paramJSONArray)))
    {
      acqy.d("GdtJsonPbUtil", "pbRepeatFromJsonArray error");
      return null;
    }
    try
    {
      localField = paramPBField.getClass().getDeclaredField("helper");
      bool = localField.isAccessible();
      localField.setAccessible(true);
      paramPBField = localField.get(paramPBField);
    }
    catch (NoSuchFieldException localNoSuchFieldException1)
    {
      for (;;)
      {
        Field localField;
        boolean bool;
        paramPBField = null;
        acqy.d("GdtJsonPbUtil", "getClassOfPBArray", localNoSuchFieldException1);
      }
    }
    catch (IllegalAccessException localIllegalAccessException1)
    {
      for (;;)
      {
        label80:
        paramPBField = null;
        acqy.d("GdtJsonPbUtil", "getClassOfPBArray", localIllegalAccessException1);
        continue;
        if ((!(paramPBField instanceof Class)) || (((Class)paramPBField).getSuperclass() != MessageMicro.class)) {
          break label427;
        }
        try
        {
          paramPBField = ((Class)Class.class.cast(paramPBField)).newInstance();
          if (!(paramPBField instanceof MessageMicro)) {
            break label427;
          }
          paramPBField = (PBField)MessageMicro.class.cast(paramPBField);
        }
        catch (InstantiationException paramPBField)
        {
          for (;;)
          {
            acqy.d("GdtJsonPbUtil", "getClassOfPBArray", paramPBField);
            paramPBField = null;
          }
        }
        catch (IllegalAccessException paramPBField)
        {
          for (;;)
          {
            acqy.d("GdtJsonPbUtil", "getClassOfPBArray", paramPBField);
            paramPBField = null;
          }
        }
      }
      if (a(paramPBField.getClass())) {}
      PBRepeatMessageField localPBRepeatMessageField;
      for (;;)
      {
        try
        {
          Object localObject1 = paramPBField.getClass().getField("__repeatHelper__").get(paramPBField);
          if (!(localObject1 instanceof PBField)) {
            break label421;
          }
          localObject1 = PBField.initRepeat((PBField)PBField.class.cast(localObject1));
          if (localObject1 != null) {
            break;
          }
          acqy.d("GdtJsonPbUtil", "pbRepeatFromJsonArray error");
          return null;
        }
        catch (NoSuchFieldException localNoSuchFieldException2)
        {
          acqy.d("GdtJsonPbUtil", "pbRepeatFromJsonArray", localNoSuchFieldException2);
          Object localObject2 = null;
          continue;
        }
        catch (IllegalAccessException localIllegalAccessException2)
        {
          acqy.d("GdtJsonPbUtil", "pbRepeatFromJsonArray", localIllegalAccessException2);
          localPBRepeatMessageField = null;
          continue;
        }
        if (!c(paramPBField.getClass())) {
          break label415;
        }
        localPBRepeatMessageField = PBField.initRepeatMessage(((MessageMicro)MessageMicro.class.cast(paramPBField)).getClass());
      }
      int i = 0;
      for (;;)
      {
        if (i >= paramJSONArray.length()) {
          break label402;
        }
        try
        {
          Object localObject4 = paramJSONArray.get(i);
          if (localObject4 != null) {
            if (!JSONObject.NULL.equals(localObject4)) {
              break;
            }
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            acqy.d("GdtJsonPbUtil", "pbRepeatFromJsonArray", localJSONException);
            continue;
            a(localPBRepeatMessageField, a(a(paramPBField, localJSONException)));
          }
        }
        i += 1;
      }
      return localPBRepeatMessageField;
    }
    try
    {
      localField.setAccessible(bool);
      if (!(paramPBField instanceof PBField)) {
        break label125;
      }
      paramPBField = (PBField)PBField.class.cast(paramPBField);
    }
    catch (IllegalAccessException localIllegalAccessException3)
    {
      break label113;
    }
    catch (NoSuchFieldException localNoSuchFieldException3)
    {
      break label97;
      Object localObject3 = null;
      break label253;
      localObject3 = null;
      break label253;
      paramPBField = null;
      break label80;
    }
    if (paramPBField == null)
    {
      acqy.d("GdtJsonPbUtil", "pbRepeatFromJsonArray error");
      return null;
    }
  }
  
  private static PBPrimitiveField a(PBPrimitiveField paramPBPrimitiveField, Object paramObject)
  {
    if ((paramPBPrimitiveField == null) || (!a(paramPBPrimitiveField.getClass())) || (paramObject == null) || (JSONObject.NULL.equals(paramObject)))
    {
      acqy.d("GdtJsonPbUtil", "pbFromJsonPrimitive error");
      return null;
    }
    try
    {
      if ((paramPBPrimitiveField instanceof PBBoolField)) {
        paramObject = PBField.initBool(Boolean.parseBoolean(paramObject.toString()));
      }
      for (;;)
      {
        if ((paramObject != null) && (paramObject.getClass() == paramPBPrimitiveField.getClass())) {
          return paramObject;
        }
        acqy.d("GdtJsonPbUtil", "pbFromJsonPrimitive error");
        return null;
        if ((paramPBPrimitiveField instanceof PBDoubleField))
        {
          paramObject = PBField.initDouble(Double.parseDouble(paramObject.toString()));
        }
        else if ((paramPBPrimitiveField instanceof PBEnumField))
        {
          paramObject = PBField.initEnum(Integer.parseInt(paramObject.toString()));
        }
        else if ((paramPBPrimitiveField instanceof PBFixed32Field))
        {
          paramObject = PBField.initFixed32(Integer.parseInt(paramObject.toString()));
        }
        else if ((paramPBPrimitiveField instanceof PBFixed64Field))
        {
          paramObject = PBField.initFixed64(Long.parseLong(paramObject.toString()));
        }
        else if ((paramPBPrimitiveField instanceof PBFloatField))
        {
          paramObject = PBField.initFloat(Float.parseFloat(paramObject.toString()));
        }
        else if ((paramPBPrimitiveField instanceof PBInt32Field))
        {
          paramObject = PBField.initInt32(Integer.parseInt(paramObject.toString()));
        }
        else if ((paramPBPrimitiveField instanceof PBInt64Field))
        {
          paramObject = PBField.initInt64(Long.parseLong(paramObject.toString()));
        }
        else if ((paramPBPrimitiveField instanceof PBSFixed32Field))
        {
          paramObject = PBField.initSFixed32(Integer.parseInt(paramObject.toString()));
        }
        else if ((paramPBPrimitiveField instanceof PBSFixed64Field))
        {
          paramObject = PBField.initSFixed64(Long.parseLong(paramObject.toString()));
        }
        else if ((paramPBPrimitiveField instanceof PBSInt32Field))
        {
          paramObject = PBField.initSInt32(Integer.parseInt(paramObject.toString()));
        }
        else if ((paramPBPrimitiveField instanceof PBSInt64Field))
        {
          paramObject = PBField.initSInt64(Long.parseLong(paramObject.toString()));
        }
        else if (((paramPBPrimitiveField instanceof PBStringField)) && (paramObject.getClass() == String.class))
        {
          paramObject = PBField.initString((String)String.class.cast(paramObject));
        }
        else if ((paramPBPrimitiveField instanceof PBUInt32Field))
        {
          paramObject = PBField.initUInt32(Integer.parseInt(paramObject.toString()));
        }
        else
        {
          if (!(paramPBPrimitiveField instanceof PBUInt64Field)) {
            break;
          }
          paramObject = PBField.initUInt64(Long.parseLong(paramObject.toString()));
        }
      }
    }
    catch (Throwable paramObject)
    {
      for (;;)
      {
        acqy.d("GdtJsonPbUtil", "pbFromJsonPrimitive", paramObject);
        paramObject = null;
      }
    }
    return paramObject;
  }
  
  private static Class a(Class paramClass)
  {
    if (paramClass == null)
    {
      acqy.d("GdtJsonPbUtil", "getValueClassOfPBField error");
      return null;
    }
    try
    {
      paramClass = paramClass.getMethod("get", null).getReturnType();
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      acqy.d("GdtJsonPbUtil", "getValueClassOfPBField", paramClass);
    }
    return null;
  }
  
  public static Object a(PBField paramPBField)
  {
    if (paramPBField == null)
    {
      acqy.d("GdtJsonPbUtil", "pbToJson error");
      return null;
    }
    if (a(paramPBField.getClass())) {
      return a((PBPrimitiveField)PBPrimitiveField.class.cast(paramPBField));
    }
    if (b(paramPBField.getClass())) {
      return a(paramPBField);
    }
    if (c(paramPBField.getClass())) {
      return a((MessageMicro)MessageMicro.class.cast(paramPBField));
    }
    acqy.d("GdtJsonPbUtil", "pbToJson error, " + paramPBField.getClass().getName() + " is not supported");
    return null;
  }
  
  private static Object a(PBPrimitiveField<?> paramPBPrimitiveField)
  {
    Object localObject1;
    if ((paramPBPrimitiveField == null) || ((paramPBPrimitiveField instanceof PBBytesField)) || (!paramPBPrimitiveField.has())) {
      localObject1 = null;
    }
    Object localObject2;
    do
    {
      return localObject1;
      localObject2 = a(paramPBPrimitiveField);
      if (((paramPBPrimitiveField instanceof PBFixed64Field)) || ((paramPBPrimitiveField instanceof PBInt64Field)) || ((paramPBPrimitiveField instanceof PBSFixed64Field)) || ((paramPBPrimitiveField instanceof PBSInt64Field))) {
        break;
      }
      localObject1 = localObject2;
    } while (!(paramPBPrimitiveField instanceof PBUInt64Field));
    if (localObject2 == null) {
      return "";
    }
    try
    {
      paramPBPrimitiveField = String.valueOf(localObject2);
      return paramPBPrimitiveField;
    }
    catch (Throwable paramPBPrimitiveField)
    {
      acqy.d("GdtJsonPbUtil", "pbPrimitiveFieldToJson", paramPBPrimitiveField);
    }
    return "";
  }
  
  private static Object a(Object paramObject)
  {
    if (paramObject == null)
    {
      acqy.d("GdtJsonPbUtil", "getOfPB error");
      return null;
    }
    try
    {
      paramObject = paramObject.getClass().getMethod("get", null).invoke(paramObject, null);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      acqy.d("GdtJsonPbUtil", "getOfPB", paramObject);
    }
    return null;
  }
  
  private static JSONArray a(PBField paramPBField)
  {
    if ((paramPBField == null) || (!b(paramPBField.getClass()))) {
      return null;
    }
    paramPBField = a(paramPBField);
    if (paramPBField == null) {
      return null;
    }
    if (!(paramPBField instanceof List))
    {
      acqy.d("GdtJsonPbUtil", "pbRepeatToJson error");
      return null;
    }
    paramPBField = (List)List.class.cast(paramPBField);
    if (paramPBField == null)
    {
      acqy.d("GdtJsonPbUtil", "pbRepeatToJson error");
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramPBField.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      paramPBField = localObject;
      if ((localObject instanceof PBField)) {
        paramPBField = a((PBField)PBField.class.cast(localObject));
      }
      if ((paramPBField != null) && (!JSONObject.NULL.equals(paramPBField))) {
        localJSONArray.put(paramPBField);
      }
    }
    return localJSONArray;
  }
  
  private static JSONObject a(MessageMicro paramMessageMicro)
  {
    if (paramMessageMicro == null) {}
    Field[] arrayOfField;
    do
    {
      return null;
      arrayOfField = paramMessageMicro.getClass().getDeclaredFields();
    } while (arrayOfField == null);
    JSONObject localJSONObject = new JSONObject();
    int j = arrayOfField.length;
    int i = 0;
    if (i < j)
    {
      Object localObject1 = arrayOfField[i];
      if (!Modifier.isPublic(((Field)localObject1).getModifiers())) {}
      for (;;)
      {
        i += 1;
        break;
        boolean bool = ((Field)localObject1).isAccessible();
        ((Field)localObject1).setAccessible(true);
        String str = ((Field)localObject1).getName();
        Object localObject2;
        try
        {
          localObject2 = ((Field)localObject1).get(paramMessageMicro);
          ((Field)localObject1).setAccessible(bool);
          if (((Modifier.isStatic(((Field)localObject1).getModifiers())) || (Modifier.isFinal(((Field)localObject1).getModifiers()))) && (localObject2 != null) && ((localObject2.getClass() == Integer.TYPE) || (localObject2.getClass() == Integer.class))) {
            continue;
          }
          if ((localObject2 instanceof PBField)) {
            break label179;
          }
          acqy.d("GdtJsonPbUtil", "pbMessagebToJson error");
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          acqy.d("GdtJsonPbUtil", "pbMessagebToJson", localIllegalAccessException);
        }
        continue;
        label179:
        localObject1 = a((PBField)PBField.class.cast(localObject2));
        if ((localObject1 != null) && (!JSONObject.NULL.equals(localObject1))) {
          try
          {
            localJSONObject.put(localIllegalAccessException, localObject1);
          }
          catch (JSONException localJSONException)
          {
            acqy.d("GdtJsonPbUtil", "pbMessagebToJson", localJSONException);
          }
        }
      }
    }
    return localJSONObject;
  }
  
  private static void a(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) || (paramObject2 == null))
    {
      acqy.d("GdtJsonPbUtil", "addOfPB error");
      return;
    }
    Method localMethod = null;
    for (;;)
    {
      try
      {
        if ((paramObject1 instanceof PBRepeatMessageField))
        {
          localMethod = PBRepeatMessageField.class.getDeclaredMethod("add", new Class[] { MessageMicro.class });
          if (localMethod != null) {
            break;
          }
          acqy.d("GdtJsonPbUtil", "addOfPB error");
          return;
        }
      }
      catch (Throwable paramObject1)
      {
        acqy.d("GdtJsonPbUtil", "addOfPB", paramObject1);
        return;
      }
      if ((paramObject1 instanceof PBRepeatField)) {
        localMethod = PBRepeatField.class.getDeclaredMethod("add", new Class[] { Object.class });
      }
    }
    localMethod.invoke(paramObject1, new Object[] { paramObject2 });
  }
  
  private static void a(Object paramObject1, Object paramObject2, Class paramClass)
  {
    if ((paramObject1 == null) || (paramObject2 == null) || (paramClass == null))
    {
      acqy.d("GdtJsonPbUtil", "setOfPB error");
      return;
    }
    try
    {
      paramObject1.getClass().getMethod("set", new Class[] { paramClass }).invoke(paramObject1, new Object[] { paramObject2 });
      return;
    }
    catch (Throwable paramObject1)
    {
      acqy.d("GdtJsonPbUtil", "setOfPB", paramObject1);
    }
  }
  
  private static boolean a(Class paramClass)
  {
    return (paramClass == PBBoolField.class) || (paramClass == PBDoubleField.class) || (paramClass == PBEnumField.class) || (paramClass == PBFixed32Field.class) || (paramClass == PBFixed64Field.class) || (paramClass == PBFloatField.class) || (paramClass == PBInt32Field.class) || (paramClass == PBInt64Field.class) || (paramClass == PBSFixed32Field.class) || (paramClass == PBSFixed64Field.class) || (paramClass == PBSInt32Field.class) || (paramClass == PBSInt64Field.class) || (paramClass == PBStringField.class) || (paramClass == PBUInt32Field.class) || (paramClass == PBUInt64Field.class);
  }
  
  private static boolean b(Class paramClass)
  {
    return (paramClass == PBRepeatField.class) || (paramClass == PBRepeatMessageField.class);
  }
  
  private static boolean c(Class paramClass)
  {
    return (paramClass != null) && (paramClass.getSuperclass() == MessageMicro.class) && (!b(paramClass));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqx
 * JD-Core Version:    0.7.0.1
 */