package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ajh
  extends dop
{
  public b LoA;
  public String LoB;
  public b Loz;
  public String token;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(214286);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Loz != null) {
        paramVarArgs.c(2, this.Loz);
      }
      if (this.LoA != null) {
        paramVarArgs.c(3, this.LoA);
      }
      if (this.token != null) {
        paramVarArgs.e(4, this.token);
      }
      if (this.LoB != null) {
        paramVarArgs.e(101, this.LoB);
      }
      AppMethodBeat.o(214286);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label570;
      }
    }
    label570:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Loz != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.Loz);
      }
      i = paramInt;
      if (this.LoA != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.LoA);
      }
      paramInt = i;
      if (this.token != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.token);
      }
      i = paramInt;
      if (this.LoB != null) {
        i = paramInt + g.a.a.b.b.a.f(101, this.LoB);
      }
      AppMethodBeat.o(214286);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(214286);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ajh localajh = (ajh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(214286);
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
            localajh.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(214286);
          return 0;
        case 2: 
          localajh.Loz = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(214286);
          return 0;
        case 3: 
          localajh.LoA = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(214286);
          return 0;
        case 4: 
          localajh.token = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214286);
          return 0;
        }
        localajh.LoB = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(214286);
        return 0;
      }
      AppMethodBeat.o(214286);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajh
 * JD-Core Version:    0.7.0.1
 */