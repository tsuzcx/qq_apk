package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class emz
  extends com.tencent.mm.cd.a
{
  public b UpK;
  public ajf UpL;
  public aje UpM;
  public int height;
  public String path;
  public int type;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(255126);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      if (this.path != null) {
        paramVarArgs.f(2, this.path);
      }
      if (this.UpK != null) {
        paramVarArgs.c(3, this.UpK);
      }
      paramVarArgs.aY(4, this.width);
      paramVarArgs.aY(5, this.height);
      if (this.UpL != null)
      {
        paramVarArgs.oE(6, this.UpL.computeSize());
        this.UpL.writeFields(paramVarArgs);
      }
      if (this.UpM != null)
      {
        paramVarArgs.oE(7, this.UpM.computeSize());
        this.UpM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(255126);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.type) + 0;
      paramInt = i;
      if (this.path != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.path);
      }
      i = paramInt;
      if (this.UpK != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.UpK);
      }
      i = i + g.a.a.b.b.a.bM(4, this.width) + g.a.a.b.b.a.bM(5, this.height);
      paramInt = i;
      if (this.UpL != null) {
        paramInt = i + g.a.a.a.oD(6, this.UpL.computeSize());
      }
      i = paramInt;
      if (this.UpM != null) {
        i = paramInt + g.a.a.a.oD(7, this.UpM.computeSize());
      }
      AppMethodBeat.o(255126);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(255126);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      emz localemz = (emz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(255126);
        return -1;
      case 1: 
        localemz.type = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(255126);
        return 0;
      case 2: 
        localemz.path = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(255126);
        return 0;
      case 3: 
        localemz.UpK = ((g.a.a.a.a)localObject1).abFh.iUw();
        AppMethodBeat.o(255126);
        return 0;
      case 4: 
        localemz.width = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(255126);
        return 0;
      case 5: 
        localemz.height = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(255126);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ajf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ajf)localObject2).parseFrom((byte[])localObject1);
          }
          localemz.UpL = ((ajf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(255126);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new aje();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((aje)localObject2).parseFrom((byte[])localObject1);
        }
        localemz.UpM = ((aje)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(255126);
      return 0;
    }
    AppMethodBeat.o(255126);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emz
 * JD-Core Version:    0.7.0.1
 */