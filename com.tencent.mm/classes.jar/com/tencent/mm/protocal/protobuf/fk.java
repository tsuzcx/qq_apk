package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class fk
  extends com.tencent.mm.bv.a
{
  public String crs;
  public String fLx;
  public String gfK;
  public long wrA;
  public LinkedList<String> wrz;
  
  public fk()
  {
    AppMethodBeat.i(118265);
    this.wrz = new LinkedList();
    AppMethodBeat.o(118265);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118266);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.gfK == null)
      {
        paramVarArgs = new b("Not all required fields were included: roomname");
        AppMethodBeat.o(118266);
        throw paramVarArgs;
      }
      if (this.gfK != null) {
        paramVarArgs.e(1, this.gfK);
      }
      if (this.crs != null) {
        paramVarArgs.e(2, this.crs);
      }
      if (this.fLx != null) {
        paramVarArgs.e(3, this.fLx);
      }
      paramVarArgs.e(4, 1, this.wrz);
      paramVarArgs.am(5, this.wrA);
      AppMethodBeat.o(118266);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gfK == null) {
        break label486;
      }
    }
    label486:
    for (int i = e.a.a.b.b.a.f(1, this.gfK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.crs != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.crs);
      }
      i = paramInt;
      if (this.fLx != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.fLx);
      }
      paramInt = e.a.a.a.c(4, 1, this.wrz);
      int j = e.a.a.b.b.a.p(5, this.wrA);
      AppMethodBeat.o(118266);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wrz.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.gfK == null)
        {
          paramVarArgs = new b("Not all required fields were included: roomname");
          AppMethodBeat.o(118266);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118266);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        fk localfk = (fk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(118266);
          return -1;
        case 1: 
          localfk.gfK = locala.CLY.readString();
          AppMethodBeat.o(118266);
          return 0;
        case 2: 
          localfk.crs = locala.CLY.readString();
          AppMethodBeat.o(118266);
          return 0;
        case 3: 
          localfk.fLx = locala.CLY.readString();
          AppMethodBeat.o(118266);
          return 0;
        case 4: 
          localfk.wrz.add(locala.CLY.readString());
          AppMethodBeat.o(118266);
          return 0;
        }
        localfk.wrA = locala.CLY.sm();
        AppMethodBeat.o(118266);
        return 0;
      }
      AppMethodBeat.o(118266);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fk
 * JD-Core Version:    0.7.0.1
 */