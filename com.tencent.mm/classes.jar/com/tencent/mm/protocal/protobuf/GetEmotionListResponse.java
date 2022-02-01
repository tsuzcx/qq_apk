package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class GetEmotionListResponse
  extends cld
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
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
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
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ReqBuf != null)
      {
        paramVarArgs.kX(2, this.ReqBuf.computeSize());
        this.ReqBuf.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.EmotionCount);
      paramVarArgs.e(4, 8, this.EmotionList);
      if (this.Banner != null)
      {
        paramVarArgs.kX(5, this.Banner.computeSize());
        this.Banner.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.NewBannerCount);
      paramVarArgs.e(7, 8, this.NewBannerList);
      paramVarArgs.aR(8, this.CellCount);
      paramVarArgs.e(9, 8, this.CellList);
      paramVarArgs.aR(10, this.BannerSetCount);
      paramVarArgs.e(11, 8, this.BannerSetList);
      paramVarArgs.aR(12, this.TopHotNum);
      paramVarArgs.aR(13, this.RecentHotNum);
      paramVarArgs.aR(14, this.CellSetCount);
      paramVarArgs.e(15, 8, this.CellSetList);
      if (this.EmotionExptConfig != null) {
        paramVarArgs.d(16, this.EmotionExptConfig);
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
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ReqBuf != null) {
        i = paramInt + f.a.a.a.kW(2, this.ReqBuf.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(3, this.EmotionCount) + f.a.a.a.c(4, 8, this.EmotionList);
      paramInt = i;
      if (this.Banner != null) {
        paramInt = i + f.a.a.a.kW(5, this.Banner.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.NewBannerCount) + f.a.a.a.c(7, 8, this.NewBannerList) + f.a.a.b.b.a.bA(8, this.CellCount) + f.a.a.a.c(9, 8, this.CellList) + f.a.a.b.b.a.bA(10, this.BannerSetCount) + f.a.a.a.c(11, 8, this.BannerSetList) + f.a.a.b.b.a.bA(12, this.TopHotNum) + f.a.a.b.b.a.bA(13, this.RecentHotNum) + f.a.a.b.b.a.bA(14, this.CellSetCount) + f.a.a.a.c(15, 8, this.CellSetList);
      paramInt = i;
      if (this.EmotionExptConfig != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.EmotionExptConfig);
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
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localGetEmotionListResponse.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localGetEmotionListResponse.ReqBuf = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 3: 
          localGetEmotionListResponse.EmotionCount = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(104801);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionSummary();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((EmotionSummary)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localGetEmotionListResponse.EmotionList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionBanner();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((EmotionBanner)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localGetEmotionListResponse.Banner = ((EmotionBanner)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 6: 
          localGetEmotionListResponse.NewBannerCount = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(104801);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionBanner();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((EmotionBanner)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localGetEmotionListResponse.NewBannerList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 8: 
          localGetEmotionListResponse.CellCount = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(104801);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionCell();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((EmotionCell)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localGetEmotionListResponse.CellList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 10: 
          localGetEmotionListResponse.BannerSetCount = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(104801);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionBannerSet();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((EmotionBannerSet)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localGetEmotionListResponse.BannerSetList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        case 12: 
          localGetEmotionListResponse.TopHotNum = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(104801);
          return 0;
        case 13: 
          localGetEmotionListResponse.RecentHotNum = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(104801);
          return 0;
        case 14: 
          localGetEmotionListResponse.CellSetCount = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(104801);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionBannerSet();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((EmotionBannerSet)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localGetEmotionListResponse.CellSetList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104801);
          return 0;
        }
        localGetEmotionListResponse.EmotionExptConfig = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(104801);
        return 0;
      }
      AppMethodBeat.o(104801);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.GetEmotionListResponse
 * JD-Core Version:    0.7.0.1
 */