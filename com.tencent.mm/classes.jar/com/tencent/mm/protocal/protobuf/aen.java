package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aen
  extends com.tencent.mm.bw.a
{
  public int Exl;
  public int Exm;
  public String Exn;
  public String dlQ;
  public String oGN;
  public int tfk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(179487);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Exl);
      paramVarArgs.aR(2, this.Exm);
      paramVarArgs.aR(3, this.tfk);
      if (this.dlQ != null) {
        paramVarArgs.d(4, this.dlQ);
      }
      if (this.oGN != null) {
        paramVarArgs.d(5, this.oGN);
      }
      if (this.Exn != null) {
        paramVarArgs.d(6, this.Exn);
      }
      AppMethodBeat.o(179487);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.Exl) + 0 + f.a.a.b.b.a.bx(2, this.Exm) + f.a.a.b.b.a.bx(3, this.tfk);
      paramInt = i;
      if (this.dlQ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dlQ);
      }
      i = paramInt;
      if (this.oGN != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.oGN);
      }
      paramInt = i;
      if (this.Exn != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Exn);
      }
      AppMethodBeat.o(179487);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(179487);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aen localaen = (aen)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(179487);
        return -1;
      case 1: 
        localaen.Exl = locala.LVo.xF();
        AppMethodBeat.o(179487);
        return 0;
      case 2: 
        localaen.Exm = locala.LVo.xF();
        AppMethodBeat.o(179487);
        return 0;
      case 3: 
        localaen.tfk = locala.LVo.xF();
        AppMethodBeat.o(179487);
        return 0;
      case 4: 
        localaen.dlQ = locala.LVo.readString();
        AppMethodBeat.o(179487);
        return 0;
      case 5: 
        localaen.oGN = locala.LVo.readString();
        AppMethodBeat.o(179487);
        return 0;
      }
      localaen.Exn = locala.LVo.readString();
      AppMethodBeat.o(179487);
      return 0;
    }
    AppMethodBeat.o(179487);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aen
 * JD-Core Version:    0.7.0.1
 */