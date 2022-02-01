package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class oz
  extends dop
{
  public int KND;
  public String KRH;
  public String KRI;
  public int KRJ;
  public int KRK;
  public b KRc;
  public long KRi;
  public int KVT;
  public int source;
  public String xve;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212247);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.KRc != null) {
        paramVarArgs.c(2, this.KRc);
      }
      paramVarArgs.aM(3, this.source);
      if (this.xve != null) {
        paramVarArgs.e(5, this.xve);
      }
      if (this.KRH != null) {
        paramVarArgs.e(6, this.KRH);
      }
      if (this.KRI != null) {
        paramVarArgs.e(7, this.KRI);
      }
      paramVarArgs.aM(8, this.KVT);
      paramVarArgs.aM(9, this.KRJ);
      paramVarArgs.aM(10, this.KRK);
      paramVarArgs.bb(18, this.KRi);
      paramVarArgs.aM(22, this.KND);
      AppMethodBeat.o(212247);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label882;
      }
    }
    label882:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KRc != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.KRc);
      }
      i += g.a.a.b.b.a.bu(3, this.source);
      paramInt = i;
      if (this.xve != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.xve);
      }
      i = paramInt;
      if (this.KRH != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.KRH);
      }
      paramInt = i;
      if (this.KRI != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.KRI);
      }
      i = g.a.a.b.b.a.bu(8, this.KVT);
      int j = g.a.a.b.b.a.bu(9, this.KRJ);
      int k = g.a.a.b.b.a.bu(10, this.KRK);
      int m = g.a.a.b.b.a.r(18, this.KRi);
      int n = g.a.a.b.b.a.bu(22, this.KND);
      AppMethodBeat.o(212247);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(212247);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        oz localoz = (oz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 4: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 19: 
        case 20: 
        case 21: 
        default: 
          AppMethodBeat.o(212247);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localoz.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212247);
          return 0;
        case 2: 
          localoz.KRc = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(212247);
          return 0;
        case 3: 
          localoz.source = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(212247);
          return 0;
        case 5: 
          localoz.xve = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212247);
          return 0;
        case 6: 
          localoz.KRH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212247);
          return 0;
        case 7: 
          localoz.KRI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212247);
          return 0;
        case 8: 
          localoz.KVT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(212247);
          return 0;
        case 9: 
          localoz.KRJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(212247);
          return 0;
        case 10: 
          localoz.KRK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(212247);
          return 0;
        case 18: 
          localoz.KRi = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(212247);
          return 0;
        }
        localoz.KND = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(212247);
        return 0;
      }
      AppMethodBeat.o(212247);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oz
 * JD-Core Version:    0.7.0.1
 */