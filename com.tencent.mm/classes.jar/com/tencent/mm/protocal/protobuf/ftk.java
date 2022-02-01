package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ftk
  extends esc
{
  public int ZaS;
  public LinkedList<amw> ZtR;
  public int abRC;
  
  public ftk()
  {
    AppMethodBeat.i(109450);
    this.ZtR = new LinkedList();
    AppMethodBeat.o(109450);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(109451);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(109451);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.abRC);
      paramVarArgs.e(3, 8, this.ZtR);
      paramVarArgs.bS(4, this.ZaS);
      AppMethodBeat.o(109451);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label546;
      }
    }
    label546:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.abRC);
      int j = i.a.a.a.c(3, 8, this.ZtR);
      int k = i.a.a.b.b.a.cJ(4, this.ZaS);
      AppMethodBeat.o(109451);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZtR.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(109451);
          throw paramVarArgs;
        }
        AppMethodBeat.o(109451);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ftk localftk = (ftk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(109451);
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
            localftk.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(109451);
          return 0;
        case 2: 
          localftk.abRC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(109451);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new amw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((amw)localObject2).parseFrom((byte[])localObject1);
            }
            localftk.ZtR.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(109451);
          return 0;
        }
        localftk.ZaS = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(109451);
        return 0;
      }
      AppMethodBeat.o(109451);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ftk
 * JD-Core Version:    0.7.0.1
 */