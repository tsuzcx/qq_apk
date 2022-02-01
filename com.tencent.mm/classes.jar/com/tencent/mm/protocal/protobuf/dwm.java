package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dwm
  extends com.tencent.mm.bx.a
{
  public String FKD;
  public SKBuiltinBuffer_t HFw;
  public int HIU;
  public int ihf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148667);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HFw == null)
      {
        paramVarArgs = new b("Not all required fields were included: Text");
        AppMethodBeat.o(148667);
        throw paramVarArgs;
      }
      if (this.HFw != null)
      {
        paramVarArgs.lC(1, this.HFw.computeSize());
        this.HFw.writeFields(paramVarArgs);
      }
      if (this.FKD != null) {
        paramVarArgs.d(2, this.FKD);
      }
      paramVarArgs.aS(3, this.ihf);
      paramVarArgs.aS(4, this.HIU);
      AppMethodBeat.o(148667);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HFw == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = f.a.a.a.lB(1, this.HFw.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FKD != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FKD);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.ihf);
      int j = f.a.a.b.b.a.bz(4, this.HIU);
      AppMethodBeat.o(148667);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HFw == null)
        {
          paramVarArgs = new b("Not all required fields were included: Text");
          AppMethodBeat.o(148667);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148667);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dwm localdwm = (dwm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148667);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwm.HFw = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148667);
          return 0;
        case 2: 
          localdwm.FKD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(148667);
          return 0;
        case 3: 
          localdwm.ihf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148667);
          return 0;
        }
        localdwm.HIU = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(148667);
        return 0;
      }
      AppMethodBeat.o(148667);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwm
 * JD-Core Version:    0.7.0.1
 */