package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwa
  extends com.tencent.mm.bx.a
{
  public String EJM;
  public LinkedList<dvz> EJN;
  
  public dwa()
  {
    AppMethodBeat.i(153332);
    this.EJN = new LinkedList();
    AppMethodBeat.o(153332);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153333);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EJM != null) {
        paramVarArgs.d(1, this.EJM);
      }
      paramVarArgs.e(2, 8, this.EJN);
      AppMethodBeat.o(153333);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EJM == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = f.a.a.b.b.a.e(1, this.EJM) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.EJN);
      AppMethodBeat.o(153333);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EJN.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153333);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dwa localdwa = (dwa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153333);
          return -1;
        case 1: 
          localdwa.EJM = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153333);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dvz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dvz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwa.EJN.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153333);
        return 0;
      }
      AppMethodBeat.o(153333);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwa
 * JD-Core Version:    0.7.0.1
 */