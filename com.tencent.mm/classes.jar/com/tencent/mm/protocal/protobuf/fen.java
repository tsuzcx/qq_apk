package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fen
  extends com.tencent.mm.bw.a
{
  public LinkedList<Integer> NnI;
  public fem NzO;
  public LinkedList<Integer> NzP;
  public int NzQ;
  public int NzR;
  
  public fen()
  {
    AppMethodBeat.i(153338);
    this.NzP = new LinkedList();
    this.NnI = new LinkedList();
    AppMethodBeat.o(153338);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153339);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NzO != null)
      {
        paramVarArgs.ni(1, this.NzO.computeSize());
        this.NzO.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 2, this.NzP);
      paramVarArgs.e(3, 2, this.NnI);
      paramVarArgs.aM(4, this.NzQ);
      paramVarArgs.aM(5, this.NzR);
      AppMethodBeat.o(153339);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NzO == null) {
        break label528;
      }
    }
    label528:
    for (paramInt = g.a.a.a.nh(1, this.NzO.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 2, this.NzP);
      int j = g.a.a.a.c(3, 2, this.NnI);
      int k = g.a.a.b.b.a.bu(4, this.NzQ);
      int m = g.a.a.b.b.a.bu(5, this.NzR);
      AppMethodBeat.o(153339);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.NzP.clear();
        this.NnI.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153339);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fen localfen = (fen)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153339);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fem();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((fem)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfen.NzO = ((fem)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153339);
          return 0;
        case 2: 
          localfen.NzP.add(Integer.valueOf(((g.a.a.a.a)localObject1).UbS.zi()));
          AppMethodBeat.o(153339);
          return 0;
        case 3: 
          localfen.NnI.add(Integer.valueOf(((g.a.a.a.a)localObject1).UbS.zi()));
          AppMethodBeat.o(153339);
          return 0;
        case 4: 
          localfen.NzQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153339);
          return 0;
        }
        localfen.NzR = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(153339);
        return 0;
      }
      AppMethodBeat.o(153339);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fen
 * JD-Core Version:    0.7.0.1
 */