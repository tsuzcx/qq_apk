package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xp
  extends cvc
{
  public String FDD;
  public bb FPa;
  public String FWa;
  public String FXe;
  public String FXf;
  public String FXg;
  public String FXh;
  public int FXi;
  public String FXj;
  public int FXk;
  public String FXl;
  public int Fva;
  public String iht;
  public String nDo;
  public String ujc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91416);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.iht != null) {
        paramVarArgs.d(2, this.iht);
      }
      if (this.FXe != null) {
        paramVarArgs.d(3, this.FXe);
      }
      if (this.FDD != null) {
        paramVarArgs.d(4, this.FDD);
      }
      if (this.FXf != null) {
        paramVarArgs.d(5, this.FXf);
      }
      if (this.FXg != null) {
        paramVarArgs.d(6, this.FXg);
      }
      if (this.FXh != null) {
        paramVarArgs.d(7, this.FXh);
      }
      if (this.FWa != null) {
        paramVarArgs.d(8, this.FWa);
      }
      paramVarArgs.aS(9, this.FXi);
      if (this.FPa != null)
      {
        paramVarArgs.lC(10, this.FPa.computeSize());
        this.FPa.writeFields(paramVarArgs);
      }
      if (this.FXj != null) {
        paramVarArgs.d(11, this.FXj);
      }
      if (this.nDo != null) {
        paramVarArgs.d(12, this.nDo);
      }
      if (this.ujc != null) {
        paramVarArgs.d(13, this.ujc);
      }
      paramVarArgs.aS(14, this.Fva);
      paramVarArgs.aS(15, this.FXk);
      if (this.FXl != null) {
        paramVarArgs.d(16, this.FXl);
      }
      AppMethodBeat.o(91416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1278;
      }
    }
    label1278:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iht != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iht);
      }
      i = paramInt;
      if (this.FXe != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FXe);
      }
      paramInt = i;
      if (this.FDD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FDD);
      }
      i = paramInt;
      if (this.FXf != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FXf);
      }
      paramInt = i;
      if (this.FXg != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FXg);
      }
      i = paramInt;
      if (this.FXh != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FXh);
      }
      paramInt = i;
      if (this.FWa != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FWa);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.FXi);
      paramInt = i;
      if (this.FPa != null) {
        paramInt = i + f.a.a.a.lB(10, this.FPa.computeSize());
      }
      i = paramInt;
      if (this.FXj != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.FXj);
      }
      paramInt = i;
      if (this.nDo != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.nDo);
      }
      i = paramInt;
      if (this.ujc != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.ujc);
      }
      i = i + f.a.a.b.b.a.bz(14, this.Fva) + f.a.a.b.b.a.bz(15, this.FXk);
      paramInt = i;
      if (this.FXl != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.FXl);
      }
      AppMethodBeat.o(91416);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91416);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        xp localxp = (xp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91416);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localxp.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91416);
          return 0;
        case 2: 
          localxp.iht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 3: 
          localxp.FXe = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 4: 
          localxp.FDD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 5: 
          localxp.FXf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 6: 
          localxp.FXg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 7: 
          localxp.FXh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 8: 
          localxp.FWa = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 9: 
          localxp.FXi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91416);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localxp.FPa = ((bb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91416);
          return 0;
        case 11: 
          localxp.FXj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 12: 
          localxp.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 13: 
          localxp.ujc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 14: 
          localxp.Fva = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91416);
          return 0;
        case 15: 
          localxp.FXk = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91416);
          return 0;
        }
        localxp.FXl = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91416);
        return 0;
      }
      AppMethodBeat.o(91416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xp
 * JD-Core Version:    0.7.0.1
 */