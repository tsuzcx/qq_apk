package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gi
  extends com.tencent.mm.bw.a
{
  public cab DTn;
  public LinkedList<cab> DTo;
  public String ddJ;
  public String djF;
  
  public gi()
  {
    AppMethodBeat.i(152496);
    this.DTo = new LinkedList();
    AppMethodBeat.o(152496);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152497);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.djF != null) {
        paramVarArgs.d(1, this.djF);
      }
      if (this.DTn != null)
      {
        paramVarArgs.ln(2, this.DTn.computeSize());
        this.DTn.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.DTo);
      if (this.ddJ != null) {
        paramVarArgs.d(4, this.ddJ);
      }
      AppMethodBeat.o(152497);
      return 0;
    }
    if (paramInt == 1) {
      if (this.djF == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = f.a.a.b.b.a.e(1, this.djF) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DTn != null) {
        i = paramInt + f.a.a.a.lm(2, this.DTn.computeSize());
      }
      i += f.a.a.a.c(3, 8, this.DTo);
      paramInt = i;
      if (this.ddJ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ddJ);
      }
      AppMethodBeat.o(152497);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DTo.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152497);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        gi localgi = (gi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152497);
          return -1;
        case 1: 
          localgi.djF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152497);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cab();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cab)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localgi.DTn = ((cab)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152497);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cab();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cab)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localgi.DTo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152497);
          return 0;
        }
        localgi.ddJ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152497);
        return 0;
      }
      AppMethodBeat.o(152497);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gi
 * JD-Core Version:    0.7.0.1
 */