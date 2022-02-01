package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class bzq
  extends com.tencent.mm.bw.a
{
  public String HnB;
  public String HnC;
  public String HnD;
  public int HnE;
  public String dyI;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91538);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dyI == null)
      {
        paramVarArgs = new b("Not all required fields were included: wording");
        AppMethodBeat.o(91538);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.type);
      if (this.dyI != null) {
        paramVarArgs.d(2, this.dyI);
      }
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      if (this.HnB != null) {
        paramVarArgs.d(4, this.HnB);
      }
      if (this.HnC != null) {
        paramVarArgs.d(5, this.HnC);
      }
      if (this.HnD != null) {
        paramVarArgs.d(6, this.HnD);
      }
      paramVarArgs.aS(7, this.HnE);
      AppMethodBeat.o(91538);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.dyI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dyI);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.url);
      }
      paramInt = i;
      if (this.HnB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HnB);
      }
      i = paramInt;
      if (this.HnC != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HnC);
      }
      paramInt = i;
      if (this.HnD != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HnD);
      }
      i = f.a.a.b.b.a.bz(7, this.HnE);
      AppMethodBeat.o(91538);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.dyI == null)
      {
        paramVarArgs = new b("Not all required fields were included: wording");
        AppMethodBeat.o(91538);
        throw paramVarArgs;
      }
      AppMethodBeat.o(91538);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bzq localbzq = (bzq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91538);
        return -1;
      case 1: 
        localbzq.type = locala.OmT.zc();
        AppMethodBeat.o(91538);
        return 0;
      case 2: 
        localbzq.dyI = locala.OmT.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 3: 
        localbzq.url = locala.OmT.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 4: 
        localbzq.HnB = locala.OmT.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 5: 
        localbzq.HnC = locala.OmT.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 6: 
        localbzq.HnD = locala.OmT.readString();
        AppMethodBeat.o(91538);
        return 0;
      }
      localbzq.HnE = locala.OmT.zc();
      AppMethodBeat.o(91538);
      return 0;
    }
    AppMethodBeat.o(91538);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzq
 * JD-Core Version:    0.7.0.1
 */