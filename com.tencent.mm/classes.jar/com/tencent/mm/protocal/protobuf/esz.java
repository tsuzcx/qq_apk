package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class esz
  extends erp
{
  public String YFk;
  public esw aapP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181508);
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
      if (this.aapP != null)
      {
        paramVarArgs.qD(3, this.aapP.computeSize());
        this.aapP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(181508);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label478;
      }
    }
    label478:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YFk != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YFk);
      }
      i = paramInt;
      if (this.aapP != null) {
        i = paramInt + i.a.a.a.qC(3, this.aapP.computeSize());
      }
      AppMethodBeat.o(181508);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(181508);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        esz localesz = (esz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(181508);
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
            localesz.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(181508);
          return 0;
        case 2: 
          localesz.YFk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(181508);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new esw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((esw)localObject2).parseFrom((byte[])localObject1);
          }
          localesz.aapP = ((esw)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(181508);
        return 0;
      }
      AppMethodBeat.o(181508);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esz
 * JD-Core Version:    0.7.0.1
 */