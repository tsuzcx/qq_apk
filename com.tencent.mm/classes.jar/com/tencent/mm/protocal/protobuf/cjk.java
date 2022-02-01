package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cjk
  extends erp
{
  public int XKk;
  public b aarX;
  public String extra;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152568);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.XKk);
      if (this.extra != null) {
        paramVarArgs.g(3, this.extra);
      }
      if (this.aarX != null) {
        paramVarArgs.d(4, this.aarX);
      }
      AppMethodBeat.o(152568);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label448;
      }
    }
    label448:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.XKk);
      paramInt = i;
      if (this.extra != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.extra);
      }
      i = paramInt;
      if (this.aarX != null) {
        i = paramInt + i.a.a.b.b.a.c(4, this.aarX);
      }
      AppMethodBeat.o(152568);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152568);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cjk localcjk = (cjk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152568);
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
            localcjk.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(152568);
          return 0;
        case 2: 
          localcjk.XKk = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152568);
          return 0;
        case 3: 
          localcjk.extra = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152568);
          return 0;
        }
        localcjk.aarX = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(152568);
        return 0;
      }
      AppMethodBeat.o(152568);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjk
 * JD-Core Version:    0.7.0.1
 */