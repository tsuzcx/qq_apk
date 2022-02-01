package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cjz
  extends cqk
{
  public String Fyi;
  public int Fyj;
  public String Fyk;
  public String Fyl;
  public String Fym;
  public String Fyn;
  public int dae;
  public String ikc;
  public String oxf;
  public int state;
  public int uiK;
  public String wEU;
  public String wEV;
  
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
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dae);
      if (this.oxf != null) {
        paramVarArgs.d(3, this.oxf);
      }
      paramVarArgs.aR(4, this.state);
      if (this.Fyi != null) {
        paramVarArgs.d(5, this.Fyi);
      }
      paramVarArgs.aR(6, this.uiK);
      paramVarArgs.aR(7, this.Fyj);
      if (this.wEU != null) {
        paramVarArgs.d(8, this.wEU);
      }
      if (this.Fyk != null) {
        paramVarArgs.d(9, this.Fyk);
      }
      if (this.wEV != null) {
        paramVarArgs.d(10, this.wEV);
      }
      if (this.Fyl != null) {
        paramVarArgs.d(11, this.Fyl);
      }
      if (this.Fym != null) {
        paramVarArgs.d(12, this.Fym);
      }
      if (this.Fyn != null) {
        paramVarArgs.d(14, this.Fyn);
      }
      if (this.ikc != null) {
        paramVarArgs.d(15, this.ikc);
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
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.dae);
      paramInt = i;
      if (this.oxf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oxf);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.state);
      paramInt = i;
      if (this.Fyi != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Fyi);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.uiK) + f.a.a.b.b.a.bx(7, this.Fyj);
      paramInt = i;
      if (this.wEU != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.wEU);
      }
      i = paramInt;
      if (this.Fyk != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Fyk);
      }
      paramInt = i;
      if (this.wEV != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.wEV);
      }
      i = paramInt;
      if (this.Fyl != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.Fyl);
      }
      paramInt = i;
      if (this.Fym != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Fym);
      }
      i = paramInt;
      if (this.Fyn != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.Fyn);
      }
      paramInt = i;
      if (this.ikc != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.ikc);
      }
      AppMethodBeat.o(72567);
      return paramInt;
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
          AppMethodBeat.o(72567);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72567);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cjz localcjz = (cjz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 13: 
        default: 
          AppMethodBeat.o(72567);
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
            localcjz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72567);
          return 0;
        case 2: 
          localcjz.dae = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72567);
          return 0;
        case 3: 
          localcjz.oxf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 4: 
          localcjz.state = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72567);
          return 0;
        case 5: 
          localcjz.Fyi = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 6: 
          localcjz.uiK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72567);
          return 0;
        case 7: 
          localcjz.Fyj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72567);
          return 0;
        case 8: 
          localcjz.wEU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 9: 
          localcjz.Fyk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 10: 
          localcjz.wEV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 11: 
          localcjz.Fyl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 12: 
          localcjz.Fym = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 14: 
          localcjz.Fyn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72567);
          return 0;
        }
        localcjz.ikc = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72567);
        return 0;
      }
      AppMethodBeat.o(72567);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjz
 * JD-Core Version:    0.7.0.1
 */