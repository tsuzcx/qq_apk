package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dmz
  extends cqk
{
  public String Eof;
  public String Eog;
  public String FUE;
  public int vTH;
  public int vTI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152718);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152718);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.vTH);
      paramVarArgs.aR(3, this.vTI);
      if (this.FUE != null) {
        paramVarArgs.d(4, this.FUE);
      }
      if (this.Eof != null) {
        paramVarArgs.d(5, this.Eof);
      }
      if (this.Eog != null) {
        paramVarArgs.d(6, this.Eog);
      }
      AppMethodBeat.o(152718);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.vTH) + f.a.a.b.b.a.bx(3, this.vTI);
      paramInt = i;
      if (this.FUE != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FUE);
      }
      i = paramInt;
      if (this.Eof != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Eof);
      }
      paramInt = i;
      if (this.Eog != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Eog);
      }
      AppMethodBeat.o(152718);
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
          AppMethodBeat.o(152718);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152718);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dmz localdmz = (dmz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152718);
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
            localdmz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152718);
          return 0;
        case 2: 
          localdmz.vTH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152718);
          return 0;
        case 3: 
          localdmz.vTI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152718);
          return 0;
        case 4: 
          localdmz.FUE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152718);
          return 0;
        case 5: 
          localdmz.Eof = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152718);
          return 0;
        }
        localdmz.Eog = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152718);
        return 0;
      }
      AppMethodBeat.o(152718);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmz
 * JD-Core Version:    0.7.0.1
 */