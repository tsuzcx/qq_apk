package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ape
  extends com.tencent.mm.cd.a
{
  public int RLs;
  public String SCg;
  public long SCh;
  public String SCi;
  public LinkedList<apc> SCj;
  public bnq SCk;
  public int rWo;
  
  public ape()
  {
    AppMethodBeat.i(110849);
    this.SCj = new LinkedList();
    AppMethodBeat.o(110849);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110850);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SCg == null)
      {
        paramVarArgs = new b("Not all required fields were included: Rid");
        AppMethodBeat.o(110850);
        throw paramVarArgs;
      }
      if (this.SCi == null)
      {
        paramVarArgs = new b("Not all required fields were included: MimeType");
        AppMethodBeat.o(110850);
        throw paramVarArgs;
      }
      if (this.SCg != null) {
        paramVarArgs.f(1, this.SCg);
      }
      paramVarArgs.bm(2, this.SCh);
      paramVarArgs.aY(3, this.rWo);
      if (this.SCi != null) {
        paramVarArgs.f(4, this.SCi);
      }
      paramVarArgs.e(5, 8, this.SCj);
      if (this.SCk != null)
      {
        paramVarArgs.oE(6, this.SCk.computeSize());
        this.SCk.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(7, this.RLs);
      AppMethodBeat.o(110850);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SCg == null) {
        break label758;
      }
    }
    label758:
    for (paramInt = g.a.a.b.b.a.g(1, this.SCg) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.SCh) + g.a.a.b.b.a.bM(3, this.rWo);
      paramInt = i;
      if (this.SCi != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SCi);
      }
      i = paramInt + g.a.a.a.c(5, 8, this.SCj);
      paramInt = i;
      if (this.SCk != null) {
        paramInt = i + g.a.a.a.oD(6, this.SCk.computeSize());
      }
      i = g.a.a.b.b.a.bM(7, this.RLs);
      AppMethodBeat.o(110850);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SCj.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.SCg == null)
        {
          paramVarArgs = new b("Not all required fields were included: Rid");
          AppMethodBeat.o(110850);
          throw paramVarArgs;
        }
        if (this.SCi == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ape localape = (ape)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110850);
          return -1;
        case 1: 
          localape.SCg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(110850);
          return 0;
        case 2: 
          localape.SCh = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(110850);
          return 0;
        case 3: 
          localape.rWo = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(110850);
          return 0;
        case 4: 
          localape.SCi = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(110850);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new apc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((apc)localObject2).parseFrom((byte[])localObject1);
            }
            localape.SCj.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(110850);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bnq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bnq)localObject2).parseFrom((byte[])localObject1);
            }
            localape.SCk = ((bnq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(110850);
          return 0;
        }
        localape.RLs = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(110850);
        return 0;
      }
      AppMethodBeat.o(110850);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ape
 * JD-Core Version:    0.7.0.1
 */