package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import java.util.LinkedList;

public final class af
  extends erp
{
  public b TpC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(290010);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.TpC != null) {
        paramVarArgs.d(2, this.TpC);
      }
      AppMethodBeat.o(290010);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TpC != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.TpC);
      }
      AppMethodBeat.o(290010);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(290010);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        af localaf = (af)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(290010);
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
            localaf.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(290010);
          return 0;
        }
        localaf.TpC = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(290010);
        return 0;
      }
      AppMethodBeat.o(290010);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.af
 * JD-Core Version:    0.7.0.1
 */