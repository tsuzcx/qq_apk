package com.tencent.mm.r.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import i.a.a.b;
import java.util.LinkedList;

public final class f
  extends esc
{
  public int interval;
  public String mdH;
  public int mdI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231411);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(231411);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.mdH != null) {
        paramVarArgs.g(2, this.mdH);
      }
      paramVarArgs.bS(3, this.mdI);
      paramVarArgs.bS(4, this.interval);
      AppMethodBeat.o(231411);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label484;
      }
    }
    label484:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mdH != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.mdH);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.mdI);
      int j = i.a.a.b.b.a.cJ(4, this.interval);
      AppMethodBeat.o(231411);
      return i + paramInt + j;
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
          AppMethodBeat.o(231411);
          throw paramVarArgs;
        }
        AppMethodBeat.o(231411);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231411);
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
            localf.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(231411);
          return 0;
        case 2: 
          localf.mdH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(231411);
          return 0;
        case 3: 
          localf.mdI = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(231411);
          return 0;
        }
        localf.interval = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(231411);
        return 0;
      }
      AppMethodBeat.o(231411);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.r.a.f
 * JD-Core Version:    0.7.0.1
 */