package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsl
  extends esc
{
  public String token;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259775);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.token != null) {
        paramVarArgs.g(2, this.token);
      }
      AppMethodBeat.o(259775);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.token != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.token);
      }
      AppMethodBeat.o(259775);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259775);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dsl localdsl = (dsl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259775);
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
            localdsl.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(259775);
          return 0;
        }
        localdsl.token = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259775);
        return 0;
      }
      AppMethodBeat.o(259775);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsl
 * JD-Core Version:    0.7.0.1
 */