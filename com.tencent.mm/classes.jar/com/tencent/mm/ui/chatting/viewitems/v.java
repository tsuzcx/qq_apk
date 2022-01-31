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
import com.tencent.mm.R.f;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class v
{
  private static final LinearLayout.LayoutParams vEu = new LinearLayout.LayoutParams(-1, -2);
  
  private static boolean a(LinearLayout paramLinearLayout, SpannableString paramSpannableString, List<v.a> paramList)
  {
    y.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "addLines, nodeList size = " + paramList.size());
    int j = paramSpannableString.length();
    paramList = paramList.iterator();
    v.a locala;
    for (int i = 0; paramList.hasNext(); i = locala.offset)
    {
      locala = (v.a)paramList.next();
      if (locala.offset > i)
      {
        localTextView = new TextView(paramLinearLayout.getContext());
        localTextView.setText(paramSpannableString.subSequence(i, Math.min(locala.offset, j)));
        localTextView.setLineSpacing(3.0F, 1.0F);
        paramLinearLayout.addView(localTextView, vEu);
      }
      TextView localTextView = new TextView(paramLinearLayout.getContext());
      localTextView.setText(adJ(locala.vEw));
      localTextView.setSingleLine(true);
      if (locala.guC != 14) {
        localTextView.setTextSize(locala.guC);
      }
      if (locala.bZQ) {
        localTextView.setTypeface(null, 1);
      }
      if (locala.vEv) {
        localTextView.setPaintFlags(localTextView.getPaintFlags() | 0x8);
      }
      localTextView.setTextColor(locala.color);
      paramLinearLayout.addView(localTextView, vEu);
    }
    if (i >= j)
    {
      y.i("MicroMsg.ChattingItemDyeingTemplateDecorator", "addLines, lastOffset >= maxLength, lastOffset = " + i + ", maxLength = " + j);
      return true;
    }
    paramList = new TextView(paramLinearLayout.getContext());
    paramList.setTextSize(0, a.aa(paramList.getContext(), R.f.HintTextSize));
    paramList.setText(paramSpannableString.subSequence(i, j));
    paramList.setLineSpacing(2.0F, 1.0F);
    paramLinearLayout.addView(paramList, vEu);
    return true;
  }
  
  public static boolean a(LinearLayout paramLinearLayout, Map<String, String> paramMap)
  {
    if (paramLinearLayout == null)
    {
      y.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle fail, digestLl is null");
      return false;
    }
    String str1 = (String)paramMap.get(".msg.appmsg.mmreader.category.item.digest");
    if (bk.bl(str1))
    {
      y.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle, digest is null");
      return false;
    }
    SpannableString localSpannableString = new SpannableString(str1);
    int i;
    Object localObject2;
    Object localObject3;
    label171:
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
          break label268;
        }
        y.i("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle end, total style count = " + i);
        i = 0;
        localObject2 = new ArrayList();
        localObject3 = new StringBuilder(".msg.appmsg.mmreader.category.item.styles.line");
        if (i != 0) {
          break label940;
        }
        str1 = "";
        str1 = str1;
        if (paramMap.containsKey(str1)) {
          break label949;
        }
        y.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle end, total line count = " + i);
        Collections.sort((List)localObject2);
        paramLinearLayout.removeAllViews();
        a(paramLinearLayout, localSpannableString, (List)localObject2);
        return true;
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException1)
    {
      for (;;)
      {
        y.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle setSpan error: %s", new Object[] { localIndexOutOfBoundsException1.getMessage() });
        continue;
        localObject1 = String.valueOf(i);
      }
      label268:
      localObject1 = v.b.x(paramMap, (String)localObject2);
      if (localObject1 != null) {
        break label311;
      }
    }
    y.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom fail, skip to next, styleKey = " + (String)localObject2);
    for (;;)
    {
      i += 1;
      break;
      label311:
      if (((v.b)localObject1).vEx < ((v.b)localObject1).vEy) {
        break label367;
      }
      y.w("MicroMsg.ChattingItemDyeingTemplateDecorator", "addStyle, no need to add, rangeFrom = " + ((v.b)localObject1).vEx + ", rangeTo = " + ((v.b)localObject1).vEy);
    }
    label367:
    int m = ((v.b)localObject1).vEx;
    int k = ((v.b)localObject1).vEy;
    int n = ((v.b)localObject1).guC;
    boolean bool1 = ((v.b)localObject1).bZQ;
    boolean bool2 = ((v.b)localObject1).vEv;
    y.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, rangeFrom = " + m + ", rangeTo = " + k + ", fontSize = " + n + ", isBlack = " + bool1 + ", isUnderLine = " + bool2);
    int j = m;
    if (m < 0)
    {
      y.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, params error. length:%d, from:%d, to:%d", new Object[] { Integer.valueOf(localSpannableString.length()), Integer.valueOf(m), Integer.valueOf(k) });
      j = 0;
    }
    if (k > localSpannableString.length())
    {
      y.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, params error. length:%d, from:%d, to:%d", new Object[] { Integer.valueOf(localSpannableString.length()), Integer.valueOf(j), Integer.valueOf(k) });
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
                  k = ((v.b)localObject1).vEx;
                  m = ((v.b)localObject1).vEy;
                  n = ((v.b)localObject1).color;
                  y.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, rangeFrom = " + k + ", rangeTo = " + m + ", color = " + n);
                  j = k;
                  if (k < 0)
                  {
                    y.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, params error. length:%d, from:%d, to:%d", new Object[] { Integer.valueOf(localSpannableString.length()), Integer.valueOf(k), Integer.valueOf(m) });
                    j = 0;
                  }
                  k = m;
                  if (m > localSpannableString.length())
                  {
                    y.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, params error. length:%d, from:%d, to:%d", new Object[] { Integer.valueOf(localSpannableString.length()), Integer.valueOf(j), Integer.valueOf(m) });
                    k = localSpannableString.length();
                  }
                  try
                  {
                    localSpannableString.setSpan(new ForegroundColorSpan(n), j, k, 17);
                  }
                  catch (IndexOutOfBoundsException localIndexOutOfBoundsException2)
                  {
                    y.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", new Object[] { localIndexOutOfBoundsException2.getMessage() });
                  }
                }
                break;
                localIndexOutOfBoundsException3 = localIndexOutOfBoundsException3;
                y.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", new Object[] { localIndexOutOfBoundsException3.getMessage() });
              }
              localIndexOutOfBoundsException4 = localIndexOutOfBoundsException4;
              y.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", new Object[] { localIndexOutOfBoundsException4.getMessage() });
            }
            catch (IndexOutOfBoundsException localIndexOutOfBoundsException5)
            {
              for (;;)
              {
                y.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", new Object[] { localIndexOutOfBoundsException5.getMessage() });
              }
            }
          }
        }
      }
      label940:
      String str2 = String.valueOf(i);
      break label171;
      label949:
      localObject3 = v.a.w(paramMap, str2);
      if (localObject3 == null) {
        y.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom fail, skip to next, lineKey = " + str2);
      }
      for (;;)
      {
        i += 1;
        break;
        localIndexOutOfBoundsException5.add(localObject3);
      }
    }
  }
  
  private static String adJ(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    while (localStringBuilder.length() < 80) {
      localStringBuilder.append(paramString);
    }
    return localStringBuilder.toString();
  }
  
  private static int adK(String paramString)
  {
    if (bk.bl(paramString)) {
      return -16777216;
    }
    try
    {
      int i = Color.parseColor(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom, ex = " + paramString.getMessage());
    }
    return -16777216;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.v
 * JD-Core Version:    0.7.0.1
 */