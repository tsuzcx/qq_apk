package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgh
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public int DeleteFlag;
  public String HNE;
  public int HNj;
  public int HNk;
  public long HNl;
  public long HNm;
  public int HNo;
  public LinkedList<dgn> HNp;
  public int HNq;
  public int IsNotRichText;
  public String Nickname;
  public String Username;
  public String hFS;
  public int nJA;
  public int ucK;
  
  public dgh()
  {
    AppMethodBeat.i(125778);
    this.HNp = new LinkedList();
    AppMethodBeat.o(125778);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125779);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.d(1, this.Username);
      }
      if (this.Nickname != null) {
        paramVarArgs.d(2, this.Nickname);
      }
      paramVarArgs.aS(3, this.ucK);
      paramVarArgs.aS(4, this.nJA);
      if (this.hFS != null) {
        paramVarArgs.d(5, this.hFS);
      }
      paramVarArgs.aS(6, this.CreateTime);
      paramVarArgs.aS(7, this.HNk);
      paramVarArgs.aS(8, this.HNj);
      if (this.HNE != null) {
        paramVarArgs.d(9, this.HNE);
      }
      paramVarArgs.aS(10, this.IsNotRichText);
      paramVarArgs.aZ(11, this.HNl);
      paramVarArgs.aZ(12, this.HNm);
      paramVarArgs.aS(13, this.DeleteFlag);
      paramVarArgs.aS(14, this.HNo);
      paramVarArgs.e(15, 8, this.HNp);
      paramVarArgs.aS(16, this.HNq);
      AppMethodBeat.o(125779);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label1050;
      }
    }
    label1050:
    for (paramInt = f.a.a.b.b.a.e(1, this.Username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Nickname != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Nickname);
      }
      i = i + f.a.a.b.b.a.bz(3, this.ucK) + f.a.a.b.b.a.bz(4, this.nJA);
      paramInt = i;
      if (this.hFS != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hFS);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.CreateTime) + f.a.a.b.b.a.bz(7, this.HNk) + f.a.a.b.b.a.bz(8, this.HNj);
      paramInt = i;
      if (this.HNE != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.HNE);
      }
      i = f.a.a.b.b.a.bz(10, this.IsNotRichText);
      int j = f.a.a.b.b.a.p(11, this.HNl);
      int k = f.a.a.b.b.a.p(12, this.HNm);
      int m = f.a.a.b.b.a.bz(13, this.DeleteFlag);
      int n = f.a.a.b.b.a.bz(14, this.HNo);
      int i1 = f.a.a.a.c(15, 8, this.HNp);
      int i2 = f.a.a.b.b.a.bz(16, this.HNq);
      AppMethodBeat.o(125779);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HNp.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(125779);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dgh localdgh = (dgh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125779);
          return -1;
        case 1: 
          localdgh.Username = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 2: 
          localdgh.Nickname = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 3: 
          localdgh.ucK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125779);
          return 0;
        case 4: 
          localdgh.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125779);
          return 0;
        case 5: 
          localdgh.hFS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 6: 
          localdgh.CreateTime = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125779);
          return 0;
        case 7: 
          localdgh.HNk = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125779);
          return 0;
        case 8: 
          localdgh.HNj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125779);
          return 0;
        case 9: 
          localdgh.HNE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 10: 
          localdgh.IsNotRichText = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125779);
          return 0;
        case 11: 
          localdgh.HNl = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125779);
          return 0;
        case 12: 
          localdgh.HNm = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125779);
          return 0;
        case 13: 
          localdgh.DeleteFlag = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125779);
          return 0;
        case 14: 
          localdgh.HNo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125779);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dgn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dgn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgh.HNp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125779);
          return 0;
        }
        localdgh.HNq = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125779);
        return 0;
      }
      AppMethodBeat.o(125779);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgh
 * JD-Core Version:    0.7.0.1
 */