package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eyn
  extends com.tencent.mm.bx.a
{
  public dbi abzR;
  public long abzS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110910);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abzR != null)
      {
        paramVarArgs.qD(1, this.abzR.computeSize());
        this.abzR.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.abzS);
      AppMethodBeat.o(110910);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abzR == null) {
        break label328;
      }
    }
    label328:
    for (paramInt = i.a.a.a.qC(1, this.abzR.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.abzS);
      AppMethodBeat.o(110910);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(110910);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eyn localeyn = (eyn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110910);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dbi localdbi = new dbi();
            if ((localObject != null) && (localObject.length > 0)) {
              localdbi.parseFrom((byte[])localObject);
            }
            localeyn.abzR = localdbi;
            paramInt += 1;
          }
          AppMethodBeat.o(110910);
          return 0;
        }
        localeyn.abzS = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(110910);
        return 0;
      }
      AppMethodBeat.o(110910);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyn
 * JD-Core Version:    0.7.0.1
 */