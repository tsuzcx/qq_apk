package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dku
  extends com.tencent.mm.bx.a
{
  public String FGE;
  public LinkedList<bsu> FMs;
  public String GQJ;
  public int Hzg;
  public int Hzh;
  public int Hzi;
  public int Hzj;
  public int Hzk;
  public int Hzl;
  public int Hzm;
  public String Hzn;
  public String Hzo;
  public int Hzp;
  public String Title;
  
  public dku()
  {
    AppMethodBeat.i(152702);
    this.FMs = new LinkedList();
    AppMethodBeat.o(152702);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152703);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GQJ != null) {
        paramVarArgs.d(1, this.GQJ);
      }
      paramVarArgs.aS(2, this.Hzg);
      paramVarArgs.aS(3, this.Hzh);
      paramVarArgs.aS(4, this.Hzi);
      paramVarArgs.aS(5, this.Hzj);
      if (this.Title != null) {
        paramVarArgs.d(6, this.Title);
      }
      paramVarArgs.e(7, 8, this.FMs);
      paramVarArgs.aS(8, this.Hzk);
      if (this.FGE != null) {
        paramVarArgs.d(9, this.FGE);
      }
      paramVarArgs.aS(10, this.Hzl);
      paramVarArgs.aS(11, this.Hzm);
      if (this.Hzn != null) {
        paramVarArgs.d(12, this.Hzn);
      }
      if (this.Hzo != null) {
        paramVarArgs.d(13, this.Hzo);
      }
      paramVarArgs.aS(14, this.Hzp);
      AppMethodBeat.o(152703);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GQJ == null) {
        break label958;
      }
    }
    label958:
    for (paramInt = f.a.a.b.b.a.e(1, this.GQJ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Hzg) + f.a.a.b.b.a.bz(3, this.Hzh) + f.a.a.b.b.a.bz(4, this.Hzi) + f.a.a.b.b.a.bz(5, this.Hzj);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Title);
      }
      i = paramInt + f.a.a.a.c(7, 8, this.FMs) + f.a.a.b.b.a.bz(8, this.Hzk);
      paramInt = i;
      if (this.FGE != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FGE);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.Hzl) + f.a.a.b.b.a.bz(11, this.Hzm);
      paramInt = i;
      if (this.Hzn != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Hzn);
      }
      i = paramInt;
      if (this.Hzo != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.Hzo);
      }
      paramInt = f.a.a.b.b.a.bz(14, this.Hzp);
      AppMethodBeat.o(152703);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FMs.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152703);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dku localdku = (dku)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152703);
          return -1;
        case 1: 
          localdku.GQJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 2: 
          localdku.Hzg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152703);
          return 0;
        case 3: 
          localdku.Hzh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152703);
          return 0;
        case 4: 
          localdku.Hzi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152703);
          return 0;
        case 5: 
          localdku.Hzj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152703);
          return 0;
        case 6: 
          localdku.Title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bsu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdku.FMs.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152703);
          return 0;
        case 8: 
          localdku.Hzk = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152703);
          return 0;
        case 9: 
          localdku.FGE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 10: 
          localdku.Hzl = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152703);
          return 0;
        case 11: 
          localdku.Hzm = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152703);
          return 0;
        case 12: 
          localdku.Hzn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 13: 
          localdku.Hzo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152703);
          return 0;
        }
        localdku.Hzp = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152703);
        return 0;
      }
      AppMethodBeat.o(152703);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dku
 * JD-Core Version:    0.7.0.1
 */