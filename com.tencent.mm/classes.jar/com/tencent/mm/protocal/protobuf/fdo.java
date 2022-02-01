package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fdo
  extends com.tencent.mm.bx.a
{
  public etl abCM;
  public long abDd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125769);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.abDd);
      if (this.abCM != null)
      {
        paramVarArgs.qD(2, this.abCM.computeSize());
        this.abCM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125769);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.abDd) + 0;
      paramInt = i;
      if (this.abCM != null) {
        paramInt = i + i.a.a.a.qC(2, this.abCM.computeSize());
      }
      AppMethodBeat.o(125769);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(125769);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fdo localfdo = (fdo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125769);
        return -1;
      case 1: 
        localfdo.abDd = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(125769);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        etl localetl = new etl();
        if ((localObject != null) && (localObject.length > 0)) {
          localetl.dh((byte[])localObject);
        }
        localfdo.abCM = localetl;
        paramInt += 1;
      }
      AppMethodBeat.o(125769);
      return 0;
    }
    AppMethodBeat.o(125769);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdo
 * JD-Core Version:    0.7.0.1
 */