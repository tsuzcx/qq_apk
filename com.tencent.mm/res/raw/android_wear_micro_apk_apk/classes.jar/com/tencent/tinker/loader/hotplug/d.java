package com.tencent.tinker.loader.hotplug;

import android.content.Context;
import org.xmlpull.v1.XmlPullParser;

abstract class d<T_RESULT>
{
  void a(int paramInt, XmlPullParser paramXmlPullParser) {}
  
  abstract void a(Context paramContext, String paramString1, String paramString2, T_RESULT paramT_RESULT);
  
  final void a(Context paramContext, XmlPullParser paramXmlPullParser, T_RESULT paramT_RESULT)
  {
    int i = 0;
    a(0, paramXmlPullParser);
    int j = paramXmlPullParser.getAttributeCount();
    while (i < j)
    {
      if ("android".equals(paramXmlPullParser.getAttributePrefix(i))) {
        a(paramContext, paramXmlPullParser.getAttributeName(i), paramXmlPullParser.getAttributeValue(i), paramT_RESULT);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.d
 * JD-Core Version:    0.7.0.1
 */