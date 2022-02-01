package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dkq
  extends com.tencent.mm.bx.a
{
  public yj EAe;
  public boolean EAf = true;
  public dkf EAg;
  public String EAh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117943);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EAe != null)
      {
        paramVarArgs.kX(1, this.EAe.computeSize());
        this.EAe.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(2, this.EAf);
      if (this.EAg != null)
      {
        paramVarArgs.kX(3, this.EAg.computeSize());
        this.EAg.writeFields(paramVarArgs);
      }
      if (this.EAh != null) {
        paramVarArgs.d(4, this.EAh);
      }
      AppMethodBeat.o(117943);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EAe == null) {
        break label566;
      }
    }
    label566:
    for (paramInt = f.a.a.a.kW(1, this.EAe.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (f.a.a.b.b.a.fY(2) + 1);
      paramInt = i;
      if (this.EAg != null) {
        paramInt = i + f.a.a.a.kW(3, this.EAg.computeSize());
      }
      i = paramInt;
      if (this.EAh != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.EAh);
      }
      AppMethodBeat.o(117943);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117943);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dkq localdkq = (dkq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117943);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkq.EAe = ((yj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117943);
          return 0;
        case 2: 
          localdkq.EAf = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(117943);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dkf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dkf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkq.EAg = ((dkf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117943);
          return 0;
        }
        localdkq.EAh = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117943);
        return 0;
      }
      AppMethodBeat.o(117943);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkq
 * JD-Core Version:    0.7.0.1
 */