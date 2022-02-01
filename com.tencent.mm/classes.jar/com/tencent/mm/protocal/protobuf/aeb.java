package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aeb
  extends com.tencent.mm.bx.a
{
  public int Dep;
  public int count;
  public String dlB;
  public String lpA;
  public String lpv;
  public String lpw;
  public String lpx;
  public String lpy;
  public int lpz;
  public int position;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50085);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      paramVarArgs.aR(2, this.count);
      if (this.lpv != null) {
        paramVarArgs.d(3, this.lpv);
      }
      if (this.lpw != null) {
        paramVarArgs.d(4, this.lpw);
      }
      paramVarArgs.aR(5, this.Dep);
      if (this.dlB != null) {
        paramVarArgs.d(6, this.dlB);
      }
      if (this.lpx != null) {
        paramVarArgs.d(7, this.lpx);
      }
      if (this.lpy != null) {
        paramVarArgs.d(8, this.lpy);
      }
      paramVarArgs.aR(9, this.lpz);
      if (this.lpA != null) {
        paramVarArgs.d(10, this.lpA);
      }
      paramVarArgs.aR(11, this.position);
      AppMethodBeat.o(50085);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label762;
      }
    }
    label762:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.count);
      paramInt = i;
      if (this.lpv != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.lpv);
      }
      i = paramInt;
      if (this.lpw != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.lpw);
      }
      i += f.a.a.b.b.a.bA(5, this.Dep);
      paramInt = i;
      if (this.dlB != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dlB);
      }
      i = paramInt;
      if (this.lpx != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.lpx);
      }
      paramInt = i;
      if (this.lpy != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.lpy);
      }
      i = paramInt + f.a.a.b.b.a.bA(9, this.lpz);
      paramInt = i;
      if (this.lpA != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.lpA);
      }
      i = f.a.a.b.b.a.bA(11, this.position);
      AppMethodBeat.o(50085);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(50085);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aeb localaeb = (aeb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50085);
          return -1;
        case 1: 
          localaeb.username = locala.KhF.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 2: 
          localaeb.count = locala.KhF.xS();
          AppMethodBeat.o(50085);
          return 0;
        case 3: 
          localaeb.lpv = locala.KhF.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 4: 
          localaeb.lpw = locala.KhF.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 5: 
          localaeb.Dep = locala.KhF.xS();
          AppMethodBeat.o(50085);
          return 0;
        case 6: 
          localaeb.dlB = locala.KhF.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 7: 
          localaeb.lpx = locala.KhF.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 8: 
          localaeb.lpy = locala.KhF.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 9: 
          localaeb.lpz = locala.KhF.xS();
          AppMethodBeat.o(50085);
          return 0;
        case 10: 
          localaeb.lpA = locala.KhF.readString();
          AppMethodBeat.o(50085);
          return 0;
        }
        localaeb.position = locala.KhF.xS();
        AppMethodBeat.o(50085);
        return 0;
      }
      AppMethodBeat.o(50085);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aeb
 * JD-Core Version:    0.7.0.1
 */