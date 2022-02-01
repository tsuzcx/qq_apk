package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dlt
  extends cpx
{
  public SKBuiltinBuffer_t DYu;
  public String FUa;
  public String FUb;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(130921);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FUa != null) {
        paramVarArgs.d(2, this.FUa);
      }
      if (this.FUb != null) {
        paramVarArgs.d(3, this.FUb);
      }
      paramVarArgs.aR(4, this.Scene);
      if (this.DYu != null)
      {
        paramVarArgs.ln(5, this.DYu.computeSize());
        this.DYu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(130921);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FUa != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FUa);
      }
      i = paramInt;
      if (this.FUb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FUb);
      }
      i += f.a.a.b.b.a.bx(4, this.Scene);
      paramInt = i;
      if (this.DYu != null) {
        paramInt = i + f.a.a.a.lm(5, this.DYu.computeSize());
      }
      AppMethodBeat.o(130921);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(130921);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dlt localdlt = (dlt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(130921);
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
            localdlt.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(130921);
          return 0;
        case 2: 
          localdlt.FUa = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(130921);
          return 0;
        case 3: 
          localdlt.FUb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(130921);
          return 0;
        case 4: 
          localdlt.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(130921);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdlt.DYu = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(130921);
        return 0;
      }
      AppMethodBeat.o(130921);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlt
 * JD-Core Version:    0.7.0.1
 */