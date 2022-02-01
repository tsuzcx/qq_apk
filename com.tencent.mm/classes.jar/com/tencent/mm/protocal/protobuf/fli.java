package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fli
  extends com.tencent.mm.bx.a
{
  public String Zxo;
  public asr abLJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124562);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zxo != null) {
        paramVarArgs.g(1, this.Zxo);
      }
      if (this.abLJ != null)
      {
        paramVarArgs.qD(2, this.abLJ.computeSize());
        this.abLJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Zxo == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.b.b.a.h(1, this.Zxo) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abLJ != null) {
        i = paramInt + i.a.a.a.qC(2, this.abLJ.computeSize());
      }
      AppMethodBeat.o(124562);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124562);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fli localfli = (fli)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124562);
          return -1;
        case 1: 
          localfli.Zxo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124562);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          asr localasr = new asr();
          if ((localObject != null) && (localObject.length > 0)) {
            localasr.parseFrom((byte[])localObject);
          }
          localfli.abLJ = localasr;
          paramInt += 1;
        }
        AppMethodBeat.o(124562);
        return 0;
      }
      AppMethodBeat.o(124562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fli
 * JD-Core Version:    0.7.0.1
 */