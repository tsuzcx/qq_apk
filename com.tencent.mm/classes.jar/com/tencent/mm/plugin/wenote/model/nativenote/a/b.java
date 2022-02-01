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
import com.tencent.mm.sdk.platformtools.Util;
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
    AppMethodBeat.i(30390);
    if (!paramStack.isEmpty())
    {
      paramStack = (a)paramStack.pop();
      String str = paramStack.XBL.xBY;
      int j = paramStack.xBD;
      while (i < j)
      {
        paramStringBuilder.append(str);
        i += 1;
      }
      i = paramStack.xBD;
      AppMethodBeat.o(30390);
      return i;
    }
    AppMethodBeat.o(30390);
    return 0;
  }
  
  public static String a(Spanned paramSpanned)
  {
    AppMethodBeat.i(30383);
    if ((paramSpanned == null) || (Util.isNullOrNil(paramSpanned.toString())))
    {
      AppMethodBeat.o(30383);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    a(paramSpanned, localStringBuilder);
    paramSpanned = localStringBuilder.toString();
    AppMethodBeat.o(30383);
    return paramSpanned;
  }
  
  private static Set<r> a(Spanned paramSpanned, e parame)
  {
    AppMethodBeat.i(30388);
    HashSet localHashSet = new HashSet();
    paramSpanned = (ParagraphStyle[])paramSpanned.getSpans(parame.uG, parame.uH, ParagraphStyle.class);
    int j = paramSpanned.length;
    int i = 0;
    while (i < j)
    {
      parame = paramSpanned[i];
      q localq = q.b(parame);
      if (localq != null) {
        localHashSet.add(new r(localq, parame));
      }
      i += 1;
    }
    AppMethodBeat.o(30388);
    return localHashSet;
  }
  
  private static void a(Spanned paramSpanned, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(30384);
    ArrayList localArrayList = new j(paramSpanned).xAm;
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
      } while (!((r)localObject1).XBL.xBZ);
      Object localObject1 = ((r)localObject1).XBL;
      int j = 0;
      localq = q.XBQ;
      localObject2 = ((Set)localObject2).iterator();
      int k;
      label192:
      Object localObject4;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (r)((Iterator)localObject2).next();
        boolean bool;
        if ((((r)localObject3).XBL.dxv()) || (((r)localObject3).XBL.dxw()) || (((r)localObject3).XBL.dxx()))
        {
          k = 1;
          j += k;
          localObject4 = ((r)localObject3).XBL;
          if (!((r)localObject3).XBL.dxv()) {
            break label247;
          }
          bool = ((d)((r)localObject3).xCf).xBH;
          label228:
          if (!bool) {
            break label307;
          }
          localq = q.XBQ;
        }
        for (;;)
        {
          break;
          k = 0;
          break label192;
          label247:
          if (((r)localObject3).XBL.dxw())
          {
            bool = ((m)((r)localObject3).xCf).xBH;
            break label228;
          }
          if (((r)localObject3).XBL.dxx())
          {
            bool = ((k)((r)localObject3).xCf).xBH;
            break label228;
          }
          bool = true;
          break label228;
          label307:
          if (((q)localObject4).dxv()) {
            localq = q.XBR;
          } else if (((q)localObject4).dxw()) {
            localq = q.XBS;
          } else if (((q)localObject4).dxx()) {
            localq = q.XBT;
          }
        }
      }
      a(localStack, paramStringBuilder, new a(localq, j, 0));
      if (localq.dxx())
      {
        localObject2 = (k[])paramSpanned.getSpans(localn.uG, localn.uH, k.class);
        if (localObject2.length > 0)
        {
          localq.xCd = localObject2[0].xCk;
          j = localq.xCa.indexOf("\"") + 1;
          k = localq.xCa.lastIndexOf("\"");
          if (j < k)
          {
            localObject3 = localq.xCa.substring(j, k);
            if (!Util.isNullOrNil((String)localObject3))
            {
              localObject4 = ((String)localObject3).trim();
              if (!localq.xCd) {
                break label672;
              }
              localObject2 = "1";
              label495:
              if (!((String)localObject4).equals(localObject2))
              {
                localObject4 = localq.xCa;
                if (!localq.xCd) {
                  break label680;
                }
              }
            }
          }
        }
      }
      label672:
      label680:
      for (localObject2 = "1";; localObject2 = "0")
      {
        localq.xCa = ((String)localObject4).replaceAll((String)localObject3, (String)localObject2);
        paramStringBuilder.append(localq.xCa);
        if (localObject1 != null) {
          paramStringBuilder.append(((q)localObject1).xBX);
        }
        j = localn.uG;
        k = localn.uH;
        localObject2 = new TreeSet(new b.1(paramSpanned));
        ((SortedSet)localObject2).addAll(Arrays.asList((CharacterStyle[])paramSpanned.getSpans(j, k, CharacterStyle.class)));
        a(paramSpanned, paramStringBuilder, j, k, (SortedSet)localObject2);
        if (localObject1 != null)
        {
          a(paramStringBuilder, (q)localObject1);
          paramStringBuilder.append(((q)localObject1).xBY);
        }
        a(paramStringBuilder, localq);
        paramStringBuilder.append(localq.xCb);
        i += 1;
        break;
        localObject2 = "0";
        break label495;
      }
    }
    while (!localStack.isEmpty()) {
      a(localStack, paramStringBuilder);
    }
    AppMethodBeat.o(30384);
  }
  
  private static void a(Spanned paramSpanned, StringBuilder paramStringBuilder, int paramInt1, int paramInt2, SortedSet<CharacterStyle> paramSortedSet)
  {
    AppMethodBeat.i(30385);
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
          paramStringBuilder.append(com.tencent.mm.plugin.wenote.model.nativenote.manager.b.JP((int)(((RelativeSizeSpan)localCharacterStyle).getSizeChange() * com.tencent.mm.plugin.wenote.model.nativenote.manager.b.getTextSize())));
          paramStringBuilder.append("px\">");
          break label135;
        }
        if ((localCharacterStyle instanceof AbsoluteSizeSpan))
        {
          paramStringBuilder.append("<wx-font style=\"font-size:");
          paramStringBuilder.append(com.tencent.mm.plugin.wenote.model.nativenote.manager.b.JP(((AbsoluteSizeSpan)localCharacterStyle).getSize()));
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
    AppMethodBeat.o(30385);
  }
  
  public static void a(CharSequence paramCharSequence, StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30386);
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
    AppMethodBeat.o(30386);
  }
  
  private static void a(StringBuilder paramStringBuilder, q paramq)
  {
    AppMethodBeat.i(30387);
    if ((paramq.xCc) && (paramStringBuilder.length() >= 5))
    {
      int i = paramStringBuilder.length() - 5;
      int j = paramStringBuilder.length();
      if (paramStringBuilder.subSequence(i, j).equals("<br/>")) {
        paramStringBuilder.delete(i, j);
      }
    }
    AppMethodBeat.o(30387);
  }
  
  private static void a(Stack<a> paramStack, StringBuilder paramStringBuilder, a parama)
  {
    AppMethodBeat.i(30389);
    Object localObject;
    for (;;)
    {
      int i = 0;
      localObject = q.XBQ;
      if (!paramStack.isEmpty())
      {
        localObject = (a)paramStack.peek();
        i = ((a)localObject).xBC;
        localObject = ((a)localObject).XBL;
      }
      if (parama.xBC > i)
      {
        parama.xBD = (parama.xBC - i);
        b(paramStack, paramStringBuilder, parama);
        AppMethodBeat.o(30389);
        return;
      }
      if (parama.xBC >= i) {
        break;
      }
      a(paramStack, paramStringBuilder);
    }
    if (parama.XBL != localObject)
    {
      parama.xBD = a(paramStack, paramStringBuilder);
      b(paramStack, paramStringBuilder, parama);
    }
    AppMethodBeat.o(30389);
  }
  
  private static void b(Stack<a> paramStack, StringBuilder paramStringBuilder, a parama)
  {
    AppMethodBeat.i(30391);
    String str = parama.XBL.xBX;
    int j = parama.xBD;
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append(str);
      i += 1;
    }
    paramStack.push(parama);
    AppMethodBeat.o(30391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.a.b
 * JD-Core Version:    0.7.0.1
 */