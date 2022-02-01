package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sw
  extends com.tencent.mm.bx.a
{
  public int FQa;
  public String FQb;
  public tg FQc;
  public String FQd;
  public String FQk;
  public String FQl;
  public String FQm;
  public String FQn;
  public LinkedList<su> FQo;
  public LinkedList<st> FQp;
  public String FQq;
  public String FQr;
  public tg FQs;
  public su FQt;
  public int FQu;
  public int FQv;
  public int FQw;
  public long FQx;
  
  public sw()
  {
    AppMethodBeat.i(113954);
    this.FQo = new LinkedList();
    this.FQp = new LinkedList();
    AppMethodBeat.o(113954);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113955);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FQk != null) {
        paramVarArgs.d(1, this.FQk);
      }
      if (this.FQl != null) {
        paramVarArgs.d(2, this.FQl);
      }
      if (this.FQm != null) {
        paramVarArgs.d(3, this.FQm);
      }
      if (this.FQn != null) {
        paramVarArgs.d(4, this.FQn);
      }
      paramVarArgs.e(5, 8, this.FQo);
      paramVarArgs.aS(6, this.FQa);
      if (this.FQb != null) {
        paramVarArgs.d(7, this.FQb);
      }
      if (this.FQc != null)
      {
        paramVarArgs.lC(8, this.FQc.computeSize());
        this.FQc.writeFields(paramVarArgs);
      }
      if (this.FQd != null) {
        paramVarArgs.d(9, this.FQd);
      }
      paramVarArgs.e(10, 8, this.FQp);
      if (this.FQq != null) {
        paramVarArgs.d(11, this.FQq);
      }
      if (this.FQr != null) {
        paramVarArgs.d(12, this.FQr);
      }
      if (this.FQs != null)
      {
        paramVarArgs.lC(13, this.FQs.computeSize());
        this.FQs.writeFields(paramVarArgs);
      }
      if (this.FQt != null)
      {
        paramVarArgs.lC(14, this.FQt.computeSize());
        this.FQt.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(15, this.FQu);
      paramVarArgs.aS(16, this.FQv);
      paramVarArgs.aS(17, this.FQw);
      paramVarArgs.aY(18, this.FQx);
      AppMethodBeat.o(113955);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FQk == null) {
        break label1630;
      }
    }
    label1630:
    for (int i = f.a.a.b.b.a.e(1, this.FQk) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FQl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FQl);
      }
      i = paramInt;
      if (this.FQm != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FQm);
      }
      paramInt = i;
      if (this.FQn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FQn);
      }
      i = paramInt + f.a.a.a.c(5, 8, this.FQo) + f.a.a.b.b.a.bz(6, this.FQa);
      paramInt = i;
      if (this.FQb != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FQb);
      }
      i = paramInt;
      if (this.FQc != null) {
        i = paramInt + f.a.a.a.lB(8, this.FQc.computeSize());
      }
      paramInt = i;
      if (this.FQd != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FQd);
      }
      i = paramInt + f.a.a.a.c(10, 8, this.FQp);
      paramInt = i;
      if (this.FQq != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FQq);
      }
      i = paramInt;
      if (this.FQr != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.FQr);
      }
      paramInt = i;
      if (this.FQs != null) {
        paramInt = i + f.a.a.a.lB(13, this.FQs.computeSize());
      }
      i = paramInt;
      if (this.FQt != null) {
        i = paramInt + f.a.a.a.lB(14, this.FQt.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(15, this.FQu);
      int j = f.a.a.b.b.a.bz(16, this.FQv);
      int k = f.a.a.b.b.a.bz(17, this.FQw);
      int m = f.a.a.b.b.a.p(18, this.FQx);
      AppMethodBeat.o(113955);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FQo.clear();
        this.FQp.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(113955);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        sw localsw = (sw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113955);
          return -1;
        case 1: 
          localsw.FQk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 2: 
          localsw.FQl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 3: 
          localsw.FQm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 4: 
          localsw.FQn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new su();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((su)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsw.FQo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 6: 
          localsw.FQa = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(113955);
          return 0;
        case 7: 
          localsw.FQb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsw.FQc = ((tg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 9: 
          localsw.FQd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new st();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((st)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsw.FQp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 11: 
          localsw.FQq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 12: 
          localsw.FQr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsw.FQs = ((tg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new su();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((su)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsw.FQt = ((su)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 15: 
          localsw.FQu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(113955);
          return 0;
        case 16: 
          localsw.FQv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(113955);
          return 0;
        case 17: 
          localsw.FQw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(113955);
          return 0;
        }
        localsw.FQx = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(113955);
        return 0;
      }
      AppMethodBeat.o(113955);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sw
 * JD-Core Version:    0.7.0.1
 */