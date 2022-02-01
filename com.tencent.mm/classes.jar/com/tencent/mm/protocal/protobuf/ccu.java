package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ccu
  extends erp
{
  public double YTc;
  public double YTd;
  public int aami;
  public String aamj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257815);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.d(2, this.YTc);
      paramVarArgs.d(3, this.YTd);
      paramVarArgs.bS(4, this.aami);
      if (this.aamj != null) {
        paramVarArgs.g(5, this.aamj);
      }
      AppMethodBeat.o(257815);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label478;
      }
    }
    label478:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 8) + (i.a.a.b.b.a.ko(3) + 8) + i.a.a.b.b.a.cJ(4, this.aami);
      paramInt = i;
      if (this.aamj != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aamj);
      }
      AppMethodBeat.o(257815);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257815);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ccu localccu = (ccu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257815);
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
            localccu.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(257815);
          return 0;
        case 2: 
          localccu.YTc = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
          AppMethodBeat.o(257815);
          return 0;
        case 3: 
          localccu.YTd = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
          AppMethodBeat.o(257815);
          return 0;
        case 4: 
          localccu.aami = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257815);
          return 0;
        }
        localccu.aamj = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257815);
        return 0;
      }
      AppMethodBeat.o(257815);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccu
 * JD-Core Version:    0.7.0.1
 */