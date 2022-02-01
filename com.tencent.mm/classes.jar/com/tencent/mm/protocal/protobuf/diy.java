package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class diy
  extends com.tencent.mm.bx.a
{
  public dkv Ezg;
  public int aMk;
  public int aMl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110915);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ezg == null)
      {
        paramVarArgs = new b("Not all required fields were included: materialResp");
        AppMethodBeat.o(110915);
        throw paramVarArgs;
      }
      if (this.Ezg != null)
      {
        paramVarArgs.kX(1, this.Ezg.computeSize());
        this.Ezg.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.aMk);
      paramVarArgs.aR(3, this.aMl);
      AppMethodBeat.o(110915);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ezg == null) {
        break label450;
      }
    }
    label450:
    for (paramInt = f.a.a.a.kW(1, this.Ezg.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.aMk);
      int j = f.a.a.b.b.a.bA(3, this.aMl);
      AppMethodBeat.o(110915);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Ezg == null)
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
        diy localdiy = (diy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110915);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dkv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dkv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdiy.Ezg = ((dkv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110915);
          return 0;
        case 2: 
          localdiy.aMk = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(110915);
          return 0;
        }
        localdiy.aMl = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(110915);
        return 0;
      }
      AppMethodBeat.o(110915);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.diy
 * JD-Core Version:    0.7.0.1
 */