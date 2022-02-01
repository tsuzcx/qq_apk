package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class av
  extends com.tencent.mm.bx.a
{
  public String CuQ;
  public LinkedList<bwi> CuR;
  public LinkedList<bwh> cTE;
  
  public av()
  {
    AppMethodBeat.i(152476);
    this.CuR = new LinkedList();
    this.cTE = new LinkedList();
    AppMethodBeat.o(152476);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152477);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CuQ != null) {
        paramVarArgs.d(1, this.CuQ);
      }
      paramVarArgs.e(2, 8, this.CuR);
      paramVarArgs.e(3, 8, this.cTE);
      AppMethodBeat.o(152477);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CuQ == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = f.a.a.b.b.a.e(1, this.CuQ) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.CuR);
      int j = f.a.a.a.c(3, 8, this.cTE);
      AppMethodBeat.o(152477);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CuR.clear();
        this.cTE.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152477);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        av localav = (av)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152477);
          return -1;
        case 1: 
          localav.CuQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152477);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localav.CuR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152477);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localav.cTE.add(localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.av
 * JD-Core Version:    0.7.0.1
 */