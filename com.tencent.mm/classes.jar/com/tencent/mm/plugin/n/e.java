package com.tencent.mm.plugin.n;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCodecList;
import android.util.Range;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public final class e
{
  private static long oEy = 0L;
  
  private static String b(MediaCodecInfo paramMediaCodecInfo)
  {
    AppMethodBeat.i(117869);
    paramMediaCodecInfo = paramMediaCodecInfo.getSupportedTypes();
    int i = 0;
    while (i < paramMediaCodecInfo.length)
    {
      String str = paramMediaCodecInfo[i];
      if ((!bo.isNullOrNil(str)) && (str.contains("hevc")))
      {
        AppMethodBeat.o(117869);
        return str;
      }
      i += 1;
    }
    AppMethodBeat.o(117869);
    return "";
  }
  
  @TargetApi(21)
  public static boolean bQq()
  {
    AppMethodBeat.i(117865);
    for (;;)
    {
      int i;
      try
      {
        if (d.fv(21))
        {
          MediaCodecInfo[] arrayOfMediaCodecInfo = new MediaCodecList(1).getCodecInfos();
          int j = arrayOfMediaCodecInfo.length;
          ArrayList localArrayList1 = new ArrayList();
          ArrayList localArrayList2 = new ArrayList();
          i = 0;
          if (i < j)
          {
            String str = b(arrayOfMediaCodecInfo[i]);
            if (!bo.isNullOrNil(str))
            {
              localArrayList1.add(Integer.valueOf(i));
              localArrayList2.add(str);
            }
          }
          else
          {
            boolean bool = localArrayList1.isEmpty();
            if (bool)
            {
              AppMethodBeat.o(117865);
              return false;
            }
            AppMethodBeat.o(117865);
            return true;
          }
        }
        else
        {
          AppMethodBeat.o(117865);
          return false;
        }
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.MediaCodecUtil", localException, "isSupportHevc error", new Object[0]);
        AppMethodBeat.o(117865);
        return false;
      }
      i += 1;
    }
  }
  
  public static boolean bQr()
  {
    AppMethodBeat.i(117866);
    if (bo.hl(oEy) > 86400000L)
    {
      AppMethodBeat.o(117866);
      return true;
    }
    AppMethodBeat.o(117866);
    return false;
  }
  
  public static String bQs()
  {
    AppMethodBeat.i(117867);
    ab.d("MicroMsg.MediaCodecUtil", "check hevc info last rpt time[%d]", new Object[] { Long.valueOf(oEy) });
    for (;;)
    {
      int i;
      int i5;
      try
      {
        oEy = bo.aoy();
        if (!d.fv(21)) {
          continue;
        }
        l = bo.yB();
        localObject1 = new MediaCodecList(1).getCodecInfos();
        j = localObject1.length;
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        i = 0;
        if (i < j)
        {
          localObject2 = b(localObject1[i]);
          if (bo.isNullOrNil((String)localObject2)) {
            break label859;
          }
          localArrayList1.add(Integer.valueOf(i));
          localArrayList2.add(localObject2);
          break label859;
        }
        if (localArrayList1.isEmpty())
        {
          AppMethodBeat.o(117867);
          return "";
        }
        bool = false;
        j = 0;
        i7 = 0;
        i6 = 0;
        k = 0;
        m = 0;
        n = 0;
        i1 = 0;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        i = 0;
        localObject2 = new StringBuilder();
        localStringBuilder = new StringBuilder();
        i5 = 0;
        if (i5 < localArrayList1.size())
        {
          int i8 = ((Integer)localArrayList1.get(i5)).intValue();
          Object localObject3 = (String)localArrayList2.get(i5);
          bool = localObject1[i8].isEncoder();
          if (localObject1[i8].isEncoder()) {
            break label875;
          }
          j = 1;
          localObject3 = localObject1[i8].getCapabilitiesForType((String)localObject3);
          if (localObject3 != null)
          {
            i7 = 1;
            localObject3 = ((MediaCodecInfo.CodecCapabilities)localObject3).getVideoCapabilities();
            if (localObject3 == null) {
              break label856;
            }
            k = Math.max(((Integer)((MediaCodecInfo.VideoCapabilities)localObject3).getBitrateRange().getLower()).intValue(), k);
            m = Math.max(((Integer)((MediaCodecInfo.VideoCapabilities)localObject3).getBitrateRange().getUpper()).intValue(), m);
            n = Math.max(((Integer)((MediaCodecInfo.VideoCapabilities)localObject3).getSupportedFrameRates().getLower()).intValue(), n);
            i1 = Math.max(((Integer)((MediaCodecInfo.VideoCapabilities)localObject3).getSupportedFrameRates().getUpper()).intValue(), i1);
            i2 = Math.max(((Integer)((MediaCodecInfo.VideoCapabilities)localObject3).getSupportedWidths().getLower()).intValue(), i2);
            i3 = Math.max(((Integer)((MediaCodecInfo.VideoCapabilities)localObject3).getSupportedWidths().getUpper()).intValue(), i3);
            i4 = Math.max(((Integer)((MediaCodecInfo.VideoCapabilities)localObject3).getSupportedHeights().getLower()).intValue(), i4);
            i = Math.max(((Integer)((MediaCodecInfo.VideoCapabilities)localObject3).getSupportedHeights().getUpper()).intValue(), i);
            ((StringBuilder)localObject2).append(localObject1[i8].getName()).append("|");
            break label866;
          }
          i6 = 1;
          localStringBuilder.append(localObject1[i8].getName()).append("|");
          break label866;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(1).append(",");
        if ((j == 0) || (!bool)) {
          continue;
        }
        ((StringBuilder)localObject1).append(3).append(",");
      }
      catch (Exception localException)
      {
        long l;
        Object localObject1;
        Object localObject2;
        boolean bool;
        int i7;
        int k;
        int m;
        int n;
        int i1;
        int i2;
        int i3;
        int i4;
        StringBuilder localStringBuilder;
        ab.printErrStackTrace("MicroMsg.MediaCodecUtil", localException, "report hevc info error %s", new Object[] { localException.toString() });
        AppMethodBeat.o(117867);
        return "";
        localException.append(1).append(",");
        continue;
      }
      catch (Throwable localThrowable)
      {
        int i6;
        ab.printErrStackTrace("MicroMsg.MediaCodecUtil", localThrowable, "report hevc info error %s", new Object[] { localThrowable.toString() });
        continue;
        if (i6 == 0) {
          continue;
        }
        localThrowable.append(2).append(",");
        continue;
        localThrowable.append(1).append(",");
        continue;
        String str = bQt();
        AppMethodBeat.o(117867);
        return str;
      }
      if ((i7 != 0) && (i6 != 0))
      {
        ((StringBuilder)localObject1).append(3).append(",");
        ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString()).append(",");
        ((StringBuilder)localObject1).append(localStringBuilder.toString()).append(",");
        ((StringBuilder)localObject1).append(k).append(",").append(m).append(",");
        ((StringBuilder)localObject1).append(n).append(",").append(i1).append(",");
        ((StringBuilder)localObject1).append(i2).append(",").append(i3).append(",");
        ((StringBuilder)localObject1).append(i4).append(",").append(i);
        localObject1 = ((StringBuilder)localObject1).toString();
        ab.i("MicroMsg.MediaCodecUtil", "high api 21 cost[%d] hevc info %s", new Object[] { Long.valueOf(bo.av(l)), localObject1 });
        AppMethodBeat.o(117867);
        return localObject1;
        if (bool)
        {
          ((StringBuilder)localObject1).append(2).append(",");
          continue;
        }
      }
      label856:
      continue;
      label859:
      i += 1;
      continue;
      label866:
      i5 += 1;
      continue;
      label875:
      int j = 0;
    }
  }
  
  private static String bQt()
  {
    AppMethodBeat.i(117868);
    long l = bo.yB();
    int j = MediaCodecList.getCodecCount();
    Object localObject1 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      localObject2 = b(MediaCodecList.getCodecInfoAt(i));
      if (!bo.isNullOrNil((String)localObject2))
      {
        ((ArrayList)localObject1).add(Integer.valueOf(i));
        localArrayList.add(localObject2);
      }
      i += 1;
    }
    if (((ArrayList)localObject1).isEmpty())
    {
      AppMethodBeat.o(117868);
      return "";
    }
    boolean bool = false;
    i = 0;
    j = 0;
    int m = 0;
    Object localObject2 = new StringBuilder();
    StringBuilder localStringBuilder = new StringBuilder();
    int k = 0;
    if (k < ((ArrayList)localObject1).size())
    {
      i = ((Integer)((ArrayList)localObject1).get(k)).intValue();
      String str = (String)localArrayList.get(k);
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      bool = localMediaCodecInfo.isEncoder();
      if (!localMediaCodecInfo.isEncoder())
      {
        i = 1;
        label182:
        if (localMediaCodecInfo.getCapabilitiesForType(str) == null) {
          break label222;
        }
        j = 1;
        ((StringBuilder)localObject2).append(localMediaCodecInfo.getName()).append("|");
      }
      for (;;)
      {
        k += 1;
        break;
        i = 0;
        break label182;
        label222:
        m = 1;
        localStringBuilder.append(localMediaCodecInfo.getName()).append("|");
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(1).append(",");
    if ((i != 0) && (bool))
    {
      ((StringBuilder)localObject1).append(3).append(",");
      if ((j == 0) || (m == 0)) {
        break label409;
      }
      ((StringBuilder)localObject1).append(3).append(",");
    }
    for (;;)
    {
      ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString()).append(",");
      ((StringBuilder)localObject1).append(localStringBuilder.toString());
      localObject1 = ((StringBuilder)localObject1).toString();
      ab.i("MicroMsg.MediaCodecUtil", "below api 21 cost[%d] hevc info %s", new Object[] { Long.valueOf(bo.av(l)), localObject1 });
      AppMethodBeat.o(117868);
      return localObject1;
      if (bool)
      {
        ((StringBuilder)localObject1).append(2).append(",");
        break;
      }
      ((StringBuilder)localObject1).append(1).append(",");
      break;
      label409:
      if (m != 0) {
        ((StringBuilder)localObject1).append(2).append(",");
      } else {
        ((StringBuilder)localObject1).append(1).append(",");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.n.e
 * JD-Core Version:    0.7.0.1
 */