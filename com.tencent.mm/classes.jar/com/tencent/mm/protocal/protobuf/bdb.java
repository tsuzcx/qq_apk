package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bdb
  extends com.tencent.mm.bx.a
{
  public int ZNM;
  public String ZNN;
  public bkx ZNO;
  public bkz ZNP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259110);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZNM);
      if (this.ZNN != null) {
        paramVarArgs.g(2, this.ZNN);
      }
      if (this.ZNO != null)
      {
        paramVarArgs.qD(3, this.ZNO.computeSize());
        this.ZNO.writeFields(paramVarArgs);
      }
      if (this.ZNP != null)
      {
        paramVarArgs.qD(4, this.ZNP.computeSize());
        this.ZNP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259110);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.ZNM) + 0;
      paramInt = i;
      if (this.ZNN != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZNN);
      }
      i = paramInt;
      if (this.ZNO != null) {
        i = paramInt + i.a.a.a.qC(3, this.ZNO.computeSize());
      }
      paramInt = i;
      if (this.ZNP != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZNP.computeSize());
      }
      AppMethodBeat.o(259110);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259110);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      bdb localbdb = (bdb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259110);
        return -1;
      case 1: 
        localbdb.ZNM = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259110);
        return 0;
      case 2: 
        localbdb.ZNN = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259110);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bkx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bkx)localObject2).parseFrom((byte[])localObject1);
          }
          localbdb.ZNO = ((bkx)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259110);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new bkz();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((bkz)localObject2).parseFrom((byte[])localObject1);
        }
        localbdb.ZNP = ((bkz)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(259110);
      return 0;
    }
    AppMethodBeat.o(259110);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdb
 * JD-Core Version:    0.7.0.1
 */