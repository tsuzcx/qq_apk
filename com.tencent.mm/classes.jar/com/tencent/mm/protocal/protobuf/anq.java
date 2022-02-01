package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class anq
  extends com.tencent.mm.cd.a
{
  public LinkedList<cyl> SAl;
  public LinkedList<cyi> wHJ;
  
  public anq()
  {
    AppMethodBeat.i(127461);
    this.wHJ = new LinkedList();
    this.SAl = new LinkedList();
    AppMethodBeat.o(127461);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127462);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.wHJ);
      paramVarArgs.e(2, 8, this.SAl);
      AppMethodBeat.o(127462);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.wHJ);
      i = g.a.a.a.c(2, 8, this.SAl);
      AppMethodBeat.o(127462);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wHJ.clear();
      this.SAl.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(127462);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      anq localanq = (anq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127462);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cyi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cyi)localObject2).parseFrom((byte[])localObject1);
          }
          localanq.wHJ.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(127462);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new cyl();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((cyl)localObject2).parseFrom((byte[])localObject1);
        }
        localanq.SAl.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(127462);
      return 0;
    }
    AppMethodBeat.o(127462);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anq
 * JD-Core Version:    0.7.0.1
 */