package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dlp
  extends cpx
{
  public String FTZ;
  public int status;
  public String uuid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153309);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.uuid != null) {
        paramVarArgs.d(2, this.uuid);
      }
      paramVarArgs.aR(3, this.status);
      if (this.FTZ != null) {
        paramVarArgs.d(4, this.FTZ);
      }
      AppMethodBeat.o(153309);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uuid != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.uuid);
      }
      i += f.a.a.b.b.a.bx(3, this.status);
      paramInt = i;
      if (this.FTZ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FTZ);
      }
      AppMethodBeat.o(153309);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(153309);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dlp localdlp = (dlp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153309);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlp.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153309);
          return 0;
        case 2: 
          localdlp.uuid = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153309);
          return 0;
        case 3: 
          localdlp.status = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153309);
          return 0;
        }
        localdlp.FTZ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(153309);
        return 0;
      }
      AppMethodBeat.o(153309);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlp
 * JD-Core Version:    0.7.0.1
 */