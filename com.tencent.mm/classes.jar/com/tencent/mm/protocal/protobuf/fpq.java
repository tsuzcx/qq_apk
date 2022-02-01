package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fpq
  extends com.tencent.mm.cd.a
{
  public String Md5;
  public int RTb;
  public int UNC;
  public boolean UND;
  public String UNE;
  public int UNF;
  public fpn UNq;
  public int Uev;
  public int Uex;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153341);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UNq != null)
      {
        paramVarArgs.oE(1, this.UNq.computeSize());
        this.UNq.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.UNC);
      paramVarArgs.aY(3, this.Uev);
      paramVarArgs.aY(4, this.Uex);
      paramVarArgs.co(5, this.UND);
      paramVarArgs.aY(6, this.RTb);
      if (this.Md5 != null) {
        paramVarArgs.f(7, this.Md5);
      }
      if (this.UNE != null) {
        paramVarArgs.f(8, this.UNE);
      }
      paramVarArgs.aY(9, this.UNF);
      AppMethodBeat.o(153341);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UNq == null) {
        break label672;
      }
    }
    label672:
    for (paramInt = g.a.a.a.oD(1, this.UNq.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.UNC) + g.a.a.b.b.a.bM(3, this.Uev) + g.a.a.b.b.a.bM(4, this.Uex) + (g.a.a.b.b.a.gL(5) + 1) + g.a.a.b.b.a.bM(6, this.RTb);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Md5);
      }
      i = paramInt;
      if (this.UNE != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.UNE);
      }
      paramInt = g.a.a.b.b.a.bM(9, this.UNF);
      AppMethodBeat.o(153341);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153341);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fpq localfpq = (fpq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153341);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fpn localfpn = new fpn();
            if ((localObject != null) && (localObject.length > 0)) {
              localfpn.parseFrom((byte[])localObject);
            }
            localfpq.UNq = localfpn;
            paramInt += 1;
          }
          AppMethodBeat.o(153341);
          return 0;
        case 2: 
          localfpq.UNC = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(153341);
          return 0;
        case 3: 
          localfpq.Uev = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(153341);
          return 0;
        case 4: 
          localfpq.Uex = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(153341);
          return 0;
        case 5: 
          localfpq.UND = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(153341);
          return 0;
        case 6: 
          localfpq.RTb = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(153341);
          return 0;
        case 7: 
          localfpq.Md5 = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(153341);
          return 0;
        case 8: 
          localfpq.UNE = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(153341);
          return 0;
        }
        localfpq.UNF = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(153341);
        return 0;
      }
      AppMethodBeat.o(153341);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fpq
 * JD-Core Version:    0.7.0.1
 */