package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cld
  extends esc
{
  public b aatg;
  public b aath;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257912);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aatg != null) {
        paramVarArgs.d(2, this.aatg);
      }
      if (this.aath != null) {
        paramVarArgs.d(3, this.aath);
      }
      AppMethodBeat.o(257912);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label404;
      }
    }
    label404:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aatg != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.aatg);
      }
      i = paramInt;
      if (this.aath != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.aath);
      }
      AppMethodBeat.o(257912);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257912);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cld localcld = (cld)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257912);
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
            localcld.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(257912);
          return 0;
        case 2: 
          localcld.aatg = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(257912);
          return 0;
        }
        localcld.aath = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(257912);
        return 0;
      }
      AppMethodBeat.o(257912);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cld
 * JD-Core Version:    0.7.0.1
 */