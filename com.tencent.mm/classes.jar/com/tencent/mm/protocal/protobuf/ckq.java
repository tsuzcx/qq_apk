package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ckq
  extends erp
{
  public int NkN;
  public int NkO;
  public String UserName;
  public int aasO;
  public int aasP;
  public String aasQ;
  public int aasR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152570);
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
      paramVarArgs.bS(3, this.aasO);
      paramVarArgs.bS(4, this.aasP);
      if (this.aasQ != null) {
        paramVarArgs.g(5, this.aasQ);
      }
      paramVarArgs.bS(6, this.NkN);
      paramVarArgs.bS(7, this.NkO);
      paramVarArgs.bS(8, this.aasR);
      AppMethodBeat.o(152570);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label632;
      }
    }
    label632:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UserName != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.UserName);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.aasO) + i.a.a.b.b.a.cJ(4, this.aasP);
      paramInt = i;
      if (this.aasQ != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aasQ);
      }
      i = i.a.a.b.b.a.cJ(6, this.NkN);
      int j = i.a.a.b.b.a.cJ(7, this.NkO);
      int k = i.a.a.b.b.a.cJ(8, this.aasR);
      AppMethodBeat.o(152570);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152570);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ckq localckq = (ckq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152570);
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
            localckq.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(152570);
          return 0;
        case 2: 
          localckq.UserName = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152570);
          return 0;
        case 3: 
          localckq.aasO = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152570);
          return 0;
        case 4: 
          localckq.aasP = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152570);
          return 0;
        case 5: 
          localckq.aasQ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152570);
          return 0;
        case 6: 
          localckq.NkN = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152570);
          return 0;
        case 7: 
          localckq.NkO = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152570);
          return 0;
        }
        localckq.aasR = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(152570);
        return 0;
      }
      AppMethodBeat.o(152570);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckq
 * JD-Core Version:    0.7.0.1
 */