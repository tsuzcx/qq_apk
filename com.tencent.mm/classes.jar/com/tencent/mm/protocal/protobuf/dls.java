package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dls
  extends cld
{
  public LinkedList<dlm> CCG;
  public com.tencent.mm.bx.b DZk;
  public long Dea;
  public int EBJ;
  public int EBK;
  public int EBL;
  public LinkedList<dlm> EBM;
  public int EpW;
  public long Erf;
  public int sBi;
  public int sBo;
  public int sBp;
  public int sBt;
  
  public dls()
  {
    AppMethodBeat.i(125499);
    this.CCG = new LinkedList();
    this.EBM = new LinkedList();
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
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(2, this.Erf);
      paramVarArgs.aG(3, this.Dea);
      paramVarArgs.e(4, 8, this.CCG);
      paramVarArgs.aR(5, this.EpW);
      paramVarArgs.aR(6, this.sBo);
      paramVarArgs.aR(7, this.sBp);
      paramVarArgs.aR(8, this.sBi);
      paramVarArgs.aR(9, this.sBt);
      paramVarArgs.aR(10, this.EBJ);
      paramVarArgs.aR(11, this.EBK);
      if (this.DZk != null) {
        paramVarArgs.c(12, this.DZk);
      }
      paramVarArgs.aR(13, this.EBL);
      paramVarArgs.e(14, 8, this.EBM);
      AppMethodBeat.o(125500);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1142;
      }
    }
    label1142:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.Erf) + f.a.a.b.b.a.q(3, this.Dea) + f.a.a.a.c(4, 8, this.CCG) + f.a.a.b.b.a.bA(5, this.EpW) + f.a.a.b.b.a.bA(6, this.sBo) + f.a.a.b.b.a.bA(7, this.sBp) + f.a.a.b.b.a.bA(8, this.sBi) + f.a.a.b.b.a.bA(9, this.sBt) + f.a.a.b.b.a.bA(10, this.EBJ) + f.a.a.b.b.a.bA(11, this.EBK);
      paramInt = i;
      if (this.DZk != null) {
        paramInt = i + f.a.a.b.b.a.b(12, this.DZk);
      }
      i = f.a.a.b.b.a.bA(13, this.EBL);
      int j = f.a.a.a.c(14, 8, this.EBM);
      AppMethodBeat.o(125500);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CCG.clear();
        this.EBM.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
        dls localdls = (dls)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125500);
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
            localdls.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125500);
          return 0;
        case 2: 
          localdls.Erf = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125500);
          return 0;
        case 3: 
          localdls.Dea = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125500);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dlm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdls.CCG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125500);
          return 0;
        case 5: 
          localdls.EpW = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125500);
          return 0;
        case 6: 
          localdls.sBo = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125500);
          return 0;
        case 7: 
          localdls.sBp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125500);
          return 0;
        case 8: 
          localdls.sBi = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125500);
          return 0;
        case 9: 
          localdls.sBt = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125500);
          return 0;
        case 10: 
          localdls.EBJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125500);
          return 0;
        case 11: 
          localdls.EBK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125500);
          return 0;
        case 12: 
          localdls.DZk = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(125500);
          return 0;
        case 13: 
          localdls.EBL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125500);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dlm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dlm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdls.EBM.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dls
 * JD-Core Version:    0.7.0.1
 */