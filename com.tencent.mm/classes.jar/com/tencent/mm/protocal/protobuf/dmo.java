package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dmo
  extends com.tencent.mm.bw.a
{
  public String FZa;
  public LinkedList<String> GaF;
  public int Gan;
  public long Gcv;
  public String Gyt;
  public String HTO;
  
  public dmo()
  {
    AppMethodBeat.i(124560);
    this.GaF = new LinkedList();
    AppMethodBeat.o(124560);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124561);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.Gcv);
      if (this.FZa != null) {
        paramVarArgs.d(2, this.FZa);
      }
      paramVarArgs.e(3, 1, this.GaF);
      if (this.Gyt != null) {
        paramVarArgs.d(4, this.Gyt);
      }
      if (this.HTO != null) {
        paramVarArgs.d(5, this.HTO);
      }
      paramVarArgs.aS(6, this.Gan);
      AppMethodBeat.o(124561);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.Gcv) + 0;
      paramInt = i;
      if (this.FZa != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FZa);
      }
      i = paramInt + f.a.a.a.c(3, 1, this.GaF);
      paramInt = i;
      if (this.Gyt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gyt);
      }
      i = paramInt;
      if (this.HTO != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HTO);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.Gan);
      AppMethodBeat.o(124561);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GaF.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(124561);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dmo localdmo = (dmo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124561);
        return -1;
      case 1: 
        localdmo.Gcv = locala.OmT.zd();
        AppMethodBeat.o(124561);
        return 0;
      case 2: 
        localdmo.FZa = locala.OmT.readString();
        AppMethodBeat.o(124561);
        return 0;
      case 3: 
        localdmo.GaF.add(locala.OmT.readString());
        AppMethodBeat.o(124561);
        return 0;
      case 4: 
        localdmo.Gyt = locala.OmT.readString();
        AppMethodBeat.o(124561);
        return 0;
      case 5: 
        localdmo.HTO = locala.OmT.readString();
        AppMethodBeat.o(124561);
        return 0;
      }
      localdmo.Gan = locala.OmT.zc();
      AppMethodBeat.o(124561);
      return 0;
    }
    AppMethodBeat.o(124561);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmo
 * JD-Core Version:    0.7.0.1
 */