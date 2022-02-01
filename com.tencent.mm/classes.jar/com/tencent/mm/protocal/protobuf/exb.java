package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class exb
  extends erp
{
  public String UserName;
  public int abab;
  public String abzf;
  public int bcb;
  public String nUB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152688);
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
      if (this.nUB != null) {
        paramVarArgs.g(3, this.nUB);
      }
      paramVarArgs.bS(4, this.abab);
      paramVarArgs.bS(5, this.bcb);
      if (this.abzf != null) {
        paramVarArgs.g(6, this.abzf);
      }
      AppMethodBeat.o(152688);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label552;
      }
    }
    label552:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.UserName);
      }
      i = paramInt;
      if (this.nUB != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.nUB);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.abab) + i.a.a.b.b.a.cJ(5, this.bcb);
      paramInt = i;
      if (this.abzf != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abzf);
      }
      AppMethodBeat.o(152688);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152688);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        exb localexb = (exb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152688);
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
            localexb.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(152688);
          return 0;
        case 2: 
          localexb.UserName = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152688);
          return 0;
        case 3: 
          localexb.nUB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152688);
          return 0;
        case 4: 
          localexb.abab = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152688);
          return 0;
        case 5: 
          localexb.bcb = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152688);
          return 0;
        }
        localexb.abzf = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152688);
        return 0;
      }
      AppMethodBeat.o(152688);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exb
 * JD-Core Version:    0.7.0.1
 */