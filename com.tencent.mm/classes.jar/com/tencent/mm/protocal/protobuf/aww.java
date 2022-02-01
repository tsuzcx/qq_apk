package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aww
  extends cpx
{
  public String EOI;
  public String cZL;
  public String djj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(108143);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.cZL != null) {
        paramVarArgs.d(2, this.cZL);
      }
      if (this.djj != null) {
        paramVarArgs.d(3, this.djj);
      }
      if (this.EOI != null) {
        paramVarArgs.d(4, this.EOI);
      }
      AppMethodBeat.o(108143);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label490;
      }
    }
    label490:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.cZL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.cZL);
      }
      i = paramInt;
      if (this.djj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.djj);
      }
      paramInt = i;
      if (this.EOI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EOI);
      }
      AppMethodBeat.o(108143);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(108143);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aww localaww = (aww)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(108143);
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
            localaww.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(108143);
          return 0;
        case 2: 
          localaww.cZL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(108143);
          return 0;
        case 3: 
          localaww.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(108143);
          return 0;
        }
        localaww.EOI = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(108143);
        return 0;
      }
      AppMethodBeat.o(108143);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aww
 * JD-Core Version:    0.7.0.1
 */