package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gw
  extends com.tencent.mm.bw.a
{
  public String FRm;
  public dur FRn;
  public String FRo;
  public cyi FRp;
  public String scope;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147757);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.d(1, this.scope);
      }
      if (this.FRm != null) {
        paramVarArgs.d(2, this.FRm);
      }
      paramVarArgs.aS(3, this.state);
      if (this.FRn != null)
      {
        paramVarArgs.lJ(4, this.FRn.computeSize());
        this.FRn.writeFields(paramVarArgs);
      }
      if (this.FRo != null) {
        paramVarArgs.d(5, this.FRo);
      }
      if (this.FRp != null)
      {
        paramVarArgs.lJ(6, this.FRp.computeSize());
        this.FRp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(147757);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = f.a.a.b.b.a.e(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FRm != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FRm);
      }
      i += f.a.a.b.b.a.bz(3, this.state);
      paramInt = i;
      if (this.FRn != null) {
        paramInt = i + f.a.a.a.lI(4, this.FRn.computeSize());
      }
      i = paramInt;
      if (this.FRo != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FRo);
      }
      paramInt = i;
      if (this.FRp != null) {
        paramInt = i + f.a.a.a.lI(6, this.FRp.computeSize());
      }
      AppMethodBeat.o(147757);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(147757);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        gw localgw = (gw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147757);
          return -1;
        case 1: 
          localgw.scope = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(147757);
          return 0;
        case 2: 
          localgw.FRm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(147757);
          return 0;
        case 3: 
          localgw.state = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(147757);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dur();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dur)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localgw.FRn = ((dur)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147757);
          return 0;
        case 5: 
          localgw.FRo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(147757);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cyi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cyi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgw.FRp = ((cyi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(147757);
        return 0;
      }
      AppMethodBeat.o(147757);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gw
 * JD-Core Version:    0.7.0.1
 */