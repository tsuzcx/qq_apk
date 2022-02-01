package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class of
  extends com.tencent.mm.bw.a
{
  public int Gaz;
  public int KJJ;
  public int KSR;
  public int KSS;
  public int KTH;
  public int KTI;
  public acf KTJ;
  public int KTK;
  public int KTL;
  public int KTM = 0;
  public int KTN;
  public String content;
  public String iwv;
  public String openid;
  public String qFU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103203);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KTH);
      paramVarArgs.aM(2, this.KJJ);
      if (this.openid != null) {
        paramVarArgs.e(3, this.openid);
      }
      if (this.qFU != null) {
        paramVarArgs.e(4, this.qFU);
      }
      if (this.iwv != null) {
        paramVarArgs.e(5, this.iwv);
      }
      if (this.content != null) {
        paramVarArgs.e(6, this.content);
      }
      paramVarArgs.aM(7, this.Gaz);
      paramVarArgs.aM(8, this.KTI);
      paramVarArgs.aM(9, this.KSR);
      paramVarArgs.aM(10, this.KSS);
      if (this.KTJ != null)
      {
        paramVarArgs.ni(11, this.KTJ.computeSize());
        this.KTJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(12, this.KTK);
      paramVarArgs.aM(13, this.KTL);
      paramVarArgs.aM(14, this.KTM);
      paramVarArgs.aM(15, this.KTN);
      AppMethodBeat.o(103203);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.KTH) + 0 + g.a.a.b.b.a.bu(2, this.KJJ);
      paramInt = i;
      if (this.openid != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.openid);
      }
      i = paramInt;
      if (this.qFU != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.qFU);
      }
      paramInt = i;
      if (this.iwv != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.iwv);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.content);
      }
      i = i + g.a.a.b.b.a.bu(7, this.Gaz) + g.a.a.b.b.a.bu(8, this.KTI) + g.a.a.b.b.a.bu(9, this.KSR) + g.a.a.b.b.a.bu(10, this.KSS);
      paramInt = i;
      if (this.KTJ != null) {
        paramInt = i + g.a.a.a.nh(11, this.KTJ.computeSize());
      }
      i = g.a.a.b.b.a.bu(12, this.KTK);
      int j = g.a.a.b.b.a.bu(13, this.KTL);
      int k = g.a.a.b.b.a.bu(14, this.KTM);
      int m = g.a.a.b.b.a.bu(15, this.KTN);
      AppMethodBeat.o(103203);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(103203);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      of localof = (of)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(103203);
        return -1;
      case 1: 
        localof.KTH = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(103203);
        return 0;
      case 2: 
        localof.KJJ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(103203);
        return 0;
      case 3: 
        localof.openid = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 4: 
        localof.qFU = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 5: 
        localof.iwv = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 6: 
        localof.content = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 7: 
        localof.Gaz = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(103203);
        return 0;
      case 8: 
        localof.KTI = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(103203);
        return 0;
      case 9: 
        localof.KSR = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(103203);
        return 0;
      case 10: 
        localof.KSS = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(103203);
        return 0;
      case 11: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new acf();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((acf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localof.KTJ = ((acf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(103203);
        return 0;
      case 12: 
        localof.KTK = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(103203);
        return 0;
      case 13: 
        localof.KTL = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(103203);
        return 0;
      case 14: 
        localof.KTM = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(103203);
        return 0;
      }
      localof.KTN = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(103203);
      return 0;
    }
    AppMethodBeat.o(103203);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.of
 * JD-Core Version:    0.7.0.1
 */