package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class er
  extends erp
{
  public String YFk;
  public int YGJ;
  public LinkedList<zi> YGK;
  
  public er()
  {
    AppMethodBeat.i(258937);
    this.YGK = new LinkedList();
    AppMethodBeat.o(258937);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258943);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YFk != null) {
        paramVarArgs.g(2, this.YFk);
      }
      paramVarArgs.bS(3, this.YGJ);
      paramVarArgs.e(4, 8, this.YGK);
      AppMethodBeat.o(258943);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YFk != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YFk);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.YGJ);
      int j = i.a.a.a.c(4, 8, this.YGK);
      AppMethodBeat.o(258943);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YGK.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258943);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        er localer = (er)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258943);
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
            localer.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258943);
          return 0;
        case 2: 
          localer.YFk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258943);
          return 0;
        case 3: 
          localer.YGJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258943);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new zi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((zi)localObject2).parseFrom((byte[])localObject1);
          }
          localer.YGK.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258943);
        return 0;
      }
      AppMethodBeat.o(258943);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.er
 * JD-Core Version:    0.7.0.1
 */