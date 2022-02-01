package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bvm
  extends com.tencent.mm.bw.a
{
  public int DeleteFlag;
  public crm EuE;
  public int Flm;
  public int Fln;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32351);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EuE == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(32351);
        throw paramVarArgs;
      }
      if (this.EuE != null)
      {
        paramVarArgs.ln(1, this.EuE.computeSize());
        this.EuE.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Flm);
      paramVarArgs.aR(3, this.Fln);
      paramVarArgs.aR(4, this.DeleteFlag);
      AppMethodBeat.o(32351);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EuE == null) {
        break label508;
      }
    }
    label508:
    for (paramInt = f.a.a.a.lm(1, this.EuE.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.Flm);
      int j = f.a.a.b.b.a.bx(3, this.Fln);
      int k = f.a.a.b.b.a.bx(4, this.DeleteFlag);
      AppMethodBeat.o(32351);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EuE == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(32351);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32351);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bvm localbvm = (bvm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32351);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvm.EuE = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32351);
          return 0;
        case 2: 
          localbvm.Flm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32351);
          return 0;
        case 3: 
          localbvm.Fln = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32351);
          return 0;
        }
        localbvm.DeleteFlag = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32351);
        return 0;
      }
      AppMethodBeat.o(32351);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvm
 * JD-Core Version:    0.7.0.1
 */