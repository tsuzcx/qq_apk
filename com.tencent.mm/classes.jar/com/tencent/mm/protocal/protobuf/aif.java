package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aif
  extends com.tencent.mm.bx.a
{
  public int DkL;
  public int DkM;
  public int DkN;
  public int DkO;
  public int DkP;
  public int DkQ;
  public int DkR;
  public String DkS;
  public int DkU;
  public String DkV;
  public int DkW;
  public String KTW;
  public long KVz;
  public int duration;
  public long feedId;
  public int kqF;
  public int networkId;
  public int qGA;
  public LinkedList<alx> qHc;
  public int scene;
  public int xXi;
  
  public aif()
  {
    AppMethodBeat.i(184197);
    this.qHc = new LinkedList();
    AppMethodBeat.o(184197);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184198);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.feedId);
      paramVarArgs.aR(2, this.xXi);
      paramVarArgs.aR(3, this.scene);
      paramVarArgs.aR(4, this.DkL);
      paramVarArgs.aR(5, this.kqF);
      paramVarArgs.aR(6, this.DkM);
      paramVarArgs.aR(7, this.duration);
      paramVarArgs.aR(8, this.DkN);
      paramVarArgs.aR(9, this.DkO);
      paramVarArgs.aR(10, this.DkP);
      paramVarArgs.e(11, 8, this.qHc);
      paramVarArgs.aR(12, this.DkQ);
      paramVarArgs.aR(13, this.qGA);
      paramVarArgs.aR(14, this.DkR);
      if (this.KTW != null) {
        paramVarArgs.d(15, this.KTW);
      }
      paramVarArgs.aG(16, this.KVz);
      paramVarArgs.aR(17, this.DkU);
      paramVarArgs.aR(18, this.networkId);
      if (this.DkV != null) {
        paramVarArgs.d(19, this.DkV);
      }
      paramVarArgs.aR(20, this.DkW);
      if (this.DkS != null) {
        paramVarArgs.d(21, this.DkS);
      }
      AppMethodBeat.o(184198);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.q(1, this.feedId) + 0 + f.a.a.b.b.a.bA(2, this.xXi) + f.a.a.b.b.a.bA(3, this.scene) + f.a.a.b.b.a.bA(4, this.DkL) + f.a.a.b.b.a.bA(5, this.kqF) + f.a.a.b.b.a.bA(6, this.DkM) + f.a.a.b.b.a.bA(7, this.duration) + f.a.a.b.b.a.bA(8, this.DkN) + f.a.a.b.b.a.bA(9, this.DkO) + f.a.a.b.b.a.bA(10, this.DkP) + f.a.a.a.c(11, 8, this.qHc) + f.a.a.b.b.a.bA(12, this.DkQ) + f.a.a.b.b.a.bA(13, this.qGA) + f.a.a.b.b.a.bA(14, this.DkR);
      paramInt = i;
      if (this.KTW != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.KTW);
      }
      i = paramInt + f.a.a.b.b.a.q(16, this.KVz) + f.a.a.b.b.a.bA(17, this.DkU) + f.a.a.b.b.a.bA(18, this.networkId);
      paramInt = i;
      if (this.DkV != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.DkV);
      }
      i = paramInt + f.a.a.b.b.a.bA(20, this.DkW);
      paramInt = i;
      if (this.DkS != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.DkS);
      }
      AppMethodBeat.o(184198);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.qHc.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(184198);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      aif localaif = (aif)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184198);
        return -1;
      case 1: 
        localaif.feedId = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(184198);
        return 0;
      case 2: 
        localaif.xXi = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(184198);
        return 0;
      case 3: 
        localaif.scene = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(184198);
        return 0;
      case 4: 
        localaif.DkL = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(184198);
        return 0;
      case 5: 
        localaif.kqF = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(184198);
        return 0;
      case 6: 
        localaif.DkM = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(184198);
        return 0;
      case 7: 
        localaif.duration = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(184198);
        return 0;
      case 8: 
        localaif.DkN = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(184198);
        return 0;
      case 9: 
        localaif.DkO = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(184198);
        return 0;
      case 10: 
        localaif.DkP = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(184198);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new alx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((alx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaif.qHc.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(184198);
        return 0;
      case 12: 
        localaif.DkQ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(184198);
        return 0;
      case 13: 
        localaif.qGA = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(184198);
        return 0;
      case 14: 
        localaif.DkR = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(184198);
        return 0;
      case 15: 
        localaif.KTW = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(184198);
        return 0;
      case 16: 
        localaif.KVz = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(184198);
        return 0;
      case 17: 
        localaif.DkU = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(184198);
        return 0;
      case 18: 
        localaif.networkId = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(184198);
        return 0;
      case 19: 
        localaif.DkV = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(184198);
        return 0;
      case 20: 
        localaif.DkW = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(184198);
        return 0;
      }
      localaif.DkS = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(184198);
      return 0;
    }
    AppMethodBeat.o(184198);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aif
 * JD-Core Version:    0.7.0.1
 */