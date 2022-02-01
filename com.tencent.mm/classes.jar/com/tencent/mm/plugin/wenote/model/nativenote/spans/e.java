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
    int j = parame.avj;
    int m = parame.OQ;
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
    } while (params == s.ETq);
    k = paramSpannable.getSpanFlags(paramObject) & 0x33;
    if (i == j) {
      return e(k, new int[] { 34, 18 });
    }
    return e(k, new int[] { 17, 18 });
  }
  
  protected final ArrayList<Object> a(Spannable paramSpannable, com.tencent.mm.plugin.wenote.model.nativenote.manager.e parame, s params)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    Object[] arrayOfObject = paramSpannable.getSpans(Math.max(0, parame.avj - 1), Math.min(paramSpannable.length(), parame.OQ + 1), CharacterStyle.class);
    int j = arrayOfObject.length;
    while (i < j)
    {
      Object localObject = arrayOfObject[i];
      if ((cW(localObject)) && (a(paramSpannable, parame, localObject, params))) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a(WXRTEditText paramWXRTEditText, V paramV)
  {
    com.tencent.mm.plugin.wenote.model.nativenote.manager.e locale = r(paramWXRTEditText);
    int i;
    int j;
    label41:
    Object localObject;
    int k;
    if (locale.isEmpty())
    {
      i = 18;
      paramWXRTEditText = paramWXRTEditText.getText();
      Iterator localIterator = a(paramWXRTEditText, locale, s.ETr).iterator();
      j = i;
      if (!localIterator.hasNext()) {
        break label233;
      }
      localObject = localIterator.next();
      boolean bool = cgE().equals(paramV);
      k = paramWXRTEditText.getSpanStart(localObject);
      i = j;
      if (k < locale.avj)
      {
        if (!bool) {
          break label176;
        }
        locale.jl(locale.avj - k, 0);
        i = 34;
      }
      label116:
      j = paramWXRTEditText.getSpanEnd(localObject);
      if (j > locale.OQ)
      {
        if (!bool) {
          break label206;
        }
        locale.jl(0, j - locale.OQ);
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
      cgE();
      paramWXRTEditText.setSpan(faT(), k, locale.avj, 33);
      i = j;
      break label116;
      label206:
      cgE();
      paramWXRTEditText.setSpan(faT(), locale.OQ, j, 34);
    }
    label233:
    if (paramV != null) {
      paramWXRTEditText.setSpan(faT(), locale.avj, locale.OQ, j);
    }
  }
  
  public abstract boolean cW(Object paramObject);
  
  protected abstract V cgE();
  
  protected abstract g<V> faT();
  
  protected final com.tencent.mm.plugin.wenote.model.nativenote.manager.e r(WXRTEditText paramWXRTEditText)
  {
    return new com.tencent.mm.plugin.wenote.model.nativenote.manager.e(paramWXRTEditText);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.e
 * JD-Core Version:    0.7.0.1
 */