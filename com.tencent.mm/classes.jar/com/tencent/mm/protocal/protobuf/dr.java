package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dr
  extends esc
{
  public LinkedList<dxg> YFR;
  public String YFS;
  
  public dr()
  {
    AppMethodBeat.i(152485);
    this.YFR = new LinkedList();
    AppMethodBeat.o(152485);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152486);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.YFR);
      if (this.YFS != null) {
        paramVarArgs.g(3, this.YFS);
      }
      AppMethodBeat.o(152486);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.YFR);
      paramInt = i;
      if (this.YFS != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YFS);
      }
      AppMethodBeat.o(152486);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YFR.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152486);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dr localdr = (dr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152486);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localdr.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152486);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dxg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dxg)localObject2).parseFrom((byte[])localObject1);
            }
            localdr.YFR.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152486);
          return 0;
        }
        localdr.YFS = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(152486);
        return 0;
      }
      AppMethodBeat.o(152486);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dr
 * JD-Core Version:    0.7.0.1
 */