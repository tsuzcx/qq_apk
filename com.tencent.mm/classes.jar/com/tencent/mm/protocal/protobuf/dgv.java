package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgv
  extends com.tencent.mm.bw.a
{
  public int MLl;
  public boolean MLm;
  public String MLn;
  public int MLo;
  public int MLp;
  public LinkedList<dgu> MLq;
  public String eaO;
  
  public dgv()
  {
    AppMethodBeat.i(114057);
    this.MLq = new LinkedList();
    AppMethodBeat.o(114057);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114058);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.eaO != null) {
        paramVarArgs.e(1, this.eaO);
      }
      paramVarArgs.aM(2, this.MLl);
      paramVarArgs.cc(3, this.MLm);
      if (this.MLn != null) {
        paramVarArgs.e(4, this.MLn);
      }
      paramVarArgs.aM(5, this.MLo);
      paramVarArgs.aM(6, this.MLp);
      paramVarArgs.e(7, 8, this.MLq);
      AppMethodBeat.o(114058);
      return 0;
    }
    if (paramInt == 1) {
      if (this.eaO == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = g.a.a.b.b.a.f(1, this.eaO) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MLl) + (g.a.a.b.b.a.fS(3) + 1);
      paramInt = i;
      if (this.MLn != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MLn);
      }
      i = g.a.a.b.b.a.bu(5, this.MLo);
      int j = g.a.a.b.b.a.bu(6, this.MLp);
      int k = g.a.a.a.c(7, 8, this.MLq);
      AppMethodBeat.o(114058);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MLq.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(114058);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dgv localdgv = (dgv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114058);
          return -1;
        case 1: 
          localdgv.eaO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114058);
          return 0;
        case 2: 
          localdgv.MLl = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114058);
          return 0;
        case 3: 
          localdgv.MLm = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(114058);
          return 0;
        case 4: 
          localdgv.MLn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114058);
          return 0;
        case 5: 
          localdgv.MLo = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114058);
          return 0;
        case 6: 
          localdgv.MLp = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114058);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dgu();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dgu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdgv.MLq.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114058);
        return 0;
      }
      AppMethodBeat.o(114058);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgv
 * JD-Core Version:    0.7.0.1
 */