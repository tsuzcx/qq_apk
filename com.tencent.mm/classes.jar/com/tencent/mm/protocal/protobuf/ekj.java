package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ekj
  extends com.tencent.mm.cd.a
{
  public int Umb;
  public elp Umc;
  public dsg Umd;
  public ago Ume;
  public dnx Umf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125802);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Umb);
      if (this.Umc != null)
      {
        paramVarArgs.oE(2, this.Umc.computeSize());
        this.Umc.writeFields(paramVarArgs);
      }
      if (this.Umd != null)
      {
        paramVarArgs.oE(3, this.Umd.computeSize());
        this.Umd.writeFields(paramVarArgs);
      }
      if (this.Ume != null)
      {
        paramVarArgs.oE(4, this.Ume.computeSize());
        this.Ume.writeFields(paramVarArgs);
      }
      if (this.Umf != null)
      {
        paramVarArgs.oE(5, this.Umf.computeSize());
        this.Umf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125802);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.Umb) + 0;
      paramInt = i;
      if (this.Umc != null) {
        paramInt = i + g.a.a.a.oD(2, this.Umc.computeSize());
      }
      i = paramInt;
      if (this.Umd != null) {
        i = paramInt + g.a.a.a.oD(3, this.Umd.computeSize());
      }
      paramInt = i;
      if (this.Ume != null) {
        paramInt = i + g.a.a.a.oD(4, this.Ume.computeSize());
      }
      i = paramInt;
      if (this.Umf != null) {
        i = paramInt + g.a.a.a.oD(5, this.Umf.computeSize());
      }
      AppMethodBeat.o(125802);
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
      AppMethodBeat.o(125802);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ekj localekj = (ekj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125802);
        return -1;
      case 1: 
        localekj.Umb = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125802);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new elp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((elp)localObject2).parseFrom((byte[])localObject1);
          }
          localekj.Umc = ((elp)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125802);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dsg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dsg)localObject2).parseFrom((byte[])localObject1);
          }
          localekj.Umd = ((dsg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125802);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ago();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ago)localObject2).parseFrom((byte[])localObject1);
          }
          localekj.Ume = ((ago)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125802);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new dnx();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((dnx)localObject2).parseFrom((byte[])localObject1);
        }
        localekj.Umf = ((dnx)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(125802);
      return 0;
    }
    AppMethodBeat.o(125802);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekj
 * JD-Core Version:    0.7.0.1
 */