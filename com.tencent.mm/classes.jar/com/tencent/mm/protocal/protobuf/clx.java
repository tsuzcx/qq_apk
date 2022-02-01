package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class clx
  extends esc
{
  public int YME;
  public String YMF;
  public LinkedList<aou> aatO;
  public int aatP;
  
  public clx()
  {
    AppMethodBeat.i(91487);
    this.aatO = new LinkedList();
    AppMethodBeat.o(91487);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91488);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91488);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.aatO);
      paramVarArgs.bS(3, this.aatP);
      paramVarArgs.bS(4, this.YME);
      if (this.YMF != null) {
        paramVarArgs.g(5, this.YMF);
      }
      AppMethodBeat.o(91488);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.aatO) + i.a.a.b.b.a.cJ(3, this.aatP) + i.a.a.b.b.a.cJ(4, this.YME);
      paramInt = i;
      if (this.YMF != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YMF);
      }
      AppMethodBeat.o(91488);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aatO.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91488);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91488);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        clx localclx = (clx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91488);
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
            localclx.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91488);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aou();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aou)localObject2).parseFrom((byte[])localObject1);
            }
            localclx.aatO.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91488);
          return 0;
        case 3: 
          localclx.aatP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91488);
          return 0;
        case 4: 
          localclx.YME = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91488);
          return 0;
        }
        localclx.YMF = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91488);
        return 0;
      }
      AppMethodBeat.o(91488);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clx
 * JD-Core Version:    0.7.0.1
 */