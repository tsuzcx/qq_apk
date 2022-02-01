package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class afc
  extends cpx
{
  public int Scene;
  public String hkR;
  public int ndI;
  public int wTD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195327);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hkR == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(195327);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ndI);
      paramVarArgs.aR(3, this.Scene);
      paramVarArgs.aR(4, this.wTD);
      if (this.hkR != null) {
        paramVarArgs.d(5, this.hkR);
      }
      AppMethodBeat.o(195327);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label546;
      }
    }
    label546:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ndI) + f.a.a.b.b.a.bx(3, this.Scene) + f.a.a.b.b.a.bx(4, this.wTD);
      paramInt = i;
      if (this.hkR != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hkR);
      }
      AppMethodBeat.o(195327);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.hkR == null)
        {
          paramVarArgs = new b("Not all required fields were included: Content");
          AppMethodBeat.o(195327);
          throw paramVarArgs;
        }
        AppMethodBeat.o(195327);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        afc localafc = (afc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195327);
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
            localafc.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(195327);
          return 0;
        case 2: 
          localafc.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(195327);
          return 0;
        case 3: 
          localafc.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(195327);
          return 0;
        case 4: 
          localafc.wTD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(195327);
          return 0;
        }
        localafc.hkR = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(195327);
        return 0;
      }
      AppMethodBeat.o(195327);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afc
 * JD-Core Version:    0.7.0.1
 */