package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awm
  extends com.tencent.mm.bw.a
{
  public String KDS;
  public int LFG;
  public avn LFI;
  public long LHk;
  public String Lmn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209536);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LFI != null)
      {
        paramVarArgs.ni(1, this.LFI.computeSize());
        this.LFI.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LFG);
      if (this.Lmn != null) {
        paramVarArgs.e(3, this.Lmn);
      }
      if (this.KDS != null) {
        paramVarArgs.e(4, this.KDS);
      }
      paramVarArgs.bb(5, this.LHk);
      AppMethodBeat.o(209536);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LFI == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = g.a.a.a.nh(1, this.LFI.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LFG);
      paramInt = i;
      if (this.Lmn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.Lmn);
      }
      i = paramInt;
      if (this.KDS != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.KDS);
      }
      paramInt = g.a.a.b.b.a.r(5, this.LHk);
      AppMethodBeat.o(209536);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209536);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        awm localawm = (awm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209536);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((avn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localawm.LFI = ((avn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209536);
          return 0;
        case 2: 
          localawm.LFG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209536);
          return 0;
        case 3: 
          localawm.Lmn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209536);
          return 0;
        case 4: 
          localawm.KDS = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209536);
          return 0;
        }
        localawm.LHk = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(209536);
        return 0;
      }
      AppMethodBeat.o(209536);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awm
 * JD-Core Version:    0.7.0.1
 */