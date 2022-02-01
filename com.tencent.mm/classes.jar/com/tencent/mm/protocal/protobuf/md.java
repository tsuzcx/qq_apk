package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class md
  extends cvc
{
  public b FEU;
  public String FEV;
  public String FEW;
  public String FEX;
  public int FEY;
  public int FEZ;
  public long FFa;
  public boolean FFb;
  public boolean FFc;
  public GoodsObject FFd;
  public int FFe;
  public int FFf;
  public mc FFg;
  public ma FFh;
  public mb FFi;
  public long FFj;
  public int mode;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124394);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FEU != null) {
        paramVarArgs.c(2, this.FEU);
      }
      paramVarArgs.aS(11, this.type);
      paramVarArgs.aS(12, this.mode);
      if (this.FEV != null) {
        paramVarArgs.d(13, this.FEV);
      }
      if (this.FEW != null) {
        paramVarArgs.d(14, this.FEW);
      }
      if (this.FEX != null) {
        paramVarArgs.d(15, this.FEX);
      }
      paramVarArgs.aS(16, this.FEY);
      paramVarArgs.aS(17, this.FEZ);
      paramVarArgs.aY(18, this.FFa);
      paramVarArgs.bt(19, this.FFb);
      paramVarArgs.bt(20, this.FFc);
      if (this.FFd != null)
      {
        paramVarArgs.lC(21, this.FFd.computeSize());
        this.FFd.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(22, this.FFe);
      paramVarArgs.aS(23, this.FFf);
      if (this.FFg != null)
      {
        paramVarArgs.lC(26, this.FFg.computeSize());
        this.FFg.writeFields(paramVarArgs);
      }
      if (this.FFh != null)
      {
        paramVarArgs.lC(31, this.FFh.computeSize());
        this.FFh.writeFields(paramVarArgs);
      }
      if (this.FFi != null)
      {
        paramVarArgs.lC(32, this.FFi.computeSize());
        this.FFi.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(50, this.FFj);
      AppMethodBeat.o(124394);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1694;
      }
    }
    label1694:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FEU != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.FEU);
      }
      i = i + f.a.a.b.b.a.bz(11, this.type) + f.a.a.b.b.a.bz(12, this.mode);
      paramInt = i;
      if (this.FEV != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.FEV);
      }
      i = paramInt;
      if (this.FEW != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.FEW);
      }
      paramInt = i;
      if (this.FEX != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.FEX);
      }
      i = paramInt + f.a.a.b.b.a.bz(16, this.FEY) + f.a.a.b.b.a.bz(17, this.FEZ) + f.a.a.b.b.a.p(18, this.FFa) + f.a.a.b.b.a.alV(19) + f.a.a.b.b.a.alV(20);
      paramInt = i;
      if (this.FFd != null) {
        paramInt = i + f.a.a.a.lB(21, this.FFd.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(22, this.FFe) + f.a.a.b.b.a.bz(23, this.FFf);
      paramInt = i;
      if (this.FFg != null) {
        paramInt = i + f.a.a.a.lB(26, this.FFg.computeSize());
      }
      i = paramInt;
      if (this.FFh != null) {
        i = paramInt + f.a.a.a.lB(31, this.FFh.computeSize());
      }
      paramInt = i;
      if (this.FFi != null) {
        paramInt = i + f.a.a.a.lB(32, this.FFi.computeSize());
      }
      i = f.a.a.b.b.a.p(50, this.FFj);
      AppMethodBeat.o(124394);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124394);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        md localmd = (md)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124394);
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
            localmd.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        case 2: 
          localmd.FEU = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(124394);
          return 0;
        case 11: 
          localmd.type = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124394);
          return 0;
        case 12: 
          localmd.mode = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124394);
          return 0;
        case 13: 
          localmd.FEV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124394);
          return 0;
        case 14: 
          localmd.FEW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124394);
          return 0;
        case 15: 
          localmd.FEX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124394);
          return 0;
        case 16: 
          localmd.FEY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124394);
          return 0;
        case 17: 
          localmd.FEZ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124394);
          return 0;
        case 18: 
          localmd.FFa = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(124394);
          return 0;
        case 19: 
          localmd.FFb = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(124394);
          return 0;
        case 20: 
          localmd.FFc = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(124394);
          return 0;
        case 21: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new GoodsObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((GoodsObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmd.FFd = ((GoodsObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        case 22: 
          localmd.FFe = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124394);
          return 0;
        case 23: 
          localmd.FFf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124394);
          return 0;
        case 26: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmd.FFg = ((mc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        case 31: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ma();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ma)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmd.FFh = ((ma)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        case 32: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmd.FFi = ((mb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        }
        localmd.FFj = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(124394);
        return 0;
      }
      AppMethodBeat.o(124394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.md
 * JD-Core Version:    0.7.0.1
 */