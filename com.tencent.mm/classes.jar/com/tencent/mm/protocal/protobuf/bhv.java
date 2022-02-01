package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bhv
  extends com.tencent.mm.bx.a
{
  public bim ZOR;
  public String ZRa;
  public b ZRb;
  public int wuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257608);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZRa != null) {
        paramVarArgs.g(1, this.ZRa);
      }
      if (this.ZOR != null)
      {
        paramVarArgs.qD(2, this.ZOR.computeSize());
        this.ZOR.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.wuz);
      if (this.ZRb != null) {
        paramVarArgs.d(4, this.ZRb);
      }
      AppMethodBeat.o(257608);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZRa == null) {
        break label448;
      }
    }
    label448:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZRa) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZOR != null) {
        i = paramInt + i.a.a.a.qC(2, this.ZOR.computeSize());
      }
      i += i.a.a.b.b.a.cJ(3, this.wuz);
      paramInt = i;
      if (this.ZRb != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.ZRb);
      }
      AppMethodBeat.o(257608);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257608);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bhv localbhv = (bhv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257608);
          return -1;
        case 1: 
          localbhv.ZRa = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257608);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            bim localbim = new bim();
            if ((localObject != null) && (localObject.length > 0)) {
              localbim.parseFrom((byte[])localObject);
            }
            localbhv.ZOR = localbim;
            paramInt += 1;
          }
          AppMethodBeat.o(257608);
          return 0;
        case 3: 
          localbhv.wuz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257608);
          return 0;
        }
        localbhv.ZRb = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(257608);
        return 0;
      }
      AppMethodBeat.o(257608);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhv
 * JD-Core Version:    0.7.0.1
 */