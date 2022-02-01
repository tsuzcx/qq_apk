package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ml
  extends dop
{
  public String KQF;
  public String KQG;
  public long KQH;
  public String mac;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82394);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.KQF != null) {
        paramVarArgs.e(2, this.KQF);
      }
      if (this.KQG != null) {
        paramVarArgs.e(3, this.KQG);
      }
      if (this.mac != null) {
        paramVarArgs.e(4, this.mac);
      }
      paramVarArgs.bb(5, this.KQH);
      AppMethodBeat.o(82394);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label534;
      }
    }
    label534:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KQF != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KQF);
      }
      i = paramInt;
      if (this.KQG != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KQG);
      }
      paramInt = i;
      if (this.mac != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.mac);
      }
      i = g.a.a.b.b.a.r(5, this.KQH);
      AppMethodBeat.o(82394);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(82394);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ml localml = (ml)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82394);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localml.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82394);
          return 0;
        case 2: 
          localml.KQF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82394);
          return 0;
        case 3: 
          localml.KQG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82394);
          return 0;
        case 4: 
          localml.mac = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82394);
          return 0;
        }
        localml.KQH = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(82394);
        return 0;
      }
      AppMethodBeat.o(82394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ml
 * JD-Core Version:    0.7.0.1
 */