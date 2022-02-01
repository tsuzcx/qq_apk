package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class qw
  extends esc
{
  public int YFu;
  public int YRq;
  public long YVJ;
  public String YVP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257452);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(257452);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.YVJ);
      paramVarArgs.bS(3, this.YFu);
      paramVarArgs.bS(4, this.YRq);
      if (this.YVP != null) {
        paramVarArgs.g(5, this.YVP);
      }
      AppMethodBeat.o(257452);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label520;
      }
    }
    label520:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.YVJ) + i.a.a.b.b.a.cJ(3, this.YFu) + i.a.a.b.b.a.cJ(4, this.YRq);
      paramInt = i;
      if (this.YVP != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YVP);
      }
      AppMethodBeat.o(257452);
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
          AppMethodBeat.o(257452);
          throw paramVarArgs;
        }
        AppMethodBeat.o(257452);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        qw localqw = (qw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257452);
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
            localqw.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(257452);
          return 0;
        case 2: 
          localqw.YVJ = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(257452);
          return 0;
        case 3: 
          localqw.YFu = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257452);
          return 0;
        case 4: 
          localqw.YRq = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257452);
          return 0;
        }
        localqw.YVP = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257452);
        return 0;
      }
      AppMethodBeat.o(257452);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qw
 * JD-Core Version:    0.7.0.1
 */