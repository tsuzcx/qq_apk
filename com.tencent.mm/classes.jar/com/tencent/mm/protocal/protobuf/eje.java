package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eje
  extends com.tencent.mm.bx.a
{
  public agp abnU;
  public dot abnW;
  public String jump_url;
  public int type;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258506);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.g(1, this.wording);
      }
      paramVarArgs.bS(2, this.type);
      if (this.jump_url != null) {
        paramVarArgs.g(3, this.jump_url);
      }
      if (this.abnW != null)
      {
        paramVarArgs.qD(4, this.abnW.computeSize());
        this.abnW.writeFields(paramVarArgs);
      }
      if (this.abnU != null)
      {
        paramVarArgs.qD(5, this.abnU.computeSize());
        this.abnU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wording == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = i.a.a.b.b.a.h(1, this.wording) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.type);
      paramInt = i;
      if (this.jump_url != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.jump_url);
      }
      i = paramInt;
      if (this.abnW != null) {
        i = paramInt + i.a.a.a.qC(4, this.abnW.computeSize());
      }
      paramInt = i;
      if (this.abnU != null) {
        paramInt = i + i.a.a.a.qC(5, this.abnU.computeSize());
      }
      AppMethodBeat.o(258506);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258506);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eje localeje = (eje)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258506);
          return -1;
        case 1: 
          localeje.wording = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258506);
          return 0;
        case 2: 
          localeje.type = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258506);
          return 0;
        case 3: 
          localeje.jump_url = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258506);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dot();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dot)localObject2).parseFrom((byte[])localObject1);
            }
            localeje.abnW = ((dot)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258506);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new agp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((agp)localObject2).parseFrom((byte[])localObject1);
          }
          localeje.abnU = ((agp)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258506);
        return 0;
      }
      AppMethodBeat.o(258506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eje
 * JD-Core Version:    0.7.0.1
 */