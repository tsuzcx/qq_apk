package com.tencent.mm.plugin.wenote.model.nativenote.a;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.Html.TagHandler;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.b;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.BoldSpan;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.d;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.m;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.q;
import com.tencent.mm.sdk.platformtools.bk;
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
  private static final Pattern aOS = Pattern.compile("\\d+");
  private static final Pattern rHh = Pattern.compile("#[a-f0-9]+");
  private static HashMap<String, Integer> rHi;
  private Stack<a> rHf = new Stack();
  final HashMap<String, String> rHg = new HashMap();
  
  static
  {
    HashMap localHashMap = new HashMap();
    rHi = localHashMap;
    localHashMap.put("aqua", Integer.valueOf(65535));
    rHi.put("black", Integer.valueOf(0));
    rHi.put("blue", Integer.valueOf(255));
    rHi.put("fuchsia", Integer.valueOf(16711935));
    rHi.put("green", Integer.valueOf(32768));
    rHi.put("grey", Integer.valueOf(8421504));
    rHi.put("lime", Integer.valueOf(65280));
    rHi.put("maroon", Integer.valueOf(8388608));
    rHi.put("navy", Integer.valueOf(128));
    rHi.put("olive", Integer.valueOf(8421376));
    rHi.put("purple", Integer.valueOf(8388736));
    rHi.put("red", Integer.valueOf(16711680));
    rHi.put("silver", Integer.valueOf(12632256));
    rHi.put("teal", Integer.valueOf(32896));
    rHi.put("white", Integer.valueOf(16777215));
    rHi.put("yellow", Integer.valueOf(16776960));
  }
  
  @SuppressLint({"DefaultLocale"})
  private static int Ux(String paramString)
  {
    Integer localInteger = (Integer)rHi.get(paramString.toLowerCase());
    if (localInteger != null) {
      return localInteger.intValue();
    }
    if (paramString == null) {
      return -1;
    }
    for (;;)
    {
      int m;
      try
      {
        paramString = paramString.toString();
        j = paramString.length();
        m = 10;
        if ('-' != paramString.charAt(0)) {
          break label149;
        }
        i = 1;
        k = -1;
        if ('0' == paramString.charAt(i))
        {
          if (i == j - 1) {
            return 0;
          }
          j = paramString.charAt(i + 1);
          if (120 == j) {
            break label156;
          }
          if (88 != j) {
            break label166;
          }
          break label156;
          return Integer.parseInt(paramString.substring(j), i) * k;
        }
        j = paramString.charAt(i);
        if (35 == j)
        {
          j = i + 1;
          i = 16;
          continue;
        }
        j = i;
      }
      catch (NumberFormatException paramString)
      {
        return -1;
      }
      int i = m;
      continue;
      label149:
      i = 0;
      int k = 1;
      continue;
      label156:
      int j = i + 2;
      i = 16;
      continue;
      label166:
      j = i + 1;
      i = 8;
    }
  }
  
  private static Object a(Editable paramEditable, Class<? extends Object> paramClass)
  {
    paramEditable = paramEditable.getSpans(0, paramEditable.length(), paramClass);
    if (paramEditable.length == 0) {
      return null;
    }
    return paramEditable[(paramEditable.length - 1)];
  }
  
  private static void a(Editable paramEditable, Object paramObject)
  {
    int i = paramEditable.length();
    paramEditable.setSpan(paramObject, i, i, 17);
  }
  
  private void a(boolean paramBoolean, q paramq)
  {
    if (paramBoolean) {
      paramq = q.rKK;
    }
    if (this.rHf.isEmpty()) {}
    for (a locala = null; locala == null; locala = (a)this.rHf.peek())
    {
      paramq = new a(paramq, 1, 1);
      this.rHf.push(paramq);
      return;
    }
    if (locala.rKo == paramq)
    {
      locala.rKp += 1;
      locala.rKq += 1;
      return;
    }
    paramq = new a(paramq, locala.rKp + 1, 1);
    this.rHf.push(paramq);
  }
  
  private static void d(Editable paramEditable)
  {
    int i = paramEditable.length();
    if ((i > 0) && (paramEditable.charAt(i - 1) == '\n')) {}
    while (i == 0) {
      return;
    }
    paramEditable.append("\n");
  }
  
  private void lA(boolean paramBoolean)
  {
    for (;;)
    {
      if (!this.rHf.isEmpty())
      {
        a locala = (a)this.rHf.peek();
        q localq = locala.rKo;
        if (((!paramBoolean) || (!localq.cjh())) && ((paramBoolean) || (!localq.cjg())) && ((paramBoolean) || (!localq.cji()))) {
          break label100;
        }
        int i = locala.rKq;
        if (i > 1)
        {
          locala.rKq = (i - 1);
          locala.rKp -= 1;
        }
      }
      else
      {
        return;
      }
      this.rHf.pop();
      return;
      label100:
      this.rHf.pop();
    }
  }
  
  public final void handleTag(boolean paramBoolean, String paramString, Editable paramEditable, XMLReader paramXMLReader)
  {
    boolean bool3 = true;
    int j = 1;
    boolean bool2 = true;
    boolean bool1 = false;
    this.rHg.clear();
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
        this.rHg.put(localObject[(i * 5 + 1)], localObject[(i * 5 + 4)]);
        i += 1;
      }
      if (!paramBoolean) {
        break label897;
      }
    }
    catch (Exception paramXMLReader) {}
    if (paramString.equalsIgnoreCase("wx-ul")) {
      a(false, q.rKJ);
    }
    label650:
    label1549:
    label1555:
    label1684:
    for (;;)
    {
      a.rHd = paramEditable;
      return;
      label1561:
      if (paramString.equalsIgnoreCase("wx-ol")) {
        a(true, q.rKK);
      } else {
        label1436:
        label1565:
        if (paramString.equalsIgnoreCase("wn-todo"))
        {
          paramString = new a(q.rKL, 1, 1);
          this.rHf.push(paramString);
          paramString = (String)this.rHg.get("checked");
          paramBoolean = bool1;
          if (!bk.bl(paramString))
          {
            paramBoolean = bool1;
            if (paramString.equals("1")) {
              paramBoolean = true;
            }
          }
          a(paramEditable, new c.e(((a)this.rHf.peek()).rKp, paramBoolean));
        }
        else
        {
          if (paramString.equalsIgnoreCase("wx-li"))
          {
            paramString = (String)this.rHg.get("done");
            if ((!bk.bl(paramString)) && (paramString.equals("true")))
            {
              paramBoolean = bool2;
              label380:
              if (this.rHf.isEmpty()) {
                break label491;
              }
              paramString = (a)this.rHf.peek();
              paramXMLReader = paramString.rKo;
              i = paramString.rKp;
              if (!paramXMLReader.cjh()) {
                break label448;
              }
              paramString = new c.d(i);
            }
          }
          label1084:
          for (;;)
          {
            if (paramString == null) {
              break label1684;
            }
            a(paramEditable, paramString);
            break;
            paramBoolean = false;
            break label380;
            label448:
            if (paramXMLReader.cjg())
            {
              paramString = new f(i);
            }
            else if (paramXMLReader.cji())
            {
              paramString = new c.e(i, paramBoolean);
              continue;
              label491:
              paramString = new f(0);
              continue;
              int m;
              if ((paramString.equalsIgnoreCase("wx-font")) || (paramString.equalsIgnoreCase("span")))
              {
                i = -2147483648;
                paramString = (String)this.rHg.get("style");
                if (paramString == null) {
                  break label1673;
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
                    localMatcher = aOS.matcher(localField);
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
                      localMatcher = rHh.matcher(localNumberFormatException);
                      if (localMatcher.find(0)) {
                        paramString = localNumberFormatException.substring(localMatcher.start(), localMatcher.end());
                      }
                    }
                    else
                    {
                      if (!localNumberFormatException.startsWith("background-color")) {
                        break label1670;
                      }
                      localMatcher = rHh.matcher(localNumberFormatException);
                      if (!localMatcher.find(0)) {
                        break label1670;
                      }
                      paramXMLReader = localNumberFormatException.substring(localMatcher.start(), localMatcher.end());
                    }
                  }
                }
              }
              for (;;)
              {
                localObject = (String)this.rHg.get("face");
                j = paramEditable.length();
                c.b localb = new c.b((byte)0);
                localb.mSize = i;
                localb.rHj = paramString;
                localb.rHk = paramXMLReader;
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
                  lA(false);
                }
                for (;;)
                {
                  this.rHg.clear();
                  break;
                  if (paramString.equalsIgnoreCase("wx-ol"))
                  {
                    lA(true);
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
                      if (!paramString.rHn)
                      {
                        k = b.chW();
                        bool1 = ((c.e)paramString).rHo;
                        if (i != j) {
                          break label1084;
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
                      if (!paramXMLReader.rHn)
                      {
                        k = b.chW();
                        if (!(paramXMLReader instanceof c.d)) {
                          break label1243;
                        }
                        if (i != j) {
                          break label1238;
                        }
                      }
                      label1238:
                      for (paramBoolean = true;; paramBoolean = false)
                      {
                        paramString = new m(1, k, paramBoolean, false, false);
                        paramEditable.setSpan(paramString, i, j, 33);
                        paramEditable.removeSpan(paramXMLReader);
                        break;
                      }
                      label1243:
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
                        if (!TextUtils.isEmpty(paramString.rHl))
                        {
                          i = 1;
                          label1354:
                          if (i != 0) {
                            paramEditable.setSpan(new TypefaceSpan(paramString.rHl), m, k, 33);
                          }
                          if (paramString.mSize <= 0) {
                            break label1549;
                          }
                          i = 1;
                          label1392:
                          if (i != 0) {
                            paramEditable.setSpan(new AbsoluteSizeSpan(b.Do(paramString.mSize)), m, k, 33);
                          }
                          if (TextUtils.isEmpty(paramString.rHj)) {
                            break label1555;
                          }
                          i = 1;
                          if (i != 0)
                          {
                            i = Ux(paramString.rHj);
                            if (i != -1) {
                              paramEditable.setSpan(new ForegroundColorSpan(i | 0xFF000000), m, k, 33);
                            }
                          }
                          if (TextUtils.isEmpty(paramString.rHk)) {
                            break label1561;
                          }
                        }
                        for (i = j;; i = 0)
                        {
                          if (i == 0) {
                            break label1565;
                          }
                          i = Ux(paramString.rHk);
                          if (i == -1) {
                            break;
                          }
                          paramEditable.setSpan(new BackgroundColorSpan(i | 0xFF000000), m, k, 33);
                          break;
                          i = 0;
                          break label1354;
                          i = 0;
                          break label1392;
                          i = 0;
                          break label1436;
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
                break label650;
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
  
  private static final class f
    extends c.c
  {
    f(int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.a.c
 * JD-Core Version:    0.7.0.1
 */