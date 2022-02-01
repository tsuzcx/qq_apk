package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bgt
  extends com.tencent.mm.bx.a
{
  public String CCm;
  public String COP;
  public String DEJ;
  public String Md5;
  public String Name;
  public String Type;
  public String Url;
  public int mBC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32325);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Type != null) {
        paramVarArgs.d(1, this.Type);
      }
      if (this.Name != null) {
        paramVarArgs.d(2, this.Name);
      }
      paramVarArgs.aR(3, this.mBC);
      if (this.Md5 != null) {
        paramVarArgs.d(4, this.Md5);
      }
      if (this.CCm != null) {
        paramVarArgs.d(5, this.CCm);
      }
      if (this.COP != null) {
        paramVarArgs.d(6, this.COP);
      }
      if (this.Url != null) {
        paramVarArgs.d(7, this.Url);
      }
      if (this.DEJ != null) {
        paramVarArgs.d(8, this.DEJ);
      }
      AppMethodBeat.o(32325);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Type == null) {
        break label640;
      }
    }
    label640:
    for (paramInt = f.a.a.b.b.a.e(1, this.Type) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Name != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Name);
      }
      i += f.a.a.b.b.a.bA(3, this.mBC);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Md5);
      }
      i = paramInt;
      if (this.CCm != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CCm);
      }
      paramInt = i;
      if (this.COP != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.COP);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Url);
      }
      paramInt = i;
      if (this.DEJ != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DEJ);
      }
      AppMethodBeat.o(32325);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32325);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bgt localbgt = (bgt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32325);
          return -1;
        case 1: 
          localbgt.Type = locala.KhF.readString();
          AppMethodBeat.o(32325);
          return 0;
        case 2: 
          localbgt.Name = locala.KhF.readString();
          AppMethodBeat.o(32325);
          return 0;
        case 3: 
          localbgt.mBC = locala.KhF.xS();
          AppMethodBeat.o(32325);
          return 0;
        case 4: 
          localbgt.Md5 = locala.KhF.readString();
          AppMethodBeat.o(32325);
          return 0;
        case 5: 
          localbgt.CCm = locala.KhF.readString();
          AppMethodBeat.o(32325);
          return 0;
        case 6: 
          localbgt.COP = locala.KhF.readString();
          AppMethodBeat.o(32325);
          return 0;
        case 7: 
          localbgt.Url = locala.KhF.readString();
          AppMethodBeat.o(32325);
          return 0;
        }
        localbgt.DEJ = locala.KhF.readString();
        AppMethodBeat.o(32325);
        return 0;
      }
      AppMethodBeat.o(32325);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgt
 * JD-Core Version:    0.7.0.1
 */