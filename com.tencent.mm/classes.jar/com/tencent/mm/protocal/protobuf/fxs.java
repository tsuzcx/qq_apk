package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fxs
  extends com.tencent.mm.bx.a
{
  public fmi ZHT;
  public int abVu;
  public String abVv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257844);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZHT != null)
      {
        paramVarArgs.qD(1, this.ZHT.computeSize());
        this.ZHT.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.abVu);
      if (this.abVv != null) {
        paramVarArgs.g(3, this.abVv);
      }
      AppMethodBeat.o(257844);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZHT == null) {
        break label388;
      }
    }
    label388:
    for (paramInt = i.a.a.a.qC(1, this.ZHT.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abVu);
      paramInt = i;
      if (this.abVv != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.abVv);
      }
      AppMethodBeat.o(257844);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257844);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fxs localfxs = (fxs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257844);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fmi localfmi = new fmi();
            if ((localObject != null) && (localObject.length > 0)) {
              localfmi.parseFrom((byte[])localObject);
            }
            localfxs.ZHT = localfmi;
            paramInt += 1;
          }
          AppMethodBeat.o(257844);
          return 0;
        case 2: 
          localfxs.abVu = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257844);
          return 0;
        }
        localfxs.abVv = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257844);
        return 0;
      }
      AppMethodBeat.o(257844);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fxs
 * JD-Core Version:    0.7.0.1
 */