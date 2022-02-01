package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cpx
  extends erp
{
  public String aawr;
  public String aaws;
  public int crz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91504);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.aawr != null) {
        paramVarArgs.g(2, this.aawr);
      }
      paramVarArgs.bS(3, this.crz);
      if (this.aaws != null) {
        paramVarArgs.g(4, this.aaws);
      }
      AppMethodBeat.o(91504);
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
      int i = paramInt;
      if (this.aawr != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.aawr);
      }
      i += i.a.a.b.b.a.cJ(3, this.crz);
      paramInt = i;
      if (this.aaws != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaws);
      }
      AppMethodBeat.o(91504);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91504);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cpx localcpx = (cpx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91504);
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
            localcpx.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(91504);
          return 0;
        case 2: 
          localcpx.aawr = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91504);
          return 0;
        case 3: 
          localcpx.crz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91504);
          return 0;
        }
        localcpx.aaws = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91504);
        return 0;
      }
      AppMethodBeat.o(91504);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpx
 * JD-Core Version:    0.7.0.1
 */