package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class abt
  extends com.tencent.mm.cd.a
{
  public int RYy;
  public b SnE;
  public dku SnF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91422);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RYy);
      if (this.SnE != null) {
        paramVarArgs.c(2, this.SnE);
      }
      if (this.SnF != null)
      {
        paramVarArgs.oE(3, this.SnF.computeSize());
        this.SnF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91422);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.RYy) + 0;
      paramInt = i;
      if (this.SnE != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.SnE);
      }
      i = paramInt;
      if (this.SnF != null) {
        i = paramInt + g.a.a.a.oD(3, this.SnF.computeSize());
      }
      AppMethodBeat.o(91422);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91422);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      abt localabt = (abt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91422);
        return -1;
      case 1: 
        localabt.RYy = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91422);
        return 0;
      case 2: 
        localabt.SnE = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(91422);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        dku localdku = new dku();
        if ((localObject != null) && (localObject.length > 0)) {
          localdku.parseFrom((byte[])localObject);
        }
        localabt.SnF = localdku;
        paramInt += 1;
      }
      AppMethodBeat.o(91422);
      return 0;
    }
    AppMethodBeat.o(91422);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abt
 * JD-Core Version:    0.7.0.1
 */