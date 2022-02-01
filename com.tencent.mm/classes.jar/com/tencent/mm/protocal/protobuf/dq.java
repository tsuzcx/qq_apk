package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dq
  extends com.tencent.mm.bx.a
{
  public bry DnV;
  public bry DnW;
  public int FvS;
  public String dxD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168752);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dxD != null) {
        paramVarArgs.d(1, this.dxD);
      }
      if (this.DnV != null)
      {
        paramVarArgs.lC(2, this.DnV.computeSize());
        this.DnV.writeFields(paramVarArgs);
      }
      if (this.DnW != null)
      {
        paramVarArgs.lC(3, this.DnW.computeSize());
        this.DnW.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.FvS);
      AppMethodBeat.o(168752);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dxD == null) {
        break label570;
      }
    }
    label570:
    for (int i = f.a.a.b.b.a.e(1, this.dxD) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DnV != null) {
        paramInt = i + f.a.a.a.lB(2, this.DnV.computeSize());
      }
      i = paramInt;
      if (this.DnW != null) {
        i = paramInt + f.a.a.a.lB(3, this.DnW.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(4, this.FvS);
      AppMethodBeat.o(168752);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(168752);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dq localdq = (dq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168752);
          return -1;
        case 1: 
          localdq.dxD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168752);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bry();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bry)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdq.DnV = ((bry)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168752);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bry();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bry)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdq.DnW = ((bry)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168752);
          return 0;
        }
        localdq.FvS = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(168752);
        return 0;
      }
      AppMethodBeat.o(168752);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dq
 * JD-Core Version:    0.7.0.1
 */