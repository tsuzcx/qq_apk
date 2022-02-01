package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class awc
  extends dpc
{
  public String LGA;
  public String LGB;
  public int LGC;
  public String LGD;
  public String LGE;
  public String LGF;
  public String LGG;
  public String LGH;
  public String LGI;
  public String LGw;
  public LinkedList<axg> LGy;
  public String LGz;
  public int continueFlag;
  public int gAZ;
  public long liveId;
  public b tVM;
  public String ukr;
  public String vtD;
  
  public awc()
  {
    AppMethodBeat.i(209522);
    this.LGy = new LinkedList();
    AppMethodBeat.o(209522);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209523);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.gAZ);
      paramVarArgs.e(3, 8, this.LGy);
      if (this.tVM != null) {
        paramVarArgs.c(4, this.tVM);
      }
      paramVarArgs.aM(5, this.continueFlag);
      if (this.LGz != null) {
        paramVarArgs.e(6, this.LGz);
      }
      if (this.LGA != null) {
        paramVarArgs.e(7, this.LGA);
      }
      if (this.LGB != null) {
        paramVarArgs.e(8, this.LGB);
      }
      paramVarArgs.aM(9, this.LGC);
      if (this.LGD != null) {
        paramVarArgs.e(10, this.LGD);
      }
      paramVarArgs.bb(11, this.liveId);
      if (this.LGE != null) {
        paramVarArgs.e(12, this.LGE);
      }
      if (this.LGF != null) {
        paramVarArgs.e(13, this.LGF);
      }
      if (this.LGG != null) {
        paramVarArgs.e(14, this.LGG);
      }
      if (this.ukr != null) {
        paramVarArgs.e(15, this.ukr);
      }
      if (this.vtD != null) {
        paramVarArgs.e(16, this.vtD);
      }
      if (this.LGH != null) {
        paramVarArgs.e(17, this.LGH);
      }
      if (this.LGI != null) {
        paramVarArgs.e(18, this.LGI);
      }
      if (this.LGw != null) {
        paramVarArgs.e(20, this.LGw);
      }
      AppMethodBeat.o(209523);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1438;
      }
    }
    label1438:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.gAZ) + g.a.a.a.c(3, 8, this.LGy);
      paramInt = i;
      if (this.tVM != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.tVM);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.continueFlag);
      paramInt = i;
      if (this.LGz != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LGz);
      }
      i = paramInt;
      if (this.LGA != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.LGA);
      }
      paramInt = i;
      if (this.LGB != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.LGB);
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.LGC);
      paramInt = i;
      if (this.LGD != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.LGD);
      }
      i = paramInt + g.a.a.b.b.a.r(11, this.liveId);
      paramInt = i;
      if (this.LGE != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.LGE);
      }
      i = paramInt;
      if (this.LGF != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.LGF);
      }
      paramInt = i;
      if (this.LGG != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.LGG);
      }
      i = paramInt;
      if (this.ukr != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.ukr);
      }
      paramInt = i;
      if (this.vtD != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.vtD);
      }
      i = paramInt;
      if (this.LGH != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.LGH);
      }
      paramInt = i;
      if (this.LGI != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.LGI);
      }
      i = paramInt;
      if (this.LGw != null) {
        i = paramInt + g.a.a.b.b.a.f(20, this.LGw);
      }
      AppMethodBeat.o(209523);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LGy.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209523);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        awc localawc = (awc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 19: 
        default: 
          AppMethodBeat.o(209523);
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
            localawc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209523);
          return 0;
        case 2: 
          localawc.gAZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209523);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new axg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((axg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localawc.LGy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209523);
          return 0;
        case 4: 
          localawc.tVM = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209523);
          return 0;
        case 5: 
          localawc.continueFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209523);
          return 0;
        case 6: 
          localawc.LGz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209523);
          return 0;
        case 7: 
          localawc.LGA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209523);
          return 0;
        case 8: 
          localawc.LGB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209523);
          return 0;
        case 9: 
          localawc.LGC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209523);
          return 0;
        case 10: 
          localawc.LGD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209523);
          return 0;
        case 11: 
          localawc.liveId = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209523);
          return 0;
        case 12: 
          localawc.LGE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209523);
          return 0;
        case 13: 
          localawc.LGF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209523);
          return 0;
        case 14: 
          localawc.LGG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209523);
          return 0;
        case 15: 
          localawc.ukr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209523);
          return 0;
        case 16: 
          localawc.vtD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209523);
          return 0;
        case 17: 
          localawc.LGH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209523);
          return 0;
        case 18: 
          localawc.LGI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209523);
          return 0;
        }
        localawc.LGw = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209523);
        return 0;
      }
      AppMethodBeat.o(209523);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awc
 * JD-Core Version:    0.7.0.1
 */