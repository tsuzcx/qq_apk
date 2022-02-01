package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rs
  extends cpx
{
  public float dmL;
  public float doB;
  public String dvO;
  public String nUr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113970);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nUr != null) {
        paramVarArgs.d(2, this.nUr);
      }
      paramVarArgs.x(3, this.doB);
      paramVarArgs.x(4, this.dmL);
      if (this.dvO != null) {
        paramVarArgs.d(5, this.dvO);
      }
      AppMethodBeat.o(113970);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label520;
      }
    }
    label520:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nUr != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nUr);
      }
      i = i + (f.a.a.b.b.a.fK(3) + 4) + (f.a.a.b.b.a.fK(4) + 4);
      paramInt = i;
      if (this.dvO != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dvO);
      }
      AppMethodBeat.o(113970);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(113970);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        rs localrs = (rs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113970);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localrs.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113970);
          return 0;
        case 2: 
          localrs.nUr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113970);
          return 0;
        case 3: 
          localrs.doB = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(113970);
          return 0;
        case 4: 
          localrs.dmL = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(113970);
          return 0;
        }
        localrs.dvO = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(113970);
        return 0;
      }
      AppMethodBeat.o(113970);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rs
 * JD-Core Version:    0.7.0.1
 */