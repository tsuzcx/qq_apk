package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class avo
  extends com.tencent.mm.bv.a
{
  public String Md5;
  public String Name;
  public String Type;
  public String Url;
  public int jKn;
  public String wDo;
  public String wDs;
  public String xkZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28525);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Type != null) {
        paramVarArgs.e(1, this.Type);
      }
      if (this.Name != null) {
        paramVarArgs.e(2, this.Name);
      }
      paramVarArgs.aO(3, this.jKn);
      if (this.Md5 != null) {
        paramVarArgs.e(4, this.Md5);
      }
      if (this.wDs != null) {
        paramVarArgs.e(5, this.wDs);
      }
      if (this.wDo != null) {
        paramVarArgs.e(6, this.wDo);
      }
      if (this.Url != null) {
        paramVarArgs.e(7, this.Url);
      }
      if (this.xkZ != null) {
        paramVarArgs.e(8, this.xkZ);
      }
      AppMethodBeat.o(28525);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Type == null) {
        break label640;
      }
    }
    label640:
    for (paramInt = e.a.a.b.b.a.f(1, this.Type) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Name != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.Name);
      }
      i += e.a.a.b.b.a.bl(3, this.jKn);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.Md5);
      }
      i = paramInt;
      if (this.wDs != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wDs);
      }
      paramInt = i;
      if (this.wDo != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wDo);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.Url);
      }
      paramInt = i;
      if (this.xkZ != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xkZ);
      }
      AppMethodBeat.o(28525);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28525);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        avo localavo = (avo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28525);
          return -1;
        case 1: 
          localavo.Type = locala.CLY.readString();
          AppMethodBeat.o(28525);
          return 0;
        case 2: 
          localavo.Name = locala.CLY.readString();
          AppMethodBeat.o(28525);
          return 0;
        case 3: 
          localavo.jKn = locala.CLY.sl();
          AppMethodBeat.o(28525);
          return 0;
        case 4: 
          localavo.Md5 = locala.CLY.readString();
          AppMethodBeat.o(28525);
          return 0;
        case 5: 
          localavo.wDs = locala.CLY.readString();
          AppMethodBeat.o(28525);
          return 0;
        case 6: 
          localavo.wDo = locala.CLY.readString();
          AppMethodBeat.o(28525);
          return 0;
        case 7: 
          localavo.Url = locala.CLY.readString();
          AppMethodBeat.o(28525);
          return 0;
        }
        localavo.xkZ = locala.CLY.readString();
        AppMethodBeat.o(28525);
        return 0;
      }
      AppMethodBeat.o(28525);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avo
 * JD-Core Version:    0.7.0.1
 */