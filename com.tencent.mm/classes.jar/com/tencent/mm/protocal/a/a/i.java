package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public class i
  extends com.tencent.mm.cd.a
{
  public int RCF;
  public int RCH;
  public LinkedList<e> RCI;
  public b RCJ;
  public int RCr;
  
  public i()
  {
    AppMethodBeat.i(143950);
    this.RCI = new LinkedList();
    AppMethodBeat.o(143950);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143951);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RCr);
      paramVarArgs.aY(2, this.RCH);
      paramVarArgs.aY(3, this.RCF);
      paramVarArgs.e(4, 8, this.RCI);
      if (this.RCJ != null) {
        paramVarArgs.c(5, this.RCJ);
      }
      AppMethodBeat.o(143951);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.RCr) + 0 + g.a.a.b.b.a.bM(2, this.RCH) + g.a.a.b.b.a.bM(3, this.RCF) + g.a.a.a.c(4, 8, this.RCI);
      paramInt = i;
      if (this.RCJ != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.RCJ);
      }
      AppMethodBeat.o(143951);
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
      AppMethodBeat.o(143951);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      i locali = (i)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143951);
        return -1;
      case 1: 
        locali.RCr = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143951);
        return 0;
      case 2: 
        locali.RCH = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143951);
        return 0;
      case 3: 
        locali.RCF = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143951);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          e locale = new e();
          if ((localObject != null) && (localObject.length > 0)) {
            locale.parseFrom((byte[])localObject);
          }
          locali.RCI.add(locale);
          paramInt += 1;
        }
        AppMethodBeat.o(143951);
        return 0;
      }
      locali.RCJ = ((g.a.a.a.a)localObject).abFh.iUw();
      AppMethodBeat.o(143951);
      return 0;
    }
    AppMethodBeat.o(143951);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.i
 * JD-Core Version:    0.7.0.1
 */