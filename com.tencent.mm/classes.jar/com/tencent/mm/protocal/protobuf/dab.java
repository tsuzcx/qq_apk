package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dab
  extends cpx
{
  public czv FIK;
  public crm FIL;
  public String hkN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125780);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FIK == null)
      {
        paramVarArgs = new b("Not all required fields were included: Action");
        AppMethodBeat.o(125780);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FIK != null)
      {
        paramVarArgs.ln(2, this.FIK.computeSize());
        this.FIK.writeFields(paramVarArgs);
      }
      if (this.hkN != null) {
        paramVarArgs.d(3, this.hkN);
      }
      if (this.FIL != null)
      {
        paramVarArgs.ln(4, this.FIL.computeSize());
        this.FIL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125780);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label726;
      }
    }
    label726:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FIK != null) {
        paramInt = i + f.a.a.a.lm(2, this.FIK.computeSize());
      }
      i = paramInt;
      if (this.hkN != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hkN);
      }
      paramInt = i;
      if (this.FIL != null) {
        paramInt = i + f.a.a.a.lm(4, this.FIL.computeSize());
      }
      AppMethodBeat.o(125780);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FIK == null)
        {
          paramVarArgs = new b("Not all required fields were included: Action");
          AppMethodBeat.o(125780);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125780);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dab localdab = (dab)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125780);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdab.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125780);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new czv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((czv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdab.FIK = ((czv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125780);
          return 0;
        case 3: 
          localdab.hkN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125780);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdab.FIL = ((crm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125780);
        return 0;
      }
      AppMethodBeat.o(125780);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dab
 * JD-Core Version:    0.7.0.1
 */