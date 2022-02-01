package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class env
  extends com.tencent.mm.cd.a
{
  public int TAg;
  public long TEf;
  public int TEj;
  public int UqD;
  public ent UqE;
  public String UqF;
  public boolean UqG;
  public LinkedList<String> UqH;
  public int kQn;
  public String lps;
  public String md5;
  
  public env()
  {
    AppMethodBeat.i(208785);
    this.UqH = new LinkedList();
    AppMethodBeat.o(208785);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118455);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.lps != null) {
        paramVarArgs.f(1, this.lps);
      }
      paramVarArgs.aY(2, this.kQn);
      paramVarArgs.bm(3, this.TEf);
      paramVarArgs.aY(4, this.TEj);
      if (this.md5 != null) {
        paramVarArgs.f(5, this.md5);
      }
      paramVarArgs.aY(6, this.TAg);
      paramVarArgs.aY(7, this.UqD);
      if (this.UqE != null)
      {
        paramVarArgs.oE(8, this.UqE.computeSize());
        this.UqE.writeFields(paramVarArgs);
      }
      if (this.UqF != null) {
        paramVarArgs.f(9, this.UqF);
      }
      paramVarArgs.co(10, this.UqG);
      paramVarArgs.e(11, 1, this.UqH);
      AppMethodBeat.o(118455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lps == null) {
        break label796;
      }
    }
    label796:
    for (paramInt = g.a.a.b.b.a.g(1, this.lps) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.kQn) + g.a.a.b.b.a.p(3, this.TEf) + g.a.a.b.b.a.bM(4, this.TEj);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.md5);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.TAg) + g.a.a.b.b.a.bM(7, this.UqD);
      paramInt = i;
      if (this.UqE != null) {
        paramInt = i + g.a.a.a.oD(8, this.UqE.computeSize());
      }
      i = paramInt;
      if (this.UqF != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.UqF);
      }
      paramInt = g.a.a.b.b.a.gL(10);
      int j = g.a.a.a.c(11, 1, this.UqH);
      AppMethodBeat.o(118455);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UqH.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(118455);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        env localenv = (env)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118455);
          return -1;
        case 1: 
          localenv.lps = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(118455);
          return 0;
        case 2: 
          localenv.kQn = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(118455);
          return 0;
        case 3: 
          localenv.TEf = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(118455);
          return 0;
        case 4: 
          localenv.TEj = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(118455);
          return 0;
        case 5: 
          localenv.md5 = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(118455);
          return 0;
        case 6: 
          localenv.TAg = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(118455);
          return 0;
        case 7: 
          localenv.UqD = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(118455);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ent localent = new ent();
            if ((localObject != null) && (localObject.length > 0)) {
              localent.parseFrom((byte[])localObject);
            }
            localenv.UqE = localent;
            paramInt += 1;
          }
          AppMethodBeat.o(118455);
          return 0;
        case 9: 
          localenv.UqF = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(118455);
          return 0;
        case 10: 
          localenv.UqG = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(118455);
          return 0;
        }
        localenv.UqH.add(((g.a.a.a.a)localObject).abFh.readString());
        AppMethodBeat.o(118455);
        return 0;
      }
      AppMethodBeat.o(118455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.env
 * JD-Core Version:    0.7.0.1
 */