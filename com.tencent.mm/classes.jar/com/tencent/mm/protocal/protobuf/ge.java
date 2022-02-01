package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ge
  extends com.tencent.mm.cd.a
{
  public int RLf;
  public int RLg;
  public int RLn;
  public gf RLo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32120);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RLf);
      paramVarArgs.aY(2, this.RLg);
      paramVarArgs.aY(3, this.RLn);
      if (this.RLo != null)
      {
        paramVarArgs.oE(4, this.RLo.computeSize());
        this.RLo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32120);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.RLf) + 0 + g.a.a.b.b.a.bM(2, this.RLg) + g.a.a.b.b.a.bM(3, this.RLn);
      paramInt = i;
      if (this.RLo != null) {
        paramInt = i + g.a.a.a.oD(4, this.RLo.computeSize());
      }
      AppMethodBeat.o(32120);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(32120);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      ge localge = (ge)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32120);
        return -1;
      case 1: 
        localge.RLf = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32120);
        return 0;
      case 2: 
        localge.RLg = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32120);
        return 0;
      case 3: 
        localge.RLn = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32120);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        gf localgf = new gf();
        if ((localObject != null) && (localObject.length > 0)) {
          localgf.parseFrom((byte[])localObject);
        }
        localge.RLo = localgf;
        paramInt += 1;
      }
      AppMethodBeat.o(32120);
      return 0;
    }
    AppMethodBeat.o(32120);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ge
 * JD-Core Version:    0.7.0.1
 */