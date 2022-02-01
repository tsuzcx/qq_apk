package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dgu
  extends dyy
{
  public String TNA;
  public String TNB;
  public int TNC;
  public int TND;
  public int TNy;
  public int TNz;
  public int fwx;
  public String mKL;
  public String mKM;
  public String tVo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72539);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72539);
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
      paramVarArgs.aY(4, this.TNy);
      paramVarArgs.aY(5, this.TNz);
      if (this.mKL != null) {
        paramVarArgs.f(6, this.mKL);
      }
      if (this.mKM != null) {
        paramVarArgs.f(7, this.mKM);
      }
      if (this.TNA != null) {
        paramVarArgs.f(8, this.TNA);
      }
      if (this.TNB != null) {
        paramVarArgs.f(9, this.TNB);
      }
      paramVarArgs.aY(10, this.TNC);
      paramVarArgs.aY(11, this.TND);
      AppMethodBeat.o(72539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label868;
      }
    }
    label868:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.TNy) + g.a.a.b.b.a.bM(5, this.TNz);
      paramInt = i;
      if (this.mKL != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.mKL);
      }
      i = paramInt;
      if (this.mKM != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.mKM);
      }
      paramInt = i;
      if (this.TNA != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.TNA);
      }
      i = paramInt;
      if (this.TNB != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.TNB);
      }
      paramInt = g.a.a.b.b.a.bM(10, this.TNC);
      int j = g.a.a.b.b.a.bM(11, this.TND);
      AppMethodBeat.o(72539);
      return i + paramInt + j;
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
          AppMethodBeat.o(72539);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72539);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dgu localdgu = (dgu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72539);
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
            localdgu.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(72539);
          return 0;
        case 2: 
          localdgu.fwx = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72539);
          return 0;
        case 3: 
          localdgu.tVo = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 4: 
          localdgu.TNy = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72539);
          return 0;
        case 5: 
          localdgu.TNz = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72539);
          return 0;
        case 6: 
          localdgu.mKL = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 7: 
          localdgu.mKM = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 8: 
          localdgu.TNA = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 9: 
          localdgu.TNB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 10: 
          localdgu.TNC = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72539);
          return 0;
        }
        localdgu.TND = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(72539);
        return 0;
      }
      AppMethodBeat.o(72539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgu
 * JD-Core Version:    0.7.0.1
 */