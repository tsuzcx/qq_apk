package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class we
  extends com.tencent.mm.bx.a
{
  public bjt Avj;
  public bjt Avk;
  public LinkedList<bkg> CYg;
  public String subtitle;
  public String title;
  
  public we()
  {
    AppMethodBeat.i(72460);
    this.CYg = new LinkedList();
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
      paramVarArgs.e(3, 8, this.CYg);
      if (this.Avj != null)
      {
        paramVarArgs.kX(4, this.Avj.computeSize());
        this.Avj.writeFields(paramVarArgs);
      }
      if (this.Avk != null)
      {
        paramVarArgs.kX(5, this.Avk.computeSize());
        this.Avk.writeFields(paramVarArgs);
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
      i += f.a.a.a.c(3, 8, this.CYg);
      paramInt = i;
      if (this.Avj != null) {
        paramInt = i + f.a.a.a.kW(4, this.Avj.computeSize());
      }
      i = paramInt;
      if (this.Avk != null) {
        i = paramInt + f.a.a.a.kW(5, this.Avk.computeSize());
      }
      AppMethodBeat.o(72461);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CYg.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72461);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        we localwe = (we)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72461);
          return -1;
        case 1: 
          localwe.title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72461);
          return 0;
        case 2: 
          localwe.subtitle = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72461);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bkg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bkg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localwe.CYg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72461);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bjt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localwe.Avj = ((bjt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72461);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bjt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bjt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localwe.Avk = ((bjt)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.we
 * JD-Core Version:    0.7.0.1
 */