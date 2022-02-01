package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bqt
  extends com.tencent.mm.bw.a
{
  public int FfT;
  public LinkedList<bqs> FfU;
  public int FfV;
  public int FfW;
  public long FfX;
  public long FfY;
  public long FfZ;
  public long Fga;
  public LinkedList<bqq> Fgb;
  public String clientId;
  public long fWs;
  public int gLY;
  
  public bqt()
  {
    AppMethodBeat.i(169081);
    this.FfU = new LinkedList();
    this.Fgb = new LinkedList();
    AppMethodBeat.o(169081);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169082);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.clientId != null) {
        paramVarArgs.d(1, this.clientId);
      }
      paramVarArgs.aR(2, this.gLY);
      paramVarArgs.aR(3, this.FfT);
      paramVarArgs.e(4, 8, this.FfU);
      paramVarArgs.aR(5, this.FfV);
      paramVarArgs.aR(6, this.FfW);
      paramVarArgs.aO(7, this.FfX);
      paramVarArgs.aO(8, this.FfY);
      paramVarArgs.aO(9, this.FfZ);
      paramVarArgs.aO(10, this.fWs);
      paramVarArgs.aO(11, this.Fga);
      paramVarArgs.e(12, 8, this.Fgb);
      AppMethodBeat.o(169082);
      return 0;
    }
    if (paramInt == 1) {
      if (this.clientId == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = f.a.a.b.b.a.e(1, this.clientId) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.gLY);
      int j = f.a.a.b.b.a.bx(3, this.FfT);
      int k = f.a.a.a.c(4, 8, this.FfU);
      int m = f.a.a.b.b.a.bx(5, this.FfV);
      int n = f.a.a.b.b.a.bx(6, this.FfW);
      int i1 = f.a.a.b.b.a.p(7, this.FfX);
      int i2 = f.a.a.b.b.a.p(8, this.FfY);
      int i3 = f.a.a.b.b.a.p(9, this.FfZ);
      int i4 = f.a.a.b.b.a.p(10, this.fWs);
      int i5 = f.a.a.b.b.a.p(11, this.Fga);
      int i6 = f.a.a.a.c(12, 8, this.Fgb);
      AppMethodBeat.o(169082);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FfU.clear();
        this.Fgb.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(169082);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bqt localbqt = (bqt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169082);
          return -1;
        case 1: 
          localbqt.clientId = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169082);
          return 0;
        case 2: 
          localbqt.gLY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169082);
          return 0;
        case 3: 
          localbqt.FfT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169082);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bqs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bqs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqt.FfU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169082);
          return 0;
        case 5: 
          localbqt.FfV = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169082);
          return 0;
        case 6: 
          localbqt.FfW = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169082);
          return 0;
        case 7: 
          localbqt.FfX = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(169082);
          return 0;
        case 8: 
          localbqt.FfY = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(169082);
          return 0;
        case 9: 
          localbqt.FfZ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(169082);
          return 0;
        case 10: 
          localbqt.fWs = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(169082);
          return 0;
        case 11: 
          localbqt.Fga = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(169082);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bqq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bqq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbqt.Fgb.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169082);
        return 0;
      }
      AppMethodBeat.o(169082);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqt
 * JD-Core Version:    0.7.0.1
 */