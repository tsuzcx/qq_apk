package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class am
  extends erp
{
  public String YBb;
  public String YBc;
  public int YBd;
  public int YBe;
  public fhj YBf;
  public String from_username;
  public String iaI;
  public String iaJ;
  public int iaK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113922);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.iaI == null)
      {
        paramVarArgs = new b("Not all required fields were included: card_id");
        AppMethodBeat.o(113922);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.from_username != null) {
        paramVarArgs.g(2, this.from_username);
      }
      paramVarArgs.bS(3, this.iaK);
      if (this.iaI != null) {
        paramVarArgs.g(4, this.iaI);
      }
      if (this.iaJ != null) {
        paramVarArgs.g(5, this.iaJ);
      }
      if (this.YBb != null) {
        paramVarArgs.g(6, this.YBb);
      }
      if (this.YBc != null) {
        paramVarArgs.g(7, this.YBc);
      }
      paramVarArgs.bS(8, this.YBd);
      paramVarArgs.bS(9, this.YBe);
      if (this.YBf != null)
      {
        paramVarArgs.qD(10, this.YBf.computeSize());
        this.YBf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(113922);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label906;
      }
    }
    label906:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.from_username != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.from_username);
      }
      i += i.a.a.b.b.a.cJ(3, this.iaK);
      paramInt = i;
      if (this.iaI != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.iaI);
      }
      i = paramInt;
      if (this.iaJ != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.iaJ);
      }
      paramInt = i;
      if (this.YBb != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YBb);
      }
      i = paramInt;
      if (this.YBc != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.YBc);
      }
      i = i + i.a.a.b.b.a.cJ(8, this.YBd) + i.a.a.b.b.a.cJ(9, this.YBe);
      paramInt = i;
      if (this.YBf != null) {
        paramInt = i + i.a.a.a.qC(10, this.YBf.computeSize());
      }
      AppMethodBeat.o(113922);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.iaI == null)
        {
          paramVarArgs = new b("Not all required fields were included: card_id");
          AppMethodBeat.o(113922);
          throw paramVarArgs;
        }
        AppMethodBeat.o(113922);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        am localam = (am)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113922);
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
            localam.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113922);
          return 0;
        case 2: 
          localam.from_username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 3: 
          localam.iaK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(113922);
          return 0;
        case 4: 
          localam.iaI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 5: 
          localam.iaJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 6: 
          localam.YBb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 7: 
          localam.YBc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 8: 
          localam.YBd = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(113922);
          return 0;
        case 9: 
          localam.YBe = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(113922);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fhj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fhj)localObject2).parseFrom((byte[])localObject1);
          }
          localam.YBf = ((fhj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(113922);
        return 0;
      }
      AppMethodBeat.o(113922);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.am
 * JD-Core Version:    0.7.0.1
 */