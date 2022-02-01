package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class eii
  extends erp
{
  public long ZvA;
  public int Zvz;
  public long abmO;
  public long abmR;
  public String abnl;
  public int abnm;
  public int abnn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32390);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abnl == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUsername");
        AppMethodBeat.o(32390);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abnl != null) {
        paramVarArgs.g(2, this.abnl);
      }
      paramVarArgs.bS(3, this.Zvz);
      paramVarArgs.bv(4, this.ZvA);
      paramVarArgs.bv(5, this.abmO);
      paramVarArgs.bS(6, this.abnm);
      paramVarArgs.bv(7, this.abmR);
      paramVarArgs.bS(8, this.abnn);
      AppMethodBeat.o(32390);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abnl != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abnl);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.Zvz);
      int j = i.a.a.b.b.a.q(4, this.ZvA);
      int k = i.a.a.b.b.a.q(5, this.abmO);
      int m = i.a.a.b.b.a.cJ(6, this.abnm);
      int n = i.a.a.b.b.a.q(7, this.abmR);
      int i1 = i.a.a.b.b.a.cJ(8, this.abnn);
      AppMethodBeat.o(32390);
      return i + paramInt + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abnl == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUsername");
          AppMethodBeat.o(32390);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32390);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eii localeii = (eii)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32390);
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
            localeii.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(32390);
          return 0;
        case 2: 
          localeii.abnl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32390);
          return 0;
        case 3: 
          localeii.Zvz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32390);
          return 0;
        case 4: 
          localeii.ZvA = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(32390);
          return 0;
        case 5: 
          localeii.abmO = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(32390);
          return 0;
        case 6: 
          localeii.abnm = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32390);
          return 0;
        case 7: 
          localeii.abmR = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(32390);
          return 0;
        }
        localeii.abnn = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32390);
        return 0;
      }
      AppMethodBeat.o(32390);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eii
 * JD-Core Version:    0.7.0.1
 */