package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxv
  extends com.tencent.mm.bx.a
{
  public LinkedList<in> Dde;
  public ebn LwQ;
  public boolean LwR;
  
  public dxv()
  {
    AppMethodBeat.i(203583);
    this.Dde = new LinkedList();
    AppMethodBeat.o(203583);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203584);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.LwQ != null)
      {
        paramVarArgs.kX(1, this.LwQ.computeSize());
        this.LwQ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Dde);
      paramVarArgs.bg(3, this.LwR);
      AppMethodBeat.o(203584);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LwQ == null) {
        break label494;
      }
    }
    label494:
    for (paramInt = f.a.a.a.kW(1, this.LwQ.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.Dde);
      int j = f.a.a.b.b.a.fY(3);
      AppMethodBeat.o(203584);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dde.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(203584);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dxv localdxv = (dxv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(203584);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxv.LwQ = ((ebn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(203584);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new in();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((in)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxv.Dde.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(203584);
          return 0;
        }
        localdxv.LwR = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(203584);
        return 0;
      }
      AppMethodBeat.o(203584);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxv
 * JD-Core Version:    0.7.0.1
 */