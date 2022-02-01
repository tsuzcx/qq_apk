package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ayi
  extends cpx
{
  public String DLD;
  public acp DLU;
  public String sqm;
  public String sqn;
  public String sqo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32243);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.sqm != null) {
        paramVarArgs.d(2, this.sqm);
      }
      if (this.sqn != null) {
        paramVarArgs.d(3, this.sqn);
      }
      if (this.sqo != null) {
        paramVarArgs.d(4, this.sqo);
      }
      if (this.DLD != null) {
        paramVarArgs.d(5, this.DLD);
      }
      if (this.DLU != null)
      {
        paramVarArgs.ln(6, this.DLU.computeSize());
        this.DLU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32243);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label718;
      }
    }
    label718:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sqm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.sqm);
      }
      i = paramInt;
      if (this.sqn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sqn);
      }
      paramInt = i;
      if (this.sqo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sqo);
      }
      i = paramInt;
      if (this.DLD != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DLD);
      }
      paramInt = i;
      if (this.DLU != null) {
        paramInt = i + f.a.a.a.lm(6, this.DLU.computeSize());
      }
      AppMethodBeat.o(32243);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32243);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayi localayi = (ayi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32243);
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
            localayi.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32243);
          return 0;
        case 2: 
          localayi.sqm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32243);
          return 0;
        case 3: 
          localayi.sqn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32243);
          return 0;
        case 4: 
          localayi.sqo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32243);
          return 0;
        case 5: 
          localayi.DLD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32243);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new acp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((acp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localayi.DLU = ((acp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32243);
        return 0;
      }
      AppMethodBeat.o(32243);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayi
 * JD-Core Version:    0.7.0.1
 */