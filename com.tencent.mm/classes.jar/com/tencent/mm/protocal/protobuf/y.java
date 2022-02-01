package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class y
  extends cqk
{
  public String DLl;
  public int DLm;
  public int DLn;
  public String DLo;
  public LinkedList<k> DLp;
  public String DLq;
  public int dae;
  public String oxf;
  
  public y()
  {
    AppMethodBeat.i(91337);
    this.dae = 268513600;
    this.oxf = "请求不成功，请稍候再试";
    this.DLp = new LinkedList();
    AppMethodBeat.o(91337);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91338);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91338);
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
      paramVarArgs.e(4, 8, this.DLp);
      if (this.DLq != null) {
        paramVarArgs.d(5, this.DLq);
      }
      if (this.DLl != null) {
        paramVarArgs.d(6, this.DLl);
      }
      paramVarArgs.aR(7, this.DLm);
      paramVarArgs.aR(8, this.DLn);
      if (this.DLo != null) {
        paramVarArgs.d(9, this.DLo);
      }
      AppMethodBeat.o(91338);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.dae);
      paramInt = i;
      if (this.oxf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oxf);
      }
      i = paramInt + f.a.a.a.c(4, 8, this.DLp);
      paramInt = i;
      if (this.DLq != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DLq);
      }
      i = paramInt;
      if (this.DLl != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DLl);
      }
      i = i + f.a.a.b.b.a.bx(7, this.DLm) + f.a.a.b.b.a.bx(8, this.DLn);
      paramInt = i;
      if (this.DLo != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DLo);
      }
      AppMethodBeat.o(91338);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DLp.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91338);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91338);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        y localy = (y)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91338);
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
            localy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91338);
          return 0;
        case 2: 
          localy.dae = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91338);
          return 0;
        case 3: 
          localy.oxf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91338);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new k();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localy.DLp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91338);
          return 0;
        case 5: 
          localy.DLq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91338);
          return 0;
        case 6: 
          localy.DLl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91338);
          return 0;
        case 7: 
          localy.DLm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91338);
          return 0;
        case 8: 
          localy.DLn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91338);
          return 0;
        }
        localy.DLo = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91338);
        return 0;
      }
      AppMethodBeat.o(91338);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.y
 * JD-Core Version:    0.7.0.1
 */