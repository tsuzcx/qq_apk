package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cif
  extends com.tencent.mm.bx.a
{
  public String fFR;
  public LinkedList<cig> vox;
  
  public cif()
  {
    AppMethodBeat.i(192560);
    this.vox = new LinkedList();
    AppMethodBeat.o(192560);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(192561);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fFR != null) {
        paramVarArgs.d(1, this.fFR);
      }
      paramVarArgs.e(2, 8, this.vox);
      AppMethodBeat.o(192561);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fFR == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = f.a.a.b.b.a.e(1, this.fFR) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.vox);
      AppMethodBeat.o(192561);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.vox.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(192561);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cif localcif = (cif)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(192561);
          return -1;
        case 1: 
          localcif.fFR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(192561);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cig();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cig)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcif.vox.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(192561);
        return 0;
      }
      AppMethodBeat.o(192561);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cif
 * JD-Core Version:    0.7.0.1
 */