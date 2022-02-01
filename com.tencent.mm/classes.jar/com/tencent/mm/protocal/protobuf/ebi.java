package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebi
  extends com.tencent.mm.bx.a
{
  public String LAb;
  public String LAc;
  public String LAd;
  public String LAe;
  public String LAf;
  public String LAg;
  public String LAh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203892);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.LAb != null) {
        paramVarArgs.d(1, this.LAb);
      }
      if (this.LAc != null) {
        paramVarArgs.d(2, this.LAc);
      }
      if (this.LAd != null) {
        paramVarArgs.d(3, this.LAd);
      }
      if (this.LAe != null) {
        paramVarArgs.d(4, this.LAe);
      }
      if (this.LAf != null) {
        paramVarArgs.d(5, this.LAf);
      }
      if (this.LAg != null) {
        paramVarArgs.d(6, this.LAg);
      }
      if (this.LAh != null) {
        paramVarArgs.d(7, this.LAh);
      }
      AppMethodBeat.o(203892);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LAb == null) {
        break label578;
      }
    }
    label578:
    for (int i = f.a.a.b.b.a.e(1, this.LAb) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LAc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.LAc);
      }
      i = paramInt;
      if (this.LAd != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.LAd);
      }
      paramInt = i;
      if (this.LAe != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.LAe);
      }
      i = paramInt;
      if (this.LAf != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.LAf);
      }
      paramInt = i;
      if (this.LAg != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.LAg);
      }
      i = paramInt;
      if (this.LAh != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.LAh);
      }
      AppMethodBeat.o(203892);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(203892);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ebi localebi = (ebi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(203892);
          return -1;
        case 1: 
          localebi.LAb = locala.KhF.readString();
          AppMethodBeat.o(203892);
          return 0;
        case 2: 
          localebi.LAc = locala.KhF.readString();
          AppMethodBeat.o(203892);
          return 0;
        case 3: 
          localebi.LAd = locala.KhF.readString();
          AppMethodBeat.o(203892);
          return 0;
        case 4: 
          localebi.LAe = locala.KhF.readString();
          AppMethodBeat.o(203892);
          return 0;
        case 5: 
          localebi.LAf = locala.KhF.readString();
          AppMethodBeat.o(203892);
          return 0;
        case 6: 
          localebi.LAg = locala.KhF.readString();
          AppMethodBeat.o(203892);
          return 0;
        }
        localebi.LAh = locala.KhF.readString();
        AppMethodBeat.o(203892);
        return 0;
      }
      AppMethodBeat.o(203892);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebi
 * JD-Core Version:    0.7.0.1
 */