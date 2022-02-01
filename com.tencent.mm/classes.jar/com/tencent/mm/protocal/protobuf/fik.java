package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fik
  extends erp
{
  public String UserName;
  public String ZrX;
  public long abDv;
  public int ytH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118444);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.g(2, this.UserName);
      }
      paramVarArgs.bS(3, this.ytH);
      if (this.ZrX != null) {
        paramVarArgs.g(4, this.ZrX);
      }
      paramVarArgs.bv(5, this.abDv);
      AppMethodBeat.o(118444);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label492;
      }
    }
    label492:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UserName != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.UserName);
      }
      i += i.a.a.b.b.a.cJ(3, this.ytH);
      paramInt = i;
      if (this.ZrX != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZrX);
      }
      i = i.a.a.b.b.a.q(5, this.abDv);
      AppMethodBeat.o(118444);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(118444);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fik localfik = (fik)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118444);
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
            localfik.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(118444);
          return 0;
        case 2: 
          localfik.UserName = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(118444);
          return 0;
        case 3: 
          localfik.ytH = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(118444);
          return 0;
        case 4: 
          localfik.ZrX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(118444);
          return 0;
        }
        localfik.abDv = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(118444);
        return 0;
      }
      AppMethodBeat.o(118444);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fik
 * JD-Core Version:    0.7.0.1
 */