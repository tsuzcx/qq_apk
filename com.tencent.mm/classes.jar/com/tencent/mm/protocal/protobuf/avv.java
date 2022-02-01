package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avv
  extends cqk
{
  public LinkedList<Integer> EKK;
  public int ENQ;
  public LinkedList<bva> ENR;
  public LinkedList<dpn> ENS;
  public LinkedList<cun> ENT;
  
  public avv()
  {
    AppMethodBeat.i(32234);
    this.ENR = new LinkedList();
    this.EKK = new LinkedList();
    this.ENS = new LinkedList();
    this.ENT = new LinkedList();
    AppMethodBeat.o(32234);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32235);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32235);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ENQ);
      paramVarArgs.e(3, 8, this.ENR);
      paramVarArgs.f(4, 2, this.EKK);
      paramVarArgs.e(5, 8, this.ENS);
      paramVarArgs.e(6, 8, this.ENT);
      AppMethodBeat.o(32235);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label917;
      }
    }
    label917:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.ENQ);
      int j = f.a.a.a.c(3, 8, this.ENR);
      int k = f.a.a.a.d(4, 2, this.EKK);
      int m = f.a.a.a.c(5, 8, this.ENS);
      int n = f.a.a.a.c(6, 8, this.ENT);
      AppMethodBeat.o(32235);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ENR.clear();
        this.EKK.clear();
        this.ENS.clear();
        this.ENT.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32235);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32235);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avv localavv = (avv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32235);
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
            localavv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32235);
          return 0;
        case 2: 
          localavv.ENQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32235);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bva();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bva)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavv.ENR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32235);
          return 0;
        case 4: 
          localavv.EKK = new f.a.a.a.a(((f.a.a.a.a)localObject1).LVo.gfk().xy, unknownTagHandler).LVo.gfi();
          AppMethodBeat.o(32235);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dpn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dpn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavv.ENS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32235);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cun();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cun)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localavv.ENT.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32235);
        return 0;
      }
      AppMethodBeat.o(32235);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avv
 * JD-Core Version:    0.7.0.1
 */