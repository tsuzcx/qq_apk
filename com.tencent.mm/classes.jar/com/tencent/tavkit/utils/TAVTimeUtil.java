package com.tencent.tavkit.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TAVTimeUtil
{
  public static float factorForTime(CMTime paramCMTime, CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(213228);
    if (paramCMTimeRange == null)
    {
      AppMethodBeat.o(213228);
      return 0.0F;
    }
    float f = paramCMTime.sub(paramCMTimeRange.getStart()).getTimeSeconds() / paramCMTimeRange.getDuration().getTimeSeconds();
    AppMethodBeat.o(213228);
    return f;
  }
  
  public static CMTimeRange getIntersection(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    AppMethodBeat.i(213231);
    if ((paramCMTimeRange1 == null) || (paramCMTimeRange2 == null))
    {
      AppMethodBeat.o(213231);
      return null;
    }
    if (paramCMTimeRange1.getStart().bigThan(paramCMTimeRange2.getStart())) {}
    for (;;)
    {
      if (paramCMTimeRange2.getEnd().smallThan(paramCMTimeRange1.getStart()))
      {
        AppMethodBeat.o(213231);
        return null;
      }
      if (paramCMTimeRange2.getStart().bigThan(paramCMTimeRange1.getStart()))
      {
        localObject = paramCMTimeRange2.getStart();
        if (!paramCMTimeRange2.getEnd().smallThan(paramCMTimeRange1.getEnd())) {
          break label122;
        }
      }
      label122:
      for (paramCMTimeRange1 = paramCMTimeRange2.getEnd();; paramCMTimeRange1 = paramCMTimeRange1.getEnd())
      {
        paramCMTimeRange1 = new CMTimeRange((CMTime)localObject, paramCMTimeRange1.sub((CMTime)localObject));
        AppMethodBeat.o(213231);
        return paramCMTimeRange1;
        localObject = paramCMTimeRange1.getStart();
        break;
      }
      Object localObject = paramCMTimeRange1;
      paramCMTimeRange1 = paramCMTimeRange2;
      paramCMTimeRange2 = (CMTimeRange)localObject;
    }
  }
  
  public static List<CMTimeRange> mixTimeRangesWithMinTimeRange(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2, CMTimeRange paramCMTimeRange3)
  {
    AppMethodBeat.i(213240);
    if (paramCMTimeRange3.containsTimeRange(paramCMTimeRange1))
    {
      paramCMTimeRange1 = new ArrayList();
      localObject = paramCMTimeRange2.getStart().sub(paramCMTimeRange3.getStart());
      if (((CMTime)localObject).getTimeSeconds() > 0.0F) {
        paramCMTimeRange1.add(new CMTimeRange(paramCMTimeRange3.getStart(), (CMTime)localObject));
      }
      paramCMTimeRange1.add(paramCMTimeRange2);
      paramCMTimeRange3 = paramCMTimeRange3.getEnd().sub(paramCMTimeRange2.getEnd());
      if (paramCMTimeRange3.getTimeSeconds() > 0.0F) {
        paramCMTimeRange1.add(new CMTimeRange(paramCMTimeRange2.getEnd(), paramCMTimeRange3));
      }
      AppMethodBeat.o(213240);
      return paramCMTimeRange1;
    }
    if (paramCMTimeRange1.equals(paramCMTimeRange3))
    {
      paramCMTimeRange1 = new ArrayList();
      paramCMTimeRange1.add(paramCMTimeRange2);
      AppMethodBeat.o(213240);
      return paramCMTimeRange1;
    }
    Object localObject = new ArrayList();
    CMTime localCMTime = paramCMTimeRange1.getDuration().sub(paramCMTimeRange2.getDuration());
    paramCMTimeRange1 = new CMTimeRange(paramCMTimeRange1.getStart(), localCMTime);
    if (paramCMTimeRange1.getDuration().getTimeSeconds() > 0.0F) {
      ((List)localObject).add(paramCMTimeRange1);
    }
    ((List)localObject).add(paramCMTimeRange2);
    paramCMTimeRange1 = paramCMTimeRange3.getEnd().sub(paramCMTimeRange2.getEnd());
    paramCMTimeRange1 = new CMTimeRange(paramCMTimeRange2.getEnd(), paramCMTimeRange1);
    if (paramCMTimeRange1.getDuration().getTimeSeconds() > 0.0F) {
      ((List)localObject).add(paramCMTimeRange1);
    }
    AppMethodBeat.o(213240);
    return localObject;
  }
  
  public static List<CMTimeRange> sliceTimeRangesForTimeRange1(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    AppMethodBeat.i(213235);
    Object localObject = getIntersection(paramCMTimeRange1, paramCMTimeRange2);
    if (((CMTimeRange)localObject).getDuration().getTimeSeconds() > 0.0F) {
      if ((paramCMTimeRange2.containsTimeRange(paramCMTimeRange1)) || ((paramCMTimeRange1.getStart().getTimeSeconds() < paramCMTimeRange2.getStart().getTimeSeconds()) && (paramCMTimeRange1.getEnd().getTimeSeconds() < paramCMTimeRange2.getEnd().getTimeSeconds()))) {
        paramCMTimeRange1 = mixTimeRangesWithMinTimeRange(paramCMTimeRange1, (CMTimeRange)localObject, paramCMTimeRange2);
      }
    }
    for (;;)
    {
      Collections.sort(paramCMTimeRange1, new Comparator()
      {
        public final int compare(CMTimeRange paramAnonymousCMTimeRange1, CMTimeRange paramAnonymousCMTimeRange2)
        {
          AppMethodBeat.i(213219);
          paramAnonymousCMTimeRange1 = paramAnonymousCMTimeRange1.getStart();
          paramAnonymousCMTimeRange2 = paramAnonymousCMTimeRange2.getStart();
          if (paramAnonymousCMTimeRange1.equalsTo(paramAnonymousCMTimeRange2))
          {
            AppMethodBeat.o(213219);
            return 0;
          }
          if (paramAnonymousCMTimeRange1.smallThan(paramAnonymousCMTimeRange2))
          {
            AppMethodBeat.o(213219);
            return -1;
          }
          AppMethodBeat.o(213219);
          return 1;
        }
      });
      AppMethodBeat.o(213235);
      return paramCMTimeRange1;
      paramCMTimeRange1 = mixTimeRangesWithMinTimeRange(paramCMTimeRange2, (CMTimeRange)localObject, paramCMTimeRange1);
      continue;
      localObject = new ArrayList();
      ((List)localObject).add(paramCMTimeRange1);
      ((List)localObject).add(paramCMTimeRange2);
      paramCMTimeRange1 = (CMTimeRange)localObject;
    }
  }
  
  public static List<CMTimeRange> timeRange(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    AppMethodBeat.i(213243);
    CMTimeRange localCMTimeRange1 = getIntersection(paramCMTimeRange1, paramCMTimeRange2);
    if ((localCMTimeRange1 == null) || (localCMTimeRange1.getDuration().getTimeSeconds() <= 0.0F))
    {
      paramCMTimeRange2 = new ArrayList();
      paramCMTimeRange2.add(paramCMTimeRange1);
      AppMethodBeat.o(213243);
      return paramCMTimeRange2;
    }
    paramCMTimeRange2 = new ArrayList();
    CMTimeRange localCMTimeRange2 = new CMTimeRange(paramCMTimeRange1.getStart(), localCMTimeRange1.getStart().sub(paramCMTimeRange1.getStart()));
    if (localCMTimeRange2.getDuration().getTimeSeconds() > 0.0F) {
      paramCMTimeRange2.add(localCMTimeRange2);
    }
    paramCMTimeRange1 = new CMTimeRange(localCMTimeRange1.getEnd(), paramCMTimeRange1.getEnd().sub(localCMTimeRange1.getEnd()));
    if (paramCMTimeRange1.getDuration().getTimeSeconds() > 0.0F) {
      paramCMTimeRange2.add(paramCMTimeRange1);
    }
    AppMethodBeat.o(213243);
    return paramCMTimeRange2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tavkit.utils.TAVTimeUtil
 * JD-Core Version:    0.7.0.1
 */