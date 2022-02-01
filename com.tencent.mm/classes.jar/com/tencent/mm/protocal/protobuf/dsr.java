package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dsr
  extends cqk
{
  public int Exf;
  public long Exg;
  public LinkedList<dqy> FYZ;
  public int Fwc;
  public int GaR;
  public LinkedList<dqy> GaS;
  public int GaT;
  public LinkedList<dqy> GaU;
  public int GaV;
  public int GaW;
  public int GaX;
  public dsl GaY;
  
  public dsr()
  {
    AppMethodBeat.i(115907);
    this.GaS = new LinkedList();
    this.GaU = new LinkedList();
    this.FYZ = new LinkedList();
    AppMethodBeat.o(115907);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115908);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115908);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Exf);
      paramVarArgs.aR(3, this.GaR);
      paramVarArgs.e(4, 8, this.GaS);
      paramVarArgs.aR(5, this.GaT);
      paramVarArgs.e(6, 8, this.GaU);
      paramVarArgs.aO(7, this.Exg);
      paramVarArgs.aR(8, this.Fwc);
      paramVarArgs.aR(9, this.GaV);
      paramVarArgs.e(10, 8, this.FYZ);
      paramVarArgs.aR(11, this.GaW);
      paramVarArgs.aR(12, this.GaX);
      if (this.GaY != null)
      {
        paramVarArgs.ln(13, this.GaY.computeSize());
        this.GaY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115908);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1278;
      }
    }
    label1278:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Exf) + f.a.a.b.b.a.bx(3, this.GaR) + f.a.a.a.c(4, 8, this.GaS) + f.a.a.b.b.a.bx(5, this.GaT) + f.a.a.a.c(6, 8, this.GaU) + f.a.a.b.b.a.p(7, this.Exg) + f.a.a.b.b.a.bx(8, this.Fwc) + f.a.a.b.b.a.bx(9, this.GaV) + f.a.a.a.c(10, 8, this.FYZ) + f.a.a.b.b.a.bx(11, this.GaW) + f.a.a.b.b.a.bx(12, this.GaX);
      paramInt = i;
      if (this.GaY != null) {
        paramInt = i + f.a.a.a.lm(13, this.GaY.computeSize());
      }
      AppMethodBeat.o(115908);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GaS.clear();
        this.GaU.clear();
        this.FYZ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(115908);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115908);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dsr localdsr = (dsr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115908);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 2: 
          localdsr.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115908);
          return 0;
        case 3: 
          localdsr.GaR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115908);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsr.GaS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 5: 
          localdsr.GaT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115908);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsr.GaU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 7: 
          localdsr.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(115908);
          return 0;
        case 8: 
          localdsr.Fwc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115908);
          return 0;
        case 9: 
          localdsr.GaV = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115908);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsr.FYZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 11: 
          localdsr.GaW = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115908);
          return 0;
        case 12: 
          localdsr.GaX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115908);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dsl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dsl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdsr.GaY = ((dsl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115908);
        return 0;
      }
      AppMethodBeat.o(115908);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsr
 * JD-Core Version:    0.7.0.1
 */