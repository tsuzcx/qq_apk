package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cho
  extends com.tencent.mm.bw.a
{
  public String LRO;
  public String Lir;
  public String Lis;
  public String UserName;
  public String oUJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138178);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.e(1, this.UserName);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(2, this.oUJ);
      }
      if (this.Lir != null) {
        paramVarArgs.e(3, this.Lir);
      }
      if (this.Lis != null) {
        paramVarArgs.e(4, this.Lis);
      }
      if (this.LRO != null) {
        paramVarArgs.e(5, this.LRO);
      }
      AppMethodBeat.o(138178);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label454;
      }
    }
    label454:
    for (int i = g.a.a.b.b.a.f(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oUJ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.oUJ);
      }
      i = paramInt;
      if (this.Lir != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Lir);
      }
      paramInt = i;
      if (this.Lis != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Lis);
      }
      i = paramInt;
      if (this.LRO != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LRO);
      }
      AppMethodBeat.o(138178);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(138178);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cho localcho = (cho)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138178);
          return -1;
        case 1: 
          localcho.UserName = locala.UbS.readString();
          AppMethodBeat.o(138178);
          return 0;
        case 2: 
          localcho.oUJ = locala.UbS.readString();
          AppMethodBeat.o(138178);
          return 0;
        case 3: 
          localcho.Lir = locala.UbS.readString();
          AppMethodBeat.o(138178);
          return 0;
        case 4: 
          localcho.Lis = locala.UbS.readString();
          AppMethodBeat.o(138178);
          return 0;
        }
        localcho.LRO = locala.UbS.readString();
        AppMethodBeat.o(138178);
        return 0;
      }
      AppMethodBeat.o(138178);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cho
 * JD-Core Version:    0.7.0.1
 */