package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class duz
  extends com.tencent.mm.bw.a
{
  public String FSh;
  public String Gte;
  public String HaY;
  public String HvQ;
  public long IaK;
  public String IconUrl;
  public String nIN;
  public String uuo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32491);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gte != null) {
        paramVarArgs.d(1, this.Gte);
      }
      if (this.FSh != null) {
        paramVarArgs.d(2, this.FSh);
      }
      if (this.HvQ != null) {
        paramVarArgs.d(3, this.HvQ);
      }
      if (this.uuo != null) {
        paramVarArgs.d(4, this.uuo);
      }
      if (this.nIN != null) {
        paramVarArgs.d(5, this.nIN);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(6, this.IconUrl);
      }
      if (this.HaY != null) {
        paramVarArgs.d(7, this.HaY);
      }
      paramVarArgs.aZ(8, this.IaK);
      AppMethodBeat.o(32491);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gte == null) {
        break label640;
      }
    }
    label640:
    for (int i = f.a.a.b.b.a.e(1, this.Gte) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FSh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FSh);
      }
      i = paramInt;
      if (this.HvQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HvQ);
      }
      paramInt = i;
      if (this.uuo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uuo);
      }
      i = paramInt;
      if (this.nIN != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nIN);
      }
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.IconUrl);
      }
      i = paramInt;
      if (this.HaY != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HaY);
      }
      paramInt = f.a.a.b.b.a.p(8, this.IaK);
      AppMethodBeat.o(32491);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32491);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        duz localduz = (duz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32491);
          return -1;
        case 1: 
          localduz.Gte = locala.OmT.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 2: 
          localduz.FSh = locala.OmT.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 3: 
          localduz.HvQ = locala.OmT.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 4: 
          localduz.uuo = locala.OmT.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 5: 
          localduz.nIN = locala.OmT.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 6: 
          localduz.IconUrl = locala.OmT.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 7: 
          localduz.HaY = locala.OmT.readString();
          AppMethodBeat.o(32491);
          return 0;
        }
        localduz.IaK = locala.OmT.zd();
        AppMethodBeat.o(32491);
        return 0;
      }
      AppMethodBeat.o(32491);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duz
 * JD-Core Version:    0.7.0.1
 */