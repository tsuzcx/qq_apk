package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class zl
  extends com.tencent.mm.bw.a
{
  public ciw EtO;
  public ciw EtP;
  public int EtQ;
  public String dlQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194013);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlQ != null) {
        paramVarArgs.d(1, this.dlQ);
      }
      if (this.EtO != null)
      {
        paramVarArgs.ln(2, this.EtO.computeSize());
        this.EtO.writeFields(paramVarArgs);
      }
      if (this.EtP != null)
      {
        paramVarArgs.ln(3, this.EtP.computeSize());
        this.EtP.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.EtQ);
      AppMethodBeat.o(194013);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlQ == null) {
        break label570;
      }
    }
    label570:
    for (int i = f.a.a.b.b.a.e(1, this.dlQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EtO != null) {
        paramInt = i + f.a.a.a.lm(2, this.EtO.computeSize());
      }
      i = paramInt;
      if (this.EtP != null) {
        i = paramInt + f.a.a.a.lm(3, this.EtP.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(4, this.EtQ);
      AppMethodBeat.o(194013);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(194013);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        zl localzl = (zl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194013);
          return -1;
        case 1: 
          localzl.dlQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(194013);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ciw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ciw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzl.EtO = ((ciw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(194013);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ciw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ciw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzl.EtP = ((ciw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(194013);
          return 0;
        }
        localzl.EtQ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(194013);
        return 0;
      }
      AppMethodBeat.o(194013);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zl
 * JD-Core Version:    0.7.0.1
 */