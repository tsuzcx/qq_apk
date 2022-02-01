package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class due
  extends com.tencent.mm.bx.a
{
  public dwg HGY;
  public int aXs;
  public int aXt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110915);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HGY == null)
      {
        paramVarArgs = new b("Not all required fields were included: materialResp");
        AppMethodBeat.o(110915);
        throw paramVarArgs;
      }
      if (this.HGY != null)
      {
        paramVarArgs.lC(1, this.HGY.computeSize());
        this.HGY.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.aXs);
      paramVarArgs.aS(3, this.aXt);
      AppMethodBeat.o(110915);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HGY == null) {
        break label450;
      }
    }
    label450:
    for (paramInt = f.a.a.a.lB(1, this.HGY.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.aXs);
      int j = f.a.a.b.b.a.bz(3, this.aXt);
      AppMethodBeat.o(110915);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HGY == null)
        {
          paramVarArgs = new b("Not all required fields were included: materialResp");
          AppMethodBeat.o(110915);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110915);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        due localdue = (due)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110915);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dwg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdue.HGY = ((dwg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110915);
          return 0;
        case 2: 
          localdue.aXs = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(110915);
          return 0;
        }
        localdue.aXt = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(110915);
        return 0;
      }
      AppMethodBeat.o(110915);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.due
 * JD-Core Version:    0.7.0.1
 */