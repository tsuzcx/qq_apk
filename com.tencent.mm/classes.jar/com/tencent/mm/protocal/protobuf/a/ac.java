package com.tencent.mm.protocal.protobuf.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import java.util.LinkedList;

public final class ac
  extends erp
{
  public String SessionId;
  public int YYs;
  public String acjv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259712);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.acjv != null) {
        paramVarArgs.g(2, this.acjv);
      }
      paramVarArgs.bS(3, this.YYs);
      if (this.SessionId != null) {
        paramVarArgs.g(4, this.SessionId);
      }
      AppMethodBeat.o(259712);
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
      if (this.acjv != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.acjv);
      }
      i += i.a.a.b.b.a.cJ(3, this.YYs);
      paramInt = i;
      if (this.SessionId != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.SessionId);
      }
      AppMethodBeat.o(259712);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259712);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ac localac = (ac)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259712);
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
            localac.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(259712);
          return 0;
        case 2: 
          localac.acjv = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259712);
          return 0;
        case 3: 
          localac.YYs = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259712);
          return 0;
        }
        localac.SessionId = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259712);
        return 0;
      }
      AppMethodBeat.o(259712);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.a.ac
 * JD-Core Version:    0.7.0.1
 */