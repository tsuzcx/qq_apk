package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cba
  extends com.tencent.mm.bx.a
{
  public String DXn;
  public String doh;
  public int type;
  public String zHs;
  public String zHt;
  public String zPB;
  public String zVl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91620);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.doh != null) {
        paramVarArgs.d(1, this.doh);
      }
      paramVarArgs.aR(2, this.type);
      if (this.zVl != null) {
        paramVarArgs.d(3, this.zVl);
      }
      if (this.zHs != null) {
        paramVarArgs.d(4, this.zHs);
      }
      if (this.zHt != null) {
        paramVarArgs.d(5, this.zHt);
      }
      if (this.DXn != null) {
        paramVarArgs.d(6, this.DXn);
      }
      if (this.zPB != null) {
        paramVarArgs.d(7, this.zPB);
      }
      AppMethodBeat.o(91620);
      return 0;
    }
    if (paramInt == 1) {
      if (this.doh == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.b.b.a.e(1, this.doh) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.type);
      paramInt = i;
      if (this.zVl != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.zVl);
      }
      i = paramInt;
      if (this.zHs != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.zHs);
      }
      paramInt = i;
      if (this.zHt != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.zHt);
      }
      i = paramInt;
      if (this.DXn != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DXn);
      }
      paramInt = i;
      if (this.zPB != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.zPB);
      }
      AppMethodBeat.o(91620);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91620);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cba localcba = (cba)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91620);
          return -1;
        case 1: 
          localcba.doh = locala.KhF.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 2: 
          localcba.type = locala.KhF.xS();
          AppMethodBeat.o(91620);
          return 0;
        case 3: 
          localcba.zVl = locala.KhF.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 4: 
          localcba.zHs = locala.KhF.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 5: 
          localcba.zHt = locala.KhF.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 6: 
          localcba.DXn = locala.KhF.readString();
          AppMethodBeat.o(91620);
          return 0;
        }
        localcba.zPB = locala.KhF.readString();
        AppMethodBeat.o(91620);
        return 0;
      }
      AppMethodBeat.o(91620);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cba
 * JD-Core Version:    0.7.0.1
 */