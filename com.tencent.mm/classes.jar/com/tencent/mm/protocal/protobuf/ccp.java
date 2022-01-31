package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccp
  extends com.tencent.mm.bv.a
{
  public int actionType;
  public String cDz;
  public String cyA;
  public String id;
  public String jjP;
  public String title;
  public String url;
  public long xNd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(55701);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.e(1, this.id);
      }
      if (this.cyA != null) {
        paramVarArgs.e(2, this.cyA);
      }
      paramVarArgs.am(3, this.xNd);
      paramVarArgs.aO(4, this.actionType);
      if (this.url != null) {
        paramVarArgs.e(5, this.url);
      }
      if (this.title != null) {
        paramVarArgs.e(6, this.title);
      }
      if (this.jjP != null) {
        paramVarArgs.e(7, this.jjP);
      }
      if (this.cDz != null) {
        paramVarArgs.e(8, this.cDz);
      }
      AppMethodBeat.o(55701);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label606;
      }
    }
    label606:
    for (paramInt = e.a.a.b.b.a.f(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.cyA != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.cyA);
      }
      i = i + e.a.a.b.b.a.p(3, this.xNd) + e.a.a.b.b.a.bl(4, this.actionType);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.url);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.title);
      }
      paramInt = i;
      if (this.jjP != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.jjP);
      }
      i = paramInt;
      if (this.cDz != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.cDz);
      }
      AppMethodBeat.o(55701);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(55701);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ccp localccp = (ccp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(55701);
          return -1;
        case 1: 
          localccp.id = locala.CLY.readString();
          AppMethodBeat.o(55701);
          return 0;
        case 2: 
          localccp.cyA = locala.CLY.readString();
          AppMethodBeat.o(55701);
          return 0;
        case 3: 
          localccp.xNd = locala.CLY.sm();
          AppMethodBeat.o(55701);
          return 0;
        case 4: 
          localccp.actionType = locala.CLY.sl();
          AppMethodBeat.o(55701);
          return 0;
        case 5: 
          localccp.url = locala.CLY.readString();
          AppMethodBeat.o(55701);
          return 0;
        case 6: 
          localccp.title = locala.CLY.readString();
          AppMethodBeat.o(55701);
          return 0;
        case 7: 
          localccp.jjP = locala.CLY.readString();
          AppMethodBeat.o(55701);
          return 0;
        }
        localccp.cDz = locala.CLY.readString();
        AppMethodBeat.o(55701);
        return 0;
      }
      AppMethodBeat.o(55701);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccp
 * JD-Core Version:    0.7.0.1
 */