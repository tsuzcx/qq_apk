package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dij
  extends com.tencent.mm.bx.a
{
  public ly Hxf;
  public duh Hxg;
  public cgq Hxh;
  public long Hxi;
  public int Hxj;
  public long Hxk;
  public String objectNonceId;
  public long rIZ;
  public int rTD;
  public String rTn;
  public String sessionBuffer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169091);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.rIZ);
      if (this.Hxf != null)
      {
        paramVarArgs.lC(2, this.Hxf.computeSize());
        this.Hxf.writeFields(paramVarArgs);
      }
      if (this.Hxg != null)
      {
        paramVarArgs.lC(3, this.Hxg.computeSize());
        this.Hxg.writeFields(paramVarArgs);
      }
      if (this.Hxh != null)
      {
        paramVarArgs.lC(4, this.Hxh.computeSize());
        this.Hxh.writeFields(paramVarArgs);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.d(5, this.objectNonceId);
      }
      if (this.rTn != null) {
        paramVarArgs.d(6, this.rTn);
      }
      paramVarArgs.aY(7, this.Hxi);
      paramVarArgs.aS(8, this.Hxj);
      if (this.sessionBuffer != null) {
        paramVarArgs.d(9, this.sessionBuffer);
      }
      paramVarArgs.aY(10, this.Hxk);
      paramVarArgs.aS(11, this.rTD);
      AppMethodBeat.o(169091);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.rIZ) + 0;
      paramInt = i;
      if (this.Hxf != null) {
        paramInt = i + f.a.a.a.lB(2, this.Hxf.computeSize());
      }
      i = paramInt;
      if (this.Hxg != null) {
        i = paramInt + f.a.a.a.lB(3, this.Hxg.computeSize());
      }
      paramInt = i;
      if (this.Hxh != null) {
        paramInt = i + f.a.a.a.lB(4, this.Hxh.computeSize());
      }
      i = paramInt;
      if (this.objectNonceId != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.objectNonceId);
      }
      paramInt = i;
      if (this.rTn != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.rTn);
      }
      i = paramInt + f.a.a.b.b.a.p(7, this.Hxi) + f.a.a.b.b.a.bz(8, this.Hxj);
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.sessionBuffer);
      }
      i = f.a.a.b.b.a.p(10, this.Hxk);
      int j = f.a.a.b.b.a.bz(11, this.rTD);
      AppMethodBeat.o(169091);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(169091);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dij localdij = (dij)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169091);
        return -1;
      case 1: 
        localdij.rIZ = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(169091);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ly();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ly)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdij.Hxf = ((ly)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169091);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new duh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((duh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdij.Hxg = ((duh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169091);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cgq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cgq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdij.Hxh = ((cgq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169091);
        return 0;
      case 5: 
        localdij.objectNonceId = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(169091);
        return 0;
      case 6: 
        localdij.rTn = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(169091);
        return 0;
      case 7: 
        localdij.Hxi = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(169091);
        return 0;
      case 8: 
        localdij.Hxj = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(169091);
        return 0;
      case 9: 
        localdij.sessionBuffer = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(169091);
        return 0;
      case 10: 
        localdij.Hxk = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(169091);
        return 0;
      }
      localdij.rTD = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(169091);
      return 0;
    }
    AppMethodBeat.o(169091);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dij
 * JD-Core Version:    0.7.0.1
 */