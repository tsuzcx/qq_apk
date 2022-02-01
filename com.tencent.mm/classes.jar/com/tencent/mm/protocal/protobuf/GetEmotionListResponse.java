package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public class GetEmotionListResponse
  extends dpc
{
  public EmotionBanner Banner;
  public int BannerSetCount;
  public LinkedList<EmotionBannerSet> BannerSetList;
  public int CellCount;
  public LinkedList<EmotionCell> CellList;
  public int CellSetCount;
  public LinkedList<EmotionBannerSet> CellSetList;
  public int EmotionCount;
  public String EmotionExptConfig;
  public LinkedList<EmotionSummary> EmotionList;
  public int NewBannerCount;
  public LinkedList<EmotionBanner> NewBannerList;
  public int RecentHotNum;
  public SKBuiltinBuffer_t ReqBuf;
  public int TopHotNum;
  
  public GetEmotionListResponse()
  {
    AppMethodBeat.i(104800);
    this.EmotionList = new LinkedList();
    this.NewBannerList = new LinkedList();
    this.CellList = new LinkedList();
    this.BannerSetList = new LinkedList();
    this.CellSetList = new LinkedList();
    AppMethodBeat.o(104800);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104801);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104801);
        throw paramVarArgs;
      }
      if (this.ReqBuf == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqBuf");
        AppMethodBeat.o(104801);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ReqBuf != null)
      {
        paramVarArgs.ni(2, this.ReqBuf.computeSize());
        this.ReqBuf.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.EmotionCount);
      paramVarArgs.e(4, 8, this.EmotionList);
      if (this.Banner != null)
      {
        paramVarArgs.ni(5, this.Banner.computeSize());
        this.Banner.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.NewBannerCount);
      paramVarArgs.e(7, 8, this.NewBannerList);
      paramVarArgs.aM(8, this.CellCount);
      paramVarArgs.e(9, 8, this.CellList);
      paramVarArgs.aM(10, this.BannerSetCount);
      paramVarArgs.e(11, 8, this.BannerSetList);
      paramVarArgs.aM(12, this.TopHotNum);
      paramVarArgs.aM(13, this.RecentHotNum);
      paramVarArgs.aM(14, this.CellSetCount);
      paramVarArgs.e(15, 8, this.CellSetList);
      if (this.EmotionExptConfig != null) {
        paramVarArgs.e(16, this.EmotionExptConfig);
      }
      AppMethodBeat.o(104801);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1782;
      }
    }
    label1782:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ReqBuf != null) {
        i = paramInt + g.a.a.a.nh(2, this.ReqBuf.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(3, this.EmotionCount) + g.a.a.a.c(4, 8, this.EmotionList);
      paramInt = i;
      if (this.Banner != null) {
        paramInt = i + g.a.a.a.nh(5, this.Banner.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.NewBannerCount) + g.a.a.a.c(7, 8, this.NewBannerList) + g.a.a.b.b.a.bu(8, this.CellCount) + g.a.a.a.c(9, 8, this.CellList) + g.a.a.b.b.a.bu(10, this.BannerSetCount) + g.a.a.a.c(11, 8, this.BannerSetList) + g.a.a.b.b.a.bu(12, this.TopHotNum) + g.a.a.b.b.a.bu(13, this.RecentHotNum) + g.a.a.b.b.a.bu(14, this.CellSetCount) + g.a.a.a.c(15, 8, this.CellSetList);
      paramInt = i;
      if (this.EmotionExptConfig != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.EmotionExptConfig);
      }
      AppMethodBeat.o(104801);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EmotionList.clear();
        this.NewBannerList.clear();
        this.CellList.clear();
        this.BannerSetList.clear();
        this.CellSetList.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104801);
          throw paramVarArgs;
        }
        if (this.ReqBuf == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReqBuf");
          AppMethodBeat.o(104801);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104801);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        GetEmotionListResponse localGetEmotionListResponse = (GetEmotionListResponse)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104801);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localGetEmotionListResponse.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localGetEmotionListResponse.ReqBuf = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 3: 
          localGetEmotionListResponse.EmotionCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(104801);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionSummary();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((EmotionSummary)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localGetEmotionListResponse.EmotionList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionBanner();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((EmotionBanner)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localGetEmotionListResponse.Banner = ((EmotionBanner)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 6: 
          localGetEmotionListResponse.NewBannerCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(104801);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionBanner();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((EmotionBanner)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localGetEmotionListResponse.NewBannerList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 8: 
          localGetEmotionListResponse.CellCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(104801);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionCell();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((EmotionCell)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localGetEmotionListResponse.CellList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 10: 
          localGetEmotionListResponse.BannerSetCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(104801);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionBannerSet();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((EmotionBannerSet)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localGetEmotionListResponse.BannerSetList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 12: 
          localGetEmotionListResponse.TopHotNum = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(104801);
          return 0;
        case 13: 
          localGetEmotionListResponse.RecentHotNum = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(104801);
          return 0;
        case 14: 
          localGetEmotionListResponse.CellSetCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(104801);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionBannerSet();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((EmotionBannerSet)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localGetEmotionListResponse.CellSetList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        }
        localGetEmotionListResponse.EmotionExptConfig = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(104801);
        return 0;
      }
      AppMethodBeat.o(104801);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.GetEmotionListResponse
 * JD-Core Version:    0.7.0.1
 */