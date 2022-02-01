package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class duf
  extends cwj
{
  public String FNL;
  public String FOR;
  public String Ghg;
  public int Ghl;
  public int HZJ;
  public int HlH;
  public int xri;
  public long xrk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127181);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(127181);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FOR != null) {
        paramVarArgs.d(2, this.FOR);
      }
      paramVarArgs.aS(3, this.xri);
      paramVarArgs.aS(4, this.HlH);
      paramVarArgs.aS(5, this.HZJ);
      paramVarArgs.aZ(6, this.xrk);
      if (this.Ghg != null) {
        paramVarArgs.d(7, this.Ghg);
      }
      if (this.FNL != null) {
        paramVarArgs.d(8, this.FNL);
      }
      paramVarArgs.aS(9, this.Ghl);
      AppMethodBeat.o(127181);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label762;
      }
    }
    label762:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FOR != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FOR);
      }
      i = i + f.a.a.b.b.a.bz(3, this.xri) + f.a.a.b.b.a.bz(4, this.HlH) + f.a.a.b.b.a.bz(5, this.HZJ) + f.a.a.b.b.a.p(6, this.xrk);
      paramInt = i;
      if (this.Ghg != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Ghg);
      }
      i = paramInt;
      if (this.FNL != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.FNL);
      }
      paramInt = f.a.a.b.b.a.bz(9, this.Ghl);
      AppMethodBeat.o(127181);
      return i + paramInt;
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
          AppMethodBeat.o(127181);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127181);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        duf localduf = (duf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127181);
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
            localduf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127181);
          return 0;
        case 2: 
          localduf.FOR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127181);
          return 0;
        case 3: 
          localduf.xri = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127181);
          return 0;
        case 4: 
          localduf.HlH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127181);
          return 0;
        case 5: 
          localduf.HZJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127181);
          return 0;
        case 6: 
          localduf.xrk = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(127181);
          return 0;
        case 7: 
          localduf.Ghg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127181);
          return 0;
        case 8: 
          localduf.FNL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127181);
          return 0;
        }
        localduf.Ghl = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(127181);
        return 0;
      }
      AppMethodBeat.o(127181);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duf
 * JD-Core Version:    0.7.0.1
 */