package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dp
  extends com.tencent.mm.bv.a
{
  public String cwc;
  public String fBA;
  public String iFI;
  public String iFM;
  public int position;
  public String username;
  public int wpE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134422);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.fBA != null) {
        paramVarArgs.e(2, this.fBA);
      }
      if (this.iFI != null) {
        paramVarArgs.e(3, this.iFI);
      }
      if (this.cwc != null) {
        paramVarArgs.e(4, this.cwc);
      }
      if (this.iFM != null) {
        paramVarArgs.e(5, this.iFM);
      }
      paramVarArgs.aO(6, this.position);
      paramVarArgs.aO(7, this.wpE);
      AppMethodBeat.o(134422);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label550;
      }
    }
    label550:
    for (int i = e.a.a.b.b.a.f(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fBA != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.fBA);
      }
      i = paramInt;
      if (this.iFI != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.iFI);
      }
      paramInt = i;
      if (this.cwc != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.cwc);
      }
      i = paramInt;
      if (this.iFM != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.iFM);
      }
      paramInt = e.a.a.b.b.a.bl(6, this.position);
      int j = e.a.a.b.b.a.bl(7, this.wpE);
      AppMethodBeat.o(134422);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(134422);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        dp localdp = (dp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(134422);
          return -1;
        case 1: 
          localdp.username = locala.CLY.readString();
          AppMethodBeat.o(134422);
          return 0;
        case 2: 
          localdp.fBA = locala.CLY.readString();
          AppMethodBeat.o(134422);
          return 0;
        case 3: 
          localdp.iFI = locala.CLY.readString();
          AppMethodBeat.o(134422);
          return 0;
        case 4: 
          localdp.cwc = locala.CLY.readString();
          AppMethodBeat.o(134422);
          return 0;
        case 5: 
          localdp.iFM = locala.CLY.readString();
          AppMethodBeat.o(134422);
          return 0;
        case 6: 
          localdp.position = locala.CLY.sl();
          AppMethodBeat.o(134422);
          return 0;
        }
        localdp.wpE = locala.CLY.sl();
        AppMethodBeat.o(134422);
        return 0;
      }
      AppMethodBeat.o(134422);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dp
 * JD-Core Version:    0.7.0.1
 */