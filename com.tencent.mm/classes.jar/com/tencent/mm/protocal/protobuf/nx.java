package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nx
  extends com.tencent.mm.cd.a
{
  public LinkedList<fhh> RUY;
  public LinkedList<String> RVa;
  public String RVb;
  public String RVc;
  
  public nx()
  {
    AppMethodBeat.i(205989);
    this.RUY = new LinkedList();
    this.RVa = new LinkedList();
    AppMethodBeat.o(205989);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205990);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(15, 8, this.RUY);
      paramVarArgs.e(17, 1, this.RVa);
      if (this.RVb != null) {
        paramVarArgs.f(18, this.RVb);
      }
      if (this.RVc != null) {
        paramVarArgs.f(19, this.RVc);
      }
      AppMethodBeat.o(205990);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(15, 8, this.RUY) + 0 + g.a.a.a.c(17, 1, this.RVa);
      paramInt = i;
      if (this.RVb != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.RVb);
      }
      i = paramInt;
      if (this.RVc != null) {
        i = paramInt + g.a.a.b.b.a.g(19, this.RVc);
      }
      AppMethodBeat.o(205990);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RUY.clear();
      this.RVa.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(205990);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      nx localnx = (nx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 16: 
      default: 
        AppMethodBeat.o(205990);
        return -1;
      case 15: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fhh localfhh = new fhh();
          if ((localObject != null) && (localObject.length > 0)) {
            localfhh.parseFrom((byte[])localObject);
          }
          localnx.RUY.add(localfhh);
          paramInt += 1;
        }
        AppMethodBeat.o(205990);
        return 0;
      case 17: 
        localnx.RVa.add(((g.a.a.a.a)localObject).abFh.readString());
        AppMethodBeat.o(205990);
        return 0;
      case 18: 
        localnx.RVb = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(205990);
        return 0;
      }
      localnx.RVc = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(205990);
      return 0;
    }
    AppMethodBeat.o(205990);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nx
 * JD-Core Version:    0.7.0.1
 */