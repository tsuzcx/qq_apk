package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ffz
  extends erp
{
  public long Tqa;
  public int abFU;
  public int limit;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257982);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.g(2, this.username);
      }
      paramVarArgs.bv(3, this.Tqa);
      paramVarArgs.bS(4, this.limit);
      paramVarArgs.bS(5, this.abFU);
      AppMethodBeat.o(257982);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label480;
      }
    }
    label480:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.username);
      }
      paramInt = i.a.a.b.b.a.q(3, this.Tqa);
      int j = i.a.a.b.b.a.cJ(4, this.limit);
      int k = i.a.a.b.b.a.cJ(5, this.abFU);
      AppMethodBeat.o(257982);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257982);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ffz localffz = (ffz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257982);
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
            localffz.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(257982);
          return 0;
        case 2: 
          localffz.username = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257982);
          return 0;
        case 3: 
          localffz.Tqa = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(257982);
          return 0;
        case 4: 
          localffz.limit = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257982);
          return 0;
        }
        localffz.abFU = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257982);
        return 0;
      }
      AppMethodBeat.o(257982);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffz
 * JD-Core Version:    0.7.0.1
 */