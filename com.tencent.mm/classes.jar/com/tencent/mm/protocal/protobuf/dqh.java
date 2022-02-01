package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqh
  extends erp
{
  public String aaWD;
  public int aaWE;
  public int aaWF;
  public int aaWG;
  public String appid;
  public int iaK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74664);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appid != null) {
        paramVarArgs.g(2, this.appid);
      }
      if (this.aaWD != null) {
        paramVarArgs.g(3, this.aaWD);
      }
      paramVarArgs.bS(4, this.aaWE);
      paramVarArgs.bS(5, this.aaWF);
      paramVarArgs.bS(6, this.aaWG);
      paramVarArgs.bS(7, this.iaK);
      AppMethodBeat.o(74664);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label592;
      }
    }
    label592:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.appid);
      }
      i = paramInt;
      if (this.aaWD != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaWD);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.aaWE);
      int j = i.a.a.b.b.a.cJ(5, this.aaWF);
      int k = i.a.a.b.b.a.cJ(6, this.aaWG);
      int m = i.a.a.b.b.a.cJ(7, this.iaK);
      AppMethodBeat.o(74664);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(74664);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dqh localdqh = (dqh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74664);
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
            localdqh.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(74664);
          return 0;
        case 2: 
          localdqh.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(74664);
          return 0;
        case 3: 
          localdqh.aaWD = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(74664);
          return 0;
        case 4: 
          localdqh.aaWE = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(74664);
          return 0;
        case 5: 
          localdqh.aaWF = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(74664);
          return 0;
        case 6: 
          localdqh.aaWG = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(74664);
          return 0;
        }
        localdqh.iaK = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(74664);
        return 0;
      }
      AppMethodBeat.o(74664);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqh
 * JD-Core Version:    0.7.0.1
 */