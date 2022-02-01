package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ciw
  extends com.tencent.mm.bw.a
{
  public zl FwR;
  public buo FwT;
  public String dlQ;
  public String nWj;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194021);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlQ != null) {
        paramVarArgs.d(1, this.dlQ);
      }
      paramVarArgs.aR(2, this.type);
      if (this.nWj != null) {
        paramVarArgs.d(3, this.nWj);
      }
      if (this.FwT != null)
      {
        paramVarArgs.ln(4, this.FwT.computeSize());
        this.FwT.writeFields(paramVarArgs);
      }
      if (this.FwR != null)
      {
        paramVarArgs.ln(5, this.FwR.computeSize());
        this.FwR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(194021);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlQ == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = f.a.a.b.b.a.e(1, this.dlQ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.type);
      paramInt = i;
      if (this.nWj != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWj);
      }
      i = paramInt;
      if (this.FwT != null) {
        i = paramInt + f.a.a.a.lm(4, this.FwT.computeSize());
      }
      paramInt = i;
      if (this.FwR != null) {
        paramInt = i + f.a.a.a.lm(5, this.FwR.computeSize());
      }
      AppMethodBeat.o(194021);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(194021);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ciw localciw = (ciw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194021);
          return -1;
        case 1: 
          localciw.dlQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(194021);
          return 0;
        case 2: 
          localciw.type = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(194021);
          return 0;
        case 3: 
          localciw.nWj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(194021);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new buo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((buo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localciw.FwT = ((buo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(194021);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new zl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((zl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localciw.FwR = ((zl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(194021);
        return 0;
      }
      AppMethodBeat.o(194021);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ciw
 * JD-Core Version:    0.7.0.1
 */