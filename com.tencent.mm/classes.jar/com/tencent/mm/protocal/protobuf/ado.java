package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ado
  extends erp
{
  public String YBL;
  public boolean ZlY;
  public long mMJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257566);
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
      paramVarArgs.di(4, this.ZlY);
      AppMethodBeat.o(257566);
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
      i = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(257566);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257566);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ado localado = (ado)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257566);
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
            localado.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(257566);
          return 0;
        case 2: 
          localado.mMJ = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(257566);
          return 0;
        case 3: 
          localado.YBL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257566);
          return 0;
        }
        localado.ZlY = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(257566);
        return 0;
      }
      AppMethodBeat.o(257566);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ado
 * JD-Core Version:    0.7.0.1
 */