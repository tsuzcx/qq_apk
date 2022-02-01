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
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class aj
{
  private static final LinearLayout.LayoutParams Key;
  
  static
  {
    AppMethodBeat.i(37279);
    Key = new LinearLayout.LayoutParams(-1, -2);
    AppMethodBeat.o(37279);
  }
  
  private static boolean a(LinearLayout paramLinearLayout, SpannableString paramSpannableString, List<a> paramList)
  {
    AppMethodBeat.i(37272);
    ad.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "addLines, nodeList size = " + paramList.size());
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
        paramLinearLayout.addView(localTextView, Key);
      }
      TextView localTextView = new TextView(paramLinearLayout.getContext());
      localTextView.setText(aWF(locala.KeA));
      localTextView.setSingleLine(true);
      if (locala.kSb != 14) {
        localTextView.setTextSize(locala.kSb);
      }
      if (locala.dIW) {
        localTextView.setTypeface(null, 1);
      }
      if (locala.Kez) {
        localTextView.setPaintFlags(localTextView.getPaintFlags() | 0x8);
      }
      localTextView.setTextColor(al.gD(locala.color));
      paramLinearLayout.addView(localTextView, Key);
    }
    if (i >= j)
    {
      ad.i("MicroMsg.ChattingItemDyeingTemplateDecorator", "addLines, lastOffset >= maxLength, lastOffset = " + i + ", maxLength = " + j);
      AppMethodBeat.o(37272);
      return true;
    }
    paramList = new TextView(paramLinearLayout.getContext());
    paramList.setTextSize(0, a.ax(paramList.getContext(), 2131165466));
    paramList.setText(paramSpannableString.subSequence(i, j));
    paramList.setLineSpacing(2.0F, 1.0F);
    paramLinearLayout.addView(paramList, Key);
    AppMethodBeat.o(37272);
    return true;
  }
  
  public static boolean a(LinearLayout paramLinearLayout, Map<String, String> paramMap)
  {
    AppMethodBeat.i(37271);
    if (paramLinearLayout == null)
    {
      ad.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle fail, digestLl is null");
      AppMethodBeat.o(37271);
      return false;
    }
    String str1 = (String)paramMap.get(".msg.appmsg.mmreader.category.item.digest");
    if (bt.isNullOrNil(str1))
    {
      ad.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle, digest is null");
      paramLinearLayout.setVisibility(8);
      AppMethodBeat.o(37271);
      return false;
    }
    paramLinearLayout.setVisibility(0);
    SpannableString localSpannableString = new SpannableString(str1);
    int i;
    Object localObject2;
    Object localObject3;
    label202:
    Object localObject1;
    try
    {
      localSpannableString.setSpan(new ForegroundColorSpan(paramLinearLayout.getContext().getResources().getColor(2131100711)), 0, localSpannableString.length(), 17);
      i = 0;
      localObject2 = new StringBuilder(".msg.appmsg.mmreader.category.item.styles.style");
      if (i == 0)
      {
        str1 = "";
        localObject2 = str1;
        if (paramMap.containsKey(localObject2)) {
          break label299;
        }
        ad.i("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle end, total style count = ".concat(String.valueOf(i)));
        i = 0;
        localObject2 = new ArrayList();
        localObject3 = new StringBuilder(".msg.appmsg.mmreader.category.item.styles.line");
        if (i != 0) {
          break label967;
        }
        str1 = "";
        str1 = str1;
        if (paramMap.containsKey(str1)) {
          break label976;
        }
        ad.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle end, total line count = ".concat(String.valueOf(i)));
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
        ad.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle setSpan error: %s", new Object[] { localIndexOutOfBoundsException1.getMessage() });
        continue;
        localObject1 = String.valueOf(i);
      }
      label299:
      localObject1 = b.E(paramMap, (String)localObject2);
      if (localObject1 != null) {
        break label335;
      }
    }
    ad.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom fail, skip to next, styleKey = ".concat(String.valueOf(localObject2)));
    for (;;)
    {
      i += 1;
      break;
      label335:
      if (((b)localObject1).KeB < ((b)localObject1).KeC) {
        break label391;
      }
      ad.w("MicroMsg.ChattingItemDyeingTemplateDecorator", "addStyle, no need to add, rangeFrom = " + ((b)localObject1).KeB + ", rangeTo = " + ((b)localObject1).KeC);
    }
    label391:
    int m = ((b)localObject1).KeB;
    int k = ((b)localObject1).KeC;
    int n = ((b)localObject1).kSb;
    boolean bool1 = ((b)localObject1).dIW;
    boolean bool2 = ((b)localObject1).Kez;
    ad.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, rangeFrom = " + m + ", rangeTo = " + k + ", fontSize = " + n + ", isBlack = " + bool1 + ", isUnderLine = " + bool2);
    int j = m;
    if (m < 0)
    {
      ad.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, params error. length:%d, from:%d, to:%d", new Object[] { Integer.valueOf(localSpannableString.length()), Integer.valueOf(m), Integer.valueOf(k) });
      j = 0;
    }
    if (k > localSpannableString.length())
    {
      ad.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, params error. length:%d, from:%d, to:%d", new Object[] { Integer.valueOf(localSpannableString.length()), Integer.valueOf(j), Integer.valueOf(k) });
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
                  k = ((b)localObject1).KeB;
                  m = ((b)localObject1).KeC;
                  n = al.gD(((b)localObject1).color);
                  ad.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, rangeFrom = " + k + ", rangeTo = " + m + ", color = " + n);
                  j = k;
                  if (k < 0)
                  {
                    ad.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, params error. length:%d, from:%d, to:%d", new Object[] { Integer.valueOf(localSpannableString.length()), Integer.valueOf(k), Integer.valueOf(m) });
                    j = 0;
                  }
                  k = m;
                  if (m > localSpannableString.length())
                  {
                    ad.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, params error. length:%d, from:%d, to:%d", new Object[] { Integer.valueOf(localSpannableString.length()), Integer.valueOf(j), Integer.valueOf(m) });
                    k = localSpannableString.length();
                  }
                  try
                  {
                    localSpannableString.setSpan(new ForegroundColorSpan(n), j, k, 17);
                  }
                  catch (IndexOutOfBoundsException localIndexOutOfBoundsException2)
                  {
                    ad.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", new Object[] { localIndexOutOfBoundsException2.getMessage() });
                  }
                }
                break;
                localIndexOutOfBoundsException3 = localIndexOutOfBoundsException3;
                ad.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", new Object[] { localIndexOutOfBoundsException3.getMessage() });
              }
              localIndexOutOfBoundsException4 = localIndexOutOfBoundsException4;
              ad.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", new Object[] { localIndexOutOfBoundsException4.getMessage() });
            }
            catch (IndexOutOfBoundsException localIndexOutOfBoundsException5)
            {
              for (;;)
              {
                ad.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", new Object[] { localIndexOutOfBoundsException5.getMessage() });
              }
            }
          }
        }
      }
      label967:
      String str2 = String.valueOf(i);
      break label202;
      label976:
      localObject3 = a.D(paramMap, str2);
      if (localObject3 == null) {
        ad.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom fail, skip to next, lineKey = ".concat(String.valueOf(str2)));
      }
      for (;;)
      {
        i += 1;
        break;
        localIndexOutOfBoundsException5.add(localObject3);
      }
    }
  }
  
  private static String aWF(String paramString)
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
  
  private static int gE(String paramString, int paramInt)
  {
    AppMethodBeat.i(37274);
    if (bt.isNullOrNil(paramString))
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
      ad.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom, ex = " + paramString.getMessage());
      AppMethodBeat.o(37274);
    }
    return paramInt;
  }
  
  static final class a
    implements Comparable<a>
  {
    public String KeA;
    public boolean Kez;
    public int color;
    public boolean dIW;
    public int kSb;
    public int offset;
    
    public static a D(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(37268);
      a locala = new a();
      for (;;)
      {
        try
        {
          locala.offset = bt.getInt((String)paramMap.get(paramString + ".offset"), 0);
          str = (String)paramMap.get(paramString + ".font");
          if (bt.isNullOrNil(str))
          {
            ad.d("MicroMsg.LineNode", "parseFrom, font is null, use default value");
            str = "m";
            locala.dIW = aj.fp(str);
            locala.Kez = aj.Lp(str);
            locala.kSb = aj.aWG(str);
            str = (String)paramMap.get(paramString + ".color");
            if (!al.isDarkMode()) {
              break label270;
            }
            i = -855638017;
            locala.color = aj.gF(str, i);
            locala.KeA = ((String)paramMap.get(paramString + ".chars"));
            if (!bt.isNullOrNil(locala.KeA)) {
              break;
            }
            ad.e("MicroMsg.LineNode", "parseFrom fail, chars is null");
            AppMethodBeat.o(37268);
            return null;
          }
        }
        catch (Exception paramMap)
        {
          ad.e("MicroMsg.LineNode", "parseFrom fail, ex = " + paramMap.getMessage());
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
    public int KeB;
    public int KeC;
    public boolean Kez;
    public int color;
    public boolean dIW;
    public int kSb;
    
    public static b E(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(37270);
      Object localObject = (String)paramMap.get(paramString + ".range");
      if (bt.isNullOrNil((String)localObject))
      {
        ad.e("MicroMsg.StyleNode", "parseFrom fail, range is null");
        AppMethodBeat.o(37270);
        return null;
      }
      if ((((String)localObject).length() < 5) || (((String)localObject).charAt(0) != '{') || (((String)localObject).charAt(((String)localObject).length() - 1) != '}') || (!((String)localObject).contains(",")))
      {
        ad.e("MicroMsg.StyleNode", "parseFrom fail, range wrong format, range = ".concat(String.valueOf(localObject)));
        AppMethodBeat.o(37270);
        return null;
      }
      ad.d("MicroMsg.StyleNode", "parseFrom, range = ".concat(String.valueOf(localObject)));
      localObject = ((String)localObject).substring(1, ((String)localObject).length() - 1).split(",");
      if ((localObject == null) || (localObject.length != 2))
      {
        ad.e("MicroMsg.StyleNode", "parseFrom fail, range wrong format, strs array length = " + localObject.length);
        AppMethodBeat.o(37270);
        return null;
      }
      b localb = new b();
      for (;;)
      {
        try
        {
          localb.KeB = bt.getInt(localObject[0], 0);
          int i = localb.KeB;
          localb.KeC = (bt.getInt(localObject[1], 0) + i);
          localObject = (String)paramMap.get(paramString + ".font");
          if (bt.isNullOrNil((String)localObject))
          {
            ad.d("MicroMsg.StyleNode", "parseFrom, font is null, use default value");
            localObject = "m";
            localb.dIW = aj.fp((String)localObject);
            localb.Kez = aj.Lp((String)localObject);
            localb.kSb = aj.aWG((String)localObject);
            localObject = paramString + ".color";
            paramString = paramString + ".wxcolors.wxcolor";
            if (al.isDarkMode()) {
              break label429;
            }
            localb.color = aj.gF((String)paramMap.get(paramString), aj.gF((String)paramMap.get(localObject), -16777216));
            AppMethodBeat.o(37270);
            return localb;
          }
        }
        catch (Exception paramMap)
        {
          ad.e("MicroMsg.StyleNode", "parseFrom fail, ex = " + paramMap.getMessage());
          AppMethodBeat.o(37270);
          return null;
        }
        localObject = ((String)localObject).toLowerCase();
        continue;
        label429:
        localb.color = aj.gF((String)paramMap.get(paramString + "1"), aj.gF((String)paramMap.get(paramString), aj.gF((String)paramMap.get(localObject), -855638017)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aj
 * JD-Core Version:    0.7.0.1
 */