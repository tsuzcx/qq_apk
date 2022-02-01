package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dyw
  extends com.tencent.mm.cd.a
{
  public LinkedList<dyr> UeG;
  public int rWu;
  
  public dyw()
  {
    AppMethodBeat.i(152673);
    this.UeG = new LinkedList();
    AppMethodBeat.o(152673);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152674);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.rWu);
      paramVarArgs.e(2, 8, this.UeG);
      AppMethodBeat.o(152674);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.rWu);
      i = g.a.a.a.c(2, 8, this.UeG);
      AppMethodBeat.o(152674);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UeG.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(152674);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dyw localdyw = (dyw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152674);
        return -1;
      case 1: 
        localdyw.rWu = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(152674);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        dyr localdyr = new dyr();
        if ((localObject != null) && (localObject.length > 0)) {
          localdyr.parseFrom((byte[])localObject);
        }
        localdyw.UeG.add(localdyr);
        paramInt += 1;
      }
      AppMethodBeat.o(152674);
      return 0;
    }
    AppMethodBeat.o(152674);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyw
 * JD-Core Version:    0.7.0.1
 */