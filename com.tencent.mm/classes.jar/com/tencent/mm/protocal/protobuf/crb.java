package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class crb
  extends com.tencent.mm.bx.a
{
  public boolean HjA;
  public boolean HjB;
  public boolean HjC;
  public boolean HjD;
  public boolean HjE;
  public acc Hjv;
  public boolean Hjw;
  public boolean Hjx;
  public boolean Hjy;
  public boolean Hjz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91659);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hjv != null)
      {
        paramVarArgs.lC(1, this.Hjv.computeSize());
        this.Hjv.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(2, this.Hjw);
      paramVarArgs.bt(3, this.Hjx);
      paramVarArgs.bt(4, this.Hjy);
      paramVarArgs.bt(5, this.Hjz);
      paramVarArgs.bt(6, this.HjA);
      paramVarArgs.bt(7, this.HjB);
      paramVarArgs.bt(8, this.HjC);
      paramVarArgs.bt(9, this.HjD);
      paramVarArgs.bt(10, this.HjE);
      AppMethodBeat.o(91659);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hjv == null) {
        break label698;
      }
    }
    label698:
    for (paramInt = f.a.a.a.lB(1, this.Hjv.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.alV(2);
      int j = f.a.a.b.b.a.alV(3);
      int k = f.a.a.b.b.a.alV(4);
      int m = f.a.a.b.b.a.alV(5);
      int n = f.a.a.b.b.a.alV(6);
      int i1 = f.a.a.b.b.a.alV(7);
      int i2 = f.a.a.b.b.a.alV(8);
      int i3 = f.a.a.b.b.a.alV(9);
      int i4 = f.a.a.b.b.a.alV(10);
      AppMethodBeat.o(91659);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91659);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        crb localcrb = (crb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91659);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((acc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcrb.Hjv = ((acc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91659);
          return 0;
        case 2: 
          localcrb.Hjw = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91659);
          return 0;
        case 3: 
          localcrb.Hjx = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91659);
          return 0;
        case 4: 
          localcrb.Hjy = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91659);
          return 0;
        case 5: 
          localcrb.Hjz = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91659);
          return 0;
        case 6: 
          localcrb.HjA = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91659);
          return 0;
        case 7: 
          localcrb.HjB = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91659);
          return 0;
        case 8: 
          localcrb.HjC = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91659);
          return 0;
        case 9: 
          localcrb.HjD = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91659);
          return 0;
        }
        localcrb.HjE = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(91659);
        return 0;
      }
      AppMethodBeat.o(91659);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crb
 * JD-Core Version:    0.7.0.1
 */