package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class mk
  extends cwj
{
  public int FTU;
  public int FXF;
  public String FXI;
  public GoodsObject FXJ;
  public int FXU;
  public String FXV;
  public long FXv;
  public String dwj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188920);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(188920);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FXF);
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
      paramVarArgs.aZ(11, this.FXv);
      paramVarArgs.aS(14, this.FXU);
      paramVarArgs.aS(15, this.FTU);
      if (this.FXV != null) {
        paramVarArgs.d(21, this.FXV);
      }
      AppMethodBeat.o(188920);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FXF);
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
      i = paramInt + f.a.a.b.b.a.p(11, this.FXv) + f.a.a.b.b.a.bz(14, this.FXU) + f.a.a.b.b.a.bz(15, this.FTU);
      paramInt = i;
      if (this.FXV != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.FXV);
      }
      AppMethodBeat.o(188920);
      return paramInt;
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
          AppMethodBeat.o(188920);
          throw paramVarArgs;
        }
        AppMethodBeat.o(188920);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        mk localmk = (mk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 10: 
        case 12: 
        case 13: 
        case 16: 
        case 17: 
        case 18: 
        case 19: 
        case 20: 
        default: 
          AppMethodBeat.o(188920);
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
            localmk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(188920);
          return 0;
        case 2: 
          localmk.FXF = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(188920);
          return 0;
        case 7: 
          localmk.dwj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(188920);
          return 0;
        case 8: 
          localmk.FXI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(188920);
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
            localmk.FXJ = ((GoodsObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(188920);
          return 0;
        case 11: 
          localmk.FXv = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(188920);
          return 0;
        case 14: 
          localmk.FXU = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(188920);
          return 0;
        case 15: 
          localmk.FTU = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(188920);
          return 0;
        }
        localmk.FXV = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(188920);
        return 0;
      }
      AppMethodBeat.o(188920);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mk
 * JD-Core Version:    0.7.0.1
 */