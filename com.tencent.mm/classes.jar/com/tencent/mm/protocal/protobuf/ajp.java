package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajp
  extends com.tencent.mm.bw.a
{
  public int EEh;
  public int EEi;
  public int EEj;
  public int EEk;
  public int EEl;
  public int EEm;
  public int EEn;
  public int EEo;
  public long dig;
  public String drn;
  public int duration;
  public int kRY;
  public int networkId;
  public String rvP;
  public LinkedList<apa> rzL;
  public String rzW;
  public int rzX;
  public long rzi;
  public int rzk;
  public int scene;
  public int zkd;
  
  public ajp()
  {
    AppMethodBeat.i(184197);
    this.rzL = new LinkedList();
    AppMethodBeat.o(184197);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184198);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.dig);
      paramVarArgs.aR(2, this.zkd);
      paramVarArgs.aR(3, this.scene);
      paramVarArgs.aR(4, this.EEh);
      paramVarArgs.aR(5, this.kRY);
      paramVarArgs.aR(6, this.EEi);
      paramVarArgs.aR(7, this.duration);
      paramVarArgs.aR(8, this.EEj);
      paramVarArgs.aR(9, this.EEk);
      paramVarArgs.aR(10, this.EEl);
      paramVarArgs.e(11, 8, this.rzL);
      paramVarArgs.aR(12, this.EEm);
      paramVarArgs.aR(13, this.rzk);
      paramVarArgs.aR(14, this.EEn);
      if (this.rvP != null) {
        paramVarArgs.d(15, this.rvP);
      }
      paramVarArgs.aO(16, this.rzi);
      paramVarArgs.aR(17, this.EEo);
      paramVarArgs.aR(18, this.networkId);
      if (this.rzW != null) {
        paramVarArgs.d(19, this.rzW);
      }
      paramVarArgs.aR(20, this.rzX);
      if (this.drn != null) {
        paramVarArgs.d(21, this.drn);
      }
      AppMethodBeat.o(184198);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.dig) + 0 + f.a.a.b.b.a.bx(2, this.zkd) + f.a.a.b.b.a.bx(3, this.scene) + f.a.a.b.b.a.bx(4, this.EEh) + f.a.a.b.b.a.bx(5, this.kRY) + f.a.a.b.b.a.bx(6, this.EEi) + f.a.a.b.b.a.bx(7, this.duration) + f.a.a.b.b.a.bx(8, this.EEj) + f.a.a.b.b.a.bx(9, this.EEk) + f.a.a.b.b.a.bx(10, this.EEl) + f.a.a.a.c(11, 8, this.rzL) + f.a.a.b.b.a.bx(12, this.EEm) + f.a.a.b.b.a.bx(13, this.rzk) + f.a.a.b.b.a.bx(14, this.EEn);
      paramInt = i;
      if (this.rvP != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.rvP);
      }
      i = paramInt + f.a.a.b.b.a.p(16, this.rzi) + f.a.a.b.b.a.bx(17, this.EEo) + f.a.a.b.b.a.bx(18, this.networkId);
      paramInt = i;
      if (this.rzW != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.rzW);
      }
      i = paramInt + f.a.a.b.b.a.bx(20, this.rzX);
      paramInt = i;
      if (this.drn != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.drn);
      }
      AppMethodBeat.o(184198);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.rzL.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(184198);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ajp localajp = (ajp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184198);
        return -1;
      case 1: 
        localajp.dig = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(184198);
        return 0;
      case 2: 
        localajp.zkd = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(184198);
        return 0;
      case 3: 
        localajp.scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(184198);
        return 0;
      case 4: 
        localajp.EEh = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(184198);
        return 0;
      case 5: 
        localajp.kRY = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(184198);
        return 0;
      case 6: 
        localajp.EEi = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(184198);
        return 0;
      case 7: 
        localajp.duration = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(184198);
        return 0;
      case 8: 
        localajp.EEj = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(184198);
        return 0;
      case 9: 
        localajp.EEk = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(184198);
        return 0;
      case 10: 
        localajp.EEl = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(184198);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new apa();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((apa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localajp.rzL.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(184198);
        return 0;
      case 12: 
        localajp.EEm = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(184198);
        return 0;
      case 13: 
        localajp.rzk = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(184198);
        return 0;
      case 14: 
        localajp.EEn = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(184198);
        return 0;
      case 15: 
        localajp.rvP = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(184198);
        return 0;
      case 16: 
        localajp.rzi = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(184198);
        return 0;
      case 17: 
        localajp.EEo = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(184198);
        return 0;
      case 18: 
        localajp.networkId = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(184198);
        return 0;
      case 19: 
        localajp.rzW = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(184198);
        return 0;
      case 20: 
        localajp.rzX = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(184198);
        return 0;
      }
      localajp.drn = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(184198);
      return 0;
    }
    AppMethodBeat.o(184198);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajp
 * JD-Core Version:    0.7.0.1
 */