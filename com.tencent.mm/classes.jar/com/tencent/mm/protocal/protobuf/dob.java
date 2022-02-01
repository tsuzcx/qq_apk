package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dob
  extends com.tencent.mm.bx.a
{
  public int aacR;
  public String coverUrl;
  public float height;
  public String thumbUrl;
  public String url;
  public float width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258418);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.g(1, this.url);
      }
      if (this.thumbUrl != null) {
        paramVarArgs.g(2, this.thumbUrl);
      }
      paramVarArgs.l(3, this.width);
      paramVarArgs.l(4, this.height);
      if (this.coverUrl != null) {
        paramVarArgs.g(5, this.coverUrl);
      }
      paramVarArgs.bS(6, this.aacR);
      AppMethodBeat.o(258418);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label464;
      }
    }
    label464:
    for (paramInt = i.a.a.b.b.a.h(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.thumbUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.thumbUrl);
      }
      i = i + (i.a.a.b.b.a.ko(3) + 4) + (i.a.a.b.b.a.ko(4) + 4);
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.coverUrl);
      }
      i = i.a.a.b.b.a.cJ(6, this.aacR);
      AppMethodBeat.o(258418);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258418);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dob localdob = (dob)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258418);
          return -1;
        case 1: 
          localdob.url = locala.ajGk.readString();
          AppMethodBeat.o(258418);
          return 0;
        case 2: 
          localdob.thumbUrl = locala.ajGk.readString();
          AppMethodBeat.o(258418);
          return 0;
        case 3: 
          localdob.width = Float.intBitsToFloat(locala.ajGk.aax());
          AppMethodBeat.o(258418);
          return 0;
        case 4: 
          localdob.height = Float.intBitsToFloat(locala.ajGk.aax());
          AppMethodBeat.o(258418);
          return 0;
        case 5: 
          localdob.coverUrl = locala.ajGk.readString();
          AppMethodBeat.o(258418);
          return 0;
        }
        localdob.aacR = locala.ajGk.aar();
        AppMethodBeat.o(258418);
        return 0;
      }
      AppMethodBeat.o(258418);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dob
 * JD-Core Version:    0.7.0.1
 */