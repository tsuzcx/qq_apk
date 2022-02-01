package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ur
  extends com.tencent.mm.bw.a
{
  public String Leh;
  public String Lei;
  public String Lej;
  public int Lek;
  public String Lel;
  public un Lem;
  public String Len;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113968);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Leh != null) {
        paramVarArgs.e(1, this.Leh);
      }
      if (this.Lei != null) {
        paramVarArgs.e(2, this.Lei);
      }
      if (this.Lej != null) {
        paramVarArgs.e(3, this.Lej);
      }
      paramVarArgs.aM(4, this.Lek);
      if (this.Lel != null) {
        paramVarArgs.e(5, this.Lel);
      }
      if (this.Lem != null)
      {
        paramVarArgs.ni(6, this.Lem.computeSize());
        this.Lem.writeFields(paramVarArgs);
      }
      if (this.Len != null) {
        paramVarArgs.e(7, this.Len);
      }
      AppMethodBeat.o(113968);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Leh == null) {
        break label658;
      }
    }
    label658:
    for (int i = g.a.a.b.b.a.f(1, this.Leh) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Lei != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Lei);
      }
      i = paramInt;
      if (this.Lej != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Lej);
      }
      i += g.a.a.b.b.a.bu(4, this.Lek);
      paramInt = i;
      if (this.Lel != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Lel);
      }
      i = paramInt;
      if (this.Lem != null) {
        i = paramInt + g.a.a.a.nh(6, this.Lem.computeSize());
      }
      paramInt = i;
      if (this.Len != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Len);
      }
      AppMethodBeat.o(113968);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(113968);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ur localur = (ur)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113968);
          return -1;
        case 1: 
          localur.Leh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113968);
          return 0;
        case 2: 
          localur.Lei = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113968);
          return 0;
        case 3: 
          localur.Lej = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113968);
          return 0;
        case 4: 
          localur.Lek = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(113968);
          return 0;
        case 5: 
          localur.Lel = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113968);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new un();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((un)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localur.Lem = ((un)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113968);
          return 0;
        }
        localur.Len = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(113968);
        return 0;
      }
      AppMethodBeat.o(113968);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ur
 * JD-Core Version:    0.7.0.1
 */