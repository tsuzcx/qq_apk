package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ado
  extends com.tencent.mm.bw.a
{
  public cxn GuF;
  public LinkedList<Integer> GuL;
  public int nID;
  
  public ado()
  {
    AppMethodBeat.i(43092);
    this.GuL = new LinkedList();
    AppMethodBeat.o(43092);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43093);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GuF == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(43093);
        throw paramVarArgs;
      }
      if (this.GuF != null)
      {
        paramVarArgs.lJ(1, this.GuF.computeSize());
        this.GuF.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.nID);
      paramVarArgs.f(3, 2, this.GuL);
      AppMethodBeat.o(43093);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GuF == null) {
        break label477;
      }
    }
    label477:
    for (paramInt = f.a.a.a.lI(1, this.GuF.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.nID);
      int j = f.a.a.a.d(3, 2, this.GuL);
      AppMethodBeat.o(43093);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GuL.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GuF == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: UserName");
          AppMethodBeat.o(43093);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43093);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ado localado = (ado)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43093);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localado.GuF = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43093);
          return 0;
        case 2: 
          localado.nID = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(43093);
          return 0;
        }
        localado.GuL = new f.a.a.a.a(((f.a.a.a.a)localObject1).OmT.gCk().zr, unknownTagHandler).OmT.gCi();
        AppMethodBeat.o(43093);
        return 0;
      }
      AppMethodBeat.o(43093);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ado
 * JD-Core Version:    0.7.0.1
 */