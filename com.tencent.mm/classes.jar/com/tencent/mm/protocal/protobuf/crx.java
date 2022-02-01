package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class crx
  extends dpc
{
  public String MwX;
  public long MwZ;
  public String uFc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256708);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.MwZ);
      if (this.uFc != null) {
        paramVarArgs.e(3, this.uFc);
      }
      if (this.MwX != null) {
        paramVarArgs.e(4, this.MwX);
      }
      AppMethodBeat.o(256708);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.MwZ);
      paramInt = i;
      if (this.uFc != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.uFc);
      }
      i = paramInt;
      if (this.MwX != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.MwX);
      }
      AppMethodBeat.o(256708);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(256708);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        crx localcrx = (crx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(256708);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcrx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256708);
          return 0;
        case 2: 
          localcrx.MwZ = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(256708);
          return 0;
        case 3: 
          localcrx.uFc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256708);
          return 0;
        }
        localcrx.MwX = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(256708);
        return 0;
      }
      AppMethodBeat.o(256708);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crx
 * JD-Core Version:    0.7.0.1
 */