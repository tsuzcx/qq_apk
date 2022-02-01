package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvb
  extends dop
{
  public String code;
  public String eaO;
  public String pRX;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114034);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.eaO != null) {
        paramVarArgs.e(2, this.eaO);
      }
      paramVarArgs.aM(3, this.scene);
      if (this.pRX != null) {
        paramVarArgs.e(4, this.pRX);
      }
      if (this.code != null) {
        paramVarArgs.e(5, this.code);
      }
      AppMethodBeat.o(114034);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.eaO != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.eaO);
      }
      i += g.a.a.b.b.a.bu(3, this.scene);
      paramInt = i;
      if (this.pRX != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.pRX);
      }
      i = paramInt;
      if (this.code != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.code);
      }
      AppMethodBeat.o(114034);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(114034);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bvb localbvb = (bvb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114034);
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
            localbvb.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114034);
          return 0;
        case 2: 
          localbvb.eaO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114034);
          return 0;
        case 3: 
          localbvb.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114034);
          return 0;
        case 4: 
          localbvb.pRX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114034);
          return 0;
        }
        localbvb.code = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(114034);
        return 0;
      }
      AppMethodBeat.o(114034);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvb
 * JD-Core Version:    0.7.0.1
 */