package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fep
  extends erp
{
  public gol YKb;
  public int abDW;
  public LinkedList<fem> abDX;
  
  public fep()
  {
    AppMethodBeat.i(125798);
    this.abDX = new LinkedList();
    AppMethodBeat.o(125798);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125799);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.abDW);
      paramVarArgs.e(3, 8, this.abDX);
      if (this.YKb != null)
      {
        paramVarArgs.qD(4, this.YKb.computeSize());
        this.YKb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125799);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label580;
      }
    }
    label580:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abDW) + i.a.a.a.c(3, 8, this.abDX);
      paramInt = i;
      if (this.YKb != null) {
        paramInt = i + i.a.a.a.qC(4, this.YKb.computeSize());
      }
      AppMethodBeat.o(125799);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abDX.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125799);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fep localfep = (fep)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125799);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localfep.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125799);
          return 0;
        case 2: 
          localfep.abDW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125799);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fem();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fem)localObject2).parseFrom((byte[])localObject1);
            }
            localfep.abDX.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125799);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gol)localObject2).dg((byte[])localObject1);
          }
          localfep.YKb = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125799);
        return 0;
      }
      AppMethodBeat.o(125799);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fep
 * JD-Core Version:    0.7.0.1
 */