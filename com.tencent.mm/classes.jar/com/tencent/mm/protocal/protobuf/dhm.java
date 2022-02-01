package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhm
  extends com.tencent.mm.bx.a
{
  public dtx aaMQ;
  public LinkedList<dhl> aaMR;
  public dhj aaMS;
  
  public dhm()
  {
    AppMethodBeat.i(257648);
    this.aaMR = new LinkedList();
    AppMethodBeat.o(257648);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257650);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaMQ != null)
      {
        paramVarArgs.qD(1, this.aaMQ.computeSize());
        this.aaMQ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.aaMR);
      if (this.aaMS != null)
      {
        paramVarArgs.qD(3, this.aaMS.computeSize());
        this.aaMS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257650);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaMQ == null) {
        break label536;
      }
    }
    label536:
    for (paramInt = i.a.a.a.qC(1, this.aaMQ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.aaMR);
      paramInt = i;
      if (this.aaMS != null) {
        paramInt = i + i.a.a.a.qC(3, this.aaMS.computeSize());
      }
      AppMethodBeat.o(257650);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaMR.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257650);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dhm localdhm = (dhm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257650);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtx)localObject2).parseFrom((byte[])localObject1);
            }
            localdhm.aaMQ = ((dtx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257650);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dhl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dhl)localObject2).parseFrom((byte[])localObject1);
            }
            localdhm.aaMR.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257650);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dhj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dhj)localObject2).parseFrom((byte[])localObject1);
          }
          localdhm.aaMS = ((dhj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257650);
        return 0;
      }
      AppMethodBeat.o(257650);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhm
 * JD-Core Version:    0.7.0.1
 */