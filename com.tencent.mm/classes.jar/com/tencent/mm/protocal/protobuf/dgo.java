package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgo
  extends com.tencent.mm.bw.a
{
  public int AFo;
  public int HNJ;
  public LinkedList<alh> HNK;
  public long HNL;
  public double HNM;
  public double HNN;
  public String bVF;
  public boolean cNB;
  public int commentCount;
  public long endTime;
  public String feedId;
  public int height;
  public boolean isAd;
  public int likeCount;
  public int lya;
  public int sQl;
  public long startTime;
  public String userName;
  public int vi;
  public int y;
  public int zpn;
  
  public dgo()
  {
    AppMethodBeat.i(122546);
    this.y = -1;
    this.height = -1;
    this.lya = -1;
    this.HNJ = 0;
    this.zpn = -1;
    this.sQl = -1;
    this.vi = 0;
    this.AFo = 0;
    this.cNB = false;
    this.startTime = -1L;
    this.endTime = -1L;
    this.HNK = new LinkedList();
    this.HNL = 0L;
    this.HNM = 0.0D;
    this.HNN = 0.0D;
    this.isAd = false;
    AppMethodBeat.o(122546);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122547);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.feedId != null) {
        paramVarArgs.d(1, this.feedId);
      }
      paramVarArgs.aS(2, this.y);
      paramVarArgs.aS(3, this.height);
      paramVarArgs.aS(4, this.lya);
      paramVarArgs.aS(5, this.HNJ);
      paramVarArgs.aS(6, this.zpn);
      paramVarArgs.aS(7, this.sQl);
      paramVarArgs.aS(8, this.vi);
      paramVarArgs.aS(9, this.AFo);
      paramVarArgs.bC(10, this.cNB);
      paramVarArgs.aZ(11, this.startTime);
      paramVarArgs.aZ(12, this.endTime);
      paramVarArgs.e(13, 8, this.HNK);
      paramVarArgs.aZ(14, this.HNL);
      paramVarArgs.e(15, this.HNM);
      paramVarArgs.e(16, this.HNN);
      paramVarArgs.aS(17, this.commentCount);
      paramVarArgs.aS(18, this.likeCount);
      if (this.userName != null) {
        paramVarArgs.d(19, this.userName);
      }
      paramVarArgs.bC(20, this.isAd);
      if (this.bVF != null) {
        paramVarArgs.d(21, this.bVF);
      }
      AppMethodBeat.o(122547);
      return 0;
    }
    if (paramInt == 1) {
      if (this.feedId == null) {
        break label1216;
      }
    }
    label1216:
    for (paramInt = f.a.a.b.b.a.e(1, this.feedId) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.y) + f.a.a.b.b.a.bz(3, this.height) + f.a.a.b.b.a.bz(4, this.lya) + f.a.a.b.b.a.bz(5, this.HNJ) + f.a.a.b.b.a.bz(6, this.zpn) + f.a.a.b.b.a.bz(7, this.sQl) + f.a.a.b.b.a.bz(8, this.vi) + f.a.a.b.b.a.bz(9, this.AFo) + f.a.a.b.b.a.amF(10) + f.a.a.b.b.a.p(11, this.startTime) + f.a.a.b.b.a.p(12, this.endTime) + f.a.a.a.c(13, 8, this.HNK) + f.a.a.b.b.a.p(14, this.HNL) + f.a.a.b.b.a.amD(15) + f.a.a.b.b.a.amD(16) + f.a.a.b.b.a.bz(17, this.commentCount) + f.a.a.b.b.a.bz(18, this.likeCount);
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.userName);
      }
      i = paramInt + f.a.a.b.b.a.amF(20);
      paramInt = i;
      if (this.bVF != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.bVF);
      }
      AppMethodBeat.o(122547);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HNK.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(122547);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dgo localdgo = (dgo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122547);
          return -1;
        case 1: 
          localdgo.feedId = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122547);
          return 0;
        case 2: 
          localdgo.y = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(122547);
          return 0;
        case 3: 
          localdgo.height = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(122547);
          return 0;
        case 4: 
          localdgo.lya = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(122547);
          return 0;
        case 5: 
          localdgo.HNJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(122547);
          return 0;
        case 6: 
          localdgo.zpn = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(122547);
          return 0;
        case 7: 
          localdgo.sQl = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(122547);
          return 0;
        case 8: 
          localdgo.vi = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(122547);
          return 0;
        case 9: 
          localdgo.AFo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(122547);
          return 0;
        case 10: 
          localdgo.cNB = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(122547);
          return 0;
        case 11: 
          localdgo.startTime = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(122547);
          return 0;
        case 12: 
          localdgo.endTime = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(122547);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((alh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgo.HNK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122547);
          return 0;
        case 14: 
          localdgo.HNL = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(122547);
          return 0;
        case 15: 
          localdgo.HNM = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(122547);
          return 0;
        case 16: 
          localdgo.HNN = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(122547);
          return 0;
        case 17: 
          localdgo.commentCount = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(122547);
          return 0;
        case 18: 
          localdgo.likeCount = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(122547);
          return 0;
        case 19: 
          localdgo.userName = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122547);
          return 0;
        case 20: 
          localdgo.isAd = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(122547);
          return 0;
        }
        localdgo.bVF = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(122547);
        return 0;
      }
      AppMethodBeat.o(122547);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgo
 * JD-Core Version:    0.7.0.1
 */