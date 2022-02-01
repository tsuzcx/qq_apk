package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fvh
  extends com.tencent.mm.bx.a
{
  public LinkedList<fvi> abTE;
  public fvi abTF;
  
  public fvh()
  {
    AppMethodBeat.i(258737);
    this.abTE = new LinkedList();
    AppMethodBeat.o(258737);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258738);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.abTE);
      if (this.abTF != null)
      {
        paramVarArgs.qD(2, this.abTF.computeSize());
        this.abTF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258738);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.abTE) + 0;
      paramInt = i;
      if (this.abTF != null) {
        paramInt = i + i.a.a.a.qC(2, this.abTF.computeSize());
      }
      AppMethodBeat.o(258738);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abTE.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258738);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fvh localfvh = (fvh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      fvi localfvi;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258738);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localfvi = new fvi();
          if ((localObject != null) && (localObject.length > 0)) {
            localfvi.parseFrom((byte[])localObject);
          }
          localfvh.abTE.add(localfvi);
          paramInt += 1;
        }
        AppMethodBeat.o(258738);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localfvi = new fvi();
        if ((localObject != null) && (localObject.length > 0)) {
          localfvi.parseFrom((byte[])localObject);
        }
        localfvh.abTF = localfvi;
        paramInt += 1;
      }
      AppMethodBeat.o(258738);
      return 0;
    }
    AppMethodBeat.o(258738);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fvh
 * JD-Core Version:    0.7.0.1
 */