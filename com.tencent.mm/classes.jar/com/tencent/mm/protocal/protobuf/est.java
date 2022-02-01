package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class est
  extends com.tencent.mm.cd.a
{
  public int Rna;
  public int UuA;
  public LinkedList<esy> UuB;
  public boolean UuC;
  public int Uux;
  public String Uuy;
  public int Uuz;
  public boolean fxt;
  
  public est()
  {
    AppMethodBeat.i(153003);
    this.UuB = new LinkedList();
    AppMethodBeat.o(153003);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153004);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Uux);
      if (this.Uuy != null) {
        paramVarArgs.f(2, this.Uuy);
      }
      paramVarArgs.aY(3, this.Rna);
      paramVarArgs.aY(4, this.Uuz);
      paramVarArgs.aY(5, this.UuA);
      paramVarArgs.e(6, 8, this.UuB);
      paramVarArgs.co(7, this.UuC);
      paramVarArgs.co(8, this.fxt);
      AppMethodBeat.o(153004);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.Uux) + 0;
      paramInt = i;
      if (this.Uuy != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Uuy);
      }
      i = g.a.a.b.b.a.bM(3, this.Rna);
      int j = g.a.a.b.b.a.bM(4, this.Uuz);
      int k = g.a.a.b.b.a.bM(5, this.UuA);
      int m = g.a.a.a.c(6, 8, this.UuB);
      int n = g.a.a.b.b.a.gL(7);
      int i1 = g.a.a.b.b.a.gL(8);
      AppMethodBeat.o(153004);
      return paramInt + i + j + k + m + (n + 1) + (i1 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UuB.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(153004);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      est localest = (est)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(153004);
        return -1;
      case 1: 
        localest.Uux = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(153004);
        return 0;
      case 2: 
        localest.Uuy = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(153004);
        return 0;
      case 3: 
        localest.Rna = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(153004);
        return 0;
      case 4: 
        localest.Uuz = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(153004);
        return 0;
      case 5: 
        localest.UuA = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(153004);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          esy localesy = new esy();
          if ((localObject != null) && (localObject.length > 0)) {
            localesy.parseFrom((byte[])localObject);
          }
          localest.UuB.add(localesy);
          paramInt += 1;
        }
        AppMethodBeat.o(153004);
        return 0;
      case 7: 
        localest.UuC = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(153004);
        return 0;
      }
      localest.fxt = ((g.a.a.a.a)localObject).abFh.AB();
      AppMethodBeat.o(153004);
      return 0;
    }
    AppMethodBeat.o(153004);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.est
 * JD-Core Version:    0.7.0.1
 */