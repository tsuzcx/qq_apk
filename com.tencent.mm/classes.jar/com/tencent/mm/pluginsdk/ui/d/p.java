package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.a.f;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.comm.a.c;
import com.tencent.mm.plugin.comm.a.g;
import com.tencent.mm.pluginsdk.ui.applet.r;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class p
{
  private static Class<?>[] skB = { com.tencent.mm.ui.widget.a.class, n.class, ForegroundColorSpan.class };
  private static final f<String, SpannableString> ski = new f(500);
  String fKV;
  private TextView lh = null;
  private Context mContext = null;
  Object skA;
  private ArrayList<com.tencent.mm.pluginsdk.ui.applet.m> skj = new ArrayList();
  private ArrayList<a> skk = new ArrayList();
  private ArrayList<r> skl = new ArrayList();
  boolean skm = false;
  boolean skn = false;
  boolean sko = false;
  boolean skp = true;
  boolean skq = true;
  boolean skr = false;
  boolean sks = false;
  boolean skt = false;
  boolean sku = false;
  boolean skv = false;
  boolean skw = true;
  int skx = 0;
  private int sky = 0;
  boolean skz = false;
  
  public p(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private CharSequence A(CharSequence paramCharSequence)
  {
    Object localObject2 = i.a.sjx.matcher(paramCharSequence.toString());
    Object localObject1 = paramCharSequence;
    paramCharSequence = (CharSequence)localObject2;
    if (paramCharSequence.find())
    {
      if (this.sku) {
        paramCharSequence = ((CharSequence)localObject1).toString().replace(paramCharSequence.group(0), "");
      }
      for (;;)
      {
        localObject2 = i.a.sjs.matcher(paramCharSequence);
        localObject1 = paramCharSequence;
        paramCharSequence = (CharSequence)localObject2;
        break;
        localObject1 = ((CharSequence)localObject1).toString().replace(paramCharSequence.group(0), "  ");
        localObject2 = paramCharSequence.group(1);
        int i = paramCharSequence.start();
        int j = this.mContext.getResources().getIdentifier(((String)localObject2).toLowerCase(), "drawable", this.mContext.getPackageName());
        if (j != 0)
        {
          paramCharSequence = new r(i, i + 2, j);
          if ((!bk.bl((String)localObject2)) && ("original_label".equals(localObject2)))
          {
            paramCharSequence.height = 15;
            paramCharSequence.width = 35;
          }
          this.skl.add(paramCharSequence);
          paramCharSequence = (CharSequence)localObject1;
        }
        else
        {
          y.w("MicroMsg.SpanProcessor", "dz[parseImgSpan:error drawable name %s]", new Object[] { localObject2 });
          paramCharSequence = (CharSequence)localObject1;
        }
      }
    }
    return localObject1;
  }
  
  private CharSequence B(CharSequence paramCharSequence)
  {
    Object localObject2 = i.a.sjv.matcher(paramCharSequence);
    int i = 0;
    Object localObject1 = paramCharSequence;
    String str1;
    String str2;
    int j;
    Object localObject3;
    for (;;)
    {
      if (((Matcher)localObject2).find())
      {
        String str3 = ((Matcher)localObject2).group(0);
        localObject4 = ((Matcher)localObject2).group(1);
        str1 = ((Matcher)localObject2).group(2);
        str2 = ((Matcher)localObject2).group(3);
        localObject1 = ((CharSequence)localObject1).toString().replace(str3, str2);
        j = ((Matcher)localObject2).start(0);
        int k = str2.length() + j;
        if ((j < 0) || (k > paramCharSequence.length()))
        {
          y.e("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error: start:%d, end:%d, source.length:%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramCharSequence.length()) });
          continue;
        }
        try
        {
          i = Color.parseColor((String)localObject4);
          if (bk.bl(str1))
          {
            localObject2 = new com.tencent.mm.pluginsdk.ui.applet.m(j, k);
            ((com.tencent.mm.pluginsdk.ui.applet.m)localObject2).linkColor = i;
            this.skj.add(localObject2);
            this.skk.add(new a(j, k));
            localObject2 = i.a.sjv.matcher((CharSequence)localObject1);
            i = 1;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            y.w("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error at color : %s]", new Object[] { localObject4 });
            i = 0;
            continue;
            localObject3 = a.a(this.mContext, str1, j, k, i, i & 0x99FFFFFF);
            if (localObject3 != null)
            {
              if (this.skA != null) {
                ((com.tencent.mm.pluginsdk.ui.applet.m)localObject3).data = this.skA;
              }
              this.skj.add(localObject3);
              this.skk.add(new a(j, k));
            }
          }
        }
      }
    }
    Object localObject4 = localObject1;
    if (i == 0)
    {
      localObject3 = i.a.sjw.matcher(paramCharSequence);
      for (;;)
      {
        localObject4 = localObject1;
        if (!((Matcher)localObject3).find()) {
          break;
        }
        str2 = ((Matcher)localObject3).group(0);
        localObject4 = ((Matcher)localObject3).group(1);
        str1 = ((Matcher)localObject3).group(2);
        if (((String)localObject4).length() >= 2)
        {
          localObject1 = ((CharSequence)localObject1).toString().replace(str2, str1);
          i = ((Matcher)localObject3).start(0);
          j = str1.length() + i;
          if ((i < 0) || (j > paramCharSequence.length()))
          {
            y.e("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error: start:%d, end:%d, source.length:%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramCharSequence.length()) });
          }
          else
          {
            ai((String)localObject4, i, j);
            localObject3 = i.a.sjv.matcher((CharSequence)localObject1);
          }
        }
      }
    }
    return localObject4;
  }
  
  private CharSequence C(CharSequence paramCharSequence)
  {
    String str1 = paramCharSequence.toString();
    Matcher localMatcher;
    if (str1.length() < 1500) {
      localMatcher = i.a.sjs.matcher(str1);
    }
    while (localMatcher.find())
    {
      String str4 = localMatcher.group(0);
      String str2 = localMatcher.group(1);
      String str3 = localMatcher.group(2);
      if (str2.length() >= 2)
      {
        str1 = str1.toString().replace(str4, str3);
        int i = localMatcher.start(0);
        int j = str3.length() + i;
        if ((i < 0) || (j > paramCharSequence.length()))
        {
          y.e("MicroMsg.SpanProcessor", "parseHref error, start:%d, end:%d, source.length:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramCharSequence.length()) });
          continue;
          localMatcher = i.a.sjr.matcher(str1);
        }
        else
        {
          ai(str2, i, j);
          if (str1.length() < 1500) {
            localMatcher = i.a.sjs.matcher(str1);
          } else {
            localMatcher = i.a.sjr.matcher(str1);
          }
        }
      }
    }
    return str1;
  }
  
  private CharSequence D(CharSequence paramCharSequence)
  {
    String str1 = paramCharSequence.toString();
    Object localObject1;
    if (str1.length() < 1500) {
      localObject1 = i.a.sju.matcher(str1);
    }
    while (((Matcher)localObject1).find())
    {
      String str5 = ((Matcher)localObject1).group(0);
      String str3 = ((Matcher)localObject1).group(1);
      String str4 = ((Matcher)localObject1).group(2);
      Object localObject2 = bn.s(str5.replace(str3, " ").replace(str4, " "), "a");
      if (localObject2 == null)
      {
        y.e("MicroMsg.SpanProcessor", "XmlParser parse return null, so continue");
        continue;
        localObject1 = i.a.sjt.matcher(str1);
      }
      else
      {
        String str2 = (String)((Map)localObject2).get(".a.$data-miniprogram-appid");
        localObject2 = (String)((Map)localObject2).get(".a.$data-miniprogram-path");
        int i;
        label156:
        int j;
        if (!bk.bl(str3))
        {
          i = 1;
          if (bk.bl(str2)) {
            break label272;
          }
          j = 1;
        }
        for (;;)
        {
          if ((i != 0) && (j == 0))
          {
            if (str3.length() < 2) {
              break;
            }
            str1 = str1.toString().replace(str5, str4);
            i = ((Matcher)localObject1).start(0);
            j = str4.length() + i;
            if ((i < 0) || (j > paramCharSequence.length()))
            {
              y.e("MicroMsg.SpanProcessor", "parseHref error, start:%d, end:%d, source.length:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramCharSequence.length()) });
              break;
              i = 0;
              break label156;
              label272:
              j = 0;
              continue;
            }
            ai(str3, i, j);
          }
        }
        for (;;)
        {
          if (str1.length() < 1500)
          {
            localObject1 = i.a.sju.matcher(str1);
            break;
            if (j != 0)
            {
              if (this.sku)
              {
                str1 = str1.toString().replace(str5, str4);
                i = ((Matcher)localObject1).start(0);
                j = str4.length();
                localObject1 = new com.tencent.mm.pluginsdk.ui.applet.m(str3, 45, null);
                ((com.tencent.mm.pluginsdk.ui.applet.m)localObject1).start = i;
                ((com.tencent.mm.pluginsdk.ui.applet.m)localObject1).end = (j + i);
                this.skj.add(localObject1);
              }
              else
              {
                str3 = "    " + str4;
                str1 = str1.toString().replace(str5, str3);
                i = ((Matcher)localObject1).start(0);
                j = str3.length();
                localObject1 = new r(i + 1, i + 3, a.g.spannable_app_brand_link_logo);
                this.skl.add(localObject1);
                localObject1 = new com.tencent.mm.pluginsdk.ui.applet.m(str2, 45, localObject2);
                ((com.tencent.mm.pluginsdk.ui.applet.m)localObject1).start = (i + 4);
                ((com.tencent.mm.pluginsdk.ui.applet.m)localObject1).end = (j + i);
                this.skj.add(localObject1);
              }
            }
            else
            {
              y.e("MicroMsg.SpanProcessor", "url && appId is null, continue");
              break;
            }
          }
        }
        localObject1 = i.a.sjt.matcher(str1);
      }
    }
    return str1;
  }
  
  private ArrayList<a> E(CharSequence paramCharSequence)
  {
    int i = 2000;
    ArrayList localArrayList = new ArrayList();
    Object localObject = i.a.sjB;
    if (paramCharSequence.length() > 2000) {}
    for (;;)
    {
      paramCharSequence = ((Pattern)localObject).matcher(paramCharSequence.subSequence(0, i));
      while (paramCharSequence.find())
      {
        i = paramCharSequence.start();
        int j = paramCharSequence.end();
        localObject = new com.tencent.mm.pluginsdk.ui.applet.m(paramCharSequence.group(), 24, null);
        ((com.tencent.mm.pluginsdk.ui.applet.m)localObject).start = i;
        ((com.tencent.mm.pluginsdk.ui.applet.m)localObject).end = j;
        if (!a(this.skk, new a(i, j)))
        {
          this.skj.add(localObject);
          localArrayList.add(new a(i, j));
        }
      }
      i = paramCharSequence.length();
    }
    return localArrayList;
  }
  
  private ArrayList<a> F(CharSequence paramCharSequence)
  {
    ArrayList localArrayList = new ArrayList();
    String str = paramCharSequence.toString();
    if (str.length() > 500) {
      paramCharSequence = i.a.sjA.matcher(str.toLowerCase());
    }
    while (paramCharSequence.find())
    {
      int i = paramCharSequence.start();
      int j = paramCharSequence.end();
      if ((!a(this.skk, new a(i, j))) && (i >= 0) && (j <= str.length())) {
        if (j < str.length())
        {
          int k = str.charAt(j);
          if ((97 <= k) && (k <= 122)) {}
        }
        else
        {
          com.tencent.mm.pluginsdk.ui.applet.m localm = new com.tencent.mm.pluginsdk.ui.applet.m(str.substring(i, j), 1, this.skA);
          localm.start = i;
          localm.end = j;
          this.skj.add(localm);
          localArrayList.add(new a(i, j));
          continue;
          paramCharSequence = i.a.sjz.matcher(str.toLowerCase());
        }
      }
    }
    return localArrayList;
  }
  
  private ArrayList<a> G(CharSequence paramCharSequence)
  {
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = paramCharSequence.toString();
    if (paramCharSequence.length() > 200) {}
    for (;;)
    {
      return localArrayList;
      Matcher localMatcher = i.a.sjG.matcher(paramCharSequence);
      while (localMatcher.find())
      {
        int i = localMatcher.start();
        int j = localMatcher.end();
        if ((!a(this.skk, new a(i, j))) && (i >= 0) && (j <= paramCharSequence.length()))
        {
          com.tencent.mm.pluginsdk.ui.applet.m localm = new com.tencent.mm.pluginsdk.ui.applet.m(paramCharSequence.substring(i, j), 44, this.skA);
          localm.start = i;
          localm.end = j;
          this.skj.add(localm);
          localArrayList.add(new a(i, j));
        }
      }
    }
  }
  
  private ArrayList<a> H(CharSequence paramCharSequence)
  {
    ArrayList localArrayList = new ArrayList();
    String str = paramCharSequence.toString();
    paramCharSequence = i.a.sjD.matcher(paramCharSequence);
    while (paramCharSequence.find())
    {
      int i = paramCharSequence.start();
      int j = paramCharSequence.end();
      if ((!a(this.skk, new a(i, j))) && (i >= 0) && (j <= str.length()))
      {
        com.tencent.mm.pluginsdk.ui.applet.m localm = new com.tencent.mm.pluginsdk.ui.applet.m(str.substring(i, j), 28, null);
        localm.start = i;
        localm.end = j;
        this.skj.add(localm);
        localArrayList.add(new a(i, j));
      }
    }
    return localArrayList;
  }
  
  private ArrayList<a> I(CharSequence paramCharSequence)
  {
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = i.a.sjC.matcher(paramCharSequence);
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
      if (((i != 6) && (i != 5)) || (("+12306+12110+12395+12121+12117+12119+95555+95566+95533+95588+95558+95599+95568+95595+95559+95508+95528+95501+95577+95561+10086+10010+10000+17951+17911+17900+118114+116114+950718+95598+12318+12315+12358+12365+12310+12369+12333+12366+95518+95519+95511+95500+95522+95567".contains((CharSequence)localObject)) && (i < 24) && (!a(this.skk, new a(k, m)))))
      {
        localObject = new com.tencent.mm.pluginsdk.ui.applet.m((String)localObject, 25, this.skA);
        ((com.tencent.mm.pluginsdk.ui.applet.m)localObject).start = k;
        ((com.tencent.mm.pluginsdk.ui.applet.m)localObject).end = m;
        this.skj.add(localObject);
        localArrayList.add(new a(k, m));
      }
    }
    return localArrayList;
  }
  
  private ArrayList<a> J(CharSequence paramCharSequence)
  {
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = a.bn(this.mContext, paramCharSequence.toString()).iterator();
    while (paramCharSequence.hasNext())
    {
      com.tencent.mm.pluginsdk.ui.applet.m localm = (com.tencent.mm.pluginsdk.ui.applet.m)paramCharSequence.next();
      a locala = new a(localm.start, localm.end);
      if (!a(this.skk, locala))
      {
        this.skj.add(localm);
        localArrayList.add(locala);
      }
    }
    return localArrayList;
  }
  
  private ArrayList<a> K(CharSequence paramCharSequence)
  {
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = paramCharSequence.toString();
    Matcher localMatcher = i.a.sjF.matcher(paramCharSequence);
    int i;
    int j;
    a locala;
    com.tencent.mm.pluginsdk.ui.applet.m localm;
    while (localMatcher.find())
    {
      i = localMatcher.start();
      j = localMatcher.end();
      locala = new a(i, j);
      if ((!a(this.skk, locala)) && (i >= 0) && (j <= paramCharSequence.length()))
      {
        localm = new com.tencent.mm.pluginsdk.ui.applet.m(paramCharSequence.substring(i, j), 30, null);
        localm.start = i;
        localm.end = j;
        this.skj.add(localm);
        localArrayList.add(locala);
      }
    }
    if (localArrayList.size() <= 0)
    {
      localMatcher = i.a.sjE.matcher(paramCharSequence);
      while (localMatcher.find())
      {
        i = localMatcher.start();
        j = localMatcher.end();
        locala = new a(i, j);
        if ((!a(this.skk, locala)) && (i >= 0) && (j <= paramCharSequence.length()))
        {
          localm = new com.tencent.mm.pluginsdk.ui.applet.m(paramCharSequence.substring(i, j), 30, null);
          localm.start = i;
          localm.end = j;
          this.skj.add(localm);
          localArrayList.add(locala);
        }
      }
    }
    return localArrayList;
  }
  
  private void a(SpannableString paramSpannableString)
  {
    int i = 0;
    if (this.lh != null)
    {
      paramSpannableString = new m();
      paramSpannableString.fKV = this.fKV;
      this.lh.setOnTouchListener(paramSpannableString);
    }
    for (;;)
    {
      return;
      if (paramSpannableString != null)
      {
        paramSpannableString = (n[])paramSpannableString.getSpans(0, paramSpannableString.length(), n.class);
        if ((paramSpannableString == null) || (paramSpannableString.length <= 0) || (this.fKV == null)) {
          break;
        }
        int j = paramSpannableString.length;
        while (i < j)
        {
          paramSpannableString[i].setSessionId(this.fKV);
          i += 1;
        }
      }
    }
  }
  
  private static boolean a(ArrayList<a> paramArrayList, a parama)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      a locala = (a)paramArrayList.next();
      if ((locala.end > parama.start) && (parama.end > locala.start)) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  private boolean ai(String paramString, int paramInt1, int paramInt2)
  {
    paramString = a.a(this.mContext, paramString, paramInt1, paramInt2);
    if (paramString != null)
    {
      if (this.skA != null) {
        paramString.data = this.skA;
      }
      this.skj.add(paramString);
      this.skk.add(new a(paramInt1, paramInt2));
      return true;
    }
    return false;
  }
  
  public static void clearCache()
  {
    ski.clear();
  }
  
  private static void e(Spannable paramSpannable)
  {
    Object[] arrayOfObject = paramSpannable.getSpans(0, paramSpannable.length(), Object.class);
    int k = arrayOfObject.length;
    int i = 0;
    if (i < k)
    {
      Object localObject = arrayOfObject[i];
      int j = 0;
      label36:
      if (j < skB.length) {
        if (!skB[j].isInstance(localObject)) {}
      }
      for (j = 1;; j = 0)
      {
        if (j == 0) {
          paramSpannable.removeSpan(localObject);
        }
        i += 1;
        break;
        j += 1;
        break label36;
      }
    }
  }
  
  private void f(Spannable paramSpannable)
  {
    if ((this.lh != null) && (!bk.bl(paramSpannable.toString())))
    {
      if (ae.eTo) {
        this.lh.setText(paramSpannable, TextView.BufferType.SPANNABLE);
      }
    }
    else {
      return;
    }
    this.lh.setText(paramSpannable);
  }
  
  public final SpannableString a(CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    if (paramCharSequence == null) {
      return new SpannableString("");
    }
    this.sky = paramInt;
    String str = paramCharSequence + "@" + this.sky + "@" + this.skm + "@" + this.sko + "@" + this.skp + "@" + this.skq + "@" + this.skx + "@" + this.skz + "@" + this.skt + "@" + this.sku + "@" + this.skv;
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = (SpannableString)ski.get(str);
      if (localObject1 != null)
      {
        e((Spannable)localObject1);
        f((Spannable)localObject1);
        a((SpannableString)localObject1);
        return localObject1;
      }
    }
    this.skj = new ArrayList();
    if (this.sky <= 0)
    {
      if (this.lh != null) {
        this.sky = ((int)this.lh.getTextSize());
      }
    }
    else
    {
      if (this.skj == null) {
        this.skj = new ArrayList();
      }
      if (this.skk == null) {
        this.skk = new ArrayList();
      }
      this.skj.clear();
      this.skk.clear();
      if (paramCharSequence == null) {
        break label768;
      }
      if (q.dyn.dwZ != 1) {
        break label732;
      }
      paramInt = 1;
      label310:
      localObject1 = paramCharSequence;
      if (paramInt != 0)
      {
        localObject1 = paramCharSequence;
        if (this.skw)
        {
          localObject1 = paramCharSequence;
          if (d.a.sjp != null) {
            if (!d.a.sjp.w(paramCharSequence))
            {
              localObject1 = paramCharSequence;
              if (!d.a.sjp.v(paramCharSequence)) {}
            }
            else
            {
              localObject1 = paramCharSequence.toString().replace("\n", "                                                                                                                                                                                                                                                                                                                        ");
            }
          }
        }
      }
      paramCharSequence = (CharSequence)localObject1;
      if (this.skm)
      {
        if (!((CharSequence)localObject1).toString().contains("data-miniprogram-appid")) {
          break label773;
        }
        paramCharSequence = D((CharSequence)localObject1);
      }
      label413:
      localObject1 = paramCharSequence;
      if (this.skt) {
        localObject1 = A(paramCharSequence);
      }
      paramCharSequence = (CharSequence)localObject1;
      if (this.skv) {
        paramCharSequence = B((CharSequence)localObject1);
      }
      if ((!this.skw) || (d.a.sjp == null)) {
        break label1095;
      }
      paramCharSequence = d.a.sjp.g(paramCharSequence, this.sky);
    }
    label768:
    label773:
    label1095:
    for (;;)
    {
      if (this.skp) {
        this.skk.addAll(E(paramCharSequence));
      }
      if (this.skm) {
        this.skk.addAll(F(paramCharSequence));
      }
      if (this.skn) {
        this.skk.addAll(G(paramCharSequence));
      }
      if (this.sks) {
        this.skk.addAll(K(paramCharSequence));
      }
      if (this.skq) {
        this.skk.addAll(H(paramCharSequence));
      }
      if (this.sko) {
        this.skk.addAll(I(paramCharSequence));
      }
      if (this.skr) {
        this.skk.addAll(J(paramCharSequence));
      }
      label626:
      Object localObject2;
      if ((paramCharSequence instanceof Spannable))
      {
        paramCharSequence = (SpannableString)paramCharSequence;
        if (this.skz) {
          localObject1 = this.skj.iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label851;
          }
          localObject2 = (com.tencent.mm.pluginsdk.ui.applet.m)((Iterator)localObject1).next();
          ((com.tencent.mm.pluginsdk.ui.applet.m)localObject2).fKV = this.fKV;
          if (bk.bl(((com.tencent.mm.pluginsdk.ui.applet.m)localObject2).url))
          {
            paramCharSequence.setSpan(new ForegroundColorSpan(((com.tencent.mm.pluginsdk.ui.applet.m)localObject2).linkColor), ((com.tencent.mm.pluginsdk.ui.applet.m)localObject2).start, ((com.tencent.mm.pluginsdk.ui.applet.m)localObject2).end, 33);
            continue;
            this.sky = com.tencent.mm.cb.a.aa(this.mContext, a.c.NormalTextSize);
            break;
            label732:
            if ((Build.VERSION.SDK_INT == 16) && (bk.aM(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) < 0))
            {
              paramInt = 1;
              break label310;
            }
            paramInt = 0;
            break label310;
            paramCharSequence = C((CharSequence)localObject1);
            break label413;
            paramCharSequence = new SpannableString(paramCharSequence);
            break label626;
          }
          if ((((com.tencent.mm.pluginsdk.ui.applet.m)localObject2).start <= paramCharSequence.length()) && (((com.tencent.mm.pluginsdk.ui.applet.m)localObject2).end <= paramCharSequence.length())) {
            paramCharSequence.setSpan(new n(this.skx, (com.tencent.mm.pluginsdk.ui.applet.m)localObject2), ((com.tencent.mm.pluginsdk.ui.applet.m)localObject2).start, ((com.tencent.mm.pluginsdk.ui.applet.m)localObject2).end, 33);
          }
        }
      }
      label851:
      localObject1 = this.skl.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (r)((Iterator)localObject1).next();
        if ((((r)localObject2).start <= paramCharSequence.length()) && (((r)localObject2).end <= paramCharSequence.length()))
        {
          Object localObject3 = this.mContext.getResources().getDrawable(((r)localObject2).id);
          if ((((r)localObject2).width > 0) && (((r)localObject2).height > 0))
          {
            ((Drawable)localObject3).setBounds(0, 0, com.tencent.mm.cb.a.fromDPToPix(this.mContext, ((r)localObject2).width), com.tencent.mm.cb.a.fromDPToPix(this.mContext, ((r)localObject2).height));
            localObject3 = new com.tencent.mm.ui.widget.a((Drawable)localObject3);
            ((com.tencent.mm.ui.widget.a)localObject3).wjc = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 2);
            paramCharSequence.setSpan(localObject3, ((r)localObject2).start, ((r)localObject2).start + 1, 18);
          }
          else
          {
            if (this.lh == null) {}
            for (paramInt = (int)(this.sky * 1.3F);; paramInt = (int)(this.lh.getTextSize() * 1.3F))
            {
              ((Drawable)localObject3).setBounds(0, 0, paramInt, paramInt);
              break;
            }
          }
        }
      }
      f(paramCharSequence);
      a(paramCharSequence);
      if (paramBoolean) {
        ski.f(str, new SpannableString(paramCharSequence));
      }
      return paramCharSequence;
    }
  }
  
  public final p i(TextView paramTextView)
  {
    this.lh = paramTextView;
    if (paramTextView != null) {
      this.mContext = this.lh.getContext();
    }
    return this;
  }
  
  final class a
  {
    int end;
    int start;
    
    a(int paramInt1, int paramInt2)
    {
      this.start = paramInt1;
      this.end = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.p
 * JD-Core Version:    0.7.0.1
 */