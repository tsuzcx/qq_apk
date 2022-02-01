package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvw
  extends com.tencent.mm.cd.a
{
  public String CMB;
  public int Privated;
  public int TAg;
  public String TDY;
  public String TEA;
  public String TEB;
  public String TEC;
  public cuv TED;
  public int TEE;
  public int TEa;
  public int TEb;
  public int TEj;
  public String TEk;
  public cvo TEx;
  public int TEy;
  public LinkedList<cvo> TEz;
  public int aOl;
  public String appid;
  public int fBX;
  public int kQn;
  public String md5;
  public String token;
  public String videoPath;
  
  public cvw()
  {
    AppMethodBeat.i(125747);
    this.TEz = new LinkedList();
    AppMethodBeat.o(125747);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125748);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TEa);
      paramVarArgs.aY(2, this.TEb);
      paramVarArgs.aY(3, this.Privated);
      if (this.TEx != null)
      {
        paramVarArgs.oE(4, this.TEx.computeSize());
        this.TEx.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.TEy);
      paramVarArgs.e(6, 8, this.TEz);
      paramVarArgs.aY(7, this.kQn);
      paramVarArgs.aY(8, this.TAg);
      if (this.CMB != null) {
        paramVarArgs.f(9, this.CMB);
      }
      if (this.TEA != null) {
        paramVarArgs.f(10, this.TEA);
      }
      if (this.token != null) {
        paramVarArgs.f(11, this.token);
      }
      if (this.TEk != null) {
        paramVarArgs.f(12, this.TEk);
      }
      paramVarArgs.aY(13, this.TEj);
      if (this.videoPath != null) {
        paramVarArgs.f(14, this.videoPath);
      }
      if (this.TEB != null) {
        paramVarArgs.f(15, this.TEB);
      }
      if (this.TEC != null) {
        paramVarArgs.f(16, this.TEC);
      }
      if (this.md5 != null) {
        paramVarArgs.f(17, this.md5);
      }
      if (this.appid != null) {
        paramVarArgs.f(18, this.appid);
      }
      paramVarArgs.aY(19, this.aOl);
      paramVarArgs.aY(20, this.fBX);
      if (this.TDY != null) {
        paramVarArgs.f(21, this.TDY);
      }
      if (this.TED != null)
      {
        paramVarArgs.oE(22, this.TED.computeSize());
        this.TED.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(23, this.TEE);
      AppMethodBeat.o(125748);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.TEa) + 0 + g.a.a.b.b.a.bM(2, this.TEb) + g.a.a.b.b.a.bM(3, this.Privated);
      paramInt = i;
      if (this.TEx != null) {
        paramInt = i + g.a.a.a.oD(4, this.TEx.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.TEy) + g.a.a.a.c(6, 8, this.TEz) + g.a.a.b.b.a.bM(7, this.kQn) + g.a.a.b.b.a.bM(8, this.TAg);
      paramInt = i;
      if (this.CMB != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.CMB);
      }
      i = paramInt;
      if (this.TEA != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.TEA);
      }
      paramInt = i;
      if (this.token != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.token);
      }
      i = paramInt;
      if (this.TEk != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.TEk);
      }
      i += g.a.a.b.b.a.bM(13, this.TEj);
      paramInt = i;
      if (this.videoPath != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.videoPath);
      }
      i = paramInt;
      if (this.TEB != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.TEB);
      }
      paramInt = i;
      if (this.TEC != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.TEC);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.md5);
      }
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.appid);
      }
      i = paramInt + g.a.a.b.b.a.bM(19, this.aOl) + g.a.a.b.b.a.bM(20, this.fBX);
      paramInt = i;
      if (this.TDY != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.TDY);
      }
      i = paramInt;
      if (this.TED != null) {
        i = paramInt + g.a.a.a.oD(22, this.TED.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(23, this.TEE);
      AppMethodBeat.o(125748);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TEz.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(125748);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cvw localcvw = (cvw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125748);
        return -1;
      case 1: 
        localcvw.TEa = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125748);
        return 0;
      case 2: 
        localcvw.TEb = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125748);
        return 0;
      case 3: 
        localcvw.Privated = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125748);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cvo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cvo)localObject2).parseFrom((byte[])localObject1);
          }
          localcvw.TEx = ((cvo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125748);
        return 0;
      case 5: 
        localcvw.TEy = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125748);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cvo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cvo)localObject2).parseFrom((byte[])localObject1);
          }
          localcvw.TEz.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125748);
        return 0;
      case 7: 
        localcvw.kQn = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125748);
        return 0;
      case 8: 
        localcvw.TAg = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125748);
        return 0;
      case 9: 
        localcvw.CMB = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 10: 
        localcvw.TEA = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 11: 
        localcvw.token = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 12: 
        localcvw.TEk = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 13: 
        localcvw.TEj = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125748);
        return 0;
      case 14: 
        localcvw.videoPath = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 15: 
        localcvw.TEB = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 16: 
        localcvw.TEC = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 17: 
        localcvw.md5 = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 18: 
        localcvw.appid = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 19: 
        localcvw.aOl = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125748);
        return 0;
      case 20: 
        localcvw.fBX = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125748);
        return 0;
      case 21: 
        localcvw.TDY = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 22: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cuv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cuv)localObject2).parseFrom((byte[])localObject1);
          }
          localcvw.TED = ((cuv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125748);
        return 0;
      }
      localcvw.TEE = ((g.a.a.a.a)localObject1).abFh.AK();
      AppMethodBeat.o(125748);
      return 0;
    }
    AppMethodBeat.o(125748);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvw
 * JD-Core Version:    0.7.0.1
 */