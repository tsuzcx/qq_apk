package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bdo
  extends com.tencent.mm.bx.a
{
  public int ZOf;
  public dix ZOg;
  public bgh ZOh;
  public long ZOi;
  public String ZlX;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259074);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZlX != null) {
        paramVarArgs.g(1, this.ZlX);
      }
      paramVarArgs.bS(51, this.ZOf);
      if (this.ZOg != null)
      {
        paramVarArgs.qD(101, this.ZOg.computeSize());
        this.ZOg.writeFields(paramVarArgs);
      }
      if (this.ZOh != null)
      {
        paramVarArgs.qD(102, this.ZOh.computeSize());
        this.ZOh.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(103, this.ZOi);
      paramVarArgs.bv(104, this.seq);
      AppMethodBeat.o(259074);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZlX == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZlX) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(51, this.ZOf);
      paramInt = i;
      if (this.ZOg != null) {
        paramInt = i + i.a.a.a.qC(101, this.ZOg.computeSize());
      }
      i = paramInt;
      if (this.ZOh != null) {
        i = paramInt + i.a.a.a.qC(102, this.ZOh.computeSize());
      }
      paramInt = i.a.a.b.b.a.q(103, this.ZOi);
      int j = i.a.a.b.b.a.q(104, this.seq);
      AppMethodBeat.o(259074);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259074);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bdo localbdo = (bdo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259074);
          return -1;
        case 1: 
          localbdo.ZlX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259074);
          return 0;
        case 51: 
          localbdo.ZOf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259074);
          return 0;
        case 101: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dix();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dix)localObject2).parseFrom((byte[])localObject1);
            }
            localbdo.ZOg = ((dix)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259074);
          return 0;
        case 102: 
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
            localbdo.ZOh = ((bgh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259074);
          return 0;
        case 103: 
          localbdo.ZOi = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259074);
          return 0;
        }
        localbdo.seq = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(259074);
        return 0;
      }
      AppMethodBeat.o(259074);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdo
 * JD-Core Version:    0.7.0.1
 */