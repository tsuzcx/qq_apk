package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fcx
  extends com.tencent.mm.bx.a
{
  public String YMe;
  public fmp aaXk;
  public esr abCm;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91693);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaXk != null)
      {
        paramVarArgs.qD(1, this.aaXk.computeSize());
        this.aaXk.writeFields(paramVarArgs);
      }
      if (this.abCm != null)
      {
        paramVarArgs.qD(2, this.abCm.computeSize());
        this.abCm.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.type);
      if (this.YMe != null) {
        paramVarArgs.g(4, this.YMe);
      }
      AppMethodBeat.o(91693);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaXk == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = i.a.a.a.qC(1, this.aaXk.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abCm != null) {
        i = paramInt + i.a.a.a.qC(2, this.abCm.computeSize());
      }
      i += i.a.a.b.b.a.cJ(3, this.type);
      paramInt = i;
      if (this.YMe != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YMe);
      }
      AppMethodBeat.o(91693);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91693);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fcx localfcx = (fcx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91693);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fmp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fmp)localObject2).parseFrom((byte[])localObject1);
            }
            localfcx.aaXk = ((fmp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91693);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new esr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((esr)localObject2).parseFrom((byte[])localObject1);
            }
            localfcx.abCm = ((esr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91693);
          return 0;
        case 3: 
          localfcx.type = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91693);
          return 0;
        }
        localfcx.YMe = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91693);
        return 0;
      }
      AppMethodBeat.o(91693);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcx
 * JD-Core Version:    0.7.0.1
 */