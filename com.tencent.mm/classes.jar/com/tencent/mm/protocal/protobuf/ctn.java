package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ctn
  extends erp
{
  public int Zby;
  public String aazm;
  public String aazn;
  public int aazo;
  public int aazp = 4;
  public String appid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123580);
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
      if (this.aazm != null) {
        paramVarArgs.g(3, this.aazm);
      }
      if (this.aazn != null) {
        paramVarArgs.g(4, this.aazn);
      }
      paramVarArgs.bS(5, this.Zby);
      paramVarArgs.bS(6, this.aazo);
      paramVarArgs.bS(7, this.aazp);
      AppMethodBeat.o(123580);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label604;
      }
    }
    label604:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.appid);
      }
      i = paramInt;
      if (this.aazm != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aazm);
      }
      paramInt = i;
      if (this.aazn != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aazn);
      }
      i = i.a.a.b.b.a.cJ(5, this.Zby);
      int j = i.a.a.b.b.a.cJ(6, this.aazo);
      int k = i.a.a.b.b.a.cJ(7, this.aazp);
      AppMethodBeat.o(123580);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123580);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ctn localctn = (ctn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123580);
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
            localctn.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(123580);
          return 0;
        case 2: 
          localctn.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123580);
          return 0;
        case 3: 
          localctn.aazm = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123580);
          return 0;
        case 4: 
          localctn.aazn = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123580);
          return 0;
        case 5: 
          localctn.Zby = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(123580);
          return 0;
        case 6: 
          localctn.aazo = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(123580);
          return 0;
        }
        localctn.aazp = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(123580);
        return 0;
      }
      AppMethodBeat.o(123580);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctn
 * JD-Core Version:    0.7.0.1
 */