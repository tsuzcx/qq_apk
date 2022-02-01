package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ect
  extends com.tencent.mm.bx.a
{
  public int Fws;
  public String Gax;
  public String HOE;
  public String HOF;
  public String HOG;
  public String HOH;
  public String HOI;
  public String HOJ;
  public String ffJ;
  public String nDt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32531);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HOE == null)
      {
        paramVarArgs = new b("Not all required fields were included: LocalNodeId");
        AppMethodBeat.o(32531);
        throw paramVarArgs;
      }
      if (this.HOE != null) {
        paramVarArgs.d(1, this.HOE);
      }
      if (this.nDt != null) {
        paramVarArgs.d(2, this.nDt);
      }
      if (this.HOF != null) {
        paramVarArgs.d(3, this.HOF);
      }
      if (this.ffJ != null) {
        paramVarArgs.d(4, this.ffJ);
      }
      if (this.HOG != null) {
        paramVarArgs.d(5, this.HOG);
      }
      if (this.Gax != null) {
        paramVarArgs.d(6, this.Gax);
      }
      if (this.HOH != null) {
        paramVarArgs.d(7, this.HOH);
      }
      if (this.HOI != null) {
        paramVarArgs.d(8, this.HOI);
      }
      if (this.HOJ != null) {
        paramVarArgs.d(9, this.HOJ);
      }
      paramVarArgs.aS(10, this.Fws);
      AppMethodBeat.o(32531);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HOE == null) {
        break label814;
      }
    }
    label814:
    for (int i = f.a.a.b.b.a.e(1, this.HOE) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nDt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nDt);
      }
      i = paramInt;
      if (this.HOF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HOF);
      }
      paramInt = i;
      if (this.ffJ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ffJ);
      }
      i = paramInt;
      if (this.HOG != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HOG);
      }
      paramInt = i;
      if (this.Gax != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gax);
      }
      i = paramInt;
      if (this.HOH != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HOH);
      }
      paramInt = i;
      if (this.HOI != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HOI);
      }
      i = paramInt;
      if (this.HOJ != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.HOJ);
      }
      paramInt = f.a.a.b.b.a.bz(10, this.Fws);
      AppMethodBeat.o(32531);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HOE == null)
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
        ect localect = (ect)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32531);
          return -1;
        case 1: 
          localect.HOE = locala.NPN.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 2: 
          localect.nDt = locala.NPN.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 3: 
          localect.HOF = locala.NPN.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 4: 
          localect.ffJ = locala.NPN.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 5: 
          localect.HOG = locala.NPN.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 6: 
          localect.Gax = locala.NPN.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 7: 
          localect.HOH = locala.NPN.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 8: 
          localect.HOI = locala.NPN.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 9: 
          localect.HOJ = locala.NPN.readString();
          AppMethodBeat.o(32531);
          return 0;
        }
        localect.Fws = locala.NPN.zc();
        AppMethodBeat.o(32531);
        return 0;
      }
      AppMethodBeat.o(32531);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ect
 * JD-Core Version:    0.7.0.1
 */