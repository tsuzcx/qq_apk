package com.tencent.mm.plugin.wenote.model.nativenote.a;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.Html.TagHandler;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.b;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.BoldSpan;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.d;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.m;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.q;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.XMLReader;

public final class c
  implements Html.TagHandler
{
  private static final Pattern aWm;
  private static final Pattern vxP;
  private static HashMap<String, Integer> vxQ;
  private Stack<a> vxN;
  final HashMap<String, String> vxO;
  
  static
  {
    AppMethodBeat.i(26707);
    aWm = Pattern.compile("\\d+");
    vxP = Pattern.compile("#[a-f0-9]+");
    HashMap localHashMap = new HashMap();
    vxQ = localHashMap;
    localHashMap.put("aqua", Integer.valueOf(65535));
    vxQ.put("black", Integer.valueOf(0));
    vxQ.put("blue", Integer.valueOf(255));
    vxQ.put("fuchsia", Integer.valueOf(16711935));
    vxQ.put("green", Integer.valueOf(32768));
    vxQ.put("grey", Integer.valueOf(8421504));
    vxQ.put("lime", Integer.valueOf(65280));
    vxQ.put("maroon", Integer.valueOf(8388608));
    vxQ.put("navy", Integer.valueOf(128));
    vxQ.put("olive", Integer.valueOf(8421376));
    vxQ.put("purple", Integer.valueOf(8388736));
    vxQ.put("red", Integer.valueOf(16711680));
    vxQ.put("silver", Integer.valueOf(12632256));
    vxQ.put("teal", Integer.valueOf(32896));
    vxQ.put("white", Integer.valueOf(16777215));
    vxQ.put("yellow", Integer.valueOf(16776960));
    AppMethodBeat.o(26707);
  }
  
  public c()
  {
    AppMethodBeat.i(26699);
    this.vxN = new Stack();
    this.vxO = new HashMap();
    AppMethodBeat.o(26699);
  }
  
  private static Object a(Editable paramEditable, Class<? extends Object> paramClass)
  {
    AppMethodBeat.i(26704);
    paramEditable = paramEditable.getSpans(0, paramEditable.length(), paramClass);
    if (paramEditable.length == 0)
    {
      AppMethodBeat.o(26704);
      return null;
    }
    paramEditable = paramEditable[(paramEditable.length - 1)];
    AppMethodBeat.o(26704);
    return paramEditable;
  }
  
  private static void a(Editable paramEditable, Object paramObject)
  {
    AppMethodBeat.i(26705);
    int i = paramEditable.length();
    paramEditable.setSpan(paramObject, i, i, 17);
    AppMethodBeat.o(26705);
  }
  
  private void a(boolean paramBoolean, q paramq)
  {
    AppMethodBeat.i(26702);
    if (paramBoolean) {
      paramq = q.vBo;
    }
    if (this.vxN.isEmpty()) {}
    for (a locala = null; locala == null; locala = (a)this.vxN.peek())
    {
      paramq = new a(paramq, 1, 1);
      this.vxN.push(paramq);
      AppMethodBeat.o(26702);
      return;
    }
    if (locala.vAS == paramq)
    {
      locala.vAT += 1;
      locala.vAU += 1;
      AppMethodBeat.o(26702);
      return;
    }
    paramq = new a(paramq, locala.vAT + 1, 1);
    this.vxN.push(paramq);
    AppMethodBeat.o(26702);
  }
  
  @SuppressLint({"DefaultLocale"})
  private static int ajL(String paramString)
  {
    AppMethodBeat.i(26706);
    Integer localInteger = (Integer)vxQ.get(paramString.toLowerCase());
    int i;
    if (localInteger != null)
    {
      i = localInteger.intValue();
      AppMethodBeat.o(26706);
      return i;
    }
    if (paramString == null) {}
    int k;
    try
    {
      AppMethodBeat.o(26706);
      return -1;
    }
    catch (NumberFormatException paramString)
    {
      AppMethodBeat.o(26706);
      return -1;
    }
    paramString = paramString.toString();
    int j = paramString.length();
    int m = 10;
    if ('-' == paramString.charAt(0))
    {
      i = 1;
      k = -1;
      if ('0' == paramString.charAt(i))
      {
        if (i == j - 1)
        {
          AppMethodBeat.o(26706);
          return 0;
        }
        j = paramString.charAt(i + 1);
        if (120 == j) {
          break label206;
        }
        if (88 == j) {
          break label206;
        }
      }
    }
    for (;;)
    {
      i = Integer.parseInt(paramString.substring(j), i);
      AppMethodBeat.o(26706);
      return i * k;
      j = i + 1;
      i = 8;
      continue;
      j = paramString.charAt(i);
      if (35 == j)
      {
        j = i + 1;
        i = 16;
      }
      else
      {
        j = i;
        i = m;
        continue;
        i = 0;
        k = 1;
        break;
        label206:
        j = i + 2;
        i = 16;
      }
    }
  }
  
  private static void d(Editable paramEditable)
  {
    AppMethodBeat.i(26701);
    int i = paramEditable.length();
    if ((i > 0) && (paramEditable.charAt(i - 1) == '\n'))
    {
      AppMethodBeat.o(26701);
      return;
    }
    if (i != 0) {
      paramEditable.append("\n");
    }
    AppMethodBeat.o(26701);
  }
  
  private void oL(boolean paramBoolean)
  {
    AppMethodBeat.i(26703);
    while (!this.vxN.isEmpty())
    {
      a locala = (a)this.vxN.peek();
      q localq = locala.vAS;
      if (((paramBoolean) && (localq.djI())) || ((!paramBoolean) && (localq.djH())) || ((!paramBoolean) && (localq.djJ())))
      {
        int i = locala.vAU;
        if (i > 1)
        {
          locala.vAU = (i - 1);
          locala.vAT -= 1;
          AppMethodBeat.o(26703);
          return;
        }
        this.vxN.pop();
        AppMethodBeat.o(26703);
        return;
      }
      this.vxN.pop();
    }
    AppMethodBeat.o(26703);
  }
  
  public final void handleTag(boolean paramBoolean, String paramString, Editable paramEditable, XMLReader paramXMLReader)
  {
    boolean bool3 = true;
    int j = 1;
    boolean bool2 = true;
    boolean bool1 = false;
    AppMethodBeat.i(26700);
    this.vxO.clear();
    Object localObject;
    Field localField;
    int k;
    int i;
    try
    {
      localObject = paramXMLReader.getClass().getDeclaredField("theNewElement");
      ((Field)localObject).setAccessible(true);
      paramXMLReader = ((Field)localObject).get(paramXMLReader);
      localObject = paramXMLReader.getClass().getDeclaredField("theAtts");
      ((Field)localObject).setAccessible(true);
      paramXMLReader = ((Field)localObject).get(paramXMLReader);
      localObject = paramXMLReader.getClass().getDeclaredField("data");
      ((Field)localObject).setAccessible(true);
      localObject = (String[])((Field)localObject).get(paramXMLReader);
      localField = paramXMLReader.getClass().getDeclaredField("length");
      localField.setAccessible(true);
      k = ((Integer)localField.get(paramXMLReader)).intValue();
      i = 0;
      while (i < k)
      {
        this.vxO.put(localObject[(i * 5 + 1)], localObject[(i * 5 + 4)]);
        i += 1;
      }
      if (!paramBoolean) {
        break label909;
      }
    }
    catch (Exception paramXMLReader) {}
    if (paramString.equalsIgnoreCase("wx-ul")) {
      a(false, q.vBn);
    }
    label392:
    label662:
    label1561:
    label1567:
    label1696:
    for (;;)
    {
      a.vxL = paramEditable;
      AppMethodBeat.o(26700);
      return;
      label1573:
      if (paramString.equalsIgnoreCase("wx-ol")) {
        a(true, q.vBo);
      } else {
        label1448:
        label1577:
        if (paramString.equalsIgnoreCase("wn-todo"))
        {
          paramString = new a(q.vBp, 1, 1);
          this.vxN.push(paramString);
          paramString = (String)this.vxO.get("checked");
          paramBoolean = bool1;
          if (!bo.isNullOrNil(paramString))
          {
            paramBoolean = bool1;
            if (paramString.equals("1")) {
              paramBoolean = true;
            }
          }
          a(paramEditable, new c.e(((a)this.vxN.peek()).vAT, paramBoolean));
        }
        else
        {
          if (paramString.equalsIgnoreCase("wx-li"))
          {
            paramString = (String)this.vxO.get("done");
            if ((!bo.isNullOrNil(paramString)) && (paramString.equals("true")))
            {
              paramBoolean = bool2;
              if (this.vxN.isEmpty()) {
                break label503;
              }
              paramString = (a)this.vxN.peek();
              paramXMLReader = paramString.vAS;
              i = paramString.vAT;
              if (!paramXMLReader.djI()) {
                break label460;
              }
              paramString = new c.d(i);
            }
          }
          label1096:
          for (;;)
          {
            if (paramString == null) {
              break label1696;
            }
            a(paramEditable, paramString);
            break;
            paramBoolean = false;
            break label392;
            label460:
            if (paramXMLReader.djH())
            {
              paramString = new f(i);
            }
            else if (paramXMLReader.djJ())
            {
              paramString = new c.e(i, paramBoolean);
              continue;
              label503:
              paramString = new f(0);
              continue;
              int m;
              if ((paramString.equalsIgnoreCase("wx-font")) || (paramString.equalsIgnoreCase("span")))
              {
                i = -2147483648;
                paramString = (String)this.vxO.get("style");
                if (paramString == null) {
                  break label1685;
                }
                localObject = paramString.toLowerCase(Locale.ENGLISH).split(";");
                m = localObject.length;
                j = 0;
                paramXMLReader = null;
                paramString = null;
                if (j < m)
                {
                  localField = localObject[j];
                  Matcher localMatcher;
                  int n;
                  if (localField.startsWith("font-size"))
                  {
                    localMatcher = aWm.matcher(localField);
                    if (localMatcher.find(0))
                    {
                      k = localMatcher.start();
                      n = localMatcher.end();
                    }
                  }
                  for (;;)
                  {
                    try
                    {
                      k = Integer.parseInt(localField.substring(k, n));
                      i = k;
                      j += 1;
                    }
                    catch (NumberFormatException localNumberFormatException) {}
                    continue;
                    if (localNumberFormatException.startsWith("color"))
                    {
                      localMatcher = vxP.matcher(localNumberFormatException);
                      if (localMatcher.find(0)) {
                        paramString = localNumberFormatException.substring(localMatcher.start(), localMatcher.end());
                      }
                    }
                    else
                    {
                      if (!localNumberFormatException.startsWith("background-color")) {
                        break label1682;
                      }
                      localMatcher = vxP.matcher(localNumberFormatException);
                      if (!localMatcher.find(0)) {
                        break label1682;
                      }
                      paramXMLReader = localNumberFormatException.substring(localMatcher.start(), localMatcher.end());
                    }
                  }
                }
              }
              for (;;)
              {
                localObject = (String)this.vxO.get("face");
                j = paramEditable.length();
                c.b localb = new c.b((byte)0);
                localb.mSize = i;
                localb.vxR = paramString;
                localb.vxS = paramXMLReader;
                paramEditable.setSpan(c.b.a(localb, (String)localObject), j, j, 17);
                break;
                if (paramString.equalsIgnoreCase("wx-b"))
                {
                  a(paramEditable, new c.a((byte)0));
                  break;
                }
                if (paramString.equalsIgnoreCase("wx-p"))
                {
                  d(paramEditable);
                  break;
                }
                if (!paramString.equalsIgnoreCase("wx-div")) {
                  break;
                }
                d(paramEditable);
                break;
                if (paramString.equalsIgnoreCase("wx-ul")) {
                  oL(false);
                }
                for (;;)
                {
                  this.vxO.clear();
                  break;
                  if (paramString.equalsIgnoreCase("wx-ol"))
                  {
                    oL(true);
                  }
                  else if (paramString.equalsIgnoreCase("wn-todo"))
                  {
                    paramString = (c.c)a(paramEditable, c.c.class);
                    if (paramString != null)
                    {
                      if ((paramEditable.length() == 0) || (paramEditable.charAt(paramEditable.length() - 1) != '\n')) {
                        paramEditable.append('\n');
                      }
                      i = paramEditable.getSpanStart(paramString);
                      j = paramEditable.length();
                      if (!paramString.vxV)
                      {
                        k = b.dim();
                        bool1 = ((c.e)paramString).vxW;
                        if (i != j) {
                          break label1096;
                        }
                      }
                      for (paramBoolean = true;; paramBoolean = false)
                      {
                        paramEditable.setSpan(new k(bool1, k, paramBoolean, false, false), i, j, 33);
                        paramEditable.removeSpan(paramString);
                        break;
                      }
                    }
                  }
                  else if (paramString.equalsIgnoreCase("wx-li"))
                  {
                    paramXMLReader = (c.c)a(paramEditable, c.c.class);
                    if (paramXMLReader != null)
                    {
                      if ((paramEditable.length() == 0) || (paramEditable.charAt(paramEditable.length() - 1) != '\n')) {
                        paramEditable.append('\n');
                      }
                      i = paramEditable.getSpanStart(paramXMLReader);
                      j = paramEditable.length();
                      if (!paramXMLReader.vxV)
                      {
                        k = b.dim();
                        if (!(paramXMLReader instanceof c.d)) {
                          break label1255;
                        }
                        if (i != j) {
                          break label1250;
                        }
                      }
                      label1250:
                      for (paramBoolean = true;; paramBoolean = false)
                      {
                        paramString = new m(1, k, paramBoolean, false, false);
                        paramEditable.setSpan(paramString, i, j, 33);
                        paramEditable.removeSpan(paramXMLReader);
                        break;
                      }
                      label1255:
                      if (i == j) {}
                      for (paramBoolean = bool3;; paramBoolean = false)
                      {
                        paramString = new d(k, paramBoolean, false, false);
                        break;
                      }
                    }
                  }
                  else if ((paramString.equalsIgnoreCase("wx-font")) || (paramString.equalsIgnoreCase("span")))
                  {
                    k = paramEditable.length();
                    paramString = a(paramEditable, c.b.class);
                    if (paramString != null)
                    {
                      m = paramEditable.getSpanStart(paramString);
                      paramEditable.removeSpan(paramString);
                      if (m != k)
                      {
                        paramString = (c.b)paramString;
                        if (!TextUtils.isEmpty(paramString.vxT))
                        {
                          i = 1;
                          label1366:
                          if (i != 0) {
                            paramEditable.setSpan(new TypefaceSpan(paramString.vxT), m, k, 33);
                          }
                          if (paramString.mSize <= 0) {
                            break label1561;
                          }
                          i = 1;
                          label1404:
                          if (i != 0) {
                            paramEditable.setSpan(new AbsoluteSizeSpan(b.Lh(paramString.mSize)), m, k, 33);
                          }
                          if (TextUtils.isEmpty(paramString.vxR)) {
                            break label1567;
                          }
                          i = 1;
                          if (i != 0)
                          {
                            i = ajL(paramString.vxR);
                            if (i != -1) {
                              paramEditable.setSpan(new ForegroundColorSpan(i | 0xFF000000), m, k, 33);
                            }
                          }
                          if (TextUtils.isEmpty(paramString.vxS)) {
                            break label1573;
                          }
                        }
                        for (i = j;; i = 0)
                        {
                          if (i == 0) {
                            break label1577;
                          }
                          i = ajL(paramString.vxS);
                          if (i == -1) {
                            break;
                          }
                          paramEditable.setSpan(new BackgroundColorSpan(i | 0xFF000000), m, k, 33);
                          break;
                          i = 0;
                          break label1366;
                          i = 0;
                          break label1404;
                          i = 0;
                          break label1448;
                        }
                      }
                    }
                  }
                  else if (paramString.equalsIgnoreCase("wx-b"))
                  {
                    paramString = new BoldSpan();
                    i = paramEditable.length();
                    paramXMLReader = a(paramEditable, c.a.class);
                    j = paramEditable.getSpanStart(paramXMLReader);
                    paramEditable.removeSpan(paramXMLReader);
                    if (j != i) {
                      paramEditable.setSpan(paramString, j, i, 33);
                    }
                  }
                  else if (paramString.equalsIgnoreCase("wx-p"))
                  {
                    d(paramEditable);
                  }
                  else
                  {
                    paramString.equalsIgnoreCase("wx-div");
                  }
                }
                break label662;
                paramXMLReader = null;
                paramString = null;
              }
            }
            else
            {
              paramString = null;
            }
          }
        }
      }
    }
  }
  
  static final class f
    extends c.c
  {
    f(int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.a.c
 * JD-Core Version:    0.7.0.1
 */