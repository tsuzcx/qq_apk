package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class dsx
  extends esc
{
  public String aaXV;
  public b cookie;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259524);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.cookie != null) {
        paramVarArgs.d(2, this.cookie);
      }
      if (this.aaXV != null) {
        paramVarArgs.g(3, this.aaXV);
      }
      AppMethodBeat.o(259524);
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
      if (this.cookie != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.cookie);
      }
      i = paramInt;
      if (this.aaXV != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaXV);
      }
      AppMethodBeat.o(259524);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259524);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dsx localdsx = (dsx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259524);
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
            localdsx.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(259524);
          return 0;
        case 2: 
          localdsx.cookie = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(259524);
          return 0;
        }
        localdsx.aaXV = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259524);
        return 0;
      }
      AppMethodBeat.o(259524);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsx
 * JD-Core Version:    0.7.0.1
 */