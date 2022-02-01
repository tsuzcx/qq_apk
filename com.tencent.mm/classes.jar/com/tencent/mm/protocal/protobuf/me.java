package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class me
  extends cwj
{
  public int FXF;
  public String FXG;
  public String FXH;
  public String FXI;
  public GoodsObject FXJ;
  public boolean FXK = false;
  public int FXL;
  public boolean FXM;
  public int FXN;
  public int FXt;
  public int FXu;
  public long FXv;
  public String dwj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124395);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124395);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FXF);
      if (this.FXG != null) {
        paramVarArgs.d(3, this.FXG);
      }
      if (this.FXH != null) {
        paramVarArgs.d(4, this.FXH);
      }
      if (this.dwj != null) {
        paramVarArgs.d(7, this.dwj);
      }
      if (this.FXI != null) {
        paramVarArgs.d(8, this.FXI);
      }
      if (this.FXJ != null)
      {
        paramVarArgs.lJ(9, this.FXJ.computeSize());
        this.FXJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(10, this.FXt);
      paramVarArgs.aZ(11, this.FXv);
      paramVarArgs.aS(12, this.FXu);
      paramVarArgs.bC(13, this.FXK);
      paramVarArgs.aS(16, this.FXL);
      paramVarArgs.bC(17, this.FXM);
      paramVarArgs.aS(50, this.FXN);
      AppMethodBeat.o(124395);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1182;
      }
    }
    label1182:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FXF);
      paramInt = i;
      if (this.FXG != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FXG);
      }
      i = paramInt;
      if (this.FXH != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FXH);
      }
      paramInt = i;
      if (this.dwj != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.dwj);
      }
      i = paramInt;
      if (this.FXI != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.FXI);
      }
      paramInt = i;
      if (this.FXJ != null) {
        paramInt = i + f.a.a.a.lI(9, this.FXJ.computeSize());
      }
      i = f.a.a.b.b.a.bz(10, this.FXt);
      int j = f.a.a.b.b.a.p(11, this.FXv);
      int k = f.a.a.b.b.a.bz(12, this.FXu);
      int m = f.a.a.b.b.a.amF(13);
      int n = f.a.a.b.b.a.bz(16, this.FXL);
      int i1 = f.a.a.b.b.a.amF(17);
      int i2 = f.a.a.b.b.a.bz(50, this.FXN);
      AppMethodBeat.o(124395);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(124395);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124395);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        me localme = (me)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124395);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localme.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124395);
          return 0;
        case 2: 
          localme.FXF = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124395);
          return 0;
        case 3: 
          localme.FXG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124395);
          return 0;
        case 4: 
          localme.FXH = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124395);
          return 0;
        case 7: 
          localme.dwj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124395);
          return 0;
        case 8: 
          localme.FXI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124395);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new GoodsObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((GoodsObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localme.FXJ = ((GoodsObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124395);
          return 0;
        case 10: 
          localme.FXt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124395);
          return 0;
        case 11: 
          localme.FXv = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(124395);
          return 0;
        case 12: 
          localme.FXu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124395);
          return 0;
        case 13: 
          localme.FXK = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(124395);
          return 0;
        case 16: 
          localme.FXL = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124395);
          return 0;
        case 17: 
          localme.FXM = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(124395);
          return 0;
        }
        localme.FXN = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(124395);
        return 0;
      }
      AppMethodBeat.o(124395);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.me
 * JD-Core Version:    0.7.0.1
 */