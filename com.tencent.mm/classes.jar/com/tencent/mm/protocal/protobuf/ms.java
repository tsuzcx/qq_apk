package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class ms
  extends dyl
{
  public String Crx;
  public ml IKy;
  public int ROx;
  public long RSC;
  public String RSD;
  public String RSE;
  public mu RSG;
  public String RSH;
  public String RSI;
  public int RSJ;
  public int RSK;
  public LinkedList<mi> RSL;
  public b RSg;
  public long RSk;
  public GoodsObject RSn;
  public int mode;
  public int type;
  
  public ms()
  {
    AppMethodBeat.i(209127);
    this.RSL = new LinkedList();
    AppMethodBeat.o(209127);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209132);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RSg != null) {
        paramVarArgs.c(2, this.RSg);
      }
      paramVarArgs.aY(11, this.type);
      paramVarArgs.aY(12, this.mode);
      paramVarArgs.bm(18, this.RSk);
      if (this.RSn != null)
      {
        paramVarArgs.oE(21, this.RSn.computeSize());
        this.RSn.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(22, this.ROx);
      if (this.RSG != null)
      {
        paramVarArgs.oE(23, this.RSG.computeSize());
        this.RSG.writeFields(paramVarArgs);
      }
      if (this.IKy != null)
      {
        paramVarArgs.oE(26, this.IKy.computeSize());
        this.IKy.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(27, this.RSC);
      if (this.RSD != null) {
        paramVarArgs.f(28, this.RSD);
      }
      if (this.RSE != null) {
        paramVarArgs.f(29, this.RSE);
      }
      if (this.Crx != null) {
        paramVarArgs.f(30, this.Crx);
      }
      if (this.RSH != null) {
        paramVarArgs.f(31, this.RSH);
      }
      if (this.RSI != null) {
        paramVarArgs.f(32, this.RSI);
      }
      paramVarArgs.aY(33, this.RSJ);
      paramVarArgs.aY(34, this.RSK);
      paramVarArgs.e(35, 8, this.RSL);
      AppMethodBeat.o(209132);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1572;
      }
    }
    label1572:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RSg != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.RSg);
      }
      i = i + g.a.a.b.b.a.bM(11, this.type) + g.a.a.b.b.a.bM(12, this.mode) + g.a.a.b.b.a.p(18, this.RSk);
      paramInt = i;
      if (this.RSn != null) {
        paramInt = i + g.a.a.a.oD(21, this.RSn.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(22, this.ROx);
      paramInt = i;
      if (this.RSG != null) {
        paramInt = i + g.a.a.a.oD(23, this.RSG.computeSize());
      }
      i = paramInt;
      if (this.IKy != null) {
        i = paramInt + g.a.a.a.oD(26, this.IKy.computeSize());
      }
      i += g.a.a.b.b.a.p(27, this.RSC);
      paramInt = i;
      if (this.RSD != null) {
        paramInt = i + g.a.a.b.b.a.g(28, this.RSD);
      }
      i = paramInt;
      if (this.RSE != null) {
        i = paramInt + g.a.a.b.b.a.g(29, this.RSE);
      }
      paramInt = i;
      if (this.Crx != null) {
        paramInt = i + g.a.a.b.b.a.g(30, this.Crx);
      }
      i = paramInt;
      if (this.RSH != null) {
        i = paramInt + g.a.a.b.b.a.g(31, this.RSH);
      }
      paramInt = i;
      if (this.RSI != null) {
        paramInt = i + g.a.a.b.b.a.g(32, this.RSI);
      }
      i = g.a.a.b.b.a.bM(33, this.RSJ);
      int j = g.a.a.b.b.a.bM(34, this.RSK);
      int k = g.a.a.a.c(35, 8, this.RSL);
      AppMethodBeat.o(209132);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RSL.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(209132);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ms localms = (ms)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        case 10: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 19: 
        case 20: 
        case 24: 
        case 25: 
        default: 
          AppMethodBeat.o(209132);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localms.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(209132);
          return 0;
        case 2: 
          localms.RSg = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(209132);
          return 0;
        case 11: 
          localms.type = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(209132);
          return 0;
        case 12: 
          localms.mode = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(209132);
          return 0;
        case 18: 
          localms.RSk = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(209132);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new GoodsObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((GoodsObject)localObject2).parseFrom((byte[])localObject1);
            }
            localms.RSn = ((GoodsObject)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(209132);
          return 0;
        case 22: 
          localms.ROx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(209132);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new mu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((mu)localObject2).parseFrom((byte[])localObject1);
            }
            localms.RSG = ((mu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(209132);
          return 0;
        case 26: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ml();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ml)localObject2).parseFrom((byte[])localObject1);
            }
            localms.IKy = ((ml)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(209132);
          return 0;
        case 27: 
          localms.RSC = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(209132);
          return 0;
        case 28: 
          localms.RSD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(209132);
          return 0;
        case 29: 
          localms.RSE = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(209132);
          return 0;
        case 30: 
          localms.Crx = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(209132);
          return 0;
        case 31: 
          localms.RSH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(209132);
          return 0;
        case 32: 
          localms.RSI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(209132);
          return 0;
        case 33: 
          localms.RSJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(209132);
          return 0;
        case 34: 
          localms.RSK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(209132);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new mi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((mi)localObject2).parseFrom((byte[])localObject1);
          }
          localms.RSL.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(209132);
        return 0;
      }
      AppMethodBeat.o(209132);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ms
 * JD-Core Version:    0.7.0.1
 */