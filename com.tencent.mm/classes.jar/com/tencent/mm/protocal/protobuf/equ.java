package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class equ
  extends erp
{
  public int YXw;
  public String abdU;
  public b abut;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72579);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abut != null) {
        paramVarArgs.d(2, this.abut);
      }
      if (this.abdU != null) {
        paramVarArgs.g(3, this.abdU);
      }
      paramVarArgs.bS(4, this.YXw);
      AppMethodBeat.o(72579);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label448;
      }
    }
    label448:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abut != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.abut);
      }
      i = paramInt;
      if (this.abdU != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abdU);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.YXw);
      AppMethodBeat.o(72579);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72579);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        equ localequ = (equ)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72579);
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
            localequ.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(72579);
          return 0;
        case 2: 
          localequ.abut = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(72579);
          return 0;
        case 3: 
          localequ.abdU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72579);
          return 0;
        }
        localequ.YXw = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(72579);
        return 0;
      }
      AppMethodBeat.o(72579);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.equ
 * JD-Core Version:    0.7.0.1
 */