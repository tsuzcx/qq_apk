package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acp
  extends com.tencent.mm.cd.a
{
  public String RYK;
  public String Soj;
  public long Sok;
  public int Sol;
  public int Som;
  public LinkedList<acr> Son;
  
  public acp()
  {
    AppMethodBeat.i(198204);
    this.Son = new LinkedList();
    AppMethodBeat.o(198204);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198218);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Soj != null) {
        paramVarArgs.f(1, this.Soj);
      }
      if (this.RYK != null) {
        paramVarArgs.f(2, this.RYK);
      }
      paramVarArgs.bm(3, this.Sok);
      paramVarArgs.aY(4, this.Sol);
      paramVarArgs.aY(5, this.Som);
      paramVarArgs.e(6, 8, this.Son);
      AppMethodBeat.o(198218);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Soj == null) {
        break label536;
      }
    }
    label536:
    for (paramInt = g.a.a.b.b.a.g(1, this.Soj) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RYK != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.RYK);
      }
      paramInt = g.a.a.b.b.a.p(3, this.Sok);
      int j = g.a.a.b.b.a.bM(4, this.Sol);
      int k = g.a.a.b.b.a.bM(5, this.Som);
      int m = g.a.a.a.c(6, 8, this.Son);
      AppMethodBeat.o(198218);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Son.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(198218);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        acp localacp = (acp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(198218);
          return -1;
        case 1: 
          localacp.Soj = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(198218);
          return 0;
        case 2: 
          localacp.RYK = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(198218);
          return 0;
        case 3: 
          localacp.Sok = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(198218);
          return 0;
        case 4: 
          localacp.Sol = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(198218);
          return 0;
        case 5: 
          localacp.Som = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(198218);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          acr localacr = new acr();
          if ((localObject != null) && (localObject.length > 0)) {
            localacr.parseFrom((byte[])localObject);
          }
          localacp.Son.add(localacr);
          paramInt += 1;
        }
        AppMethodBeat.o(198218);
        return 0;
      }
      AppMethodBeat.o(198218);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acp
 * JD-Core Version:    0.7.0.1
 */