package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class eig
  extends erp
{
  public String IMh;
  public long ZvA;
  public int Zvz;
  public long abmO;
  public long abmR;
  public int vhk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32388);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IMh == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(32388);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.IMh != null) {
        paramVarArgs.g(2, this.IMh);
      }
      paramVarArgs.bS(3, this.Zvz);
      paramVarArgs.bv(4, this.ZvA);
      paramVarArgs.bv(5, this.abmO);
      paramVarArgs.bv(6, this.abmR);
      paramVarArgs.bS(7, this.vhk);
      AppMethodBeat.o(32388);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label641;
      }
    }
    label641:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IMh != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.IMh);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.Zvz);
      int j = i.a.a.b.b.a.q(4, this.ZvA);
      int k = i.a.a.b.b.a.q(5, this.abmO);
      int m = i.a.a.b.b.a.q(6, this.abmR);
      int n = i.a.a.b.b.a.cJ(7, this.vhk);
      AppMethodBeat.o(32388);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.IMh == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(32388);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32388);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eig localeig = (eig)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32388);
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
            localeig.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(32388);
          return 0;
        case 2: 
          localeig.IMh = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32388);
          return 0;
        case 3: 
          localeig.Zvz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32388);
          return 0;
        case 4: 
          localeig.ZvA = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(32388);
          return 0;
        case 5: 
          localeig.abmO = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(32388);
          return 0;
        case 6: 
          localeig.abmR = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(32388);
          return 0;
        }
        localeig.vhk = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32388);
        return 0;
      }
      AppMethodBeat.o(32388);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eig
 * JD-Core Version:    0.7.0.1
 */