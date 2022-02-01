package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cgy
  extends com.tencent.mm.bx.a
{
  public LinkedList<cgx> Has;
  public int Hat;
  public int Hau;
  public cvl Hav;
  public int Haw;
  public LinkedList<cgw> Hax;
  public boolean Hay;
  public LinkedList<cvl> Haz;
  public int state;
  public String wDT;
  
  public cgy()
  {
    AppMethodBeat.i(117544);
    this.Has = new LinkedList();
    this.Hax = new LinkedList();
    this.Haz = new LinkedList();
    AppMethodBeat.o(117544);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117545);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.wDT == null)
      {
        paramVarArgs = new b("Not all required fields were included: pid");
        AppMethodBeat.o(117545);
        throw paramVarArgs;
      }
      if (this.wDT != null) {
        paramVarArgs.d(1, this.wDT);
      }
      paramVarArgs.aS(2, this.state);
      paramVarArgs.e(3, 8, this.Has);
      paramVarArgs.aS(4, this.Hat);
      paramVarArgs.aS(5, this.Hau);
      if (this.Hav != null)
      {
        paramVarArgs.lC(6, this.Hav.computeSize());
        this.Hav.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.Haw);
      paramVarArgs.e(8, 8, this.Hax);
      paramVarArgs.bt(9, this.Hay);
      paramVarArgs.e(10, 8, this.Haz);
      AppMethodBeat.o(117545);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wDT == null) {
        break label1062;
      }
    }
    label1062:
    for (paramInt = f.a.a.b.b.a.e(1, this.wDT) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.state) + f.a.a.a.c(3, 8, this.Has) + f.a.a.b.b.a.bz(4, this.Hat) + f.a.a.b.b.a.bz(5, this.Hau);
      paramInt = i;
      if (this.Hav != null) {
        paramInt = i + f.a.a.a.lB(6, this.Hav.computeSize());
      }
      i = f.a.a.b.b.a.bz(7, this.Haw);
      int j = f.a.a.a.c(8, 8, this.Hax);
      int k = f.a.a.b.b.a.alV(9);
      int m = f.a.a.a.c(10, 8, this.Haz);
      AppMethodBeat.o(117545);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Has.clear();
        this.Hax.clear();
        this.Haz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.wDT == null)
        {
          paramVarArgs = new b("Not all required fields were included: pid");
          AppMethodBeat.o(117545);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117545);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cgy localcgy = (cgy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117545);
          return -1;
        case 1: 
          localcgy.wDT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117545);
          return 0;
        case 2: 
          localcgy.state = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117545);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcgy.Has.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117545);
          return 0;
        case 4: 
          localcgy.Hat = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117545);
          return 0;
        case 5: 
          localcgy.Hau = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117545);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cvl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcgy.Hav = ((cvl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117545);
          return 0;
        case 7: 
          localcgy.Haw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117545);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcgy.Hax.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117545);
          return 0;
        case 9: 
          localcgy.Hay = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(117545);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cvl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cvl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcgy.Haz.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117545);
        return 0;
      }
      AppMethodBeat.o(117545);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgy
 * JD-Core Version:    0.7.0.1
 */