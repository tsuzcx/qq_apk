package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Editable;
import android.text.Layout;
import android.text.Spannable;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class o<V, C extends g<V>>
  extends t<V, C>
{
  private static boolean a(Spannable paramSpannable, e parame, Object paramObject, s params)
  {
    int k = paramSpannable.getSpanStart(paramObject);
    int i = paramSpannable.getSpanEnd(paramObject);
    int j = parame.atr;
    int m = parame.MZ;
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
      if (params != s.CWY) {
        break;
      }
    } while ((k != j) || (i != m) || (j != m));
    return true;
    k = paramSpannable.getSpanFlags(paramObject) & 0x33;
    if (i == j) {
      return e(k, new int[] { 34, 18 });
    }
    return e(k, new int[] { 17, 18 });
  }
  
  protected final ArrayList<Object> a(Spannable paramSpannable, e parame, s params)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments();
    if (localObject1 == null) {
      return null;
    }
    localObject1 = (Class)localObject1[(localObject1.length - 1)];
    localObject1 = paramSpannable.getSpans(parame.atr, parame.MZ, (Class)localObject1);
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (a(paramSpannable, parame, localObject2, params)) {
        localArrayList.add(localObject2);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  protected final void a(Spannable paramSpannable, n paramn, p paramp)
  {
    paramp.a(a(paramSpannable, paramn, s.CWY), paramn);
  }
  
  public abstract void a(WXRTEditText paramWXRTEditText, e parame, V paramV);
  
  public final void a(WXRTEditText paramWXRTEditText, V paramV)
  {
    e locale = paramWXRTEditText.getParagraphsInSelection();
    if ((paramWXRTEditText.oRK) && (paramWXRTEditText.getSelection().atr == locale.atr) && (locale.atr > 1))
    {
      Object localObject1 = a(paramWXRTEditText.getText(), locale, s.CWZ);
      if ((!((ArrayList)localObject1).isEmpty()) && (paramWXRTEditText.getLayout().getPrimaryHorizontal(paramWXRTEditText.getSelection().atr) == b.bZV()))
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((Iterator)localObject1).next();
          paramWXRTEditText.getText().removeSpan(localObject2);
        }
        paramWXRTEditText.getText().insert(locale.atr - 1, "\n");
      }
    }
    a(paramWXRTEditText, locale, paramV);
    u.a(paramWXRTEditText, new t[] { this });
  }
  
  protected final e r(WXRTEditText paramWXRTEditText)
  {
    return paramWXRTEditText.getParagraphsInSelection();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.o
 * JD-Core Version:    0.7.0.1
 */