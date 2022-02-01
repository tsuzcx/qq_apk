package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import java.util.LinkedList;

public final class ad
  extends erp
{
  public long Tpz;
  public long key;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(289995);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.key);
      paramVarArgs.bv(3, this.Tpz);
      AppMethodBeat.o(289995);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label376;
      }
    }
    label376:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.key);
      int j = i.a.a.b.b.a.q(3, this.Tpz);
      AppMethodBeat.o(289995);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(289995);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ad localad = (ad)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(289995);
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
            localad.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(289995);
          return 0;
        case 2: 
          localad.key = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(289995);
          return 0;
        }
        localad.Tpz = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(289995);
        return 0;
      }
      AppMethodBeat.o(289995);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.ad
 * JD-Core Version:    0.7.0.1
 */