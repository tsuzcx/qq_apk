package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bhl
  extends com.tencent.mm.bx.a
{
  public String CDW;
  public float height;
  public String url;
  public float width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91522);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.d(1, this.url);
      }
      if (this.CDW != null) {
        paramVarArgs.d(2, this.CDW);
      }
      paramVarArgs.x(3, this.width);
      paramVarArgs.x(4, this.height);
      AppMethodBeat.o(91522);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label368;
      }
    }
    label368:
    for (paramInt = f.a.a.b.b.a.e(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CDW != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.CDW);
      }
      paramInt = f.a.a.b.b.a.fY(3);
      int j = f.a.a.b.b.a.fY(4);
      AppMethodBeat.o(91522);
      return i + (paramInt + 4) + (j + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91522);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bhl localbhl = (bhl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91522);
          return -1;
        case 1: 
          localbhl.url = locala.KhF.readString();
          AppMethodBeat.o(91522);
          return 0;
        case 2: 
          localbhl.CDW = locala.KhF.readString();
          AppMethodBeat.o(91522);
          return 0;
        case 3: 
          localbhl.width = Float.intBitsToFloat(locala.KhF.fHx());
          AppMethodBeat.o(91522);
          return 0;
        }
        localbhl.height = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(91522);
        return 0;
      }
      AppMethodBeat.o(91522);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhl
 * JD-Core Version:    0.7.0.1
 */