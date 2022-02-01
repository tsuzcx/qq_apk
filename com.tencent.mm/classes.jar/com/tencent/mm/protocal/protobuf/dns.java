package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dns
  extends erp
{
  public long AyP;
  public long NIs;
  public dnf aaUG;
  public String aahV;
  public int opType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258472);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.aaUG != null)
      {
        paramVarArgs.qD(2, this.aaUG.computeSize());
        this.aaUG.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(3, this.NIs);
      paramVarArgs.bS(4, this.opType);
      paramVarArgs.bv(5, this.AyP);
      if (this.aahV != null) {
        paramVarArgs.g(6, this.aahV);
      }
      AppMethodBeat.o(258472);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label606;
      }
    }
    label606:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaUG != null) {
        i = paramInt + i.a.a.a.qC(2, this.aaUG.computeSize());
      }
      i = i + i.a.a.b.b.a.q(3, this.NIs) + i.a.a.b.b.a.cJ(4, this.opType) + i.a.a.b.b.a.q(5, this.AyP);
      paramInt = i;
      if (this.aahV != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aahV);
      }
      AppMethodBeat.o(258472);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258472);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dns localdns = (dns)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258472);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localdns.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258472);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dnf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dnf)localObject2).parseFrom((byte[])localObject1);
            }
            localdns.aaUG = ((dnf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258472);
          return 0;
        case 3: 
          localdns.NIs = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258472);
          return 0;
        case 4: 
          localdns.opType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258472);
          return 0;
        case 5: 
          localdns.AyP = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258472);
          return 0;
        }
        localdns.aahV = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258472);
        return 0;
      }
      AppMethodBeat.o(258472);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dns
 * JD-Core Version:    0.7.0.1
 */