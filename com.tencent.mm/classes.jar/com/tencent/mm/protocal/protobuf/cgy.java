package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cgy
  extends com.tencent.mm.bx.a
{
  public boolean EcA;
  public boolean EcB;
  public boolean EcC;
  public boolean EcD;
  public boolean EcE;
  public zf Ecv;
  public boolean Ecw;
  public boolean Ecx;
  public boolean Ecy;
  public boolean Ecz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91659);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ecv != null)
      {
        paramVarArgs.kX(1, this.Ecv.computeSize());
        this.Ecv.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(2, this.Ecw);
      paramVarArgs.bg(3, this.Ecx);
      paramVarArgs.bg(4, this.Ecy);
      paramVarArgs.bg(5, this.Ecz);
      paramVarArgs.bg(6, this.EcA);
      paramVarArgs.bg(7, this.EcB);
      paramVarArgs.bg(8, this.EcC);
      paramVarArgs.bg(9, this.EcD);
      paramVarArgs.bg(10, this.EcE);
      AppMethodBeat.o(91659);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ecv == null) {
        break label714;
      }
    }
    label714:
    for (paramInt = f.a.a.a.kW(1, this.Ecv.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.fY(2);
      int j = f.a.a.b.b.a.fY(3);
      int k = f.a.a.b.b.a.fY(4);
      int m = f.a.a.b.b.a.fY(5);
      int n = f.a.a.b.b.a.fY(6);
      int i1 = f.a.a.b.b.a.fY(7);
      int i2 = f.a.a.b.b.a.fY(8);
      int i3 = f.a.a.b.b.a.fY(9);
      int i4 = f.a.a.b.b.a.fY(10);
      AppMethodBeat.o(91659);
      return paramInt + (i + 1) + (j + 1) + (k + 1) + (m + 1) + (n + 1) + (i1 + 1) + (i2 + 1) + (i3 + 1) + (i4 + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91659);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cgy localcgy = (cgy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91659);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((zf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcgy.Ecv = ((zf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91659);
          return 0;
        case 2: 
          localcgy.Ecw = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91659);
          return 0;
        case 3: 
          localcgy.Ecx = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91659);
          return 0;
        case 4: 
          localcgy.Ecy = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91659);
          return 0;
        case 5: 
          localcgy.Ecz = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91659);
          return 0;
        case 6: 
          localcgy.EcA = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91659);
          return 0;
        case 7: 
          localcgy.EcB = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91659);
          return 0;
        case 8: 
          localcgy.EcC = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91659);
          return 0;
        case 9: 
          localcgy.EcD = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91659);
          return 0;
        }
        localcgy.EcE = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(91659);
        return 0;
      }
      AppMethodBeat.o(91659);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgy
 * JD-Core Version:    0.7.0.1
 */