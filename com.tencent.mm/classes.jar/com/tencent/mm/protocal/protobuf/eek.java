package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class eek
  extends com.tencent.mm.bw.a
{
  public int FOQ;
  public String Gte;
  public String IiL;
  public String IiM;
  public String IiN;
  public String IiO;
  public String IiP;
  public String IiQ;
  public String fhG;
  public String nIO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32531);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.IiL == null)
      {
        paramVarArgs = new b("Not all required fields were included: LocalNodeId");
        AppMethodBeat.o(32531);
        throw paramVarArgs;
      }
      if (this.IiL != null) {
        paramVarArgs.d(1, this.IiL);
      }
      if (this.nIO != null) {
        paramVarArgs.d(2, this.nIO);
      }
      if (this.IiM != null) {
        paramVarArgs.d(3, this.IiM);
      }
      if (this.fhG != null) {
        paramVarArgs.d(4, this.fhG);
      }
      if (this.IiN != null) {
        paramVarArgs.d(5, this.IiN);
      }
      if (this.Gte != null) {
        paramVarArgs.d(6, this.Gte);
      }
      if (this.IiO != null) {
        paramVarArgs.d(7, this.IiO);
      }
      if (this.IiP != null) {
        paramVarArgs.d(8, this.IiP);
      }
      if (this.IiQ != null) {
        paramVarArgs.d(9, this.IiQ);
      }
      paramVarArgs.aS(10, this.FOQ);
      AppMethodBeat.o(32531);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IiL == null) {
        break label814;
      }
    }
    label814:
    for (int i = f.a.a.b.b.a.e(1, this.IiL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nIO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nIO);
      }
      i = paramInt;
      if (this.IiM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.IiM);
      }
      paramInt = i;
      if (this.fhG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.fhG);
      }
      i = paramInt;
      if (this.IiN != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.IiN);
      }
      paramInt = i;
      if (this.Gte != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gte);
      }
      i = paramInt;
      if (this.IiO != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.IiO);
      }
      paramInt = i;
      if (this.IiP != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.IiP);
      }
      i = paramInt;
      if (this.IiQ != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.IiQ);
      }
      paramInt = f.a.a.b.b.a.bz(10, this.FOQ);
      AppMethodBeat.o(32531);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.IiL == null)
        {
          paramVarArgs = new b("Not all required fields were included: LocalNodeId");
          AppMethodBeat.o(32531);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32531);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eek localeek = (eek)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32531);
          return -1;
        case 1: 
          localeek.IiL = locala.OmT.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 2: 
          localeek.nIO = locala.OmT.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 3: 
          localeek.IiM = locala.OmT.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 4: 
          localeek.fhG = locala.OmT.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 5: 
          localeek.IiN = locala.OmT.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 6: 
          localeek.Gte = locala.OmT.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 7: 
          localeek.IiO = locala.OmT.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 8: 
          localeek.IiP = locala.OmT.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 9: 
          localeek.IiQ = locala.OmT.readString();
          AppMethodBeat.o(32531);
          return 0;
        }
        localeek.FOQ = locala.OmT.zc();
        AppMethodBeat.o(32531);
        return 0;
      }
      AppMethodBeat.o(32531);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eek
 * JD-Core Version:    0.7.0.1
 */