package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class y
{
  List<b> afLH;
  WeakReference<EditText> afLI;
  ArrayList<String> afLJ;
  boolean afLK;
  String mText;
  
  public y(EditText paramEditText)
  {
    AppMethodBeat.i(143290);
    this.afLI = new WeakReference(paramEditText);
    AppMethodBeat.o(143290);
  }
  
  private static SpannableString a(Context paramContext, String paramString, Paint paramPaint)
  {
    AppMethodBeat.i(143293);
    SpannableString localSpannableString = new SpannableString(paramString);
    localSpannableString.setSpan(new ImageSpan(new y.a(paramContext, paramString, paramPaint), 0), 0, paramString.length(), 33);
    AppMethodBeat.o(143293);
    return localSpannableString;
  }
  
  static boolean a(EditText paramEditText, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(143292);
    String str = paramEditText.getText().toString();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Object localObject = r(str, paramArrayList);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      int i = paramEditText.getSelectionStart();
      int j = paramEditText.getSelectionEnd();
      paramArrayList = paramEditText.getContext();
      TextPaint localTextPaint = paramEditText.getPaint();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        int k = localb.start;
        int m = localb.length;
        if ((k < 0) || (m <= 0) || (k + m > str.length())) {
          Log.i("MicroMsg.WordsChecker", "start : %d, length : %d.", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
        } else if (localb.afLN) {
          localSpannableStringBuilder.append(a(paramArrayList, str.substring(k, k + m), localTextPaint));
        } else {
          localSpannableStringBuilder.append(str.substring(k, k + m));
        }
      }
      if (localSpannableStringBuilder.length() > 0)
      {
        paramEditText.setText(localSpannableStringBuilder);
        paramEditText.setTextKeepState(localSpannableStringBuilder);
        if ((i == j) && (i >= 0)) {
          paramEditText.setSelection(i);
        }
      }
      AppMethodBeat.o(143292);
      return true;
    }
    AppMethodBeat.o(143292);
    return false;
  }
  
  static List<b> r(String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(143294);
    if ((Util.isNullOrNil(paramString)) || (paramArrayList == null) || (paramArrayList.size() == 0))
    {
      AppMethodBeat.o(143294);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int m = paramString.length();
    int j = 0;
    int i;
    int k;
    if (j <= m)
    {
      Iterator localIterator = paramArrayList.iterator();
      i = 0;
      k = m;
      label65:
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!Util.isNullOrNil(str))
        {
          int n = paramString.indexOf(str, j);
          if ((n < 0) || ((n >= k) && ((n != k) || (str.length() <= i)))) {
            break label241;
          }
          i = str.length();
          k = n;
        }
      }
    }
    label241:
    for (;;)
    {
      break label65;
      if (k < m)
      {
        if (k > j) {
          localArrayList.add(new b(j, k - j, false));
        }
        localArrayList.add(new b(k, i, true));
        j = k + i;
        break;
      }
      if (k > j) {
        localArrayList.add(new b(j, k - j, false));
      }
      AppMethodBeat.o(143294);
      return localArrayList;
    }
  }
  
  final b aEe(int paramInt)
  {
    AppMethodBeat.i(143291);
    if (this.afLH != null)
    {
      Iterator localIterator = this.afLH.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if ((paramInt <= localb.start + localb.length) && (paramInt > localb.start))
        {
          AppMethodBeat.o(143291);
          return localb;
        }
      }
    }
    AppMethodBeat.o(143291);
    return null;
  }
  
  static final class b
  {
    boolean afLN;
    int length;
    int start;
    
    b(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.start = paramInt1;
      this.length = paramInt2;
      this.afLN = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.tools.y
 * JD-Core Version:    0.7.0.1
 */