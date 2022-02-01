package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cha
  extends dop
{
  public String Mmi;
  public String Mmj;
  public String Mmk;
  public String query;
  public int source;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153288);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Mmi != null) {
        paramVarArgs.e(2, this.Mmi);
      }
      if (this.query != null) {
        paramVarArgs.e(3, this.query);
      }
      if (this.Mmj != null) {
        paramVarArgs.e(4, this.Mmj);
      }
      if (this.Mmk != null) {
        paramVarArgs.e(5, this.Mmk);
      }
      paramVarArgs.aM(6, this.source);
      AppMethodBeat.o(153288);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Mmi != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Mmi);
      }
      i = paramInt;
      if (this.query != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.query);
      }
      paramInt = i;
      if (this.Mmj != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Mmj);
      }
      i = paramInt;
      if (this.Mmk != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Mmk);
      }
      paramInt = g.a.a.b.b.a.bu(6, this.source);
      AppMethodBeat.o(153288);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153288);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cha localcha = (cha)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153288);
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
            localcha.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153288);
          return 0;
        case 2: 
          localcha.Mmi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153288);
          return 0;
        case 3: 
          localcha.query = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153288);
          return 0;
        case 4: 
          localcha.Mmj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153288);
          return 0;
        case 5: 
          localcha.Mmk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153288);
          return 0;
        }
        localcha.source = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(153288);
        return 0;
      }
      AppMethodBeat.o(153288);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cha
 * JD-Core Version:    0.7.0.1
 */