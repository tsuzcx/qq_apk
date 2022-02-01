package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fqk
  extends com.tencent.mm.bx.a
{
  public int Idd;
  public String TSI;
  public String aaZO;
  public gol aanh;
  public int abQm;
  public int abQq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152716);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abQm);
      if (this.TSI != null) {
        paramVarArgs.g(2, this.TSI);
      }
      paramVarArgs.bS(3, this.Idd);
      if (this.aaZO != null) {
        paramVarArgs.g(4, this.aaZO);
      }
      if (this.aanh != null)
      {
        paramVarArgs.qD(5, this.aanh.computeSize());
        this.aanh.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.abQq);
      AppMethodBeat.o(152716);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.abQm) + 0;
      paramInt = i;
      if (this.TSI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.TSI);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.Idd);
      paramInt = i;
      if (this.aaZO != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaZO);
      }
      i = paramInt;
      if (this.aanh != null) {
        i = paramInt + i.a.a.a.qC(5, this.aanh.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.abQq);
      AppMethodBeat.o(152716);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(152716);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fqk localfqk = (fqk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152716);
        return -1;
      case 1: 
        localfqk.abQm = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(152716);
        return 0;
      case 2: 
        localfqk.TSI = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152716);
        return 0;
      case 3: 
        localfqk.Idd = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(152716);
        return 0;
      case 4: 
        localfqk.aaZO = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152716);
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
          localfqk.aanh = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(152716);
        return 0;
      }
      localfqk.abQq = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(152716);
      return 0;
    }
    AppMethodBeat.o(152716);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fqk
 * JD-Core Version:    0.7.0.1
 */