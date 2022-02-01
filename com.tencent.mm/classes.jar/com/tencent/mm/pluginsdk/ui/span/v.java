package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.comm.c.c;
import com.tencent.mm.plugin.comm.c.g;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.aw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

final class v
{
  private static Class<?>[] YpE;
  private static final com.tencent.mm.b.f<String, SpannableString> Ype;
  int YpA;
  private int YpB;
  boolean YpC;
  Object YpD;
  private ArrayList<u> Ypf;
  private ArrayList<a> Ypg;
  private ArrayList<com.tencent.mm.pluginsdk.ui.applet.z> Yph;
  boolean Ypi;
  boolean Ypj;
  boolean Ypk;
  boolean Ypl;
  boolean Ypm;
  boolean Ypn;
  boolean Ypo;
  boolean Ypp;
  boolean Ypq;
  boolean Ypr;
  boolean Yps;
  boolean Ypt;
  boolean Ypu;
  boolean Ypv;
  boolean Ypw;
  boolean Ypx;
  boolean Ypy;
  boolean Ypz;
  int lCR;
  a mAdTagClickCallback;
  int mAdTagClickScene;
  private Context mContext;
  String mSessionId;
  private TextView sQ;
  
  static
  {
    AppMethodBeat.i(152370);
    Ype = new com.tencent.mm.memory.a.c(500);
    YpE = new Class[] { com.tencent.mm.ui.widget.a.class, t.class, ForegroundColorSpan.class };
    AppMethodBeat.o(152370);
  }
  
  public v(Context paramContext)
  {
    AppMethodBeat.i(152345);
    this.Ypf = new ArrayList();
    this.Ypg = new ArrayList();
    this.Yph = new ArrayList();
    this.sQ = null;
    this.Ypi = false;
    this.Ypj = false;
    this.Ypk = true;
    this.Ypl = false;
    this.Ypm = false;
    this.Ypn = true;
    this.Ypo = true;
    this.Ypp = false;
    this.Ypq = false;
    this.Ypr = false;
    this.Yps = false;
    this.Ypt = false;
    this.Ypu = false;
    this.Ypv = false;
    this.Ypw = true;
    this.Ypx = false;
    this.Ypy = false;
    this.Ypz = false;
    this.YpA = 0;
    this.YpB = 0;
    this.mContext = null;
    this.YpC = false;
    this.lCR = 0;
    this.Ypf = new ArrayList();
    this.Ypg = new ArrayList();
    this.Yph = new ArrayList();
    this.mContext = paramContext;
    AppMethodBeat.o(152345);
  }
  
  private void a(SpannableString paramSpannableString)
  {
    AppMethodBeat.i(152368);
    if (this.sQ != null)
    {
      paramSpannableString = new s();
      paramSpannableString.mSessionId = this.mSessionId;
      paramSpannableString.setAdTagClickCallback(this.mAdTagClickCallback, 0);
      paramSpannableString.mAdTagClickScene = this.mAdTagClickScene;
      this.sQ.setOnTouchListener(paramSpannableString);
      AppMethodBeat.o(152368);
      return;
    }
    if (paramSpannableString != null)
    {
      paramSpannableString = (t[])paramSpannableString.getSpans(0, paramSpannableString.length(), t.class);
      int j;
      int i;
      if ((paramSpannableString != null) && (paramSpannableString.length > 0) && (this.mSessionId != null))
      {
        j = paramSpannableString.length;
        i = 0;
        while (i < j)
        {
          paramSpannableString[i].setSessionId(this.mSessionId);
          i += 1;
        }
      }
      if ((paramSpannableString != null) && (paramSpannableString.length > 0))
      {
        j = paramSpannableString.length;
        i = 0;
        while (i < j)
        {
          Object localObject = paramSpannableString[i];
          localObject.setAdTagClickCallback(this.mAdTagClickCallback, 0);
          localObject.setAdTagClickScene(this.mAdTagClickScene);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(152368);
  }
  
  private static boolean a(ArrayList<a> paramArrayList, a parama)
  {
    AppMethodBeat.i(152366);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (((a)paramArrayList.next()).a(parama))
      {
        AppMethodBeat.o(152366);
        return true;
      }
    }
    AppMethodBeat.o(152366);
    return false;
  }
  
  private CharSequence aA(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(245202);
    String str1 = paramCharSequence.toString();
    Matcher localMatcher;
    if (str1.length() < 1500) {
      localMatcher = o.a.Yok.matcher(str1);
    }
    while (localMatcher.find())
    {
      String str2 = localMatcher.group(1);
      String str3 = localMatcher.group(2);
      if (str2.length() >= 2)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (localMatcher.start(0) > 0) {
          localStringBuilder.append(str1.substring(0, localMatcher.start(0)));
        }
        localStringBuilder.append(str3);
        if (localMatcher.end(0) < str1.length()) {
          localStringBuilder.append(str1.substring(localMatcher.end(0), str1.length()));
        }
        str1 = localStringBuilder.toString();
        int i = localMatcher.start(0);
        int j = str3.length() + i;
        if ((i < 0) || (j > paramCharSequence.length()))
        {
          Log.e("MicroMsg.SpanProcessor", "parseHrefWithKefuMenuLink error, start:%d, end:%d, source.length:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramCharSequence.length()) });
          continue;
          localMatcher = o.a.Yoj.matcher(str1);
        }
        else
        {
          aX(str2, i, j);
          if (str1.length() < 1500) {
            localMatcher = o.a.Yok.matcher(str1);
          } else {
            localMatcher = o.a.Yof.matcher(str1);
          }
        }
      }
    }
    AppMethodBeat.o(245202);
    return str1;
  }
  
  private CharSequence aB(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152354);
    Object localObject1 = paramCharSequence.toString();
    Object localObject2;
    if (((String)localObject1).length() < 1500) {
      localObject2 = o.a.Yoi.matcher((CharSequence)localObject1);
    }
    for (;;)
    {
      String str1;
      String str2;
      Object localObject3;
      String str3;
      int i;
      label164:
      int j;
      if (((Matcher)localObject2).find())
      {
        String str4 = ((Matcher)localObject2).group(0);
        str1 = ((Matcher)localObject2).group(1);
        str2 = ((Matcher)localObject2).group(2);
        localObject3 = XmlParser.parseXml(str4.replace(str1, " ").replace(str2, " "), "a", null);
        if (localObject3 == null)
        {
          Log.e("MicroMsg.SpanProcessor", "XmlParser parse return null, so continue");
          continue;
          localObject2 = o.a.Yoh.matcher((CharSequence)localObject1);
          continue;
        }
        str3 = (String)((Map)localObject3).get(".a.$data-miniprogram-appid");
        localObject3 = (String)((Map)localObject3).get(".a.$data-miniprogram-path");
        if (!Util.isNullOrNil(str1))
        {
          i = 1;
          if (Util.isNullOrNil(str3)) {
            break label281;
          }
          j = 1;
        }
        for (;;)
        {
          if ((i != 0) && (j == 0))
          {
            if (str1.length() < 2) {
              break;
            }
            localObject1 = ((String)localObject1).toString().replace(str4, str2);
            i = ((Matcher)localObject2).start(0);
            j = str2.length() + i;
            if ((i < 0) || (j > paramCharSequence.length()))
            {
              Log.e("MicroMsg.SpanProcessor", "parseHref error, start:%d, end:%d, source.length:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramCharSequence.length()) });
              break;
              i = 0;
              break label164;
              label281:
              j = 0;
              continue;
            }
            aX(str1, i, j);
          }
        }
        for (;;)
        {
          label295:
          if (((String)localObject1).length() < 1500)
          {
            localObject2 = o.a.Yoi.matcher((CharSequence)localObject1);
            break;
            if (j != 0)
            {
              if (this.Ypu)
              {
                localObject1 = ((String)localObject1).toString().replace(str4, str2);
                i = ((Matcher)localObject2).start(0);
                j = str2.length();
                localObject2 = new u(str1, 45, null);
                ((u)localObject2).start = i;
                ((u)localObject2).end = (j + i);
                this.Ypf.add(localObject2);
                continue;
              }
              String str5 = "    ".concat(String.valueOf(str2));
              str1 = ((String)localObject1).toString().replace(str4, str5);
              i = ((Matcher)localObject2).start(0);
              j = str5.length();
              if (aw.isDarkMode())
              {
                localObject1 = new com.tencent.mm.pluginsdk.ui.applet.z(i + 1, i + 3, c.g.spannable_app_brand_link_logo_dark);
                label462:
                this.Yph.add(localObject1);
                localObject1 = new JSONObject();
              }
            }
          }
        }
      }
      try
      {
        ((JSONObject)localObject1).put("fullText", str1);
        ((JSONObject)localObject1).put("linkText", str2);
        ((JSONObject)localObject1).put("path", localObject3);
        label514:
        localObject1 = new u(str3, 45, ((JSONObject)localObject1).toString());
        ((u)localObject1).start = (i + 4);
        ((u)localObject1).end = (i + j);
        this.Ypf.add(localObject1);
        localObject1 = str1;
        break label295;
        localObject1 = new com.tencent.mm.pluginsdk.ui.applet.z(i + 1, i + 3, c.g.spannable_app_brand_link_logo);
        break label462;
        Log.e("MicroMsg.SpanProcessor", "url && appId is null, continue");
        continue;
        localObject2 = o.a.Yoh.matcher((CharSequence)localObject1);
        continue;
        AppMethodBeat.o(152354);
        return localObject1;
      }
      catch (JSONException localJSONException)
      {
        break label514;
      }
    }
  }
  
  private void aC(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152355);
    if (this.Ypn) {
      this.Ypg.addAll(aD(paramCharSequence));
    }
    if (this.Ypj) {
      this.Ypg.addAll(aF(paramCharSequence));
    }
    if (this.Ypl) {
      this.Ypg.addAll(aG(paramCharSequence));
    }
    if (this.Ypr) {
      this.Ypg.addAll(aM(paramCharSequence));
    }
    if (this.Ypo) {
      this.Ypg.addAll(aH(paramCharSequence));
    }
    if (this.Ypp) {
      this.Ypg.addAll(aI(paramCharSequence));
    }
    if (this.Yps) {
      this.Ypg.addAll(aJ(paramCharSequence));
    }
    if (this.Ypm) {
      this.Ypg.addAll(aK(paramCharSequence));
    }
    if (this.Ypq) {
      this.Ypg.addAll(aL(paramCharSequence));
    }
    if (this.Ypy) {
      this.Ypg.addAll(aE(paramCharSequence));
    }
    if (this.Ypx) {
      this.Ypg.addAll(aN(paramCharSequence));
    }
    AppMethodBeat.o(152355);
  }
  
  private ArrayList<a> aD(CharSequence paramCharSequence)
  {
    int i = 2000;
    AppMethodBeat.i(152356);
    ArrayList localArrayList = new ArrayList();
    Object localObject = o.a.Yor;
    if (paramCharSequence.length() > 2000) {}
    for (;;)
    {
      paramCharSequence = ((Pattern)localObject).matcher(paramCharSequence.subSequence(0, i));
      while (paramCharSequence.find())
      {
        i = paramCharSequence.start();
        int j = paramCharSequence.end();
        localObject = new u(paramCharSequence.group(), 24, null);
        ((u)localObject).start = i;
        ((u)localObject).end = j;
        if (!a(this.Ypg, new a(i, j)))
        {
          this.Ypf.add(localObject);
          localArrayList.add(new a(i, j));
        }
      }
      i = paramCharSequence.length();
    }
    AppMethodBeat.o(152356);
    return localArrayList;
  }
  
  private ArrayList<a> aE(CharSequence paramCharSequence)
  {
    int i = 2000;
    AppMethodBeat.i(152357);
    ArrayList localArrayList = new ArrayList();
    Object localObject = o.a.Yos;
    if (paramCharSequence.length() > 2000) {}
    for (;;)
    {
      paramCharSequence = ((Pattern)localObject).matcher(paramCharSequence.subSequence(0, i));
      while (paramCharSequence.find())
      {
        i = paramCharSequence.start();
        int j = paramCharSequence.end();
        localObject = new u(paramCharSequence.group(), 48, null);
        ((u)localObject).start = i;
        ((u)localObject).end = j;
        if (!a(this.Ypg, new a(i, j)))
        {
          this.Ypf.add(localObject);
          localArrayList.add(new a(i, j));
        }
      }
      i = paramCharSequence.length();
    }
    AppMethodBeat.o(152357);
    return localArrayList;
  }
  
  private ArrayList<a> aF(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152358);
    ArrayList localArrayList = new ArrayList();
    String str = paramCharSequence.toString();
    if (str.length() > 500) {
      paramCharSequence = o.a.Yoq.matcher(str.toLowerCase());
    }
    while (paramCharSequence.find())
    {
      int i = paramCharSequence.start();
      int j = paramCharSequence.end();
      if ((!a(this.Ypg, new a(i, j))) && (i >= 0) && (j <= str.length())) {
        if (j < str.length())
        {
          int k = str.charAt(j);
          if ((97 <= k) && (k <= 122)) {}
        }
        else
        {
          u localu = new u(str.substring(i, j), 1, this.YpD);
          localu.start = i;
          localu.end = j;
          this.Ypf.add(localu);
          localArrayList.add(new a(i, j));
          continue;
          paramCharSequence = o.a.Yop.matcher(str.toLowerCase());
        }
      }
    }
    AppMethodBeat.o(152358);
    return localArrayList;
  }
  
  private ArrayList<a> aG(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152359);
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = paramCharSequence.toString();
    if (paramCharSequence.length() > 200)
    {
      AppMethodBeat.o(152359);
      return localArrayList;
    }
    Matcher localMatcher = o.a.Yox.matcher(paramCharSequence);
    while (localMatcher.find())
    {
      int i = localMatcher.start();
      int j = localMatcher.end();
      if ((!a(this.Ypg, new a(i, j))) && (i >= 0) && (j <= paramCharSequence.length()))
      {
        u localu = new u(paramCharSequence.substring(i, j), 44, this.YpD);
        localu.start = i;
        localu.end = j;
        this.Ypf.add(localu);
        localArrayList.add(new a(i, j));
      }
    }
    AppMethodBeat.o(152359);
    return localArrayList;
  }
  
  private ArrayList<a> aH(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152360);
    ArrayList localArrayList = new ArrayList();
    String str = paramCharSequence.toString();
    paramCharSequence = o.a.You.matcher(paramCharSequence);
    while (paramCharSequence.find())
    {
      int i = paramCharSequence.start();
      int j = paramCharSequence.end();
      if ((!a(this.Ypg, new a(i, j))) && (i >= 0) && (j <= str.length()))
      {
        u localu = new u(str.substring(i, j), 28, null);
        localu.start = i;
        localu.end = j;
        this.Ypf.add(localu);
        localArrayList.add(new a(i, j));
      }
    }
    AppMethodBeat.o(152360);
    return localArrayList;
  }
  
  private ArrayList<a> aI(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152361);
    ArrayList localArrayList = new ArrayList();
    String str = paramCharSequence.toString();
    paramCharSequence = o.a.Yoy.matcher(paramCharSequence);
    while (paramCharSequence.find())
    {
      Object localObject = paramCharSequence.group();
      if (c.YnV.brq((String)localObject))
      {
        int i = paramCharSequence.start();
        int j = paramCharSequence.end();
        if ((!a(this.Ypg, new a(i, j))) && (i >= 0) && (j <= str.length()))
        {
          localObject = new u(str.substring(i, j), 50, this.YpD);
          ((u)localObject).start = i;
          ((u)localObject).end = j;
          this.Ypf.add(localObject);
          localArrayList.add(new a(i, j));
        }
      }
    }
    AppMethodBeat.o(152361);
    return localArrayList;
  }
  
  private ArrayList<a> aJ(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(245221);
    ArrayList localArrayList = new ArrayList();
    String str = paramCharSequence.toString();
    paramCharSequence = o.a.YoB.matcher(paramCharSequence);
    while (paramCharSequence.find())
    {
      paramCharSequence.group();
      int i = paramCharSequence.start();
      int j = paramCharSequence.end();
      if ((!a(this.Ypg, new a(i, j))) && (i >= 0) && (j <= str.length()))
      {
        u localu = new u(str.substring(i, j), 58, this.YpD);
        localu.start = i;
        localu.end = j;
        this.Ypf.add(localu);
        localArrayList.add(new a(i, j));
      }
    }
    AppMethodBeat.o(245221);
    return localArrayList;
  }
  
  private ArrayList<a> aK(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152362);
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = o.a.Yot.matcher(paramCharSequence);
    while (paramCharSequence.find())
    {
      int k = paramCharSequence.start();
      int m = paramCharSequence.end();
      Object localObject = paramCharSequence.group();
      int j = m - k;
      int i = j;
      if (((String)localObject).startsWith("+")) {
        i = j - 1;
      }
      if (((i != 6) && (i != 5)) || (("+12306+12110+12395+12121+12117+12119+95555+95566+95533+95588+95558+95599+95568+95595+95559+95508+95528+95501+95577+95561+10086+10010+10000+17951+17911+17900+118114+116114+950718+95598+12318+12315+12358+12365+12310+12369+12333+12366+95518+95519+95511+95500+95522+95567+95017".contains((CharSequence)localObject)) && (i < 100) && (!a(this.Ypg, new a(k, m)))))
      {
        localObject = new u((String)localObject, 25, this.YpD);
        ((u)localObject).start = k;
        ((u)localObject).end = m;
        this.Ypf.add(localObject);
        localArrayList.add(new a(k, m));
      }
    }
    AppMethodBeat.o(152362);
    return localArrayList;
  }
  
  private ArrayList<a> aL(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152363);
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = b.cK(this.mContext, paramCharSequence.toString()).iterator();
    while (paramCharSequence.hasNext())
    {
      u localu = (u)paramCharSequence.next();
      a locala = new a(localu.start, localu.end);
      if (!a(this.Ypg, locala))
      {
        this.Ypf.add(localu);
        localArrayList.add(locala);
      }
    }
    AppMethodBeat.o(152363);
    return localArrayList;
  }
  
  private ArrayList<a> aM(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152364);
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = paramCharSequence.toString();
    Matcher localMatcher = o.a.Yow.matcher(paramCharSequence);
    int i;
    int j;
    a locala;
    u localu;
    while (localMatcher.find())
    {
      i = localMatcher.start();
      j = localMatcher.end();
      locala = new a(i, j);
      if ((!a(this.Ypg, locala)) && (i >= 0) && (j <= paramCharSequence.length()))
      {
        localu = new u(paramCharSequence.substring(i, j), 30, null);
        localu.start = i;
        localu.end = j;
        this.Ypf.add(localu);
        localArrayList.add(locala);
      }
    }
    if (localArrayList.size() <= 0)
    {
      localMatcher = o.a.Yov.matcher(paramCharSequence);
      while (localMatcher.find())
      {
        i = localMatcher.start();
        j = localMatcher.end();
        locala = new a(i, j);
        if ((!a(this.Ypg, locala)) && (i >= 0) && (j <= paramCharSequence.length()))
        {
          localu = new u(paramCharSequence.substring(i, j), 30, null);
          localu.start = i;
          localu.end = j;
          this.Ypf.add(localu);
          localArrayList.add(locala);
        }
      }
    }
    AppMethodBeat.o(152364);
    return localArrayList;
  }
  
  private ArrayList<a> aN(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(245228);
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = paramCharSequence.toString();
    Matcher localMatcher = o.a.YoC.matcher(paramCharSequence);
    while (localMatcher.find())
    {
      int i = localMatcher.start();
      int j = localMatcher.end();
      a locala = new a(i, j);
      if ((!a(this.Ypg, locala)) && (i >= 0) && (j <= paramCharSequence.length()))
      {
        u localu = new u(paramCharSequence.substring(i, j), 60, null);
        localu.start = i;
        localu.cpt = this.YpD;
        localu.end = j;
        this.Ypf.add(localu);
        localArrayList.add(locala);
      }
    }
    AppMethodBeat.o(245228);
    return localArrayList;
  }
  
  private boolean aX(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152365);
    paramString = b.c(this.mContext, paramString, paramInt1, paramInt2);
    if (paramString != null)
    {
      if (this.YpD != null) {
        paramString.cpt = this.YpD;
      }
      this.Ypf.add(paramString);
      this.Ypg.add(new a(paramInt1, paramInt2));
      AppMethodBeat.o(152365);
      return true;
    }
    AppMethodBeat.o(152365);
    return false;
  }
  
  private String aw(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152347);
    paramCharSequence = paramCharSequence + "@" + this.YpB + "@" + this.Ypi + "@" + this.Ypj + "@" + this.Ypm + "@" + this.Ypn + "@" + this.Ypo + "@" + this.YpA + "@" + this.YpC + "@" + this.Ypt + "@" + this.Ypu + "@" + this.Ypv + "@" + this.Yps + "@" + this.lCR;
    AppMethodBeat.o(152347);
    return paramCharSequence;
  }
  
  private SpannableString ax(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152350);
    this.Ypf = new ArrayList();
    Object localObject;
    if (this.YpB <= 0)
    {
      if (this.sQ != null) {
        this.YpB = ((int)this.sQ.getTextSize());
      }
    }
    else
    {
      if (this.Ypf == null) {
        this.Ypf = new ArrayList();
      }
      if (this.Ypg == null) {
        this.Ypg = new ArrayList();
      }
      this.Ypf.clear();
      this.Ypg.clear();
      localObject = paramCharSequence;
      if (p.I(paramCharSequence))
      {
        localObject = paramCharSequence;
        if (this.Ypw)
        {
          localObject = paramCharSequence;
          if (f.a.Yoa != null) {
            if (!f.a.Yoa.ab(paramCharSequence))
            {
              localObject = paramCharSequence;
              if (!f.a.Yoa.aa(paramCharSequence)) {}
            }
            else
            {
              localObject = paramCharSequence.toString().replace("\n", "                                                                                                                                                                                                                                                                                                                        ");
            }
          }
        }
      }
      paramCharSequence = (CharSequence)localObject;
      if (this.Ypi)
      {
        if (!((CharSequence)localObject).toString().contains("data-miniprogram-appid")) {
          break label305;
        }
        paramCharSequence = aB((CharSequence)localObject);
      }
      label191:
      localObject = paramCharSequence;
      if (this.Ypt) {
        localObject = ay(paramCharSequence);
      }
      paramCharSequence = (CharSequence)localObject;
      if (this.Ypv) {
        paramCharSequence = e((CharSequence)localObject, this.Ypz);
      }
      if ((!this.Ypw) || (f.a.Yoa == null)) {
        break label355;
      }
      paramCharSequence = f.a.Yoa.a(this.mContext, paramCharSequence, this.YpB);
    }
    label305:
    label355:
    for (;;)
    {
      if (this.Ypk) {
        aC(paramCharSequence);
      }
      if ((paramCharSequence instanceof SpannableString))
      {
        paramCharSequence = (SpannableString)paramCharSequence;
        AppMethodBeat.o(152350);
        return paramCharSequence;
        this.YpB = com.tencent.mm.cd.a.br(this.mContext, c.c.NormalTextSize);
        break;
        if (((CharSequence)localObject).toString().contains("weixin://kefumenu"))
        {
          paramCharSequence = aA((CharSequence)localObject);
          break label191;
        }
        paramCharSequence = az((CharSequence)localObject);
        break label191;
      }
      paramCharSequence = new SpannableString(paramCharSequence);
      AppMethodBeat.o(152350);
      return paramCharSequence;
    }
  }
  
  private CharSequence ay(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152351);
    Object localObject2 = o.a.Yon.matcher(paramCharSequence.toString());
    Object localObject1 = paramCharSequence;
    paramCharSequence = (CharSequence)localObject2;
    if (paramCharSequence.find())
    {
      if (this.Ypu) {
        paramCharSequence = ((CharSequence)localObject1).toString().replace(paramCharSequence.group(0), "");
      }
      for (;;)
      {
        localObject2 = o.a.Yog.matcher(paramCharSequence);
        localObject1 = paramCharSequence;
        paramCharSequence = (CharSequence)localObject2;
        break;
        localObject1 = ((CharSequence)localObject1).toString().replace(paramCharSequence.group(0), "  ");
        localObject2 = paramCharSequence.group(1);
        int i = paramCharSequence.start();
        int j = this.mContext.getResources().getIdentifier(((String)localObject2).toLowerCase(), "drawable", this.mContext.getPackageName());
        if (j != 0)
        {
          paramCharSequence = new com.tencent.mm.pluginsdk.ui.applet.z(i, i + 2, j);
          if ((!Util.isNullOrNil((String)localObject2)) && ("original_label".equals(localObject2)))
          {
            paramCharSequence.height = 15;
            paramCharSequence.width = 35;
          }
          this.Yph.add(paramCharSequence);
          paramCharSequence = (CharSequence)localObject1;
        }
        else
        {
          Log.w("MicroMsg.SpanProcessor", "dz[parseImgSpan:error drawable name %s]", new Object[] { localObject2 });
          paramCharSequence = (CharSequence)localObject1;
        }
      }
    }
    AppMethodBeat.o(152351);
    return localObject1;
  }
  
  private CharSequence az(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152353);
    String str1 = paramCharSequence.toString();
    Matcher localMatcher;
    if (str1.length() < 1500) {
      localMatcher = o.a.Yog.matcher(str1);
    }
    while (localMatcher.find())
    {
      String str2 = localMatcher.group(1);
      String str3 = localMatcher.group(2);
      if (str2.length() >= 2)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (localMatcher.start(0) > 0) {
          localStringBuilder.append(str1.substring(0, localMatcher.start(0)));
        }
        localStringBuilder.append(str3);
        if (localMatcher.end(0) < str1.length()) {
          localStringBuilder.append(str1.substring(localMatcher.end(0), str1.length()));
        }
        str1 = localStringBuilder.toString();
        int i = localMatcher.start(0);
        int j = str3.length() + i;
        if ((i < 0) || (j > paramCharSequence.length()))
        {
          Log.e("MicroMsg.SpanProcessor", "parseHref error, start:%d, end:%d, source.length:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramCharSequence.length()) });
          continue;
          localMatcher = o.a.Yof.matcher(str1);
        }
        else
        {
          aX(str2, i, j);
          if (str1.length() < 1500) {
            localMatcher = o.a.Yog.matcher(str1);
          } else {
            localMatcher = o.a.Yof.matcher(str1);
          }
        }
      }
    }
    AppMethodBeat.o(152353);
    return str1;
  }
  
  public static void clearCache()
  {
    AppMethodBeat.i(152369);
    Ype.clear();
    AppMethodBeat.o(152369);
  }
  
  private CharSequence e(CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(152352);
    Object localObject2 = o.a.Yol.matcher(paramCharSequence);
    int i = 0;
    Object localObject1 = paramCharSequence;
    String str2;
    String str3;
    String str1;
    int j;
    Object localObject3;
    for (;;)
    {
      if (((Matcher)localObject2).find())
      {
        String str4 = ((Matcher)localObject2).group(0);
        str2 = ((Matcher)localObject2).group(1);
        str3 = ((Matcher)localObject2).group(2);
        str1 = ((Matcher)localObject2).group(3);
        localObject4 = str1;
        if (str1 == null) {
          localObject4 = "";
        }
        localObject1 = ((CharSequence)localObject1).toString().replace(str4, (CharSequence)localObject4);
        j = ((Matcher)localObject2).start(0);
        int k = ((String)localObject4).length() + j;
        if ((j < 0) || (k > paramCharSequence.length()))
        {
          Log.e("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error: start:%d, end:%d, source.length:%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramCharSequence.length()) });
          continue;
        }
        try
        {
          i = Color.parseColor(str2);
          if (Util.isNullOrNil(str3))
          {
            localObject2 = new u(j, k);
            ((u)localObject2).linkColor = i;
            this.Ypf.add(localObject2);
            this.Ypg.add(new a(j, k));
            localObject2 = o.a.Yol.matcher((CharSequence)localObject1);
            i = 1;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localObject3 = MMApplicationContext.getContext();
            int m = ((Context)localObject3).getResources().getIdentifier(str2, "color", ((Context)localObject3).getPackageName());
            if (m <= 0) {}
            for (i = 0;; i = MMApplicationContext.getContext().getResources().getColor(m))
            {
              Log.w("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error at color : %s, resId : %s]", new Object[] { str2, Integer.valueOf(m) });
              break;
            }
            localObject3 = b.a(this.mContext, str3, j, k, i, i & 0x99FFFFFF);
            if (localObject3 != null)
            {
              if (this.YpD != null) {
                ((u)localObject3).cpt = this.YpD;
              }
              this.Ypf.add(localObject3);
              this.Ypg.add(new a(j, k));
            }
          }
        }
      }
    }
    Object localObject4 = localObject1;
    if (i == 0)
    {
      localObject3 = o.a.Yom.matcher(paramCharSequence);
      for (;;)
      {
        localObject4 = localObject1;
        if (!((Matcher)localObject3).find()) {
          break;
        }
        str3 = ((Matcher)localObject3).group(0);
        str2 = ((Matcher)localObject3).group(1);
        str1 = ((Matcher)localObject3).group(2);
        localObject4 = str1;
        if (str1 == null) {
          localObject4 = "";
        }
        if (str2.length() >= 2)
        {
          localObject1 = ((CharSequence)localObject1).toString().replace(str3, (CharSequence)localObject4);
          i = ((Matcher)localObject3).start(0);
          j = ((String)localObject4).length() + i;
          if ((i < 0) || (j > paramCharSequence.length()))
          {
            Log.e("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error: start:%d, end:%d, source.length:%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramCharSequence.length()) });
          }
          else
          {
            if ((!aX(str2, i, j)) && (paramBoolean))
            {
              localObject3 = new u(str2, 2147483646, null);
              if (this.YpD != null) {
                ((u)localObject3).cpt = this.YpD;
              }
              ((u)localObject3).start = i;
              ((u)localObject3).end = j;
              if (!a(this.Ypg, new a(i, j)))
              {
                this.Ypf.add(localObject3);
                this.Ypg.add(new a(i, j));
              }
            }
            localObject3 = o.a.Yol.matcher((CharSequence)localObject1);
          }
        }
      }
    }
    AppMethodBeat.o(152352);
    return localObject4;
  }
  
  private static void f(Spannable paramSpannable)
  {
    AppMethodBeat.i(152349);
    Object[] arrayOfObject = paramSpannable.getSpans(0, paramSpannable.length(), Object.class);
    int k = arrayOfObject.length;
    int i = 0;
    if (i < k)
    {
      Object localObject = arrayOfObject[i];
      int j = 0;
      label42:
      if (j < YpE.length) {
        if (!YpE[j].isInstance(localObject)) {}
      }
      for (j = 1;; j = 0)
      {
        if (j == 0) {
          paramSpannable.removeSpan(localObject);
        }
        i += 1;
        break;
        j += 1;
        break label42;
      }
    }
    AppMethodBeat.o(152349);
  }
  
  private void g(Spannable paramSpannable)
  {
    AppMethodBeat.i(152367);
    if ((this.sQ != null) && (!Util.isNullOrNil(paramSpannable.toString())))
    {
      if (com.tencent.mm.platformtools.z.pCN)
      {
        this.sQ.setText(paramSpannable, TextView.BufferType.SPANNABLE);
        AppMethodBeat.o(152367);
        return;
      }
      this.sQ.setText(paramSpannable);
    }
    AppMethodBeat.o(152367);
  }
  
  public final v M(TextView paramTextView)
  {
    AppMethodBeat.i(152346);
    this.sQ = paramTextView;
    if (paramTextView != null) {
      this.mContext = this.sQ.getContext();
    }
    AppMethodBeat.o(152346);
    return this;
  }
  
  public final SpannableString b(CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(152348);
    if (paramCharSequence == null)
    {
      paramCharSequence = new SpannableString("");
      AppMethodBeat.o(152348);
      return paramCharSequence;
    }
    this.YpB = paramInt;
    Object localObject1 = aw(paramCharSequence);
    if (paramBoolean)
    {
      localObject2 = (SpannableString)Ype.get(localObject1);
      if (localObject2 != null)
      {
        f((Spannable)localObject2);
        g((Spannable)localObject2);
        a((SpannableString)localObject2);
        paramCharSequence = (t[])((SpannableString)localObject2).getSpans(0, ((SpannableString)localObject2).length(), t.class);
        int i = paramCharSequence.length;
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = paramCharSequence[paramInt].getHrefInfo();
          if ((localObject1 != null) && ((((u)localObject1).type == 60) || (((u)localObject1).type == 58) || (((u)localObject1).type == 1)) && (this.YpD != null)) {
            ((u)localObject1).cpt = this.YpD;
          }
          paramInt += 1;
        }
        AppMethodBeat.o(152348);
        return localObject2;
      }
    }
    paramCharSequence = ax(paramCharSequence);
    Object localObject3;
    if (this.YpC)
    {
      localObject2 = this.Ypf.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (u)((Iterator)localObject2).next();
        ((u)localObject3).mSessionId = this.mSessionId;
        ((u)localObject3).fromScene = this.lCR;
        if (Util.isNullOrNil(((u)localObject3).url)) {
          paramCharSequence.setSpan(new ForegroundColorSpan(((u)localObject3).linkColor), ((u)localObject3).start, ((u)localObject3).end, 33);
        } else if ((((u)localObject3).start <= paramCharSequence.length()) && (((u)localObject3).end <= paramCharSequence.length())) {
          paramCharSequence.setSpan(new t(this.YpA, (u)localObject3), ((u)localObject3).start, ((u)localObject3).end, 33);
        }
      }
    }
    Object localObject2 = this.Yph.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mm.pluginsdk.ui.applet.z)((Iterator)localObject2).next();
      if ((((com.tencent.mm.pluginsdk.ui.applet.z)localObject3).start <= paramCharSequence.length()) && (((com.tencent.mm.pluginsdk.ui.applet.z)localObject3).end <= paramCharSequence.length()))
      {
        Object localObject4 = this.mContext.getResources().getDrawable(((com.tencent.mm.pluginsdk.ui.applet.z)localObject3).id);
        if ((((com.tencent.mm.pluginsdk.ui.applet.z)localObject3).width > 0) && (((com.tencent.mm.pluginsdk.ui.applet.z)localObject3).height > 0))
        {
          ((Drawable)localObject4).setBounds(0, 0, com.tencent.mm.cd.a.fromDPToPix(this.mContext, ((com.tencent.mm.pluginsdk.ui.applet.z)localObject3).width), com.tencent.mm.cd.a.fromDPToPix(this.mContext, ((com.tencent.mm.pluginsdk.ui.applet.z)localObject3).height));
          localObject4 = new com.tencent.mm.ui.widget.a((Drawable)localObject4, 1);
          ((com.tencent.mm.ui.widget.a)localObject4).afSg = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 2);
          paramCharSequence.setSpan(localObject4, ((com.tencent.mm.pluginsdk.ui.applet.z)localObject3).start, ((com.tencent.mm.pluginsdk.ui.applet.z)localObject3).start + 1, 18);
        }
        else
        {
          if (this.sQ == null) {}
          for (paramInt = (int)(this.YpB * 1.3F);; paramInt = (int)(this.sQ.getTextSize() * 1.3F))
          {
            ((Drawable)localObject4).setBounds(0, 0, paramInt, paramInt);
            break;
          }
        }
      }
    }
    g(paramCharSequence);
    a(paramCharSequence);
    if (paramBoolean) {
      Ype.B(localObject1, new SpannableString(paramCharSequence));
    }
    AppMethodBeat.o(152348);
    return paramCharSequence;
  }
  
  final class a
  {
    private int end;
    private int start;
    
    a(int paramInt1, int paramInt2)
    {
      this.start = paramInt1;
      this.end = paramInt2;
    }
    
    final boolean a(a parama)
    {
      return (this.end > parama.start) && (parama.end > this.start);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.v
 * JD-Core Version:    0.7.0.1
 */