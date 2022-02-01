package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class eot
  extends esc
{
  public String UserName;
  public String Zky;
  public int yth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259490);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(259490);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.g(2, this.UserName);
      }
      if (this.Zky != null) {
        paramVarArgs.g(3, this.Zky);
      }
      paramVarArgs.bS(4, this.yth);
      AppMethodBeat.o(259490);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label496;
      }
    }
    label496:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.UserName);
      }
      i = paramInt;
      if (this.Zky != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Zky);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.yth);
      AppMethodBeat.o(259490);
      return i + paramInt;
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
          AppMethodBeat.o(259490);
          throw paramVarArgs;
        }
        AppMethodBeat.o(259490);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eot localeot = (eot)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259490);
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
            localeot.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(259490);
          return 0;
        case 2: 
          localeot.UserName = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259490);
          return 0;
        case 3: 
          localeot.Zky = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259490);
          return 0;
        }
        localeot.yth = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259490);
        return 0;
      }
      AppMethodBeat.o(259490);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eot
 * JD-Core Version:    0.7.0.1
 */