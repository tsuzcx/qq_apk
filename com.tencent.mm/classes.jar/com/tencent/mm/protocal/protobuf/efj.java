package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class efj
  extends com.tencent.mm.bx.a
{
  public String abkK;
  public String abkL;
  public LinkedList<fmx> abkM;
  
  public efj()
  {
    AppMethodBeat.i(72550);
    this.abkM = new LinkedList();
    AppMethodBeat.o(72550);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72551);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abkK != null) {
        paramVarArgs.g(1, this.abkK);
      }
      if (this.abkL != null) {
        paramVarArgs.g(2, this.abkL);
      }
      paramVarArgs.e(3, 8, this.abkM);
      AppMethodBeat.o(72551);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abkK == null) {
        break label392;
      }
    }
    label392:
    for (paramInt = i.a.a.b.b.a.h(1, this.abkK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abkL != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abkL);
      }
      paramInt = i.a.a.a.c(3, 8, this.abkM);
      AppMethodBeat.o(72551);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abkM.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72551);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        efj localefj = (efj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72551);
          return -1;
        case 1: 
          localefj.abkK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72551);
          return 0;
        case 2: 
          localefj.abkL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72551);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fmx localfmx = new fmx();
          if ((localObject != null) && (localObject.length > 0)) {
            localfmx.parseFrom((byte[])localObject);
          }
          localefj.abkM.add(localfmx);
          paramInt += 1;
        }
        AppMethodBeat.o(72551);
        return 0;
      }
      AppMethodBeat.o(72551);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efj
 * JD-Core Version:    0.7.0.1
 */