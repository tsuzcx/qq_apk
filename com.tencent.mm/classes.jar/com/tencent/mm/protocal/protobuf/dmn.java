package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dmn
  extends cqk
{
  public int CreateTime;
  public String FUk;
  public String hOf;
  public String hOi;
  public String ncR;
  public int vTH;
  public int vTI;
  public int vTJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32485);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32485);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.hOf != null) {
        paramVarArgs.d(2, this.hOf);
      }
      if (this.hOi != null) {
        paramVarArgs.d(3, this.hOi);
      }
      if (this.FUk != null) {
        paramVarArgs.d(4, this.FUk);
      }
      if (this.ncR != null) {
        paramVarArgs.d(5, this.ncR);
      }
      paramVarArgs.aR(6, this.vTH);
      paramVarArgs.aR(7, this.vTI);
      paramVarArgs.aR(8, this.vTJ);
      paramVarArgs.aR(9, this.CreateTime);
      AppMethodBeat.o(32485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label805;
      }
    }
    label805:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hOf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hOf);
      }
      i = paramInt;
      if (this.hOi != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hOi);
      }
      paramInt = i;
      if (this.FUk != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FUk);
      }
      i = paramInt;
      if (this.ncR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ncR);
      }
      paramInt = f.a.a.b.b.a.bx(6, this.vTH);
      int j = f.a.a.b.b.a.bx(7, this.vTI);
      int k = f.a.a.b.b.a.bx(8, this.vTJ);
      int m = f.a.a.b.b.a.bx(9, this.CreateTime);
      AppMethodBeat.o(32485);
      return i + paramInt + j + k + m;
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
          AppMethodBeat.o(32485);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dmn localdmn = (dmn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32485);
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
            localdmn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32485);
          return 0;
        case 2: 
          localdmn.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 3: 
          localdmn.hOi = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 4: 
          localdmn.FUk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 5: 
          localdmn.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 6: 
          localdmn.vTH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32485);
          return 0;
        case 7: 
          localdmn.vTI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32485);
          return 0;
        case 8: 
          localdmn.vTJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32485);
          return 0;
        }
        localdmn.CreateTime = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32485);
        return 0;
      }
      AppMethodBeat.o(32485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmn
 * JD-Core Version:    0.7.0.1
 */