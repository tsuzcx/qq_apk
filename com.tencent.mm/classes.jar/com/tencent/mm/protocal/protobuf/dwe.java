package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dwe
  extends com.tencent.mm.bx.a
{
  public int DQZ;
  public String EIq;
  public int EJV;
  public String EJW;
  public int EJX;
  public boolean EJY = false;
  public boolean EJZ = false;
  public String session_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117961);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EJV);
      paramVarArgs.aR(2, this.DQZ);
      if (this.session_id != null) {
        paramVarArgs.d(3, this.session_id);
      }
      if (this.EJW != null) {
        paramVarArgs.d(4, this.EJW);
      }
      if (this.EIq != null) {
        paramVarArgs.d(5, this.EIq);
      }
      paramVarArgs.aR(6, this.EJX);
      paramVarArgs.bg(7, this.EJY);
      paramVarArgs.bg(8, this.EJZ);
      AppMethodBeat.o(117961);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.EJV) + 0 + f.a.a.b.b.a.bA(2, this.DQZ);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.session_id);
      }
      i = paramInt;
      if (this.EJW != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.EJW);
      }
      paramInt = i;
      if (this.EIq != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EIq);
      }
      i = f.a.a.b.b.a.bA(6, this.EJX);
      int j = f.a.a.b.b.a.fY(7);
      int k = f.a.a.b.b.a.fY(8);
      AppMethodBeat.o(117961);
      return paramInt + i + (j + 1) + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(117961);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dwe localdwe = (dwe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117961);
        return -1;
      case 1: 
        localdwe.EJV = locala.KhF.xS();
        AppMethodBeat.o(117961);
        return 0;
      case 2: 
        localdwe.DQZ = locala.KhF.xS();
        AppMethodBeat.o(117961);
        return 0;
      case 3: 
        localdwe.session_id = locala.KhF.readString();
        AppMethodBeat.o(117961);
        return 0;
      case 4: 
        localdwe.EJW = locala.KhF.readString();
        AppMethodBeat.o(117961);
        return 0;
      case 5: 
        localdwe.EIq = locala.KhF.readString();
        AppMethodBeat.o(117961);
        return 0;
      case 6: 
        localdwe.EJX = locala.KhF.xS();
        AppMethodBeat.o(117961);
        return 0;
      case 7: 
        localdwe.EJY = locala.KhF.fHu();
        AppMethodBeat.o(117961);
        return 0;
      }
      localdwe.EJZ = locala.KhF.fHu();
      AppMethodBeat.o(117961);
      return 0;
    }
    AppMethodBeat.o(117961);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwe
 * JD-Core Version:    0.7.0.1
 */