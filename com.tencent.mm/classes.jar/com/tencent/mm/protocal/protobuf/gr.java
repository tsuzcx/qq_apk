package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class gr
  extends com.tencent.mm.bx.a
{
  public String Fvh;
  public String FyI;
  public gs FyJ;
  public String Name;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125712);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FyJ == null)
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
      if (this.FyI != null) {
        paramVarArgs.d(3, this.FyI);
      }
      if (this.Fvh != null) {
        paramVarArgs.d(4, this.Fvh);
      }
      if (this.FyJ != null)
      {
        paramVarArgs.lC(5, this.FyJ.computeSize());
        this.FyJ.writeFields(paramVarArgs);
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
      if (this.FyI != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FyI);
      }
      paramInt = i;
      if (this.Fvh != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Fvh);
      }
      i = paramInt;
      if (this.FyJ != null) {
        i = paramInt + f.a.a.a.lB(5, this.FyJ.computeSize());
      }
      AppMethodBeat.o(125712);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FyJ == null)
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
        gr localgr = (gr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125712);
          return -1;
        case 1: 
          localgr.Name = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125712);
          return 0;
        case 2: 
          localgr.Title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125712);
          return 0;
        case 3: 
          localgr.FyI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125712);
          return 0;
        case 4: 
          localgr.Fvh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125712);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new gs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((gs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgr.FyJ = ((gs)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gr
 * JD-Core Version:    0.7.0.1
 */