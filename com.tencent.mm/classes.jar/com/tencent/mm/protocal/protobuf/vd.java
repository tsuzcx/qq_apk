package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class vd
  extends cqk
{
  public long Epi;
  public long Epj;
  public String Epk;
  public String Epl;
  public int nWx;
  public String nWy;
  public String oGN;
  public String ugH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72458);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72458);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.nWx);
      if (this.nWy != null) {
        paramVarArgs.d(3, this.nWy);
      }
      paramVarArgs.aO(4, this.Epi);
      paramVarArgs.aO(5, this.Epj);
      if (this.Epk != null) {
        paramVarArgs.d(6, this.Epk);
      }
      if (this.Epl != null) {
        paramVarArgs.d(7, this.Epl);
      }
      if (this.ugH != null) {
        paramVarArgs.d(8, this.ugH);
      }
      if (this.oGN != null) {
        paramVarArgs.d(9, this.oGN);
      }
      AppMethodBeat.o(72458);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt + f.a.a.b.b.a.p(4, this.Epi) + f.a.a.b.b.a.p(5, this.Epj);
      paramInt = i;
      if (this.Epk != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Epk);
      }
      i = paramInt;
      if (this.Epl != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Epl);
      }
      paramInt = i;
      if (this.ugH != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.ugH);
      }
      i = paramInt;
      if (this.oGN != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.oGN);
      }
      AppMethodBeat.o(72458);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72458);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72458);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vd localvd = (vd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72458);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72458);
          return 0;
        case 2: 
          localvd.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72458);
          return 0;
        case 3: 
          localvd.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72458);
          return 0;
        case 4: 
          localvd.Epi = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(72458);
          return 0;
        case 5: 
          localvd.Epj = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(72458);
          return 0;
        case 6: 
          localvd.Epk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72458);
          return 0;
        case 7: 
          localvd.Epl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72458);
          return 0;
        case 8: 
          localvd.ugH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72458);
          return 0;
        }
        localvd.oGN = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72458);
        return 0;
      }
      AppMethodBeat.o(72458);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vd
 * JD-Core Version:    0.7.0.1
 */