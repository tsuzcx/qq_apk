package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ax
  extends com.tencent.mm.bx.a
{
  public String Fsq;
  public LinkedList<cfr> Fsr;
  public LinkedList<cfq> dcr;
  
  public ax()
  {
    AppMethodBeat.i(152476);
    this.Fsr = new LinkedList();
    this.dcr = new LinkedList();
    AppMethodBeat.o(152476);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152477);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fsq != null) {
        paramVarArgs.d(1, this.Fsq);
      }
      paramVarArgs.e(2, 8, this.Fsr);
      paramVarArgs.e(3, 8, this.dcr);
      AppMethodBeat.o(152477);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fsq == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = f.a.a.b.b.a.e(1, this.Fsq) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.Fsr);
      int j = f.a.a.a.c(3, 8, this.dcr);
      AppMethodBeat.o(152477);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Fsr.clear();
        this.dcr.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152477);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ax localax = (ax)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152477);
          return -1;
        case 1: 
          localax.Fsq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152477);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localax.Fsr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152477);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cfq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cfq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localax.dcr.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152477);
        return 0;
      }
      AppMethodBeat.o(152477);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ax
 * JD-Core Version:    0.7.0.1
 */