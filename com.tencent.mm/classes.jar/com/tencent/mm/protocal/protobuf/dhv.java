package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhv
  extends erp
{
  public String YBL;
  public long count;
  public long mMJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257562);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.mMJ);
      if (this.YBL != null) {
        paramVarArgs.g(3, this.YBL);
      }
      paramVarArgs.bv(4, this.count);
      AppMethodBeat.o(257562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label432;
      }
    }
    label432:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.mMJ);
      paramInt = i;
      if (this.YBL != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YBL);
      }
      i = i.a.a.b.b.a.q(4, this.count);
      AppMethodBeat.o(257562);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257562);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dhv localdhv = (dhv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257562);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localdhv.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(257562);
          return 0;
        case 2: 
          localdhv.mMJ = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(257562);
          return 0;
        case 3: 
          localdhv.YBL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257562);
          return 0;
        }
        localdhv.count = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(257562);
        return 0;
      }
      AppMethodBeat.o(257562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhv
 * JD-Core Version:    0.7.0.1
 */