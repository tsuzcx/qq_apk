package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class g
  extends com.tencent.mm.cd.a
{
  public int RCH;
  public LinkedList<b> RCI;
  public com.tencent.mm.cd.b RCJ;
  public int RCr;
  
  public g()
  {
    AppMethodBeat.i(143947);
    this.RCI = new LinkedList();
    AppMethodBeat.o(143947);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143948);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RCr);
      paramVarArgs.aY(2, this.RCH);
      paramVarArgs.e(3, 8, this.RCI);
      if (this.RCJ != null) {
        paramVarArgs.c(4, this.RCJ);
      }
      AppMethodBeat.o(143948);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.RCr) + 0 + g.a.a.b.b.a.bM(2, this.RCH) + g.a.a.a.c(3, 8, this.RCI);
      paramInt = i;
      if (this.RCJ != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.RCJ);
      }
      AppMethodBeat.o(143948);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RCI.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(143948);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      g localg = (g)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143948);
        return -1;
      case 1: 
        localg.RCr = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143948);
        return 0;
      case 2: 
        localg.RCH = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143948);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          b localb = new b();
          if ((localObject != null) && (localObject.length > 0)) {
            localb.parseFrom((byte[])localObject);
          }
          localg.RCI.add(localb);
          paramInt += 1;
        }
        AppMethodBeat.o(143948);
        return 0;
      }
      localg.RCJ = ((g.a.a.a.a)localObject).abFh.iUw();
      AppMethodBeat.o(143948);
      return 0;
    }
    AppMethodBeat.o(143948);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.g
 * JD-Core Version:    0.7.0.1
 */