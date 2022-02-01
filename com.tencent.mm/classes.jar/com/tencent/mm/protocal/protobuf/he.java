package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class he
  extends esc
{
  public String YBM;
  public boolean YII;
  public String YIJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257733);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(257733);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.YBM != null) {
        paramVarArgs.g(2, this.YBM);
      }
      paramVarArgs.di(3, this.YII);
      if (this.YIJ != null) {
        paramVarArgs.g(4, this.YIJ);
      }
      AppMethodBeat.o(257733);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label496;
      }
    }
    label496:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YBM != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YBM);
      }
      i += i.a.a.b.b.a.ko(3) + 1;
      paramInt = i;
      if (this.YIJ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YIJ);
      }
      AppMethodBeat.o(257733);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(257733);
          throw paramVarArgs;
        }
        AppMethodBeat.o(257733);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        he localhe = (he)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257733);
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
            localhe.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(257733);
          return 0;
        case 2: 
          localhe.YBM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257733);
          return 0;
        case 3: 
          localhe.YII = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(257733);
          return 0;
        }
        localhe.YIJ = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257733);
        return 0;
      }
      AppMethodBeat.o(257733);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.he
 * JD-Core Version:    0.7.0.1
 */