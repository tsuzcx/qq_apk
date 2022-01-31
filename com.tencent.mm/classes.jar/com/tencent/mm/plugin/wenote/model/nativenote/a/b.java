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
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import com.tencent.mm.sdk.platformtools.bo;
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
    AppMethodBeat.i(26697);
    if (!paramStack.isEmpty())
    {
      paramStack = (a)paramStack.pop();
      String str = paramStack.vAS.vBr;
      int j = paramStack.vAU;
      while (i < j)
      {
        paramStringBuilder.append(str);
        i += 1;
      }
      i = paramStack.vAU;
      AppMethodBeat.o(26697);
      return i;
    }
    AppMethodBeat.o(26697);
    return 0;
  }
  
  public static String a(Spanned paramSpanned)
  {
    AppMethodBeat.i(26690);
    if ((paramSpanned == null) || (bo.isNullOrNil(paramSpanned.toString())))
    {
      AppMethodBeat.o(26690);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    a(paramSpanned, localStringBuilder);
    paramSpanned = localStringBuilder.toString();
    AppMethodBeat.o(26690);
    return paramSpanned;
  }
  
  private static Set<r> a(Spanned paramSpanned, e parame)
  {
    AppMethodBeat.i(26695);
    HashSet localHashSet = new HashSet();
    paramSpanned = (ParagraphStyle[])paramSpanned.getSpans(parame.akX, parame.Fe, ParagraphStyle.class);
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
    AppMethodBeat.o(26695);
    return localHashSet;
  }
  
  private static void a(Spanned paramSpanned, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(26691);
    ArrayList localArrayList = new j(paramSpanned).vzx;
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
      } while (!((r)localObject1).vAS.vBs);
      Object localObject1 = ((r)localObject1).vAS;
      int j = 0;
      localq = q.vBm;
      localObject2 = ((Set)localObject2).iterator();
      int k;
      label192:
      Object localObject4;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (r)((Iterator)localObject2).next();
        boolean bool;
        if ((((r)localObject3).vAS.djH()) || (((r)localObject3).vAS.djI()) || (((r)localObject3).vAS.djJ()))
        {
          k = 1;
          j += k;
          localObject4 = ((r)localObject3).vAS;
          if (!((r)localObject3).vAS.djH()) {
            break label247;
          }
          bool = ((d)((r)localObject3).vBy).vAY;
          label228:
          if (!bool) {
            break label307;
          }
          localq = q.vBm;
        }
        for (;;)
        {
          break;
          k = 0;
          break label192;
          label247:
          if (((r)localObject3).vAS.djI())
          {
            bool = ((m)((r)localObject3).vBy).vAY;
            break label228;
          }
          if (((r)localObject3).vAS.djJ())
          {
            bool = ((k)((r)localObject3).vBy).vAY;
            break label228;
          }
          bool = true;
          break label228;
          label307:
          if (((q)localObject4).djH()) {
            localq = q.vBn;
          } else if (((q)localObject4).djI()) {
            localq = q.vBo;
          } else if (((q)localObject4).djJ()) {
            localq = q.vBp;
          }
        }
      }
      a(localStack, paramStringBuilder, new a(localq, j, 0));
      if (localq.djJ())
      {
        localObject2 = (k[])paramSpanned.getSpans(localn.akX, localn.Fe, k.class);
        if (localObject2.length > 0)
        {
          localq.vBw = localObject2[0].vBe;
          j = localq.vBt.indexOf("\"") + 1;
          k = localq.vBt.lastIndexOf("\"");
          if (j < k)
          {
            localObject3 = localq.vBt.substring(j, k);
            if (!bo.isNullOrNil((String)localObject3))
            {
              localObject4 = ((String)localObject3).trim();
              if (!localq.vBw) {
                break label669;
              }
              localObject2 = "1";
              label495:
              if (!((String)localObject4).equals(localObject2))
              {
                localObject4 = localq.vBt;
                if (!localq.vBw) {
                  break label677;
                }
              }
            }
          }
        }
      }
      label669:
      label677:
      for (localObject2 = "1";; localObject2 = "0")
      {
        localq.vBt = ((String)localObject4).replaceAll((String)localObject3, (String)localObject2);
        paramStringBuilder.append(localq.vBt);
        if (localObject1 != null) {
          paramStringBuilder.append(((q)localObject1).vBq);
        }
        j = localn.akX;
        k = localn.Fe;
        localObject2 = new TreeSet(new b.1(paramSpanned));
        ((SortedSet)localObject2).addAll(Arrays.asList(paramSpanned.getSpans(j, k, CharacterStyle.class)));
        a(paramSpanned, paramStringBuilder, j, k, (SortedSet)localObject2);
        if (localObject1 != null)
        {
          a(paramStringBuilder, (q)localObject1);
          paramStringBuilder.append(((q)localObject1).vBr);
        }
        a(paramStringBuilder, localq);
        paramStringBuilder.append(localq.vBu);
        i += 1;
        break;
        localObject2 = "0";
        break label495;
      }
    }
    while (!localStack.isEmpty()) {
      a(localStack, paramStringBuilder);
    }
    AppMethodBeat.o(26691);
  }
  
  private static void a(Spanned paramSpanned, StringBuilder paramStringBuilder, int paramInt1, int paramInt2, SortedSet<CharacterStyle> paramSortedSet)
  {
    AppMethodBeat.i(26692);
    if (paramInt1 < paramInt2)
    {
      CharacterStyle localCharacterStyle;
      label24:
      int i;
      if (paramSortedSet.isEmpty())
      {
        localCharacterStyle = null;
        if (localCharacterStyle != null) {
          break label83;
        }
        i = 2147483647;
        label34:
        if (localCharacterStyle != null) {
          break label96;
        }
      }
      label83:
      label96:
      for (int j = 2147483647;; j = paramSpanned.getSpanEnd(localCharacterStyle))
      {
        if (paramInt1 >= i) {
          break label109;
        }
        a(paramSpanned, paramStringBuilder, paramInt1, Math.min(paramInt2, i));
        paramInt1 = i;
        break;
        localCharacterStyle = (CharacterStyle)paramSortedSet.first();
        break label24;
        i = paramSpanned.getSpanStart(localCharacterStyle);
        break label34;
      }
      label109:
      paramSortedSet.remove(localCharacterStyle);
      if ((localCharacterStyle instanceof BoldSpan))
      {
        paramStringBuilder.append("<wx-b>");
        label135:
        a(paramSpanned, paramStringBuilder, Math.max(i, paramInt1), Math.min(j, paramInt2), paramSortedSet);
        if (!(localCharacterStyle instanceof ForegroundColorSpan)) {
          break label503;
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
          break label135;
        }
        if (((localCharacterStyle instanceof StyleSpan)) && (((StyleSpan)localCharacterStyle).getStyle() == 2))
        {
          paramStringBuilder.append("<i>");
          break label135;
        }
        if ((localCharacterStyle instanceof UnderlineSpan))
        {
          paramStringBuilder.append("<u>");
          break label135;
        }
        if ((localCharacterStyle instanceof RelativeSizeSpan))
        {
          paramStringBuilder.append("<wx-font style=\"font-size:");
          paramStringBuilder.append(com.tencent.mm.plugin.wenote.model.nativenote.manager.b.Li((int)(((RelativeSizeSpan)localCharacterStyle).getSizeChange() * com.tencent.mm.plugin.wenote.model.nativenote.manager.b.getTextSize())));
          paramStringBuilder.append("px\">");
          break label135;
        }
        if ((localCharacterStyle instanceof AbsoluteSizeSpan))
        {
          paramStringBuilder.append("<wx-font style=\"font-size:");
          paramStringBuilder.append(com.tencent.mm.plugin.wenote.model.nativenote.manager.b.Li(((AbsoluteSizeSpan)localCharacterStyle).getSize()));
          paramStringBuilder.append("px\">");
          break label135;
        }
        if ((localCharacterStyle instanceof ForegroundColorSpan))
        {
          paramStringBuilder.append("<wx-font style=\"color:#");
          for (str = Integer.toHexString(((ForegroundColorSpan)localCharacterStyle).getForegroundColor() + 16777216); str.length() < 6; str = "0".concat(String.valueOf(str))) {}
          paramStringBuilder.append(str);
          paramStringBuilder.append("\">");
          break label135;
        }
        if (!(localCharacterStyle instanceof BackgroundColorSpan)) {
          break label135;
        }
        paramStringBuilder.append("<wx-font style=\"background-color:#");
        for (String str = Integer.toHexString(((BackgroundColorSpan)localCharacterStyle).getBackgroundColor() + 16777216); str.length() < 6; str = "0".concat(String.valueOf(str))) {}
        paramStringBuilder.append(str);
        paramStringBuilder.append("\">");
        break label135;
        label503:
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
    AppMethodBeat.o(26692);
  }
  
  public static void a(CharSequence paramCharSequence, StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26693);
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
    AppMethodBeat.o(26693);
  }
  
  private static void a(StringBuilder paramStringBuilder, q paramq)
  {
    AppMethodBeat.i(26694);
    if ((paramq.vBv) && (paramStringBuilder.length() >= 5))
    {
      int i = paramStringBuilder.length() - 5;
      int j = paramStringBuilder.length();
      if (paramStringBuilder.subSequence(i, j).equals("<br/>")) {
        paramStringBuilder.delete(i, j);
      }
    }
    AppMethodBeat.o(26694);
  }
  
  private static void a(Stack<a> paramStack, StringBuilder paramStringBuilder, a parama)
  {
    AppMethodBeat.i(26696);
    Object localObject;
    for (;;)
    {
      int i = 0;
      localObject = q.vBm;
      if (!paramStack.isEmpty())
      {
        localObject = (a)paramStack.peek();
        i = ((a)localObject).vAT;
        localObject = ((a)localObject).vAS;
      }
      if (parama.vAT > i)
      {
        parama.vAU = (parama.vAT - i);
        b(paramStack, paramStringBuilder, parama);
        AppMethodBeat.o(26696);
        return;
      }
      if (parama.vAT >= i) {
        break;
      }
      a(paramStack, paramStringBuilder);
    }
    if (parama.vAS != localObject)
    {
      parama.vAU = a(paramStack, paramStringBuilder);
      b(paramStack, paramStringBuilder, parama);
    }
    AppMethodBeat.o(26696);
  }
  
  private static void b(Stack<a> paramStack, StringBuilder paramStringBuilder, a parama)
  {
    AppMethodBeat.i(26698);
    String str = parama.vAS.vBq;
    int j = parama.vAU;
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append(str);
      i += 1;
    }
    paramStack.push(parama);
    AppMethodBeat.o(26698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.a.b
 * JD-Core Version:    0.7.0.1
 */