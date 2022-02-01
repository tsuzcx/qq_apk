package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class fwl
  extends erp
{
  public b ZoS;
  public b abUn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258395);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abUn != null) {
        paramVarArgs.d(2, this.abUn);
      }
      if (this.ZoS != null) {
        paramVarArgs.d(3, this.ZoS);
      }
      AppMethodBeat.o(258395);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label404;
      }
    }
    label404:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abUn != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.abUn);
      }
      i = paramInt;
      if (this.ZoS != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.ZoS);
      }
      AppMethodBeat.o(258395);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258395);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fwl localfwl = (fwl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258395);
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
            localfwl.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(258395);
          return 0;
        case 2: 
          localfwl.abUn = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(258395);
          return 0;
        }
        localfwl.ZoS = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(258395);
        return 0;
      }
      AppMethodBeat.o(258395);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fwl
 * JD-Core Version:    0.7.0.1
 */