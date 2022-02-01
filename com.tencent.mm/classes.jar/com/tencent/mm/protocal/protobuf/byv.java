package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byv
  extends cpx
{
  public bb EhT;
  public int FnR;
  public String Id;
  public String iJA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91556);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.FnR);
      if (this.Id != null) {
        paramVarArgs.d(3, this.Id);
      }
      if (this.iJA != null) {
        paramVarArgs.d(4, this.iJA);
      }
      if (this.EhT != null)
      {
        paramVarArgs.ln(5, this.EhT.computeSize());
        this.EhT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91556);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.FnR);
      paramInt = i;
      if (this.Id != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Id);
      }
      i = paramInt;
      if (this.iJA != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.iJA);
      }
      paramInt = i;
      if (this.EhT != null) {
        paramInt = i + f.a.a.a.lm(5, this.EhT.computeSize());
      }
      AppMethodBeat.o(91556);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91556);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        byv localbyv = (byv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91556);
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
            localbyv.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91556);
          return 0;
        case 2: 
          localbyv.FnR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91556);
          return 0;
        case 3: 
          localbyv.Id = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91556);
          return 0;
        case 4: 
          localbyv.iJA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91556);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbyv.EhT = ((bb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91556);
        return 0;
      }
      AppMethodBeat.o(91556);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byv
 * JD-Core Version:    0.7.0.1
 */