package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class daw
  extends com.tencent.mm.bv.a
{
  public String Username;
  public String nuv;
  public String woB;
  public String woO;
  public int wwX;
  public int yhf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151933);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.e(1, this.Username);
      }
      if (this.nuv != null) {
        paramVarArgs.e(2, this.nuv);
      }
      paramVarArgs.aO(3, this.wwX);
      if (this.woB != null) {
        paramVarArgs.e(4, this.woB);
      }
      paramVarArgs.aO(5, this.yhf);
      if (this.woO != null) {
        paramVarArgs.e(6, this.woO);
      }
      AppMethodBeat.o(151933);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label486;
      }
    }
    label486:
    for (paramInt = e.a.a.b.b.a.f(1, this.Username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nuv != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.nuv);
      }
      i += e.a.a.b.b.a.bl(3, this.wwX);
      paramInt = i;
      if (this.woB != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.woB);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.yhf);
      paramInt = i;
      if (this.woO != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.woO);
      }
      AppMethodBeat.o(151933);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(151933);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        daw localdaw = (daw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(151933);
          return -1;
        case 1: 
          localdaw.Username = locala.CLY.readString();
          AppMethodBeat.o(151933);
          return 0;
        case 2: 
          localdaw.nuv = locala.CLY.readString();
          AppMethodBeat.o(151933);
          return 0;
        case 3: 
          localdaw.wwX = locala.CLY.sl();
          AppMethodBeat.o(151933);
          return 0;
        case 4: 
          localdaw.woB = locala.CLY.readString();
          AppMethodBeat.o(151933);
          return 0;
        case 5: 
          localdaw.yhf = locala.CLY.sl();
          AppMethodBeat.o(151933);
          return 0;
        }
        localdaw.woO = locala.CLY.readString();
        AppMethodBeat.o(151933);
        return 0;
      }
      AppMethodBeat.o(151933);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.daw
 * JD-Core Version:    0.7.0.1
 */