package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class lk
  extends ckq
{
  public b CGV;
  public String CGW;
  public String CGX;
  public String CGY;
  public int CGZ;
  public int CHa;
  public long CHb;
  public boolean CHc;
  public boolean CHd;
  public GoodsObject CHe;
  public int CHf;
  public int CHg;
  public long CHh;
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
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CGV != null) {
        paramVarArgs.c(2, this.CGV);
      }
      paramVarArgs.aR(11, this.type);
      paramVarArgs.aR(12, this.mode);
      if (this.CGW != null) {
        paramVarArgs.d(13, this.CGW);
      }
      if (this.CGX != null) {
        paramVarArgs.d(14, this.CGX);
      }
      if (this.CGY != null) {
        paramVarArgs.d(15, this.CGY);
      }
      paramVarArgs.aR(16, this.CGZ);
      paramVarArgs.aR(17, this.CHa);
      paramVarArgs.aG(18, this.CHb);
      paramVarArgs.bg(19, this.CHc);
      paramVarArgs.bg(20, this.CHd);
      if (this.CHe != null)
      {
        paramVarArgs.kX(21, this.CHe.computeSize());
        this.CHe.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(22, this.CHf);
      paramVarArgs.aR(23, this.CHg);
      paramVarArgs.aG(50, this.CHh);
      AppMethodBeat.o(124394);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1222;
      }
    }
    label1222:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CGV != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.CGV);
      }
      i = i + f.a.a.b.b.a.bA(11, this.type) + f.a.a.b.b.a.bA(12, this.mode);
      paramInt = i;
      if (this.CGW != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.CGW);
      }
      i = paramInt;
      if (this.CGX != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.CGX);
      }
      paramInt = i;
      if (this.CGY != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.CGY);
      }
      i = paramInt + f.a.a.b.b.a.bA(16, this.CGZ) + f.a.a.b.b.a.bA(17, this.CHa) + f.a.a.b.b.a.q(18, this.CHb) + (f.a.a.b.b.a.fY(19) + 1) + (f.a.a.b.b.a.fY(20) + 1);
      paramInt = i;
      if (this.CHe != null) {
        paramInt = i + f.a.a.a.kW(21, this.CHe.computeSize());
      }
      i = f.a.a.b.b.a.bA(22, this.CHf);
      int j = f.a.a.b.b.a.bA(23, this.CHg);
      int k = f.a.a.b.b.a.q(50, this.CHh);
      AppMethodBeat.o(124394);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124394);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        lk locallk = (lk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124394);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallk.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        case 2: 
          locallk.CGV = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(124394);
          return 0;
        case 11: 
          locallk.type = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124394);
          return 0;
        case 12: 
          locallk.mode = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124394);
          return 0;
        case 13: 
          locallk.CGW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124394);
          return 0;
        case 14: 
          locallk.CGX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124394);
          return 0;
        case 15: 
          locallk.CGY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124394);
          return 0;
        case 16: 
          locallk.CGZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124394);
          return 0;
        case 17: 
          locallk.CHa = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124394);
          return 0;
        case 18: 
          locallk.CHb = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(124394);
          return 0;
        case 19: 
          locallk.CHc = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(124394);
          return 0;
        case 20: 
          locallk.CHd = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(124394);
          return 0;
        case 21: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new GoodsObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((GoodsObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallk.CHe = ((GoodsObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        case 22: 
          locallk.CHf = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124394);
          return 0;
        case 23: 
          locallk.CHg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124394);
          return 0;
        }
        locallk.CHh = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(124394);
        return 0;
      }
      AppMethodBeat.o(124394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lk
 * JD-Core Version:    0.7.0.1
 */