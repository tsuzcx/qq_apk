package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dyx
  extends com.tencent.mm.cd.a
{
  public LinkedList<dyv> UeH;
  public int rWu;
  
  public dyx()
  {
    AppMethodBeat.i(152675);
    this.UeH = new LinkedList();
    AppMethodBeat.o(152675);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152676);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.rWu);
      paramVarArgs.e(2, 8, this.UeH);
      AppMethodBeat.o(152676);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.rWu);
      i = g.a.a.a.c(2, 8, this.UeH);
      AppMethodBeat.o(152676);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UeH.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(152676);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dyx localdyx = (dyx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152676);
        return -1;
      case 1: 
        localdyx.rWu = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(152676);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        dyv localdyv = new dyv();
        if ((localObject != null) && (localObject.length > 0)) {
          localdyv.parseFrom((byte[])localObject);
        }
        localdyx.UeH.add(localdyv);
        paramInt += 1;
      }
      AppMethodBeat.o(152676);
      return 0;
    }
    AppMethodBeat.o(152676);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyx
 * JD-Core Version:    0.7.0.1
 */