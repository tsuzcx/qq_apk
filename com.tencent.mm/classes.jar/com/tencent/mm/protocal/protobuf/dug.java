package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dug
  extends com.tencent.mm.bw.a
{
  public String DMW;
  public dtg GbW;
  public String Gch;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147812);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GbW == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_request");
        AppMethodBeat.o(147812);
        throw paramVarArgs;
      }
      if (this.GbW != null)
      {
        paramVarArgs.ln(1, this.GbW.computeSize());
        this.GbW.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      if (this.DMW != null) {
        paramVarArgs.d(3, this.DMW);
      }
      if (this.Gch != null) {
        paramVarArgs.d(4, this.Gch);
      }
      AppMethodBeat.o(147812);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GbW == null) {
        break label538;
      }
    }
    label538:
    for (int i = f.a.a.a.lm(1, this.GbW.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.username);
      }
      i = paramInt;
      if (this.DMW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DMW);
      }
      paramInt = i;
      if (this.Gch != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gch);
      }
      AppMethodBeat.o(147812);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.GbW == null)
        {
          paramVarArgs = new b("Not all required fields were included: base_request");
          AppMethodBeat.o(147812);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147812);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dug localdug = (dug)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147812);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dtg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dtg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdug.GbW = ((dtg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147812);
          return 0;
        case 2: 
          localdug.username = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(147812);
          return 0;
        case 3: 
          localdug.DMW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(147812);
          return 0;
        }
        localdug.Gch = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(147812);
        return 0;
      }
      AppMethodBeat.o(147812);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dug
 * JD-Core Version:    0.7.0.1
 */