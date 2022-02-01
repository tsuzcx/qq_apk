package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dhf
  extends dpc
{
  public eig LUW;
  public sx LWE;
  public long LjE;
  public long LjF;
  public cbw LpE;
  public crf MLE;
  public dpp MhF;
  public LinkedList<czq> dkr;
  public int pTZ;
  public String pUa;
  
  public dhf()
  {
    AppMethodBeat.i(72560);
    this.dkr = new LinkedList();
    AppMethodBeat.o(72560);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72561);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72561);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.pTZ);
      if (this.pUa != null) {
        paramVarArgs.e(3, this.pUa);
      }
      if (this.LpE != null)
      {
        paramVarArgs.ni(4, this.LpE.computeSize());
        this.LpE.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.dkr);
      paramVarArgs.bb(6, this.LjE);
      paramVarArgs.bb(7, this.LjF);
      if (this.MhF != null)
      {
        paramVarArgs.ni(8, this.MhF.computeSize());
        this.MhF.writeFields(paramVarArgs);
      }
      if (this.LWE != null)
      {
        paramVarArgs.ni(9, this.LWE.computeSize());
        this.LWE.writeFields(paramVarArgs);
      }
      if (this.LUW != null)
      {
        paramVarArgs.ni(10, this.LUW.computeSize());
        this.LUW.writeFields(paramVarArgs);
      }
      if (this.MLE != null)
      {
        paramVarArgs.ni(11, this.MLE.computeSize());
        this.MLE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72561);
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
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt;
      if (this.LpE != null) {
        i = paramInt + g.a.a.a.nh(4, this.LpE.computeSize());
      }
      i = i + g.a.a.a.c(5, 8, this.dkr) + g.a.a.b.b.a.r(6, this.LjE) + g.a.a.b.b.a.r(7, this.LjF);
      paramInt = i;
      if (this.MhF != null) {
        paramInt = i + g.a.a.a.nh(8, this.MhF.computeSize());
      }
      i = paramInt;
      if (this.LWE != null) {
        i = paramInt + g.a.a.a.nh(9, this.LWE.computeSize());
      }
      paramInt = i;
      if (this.LUW != null) {
        paramInt = i + g.a.a.a.nh(10, this.LUW.computeSize());
      }
      i = paramInt;
      if (this.MLE != null) {
        i = paramInt + g.a.a.a.nh(11, this.MLE.computeSize());
      }
      AppMethodBeat.o(72561);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.dkr.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72561);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72561);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dhf localdhf = (dhf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72561);
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
            localdhf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 2: 
          localdhf.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72561);
          return 0;
        case 3: 
          localdhf.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72561);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cbw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhf.LpE = ((cbw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new czq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((czq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhf.dkr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 6: 
          localdhf.LjE = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(72561);
          return 0;
        case 7: 
          localdhf.LjF = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(72561);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dpp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dpp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhf.MhF = ((dpp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sx();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhf.LWE = ((sx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eig();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eig)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhf.LUW = ((eig)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crf();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdhf.MLE = ((crf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72561);
        return 0;
      }
      AppMethodBeat.o(72561);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhf
 * JD-Core Version:    0.7.0.1
 */