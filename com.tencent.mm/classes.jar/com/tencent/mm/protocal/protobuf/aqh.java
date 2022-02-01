package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class aqh
  extends com.tencent.mm.cd.a
{
  public LinkedList<ol> SDE;
  public LinkedList<bel> SDF;
  
  public aqh()
  {
    AppMethodBeat.i(202490);
    this.SDE = new LinkedList();
    this.SDF = new LinkedList();
    AppMethodBeat.o(202490);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202513);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.SDE);
      paramVarArgs.e(2, 8, this.SDF);
      AppMethodBeat.o(202513);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.SDE);
      i = g.a.a.a.c(2, 8, this.SDF);
      AppMethodBeat.o(202513);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SDE.clear();
      this.SDF.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(202513);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      aqh localaqh = (aqh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(202513);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ol)localObject2).parseFrom((byte[])localObject1);
          }
          localaqh.SDE.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(202513);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new bel();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((bel)localObject2).parseFrom((byte[])localObject1);
        }
        localaqh.SDF.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(202513);
      return 0;
    }
    AppMethodBeat.o(202513);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqh
 * JD-Core Version:    0.7.0.1
 */