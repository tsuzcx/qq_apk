package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yn
  extends com.tencent.mm.bx.a
{
  public bry DnV;
  public bry DnW;
  public LinkedList<bsm> FXZ;
  public String subtitle;
  public String title;
  
  public yn()
  {
    AppMethodBeat.i(72460);
    this.FXZ = new LinkedList();
    AppMethodBeat.o(72460);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72461);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.subtitle != null) {
        paramVarArgs.d(2, this.subtitle);
      }
      paramVarArgs.e(3, 8, this.FXZ);
      if (this.DnV != null)
      {
        paramVarArgs.lC(4, this.DnV.computeSize());
        this.DnV.writeFields(paramVarArgs);
      }
      if (this.DnW != null)
      {
        paramVarArgs.lC(5, this.DnW.computeSize());
        this.DnW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72461);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label726;
      }
    }
    label726:
    for (paramInt = f.a.a.b.b.a.e(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.subtitle != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.subtitle);
      }
      i += f.a.a.a.c(3, 8, this.FXZ);
      paramInt = i;
      if (this.DnV != null) {
        paramInt = i + f.a.a.a.lB(4, this.DnV.computeSize());
      }
      i = paramInt;
      if (this.DnW != null) {
        i = paramInt + f.a.a.a.lB(5, this.DnW.computeSize());
      }
      AppMethodBeat.o(72461);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FXZ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72461);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        yn localyn = (yn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72461);
          return -1;
        case 1: 
          localyn.title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72461);
          return 0;
        case 2: 
          localyn.subtitle = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72461);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyn.FXZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72461);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bry();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bry)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyn.DnV = ((bry)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72461);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bry();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bry)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyn.DnW = ((bry)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72461);
        return 0;
      }
      AppMethodBeat.o(72461);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yn
 * JD-Core Version:    0.7.0.1
 */