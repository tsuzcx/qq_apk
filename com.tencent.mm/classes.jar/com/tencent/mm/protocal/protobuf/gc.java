package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class gc
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> CAN;
  public long CAO;
  public String dgo;
  public String dlX;
  public String hoj;
  
  public gc()
  {
    AppMethodBeat.i(138168);
    this.CAN = new LinkedList();
    AppMethodBeat.o(138168);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138169);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlX == null)
      {
        paramVarArgs = new b("Not all required fields were included: roomname");
        AppMethodBeat.o(138169);
        throw paramVarArgs;
      }
      if (this.dlX != null) {
        paramVarArgs.d(1, this.dlX);
      }
      if (this.dgo != null) {
        paramVarArgs.d(2, this.dgo);
      }
      if (this.hoj != null) {
        paramVarArgs.d(3, this.hoj);
      }
      paramVarArgs.e(4, 1, this.CAN);
      paramVarArgs.aG(5, this.CAO);
      AppMethodBeat.o(138169);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlX == null) {
        break label486;
      }
    }
    label486:
    for (int i = f.a.a.b.b.a.e(1, this.dlX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dgo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dgo);
      }
      i = paramInt;
      if (this.hoj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hoj);
      }
      paramInt = f.a.a.a.c(4, 1, this.CAN);
      int j = f.a.a.b.b.a.q(5, this.CAO);
      AppMethodBeat.o(138169);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CAN.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.dlX == null)
        {
          paramVarArgs = new b("Not all required fields were included: roomname");
          AppMethodBeat.o(138169);
          throw paramVarArgs;
        }
        AppMethodBeat.o(138169);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        gc localgc = (gc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138169);
          return -1;
        case 1: 
          localgc.dlX = locala.KhF.readString();
          AppMethodBeat.o(138169);
          return 0;
        case 2: 
          localgc.dgo = locala.KhF.readString();
          AppMethodBeat.o(138169);
          return 0;
        case 3: 
          localgc.hoj = locala.KhF.readString();
          AppMethodBeat.o(138169);
          return 0;
        case 4: 
          localgc.CAN.add(locala.KhF.readString());
          AppMethodBeat.o(138169);
          return 0;
        }
        localgc.CAO = locala.KhF.xT();
        AppMethodBeat.o(138169);
        return 0;
      }
      AppMethodBeat.o(138169);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gc
 * JD-Core Version:    0.7.0.1
 */