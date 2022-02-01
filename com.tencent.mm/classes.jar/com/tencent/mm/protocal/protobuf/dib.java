package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dib
  extends com.tencent.mm.cd.a
{
  public String RFf;
  public String TPg;
  public String TPh;
  public String TPi;
  public int TPj;
  public LinkedList<ub> TPk;
  public String TPl;
  public String TPm;
  
  public dib()
  {
    AppMethodBeat.i(114047);
    this.TPk = new LinkedList();
    AppMethodBeat.o(114047);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114048);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RFf != null) {
        paramVarArgs.f(1, this.RFf);
      }
      if (this.TPg != null) {
        paramVarArgs.f(2, this.TPg);
      }
      if (this.TPh != null) {
        paramVarArgs.f(3, this.TPh);
      }
      if (this.TPi != null) {
        paramVarArgs.f(4, this.TPi);
      }
      paramVarArgs.aY(5, this.TPj);
      paramVarArgs.e(6, 8, this.TPk);
      if (this.TPl != null) {
        paramVarArgs.f(7, this.TPl);
      }
      if (this.TPm != null) {
        paramVarArgs.f(8, this.TPm);
      }
      AppMethodBeat.o(114048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RFf == null) {
        break label684;
      }
    }
    label684:
    for (int i = g.a.a.b.b.a.g(1, this.RFf) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TPg != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TPg);
      }
      i = paramInt;
      if (this.TPh != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TPh);
      }
      paramInt = i;
      if (this.TPi != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TPi);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.TPj) + g.a.a.a.c(6, 8, this.TPk);
      paramInt = i;
      if (this.TPl != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.TPl);
      }
      i = paramInt;
      if (this.TPm != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.TPm);
      }
      AppMethodBeat.o(114048);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TPk.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(114048);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dib localdib = (dib)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114048);
          return -1;
        case 1: 
          localdib.RFf = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 2: 
          localdib.TPg = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 3: 
          localdib.TPh = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 4: 
          localdib.TPi = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 5: 
          localdib.TPj = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(114048);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ub localub = new ub();
            if ((localObject != null) && (localObject.length > 0)) {
              localub.parseFrom((byte[])localObject);
            }
            localdib.TPk.add(localub);
            paramInt += 1;
          }
          AppMethodBeat.o(114048);
          return 0;
        case 7: 
          localdib.TPl = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114048);
          return 0;
        }
        localdib.TPm = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(114048);
        return 0;
      }
      AppMethodBeat.o(114048);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dib
 * JD-Core Version:    0.7.0.1
 */