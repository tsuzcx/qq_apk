package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gp
  extends com.tencent.mm.bw.a
{
  public cfm FRe;
  public LinkedList<cfm> FRf;
  public String dqk;
  public String dwx;
  
  public gp()
  {
    AppMethodBeat.i(152496);
    this.FRf = new LinkedList();
    AppMethodBeat.o(152496);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152497);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dwx != null) {
        paramVarArgs.d(1, this.dwx);
      }
      if (this.FRe != null)
      {
        paramVarArgs.lJ(2, this.FRe.computeSize());
        this.FRe.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.FRf);
      if (this.dqk != null) {
        paramVarArgs.d(4, this.dqk);
      }
      AppMethodBeat.o(152497);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dwx == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = f.a.a.b.b.a.e(1, this.dwx) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FRe != null) {
        i = paramInt + f.a.a.a.lI(2, this.FRe.computeSize());
      }
      i += f.a.a.a.c(3, 8, this.FRf);
      paramInt = i;
      if (this.dqk != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dqk);
      }
      AppMethodBeat.o(152497);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FRf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152497);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        gp localgp = (gp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152497);
          return -1;
        case 1: 
          localgp.dwx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152497);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localgp.FRe = ((cfm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152497);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localgp.FRf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152497);
          return 0;
        }
        localgp.dqk = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152497);
        return 0;
      }
      AppMethodBeat.o(152497);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gp
 * JD-Core Version:    0.7.0.1
 */