package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bjt
  extends com.tencent.mm.cd.a
{
  public LinkedList<bjp> SIf;
  public LinkedList<bjr> STB;
  public LinkedList<Long> SUa;
  
  public bjt()
  {
    AppMethodBeat.i(203462);
    this.STB = new LinkedList();
    this.SIf = new LinkedList();
    this.SUa = new LinkedList();
    AppMethodBeat.o(203462);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203485);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.STB);
      paramVarArgs.e(2, 8, this.SIf);
      paramVarArgs.e(3, 3, this.SUa);
      AppMethodBeat.o(203485);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.STB);
      i = g.a.a.a.c(2, 8, this.SIf);
      int j = g.a.a.a.c(3, 3, this.SUa);
      AppMethodBeat.o(203485);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.STB.clear();
      this.SIf.clear();
      this.SUa.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(203485);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bjt localbjt = (bjt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(203485);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bjr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bjr)localObject2).parseFrom((byte[])localObject1);
          }
          localbjt.STB.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(203485);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bjp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bjp)localObject2).parseFrom((byte[])localObject1);
          }
          localbjt.SIf.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(203485);
        return 0;
      }
      localbjt.SUa.add(Long.valueOf(((g.a.a.a.a)localObject1).abFh.AN()));
      AppMethodBeat.o(203485);
      return 0;
    }
    AppMethodBeat.o(203485);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjt
 * JD-Core Version:    0.7.0.1
 */