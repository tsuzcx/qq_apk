package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class gd
  extends cqk
{
  public String DMY;
  public boolean DTg;
  public String DTh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190847);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(190847);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DMY != null) {
        paramVarArgs.d(2, this.DMY);
      }
      paramVarArgs.bl(3, this.DTg);
      if (this.DTh != null) {
        paramVarArgs.d(4, this.DTh);
      }
      AppMethodBeat.o(190847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DMY != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DMY);
      }
      i += f.a.a.b.b.a.fK(3) + 1;
      paramInt = i;
      if (this.DTh != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DTh);
      }
      AppMethodBeat.o(190847);
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
          AppMethodBeat.o(190847);
          throw paramVarArgs;
        }
        AppMethodBeat.o(190847);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        gd localgd = (gd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(190847);
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
            localgd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(190847);
          return 0;
        case 2: 
          localgd.DMY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(190847);
          return 0;
        case 3: 
          localgd.DTg = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(190847);
          return 0;
        }
        localgd.DTh = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(190847);
        return 0;
      }
      AppMethodBeat.o(190847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gd
 * JD-Core Version:    0.7.0.1
 */