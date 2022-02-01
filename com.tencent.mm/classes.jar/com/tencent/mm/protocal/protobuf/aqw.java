package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqw
  extends erp
{
  public long Zyc;
  public String Zyd;
  public String Zyj;
  public String appid;
  public int source;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104365);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.Zyc);
      if (this.Zyj != null) {
        paramVarArgs.g(3, this.Zyj);
      }
      if (this.appid != null) {
        paramVarArgs.g(4, this.appid);
      }
      if (this.Zyd != null) {
        paramVarArgs.g(5, this.Zyd);
      }
      paramVarArgs.bS(6, this.source);
      AppMethodBeat.o(104365);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label556;
      }
    }
    label556:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.Zyc);
      paramInt = i;
      if (this.Zyj != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.Zyj);
      }
      i = paramInt;
      if (this.appid != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.appid);
      }
      paramInt = i;
      if (this.Zyd != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.Zyd);
      }
      i = i.a.a.b.b.a.cJ(6, this.source);
      AppMethodBeat.o(104365);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(104365);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        aqw localaqw = (aqw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104365);
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
            localaqw.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(104365);
          return 0;
        case 2: 
          localaqw.Zyc = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(104365);
          return 0;
        case 3: 
          localaqw.Zyj = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104365);
          return 0;
        case 4: 
          localaqw.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104365);
          return 0;
        case 5: 
          localaqw.Zyd = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104365);
          return 0;
        }
        localaqw.source = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(104365);
        return 0;
      }
      AppMethodBeat.o(104365);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqw
 * JD-Core Version:    0.7.0.1
 */