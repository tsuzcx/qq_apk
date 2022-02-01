package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eht
  extends erp
{
  public String IMg;
  public long ZvA;
  public int Zvz;
  public long abmO;
  public int abmP;
  public String abmQ;
  public long abmR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32372);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.Zvz);
      paramVarArgs.bv(3, this.ZvA);
      if (this.IMg != null) {
        paramVarArgs.g(4, this.IMg);
      }
      paramVarArgs.bv(5, this.abmO);
      paramVarArgs.bS(6, this.abmP);
      if (this.abmQ != null) {
        paramVarArgs.g(7, this.abmQ);
      }
      paramVarArgs.bv(8, this.abmR);
      AppMethodBeat.o(32372);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.Zvz) + i.a.a.b.b.a.q(3, this.ZvA);
      paramInt = i;
      if (this.IMg != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IMg);
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.abmO) + i.a.a.b.b.a.cJ(6, this.abmP);
      paramInt = i;
      if (this.abmQ != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abmQ);
      }
      i = i.a.a.b.b.a.q(8, this.abmR);
      AppMethodBeat.o(32372);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32372);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eht localeht = (eht)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32372);
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
            localeht.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(32372);
          return 0;
        case 2: 
          localeht.Zvz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32372);
          return 0;
        case 3: 
          localeht.ZvA = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(32372);
          return 0;
        case 4: 
          localeht.IMg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32372);
          return 0;
        case 5: 
          localeht.abmO = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(32372);
          return 0;
        case 6: 
          localeht.abmP = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32372);
          return 0;
        case 7: 
          localeht.abmQ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32372);
          return 0;
        }
        localeht.abmR = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(32372);
        return 0;
      }
      AppMethodBeat.o(32372);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eht
 * JD-Core Version:    0.7.0.1
 */