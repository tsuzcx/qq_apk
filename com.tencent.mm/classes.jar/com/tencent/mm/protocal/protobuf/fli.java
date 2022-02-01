package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fli
  extends com.tencent.mm.cd.a
{
  public long UKg;
  public qn UKh;
  public int UKi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117950);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.UKg);
      if (this.UKh != null)
      {
        paramVarArgs.oE(2, this.UKh.computeSize());
        this.UKh.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.UKi);
      AppMethodBeat.o(117950);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.UKg) + 0;
      paramInt = i;
      if (this.UKh != null) {
        paramInt = i + g.a.a.a.oD(2, this.UKh.computeSize());
      }
      i = g.a.a.b.b.a.bM(3, this.UKi);
      AppMethodBeat.o(117950);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(117950);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      fli localfli = (fli)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117950);
        return -1;
      case 1: 
        localfli.UKg = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(117950);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          qn localqn = new qn();
          if ((localObject != null) && (localObject.length > 0)) {
            localqn.parseFrom((byte[])localObject);
          }
          localfli.UKh = localqn;
          paramInt += 1;
        }
        AppMethodBeat.o(117950);
        return 0;
      }
      localfli.UKi = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(117950);
      return 0;
    }
    AppMethodBeat.o(117950);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fli
 * JD-Core Version:    0.7.0.1
 */