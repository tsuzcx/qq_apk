package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ug
  extends cqk
{
  public String DTk;
  public int dae;
  public String oxf;
  public String wES;
  public String wET;
  public String wEU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72453);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72453);
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
      if (this.wES != null) {
        paramVarArgs.d(4, this.wES);
      }
      if (this.wET != null) {
        paramVarArgs.d(5, this.wET);
      }
      if (this.wEU != null) {
        paramVarArgs.d(6, this.wEU);
      }
      if (this.DTk != null) {
        paramVarArgs.d(7, this.DTk);
      }
      AppMethodBeat.o(72453);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label706;
      }
    }
    label706:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.dae);
      paramInt = i;
      if (this.oxf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oxf);
      }
      i = paramInt;
      if (this.wES != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.wES);
      }
      paramInt = i;
      if (this.wET != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.wET);
      }
      i = paramInt;
      if (this.wEU != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.wEU);
      }
      paramInt = i;
      if (this.DTk != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DTk);
      }
      AppMethodBeat.o(72453);
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
          AppMethodBeat.o(72453);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72453);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ug localug = (ug)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72453);
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
            localug.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72453);
          return 0;
        case 2: 
          localug.dae = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72453);
          return 0;
        case 3: 
          localug.oxf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72453);
          return 0;
        case 4: 
          localug.wES = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72453);
          return 0;
        case 5: 
          localug.wET = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72453);
          return 0;
        case 6: 
          localug.wEU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72453);
          return 0;
        }
        localug.DTk = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72453);
        return 0;
      }
      AppMethodBeat.o(72453);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ug
 * JD-Core Version:    0.7.0.1
 */