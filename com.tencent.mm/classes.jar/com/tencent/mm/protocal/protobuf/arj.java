package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class arj
  extends com.tencent.mm.bx.a
{
  public LinkedList<dpo> AdX;
  public LinkedList<dpr> ZBd;
  
  public arj()
  {
    AppMethodBeat.i(127461);
    this.AdX = new LinkedList();
    this.ZBd = new LinkedList();
    AppMethodBeat.o(127461);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127462);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.AdX);
      paramVarArgs.e(2, 8, this.ZBd);
      AppMethodBeat.o(127462);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.AdX);
      i = i.a.a.a.c(2, 8, this.ZBd);
      AppMethodBeat.o(127462);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.AdX.clear();
      this.ZBd.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(127462);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      arj localarj = (arj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127462);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dpo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dpo)localObject2).parseFrom((byte[])localObject1);
          }
          localarj.AdX.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(127462);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new dpr();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((dpr)localObject2).parseFrom((byte[])localObject1);
        }
        localarj.ZBd.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(127462);
      return 0;
    }
    AppMethodBeat.o(127462);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arj
 * JD-Core Version:    0.7.0.1
 */