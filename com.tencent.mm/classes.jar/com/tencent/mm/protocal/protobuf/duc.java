package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class duc
  extends com.tencent.mm.bw.a
{
  public dth GbY;
  public int GbZ;
  public int Gca;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147808);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GbY == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_response");
        AppMethodBeat.o(147808);
        throw paramVarArgs;
      }
      if (this.GbY != null)
      {
        paramVarArgs.ln(1, this.GbY.computeSize());
        this.GbY.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.GbZ);
      paramVarArgs.aR(3, this.Gca);
      AppMethodBeat.o(147808);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GbY == null) {
        break label450;
      }
    }
    label450:
    for (paramInt = f.a.a.a.lm(1, this.GbY.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.GbZ);
      int j = f.a.a.b.b.a.bx(3, this.Gca);
      AppMethodBeat.o(147808);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.GbY == null)
        {
          paramVarArgs = new b("Not all required fields were included: base_response");
          AppMethodBeat.o(147808);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147808);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        duc localduc = (duc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147808);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dth();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dth)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localduc.GbY = ((dth)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147808);
          return 0;
        case 2: 
          localduc.GbZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(147808);
          return 0;
        }
        localduc.Gca = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(147808);
        return 0;
      }
      AppMethodBeat.o(147808);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duc
 * JD-Core Version:    0.7.0.1
 */