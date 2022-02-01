package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aaa
  extends com.tencent.mm.bx.a
{
  public String ZiA;
  public int ZiB;
  public String Ziv;
  public String Ziw;
  public String Zix;
  public int Ziy;
  public int Ziz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127444);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Ziv != null) {
        paramVarArgs.g(1, this.Ziv);
      }
      if (this.Ziw != null) {
        paramVarArgs.g(2, this.Ziw);
      }
      if (this.Zix != null) {
        paramVarArgs.g(3, this.Zix);
      }
      paramVarArgs.bS(4, this.Ziy);
      paramVarArgs.bS(5, this.Ziz);
      if (this.ZiA != null) {
        paramVarArgs.g(6, this.ZiA);
      }
      paramVarArgs.bS(7, this.ZiB);
      AppMethodBeat.o(127444);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ziv == null) {
        break label526;
      }
    }
    label526:
    for (int i = i.a.a.b.b.a.h(1, this.Ziv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ziw != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Ziw);
      }
      i = paramInt;
      if (this.Zix != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Zix);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.Ziy) + i.a.a.b.b.a.cJ(5, this.Ziz);
      paramInt = i;
      if (this.ZiA != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZiA);
      }
      i = i.a.a.b.b.a.cJ(7, this.ZiB);
      AppMethodBeat.o(127444);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(127444);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        aaa localaaa = (aaa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127444);
          return -1;
        case 1: 
          localaaa.Ziv = locala.ajGk.readString();
          AppMethodBeat.o(127444);
          return 0;
        case 2: 
          localaaa.Ziw = locala.ajGk.readString();
          AppMethodBeat.o(127444);
          return 0;
        case 3: 
          localaaa.Zix = locala.ajGk.readString();
          AppMethodBeat.o(127444);
          return 0;
        case 4: 
          localaaa.Ziy = locala.ajGk.aar();
          AppMethodBeat.o(127444);
          return 0;
        case 5: 
          localaaa.Ziz = locala.ajGk.aar();
          AppMethodBeat.o(127444);
          return 0;
        case 6: 
          localaaa.ZiA = locala.ajGk.readString();
          AppMethodBeat.o(127444);
          return 0;
        }
        localaaa.ZiB = locala.ajGk.aar();
        AppMethodBeat.o(127444);
        return 0;
      }
      AppMethodBeat.o(127444);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aaa
 * JD-Core Version:    0.7.0.1
 */