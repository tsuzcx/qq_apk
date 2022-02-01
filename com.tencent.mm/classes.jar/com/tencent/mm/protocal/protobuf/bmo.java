package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmo
  extends com.tencent.mm.cd.a
{
  public esj SXr;
  public String SXs = "";
  public int SXt = 0;
  public String SXu = "";
  public boolean SXv = false;
  public boolean SXw = false;
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122493);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SXr != null)
      {
        paramVarArgs.oE(1, this.SXr.computeSize());
        this.SXr.writeFields(paramVarArgs);
      }
      if (this.SXu != null) {
        paramVarArgs.f(2, this.SXu);
      }
      paramVarArgs.co(3, this.SXv);
      if (this.SXs != null) {
        paramVarArgs.f(4, this.SXs);
      }
      paramVarArgs.co(5, this.SXw);
      paramVarArgs.bm(6, this.timestamp);
      paramVarArgs.aY(7, this.SXt);
      AppMethodBeat.o(122493);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SXr == null) {
        break label588;
      }
    }
    label588:
    for (paramInt = g.a.a.a.oD(1, this.SXr.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SXu != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.SXu);
      }
      i += g.a.a.b.b.a.gL(3) + 1;
      paramInt = i;
      if (this.SXs != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SXs);
      }
      i = g.a.a.b.b.a.gL(5);
      int j = g.a.a.b.b.a.p(6, this.timestamp);
      int k = g.a.a.b.b.a.bM(7, this.SXt);
      AppMethodBeat.o(122493);
      return paramInt + (i + 1) + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(122493);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bmo localbmo = (bmo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122493);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            esj localesj = new esj();
            if ((localObject != null) && (localObject.length > 0)) {
              localesj.parseFrom((byte[])localObject);
            }
            localbmo.SXr = localesj;
            paramInt += 1;
          }
          AppMethodBeat.o(122493);
          return 0;
        case 2: 
          localbmo.SXu = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122493);
          return 0;
        case 3: 
          localbmo.SXv = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(122493);
          return 0;
        case 4: 
          localbmo.SXs = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122493);
          return 0;
        case 5: 
          localbmo.SXw = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(122493);
          return 0;
        case 6: 
          localbmo.timestamp = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(122493);
          return 0;
        }
        localbmo.SXt = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(122493);
        return 0;
      }
      AppMethodBeat.o(122493);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmo
 * JD-Core Version:    0.7.0.1
 */