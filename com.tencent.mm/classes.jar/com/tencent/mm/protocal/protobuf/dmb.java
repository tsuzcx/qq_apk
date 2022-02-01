package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dmb
  extends com.tencent.mm.cd.a
{
  public LinkedList<erk> TSL;
  public String TTp;
  public String TTq;
  public LinkedList<Integer> TTr;
  public LinkedList<Integer> TTs;
  public String TTt;
  public boolean TTu;
  
  public dmb()
  {
    AppMethodBeat.i(209519);
    this.TSL = new LinkedList();
    this.TTr = new LinkedList();
    this.TTs = new LinkedList();
    AppMethodBeat.o(209519);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209522);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TTp != null) {
        paramVarArgs.f(1, this.TTp);
      }
      if (this.TTq != null) {
        paramVarArgs.f(2, this.TTq);
      }
      paramVarArgs.e(3, 8, this.TSL);
      paramVarArgs.e(4, 2, this.TTr);
      paramVarArgs.e(5, 2, this.TTs);
      if (this.TTt != null) {
        paramVarArgs.f(6, this.TTt);
      }
      paramVarArgs.co(7, this.TTu);
      AppMethodBeat.o(209522);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TTp == null) {
        break label618;
      }
    }
    label618:
    for (paramInt = g.a.a.b.b.a.g(1, this.TTp) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TTq != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.TTq);
      }
      i = i + g.a.a.a.c(3, 8, this.TSL) + g.a.a.a.c(4, 2, this.TTr) + g.a.a.a.c(5, 2, this.TTs);
      paramInt = i;
      if (this.TTt != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TTt);
      }
      i = g.a.a.b.b.a.gL(7);
      AppMethodBeat.o(209522);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TSL.clear();
        this.TTr.clear();
        this.TTs.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(209522);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dmb localdmb = (dmb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209522);
          return -1;
        case 1: 
          localdmb.TTp = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(209522);
          return 0;
        case 2: 
          localdmb.TTq = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(209522);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            erk localerk = new erk();
            if ((localObject != null) && (localObject.length > 0)) {
              localerk.parseFrom((byte[])localObject);
            }
            localdmb.TSL.add(localerk);
            paramInt += 1;
          }
          AppMethodBeat.o(209522);
          return 0;
        case 4: 
          localdmb.TTr.add(Integer.valueOf(((g.a.a.a.a)localObject).abFh.AK()));
          AppMethodBeat.o(209522);
          return 0;
        case 5: 
          localdmb.TTs.add(Integer.valueOf(((g.a.a.a.a)localObject).abFh.AK()));
          AppMethodBeat.o(209522);
          return 0;
        case 6: 
          localdmb.TTt = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(209522);
          return 0;
        }
        localdmb.TTu = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(209522);
        return 0;
      }
      AppMethodBeat.o(209522);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmb
 * JD-Core Version:    0.7.0.1
 */