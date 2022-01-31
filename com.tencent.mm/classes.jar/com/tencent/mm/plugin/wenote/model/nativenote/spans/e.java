package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import android.text.style.CharacterStyle;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class e<V, C extends g<V>>
  extends t<V, C>
{
  protected final ArrayList<Object> a(Spannable paramSpannable, com.tencent.mm.plugin.wenote.model.nativenote.manager.e parame, s params)
  {
    ArrayList localArrayList = new ArrayList();
    Object[] arrayOfObject = paramSpannable.getSpans(Math.max(0, parame.aiH - 1), Math.min(paramSpannable.length(), parame.Eo + 1), CharacterStyle.class);
    int j = arrayOfObject.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = arrayOfObject[i];
      int n;
      int k;
      int m;
      int i1;
      int i2;
      int i3;
      boolean bool;
      if (bH(localObject))
      {
        n = paramSpannable.getSpanStart(localObject);
        k = paramSpannable.getSpanEnd(localObject);
        m = parame.aiH;
        i1 = parame.Eo;
        i2 = Math.max(n, m);
        i3 = Math.min(k, i1);
        if (i2 <= i3) {
          break label157;
        }
        bool = false;
      }
      for (;;)
      {
        if (bool) {
          localArrayList.add(localObject);
        }
        i += 1;
        break;
        label157:
        if (i2 < i3)
        {
          bool = true;
        }
        else if (((n > m) && (k < i1)) || ((m > n) && (i1 < k)))
        {
          bool = true;
        }
        else if (params == s.rKV)
        {
          bool = false;
        }
        else
        {
          n = paramSpannable.getSpanFlags(localObject) & 0x33;
          if (k == m) {
            bool = d(n, new int[] { 34, 18 });
          } else {
            bool = d(n, new int[] { 17, 18 });
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a(WXRTEditText paramWXRTEditText, V paramV)
  {
    com.tencent.mm.plugin.wenote.model.nativenote.manager.e locale = p(paramWXRTEditText);
    int i;
    int j;
    label41:
    Object localObject;
    int k;
    if (locale.isEmpty())
    {
      i = 18;
      paramWXRTEditText = paramWXRTEditText.getText();
      Iterator localIterator = a(paramWXRTEditText, locale, s.rKW).iterator();
      j = i;
      if (!localIterator.hasNext()) {
        break label233;
      }
      localObject = localIterator.next();
      boolean bool = cja().equals(paramV);
      k = paramWXRTEditText.getSpanStart(localObject);
      i = j;
      if (k < locale.aiH)
      {
        if (!bool) {
          break label176;
        }
        locale.eR(locale.aiH - k, 0);
        i = 34;
      }
      label116:
      j = paramWXRTEditText.getSpanEnd(localObject);
      if (j > locale.Eo)
      {
        if (!bool) {
          break label206;
        }
        locale.eR(0, j - locale.Eo);
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
      cja();
      paramWXRTEditText.setSpan(ciZ(), k, locale.aiH, 33);
      i = j;
      break label116;
      label206:
      cja();
      paramWXRTEditText.setSpan(ciZ(), locale.Eo, j, 34);
    }
    label233:
    if (paramV != null) {
      paramWXRTEditText.setSpan(ciZ(), locale.aiH, locale.Eo, j);
    }
  }
  
  public abstract boolean bH(Object paramObject);
  
  protected abstract g<V> ciZ();
  
  protected abstract V cja();
  
  protected final com.tencent.mm.plugin.wenote.model.nativenote.manager.e p(WXRTEditText paramWXRTEditText)
  {
    return new com.tencent.mm.plugin.wenote.model.nativenote.manager.e(paramWXRTEditText);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.e
 * JD-Core Version:    0.7.0.1
 */