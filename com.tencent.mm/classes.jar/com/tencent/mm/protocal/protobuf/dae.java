package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dae
  extends cwj
{
  public int CreateTime;
  public String FOR;
  public String Ghg;
  public int Ghl;
  public String ikm;
  public int nJA;
  public String uvF;
  public String uvG;
  public int xri;
  public long xrk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32427);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32427);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ikm != null) {
        paramVarArgs.d(2, this.ikm);
      }
      if (this.uvG != null) {
        paramVarArgs.d(3, this.uvG);
      }
      if (this.uvF != null) {
        paramVarArgs.d(4, this.uvF);
      }
      paramVarArgs.aS(5, this.xri);
      if (this.FOR != null) {
        paramVarArgs.d(6, this.FOR);
      }
      paramVarArgs.aS(7, this.CreateTime);
      paramVarArgs.aS(8, this.nJA);
      paramVarArgs.aZ(9, this.xrk);
      if (this.Ghg != null) {
        paramVarArgs.d(10, this.Ghg);
      }
      paramVarArgs.aS(12, this.Ghl);
      AppMethodBeat.o(32427);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label911;
      }
    }
    label911:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ikm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ikm);
      }
      i = paramInt;
      if (this.uvG != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uvG);
      }
      paramInt = i;
      if (this.uvF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uvF);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.xri);
      paramInt = i;
      if (this.FOR != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FOR);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.CreateTime) + f.a.a.b.b.a.bz(8, this.nJA) + f.a.a.b.b.a.p(9, this.xrk);
      paramInt = i;
      if (this.Ghg != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Ghg);
      }
      i = f.a.a.b.b.a.bz(12, this.Ghl);
      AppMethodBeat.o(32427);
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
          AppMethodBeat.o(32427);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32427);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dae localdae = (dae)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 11: 
        default: 
          AppMethodBeat.o(32427);
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
            localdae.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32427);
          return 0;
        case 2: 
          localdae.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 3: 
          localdae.uvG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 4: 
          localdae.uvF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 5: 
          localdae.xri = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32427);
          return 0;
        case 6: 
          localdae.FOR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 7: 
          localdae.CreateTime = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32427);
          return 0;
        case 8: 
          localdae.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32427);
          return 0;
        case 9: 
          localdae.xrk = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(32427);
          return 0;
        case 10: 
          localdae.Ghg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32427);
          return 0;
        }
        localdae.Ghl = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32427);
        return 0;
      }
      AppMethodBeat.o(32427);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dae
 * JD-Core Version:    0.7.0.1
 */