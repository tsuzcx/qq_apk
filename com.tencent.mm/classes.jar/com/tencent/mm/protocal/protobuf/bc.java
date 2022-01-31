package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bc
  extends com.tencent.mm.bv.a
{
  public String cDz;
  public String cyA;
  public String title;
  public String uaL;
  public String ugl;
  public String urC;
  public int urD;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56698);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.e(1, this.url);
      }
      if (this.cyA != null) {
        paramVarArgs.e(2, this.cyA);
      }
      if (this.cDz != null) {
        paramVarArgs.e(3, this.cDz);
      }
      if (this.urC != null) {
        paramVarArgs.e(4, this.urC);
      }
      if (this.title != null) {
        paramVarArgs.e(5, this.title);
      }
      if (this.ugl != null) {
        paramVarArgs.e(6, this.ugl);
      }
      if (this.uaL != null) {
        paramVarArgs.e(7, this.uaL);
      }
      paramVarArgs.aO(8, this.urD);
      AppMethodBeat.o(56698);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label626;
      }
    }
    label626:
    for (int i = e.a.a.b.b.a.f(1, this.url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.cyA != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.cyA);
      }
      i = paramInt;
      if (this.cDz != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.cDz);
      }
      paramInt = i;
      if (this.urC != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.urC);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.title);
      }
      paramInt = i;
      if (this.ugl != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.ugl);
      }
      i = paramInt;
      if (this.uaL != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.uaL);
      }
      paramInt = e.a.a.b.b.a.bl(8, this.urD);
      AppMethodBeat.o(56698);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56698);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bc localbc = (bc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56698);
          return -1;
        case 1: 
          localbc.url = locala.CLY.readString();
          AppMethodBeat.o(56698);
          return 0;
        case 2: 
          localbc.cyA = locala.CLY.readString();
          AppMethodBeat.o(56698);
          return 0;
        case 3: 
          localbc.cDz = locala.CLY.readString();
          AppMethodBeat.o(56698);
          return 0;
        case 4: 
          localbc.urC = locala.CLY.readString();
          AppMethodBeat.o(56698);
          return 0;
        case 5: 
          localbc.title = locala.CLY.readString();
          AppMethodBeat.o(56698);
          return 0;
        case 6: 
          localbc.ugl = locala.CLY.readString();
          AppMethodBeat.o(56698);
          return 0;
        case 7: 
          localbc.uaL = locala.CLY.readString();
          AppMethodBeat.o(56698);
          return 0;
        }
        localbc.urD = locala.CLY.sl();
        AppMethodBeat.o(56698);
        return 0;
      }
      AppMethodBeat.o(56698);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bc
 * JD-Core Version:    0.7.0.1
 */