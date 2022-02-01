package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azh
  extends com.tencent.mm.cd.a
{
  public String CqZ;
  public String Cra;
  public bns SLd;
  public int SLe;
  public String SLf;
  public int SLg;
  public String ufq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231464);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SLd != null)
      {
        paramVarArgs.oE(1, this.SLd.computeSize());
        this.SLd.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.SLe);
      if (this.CqZ != null) {
        paramVarArgs.f(3, this.CqZ);
      }
      if (this.Cra != null) {
        paramVarArgs.f(4, this.Cra);
      }
      if (this.SLf != null) {
        paramVarArgs.f(5, this.SLf);
      }
      paramVarArgs.aY(6, this.SLg);
      if (this.ufq != null) {
        paramVarArgs.f(7, this.ufq);
      }
      AppMethodBeat.o(231464);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SLd == null) {
        break label620;
      }
    }
    label620:
    for (paramInt = g.a.a.a.oD(1, this.SLd.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.SLe);
      paramInt = i;
      if (this.CqZ != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.CqZ);
      }
      i = paramInt;
      if (this.Cra != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.Cra);
      }
      paramInt = i;
      if (this.SLf != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.SLf);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.SLg);
      paramInt = i;
      if (this.ufq != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.ufq);
      }
      AppMethodBeat.o(231464);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231464);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        azh localazh = (azh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231464);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            bns localbns = new bns();
            if ((localObject != null) && (localObject.length > 0)) {
              localbns.parseFrom((byte[])localObject);
            }
            localazh.SLd = localbns;
            paramInt += 1;
          }
          AppMethodBeat.o(231464);
          return 0;
        case 2: 
          localazh.SLe = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(231464);
          return 0;
        case 3: 
          localazh.CqZ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231464);
          return 0;
        case 4: 
          localazh.Cra = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231464);
          return 0;
        case 5: 
          localazh.SLf = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231464);
          return 0;
        case 6: 
          localazh.SLg = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(231464);
          return 0;
        }
        localazh.ufq = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(231464);
        return 0;
      }
      AppMethodBeat.o(231464);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azh
 * JD-Core Version:    0.7.0.1
 */