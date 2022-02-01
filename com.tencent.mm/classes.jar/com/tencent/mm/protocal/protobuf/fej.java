package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fej
  extends com.tencent.mm.cd.a
{
  public long UDX;
  public LinkedList<fem> UDY;
  
  public fej()
  {
    AppMethodBeat.i(115890);
    this.UDY = new LinkedList();
    AppMethodBeat.o(115890);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115891);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.UDX);
      paramVarArgs.e(2, 8, this.UDY);
      AppMethodBeat.o(115891);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.UDX);
      i = g.a.a.a.c(2, 8, this.UDY);
      AppMethodBeat.o(115891);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UDY.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(115891);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      fej localfej = (fej)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115891);
        return -1;
      case 1: 
        localfej.UDX = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(115891);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        fem localfem = new fem();
        if ((localObject != null) && (localObject.length > 0)) {
          localfem.parseFrom((byte[])localObject);
        }
        localfej.UDY.add(localfem);
        paramInt += 1;
      }
      AppMethodBeat.o(115891);
      return 0;
    }
    AppMethodBeat.o(115891);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fej
 * JD-Core Version:    0.7.0.1
 */