package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eri
  extends com.tencent.mm.bw.a
{
  public long Lnw;
  public String NoW;
  public String NoX;
  public LinkedList<esd> NoY;
  public long NoZ;
  public int Npa;
  public String Npb;
  
  public eri()
  {
    AppMethodBeat.i(239510);
    this.NoY = new LinkedList();
    AppMethodBeat.o(239510);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(239511);
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
      paramVarArgs.e(4, 8, this.NoY);
      paramVarArgs.bb(5, this.NoZ);
      paramVarArgs.aM(6, this.Npa);
      if (this.Npb != null) {
        paramVarArgs.e(7, this.Npb);
      }
      AppMethodBeat.o(239511);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NoW == null) {
        break label610;
      }
    }
    label610:
    for (paramInt = g.a.a.b.b.a.f(1, this.NoW) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.Lnw);
      paramInt = i;
      if (this.NoX != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.NoX);
      }
      i = paramInt + g.a.a.a.c(4, 8, this.NoY) + g.a.a.b.b.a.r(5, this.NoZ) + g.a.a.b.b.a.bu(6, this.Npa);
      paramInt = i;
      if (this.Npb != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Npb);
      }
      AppMethodBeat.o(239511);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.NoY.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(239511);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eri localeri = (eri)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(239511);
          return -1;
        case 1: 
          localeri.NoW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(239511);
          return 0;
        case 2: 
          localeri.Lnw = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(239511);
          return 0;
        case 3: 
          localeri.NoX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(239511);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new esd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((esd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeri.NoY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(239511);
          return 0;
        case 5: 
          localeri.NoZ = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(239511);
          return 0;
        case 6: 
          localeri.Npa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(239511);
          return 0;
        }
        localeri.Npb = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(239511);
        return 0;
      }
      AppMethodBeat.o(239511);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eri
 * JD-Core Version:    0.7.0.1
 */