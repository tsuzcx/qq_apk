package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cpt
  extends cwj
{
  public String HBN;
  public int HBO;
  public String HBP;
  public String HBQ;
  public String HBR;
  public String HBS;
  public int dmy;
  public String iGm;
  public String phe;
  public int state;
  public int vxx;
  public String yiu;
  public String yiv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72567);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72567);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dmy);
      if (this.phe != null) {
        paramVarArgs.d(3, this.phe);
      }
      paramVarArgs.aS(4, this.state);
      if (this.HBN != null) {
        paramVarArgs.d(5, this.HBN);
      }
      paramVarArgs.aS(6, this.vxx);
      paramVarArgs.aS(7, this.HBO);
      if (this.yiu != null) {
        paramVarArgs.d(8, this.yiu);
      }
      if (this.HBP != null) {
        paramVarArgs.d(9, this.HBP);
      }
      if (this.yiv != null) {
        paramVarArgs.d(10, this.yiv);
      }
      if (this.HBQ != null) {
        paramVarArgs.d(11, this.HBQ);
      }
      if (this.HBR != null) {
        paramVarArgs.d(12, this.HBR);
      }
      if (this.HBS != null) {
        paramVarArgs.d(14, this.HBS);
      }
      if (this.iGm != null) {
        paramVarArgs.d(15, this.iGm);
      }
      AppMethodBeat.o(72567);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1094;
      }
    }
    label1094:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dmy);
      paramInt = i;
      if (this.phe != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.phe);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.state);
      paramInt = i;
      if (this.HBN != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HBN);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.vxx) + f.a.a.b.b.a.bz(7, this.HBO);
      paramInt = i;
      if (this.yiu != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.yiu);
      }
      i = paramInt;
      if (this.HBP != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.HBP);
      }
      paramInt = i;
      if (this.yiv != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.yiv);
      }
      i = paramInt;
      if (this.HBQ != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.HBQ);
      }
      paramInt = i;
      if (this.HBR != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.HBR);
      }
      i = paramInt;
      if (this.HBS != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.HBS);
      }
      paramInt = i;
      if (this.iGm != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.iGm);
      }
      AppMethodBeat.o(72567);
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
          AppMethodBeat.o(72567);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72567);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cpt localcpt = (cpt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 13: 
        default: 
          AppMethodBeat.o(72567);
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
            localcpt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72567);
          return 0;
        case 2: 
          localcpt.dmy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72567);
          return 0;
        case 3: 
          localcpt.phe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 4: 
          localcpt.state = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72567);
          return 0;
        case 5: 
          localcpt.HBN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 6: 
          localcpt.vxx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72567);
          return 0;
        case 7: 
          localcpt.HBO = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72567);
          return 0;
        case 8: 
          localcpt.yiu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 9: 
          localcpt.HBP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 10: 
          localcpt.yiv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 11: 
          localcpt.HBQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 12: 
          localcpt.HBR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 14: 
          localcpt.HBS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72567);
          return 0;
        }
        localcpt.iGm = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72567);
        return 0;
      }
      AppMethodBeat.o(72567);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpt
 * JD-Core Version:    0.7.0.1
 */