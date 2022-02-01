package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bso
  extends com.tencent.mm.bw.a
{
  public abf Hgl;
  public LinkedList<bta> Hgm;
  public int dEu;
  public String dvT;
  
  public bso()
  {
    AppMethodBeat.i(196269);
    this.dEu = 0;
    this.Hgm = new LinkedList();
    AppMethodBeat.o(196269);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196270);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hgl == null)
      {
        paramVarArgs = new b("Not all required fields were included: idInfo");
        AppMethodBeat.o(196270);
        throw paramVarArgs;
      }
      if (this.Hgl != null)
      {
        paramVarArgs.lJ(1, this.Hgl.computeSize());
        this.Hgl.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dEu);
      if (this.dvT != null) {
        paramVarArgs.d(3, this.dvT);
      }
      paramVarArgs.e(4, 8, this.Hgm);
      AppMethodBeat.o(196270);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hgl == null) {
        break label602;
      }
    }
    label602:
    for (paramInt = f.a.a.a.lI(1, this.Hgl.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dEu);
      paramInt = i;
      if (this.dvT != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dvT);
      }
      i = f.a.a.a.c(4, 8, this.Hgm);
      AppMethodBeat.o(196270);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hgm.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Hgl == null)
        {
          paramVarArgs = new b("Not all required fields were included: idInfo");
          AppMethodBeat.o(196270);
          throw paramVarArgs;
        }
        AppMethodBeat.o(196270);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bso localbso = (bso)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(196270);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new abf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((abf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbso.Hgl = ((abf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(196270);
          return 0;
        case 2: 
          localbso.dEu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(196270);
          return 0;
        case 3: 
          localbso.dvT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(196270);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bta();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bta)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbso.Hgm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(196270);
        return 0;
      }
      AppMethodBeat.o(196270);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bso
 * JD-Core Version:    0.7.0.1
 */