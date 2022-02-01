package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmn
  extends cqk
{
  public String FpC;
  public String FpD;
  public String FpE;
  public int FpF;
  public String FpH;
  public com.tencent.mm.bw.b Fpv;
  public int Fpw;
  public int Fpx;
  public String nYv;
  public int ugF;
  public int ugG;
  public String ugH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91662);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91662);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Fpw);
      if (this.ugH != null) {
        paramVarArgs.d(3, this.ugH);
      }
      if (this.FpD != null) {
        paramVarArgs.d(4, this.FpD);
      }
      if (this.FpE != null) {
        paramVarArgs.d(5, this.FpE);
      }
      if (this.Fpv != null) {
        paramVarArgs.c(6, this.Fpv);
      }
      paramVarArgs.aR(7, this.Fpx);
      paramVarArgs.aR(8, this.ugF);
      paramVarArgs.aR(9, this.FpF);
      paramVarArgs.aR(10, this.ugG);
      if (this.nYv != null) {
        paramVarArgs.d(11, this.nYv);
      }
      if (this.FpH != null) {
        paramVarArgs.d(12, this.FpH);
      }
      if (this.FpC != null) {
        paramVarArgs.d(13, this.FpC);
      }
      AppMethodBeat.o(91662);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1010;
      }
    }
    label1010:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Fpw);
      paramInt = i;
      if (this.ugH != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ugH);
      }
      i = paramInt;
      if (this.FpD != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FpD);
      }
      paramInt = i;
      if (this.FpE != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FpE);
      }
      i = paramInt;
      if (this.Fpv != null) {
        i = paramInt + f.a.a.b.b.a.b(6, this.Fpv);
      }
      i = i + f.a.a.b.b.a.bx(7, this.Fpx) + f.a.a.b.b.a.bx(8, this.ugF) + f.a.a.b.b.a.bx(9, this.FpF) + f.a.a.b.b.a.bx(10, this.ugG);
      paramInt = i;
      if (this.nYv != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.nYv);
      }
      i = paramInt;
      if (this.FpH != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.FpH);
      }
      paramInt = i;
      if (this.FpC != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.FpC);
      }
      AppMethodBeat.o(91662);
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
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91662);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91662);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cmn localcmn = (cmn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91662);
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
            localcmn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91662);
          return 0;
        case 2: 
          localcmn.Fpw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91662);
          return 0;
        case 3: 
          localcmn.ugH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 4: 
          localcmn.FpD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 5: 
          localcmn.FpE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 6: 
          localcmn.Fpv = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(91662);
          return 0;
        case 7: 
          localcmn.Fpx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91662);
          return 0;
        case 8: 
          localcmn.ugF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91662);
          return 0;
        case 9: 
          localcmn.FpF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91662);
          return 0;
        case 10: 
          localcmn.ugG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91662);
          return 0;
        case 11: 
          localcmn.nYv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91662);
          return 0;
        case 12: 
          localcmn.FpH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91662);
          return 0;
        }
        localcmn.FpC = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91662);
        return 0;
      }
      AppMethodBeat.o(91662);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmn
 * JD-Core Version:    0.7.0.1
 */