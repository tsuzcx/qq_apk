package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bke
  extends com.tencent.mm.bx.a
{
  public int Dnx;
  public String fVv;
  public String fVw;
  public String fVx;
  public String fVy;
  public String fVz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116336);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fVv != null) {
        paramVarArgs.d(1, this.fVv);
      }
      if (this.fVw != null) {
        paramVarArgs.d(2, this.fVw);
      }
      if (this.fVx != null) {
        paramVarArgs.d(3, this.fVx);
      }
      if (this.fVy != null) {
        paramVarArgs.d(4, this.fVy);
      }
      if (this.fVz != null) {
        paramVarArgs.d(5, this.fVz);
      }
      paramVarArgs.aR(6, this.Dnx);
      AppMethodBeat.o(116336);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fVv == null) {
        break label502;
      }
    }
    label502:
    for (int i = f.a.a.b.b.a.e(1, this.fVv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fVw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.fVw);
      }
      i = paramInt;
      if (this.fVx != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.fVx);
      }
      paramInt = i;
      if (this.fVy != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.fVy);
      }
      i = paramInt;
      if (this.fVz != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.fVz);
      }
      paramInt = f.a.a.b.b.a.bA(6, this.Dnx);
      AppMethodBeat.o(116336);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(116336);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bke localbke = (bke)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116336);
          return -1;
        case 1: 
          localbke.fVv = locala.KhF.readString();
          AppMethodBeat.o(116336);
          return 0;
        case 2: 
          localbke.fVw = locala.KhF.readString();
          AppMethodBeat.o(116336);
          return 0;
        case 3: 
          localbke.fVx = locala.KhF.readString();
          AppMethodBeat.o(116336);
          return 0;
        case 4: 
          localbke.fVy = locala.KhF.readString();
          AppMethodBeat.o(116336);
          return 0;
        case 5: 
          localbke.fVz = locala.KhF.readString();
          AppMethodBeat.o(116336);
          return 0;
        }
        localbke.Dnx = locala.KhF.xS();
        AppMethodBeat.o(116336);
        return 0;
      }
      AppMethodBeat.o(116336);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bke
 * JD-Core Version:    0.7.0.1
 */