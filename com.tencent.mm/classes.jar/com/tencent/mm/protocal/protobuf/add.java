package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class add
  extends cqk
{
  public String hOf;
  public String hOi;
  public String ncR;
  public int vTH;
  public int vTI;
  public int vTJ;
  public SKBuiltinBuffer_t vTK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(9591);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(9591);
        throw paramVarArgs;
      }
      if (this.vTK == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(9591);
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
      if (this.ncR != null) {
        paramVarArgs.d(4, this.ncR);
      }
      paramVarArgs.aR(5, this.vTH);
      paramVarArgs.aR(6, this.vTI);
      paramVarArgs.aR(7, this.vTJ);
      if (this.vTK != null)
      {
        paramVarArgs.ln(8, this.vTK.computeSize());
        this.vTK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(9591);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label892;
      }
    }
    label892:
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
      if (this.ncR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ncR);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.vTH) + f.a.a.b.b.a.bx(6, this.vTI) + f.a.a.b.b.a.bx(7, this.vTJ);
      paramInt = i;
      if (this.vTK != null) {
        paramInt = i + f.a.a.a.lm(8, this.vTK.computeSize());
      }
      AppMethodBeat.o(9591);
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
          AppMethodBeat.o(9591);
          throw paramVarArgs;
        }
        if (this.vTK == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(9591);
          throw paramVarArgs;
        }
        AppMethodBeat.o(9591);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        add localadd = (add)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(9591);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localadd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(9591);
          return 0;
        case 2: 
          localadd.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(9591);
          return 0;
        case 3: 
          localadd.hOi = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(9591);
          return 0;
        case 4: 
          localadd.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(9591);
          return 0;
        case 5: 
          localadd.vTH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(9591);
          return 0;
        case 6: 
          localadd.vTI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(9591);
          return 0;
        case 7: 
          localadd.vTJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(9591);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localadd.vTK = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(9591);
        return 0;
      }
      AppMethodBeat.o(9591);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.add
 * JD-Core Version:    0.7.0.1
 */