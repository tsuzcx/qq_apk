package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class he
  extends com.tencent.mm.bw.a
{
  public String KHk;
  public String KKN;
  public hf KKO;
  public String Name;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125712);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KKO == null)
      {
        paramVarArgs = new b("Not all required fields were included: ArtisIcon");
        AppMethodBeat.o(125712);
        throw paramVarArgs;
      }
      if (this.Name != null) {
        paramVarArgs.e(1, this.Name);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.KKN != null) {
        paramVarArgs.e(3, this.KKN);
      }
      if (this.KHk != null) {
        paramVarArgs.e(4, this.KHk);
      }
      if (this.KKO != null)
      {
        paramVarArgs.ni(5, this.KKO.computeSize());
        this.KKO.writeFields(paramVarArgs);
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
    for (int i = g.a.a.b.b.a.f(1, this.Name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.KKN != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KKN);
      }
      paramInt = i;
      if (this.KHk != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KHk);
      }
      i = paramInt;
      if (this.KKO != null) {
        i = paramInt + g.a.a.a.nh(5, this.KKO.computeSize());
      }
      AppMethodBeat.o(125712);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KKO == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        he localhe = (he)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125712);
          return -1;
        case 1: 
          localhe.Name = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125712);
          return 0;
        case 2: 
          localhe.Title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125712);
          return 0;
        case 3: 
          localhe.KKN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125712);
          return 0;
        case 4: 
          localhe.KHk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125712);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new hf();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((hf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localhe.KKO = ((hf)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.he
 * JD-Core Version:    0.7.0.1
 */