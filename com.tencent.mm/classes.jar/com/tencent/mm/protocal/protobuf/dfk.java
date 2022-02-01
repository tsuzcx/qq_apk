package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dfk
  extends com.tencent.mm.bw.a
{
  public String FUn;
  public cww HMv;
  public dnl Hpd;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91693);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hpd != null)
      {
        paramVarArgs.lJ(1, this.Hpd.computeSize());
        this.Hpd.writeFields(paramVarArgs);
      }
      if (this.HMv != null)
      {
        paramVarArgs.lJ(2, this.HMv.computeSize());
        this.HMv.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.type);
      if (this.FUn != null) {
        paramVarArgs.d(4, this.FUn);
      }
      AppMethodBeat.o(91693);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hpd == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = f.a.a.a.lI(1, this.Hpd.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HMv != null) {
        i = paramInt + f.a.a.a.lI(2, this.HMv.computeSize());
      }
      i += f.a.a.b.b.a.bz(3, this.type);
      paramInt = i;
      if (this.FUn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FUn);
      }
      AppMethodBeat.o(91693);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91693);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dfk localdfk = (dfk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91693);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfk.Hpd = ((dnl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91693);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cww();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cww)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfk.HMv = ((cww)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91693);
          return 0;
        case 3: 
          localdfk.type = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91693);
          return 0;
        }
        localdfk.FUn = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91693);
        return 0;
      }
      AppMethodBeat.o(91693);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfk
 * JD-Core Version:    0.7.0.1
 */