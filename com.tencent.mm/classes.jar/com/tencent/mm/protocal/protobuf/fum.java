package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fum
  extends com.tencent.mm.bx.a
{
  public LinkedList<flo> abSG;
  public LinkedList<flo> abSH;
  public LinkedList<aek> abSI;
  public String title;
  
  public fum()
  {
    AppMethodBeat.i(114083);
    this.abSG = new LinkedList();
    this.abSH = new LinkedList();
    this.abSI = new LinkedList();
    AppMethodBeat.o(114083);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114084);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      paramVarArgs.e(2, 8, this.abSG);
      paramVarArgs.e(3, 8, this.abSH);
      paramVarArgs.e(4, 8, this.abSI);
      AppMethodBeat.o(114084);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label572;
      }
    }
    label572:
    for (paramInt = i.a.a.b.b.a.h(1, this.title) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.abSG);
      int j = i.a.a.a.c(3, 8, this.abSH);
      int k = i.a.a.a.c(4, 8, this.abSI);
      AppMethodBeat.o(114084);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abSG.clear();
        this.abSH.clear();
        this.abSI.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(114084);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fum localfum = (fum)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114084);
          return -1;
        case 1: 
          localfum.title = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(114084);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new flo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((flo)localObject2).parseFrom((byte[])localObject1);
            }
            localfum.abSG.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114084);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new flo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((flo)localObject2).parseFrom((byte[])localObject1);
            }
            localfum.abSH.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114084);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aek();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aek)localObject2).parseFrom((byte[])localObject1);
          }
          localfum.abSI.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(114084);
        return 0;
      }
      AppMethodBeat.o(114084);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fum
 * JD-Core Version:    0.7.0.1
 */