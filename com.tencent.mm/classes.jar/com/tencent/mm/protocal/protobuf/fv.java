package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fv
  extends com.tencent.mm.bx.a
{
  public LinkedList<fy> YCW;
  public int type;
  
  public fv()
  {
    AppMethodBeat.i(103180);
    this.YCW = new LinkedList();
    AppMethodBeat.o(103180);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103181);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      paramVarArgs.e(2, 8, this.YCW);
      AppMethodBeat.o(103181);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.type);
      i = i.a.a.a.c(2, 8, this.YCW);
      AppMethodBeat.o(103181);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YCW.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(103181);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fv localfv = (fv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(103181);
        return -1;
      case 1: 
        localfv.type = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(103181);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        fy localfy = new fy();
        if ((localObject != null) && (localObject.length > 0)) {
          localfy.parseFrom((byte[])localObject);
        }
        localfv.YCW.add(localfy);
        paramInt += 1;
      }
      AppMethodBeat.o(103181);
      return 0;
    }
    AppMethodBeat.o(103181);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fv
 * JD-Core Version:    0.7.0.1
 */