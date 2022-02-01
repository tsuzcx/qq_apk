package com.tencent.mm.plugin.textstatus.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class t
{
  private static String MzR;
  private static long MzS;
  private static long MzT;
  private static final SimpleDateFormat MzU;
  private static final SimpleDateFormat MzV;
  private static final SimpleDateFormat MzW;
  
  static
  {
    AppMethodBeat.i(243653);
    MzR = "#([^\\n\\s\\t#@\\,，\\.。]{1,32})";
    MzS = 0L;
    MzT = 1L;
    MzU = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    MzV = new SimpleDateFormat("HH:mm");
    MzW = new SimpleDateFormat("yyyy-MM-dd");
    AppMethodBeat.o(243653);
  }
  
  private static String RZ(long paramLong)
  {
    AppMethodBeat.i(243646);
    try
    {
      String str = MzW.format(Long.valueOf(paramLong));
      AppMethodBeat.o(243646);
      return str;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(243646);
    }
    return "";
  }
  
  private static Calendar Sa(long paramLong)
  {
    AppMethodBeat.i(243647);
    try
    {
      Object localObject = MzU.format(Long.valueOf(paramLong));
      localObject = MzU.parse((String)localObject);
      Calendar localCalendar = Calendar.getInstance();
      if (localObject == null)
      {
        AppMethodBeat.o(243647);
        return null;
      }
      localCalendar.setTime((Date)localObject);
      AppMethodBeat.o(243647);
      return localCalendar;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(243647);
    }
    return null;
  }
  
  private static String a(int paramInt, a parama)
  {
    AppMethodBeat.i(243640);
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(paramInt).append("_");
    if (parama != null) {}
    for (parama = parama.toString();; parama = "")
    {
      localStringBuilder2.append(parama).append("_").append(RZ(cm.bfC()));
      parama = localStringBuilder1.toString();
      AppMethodBeat.o(243640);
      return parama;
    }
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(243642);
    if ((paramb == null) || (paramb.style == 0))
    {
      AppMethodBeat.o(243642);
      return;
    }
    paramb = a(paramb.style, paramb.MzZ);
    Log.d("MicroMsg.TextStatus.TextStatusSwitch", "setFriendsStatusBtnClick:%s", new Object[] { paramb });
    h.aHG().aHp().set(ar.a.VEa, paramb);
    AppMethodBeat.o(243642);
  }
  
  private static b bel(String paramString)
  {
    AppMethodBeat.i(243644);
    b localb = new b();
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        i = paramString.optInt("style", 0);
        if ((i > 0) && (i <= 2))
        {
          paramString = a.J(paramString.optJSONArray("durations"));
          if (paramString.size() <= 0) {
            continue;
          }
          localObject = Sa(cm.bfE());
          if (localObject != null)
          {
            int j = ((Calendar)localObject).get(11);
            int k = ((Calendar)localObject).get(12);
            int m = j * 60 + k;
            Log.d("MicroMsg.TextStatus.TextStatusSwitch", "btnStyle convert cur h:%s, m:%s, tm:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
            paramString = paramString.iterator();
            if (paramString.hasNext())
            {
              localObject = (a)paramString.next();
              Log.d("MicroMsg.TextStatus.TextStatusSwitch", "btnStyle convert DurationData:%s", new Object[] { localObject });
              if ((m < ((a)localObject).MzX) || (m > ((a)localObject).MzY)) {
                continue;
              }
              String str1 = glv();
              String str2 = a(i, (a)localObject);
              Log.d("MicroMsg.TextStatus.TextStatusSwitch", "btnStyle convert curtag:%s, targetTag:%s", new Object[] { str1, str2 });
              if (TextUtils.equals(str1, str2)) {
                continue;
              }
              localb.style = i;
              localb.MzZ = ((a)localObject);
            }
          }
        }
      }
      catch (Throwable paramString)
      {
        int i;
        Object localObject;
        Log.printErrStackTrace("MicroMsg.TextStatus.TextStatusSwitch", paramString, "convertBtnStyle", new Object[0]);
        continue;
      }
      AppMethodBeat.o(243644);
      return localb;
      paramString = glv();
      localObject = a(i, null);
      Log.d("MicroMsg.TextStatus.TextStatusSwitch", "btnStyle convert curtag:%s, targetTag:%s", new Object[] { paramString, localObject });
      if (!TextUtils.equals(paramString, (CharSequence)localObject)) {
        localb.style = i;
      }
    }
  }
  
  private static Calendar bem(String paramString)
  {
    AppMethodBeat.i(243649);
    try
    {
      paramString = MzV.parse(paramString);
      Calendar localCalendar = Calendar.getInstance();
      if (paramString == null)
      {
        AppMethodBeat.o(243649);
        return null;
      }
      localCalendar.setTime(paramString);
      AppMethodBeat.o(243649);
      return localCalendar;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(243649);
    }
    return null;
  }
  
  public static boolean gkZ()
  {
    AppMethodBeat.i(243615);
    if (((b)h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.waM, 1) == 1)
    {
      AppMethodBeat.o(243615);
      return true;
    }
    AppMethodBeat.o(243615);
    return false;
  }
  
  public static boolean gla()
  {
    AppMethodBeat.i(243616);
    if (!gkZ())
    {
      AppMethodBeat.o(243616);
      return false;
    }
    if (((b)h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.waN, com.tencent.mm.util.b.a.YxY, 0) == 1)
    {
      AppMethodBeat.o(243616);
      return true;
    }
    AppMethodBeat.o(243616);
    return false;
  }
  
  public static boolean glb()
  {
    AppMethodBeat.i(243617);
    if (h.aHG().aHp().getBoolean(ar.a.VDX, false))
    {
      AppMethodBeat.o(243617);
      return false;
    }
    if (!gls())
    {
      AppMethodBeat.o(243617);
      return false;
    }
    AppMethodBeat.o(243617);
    return true;
  }
  
  public static void glc()
  {
    AppMethodBeat.i(243618);
    h.aHG().aHp().set(ar.a.VDX, Boolean.TRUE);
    AppMethodBeat.o(243618);
  }
  
  public static void gld()
  {
    AppMethodBeat.i(243619);
    h.aHG().aHp().set(ar.a.VDW, Boolean.TRUE);
    AppMethodBeat.o(243619);
  }
  
  public static boolean gle()
  {
    AppMethodBeat.i(243620);
    if (!gkZ())
    {
      AppMethodBeat.o(243620);
      return false;
    }
    if (h.aHG().aHp().getBoolean(ar.a.VDW, false))
    {
      AppMethodBeat.o(243620);
      return false;
    }
    if (((b)h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.waO, com.tencent.mm.util.b.a.YxX, 0) == 1)
    {
      AppMethodBeat.o(243620);
      return true;
    }
    AppMethodBeat.o(243620);
    return false;
  }
  
  public static int glf()
  {
    AppMethodBeat.i(243621);
    if (!gkZ())
    {
      AppMethodBeat.o(243621);
      return 0;
    }
    AppMethodBeat.o(243621);
    return 0;
  }
  
  public static String glg()
  {
    AppMethodBeat.i(243622);
    if (!gkZ())
    {
      str = MzR;
      AppMethodBeat.o(243622);
      return str;
    }
    String str = ((b)h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.waQ, MzR);
    AppMethodBeat.o(243622);
    return str;
  }
  
  public static boolean glh()
  {
    AppMethodBeat.i(243623);
    if (!gkZ())
    {
      AppMethodBeat.o(243623);
      return false;
    }
    if (((b)h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.waS, 1) == 1)
    {
      AppMethodBeat.o(243623);
      return true;
    }
    AppMethodBeat.o(243623);
    return false;
  }
  
  public static boolean gli()
  {
    AppMethodBeat.i(243624);
    if (!gkZ())
    {
      AppMethodBeat.o(243624);
      return false;
    }
    if (((b)h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.waT, 1) == 1)
    {
      AppMethodBeat.o(243624);
      return true;
    }
    AppMethodBeat.o(243624);
    return false;
  }
  
  public static boolean glj()
  {
    AppMethodBeat.i(243626);
    if (!gkZ())
    {
      AppMethodBeat.o(243626);
      return false;
    }
    if (((b)h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.waU, com.tencent.mm.util.b.a.YxZ, 0) == 1)
    {
      AppMethodBeat.o(243626);
      return true;
    }
    AppMethodBeat.o(243626);
    return false;
  }
  
  public static boolean glk()
  {
    AppMethodBeat.i(243627);
    if (!gkZ())
    {
      AppMethodBeat.o(243627);
      return false;
    }
    if (((b)h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.waV, com.tencent.mm.util.b.a.Yya, 0) == 1)
    {
      AppMethodBeat.o(243627);
      return true;
    }
    AppMethodBeat.o(243627);
    return false;
  }
  
  public static boolean gll()
  {
    AppMethodBeat.i(243628);
    if (!gkZ())
    {
      AppMethodBeat.o(243628);
      return false;
    }
    if (((b)h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.waW, com.tencent.mm.util.b.a.Yyb, 0) == 1)
    {
      AppMethodBeat.o(243628);
      return true;
    }
    AppMethodBeat.o(243628);
    return false;
  }
  
  public static boolean glm()
  {
    AppMethodBeat.i(243629);
    if (!gkZ())
    {
      AppMethodBeat.o(243629);
      return false;
    }
    if (((b)h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.waX, com.tencent.mm.util.b.a.Yyc, 0) == 1)
    {
      AppMethodBeat.o(243629);
      return true;
    }
    AppMethodBeat.o(243629);
    return false;
  }
  
  public static boolean gln()
  {
    AppMethodBeat.i(243631);
    int i = glo();
    boolean bool;
    if (i == 1) {
      if (h.aHG().aHp().a(ar.a.VDO, MzT) == MzS) {
        bool = true;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.TextStatus.TextStatusSwitch", "result:%s level:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      AppMethodBeat.o(243631);
      return bool;
      bool = false;
      continue;
      if (i == 2) {
        bool = false;
      } else {
        bool = true;
      }
    }
  }
  
  public static int glo()
  {
    AppMethodBeat.i(243632);
    int i = ((b)h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.waY, 1);
    AppMethodBeat.o(243632);
    return i;
  }
  
  public static int glp()
  {
    AppMethodBeat.i(243633);
    int i = ((b)h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.wba, 1);
    AppMethodBeat.o(243633);
    return i;
  }
  
  public static boolean glq()
  {
    AppMethodBeat.i(243634);
    if (((b)h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.wbb, com.tencent.mm.util.b.a.Yyd, 0) == 1)
    {
      AppMethodBeat.o(243634);
      return true;
    }
    AppMethodBeat.o(243634);
    return false;
  }
  
  public static boolean glr()
  {
    AppMethodBeat.i(243635);
    if (((b)h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.wbf, com.tencent.mm.util.b.a.Yyh, 0) == 1)
    {
      AppMethodBeat.o(243635);
      return true;
    }
    AppMethodBeat.o(243635);
    return false;
  }
  
  public static boolean gls()
  {
    AppMethodBeat.i(243636);
    if (((a)h.ae(a.class)).axc().getInt("StatusSquareSelfTagEntry", 0) == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(243636);
      return true;
    }
    if (((b)h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.wbc, com.tencent.mm.util.b.a.Yye, 0) == 1)
    {
      AppMethodBeat.o(243636);
      return true;
    }
    AppMethodBeat.o(243636);
    return false;
  }
  
  public static boolean glt()
  {
    AppMethodBeat.i(243637);
    if (((a)h.ae(a.class)).axc().getInt("StatusSquareOthersTagEntry", 0) == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(243637);
      return true;
    }
    if (((b)h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.wbd, com.tencent.mm.util.b.a.Yyf, 0) == 1)
    {
      AppMethodBeat.o(243637);
      return true;
    }
    AppMethodBeat.o(243637);
    return false;
  }
  
  public static boolean glu()
  {
    AppMethodBeat.i(243638);
    if (((b)h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.wbg, com.tencent.mm.util.b.a.Yyi, 0) == 1)
    {
      AppMethodBeat.o(243638);
      return true;
    }
    AppMethodBeat.o(243638);
    return false;
  }
  
  private static String glv()
  {
    AppMethodBeat.i(243639);
    String str = h.aHG().aHp().a(ar.a.VEa, "");
    AppMethodBeat.o(243639);
    return str;
  }
  
  public static b glw()
  {
    AppMethodBeat.i(243643);
    long l = System.currentTimeMillis();
    String str = ((a)h.ae(a.class)).axc().getValue("StatusFriendsButtonStyleConfig");
    b localb;
    if (!TextUtils.isEmpty(str))
    {
      localb = bel(str);
      Log.d("MicroMsg.TextStatus.TextStatusSwitch", "btnStyle convert dConfig src:%s style:%s", new Object[] { str, Integer.valueOf(localb.style) });
    }
    for (;;)
    {
      Log.d("MicroMsg.TextStatus.TextStatusSwitch", "btnStyle final:%s cost:%s", new Object[] { localb, Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(243643);
      return localb;
      str = ((b)h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.wbe, "");
      localb = bel(str);
      Log.d("MicroMsg.TextStatus.TextStatusSwitch", "btnStyle convert xConfig src:%s style:%s", new Object[] { str, Integer.valueOf(localb.style) });
    }
  }
  
  static final class a
  {
    public int MzX;
    public int MzY;
    
    public static List<a> J(JSONArray paramJSONArray)
    {
      AppMethodBeat.i(243680);
      LinkedList localLinkedList = new LinkedList();
      if (paramJSONArray != null)
      {
        int i = 0;
        while (i < paramJSONArray.length())
        {
          a locala = beo(paramJSONArray.optString(i));
          if (locala != null) {
            localLinkedList.add(locala);
          }
          i += 1;
        }
      }
      AppMethodBeat.o(243680);
      return localLinkedList;
    }
    
    private static a beo(String paramString)
    {
      AppMethodBeat.i(243678);
      try
      {
        Object localObject = paramString.split("-");
        if (localObject != null)
        {
          int i = localObject.length;
          if (i == 2) {}
        }
        else
        {
          AppMethodBeat.o(243678);
          return null;
        }
        paramString = t.ben(localObject[0]);
        if (paramString == null)
        {
          AppMethodBeat.o(243678);
          return null;
        }
        localObject = t.ben(localObject[1]);
        if (localObject == null)
        {
          AppMethodBeat.o(243678);
          return null;
        }
        a locala = new a();
        locala.MzX = t.b(paramString);
        locala.MzY = t.b((Calendar)localObject);
        if (locala.MzY == 0) {
          locala.MzY = 1440;
        }
        AppMethodBeat.o(243678);
        return locala;
      }
      catch (Throwable paramString)
      {
        AppMethodBeat.o(243678);
      }
      return null;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(243677);
      String str = this.MzX + "_" + this.MzY;
      AppMethodBeat.o(243677);
      return str;
    }
  }
  
  public static final class b
  {
    public t.a MzZ;
    public int style = 0;
    
    public final int glx()
    {
      if (this.style == 1) {
        return 2;
      }
      if (this.style == 2) {
        return 3;
      }
      return 1;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(243692);
      String str = "btnStyle{style=" + this.style + ", durationData=" + this.MzZ + '}';
      AppMethodBeat.o(243692);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.a.t
 * JD-Core Version:    0.7.0.1
 */