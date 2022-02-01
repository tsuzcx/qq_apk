package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apk
  extends esc
{
  public com.tencent.mm.bx.b Zwy;
  public String Zwz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32205);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32205);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Zwy != null) {
        paramVarArgs.d(2, this.Zwy);
      }
      if (this.Zwz != null) {
        paramVarArgs.g(3, this.Zwz);
      }
      AppMethodBeat.o(32205);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label465;
      }
    }
    label465:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Zwy != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.Zwy);
      }
      i = paramInt;
      if (this.Zwz != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Zwz);
      }
      AppMethodBeat.o(32205);
      return i;
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
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32205);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32205);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        apk localapk = (apk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32205);
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
            localapk.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(32205);
          return 0;
        case 2: 
          localapk.Zwy = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(32205);
          return 0;
        }
        localapk.Zwz = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32205);
        return 0;
      }
      AppMethodBeat.o(32205);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apk
 * JD-Core Version:    0.7.0.1
 */