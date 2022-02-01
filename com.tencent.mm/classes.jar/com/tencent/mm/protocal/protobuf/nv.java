package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nv
  extends com.tencent.mm.cd.a
{
  public int ChC;
  public int RKB;
  public int RUD;
  public int RUE;
  public int RUF;
  public int RUG;
  public acm RUH;
  public int RUI;
  public int RUJ;
  public int RUK = 0;
  public int RUL;
  public String content;
  public String llI;
  public String openid;
  public String ueW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103203);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RUD);
      paramVarArgs.aY(2, this.RKB);
      if (this.openid != null) {
        paramVarArgs.f(3, this.openid);
      }
      if (this.ueW != null) {
        paramVarArgs.f(4, this.ueW);
      }
      if (this.llI != null) {
        paramVarArgs.f(5, this.llI);
      }
      if (this.content != null) {
        paramVarArgs.f(6, this.content);
      }
      paramVarArgs.aY(7, this.ChC);
      paramVarArgs.aY(8, this.RUE);
      paramVarArgs.aY(9, this.RUF);
      paramVarArgs.aY(10, this.RUG);
      if (this.RUH != null)
      {
        paramVarArgs.oE(11, this.RUH.computeSize());
        this.RUH.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(12, this.RUI);
      paramVarArgs.aY(13, this.RUJ);
      paramVarArgs.aY(14, this.RUK);
      paramVarArgs.aY(15, this.RUL);
      AppMethodBeat.o(103203);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.RUD) + 0 + g.a.a.b.b.a.bM(2, this.RKB);
      paramInt = i;
      if (this.openid != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.openid);
      }
      i = paramInt;
      if (this.ueW != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.ueW);
      }
      paramInt = i;
      if (this.llI != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.llI);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.content);
      }
      i = i + g.a.a.b.b.a.bM(7, this.ChC) + g.a.a.b.b.a.bM(8, this.RUE) + g.a.a.b.b.a.bM(9, this.RUF) + g.a.a.b.b.a.bM(10, this.RUG);
      paramInt = i;
      if (this.RUH != null) {
        paramInt = i + g.a.a.a.oD(11, this.RUH.computeSize());
      }
      i = g.a.a.b.b.a.bM(12, this.RUI);
      int j = g.a.a.b.b.a.bM(13, this.RUJ);
      int k = g.a.a.b.b.a.bM(14, this.RUK);
      int m = g.a.a.b.b.a.bM(15, this.RUL);
      AppMethodBeat.o(103203);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(103203);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      nv localnv = (nv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(103203);
        return -1;
      case 1: 
        localnv.RUD = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(103203);
        return 0;
      case 2: 
        localnv.RKB = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(103203);
        return 0;
      case 3: 
        localnv.openid = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 4: 
        localnv.ueW = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 5: 
        localnv.llI = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 6: 
        localnv.content = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 7: 
        localnv.ChC = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(103203);
        return 0;
      case 8: 
        localnv.RUE = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(103203);
        return 0;
      case 9: 
        localnv.RUF = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(103203);
        return 0;
      case 10: 
        localnv.RUG = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(103203);
        return 0;
      case 11: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          acm localacm = new acm();
          if ((localObject != null) && (localObject.length > 0)) {
            localacm.parseFrom((byte[])localObject);
          }
          localnv.RUH = localacm;
          paramInt += 1;
        }
        AppMethodBeat.o(103203);
        return 0;
      case 12: 
        localnv.RUI = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(103203);
        return 0;
      case 13: 
        localnv.RUJ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(103203);
        return 0;
      case 14: 
        localnv.RUK = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(103203);
        return 0;
      }
      localnv.RUL = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(103203);
      return 0;
    }
    AppMethodBeat.o(103203);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nv
 * JD-Core Version:    0.7.0.1
 */