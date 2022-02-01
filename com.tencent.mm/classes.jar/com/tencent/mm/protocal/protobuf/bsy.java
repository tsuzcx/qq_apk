package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bsy
  extends com.tencent.mm.bx.a
{
  public String CRC;
  public int DPY;
  public int DPZ;
  public String DcE;
  public String desc;
  public String dub;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91555);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.DcE != null) {
        paramVarArgs.d(3, this.DcE);
      }
      paramVarArgs.aR(4, this.DPY);
      paramVarArgs.aR(5, this.DPZ);
      if (this.CRC != null) {
        paramVarArgs.d(6, this.CRC);
      }
      if (this.dub != null) {
        paramVarArgs.d(7, this.dub);
      }
      AppMethodBeat.o(91555);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label546;
      }
    }
    label546:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.DcE != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DcE);
      }
      i = i + f.a.a.b.b.a.bA(4, this.DPY) + f.a.a.b.b.a.bA(5, this.DPZ);
      paramInt = i;
      if (this.CRC != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CRC);
      }
      i = paramInt;
      if (this.dub != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.dub);
      }
      AppMethodBeat.o(91555);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91555);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bsy localbsy = (bsy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91555);
          return -1;
        case 1: 
          localbsy.title = locala.KhF.readString();
          AppMethodBeat.o(91555);
          return 0;
        case 2: 
          localbsy.desc = locala.KhF.readString();
          AppMethodBeat.o(91555);
          return 0;
        case 3: 
          localbsy.DcE = locala.KhF.readString();
          AppMethodBeat.o(91555);
          return 0;
        case 4: 
          localbsy.DPY = locala.KhF.xS();
          AppMethodBeat.o(91555);
          return 0;
        case 5: 
          localbsy.DPZ = locala.KhF.xS();
          AppMethodBeat.o(91555);
          return 0;
        case 6: 
          localbsy.CRC = locala.KhF.readString();
          AppMethodBeat.o(91555);
          return 0;
        }
        localbsy.dub = locala.KhF.readString();
        AppMethodBeat.o(91555);
        return 0;
      }
      AppMethodBeat.o(91555);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsy
 * JD-Core Version:    0.7.0.1
 */