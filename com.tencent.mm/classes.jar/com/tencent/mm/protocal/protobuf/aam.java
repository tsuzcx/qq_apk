package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aam
  extends com.tencent.mm.bv.a
{
  public int count;
  public String cwc;
  public String iFH;
  public String iFI;
  public String iFJ;
  public String iFK;
  public int iFL;
  public String iFM;
  public int position;
  public String username;
  public int wRc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134427);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      paramVarArgs.aO(2, this.count);
      if (this.iFH != null) {
        paramVarArgs.e(3, this.iFH);
      }
      if (this.iFI != null) {
        paramVarArgs.e(4, this.iFI);
      }
      paramVarArgs.aO(5, this.wRc);
      if (this.cwc != null) {
        paramVarArgs.e(6, this.cwc);
      }
      if (this.iFJ != null) {
        paramVarArgs.e(7, this.iFJ);
      }
      if (this.iFK != null) {
        paramVarArgs.e(8, this.iFK);
      }
      paramVarArgs.aO(9, this.iFL);
      if (this.iFM != null) {
        paramVarArgs.e(10, this.iFM);
      }
      paramVarArgs.aO(11, this.position);
      AppMethodBeat.o(134427);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label762;
      }
    }
    label762:
    for (paramInt = e.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.count);
      paramInt = i;
      if (this.iFH != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.iFH);
      }
      i = paramInt;
      if (this.iFI != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.iFI);
      }
      i += e.a.a.b.b.a.bl(5, this.wRc);
      paramInt = i;
      if (this.cwc != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.cwc);
      }
      i = paramInt;
      if (this.iFJ != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.iFJ);
      }
      paramInt = i;
      if (this.iFK != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.iFK);
      }
      i = paramInt + e.a.a.b.b.a.bl(9, this.iFL);
      paramInt = i;
      if (this.iFM != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.iFM);
      }
      i = e.a.a.b.b.a.bl(11, this.position);
      AppMethodBeat.o(134427);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(134427);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        aam localaam = (aam)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(134427);
          return -1;
        case 1: 
          localaam.username = locala.CLY.readString();
          AppMethodBeat.o(134427);
          return 0;
        case 2: 
          localaam.count = locala.CLY.sl();
          AppMethodBeat.o(134427);
          return 0;
        case 3: 
          localaam.iFH = locala.CLY.readString();
          AppMethodBeat.o(134427);
          return 0;
        case 4: 
          localaam.iFI = locala.CLY.readString();
          AppMethodBeat.o(134427);
          return 0;
        case 5: 
          localaam.wRc = locala.CLY.sl();
          AppMethodBeat.o(134427);
          return 0;
        case 6: 
          localaam.cwc = locala.CLY.readString();
          AppMethodBeat.o(134427);
          return 0;
        case 7: 
          localaam.iFJ = locala.CLY.readString();
          AppMethodBeat.o(134427);
          return 0;
        case 8: 
          localaam.iFK = locala.CLY.readString();
          AppMethodBeat.o(134427);
          return 0;
        case 9: 
          localaam.iFL = locala.CLY.sl();
          AppMethodBeat.o(134427);
          return 0;
        case 10: 
          localaam.iFM = locala.CLY.readString();
          AppMethodBeat.o(134427);
          return 0;
        }
        localaam.position = locala.CLY.sl();
        AppMethodBeat.o(134427);
        return 0;
      }
      AppMethodBeat.o(134427);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aam
 * JD-Core Version:    0.7.0.1
 */