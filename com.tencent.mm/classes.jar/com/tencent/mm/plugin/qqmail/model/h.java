package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.bx.a
{
  public String Hox;
  public LinkedList<k> NjA;
  public LinkedList<ai> NjB;
  public int NjC;
  public String Njg;
  public int Njx;
  public LinkedList<k> Njy;
  public LinkedList<k> Njz;
  public String content;
  
  public h()
  {
    AppMethodBeat.i(122665);
    this.Njy = new LinkedList();
    this.Njz = new LinkedList();
    this.NjA = new LinkedList();
    this.NjB = new LinkedList();
    this.NjC = 20;
    AppMethodBeat.o(122665);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122666);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.content == null)
      {
        paramVarArgs = new b("Not all required fields were included: content");
        AppMethodBeat.o(122666);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.Njx);
      if (this.Njg != null) {
        paramVarArgs.g(2, this.Njg);
      }
      paramVarArgs.e(3, 8, this.Njy);
      paramVarArgs.e(4, 8, this.Njz);
      paramVarArgs.e(5, 8, this.NjA);
      paramVarArgs.e(6, 8, this.NjB);
      if (this.Hox != null) {
        paramVarArgs.g(7, this.Hox);
      }
      if (this.content != null) {
        paramVarArgs.g(8, this.content);
      }
      paramVarArgs.bS(9, this.NjC);
      AppMethodBeat.o(122666);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.Njx) + 0;
      paramInt = i;
      if (this.Njg != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Njg);
      }
      i = paramInt + i.a.a.a.c(3, 8, this.Njy) + i.a.a.a.c(4, 8, this.Njz) + i.a.a.a.c(5, 8, this.NjA) + i.a.a.a.c(6, 8, this.NjB);
      paramInt = i;
      if (this.Hox != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Hox);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.content);
      }
      paramInt = i.a.a.b.b.a.cJ(9, this.NjC);
      AppMethodBeat.o(122666);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Njy.clear();
      this.Njz.clear();
      this.NjA.clear();
      this.NjB.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.content == null)
      {
        paramVarArgs = new b("Not all required fields were included: content");
        AppMethodBeat.o(122666);
        throw paramVarArgs;
      }
      AppMethodBeat.o(122666);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      h localh = (h)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122666);
        return -1;
      case 1: 
        localh.Njx = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(122666);
        return 0;
      case 2: 
        localh.Njg = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(122666);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new k();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((k)localObject2).parseFrom((byte[])localObject1);
          }
          localh.Njy.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new k();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((k)localObject2).parseFrom((byte[])localObject1);
          }
          localh.Njz.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new k();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((k)localObject2).parseFrom((byte[])localObject1);
          }
          localh.NjA.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ai();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ai)localObject2).parseFrom((byte[])localObject1);
          }
          localh.NjB.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122666);
        return 0;
      case 7: 
        localh.Hox = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(122666);
        return 0;
      case 8: 
        localh.content = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(122666);
        return 0;
      }
      localh.NjC = ((i.a.a.a.a)localObject1).ajGk.aar();
      AppMethodBeat.o(122666);
      return 0;
    }
    AppMethodBeat.o(122666);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.h
 * JD-Core Version:    0.7.0.1
 */