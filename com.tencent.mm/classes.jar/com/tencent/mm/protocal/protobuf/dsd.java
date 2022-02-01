package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsd
  extends com.tencent.mm.bx.a
{
  public boo aaXW;
  public LinkedList<bqn> aaXY;
  
  public dsd()
  {
    AppMethodBeat.i(259864);
    this.aaXY = new LinkedList();
    AppMethodBeat.o(259864);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259867);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaXW != null)
      {
        paramVarArgs.qD(1, this.aaXW.computeSize());
        this.aaXW.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.aaXY);
      AppMethodBeat.o(259867);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaXW == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = i.a.a.a.qC(1, this.aaXW.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.aaXY);
      AppMethodBeat.o(259867);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaXY.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259867);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dsd localdsd = (dsd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259867);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new boo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((boo)localObject2).parseFrom((byte[])localObject1);
            }
            localdsd.aaXW = ((boo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259867);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bqn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bqn)localObject2).parseFrom((byte[])localObject1);
          }
          localdsd.aaXY.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259867);
        return 0;
      }
      AppMethodBeat.o(259867);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsd
 * JD-Core Version:    0.7.0.1
 */