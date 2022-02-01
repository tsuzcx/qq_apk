package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fod
  extends com.tencent.mm.cd.a
{
  public LinkedList<epz> RQb;
  public int UMr;
  
  public fod()
  {
    AppMethodBeat.i(153322);
    this.RQb = new LinkedList();
    AppMethodBeat.o(153322);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153323);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.RQb);
      paramVarArgs.aY(2, this.UMr);
      AppMethodBeat.o(153323);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.RQb);
      i = g.a.a.b.b.a.bM(2, this.UMr);
      AppMethodBeat.o(153323);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RQb.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(153323);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      fod localfod = (fod)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(153323);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          epz localepz = new epz();
          if ((localObject != null) && (localObject.length > 0)) {
            localepz.parseFrom((byte[])localObject);
          }
          localfod.RQb.add(localepz);
          paramInt += 1;
        }
        AppMethodBeat.o(153323);
        return 0;
      }
      localfod.UMr = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(153323);
      return 0;
    }
    AppMethodBeat.o(153323);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fod
 * JD-Core Version:    0.7.0.1
 */