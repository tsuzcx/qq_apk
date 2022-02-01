package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dmt
  extends com.tencent.mm.cd.a
{
  public int TTW;
  public acs TTX;
  public ry TTY;
  public ry TTZ;
  public String desc;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(251307);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.f(2, this.desc);
      }
      paramVarArgs.aY(3, this.TTW);
      if (this.TTX != null)
      {
        paramVarArgs.oE(4, this.TTX.computeSize());
        this.TTX.writeFields(paramVarArgs);
      }
      if (this.TTY != null)
      {
        paramVarArgs.oE(5, this.TTY.computeSize());
        this.TTY.writeFields(paramVarArgs);
      }
      if (this.TTZ != null)
      {
        paramVarArgs.oE(6, this.TTZ.computeSize());
        this.TTZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(251307);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label720;
      }
    }
    label720:
    for (paramInt = g.a.a.b.b.a.g(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.desc);
      }
      i += g.a.a.b.b.a.bM(3, this.TTW);
      paramInt = i;
      if (this.TTX != null) {
        paramInt = i + g.a.a.a.oD(4, this.TTX.computeSize());
      }
      i = paramInt;
      if (this.TTY != null) {
        i = paramInt + g.a.a.a.oD(5, this.TTY.computeSize());
      }
      paramInt = i;
      if (this.TTZ != null) {
        paramInt = i + g.a.a.a.oD(6, this.TTZ.computeSize());
      }
      AppMethodBeat.o(251307);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(251307);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dmt localdmt = (dmt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(251307);
          return -1;
        case 1: 
          localdmt.title = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(251307);
          return 0;
        case 2: 
          localdmt.desc = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(251307);
          return 0;
        case 3: 
          localdmt.TTW = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(251307);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new acs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((acs)localObject2).parseFrom((byte[])localObject1);
            }
            localdmt.TTX = ((acs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(251307);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ry();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ry)localObject2).parseFrom((byte[])localObject1);
            }
            localdmt.TTY = ((ry)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(251307);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ry();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ry)localObject2).parseFrom((byte[])localObject1);
          }
          localdmt.TTZ = ((ry)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(251307);
        return 0;
      }
      AppMethodBeat.o(251307);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmt
 * JD-Core Version:    0.7.0.1
 */