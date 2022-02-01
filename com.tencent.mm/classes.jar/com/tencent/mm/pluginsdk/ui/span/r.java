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
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.applet.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class r
{
  private static final com.tencent.mm.b.f<String, SpannableString> KrC;
  private static Class<?>[] Ksc;
  private ArrayList<u> KrD;
  private ArrayList<a> KrE;
  private ArrayList<z> KrF;
  boolean KrG;
  boolean KrH;
  boolean KrI;
  boolean KrJ;
  boolean KrK;
  boolean KrL;
  boolean KrM;
  boolean KrN;
  boolean KrO;
  boolean KrP;
  boolean KrQ;
  boolean KrR;
  boolean KrS;
  boolean KrT;
  boolean KrU;
  boolean KrV;
  boolean KrW;
  boolean KrX;
  int KrY;
  private int KrZ;
  boolean Ksa;
  Object Ksb;
  private TextView Ws;
  int gwE;
  a mAdTagClickCallback;
  int mAdTagClickScene;
  private Context mContext;
  String mSessionId;
  
  static
  {
    AppMethodBeat.i(152370);
    KrC = new com.tencent.mm.memory.a.c(500);
    Ksc = new Class[] { com.tencent.mm.ui.widget.a.class, p.class, ForegroundColorSpan.class };
    AppMethodBeat.o(152370);
  }
  
  public r(Context paramContext)
  {
    AppMethodBeat.i(152345);
    this.KrD = new ArrayList();
    this.KrE = new ArrayList();
    this.KrF = new ArrayList();
    this.Ws = null;
    this.KrG = false;
    this.KrH = false;
    this.KrI = true;
    this.KrJ = false;
    this.KrK = false;
    this.KrL = true;
    this.KrM = true;
    this.KrN = false;
    this.KrO = false;
    this.KrP = false;
    this.KrQ = false;
    this.KrR = false;
    this.KrS = false;
    this.KrT = false;
    this.KrU = true;
    this.KrV = false;
    this.KrW = false;
    this.KrX = false;
    this.KrY = 0;
    this.KrZ = 0;
    this.mContext = null;
    this.Ksa = false;
    this.gwE = 0;
    this.KrD = new ArrayList();
    this.KrE = new ArrayList();
    this.KrF = new ArrayList();
    this.mContext = paramContext;
    AppMethodBeat.o(152345);
  }
  
  private String V(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152347);
    paramCharSequence = paramCharSequence + "@" + this.KrZ + "@" + this.KrG + "@" + this.KrH + "@" + this.KrK + "@" + this.KrL + "@" + this.KrM + "@" + this.KrY + "@" + this.Ksa + "@" + this.KrR + "@" + this.KrS + "@" + this.KrT + "@" + this.KrQ;
    AppMethodBeat.o(152347);
    return paramCharSequence;
  }
  
  private SpannableString W(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152350);
    this.KrD = new ArrayList();
    Object localObject;
    if (this.KrZ <= 0)
    {
      if (this.Ws != null) {
        this.KrZ = ((int)this.Ws.getTextSize());
      }
    }
    else
    {
      if (this.KrD == null) {
        this.KrD = new ArrayList();
      }
      if (this.KrE == null) {
        this.KrE = new ArrayList();
      }
      this.KrD.clear();
      this.KrE.clear();
      localObject = paramCharSequence;
      if (com.tencent.mm.compatible.util.o.y(paramCharSequence))
      {
        localObject = paramCharSequence;
        if (this.KrU)
        {
          localObject = paramCharSequence;
          if (f.a.KqF != null) {
            if (!f.a.KqF.N(paramCharSequence))
            {
              localObject = paramCharSequence;
              if (!f.a.KqF.M(paramCharSequence)) {}
            }
            else
            {
              localObject = paramCharSequence.toString().replace("\n", "                                                                                                                                                                                                                                                                                                                        ");
            }
          }
        }
      }
      paramCharSequence = (CharSequence)localObject;
      if (this.KrG)
      {
        if (!((CharSequence)localObject).toString().contains("data-miniprogram-appid")) {
          break label299;
        }
        paramCharSequence = Z((CharSequence)localObject);
      }
      label187:
      localObject = paramCharSequence;
      if (this.KrR) {
        localObject = X(paramCharSequence);
      }
      paramCharSequence = (CharSequence)localObject;
      if (this.KrT) {
        paramCharSequence = b((CharSequence)localObject, this.KrX);
      }
      if ((!this.KrU) || (f.a.KqF == null)) {
        break label324;
      }
      paramCharSequence = f.a.KqF.b(this.mContext, paramCharSequence, this.KrZ);
    }
    label299:
    label324:
    for (;;)
    {
      if (this.KrI) {
        aa(paramCharSequence);
      }
      if ((paramCharSequence instanceof Spannable))
      {
        paramCharSequence = (SpannableString)paramCharSequence;
        AppMethodBeat.o(152350);
        return paramCharSequence;
        this.KrZ = com.tencent.mm.cb.a.aG(this.mContext, 2131165535);
        break;
        paramCharSequence = Y((CharSequence)localObject);
        break label187;
      }
      paramCharSequence = new SpannableString(paramCharSequence);
      AppMethodBeat.o(152350);
      return paramCharSequence;
    }
  }
  
  private CharSequence X(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152351);
    Object localObject2 = k.a.KqN.matcher(paramCharSequence.toString());
    Object localObject1 = paramCharSequence;
    paramCharSequence = (CharSequence)localObject2;
    if (paramCharSequence.find())
    {
      if (this.KrS) {
        paramCharSequence = ((CharSequence)localObject1).toString().replace(paramCharSequence.group(0), "");
      }
      for (;;)
      {
        localObject2 = k.a.KqI.matcher(paramCharSequence);
        localObject1 = paramCharSequence;
        paramCharSequence = (CharSequence)localObject2;
        break;
        localObject1 = ((CharSequence)localObject1).toString().replace(paramCharSequence.group(0), "  ");
        localObject2 = paramCharSequence.group(1);
        int i = paramCharSequence.start();
        int j = this.mContext.getResources().getIdentifier(((String)localObject2).toLowerCase(), "drawable", this.mContext.getPackageName());
        if (j != 0)
        {
          paramCharSequence = new z(i, i + 2, j);
          if ((!Util.isNullOrNil((String)localObject2)) && ("original_label".equals(localObject2)))
          {
            paramCharSequence.height = 15;
            paramCharSequence.width = 35;
          }
          this.KrF.add(paramCharSequence);
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
  
  private CharSequence Y(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152353);
    String str1 = paramCharSequence.toString();
    Matcher localMatcher;
    if (str1.length() < 1500) {
      localMatcher = k.a.KqI.matcher(str1);
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
          localMatcher = k.a.KqH.matcher(str1);
        }
        else
        {
          aN(str2, i, j);
          if (str1.length() < 1500) {
            localMatcher = k.a.KqI.matcher(str1);
          } else {
            localMatcher = k.a.KqH.matcher(str1);
          }
        }
      }
    }
    AppMethodBeat.o(152353);
    return str1;
  }
  
  private CharSequence Z(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152354);
    Object localObject1 = paramCharSequence.toString();
    Object localObject2;
    if (((String)localObject1).length() < 1500) {
      localObject2 = k.a.KqK.matcher((CharSequence)localObject1);
    }
    while (((Matcher)localObject2).find())
    {
      String str4 = ((Matcher)localObject2).group(0);
      String str1 = ((Matcher)localObject2).group(1);
      String str3 = ((Matcher)localObject2).group(2);
      Object localObject3 = XmlParser.parseXml(str4.replace(str1, " ").replace(str3, " "), "a", null);
      if (localObject3 == null)
      {
        Log.e("MicroMsg.SpanProcessor", "XmlParser parse return null, so continue");
        continue;
        localObject2 = k.a.KqJ.matcher((CharSequence)localObject1);
      }
      else
      {
        String str2 = (String)((Map)localObject3).get(".a.$data-miniprogram-appid");
        localObject3 = (String)((Map)localObject3).get(".a.$data-miniprogram-path");
        int i;
        label164:
        int j;
        if (!Util.isNullOrNil(str1))
        {
          i = 1;
          if (Util.isNullOrNil(str2)) {
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
            localObject1 = ((String)localObject1).toString().replace(str4, str3);
            i = ((Matcher)localObject2).start(0);
            j = str3.length() + i;
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
            aN(str1, i, j);
          }
        }
        for (;;)
        {
          if (((String)localObject1).length() < 1500)
          {
            localObject2 = k.a.KqK.matcher((CharSequence)localObject1);
            break;
            if (j != 0)
            {
              if (this.KrS)
              {
                localObject1 = ((String)localObject1).toString().replace(str4, str3);
                i = ((Matcher)localObject2).start(0);
                j = str3.length();
                localObject2 = new u(str1, 45, null);
                ((u)localObject2).start = i;
                ((u)localObject2).end = (j + i);
                this.KrD.add(localObject2);
              }
              else
              {
                str3 = "    ".concat(String.valueOf(str3));
                str1 = ((String)localObject1).toString().replace(str4, str3);
                i = ((Matcher)localObject2).start(0);
                j = str3.length();
                if (ao.isDarkMode()) {}
                for (localObject1 = new z(i + 1, i + 3, 2131691573);; localObject1 = new z(i + 1, i + 3, 2131691572))
                {
                  this.KrF.add(localObject1);
                  localObject1 = new u(str2, 45, localObject3);
                  ((u)localObject1).start = (i + 4);
                  ((u)localObject1).end = (i + j);
                  this.KrD.add(localObject1);
                  localObject1 = str1;
                  break;
                }
              }
            }
            else
            {
              Log.e("MicroMsg.SpanProcessor", "url && appId is null, continue");
              break;
            }
          }
        }
        localObject2 = k.a.KqJ.matcher((CharSequence)localObject1);
      }
    }
    AppMethodBeat.o(152354);
    return localObject1;
  }
  
  private void a(SpannableString paramSpannableString)
  {
    AppMethodBeat.i(152368);
    if (this.Ws != null)
    {
      paramSpannableString = new o();
      paramSpannableString.mSessionId = this.mSessionId;
      paramSpannableString.setAdTagClickCallback(this.mAdTagClickCallback, 0);
      paramSpannableString.mAdTagClickScene = this.mAdTagClickScene;
      this.Ws.setOnTouchListener(paramSpannableString);
      AppMethodBeat.o(152368);
      return;
    }
    if (paramSpannableString != null)
    {
      paramSpannableString = (p[])paramSpannableString.getSpans(0, paramSpannableString.length(), p.class);
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
  
  private boolean aN(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152365);
    paramString = b.a(this.mContext, paramString, paramInt1, paramInt2);
    if (paramString != null)
    {
      if (this.Ksb != null) {
        paramString.data = this.Ksb;
      }
      this.KrD.add(paramString);
      this.KrE.add(new a(paramInt1, paramInt2));
      AppMethodBeat.o(152365);
      return true;
    }
    AppMethodBeat.o(152365);
    return false;
  }
  
  private void aa(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152355);
    if (this.KrL) {
      this.KrE.addAll(ab(paramCharSequence));
    }
    if (this.KrH) {
      this.KrE.addAll(ad(paramCharSequence));
    }
    if (this.KrJ) {
      this.KrE.addAll(ae(paramCharSequence));
    }
    if (this.KrP) {
      this.KrE.addAll(ak(paramCharSequence));
    }
    if (this.KrM) {
      this.KrE.addAll(af(paramCharSequence));
    }
    if (this.KrN) {
      this.KrE.addAll(ag(paramCharSequence));
    }
    if (this.KrQ) {
      this.KrE.addAll(ah(paramCharSequence));
    }
    if (this.KrK) {
      this.KrE.addAll(ai(paramCharSequence));
    }
    if (this.KrO) {
      this.KrE.addAll(aj(paramCharSequence));
    }
    if (this.KrW) {
      this.KrE.addAll(ac(paramCharSequence));
    }
    if (this.KrV) {
      this.KrE.addAll(al(paramCharSequence));
    }
    AppMethodBeat.o(152355);
  }
  
  private ArrayList<a> ab(CharSequence paramCharSequence)
  {
    int i = 2000;
    AppMethodBeat.i(152356);
    ArrayList localArrayList = new ArrayList();
    Object localObject = k.a.KqR;
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
        if (!a(this.KrE, new a(i, j)))
        {
          this.KrD.add(localObject);
          localArrayList.add(new a(i, j));
        }
      }
      i = paramCharSequence.length();
    }
    AppMethodBeat.o(152356);
    return localArrayList;
  }
  
  private ArrayList<a> ac(CharSequence paramCharSequence)
  {
    int i = 2000;
    AppMethodBeat.i(152357);
    ArrayList localArrayList = new ArrayList();
    Object localObject = k.a.KqS;
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
        if (!a(this.KrE, new a(i, j)))
        {
          this.KrD.add(localObject);
          localArrayList.add(new a(i, j));
        }
      }
      i = paramCharSequence.length();
    }
    AppMethodBeat.o(152357);
    return localArrayList;
  }
  
  private ArrayList<a> ad(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152358);
    ArrayList localArrayList = new ArrayList();
    String str = paramCharSequence.toString();
    if (str.length() > 500) {
      paramCharSequence = k.a.KqQ.matcher(str.toLowerCase());
    }
    while (paramCharSequence.find())
    {
      int i = paramCharSequence.start();
      int j = paramCharSequence.end();
      if ((!a(this.KrE, new a(i, j))) && (i >= 0) && (j <= str.length())) {
        if (j < str.length())
        {
          int k = str.charAt(j);
          if ((97 <= k) && (k <= 122)) {}
        }
        else
        {
          u localu = new u(str.substring(i, j), 1, this.Ksb);
          localu.start = i;
          localu.end = j;
          this.KrD.add(localu);
          localArrayList.add(new a(i, j));
          continue;
          paramCharSequence = k.a.KqP.matcher(str.toLowerCase());
        }
      }
    }
    AppMethodBeat.o(152358);
    return localArrayList;
  }
  
  private ArrayList<a> ae(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152359);
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = paramCharSequence.toString();
    if (paramCharSequence.length() > 200)
    {
      AppMethodBeat.o(152359);
      return localArrayList;
    }
    Matcher localMatcher = k.a.KqX.matcher(paramCharSequence);
    while (localMatcher.find())
    {
      int i = localMatcher.start();
      int j = localMatcher.end();
      if ((!a(this.KrE, new a(i, j))) && (i >= 0) && (j <= paramCharSequence.length()))
      {
        u localu = new u(paramCharSequence.substring(i, j), 44, this.Ksb);
        localu.start = i;
        localu.end = j;
        this.KrD.add(localu);
        localArrayList.add(new a(i, j));
      }
    }
    AppMethodBeat.o(152359);
    return localArrayList;
  }
  
  private ArrayList<a> af(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152360);
    ArrayList localArrayList = new ArrayList();
    String str = paramCharSequence.toString();
    paramCharSequence = k.a.KqU.matcher(paramCharSequence);
    while (paramCharSequence.find())
    {
      int i = paramCharSequence.start();
      int j = paramCharSequence.end();
      if ((!a(this.KrE, new a(i, j))) && (i >= 0) && (j <= str.length()))
      {
        u localu = new u(str.substring(i, j), 28, null);
        localu.start = i;
        localu.end = j;
        this.KrD.add(localu);
        localArrayList.add(new a(i, j));
      }
    }
    AppMethodBeat.o(152360);
    return localArrayList;
  }
  
  private ArrayList<a> ag(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152361);
    ArrayList localArrayList = new ArrayList();
    String str = paramCharSequence.toString();
    paramCharSequence = k.a.KqY.matcher(paramCharSequence);
    while (paramCharSequence.find())
    {
      Object localObject = paramCharSequence.group();
      if (c.KqA.bfg((String)localObject))
      {
        int i = paramCharSequence.start();
        int j = paramCharSequence.end();
        if ((!a(this.KrE, new a(i, j))) && (i >= 0) && (j <= str.length()))
        {
          localObject = new u(str.substring(i, j), 50, this.Ksb);
          ((u)localObject).start = i;
          ((u)localObject).end = j;
          this.KrD.add(localObject);
          localArrayList.add(new a(i, j));
        }
      }
    }
    AppMethodBeat.o(152361);
    return localArrayList;
  }
  
  private ArrayList<a> ah(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(223868);
    ArrayList localArrayList = new ArrayList();
    String str = paramCharSequence.toString();
    paramCharSequence = k.a.Krb.matcher(paramCharSequence);
    while (paramCharSequence.find())
    {
      paramCharSequence.group();
      int i = paramCharSequence.start();
      int j = paramCharSequence.end();
      if ((!a(this.KrE, new a(i, j))) && (i >= 0) && (j <= str.length()))
      {
        u localu = new u(str.substring(i, j), 58, this.Ksb);
        localu.start = i;
        localu.end = j;
        this.KrD.add(localu);
        localArrayList.add(new a(i, j));
      }
    }
    AppMethodBeat.o(223868);
    return localArrayList;
  }
  
  private ArrayList<a> ai(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152362);
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = k.a.KqT.matcher(paramCharSequence);
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
      if (((i != 6) && (i != 5)) || (("+12306+12110+12395+12121+12117+12119+95555+95566+95533+95588+95558+95599+95568+95595+95559+95508+95528+95501+95577+95561+10086+10010+10000+17951+17911+17900+118114+116114+950718+95598+12318+12315+12358+12365+12310+12369+12333+12366+95518+95519+95511+95500+95522+95567+95017".contains((CharSequence)localObject)) && (i < 100) && (!a(this.KrE, new a(k, m)))))
      {
        localObject = new u((String)localObject, 25, this.Ksb);
        ((u)localObject).start = k;
        ((u)localObject).end = m;
        this.KrD.add(localObject);
        localArrayList.add(new a(k, m));
      }
    }
    AppMethodBeat.o(152362);
    return localArrayList;
  }
  
  private ArrayList<a> aj(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152363);
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = b.cn(this.mContext, paramCharSequence.toString()).iterator();
    while (paramCharSequence.hasNext())
    {
      u localu = (u)paramCharSequence.next();
      a locala = new a(localu.start, localu.end);
      if (!a(this.KrE, locala))
      {
        this.KrD.add(localu);
        localArrayList.add(locala);
      }
    }
    AppMethodBeat.o(152363);
    return localArrayList;
  }
  
  private ArrayList<a> ak(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152364);
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = paramCharSequence.toString();
    Matcher localMatcher = k.a.KqW.matcher(paramCharSequence);
    int i;
    int j;
    a locala;
    u localu;
    while (localMatcher.find())
    {
      i = localMatcher.start();
      j = localMatcher.end();
      locala = new a(i, j);
      if ((!a(this.KrE, locala)) && (i >= 0) && (j <= paramCharSequence.length()))
      {
        localu = new u(paramCharSequence.substring(i, j), 30, null);
        localu.start = i;
        localu.end = j;
        this.KrD.add(localu);
        localArrayList.add(locala);
      }
    }
    if (localArrayList.size() <= 0)
    {
      localMatcher = k.a.KqV.matcher(paramCharSequence);
      while (localMatcher.find())
      {
        i = localMatcher.start();
        j = localMatcher.end();
        locala = new a(i, j);
        if ((!a(this.KrE, locala)) && (i >= 0) && (j <= paramCharSequence.length()))
        {
          localu = new u(paramCharSequence.substring(i, j), 30, null);
          localu.start = i;
          localu.end = j;
          this.KrD.add(localu);
          localArrayList.add(locala);
        }
      }
    }
    AppMethodBeat.o(152364);
    return localArrayList;
  }
  
  private ArrayList<a> al(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(223869);
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = paramCharSequence.toString();
    Matcher localMatcher = k.a.Krc.matcher(paramCharSequence);
    while (localMatcher.find())
    {
      int i = localMatcher.start();
      int j = localMatcher.end();
      a locala = new a(i, j);
      if ((!a(this.KrE, locala)) && (i >= 0) && (j <= paramCharSequence.length()))
      {
        u localu = new u(paramCharSequence.substring(i, j), 60, null);
        localu.start = i;
        localu.data = this.Ksb;
        localu.end = j;
        this.KrD.add(localu);
        localArrayList.add(locala);
      }
    }
    AppMethodBeat.o(223869);
    return localArrayList;
  }
  
  private CharSequence b(CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(152352);
    Object localObject2 = k.a.KqL.matcher(paramCharSequence);
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
            this.KrD.add(localObject2);
            this.KrE.add(new a(j, k));
            localObject2 = k.a.KqL.matcher((CharSequence)localObject1);
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
              if (this.Ksb != null) {
                ((u)localObject3).data = this.Ksb;
              }
              this.KrD.add(localObject3);
              this.KrE.add(new a(j, k));
            }
          }
        }
      }
    }
    Object localObject4 = localObject1;
    if (i == 0)
    {
      localObject3 = k.a.KqM.matcher(paramCharSequence);
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
            if ((!aN(str2, i, j)) && (paramBoolean))
            {
              localObject3 = new u(str2, 2147483646, null);
              if (this.Ksb != null) {
                ((u)localObject3).data = this.Ksb;
              }
              ((u)localObject3).start = i;
              ((u)localObject3).end = j;
              if (!a(this.KrE, new a(i, j)))
              {
                this.KrD.add(localObject3);
                this.KrE.add(new a(i, j));
              }
            }
            localObject3 = k.a.KqL.matcher((CharSequence)localObject1);
          }
        }
      }
    }
    AppMethodBeat.o(152352);
    return localObject4;
  }
  
  public static void clearCache()
  {
    AppMethodBeat.i(152369);
    KrC.clear();
    AppMethodBeat.o(152369);
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
      if (j < Ksc.length) {
        if (!Ksc[j].isInstance(localObject)) {}
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
    if ((this.Ws != null) && (!Util.isNullOrNil(paramSpannable.toString())))
    {
      if (ac.jPd)
      {
        this.Ws.setText(paramSpannable, TextView.BufferType.SPANNABLE);
        AppMethodBeat.o(152367);
        return;
      }
      this.Ws.setText(paramSpannable);
    }
    AppMethodBeat.o(152367);
  }
  
  public final r C(TextView paramTextView)
  {
    AppMethodBeat.i(152346);
    this.Ws = paramTextView;
    if (paramTextView != null) {
      this.mContext = this.Ws.getContext();
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
    this.KrZ = paramInt;
    Object localObject1 = V(paramCharSequence);
    if (paramBoolean)
    {
      localObject2 = (SpannableString)KrC.get(localObject1);
      if (localObject2 != null)
      {
        f((Spannable)localObject2);
        g((Spannable)localObject2);
        a((SpannableString)localObject2);
        paramCharSequence = (p[])((SpannableString)localObject2).getSpans(0, ((SpannableString)localObject2).length(), p.class);
        int i = paramCharSequence.length;
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = paramCharSequence[paramInt].getHrefInfo();
          if ((localObject1 != null) && (((u)localObject1).type == 60) && (this.Ksb != null)) {
            ((u)localObject1).data = this.Ksb;
          }
          paramInt += 1;
        }
        AppMethodBeat.o(152348);
        return localObject2;
      }
    }
    paramCharSequence = W(paramCharSequence);
    Object localObject3;
    if (this.Ksa)
    {
      localObject2 = this.KrD.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (u)((Iterator)localObject2).next();
        ((u)localObject3).mSessionId = this.mSessionId;
        ((u)localObject3).fromScene = this.gwE;
        if (Util.isNullOrNil(((u)localObject3).url)) {
          paramCharSequence.setSpan(new ForegroundColorSpan(((u)localObject3).linkColor), ((u)localObject3).start, ((u)localObject3).end, 33);
        } else if ((((u)localObject3).start <= paramCharSequence.length()) && (((u)localObject3).end <= paramCharSequence.length())) {
          paramCharSequence.setSpan(new p(this.KrY, (u)localObject3), ((u)localObject3).start, ((u)localObject3).end, 33);
        }
      }
    }
    Object localObject2 = this.KrF.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (z)((Iterator)localObject2).next();
      if ((((z)localObject3).start <= paramCharSequence.length()) && (((z)localObject3).end <= paramCharSequence.length()))
      {
        Object localObject4 = this.mContext.getResources().getDrawable(((z)localObject3).id);
        if ((((z)localObject3).width > 0) && (((z)localObject3).height > 0))
        {
          ((Drawable)localObject4).setBounds(0, 0, com.tencent.mm.cb.a.fromDPToPix(this.mContext, ((z)localObject3).width), com.tencent.mm.cb.a.fromDPToPix(this.mContext, ((z)localObject3).height));
          localObject4 = new com.tencent.mm.ui.widget.a((Drawable)localObject4);
          ((com.tencent.mm.ui.widget.a)localObject4).QBM = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 2);
          paramCharSequence.setSpan(localObject4, ((z)localObject3).start, ((z)localObject3).start + 1, 18);
        }
        else
        {
          if (this.Ws == null) {}
          for (paramInt = (int)(this.KrZ * 1.3F);; paramInt = (int)(this.Ws.getTextSize() * 1.3F))
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
      KrC.x(localObject1, new SpannableString(paramCharSequence));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.r
 * JD-Core Version:    0.7.0.1
 */