package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apl
  extends com.tencent.mm.bw.a
{
  public String Ajr;
  public int Ajt;
  public String GGA;
  public float dBu;
  public float dzE;
  public String eRf;
  public String eRg;
  public String iqx;
  public String jGd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169004);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.y(1, this.dBu);
      paramVarArgs.y(2, this.dzE);
      if (this.eRg != null) {
        paramVarArgs.d(3, this.eRg);
      }
      if (this.jGd != null) {
        paramVarArgs.d(4, this.jGd);
      }
      if (this.Ajr != null) {
        paramVarArgs.d(5, this.Ajr);
      }
      if (this.GGA != null) {
        paramVarArgs.d(6, this.GGA);
      }
      paramVarArgs.aS(7, this.Ajt);
      if (this.eRf != null) {
        paramVarArgs.d(8, this.eRf);
      }
      if (this.iqx != null) {
        paramVarArgs.d(9, this.iqx);
      }
      AppMethodBeat.o(169004);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.amE(1) + 0 + f.a.a.b.b.a.amE(2);
      paramInt = i;
      if (this.eRg != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.eRg);
      }
      i = paramInt;
      if (this.jGd != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.jGd);
      }
      paramInt = i;
      if (this.Ajr != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Ajr);
      }
      i = paramInt;
      if (this.GGA != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GGA);
      }
      i += f.a.a.b.b.a.bz(7, this.Ajt);
      paramInt = i;
      if (this.eRf != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.eRf);
      }
      i = paramInt;
      if (this.iqx != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.iqx);
      }
      AppMethodBeat.o(169004);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(169004);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      apl localapl = (apl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169004);
        return -1;
      case 1: 
        localapl.dBu = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(169004);
        return 0;
      case 2: 
        localapl.dzE = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(169004);
        return 0;
      case 3: 
        localapl.eRg = locala.OmT.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 4: 
        localapl.jGd = locala.OmT.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 5: 
        localapl.Ajr = locala.OmT.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 6: 
        localapl.GGA = locala.OmT.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 7: 
        localapl.Ajt = locala.OmT.zc();
        AppMethodBeat.o(169004);
        return 0;
      case 8: 
        localapl.eRf = locala.OmT.readString();
        AppMethodBeat.o(169004);
        return 0;
      }
      localapl.iqx = locala.OmT.readString();
      AppMethodBeat.o(169004);
      return 0;
    }
    AppMethodBeat.o(169004);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apl
 * JD-Core Version:    0.7.0.1
 */