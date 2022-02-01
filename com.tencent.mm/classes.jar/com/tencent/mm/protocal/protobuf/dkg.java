package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dkg
  extends cqk
{
  public String FTl;
  public String FTm;
  public cyl FTn;
  public int dfm;
  public String dfn;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152714);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152714);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dfm);
      if (this.dfn != null) {
        paramVarArgs.d(3, this.dfn);
      }
      if (this.FTl != null) {
        paramVarArgs.d(4, this.FTl);
      }
      if (this.FTm != null) {
        paramVarArgs.d(5, this.FTm);
      }
      if (this.FTn != null)
      {
        paramVarArgs.ln(6, this.FTn.computeSize());
        this.FTn.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.version);
      AppMethodBeat.o(152714);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.dfm);
      paramInt = i;
      if (this.dfn != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dfn);
      }
      i = paramInt;
      if (this.FTl != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FTl);
      }
      paramInt = i;
      if (this.FTm != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FTm);
      }
      i = paramInt;
      if (this.FTn != null) {
        i = paramInt + f.a.a.a.lm(6, this.FTn.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(7, this.version);
      AppMethodBeat.o(152714);
      return i + paramInt;
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
          AppMethodBeat.o(152714);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152714);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dkg localdkg = (dkg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152714);
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
            localdkg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152714);
          return 0;
        case 2: 
          localdkg.dfm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152714);
          return 0;
        case 3: 
          localdkg.dfn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 4: 
          localdkg.FTl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 5: 
          localdkg.FTm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkg.FTn = ((cyl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152714);
          return 0;
        }
        localdkg.version = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152714);
        return 0;
      }
      AppMethodBeat.o(152714);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkg
 * JD-Core Version:    0.7.0.1
 */