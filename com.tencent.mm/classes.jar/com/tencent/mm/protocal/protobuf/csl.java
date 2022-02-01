package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class csl
  extends com.tencent.mm.bw.a
{
  public int HDA;
  public String HDB;
  public String HDC;
  public String HDD;
  public String HDE;
  public bnc HDF;
  public String HDG;
  public String HDH;
  public String Hgn;
  public String mwf;
  public String mwg;
  public String mwh;
  public String mwi;
  public int mwj;
  public String mwk;
  public String prd;
  public double score;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50101);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.mwj);
      paramVarArgs.aS(2, this.HDA);
      if (this.Hgn != null) {
        paramVarArgs.d(3, this.Hgn);
      }
      if (this.mwh != null) {
        paramVarArgs.d(4, this.mwh);
      }
      if (this.mwi != null) {
        paramVarArgs.d(5, this.mwi);
      }
      if (this.HDB != null) {
        paramVarArgs.d(6, this.HDB);
      }
      if (this.prd != null) {
        paramVarArgs.d(7, this.prd);
      }
      if (this.HDC != null) {
        paramVarArgs.d(8, this.HDC);
      }
      if (this.HDD != null) {
        paramVarArgs.d(9, this.HDD);
      }
      paramVarArgs.e(10, this.score);
      if (this.HDE != null) {
        paramVarArgs.d(11, this.HDE);
      }
      if (this.mwf != null) {
        paramVarArgs.d(12, this.mwf);
      }
      if (this.HDF != null)
      {
        paramVarArgs.lJ(14, this.HDF.computeSize());
        this.HDF.writeFields(paramVarArgs);
      }
      if (this.mwg != null) {
        paramVarArgs.d(15, this.mwg);
      }
      if (this.HDG != null) {
        paramVarArgs.d(16, this.HDG);
      }
      if (this.HDH != null) {
        paramVarArgs.d(17, this.HDH);
      }
      if (this.mwk != null) {
        paramVarArgs.d(18, this.mwk);
      }
      AppMethodBeat.o(50101);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.mwj) + 0 + f.a.a.b.b.a.bz(2, this.HDA);
      paramInt = i;
      if (this.Hgn != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Hgn);
      }
      i = paramInt;
      if (this.mwh != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.mwh);
      }
      paramInt = i;
      if (this.mwi != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.mwi);
      }
      i = paramInt;
      if (this.HDB != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.HDB);
      }
      paramInt = i;
      if (this.prd != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.prd);
      }
      i = paramInt;
      if (this.HDC != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.HDC);
      }
      paramInt = i;
      if (this.HDD != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.HDD);
      }
      i = paramInt + f.a.a.b.b.a.amD(10);
      paramInt = i;
      if (this.HDE != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.HDE);
      }
      i = paramInt;
      if (this.mwf != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.mwf);
      }
      paramInt = i;
      if (this.HDF != null) {
        paramInt = i + f.a.a.a.lI(14, this.HDF.computeSize());
      }
      i = paramInt;
      if (this.mwg != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.mwg);
      }
      paramInt = i;
      if (this.HDG != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.HDG);
      }
      i = paramInt;
      if (this.HDH != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.HDH);
      }
      paramInt = i;
      if (this.mwk != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.mwk);
      }
      AppMethodBeat.o(50101);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(50101);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      csl localcsl = (csl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 13: 
      default: 
        AppMethodBeat.o(50101);
        return -1;
      case 1: 
        localcsl.mwj = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(50101);
        return 0;
      case 2: 
        localcsl.HDA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(50101);
        return 0;
      case 3: 
        localcsl.Hgn = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 4: 
        localcsl.mwh = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 5: 
        localcsl.mwi = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 6: 
        localcsl.HDB = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 7: 
        localcsl.prd = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 8: 
        localcsl.HDC = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 9: 
        localcsl.HDD = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 10: 
        localcsl.score = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
        AppMethodBeat.o(50101);
        return 0;
      case 11: 
        localcsl.HDE = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 12: 
        localcsl.mwf = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 14: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bnc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bnc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcsl.HDF = ((bnc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(50101);
        return 0;
      case 15: 
        localcsl.mwg = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 16: 
        localcsl.HDG = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 17: 
        localcsl.HDH = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(50101);
        return 0;
      }
      localcsl.mwk = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(50101);
      return 0;
    }
    AppMethodBeat.o(50101);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csl
 * JD-Core Version:    0.7.0.1
 */