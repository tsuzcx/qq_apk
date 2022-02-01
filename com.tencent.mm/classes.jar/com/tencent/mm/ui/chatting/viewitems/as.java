package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class as
{
  private static final LinearLayout.LayoutParams Xjz;
  
  static
  {
    AppMethodBeat.i(37279);
    Xjz = new LinearLayout.LayoutParams(-1, -2);
    AppMethodBeat.o(37279);
  }
  
  private static boolean a(LinearLayout paramLinearLayout, SpannableString paramSpannableString, List<a> paramList)
  {
    AppMethodBeat.i(37272);
    Log.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "addLines, nodeList size = " + paramList.size());
    int j = paramSpannableString.length();
    paramList = paramList.iterator();
    a locala;
    for (int i = 0; paramList.hasNext(); i = locala.offset)
    {
      locala = (a)paramList.next();
      if (locala.offset > i)
      {
        localTextView = new TextView(paramLinearLayout.getContext());
        localTextView.setText(paramSpannableString.subSequence(i, Math.min(locala.offset, j)));
        localTextView.setLineSpacing(3.0F, 1.0F);
        paramLinearLayout.addView(localTextView, Xjz);
      }
      TextView localTextView = new TextView(paramLinearLayout.getContext());
      localTextView.setText(bzL(locala.XjB));
      localTextView.setSingleLine(true);
      if (locala.oYK != 14) {
        localTextView.setTextSize(locala.oYK);
      }
      if (locala.fWa) {
        localTextView.setTypeface(null, 1);
      }
      if (locala.XjA) {
        localTextView.setPaintFlags(localTextView.getPaintFlags() | 0x8);
      }
      localTextView.setTextColor(ar.iV(locala.color));
      paramLinearLayout.addView(localTextView, Xjz);
    }
    if (i >= j)
    {
      Log.i("MicroMsg.ChattingItemDyeingTemplateDecorator", "addLines, lastOffset >= maxLength, lastOffset = " + i + ", maxLength = " + j);
      AppMethodBeat.o(37272);
      return true;
    }
    paramList = new TextView(paramLinearLayout.getContext());
    paramList.setTextSize(0, a.aY(paramList.getContext(), R.f.HintTextSize));
    paramList.setText(paramSpannableString.subSequence(i, j));
    paramList.setLineSpacing(2.0F, 1.0F);
    paramLinearLayout.addView(paramList, Xjz);
    AppMethodBeat.o(37272);
    return true;
  }
  
  public static boolean a(LinearLayout paramLinearLayout, Map<String, String> paramMap)
  {
    AppMethodBeat.i(37271);
    if (paramLinearLayout == null)
    {
      Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle fail, digestLl is null");
      AppMethodBeat.o(37271);
      return false;
    }
    String str1 = (String)paramMap.get(".msg.appmsg.mmreader.category.item.digest");
    if (Util.isNullOrNil(str1))
    {
      Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle, digest is null");
      paramLinearLayout.setVisibility(8);
      AppMethodBeat.o(37271);
      return false;
    }
    paramLinearLayout.setVisibility(0);
    SpannableString localSpannableString = new SpannableString(str1);
    int i;
    Object localObject2;
    Object localObject3;
    label203:
    Object localObject1;
    try
    {
      localSpannableString.setSpan(new ForegroundColorSpan(paramLinearLayout.getContext().getResources().getColor(R.e.normal_text_color)), 0, localSpannableString.length(), 17);
      i = 0;
      localObject2 = new StringBuilder(".msg.appmsg.mmreader.category.item.styles.style");
      if (i == 0)
      {
        str1 = "";
        localObject2 = str1;
        if (paramMap.containsKey(localObject2)) {
          break label300;
        }
        Log.i("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle end, total style count = ".concat(String.valueOf(i)));
        i = 0;
        localObject2 = new ArrayList();
        localObject3 = new StringBuilder(".msg.appmsg.mmreader.category.item.styles.line");
        if (i != 0) {
          break label968;
        }
        str1 = "";
        str1 = str1;
        if (paramMap.containsKey(str1)) {
          break label977;
        }
        Log.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle end, total line count = ".concat(String.valueOf(i)));
        Collections.sort((List)localObject2);
        paramLinearLayout.removeAllViews();
        a(paramLinearLayout, localSpannableString, (List)localObject2);
        AppMethodBeat.o(37271);
        return true;
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException1)
    {
      for (;;)
      {
        Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle setSpan error: %s", new Object[] { localIndexOutOfBoundsException1.getMessage() });
        continue;
        localObject1 = String.valueOf(i);
      }
      label300:
      localObject1 = b.ag(paramMap, (String)localObject2);
      if (localObject1 != null) {
        break label336;
      }
    }
    Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom fail, skip to next, styleKey = ".concat(String.valueOf(localObject2)));
    for (;;)
    {
      i += 1;
      break;
      label336:
      if (((b)localObject1).XjC < ((b)localObject1).XjD) {
        break label392;
      }
      Log.w("MicroMsg.ChattingItemDyeingTemplateDecorator", "addStyle, no need to add, rangeFrom = " + ((b)localObject1).XjC + ", rangeTo = " + ((b)localObject1).XjD);
    }
    label392:
    int m = ((b)localObject1).XjC;
    int k = ((b)localObject1).XjD;
    int n = ((b)localObject1).oYK;
    boolean bool1 = ((b)localObject1).fWa;
    boolean bool2 = ((b)localObject1).XjA;
    Log.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, rangeFrom = " + m + ", rangeTo = " + k + ", fontSize = " + n + ", isBlack = " + bool1 + ", isUnderLine = " + bool2);
    int j = m;
    if (m < 0)
    {
      Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, params error. length:%d, from:%d, to:%d", new Object[] { Integer.valueOf(localSpannableString.length()), Integer.valueOf(m), Integer.valueOf(k) });
      j = 0;
    }
    if (k > localSpannableString.length())
    {
      Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, params error. length:%d, from:%d, to:%d", new Object[] { Integer.valueOf(localSpannableString.length()), Integer.valueOf(j), Integer.valueOf(k) });
      k = localSpannableString.length();
    }
    for (;;)
    {
      for (;;)
      {
        if (bool1) {}
        try
        {
          localSpannableString.setSpan(new StyleSpan(1), j, k, 17);
          if (!bool2) {}
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException4)
        {
          try
          {
            localSpannableString.setSpan(new UnderlineSpan(), j, k, 17);
            if (n == 14) {}
          }
          catch (IndexOutOfBoundsException localIndexOutOfBoundsException4)
          {
            try
            {
              for (;;)
              {
                for (;;)
                {
                  localSpannableString.setSpan(new AbsoluteSizeSpan(n), j, k, 17);
                  k = ((b)localObject1).XjC;
                  m = ((b)localObject1).XjD;
                  n = ar.iV(((b)localObject1).color);
                  Log.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, rangeFrom = " + k + ", rangeTo = " + m + ", color = " + n);
                  j = k;
                  if (k < 0)
                  {
                    Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, params error. length:%d, from:%d, to:%d", new Object[] { Integer.valueOf(localSpannableString.length()), Integer.valueOf(k), Integer.valueOf(m) });
                    j = 0;
                  }
                  k = m;
                  if (m > localSpannableString.length())
                  {
                    Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, params error. length:%d, from:%d, to:%d", new Object[] { Integer.valueOf(localSpannableString.length()), Integer.valueOf(j), Integer.valueOf(m) });
                    k = localSpannableString.length();
                  }
                  try
                  {
                    localSpannableString.setSpan(new ForegroundColorSpan(n), j, k, 17);
                  }
                  catch (IndexOutOfBoundsException localIndexOutOfBoundsException2)
                  {
                    Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", new Object[] { localIndexOutOfBoundsException2.getMessage() });
                  }
                }
                break;
                localIndexOutOfBoundsException3 = localIndexOutOfBoundsException3;
                Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", new Object[] { localIndexOutOfBoundsException3.getMessage() });
              }
              localIndexOutOfBoundsException4 = localIndexOutOfBoundsException4;
              Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", new Object[] { localIndexOutOfBoundsException4.getMessage() });
            }
            catch (IndexOutOfBoundsException localIndexOutOfBoundsException5)
            {
              for (;;)
              {
                Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", new Object[] { localIndexOutOfBoundsException5.getMessage() });
              }
            }
          }
        }
      }
      label968:
      String str2 = String.valueOf(i);
      break label203;
      label977:
      localObject3 = a.af(paramMap, str2);
      if (localObject3 == null) {
        Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom fail, skip to next, lineKey = ".concat(String.valueOf(str2)));
      }
      for (;;)
      {
        i += 1;
        break;
        localIndexOutOfBoundsException5.add(localObject3);
      }
    }
  }
  
  private static String bzL(String paramString)
  {
    AppMethodBeat.i(37273);
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    while (localStringBuilder.length() < 80) {
      localStringBuilder.append(paramString);
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(37273);
    return paramString;
  }
  
  private static int hP(String paramString, int paramInt)
  {
    AppMethodBeat.i(37274);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(37274);
      return paramInt;
    }
    try
    {
      int i = Color.parseColor(paramString);
      AppMethodBeat.o(37274);
      return i;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom, ex = " + paramString.getMessage());
      AppMethodBeat.o(37274);
    }
    return paramInt;
  }
  
  static final class a
    implements Comparable<a>
  {
    public boolean XjA;
    public String XjB;
    public int color;
    public boolean fWa;
    public int oYK;
    public int offset;
    
    public static a af(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(37268);
      a locala = new a();
      for (;;)
      {
        try
        {
          locala.offset = Util.getInt((String)paramMap.get(paramString + ".offset"), 0);
          str = (String)paramMap.get(paramString + ".font");
          if (Util.isNullOrNil(str))
          {
            Log.d("MicroMsg.LineNode", "parseFrom, font is null, use default value");
            str = "m";
            locala.fWa = as.gS(str);
            locala.XjA = as.acL(str);
            locala.oYK = as.bzM(str);
            str = (String)paramMap.get(paramString + ".color");
            if (!ar.isDarkMode()) {
              break label270;
            }
            i = -855638017;
            locala.color = as.hQ(str, i);
            locala.XjB = ((String)paramMap.get(paramString + ".chars"));
            if (!Util.isNullOrNil(locala.XjB)) {
              break;
            }
            Log.e("MicroMsg.LineNode", "parseFrom fail, chars is null");
            AppMethodBeat.o(37268);
            return null;
          }
        }
        catch (Exception paramMap)
        {
          Log.e("MicroMsg.LineNode", "parseFrom fail, ex = " + paramMap.getMessage());
          AppMethodBeat.o(37268);
          return null;
        }
        String str = str.toLowerCase();
        continue;
        label270:
        int i = -16777216;
      }
      AppMethodBeat.o(37268);
      return locala;
    }
  }
  
  static final class b
  {
    public boolean XjA;
    public int XjC;
    public int XjD;
    public int color;
    public boolean fWa;
    public int oYK;
    
    public static b ag(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(37270);
      Object localObject = (String)paramMap.get(paramString + ".range");
      if (Util.isNullOrNil((String)localObject))
      {
        Log.e("MicroMsg.StyleNode", "parseFrom fail, range is null");
        AppMethodBeat.o(37270);
        return null;
      }
      if ((((String)localObject).length() < 5) || (((String)localObject).charAt(0) != '{') || (((String)localObject).charAt(((String)localObject).length() - 1) != '}') || (!((String)localObject).contains(",")))
      {
        Log.e("MicroMsg.StyleNode", "parseFrom fail, range wrong format, range = ".concat(String.valueOf(localObject)));
        AppMethodBeat.o(37270);
        return null;
      }
      Log.d("MicroMsg.StyleNode", "parseFrom, range = ".concat(String.valueOf(localObject)));
      localObject = ((String)localObject).substring(1, ((String)localObject).length() - 1).split(",");
      if ((localObject == null) || (localObject.length != 2))
      {
        Log.e("MicroMsg.StyleNode", "parseFrom fail, range wrong format, strs array length = " + localObject.length);
        AppMethodBeat.o(37270);
        return null;
      }
      b localb = new b();
      for (;;)
      {
        try
        {
          localb.XjC = Util.getInt(localObject[0], 0);
          int i = localb.XjC;
          localb.XjD = (Util.getInt(localObject[1], 0) + i);
          localObject = (String)paramMap.get(paramString + ".font");
          if (Util.isNullOrNil((String)localObject))
          {
            Log.d("MicroMsg.StyleNode", "parseFrom, font is null, use default value");
            localObject = "m";
            localb.fWa = as.gS((String)localObject);
            localb.XjA = as.acL((String)localObject);
            localb.oYK = as.bzM((String)localObject);
            localObject = paramString + ".color";
            paramString = paramString + ".wxcolors.wxcolor";
            if (ar.isDarkMode()) {
              break label429;
            }
            localb.color = as.hQ((String)paramMap.get(paramString), as.hQ((String)paramMap.get(localObject), -16777216));
            AppMethodBeat.o(37270);
            return localb;
          }
        }
        catch (Exception paramMap)
        {
          Log.e("MicroMsg.StyleNode", "parseFrom fail, ex = " + paramMap.getMessage());
          AppMethodBeat.o(37270);
          return null;
        }
        localObject = ((String)localObject).toLowerCase();
        continue;
        label429:
        localb.color = as.hQ((String)paramMap.get(paramString + "1"), as.hQ((String)paramMap.get(paramString), as.hQ((String)paramMap.get(localObject), -855638017)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.as
 * JD-Core Version:    0.7.0.1
 */