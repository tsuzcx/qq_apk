package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class jb
  extends com.tencent.mm.cd.a
{
  public String ROV;
  public String ROX;
  public String imei;
  public String nqp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116465);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.imei != null) {
        paramVarArgs.f(1, this.imei);
      }
      if (this.ROV != null) {
        paramVarArgs.f(2, this.ROV);
      }
      if (this.nqp != null) {
        paramVarArgs.f(3, this.nqp);
      }
      if (this.ROX != null) {
        paramVarArgs.f(4, this.ROX);
      }
      AppMethodBeat.o(116465);
      return 0;
    }
    if (paramInt == 1) {
      if (this.imei == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.g(1, this.imei) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ROV != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ROV);
      }
      i = paramInt;
      if (this.nqp != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.nqp);
      }
      paramInt = i;
      if (this.ROX != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.ROX);
      }
      AppMethodBeat.o(116465);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(116465);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        jb localjb = (jb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116465);
          return -1;
        case 1: 
          localjb.imei = locala.abFh.readString();
          AppMethodBeat.o(116465);
          return 0;
        case 2: 
          localjb.ROV = locala.abFh.readString();
          AppMethodBeat.o(116465);
          return 0;
        case 3: 
          localjb.nqp = locala.abFh.readString();
          AppMethodBeat.o(116465);
          return 0;
        }
        localjb.ROX = locala.abFh.readString();
        AppMethodBeat.o(116465);
        return 0;
      }
      AppMethodBeat.o(116465);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jb
 * JD-Core Version:    0.7.0.1
 */