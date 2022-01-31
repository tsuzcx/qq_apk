package com.tencent.mm.ui.chatting.viewitems;

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
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class y
{
  private static final LinearLayout.LayoutParams zVF;
  
  static
  {
    AppMethodBeat.i(33189);
    zVF = new LinearLayout.LayoutParams(-1, -2);
    AppMethodBeat.o(33189);
  }
  
  private static boolean a(LinearLayout paramLinearLayout, SpannableString paramSpannableString, List<y.a> paramList)
  {
    AppMethodBeat.i(33182);
    ab.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "addLines, nodeList size = " + paramList.size());
    int j = paramSpannableString.length();
    paramList = paramList.iterator();
    y.a locala;
    for (int i = 0; paramList.hasNext(); i = locala.offset)
    {
      locala = (y.a)paramList.next();
      if (locala.offset > i)
      {
        localTextView = new TextView(paramLinearLayout.getContext());
        localTextView.setText(paramSpannableString.subSequence(i, Math.min(locala.offset, j)));
        localTextView.setLineSpacing(3.0F, 1.0F);
        paramLinearLayout.addView(localTextView, zVF);
      }
      TextView localTextView = new TextView(paramLinearLayout.getContext());
      localTextView.setText(auq(locala.zVH));
      localTextView.setSingleLine(true);
      if (locala.hPx != 14) {
        localTextView.setTextSize(locala.hPx);
      }
      if (locala.cIi) {
        localTextView.setTypeface(null, 1);
      }
      if (locala.zVG) {
        localTextView.setPaintFlags(localTextView.getPaintFlags() | 0x8);
      }
      localTextView.setTextColor(locala.color);
      paramLinearLayout.addView(localTextView, zVF);
    }
    if (i >= j)
    {
      ab.i("MicroMsg.ChattingItemDyeingTemplateDecorator", "addLines, lastOffset >= maxLength, lastOffset = " + i + ", maxLength = " + j);
      AppMethodBeat.o(33182);
      return true;
    }
    paramList = new TextView(paramLinearLayout.getContext());
    paramList.setTextSize(0, a.ao(paramList.getContext(), 2131427758));
    paramList.setText(paramSpannableString.subSequence(i, j));
    paramList.setLineSpacing(2.0F, 1.0F);
    paramLinearLayout.addView(paramList, zVF);
    AppMethodBeat.o(33182);
    return true;
  }
  
  public static boolean a(LinearLayout paramLinearLayout, Map<String, String> paramMap)
  {
    AppMethodBeat.i(33181);
    if (paramLinearLayout == null)
    {
      ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle fail, digestLl is null");
      AppMethodBeat.o(33181);
      return false;
    }
    String str1 = (String)paramMap.get(".msg.appmsg.mmreader.category.item.digest");
    if (bo.isNullOrNil(str1))
    {
      ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle, digest is null");
      paramLinearLayout.setVisibility(8);
      AppMethodBeat.o(33181);
      return false;
    }
    paramLinearLayout.setVisibility(0);
    SpannableString localSpannableString = new SpannableString(str1);
    int i;
    Object localObject2;
    Object localObject3;
    label190:
    Object localObject1;
    try
    {
      localSpannableString.setSpan(new ForegroundColorSpan(-16777216), 0, localSpannableString.length(), 17);
      i = 0;
      localObject2 = new StringBuilder(".msg.appmsg.mmreader.category.item.styles.style");
      if (i == 0)
      {
        str1 = "";
        localObject2 = str1;
        if (paramMap.containsKey(localObject2)) {
          break label286;
        }
        ab.i("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle end, total style count = ".concat(String.valueOf(i)));
        i = 0;
        localObject2 = new ArrayList();
        localObject3 = new StringBuilder(".msg.appmsg.mmreader.category.item.styles.line");
        if (i != 0) {
          break label951;
        }
        str1 = "";
        str1 = str1;
        if (paramMap.containsKey(str1)) {
          break label960;
        }
        ab.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle end, total line count = ".concat(String.valueOf(i)));
        Collections.sort((List)localObject2);
        paramLinearLayout.removeAllViews();
        a(paramLinearLayout, localSpannableString, (List)localObject2);
        AppMethodBeat.o(33181);
        return true;
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException1)
    {
      for (;;)
      {
        ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle setSpan error: %s", new Object[] { localIndexOutOfBoundsException1.getMessage() });
        continue;
        localObject1 = String.valueOf(i);
      }
      label286:
      localObject1 = y.b.y(paramMap, (String)localObject2);
      if (localObject1 != null) {
        break label322;
      }
    }
    ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom fail, skip to next, styleKey = ".concat(String.valueOf(localObject2)));
    for (;;)
    {
      i += 1;
      break;
      label322:
      if (((y.b)localObject1).zVI < ((y.b)localObject1).zVJ) {
        break label378;
      }
      ab.w("MicroMsg.ChattingItemDyeingTemplateDecorator", "addStyle, no need to add, rangeFrom = " + ((y.b)localObject1).zVI + ", rangeTo = " + ((y.b)localObject1).zVJ);
    }
    label378:
    int m = ((y.b)localObject1).zVI;
    int k = ((y.b)localObject1).zVJ;
    int n = ((y.b)localObject1).hPx;
    boolean bool1 = ((y.b)localObject1).cIi;
    boolean bool2 = ((y.b)localObject1).zVG;
    ab.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, rangeFrom = " + m + ", rangeTo = " + k + ", fontSize = " + n + ", isBlack = " + bool1 + ", isUnderLine = " + bool2);
    int j = m;
    if (m < 0)
    {
      ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, params error. length:%d, from:%d, to:%d", new Object[] { Integer.valueOf(localSpannableString.length()), Integer.valueOf(m), Integer.valueOf(k) });
      j = 0;
    }
    if (k > localSpannableString.length())
    {
      ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, params error. length:%d, from:%d, to:%d", new Object[] { Integer.valueOf(localSpannableString.length()), Integer.valueOf(j), Integer.valueOf(k) });
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
                  k = ((y.b)localObject1).zVI;
                  m = ((y.b)localObject1).zVJ;
                  n = ((y.b)localObject1).color;
                  ab.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, rangeFrom = " + k + ", rangeTo = " + m + ", color = " + n);
                  j = k;
                  if (k < 0)
                  {
                    ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, params error. length:%d, from:%d, to:%d", new Object[] { Integer.valueOf(localSpannableString.length()), Integer.valueOf(k), Integer.valueOf(m) });
                    j = 0;
                  }
                  k = m;
                  if (m > localSpannableString.length())
                  {
                    ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, params error. length:%d, from:%d, to:%d", new Object[] { Integer.valueOf(localSpannableString.length()), Integer.valueOf(j), Integer.valueOf(m) });
                    k = localSpannableString.length();
                  }
                  try
                  {
                    localSpannableString.setSpan(new ForegroundColorSpan(n), j, k, 17);
                  }
                  catch (IndexOutOfBoundsException localIndexOutOfBoundsException2)
                  {
                    ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", new Object[] { localIndexOutOfBoundsException2.getMessage() });
                  }
                }
                break;
                localIndexOutOfBoundsException3 = localIndexOutOfBoundsException3;
                ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", new Object[] { localIndexOutOfBoundsException3.getMessage() });
              }
              localIndexOutOfBoundsException4 = localIndexOutOfBoundsException4;
              ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", new Object[] { localIndexOutOfBoundsException4.getMessage() });
            }
            catch (IndexOutOfBoundsException localIndexOutOfBoundsException5)
            {
              for (;;)
              {
                ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", new Object[] { localIndexOutOfBoundsException5.getMessage() });
              }
            }
          }
        }
      }
      label951:
      String str2 = String.valueOf(i);
      break label190;
      label960:
      localObject3 = y.a.x(paramMap, str2);
      if (localObject3 == null) {
        ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom fail, skip to next, lineKey = ".concat(String.valueOf(str2)));
      }
      for (;;)
      {
        i += 1;
        break;
        localIndexOutOfBoundsException5.add(localObject3);
      }
    }
  }
  
  private static String auq(String paramString)
  {
    AppMethodBeat.i(33183);
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    while (localStringBuilder.length() < 80) {
      localStringBuilder.append(paramString);
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(33183);
    return paramString;
  }
  
  private static int aur(String paramString)
  {
    AppMethodBeat.i(33184);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(33184);
      return -16777216;
    }
    try
    {
      int i = Color.parseColor(paramString);
      AppMethodBeat.o(33184);
      return i;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom, ex = " + paramString.getMessage());
      AppMethodBeat.o(33184);
    }
    return -16777216;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.y
 * JD-Core Version:    0.7.0.1
 */