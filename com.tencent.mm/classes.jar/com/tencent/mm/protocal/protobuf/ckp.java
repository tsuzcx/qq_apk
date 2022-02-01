package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ckp
  extends com.tencent.mm.bx.a
{
  public String CwR;
  public String CwS;
  public int CwW;
  public String CwX;
  public dos Hec;
  public cbi Hed;
  public bze Hee;
  public long dOa;
  public String dkR;
  public int fKG;
  public int state;
  public String uJF;
  public String wCE;
  public String xSd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91618);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.fKG);
      paramVarArgs.aY(2, this.dOa);
      if (this.dkR != null) {
        paramVarArgs.d(3, this.dkR);
      }
      if (this.wCE != null) {
        paramVarArgs.d(4, this.wCE);
      }
      if (this.CwR != null) {
        paramVarArgs.d(5, this.CwR);
      }
      if (this.CwS != null) {
        paramVarArgs.d(6, this.CwS);
      }
      if (this.Hec != null)
      {
        paramVarArgs.lC(7, this.Hec.computeSize());
        this.Hec.writeFields(paramVarArgs);
      }
      if (this.Hed != null)
      {
        paramVarArgs.lC(8, this.Hed.computeSize());
        this.Hed.writeFields(paramVarArgs);
      }
      if (this.Hee != null)
      {
        paramVarArgs.lC(9, this.Hee.computeSize());
        this.Hee.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(10, this.CwW);
      paramVarArgs.aS(11, this.state);
      if (this.uJF != null) {
        paramVarArgs.d(12, this.uJF);
      }
      if (this.xSd != null) {
        paramVarArgs.d(13, this.xSd);
      }
      if (this.CwX != null) {
        paramVarArgs.d(14, this.CwX);
      }
      AppMethodBeat.o(91618);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.fKG) + 0 + f.a.a.b.b.a.p(2, this.dOa);
      paramInt = i;
      if (this.dkR != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dkR);
      }
      i = paramInt;
      if (this.wCE != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.wCE);
      }
      paramInt = i;
      if (this.CwR != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CwR);
      }
      i = paramInt;
      if (this.CwS != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.CwS);
      }
      paramInt = i;
      if (this.Hec != null) {
        paramInt = i + f.a.a.a.lB(7, this.Hec.computeSize());
      }
      i = paramInt;
      if (this.Hed != null) {
        i = paramInt + f.a.a.a.lB(8, this.Hed.computeSize());
      }
      paramInt = i;
      if (this.Hee != null) {
        paramInt = i + f.a.a.a.lB(9, this.Hee.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.CwW) + f.a.a.b.b.a.bz(11, this.state);
      paramInt = i;
      if (this.uJF != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.uJF);
      }
      i = paramInt;
      if (this.xSd != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.xSd);
      }
      paramInt = i;
      if (this.CwX != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.CwX);
      }
      AppMethodBeat.o(91618);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91618);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ckp localckp = (ckp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91618);
        return -1;
      case 1: 
        localckp.fKG = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91618);
        return 0;
      case 2: 
        localckp.dOa = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(91618);
        return 0;
      case 3: 
        localckp.dkR = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 4: 
        localckp.wCE = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 5: 
        localckp.CwR = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 6: 
        localckp.CwS = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dos();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dos)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localckp.Hec = ((dos)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91618);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cbi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cbi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localckp.Hed = ((cbi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91618);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bze();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bze)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localckp.Hee = ((bze)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91618);
        return 0;
      case 10: 
        localckp.CwW = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91618);
        return 0;
      case 11: 
        localckp.state = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91618);
        return 0;
      case 12: 
        localckp.uJF = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 13: 
        localckp.xSd = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91618);
        return 0;
      }
      localckp.CwX = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(91618);
      return 0;
    }
    AppMethodBeat.o(91618);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckp
 * JD-Core Version:    0.7.0.1
 */