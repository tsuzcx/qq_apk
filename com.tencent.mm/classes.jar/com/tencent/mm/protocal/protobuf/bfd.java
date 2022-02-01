package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bfd
  extends esc
{
  public String ZDB;
  public long ZDC;
  public String session_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258572);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ZDB != null) {
        paramVarArgs.g(2, this.ZDB);
      }
      paramVarArgs.bv(3, this.ZDC);
      if (this.session_id != null) {
        paramVarArgs.g(4, this.session_id);
      }
      AppMethodBeat.o(258572);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label448;
      }
    }
    label448:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZDB != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ZDB);
      }
      i += i.a.a.b.b.a.q(3, this.ZDC);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.session_id);
      }
      AppMethodBeat.o(258572);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258572);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bfd localbfd = (bfd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258572);
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
            localbfd.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(258572);
          return 0;
        case 2: 
          localbfd.ZDB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258572);
          return 0;
        case 3: 
          localbfd.ZDC = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(258572);
          return 0;
        }
        localbfd.session_id = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258572);
        return 0;
      }
      AppMethodBeat.o(258572);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfd
 * JD-Core Version:    0.7.0.1
 */