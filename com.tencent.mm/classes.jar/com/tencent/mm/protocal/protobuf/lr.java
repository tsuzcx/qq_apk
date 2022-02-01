package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class lr
  extends cpx
{
  public int DZA;
  public int DZB;
  public long DZC;
  public boolean DZD;
  public boolean DZE;
  public GoodsObject DZF;
  public int DZG;
  public int DZH;
  public lq DZI;
  public long DZJ;
  public b DZw;
  public String DZx;
  public String DZy;
  public String DZz;
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
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DZw != null) {
        paramVarArgs.c(2, this.DZw);
      }
      paramVarArgs.aR(11, this.type);
      paramVarArgs.aR(12, this.mode);
      if (this.DZx != null) {
        paramVarArgs.d(13, this.DZx);
      }
      if (this.DZy != null) {
        paramVarArgs.d(14, this.DZy);
      }
      if (this.DZz != null) {
        paramVarArgs.d(15, this.DZz);
      }
      paramVarArgs.aR(16, this.DZA);
      paramVarArgs.aR(17, this.DZB);
      paramVarArgs.aO(18, this.DZC);
      paramVarArgs.bl(19, this.DZD);
      paramVarArgs.bl(20, this.DZE);
      if (this.DZF != null)
      {
        paramVarArgs.ln(21, this.DZF.computeSize());
        this.DZF.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(22, this.DZG);
      paramVarArgs.aR(23, this.DZH);
      if (this.DZI != null)
      {
        paramVarArgs.ln(31, this.DZI.computeSize());
        this.DZI.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(50, this.DZJ);
      AppMethodBeat.o(124394);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1378;
      }
    }
    label1378:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DZw != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.DZw);
      }
      i = i + f.a.a.b.b.a.bx(11, this.type) + f.a.a.b.b.a.bx(12, this.mode);
      paramInt = i;
      if (this.DZx != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.DZx);
      }
      i = paramInt;
      if (this.DZy != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.DZy);
      }
      paramInt = i;
      if (this.DZz != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.DZz);
      }
      i = paramInt + f.a.a.b.b.a.bx(16, this.DZA) + f.a.a.b.b.a.bx(17, this.DZB) + f.a.a.b.b.a.p(18, this.DZC) + (f.a.a.b.b.a.fK(19) + 1) + (f.a.a.b.b.a.fK(20) + 1);
      paramInt = i;
      if (this.DZF != null) {
        paramInt = i + f.a.a.a.lm(21, this.DZF.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(22, this.DZG) + f.a.a.b.b.a.bx(23, this.DZH);
      paramInt = i;
      if (this.DZI != null) {
        paramInt = i + f.a.a.a.lm(31, this.DZI.computeSize());
      }
      i = f.a.a.b.b.a.p(50, this.DZJ);
      AppMethodBeat.o(124394);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124394);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        lr locallr = (lr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124394);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallr.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        case 2: 
          locallr.DZw = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(124394);
          return 0;
        case 11: 
          locallr.type = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124394);
          return 0;
        case 12: 
          locallr.mode = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124394);
          return 0;
        case 13: 
          locallr.DZx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124394);
          return 0;
        case 14: 
          locallr.DZy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124394);
          return 0;
        case 15: 
          locallr.DZz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124394);
          return 0;
        case 16: 
          locallr.DZA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124394);
          return 0;
        case 17: 
          locallr.DZB = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124394);
          return 0;
        case 18: 
          locallr.DZC = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(124394);
          return 0;
        case 19: 
          locallr.DZD = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(124394);
          return 0;
        case 20: 
          locallr.DZE = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(124394);
          return 0;
        case 21: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new GoodsObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((GoodsObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallr.DZF = ((GoodsObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        case 22: 
          locallr.DZG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124394);
          return 0;
        case 23: 
          locallr.DZH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124394);
          return 0;
        case 31: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new lq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((lq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallr.DZI = ((lq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        }
        locallr.DZJ = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(124394);
        return 0;
      }
      AppMethodBeat.o(124394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lr
 * JD-Core Version:    0.7.0.1
 */