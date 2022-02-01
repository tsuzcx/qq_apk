package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class qe
  extends cvc
{
  public String AFy;
  public String AFz;
  public int FLA;
  public String FLB;
  public String FLC;
  public String FLk;
  public String FLq;
  public String FLr;
  public String FLs;
  public int FLt;
  public boolean FLu;
  public boolean FLv;
  public String FLw;
  public int FLx;
  public String FLy;
  public int FLz;
  public akt FvK;
  public int FvL;
  public String FvR;
  public int channel;
  public String iTJ;
  public String nickname;
  public int scene;
  public int xXA;
  public String xYV;
  public String xYW;
  public String xYY;
  public String xYy;
  public int xZa;
  public String xZb;
  public String xZc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91374);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FLq == null)
      {
        paramVarArgs = new b("Not all required fields were included: qrcode_id");
        AppMethodBeat.o(91374);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xZb != null) {
        paramVarArgs.d(2, this.xZb);
      }
      if (this.FLq != null) {
        paramVarArgs.d(3, this.FLq);
      }
      paramVarArgs.aS(4, this.scene);
      if (this.FLr != null) {
        paramVarArgs.d(5, this.FLr);
      }
      if (this.xYV != null) {
        paramVarArgs.d(6, this.xYV);
      }
      paramVarArgs.aS(7, this.FvL);
      paramVarArgs.aS(8, this.channel);
      if (this.xZc != null) {
        paramVarArgs.d(9, this.xZc);
      }
      if (this.xYW != null) {
        paramVarArgs.d(10, this.xYW);
      }
      if (this.FLs != null) {
        paramVarArgs.d(11, this.FLs);
      }
      paramVarArgs.aS(12, this.FLt);
      paramVarArgs.aS(13, this.xZa);
      if (this.iTJ != null) {
        paramVarArgs.d(14, this.iTJ);
      }
      if (this.FvK != null)
      {
        paramVarArgs.lC(15, this.FvK.computeSize());
        this.FvK.writeFields(paramVarArgs);
      }
      if (this.FLk != null) {
        paramVarArgs.d(16, this.FLk);
      }
      paramVarArgs.aS(17, this.xXA);
      paramVarArgs.bt(18, this.FLu);
      paramVarArgs.bt(19, this.FLv);
      if (this.AFy != null) {
        paramVarArgs.d(20, this.AFy);
      }
      if (this.AFz != null) {
        paramVarArgs.d(21, this.AFz);
      }
      if (this.FLw != null) {
        paramVarArgs.d(22, this.FLw);
      }
      if (this.xYY != null) {
        paramVarArgs.d(23, this.xYY);
      }
      if (this.nickname != null) {
        paramVarArgs.d(24, this.nickname);
      }
      if (this.xYy != null) {
        paramVarArgs.d(25, this.xYy);
      }
      paramVarArgs.aS(26, this.FLx);
      if (this.FLy != null) {
        paramVarArgs.d(27, this.FLy);
      }
      paramVarArgs.aS(28, this.FLz);
      paramVarArgs.aS(29, this.FLA);
      if (this.FvR != null) {
        paramVarArgs.d(30, this.FvR);
      }
      if (this.FLB != null) {
        paramVarArgs.d(31, this.FLB);
      }
      if (this.FLC != null) {
        paramVarArgs.d(32, this.FLC);
      }
      AppMethodBeat.o(91374);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2174;
      }
    }
    label2174:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xZb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.xZb);
      }
      i = paramInt;
      if (this.FLq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FLq);
      }
      i += f.a.a.b.b.a.bz(4, this.scene);
      paramInt = i;
      if (this.FLr != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FLr);
      }
      i = paramInt;
      if (this.xYV != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.xYV);
      }
      i = i + f.a.a.b.b.a.bz(7, this.FvL) + f.a.a.b.b.a.bz(8, this.channel);
      paramInt = i;
      if (this.xZc != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.xZc);
      }
      i = paramInt;
      if (this.xYW != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.xYW);
      }
      paramInt = i;
      if (this.FLs != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FLs);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.FLt) + f.a.a.b.b.a.bz(13, this.xZa);
      paramInt = i;
      if (this.iTJ != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.iTJ);
      }
      i = paramInt;
      if (this.FvK != null) {
        i = paramInt + f.a.a.a.lB(15, this.FvK.computeSize());
      }
      paramInt = i;
      if (this.FLk != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.FLk);
      }
      i = paramInt + f.a.a.b.b.a.bz(17, this.xXA) + f.a.a.b.b.a.alV(18) + f.a.a.b.b.a.alV(19);
      paramInt = i;
      if (this.AFy != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.AFy);
      }
      i = paramInt;
      if (this.AFz != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.AFz);
      }
      paramInt = i;
      if (this.FLw != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.FLw);
      }
      i = paramInt;
      if (this.xYY != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.xYY);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.nickname);
      }
      i = paramInt;
      if (this.xYy != null) {
        i = paramInt + f.a.a.b.b.a.e(25, this.xYy);
      }
      i += f.a.a.b.b.a.bz(26, this.FLx);
      paramInt = i;
      if (this.FLy != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.FLy);
      }
      i = paramInt + f.a.a.b.b.a.bz(28, this.FLz) + f.a.a.b.b.a.bz(29, this.FLA);
      paramInt = i;
      if (this.FvR != null) {
        paramInt = i + f.a.a.b.b.a.e(30, this.FvR);
      }
      i = paramInt;
      if (this.FLB != null) {
        i = paramInt + f.a.a.b.b.a.e(31, this.FLB);
      }
      paramInt = i;
      if (this.FLC != null) {
        paramInt = i + f.a.a.b.b.a.e(32, this.FLC);
      }
      AppMethodBeat.o(91374);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FLq == null)
        {
          paramVarArgs = new b("Not all required fields were included: qrcode_id");
          AppMethodBeat.o(91374);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91374);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        qe localqe = (qe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91374);
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
            localqe.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91374);
          return 0;
        case 2: 
          localqe.xZb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 3: 
          localqe.FLq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 4: 
          localqe.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91374);
          return 0;
        case 5: 
          localqe.FLr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 6: 
          localqe.xYV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 7: 
          localqe.FvL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91374);
          return 0;
        case 8: 
          localqe.channel = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91374);
          return 0;
        case 9: 
          localqe.xZc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 10: 
          localqe.xYW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 11: 
          localqe.FLs = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 12: 
          localqe.FLt = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91374);
          return 0;
        case 13: 
          localqe.xZa = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91374);
          return 0;
        case 14: 
          localqe.iTJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqe.FvK = ((akt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91374);
          return 0;
        case 16: 
          localqe.FLk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 17: 
          localqe.xXA = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91374);
          return 0;
        case 18: 
          localqe.FLu = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91374);
          return 0;
        case 19: 
          localqe.FLv = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91374);
          return 0;
        case 20: 
          localqe.AFy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 21: 
          localqe.AFz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 22: 
          localqe.FLw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 23: 
          localqe.xYY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 24: 
          localqe.nickname = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 25: 
          localqe.xYy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 26: 
          localqe.FLx = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91374);
          return 0;
        case 27: 
          localqe.FLy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 28: 
          localqe.FLz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91374);
          return 0;
        case 29: 
          localqe.FLA = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91374);
          return 0;
        case 30: 
          localqe.FvR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 31: 
          localqe.FLB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91374);
          return 0;
        }
        localqe.FLC = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91374);
        return 0;
      }
      AppMethodBeat.o(91374);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qe
 * JD-Core Version:    0.7.0.1
 */