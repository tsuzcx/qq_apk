package com.tencent.mm.plugin.wenote.model.nativenote.a;

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
import com.tencent.mm.sdk.platformtools.Util;
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
  private static final Pattern dgg;
  private static final Pattern xyG;
  private static HashMap<String, Integer> xyH;
  private Stack<a> xyE;
  final HashMap<String, String> xyF;
  
  static
  {
    AppMethodBeat.i(30400);
    dgg = Pattern.compile("\\d+");
    xyG = Pattern.compile("#[a-f0-9]+");
    HashMap localHashMap = new HashMap();
    xyH = localHashMap;
    localHashMap.put("aqua", Integer.valueOf(65535));
    xyH.put("black", Integer.valueOf(0));
    xyH.put("blue", Integer.valueOf(255));
    xyH.put("fuchsia", Integer.valueOf(16711935));
    xyH.put("green", Integer.valueOf(32768));
    xyH.put("grey", Integer.valueOf(8421504));
    xyH.put("lime", Integer.valueOf(65280));
    xyH.put("maroon", Integer.valueOf(8388608));
    xyH.put("navy", Integer.valueOf(128));
    xyH.put("olive", Integer.valueOf(8421376));
    xyH.put("purple", Integer.valueOf(8388736));
    xyH.put("red", Integer.valueOf(16711680));
    xyH.put("silver", Integer.valueOf(12632256));
    xyH.put("teal", Integer.valueOf(32896));
    xyH.put("white", Integer.valueOf(16777215));
    xyH.put("yellow", Integer.valueOf(16776960));
    AppMethodBeat.o(30400);
  }
  
  public c()
  {
    AppMethodBeat.i(30392);
    this.xyE = new Stack();
    this.xyF = new HashMap();
    AppMethodBeat.o(30392);
  }
  
  private static Object a(Editable paramEditable, Class<? extends Object> paramClass)
  {
    AppMethodBeat.i(30397);
    paramEditable = paramEditable.getSpans(0, paramEditable.length(), paramClass);
    if (paramEditable.length == 0)
    {
      AppMethodBeat.o(30397);
      return null;
    }
    paramEditable = paramEditable[(paramEditable.length - 1)];
    AppMethodBeat.o(30397);
    return paramEditable;
  }
  
  private static void a(Editable paramEditable, Object paramObject)
  {
    AppMethodBeat.i(30398);
    int i = paramEditable.length();
    paramEditable.setSpan(paramObject, i, i, 17);
    AppMethodBeat.o(30398);
  }
  
  private void a(boolean paramBoolean, q paramq)
  {
    AppMethodBeat.i(30395);
    if (paramBoolean) {
      paramq = q.XBS;
    }
    if (this.xyE.isEmpty()) {}
    for (a locala = null; locala == null; locala = (a)this.xyE.peek())
    {
      paramq = new a(paramq, 1, 1);
      this.xyE.push(paramq);
      AppMethodBeat.o(30395);
      return;
    }
    if (locala.XBL == paramq)
    {
      locala.xBC += 1;
      locala.xBD += 1;
      AppMethodBeat.o(30395);
      return;
    }
    paramq = new a(paramq, locala.xBC + 1, 1);
    this.xyE.push(paramq);
    AppMethodBeat.o(30395);
  }
  
  private static int anC(String paramString)
  {
    AppMethodBeat.i(30399);
    Integer localInteger = (Integer)xyH.get(paramString.toLowerCase());
    int i;
    if (localInteger != null)
    {
      i = localInteger.intValue();
      AppMethodBeat.o(30399);
      return i;
    }
    if (paramString == null) {}
    int k;
    try
    {
      AppMethodBeat.o(30399);
      return -1;
    }
    catch (NumberFormatException paramString)
    {
      AppMethodBeat.o(30399);
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
          AppMethodBeat.o(30399);
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
      AppMethodBeat.o(30399);
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
    AppMethodBeat.i(30394);
    int i = paramEditable.length();
    if ((i > 0) && (paramEditable.charAt(i - 1) == '\n'))
    {
      AppMethodBeat.o(30394);
      return;
    }
    if (i != 0) {
      paramEditable.append("\n");
    }
    AppMethodBeat.o(30394);
  }
  
  private void nO(boolean paramBoolean)
  {
    AppMethodBeat.i(30396);
    while (!this.xyE.isEmpty())
    {
      a locala = (a)this.xyE.peek();
      q localq = locala.XBL;
      if (((paramBoolean) && (localq.dxw())) || ((!paramBoolean) && (localq.dxv())) || ((!paramBoolean) && (localq.dxx())))
      {
        int i = locala.xBD;
        if (i > 1)
        {
          locala.xBD = (i - 1);
          locala.xBC -= 1;
          AppMethodBeat.o(30396);
          return;
        }
        this.xyE.pop();
        AppMethodBeat.o(30396);
        return;
      }
      this.xyE.pop();
    }
    AppMethodBeat.o(30396);
  }
  
  public final void handleTag(boolean paramBoolean, String paramString, Editable paramEditable, XMLReader paramXMLReader)
  {
    boolean bool3 = true;
    int j = 1;
    boolean bool2 = true;
    boolean bool1 = false;
    AppMethodBeat.i(30393);
    this.xyF.clear();
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
        this.xyF.put(localObject[(i * 5 + 1)], localObject[(i * 5 + 4)]);
        i += 1;
      }
      if (!paramBoolean) {
        break label906;
      }
    }
    catch (Exception paramXMLReader) {}
    if (paramString.equalsIgnoreCase("wx-ul")) {
      a(false, q.XBR);
    }
    label389:
    label659:
    label1558:
    label1564:
    label1693:
    for (;;)
    {
      a.xyC = paramEditable;
      AppMethodBeat.o(30393);
      return;
      label1570:
      if (paramString.equalsIgnoreCase("wx-ol")) {
        a(true, q.XBS);
      } else {
        label1445:
        label1574:
        if (paramString.equalsIgnoreCase("wn-todo"))
        {
          paramString = new a(q.XBT, 1, 1);
          this.xyE.push(paramString);
          paramString = (String)this.xyF.get("checked");
          paramBoolean = bool1;
          if (!Util.isNullOrNil(paramString))
          {
            paramBoolean = bool1;
            if (paramString.equals("1")) {
              paramBoolean = true;
            }
          }
          a(paramEditable, new e(((a)this.xyE.peek()).xBC, paramBoolean));
        }
        else
        {
          if (paramString.equalsIgnoreCase("wx-li"))
          {
            paramString = (String)this.xyF.get("done");
            if ((!Util.isNullOrNil(paramString)) && (paramString.equals("true")))
            {
              paramBoolean = bool2;
              if (this.xyE.isEmpty()) {
                break label500;
              }
              paramString = (a)this.xyE.peek();
              paramXMLReader = paramString.XBL;
              i = paramString.xBC;
              if (!paramXMLReader.dxw()) {
                break label457;
              }
              paramString = new d(i);
            }
          }
          label1093:
          for (;;)
          {
            if (paramString == null) {
              break label1693;
            }
            a(paramEditable, paramString);
            break;
            paramBoolean = false;
            break label389;
            label457:
            if (paramXMLReader.dxv())
            {
              paramString = new f(i);
            }
            else if (paramXMLReader.dxx())
            {
              paramString = new e(i, paramBoolean);
              continue;
              label500:
              paramString = new f(0);
              continue;
              int m;
              if ((paramString.equalsIgnoreCase("wx-font")) || (paramString.equalsIgnoreCase("span")))
              {
                i = -2147483648;
                paramString = (String)this.xyF.get("style");
                if (paramString == null) {
                  break label1682;
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
                    localMatcher = dgg.matcher(localField);
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
                      localMatcher = xyG.matcher(localNumberFormatException);
                      if (localMatcher.find(0)) {
                        paramString = localNumberFormatException.substring(localMatcher.start(), localMatcher.end());
                      }
                    }
                    else
                    {
                      if (!localNumberFormatException.startsWith("background-color")) {
                        break label1679;
                      }
                      localMatcher = xyG.matcher(localNumberFormatException);
                      if (!localMatcher.find(0)) {
                        break label1679;
                      }
                      paramXMLReader = localNumberFormatException.substring(localMatcher.start(), localMatcher.end());
                    }
                  }
                }
              }
              for (;;)
              {
                localObject = (String)this.xyF.get("face");
                j = paramEditable.length();
                b localb = new b((byte)0);
                localb.mSize = i;
                localb.xyI = paramString;
                localb.xyJ = paramXMLReader;
                paramEditable.setSpan(b.a(localb, (String)localObject), j, j, 17);
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
                  nO(false);
                }
                for (;;)
                {
                  this.xyF.clear();
                  break;
                  if (paramString.equalsIgnoreCase("wx-ol"))
                  {
                    nO(true);
                  }
                  else if (paramString.equalsIgnoreCase("wn-todo"))
                  {
                    paramString = (c)a(paramEditable, c.class);
                    if (paramString != null)
                    {
                      if ((paramEditable.length() == 0) || (paramEditable.charAt(paramEditable.length() - 1) != '\n')) {
                        paramEditable.append('\n');
                      }
                      i = paramEditable.getSpanStart(paramString);
                      j = paramEditable.length();
                      if (!paramString.xyM)
                      {
                        k = b.dwB();
                        bool1 = ((e)paramString).duj;
                        if (i != j) {
                          break label1093;
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
                    paramXMLReader = (c)a(paramEditable, c.class);
                    if (paramXMLReader != null)
                    {
                      if ((paramEditable.length() == 0) || (paramEditable.charAt(paramEditable.length() - 1) != '\n')) {
                        paramEditable.append('\n');
                      }
                      i = paramEditable.getSpanStart(paramXMLReader);
                      j = paramEditable.length();
                      if (!paramXMLReader.xyM)
                      {
                        k = b.dwB();
                        if (!(paramXMLReader instanceof d)) {
                          break label1252;
                        }
                        if (i != j) {
                          break label1247;
                        }
                      }
                      label1247:
                      for (paramBoolean = true;; paramBoolean = false)
                      {
                        paramString = new m(1, k, paramBoolean, false, false);
                        paramEditable.setSpan(paramString, i, j, 33);
                        paramEditable.removeSpan(paramXMLReader);
                        break;
                      }
                      label1252:
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
                    paramString = a(paramEditable, b.class);
                    if (paramString != null)
                    {
                      m = paramEditable.getSpanStart(paramString);
                      paramEditable.removeSpan(paramString);
                      if (m != k)
                      {
                        paramString = (b)paramString;
                        if (!TextUtils.isEmpty(paramString.xyK))
                        {
                          i = 1;
                          label1363:
                          if (i != 0) {
                            paramEditable.setSpan(new TypefaceSpan(paramString.xyK), m, k, 33);
                          }
                          if (paramString.mSize <= 0) {
                            break label1558;
                          }
                          i = 1;
                          label1401:
                          if (i != 0) {
                            paramEditable.setSpan(new AbsoluteSizeSpan(b.JO(paramString.mSize)), m, k, 33);
                          }
                          if (TextUtils.isEmpty(paramString.xyI)) {
                            break label1564;
                          }
                          i = 1;
                          if (i != 0)
                          {
                            i = anC(paramString.xyI);
                            if (i != -1) {
                              paramEditable.setSpan(new ForegroundColorSpan(i | 0xFF000000), m, k, 33);
                            }
                          }
                          if (TextUtils.isEmpty(paramString.xyJ)) {
                            break label1570;
                          }
                        }
                        for (i = j;; i = 0)
                        {
                          if (i == 0) {
                            break label1574;
                          }
                          i = anC(paramString.xyJ);
                          if (i == -1) {
                            break;
                          }
                          paramEditable.setSpan(new BackgroundColorSpan(i | 0xFF000000), m, k, 33);
                          break;
                          i = 0;
                          break label1363;
                          i = 0;
                          break label1401;
                          i = 0;
                          break label1445;
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
                break label659;
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
  
  static class b
  {
    int mSize = -2147483648;
    String xyI;
    String xyJ;
    String xyK;
  }
  
  static abstract class c
  {
    int xyL;
    boolean xyM;
    
    c(int paramInt)
    {
      this.xyL = paramInt;
      this.xyM = false;
    }
  }
  
  static final class d
    extends c.c
  {
    d(int paramInt)
    {
      super();
    }
  }
  
  static final class e
    extends c.c
  {
    boolean duj = false;
    
    e(int paramInt, boolean paramBoolean)
    {
      super();
      this.duj = paramBoolean;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.a.c
 * JD-Core Version:    0.7.0.1
 */