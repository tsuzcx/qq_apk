package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class nn
  extends com.tencent.mm.bw.a
{
  public int FZI;
  public int FZU;
  public int FZV;
  public int FZW;
  public int FZX;
  public long FZY;
  public long FZZ;
  public String FZx;
  public boolean Gaa;
  public int Gab;
  public boolean Gac;
  public iv Gad;
  public boolean Gae;
  public vv Gaf;
  public LinkedList<ecn> Gag;
  public boolean Gah;
  public LinkedList<String> Gai;
  public String Gaj;
  public String Gak;
  
  public nn()
  {
    AppMethodBeat.i(188923);
    this.Gag = new LinkedList();
    this.Gai = new LinkedList();
    AppMethodBeat.o(188923);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124426);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FZx == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124426);
        throw paramVarArgs;
      }
      if (this.FZx != null) {
        paramVarArgs.d(1, this.FZx);
      }
      paramVarArgs.aS(2, this.FZU);
      paramVarArgs.aS(3, this.FZV);
      paramVarArgs.aS(4, this.FZW);
      paramVarArgs.aS(5, this.FZX);
      paramVarArgs.aZ(6, this.FZY);
      paramVarArgs.aZ(7, this.FZZ);
      paramVarArgs.aS(8, this.FZI);
      paramVarArgs.bC(9, this.Gaa);
      paramVarArgs.aS(10, this.Gab);
      paramVarArgs.bC(11, this.Gac);
      if (this.Gad != null)
      {
        paramVarArgs.lJ(12, this.Gad.computeSize());
        this.Gad.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(13, this.Gae);
      if (this.Gaf != null)
      {
        paramVarArgs.lJ(14, this.Gaf.computeSize());
        this.Gaf.writeFields(paramVarArgs);
      }
      paramVarArgs.e(15, 8, this.Gag);
      paramVarArgs.bC(16, this.Gah);
      paramVarArgs.e(17, 1, this.Gai);
      if (this.Gaj != null) {
        paramVarArgs.d(18, this.Gaj);
      }
      if (this.Gak != null) {
        paramVarArgs.d(19, this.Gak);
      }
      AppMethodBeat.o(124426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FZx == null) {
        break label1410;
      }
    }
    label1410:
    for (paramInt = f.a.a.b.b.a.e(1, this.FZx) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FZU) + f.a.a.b.b.a.bz(3, this.FZV) + f.a.a.b.b.a.bz(4, this.FZW) + f.a.a.b.b.a.bz(5, this.FZX) + f.a.a.b.b.a.p(6, this.FZY) + f.a.a.b.b.a.p(7, this.FZZ) + f.a.a.b.b.a.bz(8, this.FZI) + f.a.a.b.b.a.amF(9) + f.a.a.b.b.a.bz(10, this.Gab) + f.a.a.b.b.a.amF(11);
      paramInt = i;
      if (this.Gad != null) {
        paramInt = i + f.a.a.a.lI(12, this.Gad.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.amF(13);
      paramInt = i;
      if (this.Gaf != null) {
        paramInt = i + f.a.a.a.lI(14, this.Gaf.computeSize());
      }
      i = paramInt + f.a.a.a.c(15, 8, this.Gag) + f.a.a.b.b.a.amF(16) + f.a.a.a.c(17, 1, this.Gai);
      paramInt = i;
      if (this.Gaj != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.Gaj);
      }
      i = paramInt;
      if (this.Gak != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.Gak);
      }
      AppMethodBeat.o(124426);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gag.clear();
        this.Gai.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FZx == null)
        {
          paramVarArgs = new b("Not all required fields were included: brand_user_name");
          AppMethodBeat.o(124426);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124426);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        nn localnn = (nn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124426);
          return -1;
        case 1: 
          localnn.FZx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124426);
          return 0;
        case 2: 
          localnn.FZU = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124426);
          return 0;
        case 3: 
          localnn.FZV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124426);
          return 0;
        case 4: 
          localnn.FZW = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124426);
          return 0;
        case 5: 
          localnn.FZX = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124426);
          return 0;
        case 6: 
          localnn.FZY = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(124426);
          return 0;
        case 7: 
          localnn.FZZ = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(124426);
          return 0;
        case 8: 
          localnn.FZI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124426);
          return 0;
        case 9: 
          localnn.Gaa = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(124426);
          return 0;
        case 10: 
          localnn.Gab = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124426);
          return 0;
        case 11: 
          localnn.Gac = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(124426);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnn.Gad = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124426);
          return 0;
        case 13: 
          localnn.Gae = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(124426);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new vv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((vv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnn.Gaf = ((vv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124426);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnn.Gag.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124426);
          return 0;
        case 16: 
          localnn.Gah = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(124426);
          return 0;
        case 17: 
          localnn.Gai.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(124426);
          return 0;
        case 18: 
          localnn.Gaj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124426);
          return 0;
        }
        localnn.Gak = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(124426);
        return 0;
      }
      AppMethodBeat.o(124426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nn
 * JD-Core Version:    0.7.0.1
 */