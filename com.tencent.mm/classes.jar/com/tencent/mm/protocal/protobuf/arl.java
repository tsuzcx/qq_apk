package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arl
  extends cqk
{
  public int DXj;
  public LinkedList<com.tencent.mm.bw.b> EKA;
  public LinkedList<Integer> EKK;
  public LinkedList<ark> EKL;
  public LinkedList<arf> EKM;
  
  public arl()
  {
    AppMethodBeat.i(152550);
    this.EKK = new LinkedList();
    this.EKL = new LinkedList();
    this.EKM = new LinkedList();
    this.EKA = new LinkedList();
    AppMethodBeat.o(152550);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152551);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152551);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DXj);
      paramVarArgs.e(3, 2, this.EKK);
      paramVarArgs.e(4, 8, this.EKL);
      paramVarArgs.e(5, 8, this.EKM);
      paramVarArgs.e(7, 6, this.EKA);
      AppMethodBeat.o(152551);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label817;
      }
    }
    label817:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.DXj);
      int j = f.a.a.a.c(3, 2, this.EKK);
      int k = f.a.a.a.c(4, 8, this.EKL);
      int m = f.a.a.a.c(5, 8, this.EKM);
      int n = f.a.a.a.c(7, 6, this.EKA);
      AppMethodBeat.o(152551);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EKK.clear();
        this.EKL.clear();
        this.EKM.clear();
        this.EKA.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152551);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152551);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        arl localarl = (arl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(152551);
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
            localarl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152551);
          return 0;
        case 2: 
          localarl.DXj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152551);
          return 0;
        case 3: 
          localarl.EKK.add(Integer.valueOf(((f.a.a.a.a)localObject1).LVo.xF()));
          AppMethodBeat.o(152551);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ark();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ark)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarl.EKL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152551);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new arf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((arf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarl.EKM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152551);
          return 0;
        }
        localarl.EKA.add(((f.a.a.a.a)localObject1).LVo.gfk());
        AppMethodBeat.o(152551);
        return 0;
      }
      AppMethodBeat.o(152551);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arl
 * JD-Core Version:    0.7.0.1
 */