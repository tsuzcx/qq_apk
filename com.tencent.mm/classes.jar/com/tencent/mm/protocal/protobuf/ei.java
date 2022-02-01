package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ei
  extends com.tencent.mm.bx.a
{
  public String CyA;
  public String CyB;
  public String Cyz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125710);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Cyz != null) {
        paramVarArgs.d(1, this.Cyz);
      }
      if (this.CyA != null) {
        paramVarArgs.d(2, this.CyA);
      }
      if (this.CyB != null) {
        paramVarArgs.d(3, this.CyB);
      }
      AppMethodBeat.o(125710);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Cyz == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.Cyz) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CyA != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CyA);
      }
      i = paramInt;
      if (this.CyB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CyB);
      }
      AppMethodBeat.o(125710);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(125710);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ei localei = (ei)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125710);
          return -1;
        case 1: 
          localei.Cyz = locala.KhF.readString();
          AppMethodBeat.o(125710);
          return 0;
        case 2: 
          localei.CyA = locala.KhF.readString();
          AppMethodBeat.o(125710);
          return 0;
        }
        localei.CyB = locala.KhF.readString();
        AppMethodBeat.o(125710);
        return 0;
      }
      AppMethodBeat.o(125710);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ei
 * JD-Core Version:    0.7.0.1
 */