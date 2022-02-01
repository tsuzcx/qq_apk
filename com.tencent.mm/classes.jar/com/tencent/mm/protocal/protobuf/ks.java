package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ks
  extends erp
{
  public fhj YBf;
  public int iaK;
  public LinkedList<wt> nUC;
  
  public ks()
  {
    AppMethodBeat.i(113940);
    this.nUC = new LinkedList();
    AppMethodBeat.o(113940);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113941);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.nUC);
      if (this.YBf != null)
      {
        paramVarArgs.qD(3, this.YBf.computeSize());
        this.YBf.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.iaK);
      AppMethodBeat.o(113941);
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
      int i = paramInt + i.a.a.a.c(2, 8, this.nUC);
      paramInt = i;
      if (this.YBf != null) {
        paramInt = i + i.a.a.a.qC(3, this.YBf.computeSize());
      }
      i = i.a.a.b.b.a.cJ(4, this.iaK);
      AppMethodBeat.o(113941);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nUC.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(113941);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ks localks = (ks)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113941);
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
            localks.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113941);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new wt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((wt)localObject2).parseFrom((byte[])localObject1);
            }
            localks.nUC.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113941);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fhj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fhj)localObject2).parseFrom((byte[])localObject1);
            }
            localks.YBf = ((fhj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113941);
          return 0;
        }
        localks.iaK = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(113941);
        return 0;
      }
      AppMethodBeat.o(113941);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ks
 * JD-Core Version:    0.7.0.1
 */