package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzm
  extends com.tencent.mm.bx.a
{
  public enx Zqq;
  public int nxO;
  public int nxP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257391);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zqq != null)
      {
        paramVarArgs.qD(1, this.Zqq.computeSize());
        this.Zqq.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.nxO);
      paramVarArgs.bS(3, this.nxP);
      AppMethodBeat.o(257391);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Zqq == null) {
        break label376;
      }
    }
    label376:
    for (paramInt = i.a.a.a.qC(1, this.Zqq.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.nxO);
      int j = i.a.a.b.b.a.cJ(3, this.nxP);
      AppMethodBeat.o(257391);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257391);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dzm localdzm = (dzm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257391);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            enx localenx = new enx();
            if ((localObject != null) && (localObject.length > 0)) {
              localenx.parseFrom((byte[])localObject);
            }
            localdzm.Zqq = localenx;
            paramInt += 1;
          }
          AppMethodBeat.o(257391);
          return 0;
        case 2: 
          localdzm.nxO = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257391);
          return 0;
        }
        localdzm.nxP = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257391);
        return 0;
      }
      AppMethodBeat.o(257391);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzm
 * JD-Core Version:    0.7.0.1
 */