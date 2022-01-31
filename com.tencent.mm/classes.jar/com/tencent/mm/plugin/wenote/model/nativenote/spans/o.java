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
  protected final ArrayList<Object> a(Spannable paramSpannable, e parame, s params)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments();
    if (localObject1 == null) {
      return null;
    }
    localObject1 = (Class)localObject1[(localObject1.length - 1)];
    localObject1 = paramSpannable.getSpans(parame.aiH, parame.Eo, (Class)localObject1);
    int j = localObject1.length;
    int i = 0;
    if (i < j)
    {
      Object localObject2 = localObject1[i];
      int n = paramSpannable.getSpanStart(localObject2);
      int k = paramSpannable.getSpanEnd(localObject2);
      int m = parame.aiH;
      int i1 = parame.Eo;
      int i2 = Math.max(n, m);
      int i3 = Math.min(k, i1);
      boolean bool;
      if (i2 > i3) {
        bool = false;
      }
      for (;;)
      {
        if (bool) {
          localArrayList.add(localObject2);
        }
        i += 1;
        break;
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
          if ((n == m) && (k == i1) && (m == i1)) {
            bool = true;
          } else {
            bool = false;
          }
        }
        else
        {
          n = paramSpannable.getSpanFlags(localObject2) & 0x33;
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
  
  protected final void a(Spannable paramSpannable, n paramn, p paramp)
  {
    paramp.a(a(paramSpannable, paramn, s.rKV), paramn);
  }
  
  public abstract void a(WXRTEditText paramWXRTEditText, e parame, V paramV);
  
  public final void a(WXRTEditText paramWXRTEditText, V paramV)
  {
    e locale = paramWXRTEditText.getParagraphsInSelection();
    if ((paramWXRTEditText.rIy) && (paramWXRTEditText.getSelection().aiH == locale.aiH) && (locale.aiH > 1))
    {
      Object localObject1 = a(paramWXRTEditText.getText(), locale, s.rKW);
      if ((!((ArrayList)localObject1).isEmpty()) && (paramWXRTEditText.getLayout().getPrimaryHorizontal(paramWXRTEditText.getSelection().aiH) == b.chW()))
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((Iterator)localObject1).next();
          paramWXRTEditText.getText().removeSpan(localObject2);
        }
        paramWXRTEditText.getText().insert(locale.aiH - 1, "\n");
      }
    }
    a(paramWXRTEditText, locale, paramV);
    u.a(paramWXRTEditText, new t[] { this });
  }
  
  protected final e p(WXRTEditText paramWXRTEditText)
  {
    return paramWXRTEditText.getParagraphsInSelection();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.spans.o
 * JD-Core Version:    0.7.0.1
 */