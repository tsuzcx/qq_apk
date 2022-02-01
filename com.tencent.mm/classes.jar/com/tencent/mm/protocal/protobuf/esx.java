package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class esx
  extends erp
{
  public String YFk;
  public int abwq;
  public etd abwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181506);
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
      paramVarArgs.bS(3, this.abwq);
      if (this.abwr != null)
      {
        paramVarArgs.qD(4, this.abwr.computeSize());
        this.abwr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(181506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YFk != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YFk);
      }
      i += i.a.a.b.b.a.cJ(3, this.abwq);
      paramInt = i;
      if (this.abwr != null) {
        paramInt = i + i.a.a.a.qC(4, this.abwr.computeSize());
      }
      AppMethodBeat.o(181506);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(181506);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        esx localesx = (esx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(181506);
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
            localesx.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(181506);
          return 0;
        case 2: 
          localesx.YFk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(181506);
          return 0;
        case 3: 
          localesx.abwq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(181506);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etd)localObject2).parseFrom((byte[])localObject1);
          }
          localesx.abwr = ((etd)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(181506);
        return 0;
      }
      AppMethodBeat.o(181506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esx
 * JD-Core Version:    0.7.0.1
 */