package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public class EmotionBanner
  extends com.tencent.mm.bw.a
{
  public EmotionBannerImg BannerImg;
  public EmotionSummary BannerSummary;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104768);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BannerSummary == null)
      {
        paramVarArgs = new b("Not all required fields were included: BannerSummary");
        AppMethodBeat.o(104768);
        throw paramVarArgs;
      }
      if (this.BannerImg == null)
      {
        paramVarArgs = new b("Not all required fields were included: BannerImg");
        AppMethodBeat.o(104768);
        throw paramVarArgs;
      }
      if (this.BannerSummary != null)
      {
        paramVarArgs.ni(1, this.BannerSummary.computeSize());
        this.BannerSummary.writeFields(paramVarArgs);
      }
      if (this.BannerImg != null)
      {
        paramVarArgs.ni(2, this.BannerImg.computeSize());
        this.BannerImg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104768);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BannerSummary == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = g.a.a.a.nh(1, this.BannerSummary.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.BannerImg != null) {
        i = paramInt + g.a.a.a.nh(2, this.BannerImg.computeSize());
      }
      AppMethodBeat.o(104768);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BannerSummary == null)
        {
          paramVarArgs = new b("Not all required fields were included: BannerSummary");
          AppMethodBeat.o(104768);
          throw paramVarArgs;
        }
        if (this.BannerImg == null)
        {
          paramVarArgs = new b("Not all required fields were included: BannerImg");
          AppMethodBeat.o(104768);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104768);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        EmotionBanner localEmotionBanner = (EmotionBanner)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104768);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionSummary();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((EmotionSummary)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localEmotionBanner.BannerSummary = ((EmotionSummary)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104768);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new EmotionBannerImg();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((EmotionBannerImg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localEmotionBanner.BannerImg = ((EmotionBannerImg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104768);
        return 0;
      }
      AppMethodBeat.o(104768);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.EmotionBanner
 * JD-Core Version:    0.7.0.1
 */