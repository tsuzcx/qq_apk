package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public class GetEmotionListResponse
  extends bvk
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
    AppMethodBeat.i(62564);
    this.EmotionList = new LinkedList();
    this.NewBannerList = new LinkedList();
    this.CellList = new LinkedList();
    this.BannerSetList = new LinkedList();
    this.CellSetList = new LinkedList();
    AppMethodBeat.o(62564);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62565);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(62565);
        throw paramVarArgs;
      }
      if (this.ReqBuf == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqBuf");
        AppMethodBeat.o(62565);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ReqBuf != null)
      {
        paramVarArgs.iQ(2, this.ReqBuf.computeSize());
        this.ReqBuf.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.EmotionCount);
      paramVarArgs.e(4, 8, this.EmotionList);
      if (this.Banner != null)
      {
        paramVarArgs.iQ(5, this.Banner.computeSize());
        this.Banner.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.NewBannerCount);
      paramVarArgs.e(7, 8, this.NewBannerList);
      paramVarArgs.aO(8, this.CellCount);
      paramVarArgs.e(9, 8, this.CellList);
      paramVarArgs.aO(10, this.BannerSetCount);
      paramVarArgs.e(11, 8, this.BannerSetList);
      paramVarArgs.aO(12, this.TopHotNum);
      paramVarArgs.aO(13, this.RecentHotNum);
      paramVarArgs.aO(14, this.CellSetCount);
      paramVarArgs.e(15, 8, this.CellSetList);
      if (this.EmotionExptConfig != null) {
        paramVarArgs.e(16, this.EmotionExptConfig);
      }
      AppMethodBeat.o(62565);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1782;
      }
    }
    label1782:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ReqBuf != null) {
        i = paramInt + e.a.a.a.iP(2, this.ReqBuf.computeSize());
      }
      i = i + e.a.a.b.b.a.bl(3, this.EmotionCount) + e.a.a.a.c(4, 8, this.EmotionList);
      paramInt = i;
      if (this.Banner != null) {
        paramInt = i + e.a.a.a.iP(5, this.Banner.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.NewBannerCount) + e.a.a.a.c(7, 8, this.NewBannerList) + e.a.a.b.b.a.bl(8, this.CellCount) + e.a.a.a.c(9, 8, this.CellList) + e.a.a.b.b.a.bl(10, this.BannerSetCount) + e.a.a.a.c(11, 8, this.BannerSetList) + e.a.a.b.b.a.bl(12, this.TopHotNum) + e.a.a.b.b.a.bl(13, this.RecentHotNum) + e.a.a.b.b.a.bl(14, this.CellSetCount) + e.a.a.a.c(15, 8, this.CellSetList);
      paramInt = i;
      if (this.EmotionExptConfig != null) {
        paramInt = i + e.a.a.b.b.a.f(16, this.EmotionExptConfig);
      }
      AppMethodBeat.o(62565);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EmotionList.clear();
        this.NewBannerList.clear();
        this.CellList.clear();
        this.BannerSetList.clear();
        this.CellSetList.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(62565);
          throw paramVarArgs;
        }
        if (this.ReqBuf == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReqBuf");
          AppMethodBeat.o(62565);
          throw paramVarArgs;
        }
        AppMethodBeat.o(62565);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        GetEmotionListResponse localGetEmotionListResponse = (GetEmotionListResponse)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(62565);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localGetEmotionListResponse.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(62565);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localGetEmotionListResponse.ReqBuf = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(62565);
          return 0;
        case 3: 
          localGetEmotionListResponse.EmotionCount = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(62565);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionSummary();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((EmotionSummary)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localGetEmotionListResponse.EmotionList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(62565);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionBanner();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((EmotionBanner)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localGetEmotionListResponse.Banner = ((EmotionBanner)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(62565);
          return 0;
        case 6: 
          localGetEmotionListResponse.NewBannerCount = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(62565);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionBanner();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((EmotionBanner)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localGetEmotionListResponse.NewBannerList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(62565);
          return 0;
        case 8: 
          localGetEmotionListResponse.CellCount = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(62565);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionCell();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((EmotionCell)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localGetEmotionListResponse.CellList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(62565);
          return 0;
        case 10: 
          localGetEmotionListResponse.BannerSetCount = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(62565);
          return 0;
        case 11: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionBannerSet();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((EmotionBannerSet)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localGetEmotionListResponse.BannerSetList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(62565);
          return 0;
        case 12: 
          localGetEmotionListResponse.TopHotNum = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(62565);
          return 0;
        case 13: 
          localGetEmotionListResponse.RecentHotNum = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(62565);
          return 0;
        case 14: 
          localGetEmotionListResponse.CellSetCount = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(62565);
          return 0;
        case 15: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionBannerSet();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((EmotionBannerSet)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localGetEmotionListResponse.CellSetList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(62565);
          return 0;
        }
        localGetEmotionListResponse.EmotionExptConfig = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(62565);
        return 0;
      }
      AppMethodBeat.o(62565);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.GetEmotionListResponse
 * JD-Core Version:    0.7.0.1
 */