package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ary
  extends com.tencent.mm.bx.a
{
  public int YFt;
  public LinkedList<asw> ZBx;
  
  public ary()
  {
    AppMethodBeat.i(127476);
    this.ZBx = new LinkedList();
    AppMethodBeat.o(127476);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127477);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YFt);
      paramVarArgs.e(2, 8, this.ZBx);
      AppMethodBeat.o(127477);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.YFt);
      i = i.a.a.a.c(2, 8, this.ZBx);
      AppMethodBeat.o(127477);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZBx.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(127477);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      ary localary = (ary)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127477);
        return -1;
      case 1: 
        localary.YFt = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(127477);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        asw localasw = new asw();
        if ((localObject != null) && (localObject.length > 0)) {
          localasw.parseFrom((byte[])localObject);
        }
        localary.ZBx.add(localasw);
        paramInt += 1;
      }
      AppMethodBeat.o(127477);
      return 0;
    }
    AppMethodBeat.o(127477);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ary
 * JD-Core Version:    0.7.0.1
 */