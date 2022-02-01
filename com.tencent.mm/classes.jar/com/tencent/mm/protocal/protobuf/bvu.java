package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvu
  extends com.tencent.mm.cd.a
{
  public int CqV;
  public String HlB;
  public ciu RPX;
  public int Tfy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82415);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.CqV);
      if (this.RPX != null)
      {
        paramVarArgs.oE(2, this.RPX.computeSize());
        this.RPX.writeFields(paramVarArgs);
      }
      if (this.HlB != null) {
        paramVarArgs.f(3, this.HlB);
      }
      paramVarArgs.aY(4, this.Tfy);
      AppMethodBeat.o(82415);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.CqV) + 0;
      paramInt = i;
      if (this.RPX != null) {
        paramInt = i + g.a.a.a.oD(2, this.RPX.computeSize());
      }
      i = paramInt;
      if (this.HlB != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.HlB);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.Tfy);
      AppMethodBeat.o(82415);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(82415);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      bvu localbvu = (bvu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(82415);
        return -1;
      case 1: 
        localbvu.CqV = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(82415);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ciu localciu = new ciu();
          if ((localObject != null) && (localObject.length > 0)) {
            localciu.parseFrom((byte[])localObject);
          }
          localbvu.RPX = localciu;
          paramInt += 1;
        }
        AppMethodBeat.o(82415);
        return 0;
      case 3: 
        localbvu.HlB = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(82415);
        return 0;
      }
      localbvu.Tfy = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(82415);
      return 0;
    }
    AppMethodBeat.o(82415);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvu
 * JD-Core Version:    0.7.0.1
 */