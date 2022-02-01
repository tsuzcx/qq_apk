package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bwa
  extends com.tencent.mm.bw.a
{
  public int HiZ;
  public LinkedList<bvz> Hja;
  public int Hjb;
  public long Hjc;
  public long Hjd;
  public long Hje;
  public LinkedList<bvx> Hjf;
  public String clientId;
  public long gsq;
  public int hiJ;
  public int postStage;
  public long wxm;
  
  public bwa()
  {
    AppMethodBeat.i(169081);
    this.Hja = new LinkedList();
    this.Hjf = new LinkedList();
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
      paramVarArgs.aS(2, this.hiJ);
      paramVarArgs.aS(3, this.HiZ);
      paramVarArgs.e(4, 8, this.Hja);
      paramVarArgs.aS(5, this.Hjb);
      paramVarArgs.aS(6, this.postStage);
      paramVarArgs.aZ(7, this.Hjc);
      paramVarArgs.aZ(8, this.wxm);
      paramVarArgs.aZ(9, this.Hjd);
      paramVarArgs.aZ(10, this.gsq);
      paramVarArgs.aZ(11, this.Hje);
      paramVarArgs.e(12, 8, this.Hjf);
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
      int i = f.a.a.b.b.a.bz(2, this.hiJ);
      int j = f.a.a.b.b.a.bz(3, this.HiZ);
      int k = f.a.a.a.c(4, 8, this.Hja);
      int m = f.a.a.b.b.a.bz(5, this.Hjb);
      int n = f.a.a.b.b.a.bz(6, this.postStage);
      int i1 = f.a.a.b.b.a.p(7, this.Hjc);
      int i2 = f.a.a.b.b.a.p(8, this.wxm);
      int i3 = f.a.a.b.b.a.p(9, this.Hjd);
      int i4 = f.a.a.b.b.a.p(10, this.gsq);
      int i5 = f.a.a.b.b.a.p(11, this.Hje);
      int i6 = f.a.a.a.c(12, 8, this.Hjf);
      AppMethodBeat.o(169082);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hja.clear();
        this.Hjf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(169082);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bwa localbwa = (bwa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169082);
          return -1;
        case 1: 
          localbwa.clientId = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169082);
          return 0;
        case 2: 
          localbwa.hiJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169082);
          return 0;
        case 3: 
          localbwa.HiZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169082);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbwa.Hja.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169082);
          return 0;
        case 5: 
          localbwa.Hjb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169082);
          return 0;
        case 6: 
          localbwa.postStage = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169082);
          return 0;
        case 7: 
          localbwa.Hjc = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(169082);
          return 0;
        case 8: 
          localbwa.wxm = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(169082);
          return 0;
        case 9: 
          localbwa.Hjd = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(169082);
          return 0;
        case 10: 
          localbwa.gsq = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(169082);
          return 0;
        case 11: 
          localbwa.Hje = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(169082);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbwa.Hjf.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwa
 * JD-Core Version:    0.7.0.1
 */