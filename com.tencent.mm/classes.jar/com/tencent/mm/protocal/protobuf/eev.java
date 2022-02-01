package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eev
  extends com.tencent.mm.bw.a
{
  public String HGP;
  public int HKR;
  public com.tencent.mm.bw.b IiK;
  public boolean Ijb;
  public boolean Ijc;
  public boolean Ijd;
  public String Title;
  public String hFS;
  public int uvE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32545);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HGP == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.Title == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Title");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.hFS == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.uvE);
      if (this.HGP != null) {
        paramVarArgs.d(2, this.HGP);
      }
      if (this.Title != null) {
        paramVarArgs.d(3, this.Title);
      }
      if (this.hFS != null) {
        paramVarArgs.d(4, this.hFS);
      }
      paramVarArgs.aS(5, this.HKR);
      if (this.IiK != null) {
        paramVarArgs.c(6, this.IiK);
      }
      paramVarArgs.bC(7, this.Ijb);
      paramVarArgs.bC(8, this.Ijc);
      paramVarArgs.bC(9, this.Ijd);
      AppMethodBeat.o(32545);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.uvE) + 0;
      paramInt = i;
      if (this.HGP != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HGP);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Title);
      }
      paramInt = i;
      if (this.hFS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hFS);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.HKR);
      paramInt = i;
      if (this.IiK != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.IiK);
      }
      i = f.a.a.b.b.a.amF(7);
      int j = f.a.a.b.b.a.amF(8);
      int k = f.a.a.b.b.a.amF(9);
      AppMethodBeat.o(32545);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.HGP == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.Title == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Title");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      if (this.hFS == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32545);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32545);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eev localeev = (eev)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32545);
        return -1;
      case 1: 
        localeev.uvE = locala.OmT.zc();
        AppMethodBeat.o(32545);
        return 0;
      case 2: 
        localeev.HGP = locala.OmT.readString();
        AppMethodBeat.o(32545);
        return 0;
      case 3: 
        localeev.Title = locala.OmT.readString();
        AppMethodBeat.o(32545);
        return 0;
      case 4: 
        localeev.hFS = locala.OmT.readString();
        AppMethodBeat.o(32545);
        return 0;
      case 5: 
        localeev.HKR = locala.OmT.zc();
        AppMethodBeat.o(32545);
        return 0;
      case 6: 
        localeev.IiK = locala.OmT.gCk();
        AppMethodBeat.o(32545);
        return 0;
      case 7: 
        localeev.Ijb = locala.OmT.gvY();
        AppMethodBeat.o(32545);
        return 0;
      case 8: 
        localeev.Ijc = locala.OmT.gvY();
        AppMethodBeat.o(32545);
        return 0;
      }
      localeev.Ijd = locala.OmT.gvY();
      AppMethodBeat.o(32545);
      return 0;
    }
    AppMethodBeat.o(32545);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eev
 * JD-Core Version:    0.7.0.1
 */