package com.tencent.mm.smiley;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bx.a
{
  public LinkedList<h> acwY;
  public LinkedList<d> acwZ;
  public q acxa;
  public v acxb;
  public p acxc;
  
  public c()
  {
    AppMethodBeat.i(104894);
    this.acwY = new LinkedList();
    this.acwZ = new LinkedList();
    AppMethodBeat.o(104894);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104895);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(3, 8, this.acwY);
      paramVarArgs.e(4, 8, this.acwZ);
      if (this.acxa != null)
      {
        paramVarArgs.qD(5, this.acxa.computeSize());
        this.acxa.writeFields(paramVarArgs);
      }
      if (this.acxb != null)
      {
        paramVarArgs.qD(6, this.acxb.computeSize());
        this.acxb.writeFields(paramVarArgs);
      }
      if (this.acxc != null)
      {
        paramVarArgs.qD(7, this.acxc.computeSize());
        this.acxc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104895);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(3, 8, this.acwY) + 0 + i.a.a.a.c(4, 8, this.acwZ);
      paramInt = i;
      if (this.acxa != null) {
        paramInt = i + i.a.a.a.qC(5, this.acxa.computeSize());
      }
      i = paramInt;
      if (this.acxb != null) {
        i = paramInt + i.a.a.a.qC(6, this.acxb.computeSize());
      }
      paramInt = i;
      if (this.acxc != null) {
        paramInt = i + i.a.a.a.qC(7, this.acxc.computeSize());
      }
      AppMethodBeat.o(104895);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.acwY.clear();
      this.acwZ.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(104895);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(104895);
        return -1;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new h();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((h)localObject2).parseFrom((byte[])localObject1);
          }
          localc.acwY.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(104895);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new d();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((d)localObject2).parseFrom((byte[])localObject1);
          }
          localc.acwZ.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(104895);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new q();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((q)localObject2).parseFrom((byte[])localObject1);
          }
          localc.acxa = ((q)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(104895);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new v();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((v)localObject2).parseFrom((byte[])localObject1);
          }
          localc.acxb = ((v)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(104895);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new p();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((p)localObject2).parseFrom((byte[])localObject1);
        }
        localc.acxc = ((p)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(104895);
      return 0;
    }
    AppMethodBeat.o(104895);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.smiley.c
 * JD-Core Version:    0.7.0.1
 */