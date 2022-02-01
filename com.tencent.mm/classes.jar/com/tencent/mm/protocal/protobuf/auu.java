package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class auu
  extends com.tencent.mm.bw.a
{
  public int LFG;
  public cjb LFH;
  public avn LFI;
  public long LFJ;
  public String Lmn;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209487);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lmn != null) {
        paramVarArgs.e(1, this.Lmn);
      }
      paramVarArgs.aM(51, this.LFG);
      if (this.LFH != null)
      {
        paramVarArgs.ni(101, this.LFH.computeSize());
        this.LFH.writeFields(paramVarArgs);
      }
      if (this.LFI != null)
      {
        paramVarArgs.ni(102, this.LFI.computeSize());
        this.LFI.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(103, this.LFJ);
      paramVarArgs.bb(104, this.seq);
      AppMethodBeat.o(209487);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lmn == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = g.a.a.b.b.a.f(1, this.Lmn) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(51, this.LFG);
      paramInt = i;
      if (this.LFH != null) {
        paramInt = i + g.a.a.a.nh(101, this.LFH.computeSize());
      }
      i = paramInt;
      if (this.LFI != null) {
        i = paramInt + g.a.a.a.nh(102, this.LFI.computeSize());
      }
      paramInt = g.a.a.b.b.a.r(103, this.LFJ);
      int j = g.a.a.b.b.a.r(104, this.seq);
      AppMethodBeat.o(209487);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209487);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        auu localauu = (auu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209487);
          return -1;
        case 1: 
          localauu.Lmn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209487);
          return 0;
        case 51: 
          localauu.LFG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209487);
          return 0;
        case 101: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localauu.LFH = ((cjb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209487);
          return 0;
        case 102: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localauu.LFI = ((avn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209487);
          return 0;
        case 103: 
          localauu.LFJ = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209487);
          return 0;
        }
        localauu.seq = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(209487);
        return 0;
      }
      AppMethodBeat.o(209487);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auu
 * JD-Core Version:    0.7.0.1
 */