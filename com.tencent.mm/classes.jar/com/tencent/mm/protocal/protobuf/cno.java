package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cno
  extends com.tencent.mm.bw.a
{
  public int LCp;
  public int LCq;
  public int LCr;
  public int LCu;
  public int LCw;
  public int LCx;
  public int MtX;
  public int MtY;
  public int MtZ;
  public long Mua;
  public String dVY;
  public int duration;
  public long feedId;
  public int mzA;
  public int networkId;
  public int scene;
  public String uUI;
  public int whS;
  public String wiK;
  public int wiL;
  public LinkedList<com> wit;
  
  public cno()
  {
    AppMethodBeat.i(209742);
    this.wit = new LinkedList();
    AppMethodBeat.o(209742);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209743);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.feedId);
      paramVarArgs.aM(2, this.LCp);
      paramVarArgs.aM(3, this.scene);
      paramVarArgs.aM(4, this.LCq);
      paramVarArgs.aM(5, this.mzA);
      paramVarArgs.aM(6, this.LCr);
      paramVarArgs.aM(7, this.duration);
      paramVarArgs.aM(8, this.MtX);
      paramVarArgs.aM(9, this.MtY);
      paramVarArgs.aM(10, this.LCu);
      paramVarArgs.e(11, 8, this.wit);
      paramVarArgs.aM(12, this.MtZ);
      paramVarArgs.aM(13, this.whS);
      paramVarArgs.aM(14, this.LCw);
      if (this.uUI != null) {
        paramVarArgs.e(15, this.uUI);
      }
      paramVarArgs.bb(16, this.Mua);
      paramVarArgs.aM(17, this.LCx);
      paramVarArgs.aM(18, this.networkId);
      if (this.wiK != null) {
        paramVarArgs.e(19, this.wiK);
      }
      paramVarArgs.aM(20, this.wiL);
      if (this.dVY != null) {
        paramVarArgs.e(21, this.dVY);
      }
      AppMethodBeat.o(209743);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.feedId) + 0 + g.a.a.b.b.a.bu(2, this.LCp) + g.a.a.b.b.a.bu(3, this.scene) + g.a.a.b.b.a.bu(4, this.LCq) + g.a.a.b.b.a.bu(5, this.mzA) + g.a.a.b.b.a.bu(6, this.LCr) + g.a.a.b.b.a.bu(7, this.duration) + g.a.a.b.b.a.bu(8, this.MtX) + g.a.a.b.b.a.bu(9, this.MtY) + g.a.a.b.b.a.bu(10, this.LCu) + g.a.a.a.c(11, 8, this.wit) + g.a.a.b.b.a.bu(12, this.MtZ) + g.a.a.b.b.a.bu(13, this.whS) + g.a.a.b.b.a.bu(14, this.LCw);
      paramInt = i;
      if (this.uUI != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.uUI);
      }
      i = paramInt + g.a.a.b.b.a.r(16, this.Mua) + g.a.a.b.b.a.bu(17, this.LCx) + g.a.a.b.b.a.bu(18, this.networkId);
      paramInt = i;
      if (this.wiK != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.wiK);
      }
      i = paramInt + g.a.a.b.b.a.bu(20, this.wiL);
      paramInt = i;
      if (this.dVY != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.dVY);
      }
      AppMethodBeat.o(209743);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wit.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209743);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cno localcno = (cno)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209743);
        return -1;
      case 1: 
        localcno.feedId = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(209743);
        return 0;
      case 2: 
        localcno.LCp = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209743);
        return 0;
      case 3: 
        localcno.scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209743);
        return 0;
      case 4: 
        localcno.LCq = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209743);
        return 0;
      case 5: 
        localcno.mzA = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209743);
        return 0;
      case 6: 
        localcno.LCr = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209743);
        return 0;
      case 7: 
        localcno.duration = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209743);
        return 0;
      case 8: 
        localcno.MtX = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209743);
        return 0;
      case 9: 
        localcno.MtY = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209743);
        return 0;
      case 10: 
        localcno.LCu = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209743);
        return 0;
      case 11: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new com();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((com)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcno.wit.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209743);
        return 0;
      case 12: 
        localcno.MtZ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209743);
        return 0;
      case 13: 
        localcno.whS = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209743);
        return 0;
      case 14: 
        localcno.LCw = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209743);
        return 0;
      case 15: 
        localcno.uUI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209743);
        return 0;
      case 16: 
        localcno.Mua = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(209743);
        return 0;
      case 17: 
        localcno.LCx = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209743);
        return 0;
      case 18: 
        localcno.networkId = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209743);
        return 0;
      case 19: 
        localcno.wiK = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209743);
        return 0;
      case 20: 
        localcno.wiL = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209743);
        return 0;
      }
      localcno.dVY = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(209743);
      return 0;
    }
    AppMethodBeat.o(209743);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cno
 * JD-Core Version:    0.7.0.1
 */