package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbq
  extends com.tencent.mm.bx.a
{
  public String FBS;
  public dmo GVC;
  public LinkedList<cwc> GVD;
  public int type;
  
  public cbq()
  {
    AppMethodBeat.i(91548);
    this.GVD = new LinkedList();
    AppMethodBeat.o(91548);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91549);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GVC != null)
      {
        paramVarArgs.lC(1, this.GVC.computeSize());
        this.GVC.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.GVD);
      paramVarArgs.aS(3, this.type);
      if (this.FBS != null) {
        paramVarArgs.d(4, this.FBS);
      }
      AppMethodBeat.o(91549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GVC == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = f.a.a.a.lB(1, this.GVC.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.GVD) + f.a.a.b.b.a.bz(3, this.type);
      paramInt = i;
      if (this.FBS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FBS);
      }
      AppMethodBeat.o(91549);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GVD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91549);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cbq localcbq = (cbq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91549);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcbq.GVC = ((dmo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91549);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcbq.GVD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91549);
          return 0;
        case 3: 
          localcbq.type = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91549);
          return 0;
        }
        localcbq.FBS = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91549);
        return 0;
      }
      AppMethodBeat.o(91549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbq
 * JD-Core Version:    0.7.0.1
 */