package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class sc
  extends cwj
{
  public int CreateTime;
  public String FNL;
  public String FSC;
  public String GgV;
  public String Ghg;
  public int Ghl;
  public String uvF;
  public String uvG;
  public long xrk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152512);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152512);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GgV != null) {
        paramVarArgs.d(3, this.GgV);
      }
      if (this.uvG != null) {
        paramVarArgs.d(4, this.uvG);
      }
      if (this.uvF != null) {
        paramVarArgs.d(5, this.uvF);
      }
      paramVarArgs.aS(9, this.CreateTime);
      paramVarArgs.aZ(10, this.xrk);
      if (this.Ghg != null) {
        paramVarArgs.d(11, this.Ghg);
      }
      if (this.FSC != null) {
        paramVarArgs.d(12, this.FSC);
      }
      if (this.FNL != null) {
        paramVarArgs.d(13, this.FNL);
      }
      paramVarArgs.aS(14, this.Ghl);
      AppMethodBeat.o(152512);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label878;
      }
    }
    label878:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GgV != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GgV);
      }
      i = paramInt;
      if (this.uvG != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.uvG);
      }
      paramInt = i;
      if (this.uvF != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.uvF);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.CreateTime) + f.a.a.b.b.a.p(10, this.xrk);
      paramInt = i;
      if (this.Ghg != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Ghg);
      }
      i = paramInt;
      if (this.FSC != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.FSC);
      }
      paramInt = i;
      if (this.FNL != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.FNL);
      }
      i = f.a.a.b.b.a.bz(14, this.Ghl);
      AppMethodBeat.o(152512);
      return paramInt + i;
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
          AppMethodBeat.o(152512);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152512);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        sc localsc = (sc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        case 6: 
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(152512);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152512);
          return 0;
        case 3: 
          localsc.GgV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 4: 
          localsc.uvG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 5: 
          localsc.uvF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 9: 
          localsc.CreateTime = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152512);
          return 0;
        case 10: 
          localsc.xrk = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(152512);
          return 0;
        case 11: 
          localsc.Ghg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 12: 
          localsc.FSC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 13: 
          localsc.FNL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152512);
          return 0;
        }
        localsc.Ghl = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152512);
        return 0;
      }
      AppMethodBeat.o(152512);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sc
 * JD-Core Version:    0.7.0.1
 */