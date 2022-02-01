package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hz
  extends com.tencent.mm.bx.a
{
  public String CDt;
  public String CDu;
  public String CDv;
  public String CDw;
  public String dca;
  public String szi;
  public String uns;
  public String zWw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91355);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CDt != null) {
        paramVarArgs.d(1, this.CDt);
      }
      if (this.zWw != null) {
        paramVarArgs.d(2, this.zWw);
      }
      if (this.dca != null) {
        paramVarArgs.d(3, this.dca);
      }
      if (this.uns != null) {
        paramVarArgs.d(4, this.uns);
      }
      if (this.szi != null) {
        paramVarArgs.d(5, this.szi);
      }
      if (this.CDu != null) {
        paramVarArgs.d(6, this.CDu);
      }
      if (this.CDv != null) {
        paramVarArgs.d(7, this.CDv);
      }
      if (this.CDw != null) {
        paramVarArgs.d(8, this.CDw);
      }
      AppMethodBeat.o(91355);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CDt == null) {
        break label642;
      }
    }
    label642:
    for (int i = f.a.a.b.b.a.e(1, this.CDt) + 0;; i = 0)
    {
      paramInt = i;
      if (this.zWw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.zWw);
      }
      i = paramInt;
      if (this.dca != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dca);
      }
      paramInt = i;
      if (this.uns != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uns);
      }
      i = paramInt;
      if (this.szi != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.szi);
      }
      paramInt = i;
      if (this.CDu != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CDu);
      }
      i = paramInt;
      if (this.CDv != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CDv);
      }
      paramInt = i;
      if (this.CDw != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CDw);
      }
      AppMethodBeat.o(91355);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91355);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        hz localhz = (hz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91355);
          return -1;
        case 1: 
          localhz.CDt = locala.KhF.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 2: 
          localhz.zWw = locala.KhF.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 3: 
          localhz.dca = locala.KhF.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 4: 
          localhz.uns = locala.KhF.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 5: 
          localhz.szi = locala.KhF.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 6: 
          localhz.CDu = locala.KhF.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 7: 
          localhz.CDv = locala.KhF.readString();
          AppMethodBeat.o(91355);
          return 0;
        }
        localhz.CDw = locala.KhF.readString();
        AppMethodBeat.o(91355);
        return 0;
      }
      AppMethodBeat.o(91355);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hz
 * JD-Core Version:    0.7.0.1
 */