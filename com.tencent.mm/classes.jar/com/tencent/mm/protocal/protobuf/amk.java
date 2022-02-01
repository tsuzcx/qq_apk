package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amk
  extends com.tencent.mm.bx.a
{
  public int GlW;
  public int GlX;
  public int GlY;
  public int GlZ;
  public int Gma;
  public int Gmb;
  public int Gmc;
  public int Gmd;
  public int Gme;
  public String dDf;
  public long dtq;
  public int duration;
  public int loB;
  public int networkId;
  public int scene;
  public String slv;
  public long sqS;
  public int sqT;
  public String srH;
  public int srI;
  public LinkedList<asv> srv;
  
  public amk()
  {
    AppMethodBeat.i(184197);
    this.srv = new LinkedList();
    AppMethodBeat.o(184197);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184198);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.dtq);
      paramVarArgs.aS(2, this.GlW);
      paramVarArgs.aS(3, this.scene);
      paramVarArgs.aS(4, this.GlX);
      paramVarArgs.aS(5, this.loB);
      paramVarArgs.aS(6, this.GlY);
      paramVarArgs.aS(7, this.duration);
      paramVarArgs.aS(8, this.GlZ);
      paramVarArgs.aS(9, this.Gma);
      paramVarArgs.aS(10, this.Gmb);
      paramVarArgs.e(11, 8, this.srv);
      paramVarArgs.aS(12, this.Gmc);
      paramVarArgs.aS(13, this.sqT);
      paramVarArgs.aS(14, this.Gmd);
      if (this.slv != null) {
        paramVarArgs.d(15, this.slv);
      }
      paramVarArgs.aY(16, this.sqS);
      paramVarArgs.aS(17, this.Gme);
      paramVarArgs.aS(18, this.networkId);
      if (this.srH != null) {
        paramVarArgs.d(19, this.srH);
      }
      paramVarArgs.aS(20, this.srI);
      if (this.dDf != null) {
        paramVarArgs.d(21, this.dDf);
      }
      AppMethodBeat.o(184198);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.dtq) + 0 + f.a.a.b.b.a.bz(2, this.GlW) + f.a.a.b.b.a.bz(3, this.scene) + f.a.a.b.b.a.bz(4, this.GlX) + f.a.a.b.b.a.bz(5, this.loB) + f.a.a.b.b.a.bz(6, this.GlY) + f.a.a.b.b.a.bz(7, this.duration) + f.a.a.b.b.a.bz(8, this.GlZ) + f.a.a.b.b.a.bz(9, this.Gma) + f.a.a.b.b.a.bz(10, this.Gmb) + f.a.a.a.c(11, 8, this.srv) + f.a.a.b.b.a.bz(12, this.Gmc) + f.a.a.b.b.a.bz(13, this.sqT) + f.a.a.b.b.a.bz(14, this.Gmd);
      paramInt = i;
      if (this.slv != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.slv);
      }
      i = paramInt + f.a.a.b.b.a.p(16, this.sqS) + f.a.a.b.b.a.bz(17, this.Gme) + f.a.a.b.b.a.bz(18, this.networkId);
      paramInt = i;
      if (this.srH != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.srH);
      }
      i = paramInt + f.a.a.b.b.a.bz(20, this.srI);
      paramInt = i;
      if (this.dDf != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.dDf);
      }
      AppMethodBeat.o(184198);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.srv.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(184198);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      amk localamk = (amk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184198);
        return -1;
      case 1: 
        localamk.dtq = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(184198);
        return 0;
      case 2: 
        localamk.GlW = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 3: 
        localamk.scene = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 4: 
        localamk.GlX = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 5: 
        localamk.loB = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 6: 
        localamk.GlY = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 7: 
        localamk.duration = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 8: 
        localamk.GlZ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 9: 
        localamk.Gma = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 10: 
        localamk.Gmb = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new asv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((asv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localamk.srv.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(184198);
        return 0;
      case 12: 
        localamk.Gmc = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 13: 
        localamk.sqT = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 14: 
        localamk.Gmd = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 15: 
        localamk.slv = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(184198);
        return 0;
      case 16: 
        localamk.sqS = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(184198);
        return 0;
      case 17: 
        localamk.Gme = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 18: 
        localamk.networkId = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 19: 
        localamk.srH = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(184198);
        return 0;
      case 20: 
        localamk.srI = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(184198);
        return 0;
      }
      localamk.dDf = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(184198);
      return 0;
    }
    AppMethodBeat.o(184198);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amk
 * JD-Core Version:    0.7.0.1
 */