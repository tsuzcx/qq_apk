package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dmx
  extends com.tencent.mm.cd.a
{
  public aea TUf;
  public aea TUg;
  public aea TUh;
  public aea TUi;
  public int bottom;
  public int left;
  public int right;
  public int top;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118412);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.left);
      paramVarArgs.aY(2, this.top);
      paramVarArgs.aY(3, this.right);
      paramVarArgs.aY(4, this.bottom);
      if (this.TUf != null)
      {
        paramVarArgs.oE(5, this.TUf.computeSize());
        this.TUf.writeFields(paramVarArgs);
      }
      if (this.TUg != null)
      {
        paramVarArgs.oE(6, this.TUg.computeSize());
        this.TUg.writeFields(paramVarArgs);
      }
      if (this.TUh != null)
      {
        paramVarArgs.oE(7, this.TUh.computeSize());
        this.TUh.writeFields(paramVarArgs);
      }
      if (this.TUi != null)
      {
        paramVarArgs.oE(8, this.TUi.computeSize());
        this.TUi.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(100, this.type);
      AppMethodBeat.o(118412);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.left) + 0 + g.a.a.b.b.a.bM(2, this.top) + g.a.a.b.b.a.bM(3, this.right) + g.a.a.b.b.a.bM(4, this.bottom);
      paramInt = i;
      if (this.TUf != null) {
        paramInt = i + g.a.a.a.oD(5, this.TUf.computeSize());
      }
      i = paramInt;
      if (this.TUg != null) {
        i = paramInt + g.a.a.a.oD(6, this.TUg.computeSize());
      }
      paramInt = i;
      if (this.TUh != null) {
        paramInt = i + g.a.a.a.oD(7, this.TUh.computeSize());
      }
      i = paramInt;
      if (this.TUi != null) {
        i = paramInt + g.a.a.a.oD(8, this.TUi.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(100, this.type);
      AppMethodBeat.o(118412);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(118412);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dmx localdmx = (dmx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      aea localaea;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118412);
        return -1;
      case 1: 
        localdmx.left = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(118412);
        return 0;
      case 2: 
        localdmx.top = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(118412);
        return 0;
      case 3: 
        localdmx.right = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(118412);
        return 0;
      case 4: 
        localdmx.bottom = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(118412);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localaea = new aea();
          if ((localObject != null) && (localObject.length > 0)) {
            localaea.parseFrom((byte[])localObject);
          }
          localdmx.TUf = localaea;
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localaea = new aea();
          if ((localObject != null) && (localObject.length > 0)) {
            localaea.parseFrom((byte[])localObject);
          }
          localdmx.TUg = localaea;
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localaea = new aea();
          if ((localObject != null) && (localObject.length > 0)) {
            localaea.parseFrom((byte[])localObject);
          }
          localdmx.TUh = localaea;
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localaea = new aea();
          if ((localObject != null) && (localObject.length > 0)) {
            localaea.parseFrom((byte[])localObject);
          }
          localdmx.TUi = localaea;
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      }
      localdmx.type = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(118412);
      return 0;
    }
    AppMethodBeat.o(118412);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmx
 * JD-Core Version:    0.7.0.1
 */