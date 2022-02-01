package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bme
  extends com.tencent.mm.bx.a
{
  public int DJF;
  public LinkedList<bmd> DJG;
  public int DJH;
  public int DJI;
  public long DJJ;
  public long DJK;
  public long DJL;
  public long DJM;
  public LinkedList<ebc> LzN;
  public String clientId;
  public long fSx;
  public int gll;
  
  public bme()
  {
    AppMethodBeat.i(169081);
    this.DJG = new LinkedList();
    this.LzN = new LinkedList();
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
      paramVarArgs.aR(2, this.gll);
      paramVarArgs.aR(3, this.DJF);
      paramVarArgs.e(4, 8, this.DJG);
      paramVarArgs.aR(5, this.DJH);
      paramVarArgs.aR(6, this.DJI);
      paramVarArgs.aG(7, this.DJJ);
      paramVarArgs.aG(8, this.DJK);
      paramVarArgs.aG(9, this.DJL);
      paramVarArgs.aG(10, this.fSx);
      paramVarArgs.aG(11, this.DJM);
      paramVarArgs.e(12, 8, this.LzN);
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
      int i = f.a.a.b.b.a.bA(2, this.gll);
      int j = f.a.a.b.b.a.bA(3, this.DJF);
      int k = f.a.a.a.c(4, 8, this.DJG);
      int m = f.a.a.b.b.a.bA(5, this.DJH);
      int n = f.a.a.b.b.a.bA(6, this.DJI);
      int i1 = f.a.a.b.b.a.q(7, this.DJJ);
      int i2 = f.a.a.b.b.a.q(8, this.DJK);
      int i3 = f.a.a.b.b.a.q(9, this.DJL);
      int i4 = f.a.a.b.b.a.q(10, this.fSx);
      int i5 = f.a.a.b.b.a.q(11, this.DJM);
      int i6 = f.a.a.a.c(12, 8, this.LzN);
      AppMethodBeat.o(169082);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DJG.clear();
        this.LzN.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(169082);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bme localbme = (bme)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169082);
          return -1;
        case 1: 
          localbme.clientId = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169082);
          return 0;
        case 2: 
          localbme.gll = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169082);
          return 0;
        case 3: 
          localbme.DJF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169082);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbme.DJG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169082);
          return 0;
        case 5: 
          localbme.DJH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169082);
          return 0;
        case 6: 
          localbme.DJI = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169082);
          return 0;
        case 7: 
          localbme.DJJ = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(169082);
          return 0;
        case 8: 
          localbme.DJK = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(169082);
          return 0;
        case 9: 
          localbme.DJL = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(169082);
          return 0;
        case 10: 
          localbme.fSx = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(169082);
          return 0;
        case 11: 
          localbme.DJM = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(169082);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ebc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ebc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbme.LzN.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bme
 * JD-Core Version:    0.7.0.1
 */