package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class avs
  extends com.tencent.mm.bv.a
{
  public String Md5;
  public String Name;
  public String Type;
  public String Url;
  public int jKn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28529);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Type != null) {
        paramVarArgs.e(1, this.Type);
      }
      paramVarArgs.aO(2, this.jKn);
      if (this.Md5 != null) {
        paramVarArgs.e(3, this.Md5);
      }
      if (this.Url != null) {
        paramVarArgs.e(4, this.Url);
      }
      if (this.Name != null) {
        paramVarArgs.e(5, this.Name);
      }
      AppMethodBeat.o(28529);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Type == null) {
        break label449;
      }
    }
    label449:
    for (paramInt = e.a.a.b.b.a.f(1, this.Type) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.jKn);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.Md5);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.Url);
      }
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.Name);
      }
      AppMethodBeat.o(28529);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28529);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        avs localavs = (avs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28529);
          return -1;
        case 1: 
          localavs.Type = locala.CLY.readString();
          AppMethodBeat.o(28529);
          return 0;
        case 2: 
          localavs.jKn = locala.CLY.sl();
          AppMethodBeat.o(28529);
          return 0;
        case 3: 
          localavs.Md5 = locala.CLY.readString();
          AppMethodBeat.o(28529);
          return 0;
        case 4: 
          localavs.Url = locala.CLY.readString();
          AppMethodBeat.o(28529);
          return 0;
        }
        localavs.Name = locala.CLY.readString();
        AppMethodBeat.o(28529);
        return 0;
      }
      AppMethodBeat.o(28529);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avs
 * JD-Core Version:    0.7.0.1
 */