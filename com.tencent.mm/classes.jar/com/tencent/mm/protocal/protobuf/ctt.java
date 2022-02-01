package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ctt
  extends com.tencent.mm.bx.a
{
  public String Eln;
  public String Elo;
  public String Elp;
  public int Elq;
  public String Elr;
  public String Els;
  public String Elt;
  public int Elu;
  public int Elv;
  public int Elw;
  public int Elx;
  public int Ely;
  public int Scene;
  public String Title;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117927);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Eln == null)
      {
        paramVarArgs = new b("Not all required fields were included: PickedWord");
        AppMethodBeat.o(117927);
        throw paramVarArgs;
      }
      if (this.Eln != null) {
        paramVarArgs.d(1, this.Eln);
      }
      if (this.Elo != null) {
        paramVarArgs.d(2, this.Elo);
      }
      if (this.Elp != null) {
        paramVarArgs.d(3, this.Elp);
      }
      paramVarArgs.aR(4, this.Scene);
      paramVarArgs.aR(5, this.Elq);
      if (this.Url != null) {
        paramVarArgs.d(6, this.Url);
      }
      if (this.Title != null) {
        paramVarArgs.d(7, this.Title);
      }
      if (this.Elr != null) {
        paramVarArgs.d(8, this.Elr);
      }
      if (this.Els != null) {
        paramVarArgs.d(9, this.Els);
      }
      if (this.Elt != null) {
        paramVarArgs.d(10, this.Elt);
      }
      paramVarArgs.aR(11, this.Elu);
      paramVarArgs.aR(12, this.Elv);
      paramVarArgs.aR(13, this.Elw);
      paramVarArgs.aR(14, this.Elx);
      paramVarArgs.aR(15, this.Ely);
      AppMethodBeat.o(117927);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Eln == null) {
        break label1018;
      }
    }
    label1018:
    for (int i = f.a.a.b.b.a.e(1, this.Eln) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Elo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Elo);
      }
      i = paramInt;
      if (this.Elp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Elp);
      }
      i = i + f.a.a.b.b.a.bA(4, this.Scene) + f.a.a.b.b.a.bA(5, this.Elq);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Url);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Title);
      }
      paramInt = i;
      if (this.Elr != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Elr);
      }
      i = paramInt;
      if (this.Els != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Els);
      }
      paramInt = i;
      if (this.Elt != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Elt);
      }
      i = f.a.a.b.b.a.bA(11, this.Elu);
      int j = f.a.a.b.b.a.bA(12, this.Elv);
      int k = f.a.a.b.b.a.bA(13, this.Elw);
      int m = f.a.a.b.b.a.bA(14, this.Elx);
      int n = f.a.a.b.b.a.bA(15, this.Ely);
      AppMethodBeat.o(117927);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Eln == null)
        {
          paramVarArgs = new b("Not all required fields were included: PickedWord");
          AppMethodBeat.o(117927);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117927);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ctt localctt = (ctt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117927);
          return -1;
        case 1: 
          localctt.Eln = locala.KhF.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 2: 
          localctt.Elo = locala.KhF.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 3: 
          localctt.Elp = locala.KhF.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 4: 
          localctt.Scene = locala.KhF.xS();
          AppMethodBeat.o(117927);
          return 0;
        case 5: 
          localctt.Elq = locala.KhF.xS();
          AppMethodBeat.o(117927);
          return 0;
        case 6: 
          localctt.Url = locala.KhF.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 7: 
          localctt.Title = locala.KhF.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 8: 
          localctt.Elr = locala.KhF.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 9: 
          localctt.Els = locala.KhF.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 10: 
          localctt.Elt = locala.KhF.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 11: 
          localctt.Elu = locala.KhF.xS();
          AppMethodBeat.o(117927);
          return 0;
        case 12: 
          localctt.Elv = locala.KhF.xS();
          AppMethodBeat.o(117927);
          return 0;
        case 13: 
          localctt.Elw = locala.KhF.xS();
          AppMethodBeat.o(117927);
          return 0;
        case 14: 
          localctt.Elx = locala.KhF.xS();
          AppMethodBeat.o(117927);
          return 0;
        }
        localctt.Ely = locala.KhF.xS();
        AppMethodBeat.o(117927);
        return 0;
      }
      AppMethodBeat.o(117927);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctt
 * JD-Core Version:    0.7.0.1
 */