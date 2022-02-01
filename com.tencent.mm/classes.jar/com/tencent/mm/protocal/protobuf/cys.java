package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cys
  extends com.tencent.mm.bx.a
{
  public String FVo;
  public String FVp;
  public cwt GKC;
  public int GNU;
  public String GNV;
  public String GNW;
  public String GNX;
  public int GNY;
  public acf GOb;
  public cwt GbY;
  public int jdc;
  public String jdd;
  public String jde;
  public String jdf;
  public int jdg;
  public String jdh;
  public String jdl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6431);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GbY == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(6431);
        throw paramVarArgs;
      }
      if (this.GKC == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(6431);
        throw paramVarArgs;
      }
      if (this.GbY != null)
      {
        paramVarArgs.lC(1, this.GbY.computeSize());
        this.GbY.writeFields(paramVarArgs);
      }
      if (this.GKC != null)
      {
        paramVarArgs.lC(2, this.GKC.computeSize());
        this.GKC.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.jdc);
      if (this.jdd != null) {
        paramVarArgs.d(4, this.jdd);
      }
      if (this.jde != null) {
        paramVarArgs.d(5, this.jde);
      }
      if (this.jdf != null) {
        paramVarArgs.d(6, this.jdf);
      }
      paramVarArgs.aS(7, this.jdg);
      paramVarArgs.aS(8, this.GNU);
      if (this.GNV != null) {
        paramVarArgs.d(9, this.GNV);
      }
      if (this.GNW != null) {
        paramVarArgs.d(10, this.GNW);
      }
      if (this.jdh != null) {
        paramVarArgs.d(11, this.jdh);
      }
      if (this.GNX != null) {
        paramVarArgs.d(12, this.GNX);
      }
      paramVarArgs.aS(13, this.GNY);
      if (this.jdl != null) {
        paramVarArgs.d(14, this.jdl);
      }
      if (this.GOb != null)
      {
        paramVarArgs.lC(15, this.GOb.computeSize());
        this.GOb.writeFields(paramVarArgs);
      }
      if (this.FVo != null) {
        paramVarArgs.d(16, this.FVo);
      }
      if (this.FVp != null) {
        paramVarArgs.d(17, this.FVp);
      }
      AppMethodBeat.o(6431);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GbY == null) {
        break label1541;
      }
    }
    label1541:
    for (paramInt = f.a.a.a.lB(1, this.GbY.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GKC != null) {
        i = paramInt + f.a.a.a.lB(2, this.GKC.computeSize());
      }
      i += f.a.a.b.b.a.bz(3, this.jdc);
      paramInt = i;
      if (this.jdd != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.jdd);
      }
      i = paramInt;
      if (this.jde != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.jde);
      }
      paramInt = i;
      if (this.jdf != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.jdf);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.jdg) + f.a.a.b.b.a.bz(8, this.GNU);
      paramInt = i;
      if (this.GNV != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GNV);
      }
      i = paramInt;
      if (this.GNW != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.GNW);
      }
      paramInt = i;
      if (this.jdh != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.jdh);
      }
      i = paramInt;
      if (this.GNX != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.GNX);
      }
      i += f.a.a.b.b.a.bz(13, this.GNY);
      paramInt = i;
      if (this.jdl != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.jdl);
      }
      i = paramInt;
      if (this.GOb != null) {
        i = paramInt + f.a.a.a.lB(15, this.GOb.computeSize());
      }
      paramInt = i;
      if (this.FVo != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.FVo);
      }
      i = paramInt;
      if (this.FVp != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.FVp);
      }
      AppMethodBeat.o(6431);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GbY == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(6431);
          throw paramVarArgs;
        }
        if (this.GKC == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(6431);
          throw paramVarArgs;
        }
        AppMethodBeat.o(6431);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cys localcys = (cys)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6431);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcys.GbY = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6431);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcys.GKC = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6431);
          return 0;
        case 3: 
          localcys.jdc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(6431);
          return 0;
        case 4: 
          localcys.jdd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 5: 
          localcys.jde = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 6: 
          localcys.jdf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 7: 
          localcys.jdg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(6431);
          return 0;
        case 8: 
          localcys.GNU = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(6431);
          return 0;
        case 9: 
          localcys.GNV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 10: 
          localcys.GNW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 11: 
          localcys.jdh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 12: 
          localcys.GNX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 13: 
          localcys.GNY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(6431);
          return 0;
        case 14: 
          localcys.jdl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(6431);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcys.GOb = ((acf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6431);
          return 0;
        case 16: 
          localcys.FVo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(6431);
          return 0;
        }
        localcys.FVp = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(6431);
        return 0;
      }
      AppMethodBeat.o(6431);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cys
 * JD-Core Version:    0.7.0.1
 */