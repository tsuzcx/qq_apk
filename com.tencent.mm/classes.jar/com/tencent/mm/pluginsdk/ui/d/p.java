package com.tencent.mm.pluginsdk.ui.d;

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
import com.tencent.mm.a.f;
import com.tencent.mm.compatible.util.o;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.pluginsdk.ui.applet.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class p
{
  private static final f<String, SpannableString> wcL;
  private static Class<?>[] wdh;
  private Context mContext;
  String mSessionId;
  private TextView md;
  private ArrayList<com.tencent.mm.pluginsdk.ui.applet.m> wcM;
  private ArrayList<a> wcN;
  private ArrayList<r> wcO;
  boolean wcP;
  boolean wcQ;
  boolean wcR;
  boolean wcS;
  boolean wcT;
  boolean wcU;
  boolean wcV;
  boolean wcW;
  boolean wcX;
  boolean wcY;
  boolean wcZ;
  boolean wda;
  boolean wdb;
  boolean wdc;
  int wdd;
  private int wde;
  boolean wdf;
  Object wdg;
  
  static
  {
    AppMethodBeat.i(79907);
    wcL = new c(500);
    wdh = new Class[] { com.tencent.mm.ui.widget.a.class, n.class, ForegroundColorSpan.class };
    AppMethodBeat.o(79907);
  }
  
  public p(Context paramContext)
  {
    AppMethodBeat.i(79883);
    this.wcM = new ArrayList();
    this.wcN = new ArrayList();
    this.wcO = new ArrayList();
    this.md = null;
    this.wcP = false;
    this.wcQ = true;
    this.wcR = false;
    this.wcS = false;
    this.wcT = true;
    this.wcU = true;
    this.wcV = false;
    this.wcW = false;
    this.wcX = false;
    this.wcY = false;
    this.wcZ = false;
    this.wda = true;
    this.wdb = false;
    this.wdc = false;
    this.wdd = 0;
    this.wde = 0;
    this.mContext = null;
    this.wdf = false;
    this.wcM = new ArrayList();
    this.wcN = new ArrayList();
    this.wcO = new ArrayList();
    this.mContext = paramContext;
    AppMethodBeat.o(79883);
  }
  
  private String M(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(79885);
    paramCharSequence = paramCharSequence + "@" + this.wde + "@" + this.wcP + "@" + this.wcS + "@" + this.wcT + "@" + this.wcU + "@" + this.wdd + "@" + this.wdf + "@" + this.wcX + "@" + this.wcY + "@" + this.wcZ;
    AppMethodBeat.o(79885);
    return paramCharSequence;
  }
  
  private SpannableString N(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(79888);
    this.wcM = new ArrayList();
    Object localObject;
    if (this.wde <= 0)
    {
      if (this.md != null) {
        this.wde = ((int)this.md.getTextSize());
      }
    }
    else
    {
      if (this.wcM == null) {
        this.wcM = new ArrayList();
      }
      if (this.wcN == null) {
        this.wcN = new ArrayList();
      }
      this.wcM.clear();
      this.wcN.clear();
      localObject = paramCharSequence;
      if (o.r(paramCharSequence))
      {
        localObject = paramCharSequence;
        if (this.wda)
        {
          localObject = paramCharSequence;
          if (d.a.wbV != null) {
            if (!d.a.wbV.F(paramCharSequence))
            {
              localObject = paramCharSequence;
              if (!d.a.wbV.E(paramCharSequence)) {}
            }
            else
            {
              localObject = paramCharSequence.toString().replace("\n", "                                                                                                                                                                                                                                                                                                                        ");
            }
          }
        }
      }
      paramCharSequence = (CharSequence)localObject;
      if (this.wcP)
      {
        if (!((CharSequence)localObject).toString().contains("data-miniprogram-appid")) {
          break label295;
        }
        paramCharSequence = Q((CharSequence)localObject);
      }
      label187:
      localObject = paramCharSequence;
      if (this.wcX) {
        localObject = O(paramCharSequence);
      }
      paramCharSequence = (CharSequence)localObject;
      if (this.wcZ) {
        paramCharSequence = b((CharSequence)localObject, this.wdc);
      }
      if ((!this.wda) || (d.a.wbV == null)) {
        break label320;
      }
      paramCharSequence = d.a.wbV.p(paramCharSequence, this.wde);
    }
    label295:
    label320:
    for (;;)
    {
      if (this.wcQ) {
        R(paramCharSequence);
      }
      if ((paramCharSequence instanceof Spannable))
      {
        paramCharSequence = (SpannableString)paramCharSequence;
        AppMethodBeat.o(79888);
        return paramCharSequence;
        this.wde = com.tencent.mm.cb.a.ao(this.mContext, 2131427809);
        break;
        paramCharSequence = P((CharSequence)localObject);
        break label187;
      }
      paramCharSequence = new SpannableString(paramCharSequence);
      AppMethodBeat.o(79888);
      return paramCharSequence;
    }
  }
  
  private CharSequence O(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(79889);
    Object localObject2 = i.a.wcd.matcher(paramCharSequence.toString());
    Object localObject1 = paramCharSequence;
    paramCharSequence = (CharSequence)localObject2;
    if (paramCharSequence.find())
    {
      if (this.wcY) {
        paramCharSequence = ((CharSequence)localObject1).toString().replace(paramCharSequence.group(0), "");
      }
      for (;;)
      {
        localObject2 = i.a.wbY.matcher(paramCharSequence);
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
          if ((!bo.isNullOrNil((String)localObject2)) && ("original_label".equals(localObject2)))
          {
            paramCharSequence.height = 15;
            paramCharSequence.width = 35;
          }
          this.wcO.add(paramCharSequence);
          paramCharSequence = (CharSequence)localObject1;
        }
        else
        {
          ab.w("MicroMsg.SpanProcessor", "dz[parseImgSpan:error drawable name %s]", new Object[] { localObject2 });
          paramCharSequence = (CharSequence)localObject1;
        }
      }
    }
    AppMethodBeat.o(79889);
    return localObject1;
  }
  
  private CharSequence P(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(79891);
    String str1 = paramCharSequence.toString();
    Matcher localMatcher;
    if (str1.length() < 1500) {
      localMatcher = i.a.wbY.matcher(str1);
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
          ab.e("MicroMsg.SpanProcessor", "parseHref error, start:%d, end:%d, source.length:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramCharSequence.length()) });
          continue;
          localMatcher = i.a.wbX.matcher(str1);
        }
        else
        {
          ay(str2, i, j);
          if (str1.length() < 1500) {
            localMatcher = i.a.wbY.matcher(str1);
          } else {
            localMatcher = i.a.wbX.matcher(str1);
          }
        }
      }
    }
    AppMethodBeat.o(79891);
    return str1;
  }
  
  private CharSequence Q(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(79892);
    String str1 = paramCharSequence.toString();
    Object localObject1;
    if (str1.length() < 1500) {
      localObject1 = i.a.wca.matcher(str1);
    }
    while (((Matcher)localObject1).find())
    {
      String str5 = ((Matcher)localObject1).group(0);
      String str3 = ((Matcher)localObject1).group(1);
      String str4 = ((Matcher)localObject1).group(2);
      Object localObject2 = br.F(str5.replace(str3, " ").replace(str4, " "), "a");
      if (localObject2 == null)
      {
        ab.e("MicroMsg.SpanProcessor", "XmlParser parse return null, so continue");
        continue;
        localObject1 = i.a.wbZ.matcher(str1);
      }
      else
      {
        String str2 = (String)((Map)localObject2).get(".a.$data-miniprogram-appid");
        localObject2 = (String)((Map)localObject2).get(".a.$data-miniprogram-path");
        int i;
        label163:
        int j;
        if (!bo.isNullOrNil(str3))
        {
          i = 1;
          if (bo.isNullOrNil(str2)) {
            break label280;
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
              ab.e("MicroMsg.SpanProcessor", "parseHref error, start:%d, end:%d, source.length:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramCharSequence.length()) });
              break;
              i = 0;
              break label163;
              label280:
              j = 0;
              continue;
            }
            ay(str3, i, j);
          }
        }
        for (;;)
        {
          if (str1.length() < 1500)
          {
            localObject1 = i.a.wca.matcher(str1);
            break;
            if (j != 0)
            {
              if (this.wcY)
              {
                str1 = str1.toString().replace(str5, str4);
                i = ((Matcher)localObject1).start(0);
                j = str4.length();
                localObject1 = new com.tencent.mm.pluginsdk.ui.applet.m(str3, 45, null);
                ((com.tencent.mm.pluginsdk.ui.applet.m)localObject1).start = i;
                ((com.tencent.mm.pluginsdk.ui.applet.m)localObject1).end = (j + i);
                this.wcM.add(localObject1);
              }
              else
              {
                str3 = "    ".concat(String.valueOf(str4));
                str1 = str1.toString().replace(str5, str3);
                i = ((Matcher)localObject1).start(0);
                j = str3.length();
                localObject1 = new r(i + 1, i + 3, 2131232058);
                this.wcO.add(localObject1);
                localObject1 = new com.tencent.mm.pluginsdk.ui.applet.m(str2, 45, localObject2);
                ((com.tencent.mm.pluginsdk.ui.applet.m)localObject1).start = (i + 4);
                ((com.tencent.mm.pluginsdk.ui.applet.m)localObject1).end = (j + i);
                this.wcM.add(localObject1);
              }
            }
            else
            {
              ab.e("MicroMsg.SpanProcessor", "url && appId is null, continue");
              break;
            }
          }
        }
        localObject1 = i.a.wbZ.matcher(str1);
      }
    }
    AppMethodBeat.o(79892);
    return str1;
  }
  
  private void R(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(79893);
    if (this.wcT) {
      this.wcN.addAll(S(paramCharSequence));
    }
    if (this.wcP) {
      this.wcN.addAll(U(paramCharSequence));
    }
    if (this.wcR) {
      this.wcN.addAll(V(paramCharSequence));
    }
    if (this.wcW) {
      this.wcN.addAll(Z(paramCharSequence));
    }
    if (this.wcU) {
      this.wcN.addAll(W(paramCharSequence));
    }
    if (this.wcS) {
      this.wcN.addAll(X(paramCharSequence));
    }
    if (this.wcV) {
      this.wcN.addAll(Y(paramCharSequence));
    }
    if (this.wdb) {
      this.wcN.addAll(T(paramCharSequence));
    }
    AppMethodBeat.o(79893);
  }
  
  private ArrayList<a> S(CharSequence paramCharSequence)
  {
    int i = 2000;
    AppMethodBeat.i(79894);
    ArrayList localArrayList = new ArrayList();
    Object localObject = i.a.wch;
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
        if (!a(this.wcN, new a(i, j)))
        {
          this.wcM.add(localObject);
          localArrayList.add(new a(i, j));
        }
      }
      i = paramCharSequence.length();
    }
    AppMethodBeat.o(79894);
    return localArrayList;
  }
  
  private ArrayList<a> T(CharSequence paramCharSequence)
  {
    int i = 2000;
    AppMethodBeat.i(79895);
    ArrayList localArrayList = new ArrayList();
    Object localObject = i.a.wci;
    if (paramCharSequence.length() > 2000) {}
    for (;;)
    {
      paramCharSequence = ((Pattern)localObject).matcher(paramCharSequence.subSequence(0, i));
      while (paramCharSequence.find())
      {
        i = paramCharSequence.start();
        int j = paramCharSequence.end();
        localObject = new com.tencent.mm.pluginsdk.ui.applet.m(paramCharSequence.group(), 48, null);
        ((com.tencent.mm.pluginsdk.ui.applet.m)localObject).start = i;
        ((com.tencent.mm.pluginsdk.ui.applet.m)localObject).end = j;
        if (!a(this.wcN, new a(i, j)))
        {
          this.wcM.add(localObject);
          localArrayList.add(new a(i, j));
        }
      }
      i = paramCharSequence.length();
    }
    AppMethodBeat.o(79895);
    return localArrayList;
  }
  
  private ArrayList<a> U(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(79896);
    ArrayList localArrayList = new ArrayList();
    String str = paramCharSequence.toString();
    if (str.length() > 500) {
      paramCharSequence = i.a.wcg.matcher(str.toLowerCase());
    }
    while (paramCharSequence.find())
    {
      int i = paramCharSequence.start();
      int j = paramCharSequence.end();
      if ((!a(this.wcN, new a(i, j))) && (i >= 0) && (j <= str.length())) {
        if (j < str.length())
        {
          int k = str.charAt(j);
          if ((97 <= k) && (k <= 122)) {}
        }
        else
        {
          com.tencent.mm.pluginsdk.ui.applet.m localm = new com.tencent.mm.pluginsdk.ui.applet.m(str.substring(i, j), 1, this.wdg);
          localm.start = i;
          localm.end = j;
          this.wcM.add(localm);
          localArrayList.add(new a(i, j));
          continue;
          paramCharSequence = i.a.wcf.matcher(str.toLowerCase());
        }
      }
    }
    AppMethodBeat.o(79896);
    return localArrayList;
  }
  
  private ArrayList<a> V(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(79897);
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = paramCharSequence.toString();
    if (paramCharSequence.length() > 200)
    {
      AppMethodBeat.o(79897);
      return localArrayList;
    }
    Matcher localMatcher = i.a.wcn.matcher(paramCharSequence);
    while (localMatcher.find())
    {
      int i = localMatcher.start();
      int j = localMatcher.end();
      if ((!a(this.wcN, new a(i, j))) && (i >= 0) && (j <= paramCharSequence.length()))
      {
        com.tencent.mm.pluginsdk.ui.applet.m localm = new com.tencent.mm.pluginsdk.ui.applet.m(paramCharSequence.substring(i, j), 44, this.wdg);
        localm.start = i;
        localm.end = j;
        this.wcM.add(localm);
        localArrayList.add(new a(i, j));
      }
    }
    AppMethodBeat.o(79897);
    return localArrayList;
  }
  
  private ArrayList<a> W(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(79898);
    ArrayList localArrayList = new ArrayList();
    String str = paramCharSequence.toString();
    paramCharSequence = i.a.wck.matcher(paramCharSequence);
    while (paramCharSequence.find())
    {
      int i = paramCharSequence.start();
      int j = paramCharSequence.end();
      if ((!a(this.wcN, new a(i, j))) && (i >= 0) && (j <= str.length()))
      {
        com.tencent.mm.pluginsdk.ui.applet.m localm = new com.tencent.mm.pluginsdk.ui.applet.m(str.substring(i, j), 28, null);
        localm.start = i;
        localm.end = j;
        this.wcM.add(localm);
        localArrayList.add(new a(i, j));
      }
    }
    AppMethodBeat.o(79898);
    return localArrayList;
  }
  
  private ArrayList<a> X(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(79899);
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = i.a.wcj.matcher(paramCharSequence);
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
      if (((i != 6) && (i != 5)) || (("+12306+12110+12395+12121+12117+12119+95555+95566+95533+95588+95558+95599+95568+95595+95559+95508+95528+95501+95577+95561+10086+10010+10000+17951+17911+17900+118114+116114+950718+95598+12318+12315+12358+12365+12310+12369+12333+12366+95518+95519+95511+95500+95522+95567+95017".contains((CharSequence)localObject)) && (i < 24) && (!a(this.wcN, new a(k, m)))))
      {
        localObject = new com.tencent.mm.pluginsdk.ui.applet.m((String)localObject, 25, this.wdg);
        ((com.tencent.mm.pluginsdk.ui.applet.m)localObject).start = k;
        ((com.tencent.mm.pluginsdk.ui.applet.m)localObject).end = m;
        this.wcM.add(localObject);
        localArrayList.add(new a(k, m));
      }
    }
    AppMethodBeat.o(79899);
    return localArrayList;
  }
  
  private ArrayList<a> Y(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(79900);
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = a.bz(this.mContext, paramCharSequence.toString()).iterator();
    while (paramCharSequence.hasNext())
    {
      com.tencent.mm.pluginsdk.ui.applet.m localm = (com.tencent.mm.pluginsdk.ui.applet.m)paramCharSequence.next();
      a locala = new a(localm.start, localm.end);
      if (!a(this.wcN, locala))
      {
        this.wcM.add(localm);
        localArrayList.add(locala);
      }
    }
    AppMethodBeat.o(79900);
    return localArrayList;
  }
  
  private ArrayList<a> Z(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(79901);
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = paramCharSequence.toString();
    Matcher localMatcher = i.a.wcm.matcher(paramCharSequence);
    int i;
    int j;
    a locala;
    com.tencent.mm.pluginsdk.ui.applet.m localm;
    while (localMatcher.find())
    {
      i = localMatcher.start();
      j = localMatcher.end();
      locala = new a(i, j);
      if ((!a(this.wcN, locala)) && (i >= 0) && (j <= paramCharSequence.length()))
      {
        localm = new com.tencent.mm.pluginsdk.ui.applet.m(paramCharSequence.substring(i, j), 30, null);
        localm.start = i;
        localm.end = j;
        this.wcM.add(localm);
        localArrayList.add(locala);
      }
    }
    if (localArrayList.size() <= 0)
    {
      localMatcher = i.a.wcl.matcher(paramCharSequence);
      while (localMatcher.find())
      {
        i = localMatcher.start();
        j = localMatcher.end();
        locala = new a(i, j);
        if ((!a(this.wcN, locala)) && (i >= 0) && (j <= paramCharSequence.length()))
        {
          localm = new com.tencent.mm.pluginsdk.ui.applet.m(paramCharSequence.substring(i, j), 30, null);
          localm.start = i;
          localm.end = j;
          this.wcM.add(localm);
          localArrayList.add(locala);
        }
      }
    }
    AppMethodBeat.o(79901);
    return localArrayList;
  }
  
  private void a(SpannableString paramSpannableString)
  {
    int i = 0;
    AppMethodBeat.i(79905);
    if (this.md != null)
    {
      paramSpannableString = new m();
      paramSpannableString.mSessionId = this.mSessionId;
      this.md.setOnTouchListener(paramSpannableString);
      AppMethodBeat.o(79905);
      return;
    }
    if (paramSpannableString != null)
    {
      paramSpannableString = (n[])paramSpannableString.getSpans(0, paramSpannableString.length(), n.class);
      if ((paramSpannableString != null) && (paramSpannableString.length > 0) && (this.mSessionId != null))
      {
        int j = paramSpannableString.length;
        while (i < j)
        {
          paramSpannableString[i].setSessionId(this.mSessionId);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(79905);
  }
  
  private static boolean a(ArrayList<a> paramArrayList, a parama)
  {
    AppMethodBeat.i(79903);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (((a)paramArrayList.next()).a(parama))
      {
        AppMethodBeat.o(79903);
        return true;
      }
    }
    AppMethodBeat.o(79903);
    return false;
  }
  
  private boolean ay(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(79902);
    paramString = a.a(this.mContext, paramString, paramInt1, paramInt2);
    if (paramString != null)
    {
      if (this.wdg != null) {
        paramString.data = this.wdg;
      }
      this.wcM.add(paramString);
      this.wcN.add(new a(paramInt1, paramInt2));
      AppMethodBeat.o(79902);
      return true;
    }
    AppMethodBeat.o(79902);
    return false;
  }
  
  private CharSequence b(CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(79890);
    Object localObject2 = i.a.wcb.matcher(paramCharSequence);
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
          ab.e("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error: start:%d, end:%d, source.length:%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramCharSequence.length()) });
          continue;
        }
        try
        {
          i = Color.parseColor((String)localObject4);
          if (bo.isNullOrNil(str1))
          {
            localObject2 = new com.tencent.mm.pluginsdk.ui.applet.m(j, k);
            ((com.tencent.mm.pluginsdk.ui.applet.m)localObject2).linkColor = i;
            this.wcM.add(localObject2);
            this.wcN.add(new a(j, k));
            localObject2 = i.a.wcb.matcher((CharSequence)localObject1);
            i = 1;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.w("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error at color : %s]", new Object[] { localObject4 });
            i = 0;
            continue;
            localObject3 = a.a(this.mContext, str1, j, k, i, i & 0x99FFFFFF);
            if (localObject3 != null)
            {
              if (this.wdg != null) {
                ((com.tencent.mm.pluginsdk.ui.applet.m)localObject3).data = this.wdg;
              }
              this.wcM.add(localObject3);
              this.wcN.add(new a(j, k));
            }
          }
        }
      }
    }
    Object localObject4 = localObject1;
    if (i == 0)
    {
      localObject3 = i.a.wcc.matcher(paramCharSequence);
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
            ab.e("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error: start:%d, end:%d, source.length:%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramCharSequence.length()) });
          }
          else
          {
            if ((!ay((String)localObject4, i, j)) && (paramBoolean))
            {
              localObject3 = new com.tencent.mm.pluginsdk.ui.applet.m((String)localObject4, 2147483646, null);
              if (this.wdg != null) {
                ((com.tencent.mm.pluginsdk.ui.applet.m)localObject3).data = this.wdg;
              }
              ((com.tencent.mm.pluginsdk.ui.applet.m)localObject3).start = i;
              ((com.tencent.mm.pluginsdk.ui.applet.m)localObject3).end = j;
              if (!a(this.wcN, new a(i, j)))
              {
                this.wcM.add(localObject3);
                this.wcN.add(new a(i, j));
              }
            }
            localObject3 = i.a.wcb.matcher((CharSequence)localObject1);
          }
        }
      }
    }
    AppMethodBeat.o(79890);
    return localObject4;
  }
  
  public static void clearCache()
  {
    AppMethodBeat.i(79906);
    wcL.clear();
    AppMethodBeat.o(79906);
  }
  
  private static void e(Spannable paramSpannable)
  {
    AppMethodBeat.i(79887);
    Object[] arrayOfObject = paramSpannable.getSpans(0, paramSpannable.length(), Object.class);
    int k = arrayOfObject.length;
    int i = 0;
    if (i < k)
    {
      Object localObject = arrayOfObject[i];
      int j = 0;
      label42:
      if (j < wdh.length) {
        if (!wdh[j].isInstance(localObject)) {}
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
    AppMethodBeat.o(79887);
  }
  
  private void f(Spannable paramSpannable)
  {
    AppMethodBeat.i(79904);
    if ((this.md != null) && (!bo.isNullOrNil(paramSpannable.toString())))
    {
      if (ae.glj)
      {
        this.md.setText(paramSpannable, TextView.BufferType.SPANNABLE);
        AppMethodBeat.o(79904);
        return;
      }
      this.md.setText(paramSpannable);
    }
    AppMethodBeat.o(79904);
  }
  
  public final SpannableString b(CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(79886);
    if (paramCharSequence == null)
    {
      paramCharSequence = new SpannableString("");
      AppMethodBeat.o(79886);
      return paramCharSequence;
    }
    this.wde = paramInt;
    String str = M(paramCharSequence);
    if (paramBoolean)
    {
      localObject1 = (SpannableString)wcL.get(str);
      if (localObject1 != null)
      {
        e((Spannable)localObject1);
        f((Spannable)localObject1);
        a((SpannableString)localObject1);
        AppMethodBeat.o(79886);
        return localObject1;
      }
    }
    paramCharSequence = N(paramCharSequence);
    Object localObject2;
    if (this.wdf)
    {
      localObject1 = this.wcM.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.pluginsdk.ui.applet.m)((Iterator)localObject1).next();
        ((com.tencent.mm.pluginsdk.ui.applet.m)localObject2).mSessionId = this.mSessionId;
        if (bo.isNullOrNil(((com.tencent.mm.pluginsdk.ui.applet.m)localObject2).url)) {
          paramCharSequence.setSpan(new ForegroundColorSpan(((com.tencent.mm.pluginsdk.ui.applet.m)localObject2).linkColor), ((com.tencent.mm.pluginsdk.ui.applet.m)localObject2).start, ((com.tencent.mm.pluginsdk.ui.applet.m)localObject2).end, 33);
        } else if ((((com.tencent.mm.pluginsdk.ui.applet.m)localObject2).start <= paramCharSequence.length()) && (((com.tencent.mm.pluginsdk.ui.applet.m)localObject2).end <= paramCharSequence.length())) {
          paramCharSequence.setSpan(new n(this.wdd, (com.tencent.mm.pluginsdk.ui.applet.m)localObject2), ((com.tencent.mm.pluginsdk.ui.applet.m)localObject2).start, ((com.tencent.mm.pluginsdk.ui.applet.m)localObject2).end, 33);
        }
      }
    }
    Object localObject1 = this.wcO.iterator();
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
          ((com.tencent.mm.ui.widget.a)localObject3).ACa = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 2);
          paramCharSequence.setSpan(localObject3, ((r)localObject2).start, ((r)localObject2).start + 1, 18);
        }
        else
        {
          if (this.md == null) {}
          for (paramInt = (int)(this.wde * 1.3F);; paramInt = (int)(this.md.getTextSize() * 1.3F))
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
      wcL.f(str, new SpannableString(paramCharSequence));
    }
    AppMethodBeat.o(79886);
    return paramCharSequence;
  }
  
  public final p m(TextView paramTextView)
  {
    AppMethodBeat.i(79884);
    this.md = paramTextView;
    if (paramTextView != null) {
      this.mContext = this.md.getContext();
    }
    AppMethodBeat.o(79884);
    return this;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.p
 * JD-Core Version:    0.7.0.1
 */