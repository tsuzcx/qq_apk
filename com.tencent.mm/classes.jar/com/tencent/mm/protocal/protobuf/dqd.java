package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqd
  extends com.tencent.mm.bw.a
{
  public String KNW;
  public ehf Lov;
  public cyf MTe;
  public float MTf;
  public long MTg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91675);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KNW != null) {
        paramVarArgs.e(1, this.KNW);
      }
      if (this.Lov != null)
      {
        paramVarArgs.ni(2, this.Lov.computeSize());
        this.Lov.writeFields(paramVarArgs);
      }
      if (this.MTe != null)
      {
        paramVarArgs.ni(3, this.MTe.computeSize());
        this.MTe.writeFields(paramVarArgs);
      }
      paramVarArgs.E(4, this.MTf);
      paramVarArgs.bb(5, this.MTg);
      AppMethodBeat.o(91675);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KNW == null) {
        break label617;
      }
    }
    label617:
    for (int i = g.a.a.b.b.a.f(1, this.KNW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Lov != null) {
        paramInt = i + g.a.a.a.nh(2, this.Lov.computeSize());
      }
      i = paramInt;
      if (this.MTe != null) {
        i = paramInt + g.a.a.a.nh(3, this.MTe.computeSize());
      }
      paramInt = g.a.a.b.b.a.fS(4);
      int j = g.a.a.b.b.a.r(5, this.MTg);
      AppMethodBeat.o(91675);
      return i + (paramInt + 4) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91675);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dqd localdqd = (dqd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91675);
          return -1;
        case 1: 
          localdqd.KNW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91675);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ehf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdqd.Lov = ((ehf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91675);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdqd.MTe = ((cyf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91675);
          return 0;
        case 4: 
          localdqd.MTf = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(91675);
          return 0;
        }
        localdqd.MTg = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(91675);
        return 0;
      }
      AppMethodBeat.o(91675);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqd
 * JD-Core Version:    0.7.0.1
 */