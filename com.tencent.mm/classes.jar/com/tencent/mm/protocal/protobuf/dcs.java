package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcs
  extends com.tencent.mm.cd.a
{
  public LinkedList<tz> SqO;
  public int SqP;
  public int SqQ;
  public long lastUpdateTime;
  public int version;
  
  public dcs()
  {
    AppMethodBeat.i(32357);
    this.SqO = new LinkedList();
    AppMethodBeat.o(32357);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32358);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.SqO);
      paramVarArgs.aY(2, this.version);
      paramVarArgs.aY(3, this.SqP);
      paramVarArgs.aY(4, this.SqQ);
      paramVarArgs.bm(5, this.lastUpdateTime);
      AppMethodBeat.o(32358);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.SqO);
      i = g.a.a.b.b.a.bM(2, this.version);
      int j = g.a.a.b.b.a.bM(3, this.SqP);
      int k = g.a.a.b.b.a.bM(4, this.SqQ);
      int m = g.a.a.b.b.a.p(5, this.lastUpdateTime);
      AppMethodBeat.o(32358);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SqO.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(32358);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dcs localdcs = (dcs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32358);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          tz localtz = new tz();
          if ((localObject != null) && (localObject.length > 0)) {
            localtz.parseFrom((byte[])localObject);
          }
          localdcs.SqO.add(localtz);
          paramInt += 1;
        }
        AppMethodBeat.o(32358);
        return 0;
      case 2: 
        localdcs.version = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32358);
        return 0;
      case 3: 
        localdcs.SqP = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32358);
        return 0;
      case 4: 
        localdcs.SqQ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32358);
        return 0;
      }
      localdcs.lastUpdateTime = ((g.a.a.a.a)localObject).abFh.AN();
      AppMethodBeat.o(32358);
      return 0;
    }
    AppMethodBeat.o(32358);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcs
 * JD-Core Version:    0.7.0.1
 */