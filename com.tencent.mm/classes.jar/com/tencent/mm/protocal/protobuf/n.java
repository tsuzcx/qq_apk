package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class n
  extends cwj
{
  public int dmy = 268513600;
  public String iWA;
  public String iWB;
  public int iWv;
  public int iWw;
  public int iWx;
  public long iWy;
  public long iWz;
  public String phe = "请求不成功，请稍候再试";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91325);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91325);
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
      paramVarArgs.aS(4, this.iWv);
      paramVarArgs.aS(5, this.iWw);
      paramVarArgs.aS(6, this.iWx);
      paramVarArgs.aZ(7, this.iWy);
      paramVarArgs.aZ(8, this.iWz);
      if (this.iWA != null) {
        paramVarArgs.d(9, this.iWA);
      }
      if (this.iWB != null) {
        paramVarArgs.d(10, this.iWB);
      }
      AppMethodBeat.o(91325);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label806;
      }
    }
    label806:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dmy);
      paramInt = i;
      if (this.phe != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.phe);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.iWv) + f.a.a.b.b.a.bz(5, this.iWw) + f.a.a.b.b.a.bz(6, this.iWx) + f.a.a.b.b.a.p(7, this.iWy) + f.a.a.b.b.a.p(8, this.iWz);
      paramInt = i;
      if (this.iWA != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.iWA);
      }
      i = paramInt;
      if (this.iWB != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.iWB);
      }
      AppMethodBeat.o(91325);
      return i;
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
          AppMethodBeat.o(91325);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91325);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91325);
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
            localn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91325);
          return 0;
        case 2: 
          localn.dmy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91325);
          return 0;
        case 3: 
          localn.phe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91325);
          return 0;
        case 4: 
          localn.iWv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91325);
          return 0;
        case 5: 
          localn.iWw = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91325);
          return 0;
        case 6: 
          localn.iWx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91325);
          return 0;
        case 7: 
          localn.iWy = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91325);
          return 0;
        case 8: 
          localn.iWz = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91325);
          return 0;
        case 9: 
          localn.iWA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91325);
          return 0;
        }
        localn.iWB = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91325);
        return 0;
      }
      AppMethodBeat.o(91325);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.n
 * JD-Core Version:    0.7.0.1
 */