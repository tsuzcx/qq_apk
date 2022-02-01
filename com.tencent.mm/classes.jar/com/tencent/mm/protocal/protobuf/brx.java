package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class brx
  extends cpx
{
  public String ELF;
  public String app_id;
  public String nYC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82453);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.app_id != null) {
        paramVarArgs.d(2, this.app_id);
      }
      if (this.ELF != null) {
        paramVarArgs.d(3, this.ELF);
      }
      if (this.nYC != null) {
        paramVarArgs.d(4, this.nYC);
      }
      AppMethodBeat.o(82453);
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
      if (this.app_id != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.app_id);
      }
      i = paramInt;
      if (this.ELF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ELF);
      }
      paramInt = i;
      if (this.nYC != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nYC);
      }
      AppMethodBeat.o(82453);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(82453);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        brx localbrx = (brx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82453);
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
            localbrx.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82453);
          return 0;
        case 2: 
          localbrx.app_id = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82453);
          return 0;
        case 3: 
          localbrx.ELF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82453);
          return 0;
        }
        localbrx.nYC = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(82453);
        return 0;
      }
      AppMethodBeat.o(82453);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brx
 * JD-Core Version:    0.7.0.1
 */