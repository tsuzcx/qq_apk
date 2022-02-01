package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class blq
  extends com.tencent.mm.bx.a
{
  public bgh Ddj;
  public int ZPR;
  public LinkedList<cxk> nUC;
  
  public blq()
  {
    AppMethodBeat.i(259193);
    this.nUC = new LinkedList();
    AppMethodBeat.o(259193);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259196);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Ddj != null)
      {
        paramVarArgs.qD(1, this.Ddj.computeSize());
        this.Ddj.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.nUC);
      paramVarArgs.bS(3, this.ZPR);
      AppMethodBeat.o(259196);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ddj == null) {
        break label450;
      }
    }
    label450:
    for (paramInt = i.a.a.a.qC(1, this.Ddj.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.nUC);
      int j = i.a.a.b.b.a.cJ(3, this.ZPR);
      AppMethodBeat.o(259196);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nUC.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259196);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        blq localblq = (blq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259196);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bgh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bgh)localObject2).parseFrom((byte[])localObject1);
            }
            localblq.Ddj = ((bgh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259196);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cxk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cxk)localObject2).parseFrom((byte[])localObject1);
            }
            localblq.nUC.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259196);
          return 0;
        }
        localblq.ZPR = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259196);
        return 0;
      }
      AppMethodBeat.o(259196);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blq
 * JD-Core Version:    0.7.0.1
 */