package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fqj
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public gol aanh;
  public int abQm;
  public String abQn;
  public String abQo;
  public String abQp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152715);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abQm);
      if (this.abQn != null) {
        paramVarArgs.g(2, this.abQn);
      }
      if (this.abQo != null) {
        paramVarArgs.g(3, this.abQo);
      }
      paramVarArgs.bS(4, this.IJG);
      if (this.aanh != null)
      {
        paramVarArgs.qD(5, this.aanh.computeSize());
        this.aanh.writeFields(paramVarArgs);
      }
      if (this.abQp != null) {
        paramVarArgs.g(6, this.abQp);
      }
      AppMethodBeat.o(152715);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.abQm) + 0;
      paramInt = i;
      if (this.abQn != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abQn);
      }
      i = paramInt;
      if (this.abQo != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abQo);
      }
      i += i.a.a.b.b.a.cJ(4, this.IJG);
      paramInt = i;
      if (this.aanh != null) {
        paramInt = i + i.a.a.a.qC(5, this.aanh.computeSize());
      }
      i = paramInt;
      if (this.abQp != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.abQp);
      }
      AppMethodBeat.o(152715);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(152715);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fqj localfqj = (fqj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152715);
        return -1;
      case 1: 
        localfqj.abQm = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(152715);
        return 0;
      case 2: 
        localfqj.abQn = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152715);
        return 0;
      case 3: 
        localfqj.abQo = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152715);
        return 0;
      case 4: 
        localfqj.IJG = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(152715);
        return 0;
      case 5: 
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
          localfqj.aanh = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(152715);
        return 0;
      }
      localfqj.abQp = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(152715);
      return 0;
    }
    AppMethodBeat.o(152715);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fqj
 * JD-Core Version:    0.7.0.1
 */