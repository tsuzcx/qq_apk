package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dml
  extends cqk
{
  public int ENp;
  public int ENq;
  public int ENr;
  public int ENs;
  public String ENt;
  public int ENu;
  public String FkI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101834);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(101834);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FkI != null) {
        paramVarArgs.d(2, this.FkI);
      }
      if (this.ENt != null) {
        paramVarArgs.d(3, this.ENt);
      }
      paramVarArgs.aR(4, this.ENs);
      paramVarArgs.aR(5, this.ENp);
      paramVarArgs.aR(6, this.ENq);
      paramVarArgs.aR(7, this.ENr);
      paramVarArgs.aR(8, this.ENu);
      AppMethodBeat.o(101834);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label714;
      }
    }
    label714:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FkI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FkI);
      }
      i = paramInt;
      if (this.ENt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ENt);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.ENs);
      int j = f.a.a.b.b.a.bx(5, this.ENp);
      int k = f.a.a.b.b.a.bx(6, this.ENq);
      int m = f.a.a.b.b.a.bx(7, this.ENr);
      int n = f.a.a.b.b.a.bx(8, this.ENu);
      AppMethodBeat.o(101834);
      return i + paramInt + j + k + m + n;
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
          AppMethodBeat.o(101834);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101834);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dml localdml = (dml)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101834);
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
            localdml.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101834);
          return 0;
        case 2: 
          localdml.FkI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101834);
          return 0;
        case 3: 
          localdml.ENt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(101834);
          return 0;
        case 4: 
          localdml.ENs = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101834);
          return 0;
        case 5: 
          localdml.ENp = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101834);
          return 0;
        case 6: 
          localdml.ENq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101834);
          return 0;
        case 7: 
          localdml.ENr = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(101834);
          return 0;
        }
        localdml.ENu = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(101834);
        return 0;
      }
      AppMethodBeat.o(101834);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dml
 * JD-Core Version:    0.7.0.1
 */