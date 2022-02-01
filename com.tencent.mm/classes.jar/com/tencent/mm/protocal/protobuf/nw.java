package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class nw
  extends esc
{
  public int YLL;
  public long YPK;
  public String YQf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258478);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(258478);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.YQf != null) {
        paramVarArgs.g(2, this.YQf);
      }
      paramVarArgs.bv(11, this.YPK);
      paramVarArgs.bS(15, this.YLL);
      AppMethodBeat.o(258478);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label500;
      }
    }
    label500:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YQf != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YQf);
      }
      paramInt = i.a.a.b.b.a.q(11, this.YPK);
      int j = i.a.a.b.b.a.cJ(15, this.YLL);
      AppMethodBeat.o(258478);
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
          AppMethodBeat.o(258478);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258478);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        nw localnw = (nw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258478);
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
            localnw.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(258478);
          return 0;
        case 2: 
          localnw.YQf = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258478);
          return 0;
        case 11: 
          localnw.YPK = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(258478);
          return 0;
        }
        localnw.YLL = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258478);
        return 0;
      }
      AppMethodBeat.o(258478);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nw
 * JD-Core Version:    0.7.0.1
 */