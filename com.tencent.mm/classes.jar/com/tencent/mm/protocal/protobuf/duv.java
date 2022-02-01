package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class duv
  extends com.tencent.mm.bw.a
{
  public String FNF;
  public String Gtk;
  public String IaI;
  public String jga;
  public String nIJ;
  public String nJO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117939);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nIJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(117939);
        throw paramVarArgs;
      }
      if (this.IaI == null)
      {
        paramVarArgs = new b("Not all required fields were included: MatchWord");
        AppMethodBeat.o(117939);
        throw paramVarArgs;
      }
      if (this.nIJ != null) {
        paramVarArgs.d(1, this.nIJ);
      }
      if (this.IaI != null) {
        paramVarArgs.d(2, this.IaI);
      }
      if (this.nJO != null) {
        paramVarArgs.d(3, this.nJO);
      }
      if (this.Gtk != null) {
        paramVarArgs.d(4, this.Gtk);
      }
      if (this.jga != null) {
        paramVarArgs.d(5, this.jga);
      }
      if (this.FNF != null) {
        paramVarArgs.d(6, this.FNF);
      }
      AppMethodBeat.o(117939);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nIJ == null) {
        break label614;
      }
    }
    label614:
    for (int i = f.a.a.b.b.a.e(1, this.nIJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IaI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.IaI);
      }
      i = paramInt;
      if (this.nJO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nJO);
      }
      paramInt = i;
      if (this.Gtk != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gtk);
      }
      i = paramInt;
      if (this.jga != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.jga);
      }
      paramInt = i;
      if (this.FNF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FNF);
      }
      AppMethodBeat.o(117939);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.nIJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(117939);
          throw paramVarArgs;
        }
        if (this.IaI == null)
        {
          paramVarArgs = new b("Not all required fields were included: MatchWord");
          AppMethodBeat.o(117939);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117939);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        duv localduv = (duv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117939);
          return -1;
        case 1: 
          localduv.nIJ = locala.OmT.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 2: 
          localduv.IaI = locala.OmT.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 3: 
          localduv.nJO = locala.OmT.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 4: 
          localduv.Gtk = locala.OmT.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 5: 
          localduv.jga = locala.OmT.readString();
          AppMethodBeat.o(117939);
          return 0;
        }
        localduv.FNF = locala.OmT.readString();
        AppMethodBeat.o(117939);
        return 0;
      }
      AppMethodBeat.o(117939);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duv
 * JD-Core Version:    0.7.0.1
 */