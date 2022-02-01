package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmy
  extends cvp
{
  public LinkedList<cmq> FAy;
  public int GeI;
  public long GeJ;
  public long HfZ;
  public int Hgi;
  public int Hgj;
  public LinkedList<cmq> Hgk;
  public String Hgl;
  public com.tencent.mm.bx.b Hgm;
  public int Hgn;
  public int uLD;
  public int uLJ;
  public int uLK;
  public int uLL;
  public com.tencent.mm.bx.b uLM;
  public int uLO;
  public int uLR;
  public int uLy;
  public String uLz;
  
  public cmy()
  {
    AppMethodBeat.i(32379);
    this.FAy = new LinkedList();
    this.Hgk = new LinkedList();
    AppMethodBeat.o(32379);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32380);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32380);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GeI);
      paramVarArgs.aY(3, this.GeJ);
      paramVarArgs.aS(4, this.Hgi);
      paramVarArgs.e(5, 8, this.FAy);
      paramVarArgs.aS(6, this.Hgj);
      paramVarArgs.aS(7, this.uLJ);
      paramVarArgs.aS(8, this.uLK);
      paramVarArgs.aY(9, this.HfZ);
      paramVarArgs.aS(10, this.uLL);
      if (this.uLM != null) {
        paramVarArgs.c(11, this.uLM);
      }
      paramVarArgs.aS(12, this.uLD);
      paramVarArgs.aS(13, this.uLy);
      if (this.uLz != null) {
        paramVarArgs.d(14, this.uLz);
      }
      paramVarArgs.aS(15, this.uLO);
      paramVarArgs.e(16, 8, this.Hgk);
      paramVarArgs.aS(17, this.uLR);
      if (this.Hgl != null) {
        paramVarArgs.d(18, this.Hgl);
      }
      if (this.Hgm != null) {
        paramVarArgs.c(19, this.Hgm);
      }
      paramVarArgs.aS(20, this.Hgn);
      AppMethodBeat.o(32380);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1488;
      }
    }
    label1488:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GeI) + f.a.a.b.b.a.p(3, this.GeJ) + f.a.a.b.b.a.bz(4, this.Hgi) + f.a.a.a.c(5, 8, this.FAy) + f.a.a.b.b.a.bz(6, this.Hgj) + f.a.a.b.b.a.bz(7, this.uLJ) + f.a.a.b.b.a.bz(8, this.uLK) + f.a.a.b.b.a.p(9, this.HfZ) + f.a.a.b.b.a.bz(10, this.uLL);
      paramInt = i;
      if (this.uLM != null) {
        paramInt = i + f.a.a.b.b.a.b(11, this.uLM);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.uLD) + f.a.a.b.b.a.bz(13, this.uLy);
      paramInt = i;
      if (this.uLz != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.uLz);
      }
      i = paramInt + f.a.a.b.b.a.bz(15, this.uLO) + f.a.a.a.c(16, 8, this.Hgk) + f.a.a.b.b.a.bz(17, this.uLR);
      paramInt = i;
      if (this.Hgl != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.Hgl);
      }
      i = paramInt;
      if (this.Hgm != null) {
        i = paramInt + f.a.a.b.b.a.b(19, this.Hgm);
      }
      paramInt = f.a.a.b.b.a.bz(20, this.Hgn);
      AppMethodBeat.o(32380);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FAy.clear();
        this.Hgk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32380);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32380);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cmy localcmy = (cmy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32380);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcmy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32380);
          return 0;
        case 2: 
          localcmy.GeI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32380);
          return 0;
        case 3: 
          localcmy.GeJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(32380);
          return 0;
        case 4: 
          localcmy.Hgi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32380);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcmy.FAy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32380);
          return 0;
        case 6: 
          localcmy.Hgj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32380);
          return 0;
        case 7: 
          localcmy.uLJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32380);
          return 0;
        case 8: 
          localcmy.uLK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32380);
          return 0;
        case 9: 
          localcmy.HfZ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(32380);
          return 0;
        case 10: 
          localcmy.uLL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32380);
          return 0;
        case 11: 
          localcmy.uLM = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(32380);
          return 0;
        case 12: 
          localcmy.uLD = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32380);
          return 0;
        case 13: 
          localcmy.uLy = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32380);
          return 0;
        case 14: 
          localcmy.uLz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32380);
          return 0;
        case 15: 
          localcmy.uLO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32380);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcmy.Hgk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32380);
          return 0;
        case 17: 
          localcmy.uLR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32380);
          return 0;
        case 18: 
          localcmy.Hgl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32380);
          return 0;
        case 19: 
          localcmy.Hgm = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(32380);
          return 0;
        }
        localcmy.Hgn = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32380);
        return 0;
      }
      AppMethodBeat.o(32380);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmy
 * JD-Core Version:    0.7.0.1
 */