package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gin
  extends com.tencent.mm.bx.a
{
  public String VHT;
  public String VmH;
  public String Zvp;
  public String abkC;
  public String aceV;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258555);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.aceV != null) {
        paramVarArgs.g(2, this.aceV);
      }
      if (this.VHT != null) {
        paramVarArgs.g(3, this.VHT);
      }
      if (this.Zvp != null) {
        paramVarArgs.g(4, this.Zvp);
      }
      if (this.VmH != null) {
        paramVarArgs.g(5, this.VmH);
      }
      if (this.abkC != null) {
        paramVarArgs.g(6, this.abkC);
      }
      AppMethodBeat.o(258555);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label514;
      }
    }
    label514:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aceV != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aceV);
      }
      i = paramInt;
      if (this.VHT != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.VHT);
      }
      paramInt = i;
      if (this.Zvp != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zvp);
      }
      i = paramInt;
      if (this.VmH != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.VmH);
      }
      paramInt = i;
      if (this.abkC != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abkC);
      }
      AppMethodBeat.o(258555);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258555);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gin localgin = (gin)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258555);
          return -1;
        case 1: 
          localgin.title = locala.ajGk.readString();
          AppMethodBeat.o(258555);
          return 0;
        case 2: 
          localgin.aceV = locala.ajGk.readString();
          AppMethodBeat.o(258555);
          return 0;
        case 3: 
          localgin.VHT = locala.ajGk.readString();
          AppMethodBeat.o(258555);
          return 0;
        case 4: 
          localgin.Zvp = locala.ajGk.readString();
          AppMethodBeat.o(258555);
          return 0;
        case 5: 
          localgin.VmH = locala.ajGk.readString();
          AppMethodBeat.o(258555);
          return 0;
        }
        localgin.abkC = locala.ajGk.readString();
        AppMethodBeat.o(258555);
        return 0;
      }
      AppMethodBeat.o(258555);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gin
 * JD-Core Version:    0.7.0.1
 */