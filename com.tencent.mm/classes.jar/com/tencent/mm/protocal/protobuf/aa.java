package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aa
  extends com.tencent.mm.bw.a
{
  public String FIV;
  public String FIW;
  public String FIX;
  public String FIY;
  public LinkedList<String> FIZ;
  public String nIO;
  public String nJo;
  
  public aa()
  {
    AppMethodBeat.i(145665);
    this.FIZ = new LinkedList();
    AppMethodBeat.o(145665);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(145666);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nJo != null) {
        paramVarArgs.d(1, this.nJo);
      }
      if (this.nIO != null) {
        paramVarArgs.d(2, this.nIO);
      }
      if (this.FIV != null) {
        paramVarArgs.d(3, this.FIV);
      }
      if (this.FIW != null) {
        paramVarArgs.d(4, this.FIW);
      }
      if (this.FIX != null) {
        paramVarArgs.d(5, this.FIX);
      }
      if (this.FIY != null) {
        paramVarArgs.d(6, this.FIY);
      }
      paramVarArgs.e(7, 1, this.FIZ);
      AppMethodBeat.o(145666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nJo == null) {
        break label578;
      }
    }
    label578:
    for (int i = f.a.a.b.b.a.e(1, this.nJo) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nIO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nIO);
      }
      i = paramInt;
      if (this.FIV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FIV);
      }
      paramInt = i;
      if (this.FIW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FIW);
      }
      i = paramInt;
      if (this.FIX != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FIX);
      }
      paramInt = i;
      if (this.FIY != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FIY);
      }
      i = f.a.a.a.c(7, 1, this.FIZ);
      AppMethodBeat.o(145666);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FIZ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(145666);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aa localaa = (aa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(145666);
          return -1;
        case 1: 
          localaa.nJo = locala.OmT.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 2: 
          localaa.nIO = locala.OmT.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 3: 
          localaa.FIV = locala.OmT.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 4: 
          localaa.FIW = locala.OmT.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 5: 
          localaa.FIX = locala.OmT.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 6: 
          localaa.FIY = locala.OmT.readString();
          AppMethodBeat.o(145666);
          return 0;
        }
        localaa.FIZ.add(locala.OmT.readString());
        AppMethodBeat.o(145666);
        return 0;
      }
      AppMethodBeat.o(145666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aa
 * JD-Core Version:    0.7.0.1
 */