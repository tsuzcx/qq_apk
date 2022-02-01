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
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.applet.z;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.ui.aj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class q
{
  private static final f<String, SpannableString> DCS;
  private static Class<?>[] DDq;
  private ArrayList<u> DCT;
  private ArrayList<a> DCU;
  private ArrayList<z> DCV;
  boolean DCW;
  boolean DCX;
  boolean DCY;
  boolean DCZ;
  boolean DDa;
  boolean DDb;
  boolean DDc;
  boolean DDd;
  boolean DDe;
  boolean DDf;
  boolean DDg;
  boolean DDh;
  boolean DDi;
  boolean DDj;
  boolean DDk;
  boolean DDl;
  int DDm;
  private int DDn;
  boolean DDo;
  Object DDp;
  private TextView Up;
  private Context mContext;
  String mSessionId;
  
  static
  {
    AppMethodBeat.i(152370);
    DCS = new c(500);
    DDq = new Class[] { com.tencent.mm.ui.widget.a.class, o.class, ForegroundColorSpan.class };
    AppMethodBeat.o(152370);
  }
  
  public q(Context paramContext)
  {
    AppMethodBeat.i(152345);
    this.DCT = new ArrayList();
    this.DCU = new ArrayList();
    this.DCV = new ArrayList();
    this.Up = null;
    this.DCW = false;
    this.DCX = false;
    this.DCY = true;
    this.DCZ = false;
    this.DDa = false;
    this.DDb = true;
    this.DDc = true;
    this.DDd = false;
    this.DDe = false;
    this.DDf = false;
    this.DDg = false;
    this.DDh = false;
    this.DDi = false;
    this.DDj = true;
    this.DDk = false;
    this.DDl = false;
    this.DDm = 0;
    this.DDn = 0;
    this.mContext = null;
    this.DDo = false;
    this.DCT = new ArrayList();
    this.DCU = new ArrayList();
    this.DCV = new ArrayList();
    this.mContext = paramContext;
    AppMethodBeat.o(152345);
  }
  
  private String T(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152347);
    paramCharSequence = paramCharSequence + "@" + this.DDn + "@" + this.DCW + "@" + this.DCX + "@" + this.DDa + "@" + this.DDb + "@" + this.DDc + "@" + this.DDm + "@" + this.DDo + "@" + this.DDg + "@" + this.DDh + "@" + this.DDi;
    AppMethodBeat.o(152347);
    return paramCharSequence;
  }
  
  private SpannableString U(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152350);
    this.DCT = new ArrayList();
    Object localObject;
    if (this.DDn <= 0)
    {
      if (this.Up != null) {
        this.DDn = ((int)this.Up.getTextSize());
      }
    }
    else
    {
      if (this.DCT == null) {
        this.DCT = new ArrayList();
      }
      if (this.DCU == null) {
        this.DCU = new ArrayList();
      }
      this.DCT.clear();
      this.DCU.clear();
      localObject = paramCharSequence;
      if (com.tencent.mm.compatible.util.n.v(paramCharSequence))
      {
        localObject = paramCharSequence;
        if (this.DDj)
        {
          localObject = paramCharSequence;
          if (e.a.DBY != null) {
            if (!e.a.DBY.K(paramCharSequence))
            {
              localObject = paramCharSequence;
              if (!e.a.DBY.J(paramCharSequence)) {}
            }
            else
            {
              localObject = paramCharSequence.toString().replace("\n", "                                                                                                                                                                                                                                                                                                                        ");
            }
          }
        }
      }
      paramCharSequence = (CharSequence)localObject;
      if (this.DCW)
      {
        if (!((CharSequence)localObject).toString().contains("data-miniprogram-appid")) {
          break label295;
        }
        paramCharSequence = X((CharSequence)localObject);
      }
      label187:
      localObject = paramCharSequence;
      if (this.DDg) {
        localObject = V(paramCharSequence);
      }
      paramCharSequence = (CharSequence)localObject;
      if (this.DDi) {
        paramCharSequence = b((CharSequence)localObject, this.DDl);
      }
      if ((!this.DDj) || (e.a.DBY == null)) {
        break label320;
      }
      paramCharSequence = e.a.DBY.n(paramCharSequence, this.DDn);
    }
    label295:
    label320:
    for (;;)
    {
      if (this.DCY) {
        Y(paramCharSequence);
      }
      if ((paramCharSequence instanceof Spannable))
      {
        paramCharSequence = (SpannableString)paramCharSequence;
        AppMethodBeat.o(152350);
        return paramCharSequence;
        this.DDn = com.tencent.mm.cc.a.au(this.mContext, 2131165517);
        break;
        paramCharSequence = W((CharSequence)localObject);
        break label187;
      }
      paramCharSequence = new SpannableString(paramCharSequence);
      AppMethodBeat.o(152350);
      return paramCharSequence;
    }
  }
  
  private CharSequence V(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152351);
    Object localObject2 = j.a.DCg.matcher(paramCharSequence.toString());
    Object localObject1 = paramCharSequence;
    paramCharSequence = (CharSequence)localObject2;
    if (paramCharSequence.find())
    {
      if (this.DDh) {
        paramCharSequence = ((CharSequence)localObject1).toString().replace(paramCharSequence.group(0), "");
      }
      for (;;)
      {
        localObject2 = j.a.DCb.matcher(paramCharSequence);
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
          if ((!bs.isNullOrNil((String)localObject2)) && ("original_label".equals(localObject2)))
          {
            paramCharSequence.height = 15;
            paramCharSequence.width = 35;
          }
          this.DCV.add(paramCharSequence);
          paramCharSequence = (CharSequence)localObject1;
        }
        else
        {
          ac.w("MicroMsg.SpanProcessor", "dz[parseImgSpan:error drawable name %s]", new Object[] { localObject2 });
          paramCharSequence = (CharSequence)localObject1;
        }
      }
    }
    AppMethodBeat.o(152351);
    return localObject1;
  }
  
  private CharSequence W(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152353);
    String str1 = paramCharSequence.toString();
    Matcher localMatcher;
    if (str1.length() < 1500) {
      localMatcher = j.a.DCb.matcher(str1);
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
          ac.e("MicroMsg.SpanProcessor", "parseHref error, start:%d, end:%d, source.length:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramCharSequence.length()) });
          continue;
          localMatcher = j.a.DCa.matcher(str1);
        }
        else
        {
          aF(str2, i, j);
          if (str1.length() < 1500) {
            localMatcher = j.a.DCb.matcher(str1);
          } else {
            localMatcher = j.a.DCa.matcher(str1);
          }
        }
      }
    }
    AppMethodBeat.o(152353);
    return str1;
  }
  
  private CharSequence X(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152354);
    Object localObject1 = paramCharSequence.toString();
    Object localObject2;
    if (((String)localObject1).length() < 1500) {
      localObject2 = j.a.DCd.matcher((CharSequence)localObject1);
    }
    while (((Matcher)localObject2).find())
    {
      String str4 = ((Matcher)localObject2).group(0);
      String str1 = ((Matcher)localObject2).group(1);
      String str3 = ((Matcher)localObject2).group(2);
      Object localObject3 = bv.L(str4.replace(str1, " ").replace(str3, " "), "a");
      if (localObject3 == null)
      {
        ac.e("MicroMsg.SpanProcessor", "XmlParser parse return null, so continue");
        continue;
        localObject2 = j.a.DCc.matcher((CharSequence)localObject1);
      }
      else
      {
        String str2 = (String)((Map)localObject3).get(".a.$data-miniprogram-appid");
        localObject3 = (String)((Map)localObject3).get(".a.$data-miniprogram-path");
        int i;
        label163:
        int j;
        if (!bs.isNullOrNil(str1))
        {
          i = 1;
          if (bs.isNullOrNil(str2)) {
            break label280;
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
              ac.e("MicroMsg.SpanProcessor", "parseHref error, start:%d, end:%d, source.length:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramCharSequence.length()) });
              break;
              i = 0;
              break label163;
              label280:
              j = 0;
              continue;
            }
            aF(str1, i, j);
          }
        }
        for (;;)
        {
          if (((String)localObject1).length() < 1500)
          {
            localObject2 = j.a.DCd.matcher((CharSequence)localObject1);
            break;
            if (j != 0)
            {
              if (this.DDh)
              {
                localObject1 = ((String)localObject1).toString().replace(str4, str3);
                i = ((Matcher)localObject2).start(0);
                j = str3.length();
                localObject2 = new u(str1, 45, null);
                ((u)localObject2).start = i;
                ((u)localObject2).end = (j + i);
                this.DCT.add(localObject2);
              }
              else
              {
                str3 = "    ".concat(String.valueOf(str3));
                str1 = ((String)localObject1).toString().replace(str4, str3);
                i = ((Matcher)localObject2).start(0);
                j = str3.length();
                if (aj.DT()) {}
                for (localObject1 = new z(i + 1, i + 3, 2131691250);; localObject1 = new z(i + 1, i + 3, 2131691249))
                {
                  this.DCV.add(localObject1);
                  localObject1 = new u(str2, 45, localObject3);
                  ((u)localObject1).start = (i + 4);
                  ((u)localObject1).end = (i + j);
                  this.DCT.add(localObject1);
                  localObject1 = str1;
                  break;
                }
              }
            }
            else
            {
              ac.e("MicroMsg.SpanProcessor", "url && appId is null, continue");
              break;
            }
          }
        }
        localObject2 = j.a.DCc.matcher((CharSequence)localObject1);
      }
    }
    AppMethodBeat.o(152354);
    return localObject1;
  }
  
  private void Y(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152355);
    if (this.DDb) {
      this.DCU.addAll(Z(paramCharSequence));
    }
    if (this.DCX) {
      this.DCU.addAll(ab(paramCharSequence));
    }
    if (this.DCZ) {
      this.DCU.addAll(ac(paramCharSequence));
    }
    if (this.DDf) {
      this.DCU.addAll(ah(paramCharSequence));
    }
    if (this.DDc) {
      this.DCU.addAll(ad(paramCharSequence));
    }
    if (this.DDd) {
      this.DCU.addAll(ae(paramCharSequence));
    }
    if (this.DDa) {
      this.DCU.addAll(af(paramCharSequence));
    }
    if (this.DDe) {
      this.DCU.addAll(ag(paramCharSequence));
    }
    if (this.DDk) {
      this.DCU.addAll(aa(paramCharSequence));
    }
    AppMethodBeat.o(152355);
  }
  
  private ArrayList<a> Z(CharSequence paramCharSequence)
  {
    int i = 2000;
    AppMethodBeat.i(152356);
    ArrayList localArrayList = new ArrayList();
    Object localObject = j.a.DCk;
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
        if (!a(this.DCU, new a(i, j)))
        {
          this.DCT.add(localObject);
          localArrayList.add(new a(i, j));
        }
      }
      i = paramCharSequence.length();
    }
    AppMethodBeat.o(152356);
    return localArrayList;
  }
  
  private void a(SpannableString paramSpannableString)
  {
    int i = 0;
    AppMethodBeat.i(152368);
    if (this.Up != null)
    {
      paramSpannableString = new n();
      paramSpannableString.mSessionId = this.mSessionId;
      this.Up.setOnTouchListener(paramSpannableString);
      AppMethodBeat.o(152368);
      return;
    }
    if (paramSpannableString != null)
    {
      paramSpannableString = (o[])paramSpannableString.getSpans(0, paramSpannableString.length(), o.class);
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
  
  private boolean aF(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152365);
    paramString = a.a(this.mContext, paramString, paramInt1, paramInt2);
    if (paramString != null)
    {
      if (this.DDp != null) {
        paramString.data = this.DDp;
      }
      this.DCT.add(paramString);
      this.DCU.add(new a(paramInt1, paramInt2));
      AppMethodBeat.o(152365);
      return true;
    }
    AppMethodBeat.o(152365);
    return false;
  }
  
  private ArrayList<a> aa(CharSequence paramCharSequence)
  {
    int i = 2000;
    AppMethodBeat.i(152357);
    ArrayList localArrayList = new ArrayList();
    Object localObject = j.a.DCl;
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
        if (!a(this.DCU, new a(i, j)))
        {
          this.DCT.add(localObject);
          localArrayList.add(new a(i, j));
        }
      }
      i = paramCharSequence.length();
    }
    AppMethodBeat.o(152357);
    return localArrayList;
  }
  
  private ArrayList<a> ab(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152358);
    ArrayList localArrayList = new ArrayList();
    String str = paramCharSequence.toString();
    if (str.length() > 500) {
      paramCharSequence = j.a.DCj.matcher(str.toLowerCase());
    }
    while (paramCharSequence.find())
    {
      int i = paramCharSequence.start();
      int j = paramCharSequence.end();
      if ((!a(this.DCU, new a(i, j))) && (i >= 0) && (j <= str.length())) {
        if (j < str.length())
        {
          int k = str.charAt(j);
          if ((97 <= k) && (k <= 122)) {}
        }
        else
        {
          u localu = new u(str.substring(i, j), 1, this.DDp);
          localu.start = i;
          localu.end = j;
          this.DCT.add(localu);
          localArrayList.add(new a(i, j));
          continue;
          paramCharSequence = j.a.DCi.matcher(str.toLowerCase());
        }
      }
    }
    AppMethodBeat.o(152358);
    return localArrayList;
  }
  
  private ArrayList<a> ac(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152359);
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = paramCharSequence.toString();
    if (paramCharSequence.length() > 200)
    {
      AppMethodBeat.o(152359);
      return localArrayList;
    }
    Matcher localMatcher = j.a.DCq.matcher(paramCharSequence);
    while (localMatcher.find())
    {
      int i = localMatcher.start();
      int j = localMatcher.end();
      if ((!a(this.DCU, new a(i, j))) && (i >= 0) && (j <= paramCharSequence.length()))
      {
        u localu = new u(paramCharSequence.substring(i, j), 44, this.DDp);
        localu.start = i;
        localu.end = j;
        this.DCT.add(localu);
        localArrayList.add(new a(i, j));
      }
    }
    AppMethodBeat.o(152359);
    return localArrayList;
  }
  
  private ArrayList<a> ad(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152360);
    ArrayList localArrayList = new ArrayList();
    String str = paramCharSequence.toString();
    paramCharSequence = j.a.DCn.matcher(paramCharSequence);
    while (paramCharSequence.find())
    {
      int i = paramCharSequence.start();
      int j = paramCharSequence.end();
      if ((!a(this.DCU, new a(i, j))) && (i >= 0) && (j <= str.length()))
      {
        u localu = new u(str.substring(i, j), 28, null);
        localu.start = i;
        localu.end = j;
        this.DCT.add(localu);
        localArrayList.add(new a(i, j));
      }
    }
    AppMethodBeat.o(152360);
    return localArrayList;
  }
  
  private ArrayList<a> ae(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152361);
    ArrayList localArrayList = new ArrayList();
    String str = paramCharSequence.toString();
    paramCharSequence = j.a.DCr.matcher(paramCharSequence);
    while (paramCharSequence.find())
    {
      Object localObject = paramCharSequence.group();
      if (b.DBT.aHE((String)localObject))
      {
        int i = paramCharSequence.start();
        int j = paramCharSequence.end();
        if ((!a(this.DCU, new a(i, j))) && (i >= 0) && (j <= str.length()))
        {
          localObject = new u(str.substring(i, j), 50, this.DDp);
          ((u)localObject).start = i;
          ((u)localObject).end = j;
          this.DCT.add(localObject);
          localArrayList.add(new a(i, j));
        }
      }
    }
    AppMethodBeat.o(152361);
    return localArrayList;
  }
  
  private ArrayList<a> af(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152362);
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = j.a.DCm.matcher(paramCharSequence);
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
      if (((i != 6) && (i != 5)) || (("+12306+12110+12395+12121+12117+12119+95555+95566+95533+95588+95558+95599+95568+95595+95559+95508+95528+95501+95577+95561+10086+10010+10000+17951+17911+17900+118114+116114+950718+95598+12318+12315+12358+12365+12310+12369+12333+12366+95518+95519+95511+95500+95522+95567+95017".contains((CharSequence)localObject)) && (i < 100) && (!a(this.DCU, new a(k, m)))))
      {
        localObject = new u((String)localObject, 25, this.DDp);
        ((u)localObject).start = k;
        ((u)localObject).end = m;
        this.DCT.add(localObject);
        localArrayList.add(new a(k, m));
      }
    }
    AppMethodBeat.o(152362);
    return localArrayList;
  }
  
  private ArrayList<a> ag(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152363);
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = a.bO(this.mContext, paramCharSequence.toString()).iterator();
    while (paramCharSequence.hasNext())
    {
      u localu = (u)paramCharSequence.next();
      a locala = new a(localu.start, localu.end);
      if (!a(this.DCU, locala))
      {
        this.DCT.add(localu);
        localArrayList.add(locala);
      }
    }
    AppMethodBeat.o(152363);
    return localArrayList;
  }
  
  private ArrayList<a> ah(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(152364);
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = paramCharSequence.toString();
    Matcher localMatcher = j.a.DCp.matcher(paramCharSequence);
    int i;
    int j;
    a locala;
    u localu;
    while (localMatcher.find())
    {
      i = localMatcher.start();
      j = localMatcher.end();
      locala = new a(i, j);
      if ((!a(this.DCU, locala)) && (i >= 0) && (j <= paramCharSequence.length()))
      {
        localu = new u(paramCharSequence.substring(i, j), 30, null);
        localu.start = i;
        localu.end = j;
        this.DCT.add(localu);
        localArrayList.add(locala);
      }
    }
    if (localArrayList.size() <= 0)
    {
      localMatcher = j.a.DCo.matcher(paramCharSequence);
      while (localMatcher.find())
      {
        i = localMatcher.start();
        j = localMatcher.end();
        locala = new a(i, j);
        if ((!a(this.DCU, locala)) && (i >= 0) && (j <= paramCharSequence.length()))
        {
          localu = new u(paramCharSequence.substring(i, j), 30, null);
          localu.start = i;
          localu.end = j;
          this.DCT.add(localu);
          localArrayList.add(locala);
        }
      }
    }
    AppMethodBeat.o(152364);
    return localArrayList;
  }
  
  private CharSequence b(CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(152352);
    Object localObject2 = j.a.DCe.matcher(paramCharSequence);
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
          ac.e("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error: start:%d, end:%d, source.length:%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramCharSequence.length()) });
          continue;
        }
        try
        {
          i = Color.parseColor((String)localObject4);
          if (bs.isNullOrNil(str1))
          {
            localObject2 = new u(j, k);
            ((u)localObject2).linkColor = i;
            this.DCT.add(localObject2);
            this.DCU.add(new a(j, k));
            localObject2 = j.a.DCe.matcher((CharSequence)localObject1);
            i = 1;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localObject3 = ai.getContext();
            int m = ((Context)localObject3).getResources().getIdentifier((String)localObject4, "color", ((Context)localObject3).getPackageName());
            if (m <= 0) {}
            for (i = 0;; i = ai.getContext().getResources().getColor(m))
            {
              ac.w("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error at color : %s, resId : %s]", new Object[] { localObject4, Integer.valueOf(m) });
              break;
            }
            localObject3 = a.a(this.mContext, str1, j, k, i, i & 0x99FFFFFF);
            if (localObject3 != null)
            {
              if (this.DDp != null) {
                ((u)localObject3).data = this.DDp;
              }
              this.DCT.add(localObject3);
              this.DCU.add(new a(j, k));
            }
          }
        }
      }
    }
    Object localObject4 = localObject1;
    if (i == 0)
    {
      localObject3 = j.a.DCf.matcher(paramCharSequence);
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
            ac.e("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error: start:%d, end:%d, source.length:%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramCharSequence.length()) });
          }
          else
          {
            if ((!aF((String)localObject4, i, j)) && (paramBoolean))
            {
              localObject3 = new u((String)localObject4, 2147483646, null);
              if (this.DDp != null) {
                ((u)localObject3).data = this.DDp;
              }
              ((u)localObject3).start = i;
              ((u)localObject3).end = j;
              if (!a(this.DCU, new a(i, j)))
              {
                this.DCT.add(localObject3);
                this.DCU.add(new a(i, j));
              }
            }
            localObject3 = j.a.DCe.matcher((CharSequence)localObject1);
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
    DCS.clear();
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
      if (j < DDq.length) {
        if (!DDq[j].isInstance(localObject)) {}
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
    if ((this.Up != null) && (!bs.isNullOrNil(paramSpannable.toString())))
    {
      if (ab.iwh)
      {
        this.Up.setText(paramSpannable, TextView.BufferType.SPANNABLE);
        AppMethodBeat.o(152367);
        return;
      }
      this.Up.setText(paramSpannable);
    }
    AppMethodBeat.o(152367);
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
    this.DDn = paramInt;
    String str = T(paramCharSequence);
    if (paramBoolean)
    {
      localObject1 = (SpannableString)DCS.get(str);
      if (localObject1 != null)
      {
        f((Spannable)localObject1);
        g((Spannable)localObject1);
        a((SpannableString)localObject1);
        AppMethodBeat.o(152348);
        return localObject1;
      }
    }
    paramCharSequence = U(paramCharSequence);
    Object localObject2;
    if (this.DDo)
    {
      localObject1 = this.DCT.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (u)((Iterator)localObject1).next();
        ((u)localObject2).mSessionId = this.mSessionId;
        if (bs.isNullOrNil(((u)localObject2).url)) {
          paramCharSequence.setSpan(new ForegroundColorSpan(((u)localObject2).linkColor), ((u)localObject2).start, ((u)localObject2).end, 33);
        } else if ((((u)localObject2).start <= paramCharSequence.length()) && (((u)localObject2).end <= paramCharSequence.length())) {
          paramCharSequence.setSpan(new o(this.DDm, (u)localObject2), ((u)localObject2).start, ((u)localObject2).end, 33);
        }
      }
    }
    Object localObject1 = this.DCV.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (z)((Iterator)localObject1).next();
      if ((((z)localObject2).start <= paramCharSequence.length()) && (((z)localObject2).end <= paramCharSequence.length()))
      {
        Object localObject3 = this.mContext.getResources().getDrawable(((z)localObject2).id);
        if ((((z)localObject2).width > 0) && (((z)localObject2).height > 0))
        {
          ((Drawable)localObject3).setBounds(0, 0, com.tencent.mm.cc.a.fromDPToPix(this.mContext, ((z)localObject2).width), com.tencent.mm.cc.a.fromDPToPix(this.mContext, ((z)localObject2).height));
          localObject3 = new com.tencent.mm.ui.widget.a((Drawable)localObject3);
          ((com.tencent.mm.ui.widget.a)localObject3).IZa = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 2);
          paramCharSequence.setSpan(localObject3, ((z)localObject2).start, ((z)localObject2).start + 1, 18);
        }
        else
        {
          if (this.Up == null) {}
          for (paramInt = (int)(this.DDn * 1.3F);; paramInt = (int)(this.Up.getTextSize() * 1.3F))
          {
            ((Drawable)localObject3).setBounds(0, 0, paramInt, paramInt);
            break;
          }
        }
      }
    }
    g(paramCharSequence);
    a(paramCharSequence);
    if (paramBoolean) {
      DCS.o(str, new SpannableString(paramCharSequence));
    }
    AppMethodBeat.o(152348);
    return paramCharSequence;
  }
  
  public final q w(TextView paramTextView)
  {
    AppMethodBeat.i(152346);
    this.Up = paramTextView;
    if (paramTextView != null) {
      this.mContext = this.Up.getContext();
    }
    AppMethodBeat.o(152346);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.q
 * JD-Core Version:    0.7.0.1
 */