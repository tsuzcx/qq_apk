package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cpq
  extends esc
{
  public String VxC;
  public boolean VxE;
  public String aawk;
  public int hAV;
  public String wYI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91503);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91503);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.hAV);
      if (this.wYI != null) {
        paramVarArgs.g(3, this.wYI);
      }
      if (this.VxC != null) {
        paramVarArgs.g(4, this.VxC);
      }
      paramVarArgs.di(5, this.VxE);
      if (this.aawk != null) {
        paramVarArgs.g(6, this.aawk);
      }
      AppMethodBeat.o(91503);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label600;
      }
    }
    label600:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt;
      if (this.VxC != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.VxC);
      }
      i += i.a.a.b.b.a.ko(5) + 1;
      paramInt = i;
      if (this.aawk != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aawk);
      }
      AppMethodBeat.o(91503);
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
          AppMethodBeat.o(91503);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91503);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cpq localcpq = (cpq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91503);
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
            localcpq.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(91503);
          return 0;
        case 2: 
          localcpq.hAV = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91503);
          return 0;
        case 3: 
          localcpq.wYI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91503);
          return 0;
        case 4: 
          localcpq.VxC = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91503);
          return 0;
        case 5: 
          localcpq.VxE = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(91503);
          return 0;
        }
        localcpq.aawk = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91503);
        return 0;
      }
      AppMethodBeat.o(91503);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpq
 * JD-Core Version:    0.7.0.1
 */