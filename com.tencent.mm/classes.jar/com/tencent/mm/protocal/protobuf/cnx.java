package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cnx
  extends esc
{
  public String aavf;
  public String aavg;
  public String aavh;
  public int aavi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259825);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(259825);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aavf != null) {
        paramVarArgs.g(2, this.aavf);
      }
      if (this.aavg != null) {
        paramVarArgs.g(3, this.aavg);
      }
      paramVarArgs.bS(4, this.aavi);
      if (this.aavh != null) {
        paramVarArgs.g(5, this.aavh);
      }
      AppMethodBeat.o(259825);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label556;
      }
    }
    label556:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aavf != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aavf);
      }
      i = paramInt;
      if (this.aavg != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aavg);
      }
      i += i.a.a.b.b.a.cJ(4, this.aavi);
      paramInt = i;
      if (this.aavh != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aavh);
      }
      AppMethodBeat.o(259825);
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
          AppMethodBeat.o(259825);
          throw paramVarArgs;
        }
        AppMethodBeat.o(259825);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cnx localcnx = (cnx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259825);
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
            localcnx.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(259825);
          return 0;
        case 2: 
          localcnx.aavf = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259825);
          return 0;
        case 3: 
          localcnx.aavg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259825);
          return 0;
        case 4: 
          localcnx.aavi = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259825);
          return 0;
        }
        localcnx.aavh = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259825);
        return 0;
      }
      AppMethodBeat.o(259825);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnx
 * JD-Core Version:    0.7.0.1
 */