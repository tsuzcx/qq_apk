package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import android.text.style.CharacterStyle;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class e<V, C extends g<V>>
  extends t<V, C>
{
  private static boolean a(Spannable paramSpannable, com.tencent.mm.plugin.wenote.model.nativenote.manager.e parame, Object paramObject, s params)
  {
    int k = paramSpannable.getSpanStart(paramObject);
    int i = paramSpannable.getSpanEnd(paramObject);
    int j = parame.uG;
    int m = parame.uH;
    int n = Math.max(k, j);
    int i1 = Math.min(i, m);
    if (n > i1) {}
    do
    {
      return false;
      if (n < i1) {
        return true;
      }
      if (((k > j) && (i < m)) || ((j > k) && (m < i))) {
        return true;
      }
    } while (params == s.XBV);
    k = paramSpannable.getSpanFlags(paramObject) & 0x33;
    if (i == j) {
      return d(k, new int[] { 34, 18 });
    }
    return d(k, new int[] { 17, 18 });
  }
  
  protected final ArrayList<Object> a(Spannable paramSpannable, com.tencent.mm.plugin.wenote.model.nativenote.manager.e parame, s params)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    Object[] arrayOfObject = paramSpannable.getSpans(Math.max(0, parame.uG - 1), Math.min(paramSpannable.length(), parame.uH + 1), CharacterStyle.class);
    int j = arrayOfObject.length;
    while (i < j)
    {
      Object localObject = arrayOfObject[i];
      if ((eX(localObject)) && (a(paramSpannable, parame, localObject, params))) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a(WXRTEditText paramWXRTEditText, V paramV)
  {
    com.tencent.mm.plugin.wenote.model.nativenote.manager.e locale = s(paramWXRTEditText);
    int i;
    int j;
    label41:
    Object localObject;
    int k;
    if (locale.isEmpty())
    {
      i = 18;
      paramWXRTEditText = paramWXRTEditText.getText();
      Iterator localIterator = a(paramWXRTEditText, locale, s.XBW).iterator();
      j = i;
      if (!localIterator.hasNext()) {
        break label233;
      }
      localObject = localIterator.next();
      boolean bool = dxr().equals(paramV);
      k = paramWXRTEditText.getSpanStart(localObject);
      i = j;
      if (k < locale.uG)
      {
        if (!bool) {
          break label176;
        }
        locale.nx(locale.uG - k, 0);
        i = 34;
      }
      label116:
      j = paramWXRTEditText.getSpanEnd(localObject);
      if (j > locale.uH)
      {
        if (!bool) {
          break label206;
        }
        locale.nx(0, j - locale.uH);
      }
    }
    for (;;)
    {
      paramWXRTEditText.removeSpan(localObject);
      j = i;
      break label41;
      i = 34;
      break;
      label176:
      dxr();
      paramWXRTEditText.setSpan(iEt(), k, locale.uG, 33);
      i = j;
      break label116;
      label206:
      dxr();
      paramWXRTEditText.setSpan(iEt(), locale.uH, j, 34);
    }
    label233:
    if (paramV != null)
    {
      paramV = iEt();
      if (paramV != null) {
        paramWXRTEditText.setSpan(paramV, locale.uG, locale.uH, j);
      }
    }
  }
  
  protected abstract V dxr();
  
  public abstract boolean eX(Object paramObject);
  
  protected abstract g<V> iEt();
  
  protected final com.tencent.mm.plugin.wenote.model.nativenote.manager.e s(WXRTEditText paramWXRTEditText)
  {
    return new com.tencent.mm.plugin.wenote.model.nativenote.manager.e(paramWXRTEditText);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.e
 * JD-Core Version:    0.7.0.1
 */