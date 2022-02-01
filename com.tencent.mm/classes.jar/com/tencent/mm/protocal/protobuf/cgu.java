package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cgu
  extends com.tencent.mm.bx.a
{
  public LinkedList<cgu> DnG;
  public String Hak;
  public LinkedList<cgt> Hal;
  public int Ham;
  public int Han;
  public int paX;
  public String type;
  public String wDT;
  
  public cgu()
  {
    AppMethodBeat.i(117537);
    this.Hal = new LinkedList();
    this.DnG = new LinkedList();
    AppMethodBeat.o(117537);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117538);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hak != null) {
        paramVarArgs.d(1, this.Hak);
      }
      if (this.wDT != null) {
        paramVarArgs.d(2, this.wDT);
      }
      paramVarArgs.e(3, 8, this.Hal);
      paramVarArgs.aS(4, this.paX);
      if (this.type != null) {
        paramVarArgs.d(5, this.type);
      }
      paramVarArgs.e(6, 8, this.DnG);
      paramVarArgs.aS(7, this.Ham);
      paramVarArgs.aS(8, this.Han);
      AppMethodBeat.o(117538);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hak == null) {
        break label758;
      }
    }
    label758:
    for (paramInt = f.a.a.b.b.a.e(1, this.Hak) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wDT != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.wDT);
      }
      i = i + f.a.a.a.c(3, 8, this.Hal) + f.a.a.b.b.a.bz(4, this.paX);
      paramInt = i;
      if (this.type != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.type);
      }
      i = f.a.a.a.c(6, 8, this.DnG);
      int j = f.a.a.b.b.a.bz(7, this.Ham);
      int k = f.a.a.b.b.a.bz(8, this.Han);
      AppMethodBeat.o(117538);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hal.clear();
        this.DnG.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117538);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cgu localcgu = (cgu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117538);
          return -1;
        case 1: 
          localcgu.Hak = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117538);
          return 0;
        case 2: 
          localcgu.wDT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117538);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcgu.Hal.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117538);
          return 0;
        case 4: 
          localcgu.paX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117538);
          return 0;
        case 5: 
          localcgu.type = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117538);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcgu.DnG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117538);
          return 0;
        case 7: 
          localcgu.Ham = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117538);
          return 0;
        }
        localcgu.Han = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117538);
        return 0;
      }
      AppMethodBeat.o(117538);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgu
 * JD-Core Version:    0.7.0.1
 */