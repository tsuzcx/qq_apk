package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dps
  extends com.tencent.mm.bx.a
{
  public cyx YNR;
  public cyy YNS;
  public int aaWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32350);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YNR == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDevice");
        AppMethodBeat.o(32350);
        throw paramVarArgs;
      }
      if (this.YNR != null)
      {
        paramVarArgs.qD(1, this.YNR.computeSize());
        this.YNR.writeFields(paramVarArgs);
      }
      if (this.YNS != null)
      {
        paramVarArgs.qD(2, this.YNS.computeSize());
        this.YNS.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.aaWu);
      AppMethodBeat.o(32350);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YNR == null) {
        break label519;
      }
    }
    label519:
    for (paramInt = i.a.a.a.qC(1, this.YNR.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YNS != null) {
        i = paramInt + i.a.a.a.qC(2, this.YNS.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.aaWu);
      AppMethodBeat.o(32350);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YNR == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDevice");
          AppMethodBeat.o(32350);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32350);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dps localdps = (dps)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32350);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cyx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cyx)localObject2).parseFrom((byte[])localObject1);
            }
            localdps.YNR = ((cyx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32350);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cyy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cyy)localObject2).parseFrom((byte[])localObject1);
            }
            localdps.YNS = ((cyy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32350);
          return 0;
        }
        localdps.aaWu = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(32350);
        return 0;
      }
      AppMethodBeat.o(32350);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dps
 * JD-Core Version:    0.7.0.1
 */