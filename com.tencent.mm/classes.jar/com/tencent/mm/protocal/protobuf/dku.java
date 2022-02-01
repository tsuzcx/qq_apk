package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dku
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public int HNj;
  public int HNk;
  public dkn HRH;
  public String HRw;
  public String HRx;
  public int HRz;
  public long Id;
  public int IsNotRichText;
  public String ThumbUrl;
  public String hFS;
  public int nJA;
  public String uvF;
  public String uvG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118472);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.Id);
      if (this.uvG != null) {
        paramVarArgs.d(2, this.uvG);
      }
      if (this.uvF != null) {
        paramVarArgs.d(3, this.uvF);
      }
      if (this.HRw != null) {
        paramVarArgs.d(4, this.HRw);
      }
      if (this.HRx != null) {
        paramVarArgs.d(5, this.HRx);
      }
      if (this.hFS != null) {
        paramVarArgs.d(6, this.hFS);
      }
      paramVarArgs.aS(7, this.nJA);
      paramVarArgs.aS(8, this.CreateTime);
      paramVarArgs.aS(9, this.HNk);
      paramVarArgs.aS(10, this.HNj);
      paramVarArgs.aS(11, this.IsNotRichText);
      if (this.ThumbUrl != null) {
        paramVarArgs.d(12, this.ThumbUrl);
      }
      if (this.HRH != null)
      {
        paramVarArgs.lJ(13, this.HRH.computeSize());
        this.HRH.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(14, this.HRz);
      AppMethodBeat.o(118472);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.Id) + 0;
      paramInt = i;
      if (this.uvG != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uvG);
      }
      i = paramInt;
      if (this.uvF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uvF);
      }
      paramInt = i;
      if (this.HRw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HRw);
      }
      i = paramInt;
      if (this.HRx != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HRx);
      }
      paramInt = i;
      if (this.hFS != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.hFS);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.nJA) + f.a.a.b.b.a.bz(8, this.CreateTime) + f.a.a.b.b.a.bz(9, this.HNk) + f.a.a.b.b.a.bz(10, this.HNj) + f.a.a.b.b.a.bz(11, this.IsNotRichText);
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.ThumbUrl);
      }
      i = paramInt;
      if (this.HRH != null) {
        i = paramInt + f.a.a.a.lI(13, this.HRH.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(14, this.HRz);
      AppMethodBeat.o(118472);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(118472);
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
        AppMethodBeat.o(118472);
        return -1;
      case 1: 
        localdku.Id = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(118472);
        return 0;
      case 2: 
        localdku.uvG = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 3: 
        localdku.uvF = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 4: 
        localdku.HRw = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 5: 
        localdku.HRx = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 6: 
        localdku.hFS = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 7: 
        localdku.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118472);
        return 0;
      case 8: 
        localdku.CreateTime = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118472);
        return 0;
      case 9: 
        localdku.HNk = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118472);
        return 0;
      case 10: 
        localdku.HNj = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118472);
        return 0;
      case 11: 
        localdku.IsNotRichText = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118472);
        return 0;
      case 12: 
        localdku.ThumbUrl = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dkn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dkn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdku.HRH = ((dkn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118472);
        return 0;
      }
      localdku.HRz = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(118472);
      return 0;
    }
    AppMethodBeat.o(118472);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dku
 * JD-Core Version:    0.7.0.1
 */