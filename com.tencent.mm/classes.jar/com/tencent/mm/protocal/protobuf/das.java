package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class das
  extends dop
{
  public int KCx;
  public int LbX;
  public bf Lcc;
  public String MFU;
  public String MFV;
  public b MFW;
  public int MFX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91598);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MFU != null) {
        paramVarArgs.e(2, this.MFU);
      }
      if (this.MFV != null) {
        paramVarArgs.e(3, this.MFV);
      }
      if (this.MFW != null) {
        paramVarArgs.c(4, this.MFW);
      }
      paramVarArgs.aM(5, this.LbX);
      paramVarArgs.aM(6, this.KCx);
      paramVarArgs.aM(7, this.MFX);
      if (this.Lcc != null)
      {
        paramVarArgs.ni(8, this.Lcc.computeSize());
        this.Lcc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91598);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label778;
      }
    }
    label778:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MFU != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MFU);
      }
      i = paramInt;
      if (this.MFV != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MFV);
      }
      paramInt = i;
      if (this.MFW != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.MFW);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.LbX) + g.a.a.b.b.a.bu(6, this.KCx) + g.a.a.b.b.a.bu(7, this.MFX);
      paramInt = i;
      if (this.Lcc != null) {
        paramInt = i + g.a.a.a.nh(8, this.Lcc.computeSize());
      }
      AppMethodBeat.o(91598);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91598);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        das localdas = (das)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91598);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdas.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91598);
          return 0;
        case 2: 
          localdas.MFU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91598);
          return 0;
        case 3: 
          localdas.MFV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91598);
          return 0;
        case 4: 
          localdas.MFW = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(91598);
          return 0;
        case 5: 
          localdas.LbX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91598);
          return 0;
        case 6: 
          localdas.KCx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91598);
          return 0;
        case 7: 
          localdas.MFX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91598);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bf();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdas.Lcc = ((bf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91598);
        return 0;
      }
      AppMethodBeat.o(91598);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.das
 * JD-Core Version:    0.7.0.1
 */