package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fcy
  extends com.tencent.mm.bx.a
{
  public fhd abCn;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258938);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abCn != null)
      {
        paramVarArgs.qD(1, this.abCn.computeSize());
        this.abCn.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.state);
      AppMethodBeat.o(258938);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abCn == null) {
        break label328;
      }
    }
    label328:
    for (paramInt = i.a.a.a.qC(1, this.abCn.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.state);
      AppMethodBeat.o(258938);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258938);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fcy localfcy = (fcy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258938);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fhd localfhd = new fhd();
            if ((localObject != null) && (localObject.length > 0)) {
              localfhd.parseFrom((byte[])localObject);
            }
            localfcy.abCn = localfhd;
            paramInt += 1;
          }
          AppMethodBeat.o(258938);
          return 0;
        }
        localfcy.state = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258938);
        return 0;
      }
      AppMethodBeat.o(258938);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcy
 * JD-Core Version:    0.7.0.1
 */