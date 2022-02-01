package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class boa
  extends esc
{
  public String Vpy;
  public b ZGI;
  public boolean zSb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258467);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.di(2, this.zSb);
      if (this.Vpy != null) {
        paramVarArgs.g(3, this.Vpy);
      }
      if (this.ZGI != null) {
        paramVarArgs.d(4, this.ZGI);
      }
      AppMethodBeat.o(258467);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label448;
      }
    }
    label448:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 1);
      paramInt = i;
      if (this.Vpy != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.Vpy);
      }
      i = paramInt;
      if (this.ZGI != null) {
        i = paramInt + i.a.a.b.b.a.c(4, this.ZGI);
      }
      AppMethodBeat.o(258467);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258467);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        boa localboa = (boa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258467);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localboa.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(258467);
          return 0;
        case 2: 
          localboa.zSb = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(258467);
          return 0;
        case 3: 
          localboa.Vpy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258467);
          return 0;
        }
        localboa.ZGI = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(258467);
        return 0;
      }
      AppMethodBeat.o(258467);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boa
 * JD-Core Version:    0.7.0.1
 */