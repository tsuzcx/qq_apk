package com.tencent.mm.plugin.sns.ad.landingpage.helper;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCodecList;
import android.util.Range;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.l;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ad/landingpage/helper/VideoCapabilityReport;", "", "()V", "whPairs", "", "Lkotlin/Pair;", "", "decoderCodecInfo", "Landroid/media/MediaCodecInfo;", "mime", "", "filterSoft", "", "report", "", "reportVideoCap", "getSupportedFrameRatesForNoError", "Landroid/media/MediaCodecInfo$VideoCapabilities;", "width", "", "height", "isSoftwareDecoder", "reportOnePair", "reportPairs", "toReportString", "Landroid/util/Range;", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c PTy;
  private static final List<r<Double, Double>> PTz;
  
  static
  {
    AppMethodBeat.i(310938);
    PTy = new c();
    PTz = p.listOf(new r[] { v.Y(Double.valueOf(2880.0D), Double.valueOf(1080.0D)), v.Y(Double.valueOf(2160.0D), Double.valueOf(1080.0D)), v.Y(Double.valueOf(1920.0D), Double.valueOf(1080.0D)), v.Y(Double.valueOf(1920.0D), Double.valueOf(720.0D)), v.Y(Double.valueOf(1440.0D), Double.valueOf(720.0D)), v.Y(Double.valueOf(1280.0D), Double.valueOf(720.0D)), v.Y(Double.valueOf(1440.0D), Double.valueOf(2160.0D)), v.Y(Double.valueOf(1440.0D), Double.valueOf(1620.0D)), v.Y(Double.valueOf(1440.0D), Double.valueOf(1440.0D)), v.Y(Double.valueOf(960.0D), Double.valueOf(1440.0D)), v.Y(Double.valueOf(960.0D), Double.valueOf(1080.0D)), v.Y(Double.valueOf(960.0D), Double.valueOf(960.0D)) });
    AppMethodBeat.o(310938);
  }
  
  private static String a(MediaCodecInfo.VideoCapabilities paramVideoCapabilities)
  {
    AppMethodBeat.i(310893);
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = ((Iterable)PTz).iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (r)localIterator.next();
      double d1 = ((Number)((r)localObject).bsC).doubleValue();
      double d2 = ((Number)((r)localObject).bsD).doubleValue();
      int j = (int)d1;
      int k = (int)d2;
      int i;
      if (paramVideoCapabilities.isSizeSupported(j, k))
      {
        i = 1;
        label95:
        if (i != 0) {
          break label188;
        }
      }
      label188:
      for (localObject = "0";; localObject = s.X("", a(paramVideoCapabilities, j, k)))
      {
        localObject = new r(Integer.valueOf(i), localObject);
        i = ((Number)((r)localObject).bsC).intValue();
        localObject = (String)((r)localObject).bsD;
        localStringBuilder.append(i + '|' + (String)localObject + '|');
        break;
        i = 0;
        break label95;
      }
    }
    paramVideoCapabilities = localStringBuilder.toString();
    s.s(paramVideoCapabilities, "result.toString()");
    AppMethodBeat.o(310893);
    return paramVideoCapabilities;
  }
  
  private static String a(MediaCodecInfo.VideoCapabilities paramVideoCapabilities, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(310901);
    try
    {
      paramInt1 = (int)((Number)paramVideoCapabilities.getSupportedFrameRatesFor(paramInt1, paramInt2).getUpper()).doubleValue();
      return String.valueOf(paramInt1);
    }
    finally
    {
      AppMethodBeat.o(310901);
    }
    return "0";
  }
  
  private static String a(Range<Integer> paramRange)
  {
    AppMethodBeat.i(310907);
    paramRange = paramRange.getLower() + '_' + paramRange.getUpper();
    AppMethodBeat.o(310907);
    return paramRange;
  }
  
  private static void aWB(String paramString)
  {
    AppMethodBeat.i(310884);
    Object localObject1 = cQ(paramString, true);
    int i;
    label29:
    Object localObject2;
    if (!((Collection)localObject1).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label111;
      }
      if (localObject1 != null) {
        break label116;
      }
      localObject2 = null;
      label35:
      if (localObject2 != null) {
        break label130;
      }
      localObject1 = null;
      label41:
      if (localObject1 != null) {
        break label407;
      }
      localObject1 = cQ(paramString, false);
      if (((Collection)localObject1).isEmpty()) {
        break label153;
      }
      i = 1;
      label65:
      if (i == 0) {
        break label158;
      }
      label69:
      if (localObject1 != null) {
        break label163;
      }
      localObject2 = null;
      label75:
      if (localObject2 != null) {
        break label177;
      }
      localObject1 = null;
    }
    label81:
    for (Object localObject3 = localObject1;; localObject3 = localObject1)
    {
      if (localObject3 == null)
      {
        l.a(l.QnI, paramString, 3, 0, "error in get codec!");
        AppMethodBeat.o(310884);
        return;
        i = 0;
        break;
        label111:
        localObject1 = null;
        break label29;
        label116:
        localObject2 = (MediaCodecInfo)((List)localObject1).get(0);
        break label35;
        localObject1 = ((MediaCodecInfo)localObject2).getCapabilitiesForType(paramString);
        if (localObject1 == null)
        {
          localObject1 = null;
          break label41;
        }
        localObject1 = ((MediaCodecInfo.CodecCapabilities)localObject1).getVideoCapabilities();
        break label41;
        i = 0;
        break label65;
        localObject1 = null;
        break label69;
        localObject2 = (MediaCodecInfo)((List)localObject1).get(0);
        break label75;
        localObject1 = ((MediaCodecInfo)localObject2).getCapabilitiesForType(paramString);
        if (localObject1 == null)
        {
          localObject1 = null;
          break label81;
        }
        localObject1 = ((MediaCodecInfo.CodecCapabilities)localObject1).getVideoCapabilities();
        break label81;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      if (localObject2 == null) {
        localObject1 = "null";
      }
      for (;;)
      {
        localStringBuilder.append(s.X((String)localObject1, "|"));
        localObject1 = localObject3.getSupportedWidths();
        s.s(localObject1, "videoCapabilities.supportedWidths");
        localStringBuilder.append(s.X(a((Range)localObject1), "|"));
        localObject1 = localObject3.getSupportedHeights();
        s.s(localObject1, "videoCapabilities.supportedHeights");
        localStringBuilder.append(s.X(a((Range)localObject1), "|"));
        localObject1 = localObject3.getSupportedFrameRates();
        s.s(localObject1, "videoCapabilities.supportedFrameRates");
        localStringBuilder.append(s.X(a((Range)localObject1), "|"));
        localObject1 = localObject3.getBitrateRange();
        s.s(localObject1, "videoCapabilities.bitrateRange");
        localStringBuilder.append(s.X(a((Range)localObject1), "|"));
        l.a(l.QnI, paramString, 2, 0, s.X("", localStringBuilder));
        localObject1 = a(localObject3);
        l.a(l.QnI, paramString, 1, 0, s.X("", localObject1));
        AppMethodBeat.o(310884);
        return;
        localObject2 = ((MediaCodecInfo)localObject2).getName();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "null";
        }
      }
    }
  }
  
  private static boolean c(MediaCodecInfo paramMediaCodecInfo)
  {
    AppMethodBeat.i(310913);
    String str = paramMediaCodecInfo.getName();
    paramMediaCodecInfo = str;
    if (str == null) {
      paramMediaCodecInfo = "";
    }
    if ((n.U(paramMediaCodecInfo, "OMX.google.", false)) || (n.U(paramMediaCodecInfo, "c2.android.", false)))
    {
      AppMethodBeat.o(310913);
      return true;
    }
    AppMethodBeat.o(310913);
    return false;
  }
  
  private static List<MediaCodecInfo> cQ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(310922);
    int k = MediaCodecList.getCodecCount();
    List localList = (List)new ArrayList();
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (!localMediaCodecInfo.isEncoder()) {
        if (paramBoolean)
        {
          s.s(localMediaCodecInfo, "info");
          if (c(localMediaCodecInfo)) {}
        }
        else
        {
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          s.s(arrayOfString, "types");
          int m = arrayOfString.length;
          i = 0;
          while (i < m)
          {
            String str = arrayOfString[i];
            i += 1;
            if (s.p(str, paramString))
            {
              s.s(localMediaCodecInfo, "info");
              localList.add(localMediaCodecInfo);
            }
          }
        }
      }
      if (j >= k)
      {
        AppMethodBeat.o(310922);
        return localList;
      }
    }
  }
  
  private static final void haL()
  {
    AppMethodBeat.i(310928);
    try
    {
      aWB("video/avc");
      aWB("video/hevc");
      return;
    }
    finally
    {
      AppMethodBeat.o(310928);
    }
  }
  
  public static final void report()
  {
    AppMethodBeat.i(310869);
    h.ahAA.bm(c..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(310869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.c
 * JD-Core Version:    0.7.0.1
 */