package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpn
  extends com.tencent.mm.bx.a
{
  public String FBS;
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
      if (this.FBS != null) {
        paramVarArgs.d(2, this.FBS);
      }
      paramVarArgs.z(3, this.width);
      paramVarArgs.z(4, this.height);
      AppMethodBeat.o(91522);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label364;
      }
    }
    label364:
    for (paramInt = f.a.a.b.b.a.e(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FBS != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FBS);
      }
      paramInt = f.a.a.b.b.a.alU(3);
      int j = f.a.a.b.b.a.alU(4);
      AppMethodBeat.o(91522);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91522);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bpn localbpn = (bpn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91522);
          return -1;
        case 1: 
          localbpn.url = locala.NPN.readString();
          AppMethodBeat.o(91522);
          return 0;
        case 2: 
          localbpn.FBS = locala.NPN.readString();
          AppMethodBeat.o(91522);
          return 0;
        case 3: 
          localbpn.width = Float.intBitsToFloat(locala.NPN.grz());
          AppMethodBeat.o(91522);
          return 0;
        }
        localbpn.height = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(91522);
        return 0;
      }
      AppMethodBeat.o(91522);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpn
 * JD-Core Version:    0.7.0.1
 */