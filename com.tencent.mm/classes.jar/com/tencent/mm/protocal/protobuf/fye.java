package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fye
  extends com.tencent.mm.bx.a
{
  public long ZnE;
  public String abWb;
  public String abWc;
  public LinkedList<fyz> abWd;
  public long abWe;
  public int abWf;
  public String abWg;
  
  public fye()
  {
    AppMethodBeat.i(257669);
    this.abWd = new LinkedList();
    AppMethodBeat.o(257669);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257673);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abWb != null) {
        paramVarArgs.g(1, this.abWb);
      }
      paramVarArgs.bv(2, this.ZnE);
      if (this.abWc != null) {
        paramVarArgs.g(3, this.abWc);
      }
      paramVarArgs.e(4, 8, this.abWd);
      paramVarArgs.bv(5, this.abWe);
      paramVarArgs.bS(6, this.abWf);
      if (this.abWg != null) {
        paramVarArgs.g(7, this.abWg);
      }
      AppMethodBeat.o(257673);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abWb == null) {
        break label584;
      }
    }
    label584:
    for (paramInt = i.a.a.b.b.a.h(1, this.abWb) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.ZnE);
      paramInt = i;
      if (this.abWc != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.abWc);
      }
      i = paramInt + i.a.a.a.c(4, 8, this.abWd) + i.a.a.b.b.a.q(5, this.abWe) + i.a.a.b.b.a.cJ(6, this.abWf);
      paramInt = i;
      if (this.abWg != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abWg);
      }
      AppMethodBeat.o(257673);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abWd.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257673);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fye localfye = (fye)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257673);
          return -1;
        case 1: 
          localfye.abWb = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257673);
          return 0;
        case 2: 
          localfye.ZnE = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(257673);
          return 0;
        case 3: 
          localfye.abWc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257673);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fyz localfyz = new fyz();
            if ((localObject != null) && (localObject.length > 0)) {
              localfyz.parseFrom((byte[])localObject);
            }
            localfye.abWd.add(localfyz);
            paramInt += 1;
          }
          AppMethodBeat.o(257673);
          return 0;
        case 5: 
          localfye.abWe = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(257673);
          return 0;
        case 6: 
          localfye.abWf = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257673);
          return 0;
        }
        localfye.abWg = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257673);
        return 0;
      }
      AppMethodBeat.o(257673);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fye
 * JD-Core Version:    0.7.0.1
 */