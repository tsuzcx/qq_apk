package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aao
  extends com.tencent.mm.cd.a
{
  public LinkedList<coq> COK;
  public int RPe;
  public int SmH;
  public String jUb;
  public String jUc;
  public String jUd;
  public String jUe;
  public String jUf;
  public int rWz;
  public int vhf;
  
  public aao()
  {
    AppMethodBeat.i(143965);
    this.COK = new LinkedList();
    AppMethodBeat.o(143965);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143966);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.vhf);
      if (this.jUd != null) {
        paramVarArgs.f(7, this.jUd);
      }
      paramVarArgs.aY(2, this.RPe);
      paramVarArgs.aY(3, this.SmH);
      paramVarArgs.e(4, 8, this.COK);
      if (this.jUb != null) {
        paramVarArgs.f(5, this.jUb);
      }
      if (this.jUc != null) {
        paramVarArgs.f(6, this.jUc);
      }
      if (this.jUe != null) {
        paramVarArgs.f(8, this.jUe);
      }
      if (this.jUf != null) {
        paramVarArgs.f(9, this.jUf);
      }
      paramVarArgs.aY(10, this.rWz);
      AppMethodBeat.o(143966);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.vhf) + 0;
      paramInt = i;
      if (this.jUd != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.jUd);
      }
      i = paramInt + g.a.a.b.b.a.bM(2, this.RPe) + g.a.a.b.b.a.bM(3, this.SmH) + g.a.a.a.c(4, 8, this.COK);
      paramInt = i;
      if (this.jUb != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.jUb);
      }
      i = paramInt;
      if (this.jUc != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.jUc);
      }
      paramInt = i;
      if (this.jUe != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.jUe);
      }
      i = paramInt;
      if (this.jUf != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.jUf);
      }
      paramInt = g.a.a.b.b.a.bM(10, this.rWz);
      AppMethodBeat.o(143966);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.COK.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(143966);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      aao localaao = (aao)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143966);
        return -1;
      case 1: 
        localaao.vhf = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143966);
        return 0;
      case 7: 
        localaao.jUd = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 2: 
        localaao.RPe = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143966);
        return 0;
      case 3: 
        localaao.SmH = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143966);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          coq localcoq = new coq();
          if ((localObject != null) && (localObject.length > 0)) {
            localcoq.parseFrom((byte[])localObject);
          }
          localaao.COK.add(localcoq);
          paramInt += 1;
        }
        AppMethodBeat.o(143966);
        return 0;
      case 5: 
        localaao.jUb = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 6: 
        localaao.jUc = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 8: 
        localaao.jUe = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 9: 
        localaao.jUf = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(143966);
        return 0;
      }
      localaao.rWz = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(143966);
      return 0;
    }
    AppMethodBeat.o(143966);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aao
 * JD-Core Version:    0.7.0.1
 */