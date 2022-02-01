package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class anr
  extends com.tencent.mm.bw.a
{
  public String Coh;
  public LinkedList<ans> KXX;
  public String Lhy;
  public String LyJ;
  public long LyK;
  public long LyL;
  public String LyM;
  public long LyN;
  
  public anr()
  {
    AppMethodBeat.i(91458);
    this.KXX = new LinkedList();
    AppMethodBeat.o(91458);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91459);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LyJ != null) {
        paramVarArgs.e(1, this.LyJ);
      }
      paramVarArgs.e(2, 8, this.KXX);
      paramVarArgs.bb(3, this.LyK);
      paramVarArgs.bb(4, this.LyL);
      if (this.LyM != null) {
        paramVarArgs.e(5, this.LyM);
      }
      if (this.Coh != null) {
        paramVarArgs.e(6, this.Coh);
      }
      paramVarArgs.bb(7, this.LyN);
      if (this.Lhy != null) {
        paramVarArgs.e(8, this.Lhy);
      }
      AppMethodBeat.o(91459);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LyJ == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = g.a.a.b.b.a.f(1, this.LyJ) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.KXX) + g.a.a.b.b.a.r(3, this.LyK) + g.a.a.b.b.a.r(4, this.LyL);
      paramInt = i;
      if (this.LyM != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LyM);
      }
      i = paramInt;
      if (this.Coh != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.Coh);
      }
      i += g.a.a.b.b.a.r(7, this.LyN);
      paramInt = i;
      if (this.Lhy != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Lhy);
      }
      AppMethodBeat.o(91459);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KXX.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91459);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        anr localanr = (anr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91459);
          return -1;
        case 1: 
          localanr.LyJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91459);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ans();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ans)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localanr.KXX.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91459);
          return 0;
        case 3: 
          localanr.LyK = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91459);
          return 0;
        case 4: 
          localanr.LyL = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91459);
          return 0;
        case 5: 
          localanr.LyM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91459);
          return 0;
        case 6: 
          localanr.Coh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91459);
          return 0;
        case 7: 
          localanr.LyN = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91459);
          return 0;
        }
        localanr.Lhy = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91459);
        return 0;
      }
      AppMethodBeat.o(91459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anr
 * JD-Core Version:    0.7.0.1
 */