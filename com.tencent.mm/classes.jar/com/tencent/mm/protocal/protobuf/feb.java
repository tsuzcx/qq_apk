package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class feb
  extends com.tencent.mm.bx.a
{
  public int Height;
  public String IGG;
  public String Md5;
  public int Width;
  public gol abDF;
  public int vhE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125784);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Md5 != null) {
        paramVarArgs.g(1, this.Md5);
      }
      if (this.abDF != null)
      {
        paramVarArgs.qD(2, this.abDF.computeSize());
        this.abDF.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.Width);
      paramVarArgs.bS(4, this.Height);
      paramVarArgs.bS(5, this.vhE);
      if (this.IGG != null) {
        paramVarArgs.g(6, this.IGG);
      }
      AppMethodBeat.o(125784);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label536;
      }
    }
    label536:
    for (paramInt = i.a.a.b.b.a.h(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abDF != null) {
        i = paramInt + i.a.a.a.qC(2, this.abDF.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(3, this.Width) + i.a.a.b.b.a.cJ(4, this.Height) + i.a.a.b.b.a.cJ(5, this.vhE);
      paramInt = i;
      if (this.IGG != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.IGG);
      }
      AppMethodBeat.o(125784);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125784);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        feb localfeb = (feb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125784);
          return -1;
        case 1: 
          localfeb.Md5 = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125784);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            gol localgol = new gol();
            if ((localObject != null) && (localObject.length > 0)) {
              localgol.dg((byte[])localObject);
            }
            localfeb.abDF = localgol;
            paramInt += 1;
          }
          AppMethodBeat.o(125784);
          return 0;
        case 3: 
          localfeb.Width = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125784);
          return 0;
        case 4: 
          localfeb.Height = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125784);
          return 0;
        case 5: 
          localfeb.vhE = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125784);
          return 0;
        }
        localfeb.IGG = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(125784);
        return 0;
      }
      AppMethodBeat.o(125784);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.feb
 * JD-Core Version:    0.7.0.1
 */