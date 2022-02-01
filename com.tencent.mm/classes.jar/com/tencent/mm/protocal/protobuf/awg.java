package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class awg
  extends cld
{
  public int DsQ;
  public qw DsR;
  public int DsU;
  public int DsV;
  public rl DsW;
  public ra DvC;
  public qt DvD;
  public String DvE;
  public qz DvF;
  public int ntx;
  public String nty;
  public int ocT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114029);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114029);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ntx);
      if (this.nty != null) {
        paramVarArgs.d(3, this.nty);
      }
      paramVarArgs.aR(4, this.ocT);
      paramVarArgs.aR(5, this.DsQ);
      if (this.DsR != null)
      {
        paramVarArgs.kX(6, this.DsR.computeSize());
        this.DsR.writeFields(paramVarArgs);
      }
      if (this.DvC != null)
      {
        paramVarArgs.kX(7, this.DvC.computeSize());
        this.DvC.writeFields(paramVarArgs);
      }
      if (this.DvD != null)
      {
        paramVarArgs.kX(8, this.DvD.computeSize());
        this.DvD.writeFields(paramVarArgs);
      }
      if (this.DvE != null) {
        paramVarArgs.d(10, this.DvE);
      }
      paramVarArgs.aR(11, this.DsU);
      paramVarArgs.aR(12, this.DsV);
      if (this.DsW != null)
      {
        paramVarArgs.kX(13, this.DsW.computeSize());
        this.DsW.writeFields(paramVarArgs);
      }
      if (this.DvF != null)
      {
        paramVarArgs.kX(14, this.DvF.computeSize());
        this.DvF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114029);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1486;
      }
    }
    label1486:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.ocT) + f.a.a.b.b.a.bA(5, this.DsQ);
      paramInt = i;
      if (this.DsR != null) {
        paramInt = i + f.a.a.a.kW(6, this.DsR.computeSize());
      }
      i = paramInt;
      if (this.DvC != null) {
        i = paramInt + f.a.a.a.kW(7, this.DvC.computeSize());
      }
      paramInt = i;
      if (this.DvD != null) {
        paramInt = i + f.a.a.a.kW(8, this.DvD.computeSize());
      }
      i = paramInt;
      if (this.DvE != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.DvE);
      }
      i = i + f.a.a.b.b.a.bA(11, this.DsU) + f.a.a.b.b.a.bA(12, this.DsV);
      paramInt = i;
      if (this.DsW != null) {
        paramInt = i + f.a.a.a.kW(13, this.DsW.computeSize());
      }
      i = paramInt;
      if (this.DvF != null) {
        i = paramInt + f.a.a.a.kW(14, this.DvF.computeSize());
      }
      AppMethodBeat.o(114029);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(114029);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114029);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        awg localawg = (awg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 9: 
        default: 
          AppMethodBeat.o(114029);
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
            localawg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 2: 
          localawg.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114029);
          return 0;
        case 3: 
          localawg.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114029);
          return 0;
        case 4: 
          localawg.ocT = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114029);
          return 0;
        case 5: 
          localawg.DsQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114029);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawg.DsR = ((qw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ra();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ra)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawg.DvC = ((ra)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawg.DvD = ((qt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 10: 
          localawg.DvE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114029);
          return 0;
        case 11: 
          localawg.DsU = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114029);
          return 0;
        case 12: 
          localawg.DsV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114029);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawg.DsW = ((rl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((qz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localawg.DvF = ((qz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114029);
        return 0;
      }
      AppMethodBeat.o(114029);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awg
 * JD-Core Version:    0.7.0.1
 */