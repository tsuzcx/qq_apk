package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axb
  extends com.tencent.mm.bx.a
{
  public bb FPa;
  public String FUQ;
  public LinkedList<String> Gvm;
  
  public axb()
  {
    AppMethodBeat.i(91482);
    this.Gvm = new LinkedList();
    AppMethodBeat.o(91482);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91483);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.Gvm);
      if (this.FPa != null)
      {
        paramVarArgs.lC(2, this.FPa.computeSize());
        this.FPa.writeFields(paramVarArgs);
      }
      if (this.FUQ != null) {
        paramVarArgs.d(3, this.FUQ);
      }
      AppMethodBeat.o(91483);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 1, this.Gvm) + 0;
      paramInt = i;
      if (this.FPa != null) {
        paramInt = i + f.a.a.a.lB(2, this.FPa.computeSize());
      }
      i = paramInt;
      if (this.FUQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FUQ);
      }
      AppMethodBeat.o(91483);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Gvm.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91483);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      axb localaxb = (axb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91483);
        return -1;
      case 1: 
        localaxb.Gvm.add(((f.a.a.a.a)localObject1).NPN.readString());
        AppMethodBeat.o(91483);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaxb.FPa = ((bb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91483);
        return 0;
      }
      localaxb.FUQ = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(91483);
      return 0;
    }
    AppMethodBeat.o(91483);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axb
 * JD-Core Version:    0.7.0.1
 */