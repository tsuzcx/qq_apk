package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class q
  extends dyy
{
  public int RDA;
  public int fwx = 268513600;
  public int mKG;
  public int mKH;
  public int mKI;
  public long mKJ;
  public long mKK;
  public String mKL;
  public String mKM;
  public String tVo = "请求不成功，请稍候再试";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91325);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91325);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.fwx);
      if (this.tVo != null) {
        paramVarArgs.f(3, this.tVo);
      }
      paramVarArgs.aY(4, this.mKG);
      paramVarArgs.aY(5, this.mKH);
      paramVarArgs.aY(6, this.mKI);
      paramVarArgs.bm(7, this.mKJ);
      paramVarArgs.bm(8, this.mKK);
      if (this.mKL != null) {
        paramVarArgs.f(9, this.mKL);
      }
      if (this.mKM != null) {
        paramVarArgs.f(10, this.mKM);
      }
      paramVarArgs.aY(11, this.RDA);
      AppMethodBeat.o(91325);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label828;
      }
    }
    label828:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.mKG) + g.a.a.b.b.a.bM(5, this.mKH) + g.a.a.b.b.a.bM(6, this.mKI) + g.a.a.b.b.a.p(7, this.mKJ) + g.a.a.b.b.a.p(8, this.mKK);
      paramInt = i;
      if (this.mKL != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.mKL);
      }
      i = paramInt;
      if (this.mKM != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.mKM);
      }
      paramInt = g.a.a.b.b.a.bM(11, this.RDA);
      AppMethodBeat.o(91325);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
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
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        q localq = (q)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91325);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localq.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(91325);
          return 0;
        case 2: 
          localq.fwx = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91325);
          return 0;
        case 3: 
          localq.tVo = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91325);
          return 0;
        case 4: 
          localq.mKG = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91325);
          return 0;
        case 5: 
          localq.mKH = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91325);
          return 0;
        case 6: 
          localq.mKI = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91325);
          return 0;
        case 7: 
          localq.mKJ = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(91325);
          return 0;
        case 8: 
          localq.mKK = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(91325);
          return 0;
        case 9: 
          localq.mKL = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91325);
          return 0;
        case 10: 
          localq.mKM = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91325);
          return 0;
        }
        localq.RDA = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91325);
        return 0;
      }
      AppMethodBeat.o(91325);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.q
 * JD-Core Version:    0.7.0.1
 */