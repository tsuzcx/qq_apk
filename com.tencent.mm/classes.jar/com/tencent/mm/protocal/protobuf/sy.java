package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sy
  extends com.tencent.mm.bx.a
{
  public String FPP;
  public String FQC;
  public int FQa;
  public String FQb;
  public tg FQc;
  public String FQd;
  public String FrW;
  public String dHX;
  public int mrl;
  public String oze;
  public String pkr;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215410);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dHX != null) {
        paramVarArgs.d(1, this.dHX);
      }
      if (this.FrW != null) {
        paramVarArgs.d(2, this.FrW);
      }
      if (this.title != null) {
        paramVarArgs.d(3, this.title);
      }
      if (this.oze != null) {
        paramVarArgs.d(4, this.oze);
      }
      if (this.FQC != null) {
        paramVarArgs.d(5, this.FQC);
      }
      if (this.FPP != null) {
        paramVarArgs.d(6, this.FPP);
      }
      paramVarArgs.aS(7, this.mrl);
      if (this.pkr != null) {
        paramVarArgs.d(8, this.pkr);
      }
      paramVarArgs.aS(9, this.FQa);
      if (this.FQb != null) {
        paramVarArgs.d(10, this.FQb);
      }
      if (this.FQc != null)
      {
        paramVarArgs.lC(11, this.FQc.computeSize());
        this.FQc.writeFields(paramVarArgs);
      }
      if (this.FQd != null) {
        paramVarArgs.d(12, this.FQd);
      }
      AppMethodBeat.o(215410);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dHX == null) {
        break label954;
      }
    }
    label954:
    for (int i = f.a.a.b.b.a.e(1, this.dHX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FrW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FrW);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.title);
      }
      paramInt = i;
      if (this.oze != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oze);
      }
      i = paramInt;
      if (this.FQC != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FQC);
      }
      paramInt = i;
      if (this.FPP != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FPP);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.mrl);
      paramInt = i;
      if (this.pkr != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.pkr);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.FQa);
      paramInt = i;
      if (this.FQb != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FQb);
      }
      i = paramInt;
      if (this.FQc != null) {
        i = paramInt + f.a.a.a.lB(11, this.FQc.computeSize());
      }
      paramInt = i;
      if (this.FQd != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FQd);
      }
      AppMethodBeat.o(215410);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(215410);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        sy localsy = (sy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(215410);
          return -1;
        case 1: 
          localsy.dHX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215410);
          return 0;
        case 2: 
          localsy.FrW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215410);
          return 0;
        case 3: 
          localsy.title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215410);
          return 0;
        case 4: 
          localsy.oze = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215410);
          return 0;
        case 5: 
          localsy.FQC = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215410);
          return 0;
        case 6: 
          localsy.FPP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215410);
          return 0;
        case 7: 
          localsy.mrl = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215410);
          return 0;
        case 8: 
          localsy.pkr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215410);
          return 0;
        case 9: 
          localsy.FQa = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215410);
          return 0;
        case 10: 
          localsy.FQb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215410);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((tg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsy.FQc = ((tg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215410);
          return 0;
        }
        localsy.FQd = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(215410);
        return 0;
      }
      AppMethodBeat.o(215410);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sy
 * JD-Core Version:    0.7.0.1
 */