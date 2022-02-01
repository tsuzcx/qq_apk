package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apc
  extends com.tencent.mm.bx.a
{
  public String Zoh;
  public String Zoi;
  public String Zoj;
  public String Zok;
  public String Zol;
  public String Zwf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259530);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zwf != null) {
        paramVarArgs.g(1, this.Zwf);
      }
      if (this.Zoh != null) {
        paramVarArgs.g(2, this.Zoh);
      }
      if (this.Zoi != null) {
        paramVarArgs.g(3, this.Zoi);
      }
      if (this.Zoj != null) {
        paramVarArgs.g(4, this.Zoj);
      }
      if (this.Zok != null) {
        paramVarArgs.g(5, this.Zok);
      }
      if (this.Zol != null) {
        paramVarArgs.g(6, this.Zol);
      }
      AppMethodBeat.o(259530);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Zwf == null) {
        break label514;
      }
    }
    label514:
    for (int i = i.a.a.b.b.a.h(1, this.Zwf) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Zoh != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Zoh);
      }
      i = paramInt;
      if (this.Zoi != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Zoi);
      }
      paramInt = i;
      if (this.Zoj != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zoj);
      }
      i = paramInt;
      if (this.Zok != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.Zok);
      }
      paramInt = i;
      if (this.Zol != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Zol);
      }
      AppMethodBeat.o(259530);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259530);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        apc localapc = (apc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259530);
          return -1;
        case 1: 
          localapc.Zwf = locala.ajGk.readString();
          AppMethodBeat.o(259530);
          return 0;
        case 2: 
          localapc.Zoh = locala.ajGk.readString();
          AppMethodBeat.o(259530);
          return 0;
        case 3: 
          localapc.Zoi = locala.ajGk.readString();
          AppMethodBeat.o(259530);
          return 0;
        case 4: 
          localapc.Zoj = locala.ajGk.readString();
          AppMethodBeat.o(259530);
          return 0;
        case 5: 
          localapc.Zok = locala.ajGk.readString();
          AppMethodBeat.o(259530);
          return 0;
        }
        localapc.Zol = locala.ajGk.readString();
        AppMethodBeat.o(259530);
        return 0;
      }
      AppMethodBeat.o(259530);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apc
 * JD-Core Version:    0.7.0.1
 */