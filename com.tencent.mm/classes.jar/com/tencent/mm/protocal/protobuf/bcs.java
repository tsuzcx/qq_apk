package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bcs
  extends com.tencent.mm.cd.a
{
  public int GTo;
  public int GTp;
  public dom SNT;
  public String SNU;
  public String SNV;
  public dom SNW;
  public int SNX;
  public String fMh;
  public String fvb;
  public int promoting;
  public int status;
  public String title;
  public String xei;
  public String yiC;
  public long yiz;
  public int zaQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231119);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.yiz);
      if (this.SNT != null)
      {
        paramVarArgs.oE(2, this.SNT.computeSize());
        this.SNT.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.f(3, this.title);
      }
      if (this.xei != null) {
        paramVarArgs.f(4, this.xei);
      }
      paramVarArgs.aY(5, this.zaQ);
      paramVarArgs.aY(6, this.GTp);
      paramVarArgs.aY(7, this.GTo);
      paramVarArgs.aY(8, this.promoting);
      if (this.SNU != null) {
        paramVarArgs.f(9, this.SNU);
      }
      if (this.SNV != null) {
        paramVarArgs.f(10, this.SNV);
      }
      paramVarArgs.aY(11, this.status);
      if (this.SNW != null)
      {
        paramVarArgs.oE(12, this.SNW.computeSize());
        this.SNW.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(13, this.SNX);
      if (this.fMh != null) {
        paramVarArgs.f(14, this.fMh);
      }
      if (this.fvb != null) {
        paramVarArgs.f(15, this.fvb);
      }
      if (this.yiC != null) {
        paramVarArgs.f(16, this.yiC);
      }
      AppMethodBeat.o(231119);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.yiz) + 0;
      paramInt = i;
      if (this.SNT != null) {
        paramInt = i + g.a.a.a.oD(2, this.SNT.computeSize());
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.title);
      }
      paramInt = i;
      if (this.xei != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.xei);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.zaQ) + g.a.a.b.b.a.bM(6, this.GTp) + g.a.a.b.b.a.bM(7, this.GTo) + g.a.a.b.b.a.bM(8, this.promoting);
      paramInt = i;
      if (this.SNU != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.SNU);
      }
      i = paramInt;
      if (this.SNV != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.SNV);
      }
      i += g.a.a.b.b.a.bM(11, this.status);
      paramInt = i;
      if (this.SNW != null) {
        paramInt = i + g.a.a.a.oD(12, this.SNW.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(13, this.SNX);
      paramInt = i;
      if (this.fMh != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.fMh);
      }
      i = paramInt;
      if (this.fvb != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.fvb);
      }
      paramInt = i;
      if (this.yiC != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.yiC);
      }
      AppMethodBeat.o(231119);
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
      AppMethodBeat.o(231119);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      bcs localbcs = (bcs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      dom localdom;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(231119);
        return -1;
      case 1: 
        localbcs.yiz = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(231119);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localdom = new dom();
          if ((localObject != null) && (localObject.length > 0)) {
            localdom.parseFrom((byte[])localObject);
          }
          localbcs.SNT = localdom;
          paramInt += 1;
        }
        AppMethodBeat.o(231119);
        return 0;
      case 3: 
        localbcs.title = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(231119);
        return 0;
      case 4: 
        localbcs.xei = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(231119);
        return 0;
      case 5: 
        localbcs.zaQ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(231119);
        return 0;
      case 6: 
        localbcs.GTp = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(231119);
        return 0;
      case 7: 
        localbcs.GTo = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(231119);
        return 0;
      case 8: 
        localbcs.promoting = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(231119);
        return 0;
      case 9: 
        localbcs.SNU = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(231119);
        return 0;
      case 10: 
        localbcs.SNV = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(231119);
        return 0;
      case 11: 
        localbcs.status = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(231119);
        return 0;
      case 12: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localdom = new dom();
          if ((localObject != null) && (localObject.length > 0)) {
            localdom.parseFrom((byte[])localObject);
          }
          localbcs.SNW = localdom;
          paramInt += 1;
        }
        AppMethodBeat.o(231119);
        return 0;
      case 13: 
        localbcs.SNX = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(231119);
        return 0;
      case 14: 
        localbcs.fMh = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(231119);
        return 0;
      case 15: 
        localbcs.fvb = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(231119);
        return 0;
      }
      localbcs.yiC = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(231119);
      return 0;
    }
    AppMethodBeat.o(231119);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcs
 * JD-Core Version:    0.7.0.1
 */