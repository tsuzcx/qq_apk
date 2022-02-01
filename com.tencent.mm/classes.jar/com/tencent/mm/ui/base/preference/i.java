package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class i
{
  private static HashMap<String, Constructor<?>> GfK;
  private static final Class<?>[] GfL;
  private final Object[] mConstructorArgs;
  private final Context mContext;
  
  static
  {
    AppMethodBeat.i(142625);
    GfK = new HashMap();
    GfL = new Class[] { Context.class, AttributeSet.class };
    AppMethodBeat.o(142625);
  }
  
  public i(Context paramContext)
  {
    AppMethodBeat.i(142619);
    this.mConstructorArgs = new Object[2];
    this.mContext = paramContext;
    AppMethodBeat.o(142619);
  }
  
  private Preference a(String paramString1, String paramString2, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(142622);
    Object localObject1 = (Constructor)GfK.get(paramString1);
    if (localObject1 == null) {}
    for (;;)
    {
      try
      {
        ad.d("test", "fuck test mContext:%s", new Object[] { this.mContext.getResources().toString() });
        localObject3 = this.mContext.getClassLoader();
        if (paramString2 != null)
        {
          localObject2 = paramString2 + paramString1;
          localObject2 = ((ClassLoader)localObject3).loadClass((String)localObject2).getConstructor(GfL);
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
        AppMethodBeat.o(142622);
        throw paramString1;
      }
      catch (ClassNotFoundException paramString1)
      {
        AppMethodBeat.o(142622);
        throw paramString1;
      }
      catch (Exception paramString2) {}
      try
      {
        GfK.put(paramString1, localObject2);
        localObject1 = localObject2;
        localObject3 = this.mConstructorArgs;
        localObject3[1] = paramAttributeSet;
        localObject1 = localObject2;
        localObject2 = (Preference)((Constructor)localObject2).newInstance((Object[])localObject3);
        AppMethodBeat.o(142622);
        return localObject2;
      }
      catch (Exception paramString2)
      {
        break label243;
      }
      Object localObject2 = paramString1;
      continue;
      label243:
      if (paramAttributeSet != null) {
        paramString1 = paramAttributeSet.getPositionDescription();
      }
      for (;;)
      {
        paramString1 = new InflateException(paramString1);
        paramString1.initCause(paramString2);
        AppMethodBeat.o(142622);
        throw paramString1;
        if ("(null): Error inflating class ".concat(String.valueOf(localNoSuchMethodException)) != null) {
          paramString1 = localNoSuchMethodException.getClass().getName();
        } else {
          paramString1 = "(null)";
        }
      }
      localObject2 = localNoSuchMethodException;
    }
  }
  
  private void a(XmlPullParser paramXmlPullParser, f paramf)
  {
    AppMethodBeat.i(142621);
    AttributeSet localAttributeSet;
    synchronized (this.mConstructorArgs)
    {
      localAttributeSet = Xml.asAttributeSet(paramXmlPullParser);
      this.mConstructorArgs[0] = this.mContext;
    }
    try
    {
      for (int i = paramXmlPullParser.next(); (i != 2) && (i != 1); i = paramXmlPullParser.next()) {}
      if (i != 2)
      {
        paramf = new InflateException(paramXmlPullParser.getPositionDescription() + ": No start tag found!");
        AppMethodBeat.o(142621);
        throw paramf;
      }
    }
    catch (InflateException paramXmlPullParser)
    {
      AppMethodBeat.o(142621);
      throw paramXmlPullParser;
      paramXmlPullParser = finally;
      AppMethodBeat.o(142621);
      throw paramXmlPullParser;
      d(paramXmlPullParser.getName(), localAttributeSet);
      a(paramXmlPullParser, paramf, localAttributeSet);
      AppMethodBeat.o(142621);
      return;
    }
    catch (XmlPullParserException paramXmlPullParser)
    {
      paramf = new InflateException(paramXmlPullParser.getMessage());
      paramf.initCause(paramXmlPullParser);
      AppMethodBeat.o(142621);
      throw paramf;
    }
    catch (IOException paramf)
    {
      paramXmlPullParser = new InflateException(paramXmlPullParser.getPositionDescription() + ": " + paramf.getMessage());
      paramXmlPullParser.initCause(paramf);
      AppMethodBeat.o(142621);
      throw paramXmlPullParser;
    }
  }
  
  private void a(XmlPullParser paramXmlPullParser, f paramf, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(142624);
    int j = paramXmlPullParser.getDepth();
    int i = paramXmlPullParser.next();
    while (((i != 3) || (paramXmlPullParser.getDepth() > j)) && (i != 1)) {
      if (i != 2)
      {
        i = paramXmlPullParser.next();
      }
      else
      {
        paramf.a(d(paramXmlPullParser.getName(), paramAttributeSet), -1);
        i = paramXmlPullParser.next();
      }
    }
    AppMethodBeat.o(142624);
  }
  
  /* Error */
  private Preference d(String paramString, AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: ldc 193
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iconst_m1
    //   6: aload_1
    //   7: bipush 46
    //   9: invokevirtual 197	java/lang/String:indexOf	(I)I
    //   12: if_icmpne +21 -> 33
    //   15: aload_0
    //   16: aload_1
    //   17: ldc 199
    //   19: aload_2
    //   20: invokespecial 201	com/tencent/mm/ui/base/preference/i:a	(Ljava/lang/String;Ljava/lang/String;Landroid/util/AttributeSet;)Lcom/tencent/mm/ui/base/preference/Preference;
    //   23: astore_3
    //   24: aload_3
    //   25: astore_1
    //   26: ldc 193
    //   28: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_1
    //   32: areturn
    //   33: aload_0
    //   34: aload_1
    //   35: aconst_null
    //   36: aload_2
    //   37: invokespecial 201	com/tencent/mm/ui/base/preference/i:a	(Ljava/lang/String;Ljava/lang/String;Landroid/util/AttributeSet;)Lcom/tencent/mm/ui/base/preference/Preference;
    //   40: astore_3
    //   41: aload_3
    //   42: astore_1
    //   43: goto -17 -> 26
    //   46: astore_1
    //   47: ldc 193
    //   49: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aload_1
    //   53: athrow
    //   54: astore_3
    //   55: new 121	android/view/InflateException
    //   58: dup
    //   59: new 88	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   66: aload_2
    //   67: invokeinterface 117 1 0
    //   72: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc 119
    //   77: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_1
    //   81: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokespecial 124	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   90: astore_1
    //   91: aload_1
    //   92: aload_3
    //   93: invokevirtual 128	android/view/InflateException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   96: pop
    //   97: ldc 193
    //   99: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_1
    //   103: athrow
    //   104: astore_3
    //   105: new 121	android/view/InflateException
    //   108: dup
    //   109: new 88	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   116: aload_2
    //   117: invokeinterface 117 1 0
    //   122: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc 119
    //   127: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_1
    //   131: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokespecial 124	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   140: astore_1
    //   141: aload_1
    //   142: aload_3
    //   143: invokevirtual 128	android/view/InflateException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   146: pop
    //   147: ldc 193
    //   149: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload_1
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	i
    //   0	154	1	paramString	String
    //   0	154	2	paramAttributeSet	AttributeSet
    //   23	19	3	localPreference	Preference
    //   54	39	3	localClassNotFoundException	ClassNotFoundException
    //   104	39	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   5	24	46	android/view/InflateException
    //   33	41	46	android/view/InflateException
    //   5	24	54	java/lang/ClassNotFoundException
    //   33	41	54	java/lang/ClassNotFoundException
    //   5	24	104	java/lang/Exception
    //   33	41	104	java/lang/Exception
  }
  
  public final void a(int paramInt, f paramf)
  {
    AppMethodBeat.i(142620);
    XmlResourceParser localXmlResourceParser = this.mContext.getResources().getXml(paramInt);
    try
    {
      a(localXmlResourceParser, paramf);
      return;
    }
    finally
    {
      localXmlResourceParser.close();
      AppMethodBeat.o(142620);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.i
 * JD-Core Version:    0.7.0.1
 */