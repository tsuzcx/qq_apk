package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aus
  extends com.tencent.mm.bw.a
{
  public LinkedList<dcc> GLE;
  public dcc GLF;
  public LinkedList<aur> GLG;
  public boolean GLH;
  public String GLI;
  public long GLJ;
  public String dAa;
  public boolean sDg;
  
  public aus()
  {
    AppMethodBeat.i(122501);
    this.GLE = new LinkedList();
    this.GLG = new LinkedList();
    this.GLH = false;
    this.sDg = false;
    AppMethodBeat.o(122501);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122502);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dAa != null) {
        paramVarArgs.d(1, this.dAa);
      }
      paramVarArgs.e(2, 8, this.GLE);
      if (this.GLF != null)
      {
        paramVarArgs.lJ(3, this.GLF.computeSize());
        this.GLF.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.GLG);
      paramVarArgs.bC(5, this.GLH);
      paramVarArgs.bC(6, this.sDg);
      if (this.GLI != null) {
        paramVarArgs.d(7, this.GLI);
      }
      paramVarArgs.aZ(8, this.GLJ);
      AppMethodBeat.o(122502);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dAa == null) {
        break label838;
      }
    }
    label838:
    for (paramInt = f.a.a.b.b.a.e(1, this.dAa) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.GLE);
      paramInt = i;
      if (this.GLF != null) {
        paramInt = i + f.a.a.a.lI(3, this.GLF.computeSize());
      }
      i = paramInt + f.a.a.a.c(4, 8, this.GLG) + f.a.a.b.b.a.amF(5) + f.a.a.b.b.a.amF(6);
      paramInt = i;
      if (this.GLI != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GLI);
      }
      i = f.a.a.b.b.a.p(8, this.GLJ);
      AppMethodBeat.o(122502);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GLE.clear();
        this.GLG.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(122502);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aus localaus = (aus)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122502);
          return -1;
        case 1: 
          localaus.dAa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122502);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaus.GLE.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122502);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaus.GLF = ((dcc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122502);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aur();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aur)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaus.GLG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122502);
          return 0;
        case 5: 
          localaus.GLH = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(122502);
          return 0;
        case 6: 
          localaus.sDg = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(122502);
          return 0;
        case 7: 
          localaus.GLI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122502);
          return 0;
        }
        localaus.GLJ = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(122502);
        return 0;
      }
      AppMethodBeat.o(122502);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aus
 * JD-Core Version:    0.7.0.1
 */