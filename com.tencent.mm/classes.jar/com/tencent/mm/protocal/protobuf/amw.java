package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amw
  extends com.tencent.mm.bw.a
{
  public int GEY;
  public int GEZ;
  public int GFa;
  public int GFb;
  public int GFc;
  public int GFd;
  public int GFe;
  public int GFf;
  public int GFg;
  public String dEk;
  public int duration;
  public long duw;
  public int lsY;
  public int networkId;
  public LinkedList<atl> sBF;
  public String sBR;
  public int sBS;
  public long sBd;
  public int sBe;
  public int scene;
  public String suu;
  
  public amw()
  {
    AppMethodBeat.i(184197);
    this.sBF = new LinkedList();
    AppMethodBeat.o(184197);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184198);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.duw);
      paramVarArgs.aS(2, this.GEY);
      paramVarArgs.aS(3, this.scene);
      paramVarArgs.aS(4, this.GEZ);
      paramVarArgs.aS(5, this.lsY);
      paramVarArgs.aS(6, this.GFa);
      paramVarArgs.aS(7, this.duration);
      paramVarArgs.aS(8, this.GFb);
      paramVarArgs.aS(9, this.GFc);
      paramVarArgs.aS(10, this.GFd);
      paramVarArgs.e(11, 8, this.sBF);
      paramVarArgs.aS(12, this.GFe);
      paramVarArgs.aS(13, this.sBe);
      paramVarArgs.aS(14, this.GFf);
      if (this.suu != null) {
        paramVarArgs.d(15, this.suu);
      }
      paramVarArgs.aZ(16, this.sBd);
      paramVarArgs.aS(17, this.GFg);
      paramVarArgs.aS(18, this.networkId);
      if (this.sBR != null) {
        paramVarArgs.d(19, this.sBR);
      }
      paramVarArgs.aS(20, this.sBS);
      if (this.dEk != null) {
        paramVarArgs.d(21, this.dEk);
      }
      AppMethodBeat.o(184198);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.duw) + 0 + f.a.a.b.b.a.bz(2, this.GEY) + f.a.a.b.b.a.bz(3, this.scene) + f.a.a.b.b.a.bz(4, this.GEZ) + f.a.a.b.b.a.bz(5, this.lsY) + f.a.a.b.b.a.bz(6, this.GFa) + f.a.a.b.b.a.bz(7, this.duration) + f.a.a.b.b.a.bz(8, this.GFb) + f.a.a.b.b.a.bz(9, this.GFc) + f.a.a.b.b.a.bz(10, this.GFd) + f.a.a.a.c(11, 8, this.sBF) + f.a.a.b.b.a.bz(12, this.GFe) + f.a.a.b.b.a.bz(13, this.sBe) + f.a.a.b.b.a.bz(14, this.GFf);
      paramInt = i;
      if (this.suu != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.suu);
      }
      i = paramInt + f.a.a.b.b.a.p(16, this.sBd) + f.a.a.b.b.a.bz(17, this.GFg) + f.a.a.b.b.a.bz(18, this.networkId);
      paramInt = i;
      if (this.sBR != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.sBR);
      }
      i = paramInt + f.a.a.b.b.a.bz(20, this.sBS);
      paramInt = i;
      if (this.dEk != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.dEk);
      }
      AppMethodBeat.o(184198);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.sBF.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(184198);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      amw localamw = (amw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184198);
        return -1;
      case 1: 
        localamw.duw = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(184198);
        return 0;
      case 2: 
        localamw.GEY = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 3: 
        localamw.scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 4: 
        localamw.GEZ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 5: 
        localamw.lsY = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 6: 
        localamw.GFa = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 7: 
        localamw.duration = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 8: 
        localamw.GFb = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 9: 
        localamw.GFc = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 10: 
        localamw.GFd = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new atl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((atl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localamw.sBF.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(184198);
        return 0;
      case 12: 
        localamw.GFe = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 13: 
        localamw.sBe = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 14: 
        localamw.GFf = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 15: 
        localamw.suu = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(184198);
        return 0;
      case 16: 
        localamw.sBd = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(184198);
        return 0;
      case 17: 
        localamw.GFg = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 18: 
        localamw.networkId = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(184198);
        return 0;
      case 19: 
        localamw.sBR = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(184198);
        return 0;
      case 20: 
        localamw.sBS = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(184198);
        return 0;
      }
      localamw.dEk = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(184198);
      return 0;
    }
    AppMethodBeat.o(184198);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amw
 * JD-Core Version:    0.7.0.1
 */