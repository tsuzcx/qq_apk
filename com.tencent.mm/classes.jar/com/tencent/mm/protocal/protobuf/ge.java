package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ge
  extends com.tencent.mm.bx.a
{
  public bvj CAP;
  public LinkedList<bvj> CAQ;
  public String dgo;
  public String dlX;
  
  public ge()
  {
    AppMethodBeat.i(152496);
    this.CAQ = new LinkedList();
    AppMethodBeat.o(152496);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152497);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlX != null) {
        paramVarArgs.d(1, this.dlX);
      }
      if (this.CAP != null)
      {
        paramVarArgs.kX(2, this.CAP.computeSize());
        this.CAP.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.CAQ);
      if (this.dgo != null) {
        paramVarArgs.d(4, this.dgo);
      }
      AppMethodBeat.o(152497);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlX == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = f.a.a.b.b.a.e(1, this.dlX) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CAP != null) {
        i = paramInt + f.a.a.a.kW(2, this.CAP.computeSize());
      }
      i += f.a.a.a.c(3, 8, this.CAQ);
      paramInt = i;
      if (this.dgo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dgo);
      }
      AppMethodBeat.o(152497);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CAQ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152497);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ge localge = (ge)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152497);
          return -1;
        case 1: 
          localge.dlX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152497);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localge.CAP = ((bvj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152497);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localge.CAQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152497);
          return 0;
        }
        localge.dgo = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(152497);
        return 0;
      }
      AppMethodBeat.o(152497);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ge
 * JD-Core Version:    0.7.0.1
 */