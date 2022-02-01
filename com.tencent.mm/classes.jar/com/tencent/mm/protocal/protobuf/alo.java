package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class alo
  extends com.tencent.mm.bw.a
{
  public String GDE;
  public long GDF;
  public String GDG;
  public LinkedList<alm> GDH;
  public int nJv;
  
  public alo()
  {
    AppMethodBeat.i(110849);
    this.GDH = new LinkedList();
    AppMethodBeat.o(110849);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110850);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GDE == null)
      {
        paramVarArgs = new b("Not all required fields were included: Rid");
        AppMethodBeat.o(110850);
        throw paramVarArgs;
      }
      if (this.GDG == null)
      {
        paramVarArgs = new b("Not all required fields were included: MimeType");
        AppMethodBeat.o(110850);
        throw paramVarArgs;
      }
      if (this.GDE != null) {
        paramVarArgs.d(1, this.GDE);
      }
      paramVarArgs.aZ(2, this.GDF);
      paramVarArgs.aS(3, this.nJv);
      if (this.GDG != null) {
        paramVarArgs.d(4, this.GDG);
      }
      paramVarArgs.e(5, 8, this.GDH);
      AppMethodBeat.o(110850);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GDE == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.b.b.a.e(1, this.GDE) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.GDF) + f.a.a.b.b.a.bz(3, this.nJv);
      paramInt = i;
      if (this.GDG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GDG);
      }
      i = f.a.a.a.c(5, 8, this.GDH);
      AppMethodBeat.o(110850);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GDH.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GDE == null)
        {
          paramVarArgs = new b("Not all required fields were included: Rid");
          AppMethodBeat.o(110850);
          throw paramVarArgs;
        }
        if (this.GDG == null)
        {
          paramVarArgs = new b("Not all required fields were included: MimeType");
          AppMethodBeat.o(110850);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110850);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        alo localalo = (alo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110850);
          return -1;
        case 1: 
          localalo.GDE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(110850);
          return 0;
        case 2: 
          localalo.GDF = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(110850);
          return 0;
        case 3: 
          localalo.nJv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(110850);
          return 0;
        case 4: 
          localalo.GDG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(110850);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new alm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((alm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localalo.GDH.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110850);
        return 0;
      }
      AppMethodBeat.o(110850);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alo
 * JD-Core Version:    0.7.0.1
 */