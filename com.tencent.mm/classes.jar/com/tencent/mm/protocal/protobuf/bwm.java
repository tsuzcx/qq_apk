package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bwm
  extends com.tencent.mm.bx.a
{
  public long ZVF;
  public String aafw;
  public LinkedList<String> aafx;
  public LinkedList<bwb> aafy;
  public LinkedList<String> aafz;
  public int style;
  
  public bwm()
  {
    AppMethodBeat.i(258673);
    this.aafx = new LinkedList();
    this.aafy = new LinkedList();
    this.aafz = new LinkedList();
    AppMethodBeat.o(258673);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258676);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.ZVF);
      paramVarArgs.bS(2, this.style);
      if (this.aafw != null) {
        paramVarArgs.g(3, this.aafw);
      }
      paramVarArgs.e(4, 1, this.aafx);
      paramVarArgs.e(5, 8, this.aafy);
      paramVarArgs.e(6, 1, this.aafz);
      AppMethodBeat.o(258676);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.ZVF) + 0 + i.a.a.b.b.a.cJ(2, this.style);
      paramInt = i;
      if (this.aafw != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.aafw);
      }
      i = i.a.a.a.c(4, 1, this.aafx);
      int j = i.a.a.a.c(5, 8, this.aafy);
      int k = i.a.a.a.c(6, 1, this.aafz);
      AppMethodBeat.o(258676);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aafx.clear();
      this.aafy.clear();
      this.aafz.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258676);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bwm localbwm = (bwm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258676);
        return -1;
      case 1: 
        localbwm.ZVF = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(258676);
        return 0;
      case 2: 
        localbwm.style = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258676);
        return 0;
      case 3: 
        localbwm.aafw = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258676);
        return 0;
      case 4: 
        localbwm.aafx.add(((i.a.a.a.a)localObject).ajGk.readString());
        AppMethodBeat.o(258676);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bwb localbwb = new bwb();
          if ((localObject != null) && (localObject.length > 0)) {
            localbwb.parseFrom((byte[])localObject);
          }
          localbwm.aafy.add(localbwb);
          paramInt += 1;
        }
        AppMethodBeat.o(258676);
        return 0;
      }
      localbwm.aafz.add(((i.a.a.a.a)localObject).ajGk.readString());
      AppMethodBeat.o(258676);
      return 0;
    }
    AppMethodBeat.o(258676);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwm
 * JD-Core Version:    0.7.0.1
 */