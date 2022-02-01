package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class atv
  extends dpc
{
  public bds LEG;
  public int LEH;
  public dcz LEI;
  public bdr bgmInfo;
  public int continueFlag;
  public com.tencent.mm.bw.b lastBuffer;
  public LinkedList<FinderObject> object;
  public baw preloadInfo;
  public dmk tTT;
  public long tTn;
  
  public atv()
  {
    AppMethodBeat.i(168991);
    this.object = new LinkedList();
    AppMethodBeat.o(168991);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168992);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(168992);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      paramVarArgs.aM(4, this.continueFlag);
      paramVarArgs.bb(5, this.tTn);
      if (this.LEG != null)
      {
        paramVarArgs.ni(6, this.LEG.computeSize());
        this.LEG.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(7, this.LEH);
      if (this.tTT != null)
      {
        paramVarArgs.ni(8, this.tTT.computeSize());
        this.tTT.writeFields(paramVarArgs);
      }
      if (this.LEI != null)
      {
        paramVarArgs.ni(9, this.LEI.computeSize());
        this.LEI.writeFields(paramVarArgs);
      }
      if (this.preloadInfo != null)
      {
        paramVarArgs.ni(10, this.preloadInfo.computeSize());
        this.preloadInfo.writeFields(paramVarArgs);
      }
      if (this.bgmInfo != null)
      {
        paramVarArgs.ni(11, this.bgmInfo.computeSize());
        this.bgmInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168992);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1470;
      }
    }
    label1470:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.continueFlag) + g.a.a.b.b.a.r(5, this.tTn);
      paramInt = i;
      if (this.LEG != null) {
        paramInt = i + g.a.a.a.nh(6, this.LEG.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.LEH);
      paramInt = i;
      if (this.tTT != null) {
        paramInt = i + g.a.a.a.nh(8, this.tTT.computeSize());
      }
      i = paramInt;
      if (this.LEI != null) {
        i = paramInt + g.a.a.a.nh(9, this.LEI.computeSize());
      }
      paramInt = i;
      if (this.preloadInfo != null) {
        paramInt = i + g.a.a.a.nh(10, this.preloadInfo.computeSize());
      }
      i = paramInt;
      if (this.bgmInfo != null) {
        i = paramInt + g.a.a.a.nh(11, this.bgmInfo.computeSize());
      }
      AppMethodBeat.o(168992);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(168992);
          throw paramVarArgs;
        }
        AppMethodBeat.o(168992);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        atv localatv = (atv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168992);
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
            localatv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localatv.object.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        case 3: 
          localatv.lastBuffer = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(168992);
          return 0;
        case 4: 
          localatv.continueFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168992);
          return 0;
        case 5: 
          localatv.tTn = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(168992);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bds();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bds)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localatv.LEG = ((bds)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        case 7: 
          localatv.LEH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168992);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localatv.tTT = ((dmk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localatv.LEI = ((dcz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new baw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((baw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localatv.preloadInfo = ((baw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bdr();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bdr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localatv.bgmInfo = ((bdr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168992);
        return 0;
      }
      AppMethodBeat.o(168992);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atv
 * JD-Core Version:    0.7.0.1
 */