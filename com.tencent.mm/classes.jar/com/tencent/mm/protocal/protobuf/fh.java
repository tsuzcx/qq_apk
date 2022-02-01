package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class fh
  extends com.tencent.mm.cd.a
{
  public int HlE;
  public int RKg;
  public String RKh;
  public int RKi;
  public boolean RKj;
  public int RKk;
  public int RKl;
  public int RKm;
  public int RKn;
  public boolean RKo;
  public LinkedList<esd> RKp;
  public String Url;
  public int lpx;
  public String lpy;
  
  public fh()
  {
    AppMethodBeat.i(6388);
    this.RKg = 600;
    this.lpx = -1;
    this.RKo = false;
    this.RKp = new LinkedList();
    AppMethodBeat.o(6388);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6389);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.f(1, this.Url);
      }
      if (this.lpy != null) {
        paramVarArgs.f(2, this.lpy);
      }
      paramVarArgs.aY(3, this.RKg);
      if (this.RKh != null) {
        paramVarArgs.f(4, this.RKh);
      }
      paramVarArgs.aY(5, this.RKi);
      paramVarArgs.co(6, this.RKj);
      paramVarArgs.aY(7, this.RKk);
      paramVarArgs.aY(8, this.RKl);
      paramVarArgs.aY(9, this.HlE);
      paramVarArgs.aY(10, this.RKm);
      paramVarArgs.aY(11, this.RKn);
      paramVarArgs.aY(12, this.lpx);
      paramVarArgs.co(13, this.RKo);
      paramVarArgs.e(14, 8, this.RKp);
      AppMethodBeat.o(6389);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label948;
      }
    }
    label948:
    for (paramInt = g.a.a.b.b.a.g(1, this.Url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lpy != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.lpy);
      }
      i += g.a.a.b.b.a.bM(3, this.RKg);
      paramInt = i;
      if (this.RKh != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RKh);
      }
      i = g.a.a.b.b.a.bM(5, this.RKi);
      int j = g.a.a.b.b.a.gL(6);
      int k = g.a.a.b.b.a.bM(7, this.RKk);
      int m = g.a.a.b.b.a.bM(8, this.RKl);
      int n = g.a.a.b.b.a.bM(9, this.HlE);
      int i1 = g.a.a.b.b.a.bM(10, this.RKm);
      int i2 = g.a.a.b.b.a.bM(11, this.RKn);
      int i3 = g.a.a.b.b.a.bM(12, this.lpx);
      int i4 = g.a.a.b.b.a.gL(13);
      int i5 = g.a.a.a.c(14, 8, this.RKp);
      AppMethodBeat.o(6389);
      return paramInt + i + (j + 1) + k + m + n + i1 + i2 + i3 + (i4 + 1) + i5;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RKp.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(6389);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fh localfh = (fh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6389);
          return -1;
        case 1: 
          localfh.Url = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(6389);
          return 0;
        case 2: 
          localfh.lpy = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(6389);
          return 0;
        case 3: 
          localfh.RKg = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(6389);
          return 0;
        case 4: 
          localfh.RKh = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(6389);
          return 0;
        case 5: 
          localfh.RKi = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(6389);
          return 0;
        case 6: 
          localfh.RKj = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(6389);
          return 0;
        case 7: 
          localfh.RKk = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(6389);
          return 0;
        case 8: 
          localfh.RKl = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(6389);
          return 0;
        case 9: 
          localfh.HlE = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(6389);
          return 0;
        case 10: 
          localfh.RKm = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(6389);
          return 0;
        case 11: 
          localfh.RKn = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(6389);
          return 0;
        case 12: 
          localfh.lpx = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(6389);
          return 0;
        case 13: 
          localfh.RKo = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(6389);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          esd localesd = new esd();
          if ((localObject != null) && (localObject.length > 0)) {
            localesd.parseFrom((byte[])localObject);
          }
          localfh.RKp.add(localesd);
          paramInt += 1;
        }
        AppMethodBeat.o(6389);
        return 0;
      }
      AppMethodBeat.o(6389);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fh
 * JD-Core Version:    0.7.0.1
 */