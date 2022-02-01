package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ecc
  extends com.tencent.mm.bx.a
{
  public String FzJ;
  public String HOA;
  public String HOy;
  public String HOz;
  public String gsM;
  public String gsN;
  public String gsO;
  public String gsP;
  public String nDs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116822);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FzJ != null) {
        paramVarArgs.d(1, this.FzJ);
      }
      if (this.gsN != null) {
        paramVarArgs.d(2, this.gsN);
      }
      if (this.gsM != null) {
        paramVarArgs.d(3, this.gsM);
      }
      if (this.nDs != null) {
        paramVarArgs.d(4, this.nDs);
      }
      if (this.HOy != null) {
        paramVarArgs.d(5, this.HOy);
      }
      if (this.gsO != null) {
        paramVarArgs.d(6, this.gsO);
      }
      if (this.gsP != null) {
        paramVarArgs.d(7, this.gsP);
      }
      if (this.HOz != null) {
        paramVarArgs.d(8, this.HOz);
      }
      if (this.HOA != null) {
        paramVarArgs.d(9, this.HOA);
      }
      AppMethodBeat.o(116822);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FzJ == null) {
        break label702;
      }
    }
    label702:
    for (int i = f.a.a.b.b.a.e(1, this.FzJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.gsN != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.gsN);
      }
      i = paramInt;
      if (this.gsM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gsM);
      }
      paramInt = i;
      if (this.nDs != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nDs);
      }
      i = paramInt;
      if (this.HOy != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HOy);
      }
      paramInt = i;
      if (this.gsO != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.gsO);
      }
      i = paramInt;
      if (this.gsP != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.gsP);
      }
      paramInt = i;
      if (this.HOz != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HOz);
      }
      i = paramInt;
      if (this.HOA != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.HOA);
      }
      AppMethodBeat.o(116822);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(116822);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ecc localecc = (ecc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116822);
          return -1;
        case 1: 
          localecc.FzJ = locala.NPN.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 2: 
          localecc.gsN = locala.NPN.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 3: 
          localecc.gsM = locala.NPN.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 4: 
          localecc.nDs = locala.NPN.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 5: 
          localecc.HOy = locala.NPN.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 6: 
          localecc.gsO = locala.NPN.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 7: 
          localecc.gsP = locala.NPN.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 8: 
          localecc.HOz = locala.NPN.readString();
          AppMethodBeat.o(116822);
          return 0;
        }
        localecc.HOA = locala.NPN.readString();
        AppMethodBeat.o(116822);
        return 0;
      }
      AppMethodBeat.o(116822);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecc
 * JD-Core Version:    0.7.0.1
 */