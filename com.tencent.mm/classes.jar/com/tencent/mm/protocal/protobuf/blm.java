package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class blm
  extends com.tencent.mm.cd.a
{
  public int status;
  public String title;
  public int yiH;
  public String zaM;
  public long zaO;
  public LinkedList<String> zaP;
  public int zaQ;
  public int zaR;
  public int zaS;
  public ahj zaT;
  public ahj zaU;
  public int zaV;
  public int zaW;
  public String zaX;
  
  public blm()
  {
    AppMethodBeat.i(205277);
    this.zaP = new LinkedList();
    AppMethodBeat.o(205277);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205281);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.zaO);
      if (this.title != null) {
        paramVarArgs.f(2, this.title);
      }
      paramVarArgs.e(3, 1, this.zaP);
      paramVarArgs.aY(4, this.zaQ);
      paramVarArgs.aY(5, this.zaR);
      paramVarArgs.aY(6, this.zaS);
      paramVarArgs.aY(7, this.status);
      if (this.zaM != null) {
        paramVarArgs.f(8, this.zaM);
      }
      if (this.zaT != null)
      {
        paramVarArgs.oE(9, this.zaT.computeSize());
        this.zaT.writeFields(paramVarArgs);
      }
      if (this.zaU != null)
      {
        paramVarArgs.oE(10, this.zaU.computeSize());
        this.zaU.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(11, this.zaV);
      paramVarArgs.aY(12, this.yiH);
      paramVarArgs.aY(13, this.zaW);
      if (this.zaX != null) {
        paramVarArgs.f(14, this.zaX);
      }
      AppMethodBeat.o(205281);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.zaO) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.title);
      }
      i = paramInt + g.a.a.a.c(3, 1, this.zaP) + g.a.a.b.b.a.bM(4, this.zaQ) + g.a.a.b.b.a.bM(5, this.zaR) + g.a.a.b.b.a.bM(6, this.zaS) + g.a.a.b.b.a.bM(7, this.status);
      paramInt = i;
      if (this.zaM != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.zaM);
      }
      i = paramInt;
      if (this.zaT != null) {
        i = paramInt + g.a.a.a.oD(9, this.zaT.computeSize());
      }
      paramInt = i;
      if (this.zaU != null) {
        paramInt = i + g.a.a.a.oD(10, this.zaU.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.zaV) + g.a.a.b.b.a.bM(12, this.yiH) + g.a.a.b.b.a.bM(13, this.zaW);
      paramInt = i;
      if (this.zaX != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.zaX);
      }
      AppMethodBeat.o(205281);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.zaP.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(205281);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      blm localblm = (blm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      ahj localahj;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(205281);
        return -1;
      case 1: 
        localblm.zaO = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(205281);
        return 0;
      case 2: 
        localblm.title = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(205281);
        return 0;
      case 3: 
        localblm.zaP.add(((g.a.a.a.a)localObject).abFh.readString());
        AppMethodBeat.o(205281);
        return 0;
      case 4: 
        localblm.zaQ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(205281);
        return 0;
      case 5: 
        localblm.zaR = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(205281);
        return 0;
      case 6: 
        localblm.zaS = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(205281);
        return 0;
      case 7: 
        localblm.status = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(205281);
        return 0;
      case 8: 
        localblm.zaM = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(205281);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localahj = new ahj();
          if ((localObject != null) && (localObject.length > 0)) {
            localahj.parseFrom((byte[])localObject);
          }
          localblm.zaT = localahj;
          paramInt += 1;
        }
        AppMethodBeat.o(205281);
        return 0;
      case 10: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localahj = new ahj();
          if ((localObject != null) && (localObject.length > 0)) {
            localahj.parseFrom((byte[])localObject);
          }
          localblm.zaU = localahj;
          paramInt += 1;
        }
        AppMethodBeat.o(205281);
        return 0;
      case 11: 
        localblm.zaV = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(205281);
        return 0;
      case 12: 
        localblm.yiH = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(205281);
        return 0;
      case 13: 
        localblm.zaW = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(205281);
        return 0;
      }
      localblm.zaX = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(205281);
      return 0;
    }
    AppMethodBeat.o(205281);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blm
 * JD-Core Version:    0.7.0.1
 */