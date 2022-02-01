package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cce
  extends com.tencent.mm.bx.a
{
  public String FBS;
  public LinkedList<dmo> FRa;
  public dmo FsP;
  public String GVX;
  
  public cce()
  {
    AppMethodBeat.i(91553);
    this.FRa = new LinkedList();
    AppMethodBeat.o(91553);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91554);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FsP != null)
      {
        paramVarArgs.lC(1, this.FsP.computeSize());
        this.FsP.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.FRa);
      if (this.FBS != null) {
        paramVarArgs.d(3, this.FBS);
      }
      if (this.GVX != null) {
        paramVarArgs.d(4, this.GVX);
      }
      AppMethodBeat.o(91554);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FsP == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = f.a.a.a.lB(1, this.FsP.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.FRa);
      paramInt = i;
      if (this.FBS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FBS);
      }
      i = paramInt;
      if (this.GVX != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.GVX);
      }
      AppMethodBeat.o(91554);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FRa.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91554);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cce localcce = (cce)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91554);
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
            localcce.FsP = ((dmo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91554);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcce.FRa.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91554);
          return 0;
        case 3: 
          localcce.FBS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91554);
          return 0;
        }
        localcce.GVX = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91554);
        return 0;
      }
      AppMethodBeat.o(91554);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cce
 * JD-Core Version:    0.7.0.1
 */