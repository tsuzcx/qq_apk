package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class fio
  extends com.tencent.mm.bx.a
{
  public long Id;
  public String ZrX;
  public int abIQ;
  public fiz abJh;
  public LinkedList<Integer> abJu;
  
  public fio()
  {
    AppMethodBeat.i(118447);
    this.abJu = new LinkedList();
    AppMethodBeat.o(118447);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118448);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.Id);
      if (this.ZrX != null) {
        paramVarArgs.g(2, this.ZrX);
      }
      if (this.abJh != null)
      {
        paramVarArgs.qD(3, this.abJh.computeSize());
        this.abJh.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.abIQ);
      paramVarArgs.f(5, 2, this.abJu);
      AppMethodBeat.o(118448);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.Id) + 0;
      paramInt = i;
      if (this.ZrX != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZrX);
      }
      i = paramInt;
      if (this.abJh != null) {
        i = paramInt + i.a.a.a.qC(3, this.abJh.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.abIQ);
      int j = i.a.a.a.d(5, 2, this.abJu);
      AppMethodBeat.o(118448);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abJu.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(118448);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fio localfio = (fio)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118448);
        return -1;
      case 1: 
        localfio.Id = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(118448);
        return 0;
      case 2: 
        localfio.ZrX = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(118448);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fiz localfiz = new fiz();
          if ((localObject != null) && (localObject.length > 0)) {
            localfiz.parseFrom((byte[])localObject);
          }
          localfio.abJh = localfiz;
          paramInt += 1;
        }
        AppMethodBeat.o(118448);
        return 0;
      case 4: 
        localfio.abIQ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(118448);
        return 0;
      }
      localfio.abJu = new i.a.a.a.a(((i.a.a.a.a)localObject).ajGk.kFX().Op, unknownTagHandler).ajGk.kFV();
      AppMethodBeat.o(118448);
      return 0;
    }
    AppMethodBeat.o(118448);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fio
 * JD-Core Version:    0.7.0.1
 */