package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class gk
  extends com.tencent.mm.bw.a
{
  public String DPS;
  public String DTp;
  public gl DTq;
  public String Name;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125712);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DTq == null)
      {
        paramVarArgs = new b("Not all required fields were included: ArtisIcon");
        AppMethodBeat.o(125712);
        throw paramVarArgs;
      }
      if (this.Name != null) {
        paramVarArgs.d(1, this.Name);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.DTp != null) {
        paramVarArgs.d(3, this.DTp);
      }
      if (this.DPS != null) {
        paramVarArgs.d(4, this.DPS);
      }
      if (this.DTq != null)
      {
        paramVarArgs.ln(5, this.DTq.computeSize());
        this.DTq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125712);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label598;
      }
    }
    label598:
    for (int i = f.a.a.b.b.a.e(1, this.Name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.DTp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DTp);
      }
      paramInt = i;
      if (this.DPS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DPS);
      }
      i = paramInt;
      if (this.DTq != null) {
        i = paramInt + f.a.a.a.lm(5, this.DTq.computeSize());
      }
      AppMethodBeat.o(125712);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DTq == null)
        {
          paramVarArgs = new b("Not all required fields were included: ArtisIcon");
          AppMethodBeat.o(125712);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125712);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        gk localgk = (gk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125712);
          return -1;
        case 1: 
          localgk.Name = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125712);
          return 0;
        case 2: 
          localgk.Title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125712);
          return 0;
        case 3: 
          localgk.DTp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125712);
          return 0;
        case 4: 
          localgk.DPS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125712);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new gl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((gl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgk.DTq = ((gl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125712);
        return 0;
      }
      AppMethodBeat.o(125712);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gk
 * JD-Core Version:    0.7.0.1
 */