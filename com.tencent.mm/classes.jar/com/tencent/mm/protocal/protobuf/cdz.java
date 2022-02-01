package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdz
  extends com.tencent.mm.bx.a
{
  public edi aaoe;
  public LinkedList<edi> aaof;
  
  public cdz()
  {
    AppMethodBeat.i(123570);
    this.aaof = new LinkedList();
    AppMethodBeat.o(123570);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123571);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaoe != null)
      {
        paramVarArgs.qD(1, this.aaoe.computeSize());
        this.aaoe.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.aaof);
      AppMethodBeat.o(123571);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaoe == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = i.a.a.a.qC(1, this.aaoe.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.aaof);
      AppMethodBeat.o(123571);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaof.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123571);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cdz localcdz = (cdz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        edi localedi;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123571);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localedi = new edi();
            if ((localObject != null) && (localObject.length > 0)) {
              localedi.parseFrom((byte[])localObject);
            }
            localcdz.aaoe = localedi;
            paramInt += 1;
          }
          AppMethodBeat.o(123571);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localedi = new edi();
          if ((localObject != null) && (localObject.length > 0)) {
            localedi.parseFrom((byte[])localObject);
          }
          localcdz.aaof.add(localedi);
          paramInt += 1;
        }
        AppMethodBeat.o(123571);
        return 0;
      }
      AppMethodBeat.o(123571);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdz
 * JD-Core Version:    0.7.0.1
 */