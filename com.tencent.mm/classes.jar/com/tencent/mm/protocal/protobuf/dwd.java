package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwd
  extends com.tencent.mm.cd.a
{
  public int Ucd;
  public LinkedList<dwc> Uce;
  
  public dwd()
  {
    AppMethodBeat.i(115849);
    this.Uce = new LinkedList();
    AppMethodBeat.o(115849);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115850);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Ucd);
      paramVarArgs.e(2, 8, this.Uce);
      AppMethodBeat.o(115850);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.Ucd);
      i = g.a.a.a.c(2, 8, this.Uce);
      AppMethodBeat.o(115850);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Uce.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(115850);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dwd localdwd = (dwd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115850);
        return -1;
      case 1: 
        localdwd.Ucd = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(115850);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        dwc localdwc = new dwc();
        if ((localObject != null) && (localObject.length > 0)) {
          localdwc.parseFrom((byte[])localObject);
        }
        localdwd.Uce.add(localdwc);
        paramInt += 1;
      }
      AppMethodBeat.o(115850);
      return 0;
    }
    AppMethodBeat.o(115850);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwd
 * JD-Core Version:    0.7.0.1
 */