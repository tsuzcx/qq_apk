package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqv
  extends erp
{
  public String MEp;
  public String UZA;
  public int UZF;
  public String YGa;
  public int day;
  public String hAk;
  public long ihV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91545);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.UZF);
      if (this.hAk != null) {
        paramVarArgs.g(3, this.hAk);
      }
      if (this.MEp != null) {
        paramVarArgs.g(4, this.MEp);
      }
      if (this.UZA != null) {
        paramVarArgs.g(5, this.UZA);
      }
      paramVarArgs.bv(6, this.ihV);
      paramVarArgs.bS(7, this.day);
      if (this.YGa != null) {
        paramVarArgs.g(8, this.YGa);
      }
      AppMethodBeat.o(91545);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label660;
      }
    }
    label660:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.UZF);
      paramInt = i;
      if (this.hAk != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.hAk);
      }
      i = paramInt;
      if (this.MEp != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.MEp);
      }
      paramInt = i;
      if (this.UZA != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.UZA);
      }
      i = paramInt + i.a.a.b.b.a.q(6, this.ihV) + i.a.a.b.b.a.cJ(7, this.day);
      paramInt = i;
      if (this.YGa != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.YGa);
      }
      AppMethodBeat.o(91545);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91545);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dqv localdqv = (dqv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91545);
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
            localdqv.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(91545);
          return 0;
        case 2: 
          localdqv.UZF = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91545);
          return 0;
        case 3: 
          localdqv.hAk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91545);
          return 0;
        case 4: 
          localdqv.MEp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91545);
          return 0;
        case 5: 
          localdqv.UZA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91545);
          return 0;
        case 6: 
          localdqv.ihV = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(91545);
          return 0;
        case 7: 
          localdqv.day = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91545);
          return 0;
        }
        localdqv.YGa = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91545);
        return 0;
      }
      AppMethodBeat.o(91545);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqv
 * JD-Core Version:    0.7.0.1
 */