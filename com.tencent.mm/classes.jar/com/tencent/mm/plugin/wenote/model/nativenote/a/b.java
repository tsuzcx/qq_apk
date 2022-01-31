package com.tencent.mm.plugin.wenote.model.nativenote.a;

import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.ParagraphStyle;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.j;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.BoldSpan;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.d;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.m;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.n;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.q;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.r;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public final class b
{
  private static int a(Stack<a> paramStack, StringBuilder paramStringBuilder)
  {
    int i = 0;
    if (!paramStack.isEmpty())
    {
      paramStack = (a)paramStack.pop();
      String str = paramStack.rKo.rKN;
      int j = paramStack.rKq;
      while (i < j)
      {
        paramStringBuilder.append(str);
        i += 1;
      }
      return paramStack.rKq;
    }
    return 0;
  }
  
  public static String a(Spanned paramSpanned)
  {
    if ((paramSpanned == null) || (bk.bl(paramSpanned.toString()))) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    a(paramSpanned, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  private static Set<r> a(Spanned paramSpanned, e parame)
  {
    HashSet localHashSet = new HashSet();
    paramSpanned = (ParagraphStyle[])paramSpanned.getSpans(parame.aiH, parame.Eo, ParagraphStyle.class);
    int j = paramSpanned.length;
    int i = 0;
    while (i < j)
    {
      parame = paramSpanned[i];
      q localq = q.a(parame);
      if (localq != null) {
        localHashSet.add(new r(localq, parame));
      }
      i += 1;
    }
    return localHashSet;
  }
  
  private static void a(Spanned paramSpanned, StringBuilder paramStringBuilder)
  {
    ArrayList localArrayList = new j(paramSpanned).rIR;
    Stack localStack = new Stack();
    int m = localArrayList.size();
    int i = 0;
    if (i < m)
    {
      n localn = (n)localArrayList.get(i);
      Object localObject2 = a(paramSpanned, localn);
      q localq = null;
      Object localObject3 = ((Set)localObject2).iterator();
      do
      {
        localObject1 = localq;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (r)((Iterator)localObject3).next();
      } while (!((r)localObject1).rKo.rKO);
      Object localObject1 = ((r)localObject1).rKo;
      localq = q.rKI;
      localObject2 = ((Set)localObject2).iterator();
      int j = 0;
      int k;
      label186:
      Object localObject4;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (r)((Iterator)localObject2).next();
        boolean bool;
        if ((((r)localObject3).rKo.cjg()) || (((r)localObject3).rKo.cjh()) || (((r)localObject3).rKo.cji()))
        {
          k = 1;
          j += k;
          localObject4 = ((r)localObject3).rKo;
          if (!((r)localObject3).rKo.cjg()) {
            break label241;
          }
          bool = ((d)((r)localObject3).rKU).rKu;
          label222:
          if (!bool) {
            break label301;
          }
          localq = q.rKI;
        }
        for (;;)
        {
          break;
          k = 0;
          break label186;
          label241:
          if (((r)localObject3).rKo.cjh())
          {
            bool = ((m)((r)localObject3).rKU).rKu;
            break label222;
          }
          if (((r)localObject3).rKo.cji())
          {
            bool = ((k)((r)localObject3).rKU).rKu;
            break label222;
          }
          bool = true;
          break label222;
          label301:
          if (((q)localObject4).cjg()) {
            localq = q.rKJ;
          } else if (((q)localObject4).cjh()) {
            localq = q.rKK;
          } else if (((q)localObject4).cji()) {
            localq = q.rKL;
          }
        }
      }
      a(localStack, paramStringBuilder, new a(localq, j, 0));
      if (localq.cji())
      {
        localObject2 = (k[])paramSpanned.getSpans(localn.aiH, localn.Eo, k.class);
        if (localObject2.length > 0)
        {
          localq.rKS = localObject2[0].rKA;
          j = localq.rKP.indexOf("\"") + 1;
          k = localq.rKP.lastIndexOf("\"");
          if (j < k)
          {
            localObject3 = localq.rKP.substring(j, k);
            if (!bk.bl((String)localObject3))
            {
              localObject4 = ((String)localObject3).trim();
              if (!localq.rKS) {
                break label663;
              }
              localObject2 = "1";
              label489:
              if (!((String)localObject4).equals(localObject2))
              {
                localObject4 = localq.rKP;
                if (!localq.rKS) {
                  break label671;
                }
              }
            }
          }
        }
      }
      label663:
      label671:
      for (localObject2 = "1";; localObject2 = "0")
      {
        localq.rKP = ((String)localObject4).replaceAll((String)localObject3, (String)localObject2);
        paramStringBuilder.append(localq.rKP);
        if (localObject1 != null) {
          paramStringBuilder.append(((q)localObject1).rKM);
        }
        j = localn.aiH;
        k = localn.Eo;
        localObject2 = new TreeSet(new b.1(paramSpanned));
        ((SortedSet)localObject2).addAll(Arrays.asList(paramSpanned.getSpans(j, k, CharacterStyle.class)));
        a(paramSpanned, paramStringBuilder, j, k, (SortedSet)localObject2);
        if (localObject1 != null)
        {
          a(paramStringBuilder, (q)localObject1);
          paramStringBuilder.append(((q)localObject1).rKN);
        }
        a(paramStringBuilder, localq);
        paramStringBuilder.append(localq.rKQ);
        i += 1;
        break;
        localObject2 = "0";
        break label489;
      }
    }
    while (!localStack.isEmpty()) {
      a(localStack, paramStringBuilder);
    }
  }
  
  private static void a(Spanned paramSpanned, StringBuilder paramStringBuilder, int paramInt1, int paramInt2, SortedSet<CharacterStyle> paramSortedSet)
  {
    if (paramInt1 < paramInt2)
    {
      CharacterStyle localCharacterStyle;
      label18:
      int i;
      if (paramSortedSet.isEmpty())
      {
        localCharacterStyle = null;
        if (localCharacterStyle != null) {
          break label77;
        }
        i = 2147483647;
        label28:
        if (localCharacterStyle != null) {
          break label90;
        }
      }
      label77:
      label90:
      for (int j = 2147483647;; j = paramSpanned.getSpanEnd(localCharacterStyle))
      {
        if (paramInt1 >= i) {
          break label103;
        }
        a(paramSpanned, paramStringBuilder, paramInt1, Math.min(paramInt2, i));
        paramInt1 = i;
        break;
        localCharacterStyle = (CharacterStyle)paramSortedSet.first();
        break label18;
        i = paramSpanned.getSpanStart(localCharacterStyle);
        break label28;
      }
      label103:
      paramSortedSet.remove(localCharacterStyle);
      if ((localCharacterStyle instanceof BoldSpan))
      {
        paramStringBuilder.append("<wx-b>");
        label129:
        a(paramSpanned, paramStringBuilder, Math.max(i, paramInt1), Math.min(j, paramInt2), paramSortedSet);
        if (!(localCharacterStyle instanceof ForegroundColorSpan)) {
          break label511;
        }
        paramStringBuilder.append("</wx-font>");
      }
      for (;;)
      {
        paramInt1 = j;
        break;
        if (((localCharacterStyle instanceof StyleSpan)) && (((StyleSpan)localCharacterStyle).getStyle() == 1))
        {
          paramStringBuilder.append("<wx-b>");
          break label129;
        }
        if (((localCharacterStyle instanceof StyleSpan)) && (((StyleSpan)localCharacterStyle).getStyle() == 2))
        {
          paramStringBuilder.append("<i>");
          break label129;
        }
        if ((localCharacterStyle instanceof UnderlineSpan))
        {
          paramStringBuilder.append("<u>");
          break label129;
        }
        if ((localCharacterStyle instanceof RelativeSizeSpan))
        {
          paramStringBuilder.append("<wx-font style=\"font-size:");
          paramStringBuilder.append(com.tencent.mm.plugin.wenote.model.nativenote.manager.b.Dp((int)(((RelativeSizeSpan)localCharacterStyle).getSizeChange() * com.tencent.mm.plugin.wenote.model.nativenote.manager.b.getTextSize())));
          paramStringBuilder.append("px\">");
          break label129;
        }
        if ((localCharacterStyle instanceof AbsoluteSizeSpan))
        {
          paramStringBuilder.append("<wx-font style=\"font-size:");
          paramStringBuilder.append(com.tencent.mm.plugin.wenote.model.nativenote.manager.b.Dp(((AbsoluteSizeSpan)localCharacterStyle).getSize()));
          paramStringBuilder.append("px\">");
          break label129;
        }
        if ((localCharacterStyle instanceof ForegroundColorSpan))
        {
          paramStringBuilder.append("<wx-font style=\"color:#");
          for (str = Integer.toHexString(((ForegroundColorSpan)localCharacterStyle).getForegroundColor() + 16777216); str.length() < 6; str = "0" + str) {}
          paramStringBuilder.append(str);
          paramStringBuilder.append("\">");
          break label129;
        }
        if (!(localCharacterStyle instanceof BackgroundColorSpan)) {
          break label129;
        }
        paramStringBuilder.append("<wx-font style=\"background-color:#");
        for (String str = Integer.toHexString(((BackgroundColorSpan)localCharacterStyle).getBackgroundColor() + 16777216); str.length() < 6; str = "0" + str) {}
        paramStringBuilder.append(str);
        paramStringBuilder.append("\">");
        break label129;
        label511:
        if ((localCharacterStyle instanceof BackgroundColorSpan)) {
          paramStringBuilder.append("</wx-font>");
        } else if ((localCharacterStyle instanceof AbsoluteSizeSpan)) {
          paramStringBuilder.append("</wx-font>");
        } else if ((localCharacterStyle instanceof UnderlineSpan)) {
          paramStringBuilder.append("</u>");
        } else if ((localCharacterStyle instanceof BoldSpan)) {
          paramStringBuilder.append("</wx-b>");
        } else if (((localCharacterStyle instanceof StyleSpan)) && (((StyleSpan)localCharacterStyle).getStyle() == 2)) {
          paramStringBuilder.append("</i>");
        } else if (((localCharacterStyle instanceof StyleSpan)) && (((StyleSpan)localCharacterStyle).getStyle() == 1)) {
          paramStringBuilder.append("</wx-b>");
        } else if ((localCharacterStyle instanceof RelativeSizeSpan)) {
          paramStringBuilder.append("</wx-font>");
        }
      }
    }
  }
  
  public static void a(CharSequence paramCharSequence, StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      char c = paramCharSequence.charAt(paramInt1);
      if (c == '\n') {
        paramStringBuilder.append("<br/>");
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        if (c == '<')
        {
          paramStringBuilder.append("&lt;");
        }
        else if (c == '>')
        {
          paramStringBuilder.append("&gt;");
        }
        else if (c == '&')
        {
          paramStringBuilder.append("&amp;");
        }
        else if (c == ' ')
        {
          while ((paramInt1 + 1 < paramInt2) && (paramCharSequence.charAt(paramInt1 + 1) == ' '))
          {
            paramStringBuilder.append("&nbsp;");
            paramInt1 += 1;
          }
          paramStringBuilder.append(' ');
        }
        else if (c < ' ')
        {
          paramStringBuilder.append("&#" + c + ";");
        }
        else
        {
          paramStringBuilder.append(c);
        }
      }
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, q paramq)
  {
    if ((paramq.rKR) && (paramStringBuilder.length() >= 5))
    {
      int i = paramStringBuilder.length() - 5;
      int j = paramStringBuilder.length();
      if (paramStringBuilder.subSequence(i, j).equals("<br/>")) {
        paramStringBuilder.delete(i, j);
      }
    }
  }
  
  private static void a(Stack<a> paramStack, StringBuilder paramStringBuilder, a parama)
  {
    int i = 0;
    Object localObject = q.rKI;
    if (!paramStack.isEmpty())
    {
      localObject = (a)paramStack.peek();
      i = ((a)localObject).rKp;
      localObject = ((a)localObject).rKo;
    }
    if (parama.rKp > i)
    {
      parama.rKq = (parama.rKp - i);
      b(paramStack, paramStringBuilder, parama);
    }
    do
    {
      return;
      if (parama.rKp < i)
      {
        a(paramStack, paramStringBuilder);
        break;
      }
    } while (parama.rKo == localObject);
    parama.rKq = a(paramStack, paramStringBuilder);
    b(paramStack, paramStringBuilder, parama);
  }
  
  private static void b(Stack<a> paramStack, StringBuilder paramStringBuilder, a parama)
  {
    String str = parama.rKo.rKM;
    int j = parama.rKq;
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append(str);
      i += 1;
    }
    paramStack.push(parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.a.b
 * JD-Core Version:    0.7.0.1
 */