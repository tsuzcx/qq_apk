package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ccy
  extends com.tencent.mm.bw.a
{
  public dnl FLn;
  public String FUn;
  public LinkedList<dnl> Gjz;
  public String Hpx;
  
  public ccy()
  {
    AppMethodBeat.i(91553);
    this.Gjz = new LinkedList();
    AppMethodBeat.o(91553);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91554);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FLn != null)
      {
        paramVarArgs.lJ(1, this.FLn.computeSize());
        this.FLn.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Gjz);
      if (this.FUn != null) {
        paramVarArgs.d(3, this.FUn);
      }
      if (this.Hpx != null) {
        paramVarArgs.d(4, this.Hpx);
      }
      AppMethodBeat.o(91554);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FLn == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = f.a.a.a.lI(1, this.FLn.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.Gjz);
      paramInt = i;
      if (this.FUn != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FUn);
      }
      i = paramInt;
      if (this.Hpx != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Hpx);
      }
      AppMethodBeat.o(91554);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gjz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91554);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ccy localccy = (ccy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91554);
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
            localccy.FLn = ((dnl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91554);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccy.Gjz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91554);
          return 0;
        case 3: 
          localccy.FUn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91554);
          return 0;
        }
        localccy.Hpx = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91554);
        return 0;
      }
      AppMethodBeat.o(91554);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccy
 * JD-Core Version:    0.7.0.1
 */