package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class avg
  extends com.tencent.mm.bx.a
{
  public int FqN;
  public String GtD;
  public String GtE;
  public String GtF;
  public String GtG;
  public String GtH;
  public int GtI;
  public int GtJ;
  public int GtK;
  public b GtL;
  public LinkedList<bos> GtM;
  public int Gtu;
  public String Title;
  public String hDa;
  public String nDo;
  public String uOt;
  
  public avg()
  {
    AppMethodBeat.i(195474);
    this.GtM = new LinkedList();
    AppMethodBeat.o(195474);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152549);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gtu);
      if (this.GtD != null) {
        paramVarArgs.d(2, this.GtD);
      }
      if (this.GtE != null) {
        paramVarArgs.d(3, this.GtE);
      }
      paramVarArgs.aS(4, this.FqN);
      if (this.Title != null) {
        paramVarArgs.d(5, this.Title);
      }
      if (this.hDa != null) {
        paramVarArgs.d(6, this.hDa);
      }
      if (this.nDo != null) {
        paramVarArgs.d(7, this.nDo);
      }
      if (this.GtF != null) {
        paramVarArgs.d(8, this.GtF);
      }
      if (this.uOt != null) {
        paramVarArgs.d(10, this.uOt);
      }
      if (this.GtG != null) {
        paramVarArgs.d(11, this.GtG);
      }
      if (this.GtH != null) {
        paramVarArgs.d(12, this.GtH);
      }
      paramVarArgs.aS(13, this.GtI);
      paramVarArgs.aS(14, this.GtJ);
      paramVarArgs.aS(15, this.GtK);
      if (this.GtL != null) {
        paramVarArgs.c(16, this.GtL);
      }
      paramVarArgs.e(17, 8, this.GtM);
      AppMethodBeat.o(152549);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Gtu) + 0;
      paramInt = i;
      if (this.GtD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GtD);
      }
      i = paramInt;
      if (this.GtE != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GtE);
      }
      i += f.a.a.b.b.a.bz(4, this.FqN);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Title);
      }
      i = paramInt;
      if (this.hDa != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.hDa);
      }
      paramInt = i;
      if (this.nDo != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.nDo);
      }
      i = paramInt;
      if (this.GtF != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GtF);
      }
      paramInt = i;
      if (this.uOt != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.uOt);
      }
      i = paramInt;
      if (this.GtG != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.GtG);
      }
      paramInt = i;
      if (this.GtH != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.GtH);
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.GtI) + f.a.a.b.b.a.bz(14, this.GtJ) + f.a.a.b.b.a.bz(15, this.GtK);
      paramInt = i;
      if (this.GtL != null) {
        paramInt = i + f.a.a.b.b.a.b(16, this.GtL);
      }
      i = f.a.a.a.c(17, 8, this.GtM);
      AppMethodBeat.o(152549);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GtM.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(152549);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      avg localavg = (avg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 9: 
      default: 
        AppMethodBeat.o(152549);
        return -1;
      case 1: 
        localavg.Gtu = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152549);
        return 0;
      case 2: 
        localavg.GtD = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 3: 
        localavg.GtE = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 4: 
        localavg.FqN = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152549);
        return 0;
      case 5: 
        localavg.Title = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 6: 
        localavg.hDa = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 7: 
        localavg.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 8: 
        localavg.GtF = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 10: 
        localavg.uOt = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 11: 
        localavg.GtG = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 12: 
        localavg.GtH = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 13: 
        localavg.GtI = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152549);
        return 0;
      case 14: 
        localavg.GtJ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152549);
        return 0;
      case 15: 
        localavg.GtK = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152549);
        return 0;
      case 16: 
        localavg.GtL = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(152549);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bos();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bos)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localavg.GtM.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(152549);
      return 0;
    }
    AppMethodBeat.o(152549);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avg
 * JD-Core Version:    0.7.0.1
 */