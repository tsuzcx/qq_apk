package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ert
  extends com.tencent.mm.bw.a
{
  public String LmK;
  public long Lnw;
  public String NoW;
  public String NoX;
  public String Npj;
  public b Npk;
  public LinkedList<esc> Npl;
  
  public ert()
  {
    AppMethodBeat.i(239527);
    this.Npl = new LinkedList();
    AppMethodBeat.o(239527);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(239528);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NoW != null) {
        paramVarArgs.e(1, this.NoW);
      }
      paramVarArgs.bb(2, this.Lnw);
      if (this.NoX != null) {
        paramVarArgs.e(3, this.NoX);
      }
      if (this.Npj != null) {
        paramVarArgs.e(4, this.Npj);
      }
      if (this.LmK != null) {
        paramVarArgs.e(5, this.LmK);
      }
      if (this.Npk != null) {
        paramVarArgs.c(6, this.Npk);
      }
      paramVarArgs.e(7, 8, this.Npl);
      AppMethodBeat.o(239528);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NoW == null) {
        break label646;
      }
    }
    label646:
    for (paramInt = g.a.a.b.b.a.f(1, this.NoW) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.Lnw);
      paramInt = i;
      if (this.NoX != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.NoX);
      }
      i = paramInt;
      if (this.Npj != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.Npj);
      }
      paramInt = i;
      if (this.LmK != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LmK);
      }
      i = paramInt;
      if (this.Npk != null) {
        i = paramInt + g.a.a.b.b.a.b(6, this.Npk);
      }
      paramInt = g.a.a.a.c(7, 8, this.Npl);
      AppMethodBeat.o(239528);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Npl.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(239528);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ert localert = (ert)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(239528);
          return -1;
        case 1: 
          localert.NoW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(239528);
          return 0;
        case 2: 
          localert.Lnw = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(239528);
          return 0;
        case 3: 
          localert.NoX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(239528);
          return 0;
        case 4: 
          localert.Npj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(239528);
          return 0;
        case 5: 
          localert.LmK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(239528);
          return 0;
        case 6: 
          localert.Npk = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(239528);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new esc();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((esc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localert.Npl.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(239528);
        return 0;
      }
      AppMethodBeat.o(239528);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ert
 * JD-Core Version:    0.7.0.1
 */