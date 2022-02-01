package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class beo
  extends com.tencent.mm.bx.a
{
  public LinkedList<bdu> ZOW;
  public bgh ZOh;
  public String ZlX;
  public int scene;
  public long seq;
  
  public beo()
  {
    AppMethodBeat.i(258732);
    this.ZOW = new LinkedList();
    AppMethodBeat.o(258732);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258734);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(101, this.scene);
      paramVarArgs.bv(102, this.seq);
      if (this.ZOh != null)
      {
        paramVarArgs.qD(103, this.ZOh.computeSize());
        this.ZOh.writeFields(paramVarArgs);
      }
      if (this.ZlX != null) {
        paramVarArgs.g(104, this.ZlX);
      }
      paramVarArgs.e(105, 8, this.ZOW);
      AppMethodBeat.o(258734);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(101, this.scene) + 0 + i.a.a.b.b.a.q(102, this.seq);
      paramInt = i;
      if (this.ZOh != null) {
        paramInt = i + i.a.a.a.qC(103, this.ZOh.computeSize());
      }
      i = paramInt;
      if (this.ZlX != null) {
        i = paramInt + i.a.a.b.b.a.h(104, this.ZlX);
      }
      paramInt = i.a.a.a.c(105, 8, this.ZOW);
      AppMethodBeat.o(258734);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZOW.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258734);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      beo localbeo = (beo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258734);
        return -1;
      case 101: 
        localbeo.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258734);
        return 0;
      case 102: 
        localbeo.seq = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(258734);
        return 0;
      case 103: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bgh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bgh)localObject2).parseFrom((byte[])localObject1);
          }
          localbeo.ZOh = ((bgh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258734);
        return 0;
      case 104: 
        localbeo.ZlX = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258734);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new bdu();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((bdu)localObject2).parseFrom((byte[])localObject1);
        }
        localbeo.ZOW.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(258734);
      return 0;
    }
    AppMethodBeat.o(258734);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.beo
 * JD-Core Version:    0.7.0.1
 */