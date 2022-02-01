package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ecb
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public LinkedList<ale> HOw;
  public String HOx;
  
  public ecb()
  {
    AppMethodBeat.i(110852);
    this.HOw = new LinkedList();
    AppMethodBeat.o(110852);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110853);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HOx == null)
      {
        paramVarArgs = new b("Not all required fields were included: Charset");
        AppMethodBeat.o(110853);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 8, this.HOw);
      if (this.HOx != null) {
        paramVarArgs.d(2, this.HOx);
      }
      if (this.Desc != null) {
        paramVarArgs.d(3, this.Desc);
      }
      AppMethodBeat.o(110853);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.HOw) + 0;
      paramInt = i;
      if (this.HOx != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HOx);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Desc);
      }
      AppMethodBeat.o(110853);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HOw.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.HOx == null)
      {
        paramVarArgs = new b("Not all required fields were included: Charset");
        AppMethodBeat.o(110853);
        throw paramVarArgs;
      }
      AppMethodBeat.o(110853);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ecb localecb = (ecb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110853);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ale();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ale)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localecb.HOw.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110853);
        return 0;
      case 2: 
        localecb.HOx = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(110853);
        return 0;
      }
      localecb.Desc = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(110853);
      return 0;
    }
    AppMethodBeat.o(110853);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecb
 * JD-Core Version:    0.7.0.1
 */