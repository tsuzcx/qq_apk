package com.tencent.mm.plugin.textstatus.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ac
{
  private static String ThZ;
  private static long Tia;
  private static long Tib;
  private static final SimpleDateFormat Tic;
  private static final SimpleDateFormat Tid;
  private static final SimpleDateFormat Tie;
  
  static
  {
    AppMethodBeat.i(290008);
    ThZ = "#([^\\n\\s\\t#@\\,，\\.。]{1,32})";
    Tia = 0L;
    Tib = 1L;
    Tic = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Tid = new SimpleDateFormat("HH:mm");
    Tie = new SimpleDateFormat("yyyy-MM-dd");
    AppMethodBeat.o(290008);
  }
  
  private static String a(int paramInt, a parama)
  {
    AppMethodBeat.i(289964);
    StringBuilder localStringBuilder = new StringBuilder();
    String str;
    long l;
    int i;
    if (parama != null)
    {
      str = parama.Tif + "_" + parama.Tig;
      l = cn.bDu();
      if ((TextUtils.isEmpty(str)) || (parama == null)) {
        break label183;
      }
      if (!parama.Tih) {
        break label178;
      }
      Calendar localCalendar = wm(l);
      if (localCalendar == null) {
        break label178;
      }
      i = localCalendar.get(11);
      if (localCalendar.get(12) + i * 60 >= parama.Tii) {
        break label178;
      }
      i = 1;
      label112:
      if (i == 0) {
        break label183;
      }
      Log.d("MicroMsg.TextStatus.TextStatusSwitch", "getFriendsStatusBtnTag isHitLastDay");
    }
    label178:
    label183:
    for (parama = wl(l - 86400000L);; parama = wl(l))
    {
      localStringBuilder.append(paramInt).append("_").append(str).append("_").append(parama);
      parama = localStringBuilder.toString();
      AppMethodBeat.o(289964);
      return parama;
      str = "";
      break;
      i = 0;
      break label112;
    }
  }
  
  public static void a(ac.b paramb)
  {
    AppMethodBeat.i(289969);
    if ((paramb == null) || (paramb.style == 0))
    {
      AppMethodBeat.o(289969);
      return;
    }
    paramb = a(paramb.style, paramb.Tij);
    Log.d("MicroMsg.TextStatus.TextStatusSwitch", "setFriendsStatusBtnClick:%s", new Object[] { paramb });
    h.baE().ban().set(at.a.adhb, paramb);
    AppMethodBeat.o(289969);
  }
  
  private static ac.b bdB(String paramString)
  {
    AppMethodBeat.i(289986);
    ac.b localb = new ac.b();
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        k = paramString.optInt("style", 0);
        if ((k > 0) && (k <= 2))
        {
          paramString = a.O(paramString.optJSONArray("durations"));
          if ((paramString == null) || (paramString.size() <= 0)) {
            continue;
          }
          localObject = wm(cn.bDw());
          if (localObject != null)
          {
            i = ((Calendar)localObject).get(11);
            j = ((Calendar)localObject).get(12);
            int m = i * 60 + j;
            Log.d("MicroMsg.TextStatus.TextStatusSwitch", "btnStyle convert cur h:%s, m:%s, tm:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m) });
            paramString = paramString.iterator();
            if (paramString.hasNext())
            {
              localObject = (a)paramString.next();
              Log.d("MicroMsg.TextStatus.TextStatusSwitch", "btnStyle convert DurationData:%s", new Object[] { localObject });
              if ((m < ((a)localObject).Tif) || (m > ((a)localObject).Tig)) {
                continue;
              }
              i = 1;
              j = i;
              if (((a)localObject).Tih)
              {
                j = i;
                if (i == 0)
                {
                  i = m + 1440;
                  if ((i < ((a)localObject).Tif) || (i > ((a)localObject).Tig)) {
                    continue;
                  }
                  j = 1;
                }
              }
              if (j == 0) {
                continue;
              }
              String str1 = hGs();
              String str2 = a(k, (a)localObject);
              Log.d("MicroMsg.TextStatus.TextStatusSwitch", "btnStyle convert curtag:%s, targetTag:%s", new Object[] { str1, str2 });
              if (TextUtils.equals(str1, str2)) {
                continue;
              }
              localb.style = k;
              localb.Tij = ((a)localObject);
            }
          }
        }
      }
      finally
      {
        int k;
        Object localObject;
        int i;
        int j;
        Log.printErrStackTrace("MicroMsg.TextStatus.TextStatusSwitch", paramString, "convertBtnStyle", new Object[0]);
        continue;
      }
      AppMethodBeat.o(289986);
      return localb;
      i = 0;
      continue;
      j = 0;
      continue;
      paramString = hGs();
      localObject = a(k, null);
      Log.d("MicroMsg.TextStatus.TextStatusSwitch", "btnStyle convert curtag:%s, targetTag:%s", new Object[] { paramString, localObject });
      if (!TextUtils.equals(paramString, (CharSequence)localObject)) {
        localb.style = k;
      }
    }
  }
  
  private static Calendar bdC(String paramString)
  {
    AppMethodBeat.i(289996);
    try
    {
      paramString = Tid.parse(paramString);
      Calendar localCalendar = Calendar.getInstance();
      if (paramString == null) {
        return null;
      }
      localCalendar.setTime(paramString);
      return localCalendar;
    }
    finally
    {
      AppMethodBeat.o(289996);
    }
    return null;
  }
  
  public static boolean hFS()
  {
    AppMethodBeat.i(289809);
    if (((c)h.ax(c.class)).a(c.a.zuo, b.a.agrk, 1) == 1)
    {
      AppMethodBeat.o(289809);
      return true;
    }
    AppMethodBeat.o(289809);
    return false;
  }
  
  public static boolean hFT()
  {
    AppMethodBeat.i(289812);
    if (((c)h.ax(c.class)).a(c.a.zuA, 1) == 1)
    {
      AppMethodBeat.o(289812);
      return true;
    }
    AppMethodBeat.o(289812);
    return false;
  }
  
  public static boolean hFU()
  {
    return false;
  }
  
  public static boolean hFV()
  {
    AppMethodBeat.i(289826);
    if (h.baE().ban().getBoolean(at.a.adgY, false))
    {
      AppMethodBeat.o(289826);
      return false;
    }
    AppMethodBeat.o(289826);
    return false;
  }
  
  public static void hFW()
  {
    AppMethodBeat.i(289828);
    h.baE().ban().set(at.a.adgY, Boolean.TRUE);
    AppMethodBeat.o(289828);
  }
  
  public static void hFX()
  {
    AppMethodBeat.i(289834);
    h.baE().ban().set(at.a.adgX, Boolean.TRUE);
    AppMethodBeat.o(289834);
  }
  
  public static boolean hFY()
  {
    AppMethodBeat.i(289843);
    if (!hFS())
    {
      AppMethodBeat.o(289843);
      return false;
    }
    if (h.baE().ban().getBoolean(at.a.adgX, false))
    {
      AppMethodBeat.o(289843);
      return false;
    }
    AppMethodBeat.o(289843);
    return false;
  }
  
  public static int hFZ()
  {
    return 0;
  }
  
  public static String hGa()
  {
    AppMethodBeat.i(289856);
    if (!hFS())
    {
      str = ThZ;
      AppMethodBeat.o(289856);
      return str;
    }
    String str = ((c)h.ax(c.class)).a(c.a.zup, ThZ);
    AppMethodBeat.o(289856);
    return str;
  }
  
  public static boolean hGb()
  {
    AppMethodBeat.i(289861);
    if (!hFS())
    {
      AppMethodBeat.o(289861);
      return false;
    }
    AppMethodBeat.o(289861);
    return true;
  }
  
  public static boolean hGc()
  {
    AppMethodBeat.i(289868);
    if (!hFS())
    {
      AppMethodBeat.o(289868);
      return false;
    }
    AppMethodBeat.o(289868);
    return true;
  }
  
  public static boolean hGd()
  {
    AppMethodBeat.i(289874);
    if (!hFS())
    {
      AppMethodBeat.o(289874);
      return false;
    }
    AppMethodBeat.o(289874);
    return true;
  }
  
  public static boolean hGe()
  {
    AppMethodBeat.i(289881);
    if (!hFS())
    {
      AppMethodBeat.o(289881);
      return false;
    }
    if (((c)h.ax(c.class)).a(c.a.zur, b.a.agrg, 0) == 1)
    {
      AppMethodBeat.o(289881);
      return true;
    }
    AppMethodBeat.o(289881);
    return false;
  }
  
  public static boolean hGf()
  {
    AppMethodBeat.i(289887);
    if (!hFS())
    {
      AppMethodBeat.o(289887);
      return false;
    }
    if (((c)h.ax(c.class)).a(c.a.zus, b.a.agrh, 0) == 1)
    {
      AppMethodBeat.o(289887);
      return true;
    }
    AppMethodBeat.o(289887);
    return false;
  }
  
  public static boolean hGg()
  {
    AppMethodBeat.i(289894);
    if (!hFS())
    {
      AppMethodBeat.o(289894);
      return false;
    }
    AppMethodBeat.o(289894);
    return true;
  }
  
  public static int hGh()
  {
    AppMethodBeat.i(289899);
    int i = ((c)h.ax(c.class)).a(c.a.zut, 1);
    AppMethodBeat.o(289899);
    return i;
  }
  
  public static int hGi()
  {
    AppMethodBeat.i(289904);
    int i = ((c)h.ax(c.class)).a(c.a.zuv, 1);
    AppMethodBeat.o(289904);
    return i;
  }
  
  public static boolean hGj()
  {
    return true;
  }
  
  public static int hGk()
  {
    return 3;
  }
  
  public static boolean hGl()
  {
    AppMethodBeat.i(289916);
    if (((c)h.ax(c.class)).a(c.a.zuy, b.a.agrj, 0) == 1)
    {
      AppMethodBeat.o(289916);
      return true;
    }
    AppMethodBeat.o(289916);
    return false;
  }
  
  public static boolean hGm()
  {
    AppMethodBeat.i(289925);
    if (((a)h.ax(a.class)).aRC().getInt("TextStatusShowRedEnvelopeEntry", 1) == 1)
    {
      AppMethodBeat.o(289925);
      return true;
    }
    AppMethodBeat.o(289925);
    return false;
  }
  
  public static boolean hGn()
  {
    return true;
  }
  
  public static boolean hGo()
  {
    AppMethodBeat.i(289935);
    if (((c)h.ax(c.class)).a(c.a.zuz, b.a.agrl, 0) == 1)
    {
      AppMethodBeat.o(289935);
      return true;
    }
    AppMethodBeat.o(289935);
    return false;
  }
  
  public static boolean hGp()
  {
    AppMethodBeat.i(289940);
    if (((c)h.ax(c.class)).a(c.a.zuB, b.a.agrm, 0) == 1)
    {
      AppMethodBeat.o(289940);
      return true;
    }
    AppMethodBeat.o(289940);
    return false;
  }
  
  public static boolean hGq()
  {
    return true;
  }
  
  public static boolean hGr()
  {
    AppMethodBeat.i(289951);
    i locali = i.agtt;
    if (i.a(b.a.agrp, 0) == 1)
    {
      AppMethodBeat.o(289951);
      return true;
    }
    AppMethodBeat.o(289951);
    return false;
  }
  
  private static String hGs()
  {
    AppMethodBeat.i(289956);
    String str = h.baE().ban().b(at.a.adhb, "");
    AppMethodBeat.o(289956);
    return str;
  }
  
  public static ac.b hGt()
  {
    AppMethodBeat.i(289977);
    long l = System.currentTimeMillis();
    String str = ((a)h.ax(a.class)).aRC().getValue("StatusFriendsButtonStyleConfig");
    ac.b localb;
    if (!TextUtils.isEmpty(str))
    {
      localb = bdB(str);
      Log.d("MicroMsg.TextStatus.TextStatusSwitch", "btnStyle convert dConfig src:%s style:%s", new Object[] { str, Integer.valueOf(localb.style) });
    }
    for (;;)
    {
      Log.d("MicroMsg.TextStatus.TextStatusSwitch", "btnStyle final:%s cost:%s", new Object[] { localb, Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(289977);
      return localb;
      localb = bdB("");
      Log.d("MicroMsg.TextStatus.TextStatusSwitch", "btnStyle convert xConfig src:%s style:%s", new Object[] { "", Integer.valueOf(localb.style) });
    }
  }
  
  private static String wl(long paramLong)
  {
    AppMethodBeat.i(289988);
    try
    {
      String str = Tie.format(Long.valueOf(paramLong));
      return str;
    }
    finally
    {
      AppMethodBeat.o(289988);
    }
    return "";
  }
  
  private static Calendar wm(long paramLong)
  {
    AppMethodBeat.i(289991);
    try
    {
      Object localObject1 = Tic.format(Long.valueOf(paramLong));
      localObject1 = Tic.parse((String)localObject1);
      Calendar localCalendar = Calendar.getInstance();
      if (localObject1 == null) {
        return null;
      }
      localCalendar.setTime((Date)localObject1);
      return localCalendar;
    }
    finally
    {
      AppMethodBeat.o(289991);
    }
    return null;
  }
  
  static final class a
  {
    public int Tif;
    public int Tig;
    public boolean Tih = false;
    public int Tii;
    
    public static List<a> O(JSONArray paramJSONArray)
    {
      AppMethodBeat.i(289816);
      LinkedList localLinkedList = new LinkedList();
      if (paramJSONArray != null)
      {
        int i = 0;
        while (i < paramJSONArray.length())
        {
          a locala = bdE(paramJSONArray.optString(i));
          if (locala != null) {
            localLinkedList.add(locala);
          }
          i += 1;
        }
      }
      AppMethodBeat.o(289816);
      return localLinkedList;
    }
    
    private static a bdE(String paramString)
    {
      AppMethodBeat.i(289810);
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
          return null;
        }
        paramString = ac.bdD(localObject[0]);
        if (paramString == null) {
          return null;
        }
        localObject = ac.bdD(localObject[1]);
        if (localObject == null) {
          return null;
        }
        a locala = new a();
        locala.Tif = ac.b(paramString);
        locala.Tig = ac.b((Calendar)localObject);
        if (locala.Tig == 0) {
          locala.Tig = 1440;
        }
        if (locala.Tig < locala.Tif)
        {
          locala.Tih = true;
          locala.Tii = locala.Tig;
          locala.Tig += 1440;
        }
        return locala;
      }
      finally
      {
        AppMethodBeat.o(289810);
      }
      return null;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(289821);
      String str = "DD{bT=" + this.Tif + ", eT=" + this.Tig + ", iC=" + this.Tih + ", oT=" + this.Tii + '}';
      AppMethodBeat.o(289821);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.a.ac
 * JD-Core Version:    0.7.0.1
 */