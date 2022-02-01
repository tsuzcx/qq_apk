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
import com.tencent.mm.plugin.comm.c.c;
import com.tencent.mm.plugin.comm.c.g;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.applet.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class r
{
  private static final com.tencent.mm.b.f<String, SpannableString> RsJ;
  private static Class<?>[] Rtj;
  private ArrayList<u> RsK;
  private ArrayList<r.a> RsL;
  private ArrayList<z> RsM;
  boolean RsN;
  boolean RsO;
  boolean RsP;
  boolean RsQ;
  boolean RsR;
  boolean RsS;
  boolean RsT;
  boolean RsU;
  boolean RsV;
  boolean RsW;
  boolean RsX;
  boolean RsY;
  boolean RsZ;
  boolean Rta;
  boolean Rtb;
  boolean Rtc;
  boolean Rtd;
  boolean Rte;
  int Rtf;
  private int Rtg;
  boolean Rth;
  Object Rti;
  int jaR;
  a mAdTagClickCallback;
  int mAdTagClickScene;
  private Context mContext;
  String mSessionId;
  private TextView rR;
  
  static
  {
    AppMethodBeat.i(152370);
    RsJ = new com.tencent.mm.memory.a.c(500);
    Rtj = new Class[] { com.tencent.mm.ui.widget.a.class, p.class, ForegroundColorSpan.class };
    AppMethodBeat.o(152370);
  }
  
  public r(Context paramContext)
  {
    AppMethodBeat.i(152345);
    this.RsK = new ArrayList();
    this.RsL = new ArrayList();
    this.RsM = new ArrayList();
    this.rR = null;
    this.RsN = false;
    this.RsO = false;
    this.RsP = true;
    this.RsQ = false;
    this.RsR = false;
    this.RsS = true;
    this.RsT = true;
    this.RsU = false;
    this.RsV = false;
    this.RsW = false;
    this.RsX = false;
    this.RsY = false;
    this.RsZ = false;
    this.Rta = false;
    this.Rtb = true;
    this.Rtc = false;
    this.Rtd = false;
    this.Rte = false;
    this.Rtf = 0;
    this.Rtg = 0;
    this.mContext = null;
    this.Rth = false;
    this.jaR = 0;
    this.RsK = new ArrayList();
    this.RsL = new ArrayList();
    this.RsM = new ArrayList();
    this.mContext = paramContext;
    AppMethodBeat.o(152345);
  }
  
  private void a(SpannableString paramSpannableString)
  {
    AppMethodBeat.i(152368);
    if (this.rR != null)
    {
      paramSpannableString = new o();
      paramSpannableString.mSessionId = this.mSessionId;
      paramSpannableString.setAdTagClickCallback(this.mAdTagClickCallback, 0);
      paramSpannableString.mAdTagClickScene = this.mAdTagClickScene;
      this.rR.setOnTouchListener(paramSpannableString);
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
  
  private static boolean a(ArrayList<r.a> paramArrayList, r.a parama)
  {
    AppMethodBeat.i(152366);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (((r.a)paramArrayList.next()).a(parama))
      {
        AppMethodBeat.o(152366);
        return true;
      }
    }
    AppMethodBeat.o(152366);
    return false;
  }
  
  private boolean aP(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152365);
    paramString = b.b(this.mContext, paramString, paramInt1, paramInt2);
    if (paramString != null)
    {
      if (this.Rti != null) {
        paramString.bnW = this.Rti;
      }
      this.RsK.add(paramString);
      this.RsL.add(new r.a(this, paramInt1, paramInt2));
      AppMethodBeat.o(152365);
      return true;
    }
    AppMethodBeat.o(152365);
    return false;
  }
  
  private String aj(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152347);
    paramCharSequence = paramCharSequence + "@" + this.Rtg + "@" + this.RsN + "@" + this.RsO + "@" + this.RsR + "@" + this.RsS + "@" + this.RsT + "@" + this.Rtf + "@" + this.Rth + "@" + this.RsY + "@" + this.RsZ + "@" + this.Rta + "@" + this.RsX;
    AppMethodBeat.o(152347);
    return paramCharSequence;
  }
  
  private SpannableString ak(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152350);
    this.RsK = new ArrayList();
    Object localObject;
    if (this.Rtg <= 0)
    {
      if (this.rR != null) {
        this.Rtg = ((int)this.rR.getTextSize());
      }
    }
    else
    {
      if (this.RsK == null) {
        this.RsK = new ArrayList();
      }
      if (this.RsL == null) {
        this.RsL = new ArrayList();
      }
      this.RsK.clear();
      this.RsL.clear();
      localObject = paramCharSequence;
      if (com.tencent.mm.compatible.util.o.E(paramCharSequence))
      {
        localObject = paramCharSequence;
        if (this.Rtb)
        {
          localObject = paramCharSequence;
          if (f.a.RrM != null) {
            if (!f.a.RrM.W(paramCharSequence))
            {
              localObject = paramCharSequence;
              if (!f.a.RrM.V(paramCharSequence)) {}
            }
            else
            {
              localObject = paramCharSequence.toString().replace("\n", "                                                                                                                                                                                                                                                                                                                        ");
            }
          }
        }
      }
      paramCharSequence = (CharSequence)localObject;
      if (this.RsN)
      {
        if (!((CharSequence)localObject).toString().contains("data-miniprogram-appid")) {
          break label305;
        }
        paramCharSequence = an((CharSequence)localObject);
      }
      label191:
      localObject = paramCharSequence;
      if (this.RsY) {
        localObject = al(paramCharSequence);
      }
      paramCharSequence = (CharSequence)localObject;
      if (this.Rta) {
        paramCharSequence = e((CharSequence)localObject, this.Rte);
      }
      if ((!this.Rtb) || (f.a.RrM == null)) {
        break label331;
      }
      paramCharSequence = f.a.RrM.a(this.mContext, paramCharSequence, this.Rtg);
    }
    label305:
    label331:
    for (;;)
    {
      if (this.RsP) {
        ao(paramCharSequence);
      }
      if ((paramCharSequence instanceof SpannableString))
      {
        paramCharSequence = (SpannableString)paramCharSequence;
        AppMethodBeat.o(152350);
        return paramCharSequence;
        this.Rtg = com.tencent.mm.ci.a.aY(this.mContext, c.c.NormalTextSize);
        break;
        paramCharSequence = am((CharSequence)localObject);
        break label191;
      }
      paramCharSequence = new SpannableString(paramCharSequence);
      AppMethodBeat.o(152350);
      return paramCharSequence;
    }
  }
  
  private CharSequence al(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152351);
    Object localObject2 = k.a.RrU.matcher(paramCharSequence.toString());
    Object localObject1 = paramCharSequence;
    paramCharSequence = (CharSequence)localObject2;
    if (paramCharSequence.find())
    {
      if (this.RsZ) {
        paramCharSequence = ((CharSequence)localObject1).toString().replace(paramCharSequence.group(0), "");
      }
      for (;;)
      {
        localObject2 = k.a.RrP.matcher(paramCharSequence);
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
          this.RsM.add(paramCharSequence);
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
  
  private CharSequence am(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152353);
    String str1 = paramCharSequence.toString();
    Matcher localMatcher;
    if (str1.length() < 1500) {
      localMatcher = k.a.RrP.matcher(str1);
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
          localMatcher = k.a.RrO.matcher(str1);
        }
        else
        {
          aP(str2, i, j);
          if (str1.length() < 1500) {
            localMatcher = k.a.RrP.matcher(str1);
          } else {
            localMatcher = k.a.RrO.matcher(str1);
          }
        }
      }
    }
    AppMethodBeat.o(152353);
    return str1;
  }
  
  private CharSequence an(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152354);
    Object localObject1 = paramCharSequence.toString();
    Object localObject2;
    if (((String)localObject1).length() < 1500) {
      localObject2 = k.a.RrR.matcher((CharSequence)localObject1);
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
        localObject2 = k.a.RrQ.matcher((CharSequence)localObject1);
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
            aP(str1, i, j);
          }
        }
        for (;;)
        {
          if (((String)localObject1).length() < 1500)
          {
            localObject2 = k.a.RrR.matcher((CharSequence)localObject1);
            break;
            if (j != 0)
            {
              if (this.RsZ)
              {
                localObject1 = ((String)localObject1).toString().replace(str4, str3);
                i = ((Matcher)localObject2).start(0);
                j = str3.length();
                localObject2 = new u(str1, 45, null);
                ((u)localObject2).start = i;
                ((u)localObject2).end = (j + i);
                this.RsK.add(localObject2);
              }
              else
              {
                str3 = "    ".concat(String.valueOf(str3));
                str1 = ((String)localObject1).toString().replace(str4, str3);
                i = ((Matcher)localObject2).start(0);
                j = str3.length();
                if (ar.isDarkMode()) {}
                for (localObject1 = new z(i + 1, i + 3, c.g.spannable_app_brand_link_logo_dark);; localObject1 = new z(i + 1, i + 3, c.g.spannable_app_brand_link_logo))
                {
                  this.RsM.add(localObject1);
                  localObject1 = new u(str2, 45, localObject3);
                  ((u)localObject1).start = (i + 4);
                  ((u)localObject1).end = (i + j);
                  this.RsK.add(localObject1);
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
        localObject2 = k.a.RrQ.matcher((CharSequence)localObject1);
      }
    }
    AppMethodBeat.o(152354);
    return localObject1;
  }
  
  private void ao(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152355);
    if (this.RsS) {
      this.RsL.addAll(ap(paramCharSequence));
    }
    if (this.RsO) {
      this.RsL.addAll(ar(paramCharSequence));
    }
    if (this.RsQ) {
      this.RsL.addAll(as(paramCharSequence));
    }
    if (this.RsW) {
      this.RsL.addAll(ay(paramCharSequence));
    }
    if (this.RsT) {
      this.RsL.addAll(at(paramCharSequence));
    }
    if (this.RsU) {
      this.RsL.addAll(au(paramCharSequence));
    }
    if (this.RsX) {
      this.RsL.addAll(av(paramCharSequence));
    }
    if (this.RsR) {
      this.RsL.addAll(aw(paramCharSequence));
    }
    if (this.RsV) {
      this.RsL.addAll(ax(paramCharSequence));
    }
    if (this.Rtd) {
      this.RsL.addAll(aq(paramCharSequence));
    }
    if (this.Rtc) {
      this.RsL.addAll(az(paramCharSequence));
    }
    AppMethodBeat.o(152355);
  }
  
  private ArrayList<r.a> ap(CharSequence paramCharSequence)
  {
    int i = 2000;
    AppMethodBeat.i(152356);
    ArrayList localArrayList = new ArrayList();
    Object localObject = k.a.RrY;
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
        if (!a(this.RsL, new r.a(this, i, j)))
        {
          this.RsK.add(localObject);
          localArrayList.add(new r.a(this, i, j));
        }
      }
      i = paramCharSequence.length();
    }
    AppMethodBeat.o(152356);
    return localArrayList;
  }
  
  private ArrayList<r.a> aq(CharSequence paramCharSequence)
  {
    int i = 2000;
    AppMethodBeat.i(152357);
    ArrayList localArrayList = new ArrayList();
    Object localObject = k.a.RrZ;
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
        if (!a(this.RsL, new r.a(this, i, j)))
        {
          this.RsK.add(localObject);
          localArrayList.add(new r.a(this, i, j));
        }
      }
      i = paramCharSequence.length();
    }
    AppMethodBeat.o(152357);
    return localArrayList;
  }
  
  private ArrayList<r.a> ar(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152358);
    ArrayList localArrayList = new ArrayList();
    String str = paramCharSequence.toString();
    if (str.length() > 500) {
      paramCharSequence = k.a.RrX.matcher(str.toLowerCase());
    }
    while (paramCharSequence.find())
    {
      int i = paramCharSequence.start();
      int j = paramCharSequence.end();
      if ((!a(this.RsL, new r.a(this, i, j))) && (i >= 0) && (j <= str.length())) {
        if (j < str.length())
        {
          int k = str.charAt(j);
          if ((97 <= k) && (k <= 122)) {}
        }
        else
        {
          u localu = new u(str.substring(i, j), 1, this.Rti);
          localu.start = i;
          localu.end = j;
          this.RsK.add(localu);
          localArrayList.add(new r.a(this, i, j));
          continue;
          paramCharSequence = k.a.RrW.matcher(str.toLowerCase());
        }
      }
    }
    AppMethodBeat.o(152358);
    return localArrayList;
  }
  
  private ArrayList<r.a> as(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152359);
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = paramCharSequence.toString();
    if (paramCharSequence.length() > 200)
    {
      AppMethodBeat.o(152359);
      return localArrayList;
    }
    Matcher localMatcher = k.a.Rse.matcher(paramCharSequence);
    while (localMatcher.find())
    {
      int i = localMatcher.start();
      int j = localMatcher.end();
      if ((!a(this.RsL, new r.a(this, i, j))) && (i >= 0) && (j <= paramCharSequence.length()))
      {
        u localu = new u(paramCharSequence.substring(i, j), 44, this.Rti);
        localu.start = i;
        localu.end = j;
        this.RsK.add(localu);
        localArrayList.add(new r.a(this, i, j));
      }
    }
    AppMethodBeat.o(152359);
    return localArrayList;
  }
  
  private ArrayList<r.a> at(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152360);
    ArrayList localArrayList = new ArrayList();
    String str = paramCharSequence.toString();
    paramCharSequence = k.a.Rsb.matcher(paramCharSequence);
    while (paramCharSequence.find())
    {
      int i = paramCharSequence.start();
      int j = paramCharSequence.end();
      if ((!a(this.RsL, new r.a(this, i, j))) && (i >= 0) && (j <= str.length()))
      {
        u localu = new u(str.substring(i, j), 28, null);
        localu.start = i;
        localu.end = j;
        this.RsK.add(localu);
        localArrayList.add(new r.a(this, i, j));
      }
    }
    AppMethodBeat.o(152360);
    return localArrayList;
  }
  
  private ArrayList<r.a> au(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152361);
    ArrayList localArrayList = new ArrayList();
    String str = paramCharSequence.toString();
    paramCharSequence = k.a.Rsf.matcher(paramCharSequence);
    while (paramCharSequence.find())
    {
      Object localObject = paramCharSequence.group();
      if (c.RrH.brC((String)localObject))
      {
        int i = paramCharSequence.start();
        int j = paramCharSequence.end();
        if ((!a(this.RsL, new r.a(this, i, j))) && (i >= 0) && (j <= str.length()))
        {
          localObject = new u(str.substring(i, j), 50, this.Rti);
          ((u)localObject).start = i;
          ((u)localObject).end = j;
          this.RsK.add(localObject);
          localArrayList.add(new r.a(this, i, j));
        }
      }
    }
    AppMethodBeat.o(152361);
    return localArrayList;
  }
  
  private ArrayList<r.a> av(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(198584);
    ArrayList localArrayList = new ArrayList();
    String str = paramCharSequence.toString();
    paramCharSequence = k.a.Rsi.matcher(paramCharSequence);
    while (paramCharSequence.find())
    {
      paramCharSequence.group();
      int i = paramCharSequence.start();
      int j = paramCharSequence.end();
      if ((!a(this.RsL, new r.a(this, i, j))) && (i >= 0) && (j <= str.length()))
      {
        u localu = new u(str.substring(i, j), 58, this.Rti);
        localu.start = i;
        localu.end = j;
        this.RsK.add(localu);
        localArrayList.add(new r.a(this, i, j));
      }
    }
    AppMethodBeat.o(198584);
    return localArrayList;
  }
  
  private ArrayList<r.a> aw(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152362);
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = k.a.Rsa.matcher(paramCharSequence);
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
      if (((i != 6) && (i != 5)) || (("+12306+12110+12395+12121+12117+12119+95555+95566+95533+95588+95558+95599+95568+95595+95559+95508+95528+95501+95577+95561+10086+10010+10000+17951+17911+17900+118114+116114+950718+95598+12318+12315+12358+12365+12310+12369+12333+12366+95518+95519+95511+95500+95522+95567+95017".contains((CharSequence)localObject)) && (i < 100) && (!a(this.RsL, new r.a(this, k, m)))))
      {
        localObject = new u((String)localObject, 25, this.Rti);
        ((u)localObject).start = k;
        ((u)localObject).end = m;
        this.RsK.add(localObject);
        localArrayList.add(new r.a(this, k, m));
      }
    }
    AppMethodBeat.o(152362);
    return localArrayList;
  }
  
  private ArrayList<r.a> ax(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152363);
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = b.cz(this.mContext, paramCharSequence.toString()).iterator();
    while (paramCharSequence.hasNext())
    {
      u localu = (u)paramCharSequence.next();
      r.a locala = new r.a(this, localu.start, localu.end);
      if (!a(this.RsL, locala))
      {
        this.RsK.add(localu);
        localArrayList.add(locala);
      }
    }
    AppMethodBeat.o(152363);
    return localArrayList;
  }
  
  private ArrayList<r.a> ay(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152364);
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = paramCharSequence.toString();
    Matcher localMatcher = k.a.Rsd.matcher(paramCharSequence);
    int i;
    int j;
    r.a locala;
    u localu;
    while (localMatcher.find())
    {
      i = localMatcher.start();
      j = localMatcher.end();
      locala = new r.a(this, i, j);
      if ((!a(this.RsL, locala)) && (i >= 0) && (j <= paramCharSequence.length()))
      {
        localu = new u(paramCharSequence.substring(i, j), 30, null);
        localu.start = i;
        localu.end = j;
        this.RsK.add(localu);
        localArrayList.add(locala);
      }
    }
    if (localArrayList.size() <= 0)
    {
      localMatcher = k.a.Rsc.matcher(paramCharSequence);
      while (localMatcher.find())
      {
        i = localMatcher.start();
        j = localMatcher.end();
        locala = new r.a(this, i, j);
        if ((!a(this.RsL, locala)) && (i >= 0) && (j <= paramCharSequence.length()))
        {
          localu = new u(paramCharSequence.substring(i, j), 30, null);
          localu.start = i;
          localu.end = j;
          this.RsK.add(localu);
          localArrayList.add(locala);
        }
      }
    }
    AppMethodBeat.o(152364);
    return localArrayList;
  }
  
  private ArrayList<r.a> az(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(198592);
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = paramCharSequence.toString();
    Matcher localMatcher = k.a.Rsj.matcher(paramCharSequence);
    while (localMatcher.find())
    {
      int i = localMatcher.start();
      int j = localMatcher.end();
      r.a locala = new r.a(this, i, j);
      if ((!a(this.RsL, locala)) && (i >= 0) && (j <= paramCharSequence.length()))
      {
        u localu = new u(paramCharSequence.substring(i, j), 60, null);
        localu.start = i;
        localu.bnW = this.Rti;
        localu.end = j;
        this.RsK.add(localu);
        localArrayList.add(locala);
      }
    }
    AppMethodBeat.o(198592);
    return localArrayList;
  }
  
  public static void clearCache()
  {
    AppMethodBeat.i(152369);
    RsJ.clear();
    AppMethodBeat.o(152369);
  }
  
  private CharSequence e(CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(152352);
    Object localObject2 = k.a.RrS.matcher(paramCharSequence);
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
            this.RsK.add(localObject2);
            this.RsL.add(new r.a(this, j, k));
            localObject2 = k.a.RrS.matcher((CharSequence)localObject1);
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
              if (this.Rti != null) {
                ((u)localObject3).bnW = this.Rti;
              }
              this.RsK.add(localObject3);
              this.RsL.add(new r.a(this, j, k));
            }
          }
        }
      }
    }
    Object localObject4 = localObject1;
    if (i == 0)
    {
      localObject3 = k.a.RrT.matcher(paramCharSequence);
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
            if ((!aP(str2, i, j)) && (paramBoolean))
            {
              localObject3 = new u(str2, 2147483646, null);
              if (this.Rti != null) {
                ((u)localObject3).bnW = this.Rti;
              }
              ((u)localObject3).start = i;
              ((u)localObject3).end = j;
              if (!a(this.RsL, new r.a(this, i, j)))
              {
                this.RsK.add(localObject3);
                this.RsL.add(new r.a(this, i, j));
              }
            }
            localObject3 = k.a.RrS.matcher((CharSequence)localObject1);
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
      if (j < Rtj.length) {
        if (!Rtj[j].isInstance(localObject)) {}
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
    if ((this.rR != null) && (!Util.isNullOrNil(paramSpannable.toString())))
    {
      if (ac.mGn)
      {
        this.rR.setText(paramSpannable, TextView.BufferType.SPANNABLE);
        AppMethodBeat.o(152367);
        return;
      }
      this.rR.setText(paramSpannable);
    }
    AppMethodBeat.o(152367);
  }
  
  public final r J(TextView paramTextView)
  {
    AppMethodBeat.i(152346);
    this.rR = paramTextView;
    if (paramTextView != null) {
      this.mContext = this.rR.getContext();
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
    this.Rtg = paramInt;
    Object localObject1 = aj(paramCharSequence);
    if (paramBoolean)
    {
      localObject2 = (SpannableString)RsJ.get(localObject1);
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
          if ((localObject1 != null) && ((((u)localObject1).type == 60) || (((u)localObject1).type == 58)) && (this.Rti != null)) {
            ((u)localObject1).bnW = this.Rti;
          }
          paramInt += 1;
        }
        AppMethodBeat.o(152348);
        return localObject2;
      }
    }
    paramCharSequence = ak(paramCharSequence);
    Object localObject3;
    if (this.Rth)
    {
      localObject2 = this.RsK.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (u)((Iterator)localObject2).next();
        ((u)localObject3).mSessionId = this.mSessionId;
        ((u)localObject3).fromScene = this.jaR;
        if (Util.isNullOrNil(((u)localObject3).url)) {
          paramCharSequence.setSpan(new ForegroundColorSpan(((u)localObject3).linkColor), ((u)localObject3).start, ((u)localObject3).end, 33);
        } else if ((((u)localObject3).start <= paramCharSequence.length()) && (((u)localObject3).end <= paramCharSequence.length())) {
          paramCharSequence.setSpan(new p(this.Rtf, (u)localObject3), ((u)localObject3).start, ((u)localObject3).end, 33);
        }
      }
    }
    Object localObject2 = this.RsM.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (z)((Iterator)localObject2).next();
      if ((((z)localObject3).start <= paramCharSequence.length()) && (((z)localObject3).end <= paramCharSequence.length()))
      {
        Object localObject4 = this.mContext.getResources().getDrawable(((z)localObject3).id);
        if ((((z)localObject3).width > 0) && (((z)localObject3).height > 0))
        {
          ((Drawable)localObject4).setBounds(0, 0, com.tencent.mm.ci.a.fromDPToPix(this.mContext, ((z)localObject3).width), com.tencent.mm.ci.a.fromDPToPix(this.mContext, ((z)localObject3).height));
          localObject4 = new com.tencent.mm.ui.widget.a((Drawable)localObject4, 1);
          ((com.tencent.mm.ui.widget.a)localObject4).Yal = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 2);
          paramCharSequence.setSpan(localObject4, ((z)localObject3).start, ((z)localObject3).start + 1, 18);
        }
        else
        {
          if (this.rR == null) {}
          for (paramInt = (int)(this.Rtg * 1.3F);; paramInt = (int)(this.rR.getTextSize() * 1.3F))
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
      RsJ.q(localObject1, new SpannableString(paramCharSequence));
    }
    AppMethodBeat.o(152348);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.r
 * JD-Core Version:    0.7.0.1
 */