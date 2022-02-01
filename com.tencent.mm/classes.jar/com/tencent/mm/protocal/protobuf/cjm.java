package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjm
  extends com.tencent.mm.cd.a
{
  public String SXs;
  public int SXt;
  public String SXu;
  public boolean SXv = false;
  public boolean SXw = false;
  public esj TqR;
  public esj TqS;
  public String TqT;
  public String TqU;
  public boolean TqV = false;
  public boolean TqW;
  public cjq TqX;
  public fbo TqY;
  public bvy TqZ;
  public int flags;
  public int msgType = -1;
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122507);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.msgType);
      if (this.TqR != null)
      {
        paramVarArgs.oE(2, this.TqR.computeSize());
        this.TqR.writeFields(paramVarArgs);
      }
      if (this.TqS != null)
      {
        paramVarArgs.oE(3, this.TqS.computeSize());
        this.TqS.writeFields(paramVarArgs);
      }
      paramVarArgs.co(4, this.SXv);
      if (this.SXs != null) {
        paramVarArgs.f(5, this.SXs);
      }
      paramVarArgs.aY(6, this.flags);
      if (this.SXu != null) {
        paramVarArgs.f(7, this.SXu);
      }
      if (this.TqT != null) {
        paramVarArgs.f(8, this.TqT);
      }
      if (this.TqU != null) {
        paramVarArgs.f(9, this.TqU);
      }
      paramVarArgs.co(10, this.TqV);
      paramVarArgs.co(11, this.TqW);
      paramVarArgs.co(12, this.SXw);
      if (this.TqX != null)
      {
        paramVarArgs.oE(13, this.TqX.computeSize());
        this.TqX.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(14, this.timestamp);
      if (this.TqY != null)
      {
        paramVarArgs.oE(15, this.TqY.computeSize());
        this.TqY.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(16, this.SXt);
      if (this.TqZ != null)
      {
        paramVarArgs.oE(17, this.TqZ.computeSize());
        this.TqZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(122507);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.msgType) + 0;
      paramInt = i;
      if (this.TqR != null) {
        paramInt = i + g.a.a.a.oD(2, this.TqR.computeSize());
      }
      i = paramInt;
      if (this.TqS != null) {
        i = paramInt + g.a.a.a.oD(3, this.TqS.computeSize());
      }
      i += g.a.a.b.b.a.gL(4) + 1;
      paramInt = i;
      if (this.SXs != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.SXs);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.flags);
      paramInt = i;
      if (this.SXu != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.SXu);
      }
      i = paramInt;
      if (this.TqT != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.TqT);
      }
      paramInt = i;
      if (this.TqU != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.TqU);
      }
      i = paramInt + (g.a.a.b.b.a.gL(10) + 1) + (g.a.a.b.b.a.gL(11) + 1) + (g.a.a.b.b.a.gL(12) + 1);
      paramInt = i;
      if (this.TqX != null) {
        paramInt = i + g.a.a.a.oD(13, this.TqX.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.p(14, this.timestamp);
      paramInt = i;
      if (this.TqY != null) {
        paramInt = i + g.a.a.a.oD(15, this.TqY.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(16, this.SXt);
      paramInt = i;
      if (this.TqZ != null) {
        paramInt = i + g.a.a.a.oD(17, this.TqZ.computeSize());
      }
      AppMethodBeat.o(122507);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(122507);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cjm localcjm = (cjm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122507);
        return -1;
      case 1: 
        localcjm.msgType = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(122507);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new esj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((esj)localObject2).parseFrom((byte[])localObject1);
          }
          localcjm.TqR = ((esj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122507);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new esj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((esj)localObject2).parseFrom((byte[])localObject1);
          }
          localcjm.TqS = ((esj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122507);
        return 0;
      case 4: 
        localcjm.SXv = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(122507);
        return 0;
      case 5: 
        localcjm.SXs = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 6: 
        localcjm.flags = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(122507);
        return 0;
      case 7: 
        localcjm.SXu = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 8: 
        localcjm.TqT = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 9: 
        localcjm.TqU = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 10: 
        localcjm.TqV = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(122507);
        return 0;
      case 11: 
        localcjm.TqW = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(122507);
        return 0;
      case 12: 
        localcjm.SXw = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(122507);
        return 0;
      case 13: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cjq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cjq)localObject2).parseFrom((byte[])localObject1);
          }
          localcjm.TqX = ((cjq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122507);
        return 0;
      case 14: 
        localcjm.timestamp = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(122507);
        return 0;
      case 15: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fbo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fbo)localObject2).parseFrom((byte[])localObject1);
          }
          localcjm.TqY = ((fbo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122507);
        return 0;
      case 16: 
        localcjm.SXt = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(122507);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new bvy();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((bvy)localObject2).parseFrom((byte[])localObject1);
        }
        localcjm.TqZ = ((bvy)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(122507);
      return 0;
    }
    AppMethodBeat.o(122507);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjm
 * JD-Core Version:    0.7.0.1
 */