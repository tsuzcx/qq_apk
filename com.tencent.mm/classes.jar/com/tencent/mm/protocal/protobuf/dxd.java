package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxd
  extends cvp
{
  public LinkedList<dwx> FAy;
  public long GeJ;
  public int HJS;
  public int HJT;
  public int HJU;
  public LinkedList<dwx> HJV;
  public com.tencent.mm.bx.b Hgm;
  public int HxJ;
  public long HyS;
  public int uLD;
  public int uLJ;
  public int uLK;
  public int uLO;
  
  public dxd()
  {
    AppMethodBeat.i(125499);
    this.FAy = new LinkedList();
    this.HJV = new LinkedList();
    AppMethodBeat.o(125499);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125500);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125500);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.HyS);
      paramVarArgs.aY(3, this.GeJ);
      paramVarArgs.e(4, 8, this.FAy);
      paramVarArgs.aS(5, this.HxJ);
      paramVarArgs.aS(6, this.uLJ);
      paramVarArgs.aS(7, this.uLK);
      paramVarArgs.aS(8, this.uLD);
      paramVarArgs.aS(9, this.uLO);
      paramVarArgs.aS(10, this.HJS);
      paramVarArgs.aS(11, this.HJT);
      if (this.Hgm != null) {
        paramVarArgs.c(12, this.Hgm);
      }
      paramVarArgs.aS(13, this.HJU);
      paramVarArgs.e(14, 8, this.HJV);
      AppMethodBeat.o(125500);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1142;
      }
    }
    label1142:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.HyS) + f.a.a.b.b.a.p(3, this.GeJ) + f.a.a.a.c(4, 8, this.FAy) + f.a.a.b.b.a.bz(5, this.HxJ) + f.a.a.b.b.a.bz(6, this.uLJ) + f.a.a.b.b.a.bz(7, this.uLK) + f.a.a.b.b.a.bz(8, this.uLD) + f.a.a.b.b.a.bz(9, this.uLO) + f.a.a.b.b.a.bz(10, this.HJS) + f.a.a.b.b.a.bz(11, this.HJT);
      paramInt = i;
      if (this.Hgm != null) {
        paramInt = i + f.a.a.b.b.a.b(12, this.Hgm);
      }
      i = f.a.a.b.b.a.bz(13, this.HJU);
      int j = f.a.a.a.c(14, 8, this.HJV);
      AppMethodBeat.o(125500);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FAy.clear();
        this.HJV.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125500);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125500);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dxd localdxd = (dxd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125500);
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
            localdxd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125500);
          return 0;
        case 2: 
          localdxd.HyS = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125500);
          return 0;
        case 3: 
          localdxd.GeJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125500);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxd.FAy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125500);
          return 0;
        case 5: 
          localdxd.HxJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125500);
          return 0;
        case 6: 
          localdxd.uLJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125500);
          return 0;
        case 7: 
          localdxd.uLK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125500);
          return 0;
        case 8: 
          localdxd.uLD = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125500);
          return 0;
        case 9: 
          localdxd.uLO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125500);
          return 0;
        case 10: 
          localdxd.HJS = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125500);
          return 0;
        case 11: 
          localdxd.HJT = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125500);
          return 0;
        case 12: 
          localdxd.Hgm = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(125500);
          return 0;
        case 13: 
          localdxd.HJU = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125500);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dwx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dwx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdxd.HJV.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125500);
        return 0;
      }
      AppMethodBeat.o(125500);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxd
 * JD-Core Version:    0.7.0.1
 */