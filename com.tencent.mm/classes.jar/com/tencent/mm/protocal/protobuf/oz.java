package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class oz
  extends esc
{
  public String Kuf;
  public String errmsg;
  public int ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258110);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(258110);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.ret);
      if (this.errmsg != null) {
        paramVarArgs.g(3, this.errmsg);
      }
      if (this.Kuf != null) {
        paramVarArgs.g(4, this.Kuf);
      }
      AppMethodBeat.o(258110);
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
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ret);
      paramInt = i;
      if (this.errmsg != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.errmsg);
      }
      i = paramInt;
      if (this.Kuf != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.Kuf);
      }
      AppMethodBeat.o(258110);
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
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(258110);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258110);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        oz localoz = (oz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258110);
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
            localoz.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(258110);
          return 0;
        case 2: 
          localoz.ret = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258110);
          return 0;
        case 3: 
          localoz.errmsg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258110);
          return 0;
        }
        localoz.Kuf = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258110);
        return 0;
      }
      AppMethodBeat.o(258110);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oz
 * JD-Core Version:    0.7.0.1
 */