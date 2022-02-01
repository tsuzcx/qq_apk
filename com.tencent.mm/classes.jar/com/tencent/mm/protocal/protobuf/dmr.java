package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class dmr
  extends com.tencent.mm.bx.a
{
  public long aaRH;
  public dbi aaSU;
  public long aaSV;
  public long beV;
  public long id;
  public LinkedList<b> msn;
  
  public dmr()
  {
    AppMethodBeat.i(110903);
    this.msn = new LinkedList();
    AppMethodBeat.o(110903);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110904);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.id);
      paramVarArgs.e(2, 6, this.msn);
      if (this.aaSU != null)
      {
        paramVarArgs.qD(3, this.aaSU.computeSize());
        this.aaSU.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(4, this.beV);
      paramVarArgs.bv(5, this.aaRH);
      paramVarArgs.bv(6, this.aaSV);
      AppMethodBeat.o(110904);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.id) + 0 + i.a.a.a.c(2, 6, this.msn);
      paramInt = i;
      if (this.aaSU != null) {
        paramInt = i + i.a.a.a.qC(3, this.aaSU.computeSize());
      }
      i = i.a.a.b.b.a.q(4, this.beV);
      int j = i.a.a.b.b.a.q(5, this.aaRH);
      int k = i.a.a.b.b.a.q(6, this.aaSV);
      AppMethodBeat.o(110904);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.msn.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(110904);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      dmr localdmr = (dmr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110904);
        return -1;
      case 1: 
        localdmr.id = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(110904);
        return 0;
      case 2: 
        localdmr.msn.add(((i.a.a.a.a)localObject).ajGk.kFX());
        AppMethodBeat.o(110904);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dbi localdbi = new dbi();
          if ((localObject != null) && (localObject.length > 0)) {
            localdbi.parseFrom((byte[])localObject);
          }
          localdmr.aaSU = localdbi;
          paramInt += 1;
        }
        AppMethodBeat.o(110904);
        return 0;
      case 4: 
        localdmr.beV = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(110904);
        return 0;
      case 5: 
        localdmr.aaRH = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(110904);
        return 0;
      }
      localdmr.aaSV = ((i.a.a.a.a)localObject).ajGk.aaw();
      AppMethodBeat.o(110904);
      return 0;
    }
    AppMethodBeat.o(110904);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmr
 * JD-Core Version:    0.7.0.1
 */