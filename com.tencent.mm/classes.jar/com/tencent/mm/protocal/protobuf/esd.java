package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class esd
  extends com.tencent.mm.cd.a
{
  public String Md5;
  public String RVF;
  public String SYY;
  public int Smj;
  public int Uet;
  public LinkedList<esc> UtT;
  public boolean UtU;
  public LinkedList<esf> UtV;
  public String UtW;
  public int rWt;
  public int rWu;
  
  public esd()
  {
    AppMethodBeat.i(6438);
    this.UtT = new LinkedList();
    this.UtV = new LinkedList();
    AppMethodBeat.o(6438);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6439);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.rWu);
      paramVarArgs.aY(2, this.rWt);
      if (this.RVF != null) {
        paramVarArgs.f(3, this.RVF);
      }
      if (this.Md5 != null) {
        paramVarArgs.f(4, this.Md5);
      }
      paramVarArgs.aY(5, this.Smj);
      paramVarArgs.aY(6, this.Uet);
      paramVarArgs.e(7, 8, this.UtT);
      paramVarArgs.co(8, this.UtU);
      if (this.SYY != null) {
        paramVarArgs.f(9, this.SYY);
      }
      paramVarArgs.e(10, 8, this.UtV);
      if (this.UtW != null) {
        paramVarArgs.f(11, this.UtW);
      }
      AppMethodBeat.o(6439);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.rWu) + 0 + g.a.a.b.b.a.bM(2, this.rWt);
      paramInt = i;
      if (this.RVF != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.RVF);
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.Md5);
      }
      i = i + g.a.a.b.b.a.bM(5, this.Smj) + g.a.a.b.b.a.bM(6, this.Uet) + g.a.a.a.c(7, 8, this.UtT) + (g.a.a.b.b.a.gL(8) + 1);
      paramInt = i;
      if (this.SYY != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.SYY);
      }
      i = paramInt + g.a.a.a.c(10, 8, this.UtV);
      paramInt = i;
      if (this.UtW != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.UtW);
      }
      AppMethodBeat.o(6439);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UtT.clear();
      this.UtV.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(6439);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      esd localesd = (esd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(6439);
        return -1;
      case 1: 
        localesd.rWu = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(6439);
        return 0;
      case 2: 
        localesd.rWt = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(6439);
        return 0;
      case 3: 
        localesd.RVF = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(6439);
        return 0;
      case 4: 
        localesd.Md5 = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(6439);
        return 0;
      case 5: 
        localesd.Smj = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(6439);
        return 0;
      case 6: 
        localesd.Uet = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(6439);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new esc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((esc)localObject2).parseFrom((byte[])localObject1);
          }
          localesd.UtT.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(6439);
        return 0;
      case 8: 
        localesd.UtU = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(6439);
        return 0;
      case 9: 
        localesd.SYY = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(6439);
        return 0;
      case 10: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new esf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((esf)localObject2).parseFrom((byte[])localObject1);
          }
          localesd.UtV.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(6439);
        return 0;
      }
      localesd.UtW = ((g.a.a.a.a)localObject1).abFh.readString();
      AppMethodBeat.o(6439);
      return 0;
    }
    AppMethodBeat.o(6439);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esd
 * JD-Core Version:    0.7.0.1
 */