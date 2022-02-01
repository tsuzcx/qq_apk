package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class aoa
  extends erp
{
  public int IcB;
  public String YRs;
  public b ZqS;
  public b ZvE;
  public int ZvF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124485);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YRs != null) {
        paramVarArgs.g(2, this.YRs);
      }
      paramVarArgs.bS(3, this.IcB);
      if (this.ZvE != null) {
        paramVarArgs.d(4, this.ZvE);
      }
      if (this.ZqS != null) {
        paramVarArgs.d(5, this.ZqS);
      }
      paramVarArgs.bS(6, this.ZvF);
      AppMethodBeat.o(124485);
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
      int i = paramInt;
      if (this.YRs != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YRs);
      }
      i += i.a.a.b.b.a.cJ(3, this.IcB);
      paramInt = i;
      if (this.ZvE != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.ZvE);
      }
      i = paramInt;
      if (this.ZqS != null) {
        i = paramInt + i.a.a.b.b.a.c(5, this.ZqS);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.ZvF);
      AppMethodBeat.o(124485);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        aoa localaoa = (aoa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124485);
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
            localaoa.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(124485);
          return 0;
        case 2: 
          localaoa.YRs = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124485);
          return 0;
        case 3: 
          localaoa.IcB = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124485);
          return 0;
        case 4: 
          localaoa.ZvE = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(124485);
          return 0;
        case 5: 
          localaoa.ZqS = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(124485);
          return 0;
        }
        localaoa.ZvF = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(124485);
        return 0;
      }
      AppMethodBeat.o(124485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoa
 * JD-Core Version:    0.7.0.1
 */