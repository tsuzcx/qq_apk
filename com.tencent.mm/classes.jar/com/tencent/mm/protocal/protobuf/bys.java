package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bys
  extends com.tencent.mm.cd.a
{
  public int ThN;
  public LinkedList<byr> ThO;
  
  public bys()
  {
    AppMethodBeat.i(115840);
    this.ThO = new LinkedList();
    AppMethodBeat.o(115840);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115841);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.ThN);
      paramVarArgs.e(2, 8, this.ThO);
      AppMethodBeat.o(115841);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.ThN);
      i = g.a.a.a.c(2, 8, this.ThO);
      AppMethodBeat.o(115841);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ThO.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(115841);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      bys localbys = (bys)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115841);
        return -1;
      case 1: 
        localbys.ThN = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(115841);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        byr localbyr = new byr();
        if ((localObject != null) && (localObject.length > 0)) {
          localbyr.parseFrom((byte[])localObject);
        }
        localbys.ThO.add(localbyr);
        paramInt += 1;
      }
      AppMethodBeat.o(115841);
      return 0;
    }
    AppMethodBeat.o(115841);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bys
 * JD-Core Version:    0.7.0.1
 */