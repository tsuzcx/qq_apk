package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class ov
  extends dyl
{
  public String Crx;
  public int ROx;
  public String RSH;
  public String RSI;
  public int RSJ;
  public int RSK;
  public LinkedList<mi> RSL;
  public b RSg;
  public long RSk;
  public int RXh;
  public int source;
  
  public ov()
  {
    AppMethodBeat.i(205912);
    this.RSL = new LinkedList();
    AppMethodBeat.o(205912);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205915);
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
      paramVarArgs.aY(3, this.source);
      if (this.Crx != null) {
        paramVarArgs.f(5, this.Crx);
      }
      if (this.RSH != null) {
        paramVarArgs.f(6, this.RSH);
      }
      if (this.RSI != null) {
        paramVarArgs.f(7, this.RSI);
      }
      paramVarArgs.aY(8, this.RXh);
      paramVarArgs.aY(9, this.RSJ);
      paramVarArgs.aY(10, this.RSK);
      paramVarArgs.e(17, 8, this.RSL);
      paramVarArgs.bm(18, this.RSk);
      paramVarArgs.aY(22, this.ROx);
      AppMethodBeat.o(205915);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label978;
      }
    }
    label978:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RSg != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.RSg);
      }
      i += g.a.a.b.b.a.bM(3, this.source);
      paramInt = i;
      if (this.Crx != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Crx);
      }
      i = paramInt;
      if (this.RSH != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.RSH);
      }
      paramInt = i;
      if (this.RSI != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.RSI);
      }
      i = g.a.a.b.b.a.bM(8, this.RXh);
      int j = g.a.a.b.b.a.bM(9, this.RSJ);
      int k = g.a.a.b.b.a.bM(10, this.RSK);
      int m = g.a.a.a.c(17, 8, this.RSL);
      int n = g.a.a.b.b.a.p(18, this.RSk);
      int i1 = g.a.a.b.b.a.bM(22, this.ROx);
      AppMethodBeat.o(205915);
      return paramInt + i + j + k + m + n + i1;
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
        AppMethodBeat.o(205915);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ov localov = (ov)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 4: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 19: 
        case 20: 
        case 21: 
        default: 
          AppMethodBeat.o(205915);
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
            localov.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(205915);
          return 0;
        case 2: 
          localov.RSg = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(205915);
          return 0;
        case 3: 
          localov.source = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(205915);
          return 0;
        case 5: 
          localov.Crx = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(205915);
          return 0;
        case 6: 
          localov.RSH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(205915);
          return 0;
        case 7: 
          localov.RSI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(205915);
          return 0;
        case 8: 
          localov.RXh = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(205915);
          return 0;
        case 9: 
          localov.RSJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(205915);
          return 0;
        case 10: 
          localov.RSK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(205915);
          return 0;
        case 17: 
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
            localov.RSL.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(205915);
          return 0;
        case 18: 
          localov.RSk = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(205915);
          return 0;
        }
        localov.ROx = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(205915);
        return 0;
      }
      AppMethodBeat.o(205915);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ov
 * JD-Core Version:    0.7.0.1
 */