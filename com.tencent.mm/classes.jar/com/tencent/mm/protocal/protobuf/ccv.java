package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ccv
  extends cld
{
  public LinkedList<ccn> CCG;
  public long DYX;
  public int DZg;
  public int DZh;
  public LinkedList<ccn> DZi;
  public String DZj;
  public com.tencent.mm.bx.b DZk;
  public int DZl;
  public int DdZ;
  public long Dea;
  public int sBd;
  public String sBe;
  public int sBi;
  public int sBo;
  public int sBp;
  public int sBq;
  public com.tencent.mm.bx.b sBr;
  public int sBt;
  public int sBw;
  
  public ccv()
  {
    AppMethodBeat.i(32379);
    this.CCG = new LinkedList();
    this.DZi = new LinkedList();
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
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DdZ);
      paramVarArgs.aG(3, this.Dea);
      paramVarArgs.aR(4, this.DZg);
      paramVarArgs.e(5, 8, this.CCG);
      paramVarArgs.aR(6, this.DZh);
      paramVarArgs.aR(7, this.sBo);
      paramVarArgs.aR(8, this.sBp);
      paramVarArgs.aG(9, this.DYX);
      paramVarArgs.aR(10, this.sBq);
      if (this.sBr != null) {
        paramVarArgs.c(11, this.sBr);
      }
      paramVarArgs.aR(12, this.sBi);
      paramVarArgs.aR(13, this.sBd);
      if (this.sBe != null) {
        paramVarArgs.d(14, this.sBe);
      }
      paramVarArgs.aR(15, this.sBt);
      paramVarArgs.e(16, 8, this.DZi);
      paramVarArgs.aR(17, this.sBw);
      if (this.DZj != null) {
        paramVarArgs.d(18, this.DZj);
      }
      if (this.DZk != null) {
        paramVarArgs.c(19, this.DZk);
      }
      paramVarArgs.aR(20, this.DZl);
      AppMethodBeat.o(32380);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1488;
      }
    }
    label1488:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DdZ) + f.a.a.b.b.a.q(3, this.Dea) + f.a.a.b.b.a.bA(4, this.DZg) + f.a.a.a.c(5, 8, this.CCG) + f.a.a.b.b.a.bA(6, this.DZh) + f.a.a.b.b.a.bA(7, this.sBo) + f.a.a.b.b.a.bA(8, this.sBp) + f.a.a.b.b.a.q(9, this.DYX) + f.a.a.b.b.a.bA(10, this.sBq);
      paramInt = i;
      if (this.sBr != null) {
        paramInt = i + f.a.a.b.b.a.b(11, this.sBr);
      }
      i = paramInt + f.a.a.b.b.a.bA(12, this.sBi) + f.a.a.b.b.a.bA(13, this.sBd);
      paramInt = i;
      if (this.sBe != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.sBe);
      }
      i = paramInt + f.a.a.b.b.a.bA(15, this.sBt) + f.a.a.a.c(16, 8, this.DZi) + f.a.a.b.b.a.bA(17, this.sBw);
      paramInt = i;
      if (this.DZj != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.DZj);
      }
      i = paramInt;
      if (this.DZk != null) {
        i = paramInt + f.a.a.b.b.a.b(19, this.DZk);
      }
      paramInt = f.a.a.b.b.a.bA(20, this.DZl);
      AppMethodBeat.o(32380);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CCG.clear();
        this.DZi.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
        ccv localccv = (ccv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32380);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32380);
          return 0;
        case 2: 
          localccv.DdZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32380);
          return 0;
        case 3: 
          localccv.Dea = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(32380);
          return 0;
        case 4: 
          localccv.DZg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32380);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccv.CCG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32380);
          return 0;
        case 6: 
          localccv.DZh = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32380);
          return 0;
        case 7: 
          localccv.sBo = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32380);
          return 0;
        case 8: 
          localccv.sBp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32380);
          return 0;
        case 9: 
          localccv.DYX = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(32380);
          return 0;
        case 10: 
          localccv.sBq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32380);
          return 0;
        case 11: 
          localccv.sBr = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(32380);
          return 0;
        case 12: 
          localccv.sBi = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32380);
          return 0;
        case 13: 
          localccv.sBd = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32380);
          return 0;
        case 14: 
          localccv.sBe = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32380);
          return 0;
        case 15: 
          localccv.sBt = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32380);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccv.DZi.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32380);
          return 0;
        case 17: 
          localccv.sBw = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32380);
          return 0;
        case 18: 
          localccv.DZj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32380);
          return 0;
        case 19: 
          localccv.DZk = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(32380);
          return 0;
        }
        localccv.DZl = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32380);
        return 0;
      }
      AppMethodBeat.o(32380);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccv
 * JD-Core Version:    0.7.0.1
 */