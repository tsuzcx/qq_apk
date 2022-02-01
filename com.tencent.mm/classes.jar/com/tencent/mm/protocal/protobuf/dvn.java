package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvn
  extends com.tencent.mm.bx.a
{
  public dvm EJC;
  public uw EJD;
  public int dhR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(187837);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EJC != null)
      {
        paramVarArgs.kX(1, this.EJC.computeSize());
        this.EJC.writeFields(paramVarArgs);
      }
      if (this.EJD != null)
      {
        paramVarArgs.kX(2, this.EJD.computeSize());
        this.EJD.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.dhR);
      AppMethodBeat.o(187837);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EJC == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = f.a.a.a.kW(1, this.EJC.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EJD != null) {
        i = paramInt + f.a.a.a.kW(2, this.EJD.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(3, this.dhR);
      AppMethodBeat.o(187837);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(187837);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dvn localdvn = (dvn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(187837);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dvm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvn.EJC = ((dvm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(187837);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new uw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((uw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvn.EJD = ((uw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(187837);
          return 0;
        }
        localdvn.dhR = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(187837);
        return 0;
      }
      AppMethodBeat.o(187837);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvn
 * JD-Core Version:    0.7.0.1
 */