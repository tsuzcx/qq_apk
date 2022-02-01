package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ega
  extends com.tencent.mm.bw.a
{
  public String GLP;
  public int GWA;
  public String GeS;
  public int GeT;
  public String HDq;
  public int HFR;
  public int HFV;
  public int HGo;
  public int HUi;
  public buh HkU;
  public String Hvs;
  public LinkedList<aaj> Iiw;
  public int IjH;
  public String IjI;
  public String IjJ;
  public LinkedList<String> IjK;
  public int IjL;
  public ato IjM;
  public int Scene;
  public int nJA;
  
  public ega()
  {
    AppMethodBeat.i(117947);
    this.IjH = 2;
    this.Iiw = new LinkedList();
    this.IjK = new LinkedList();
    AppMethodBeat.o(117947);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117948);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GeT);
      paramVarArgs.aS(2, this.GWA);
      paramVarArgs.aS(3, this.HFR);
      if (this.GLP != null) {
        paramVarArgs.d(4, this.GLP);
      }
      if (this.HkU != null)
      {
        paramVarArgs.lJ(5, this.HkU.computeSize());
        this.HkU.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.Scene);
      if (this.GeS != null) {
        paramVarArgs.d(7, this.GeS);
      }
      paramVarArgs.aS(8, this.HFV);
      paramVarArgs.aS(9, this.IjH);
      paramVarArgs.e(10, 8, this.Iiw);
      if (this.IjI != null) {
        paramVarArgs.d(11, this.IjI);
      }
      if (this.Hvs != null) {
        paramVarArgs.d(12, this.Hvs);
      }
      paramVarArgs.aS(13, this.HUi);
      if (this.IjJ != null) {
        paramVarArgs.d(14, this.IjJ);
      }
      if (this.HDq != null) {
        paramVarArgs.d(15, this.HDq);
      }
      paramVarArgs.e(16, 1, this.IjK);
      paramVarArgs.aS(17, this.HGo);
      paramVarArgs.aS(18, this.nJA);
      paramVarArgs.aS(19, this.IjL);
      if (this.IjM != null)
      {
        paramVarArgs.lJ(20, this.IjM.computeSize());
        this.IjM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117948);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.GeT) + 0 + f.a.a.b.b.a.bz(2, this.GWA) + f.a.a.b.b.a.bz(3, this.HFR);
      paramInt = i;
      if (this.GLP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GLP);
      }
      i = paramInt;
      if (this.HkU != null) {
        i = paramInt + f.a.a.a.lI(5, this.HkU.computeSize());
      }
      i += f.a.a.b.b.a.bz(6, this.Scene);
      paramInt = i;
      if (this.GeS != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GeS);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.HFV) + f.a.a.b.b.a.bz(9, this.IjH) + f.a.a.a.c(10, 8, this.Iiw);
      paramInt = i;
      if (this.IjI != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.IjI);
      }
      i = paramInt;
      if (this.Hvs != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Hvs);
      }
      i += f.a.a.b.b.a.bz(13, this.HUi);
      paramInt = i;
      if (this.IjJ != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.IjJ);
      }
      i = paramInt;
      if (this.HDq != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.HDq);
      }
      i = i + f.a.a.a.c(16, 1, this.IjK) + f.a.a.b.b.a.bz(17, this.HGo) + f.a.a.b.b.a.bz(18, this.nJA) + f.a.a.b.b.a.bz(19, this.IjL);
      paramInt = i;
      if (this.IjM != null) {
        paramInt = i + f.a.a.a.lI(20, this.IjM.computeSize());
      }
      AppMethodBeat.o(117948);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Iiw.clear();
      this.IjK.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(117948);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ega localega = (ega)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117948);
        return -1;
      case 1: 
        localega.GeT = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117948);
        return 0;
      case 2: 
        localega.GWA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117948);
        return 0;
      case 3: 
        localega.HFR = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117948);
        return 0;
      case 4: 
        localega.GLP = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new buh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((buh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localega.HkU = ((buh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117948);
        return 0;
      case 6: 
        localega.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117948);
        return 0;
      case 7: 
        localega.GeS = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 8: 
        localega.HFV = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117948);
        return 0;
      case 9: 
        localega.IjH = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117948);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aaj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aaj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localega.Iiw.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117948);
        return 0;
      case 11: 
        localega.IjI = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 12: 
        localega.Hvs = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 13: 
        localega.HUi = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117948);
        return 0;
      case 14: 
        localega.IjJ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 15: 
        localega.HDq = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 16: 
        localega.IjK.add(((f.a.a.a.a)localObject1).OmT.readString());
        AppMethodBeat.o(117948);
        return 0;
      case 17: 
        localega.HGo = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117948);
        return 0;
      case 18: 
        localega.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117948);
        return 0;
      case 19: 
        localega.IjL = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117948);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ato();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ato)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localega.IjM = ((ato)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(117948);
      return 0;
    }
    AppMethodBeat.o(117948);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ega
 * JD-Core Version:    0.7.0.1
 */