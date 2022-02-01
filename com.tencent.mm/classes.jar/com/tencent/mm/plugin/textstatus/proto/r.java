package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class r
  extends com.tencent.mm.bx.a
{
  public int HTK;
  public long Tpo;
  public String Tpp;
  public LinkedList<s> Tpq;
  public long cTz;
  public String description;
  public int update_time;
  
  public r()
  {
    AppMethodBeat.i(290040);
    this.Tpq = new LinkedList();
    AppMethodBeat.o(290040);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(290050);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.Tpo);
      if (this.Tpp != null) {
        paramVarArgs.g(2, this.Tpp);
      }
      paramVarArgs.bv(3, this.cTz);
      paramVarArgs.bS(4, this.HTK);
      paramVarArgs.bS(5, this.update_time);
      if (this.description != null) {
        paramVarArgs.g(6, this.description);
      }
      paramVarArgs.e(7, 8, this.Tpq);
      AppMethodBeat.o(290050);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.Tpo) + 0;
      paramInt = i;
      if (this.Tpp != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Tpp);
      }
      i = paramInt + i.a.a.b.b.a.q(3, this.cTz) + i.a.a.b.b.a.cJ(4, this.HTK) + i.a.a.b.b.a.cJ(5, this.update_time);
      paramInt = i;
      if (this.description != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.description);
      }
      i = i.a.a.a.c(7, 8, this.Tpq);
      AppMethodBeat.o(290050);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Tpq.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(290050);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      r localr = (r)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(290050);
        return -1;
      case 1: 
        localr.Tpo = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(290050);
        return 0;
      case 2: 
        localr.Tpp = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(290050);
        return 0;
      case 3: 
        localr.cTz = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(290050);
        return 0;
      case 4: 
        localr.HTK = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(290050);
        return 0;
      case 5: 
        localr.update_time = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(290050);
        return 0;
      case 6: 
        localr.description = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(290050);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        s locals = new s();
        if ((localObject != null) && (localObject.length > 0)) {
          locals.parseFrom((byte[])localObject);
        }
        localr.Tpq.add(locals);
        paramInt += 1;
      }
      AppMethodBeat.o(290050);
      return 0;
    }
    AppMethodBeat.o(290050);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.r
 * JD-Core Version:    0.7.0.1
 */