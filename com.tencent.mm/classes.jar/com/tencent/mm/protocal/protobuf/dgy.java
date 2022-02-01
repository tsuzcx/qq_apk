package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class dgy
  extends com.tencent.mm.cd.a
{
  public LinkedList<Integer> SZW;
  public LinkedList<dgv> TNF;
  public int rVx;
  
  public dgy()
  {
    AppMethodBeat.i(43120);
    this.SZW = new LinkedList();
    this.TNF = new LinkedList();
    AppMethodBeat.o(43120);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43121);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.rVx);
      paramVarArgs.f(2, 2, this.SZW);
      paramVarArgs.e(3, 8, this.TNF);
      AppMethodBeat.o(43121);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.rVx);
      i = g.a.a.a.d(2, 2, this.SZW);
      int j = g.a.a.a.c(3, 8, this.TNF);
      AppMethodBeat.o(43121);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SZW.clear();
      this.TNF.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(43121);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dgy localdgy = (dgy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43121);
        return -1;
      case 1: 
        localdgy.rVx = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(43121);
        return 0;
      case 2: 
        localdgy.SZW = new g.a.a.a.a(((g.a.a.a.a)localObject).abFh.iUw().UH, unknownTagHandler).abFh.iUu();
        AppMethodBeat.o(43121);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        dgv localdgv = new dgv();
        if ((localObject != null) && (localObject.length > 0)) {
          localdgv.parseFrom((byte[])localObject);
        }
        localdgy.TNF.add(localdgv);
        paramInt += 1;
      }
      AppMethodBeat.o(43121);
      return 0;
    }
    AppMethodBeat.o(43121);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgy
 * JD-Core Version:    0.7.0.1
 */