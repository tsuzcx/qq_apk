package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class GetEmotionRewardResponse
  extends cwj
{
  public int DonorNum;
  public LinkedList<EmotionDonor> Donors;
  public LinkedList<EmotionPrice> Price;
  public agx Reward;
  
  public GetEmotionRewardResponse()
  {
    AppMethodBeat.i(104803);
    this.Price = new LinkedList();
    this.Donors = new LinkedList();
    AppMethodBeat.o(104803);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104804);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104804);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Price);
      paramVarArgs.aS(3, this.DonorNum);
      paramVarArgs.e(4, 8, this.Donors);
      if (this.Reward != null)
      {
        paramVarArgs.lJ(5, this.Reward.computeSize());
        this.Reward.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104804);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label834;
      }
    }
    label834:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.Price) + f.a.a.b.b.a.bz(3, this.DonorNum) + f.a.a.a.c(4, 8, this.Donors);
      paramInt = i;
      if (this.Reward != null) {
        paramInt = i + f.a.a.a.lI(5, this.Reward.computeSize());
      }
      AppMethodBeat.o(104804);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Price.clear();
        this.Donors.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104804);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104804);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        GetEmotionRewardResponse localGetEmotionRewardResponse = (GetEmotionRewardResponse)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104804);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localGetEmotionRewardResponse.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104804);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionPrice();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((EmotionPrice)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localGetEmotionRewardResponse.Price.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104804);
          return 0;
        case 3: 
          localGetEmotionRewardResponse.DonorNum = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(104804);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionDonor();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((EmotionDonor)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localGetEmotionRewardResponse.Donors.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104804);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new agx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((agx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localGetEmotionRewardResponse.Reward = ((agx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104804);
        return 0;
      }
      AppMethodBeat.o(104804);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse
 * JD-Core Version:    0.7.0.1
 */