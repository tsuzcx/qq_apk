package com.tencent.weui.base.preference;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.InflateException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public final class c
{
  private static HashMap<String, Constructor<?>> vdy = new HashMap();
  private static final Class<?>[] vdz = { Context.class, AttributeSet.class };
  private final Object[] Qd = new Object[2];
  private final Context mContext;
  
  public c(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void a(XmlPullParser paramXmlPullParser, a parama, AttributeSet paramAttributeSet)
  {
    int j = paramXmlPullParser.getDepth();
    int i = paramXmlPullParser.next();
    while (((i != 3) || (paramXmlPullParser.getDepth() > j)) && (i != 1)) {
      if (i != 2)
      {
        i = paramXmlPullParser.next();
      }
      else
      {
        parama.a(b(paramXmlPullParser.getName(), paramAttributeSet));
        i = paramXmlPullParser.next();
      }
    }
  }
  
  private Preference b(String paramString, AttributeSet paramAttributeSet)
  {
    try
    {
      if (-1 == paramString.indexOf('.')) {
        return b(paramString, "android.preference.", paramAttributeSet);
      }
      Preference localPreference = b(paramString, null, paramAttributeSet);
      return localPreference;
    }
    catch (InflateException paramString)
    {
      throw paramString;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      paramString = new InflateException(paramAttributeSet.getPositionDescription() + ": Error inflating class " + paramString);
      paramString.initCause(localClassNotFoundException);
      throw paramString;
    }
    catch (Exception localException)
    {
      paramString = new InflateException(paramAttributeSet.getPositionDescription() + ": Error inflating class " + paramString);
      paramString.initCause(localException);
      throw paramString;
    }
  }
  
  private Preference b(String paramString1, String paramString2, AttributeSet paramAttributeSet)
  {
    Object localObject1 = (Constructor)vdy.get(paramString1);
    if (localObject1 == null) {}
    for (;;)
    {
      try
      {
        localObject3 = this.mContext.getClassLoader();
        if (paramString2 != null)
        {
          localObject2 = paramString2 + paramString1;
          localObject2 = ((ClassLoader)localObject3).loadClass((String)localObject2).getConstructor(vdz);
          localObject1 = localObject2;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Object localObject3;
        localObject2 = new StringBuilder().append(paramAttributeSet.getPositionDescription()).append(": Error inflating class ");
        paramAttributeSet = paramString1;
        if (paramString2 != null) {
          paramAttributeSet = paramString2 + paramString1;
        }
        paramString1 = new InflateException(paramAttributeSet);
        paramString1.initCause(localNoSuchMethodException);
        throw paramString1;
      }
      catch (ClassNotFoundException paramString1)
      {
        throw paramString1;
      }
      catch (Exception paramString2) {}
      try
      {
        vdy.put(paramString1, localObject2);
        localObject1 = localObject2;
        localObject3 = this.Qd;
        localObject3[1] = paramAttributeSet;
        localObject1 = localObject2;
        localObject2 = (Preference)((Constructor)localObject2).newInstance((Object[])localObject3);
        return localObject2;
      }
      catch (Exception paramString2)
      {
        break label199;
      }
      Object localObject2 = paramString1;
      continue;
      label199:
      if (paramAttributeSet != null) {
        paramString1 = paramAttributeSet.getPositionDescription();
      }
      for (;;)
      {
        paramString1 = new InflateException(paramString1);
        paramString1.initCause(paramString2);
        throw paramString1;
        if ("(null): Error inflating class " + localNoSuchMethodException != null) {
          paramString1 = localNoSuchMethodException.getClass().getName();
        } else {
          paramString1 = "(null)";
        }
      }
      localObject2 = localNoSuchMethodException;
    }
  }
  
  /* Error */
  public final void a(int paramInt, a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/tencent/weui/base/preference/c:mContext	Landroid/content/Context;
    //   4: invokevirtual 155	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   7: iload_1
    //   8: invokevirtual 161	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
    //   11: astore_3
    //   12: aload_3
    //   13: ifnonnull +4 -> 17
    //   16: return
    //   17: aload_0
    //   18: getfield 36	com/tencent/weui/base/preference/c:Qd	[Ljava/lang/Object;
    //   21: astore 4
    //   23: aload 4
    //   25: monitorenter
    //   26: aload_3
    //   27: invokestatic 167	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   30: astore 5
    //   32: aload_0
    //   33: getfield 36	com/tencent/weui/base/preference/c:Qd	[Ljava/lang/Object;
    //   36: iconst_0
    //   37: aload_0
    //   38: getfield 38	com/tencent/weui/base/preference/c:mContext	Landroid/content/Context;
    //   41: aastore
    //   42: aload_3
    //   43: invokeinterface 49 1 0
    //   48: istore_1
    //   49: iload_1
    //   50: iconst_2
    //   51: if_icmpeq +18 -> 69
    //   54: iload_1
    //   55: iconst_1
    //   56: if_icmpeq +13 -> 69
    //   59: aload_3
    //   60: invokeinterface 49 1 0
    //   65: istore_1
    //   66: goto -17 -> 49
    //   69: iload_1
    //   70: iconst_2
    //   71: if_icmpeq +53 -> 124
    //   74: new 64	android/view/InflateException
    //   77: dup
    //   78: new 81	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   85: aload_3
    //   86: invokeinterface 168 1 0
    //   91: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc 170
    //   96: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokespecial 97	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   105: athrow
    //   106: astore_2
    //   107: aload_2
    //   108: athrow
    //   109: astore_2
    //   110: aload 4
    //   112: monitorexit
    //   113: aload_2
    //   114: athrow
    //   115: astore_2
    //   116: aload_3
    //   117: invokeinterface 175 1 0
    //   122: aload_2
    //   123: athrow
    //   124: aload_0
    //   125: aload_3
    //   126: invokeinterface 53 1 0
    //   131: aload 5
    //   133: invokespecial 57	com/tencent/weui/base/preference/c:b	(Ljava/lang/String;Landroid/util/AttributeSet;)Landroid/preference/Preference;
    //   136: pop
    //   137: aload_0
    //   138: aload_3
    //   139: aload_2
    //   140: aload 5
    //   142: invokespecial 177	com/tencent/weui/base/preference/c:a	(Lorg/xmlpull/v1/XmlPullParser;Lcom/tencent/weui/base/preference/a;Landroid/util/AttributeSet;)V
    //   145: aload 4
    //   147: monitorexit
    //   148: aload_3
    //   149: invokeinterface 175 1 0
    //   154: return
    //   155: astore_2
    //   156: new 64	android/view/InflateException
    //   159: dup
    //   160: aload_2
    //   161: invokevirtual 180	org/xmlpull/v1/XmlPullParserException:getMessage	()Ljava/lang/String;
    //   164: invokespecial 97	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   167: astore 5
    //   169: aload 5
    //   171: aload_2
    //   172: invokevirtual 101	android/view/InflateException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   175: pop
    //   176: aload 5
    //   178: athrow
    //   179: astore_2
    //   180: new 64	android/view/InflateException
    //   183: dup
    //   184: new 81	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   191: aload_3
    //   192: invokeinterface 168 1 0
    //   197: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc 182
    //   202: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_2
    //   206: invokevirtual 183	java/io/IOException:getMessage	()Ljava/lang/String;
    //   209: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokespecial 97	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   218: astore 5
    //   220: aload 5
    //   222: aload_2
    //   223: invokevirtual 101	android/view/InflateException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   226: pop
    //   227: aload 5
    //   229: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	this	c
    //   0	230	1	paramInt	int
    //   0	230	2	parama	a
    //   11	181	3	localXmlResourceParser	android.content.res.XmlResourceParser
    //   30	198	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   42	49	106	android/view/InflateException
    //   59	66	106	android/view/InflateException
    //   74	106	106	android/view/InflateException
    //   124	145	106	android/view/InflateException
    //   26	42	109	finally
    //   42	49	109	finally
    //   59	66	109	finally
    //   74	106	109	finally
    //   107	109	109	finally
    //   110	113	109	finally
    //   124	145	109	finally
    //   145	148	109	finally
    //   156	179	109	finally
    //   180	230	109	finally
    //   17	26	115	finally
    //   113	115	115	finally
    //   42	49	155	org/xmlpull/v1/XmlPullParserException
    //   59	66	155	org/xmlpull/v1/XmlPullParserException
    //   74	106	155	org/xmlpull/v1/XmlPullParserException
    //   124	145	155	org/xmlpull/v1/XmlPullParserException
    //   42	49	179	java/io/IOException
    //   59	66	179	java/io/IOException
    //   74	106	179	java/io/IOException
    //   124	145	179	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.weui.base.preference.c
 * JD-Core Version:    0.7.0.1
 */