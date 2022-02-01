package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cyw
  extends com.tencent.mm.bx.a
{
  public fnk aaDJ;
  public eje aaDK;
  public eje aaDL;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259100);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaDJ != null)
      {
        paramVarArgs.qD(1, this.aaDJ.computeSize());
        this.aaDJ.writeFields(paramVarArgs);
      }
      if (this.wording != null) {
        paramVarArgs.g(2, this.wording);
      }
      if (this.aaDK != null)
      {
        paramVarArgs.qD(3, this.aaDK.computeSize());
        this.aaDK.writeFields(paramVarArgs);
      }
      if (this.aaDL != null)
      {
        paramVarArgs.qD(4, this.aaDL.computeSize());
        this.aaDL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259100);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaDJ == null) {
        break label608;
      }
    }
    label608:
    for (int i = i.a.a.a.qC(1, this.aaDJ.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.wording);
      }
      i = paramInt;
      if (this.aaDK != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaDK.computeSize());
      }
      paramInt = i;
      if (this.aaDL != null) {
        paramInt = i + i.a.a.a.qC(4, this.aaDL.computeSize());
      }
      AppMethodBeat.o(259100);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259100);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cyw localcyw = (cyw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259100);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fnk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fnk)localObject2).parseFrom((byte[])localObject1);
            }
            localcyw.aaDJ = ((fnk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259100);
          return 0;
        case 2: 
          localcyw.wording = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259100);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eje();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eje)localObject2).parseFrom((byte[])localObject1);
            }
            localcyw.aaDK = ((eje)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259100);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eje();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eje)localObject2).parseFrom((byte[])localObject1);
          }
          localcyw.aaDL = ((eje)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259100);
        return 0;
      }
      AppMethodBeat.o(259100);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyw
 * JD-Core Version:    0.7.0.1
 */