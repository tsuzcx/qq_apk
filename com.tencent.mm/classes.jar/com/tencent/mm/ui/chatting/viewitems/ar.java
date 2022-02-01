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
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class ar
{
  private static final LinearLayout.LayoutParams aeTR;
  
  static
  {
    AppMethodBeat.i(37279);
    aeTR = new LinearLayout.LayoutParams(-1, -2);
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
        paramLinearLayout.addView(localTextView, aeTR);
      }
      TextView localTextView = new TextView(paramLinearLayout.getContext());
      localTextView.setText(bBz(locala.aeTT));
      localTextView.setSingleLine(true);
      if (locala.fontSize != 14) {
        localTextView.setTextSize(locala.fontSize);
      }
      if (locala.ica) {
        localTextView.setTypeface(null, 1);
      }
      if (locala.aeTS) {
        localTextView.setPaintFlags(localTextView.getPaintFlags() | 0x8);
      }
      localTextView.setTextColor(aw.mx(locala.color));
      paramLinearLayout.addView(localTextView, aeTR);
    }
    if (i >= j)
    {
      Log.i("MicroMsg.ChattingItemDyeingTemplateDecorator", "addLines, lastOffset >= maxLength, lastOffset = " + i + ", maxLength = " + j);
      AppMethodBeat.o(37272);
      return true;
    }
    paramList = new TextView(paramLinearLayout.getContext());
    paramList.setTextSize(0, a.br(paramList.getContext(), R.f.HintTextSize));
    paramList.setText(paramSpannableString.subSequence(i, j));
    paramList.setLineSpacing(2.0F, 1.0F);
    paramLinearLayout.addView(paramList, aeTR);
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
    str1 = str1.trim();
    paramLinearLayout.setVisibility(0);
    SpannableString localSpannableString = new SpannableString(str1);
    int i;
    Object localObject2;
    Object localObject3;
    label213:
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
          break label310;
        }
        Log.i("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle end, total style count = ".concat(String.valueOf(i)));
        i = 0;
        localObject2 = new ArrayList();
        localObject3 = new StringBuilder(".msg.appmsg.mmreader.category.item.styles.line");
        if (i != 0) {
          break label978;
        }
        str1 = "";
        str1 = str1;
        if (paramMap.containsKey(str1)) {
          break label987;
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
      label310:
      localObject1 = b.az(paramMap, (String)localObject2);
      if (localObject1 != null) {
        break label346;
      }
    }
    Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom fail, skip to next, styleKey = ".concat(String.valueOf(localObject2)));
    for (;;)
    {
      i += 1;
      break;
      label346:
      if (((b)localObject1).aeTU < ((b)localObject1).aeTV) {
        break label402;
      }
      Log.w("MicroMsg.ChattingItemDyeingTemplateDecorator", "addStyle, no need to add, rangeFrom = " + ((b)localObject1).aeTU + ", rangeTo = " + ((b)localObject1).aeTV);
    }
    label402:
    int m = ((b)localObject1).aeTU;
    int k = ((b)localObject1).aeTV;
    int n = ((b)localObject1).fontSize;
    boolean bool1 = ((b)localObject1).ica;
    boolean bool2 = ((b)localObject1).aeTS;
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
                  k = ((b)localObject1).aeTU;
                  m = ((b)localObject1).aeTV;
                  n = aw.mx(((b)localObject1).color);
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
      label978:
      String str2 = String.valueOf(i);
      break label213;
      label987:
      localObject3 = a.ay(paramMap, str2);
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
  
  private static String bBz(String paramString)
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
  
  private static int iW(String paramString, int paramInt)
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
    public boolean aeTS;
    public String aeTT;
    public int color;
    public int fontSize;
    public boolean ica;
    public int offset;
    
    public static a ay(Map<String, String> paramMap, String paramString)
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
            locala.ica = ar.is(str);
            locala.aeTS = ar.Vk(str);
            locala.fontSize = ar.bBA(str);
            str = (String)paramMap.get(paramString + ".color");
            if (!aw.isDarkMode()) {
              break label270;
            }
            i = -855638017;
            locala.color = ar.iX(str, i);
            locala.aeTT = ((String)paramMap.get(paramString + ".chars"));
            if (!Util.isNullOrNil(locala.aeTT)) {
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
    public boolean aeTS;
    public int aeTU;
    public int aeTV;
    public int color;
    public int fontSize;
    public boolean ica;
    
    public static b az(Map<String, String> paramMap, String paramString)
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
          localb.aeTU = Util.getInt(localObject[0], 0);
          int i = localb.aeTU;
          localb.aeTV = (Util.getInt(localObject[1], 0) + i);
          localObject = (String)paramMap.get(paramString + ".font");
          if (Util.isNullOrNil((String)localObject))
          {
            Log.d("MicroMsg.StyleNode", "parseFrom, font is null, use default value");
            localObject = "m";
            localb.ica = ar.is((String)localObject);
            localb.aeTS = ar.Vk((String)localObject);
            localb.fontSize = ar.bBA((String)localObject);
            localObject = paramString + ".color";
            paramString = paramString + ".wxcolors.wxcolor";
            if (aw.isDarkMode()) {
              break label429;
            }
            localb.color = ar.iX((String)paramMap.get(paramString), ar.iX((String)paramMap.get(localObject), -16777216));
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
        localb.color = ar.iX((String)paramMap.get(paramString + "1"), ar.iX((String)paramMap.get(paramString), ar.iX((String)paramMap.get(localObject), -855638017)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ar
 * JD-Core Version:    0.7.0.1
 */