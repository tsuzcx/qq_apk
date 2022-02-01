package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class gkt
  extends erp
{
  public aeo YMR;
  public b YRt;
  public String aaLT;
  public String aaLU;
  public String acgG;
  public int acgH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123696);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.aaLU != null) {
        paramVarArgs.g(2, this.aaLU);
      }
      if (this.YRt != null) {
        paramVarArgs.d(3, this.YRt);
      }
      if (this.acgG != null) {
        paramVarArgs.g(4, this.acgG);
      }
      if (this.aaLT != null) {
        paramVarArgs.g(5, this.aaLT);
      }
      paramVarArgs.bS(6, this.acgH);
      if (this.YMR != null)
      {
        paramVarArgs.qD(7, this.YMR.computeSize());
        this.YMR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123696);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label706;
      }
    }
    label706:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaLU != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaLU);
      }
      i = paramInt;
      if (this.YRt != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.YRt);
      }
      paramInt = i;
      if (this.acgG != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.acgG);
      }
      i = paramInt;
      if (this.aaLT != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaLT);
      }
      i += i.a.a.b.b.a.cJ(6, this.acgH);
      paramInt = i;
      if (this.YMR != null) {
        paramInt = i + i.a.a.a.qC(7, this.YMR.computeSize());
      }
      AppMethodBeat.o(123696);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123696);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gkt localgkt = (gkt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123696);
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
            localgkt.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123696);
          return 0;
        case 2: 
          localgkt.aaLU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123696);
          return 0;
        case 3: 
          localgkt.YRt = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(123696);
          return 0;
        case 4: 
          localgkt.acgG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123696);
          return 0;
        case 5: 
          localgkt.aaLT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123696);
          return 0;
        case 6: 
          localgkt.acgH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123696);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aeo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aeo)localObject2).parseFrom((byte[])localObject1);
          }
          localgkt.YMR = ((aeo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123696);
        return 0;
      }
      AppMethodBeat.o(123696);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gkt
 * JD-Core Version:    0.7.0.1
 */