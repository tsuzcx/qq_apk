package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mb
  extends com.tencent.mm.bx.a
{
  public String CGS;
  public LinkedList<ma> CIC;
  public int CID;
  
  public mb()
  {
    AppMethodBeat.i(124413);
    this.CIC = new LinkedList();
    AppMethodBeat.o(124413);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124414);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.CIC);
      paramVarArgs.aR(2, this.CID);
      if (this.CGS != null) {
        paramVarArgs.d(3, this.CGS);
      }
      AppMethodBeat.o(124414);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.CIC) + 0 + f.a.a.b.b.a.bA(2, this.CID);
      paramInt = i;
      if (this.CGS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CGS);
      }
      AppMethodBeat.o(124414);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CIC.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(124414);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      mb localmb = (mb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(124414);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ma();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ma)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localmb.CIC.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124414);
        return 0;
      case 2: 
        localmb.CID = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(124414);
        return 0;
      }
      localmb.CGS = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(124414);
      return 0;
    }
    AppMethodBeat.o(124414);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mb
 * JD-Core Version:    0.7.0.1
 */