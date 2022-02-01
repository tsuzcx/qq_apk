package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cme
  extends erp
{
  public b aaui;
  public b aauj;
  public int nUz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104807);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.nUz);
      if (this.aaui != null) {
        paramVarArgs.d(3, this.aaui);
      }
      if (this.aauj != null) {
        paramVarArgs.d(4, this.aauj);
      }
      AppMethodBeat.o(104807);
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
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.nUz);
      paramInt = i;
      if (this.aaui != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.aaui);
      }
      i = paramInt;
      if (this.aauj != null) {
        i = paramInt + i.a.a.b.b.a.c(4, this.aauj);
      }
      AppMethodBeat.o(104807);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(104807);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cme localcme = (cme)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104807);
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
            localcme.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(104807);
          return 0;
        case 2: 
          localcme.nUz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(104807);
          return 0;
        case 3: 
          localcme.aaui = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(104807);
          return 0;
        }
        localcme.aauj = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(104807);
        return 0;
      }
      AppMethodBeat.o(104807);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cme
 * JD-Core Version:    0.7.0.1
 */