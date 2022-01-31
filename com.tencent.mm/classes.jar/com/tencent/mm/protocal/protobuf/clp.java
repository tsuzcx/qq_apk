package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class clp
  extends com.tencent.mm.bv.a
{
  public String nLq;
  public String poq;
  public String qfY;
  public String qgu;
  public String qgv;
  public String qgw;
  public String qgx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48974);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.qgu != null) {
        paramVarArgs.e(1, this.qgu);
      }
      if (this.qgv != null) {
        paramVarArgs.e(2, this.qgv);
      }
      if (this.qfY != null) {
        paramVarArgs.e(3, this.qfY);
      }
      if (this.nLq != null) {
        paramVarArgs.e(4, this.nLq);
      }
      if (this.poq != null) {
        paramVarArgs.e(5, this.poq);
      }
      if (this.qgw != null) {
        paramVarArgs.e(6, this.qgw);
      }
      if (this.qgx != null) {
        paramVarArgs.e(7, this.qgx);
      }
      AppMethodBeat.o(48974);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qgu == null) {
        break label578;
      }
    }
    label578:
    for (int i = e.a.a.b.b.a.f(1, this.qgu) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qgv != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.qgv);
      }
      i = paramInt;
      if (this.qfY != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.qfY);
      }
      paramInt = i;
      if (this.nLq != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.nLq);
      }
      i = paramInt;
      if (this.poq != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.poq);
      }
      paramInt = i;
      if (this.qgw != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.qgw);
      }
      i = paramInt;
      if (this.qgx != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.qgx);
      }
      AppMethodBeat.o(48974);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48974);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        clp localclp = (clp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(48974);
          return -1;
        case 1: 
          localclp.qgu = locala.CLY.readString();
          AppMethodBeat.o(48974);
          return 0;
        case 2: 
          localclp.qgv = locala.CLY.readString();
          AppMethodBeat.o(48974);
          return 0;
        case 3: 
          localclp.qfY = locala.CLY.readString();
          AppMethodBeat.o(48974);
          return 0;
        case 4: 
          localclp.nLq = locala.CLY.readString();
          AppMethodBeat.o(48974);
          return 0;
        case 5: 
          localclp.poq = locala.CLY.readString();
          AppMethodBeat.o(48974);
          return 0;
        case 6: 
          localclp.qgw = locala.CLY.readString();
          AppMethodBeat.o(48974);
          return 0;
        }
        localclp.qgx = locala.CLY.readString();
        AppMethodBeat.o(48974);
        return 0;
      }
      AppMethodBeat.o(48974);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clp
 * JD-Core Version:    0.7.0.1
 */