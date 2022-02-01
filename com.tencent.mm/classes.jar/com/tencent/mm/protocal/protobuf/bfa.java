package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bfa
  extends dop
{
  public String egX;
  public int limit;
  public int msgType;
  public int offset;
  public int scene;
  public String yQE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(214292);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.egX != null) {
        paramVarArgs.e(2, this.egX);
      }
      paramVarArgs.aM(3, this.limit);
      paramVarArgs.aM(4, this.offset);
      if (this.yQE != null) {
        paramVarArgs.e(5, this.yQE);
      }
      paramVarArgs.aM(6, this.msgType);
      paramVarArgs.aM(7, this.scene);
      AppMethodBeat.o(214292);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label610;
      }
    }
    label610:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.egX != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.egX);
      }
      i = i + g.a.a.b.b.a.bu(3, this.limit) + g.a.a.b.b.a.bu(4, this.offset);
      paramInt = i;
      if (this.yQE != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.yQE);
      }
      i = g.a.a.b.b.a.bu(6, this.msgType);
      int j = g.a.a.b.b.a.bu(7, this.scene);
      AppMethodBeat.o(214292);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(214292);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bfa localbfa = (bfa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(214292);
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
            localbfa.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(214292);
          return 0;
        case 2: 
          localbfa.egX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214292);
          return 0;
        case 3: 
          localbfa.limit = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214292);
          return 0;
        case 4: 
          localbfa.offset = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214292);
          return 0;
        case 5: 
          localbfa.yQE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214292);
          return 0;
        case 6: 
          localbfa.msgType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214292);
          return 0;
        }
        localbfa.scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(214292);
        return 0;
      }
      AppMethodBeat.o(214292);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfa
 * JD-Core Version:    0.7.0.1
 */