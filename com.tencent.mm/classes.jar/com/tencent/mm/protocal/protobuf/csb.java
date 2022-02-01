package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csb
  extends com.tencent.mm.bx.a
{
  public String HkA;
  public LinkedList<cwa> HkB;
  public String Hkx;
  public double Hky;
  public LinkedList<tx> Hkz;
  public long cbe;
  public String duW;
  public String nickname;
  public String username;
  public String wMR;
  
  public csb()
  {
    AppMethodBeat.i(50103);
    this.Hkz = new LinkedList();
    this.HkB = new LinkedList();
    AppMethodBeat.o(50103);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50104);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.duW != null) {
        paramVarArgs.d(1, this.duW);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.d(3, this.nickname);
      }
      if (this.wMR != null) {
        paramVarArgs.d(4, this.wMR);
      }
      paramVarArgs.aY(5, this.cbe);
      if (this.Hkx != null) {
        paramVarArgs.d(6, this.Hkx);
      }
      paramVarArgs.e(7, this.Hky);
      paramVarArgs.e(16, 8, this.Hkz);
      if (this.HkA != null) {
        paramVarArgs.d(17, this.HkA);
      }
      paramVarArgs.e(19, 8, this.HkB);
      AppMethodBeat.o(50104);
      return 0;
    }
    if (paramInt == 1) {
      if (this.duW == null) {
        break label929;
      }
    }
    label929:
    for (int i = f.a.a.b.b.a.e(1, this.duW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.username);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nickname);
      }
      paramInt = i;
      if (this.wMR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.wMR);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.cbe);
      paramInt = i;
      if (this.Hkx != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Hkx);
      }
      i = paramInt + f.a.a.b.b.a.alT(7) + f.a.a.a.c(16, 8, this.Hkz);
      paramInt = i;
      if (this.HkA != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.HkA);
      }
      i = f.a.a.a.c(19, 8, this.HkB);
      AppMethodBeat.o(50104);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hkz.clear();
        this.HkB.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(50104);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        csb localcsb = (csb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 18: 
        default: 
          AppMethodBeat.o(50104);
          return -1;
        case 1: 
          localcsb.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 2: 
          localcsb.username = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 3: 
          localcsb.nickname = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 4: 
          localcsb.wMR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 5: 
          localcsb.cbe = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(50104);
          return 0;
        case 6: 
          localcsb.Hkx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(50104);
          return 0;
        case 7: 
          localcsb.Hky = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
          AppMethodBeat.o(50104);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsb.Hkz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50104);
          return 0;
        case 17: 
          localcsb.HkA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(50104);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwa();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcsb.HkB.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(50104);
        return 0;
      }
      AppMethodBeat.o(50104);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csb
 * JD-Core Version:    0.7.0.1
 */