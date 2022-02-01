package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ym
  extends erp
{
  public String Zhd;
  public int channel;
  public String wYJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72439);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.wYJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: qrcode_url");
        AppMethodBeat.o(72439);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wYJ != null) {
        paramVarArgs.g(2, this.wYJ);
      }
      paramVarArgs.bS(3, this.channel);
      if (this.Zhd != null) {
        paramVarArgs.g(4, this.Zhd);
      }
      AppMethodBeat.o(72439);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label496;
      }
    }
    label496:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wYJ != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.wYJ);
      }
      i += i.a.a.b.b.a.cJ(3, this.channel);
      paramInt = i;
      if (this.Zhd != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zhd);
      }
      AppMethodBeat.o(72439);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.wYJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: qrcode_url");
          AppMethodBeat.o(72439);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72439);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ym localym = (ym)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72439);
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
            localym.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(72439);
          return 0;
        case 2: 
          localym.wYJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72439);
          return 0;
        case 3: 
          localym.channel = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72439);
          return 0;
        }
        localym.Zhd = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72439);
        return 0;
      }
      AppMethodBeat.o(72439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ym
 * JD-Core Version:    0.7.0.1
 */