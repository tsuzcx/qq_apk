package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class gjk
  extends com.tencent.mm.bx.a
{
  public LinkedList<fhv> acfE;
  public b acfF;
  
  public gjk()
  {
    AppMethodBeat.i(32568);
    this.acfE = new LinkedList();
    AppMethodBeat.o(32568);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32569);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.acfE);
      if (this.acfF != null) {
        paramVarArgs.d(2, this.acfF);
      }
      AppMethodBeat.o(32569);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.acfE) + 0;
      paramInt = i;
      if (this.acfF != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.acfF);
      }
      AppMethodBeat.o(32569);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.acfE.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(32569);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      gjk localgjk = (gjk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32569);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fhv localfhv = new fhv();
          if ((localObject != null) && (localObject.length > 0)) {
            localfhv.parseFrom((byte[])localObject);
          }
          localgjk.acfE.add(localfhv);
          paramInt += 1;
        }
        AppMethodBeat.o(32569);
        return 0;
      }
      localgjk.acfF = ((i.a.a.a.a)localObject).ajGk.kFX();
      AppMethodBeat.o(32569);
      return 0;
    }
    AppMethodBeat.o(32569);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gjk
 * JD-Core Version:    0.7.0.1
 */