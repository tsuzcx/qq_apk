package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class dnh
  extends ckq
{
  public int CYi;
  public int DdZ;
  public int EoJ;
  public int EoK;
  public int EoL;
  public int EoM;
  public int EoN;
  public LinkedList<Integer> EoO;
  public int EoP;
  public int EoQ;
  public LinkedList<Integer> EoR;
  public int EoS;
  public int EoT;
  
  public dnh()
  {
    AppMethodBeat.i(115916);
    this.EoO = new LinkedList();
    this.EoR = new LinkedList();
    AppMethodBeat.o(115916);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115917);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DdZ);
      paramVarArgs.aR(3, this.EoJ);
      paramVarArgs.aR(4, this.CYi);
      paramVarArgs.aR(5, this.EoK);
      paramVarArgs.aR(6, this.EoL);
      paramVarArgs.aR(7, this.EoM);
      paramVarArgs.aR(8, this.EoN);
      paramVarArgs.f(9, 2, this.EoO);
      paramVarArgs.aR(10, this.EoP);
      paramVarArgs.aR(11, this.EoQ);
      paramVarArgs.f(12, 2, this.EoR);
      paramVarArgs.aR(13, this.EoS);
      paramVarArgs.aR(14, this.EoT);
      AppMethodBeat.o(115917);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label984;
      }
    }
    label984:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.DdZ);
      int j = f.a.a.b.b.a.bA(3, this.EoJ);
      int k = f.a.a.b.b.a.bA(4, this.CYi);
      int m = f.a.a.b.b.a.bA(5, this.EoK);
      int n = f.a.a.b.b.a.bA(6, this.EoL);
      int i1 = f.a.a.b.b.a.bA(7, this.EoM);
      int i2 = f.a.a.b.b.a.bA(8, this.EoN);
      int i3 = f.a.a.a.d(9, 2, this.EoO);
      int i4 = f.a.a.b.b.a.bA(10, this.EoP);
      int i5 = f.a.a.b.b.a.bA(11, this.EoQ);
      int i6 = f.a.a.a.d(12, 2, this.EoR);
      int i7 = f.a.a.b.b.a.bA(13, this.EoS);
      int i8 = f.a.a.b.b.a.bA(14, this.EoT);
      AppMethodBeat.o(115917);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EoO.clear();
        this.EoR.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(115917);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dnh localdnh = (dnh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115917);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnh.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115917);
          return 0;
        case 2: 
          localdnh.DdZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115917);
          return 0;
        case 3: 
          localdnh.EoJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115917);
          return 0;
        case 4: 
          localdnh.CYi = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115917);
          return 0;
        case 5: 
          localdnh.EoK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115917);
          return 0;
        case 6: 
          localdnh.EoL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115917);
          return 0;
        case 7: 
          localdnh.EoM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115917);
          return 0;
        case 8: 
          localdnh.EoN = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115917);
          return 0;
        case 9: 
          localdnh.EoO = new f.a.a.a.a(((f.a.a.a.a)localObject1).KhF.fMu().wA, unknownTagHandler).KhF.fMs();
          AppMethodBeat.o(115917);
          return 0;
        case 10: 
          localdnh.EoP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115917);
          return 0;
        case 11: 
          localdnh.EoQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115917);
          return 0;
        case 12: 
          localdnh.EoR = new f.a.a.a.a(((f.a.a.a.a)localObject1).KhF.fMu().wA, unknownTagHandler).KhF.fMs();
          AppMethodBeat.o(115917);
          return 0;
        case 13: 
          localdnh.EoS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115917);
          return 0;
        }
        localdnh.EoT = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(115917);
        return 0;
      }
      AppMethodBeat.o(115917);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnh
 * JD-Core Version:    0.7.0.1
 */