package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arc
  extends com.tencent.mm.bx.a
{
  public long Zyt;
  public long Zyu;
  public LinkedList<fmw> Zyv;
  
  public arc()
  {
    AppMethodBeat.i(125722);
    this.Zyv = new LinkedList();
    AppMethodBeat.o(125722);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125723);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.Zyt);
      paramVarArgs.bv(2, this.Zyu);
      paramVarArgs.e(3, 8, this.Zyv);
      AppMethodBeat.o(125723);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.Zyt);
      i = i.a.a.b.b.a.q(2, this.Zyu);
      int j = i.a.a.a.c(3, 8, this.Zyv);
      AppMethodBeat.o(125723);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Zyv.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(125723);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      arc localarc = (arc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125723);
        return -1;
      case 1: 
        localarc.Zyt = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(125723);
        return 0;
      case 2: 
        localarc.Zyu = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(125723);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        fmw localfmw = new fmw();
        if ((localObject != null) && (localObject.length > 0)) {
          localfmw.parseFrom((byte[])localObject);
        }
        localarc.Zyv.add(localfmw);
        paramInt += 1;
      }
      AppMethodBeat.o(125723);
      return 0;
    }
    AppMethodBeat.o(125723);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arc
 * JD-Core Version:    0.7.0.1
 */