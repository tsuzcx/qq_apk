package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dtc
  extends com.tencent.mm.bx.a
{
  public boo aaXW;
  public dta aaYD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259408);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaYD != null)
      {
        paramVarArgs.qD(1, this.aaYD.computeSize());
        this.aaYD.writeFields(paramVarArgs);
      }
      if (this.aaXW != null)
      {
        paramVarArgs.qD(2, this.aaXW.computeSize());
        this.aaXW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259408);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaYD == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = i.a.a.a.qC(1, this.aaYD.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaXW != null) {
        i = paramInt + i.a.a.a.qC(2, this.aaXW.computeSize());
      }
      AppMethodBeat.o(259408);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259408);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dtc localdtc = (dtc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259408);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dta();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dta)localObject2).parseFrom((byte[])localObject1);
            }
            localdtc.aaYD = ((dta)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259408);
          return 0;
        }
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
          localdtc.aaXW = ((boo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259408);
        return 0;
      }
      AppMethodBeat.o(259408);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtc
 * JD-Core Version:    0.7.0.1
 */